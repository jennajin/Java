/**********************************************************************************
 * This java file is Register servlet that works as a controller in this MVC 
 * framework. the responsibility of this servlet is collecting the user
 * entry and create a user object with that data. Then, send the data to the model
 * for inserting data in database. if inserting is successful, it will the successful
 * message; Otherwise, this page will redirect to the registration page.  
 *********************************************************************************/

package ca.simpleweb.mvc.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.simpleweb.mvc.objects.*;
import ca.simpleweb.mvc.helpers.Contact;
import ca.simpleweb.mvc.helpers.HandlingCookies;
import ca.simpleweb.mvc.helpers.ValidationChecker;
import ca.simpleweb.mvc.models.Register;

@WebServlet("/Registers")
public class Registers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int COOKIE_AGE = 60 * 60 * 24; // Cookie age: 24 hours
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Check whether submission button is pressed
		String buttonPressed = (request.getParameter("btn") != null) ? request.getParameter("btn") : null;
		if(buttonPressed==null) {
			response.sendRedirect("registration.jsp");
			return;
		}

		//Assign input parameters into local variables
		String firstName = (request.getParameter("inputFirstName") != null) ? request.getParameter("inputFirstName") : null;
		String lastName = (request.getParameter("inputLastName") != null) ? request.getParameter("inputLastName") : null;
		String address = (request.getParameter("inputAddress") != null) ? request.getParameter("inputAddress") : null;
		String email = (request.getParameter("inputEmail") != null) ? request.getParameter("inputEmail") : null;
		String password = (request.getParameter("inputPassword") != null) ? request.getParameter("inputPassword") : null;
		String cpassword = (request.getParameter("inputCPassword") != null) ? request.getParameter("inputCPassword") : null;
		String agreement = (request.getParameter("agreeCheck") != null) ? request.getParameter("agreeCheck") : null;

		// Created cookies
		Cookie ck_firstname = new Cookie("firstname", firstName);
		Cookie ck_lastname = new Cookie("lastname", lastName);
		Cookie ck_address = new Cookie("address", address);
		Cookie ck_email = new Cookie("email", email);
		Cookie ck_password = new Cookie("password", password);
		Cookie ck_cpassword = new Cookie("cpassword", cpassword);
		Cookie ck_agreement = new Cookie("agreement", agreement);

		// Set expired date after 24 hours
		ck_firstname.setMaxAge(COOKIE_AGE);
		ck_lastname.setMaxAge(COOKIE_AGE);
		ck_address.setMaxAge(COOKIE_AGE);
		ck_email.setMaxAge(COOKIE_AGE);
		ck_password.setMaxAge(COOKIE_AGE);
		ck_cpassword.setMaxAge(COOKIE_AGE);
		ck_agreement.setMaxAge(COOKIE_AGE);

		// Add cookies in the response header
		response.addCookie(ck_firstname);
		response.addCookie(ck_lastname);
		response.addCookie(ck_address);
		response.addCookie(ck_email);
		response.addCookie(ck_password);
		response.addCookie(ck_cpassword);
		response.addCookie(ck_agreement);

		// Reset messages
		request.getSession().setAttribute("message1", null);
		request.getSession().setAttribute("message2", null);
		request.getSession().setAttribute("message3", null);
		request.getSession().setAttribute("message4", null);
		request.getSession().setAttribute("message5", null);
		request.getSession().setAttribute("message6", null);
		request.getSession().setAttribute("message7", null);
		request.getSession().setAttribute("RegisterErrMsg", null);

		// Validation check
		ValidationChecker validation = new ValidationChecker();
		boolean isValid = true;

		if(!validation.isNull(firstName) && !validation.isNull(lastName) && !validation.isNull(address) && !validation.isNull(email) && !validation.isNull(password) && !validation.isNull(cpassword)) {
			// If user input is not empty
			if (!password.equals(cpassword)) {
				// If password and confirm password are not matched
				request.getSession().setAttribute("message2", "* Password does not match the confirm password.<br />");
				isValid = false;
			}
			if (!validation.isValidEmail(email)) {
				// If email address is invalid
				request.getSession().setAttribute("message3", "* Please enter valid email address.<br />");
				isValid = false;
			}
			if(!validation.isValidName(firstName) || !validation.isValidName(lastName)) {
				// If name is invalid
				request.getSession().setAttribute("message4", "* Please enter valid name.<br />");
				isValid = false;
			}
			if(!validation.isValidPassword(password)) {
				// If password is invalid
				request.getSession().setAttribute("message5", "* Password must be 6-12 characters in length, contain at least 1 uppercase and 1 special character. <br />");
				isValid = false;
			}
			if(agreement == null) {
				// If user didn't check the box to agree
				request.getSession().setAttribute("message6", "* Please check the agreement. <br />");
				isValid = false;
			}
			if(validation.UserExists(email)) {
				// If email address already exists
				request.getSession().setAttribute("message7", "* Your email address is already registered. <br />");
				isValid = false;
			}

		} else {
			// If user input is empty
			request.getSession().setAttribute("message1", "* All fields are required. <br />");
			isValid = false;
		}

		// If input fields are not valid, display an error message
		if(!isValid) {
			response.sendRedirect("registration.jsp");		
			return;
		}


		// Create user object
		UserObject userObj = new UserObject(firstName, lastName, address, email, password);

		// Create register model (for inserting)
		Register register = new Register();

		//register.registerUser(userObj) will return a string
		// SUCCESS if inserting is successful
		// FAILED if inserting isn't successful
		String userRegistered = register.registerUser(userObj);

		if (userRegistered.equals("SUCCESS")){

			// remove cookies
			HandlingCookies cookies = new HandlingCookies();
			cookies.removeCookies(request, response);

			// send email
			String emailSubject = "Welcome to EAGLE EYED!";
			String emailBody = "<h1>Welcome " + firstName + ", " + lastName + "!</h1>"
					+ "<br>Thanks for choosing EAGLE EYED."
					+ "<p><b>&#8226 Username: "+ email + "</b></p>" 
					+ "<br>You can log in to your new account with this username at "
					+ "<a href='http://localhost:8080/COMP3095_EAGLE_EYED'><font color='blue'>EAGLE_EYED</font></a>";
			Contact contact = new Contact();
			contact.sendEmail(email, emailSubject, emailBody);
 
			//-------------------------------------------------------------------------
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html>\n" + 
					"<head>\n" + 
					"	<meta charset=\"UTF-8\">\n" + 
					"	<title>Insert title here</title>\n" + 
					"\n" + 
					"	<!-- Bootstrap core CSS -->\n" + 
					"	<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n" + 
					"	\n" + 
					"	<!-- Custom styles for this template -->\n" + 
					"	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\"/> \n" + 
					"</head>\n" + 
					"<body>\n" + 
					"	<div class=\"container\">\n" + 
					"			<div class=\"mt-5 text-left mb-5\">\n" + 
					"		    	<div class=\"panel\">\n" + 
					"			   		<h4>successfully registered user</h4>\n" + 
					"		   		</div>\n" + 
					"		   		<form>\n" + 
					"			        <div class=\"form-group\">\n" + 
					"				    <div class=\"form-check\">\n" + 
					"				      <input class=\"form-check-input\" type=\"checkbox\" checked=\"checked\">\n" + 
					"				      <label class=\"form-check-label\" for=\"agreeCheck\">\n" + 
					"				       an email has been sent to " + email + ". Please check your email to verify and confirm\n" + 
					"				        <br/>Go to <a href=\"login.jsp\">  login page </a>\n" + 
					"				      </label>\n" + 
					"				    </div>\n" + 
					"				  </div>\n" + 
					"			    </form>\n" + 
					"			    <footer class=\"blockquote-footer mt-5 mb-1\">Copyright&copy; 2018 - EagleEyed </footer>\n" + 
					"	    	</div>\n" + 
					"	    	\n" + 
					"	</div>\n" + 
					"</body>\n" + 
					"</html>");
			//-------------------------------------------------------------------------
 
		}else {
			request.getSession().setAttribute("RegisterErrMsg", userRegistered);
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
	}
}


package ca.simpleweb.mvc.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.simpleweb.mvc.helpers.HandlingCookies;
import ca.simpleweb.mvc.helpers.ValidationChecker;
import ca.simpleweb.mvc.helpers.ValidationRecaptcha;
import ca.simpleweb.mvc.models.UserChecker;
import ca.simpleweb.mvc.objects.UserObject;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int COOKIE_AGE = 60 * 60 * 24; // Cookie age: 24 hours

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();

		// Remove cookies when the user returns to login page
		String cancel = (request.getParameter("cancel") != null) ? request.getParameter("cancel") : null;
		String register = (request.getParameter("register") != null) ? request.getParameter("register") : null;
		if((cancel != null) || (register != null)) {
			HandlingCookies cookies = new HandlingCookies();
			cookies.removeCookies(request, response);
		}

		// Check whether login button is pressed
		String buttonPressed = (request.getParameter("btn") != null) ? request.getParameter("btn") : null;
		if(buttonPressed == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		// Reset messages
		request.getSession().setAttribute("message1", null);
		request.getSession().setAttribute("message2", null);
		request.getSession().setAttribute("message3", null);

		// Get request parameters
		String email = (request.getParameter("inputEmail") != null) ? request.getParameter("inputEmail") : null;
		String password = (request.getParameter("inputPassword") != null) ? request.getParameter("inputPassword") : null;
		String recaptcha = request.getParameter("g-recaptcha-response");

		// Created cookies
		Cookie ck_email = new Cookie("email", email);
		Cookie ck_password = new Cookie("password", password);

		// Set expired date after 24 hours
		ck_email.setMaxAge(COOKIE_AGE);
		ck_password.setMaxAge(COOKIE_AGE);

		// Add cookies in the response header
		response.addCookie(ck_email);
		response.addCookie(ck_password);

		// Check reCaptcha validation
		ValidationRecaptcha validRecaptcha = new ValidationRecaptcha();
		boolean verifyRecaptcha = validRecaptcha.isValidRecaptcha(recaptcha);

		ValidationChecker validation = new ValidationChecker();

		// Check whether text fields are null or not
		if(validation.isNull(email)|| validation.isNull(password)) {
			request.getSession().setAttribute("message1", "* All fields are required.");
			response.sendRedirect("login.jsp");
			return;
		}

		// check whether email and password are valid
		UserChecker check = new UserChecker();
		UserObject userObj = new UserObject();
		userObj = check.checkUser(email, password);

		if(userObj == null) {
			// Check email and password validation
			request.getSession().setAttribute("message2", "* Invalid username and/or password.");
			response.sendRedirect("login.jsp");
			return;
		} else if (!verifyRecaptcha) {
			// Check reCaptcha
			request.getSession().setAttribute("message3", "* Please verify that you are not a robot.");
			response.sendRedirect("login.jsp");
			return;
		} else {

			synchronized(session) {
				session.setAttribute("firstname", userObj.getFirstName());
			}
			response.sendRedirect("dashboard.jsp");
		}
	}
}

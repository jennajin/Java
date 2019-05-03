<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registration</title>

	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">	
	
	<!-- Custom styles for this template -->
	<link rel="stylesheet" type="text/css" href="css/style.css"/> 
</head> 
<body>
	<div class="container">
			<div class="registration-div mt-5 mb-5">
		    	<div class="panel text-center">
			   		<h2>REGISTRATION PAGE</h2>
		   		</div>
		   		<div class="error">
		   		<label class="text-left text-danger">${message1}</label>
		   		<label class="text-left text-danger">${message2}</label>
		   		<label class="text-left text-danger">${message3}</label>
		   		<label class="text-left text-danger">${message4}</label>
		   		<label class="text-left text-danger">${message5}</label>
		   		<label class="text-left text-danger">${message6}</label>
		   		<label class="text-left text-danger">${message7}</label>
		   		<label class="text-left text-danger">${RegisterErrMsg}</label>
		   		</div>
		   		<form method="post" action="Registers">
				  <div class="form-row">
				    <div class="form-group col-md-6">
				      <label for="inputFirstName" class="text-left">First Name*</label>
				      <input type="text" class="form-control" id="inputFirstName" name="inputFirstName" placeholder="First Name" value="${cookie.firstname.value}">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="inputLastName" class="text-left">Last Name*</label>
				      <input type="text" class="form-control" id="inputLastName" name="inputLastName" placeholder="Last Name" value="${cookie.lastname.value}">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputAddress">Address*</label>
				    <input type="text" class="form-control" id="inputAddress" name="inputAddress" placeholder="160 Kendal Ave, Toronto, ON M5R 1M3" value="${cookie.address.value}">
				  </div>
				  <div class="form-group">
			     	 <label for="inputEmail">Email*</label>
			     	 <input type="email" class="form-control" id="inputEmail" name="inputEmail" placeholder="Email" value="${cookie.email.value}">
			      </div>
				  <div class="form-group">
				      <label for="inputPassword">Password*</label>
				      <input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Password" value="${cookie.password.value}">
			      </div>
				  <div class="form-group">
				      <label for="inputCPassword">Confirm Password*</label>
				      <input type="password" class="form-control" id="inputCPassword" name="inputCPassword" placeholder="Confirm Password" value="${cookie.cpassword.value}">
			      </div>
			      
				  <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" id="agreeCheck" name="agreeCheck">
				      <label class="form-check-label" for="agreeCheck">
				        I agree to the <a href="agreement.html"> terms of service </a>
				      </label>
				    </div>
				  </div>
				  <div class="text-center mt-4">
			       	  <button type="submit" class="btn btn-danger" name="btn" value="register" name="register">Register</button>
			       	  <a href="Login?cancel=yes" class="btn btn-warning">Cancel</a>
				  </div>
				</form>
		   		
			    <footer class="blockquote-footer mt-5 mb-1 text-center">Copyright&copy; 2018 - EagleEyed </footer>
	    	</div>
	</div>
	 
	<!-- Bootstrap core JavaScript -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</body>
</html>
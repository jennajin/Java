<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<script src="https://www.google.com/recaptcha/api.js" async defer></script>

	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">	
	
	<!-- Custom styles for this template -->
	<link rel="stylesheet" type="text/css" href="css/style.css"/> 
</head>
<body>
	<div class="container">
			<div class="login-div mt-5 text-center mb-5">
		    	<div class="panel">
			   		<h2>LOGIN</h2>
		   		</div>
		   		<div class="error">
		   			<label class="text-left text-danger">${message1}</label>
		   			<label class="text-left text-danger">${message2}</label>
		   			<label class="text-left text-danger">${message3}</label>
		   		</div>
		   		<form method="post" action="Login">
			        <div class="form-group mb-3">
		           		 <input type="email" class="form-control" id="inputEmail" name="inputEmail" placeholder="Email Address" value="${cookie.email.value}">
			        </div>
		        	<div class="form-group">
		          		 <input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Password" value="${cookie.password.value}">
			        </div>
			        <div class="form-group">
			        	<div class="g-recaptcha" data-sitekey="6LekinYUAAAAABhHaI3NZQh60Gmt_xv31JSsGgNE"></div>
			        </div>
		        	<div class="form-group mb-3">
		       			<button type="submit" class="btn btn-warning btn-block" name="btn" value="login">Login</button>
		       			<a href="registration.jsp" class="btn btn-danger btn-block">Register</a>
		       		</div>
		       		<div class="forgot text-center mt-3 mb-30">
		        		 <a href="reset.jsp">Forgot your password?</a>
					</div>
			    </form>
			    <footer class="blockquote-footer mt-5 mb-1">Copyright&copy; 2018 - EagleEyed </footer>
	    	</div>
	    	
	</div> 
	<!-- Bootstrap core JavaScript -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
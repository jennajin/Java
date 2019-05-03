<!--  this page is just a template for using its code for servlets -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

	<!-- Bootstrap core CSS -->
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	
	<!-- Custom styles for this template -->
	<link rel="stylesheet" type="text/css" href="css/style.css"/> 
</head>
<body>
	<div class="container">
			<div class="login-div mt-5 text-center mb-5">
		    	<div class="panel">
			   		<h4>successfully registered user</h4>
		   		</div>
		   		<form>
			        <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" checked="checked">
				      <label class="form-check-label" for="agreeCheck">
				       an email has been sent to + email + please check your email to verify and confirm
				        <br/>Go to <a href="login.jsp">  login page </a>
				      </label>
				    </div>
				  </div>
			    </form>
			    <footer class="blockquote-footer mt-5 mb-1">Copyright&copy; 2018 - EagleEyed </footer>
	    	</div>
	    	
	</div>
</body>
</html>
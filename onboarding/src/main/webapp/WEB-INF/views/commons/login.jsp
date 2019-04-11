<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Resource OnBoarding</title>
<!-- Load Sytle Sheets -->
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/bootstrap.min.css">
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/application.css">

<!-- Load Scripts -->
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#loginSubmit').click(function(e) {
		$('#errMessage').text("");
		if($('#username').val() == null || $('#username').val() == ""){
			$('#errMessage').text("User Name Can't be null or empty");
			return false;
		}
		if($('#password').val() == null || $('#password').val() == ""){
			$('#errMessage').text("Password Can't be null or empty");
			return false;
		}
	});
	
});
</script>
</head>
<body>
	<div class="content-style">
		<form name='loginForm' id="loginFormID"
			action="<c:url value='login' />" method='POST'>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<c:if test="${not empty message}">
						<strong><span class="has-error">Your login attempt
								was not successful due to ${message}</span></strong>
					</c:if>
					<strong><span class="is-success">${successMessage}</span></strong>
					<strong><span class="has-error" id="errMessage"></span></strong>
				</div>
				<div class="col-md-3"></div>
			</div>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6 login-display">
					<div class="row">
						<div class="col-md-12 customized-span-login "><br>Nationwide
							Resource Onboarding</div>
					</div>
					<br>
					<div class="row form-group">
						<div class="col-md-2"></div>
						<div class="col-md-2" align="right">
							<label for="username" style="color: #FFFFFF;">Username</label>
						</div>
						<div class="col-md-6">
							<input type='text' class="form-control" id="username"
								name='username' autocomplete="off">
						</div>
						<div class="col-md-2"></div>
					</div>
					<br>
					<div class="row form-group">
						<div class="col-md-2"></div>
						<div class="col-md-2" align="right">
							<label for="password" style="color: #FFFFFF;">Password</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type='password' id='password'
								name='password' />
						</div>
						<div class="col-md-2"></div>
					</div>
					<br>
					<div class="row form-group">
						<div class="col-md-3"></div>
						<div class="col-md-9" style="text-align: center;">
							<input type="submit" class="btn btn-submit" name="login" id="loginSubmit"
								value="Login" /> <input type="reset" class="btn btn-submit"
								name="reset" value="Reset" /><br><br><br>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<br> <br>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
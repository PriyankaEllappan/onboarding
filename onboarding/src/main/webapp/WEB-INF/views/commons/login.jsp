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
</head>
<body>
	<div class="content-style">
		<form name='loginForm' id="loginFormID"
			action="<c:url value='login' />" method='POST'>
			<br>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4 login-display">
					<div class="row">
						<div class="col-md-12 customized-span-login "><br>Nationwide
							Resource Onboarding</div>
					</div>
					<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
						<span class="has-error">Your login attempt was not
							successful due to <c:out
								value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
						</span>
					</c:if>
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
							<input type="submit" class="btn btn-submit" name="login"
								value="Login" /> <input type="reset" class="btn btn-submit"
								name="reset" value="Reset" /><br><br><br>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<br> <br>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
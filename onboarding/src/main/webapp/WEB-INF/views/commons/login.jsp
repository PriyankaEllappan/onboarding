<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<!-- Load Sytle Sheets -->
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/bootstrap.min.css">
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/application.css">
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<form name='loginForm' id="loginFormID"
			action="<c:url value='login' />" method='POST'>
			<br>
			<br>
			<br>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
						<span class="has-error">Your login attempt was not successful due to <c:out
								value="${SPRING_SECURITY_LAST_EXCEPTION.message}" /></span>
					</c:if>
				</div>
				<div class="col-md-4"><br><br></div>
			</div>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-2" align="right">
					<label for="username" >Username</label>
				</div>
				<div class="col-md-2">
					<input type='text' id="username" name='username' autocomplete="off">
				</div>
				<div class="col-md-4"></div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-2" align="right">
					<label for="password">Password</label>
				</div>
				<div class="col-md-2">
					<input type='password' id='password' name='password' />
				</div>
				<div class="col-md-4"></div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-2" >
				</div>
				<div class="col-md-2">
					<input type="submit" class="btn-submit" name="login" value="Login" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" class="btn-submit" name="reset" value="Reset" />
				</div>
				<div class="col-md-4"></div>
			</div>
		</form>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
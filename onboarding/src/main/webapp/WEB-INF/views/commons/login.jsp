<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<style type="text/css">
</style>
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
			<br><br><br><br>
			<div class="row">
				<div class="col-xs-4"></div>
				<div class="col-xs-1">
					<label for="username">Username</label>
				</div>
				<div class="col-xs-2">
					<input type='text' id="username" name='username' autocomplete="off">
				</div>
				<div class="col-xs-4"></div>
			</div>
			<br>
			<div class="row">
				<div class="col-xs-4"></div>
				<div class="col-xs-1">
					<label for="password">Password</label>
				</div>
				<div class="col-xs-2">
					<input type='password' id='password' name='password' />
				</div>
				<div class="col-xs-4"></div>
			</div>
			<br>
			<div class="row">
				<div class="col-xs-4"></div>
				<div class="col-xs-2" align="right">
					<button class="btn-submit" name="login" value="login">Login</button>
				</div>
				<div class="col-xs-2">
					<button class="btn-submit" name="reset" value="reset">Reset</button>
				</div>
				<div class="col-xs-4"></div>
			</div>
		</form>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
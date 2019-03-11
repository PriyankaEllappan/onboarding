<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<style type="text/css">
</style>
<head>
<title>Login Page</title>
<!-- Load Sytle Sheets 
<link rel="stylesheet"
	href="/app/resources/stylesheets/bootstrap.min.css">
<link rel="stylesheet"
	href="/app/resources/stylesheets/bootstrap-datepicker.min.css">
<link rel="stylesheet" href="/app/resources/stylesheets/application.css"> -->
<script type="text/javascript">
history.pushState(null, null, location.href);
window.onpopstate = function () {
    history.go(1);
};
    </script>

</head>
<body>
	<h3>App Login Page</h3>

	<form name='loginForm' id="loginFormID"
		action="<c:url value='login' />" method='POST'>

		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username'
					value="<%= session.getAttribute("name") %>"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td><button name="login" value="login">Login</button></td>
				<td><button name="reset" value="reset">Reset</button></td>
			</tr>
		</table>

	</form>
	<!-- 
	<script src="/app/resources/scripts/jquery.min.js"></script>
	<script src="/app/resources/scripts/bootstrap.min.js"></script>
	<script src="/app/resources/scripts/application.js"></script>
	<script src="/app/resources/scripts/bootstrap-datepicker.min.js"></script> -->

</body>
</html>
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
<script type="text/javascript">
	history.pushState(null, null, location.href);
	window.onpopstate = function() {
		history.go(1);
	};
</script>

</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<div class="row">
			<div class="col-xs-4"></div>
			<div class="col-xs-4">
				<br> <br>
				<form name='loginForm' id="loginFormID"
					action="<c:url value='login' />" method='POST'>
					<table>
						<tr>
							<td>User &nbsp;&nbsp;</td>
							<td></td>
							<td><input type='text' name='username'></td>
						</tr>
						<tr>
							<td><br></td>
							<td><br></td>
						</tr>
						<tr>
							<td>Password &nbsp;&nbsp;</td>
							<td></td>
							<td><input type='password' name='password' /></td>
						</tr>
						<tr>
							<td><br></td>
							<td><br></td>
						</tr>
						<tr>
							
							<td><button name="login" value="login">Login</button></td>
							<td><br></td>
							<td><button name="reset" value="reset">Reset</button></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="col-xs-4"></div>
		</div>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
	<h3>App Login Page</h3>


</body>
</html>
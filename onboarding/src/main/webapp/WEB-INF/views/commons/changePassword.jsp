<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource Onboarding</title>
<!-- Load Sytle Sheets -->
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/bootstrap.min.css">
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/application.css">

<!-- Load Scripts -->
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
<script src="/onboarding/resources/scripts/changePassword.js"></script>
</head>
<body>
	<div class="content-style">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<span class="has-error" id="errMessage"></span>
			</div>
			<div class="col-md-4"></div>
		</div>
		<form:form name="changePasswordForm" method="post"
			action="/onboarding/changepassword" modelAttribute="authInfo">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4 login-display">
					<div class="row">
						<div class="col-md-12 customized-span-login ">
							<br>Reset Password
						</div>
					</div>
					<br>
					<div class="row form-group">
						<div class="col-md-4" align="right">
							<form:label path="userName" style="color: #FFFFFF;">Employee Id</form:label>
						</div>
						<div class="col-md-6">
							<form:input class="form-control" name="userName" path="userName" />
						</div>
						<div class="col-md-2"></div>
					</div>
					<div class="row form-group">
						<div class="col-md-4" align="right">
							<form:label path="currPassword" style="color: #FFFFFF;">Old Password</form:label>
						</div>
						<div class="col-md-6">
							<form:password class="form-control" name="currPassword"
								path="currPassword" />
						</div>
						<div class="col-md-2"></div>
					</div>
					<div class="row form-group">
						<div class="col-md-4" align="right">
							<form:label path="newPassword" style="color: #FFFFFF;">New Password</form:label>
						</div>
						<div class="col-md-6">
							<form:password class="form-control" name="newPassword"
								path="newPassword" />
						</div>
						<div class="col-md-2"></div>
					</div>
					<br>
					<div class="form-group">
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-4" style="text-align: right">
								<input class="btn btn-submit" type="submit"
									id="changePasswordFormSubmit" value="Submit">
							</div>
							<div class="col-md-4">
								<button class="btn btn-submit" id="changePasswordFormReset"
									type="reset" value="Cancel">Reset</button>
							</div>
							<div class="col-md-1"></div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<br> <br>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
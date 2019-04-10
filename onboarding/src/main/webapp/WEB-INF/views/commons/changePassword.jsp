<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource Onboarding</title>
<!-- Load Sytle Sheets -->
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/bootstrap.min.css">
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/bootstrap-datepicker.min.css">
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/application.css">

<!-- Load Scripts -->
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap-datepicker.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
<script src="/onboarding/resources/scripts/changePassword.js"></script>
<script src="/onboarding/resources/scripts/application.js"></script>
</head>

<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="container-fluid content-style">
		<div class="row">
			<div class="col-md-4" align="center"></div>
			<div class="col-md-4" align="center">
				<h4>
					<b>User Change Password Form</b>
				</h4>
			</div>
			<div class="col-md-2" align="center"></div>
			<div class="col-md-2" align="center"></div>
		</div>
		<br> <span class="has-error" id="errMessage"></span> <span
			class="is-success" id="statusSucessMessage"></span> <br> <br>
		<div class="resizeTabCont" id="resourceNonAvailable">
			<br> <br>
			<div id="userChangePasswordFormDiv">
				<form name="userChangePasswordForm" method="post">
					<div class="row">
						<div class="col-md-4"></div>
						<br>
						<div class="row form-group">
							<div class="col-md-2"></div>
							<div class="col-md-2" align="right">
								<label for="userName">Employee ID</label>
							</div>
							<div class="col-md-6">
								<input type='text' class="form-control" id="userName"
									name='userName' autocomplete="off">
							</div>
							<div class="col-md-2"></div>
						</div>
						<br>
						<div class="row form-group">
							<div class="col-md-2"></div>
							<div class="col-md-2" align="right">
								<label for="currentPassword">Current Password</label>
							</div>
							<div class="col-md-6">
								<input class="form-control" type='password' id='currentPassword'
									name='currentPassword' />
							</div>
							<div class="col-md-2"></div>
						</div>
						<br>
						<div class="row form-group">
							<div class="col-md-2"></div>
							<div class="col-md-2" align="right">
								<label for="newPassword">New Password</label>
							</div>
							<div class="col-md-6">
								<input class="form-control" type='password' id='newPassword'
									name='newPassword' />
							</div>
							<div class="col-md-2"></div>
						</div>
						<br>
						<div class="col-md-4">
							<br> <br>
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-2"></div>
						<div class="col-md-8" style="text-align: center;">
							<input type="submit" class="btn btn-submit" name="login"
								id="userChangePasswordFormSubmit" value="Change Password" onclick="return validateForm()"/> <input
								type="reset" class="btn btn-submit" name="reset" value="Reset" />
						</div>
						<div class="col-md-2"></div>
					</div>
					<div class="col-md-4">
						<br> <br>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
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
<script src="/onboarding/resources/scripts/admin.js"></script>
<script src="/onboarding/resources/scripts/application.js"></script>
</head>

<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="container-fluid content-style">
		<div class="row">
			<div class="col-md-4" align="center"></div>
			<div class="col-md-4" align="center">
				<h4>
					<b>User Registration Form</b>
				</h4>
			</div>
			<div class="col-md-2" align="center"></div>
			<div class="col-md-2" align="center"></div>
		</div>
		<br> <span class="has-error" id="errMessage"></span> <span
			class="is-success" id="statusSucessMessage"></span> <br> <br>
		<div class="resizeTabCont" id="resourceNonAvailable">
			<br> <br>
			<div id="userRegisterFormDiv">
			<form name="resourceRegisterForm" method="post">
				<div class=" row form-group">
					<div class="col-md-2"></div>
					<div class="col-md-3" align="right">
						<label for="newEmpID">Employee Id</label>
					</div>
					<div class="col-md-2">
						<input class="form-control" name="newEmpID" id="newEmpID"
							placeholder="Enter EmployeeID" />
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-2"></div>
				</div>
				<br>
				<div class=" row form-group">
					<div class="col-md-2"></div>
					<div class="col-md-3" align="right">
						<label for="newEmpEmail">Role</label>
					</div>
					<div class="col-md-2">
						<select class="form-control" name="role" id="role">
						<option value=" "selected disabled>Select</option>
							<option>ROLE_ADMIN</option>
							<option>ROLE_REQUESTER</option>
							<option>ROLE_PROCESSOR</option>
						</select>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-2"></div>
				</div>
				<br>
				<div class="row form-group">
					<div class="col-md-2"></div>
					<div class="col-md-8" style="text-align: center;">
						<input type="submit" class="btn btn-submit" name="login" id="userRegisterFormSubmit"
							value="Register" /> <input type="reset" class="btn btn-submit"
							name="reset" value="Reset" />
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
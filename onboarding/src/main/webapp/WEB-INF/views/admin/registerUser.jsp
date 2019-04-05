<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource Onboarding</title>
<!-- Load Sytle Sheets -->
<link rel="stylesheet" href="/onboarding/resources/stylesheets/bootstrap.min.css">
<link rel="stylesheet" href="/onboarding/resources/stylesheets/bootstrap-datepicker.min.css">
<link rel="stylesheet" href="/onboarding/resources/stylesheets/application.css">

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
				<h4><b>User Registration Form</b></h4>
			</div>
			<div class="col-md-2" align="center"></div>
			<div class="col-md-2" align="center">
			</div>
		</div>
		<br> <span class="has-error" id="errMessage"></span> <span
			class="is-success" id="statusSucessMessage"></span> <br> <br>
		<div class="resizeTabCont" id="resourceNonAvailable">
			<br> <br>
			<form name="resourceRegisterForm" method="post">
				<div class="form-group">
					<div class="row">
						<div class="col-md-2">
							<label for="newEmpID">Employee Id</label>
						</div>
						<div class="col-md-3">
							<input class="form-control" name="newEmpID" id="newEmpID"
								placeholder="Enter EmployeeID" readonly autocomplete="off" />
						</div>
						<div class="col-md-1"></div>
						<div class="col-md-2">
							<label for="newEmpEmail">Email</label>
						</div>
						<div class="col-md-3">
							<input class="form-control" id="newEmpEmail" name="newEmpEmail"
								placeholder="Enter Email Id" readonly autocomplete="off" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<br /> <br />
						<div class="col-md-10" style="text-align: center">
							<button class="btn btn-submit" id="resourceRegisterFormSubmit">
								Submit</button>
							<input class="btn btn-submit" id="resourceRegisterFormReset"
								type="reset" value="Clear" />
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
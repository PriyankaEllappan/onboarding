<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource OnBoarding</title>
<!-- Load Sytle Sheets -->
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/bootstrap.min.css">
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/bootstrap-datepicker.min.css">
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/application.css">
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<div class="row">
			<div class="col-md-4" align="left">
				<h3 style="color: blue;">Resource Details</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4" align="left">
				<p style="color: green;">Below details saved successfully</p>
			</div>
		</div>
		<table class="table table-striped">
			<tr>
				<td>Employee Id(Cognizant)</td>
				<td>${employee.getEmpId()}</td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td>${employee.getEmpFullName()}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${employee.getEmail()}</td>
			</tr>
			<tr>
				<td>First Name</td>
				<td>${employee.getFirstName()}</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>${employee.getLastName()}</td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td>${employee.getDateOfBirth()}</td>
			</tr>
			<tr>
				<td>Passport/ID Number</td>
				<td>${employee.getPassportNo()}</td>
			</tr>
			<tr>
				<td>Team Name</td>
				<td>${employee.getTeamName()}</td>
			</tr>
			<tr>
				<td>Project Name</td>
				<td>${employee.getProjName()}</td>
			</tr>
			<tr>
				<td>Project Id</td>
				<td>${employee.getProjId()}</td>
			</tr>
			<tr>
				<td>Requester</td>
				<td>${employee.getRequester()}</td>
			</tr>
			<tr>
				<td>Processor</td>
				<td>${employee.getProcessor()}</td>
			</tr>
			<tr>
				<td>Location</td>
				<td>${employee.getLocation()}</td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td>${employee.getStartDate()}</td>
			</tr>

			<tr>
				<td>End Date</td>
				<td>${employee.getEndDate()}</td>
			</tr>
			<tr>
				<td>Nationwide Id</td>
				<td>${employee.getNationWideId()}</td>
			</tr>
			<tr>
				<td>NationwideId Created Date</td>
				<td>${employee.getNationWideIdDate()}</td>
			</tr>
			<tr>
				<td>Comments</td>
				<td>${employee.getComments()}</td>
			</tr>
			<tr>
				<td>Status</td>
				<td>${employee.getStatus()}</td>
			</tr>
			<tr>
				<td>Terminated Status</td>
				<td>${employee.getTerminated()}</td>
			</tr>
			<tr>
				<td>Terminated Date</td>
				<td>${employee.getTerminatedDate()}</td>
			</tr>
			<tr>
				<td><button class="btn btn-info"
						onclick="location.href='./list'">Back</button>
			</tr>
		</table>
	</div>
	<!-- Load Script Files -->
	<script src="/onboarding/resources/scripts/jquery.min.js"></script>
	<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
	<script src="/onboarding/resources/scripts/application.js"></script>
	<script src="/onboarding/resources/scripts/bootstrap-datepicker.min.js"></script>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
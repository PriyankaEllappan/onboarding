<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<div class="row">
			<div class="col-md-4" align="center"></div>
			<div class="col-md-4" align="center">
				<h4>
					<b> Resource - Project Details</b>
				</h4>
			</div>
			<div class="col-md-2" align="center"></div>
			<div class="col-md-2" align="center"></div>
		</div>
		<table class="table table-striped bordered">
			<tr class="bold-font">
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Date of Birth</th>
				<th>Passport No/SSN No</th>
				<th>Email</th>
				<th>Status</th>
			</tr>
			<c:forEach var="employee" items="${employees}">
				<tr>
					<td>${employee.getEmployeeId()}</td>
				<td>${employee.getName()}</td>
				<td>${employee.getFirstName()}</td>
				<td>${employee.getLastName()}</td>
				<td>${employee.getDateOfBirth()}</td>
				<td>${employee.getPassportNumber()}</td>
				<td>${employee.getEmail()}</td>
				<td>${employee.getReleaseStatus()}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
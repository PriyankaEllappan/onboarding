<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
<script src="/onboarding/resources/scripts/application.js"></script>
<script src="/onboarding/resources/scripts/bootstrap-datepicker.min.js"></script>
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<h2>Resources List</h2>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-left">
				<li class="active"><a href="/onboarding">Back to home</a></li>
			</ul>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Employee Id</th>
					<th>Employee Name</th>
					<th>Project Id</th>
					<th>Project Name</th>
					<th>Team Name</th>
				</tr>
			</thead>
			<c:forEach var="employee" items="${employees}">
				<tr>
					<td>${employee.getEmployeeId()}</td>
					<td>${employee.getName()}</td>
					<td>${employee.getProjectId()}</td>
					<td>${employee.getProjectName()}</td>
					<td>${employee.getTeamName()}</td>
					<td><button class="btn btn-info"
							onclick="location.href='show/${resource.getID()}'">Show</button>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- Load Script Files -->
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
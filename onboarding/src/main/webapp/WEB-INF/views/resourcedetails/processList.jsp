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
					<th>Employee Name</th>
					<th>Project Name</th>
					<th>Project ID</th>
					<th>Requester ID</th>
					<th>Requester Name</th>
					<th>Processor ID</th>
					<th>Processor Name</th>
				</tr>
			</thead>
			<c:forEach var="resource" items="${resources}">
				<tr>
					<td>${resource.getFirstName()}</td>
					<td>${resource.getProjectName()}</td>
					<td>${resource.getProjectId()}</td>
					<td>${resource.getRequesterID()}</td>
					<td>${resource.getRequesterName()}</td>
					<td>${resource.getProcessorID()}</td>
					<td>${resource.getProcessorName()}</td>
					<td><button class="btn btn-info"
							onclick="location.href='show/${resource.getId()}'">Show</button>
					<td><button class="btn btn-primary"
							onclick="location.href='approve/${resource.getId()}'">Approve</button>
				</tr>
			</c:forEach>
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
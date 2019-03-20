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
	href="/onboarding/resources/stylesheets/application.css">
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
<script src="/onboarding/resources/scripts/application.js"></script>
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<h4>Resources List</h4>
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
					<th></th>
					<th></th>
				</tr>
			</thead>
			<c:forEach var="employee" items="${employees}">
				<tr>
					<td>${employee.getEmployeeId()}</td>
					<td>${employee.getName()}</td>
					<td>${employee.getProjectId()}</td>
					<td>${employee.getProjectName()}</td>
					<td>${employee.getTeamName()}</td>
					<c:choose>
						<c:when test="${employee.getApprovalStatus() == 'NEW'}">
							<td><button class="btn-info">Requested</button></td>
						</c:when>
						<c:when test="${employee.getApprovalStatus() == 'INPROGRESS'}">
							<td><button class="btn-warning">Acknowledged</button></td>
						</c:when>
						<c:when test="${employee.getApprovalStatus() == 'COMPLETED'}">
							<td><button class="btn-success">PROCESSED</button></td>
						</c:when>
						<c:when test="${employee.getApprovalStatus() == 'REJECTED'}">
							<td><button class="btn-danger">PROCESSED</button></td>
						</c:when>
						<c:when test="${employee.getApprovalStatus() == 'CLOSED'}">
							<td><button class="btn-default">PROCESSED</button></td>
						</c:when>
					</c:choose>
					<td><img class="icon-image to-click" src="/onboarding/resources/icons/showIcon" onclick="location.href='show/${employee.getId()}'"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- Load Script Files -->
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
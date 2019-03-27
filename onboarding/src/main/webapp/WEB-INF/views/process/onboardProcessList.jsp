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
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<div class="row">
			<div class="col-md-12" align="center">
				<h4>Process List</h4><br>
			</div>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Employee Id</th>
					<th>Employee Name</th>
					<th>Project Id</th>
					<th>Project Name</th>
					<th>Team Name</th>
					<th>Approval Status</th>
					<th>Release Status</th>
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
							<td><button class="btn-info to-click" onclick="location.href='onboard/${employee.getId()}'">Acknowledge</button></td>
						</c:when>
						<c:when test="${employee.getApprovalStatus() == 'INPROGRESS'}">
							<td><button class="btn-warning to-click" onclick="location.href='onboard/${employee.getId()}'">Processing</button></td>
						</c:when>
						<c:when test="${employee.getApprovalStatus() == 'COMPLETED'}">
							<td><button class="btn-success not-to-click">PROCESSED</button></td>
						</c:when>
					</c:choose>
					<c:choose>
								<c:when test="${employee.getReleaseStatus() == 'YET TO RELEASE'}">
									<td><button class="btn-success not-to-click">Active</button></td>
								</c:when>
								<c:when test="${employee.getReleaseStatus() == 'RELEASE INITIATED'}">
									<td><button class="btn-warning not-to-click">Release Initiated</button></td>
								</c:when>
								<c:when test="${employee.getReleaseStatus() == 'RELEASED'}">
									<td><button class="btn-danger not-to-click">Released</button></td>
								</c:when>
							</c:choose>
					<td><img class="icon-image to-click" src="/onboarding/resources/icons/show" onclick="location.href='show/${employee.getId()}'"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- Load Script Files -->
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
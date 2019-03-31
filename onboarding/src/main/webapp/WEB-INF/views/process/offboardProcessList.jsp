<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<span class="has-error" id="errMessage"></span> <span
			class="is-success" id="statusSucessMessage"></span>
		<c:choose>
			<c:when test="${not empty employees}">
				<div class="row">
					<div class="col-md-12" align="center">
						<h4>Process List</h4>
						<br>
					</div>
				</div>
				<table class="table table-striped bordered">
					<tr class="bold-font">
						<th>Employee Id</th>
						<th>Employee Name</th>
						<th>Project Id</th>
						<th>Project Name</th>
						<th>Team Name</th>
						<th>Release Status</th>
						<th></th>
					</tr>
					<c:forEach var="employee" items="${employees}">
						<tr>
							<td>${employee.getEmployeeId()}</td>
							<td>${employee.getName()}</td>
							<td>${employee.getProjectId()}</td>
							<td>${employee.getProjectName()}</td>
							<td>${employee.getTeamName()}</td>
							<c:choose>
								<c:when
									test="${employee.getReleaseStatus() == 'Release Initiated' && employee.getApprovalStatus() == 'Completed'}">
									<td><button class="btn-warning to-click"
											onclick="location.href='offboard/${employee.getId()}'">Approve</button></td>
								</c:when>
								<c:when test="${employee.getReleaseStatus() == 'Released'}">
									<td><span class="customized-span-danger">Released</span></td>
								</c:when>
								<c:otherwise>
									<td><span class="customized-span-requested">NA</span></td>
								</c:otherwise>
							</c:choose>
							<td><img class="icon-image to-click"
								src="/onboarding/resources/icons/show"
								onclick="location.href='show/${employee.getId()}'"></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<br>
				<br>
				<h4>No requests Available</h4>
			</c:otherwise>
		</c:choose>
	</div>
	<!-- Load Script Files -->
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
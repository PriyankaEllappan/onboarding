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
		<c:choose>
			<c:when test="${not empty employees}">
				<div class="row">
					<div class="col-md-12" align="center">
						<h4>Release List</h4>
						<br>
					</div>
				</div>
				<table class="table table-striped">
					<tr class="bold-font">
						<th>Employee Id</th>
						<th>Employee Name</th>
						<th>Project Id</th>
						<th>Project Name</th>
						<th>Team Name</th>
						<th> Release Status</th>
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
									test="${employee.getReleaseStatus() == 'Yet to Release'}">
									<td><button class="btn-danger to-click"
											onclick="location.href='requestrelease/${employee.getId()}'">Release</button></td>
								</c:when>
								<c:when
									test="${employee.getReleaseStatus() == 'Release Initiated'}">
									<td><span class="customized-span-warning">Release
											Initiated</span></td>
								</c:when>
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
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
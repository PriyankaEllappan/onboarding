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
<script src="/onboarding/resources/scripts/resourceList.js"></script>
</head>

<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<c:set var="count" value="0" scope="page" />
		<c:set var="headcount" value="0" scope="page" />
		<div class="row">
			<div class="col-md-4" align="center"></div>
			<div class="col-md-4" align="center">
				<h4>
					<b> Resource - Project Details</b><br><br>
				</h4>
			</div>
			<div class="col-md-2" align="center"></div>
			<div class="col-md-2" align="center"></div>
		</div>
		<c:choose>
			<c:when test="${not empty employees}">
			<c:forEach var="employee" items="${employees}">
			<c:if test="${headcount == 0}">
				<div class="row">
					<div class="col-md-12">
						<table class="table bordered">
							<tr>
								<th class="right-align">Employee ID:</th>
								<td class="left-align">${employee.getEmployeeId()}</td>
								<td></td>
								<th class="right-align">Employee Name:</th>
								<td class="left-align">${employee.getName()}</td>
								<td></td>
								<th class="right-align">Email ID:</th>
								<td class="left-align">${employee.getEmail()}</td>
								<td></td>
								<th class="right-align">Date of Birth:</th>
								<td class="left-align">${employee.getDateOfBirth()}</td>
								<td></td>
								<th class="right-align">Passport/SSN Number:</th>
								<td class="left-align">${employee.getPassportNumber()}</td>
							</tr>
						</table>
					</div>
				</div>
			</c:if>
			<c:set var="headcount" value="${headcount + 1}" scope="page" />
		</c:forEach>
		<div class="panel-group" id="accordion">
			<c:forEach var="employee" items="${employees}">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapse${count}"><b>${employee.getProjectName()}</b></a>
						</h4>
					</div>
					<div id="collapse${count}" class="panel-collapse collapse">
						<div class="panel-body">
							<table class="table table-striped bordered">
								<tr>
									<th>Project Name:</th>
									<td>${employee.getProjectName()}</td>
								</tr>
								<tr>
									<th>Project ID:</th>
									<td>${employee.getProjectId()}</td>
								</tr>
								<tr>
									<th>Team Name:</th>
									<td>${employee.getTeamName()}</td>
								</tr>
								<tr>
									<th>Location:</th>
									<td>${employee.getLocation()}</td>
								</tr>
								<tr>
									<th>Requester:</th>
									<td>${employee.getRequesterName()}</td>
								</tr>
								<tr>
									<th>Processor:</th>
									<td>${employee.getProcessorName()}</td>
								</tr>
								<c:if test="${not empty employee.getNationwideId()}">
								<tr>
									<th>Nationwide ID:</th>
									<td>${employee.getNationwideId()}</td>
								</tr>
								</c:if>
								<tr>
									<th>Start Date:</th>
									<td>${employee.getStartDate()}</td>
								</tr>
								<c:if test="${not empty employee.getReleaseDate()}">
								<tr>
									<th>End Date:</th>
									<td>${employee.getReleaseDate()}</td>
								</tr>
								</c:if>
								<tr>
									<th>Status:</th>
									<td>${employee.getReleaseStatus()}</td>
								</tr>
								<tr>
									<th></th>
									<td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<c:set var="count" value="${count + 1}" scope="page" />
			</c:forEach>
		</div>
			</c:when>
			<c:otherwise><br>
				<br>
				<h4>No Details Available for the Selected Resource.</h4></c:otherwise>
		</c:choose>
		
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
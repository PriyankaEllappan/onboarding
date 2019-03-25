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
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<div class="row">
			<div class="col-md-12" align="center">
				<h4>Resource Details</h4><br>
			</div>
		</div>
		<table class="table table-striped">
			<tr>
				<td>Employee Id(Cognizant)</td>
				<td>${employee.getEmployeeId()}</td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td>${employee.getName()}</td>
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
				<td>${employee.getPassportNumber()}</td>
			</tr>
			<tr>
				<td>Team Name</td>
				<td>${employee.getTeamName()}</td>
			</tr>
			<tr>
				<td>Project Name</td>
				<td>${employee.getProjectName()}</td>
			</tr>
			<tr>
				<td>Project Id</td>
				<td>${employee.getProjectId()}</td>
			</tr>
			<tr>
				<td>Requester</td>
				<td>${employee.getRequesterName()}</td>
			</tr>
			<tr>
				<td>Processor</td>
				<td>${employee.getProcessorName()}</td>
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
				<td>Nationwide Id</td>
				<td>${employee.getNationwideId()}</td>
			</tr>
			<tr>
				<td>NationwideId Created Date</td>
				<td>${employee.getNationwideIdCreatedDate()}</td>
			</tr>
			<tr>
				<td>SkillSet</td>
				<td>${employee.getSkillSet()}</td>
			</tr>
			<tr>
				<td>SkillSummary</td>
				<td>${employee.getSkillSummary()}</td>
			</tr>
			<tr>
				<td>Experience</td>
				<td>${employee.getExperience()}</td>
			</tr>
			<tr>
				<td>BSAName</td>
				<td>${employee.getBsaName()}</td>
			</tr>
			<tr>
				<td>Customer PPL</td>
				<td>${employee.getPplManager()}</td>
			</tr>
			<tr>
				<td>APM</td>
				<td>${employee.getApm()}</td>
			</tr>
			<tr>
				<td>Scrum Master</td>
				<td>${employee.getScrumMaster()}</td>
			</tr>
			<tr>
				<td>FGOnBoardingDate</td>
				<td>${employee.getFgOnBoardingDate()}</td>
			</tr>
			<tr>
				<td>Comments</td>
				<td>${employee.getComments()}</td>
			</tr>
			<c:if test="${not empty employee.getAttachmentId()}">
				<tr>
					<td>Attachment</td>
					<td><img class="icon-image to-click" src="/onboarding/resources/icons/download.png" onclick="location.href='/onboarding/attachment/getfile/${employee.getAttachmentId()}'"></td>
				</tr>
			</c:if>
		</table>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
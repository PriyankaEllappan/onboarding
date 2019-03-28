<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource OnBoarding</title>

<!-- Load Sytle Sheets -->
<link rel="stylesheet" href="/onboarding/resources/stylesheets/bootstrap.min.css">
<link rel="stylesheet" href="/onboarding/resources/stylesheets/application.css">
<!-- Load Script Files -->
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
		<div class="row">
			<div class="col-md-4" align="left">
				<p style="color: green;">Below details saved successfully</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2" align="center"></div>
			<div class="col-md-8" align="center">
				<table class="table table-striped">
					<c:if test="${not empty employee.getEmployeeId()}">
						<tr>
							<td class="bold-font">EMPLOYEE ID</td>
							<td>${employee.getEmployeeId()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getName()}">
						<tr>
							<td class="bold-font">NAME</td>
							<td>${employee.getName()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getEmail()}">
						<tr>
							<td class="bold-font">EMAIL</td>
							<td>${employee.getEmail()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getFirstName()}">
						<tr>
							<td class="bold-font">FIRST NAME</td>
							<td>${employee.getFirstName()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getLastName()}">
						<tr>
							<td class="bold-font">LAST NAME</td>
							<td>${employee.getLastName()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getDateOfBirth()}">
						<tr>
							<td class="bold-font">DATE OF BIRTH</td>
							<td>${employee.getDateOfBirth()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getPassportNumber()}">
						<tr>
							<td class="bold-font">PASSPORT/ID NUMBER</td>
							<td>${employee.getPassportNumber()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getTeamName()}">
						<tr>
							<td class="bold-font">TEAM NAME</td>
							<td>${employee.getTeamName()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getProjectName()}">
						<tr>
							<td class="bold-font">PROJECT NAME</td>
							<td>${employee.getProjectName()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getProjectId()}">
						<tr>
							<td class="bold-font">PROJECT ID</td>
							<td>${employee.getProjectId()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getRequesterName()}">
						<tr>
							<td class="bold-font">REQUESTER</td>
							<td>${employee.getRequesterName()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getProcessorName()}">
						<tr>
							<td class="bold-font">PROCESSOR</td>
							<td>${employee.getProcessorName()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getLocation()}">
						<tr>
							<td class="bold-font">LOCATION</td>
							<td>${employee.getLocation()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getStartDate()}">
						<tr>
							<td class="bold-font">START DATE</td>
							<td>${employee.getStartDate()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getNationwideId()}">
						<tr>
							<td class="bold-font">NATIONWIDE ID</td>
							<td>${employee.getNationwideId()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getNationwideIdCreatedDate()}">
						<tr>
							<td class="bold-font">NATIONWIDE ID CREATED DATE</td>
							<td>${employee.getNationwideIdCreatedDate()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getSkillSet()}">
						<tr>
							<td class="bold-font">SKILL SET</td>
							<td>${employee.getSkillSet()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getSkillSummary()}">
						<tr>
							<td class="bold-font">SKILL SUMMARY</td>
							<td>${employee.getSkillSummary()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getExperience()}">
						<tr>
							<td class="bold-font">EXPERIENCE</td>
							<td>${employee.getExperience()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getBsaName()}">
						<tr>
							<td class="bold-font">BSA</td>
							<td>${employee.getBsaName()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getPplManager()}">
						<tr>
							<td class="bold-font">PPL MANAGER</td>
							<td>${employee.getPplManager()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getApm()}">
						<tr>
							<td class="bold-font">APM</td>
							<td>${employee.getApm()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getScrumMaster()}">
						<tr>
							<td class="bold-font">SCRUM MASTER</td>
							<td>${employee.getScrumMaster()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getFgOnBoardingDate()}">
						<tr>
							<td class="bold-font">FG ONBOARDING DATE</td>
							<td>${employee.getFgOnBoardingDate()}</td>
						</tr>
					</c:if>
					<c:if test="${not empty employee.getComments()}">
						<tr>
							<td class="bold-font">COMMENTS</td>
							<td>${employee.getComments()}</td>
						</tr>
					</c:if>
				</table>
			</div>
			<div class="col-md-2" align="center"></div>
		</div>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
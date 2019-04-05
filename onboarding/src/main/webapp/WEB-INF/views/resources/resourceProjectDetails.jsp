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
		<c:set var="count" value="0" scope="page" />
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
		<c:forEach var="employee" items="${employees}">
			<c:choose>
				<c:when test="${count == 0}">
					<div class="row">
						<div class="col-md-2">
							<span>Employee ID:</span>
						</div>
						<div class="col-md-4">
							<span>${employee.getEmployeeId()}</span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<span>Employee Name:</span>
						</div>
						<div class="col-md-4">
							<span>${employee.getName()}</span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<span>Email ID:</span>
						</div>
						<div class="col-md-4">
							<span>${employee.getEmail()}</span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<span>Date of Birth:</span>
						</div>
						<div class="col-md-4">
							<span>${employee.getDateOfBirth()}</span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<span>Passport/SSN Number:</span>
						</div>
						<div class="col-md-4">
							<span>${employee.getPassportNumber()}<br><br></span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<span>Project Id:</span>
						</div>
						<div class="col-md-2">
							<span>${employee.getProjectId()}</span>
						</div>
						<div class="col-md-1"></div>
						<div class="col-md-2">
							<span>Project Name:</span>
						</div>
						<div class="col-md-4">
							<span>${employee.getProjectName()}</span>
						</div>
						<div class="col-md-1"></div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<span>Requester:</span>
						</div>
						<div class="col-md-2">
							<span>${employee.getRequesterId()}</span>
						</div>
						<div class="col-md-1"></div>
						<div class="col-md-2">
							<span>Processor:</span>
						</div>
						<div class="col-md-2">
							<span>${employee.getProcessorId()}</span>
						</div>
						<div class="col-md-1"></div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<span>Status:</span>
						</div>
						<div class="col-md-2">
							<span>${employee.getReleaseStatus()}<br><br></span>
						</div>
						<div class="col-md-1"></div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="row">
						<div class="col-md-2">
							<span>Project Id:</span>
						</div>
						<div class="col-md-2">
							<span>${employee.getProjectId()}</span>
						</div>
						<div class="col-md-1"></div>
						<div class="col-md-2">
							<span>Project Name:</span>
						</div>
						<div class="col-md-4">
							<span>${employee.getProjectName()}</span>
						</div>
						<div class="col-md-1"></div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<span>Requester:</span>
						</div>
						<div class="col-md-2">
							<span>${employee.getRequesterId()}</span>
						</div>
						<div class="col-md-1"></div>
						<div class="col-md-2">
							<span>Processor:</span>
						</div>
						<div class="col-md-2">
							<span>${employee.getProcessorId()}</span>
						</div>
						<div class="col-md-1"></div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<span>Status:</span>
						</div>
						<div class="col-md-2">
							<span>${employee.getReleaseStatus()}<br><br></span>
						</div>
						<div class="col-md-1"></div>
					</div>
				</c:otherwise>
			</c:choose>
			<c:set var="count" value="${count + 1}" scope="page" />
		</c:forEach>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
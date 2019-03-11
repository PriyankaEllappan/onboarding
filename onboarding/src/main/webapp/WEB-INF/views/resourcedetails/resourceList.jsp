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
<!-- 					<th>EmployeeId</th>
					<th>EmployeeName</th> -->
					<th>Name</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Passport Number</th>
					<th>Email</th>
					<th>DOB</th>
					<!-- <th>Email</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>DOB</th>
					<th>PassportNumber</th>
					<th>TeamName</th> -->
<!-- 					<th>ProjectName</th>
					<th>ProjectId</th>
					<th>Requester</th>
					<th>Processor</th> -->
					<!-- <th>Location</th>
					<th>StartDate</th>
					<th>EndDate</th>
					<th>NationwideId</th>
					<th>NationwideIdCreatedDate</th>
					<th>Comments</th>
					<th>Status</th>
					<th>TerminatedStatus</th>
					<th>TerminatedDate</th> -->
				</tr>
			</thead>
			<c:forEach var="resource" items="${resources}">
				<tr>
					<td>${resource.getName()}</td>
					<td>${resource.getFirstName()}</td>
					<td>${resource.getLastName()}</td>
					<td>${resource.getPassportNumber()}</td>
					<td>${resource.getEmail()}</td>
					<td>${resource.getDOB()}</td>
<%-- 					<td>${resource.getEmpId()}</td>
					<td>${resource.getEmpFullName()}</td> --%>
					<%-- <td>${resource.getEmail()}</td>
					<td>${resource.getFirstName()}</td>
					<td>${resource.getLastName()}</td>
					<td><fmt:formatDate type="date"
							value="${resource.getDateOfBirth()}" /></td>
					<td>${resource.getPassportNo()}</td>
					<td>${resource.getTeamName()}</td>--%>
<%-- 					<td>${resource.getProjName()}</td>
					<td>${resource.getProjId()}</td> 
					<td>${resource.getRequester()}</td>
					<td>${resource.getProcessor()}</td> --%>
					<%-- <td>${resource.getLocation()}</td>
					<td><fmt:formatDate type="date"
							value="${resource.getStartDate()}" /></td>
					<td><fmt:formatDate type="date"
							value="${resource.getEndDate()}" /></td>
					<td>${resource.getNationWideId()}</td>
					<td><fmt:formatDate type="date"
							value="${resource.getNationWideIdDate()}" /></td>
					<td>${resource.getComments()}</td>
					<td>${resource.getStatus()}</td>
					<td>${resource.getTerminated()}</td>
					<td><fmt:formatDate type="date"
							value="${resource.getTerminatedDate()}" /></td> --%>
					<td><button class="btn btn-info"
							onclick="location.href='show/${resource.getID()}'">Show</button>
<%-- 					<td><button class="btn btn-primary"
							onclick="location.href='update/${resource.getID()}'">Update</button>
					<td><button class="btn btn-danger"
							onclick="location.href='delete/${resource.getID()}'">Delete</button> --%>
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
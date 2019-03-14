<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource Availability</title>
<!-- Load Sytle Sheets -->
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/bootstrap.min.css">
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/bootstrap-datepicker.min.css">
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/application.css">
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap-datepicker.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
<script src="/onboarding/resources/scripts/processor.js"></script>
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="container-fluid content-style">
		<div id ="formDiv">
			<div class="tab">
				<button class="tablinks"
					onclick="openSpecificTab(event, 'basicInfo')" id ="defaultOpen">Employee
					Details</button>
				<button class="tablinks"
					onclick="openSpecificTab(event, 'projInfo')">Project
					Details</button>
				<button class="tablinks"
					onclick="openSpecificTab(event, 'customerInfo')">Customer
					Details</button>
			</div>
			<form:form name="projectRegisterForm" method="post" action="/onboarding/process/processupdate"
			modelAttribute="employee" >
				<div id ="basicInfo" class="tabcontent">
					<div class="resizeTabCont">
						<br>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="employeeId">Employee Id</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name ="employeeId" path ="employeeId" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="email">Email</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path ="email" name ="email" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="firstName">First Name</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path ="firstName" name="firstName" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="lastName">Last Name</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path ="lastName" name="lastName" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="dateOfBirth">Date Of Birth</form:label>
								</div>
								<div class="col-md-3">
									<form:input autocomplete="off" class="form-control" name="dateOfBirth"
										path ="dateOfBirth" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="passportNumber">Passport ID/SSN No</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="passportNumber" path ="passportNumber" />
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id ="projInfo" class="tabcontent">
					<div class="resizeTabCont">
						<br>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="teamName">Team Name</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path ="teamName" name="teamName" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="startDate">Start Date</form:label>
								</div>
								<div class="col-md-3">
									<form:input autocomplete="off" class="form-control" name="startDate" path ="startDate" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="projectId">Project ID</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path ="projectId" name="projectId" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="projectName">Project Name</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path ="projectName" name="projectName" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="requesterName">Requester</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path ="requesterName" name="requesterName" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="processorName">Processor</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="processorName" path ="processorName" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="countryName">Country</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="countryName" path ="countryName" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="location">Location</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="location" path ="location" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="role">Role</form:label>
								</div>
								<div class="col-md-3">
								<form:input class="form-control" name="role" path ="role"  id ="role"/>
										<%-- placeholder="Enter Role value" readonly autocomplete="off" /> --%>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="rate">Rate</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="rate" path ="rate"  />
										<%-- placeholder="Enter Rate value" readonly autocomplete="off" /> --%>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="skillSet">Skill</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="skillSet" path ="skillSet" />
										<%-- placeholder="Enter Skills" readonly autocomplete="off" /> --%>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="skillSummary">Skill Summary</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="skillSummary" path ="skillSummary" />
									<!-- 	placeholder="Enter Skill Summary" readonly autocomplete="off" /> -->
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id ="customerInfo" class="tabcontent">
					<div class="resizeTabCont">
						<br>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="bsaName">BSA</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path ="bsaName" name="bsaName" /> 
									<%-- 	placeholder="Enter BSA Name" readonly autocomplete="off" /> --%>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="pplManager">Customer PPL</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="pplManager" path ="pplManager" />
										<!-- placeholder="Enter PPL Name" readonly autocomplete="off" /> -->
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="nationwideId">Nationwide ID</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path ="nationwideId" name="nationwideId" />
									<!-- 	placeholder="Enter Nationwide ID"  autocomplete="off" /> -->
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="nationwideIdCreatedDate">Nationwide ID Created Date</form:label>
								</div>
								<div class="col-md-3">
									<form:input autocomplete="off" class="form-control" name="nationwideIdCreatedDate" 
										path ="nationwideIdCreatedDate" />
										<%-- placeholder="Enter Nationwide ID Created Date (YYYY-MM-DD)" /> --%>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="approvalStatus">Approval Status</form:label>
								</div>
								<div class="col-md-3">
									<form:select class="form-control" name="approvalStatus" path ="approvalStatus"></form:select>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="fgOnBoardingDate">FG Onboarding Date</form:label>
								</div>
								<div class="col-md-3">
									<form:input autocomplete="off" class="form-control" name="fgOnBoardingDate"
										path ="fgOnBoardingDate" />
										<!-- placeholder="Enter FG Onboarding Date (YYYY-MM-DD)" /> --> 
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="comments">Comments</form:label>
								</div>
								<div class="col-md-3">
									<form:textarea rows="3" cols="10" class="form-control" name="comments" path ="comments" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="attachmentId">Attachment</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path ="attachmentId" name="attachmentId"/>
										<!-- placeholder="Enter Attachment" autocomplete="off" /> -->
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<br /> <br />
								<div class="col-md-6" style="text-align: right">
									<button class="btn btn-info" id ="processorFormSubmit">
										Submit</button>
								</div>
								<div class="col-md-2">
									<button class="btn btn-info" id ="processorFormReset"
										type="reset" value="Cancel" > Cancel</button>
								</div>
							</div>
						</div>
						<%-- <div class="hideElements">
							<form:input type="hidden" path ="requesterId" value="${employee.requesterID}" /> 
							<form:input type="hidden" path ="processorId" value="${employee.processorID}" />
							<form:input type="hidden" path ="empProjId" value="${employee.id}" />
							<form:input type="hidden" path ="name" value="${employee.name}" />
							<form:input type="hidden" path ="releaseStatus" />
						</div> --%>
					</div>
				</div>
			</form:form>
		</div>
		<span id ="messageDiv" class="hideElements"> </span>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
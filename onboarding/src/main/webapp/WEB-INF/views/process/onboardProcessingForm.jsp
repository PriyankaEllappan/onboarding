<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<script src="/onboarding/resources/scripts/process.js"></script>
<script src="/onboarding/resources/scripts/application.js"></script>
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="container-fluid content-style">
		<span class="has-error" id="errMessage">${errMessage}</span> <span
			class="is-success" id="statusSucessMessage"></span>
		<div id="formDiv">
			<div class="tab">
				<button class="tablinks"
					onclick="openSpecificTab(event, 'basicInfo')" id="empTab">Employee
					Details</button>
				<button class="tablinks"
					onclick="openSpecificTab(event, 'projInfo')" id="projTab">Project
					Details</button>
				<button class="tablinks"
					onclick="openSpecificTab(event, 'customerInfo')" id="custTab">Customer
					Details</button>
			</div>
			<form:form name="projectRegisterForm" method="post"
				action="/onboarding/process/onboard" modelAttribute="employee"
				enctype="multipart/form-data">
				<div id="basicInfo" class="tabcontent">
					<div class="resizeTabCont">
						<br>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="employeeId">Employee Id</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="employeeId"
										path="employeeId" readonly="true" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="email">Email</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path="email" name="email"
										readonly="true" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="firstName">First Name</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path="firstName"
										name="firstName" readonly="true" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="lastName">Last Name</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path="lastName"
										name="lastName" readonly="true" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="dateOfBirth">Date Of Birth</form:label>
								</div>
								<div class="col-md-3">
									<form:input autocomplete="off" class="form-control"
										name="dateOfBirth" path="dateOfBirth" readonly="true" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="passportNumber">Passport ID/SSN No</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="passportNumber"
										path="passportNumber" readonly="true" />
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-11"></div>
						<div class="col-md-1">
							<ul class="nav nav-pills">
								<li class="active"
									onclick="openSpecificTabNext(event, 'projInfo')"><a
									href="#">Next >></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div id="projInfo" class="tabcontent">
					<div class="resizeTabCont">
						<br>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="teamName">Team Name</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path="teamName"
										name="teamName" readonly="true" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="startDate">Start Date</form:label>
								</div>
								<div class="col-md-3">
									<form:input autocomplete="off" class="form-control"
										name="startDate" path="startDate" readonly="true" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="projectId">Project ID</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path="projectId"
										name="projectId" readonly="true" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="projectName">Project Name</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path="projectName"
										name="projectName" readonly="true" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="requesterName">Requester</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path="requesterName"
										name="requesterName" readonly="true" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="processorName">Processor</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="processorName"
										path="processorName" readonly="true" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="countryName">Country</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="countryName"
										path="countryName" readonly="true" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="location">Location</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="location"
										path="location" readonly="true" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="role">Role</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="role" path="role"
										readonly="true" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="rate">Rate</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="rate" path="rate"
										readonly="true" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="skillSet">Skill</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="skillSet"
										path="skillSet" readonly="true" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="skillSummary">Skill Summary</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="skillSummary"
										path="skillSummary" readonly="true" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="experience">Experience</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="experience"
										path="experience" readonly="true" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="movementId">Movement</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="movementId"
										path="movementId" readonly="true" />
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-11"></div>
						<div class="col-md-1">
							<ul class="nav nav-pills">
								<li class="active"
									onclick="openSpecificTabNext(event, 'customerInfo')"><a
									href="#">Next >></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div id="customerInfo" class="tabcontent">
					<div class="resizeTabCont">
						<br>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="bsaName">BSA</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path="bsaName" name="bsaName"
										readonly="true" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="band">Band</form:label>
								</div>
								<div class="col-md-3">
									<form:select class="form-control" name="band" path="band">
										<form:option value="" label="Select" selected="true"
											disabled="true" />
									</form:select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="pplManager">Customer PPL</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" name="pplManager"
										path="pplManager" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="apm">APM</form:label>
								</div>
								<div class="col-md-3">
									<form:input autocomplete="off" class="form-control" name="apm"
										path="apm" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="nationwideId">Nationwide ID</form:label>
								</div>
								<div class="col-md-3">
									<form:input class="form-control" path="nationwideId"
										name="nationwideId" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="nationwideIdCreatedDate">Nationwide ID Created Date</form:label>
								</div>
								<div class="col-md-3">
									<form:input autocomplete="off" class="form-control load-date-picker"
										name="nationwideIdCreatedDate" path="nationwideIdCreatedDate" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="workForceId">Workforce Id</form:label>
								</div>
								<div class="col-md-3">
									<form:input autocomplete="off" class="form-control"
										name="workForceId" path="workForceId" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="scrumMaster">Scrum Master</form:label>
								</div>
								<div class="col-md-3">
									<form:input autocomplete="off" class="form-control"
										name="scrumMaster" path="scrumMaster" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="approvalStatus">Approval Status</form:label>
								</div>
								<div class="col-md-3">
									<form:select class="form-control" name="approvalStatus"
										path="approvalStatus">
										<form:option value="" label="Select" selected="true"
											disabled="true" />
									</form:select>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="fgOnBoardingDate">FG Onboarding Date</form:label>
								</div>
								<div class="col-md-3">
									<form:input autocomplete="off" class="form-control load-date-picker"
										name="fgOnBoardingDate" path="fgOnBoardingDate" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<form:label path="comments">Comments</form:label>
								</div>
								<div class="col-md-3">
									<form:textarea rows="3" cols="10" class="form-control"
										name="comments" path="comments" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<form:label path="attachment">Attachment</form:label>
								</div>
								<div class="col-md-3">
									<form:input path="attachment" type="file" name="attachment"
										size="60" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<br />
								<div class="col-md-6" style="text-align: right">
									<input class="btn btn-submit" type="submit"
										onclick="return validateForm()" id="processorFormSubmit"
										value="Submit">
								</div>
								<div class="col-md-2">
									<button class="btn btn-submit" id="processorFormReset"
										type="reset" value="Cancel">Cancel</button>
								</div>
							</div>
						</div>
						<div class="hideElements">
							<form:input type="hidden" path="id" />
							<form:input type="hidden" path="movementId" />
							<form:input type="hidden" path="releaseStatusId" />
							<form:input type="hidden" path="approvalStatusId" />
							<form:input type="hidden" path="releaseStatus" />
							<form:input type="hidden" path="reasonForOffboarding" />
							<form:input type="hidden" path="name" />
							<form:input type="hidden" path="countryId" />
							<form:input type="hidden" path="roleId" />
							<form:input type="hidden" path="teamId" />
							<form:input type="hidden" path="requesterId" />
							<form:input type="hidden" path="processorId" />
							<form:input type="hidden" path="movement" />
							<form:input type="hidden" path="fileName" />
							<form:input type="hidden" path="fileData" />
							<form:input type="hidden" path="bandId" />
							<form:input type="hidden" path="projectMappingId" />
							<form:input type="hidden" path="onboardRequester" />
							<form:input type="hidden" path="offboardRequester" />
							<form:input type="hidden" path="offboardProcessor" />
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
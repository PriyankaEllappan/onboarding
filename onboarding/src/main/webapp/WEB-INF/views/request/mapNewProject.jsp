<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<script src="/onboarding/resources/scripts/assignProject.js"></script>
<script src="/onboarding/resources/scripts/application.js"></script>
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="container-fluid content-style">
		<span class="has-error" id="errMessage"></span> <span
			class="is-success" id="statusSucessMessage"></span> <br>
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
			<form name="projectRegisterForm" method="post">
				<div id="basicInfo" class="tabcontent">
					<div class="resizeTabCont">
						<br>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label for="newEmpID">Employee Id</label>
								</div>
								<div class="col-md-3">
									<input class="form-control" name="newEmpID" id="newEmpID"
										placeholder="Enter EmployeeID" value="${employee.employeeId}"
										readonly autocomplete="off" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<label for="newEmpEmail">Email</label>
								</div>
								<div class="col-md-3">
									<input class="form-control" id="newEmpEmail" name="newEmpEmail"
										placeholder="Enter Email Id" value="${employee.email}"
										readonly autocomplete="off" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label for="newEmpFName">First Name</label>
								</div>
								<div class="col-md-3">
									<input class="form-control" id="newEmpFName" name="newEmpFName"
										placeholder="Enter First Name" value="${employee.firstName}"
										readonly autocomplete="off" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<label for="newEmpLName">Last Name</label>
								</div>
								<div class="col-md-3">
									<input class="form-control" id="newEmpLName" name="newEmpLName"
										placeholder="Enter Last Name" value="${employee.lastName}"
										readonly autocomplete="off" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label for="newEmpDOB">Date Of Birth</label>
								</div>
								<div class="col-md-3">
									<input autocomplete="off" class="form-control" name="newEmpDOB"
										id="newEmpDOB" value="${employee.dateOfBirth}"
										placeholder="Enter Date of Birth (YYYY-MM-DD)" readonly
										autocomplete="off" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<label for="newEmpPPNo">Passport ID No*</label>
								</div>
								<div class="col-md-3">
									<input class="form-control" name="newEmpPPNo" id="newEmpPPNo"
										placeholder="Enter Passport No"
										value="${employee.passportNumber}" readonly autocomplete="off" />
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-11"></div>
						<div class="col-md-1">
							<ul class="nav nav-pills">
								<li class="active" onclick="openSpecificTabNext(event, 'projInfo')"><a href="#">Next >></a></li>
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
									<label for="projectName">Project Name<span
										class="is-required"> *</span></label>
								</div>
								<div class="col-md-3">
									<select class="form-control" name="projectName"
										id="projectName">
										<option value="" selected disabled>Select</option>
									</select>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<label for="projectID">Project ID</label>
								</div>
								<div class="col-md-3">
									<input class="form-control" id="projectID" name="projectID"
										placeholder="Enter Project ID" readonly autocomplete="off" />
									<input class="form-control" type="hidden" id="projectMapID"
										name="projectMapID" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label for="requester">Requester</label>
								</div>
								<div class="col-md-3">
									<input class="form-control" id="requester" name="requester"
										placeholder="Enter Requester Name" readonly autocomplete="off" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<label for="processor">Processor</label>
								</div>
								<div class="col-md-3">
									<input class="form-control" name="processor" id="processor"
										placeholder="Enter Processor Name" readonly autocomplete="off" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label for="teamName">Team Name<span
										class="is-required"> *</span></label>
								</div>
								<div class="col-md-3">
									<input list="teamName" id="teamList" class="form-control"
										autocomplete="off" name="teamName" />
									<datalist id="teamName"></datalist>
									<!-- <select class="form-control" name="teamName" id="teamName"
										></select> -->
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<label for="startDate">Start Date<span
										class="is-required"> *</span></label>
								</div>
								<div class="col-md-3">
									<input autocomplete="off" class="form-control load-date-picker" name="startDate"
										id="startDate" placeholder="Enter Start Date (YYYY-MM-DD)" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label for="country">Country<span class="is-required">
											*</span></label>
								</div>
								<div class="col-md-3">
									<select class="form-control" name="country" id="country">
										<option value="" selected disabled>Select</option>
									</select>

								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<label for="location">Location</label>
								</div>
								<div class="col-md-3">
									<input class="form-control" name="location" id="location"
										placeholder="Enter Location" readonly autocomplete="off" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label for="role">Role<span class="is-required">
											*</span></label>
								</div>
								<div class="col-md-3">
									<select class="form-control" name="role" id="role">
										<option value="" selected disabled>Select</option>
									</select>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<label for="rate">Rate</label>
								</div>
								<div class="col-md-3">
									<input class="form-control" name="rate" id="rate"
										placeholder="Enter Rate value" readonly autocomplete="off" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label for="skill">Skill<span
										class="is-required"> *</span></label>
								</div>
								<div class="col-md-3">
									<input class="form-control" name="skill" id="skill"
										placeholder="Enter Skills" autocomplete="off" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<label for="skillSummary">Skill Summary<span
										class="is-required"> *</span></label>
								</div>
								<div class="col-md-3">
									<input class="form-control" name="skillSummary"
										id="skillSummary" placeholder="Enter Skill Summary"
										autocomplete="off" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label for="experience">Experience<span
										class="is-required"> *</span></label>
								</div>
								<div class="col-md-3">
									<input class="form-control" type="number" name="experience"
										id="experience" placeholder="Enter Experience in years"
										autocomplete="off" />
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<label for="movementID">Movement</label>
								</div>
								<div class="col-md-3">
									<select class="form-control" name="movementID" id="movementID">
										<option value="" selected disabled>Select</option>
									</select>
								</div>
							</div>
						</div>
						<span class="is-required"> *</span> Fields are mandatory
					</div>
					<div class="row">
						<div class="col-md-11"></div>
						<div class="col-md-1">
							<ul class="nav nav-pills">
								<li class="active" onclick="openSpecificTabNext(event, 'customerInfo')"><a href="#">Next >></a></li>
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
									<label for="bsaInfo">BSA<span
										class="is-required"> *</span></label>
								</div>
								<div class="col-md-3">
									<select class="form-control" id="bsaInfo" name="bsaInfo">
										<option value="" selected disabled>Select</option>
									</select>										
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<label for="pplInfo">Customer PPL</label>
								</div>
								<div class="col-md-3">
									<input class="form-control" name="pplInfo" id="pplInfo"
										placeholder="Enter PPL Info" autocomplete="off" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<br /> <br />
								<div class="col-md-6" style="text-align: right">
									<button class="btn btn-submit" id="projectRegisterFormSubmit">
										Submit</button>
								</div>
								<div class="col-md-2">
									<input class="btn btn-submit" id="projectRegisterFormReset"
										type="reset" value="Cancel" />
								</div>
							</div>
						</div>
					</div>
				</div>
					<input type="hidden" value="0" id="teamMappingID" /> <input
						type="hidden" id="roleMappingID" /> <input type="hidden"
						id="roleID" /> <input type="hidden" id="countryMappingID" /> <input
						type="hidden" id="processorID" /> <input type="hidden"
						id="requesterID" /> <input type="hidden" id="approvalStatus" />
					<input type="hidden" id="releaseStatusId" /> <input type="hidden"
						id="name" value="${employee.name}" />

			</form>
		</div>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<script src="/onboarding/resources/scripts/requester.js"></script>
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="container-fluid content-style">
		<h1>Check for User Availability</h1>
		<label for="checkEmpId"> Search for an existing Employee</label> <input
			type="text" id="checkEmpId" name="checkEmpId"></input>
		<button type="submit" id="checkEmpIdSubmit">Check</button>
		<br> <br> <br> <span id="registerStatus"
			class="hideElements"></span>
		<div id="resourceNonAvailable" class="hideElements">
			<p>Requested resource is not available in Nationwide Account</p>
			<div id="addResourceLabel">
				<span style="cursor: pointer;">Click here</span> to add the resource
			</div>
			<br>
			<div id="toggleResource" class="hideElements">
			<div class="resizeTabCont">
				<form name="resourceRegisterForm" method="post">
					<div class="form-group">
						<div class="row">
							<div class="col-md-2">
								<label for="newEmpID">Employee Id</label>
							</div>
							<div class="col-md-3">
								<input class="form-control" name="newEmpID" id="newEmpID"
									placeholder="Enter EmployeeID" />
							</div>
							<div class="col-md-1"></div>
							<div class="col-md-2">
								<label for="newEmpEmail">Email</label>
							</div>
							<div class="col-md-3">
								<input class="form-control" id="newEmpEmail" name="newEmpEmail"
									placeholder="Enter Email Id" readonly autocomplete="off" />
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
									placeholder="Enter First Name" readonly autocomplete="off" />
							</div>
							<div class="col-md-1"></div>
							<div class="col-md-2">
								<label for="newEmpLName">Last Name</label>
							</div>
							<div class="col-md-3">
								<input class="form-control" id="newEmpLName" name="newEmpLName"
									placeholder="Enter Last Name" readonly autocomplete="off" />
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
									id="newEmpDOB" placeholder="Enter Date of Birth (YYYY-MM-DD)" />
								<span class="has-error hideElements" id="dateOfBirthErr">
								</span>
							</div>
							<div class="col-md-1"></div>
							<div class="col-md-2">
								<label for="newEmpPPNo">Passport ID No*</label>
							</div>
							<div class="col-md-3">
								<input class="form-control" name="newEmpPPNo" id="newEmpPPNo"
									placeholder="Enter Passport No" /> <span
									class="has-error hideElements" id="passportNoErr"> </span>
							</div>
						</div>
					</div>
					<div class="form-group hideElements">
						<div class="row">
							<div class="col-md-2">
								<label for="newEmpName">Employee Name</label>
							</div>
							<div class="col-md-3">
								<input class="form-control" id="newEmpName" name="newEmpName"
									placeholder="Enter Employee Name" readonly autocomplete="off" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="row">
							<br /> <br />
							<div class="col-md-10" style="text-align: center">
								<button class="btn btn-info" id="resourceRegisterFormSubmit">
									Submit</button>
								<input class="btn btn-info" id="resourceRegisterFormReset"
									type="reset" value="Cancel" />
							</div>
						</div>
					</div>
				</form>
				</div>
			</div>
		</div>
		<div id="resourceAvailable" class="hideElements">
			<p>Requested resource already available in Nationwide Account</p>
			<div id="availableResourceDetails">
				<table>
					<tr>
						<th>Employee ID</th>
						<th>Employee Name</th>
						<th>Date of Birth</th>
						<th>Email</th>
						<th>Passport Number</th>
					</tr>
					<tr>
						<td><span id="availEmpID"></span></td>
						<td><span id="availEmpName"></span></td>
						<td><span id="availEmpDOB"></span></td>
						<td><span id="availEmpEmail"></span></td>
						<td><span id="availEmpPPNo"></span></td>
					</tr>
				</table>
				<br> <br>
				<div id="addProjectLabel">
					<span style="cursor: pointer;">Click here</span> to tag an project
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
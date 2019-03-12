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
		<h4>Check for User Availability</h4>
		<label for="checkEmpId"> Search for an existing Employee</label> <input
			type="text" id="checkEmpId" name="checkEmpId"></input>
		<button type="submit" id="checkEmpIdSubmit" style="cursor: pointer;">Check</button>
		<br> <span class="has-error" id="errMessage"></span> <span
			class="is-success" id="statusSucessMessage"></span>
		<div class="resizeTabCont" id="resourceNonAvailable">
			<br> <br>
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
						</div>
						<div class="col-md-1"></div>
						<div class="col-md-2">
							<label for="newEmpPPNo">Passport ID / SSN No</label>
						</div>
						<div class="col-md-3">
							<input class="form-control" name="newEmpPPNo" id="newEmpPPNo"
								placeholder="Enter last 4 digits of Passport/SSN No" />
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
		<div id="resourceAvailable">
			<br> <br>
			<table class="resizeTabCont table table-striped">
				<thead>
					<tr>
						<th>Employee ID</th>
						<th>Employee Name</th>
						<th>Date of Birth</th>
						<th>Email</th>
						<th>Passport Number</th>
					</tr>
				</thead>
				<tr>
					<td><span id="availEmpID"></span></td>
					<td><span id="availEmpName"></span></td>
					<td><span id="availEmpDOB"></span></td>
					<td><span id="availEmpEmail"></span></td>
					<td><span id="availEmpPPNo"></span></td>
				</tr>
			</table>
			<br> <br>
			<p id="checkForActiveAssignment">
				<span id="activeCheck" style="cursor: pointer;">Click</span>
				to check for any active assignments
			</p>
			<p id="NoActiveAssignment">
				No active assignments available for the requested employee. <span
					id="NoActiveSubmit" style="cursor: pointer;">Click</span> to
				tag an project
			</p>
		</div>
	</div>
	<!-- Resource Non Availability Modal -->
	<div class="modal fade" id="NoResourceModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<br>
					<p>Requested resource is not available in Nationwide Account.
						Click OK to add the resource</p>
					<br>
					<div align="right">
						<button type="button" class="btn btn-primary"
							id="confirmAddResource" data-dismiss="modal">OK</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Active Assignment Non Availability Modal -->
	<div class="modal fade" id="ActiveAssignment" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<br>
					<p>Requested resource is tagged under below project. Do you
						wish to tag a new project</p>
					<br>
					<table class="resizeTabCont table table-striped" id="availableProjects">
						<thead>
							<tr>
								<th>Project ID</th>
								<th>Project Name</th>
							</tr>
						</thead>
					</table>
					<div id="projTagConf">
						<div align="right">
							<button type="button" class="btn btn-primary" id="confirmTagging">YES</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">No</button>
						</div>
					</div>
					<div id="projTagDiv">
						<p>Is this an internal project movement?</p>
						<label class="radio-inline"> <input
							type="radio" name="projMovement" id="projMovement1" value="yes">
							Yes
						</label> <label class="radio-inline"> <input type="radio"
							name="projMovement" id="projMovement2" value="no"> No
						</label><br>
						<div align="right">
							<button type="button" class="btn btn-primary"
								id="confirmAddProject" data-dismiss="modal">Submit</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cancel</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
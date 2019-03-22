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
		<br> <span class="has-error" id="errMessage"></span> <span
			class="is-success" id="statusSucessMessage"></span> <br> <br>
		<label for="checkEmpId"> Enter Employee ID: </label> <input
			type="text" id="checkEmpId" name="checkEmpId"></input>
		<img class="icon-image to-click" id="checkEmpIdSubmit" style="cursor: pointer;" src="/onboarding/resources/icons/search.png">
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
								placeholder="Enter EmployeeID" readonly autocomplete="off" />
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
							<button class="btn btn-submit" id="resourceRegisterFormSubmit">
								Submit</button>
							<input class="btn btn-submit" id="resourceRegisterFormReset"
								type="reset" value="Cancel" />
						</div>
					</div>
				</div>
			</form>
		</div>
		<div id="resourceAddedSubmit">
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
					<td><span id="addedResEmpID"></span></td>
					<td><span id="addedResEmpName"></span></td>
					<td><span id="addedResEmpDOB"></span></td>
					<td><span id="addedResEmpEmail"></span></td>
					<td><span id="addedResEmpPPNo"></span></td>
				</tr>
			</table>
			<br> <br>
			<button type="button" class="btn btn-primary"
				id="nonAvailableAssignProj" style="align: right">Assign
				Project</button>
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
			<button type="button" class="btn btn-primary"
				id="availableAssignProj" style="align: right">Assign
				Project</button>
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
					<table class="resizeTabCont table .table-borderless"
						id="availableProjects">
						<thead>
							<tr>
								<th>Name</th>
								<th>Project Name</th>
								<th>Team Name</th>
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
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
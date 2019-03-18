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
	href="/onboarding/resources/stylesheets/application.css">
<!-- Load Script Files -->
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
<script src="/onboarding/resources/scripts/releaselist.js"></script>
<script src="/onboarding/resources/scripts/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/bootstrap-datepicker.min.css">
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<!-- <div id="navbar">
			<ul class="nav navbar-nav navbar-left">
				<li class="active"><a href="/onboarding">Back to home</a></li>
			</ul>
		</div> -->
		<div class="form-group">
			<div class="row">
				<br>
				<br>
				<div class="col-md-1">
					<label for="teamName">Team Name</label>
				</div>
				<div class="col-md-2">
					<select class="form-control" name="teamName" id="teamName">
						<option value="" selected disabled>Select</option>
					</select>
				</div>
				<div class="col-md-1">
					<br>
					<br>
				</div>
			</div>
		</div>
		<div id="releaseTeamDropDown">
			<div class="form-group">
				<div class="row">
					<div class="col-md-1">
						<label for="releaseStatus">Release Status</label>
					</div>
					<div class="col-md-2">
						<select class="form-control" name="releaseStatus"
							id="releaseStatus">
							<option value="" selected disabled>Select</option>
						</select>
					</div>
					<div class="col-md-1">
						<label for="releaseSummary">Release Summary</label>
					</div>
					<div class="col-md-2">
						<select class="form-control" name="releaseSummary"
							id="releaseSummary">
							<option value="" selected disabled>Select</option>
						</select>
					</div>
					<div class="col-md-1">
						<label for="releaseDate">Release Date</label>
					</div>
					<div class="col-md-2">
						<input autocomplete="off" class="form-control" name="releaseDate"
							id="releaseDate" />
					</div>
					<div class="col-md-1" style="text-align: right">
						<button class="btn btn-info" id="teamSubmit">Submit</button>
					</div>
				</div>
			</div>
			<table class="table table-striped" id="releaseTeamTable">
				<thead>
					<tr>
						<th>Employee Id</th>
						<th>Employee Name</th>
						<th>Project Id</th>
						<th>Project Name</th>
						<th>Team Name</th>
					</tr>
				</thead>
				</tbody>
			</table>
		</div>
		<div><span id="statusMessage"> </span></div>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
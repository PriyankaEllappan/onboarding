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
<link rel="stylesheet" href="/onboarding/resources/stylesheets/bootstrap-datepicker.min.css">

<!-- Load Script Files -->
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
<script src="/onboarding/resources/scripts/releaselist.js"></script>
<script src="/onboarding/resources/scripts/bootstrap-datepicker.min.js"></script>
<script src="/onboarding/resources/scripts/application.js"></script>

</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<div class="row">
			<div class="col-md-4" align="center"></div>
			<div class="col-md-4" align="center">
				<h4><b> Offboarding Resources - By Project</b></h4>
			</div>
			<div class="col-md-2" align="center"></div>
			<div class="col-md-2" align="center"></div>
		</div>
		<span class="has-error" id="errMessage"></span> <span
			class="is-success" id="statusSucessMessage"></span><br>
		<br>
		<div id="offboardByProj">
			<div class="form-group">
				<div class="row">
					<div class="col-md-2">
						<label for="projectName">Project Name</label>
					</div>
					<div class="col-md-3">
						<select class="form-control" name="projectName" id="projectName">
							<option value="" selected disabled>Select</option>
						</select>
					</div>
					<div class="col-md-1"></div>
				</div>
			</div>
			<div id="releaseProjDropDown">
				<div class="form-group">
					<div class="row">
						<div class="col-md-1">
							<label for="releaseStatus">Release Status<span class="is-required"> *</span></label>
						</div>
						<div class="col-md-2">
							<select class="form-control" name="releaseStatus"
								id="releaseStatus">
								<option value="" selected disabled>Select</option>
							</select>
						</div>
						<div class="col-md-1">
							<label for="releaseSummary">Release Summary<span class="is-required"> *</span></label>
						</div>
						<div class="col-md-2">
							<select class="form-control" name="releaseSummary"
								id="releaseSummary">
								<option value="" selected disabled>Select</option>
							</select>
						</div>
						<div class="col-md-1">
							<label for="releaseDate">Release Date<span class="is-required"> *</span></label>
						</div>
						<div class="col-md-2">
							<input autocomplete="off" class="form-control load-date-picker"
								name="releaseDate" id="releaseDate" />
						</div>
						<div class="col-md-1" style="text-align: right">
							<button class="btn btn-submit" id="projectSubmit">Submit</button>
						</div>
					</div>
				</div>
				<table class="table table-striped bordered" id="releaseProjTable">
					</tbody>
				</table>
			</div>
		</div>
		<div id="statusMessage"></div>
	</div>

	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
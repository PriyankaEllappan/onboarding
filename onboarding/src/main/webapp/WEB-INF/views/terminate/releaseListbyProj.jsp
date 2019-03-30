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
		<span class="has-error" id="errMessage"></span> 
		<span class="is-success" id="statusSucessMessage"></span><br><br> 
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
							<input autocomplete="off" class="form-control load-date-picker" name="releaseDate"
								id="releaseDate" />
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
		<div  id="statusMessage" ></div>
	</div>

	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
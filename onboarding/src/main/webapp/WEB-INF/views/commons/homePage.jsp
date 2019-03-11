<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
		<div class="row">
			<div class="col-xs-8">
				<h3>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome <span style="color: #161892">${userName}</span>
				</h3>
			</div>
		</div>
		<br> <br>
		<div style="margin-left: 61px;">
			<div class="row">
				<div class="col-xs-3"></div>
				<div class="col-xs-3">
					<button class="btn btn-info button-fixedwidth"
						onclick="location.href='/onboarding/request/add'">Resource
						onboarding</button>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-5">
					<br>
				</div>
			</div>
			<div class="row">
			<div class="col-xs-3"></div>
				<div class="col-xs-3">
					<button class="btn btn-info button-fixedwidth"
						onclick="location.href='/onboarding/process'">Process
						onboarding</button>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-5">
					<br>
				</div>
			</div>
			<div class="row">
			<div class="col-xs-3"></div>
				<div class="col-xs-3">
					<button class="btn btn-info button-fixedwidth"
						onclick="location.href='/onboarding/terminate'">Terminate
						a resource</button>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-5">
					<br>
				</div>
			</div>
			<div class="row">
			<div class="col-xs-3"></div>
				<div class="col-xs-3">
					<button class="btn btn-info button-fixedwidth"
						onclick="location.href='/onboarding/request'">List of
						resources</button>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-5">
					<br>
				</div>
			</div>
			<div class="row">
			<div class="col-xs-3"></div>
				<div class="col-xs-3">
					<button class="btn btn-info button-fixedwidth"
						onclick="location.href='/onboarding/project'">Project
						Details</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Load Script Files -->
	<script src="/onboarding/resources/scripts/jquery.min.js"></script>
	<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
	<script src="/onboarding/resources/scripts/application.js"></script>
	<script src="/onboarding/resources/scripts/bootstrap-datepicker.min.js"></script>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>

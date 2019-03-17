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
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<h2>Active Resources</h2>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-left">
				<li class="active"><a href="/onboarding">Back to home</a></li>
			</ul>
		</div>
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
		<table class="table table-striped" id="releaseProjTable">
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

	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
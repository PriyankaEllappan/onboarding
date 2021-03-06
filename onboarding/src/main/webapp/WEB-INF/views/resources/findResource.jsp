<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource Onboarding</title>
<!-- Load Sytle Sheets -->
<link rel="stylesheet" href="/onboarding/resources/stylesheets/bootstrap.min.css">
<link rel="stylesheet" href="/onboarding/resources/stylesheets/bootstrap-datepicker.min.css">
<link rel="stylesheet" href="/onboarding/resources/stylesheets/application.css">
<!-- Load Scripts -->
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap-datepicker.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
<script src="/onboarding/resources/scripts/findResource.js"></script>
<script src="/onboarding/resources/scripts/application.js"></script>
</head>

<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="container-fluid content-style">
		<div class="row">
			<div class="col-md-4" align="center"></div>
			<div class="col-md-4" align="center">
				<h4><b>Search - Resource Details</b></h4>
			</div>
			<div class="col-md-2" align="center"></div>
			<div class="col-md-2" align="center"></div>
		</div>
		<br> <span class="has-error" id="errMessage"></span> <span
			class="is-success" id="statusSucessMessage"></span> <br> <br>
		<label for="findEmpId"> Enter Employee ID: </label> <input
			type="text" id="findEmpId" name="findEmpId"></input> <img
			class="icon-image to-click" id="findEmpIdSubmit"
			style="cursor: pointer;" src="/onboarding/resources/icons/search.png">
		<div id="resourceAvailable">
			<br> <br>
			<table id="releaseTable" class="table table-striped bordered">
				</tbody>
			</table>
			<br> <br>
		</div>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
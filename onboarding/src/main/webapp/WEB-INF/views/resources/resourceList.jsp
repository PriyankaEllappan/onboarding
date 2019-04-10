<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource Onboarding</title>
<!-- Load Sytle Sheets -->
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/bootstrap.min.css">
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/application.css">

<!-- Load Scripts -->
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
</head>

<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<div class="row">
			<div class="col-md-4" align="center"></div>
			<div class="col-md-4" align="center">
				<h4>
					<b>Resources List</b>
				</h4>
				<br>
			</div>
			<div class="col-md-2" align="center"></div>
			<div class="col-md-2" align="center"></div>
		</div>
		<table class="table table-striped bordered">
		</table>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
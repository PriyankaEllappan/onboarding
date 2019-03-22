<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<style type="text/css">
</style>
<head>
<title>Login Page</title>
<!-- Load Sytle Sheets -->
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/bootstrap.min.css">
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/application.css">
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<div class="row">
		<br> <br>
			<div class="col-md-5" align="right">
				<h3 class="has-error">You don't have access to view this page.</h3>
			</div>
			<div class="col-md-4">
			<br>
				<button class="btn-info" onclick="location.href='/onboarding'">Back
					to Home</button>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>
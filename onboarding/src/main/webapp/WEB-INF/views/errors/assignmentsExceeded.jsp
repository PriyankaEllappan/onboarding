<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<html>
<head>
<title>Resource Onboarding</title>
<!-- Load Sytle Sheets -->
<link rel="stylesheet" href="/onboarding/resources/stylesheets/bootstrap.min.css">
<link rel="stylesheet" href="/onboarding/resources/stylesheets/application.css">
</head>
<body>
	<div class="content-style">
		<div class="row">
			<br> <br>
			<div class="col-md-7" align="right">
				<h3 class="has-error">Resource is already mapped to two
					projects.</h3>
			</div>
			<div class="col-md-2">
				<br>
				<button class="btn-info" onclick="location.href='/onboarding'">Back
					to Home</button>
			</div>
			<div class="col-md-3"></div>
		</div>
		<div class="row">
			<br> <br>
			<div class="col-md-7">
				<div>${ errMessage }</div>
			</div>
		</div>
	</div>
</body>
</html>
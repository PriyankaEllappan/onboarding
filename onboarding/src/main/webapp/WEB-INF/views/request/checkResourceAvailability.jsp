<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource Availability</title>
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/requester.js"></script>
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/application.css">
</head>
<body>
	<h1>Check for User Availability</h1>
	<label for="checkEmpId"> Search for an existing Employee</label>
	<input type="text" id="checkEmpId" name="checkEmpId"></input>
	<button type="submit" id="checkEmpIdSubmit">Check</button>
	<br>
	<br>
	<br>
	<div id="resourceNonAvailable" class="hideElements">
		<div id="addResourceLabel">Add a resource</div>
		<div id="toggleResource" class="hideElements">Toggled Resource
			Screen</div>
	</div>
	<div id="resourceAvailable" class="hideElements">
		<div id="addProjectLabel">Add a Project</div>
		<div id="toggleProject" class="hideElements">Toggled Project
			Screen</div>
	</div>
</body>
</html>
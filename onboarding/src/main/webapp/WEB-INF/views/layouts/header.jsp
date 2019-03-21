<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<style>
.header-button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 7px 32px;
	text-align: center;
	font-size: 16px;
	margin-top: 20px;
	opacity: 0.6;
	transition: 0.3s;
	display: inline-block;
	text-decoration: none;
	cursor: pointer;
	width: 7em;  height: 2em;
}

.header-button:hover {
	opacity: 1
}
</style>
</head>

<div class="row header-style">
	<div class="col-md-1">
		<img class="logo-style"
				src="/onboarding/resources/images/cognizantLogo.png"
				alt="Cognizant Logo">
	</div>
	<div class="col-md-3">
	<button onclick="location.href='/onboarding'" class="header-button" >HOME</button>
	</div>
	<div class="col-md-5 header-text" align="left">
		<br>
		<p>Nationwide Resource Onboarding</p>
	</div>
	<div class="col-md-2 welcome-text" align="right" style="color:white;">
		<c:if test="${not empty appInfo.loggedInUser}">
			<br>
			<br>
			<p>Welcome ${appInfo.loggedInUser}</p>
		</c:if>
	</div>
	<div class="col-md-1" ></div>
</div>


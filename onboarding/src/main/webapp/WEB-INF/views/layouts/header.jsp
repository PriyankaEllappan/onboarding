<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<style>
.header-image {
	/* background-color: #4CAF50;
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
	width: 7em;  height: 2em; */
	width: 45px;
	padding-top: 15px;
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
	<div class="col-md-7 header-text" align="left">
		<br>
		<p>Nationwide Resource Onboarding</p>
	</div>
	<div class="col-md-3 welcome-text" style="color: white;">
		<c:if test="${not empty appInfo.loggedInUserName}">
			<br>
			<p>
				Welcome <span>${appInfo.loggedInUserName} </span> 
				<br> <span style="font-size: 12px;"> Logged in Role:
				${appInfo.loggedInUserRole}</span>
			</p>
		</c:if>
	</div>
	<div class="col-md-1">
		<img class="to-click header-image"
			onclick="location.href='/onboarding'"
			src="/onboarding/resources/icons/homeIcon.png">
		<!-- <button onclick="location.href='/onboarding'" class="header-button" >HOME</button> -->
	</div>
</div>


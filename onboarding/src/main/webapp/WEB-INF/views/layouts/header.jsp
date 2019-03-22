<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<script>
	function goBack() {
		window.history.back();
	}
</script>
</head>
<div class="row header-style">
	<div class="col-md-1">
		<img class="logo-style"
			src="/onboarding/resources/images/cognizantLogo.png"
			alt="Cognizant Logo">
	</div>
	<div class="col-md-7 header-text" align="center">
		<br>
		<p>Nationwide Resource Onboarding</p>
	</div>
	<div class="col-md-2 welcome-text" style="color: white;">
		<c:if test="${not empty appInfo.loggedInUserName}">
			<br>
			<p style="font-size: 13px;">
				Welcome ${appInfo.loggedInUserName} <br> Logged in Role: <span
					style="font-size: 11px;"> ${appInfo.loggedInUserRole}</span>
			</p>
		</c:if>
	</div>
	<div class="col-md-1">
	<img class="to-click header-imageback"
			onclick="goBack()"
			src="/onboarding/resources/icons/backIcon.png">
	</div>
	<div class="col-md-1">
		<img class="to-click header-image"
			onclick="location.href='/onboarding'"
			src="/onboarding/resources/icons/homeIcon.png">
	</div>
</div>


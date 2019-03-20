<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row header-style">
	<div class="col-md-1" align="right">
		<div style="float: left">
			<img class="logo-style"
				src="/onboarding/resources/images/cognizantLogo.png"
				alt="Cognizant Logo">
		</div>
	</div>
	<div class="col-md-2">
		<div style="padding-top:40px;">
			<img class="to-click" style="height: 35px;" src="/onboarding/resources/icons/homeIcon.png" onclick="location.href='/onboarding'">
		</div>
	</div>
	<div class="col-md-5 header-text" align="left">
		<br>
		<p>Nationwide Resource Onboarding</p>
	</div>
	<div class="col-md-3 welcome-text" align="right">
		<c:if test="${not empty appInfo.loggedInUser}">
			<br>
			<br>
			<p>Welcome ${appInfo.loggedInUser}</p>
		</c:if>
	</div>
	<div class="col-md-1" ></div>
</div>


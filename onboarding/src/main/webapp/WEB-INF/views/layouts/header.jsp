<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row header-style">
	<div class="col-md-4" align="right">
		<div style="float: left">
			<a href="/onboarding"> <img class="logo-style"
				src="/onboarding/resources/images/cognizantLogo.png"
				alt="Cognizant Logo"></a>
		</div>
	</div>
	<div class="col-md-5 header-text" align="left">
		<br>
		<p>Onboarding Resources</p>
	</div>
	<div class="col-md-3 welcome-text" align="left">
		<c:if test="${not empty appInfo.loggedInUser}">
			<br>
			<br>
			<p>Welcome ${appInfo.loggedInUser}</p>
		</c:if>

	</div>
</div>


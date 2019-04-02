<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header-section">
	<div class="header-banner">
		<div class="row">
			<div class="col-md-1">
				<img class="logo-style"
					src="/onboarding/resources/images/cognizantLogo.png"
					alt="Cognizant Logo">
			</div>
			<div class="col-md-7" align="center">
				<!-- <br>
				<p>Nationwide Resource Onboarding</p> -->
				<img class="header-title"
					src="/onboarding/resources/images/headerText.png">
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
			<div class="col-md-2">
				<div class="homepage-homeicon-div" style="text-align: right;float:left;">
					<img class="to-click header-homeicon"
						onclick="location.href='/onboarding'"
						src="/onboarding/resources/icons/home.png">
				</div>
				<div class="homepage-logouticon-div" style="text-align: left;">
					<img class="to-click header-logouticon"
						onclick="location.href='/onboarding/j_spring_security_logout'"
						src="/onboarding/resources/icons/logout.png">
				</div>
			</div>
			<!-- <div class="col-md-1">
			</div> -->
		</div>
	</div>
	<div class="navigbar">
		<div class="dropitdown">
			<button class="dropbtn">Onboarding Resources</button>
			<div class="dropitdown-content">
				<a href="/onboarding/request/check">Raise a Request to On-Board
					a Resource</a> <a href="/onboarding/request/requestlist">View
					Request List</a>
			</div>
		</div>
		<c:if
			test="${appInfo.loggedInUserRole == 'ADMIN' || appInfo.loggedInUserRole == 'PROCESSOR'}">
			<div class="dropitdown">
				<button class="dropbtn">Processing Requests</button>
				<div class="dropitdown-content">
					<a href="/onboarding/process/onboardlist">Process On-Boarding
						Requests</a> <a href="/onboarding/process/offboardlist">Process
						Off-Boarding Requests</a>
				</div>
			</div>
		</c:if>
		<div class="dropitdown">
			<button class="dropbtn">Offboarding Resources</button>
			<div class="dropitdown-content">
				<a href="/onboarding/release/releasebyid">Raise a Request to
					Off-Board a Single Resource</a> <a
					href="/onboarding/release/releaselistbyteam">Bulk Release -
					Raise a Request to Off-Board Resources(By Team)</a> <a
					href="/onboarding/release/releaselistbyproject">Bulk Release -
					Raise a Request to Off-Board a Resources(By Project)</a>
			</div>
		</div>
	</div>
</div>

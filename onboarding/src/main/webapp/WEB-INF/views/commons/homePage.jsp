<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource OnBoarding</title>
<!-- Load Sytle Sheets -->
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/bootstrap.min.css">
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/homepage.css">
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
<style type="text/css">
a {
	text-decoration: none !important;
}
</style>
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<div class="navigbar">
			<div class="dropitdown">
				<button class="dropbtn">Onboarding Resources</button>
				<div class="dropitdown-content">
					<a href="/onboarding/request/check">Raise a Request to On-Board
						a Resource</a> <a href="/onboarding/request/requestlist">View
						Request List</a>
				</div>
			</div>
			<c:if test="${appInfo.loggedInUserRole == 'ADMIN' || appInfo.loggedInUserRole == 'PROCESSOR'}">
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
					<a href="/onboarding/release/releaselist">Raise a Request to
						Off-Board a Single Resource</a> <a
						href="/onboarding/release/releaselistbyteam">Bulk Release - Raise a Request
						to Off-Board Resources(By Team)</a> <a
						href="/onboarding/release/releaselistbyproject">Bulk Release - Raise a
						Request to Off-Board a Resources(By Project)</a>
				</div>
			</div>
		</div>
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img src="/onboarding/resources/images/Image1.jpg" alt="carousel1" style="width: 100%;">
					</div>

					<div class="item">
						<img src="/onboarding/resources/images/Image2.jpg" alt="carousel2" style="width: 100%;">
					</div>

					<div class="item">
						<img src="/onboarding/resources/images/Image3.jpg" alt="carousel3" style="width: 100%;">
					</div>
				</div>
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev"> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel"
					data-slide="next"><span
					class="sr-only">Next</span>
				</a>
			</div>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>

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
	href="/onboarding/resources/stylesheets/application.css">
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
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<!-- <li data-target="#myCarousel" data-slide-to="2"></li> -->
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img src="/onboarding/resources/images/Image1.jpg" alt="carousel1" style="width: 100%;">
					</div>
					<!-- <div class="item">
						<img src="/onboarding/resources/images/carouselCognizant.png" alt="carousel2" style="width: 100%;">
					</div> -->
					<div class="item">
						<img src="/onboarding/resources/images/carouselCogNat.png" alt="carousel3" style="width: 100%;">
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

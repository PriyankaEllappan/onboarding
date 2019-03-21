<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource OnBoarding</title>
<!-- Load Sytle Sheets -->
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/bootstrap.min.css">
<link rel="stylesheet"
	href="/onboarding/resources/stylesheets/layouts.css">
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
					<a href="/onboarding/request/check">Raise a request to On-Board
						a resource</a> <a href="/onboarding/request/requestlist">View
						request list</a>
				</div>
			</div>
			<div class="dropitdown">
				<button class="dropbtn">Processing Requests</button>
				<div class="dropitdown-content">
					<a href="/onboarding/process/onboardlist">Process On-Boarding
						requests</a> <a href="/onboarding/process/offboardlist">Process
						Off-Boarding requests</a>
				</div>
			</div>
			<div class="dropitdown">
				<button class="dropbtn">Offboarding Resources</button>
				<div class="dropitdown-content">
					<a href="/onboarding/release/releaselist">Raise a request to
						Off-Board a resource</a> <a
						href="/onboarding/release/releaselistbyteam">Raise an request
						to Off-Board by team</a> <a
						href="/onboarding/release/releaselistbyproject">Raise an
						request to Off-Board by Project</a>
				</div>
			</div>
		</div>
<!-- <div><br><br><br></div>
<div><br><br><br><br></div>

			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				Indicators
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>

				Wrapper for slides
				<div class="carousel-inner">
					<div class="item active">
						<img src="https://www.w3schools.com/bootstrap/la.jpg" alt="Los Angeles" style="width: 100%;">
					</div>

					<div class="item">
						<img src="https://www.w3schools.com/bootstrap/chicago.jpg" alt="Chicago" style="width: 100%;">
					</div>

					<div class="item">
						<img src="https://www.w3schools.com/bootstrap/ny.jpg" alt="New york" style="width: 100%;">
					</div>
				</div>

				Left and right controls
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev"> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel"
					data-slide="next"><span
					class="sr-only">Next</span>
				</a>
			</div> -->
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>

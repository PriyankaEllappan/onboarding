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
	href="/onboarding/resources/stylesheets/application.css">
<script src="/onboarding/resources/scripts/jquery.min.js"></script>
<script src="/onboarding/resources/scripts/bootstrap.min.js"></script>
<script src="/onboarding/resources/scripts/application.js"></script>
<style type="text/css">
a {
	text-decoration: none !important;
}
</style>
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div class="content-style">
		<div class="row">
			<br>
		</div>
		<div class="row">
			<br>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse1">Onboarding Resources</a>
							</h4>
						</div>
						<div id="collapse1" class="panel-collapse collapse in">
							<div class="panel-body">
								<ul class="list-group">
									<li class="list-group-item"><a
										href="/onboarding/request/check">Raise a request to
											On-Board a resource</a></li>
									<li class="list-group-item"><a
										href="/onboarding/request/requestlist">View request list</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse2">Processing Requests</a>
							</h4>
						</div>
						<div id="collapse2" class="panel-collapse collapse">
							<div class="panel-body">
								<div class="panel-body">
									<ul class="list-group">
										<li class="list-group-item"><a
											href="/onboarding/process/onboardlist">Process
												On-Boarding requests</a></li>
										<li class="list-group-item"><a
											href="/onboarding/process/offboardlist">Process
												Off-Boarding requests</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse3">Offboarding Resources</a>
							</h4>
						</div>
						<div id="collapse3" class="panel-collapse collapse">
							<div class="panel-body">
								<div class="panel-body">
									<ul class="list-group">
										<li class="list-group-item"><a
											href="/onboarding/release/releaselist">Raise a request to
												Off-Board a resource</a></li>
										<li class="list-group-item"><a
											href="/onboarding/release/releaselistbyteam">Raise an request to
												Off-Board by team</a></li>
										<li class="list-group-item"><a
											href="/onboarding/release/releaselistbyproject">Raise an request
												to Off-Board by team</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>

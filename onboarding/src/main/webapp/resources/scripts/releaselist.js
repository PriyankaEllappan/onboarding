$(document).ready(function() {
	loadTeamDetails();
	loadProjectHierarchy();
	loadReleaseStatus();
	loadReleaseReason();
	$("#teamName").change(function() {
		$("#releaseTeamTable").empty();
		loadTeamTable();
	})
	$("#projectName").change(function() {
		$("#releaseProjTable").empty();
		loadProjTable();
	})
	$("#releaseTeamDropDown").hide();
	$("#releaseProjDropDown").hide();

	/* DatePicker Options */
	var container = $('.content-style');
	var releaseDate = $('#releaseDate');
	var options = {
		format : 'yyyy-mm-dd',
		container : container,
		todayHighlight : true,
		autoclose : true,
	};
	releaseDate.datepicker(options);

	$(function() {
		$('#projectSubmit').click(function(e) {
			e.preventDefault();
			$('#errMessage').text("");
			var validationStatus = validateForm();
			if (validationStatus == true) {
				submitProj();
			}
		})
	});

	$(function() {
		$('#teamSubmit').click(function(e) {
			e.preventDefault();
			$('#errMessage').text("");
			var validationStatus = validateForm();
			if (validationStatus == true) {
				submitTeam();
			}
		})
	});

});

function submitProj() {
	jsonStr = {}
	jsonStr["projectId"] = $('#projectName').val();
	jsonStr["releaseStatusId"] = $('#releaseStatus').val();
	jsonStr["reasonForOffboarding"] = $('#releaseSummary').val();
	jsonStr["releaseDate"] = $('#releaseDate').val();
	$
			.post({
				url : '/onboarding/release/processreleasebyproject',
				type : 'POST',
				dataType : 'json',
				data : JSON.stringify(jsonStr),
				contentType : 'application/json; charset=utf-8',
				success : function(resultData) {
					console.log(resultData);
					if (!$.trim(resultData)) {
						$('#"offboardByProj"').hide();
						$('#errMessage').text("Unable to process the request");
					} else {
						$('#"offboardByProj"').hide();
						$('#statusSucessMessage')
								.text(
										"Requested project resources release has been initiated");
					}
				},
				error : function() {
					$('#"offboardByProj"').hide();
					$('#errMessage').text("Unable to process the request");
				}
			})
}

function submitTeam() {
	jsonStr = {}
	jsonStr["teamId"] = $('#teamName').val();
	jsonStr["releaseStatusId"] = $('#releaseStatus').val();
	jsonStr["reasonForOffboarding"] = $('#releaseSummary').val();
	jsonStr["releaseDate"] = $('#releaseDate').val();
	$.post({
		url : '/onboarding/release/processreleasebyteam',
		type : 'POST',
		dataType : 'json',
		data : JSON.stringify(jsonStr),
		contentType : 'application/json; charset=utf-8',
		success : function(resultData) {
			console.log(resultData);
			if (!$.trim(resultData)) {
				$('#offboardByTeam').hide();
				$('#errMessage').text("Unable to process the request");
			} else {
				$('#offboardByTeam').hide();
				$('#statusSucessMessage').text(
						"Requested team resources release has been initiated");
			}
		},
		error : function() {
			$('#offboardByTeam').hide();
			$('#errMessage').text("Unable to process the request");
			console.log("Error Empty");
		}
	})
}

function loadTeamDetails() {
	$.ajax({
		type : 'GET',
		url : "/onboarding/team/getactiveteams",
		dataType : "text",
		success : function(resultData) {
			teamHierarchy = JSON.parse(resultData);
			$.each(teamHierarchy, function(key, value) {
				$('#releaseTeamTable').append("<thead><tr><th>Employee Id</th><th>Employee Name</th><th>Project Id</th><th>Project Name</th><th>Team Name</th></tr></thead>");
				$('#teamName').append(
						$("<option></option>").attr("value", value.id).text(
								value.teamName));
			});
		}
	});
}

function loadProjectHierarchy() {
	$.ajax({
		type : 'GET',
		url : "/onboarding/projects/getactiveprojects",
		dataType : "text",
		success : function(resultData) {
			projectHierarchy = JSON.parse(resultData);
			$.each(projectHierarchy, function(key, value) {
				$('#projectName').append(
						$("<option></option>").attr("value", value.projectId)
								.text(value.projectName));
			});
		}
	});
}

function loadTeamTable() {
	console.log("Load Team Table");
	var teamId = $('#teamName').val()
	$
			.ajax({
				type : 'GET',
				url : "/onboarding/release/getresourcesbyteam/" + teamId,
				dataType : "text",
				success : function(resultData) {
					if (!$.trim(resultData)) {
						console.log("Empty Response");
						$("#statusMessage").text(
								"No Resources Available in this Team");
					} else {
						var returnedData = JSON.parse(resultData);
						$("#releaseTeamDropDown").show();
						$('#releaseTeamTable').append("<thead><tr><th>Employee Id</th><th>Employee Name</th><th>Project Id</th><th>Project Name</th><th>Team Name</th></tr></thead>");
						$('#releaseTeamTable').append("<tbody>");
						$.each(returnedData, function(key, value) {
							$('#releaseTeamTable').append(
									"<tr><td>" + value.employeeId + "</td><td>"
											+ value.name + "</td><td>"
											+ value.projectId + "</td><td>"
											+ value.projectName + "</td><td>"
											+ value.teamName + "</td></tr>");
						});
					}
				}
			});
}

function loadProjTable() {
	console.log("Load Project Table");
	var projId = $('#projectName').val()
	$.ajax({
		type : 'GET',
		url : "/onboarding/release/getresourcesbyproject/" + projId,
		dataType : "text",
		success : function(resultData) {
			if (!$.trim(resultData)) {
				console.log("Empty Response");
				$("#statusMessage").text(
						"No Resources Available in this Project");
			} else {
				var returnedData = JSON.parse(resultData);
				$("#releaseProjDropDown").show();
                $('#releaseProjTable').append("<thead><tr><th>Employee Id</th><th>Employee Name</th><th>Project Id</th><th>Project Name</th><th>Team Name</th></tr></thead>");
				$('#releaseProjTable').append("<tbody>");
				$.each(returnedData, function(key, value) {
					$('#releaseProjTable').append(
							"<tr><td>" + value.employeeId + "</td><td>"
									+ value.name + "</td><td>"
									+ value.projectId + "</td><td>"
									+ value.projectName + "</td><td>"
									+ value.teamName + "</td></tr>");
				});
			}
		}
	});
}

function loadReleaseStatus() {
	$.ajax({
		type : 'GET',
		url : "/onboarding/status/getallreleasestatus",
		dataType : "text",
		success : function(resultData) {
			releaseStat = JSON.parse(resultData);
			$.each(releaseStat, function(key, value) {
				$('#releaseStatus').append(
						$("<option></option>").attr("value", value.id).text(
								value.status));
			});
			$('select[name="releaseStatus"]').find(
					'option[value=' + $('#releaseStatusId').val() + ']').attr(
					"selected", true);
		}
	});
}

function loadReleaseReason() {
	$.ajax({
		type : 'GET',
		url : "/onboarding/release/getreleasesummary",
		dataType : "text",
		success : function(resultData) {
			releaseReason = JSON.parse(resultData);
			$.each(releaseReason, function(key, value) {
				$('#releaseSummary').append(
						$("<option></option>").attr("value", value.id).text(
								value.summary));
			});
		}
	});
}

function validateForm() {
	if ($('#releaseStatus').val() == null || $('#releaseStatus').val() == "") {
		$('#errMessage').text("Release Status needs to be selected");
		return false;
	} else if ($('#releaseStatus').val() == "1") {
		$('#errMessage').text("Release Status needs to be changed");
		return false;
	}
	if ($('#releaseSummary').val() == null || $('#releaseSummary').val() == "") {
		$('#errMessage').text("Release Summary needs to be selected");
		return false;
	}
	if ($('#releaseDate').val() == null || $('#releaseDate').val() == "") {
		$('#errMessage').text("Release Date needs to be selected");
		return false;
	}
	return true;
}
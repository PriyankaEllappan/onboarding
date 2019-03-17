$(document).ready(function() {
	loadTeamDetails();
	loadProjectHierarchy();
	$("#teamName").change(function() {
		loadTeamTable();
	})
	$("#projectName").change(function() {
		loadProjTable();
	})
});

function loadTeamDetails() {
	$.ajax({
		type : 'GET',
		url : "/onboarding/team/getactiveteams",
		dataType : "text",
		success : function(resultData) {
			teamHierarchy = JSON.parse(resultData);
			$.each(teamHierarchy, function(key, value) {
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
	$.ajax({
		type : 'GET',
		url : "/onboarding/release/getresourcesbyteam/" + teamId,
		dataType : "text",
		success : function(resultData) {
			if (!$.trim(resultData)) {
				console.log("Empty Response");
			} else {
				var returnedData = JSON.parse(resultData);
				$('#releaseTeamTable').append("<tbody>");
				$.each(returnedData, function(key, value) {
					$('#releaseTeamTable').append(
							"<tr><td>" + value.employeeId + "</td><td>"
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
	alert(projId)
	$.ajax({
		type : 'GET',
		url : "/onboarding/release/getresourcesbyproject/" + projId,
		dataType : "text",
		success : function(resultData) {
			if (!$.trim(resultData)) {
				console.log("Empty Response");
			} else {
				var returnedData = JSON.parse(resultData);
				$('#releaseProjTable').append("<tbody>");
				$.each(returnedData, function(key, value) {
					$('#releaseProjTable').append(
							"<tr><td>" + value.employeeId + "</td><td>"
									+ value.projectName + "</td><td>"
									+ value.teamName + "</td></tr>");
				});
			}
		}
	});
}
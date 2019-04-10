var projectHierarchy = {}
var teamHierarchy = {}
var countryHierarchy = {}
var roleMappings = {}
var roles = {}
var jsonRequest = {}
var movementList = {}
var bsaList ={}
var selectedTeam = [];

$(document).ready(function() {
	loadProjectHierarchy();
	loadTeamDetails();
	loadCountryHierarchy();
	loadAllRoles();
	loadAllRoleMappings();
	loadApprovalStatus();
	loadReleaseStatus();
	loadMovementDetails();
	loadBsaDetails();
	
	$('#newRateGroup').hide();
	
	document.getElementById("projTab").click();
	$("#teamList").prop('disabled', true);
	
	$("#projectName").change(function() {
		var selectedProject = $("#projectName").val();
		$("#teamList").prop('disabled', false);
		$.each(projectHierarchy.responseList, function(key,value) {  
			if (selectedProject == value.projectName) {
				$('#projectID').val(value.projectId);
				$('#requester').val(value.requesterName);
				$('#requesterID').val(value.requesterId);
				$('#processor').val(value.processorName);
				$('#processorID').val(value.processorId);
				$('#projectMapID').val(value.projMapId);
				loadTeamList(value.projMapId);
			}
		});
	})
	
	$("#role").change(function() {
		loadRateDetails();
	})
	
	$("#country").change(function() {
		loadLocDetails();
		loadRateDetails();
	})

	$('#editRateCheckBox').click(function() {
		if ($(this).prop("checked") == true) {
			$('#isRateOverride').val("1");
			$('#newRateGroup').show();
		} else if ($(this).prop("checked") == false) {
			$('#newRateGroup').hide();
			$('#isRateOverride').val("0");
		}
	});
	
});

function loadProjectHierarchy(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/projects/getactiveprojects" ,
		dataType : "json",
		success : function(resultData) {
			projectHierarchy = resultData; //setting the value for the global JS object "bandDetails"
			console.log(resultData);
			console.log(resultData.responseList);
			if (projectHierarchy.status == "SUCCESS") {
				$.each(projectHierarchy.responseList, function(key, value) {
					$('#projectName').append(
							$("<option></option>").attr("value", value.projectName)
									.text(value.projectName));
				});
			} else {
				console.log("projectHierarchy failure Call");
			}
		}
	});
}

function loadTeamList(selectedProjectMapId){
	var dataList = $('#teamName');
	dataList.empty();
	$.each(teamHierarchy.responseList, function(key,value) { 
		if(selectedProjectMapId == value.projMapId){
			var selectedTeamTemp = {};
			selectedTeamTemp["id"] = value.id;
			selectedTeamTemp["teamName"] = value.teamName;
			selectedTeam.push(selectedTeamTemp);
			$('#teamName')
	         .append($("<option></option>")
	                    .text(value.teamName)); 
		}
    });
}

function loadCountryHierarchy(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/country/getcountries" ,
		dataType : "json",
		success : function(resultData) {
			countryHierarchy = resultData; //setting the value for the global JS object "bandDetails"
			console.log(resultData);
			console.log(resultData.responseList);
			if (countryHierarchy.status == "SUCCESS") {
				$.each(countryHierarchy.responseList, function(key, value) {
					$('#country').append(
							$("<option></option>").attr("value", value.countryName)
									.text(value.countryName));
				});
			} else {
				console.log("CountryHierarchy failure Call");
			}
		}
	});
}

function loadLocDetails() {
	var selectedCountry = $('#country').val();
	$.each(countryHierarchy.responseList, function(key, value) {
		if (selectedCountry == value.countryName) {
			$('#countryMappingID').val(value.countryMappingID);
			$('#location').val(value.locationName);
		}
	});
}

function loadTeamDetails() {
	$.ajax({
		type : 'GET',
		url : "/onboarding/team/getactiveteams" ,
		dataType : "text",
		success : function(resultData) {
			teamHierarchy = JSON.parse(resultData);
		}
	});
}

function loadAllRoles() {
	$.ajax({
		type : 'GET',
		url : "/onboarding/role/getroles",
		dataType : "text",
		success : function(resultData) {
			roles = JSON.parse(resultData);
			$.each(roles, function(key, value) {
				$('#role')
						.append($("<optgroup></optgroup>").attr("label", key))
				$.each(value, function(key, valueInner) {
					$('#role').append(
							$("<option></option>").attr("value", valueInner.id)
									.text(valueInner.roleName));
				});
			});
		}
	});
}

function loadAllRoleMappings(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/role/getrolemappings" ,
		dataType : "text",
		success : function(resultData) {
			roleMappings = JSON.parse(resultData);
		}
	});
}

function loadRateDetails(){
	var selectedRoleID = $('#role').val();
	var selectedCountryMapID = $('#countryMappingID').val();
	
	$.each(roleMappings.responseList, function(key,value) {   
		if (selectedRoleID == value.roleId && selectedCountryMapID == value.countryId) {
			$('#roleMappingID').val(value.roleId);
			$('#rate').val(value.rate);
		}
	});
}

function loadApprovalStatus(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/status/getallapprovalstatus",
		dataType : "json",
		success : function(resultData) {
			console.log(resultData);
			console.log(resultData.responseList);
			if (resultData.status == "SUCCESS") {
				$.each(resultData.responseList, function(key,value) {   
					if (value.status == "New") {
						$('#approvalStatus').val(value.id);
					}
				});
			} else {
				console.log("getallapprovalstatus failure Call");
			}
		}
	});
}

function loadReleaseStatus(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/status/getallreleasestatus" ,
		dataType : "json",
		success : function(resultData) {
			console.log(resultData);
			console.log(resultData.responseList);
			if (resultData.status == "SUCCESS") {
				$.each(resultData.responseList, function(key,value) {  
					if (value.status == "Yet to Release") {
						$('#releaseStatusId').val(value.id);
					}
				});
			} else {
						console.log("getallreleasestatus failure Call");
					}

		}
	});
}

function loadMovementDetails(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/movement/getmovements" ,
		dataType : "json",
		success : function(resultData) {
			console.log(resultData);
			console.log(resultData.responseList);
			if (resultData.status == "SUCCESS") {
				$.each(resultData.responseList, function(key,value) {   
				     $('#movementID')
				         .append($("<option></option>")
				                    .attr("value",value.id)
				                    .text(value.movement)); 
				});
			} else {
				console.log("getmovements failure Call");
			}	
				
			
		}
	});
}

function loadBsaDetails(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/team/getactivebsa" ,
		dataType : "json",
		success : function(resultData) {
			bsaList = resultData; //setting the value for the global JS object "bandDetails"
			console.log(resultData);
			console.log(resultData.responseList);
			if (bsaList.status == "SUCCESS") {
				$.each(bsaList.responseList, function(key, value) {
					$('#bsaInfo').append(
							$("<option></option>").attr("value", value.bsaId)
									.text(value.bsaName));
				});
			} else {
				console.log("bsaList failure Call");
			}
		}
	});
}

/* Project Register Submit */
$(function() {
	$('#projectRegisterFormSubmit').click(
			function(e) {
				e.preventDefault();
				$('#errMessage').text("");
				var validationStatus = validateForm();
				if (validationStatus == true) {
					$('#projectRegisterFormSubmit').prop('disabled', true);
					$('#projectRegisterFormSubmit').css('cursor', 'not-allowed');
					$.each(selectedTeam, function(key, value) {
						if ($('#teamList').val() == value.teamName) {
							$('#teamMappingID').val(value.id);
						}
					});
					setRequestParams();
					$.post({
						url : '/onboarding/request/mapproject',
						type : 'POST',
						dataType : 'json',
						data : JSON.stringify(jsonRequest),
						contentType : 'application/json; charset=utf-8',
								success : function(resultData) {
									if (resultData.status == "SUCCESS") {
										$('#formDiv').hide();
										$('#statusSucessMessage').text(resultData.statusMessage);
									}
									else {
										$('#errMessage').text(resultData.statusMessage);
										$('#projTab').click(openSpecificTabNext(event, 'projInfo'));
										$('#projectRegisterFormSubmit').prop('disabled', false);
										$('#projectRegisterFormSubmit').css('cursor', 'pointer');
									}
								},
								error : function() {
									$('#errMessage').text("Unable to Add Project Details.");
									$('#projTab').click(openSpecificTabNext(event, 'projInfo'));
									$('#projectRegisterFormSubmit').prop('disabled', false);
									$('#projectRegisterFormSubmit').css('cursor', 'pointer');
								}
								
					})
				}
			});
});

function setRequestParams(){
	jsonRequest["employeeId"] = $('#newEmpID').val();
	jsonRequest["teamId"] = $('#teamMappingID').val();
	jsonRequest["teamName"] = $('#teamList').val();
	jsonRequest["roleId"] = $('#roleMappingID').val();
	jsonRequest["countryId"] = $('#countryMappingID').val();
	jsonRequest["startDate"] = $('#startDate').val();
	jsonRequest["approvalStatusId"] = $('#approvalStatus').val();
	jsonRequest["releaseStatusId"] = $('#releaseStatusId').val();
	jsonRequest["skillSet"] = $('#skill').val();
	jsonRequest["skillSummary"] = $('#skillSummary').val();
	jsonRequest["requesterId"] = $('#requesterID').val();
	jsonRequest["processorId"] = $('#processorID').val();
	jsonRequest["projectId"] = $('#projectID').val();
	jsonRequest["name"] = $('#name').val();
	jsonRequest["projectName"] = $('#projectName').val();
	jsonRequest["projectMappingId"] = $('#projectMapID').val();
	jsonRequest["movementId"] = $('#movementID').val();
	jsonRequest["pplManager"] = $('#pplInfo').val();
	jsonRequest["experience"] = $('#experience').val();
	jsonRequest["bsaId"] = $('#bsaInfo').val();
	jsonRequest["overriddenRate"] = $('#newRate').val();
	jsonRequest["isRateOverride"] = $('#isRateOverride').val();
}

function validateForm() {
	if ($('#projectName').val() == null || $('#projectName').val() == "") {
		$('#errMessage').text("Project needs to be selected");
		$('#projTab').click(openSpecificTabNext(event, 'projInfo'));
		return false;
	} 
	if ($('#teamList').val() == null || $('#teamList').val() == "") {
		$('#errMessage').text("Team name should be selected or entered");
		$('#projTab').click(openSpecificTabNext(event, 'projInfo'));
		return false;
	} 
	if ($('#startDate').val() == null || $('#startDate').val() == "") {
		$('#errMessage').text("Start Date cannot be null or empty");
		$('#projTab').click(openSpecificTabNext(event, 'projInfo'));
		return false;
	} 
	if ($('#country').val() == null || $('#country').val() == "") {
		$('#errMessage').text("Country needs to be selected");
		$('#projTab').click(openSpecificTabNext(event, 'projInfo'));
		return false;
	} 
	if ($('#role').val() == null || $('#role').val() == "") {
		$('#errMessage').text("Role needs to be selected");
		$('#projTab').click(openSpecificTabNext(event, 'projInfo'));
		return false;
	} 
	if ($('#experience').val() == null || $('#experience').val() == "" || isNaN($('#experience').val())) {
		$('#errMessage').text("Experience Should be Numeric Value");
		$('#projTab').click(openSpecificTabNext(event, 'projInfo'));
		return false;
	} 
	if ($('#skill').val() == null || $('#skill').val() == "") {
        $('#errMessage').text("Skill Set needs to be entered");
        $('#projTab').click(openSpecificTabNext(event, 'projInfo'));
        return false;
	} 
	if ($('#skillSummary').val() == null || $('#skillSummary').val() == "") {
        $('#errMessage').text("Skill Summary needs to be entered");
        $('#projTab').click(openSpecificTabNext(event, 'projInfo'));
        return false;
	} 
	if ($('#bsaInfo').val() == null || $('#bsaInfo').val() == "") {
        $('#errMessage').text("BSA needs to be selected");
        $('#projTab').click(openSpecificTabNext(event, 'customerInfo'));
        return false;
	}
	if ($('#isRateOverride').val() == 1
			&& ($('#newRate').val() == null || $('#newRate').val() == "")) {
		$('#errMessage').text("New rate needs to be entered");
		$('#projTab').click(openSpecificTabNext(event, 'customerInfo'));
		return false;
	}
	
	return true;
}

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
	
	document.getElementById("projTab").click();
	$("#teamList").prop('disabled', true);
	
	/* DatePicker Options */
	var dateOfBirth = $('#startDate');
	var container = $('.content-style');
	var options = {
		format : 'yyyy-mm-dd',
		container : container,
		todayHighlight : true,
		autoclose : true,
	};
	dateOfBirth.datepicker(options);
	
	$("#projectName").change(function() {
		var selectedProject = $("#projectName").val();
		$("#teamList").prop('disabled', false);
		$.each(projectHierarchy, function(key,value) {  
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
	
});

function openSpecificTab(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
           tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
           tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}

function openSpecificTabNext(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
           tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
           tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tabName).style.display = "block";
    if(tabName == "projInfo"){
    	document.getElementById("projTab").className += " active";
    }
    if(tabName == "customerInfo"){
    	document.getElementById("custTab").className += " active";
    }
}

function loadProjectHierarchy(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/projects/getactiveprojects" ,
		dataType : "text",
		success : function(resultData) {
			projectHierarchy = JSON.parse(resultData);
			$.each(projectHierarchy, function(key,value) {   
			     $('#projectName')
			         .append($("<option></option>")
			                    .attr("value",value.projectName)
			                    .text(value.projectName)); 
			});
		}
	});
}

function loadTeamList(selectedProjectMapId){
	var dataList = $('#teamName');
	dataList.empty();
	$.each(teamHierarchy, function(key,value) { 
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
		dataType : "text",
		success : function(resultData) {
			countryHierarchy = JSON.parse(resultData);
			$.each(countryHierarchy, function(key,value) {   
			     $('#country')
			         .append($("<option></option>")
			                    .attr("value",value.countryName)
			                    .text(value.countryName)); 
			});
		}
	});
}

function loadLocDetails() {
	var selectedCountry = $('#country').val();
	$.each(countryHierarchy, function(key, value) {
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
	
	$.each(roleMappings, function(key,value) {   
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
		dataType : "text",
		success : function(resultData) {
			approvalStat = JSON.parse(resultData);
			$.each(approvalStat, function(key,value) {   
				if (value.status == "NEW") {
					$('#approvalStatus').val(value.id);
				}
			});
		}
	});
}

function loadReleaseStatus(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/status/getallreleasestatus" ,
		dataType : "text",
		success : function(resultData) {
			releaseStat = JSON.parse(resultData);
			$.each(releaseStat, function(key,value) {  
				if (value.status == "YET TO RELEASE") {
					$('#releaseStatusId').val(value.id);
				}
			});
		}
	});
}

function loadMovementDetails(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/movement/getmovements" ,
		dataType : "text",
		success : function(resultData) {
			movementList = JSON.parse(resultData);
			$.each(movementList, function(key,value) {   
			     $('#movementID')
			         .append($("<option></option>")
			                    .attr("value",value.id)
			                    .text(value.movement)); 
			});
		}
	});
}

function loadBsaDetails(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/team/getactivebsa" ,
		dataType : "text",
		success : function(resultData) {
			bsaList = JSON.parse(resultData);
			$.each(bsaList, function(key,value) {   
			     $('#bsaInfo')
			         .append($("<option></option>")
			                    .attr("value",value.bsaId)
			                    .text(value.bsaName)); 
			});
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
							if (!$.trim(resultData)) {
								$('#errMessage').text("Unable to add the project details. Please verify the entered details");
								$('#projTab').click(openSpecificTabNext(event, 'projInfo'));
								$('#projectRegisterFormSubmit').prop('disabled', false);
								$('#projectRegisterFormSubmit').css('cursor', 'pointer');
							} else {
								$('#formDiv').hide();
								$('#statusSucessMessage').text("Project details added successfully");
							}
						},
						error : function() {
							$('#errMessage').text("Unable to add the project details. Please verify the entered details");
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
	jsonRequest["movementId"] = $('#movementId').val();
	jsonRequest["pplManager"] = $('#pplInfo').val();
	jsonRequest["experience"] = $('#experience').val();
	jsonRequest["bsaId"] = $('#bsaInfo').val();
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
	if ($('#experience').val() != null && isNaN($('#experience').val())) {
		$('#errMessage').text("Experience Should be Numeric Value");
		$('#projTab').click(openSpecificTabNext(event, 'projInfo'));
		return false;
	} 
	return true;
}

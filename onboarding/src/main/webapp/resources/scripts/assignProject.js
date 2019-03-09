var teamHierarchy = {}
var countryHierarchy = {}
var roleMappings = {}
var jsonRequest = {}

$(document).ready(function() {
	document.getElementById("defaultOpen").click();
	loadTeamHierarchy();
	loadCountryHierarchy();
	loadAllRoles();
	loadRoleMappings();
	loadApprovalStatus();
	loadReleaseStatus();
	
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

function loadCountryHierarchy(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/country/getAllCountryDetails" ,
		dataType : "text",
		success : function(resultData) {
			countryHierarchy = JSON.parse(resultData);
			console.log(countryHierarchy);
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

function loadTeamHierarchy() {
	$.ajax({
		type : 'GET',
		url : "/onboarding/teams/getAllTeamDetails" ,
		dataType : "text",
		success : function(resultData) {
			teamHierarchy = JSON.parse(resultData);
			console.log(teamHierarchy);
			$.each(teamHierarchy, function(key,value) {   
			     $('#teamName')
			         .append($("<option></option>")
			                    .attr("value",value.teamName)
			                    .text(value.teamName)); 
			});
		}
	});
}

function loadProjDetails() {
	var selectedTeam = $('#teamName').val();
	$.each(teamHierarchy, function(key, value) {
		if (selectedTeam == value.teamName) {
			$('#teamMappingID').val(value.teamMapID);
			$('#projectID').val(value.projectID);
			$('#projectName').val(value.projectName);
			$('#requester').val(value.requesterName);
			$('#requesterID').val(value.requesterID);
			$('#processor').val(value.processorName);
			$('#processorID').val(value.processorID);
			$('#bsaInfo').val(value.bsa);
			$('#pplInfo').val(value.pplName);
		}
	});
}

function loadAllRoles(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/roles/getAllRoles" ,
		dataType : "text",
		success : function(resultData) {
			var roles = JSON.parse(resultData);
			console.log(roles);
			$.each(roles, function(key,value) {   
				$('#role')
		         .append($("<option></option>")
		                    .attr("value",value.id)
		                    .text(value.role)); 
			});
		}
	});
}

function loadRoleMappings(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/roles/getAllRoleMappings" ,
		dataType : "text",
		success : function(resultData) {
			roleMappings = JSON.parse(resultData);
			console.log(roleMappings);
		}
	});
}

function loadRateDetails(){
	var selectedRoleID = $('#role').val();
	var selectedCountryMapID = $('#countryMappingID').val();
	/*alert(selectedRoleID);
	alert(selectedCountryMapID);*/
	$.each(roleMappings, function(key,value) {   
		if (selectedRoleID == value.roleId && selectedCountryMapID == value.countryMappingID) {
			$('#roleMappingID').val(value.roleMappingID);
			$('#rate').val(value.rateValue);
		}
	});
}

function loadApprovalStatus(){
	var status = "NEW";
	$.ajax({
		type : 'GET',
		url : "/onboarding/status/getapprovalid/" + status,
		dataType : "text",
		success : function(resultData) {
			approvalStat = JSON.parse(resultData);
			$('#approvalStatus').val(approvalStat.id);
		}
	});
}

function loadReleaseStatus(){
	var status = "YET TO RELEASE";
	$.ajax({
		type : 'GET',
		url : "/onboarding/status/getreleaseid/" + status,
		dataType : "text",
		success : function(resultData) {
			releaseStat = JSON.parse(resultData);
			$('#releaseStatus').val(releaseStat.id);
		}
	});
}
/* Project Register Submit */
$(function() {
	$('#projectRegisterFormSubmit').click(function(e) {
		e.preventDefault();
		setRequestParams();
		$.post({
			url : '/onboarding/request/addproject',
			type : 'POST',
			dataType : 'json',
			data : JSON.stringify(jsonRequest),
			contentType : 'application/json; charset=utf-8',
			success : function(resultData) {
				console.log(resultData);
				if (!$.trim(resultData)) {
					$('#messageDiv').removeClass('hideElements');
					$('#messageDiv').text("Unable to add the project details");
					$('#messageDiv').addClass('showElements');
					$('#formDiv').addClass('hideElements');
				} else {
					$('#messageDiv').removeClass('hideElements');
					$('#messageDiv').text("Project details added successfully");
					$('#messageDiv').addClass('showElements');
					$('#formDiv').addClass('hideElements');
				}
			},
			error : function() {
				console.log("error");
				$('#messageDiv').removeClass('hideElements');
				$('#messageDiv').text("Unable to add the project details");
				$('#messageDiv').addClass('showElements');
				$('#formDiv').addClass('hideElements');
			}
		})
	});
});

function setRequestParams(){
	jsonRequest["employeeID"] = $('#newEmpID').val();
	jsonRequest["team"] = $('#teamMappingID').val();
	jsonRequest["role"] = $('#roleMappingID').val();
	jsonRequest["country"] = $('#countryMappingID').val();
	jsonRequest["startDate"] = $('#startDate').val();
	jsonRequest["approvalStatus"] = $('#approvalStatus').val();
	jsonRequest["releaseStatus"] = $('#releaseStatus').val();
	jsonRequest["skillSet"] = $('#skill').val();
	jsonRequest["skillSummary"] = $('#skillSummary').val();
	jsonRequest["requesterId"] = $('#requesterID').val();
	jsonRequest["processorId"] = $('#processorID').val();
}
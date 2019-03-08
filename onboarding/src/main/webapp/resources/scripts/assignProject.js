var teamHierarchy = {}
var countryHierarchy = {}
var roleMappings = {}

$(document).ready(function() {
	document.getElementById("defaultOpen").click();
	loadTeamHierarchy();
	loadCountryHierarchy();
	loadAllRoles();
	loadRoleMappings();
	
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
			$('#processor').val(value.processorName);
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
	alert(selectedRoleID);
	alert(selectedCountryMapID);
	$.each(roleMappings, function(key,value) {   
		if (selectedRoleID == value.roleId && selectedCountryMapID == value.countryMappingID) {
			$('#rate').val(value.rateValue);
		}
	});
}
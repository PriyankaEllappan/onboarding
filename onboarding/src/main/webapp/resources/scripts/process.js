var jsonRequest = {}
var approvalStat;
var bandDetails;

$(document).ready(function() {
	
	/* DatePicker Options */
	var nwIdCreatedDate = $('#nationwideIdCreatedDate');
	var fgOnboardingDate = $('#fgOnBoardingDate');
	var container = $('.content-style');
	var options = {
		format : 'yyyy-mm-dd',
		container : container,
		todayHighlight : true,
		autoclose : true,
	};
	nwIdCreatedDate.datepicker(options);
	fgOnboardingDate.datepicker(options);
	
	document.getElementById("custTab").click();
	loadApprovalStatus();
	loadReleaseStatus();
	loadBands();
	loadMovementDetails();
	
	$("#band").change(function() {
		var selectedVal = $("#band").val();
		$.each(bandDetails, function(key,value) {  
			if(selectedVal == value.id ){
				 $("#bandId").val(value.id);
			}
		});
	})
	
	$("#approvalStatus").change(function() {
		var selectedVal = $("#approvalStatus").val();
		$.each(approvalStat, function(key,value) {  
			if(selectedVal == value.id ){
				 $("#approvalStatusId").val(value.id);
			}
		});
	})
})

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

function loadApprovalStatus(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/status/getallapprovalstatus",
		dataType : "text",
		success : function(resultData) {
			approvalStat = JSON.parse(resultData);
			$.each(approvalStat, function(key,value) {  
				if(value.id == 1 || value.id == 4){
					$('#approvalStatus')
			         .append($("<option></option>")
			                    .attr("value",value.id)
			                    .attr("disabled", true)
			                    .text(value.status));
				}else{
					$('#approvalStatus')
			         .append($("<option></option>")
			                    .attr("value",value.id)
			                    .text(value.status));
				}
			});
			$('select[name="approvalStatus"]').find('option[value='+ $('#approvalStatusId').val() +']').attr("selected",true);
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
					$('#releaseStatus').val(releaseStat.id);
				}
			});
		}
	});
}

function loadBands(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/band/getbands" ,
		dataType : "text",
		success : function(resultData) {
			bandDetails = JSON.parse(resultData);
			$.each(bandDetails, function(key,value) {   
			     $('#band')
			         .append($("<option></option>")
			                    .attr("value",value.id)
			                    .text(value.bandName)); 
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
				if($("#movementId").val() == value.id ){
					 $('#movement').val(value.movement)
				}
			});
		}
	});
}

function validateForm() {

	if (($('#approvalStatus').val() != 2) && ($('#approvalStatus').val() != 3) && ($('#approvalStatus').val() != 5)) {
		$('#errMessage').text("Approval Status must be selected with either value as InProgress or Completed or Rejected.");
		return false;
	}

	if ($('#nationwideId').val() != null && $('#nationwideId').val() != "") {
		if ($('#approvalStatus').val() != 3) {
			$('#errMessage').text("If NationWide ID is generated, then Approval Status must be selected with value as Completed.");
			return false;
		}
	}

	if ($('#approvalStatus').val() == 3) {
		
		if ($('#nationwideId').val() == null || $('#nationwideId').val() == "") {
			$('#errMessage').text("Nationwide ID cannot be null or empty");
			return false;
		}
		
		if ($('#nationwideIdCreatedDate').val() == null || $('#nationwideIdCreatedDate').val() == "") {
			$('#errMessage').text("Nationwide ID Created Date cannot be null or empty");
			return false;
		}
	}

	if ($('#approvalStatus').val() == 5) {
		if ($('#comments').val() == null || $('#comments').val() == "") {
			$('#errMessage').text("Comments cannot be null or empty. Please fill in the reason for the rejection in comments field.");
			return false;
		}

		if ($('#nationwideIdCreatedDate').val() != null && $('#nationwideIdCreatedDate').val() != "") {
			$('#errMessage').text("You have selected Rejected as Approval Status. For a Rejected request, there will not be any Nationwide ID Created Date.");
			return false;
		}
	}

	return true;

}
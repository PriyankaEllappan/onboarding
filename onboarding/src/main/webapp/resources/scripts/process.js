var jsonRequest = {}
var approvalStat;
var bandDetails;

$(document).ready(function() {
	
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
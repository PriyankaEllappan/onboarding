var jsonRequest = {}
var approvalStat;
var bandDetails;

$(document).ready(function() {
	
	document.getElementById("custTab").click();
	loadApprovalStatus();
	loadReleaseStatus();
	loadBands();
	loadMovementDetails();
	
	$(".is-required").hide();
	$(".is-required-msg").hide();
	
	$("#approvalStatus").change(function() {
		if($("#approvalStatus").val() == 3){
			$(".is-required").show();
			$(".is-required-msg").show();
		}else{
			$(".is-required").hide();
			$(".is-required-msg").hide();
		}
	});
	
	$("#band").change(function() {
		var selectedVal = $("#band").val();
		$.each(bandDetails.responseList, function(key,value) {
			if(selectedVal == value.id ){
				 $("#bandId").val(value.id);
			}
		});
	})
	
	$("#approvalStatus").change(function() {
		var selectedVal = $("#approvalStatus").val();
		$.each(approvalStat.responseList, function(key,value) { 
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
		dataType : "json",
		success : function(resultData) {
			approvalStat = resultData; //setting the value for the global JS object "approvalStat"
			console.log(resultData);
			console.log(resultData.responseList);
			if (approvalStat.status == "SUCCESS") {
				$.each(approvalStat.responseList, function(key,value) {  
					if(value.id == 1 || value.id == 4){
						$('#approvalStatus')
				         .append($("<option></option>")
				                    .attr("value",value.id)
				                    .attr("disabled", true)
				                    .text(value.status));
					}else if(value.id == 3 && $('#approvalStatusId').val() == 1){
						$('#approvalStatus')
				         .append($("<option></option>")
				        		 .attr("value",value.id)
				                    .attr("disabled", true)
				                    .text(value.status));
					} else{
						$('#approvalStatus')
				         .append($("<option></option>")
				                    .attr("value",value.id)
				                    .text(value.status));
					}
				});
			} else {
				console.log("getallapprovalstatus failure Call");
			}
			$('select[name="approvalStatus"]').find('option[value='+ $('#approvalStatusId').val() +']').attr("selected",true);
		}
	});
}

function loadReleaseStatus(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/status/getallreleasestatus" ,
		dataType : "json",
		success : function(resultData) {
			//releaseStat = JSON.parse(resultData);

			releaseStat = resultData; //setting the value for the global JS object "releaseStat"
			console.log(resultData);
			console.log(resultData.responseList);
			if (releaseStat.status == "SUCCESS") {
				$.each(releaseStat.responseList, function(key,value) {  
					if (value.status == "Yet to Release") {
						$('#releaseStatus').val(value.id);
					}
				});
			} else {
				console.log("getallreleasestatus failure Call");
			}
		}
	});
}

function loadBands(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/band/getbands" ,
		dataType : "json",
		success : function(resultData) {
			bandDetails = resultData; //setting the value for the global JS object "bandDetails"
			console.log(resultData);
			console.log(resultData.responseList);
			if (bandDetails.status == "SUCCESS") {
				$.each(bandDetails.responseList, function(key, value) {
					$('#band').append(
							$("<option></option>").attr("value", value.id)
									.text(value.bandName));
				});
			} else {
				console.log("bands failure Call");
			}
            $('select[name="band"]').find('option[value='+ $('#bandId').val() +']').attr("selected",true);
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
					if($("#movementId").val() == value.id ){
						 $('#movement').val(value.movement);
					}
				});
			} else {
				console.log("getmovements failure Call");
			}
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

		if ($('#nationwideIdCreatedDate').val() == null
				|| $('#nationwideIdCreatedDate').val() == "") {
			$('#errMessage').text(
					"Nationwide ID Created Date cannot be null or empty");
			return false;
		}

		if ($('#onboardAttachment').val() == null || $('#onboardAttachment').val() == "") {
			$('#errMessage').text("Confimation mail attachment is necessary to process the request");
			return false;
		}

	}

	if ($('#approvalStatus').val() == 5) {
		if ($('#comments').val() == null || $('#comments').val() == "") {
			$('#errMessage').text("Comments cannot be null or empty. Please fill the reason for the rejection in comments field.");
			return false;
		}

		if ($('#nationwideIdCreatedDate').val() != null && $('#nationwideIdCreatedDate').val() != "") {
			$('#errMessage').text("You have selected Rejected as Approval Status. For a Rejected request, there will not be any Nationwide ID Created Date.");
			return false;
		}
	}

	return true;

}
//global JS objects of this file
var jsonRequest = {}
var resultData;
$(document).ready(function() {
	
	document.getElementById("releaseTab").click();
	loadApprovalStatus();
	loadBands();
	loadReleaseStatus();
	loadReleaseReason();
	loadMovementDetails();
	
	$("#releaseStatus").change(function() {
		
		var selectedVal = $("#releaseStatus").val();
		$.each(releaseStat.responseList, function(key,value) {  
			if(selectedVal == value.id ){
				 $("#releaseStatusId").val(value.id);
			}
		});
	})
	
	$("#releaseSummary").change(function() {
		
		var selectedVal = $("#releaseSummary").val();
		$.each(releaseReason.responseList, function(key,value) { 
			if(selectedVal == value.id ){
				 $("#reasonForOffboarding").val(value.id);
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
			console.log(resultData);
			console.log(resultData.responseList);
			if (resultData.status == "SUCCESS") {
				$.each(resultData.responseList, function(key,value) {   
					$('#approvalStatus')
			         .append($("<option></option>")
			                    .attr("value",value.id)
			                    .text(value.status)); 
				});
			} else {
				console.log("getallapprovalstatus failure Call");
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
			console.log(resultData);
			console.log(resultData.responseList);
			if (resultData.status == "SUCCESS") {
				$.each(resultData.responseList, function(key,value) {   
					if($("#bandId").val() == value.id ){
						$('#band').val(value.bandName);
					}
				});
			} else {
				console.log("bands failure Call");
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
					if($("#movementId").val() == value.id ){
						 $('#movement').val(value.movement)
					}
				});
			} else {
				console.log("getmovements failure Call");
			}
		}
	});
}

function loadReleaseStatus() {
	var initVal = $('#releaseinit').val();
	$.ajax({
		type : 'GET',
		url : "/onboarding/status/getallreleasestatus",
		dataType : "json",
		success : function(resultData) {
			console.log(resultData);
			console.log(resultData.responseList);
			if (resultData.status == "SUCCESS") {
				releaseStat = resultData;
				$.each(resultData.responseList, function(key, value) {
					if (value.id == 1) {
						$('#releaseStatus').append(
								$("<option></option>").attr("value", value.id)
										.attr("disabled", true).text(
												value.status));
					} else if (value.id == 3 && initVal == 1) {
						$('#releaseStatus').append(
								$("<option></option>").attr("value", value.id)
										.attr("disabled", true).text(
												value.status));
					} else {
						$('#releaseStatus').append(
								$("<option></option>").attr("value", value.id)
										.text(value.status));
					}

				});
			} else {
				console.log("Get all releasestatus failure Call");
			}

			$('select[name="releaseStatus"]').find(
					'option[value=' + $('#releaseStatusId').val() + ']').attr(
					"selected", true);
		}
	});
}

function loadReleaseReason(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/release/getreleasesummary",
		dataType : "json",
		success : function(resultData) {
			console.log(resultData);
			console.log(resultData.responseList);
			if(resultData.status == "SUCCESS")
				{
			releaseReason = resultData;
			$.each(resultData.responseList, function(key,value) {   
				$('#releaseSummary')
		         .append($("<option></option>")
		                    .attr("value",value.id)
		                    .text(value.summary)); 
			});
		} else {
			console.log("releaseSummary failure Call");
		}
			$('select[name="releaseSummary"]').find('option[value='+ $('#reasonForOffboarding').val() +']').attr("selected",true);
		}
	});
}


function validateForm() {
    if (($('#releaseStatus').val() != 2) && ($('#releaseStatus').val() != 3)) {
           $('#errMessage').text("Release Status must be selected with either value as RELEASE INITIATED or RELEASED.");
           return false;
    }
    
    if ($('#releaseSummary').val() == null || $('#releaseSummary').val() == "") {
           $('#errMessage').text("Release Summary cannot be null or empty");
           return false;
    } 
    
    if ($('#releaseDate').val() == null || $('#releaseDate').val() == "") {
           $('#errMessage').text("Release Date cannot be null or empty");
           return false;
    } 
    return true;
}


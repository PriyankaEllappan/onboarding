var jsonRequest = {}

$(document).ready(function() {
	
	document.getElementById("releaseTab").click();
	loadApprovalStatus();
	loadBands();
	loadReleaseStatus();
	loadReleaseReason();
	loadMovementDetails();
	
	$("#releaseStatus").change(function() {
		
		var selectedVal = $("#releaseStatus").val();
		$.each(releaseStat, function(key,value) {  
			if(selectedVal == value.id ){
				 $("#releaseStatusId").val(value.id);
			}
		});
	})
	
	$("#releaseSummary").change(function() {
		
		var selectedVal = $("#releaseSummary").val();
		$.each(releaseReason, function(key,value) { 
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
		dataType : "text",
		success : function(resultData) {
			approvalStat = JSON.parse(resultData);
			$.each(approvalStat, function(key,value) {   
				$('#approvalStatus')
		         .append($("<option></option>")
		                    .attr("value",value.id)
		                    .text(value.status)); 
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
				if($("#bandId").val() == value.id ){
					$('#band').val(value.bandName);
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
				if($("#movementId").val() == value.id ){
					 $('#movement').val(value.movement)
				}
			});
		}
	});
}

function loadReleaseStatus(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/status/getallreleasestatus",
		dataType : "text",
		success : function(resultData) {
			releaseStat = JSON.parse(resultData);
			$.each(releaseStat, function(key,value) {   
				/*$('#releaseStatus')
		         .append($("<option></option>")
		                    .attr("value",value.id)
		                    .text(value.status)); */
                if(value.id == 1){
                    $('#releaseStatus')
                .append($("<option></option>")
                           .attr("value",value.id)
                           .attr("disabled", true)
                           .text(value.status));
                } else {
                    $('#releaseStatus')
                .append($("<option></option>")
                           .attr("value",value.id)
                           .text(value.status));
             }

		});
			$('select[name="releaseStatus"]').find('option[value='+ $('#releaseStatusId').val() +']').attr("selected",true);
		}
	});
}

function loadReleaseReason(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/release/getreleasesummary",
		dataType : "text",
		success : function(resultData) {
			releaseReason = JSON.parse(resultData);
			$.each(releaseReason, function(key,value) {   
				$('#releaseSummary')
		         .append($("<option></option>")
		                    .attr("value",value.id)
		                    .text(value.summary)); 
			});
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


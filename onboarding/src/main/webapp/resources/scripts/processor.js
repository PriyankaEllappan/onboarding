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
	
	document.getElementById("defaultOpen").click();
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
	alert("Inside");
	/*if ($('#newEmpID').val() == null || $('#newEmpID').val() == "") {
		$('#errMessage').text("Employee ID cannot be null or empty");
		return false;
	} 
	if ($('#newEmpDOB').val() == null || $('#newEmpDOB').val() == "") {
		$('#errMessage').text("Date of Birth cannot be null or empty");
		return false;
	} 
	if ($('#newEmpPPNo').val() == null || $('#newEmpPPNo').val() == "") {
		$('#errMessage').text("Passport number cannot be null or empty");
		return false;
	} */
	return true;
}
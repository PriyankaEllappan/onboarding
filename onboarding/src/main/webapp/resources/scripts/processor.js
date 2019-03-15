var jsonRequest = {}

$(document).ready(function() {
	
	/* DatePicker Options */
	var nwIdCreatedDate = $('#nwIdCreatedDate');
	var fgOnboardingDate = $('#fgOnboardingDate');
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
				$('#approvalStatus')
		         .append($("<option></option>")
		                    .attr("value",value.id)
		                    .text(value.status)); 
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
			console.log(bandDetails);
			$.each(bandDetails, function(key,value) {   
			     $('#band')
			         .append($("<option></option>")
			                    .attr("value",value.bandName)
			                    .text(value.bandName)); 
			});
		}
	});
}

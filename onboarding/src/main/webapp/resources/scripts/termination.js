var jsonRequest = {}

$(document).ready(function() {
	
	/* DatePicker Options */
	var releaseDate = $('#releaseDate');
	var container = $('.content-style');
	var options = {
		format : 'yyyy-mm-dd',
		container : container,
		todayHighlight : true,
		autoclose : true,
	};
	releaseDate.datepicker(options);
	
	document.getElementById("defaultOpen").click();
	loadApprovalStatus();
	loadReleaseStatus();
	loadReleaseReason();
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
		url : "/onboarding/status/getallreleasestatus",
		dataType : "text",
		success : function(resultData) {
			releaseStat = JSON.parse(resultData);
			$.each(releaseStat, function(key,value) {   
				$('#releaseStatus')
		         .append($("<option></option>")
		                    .attr("value",value.id)
		                    .text(value.status)); 
			});
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
				$('#reasonForOffboarding')
		         .append($("<option></option>")
		                    .attr("value",value.id)
		                    .text(value.summary)); 
			});
		}
	});
}

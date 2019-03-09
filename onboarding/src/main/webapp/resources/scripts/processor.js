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

/* Processor Register Submit */
$(function() {
	$('#processorFormSubmit').click(function(e) {
		e.preventDefault();
		setRequestParams();
		$.post({
			url : '/onboarding/process/processupdate',
			type : 'POST',
			dataType : 'json',
			data : JSON.stringify(jsonRequest),
			contentType : 'application/json; charset=utf-8',
			success : function(resultData) {
				console.log(resultData);
				if (!$.trim(resultData)) {
					$('#messageDiv').removeClass('hideElements');
					$('#messageDiv').text("Unable to Process the request");
					$('#messageDiv').addClass('showElements');
					$('#formDiv').addClass('hideElements');
				} else {
					$('#messageDiv').removeClass('hideElements');
					$('#messageDiv').text("Request processed");
					$('#messageDiv').addClass('showElements');
					$('#formDiv').addClass('hideElements');
				}
			},
			error : function() {
				console.log("error");
				$('#messageDiv').removeClass('hideElements');
				$('#messageDiv').text("Unable to Process the request");
				$('#messageDiv').addClass('showElements');
				$('#formDiv').addClass('hideElements');
			}
		})
	});
});

function setRequestParams() {
	jsonRequest["id"] = $('#empProjId').val();
	jsonRequest["requesterId"] = $('#requesterID').val();
	jsonRequest["processorId"] = $('#processorID').val();
	jsonRequest["releaseDate"] = $('#releaseDate').val();
	jsonRequest["releaseStatus"] = $('#releaseStatus').val();
	jsonRequest["releaseSummary"] = $('#releaseReason').val();
	jsonRequest["approvalStatus"] = $('#approvalStatus').val();
	jsonRequest["comments"] = $('#comments').val();
	jsonRequest["fgOnboardingDate"] = $('#fgOnboardingDate').val();
	jsonRequest["nationwideidCreatedDate"] = $('#nwIdCreatedDate').val();
	jsonRequest["natiowideID"] = $('#nationwideID').val();
}
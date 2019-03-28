/*Common Operations*/

$(document).ready(function() {
	/* DatePicker Options */
	var datePicker = $('.load-date-picker');
	var container = $('.content-style');
	
	var options = {
		format : 'yyyy-mm-dd',
		container : container,
		todayHighlight : true,
		autoclose : true,
	};
	
	datePicker.datepicker(options);
	
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
    if(tabName == "releaseInfo"){
    	document.getElementById("releaseTab").className += " active";
    }
}
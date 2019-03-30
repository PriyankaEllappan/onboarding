/*Common Operations*/

$(document).ready(function() {
	/* DatePicker Options */
	var dateofBirthPicker = $('.load-dob-picker');
	var commonDatePicker = $('.load-date-picker');
	
	var container = $('.content-style');
	
	var options1 = {
		format : 'yyyy-mm-dd',
		container : container,
		todayHighlight : true,
		autoclose : true,
		startDate: '-3d',
		endDate: '+3d' //Start Date 2019 Jan --> 2050
	};
	
	var options2 = {
			format : 'yyyy-mm-dd',
			container : container,
			todayHighlight : true,
			autoclose : true,
			startDate: '-3d',
			endDate: '1d' //Start Date 1950 --> End date Today
		};
	
	dateofBirthPicker.datepicker(options1);
	commonDatePicker.datepicker(options2);
	
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
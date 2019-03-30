/*Common Operations*/

$(document).ready(function() {
	/* DatePicker Options */
	var dateofBirthPicker = $('.load-dob-picker');
	var commonDatePicker = $('.load-date-picker');
	
	var container = $('.content-style');
	
	var commonPickerOptions = {
		format : 'yyyy-mm-dd',
		container : container,
		todayHighlight : true,
		autoclose : true,
        startDate: '1950-01-01',
        endDate: '2050-01-01' 
	};
	
	var dobPickerOptions = {
			format : 'yyyy-mm-dd',
			container : container,
			todayHighlight : true,
			autoclose : true,
			startDate: '1950-01-01',
            endDate: 'd' 
		};
	
	dateofBirthPicker.datepicker(dobPickerOptions);
	commonDatePicker.datepicker(commonPickerOptions);
	
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
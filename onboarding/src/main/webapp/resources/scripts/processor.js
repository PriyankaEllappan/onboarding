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
	
})
$(document).ready(function() {
	
	$('#mailPinLink').click(function() {
		var empId = $('#userName').val();
		if (empId == null || empId == "") {
			$('#errMessage').text("User Name can't be empty");
		} else {
			$.ajax({
				type : 'GET',
				url : "/onboarding/generatepin/" + empId,
				dataType : "json",
				success : function(resultData) {
					if (resultData.status == "SUCCESS") {
						$('#successMessage').text("Pin number sent successfully.");
						$('#hiddenPin').val(resultData.responseObj);
					} else {
						$('#errMessage').text("Unable to send the Mail Pin. Please try again.");
					}
				}
			});
		}
	});
});

/*function validateForm() {

	if ($('#userName').val() == null || $('#userName').val() == "" || isNaN($('#userName').val())) {
		$('#errMessage').text("Employee ID Should be Numeric Value ");
		return false;
	}
	if ($('#currentPassword').val() == null || $('#currentPassword').val() == "") {
		$('#errMessage').text("Current Password cannot be null or empty");
		return false;
	}
	if ($('#newPassword').val() == null || $('#newPassword').val() == "") {
		$('#errMessage').text("New Password cannot be null or empty");
		return false;
	}
	return true;
}*/

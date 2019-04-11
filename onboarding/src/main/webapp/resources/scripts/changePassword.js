$(document).ready(function() {
	
	$('#mailPin').prop('disabled', true);
	$('#changePasswordFormSubmit').prop('disabled', true);
	
	$('#mailPinLink').click(function() {
		$('#successMessage').text("");
		$('#errMessage').text("");
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
						$('#successMessage').text("Pin number sent successfully to your Cognizant Mail.");
						$('#hiddenPin').val(resultData.responseObj);
						$('#mailPin').prop('disabled', false);
						$('#changePasswordFormSubmit').prop('disabled', false);
					} else {
						$('#errMessage').text("Unable to send the Mail Pin. Please try again.");
					}
				}
			});
		}
	});
});

function validateForm() {
	$('#successMessage').text("");
	$('#errMessage').text("");
	if ($('#userName').val() == null || $('#userName').val() == ""
			|| isNaN($('#userName').val())) {
		$('#errMessage').text("Employee ID Should be Numeric Value ");
		return false;
	}
	if ($('#currPassword').val() == null || $('#currPassword').val() == "") {
		$('#errMessage').text("Current Password cannot be null or empty");
		return false;
	}
	if ($('#newPassword').val() == null || $('#newPassword').val() == "") {
		$('#errMessage').text("New Password cannot be null or empty");
		return false;
	}
	if ($('#mailPin').val() == null || $('#mailPin').val() == "") {
		$('#errMessage').text("Mail Pin can't be null or empty");
		return false;
	}
	return true;
}

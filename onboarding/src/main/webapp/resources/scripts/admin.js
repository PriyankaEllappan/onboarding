var jsonRequest = {}

$(document).ready(function() {

});
$(function() {
	$('#userRegisterFormSubmit').click(function(e) {
				e.preventDefault();
				$('#errMessage').text("");
				var validationStatus = validateForm();
				if (validationStatus == true) {
					$('#userRegisterFormSubmit').prop('disabled', true);
					$('#userRegisterFormSubmit').css('cursor','not-allowed');
					setRequestParams();
					$
					.post({
						url : '/onboarding/admin/register',
						type : 'POST',
						dataType : 'json',
						data : JSON.stringify(jsonRequest),
						contentType : 'application/json; charset=utf-8',
						success : function(resultData) {
							if (resultData.status == "SUCCESS") {
								$('#userRegisterFormDiv').hide();
								$('#statusSucessMessage').text(resultData.statusMessage);
								$('#userRegisterFormSubmit').prop('disabled', false);
								$('#userRegisterFormSubmit').css('cursor','pointer');
							} else {
								$('#errMessage').text(resultData.statusMessage);
								$('#userRegisterFormSubmit').prop('disabled', false);
								$('#userRegisterFormSubmit').css('cursor','pointer');
							}
						},
						error : function() {
							$('#errMessage').text("Unable to Add User into the database.");
							$('#userRegisterFormSubmit').prop('disabled', false);
							$('#userRegisterFormSubmit').css('cursor', 'pointer');
						}
					})
				}
			});
});

function setRequestParams() {
	jsonRequest["empID"] = $('#newEmpID').val();
	jsonRequest["role"] = $('#role').val();
}

function validateForm() {

	if ($('#newEmpID').val() == null || $('#newEmpID').val() == "" ||isNaN($('#newEmpID').val())) {
		$('#errMessage').text("Employee ID Should be Numeric Value ");
		return false;
	}
	if ($('#role').val() == null || $('#role').val() == "") {
		$('#errMessage').text("Role needs to be selected");
		return false;
	}
	return true;
}

$(document).ready(function() {
	/* DatePicker Options */
	var dateOfBirth = $('#newEmpDOB');
	var container = $('.content-style');
	var options = {
		format : 'yyyy-mm-dd',
		container : container,
		todayHighlight : true,
		autoclose : true,
	};

	dateOfBirth.datepicker(options);

	/* Employee Search function */
	$("#checkEmpIdSubmit").click(function() {
		var empId = $("#checkEmpId").val();
		console.log(empId);
		checkForanEmployee(empId);
	})

	$("#addResourceLabel").click(function() {
		$("#toggleResource").toggle();
	})

	/* Employee details Search */
	$("#newEmpID").blur(function() {
		var empId = $('#newEmpID').val();
		$.ajax({
			type : 'GET',
			url : "/onboarding/resource/getemployee?empId=" + empId,
			dataType : "text",
			success : function(resultData) {
				if (!$.trim(resultData)) {
					console.log("Resource not available in directory");
				} else {
					var returnedData = JSON.parse(resultData);
					$('#newEmpName').val(returnedData.name);
					$('#newEmpEmail').val(returnedData.emailId);
					$('#newEmpFName').val(returnedData.name.split(" ")[0]);
					$('#newEmpLName').val(returnedData.name.split(" ")[1]);
				}
			}
		});
	});

	/* Employee Register Submit */
	$(function() {
		$('#resourceRegisterFormSubmit').click(function(e) {
			e.preventDefault();
			var validationStatus = validateForm();
			if(validationStatus == true){
				jsonStr = {}
				jsonStr["id"] = $('#newEmpID').val();
				jsonStr["name"] = $('#newEmpName').val();
				jsonStr["firstName"] = $('#newEmpFName').val();
				jsonStr["lastName"] = $('#newEmpLName').val();
				jsonStr["dob"] = $('#newEmpDOB').val();
				jsonStr["email"] = $('#newEmpEmail').val();
				jsonStr["passportNumber"] = $('#newEmpPPNo').val();
				$.post({
					url : '/onboarding/request/addresource',
					type : 'POST',
					dataType : 'json',
					data : JSON.stringify(jsonStr),
					contentType : 'application/json; charset=utf-8',
					success : function(resultData) {
						console.log(resultData);
						if (!$.trim(resultData)) {
							$('#resourceNonAvailable').removeClass('showElements');
							$('#resourceNonAvailable').addClass('hideElements');
							$('#registerStatus').text("Resource Not Registered");
							$('#registerStatus').addClass('showElements');
						} else {
							$('#resourceNonAvailable').removeClass('showElements');
							$('#resourceNonAvailable').addClass('hideElements');
							$('#registerStatus').text("Resource Registered");
							$('#registerStatus').addClass('showElements');
						}
					},
					error : function() {
						$('#resourceNonAvailable').removeClass('showElements');
						$('#resourceNonAvailable').addClass('hideElements');
						$('#registerStatus').text("Resource Not Registered");
						$('#registerStatus').addClass('showElements');
					}
				})
			}
		});
	});

})

function checkForanEmployee(empID) {
	console.log("checkForanEmployee");
	$.ajax({
		type : 'GET',
		url : "/onboarding/request/check/" + empID,
		dataType : "text",
		success : function(resultData) {
			if (!$.trim(resultData)) {
				console.log("Empty Response");
				$('#resourceNonAvailable').addClass('showElements');
			} else {
				var returnedData = JSON.parse(resultData);
				$('#availEmpID').text(returnedData.id);
				$('#availEmpName').text(returnedData.name);
				$('#availEmpDOB').text(returnedData.DOB);
				$('#availEmpEmail').text(returnedData.email);
				$('#availEmpPPNo').text(returnedData.passportNumber);
				$('#resourceAvailable').addClass('showElements');
				console.log("Response has data");
				console.log(returnedData);
			}

		}
	});
}

function validateForm() {
	if ($('#newEmpID').val() == null || $('#newEmpID').val() == "") {
		$('#newEmpIDErr').text("Employee ID cannot be null or empty");
		return false;
	} else {
		$('#newEmpIDErr').text("");
	}

	if ($('#newEmpDOB').val() == null || $('#newEmpDOB').val() == "") {
		$('#dateOfBirthErr').text("Date of Birth cannot be null or empty");
		return false;
	} else {
		$('#dateOfBirthErr').text("");
	}

	if ($('#newEmpPPNo').val() == null || $('#newEmpPPNo').val() == "") {
		$('#passportNoErr').text("Passport number cannot be null or empty");
		return false;
	} else {
		$('#passportNoErr').text("");
	}
	return true;
}

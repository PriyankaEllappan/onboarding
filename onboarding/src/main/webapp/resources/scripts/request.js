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
	
	/*Default Hide Tags*/
	$("#resourceNonAvailable").hide();
	$("#resourceAvailable").hide();
	$("#resourceAddedSubmit").hide();
	
	/* Employee Search function */
	$("#checkEmpIdSubmit").click(function() {
		$("#checkEmpId").attr("disabled", "disabled");
		$('#checkEmpIdSubmit').prop('disabled', true);
		$('#checkEmpIdSubmit').css('cursor', 'not-allowed');
		var empId = $("#checkEmpId").val();
		checkForanEmployee(empId);
	})

	$("#availableAssignProj").click(function() {
		$('#availableAssignProj').css('cursor', 'not-allowed');
		var empId = $("#availEmpID").text();
		checkForanActiveAssignment(empId);
	})
	
	$("#nonAvailableAssignProj").click(function() {
		$('#nonAvailableAssignProj').css('cursor', 'not-allowed');
		window.location = "/onboarding/request/mapproject/" + $("#newEmpID").val();
	})
	
	/* Confirm to add resource function */
	$("#confirmTagging").click(function() {
		window.location = "/onboarding/request/mapproject/" + $("#availEmpID").text();
	})
	
	/* Confirm to add resource function */
	/*$("#confirmAddResource").click(function() {
		var empId = $('#checkEmpId').val();
		loadEmployeeDetails(empId);
		$("#resourceNonAvailable").show();
	})*/

	/* Employee Register Submit */
	$(function() {
		$('#resourceRegisterFormSubmit').click(function(e) {
			e.preventDefault();
			$('#errMessage').text("");
			var validationStatus = validateForm();
			if(validationStatus == true){
				$('#resourceRegisterFormSubmit').prop('disabled', true);
				$('#resourceRegisterFormSubmit').css('cursor', 'not-allowed');
				jsonStr = {}
				jsonStr["employeeId"] = $('#newEmpID').val();
				jsonStr["name"] = $('#newEmpName').val();
				jsonStr["firstName"] = $('#newEmpFName').val();
				jsonStr["lastName"] = $('#newEmpLName').val();
				jsonStr["dateOfBirth"] = $('#newEmpDOB').val();
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
							$('#errMessage').text("Resource Not Registered. Incorrect details entered.");
							$('#resourceRegisterFormSubmit').prop('disabled', false);
							$('#resourceRegisterFormSubmit').css('cursor', 'pointer');
						} else {
							$("#resourceNonAvailable").hide();
							$('#statusSucessMessage').text("Resource Registered");
							$('#addedResEmpID').text(resultData.employeeId);
							$('#addedResEmpName').text(resultData.name);
							$('#addedResEmpDOB').text(resultData.dateOfBirth);
							$('#addedResEmpEmail').text(resultData.email);
							$('#addedResEmpPPNo').text(resultData.passportNumber);
							$("#resourceAddedSubmit").show();
						}
					},
					error : function() {
						$('#errMessage').text("Resource Not Registered. Incorrect details entered.");
						$('#resourceRegisterFormSubmit').prop('disabled', false);
						$('#resourceRegisterFormSubmit').css('cursor', 'pointer');
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
				/*$('#NoResourceModal').modal('show');*/
				var empId = $('#checkEmpId').val();
				loadEmployeeDetails(empId);
				
			} else {
				var returnedData = JSON.parse(resultData);
				$('#availEmpID').text(returnedData.employeeId);
				$('#availEmpName').text(returnedData.name);
				$('#availEmpDOB').text(returnedData.dateOfBirth);
				$('#availEmpEmail').text(returnedData.email);
				$('#availEmpPPNo').text(returnedData.passportNumber);
				$("#resourceAvailable").show();
			}
		}
	});
}

function checkForanActiveAssignment(empID) {
	var counter = 0;
	$.ajax({
		type : 'GET',
		url : "/onboarding/request/checkactiveassignments/" + empID,
		dataType : "text",
		success : function(resultData) {
			if (!$.trim(resultData)) {
				window.location = "/onboarding/request/mapproject/" + $("#availEmpID").text();
			} else {
				var returnedData = JSON.parse(resultData);
				console.log("Response has data");
				console.log(returnedData);
				$.each(returnedData, function(key, value) {
					counter = counter + 1;
					$('#availableProjects').append(
							'<tr><td>&nbsp;&nbsp;' + value.name +
							'</td><td>&nbsp;&nbsp;'
									+ value.projectName + '</td><td>&nbsp;&nbsp;'
									+ value.teamName + '</td></tr>');
				});
				if(counter >= 2){
					$('#errMessage').text("Resource is already tagged under two projects");
				}else{
					$('#ActiveAssignment').modal('show');
				}
			}
		}
	});
}

function validateForm() {
	if ($('#newEmpID').val() == null || $('#newEmpID').val() == "") {
		$('#errMessage').text("Employee ID cannot be null or empty");
		return false;
	} 
	if ($('#newEmpDOB').val() == null || $('#newEmpDOB').val() == "") {
		$('#errMessage').text("Date of Birth cannot be null or empty");
		return false;
	} 
	if ($('#newEmpPPNo').val() == null || $('#newEmpPPNo').val() == "") {
		$('#errMessage').text("Passport number cannot be null or empty");
		return false;
	} 
	return true;
}

function loadEmployeeDetails(empId){
	$.ajax({
		type : 'GET',
		url : "/onboarding/resource/getemployee?empId=" + empId,
		dataType : "text",
		success : function(resultData) {
			if (!$.trim(resultData)) {
				$('#errMessage').text("Resource not available in Cognizant Directory. Please check the Employee ID");
			} else {
				var returnedData = JSON.parse(resultData);
				$('#newEmpID').val(empId);
				$('#newEmpName').val(returnedData.name);
				$('#newEmpEmail').val(returnedData.emailId);
				$('#newEmpFName').val(returnedData.name.split(" ")[0]);
				$('#newEmpLName').val(returnedData.name.split(" ")[1]);
				$("#resourceNonAvailable").show();
			}
		}
	});
}

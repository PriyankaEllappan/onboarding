$(document).ready(function() {
	
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
		$("#availableProjects").empty();
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
						if (resultData.status == "SUCCESS") {
							$("#resourceNonAvailable").hide();
							$('#statusSucessMessage').text(resultData.statusMessage);
							$('#addedResEmpID').text(resultData.responseObj.employeeId);
							$('#addedResEmpName').text(resultData.responseObj.name);
							$('#addedResEmpDOB').text(resultData.responseObj.dateOfBirth);
							$('#addedResEmpEmail').text(resultData.responseObj.email);
							$('#addedResEmpPPNo').text(resultData.responseObj.passportNumber);
							$("#resourceAddedSubmit").show();
						}
						else {
							$('#errMessage').text(resultData.statusMessage);
							$('#resourceRegisterFormSubmit').prop('disabled', false);
							$('#resourceRegisterFormSubmit').css('cursor', 'pointer');
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
       $('#errMessage').text("");
       $.ajax({
              type : 'GET',
              url : "/onboarding/request/check/" + empID,
              dataType : "json",
              success : function(resultData) {
            	  console.log(resultData);
            	  	if (resultData.status == "SUCCESS") {
                    	 
                    	 $('#availEmpID').text(resultData.responseObj.employeeId);
                         $('#availEmpName').text(resultData.responseObj.name);
                         $('#availEmpDOB').text(resultData.responseObj.dateOfBirth);
                         $('#availEmpEmail').text(resultData.responseObj.email);
                         $('#availEmpPPNo').text(resultData.responseObj.passportNumber);
                         $("#resourceAvailable").show();
                     } else {
                           var empId = $('#checkEmpId').val();
                           loadEmployeeDetails(empId);
                     }
              }
       });
}

function checkForanActiveAssignment(empID) {
	var counter = 0;
	$
			.ajax({
				type : 'GET',
				url : "/onboarding/request/checkactiveassignments/" + empID,
				dataType : "json",
				success : function(resultData) {
					console.log(resultData);
					if (resultData.status == "SUCCESS") {
						$('#availableProjects')
								.append(
										"<thead><tr><th>Name</th><th>Project Name</th><th>Team Name</th></tr></thead>");
						$.each(resultData.responseList, function(key, value) {
							counter = counter + 1;
							$('#availableProjects').append(
									'<tr><td>&nbsp;&nbsp;' + value.name
											+ '</td><td>&nbsp;&nbsp;'
											+ value.projectName
											+ '</td><td>&nbsp;&nbsp;'
											+ value.teamName + '</td></tr>');
						});
						if (counter >= 2) {
							$('#errMessage')
									.text(
											"Resource is already tagged under two projects");
						} else {
							$('#ActiveAssignment').modal('show');
						}
					} else if (resultData.status == "AJAXNONAVAILABLE") {
						window.location = "/onboarding/request/mapproject/"
								+ $("#availEmpID").text();
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
		dataType : "json",
		success : function(resultData) {
			console.log(resultData);
			if (resultData.status == "SUCCESS") {
				$('#newEmpID').val(empId);
				$('#newEmpName').val(resultData.responseObj.name);
				$('#newEmpEmail').val(resultData.responseObj.emailId);
				$('#newEmpFName').val(resultData.responseObj.name.split(" ")[0]);
				$('#newEmpLName').val(resultData.responseObj.name.split(" ")[1]);
				$("#resourceNonAvailable").show();
			 } else {
				 	$("#checkEmpId").val("");
				 	$("#checkEmpId").prop('disabled', false);
					$('#checkEmpIdSubmit').prop('disabled', false);
					$('#checkEmpIdSubmit').css('cursor', 'pointer');
					$('#errMessage').text("Resource not available in Cognizant Directory. Please check the Employee ID");
			 }
		}
	});
}

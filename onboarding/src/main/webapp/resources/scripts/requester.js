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
	
	$("#resourceNonAvailable").hide();
	$("#resourceAvailable").hide();
	$("#NoActiveAssignment").hide();
	$("#projTagDiv").hide();
	
	/* Employee Search function */
	$("#checkEmpIdSubmit").click(function() {
		$('#checkEmpIdSubmit').prop('disabled', true);
		$('#checkEmpIdSubmit').css('cursor', 'not-allowed');
		var empId = $("#checkEmpId").val();
		console.log(empId);
		checkForanEmployee(empId);
	})

	/* Confirm to add resource function */
	$("#confirmAddResource").click(function() {
		$("#resourceNonAvailable").show();
	})
	
	/* Active Assignment check function */
	$("#activeCheck").click(function() {
		/*$('#checkForActiveAssignment').css('cursor', 'not-allowed');*/
		$('#checkForActiveAssignment').hide();
		var empId = $("#availEmpID").text();
		console.log(empId);
		checkForanActiveAssignment(empId);
	})
	
	/* Confirm to add resource function */
	$("#confirmTagging").click(function() {
		$("#projTagDiv").show();
		$("#projTagConf").hide();
	})

	$("#confirmAddProject").click(function() {
		var selectedValue = $('input[name=projMovement]:checked').val(); 
		alert(selectedValue);
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
			$('#errMessage').text("");
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
							$("#resourceNonAvailable").hide();
							$('#errMessage').text("Resource Not Registered");
						} else {
							$("#resourceNonAvailable").hide();
							$('#statusSucessMessage').text("Resource Registered");
						}
					},
					error : function() {
						$("#resourceNonAvailable").hide();
						$('#errMessage').text("Resource Not Registered");
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
				$('#NoResourceModal').modal('show');
			} else {
				var returnedData = JSON.parse(resultData);
				console.log("Response has data");
				console.log(returnedData);
				$('#availEmpID').text(returnedData.id);
				$('#availEmpName').text(returnedData.name);
				$('#availEmpDOB').text(returnedData.DOB);
				$('#availEmpEmail').text(returnedData.email);
				$('#availEmpPPNo').text(returnedData.passportNumber);
				$("#resourceAvailable").show();
			}
		}
	});
}

function checkForanActiveAssignment(empID) {
	console.log("checkForanEmployee");
	$.ajax({
		type : 'GET',
		url : "/onboarding/request/checkActiveAssignment/" + empID,
		dataType : "text",
		success : function(resultData) {
			if (!$.trim(resultData)) {
				console.log("Empty Response");
				$('#NoActiveAssignment').show();
			} else {
				var returnedData = JSON.parse(resultData);
				console.log("Response has data");
				console.log(returnedData);
				$.each(returnedData, function(key,value) {   
				     $('#availableProjects')
				         .append('<tr><td>'+value.projectID+'</td><td>'+value.projectName+'</td></tr>'); 
				});
				$('#ActiveAssignment').modal('show');
				/*$('#availEmpID').text(returnedData.id);
				$('#availEmpName').text(returnedData.name);
				$('#availEmpDOB').text(returnedData.DOB);
				$('#availEmpEmail').text(returnedData.email);
				$('#availEmpPPNo').text(returnedData.passportNumber);
				$("#resourceAvailable").show();*/
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

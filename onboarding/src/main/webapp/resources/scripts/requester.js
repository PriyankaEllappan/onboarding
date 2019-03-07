$(document).ready(function() {
	var dateOfBirth = $('#newEmpDOB');
	var container = $('.content-style');
	var options = {
		format : 'yyyy-mm-dd',
		container : container,
		todayHighlight : true,
		autoclose : true,
	};

	dateOfBirth.datepicker(options);
	
	$("#checkEmpIdSubmit").click(function() {
		var empId = $("#checkEmpId").val();
		console.log(empId);
		checkForanEmployee(empId);
	})
	$("#addResourceLabel").click(function() {
		$("#toggleResource").toggle();
	})

	$("#newEmpID").blur(function() {
		var empId = $('#newEmpID').val();
		$.ajax({
			type : 'GET',
			url : "/onboarding/resource/getEmployee?empId=" + empId,
			dataType : "text",
			success : function(resultData) {
				var returnedData = JSON.parse(resultData);
				$('#newEmpName').val(returnedData.name);
				$('#newEmpEmail').val(returnedData.emailId);
				$('#newEmpFName').val(returnedData.name.split(" ")[0]);
				$('#newEmpLName').val(returnedData.name.split(" ")[1]);
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
				$('#availEmpDOB').text(returnedData.dob);
				$('#availEmpEmail').text(returnedData.firstName);
				$('#availEmpPPNo').text(returnedData.passportNumber);
				$('#resourceAvailable').addClass('showElements');
				console.log("Response has data");
				console.log(returnedData);
			}

		}
	});
}

function registerEmployee() {
	jsonStr = {}
	jsonStr["id"] = $('#newEmpID').val();
	jsonStr["name"] = $('#newEmpName').val();
	jsonStr["firstName"] = $('#newEmpFName').val();
	jsonStr["lastName"] = $('#newEmpLName').val();
	jsonStr["dob"] = $('#newEmpDOB').val();
	jsonStr["email"] = $('#newEmpEmail').val();
	jsonStr["passportNumber"] = $('#newEmpPPNo').val();
	alert(JSON.stringify(jsonStr));
	console.log(jsonStr);
	$.ajax({
		url : '/onboarding/request/addResource/',
		type : 'POST',
		data : JSON.stringify(jsonStr),
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		async : false,
		cache : false,
		processData : false,
		success : function(response) {
			if (response.msgtype == "success" || response.msgtype == "fail") {
				clearconsole();
			}
			console.log(msg);
		}
	});
}
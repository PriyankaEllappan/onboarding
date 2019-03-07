$(document).ready(function() {
	$("#checkEmpIdSubmit").click(function() {
		var empId = $("#checkEmpId").val();
		console.log(empId);
		checkForanEmployee(empId);
	})
	$("#addResourceLabel").click(function() {
		$("#toggleResource").toggle();
	})
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
		cache: false,
		processData:false,
		success : function(msg) {
			console.log(msg);
		}
	});
}
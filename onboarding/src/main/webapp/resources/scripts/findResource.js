$(document).ready(function() {
	/* Employee Search function */
	$("#checkEmpIdSubmit").click(function() {
		$("#checkEmpId").attr("disabled", "disabled");
		$('#checkEmpIdSubmit').prop('disabled', true);
		$('#checkEmpIdSubmit').css('cursor', 'not-allowed');
		var empId = $("#checkEmpId").val();
		checkForanEmployee(empId);
	})
});


function checkForanEmployee(empID) {
    console.log("checkForanEmployee");
    $('#errMessage').text("");
    $.ajax({
           type : 'GET',
           url : "/onboarding/release/getresourcebyid/" + empID,
           dataType : "json",
           success : function(resultData) {
         	  alert(resultData.status);
         	  console.log(resultData);
         	  	if (resultData.status == "SUCCESS") {
         	  		$('#releaseTable').append("<thead><tr><th>Employee Id</th><th>Employee Name</th><th>Project Id</th><th>Project Name</th><th>Team Name</th><th>Release Status</th></tr></thead>");
         	  		$.each(resultData.responseList, function(key, value) {
         	  			$('#releaseTable').append(
								"<tr><td>" + value.employeeId + "</td><td>"
										+ value.name + "</td><td>"
										+ value.projectId + "</td><td>"
										+ value.projectName + "</td><td>"
										+ value.teamName + "</td><td><button class='btn-danger to-click' id=" + value.id + " onclick='loadReleaseForm(this.id);'" +
										">Release</button></td></tr>");
    				});
                  } else {
                	  	$('#checkEmpId').prop('disabled', false);
                	  	$('#checkEmpId').val("");
              			$('#checkEmpIdSubmit').prop('disabled', false);
              			$('#checkEmpIdSubmit').css('cursor', 'pointer');
                	  $('#errMessage').text(resultData.statusMessage);  
                  }
           }
    });
}

function loadReleaseForm(id){
	window.location = "/onboarding/release/requestrelease/" + id;
}
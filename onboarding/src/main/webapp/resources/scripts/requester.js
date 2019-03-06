
$(document).ready(function() {
       $("#checkEmpIdSubmit").click(function(){
    	   var empId=$("#checkEmpId").val();
    	   console.log(empId);
    	   checkForanEmployee(empId);
       })
})


function checkForanEmployee(empID) {
	 console.log("checkForanEmployee");
	$.ajax({
		type : 'GET',
		url : "/onboarding/request/check/" + empID,
		dataType : "text",
		success : function(resultData) {
			var returnedData = JSON.parse(resultData);
			console.log("hi ");
			console.log(JSON.parse(resultData));
		}
	});
}
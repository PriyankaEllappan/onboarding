
$(document).ready(function() {
       $("#checkEmpIdSubmit").click(function(){
    	   var empId=$("#checkEmpId").val();
    	   console.log(empId);
    	   checkForanEmployee(empId);
       })
       $("#addResourceLabel").click(function(){
    	   $("#toggleResource").toggle(); 
       })
       $("#addProjectLabel").click(function(){
    	   $("#toggleProject").toggle(); 
       })
})


function checkForanEmployee(empID) {
	 console.log("checkForanEmployee");
	$.ajax({
		type : 'GET',
		url : "/onboarding/request/check/" + empID,
		dataType : "text",
		success : function(resultData) {
			if (!$.trim(resultData)){   
				console.log("Empty Response");
				/*$('#resourceNonAvailable').addClass('showElements');*/
				$('#resourceAvailable').addClass('showElements');
			}
			else{   
				var returnedData = JSON.parse(resultData);
				console.log("Response has data");
				console.log(returnedData);
			}
			
		}
	});
}
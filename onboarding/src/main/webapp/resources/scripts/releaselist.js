$(document).ready(function() {
	loadTableData();
});

function loadTableData(){
	$.ajax({
		type : 'GET',
		url : "/onboarding/release/resources",
		dataType : "text",
		success : function(resultData) {
			resourceList = JSON.parse(resultData);
			$.each(resourceList, function(key,value) { 
				$('#releaseTable')
			    .append($("<tr><td>" + value.employeeId +"</td><td>"+ value.projectName +"</td><td>"+value.teamName+"</td></tr>"));
			});
		}
	});
}

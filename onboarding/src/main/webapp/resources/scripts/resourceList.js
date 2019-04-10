$(document).ready(function() {
    $('#resourceTable').DataTable( {
        "ajax": "/onboarding/resource/getemployeelist",
        "columns": [
            { "data": "employeeId" },
            { "data": "name" },
            { "data": "dateOfBirth" },
            { "data": "email" }
        ]
    } );
} );

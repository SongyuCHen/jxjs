/**
 * 
 */
var baseUrl = getRootPath();

$(function(){
	g_dataTable = $("#dataTable").DataTable({
         order : [[ 5, "desc" ]]
	});
	fetchData();
});

function fetchData(){
	
}
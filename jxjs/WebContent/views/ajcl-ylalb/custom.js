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


//获取数据
function fetchData(){
	$.ajax({
		url :  baseUrl+"/ajcl/ylalb.json",
		type : "get",
		data : {},
		dataType : 'html',
		success : function(resp) {
			alert(resp);
		}
	});
}
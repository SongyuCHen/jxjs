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
			resp = $.parseJSON(resp);
			g_dataTable.clear().destroy();
			$("#dataTable>tbody").empty();
			for(var i = 0 ; i < resp.length ; i++){
				$("#dataTable>tbody").append("<tr>"+
						"<td>"+i+"</td>"+
						"<td>"+resp[i].ah+"</td>"+
						"<td>"+resp[i].ajmc+"</td>"+
						"<td>"+resp[i].sqlx+"</td>"+
						"<td>"+resp[i].ysah+"</td>"+
						"<td>"+resp[i].lasj+"</td>"+
					"</tr>");
			}
			g_dataTable = $("#dataTable").DataTable({
				 order : [[ 5, "desc" ]]
			});
		}
	});
}
/**
 * 
 */
var baseUrl = getRootPath();

$(function(){
	g_dataTable = $("#dataTable").DataTable({
	});
	fetchData();
});

function fetchData(){
	$("#loading").show();
	$.ajax({
		url :  baseUrl+"/xtdj/jajgfk.json",
		type : "get",
		data : {},
		dataType : 'html',
		success : function(resp) {
			resp = $.parseJSON(resp);
			g_dataTable.clear().destroy();
			$("#dataTable>tbody").empty();
			for(var i = 0 ; i < resp.length ; i++){
				$("#dataTable>tbody").append("<tr>"+
						"<td>"+(i+1)+"</td>"+
						"<td>"+resp[i].ah+"</td>"+
						"<td>"+resp[i].ajmc+"</td>"+
						"<td>"+resp[i].dsr+"</td>"+
						"<td>"+resp[i].sqlx+"</td>"+
					"</tr>");
			}
			g_dataTable = $("#dataTable").DataTable({
			});
		},
		complete:function(resp){
			$("#loading").hide();
		}
	});
	
}
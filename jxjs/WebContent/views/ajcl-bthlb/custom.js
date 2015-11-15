/**
 * 
 */

var baseUrl = getRootPath();
$(function(){
	g_dataTable = $("#dataTable").DataTable({
	});
	fetchData();
});


//获取数据
function fetchData(){
	$("#loading").show();
	$.ajax({
		url :  baseUrl+"/ajcl/bthlb.json",
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
						"<td>"+resp[i].ysah+"</td>"+
						"<td>"+resp[i].dsr+"</td>"+
						"<td>"+resp[i].sxfy+"</td>"+
						"<td>"+resp[i].sqlx+"</td>"+
						"<td>"+resp[i].sqsj+"</td>"+
						"<td>"+resp[i].thsj+"</td>"+
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

function print(){
	var cont = $("#dataTable").html();
	printTable(cont);
};

function exports(){
	var url = baseUrl + "/ajcl/exportBthlbExcel";
	var data = "";
	
	exportExcel(url, data);
};
/**
 * 
 */

var baseUrl = getRootPath();
$(function(){
	g_dataTable = $("#dataTable").DataTable({
	});
	//点击列表，弹出详细信息
	$("#dataTable").on("click","tbody>tr>td:not([class='checkTD'])",viewCaseDetail);
	fetchData();
});
//弹出详细信息
function viewCaseDetail(){
	$("#caseDetailModal").modal({
		keyboard: true
	});
}

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
						"<td  class='checkTD'><input type='checkbox'/></td>"+
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
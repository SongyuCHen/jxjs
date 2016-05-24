/**
 * 
 */

var baseUrl = getRootPath();
$(function(){
	g_dataTable = $("#dataTable").DataTable({
         order : [[ 5, "desc" ]],
         language : {
        	 "sEmptyTable" : "没有立案"
         }
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
						"<td>"+(i+1)+"</td>"+
						"<td>"+resp[i].ah+"</td>"+
						"<td>"+resp[i].ajmc+"</td>"+
						"<td>"+resp[i].sqlx+"</td>"+
						"<td>"+resp[i].ysah+"</td>"+
						"<td>"+resp[i].lasj+"</td>"+
					"</tr>");
			}
			g_dataTable = $("#dataTable").DataTable({
				 order : [[ 5, "desc" ]],
				 language : {
		        	 "sEmptyTable" : "没有立案"
		         }
			});
		},
		complete:function(resp){
			$("#loading").hide();
		}
	});
}

print = function(){
	var cont = $("#dataTable").html();
	printTable(cont);
};

exports = function(){
	var url = baseUrl + "/ajcl/exportYlalbExcel";
	var data = "";
	
	exportExcel(url, data);
};
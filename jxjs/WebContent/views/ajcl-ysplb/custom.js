/**
 * 
 */
var baseUrl = getRootPath();
var g_resp;
$(function(){
	g_dataTable = $("#dataTable").DataTable({
		 columnDefs:[{
             orderable:false,//禁用排序
             targets:[0]   //指定的列
         }],
         order : [[ 0, "asc" ]]
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
		url :  baseUrl+"/ajcl/ysplb.json",
		type : "get",
		data : {},
		dataType : 'html',
		success : function(resp) {
			resp = $.parseJSON(resp);
			g_resp = resp;
			g_dataTable.clear().destroy();
			$("#dataTable>tbody").empty();
			for(var i = 0 ; i < resp.length ; i++){
				$("#dataTable>tbody").append("<tr>"+
						"<td width='5%' class='checkTD'><input type='checkbox'/></td>"+
						"<td width='10%'>"+(i+1)+"</td>"+
						"<td width='20%'>"+resp[i].ysah+"</td>"+
						"<td width='10%'>"+resp[i].dsr+"</td>"+
						"<td width='15%'>"+resp[i].sxfy+"</td>"+
						"<td width='10%'>"+resp[i].sqlx+"</td>"+
						"<td width='15%'>"+resp[i].sqsj+"</td>"+
						"<td width='15%'>"+resp[i].spsj+"</td>"+
					"</tr>");
			}
			g_dataTable = $("#dataTable").DataTable({
				 columnDefs:[{
		             orderable:false,//禁用排序
		             targets:[0]   //指定的列
		         }],
//		         order : [[ 7, "desc" ]]
		         order : [[ 0, "asc" ]]
			});
		},
		complete:function(resp){
			$("#loading").hide();
		}
		
	});
}

//立案
function lian(){
	if(!anyChecked()){
		alert("请选择要进行立案的项!");
		return;
	}
	var jxjsbhList = [];
	$("#dataTable td.checkTD input").each(function(){
		if($(this).is(":checked")){
			var i = $(this).parent().parent().children().eq(1).text();
			i--;
			jxjsbhList.push(g_resp[i].jxjsbh);
		}
	});
	$.ajax({
		url :  baseUrl+"/ajcl/la",
		type : "post",
		data : {
			jxjsbhList:jxjsbhList.join()
		},
		dataType : 'html',
		success : function(resp) {
			fetchData();
		}
	});
}

// 打印
function print(){
	var cont = $("#dataTable").html();
	printTable(cont);
}

// 导出
function exports(){
	var url = baseUrl + "/ajcl/exportYsplbExcel";
	var data = "";
	
	exportExcel(url, data);
}
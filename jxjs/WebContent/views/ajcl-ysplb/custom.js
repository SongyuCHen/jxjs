/**
 * 
 */
var baseUrl = getRootPath();

$(function(){
	g_dataTable = $("#dataTable").DataTable({
		 columnDefs:[{
             orderable:false,//禁用排序
             targets:[0]   //指定的列
         }],
         order : [[ 7, "desc" ]]
	});
	fetchData();
});



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
						"<td>"+resp[i].spsj+"</td>"+
					"</tr>");
			}
			g_dataTable = $("#dataTable").DataTable({
				 columnDefs:[{
		             orderable:false,//禁用排序
		             targets:[0]   //指定的列
		         }],
		         order : [[ 7, "desc" ]]
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
	$.ajax({
		url :  baseUrl+"/ajcl/la",
		type : "get",
		data : {},
		dataType : 'html',
		success : function(resp) {
			fetchData();
		}
	});
}
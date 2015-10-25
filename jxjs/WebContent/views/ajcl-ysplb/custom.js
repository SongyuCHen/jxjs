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
	$.ajax({
		url :  baseUrl+"/ajcl/ysplb.json",
		type : "get",
		data : {},
		dataType : 'html',
		success : function(resp) {
			alert(resp);
		}
	});
}

//立案
function lian(){
	if(!anyChecked()){
		alert("请选择要进行立案的项!");
		return;
	}
}
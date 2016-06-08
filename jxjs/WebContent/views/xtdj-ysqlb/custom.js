/**
 * 
 */

var baseUrl = getRootPath();

$(document).ready(function(){
	/**
	 * 日期选择控件
	 */
	$('.form_date').datetimepicker({
	    language:  'zh-CN',
	    format: 'yyyy-mm-dd',
	    weekStart: 1,
	    todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0,
		pickerPosition: "bottom-left"
	});
	

		g_dataTable = $("#dataTable").DataTable({
			 columnDefs:[{
	             orderable:false,//禁用排序
	             targets:[0]   //指定的列
	         }],
	         order : [[ 0, "asc" ]]
		});
	
		
		//初始化日期
		var date = new Date();
		$("#startDate").val(date.Format("yyyy")+"-01-01");
		$("#endDate").val(date.Format("yyyy-MM-dd"));
		fetchData();

});

//获取数据
function fetchData(){
	$("#loading").show();
	var kssj = $("#startDate").val();
	var jssj = $("#endDate").val();
	$.ajax({
		url :  baseUrl+"/ajcl/sqlb.json",
		type : "get",
		data : {
			kssj:kssj,
			jssj:jssj},
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
						"<td>"+resp[i].clzt+"</td>"+
						"<td>"+resp[i].clsj+"</td>"+
					"</tr>");
			}
			g_dataTable = $("#dataTable").DataTable({
				 order : [[ 0, "asc" ]]
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
	var url = baseUrl + "/ajcl/exportDsplbExcel";
	var data = "";
	
	exportExcel(url, data);
};
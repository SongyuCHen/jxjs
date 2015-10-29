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
	
	//初始化日期
	var date = new Date();
	$("#startDate").val(date.Format("yyyy-MM")+"-01");
	$("#endDate").val(date.Format("yyyy-MM-dd"));
	
	
	g_dataTable = $("#dataTable").DataTable({
	});
	fetchData();
});



//获取数据
function fetchData(){
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	var condition = $("#condition").val();
	$("#loading").show();
	$.ajax({
		url :  baseUrl+"/tjfx/cx",
		type : "post",
		data : {
			startDate:startDate,
			endDate:endDate,
			condition:condition
		},
		dataType : 'html',
		success : function(resp) {
			alert(resp);
			resp = $.parseJSON(resp);
			/*g_dataTable.clear().destroy();
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
						"<td>"+resp[i].sqcs+"</td>"+
					"</tr>");
			}
			g_dataTable = $("#dataTable").DataTable({
				 columnDefs:[{
		            orderable:false,//禁用排序
		            targets:[0]   //指定的列
		        }],
		        order : [[ 6, "desc" ]]
			});*/
		},
		complete:function(resp){
			$("#loading").hide();
		}
	});
}
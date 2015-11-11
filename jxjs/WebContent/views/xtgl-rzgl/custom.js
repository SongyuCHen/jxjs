/**
 * 
 */
var baseUrl = getRootPath();

$(function(){
	
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
	});
	fetchData();
});

function search(){
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	var type = "1";
	$("#loading").show();
	$.ajax({
		url :  baseUrl+"/xtgl/rzcx",
		type : "post",
		data : {
			startDate:startDate,
			endDate:endDate,
			type:type
		},
		dataType : 'html',
		success : function(resp) {
			resp = $.parseJSON(resp);
			g_dataTable.clear().destroy();
			$("#dataTable>tbody").empty();
			for(var i = 0 ; i < resp.length ; i++){
				$("#dataTable>tbody").append("<tr>"+
						"<td>"+(i+1)+"</td>"+
						"<td>"+resp[i].czr+"</td>"+
						"<td>"+resp[i].type+"</td>"+
						"<td>"+resp[i].czsj+"</td>"+
						"<td>"+resp[i].czip+"</td>"+
						"<td>"+resp[i].bz+"</td>"+
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

function fetchData(){
//	$("#loading").show();
//	$.ajax({
//		url :  baseUrl+"/xtdj/rzcx",
//		type : "get",
//		data : {},
//		dataType : 'html',
//		success : function(resp) {
//			resp = $.parseJSON(resp);
//			g_dataTable.clear().destroy();
//			$("#dataTable>tbody").empty();
//			for(var i = 0 ; i < resp.length ; i++){
//				$("#dataTable>tbody").append("<tr>"+
//						"<td>"+(i+1)+"</td>"+
//						"<td>"+resp[i].ah+"</td>"+
//						"<td>"+resp[i].ajmc+"</td>"+
//						"<td>"+resp[i].dsr+"</td>"+
//						"<td>"+resp[i].sqlx+"</td>"+
//					"</tr>");
//			}
//			g_dataTable = $("#dataTable").DataTable({
//			});
//		},
//		complete:function(resp){
//			$("#loading").hide();
//		}
//	});
	
}
/**
 * 
 */
var baseUrl = getRootPath();

// 开始时间、结束时间、操作类型
var kssj, jssj, czlx;

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
	
	//初始化日期
	var date = new Date();
	$("#startDate").val(date.Format("yyyy-MM")+"-01");
	$("#endDate").val(date.Format("yyyy-MM-dd"));
	
	g_dataTable = $("#dataTable").DataTable({
	});

});
//用户按下统计按钮
function search(){
	cx();
}
function cx(){
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	var condition = $("#condition").val();
	$("#loading").show();
	$.ajax({
		url :  baseUrl+"/xtgl/rzcx",
		type : "post",
		data : {
			startDate:startDate,
			endDate:endDate,
			condition:condition
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
			
			// 保存查询的条件，导出表格用到
			kssj = startDate;
			jssj = endDate;
			czlx = condition;
		},
		complete:function(resp){
			$("#loading").hide();
		}
	});
}

function print(){
	var cont = $("#dataTable").html();
	printTable(cont);
}

function exports(){
	var url = baseUrl + "/xtgl/exportRzglExcel";
	var data = {
		"kssj": kssj,
		"jssj": jssj,
		"czlx": czlx
	};
	
	exportExcel(url, data);
}
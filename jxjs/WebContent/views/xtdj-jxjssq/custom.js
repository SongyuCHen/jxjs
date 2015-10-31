/**
 * 
 */
var baseUrl = getRootPath();
var g_resp;


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
		 columnDefs:[{
            orderable:false,//禁用排序
            targets:[0]   //指定的列
        }],
        order : [[ 6, "desc" ]]
	});

});



function search(){
	fetchData();
}

//获取数据
function fetchData(){
	var ah = $("#caseNumber").val();
	var dsr = $("#dsr").val();
	var kssj = $("#startDate").val();
	var jssj = $("#endDate").val();
	//alert(ah+","+dsr+","+kssj+","+jssj);
	$("#loading").show();
	$.ajax({
		url :  baseUrl+"/xtdj/jxjssq.json",
		type : "post",
		data : {
			ah:ah,
			dsr:dsr,
			kssj:kssj,
			jssj:jssj
		},
		dataType : 'html',
		success : function(resp) {
			resp = $.parseJSON(resp);
			g_resp = resp;
			alert(resp);
			/*
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

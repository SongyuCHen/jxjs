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
        order : [[ 1, "asc" ]]
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
	if(ah.length==0&&dsr.length==0&&kssj.length==0&&jssj.length==0){
		alert("查询条件不能都为空！");
		return;
	}
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
			
			g_dataTable.clear().destroy();
			$("#dataTable>tbody").empty();
			for(var i = 0 ; i < resp.length ; i++){
				$("#dataTable>tbody").append("<tr>"+
						"<td  class='checkTD'><input type='checkbox'/></td>"+
						"<td>"+(i+1)+"</td>"+
						"<td>"+resp[i].ah+"</td>"+
						"<td>"+resp[i].ajmc+"</td>"+
						"<td>"+resp[i].larq+"</td>"+
						"<td>"+resp[i].jarq+"</td>"+
						"<td>"+resp[i].bafy+"</td>"+
						"<td>"+resp[i].ay+"</td>"+
						"<td>"+resp[i].dsr+"</td>"+
					"</tr>");
			}
			g_dataTable = $("#dataTable").DataTable({
				 columnDefs:[{
		            orderable:false,//禁用排序
		            targets:[0]   //指定的列
		        }],
		        order : [[ 1, "asc" ]]
			});
		},
		complete:function(resp){
			$("#loading").hide();
		}
	});
}

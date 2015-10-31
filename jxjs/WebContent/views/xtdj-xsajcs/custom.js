/**
 * 
 */

/**
 * 
 */

var baseUrl = getRootPath();
var g_resp;

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
	         order : [[ 1, "asc" ]]
		});
	
		
		//初始化日期
		var date = new Date();
		$("#startDate").val(date.Format("yyyy-MM")+"-01");
		$("#endDate").val(date.Format("yyyy-MM-dd"));

});

function search(){
	fetchData();
}


//获取数据
function fetchData(){
	var ah = $("#caseNumber").val();
	var kssj = $("#startDate").val();
	var jssj = $("#endDate").val();
	$("#loading").show();
	$.ajax({
		url :  baseUrl+"/xtdj/xsajcs/search",
		type : "get",
		data : {
			ah:ah,
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


// 传输
function chuanshu(){
	if(!anyChecked()){
		alert("请选择要传输的项!");
		return;
	}
}
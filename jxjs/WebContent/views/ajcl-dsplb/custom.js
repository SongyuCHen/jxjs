var baseUrl = getRootPath();
var g_resp;

$(document).ready(function(){
	
	print = function(){
		var cont = $("#dataTable").html();
		printTable(cont);
	};
	
	exports = function(){
		var url = baseUrl + "/ajcl/exportDsplbExcel";
		var data = "";
		
		exportExcel(url, data);
	};
});

$(function(){

	g_dataTable = $("#dataTable").DataTable({
		 columnDefs:[{
           orderable:false,//禁用排序
           targets:[0]   //指定的列
       }],
       order : [[ 6, "desc" ]]
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

//弹出审批框
function shenpi(){
	if(!anyChecked()){
		alert("请选择要进行审批的项!");
		return;
	}
	var date = new Date();
	$("#currentDateShenpi").text(date.Format("yyyy-MM-dd"));
	$("#shenpiModal").modal({
		keyboard: true
	});
}

//弹出退回框
function tuihui(){
	if(!anyChecked()){
		alert("请选择要退回的项!");
		return;
	}
	var date = new Date();
	$("#currentDateTuihui").text(date.Format("yyyy-MM-dd"));
	$("#tuihuiModal").modal({
		keyboard: true
	});
}


//获取数据
function fetchData(){
	$("#loading").show();
	$.ajax({
		url :  baseUrl+"/ajcl/dsplb.json",
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
			});
		},
		complete:function(resp){
			$("#loading").hide();
		}
	});
}

function approval(){
	var spsj = $("#currentDateShenpi").text();
	var spyj = $("#spyjShenpi").val();
	var jxjsbhList = [];
	$("#dataTable td.checkTD input").each(function(){
		if($(this).is(":checked")){
			var i = $(this).parent().parent().children().eq(1).text();
			i--;
			jxjsbhList.push(g_resp[i].jxjsbh);
		}
	});
	$.ajax({
		url :  baseUrl+"/ajcl/approval",
		type : "post",
		data : {
			jxjsbhList:jxjsbhList.join(),
			spyj:spyj,
			spsj:spsj
		},
		dataType : 'html',
		success : function(resp) {
			fetchData();
		}
	});
}


function reject(){
	var spsj = $("#currentDateTuihui").text();
	var spyj = $("#spyjTuihui").val();
	var jxjsbhList = [];
	$("#dataTable td.checkTD input").each(function(){
		if($(this).is(":checked")){
			var i = $(this).parent().parent().children().eq(1).text();
			i--;
			jxjsbhList.push(g_resp[i].jxjsbh);
		}
	});
	$.ajax({
		url :  baseUrl+"/ajcl/reject",
		type : "get",
		data : {
			jxjsbhList:jxjsbhList.join(),
			spyj:spyj,
			spsj:spsj
		},
		dataType : 'html',
		success : function(resp) {
			fetchData();
		}
	});
}

var baseUrl = getRootPath();

$(document).ready(function(){
	
	print = function(){
		var cont = $("#dataTable").html();
		printTable(cont);
	};
	
	exports = function(){
		var url = baseUrl + "/ajcl/exportExcel";
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
	$.ajax({
		url :  baseUrl+"/ajcl/approval",
		type : "post",
		data : {
			jxjsbhList:"1,2,3",
			spyj:"新皇登基，天下大赦",
			spsj:"2015-10-28"
		},
		dataType : 'html',
		success : function(resp) {
			fetchData();
		}
	});
}


function reject(){
	$.ajax({
		url :  baseUrl+"/ajcl/reject",
		type : "get",
		data : {},
		dataType : 'html',
		success : function(resp) {
			fetchData();
		}
	});
}

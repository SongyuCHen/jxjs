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
	$("#dataTable").on("click","tbody>tr",viewCaseDetail);
});


//弹出详细信息
function viewCaseDetail(){
	$("#caseDetailModal").modal({
		keyboard: true
	});
}

//审批
function shenpi(){
	$("#shenpiModal").modal({
		keyboard: true
	});
}

//退回
function tuihui(){
	$("#tuihuiModal").modal({
		keyboard: true
	});
}

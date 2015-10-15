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
	//点击列表，弹出详细信息
	$("#dataTable").on("click","tr",viewCaseDetail);
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

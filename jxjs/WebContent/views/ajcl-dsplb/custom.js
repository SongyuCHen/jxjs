var baseUrl = getRootPath();

$(document).ready(function(){
	
	var print = function(){
		var cont = $("#dataTable").html();
		printTable(cont);
	};
	
	var exports = function(){
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

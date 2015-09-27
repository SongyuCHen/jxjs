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
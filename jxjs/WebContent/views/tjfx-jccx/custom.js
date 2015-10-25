/**
 * 
 */

var baseUrl = getRootPath();

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
	
	//初始化日期
	var date = new Date();
	$("#startDate").val(date.Format("yyyy-MM")+"-01");
	$("#endDate").val(date.Format("yyyy-MM-dd"));
});
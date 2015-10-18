/**
 * 
 */

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
	
	$(function(){
		g_dataTable = $("#dataTable").DataTable({
			 columnDefs:[{
	             orderable:false,//禁用排序
	             targets:[0]   //指定的列
	         }],
	         order : [[ 6, "desc" ]]
		});
	});
});
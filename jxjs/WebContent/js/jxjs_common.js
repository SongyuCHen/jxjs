var g_dataTable = null;

$.extend( $.fn.dataTable.defaults, {
	"sDom" : '<"top">rt<"bottom"ip<"clear">>',
	language : {
		"sProcessing" : "处理中...",
		"sLengthMenu" : "显示 _MENU_ 项结果",
		"sZeroRecords" : "没有匹配结果",
		"sInfo" : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
		"sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
		"sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
		"sInfoPostFix" : "",
		"sSearch" : "搜索:",
		"sUrl" : "",
		"sEmptyTable" : "没有查询到任何结果",
		"sLoadingRecords" : "载入中...",
		"sInfoThousands" : ",",
		"oPaginate" : {
			"sFirst" : "首页",
			"sPrevious" : "上页",
			"sNext" : "下页",
			"sLast" : "末页"
		},
		"oAria" : {
			"sSortAscending" : ": 以升序排列此列",
			"sSortDescending" : ": 以降序排列此列"
		}
	}
});

Date.prototype.Format = function(fmt)   
{ //author: meizz   
  var o = {   
    "M+" : this.getMonth()+1,                 //月份   
    "d+" : this.getDate(),                    //日   
    "h+" : this.getHours(),                   //小时   
    "m+" : this.getMinutes(),                 //分   
    "s+" : this.getSeconds(),                 //秒   
    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
    "S"  : this.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
};


$(function() {
	//时间更新
	updateTime();
	setInterval(updateTime,1000*60);
	$("#dataTable-search-input").bind("input propertychange",function(){
		 $('#dataTable').DataTable().search(
			        $(this).val(),
			        false,
			        true
			    ).draw();
	});

});

/*
function dataTable_search() {
	var query = $("#dataTable-search-input").val();
	query = query.trim();
	g_dataTable.search(query).draw();
}*/

function updateTime(){
	var date = new Date();
	var weeks = new Array('星期日','星期一','星期二','星期三','星期四','星期五','星期六');
	var currentTime = date.Format("yyyy-MM-dd")+" "+weeks[date.getDay()]+" "+date.Format("hh:mm");
	$("#currentTime").text(currentTime);
	
}


function checkAll(){
	if($("#checkAll").is(":checked")){
		$(".checkTD input").prop("checked", true);
	}else{
		$(".checkTD input").prop("checked", false);
	}
}

/*
 * 是否有选择框被选中
 */
function anyChecked(){
	var any = false;
	$(".checkTD input").each(function(){
		if($(this).is(":checked")){
			any = true;
		}
	});
	return any;
}


function null2empty(str){
	if(str==null){
		return "";
	}else{
		return str;
	}
}
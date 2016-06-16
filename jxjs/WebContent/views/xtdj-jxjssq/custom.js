/**
 * 
 */
var baseUrl = getRootPath();
var g_resp;


$(function(){
	
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
        order : [[ 0, "asc" ]]
	});
	
	$("#dataTable").on("click","tbody>tr>td.checkTD",function(){
		$("#dataTable td.checkTD input").prop("checked", false);
		$(this).children("input").prop("checked", true);
	});

});



function search(){
	fetchData();
}

//获取数据
function fetchData(){
	var ah = $("#caseNumber").val();
	var dsr = $("#dsr").val();
	var kssj = $("#startDate").val();
	var jssj = $("#endDate").val();
	//alert(ah+","+dsr+","+kssj+","+jssj);
	if(ah.length==0&&dsr.length==0&&kssj.length==0&&jssj.length==0){
		alert("查询条件不能都为空！");
		return;
	}
	$("#loading").show();
	$.ajax({
		url :  baseUrl+"/xtdj/jxjssq.json",
		type : "post",
		data : {
			ah:ah,
			dsr:dsr,
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
						"<td width='5%' class='checkTD'><input type='checkbox'/></td>"+
						"<td width='8%'>"+(i+1)+"</td>"+
						"<td width='17%'>"+resp[i].ah+"</td>"+
						"<td width='15%'>"+resp[i].ajmc+"</td>"+
						"<td width='15%'>"+resp[i].larq+"</td>"+
						"<td width='15%'>"+resp[i].jarq+"</td>"+
						"<td width='15%'>"+resp[i].bafy+"</td>"+
						"<td width='10%'>"+resp[i].ay+"</td>"+
					"</tr>");
			}
			g_dataTable = $("#dataTable").DataTable({
				 columnDefs:[{
		            orderable:false,//禁用排序
		            targets:[0]   //指定的列
		        }],
		        order : [[ 0, "asc" ]]
			});
		},
		complete:function(resp){
			$("#loading").hide();
		}
	});
}

//获取申请信息
function shenqing(){
	shenqingModalReset();
	$("#shenqingModal").modal({
		keyboard: true
	});
	var ajxh = -1;
	$("#dataTable td.checkTD input").each(function(){
		if($(this).is(":checked")){
			var i = $(this).parent().parent().children().eq(1).text();
			i--;
			ajxh = g_resp[i].ajxh;
		}
	});
	$.ajax({
		url :  baseUrl+"/xtdj/getInfoForApply",
		type : "post",
		data : {
			ajxh:ajxh
		},
		dataType : 'html',
		success : function(resp) {
			resp = $.parseJSON(resp);
			$("#mah").val(resp.ah);
			$("#majmc").val(resp.ajmc);
			$("#mbafy").val(resp.bafy);
			$("#mfxdd").val(resp.fxdd);
			$("#msqcs").val(resp.sqcs);
			$("#mrjrq").text(resp.rjrq);
			$("#mxqkssj").text(resp.xqkssj);
			$("#mxqjssj").text(resp.xqjssj);
			
			$("#msqlx").html(toOptions(resp.sqlxList));
			$("#mdsr").html(toOptions(resp.dsrList));
			$("#msxpjxf").html(toOptions(resp.sxpjxfList));
			
			$("#msqkssjLabel").text(toLabel(resp.sqlxList)+"开始时间");
			$("#msqjssjLabel").text(toLabel(resp.sqlxList)+"结束时间");
			
		},
		complete:function(resp){
			
		}
	});
}

//发起申请
function apply(){
	var ajxh = -1;
	$("#dataTable td.checkTD input").each(function(){
		if($(this).is(":checked")){
			var i = $(this).parent().parent().children().eq(1).text();
			i--;
			ajxh = g_resp[i].ajxh;
		}
	});
	var dsr = $("#mdsr").val()==null?"":$("#mdsr").val();
	var sqlx = $("#msqlx").val()==null?"":$("#msqlx").val();
	var sqsj = $("#msqsj").val();
	var sqkssj = $("#msqkssj").val();
	var sqjssj = $("#msqjssj").val();
	var bafy = $("#mbafy").val();
	var sqcs = $("#msqcs").val();
	var rjrq = $("#mrjrq").val();
	var xqkssj = $("#mxqkssj").val();
	var xqjssj = $("#mxqjssj").val();
	var sfjs = $("#msfjs").val();
	var sxah = $("#mah").val();
	var sxajmc = $("#majmc").val();
	if(sqkssj.length==0||sqjssj.length==0||dsr.length==0||bafy.length==0||rjrq.length==0||xqkssj.length==0
			||xqjssj.length==0||sxah.length==0||sxajmc.length==0){
		alert("参数不能为空，请填写完整！");
		return;
	}
	$.ajax({
		url :  baseUrl+"/xtdj/apply",
		type : "post",
		data : {
			ajxh:ajxh,
			dsr:dsr,
			sqlx:sqlx,
			sqsj:sqsj,
			sqkssj:sqkssj,
			sqjssj:sqjssj,
			bafy:bafy,
			sqcs:sqcs,
			rjrq:rjrq,
			xqkssj:xqkssj,
			xqjssj:xqjssj,
			sfjs:sfjs,
			sxah:sxah,
			sxajmc:sxajmc
		},
		dataType : 'html',
		success : function(resp) {
			resp = $.parseJSON(resp);
			alert("申请成功！");
		},
		error : function(resp){
			alert("申请失败!");
		},
		complete:function(resp){
			fetchData();
			$("#shenqingModal").hide();
		}
	});
	
}

//重置modal
function shenqingModalReset(){
	
	$("#mah").text("");
	$("#majmc").text("");
	$("#mbafy").text("");
	$("#mfxdd").text("");
	$("#msqcs").text("");
	$("#mrjrq").text("");
	$("#mxqkssj").text("");
	$("#mxqjssj").text("");

//	$("#msfjs").text("");
	$("#msfjs option:selected").attr("selected", false);
	$("#msfjs option:first").attr("selected", "selected");
	
	$("#msqlx").html(toOptions([]));
	$("#mdsr").html(toOptions([]));
	
	var date = new Date();
	$("#msqsj").val(date.Format("yyyy-MM-dd"));
	$("#msqkssj").val("");
	$("#msqjssj").val("");
}


function toOptions(l){
	var html = "";
	for(var i = 0 ; i < l.length ; i++){
		html+="<option>"+l[i]+"</option>";
	}
	return html;
}


function sqlxChanged(sel){	
	$("#msqkssjLabel").text($(sel).val()+"开始时间");
	$("#msqjssjLabel").text($(sel).val()+"结束时间");
}

function toLabel(l){
	var label = "";
	if(l.length>0){
		label = l[0];
	}else{
		label="申请";
	}
	return label;
}
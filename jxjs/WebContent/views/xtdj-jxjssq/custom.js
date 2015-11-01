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
        order : [[ 1, "asc" ]]
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
						"<td  class='checkTD'><input type='checkbox'/></td>"+
						"<td>"+(i+1)+"</td>"+
						"<td>"+resp[i].ah+"</td>"+
						"<td>"+resp[i].ajmc+"</td>"+
						"<td>"+resp[i].larq+"</td>"+
						"<td>"+resp[i].jarq+"</td>"+
						"<td>"+resp[i].bafy+"</td>"+
						"<td>"+resp[i].ay+"</td>"+
						"<td>"+resp[i].dsr+"</td>"+
					"</tr>");
			}
			g_dataTable = $("#dataTable").DataTable({
				 columnDefs:[{
		            orderable:false,//禁用排序
		            targets:[0]   //指定的列
		        }],
		        order : [[ 1, "asc" ]]
			});
		},
		complete:function(resp){
			$("#loading").hide();
		}
	});
}


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
			$("#mah").text(resp.ah);
			$("#majmc").text(resp.ajmc);
			$("#mbafy").text(resp.bafy);
			$("#mfxdd").text(resp.fxdd);
			$("#msqcs").text(resp.sqcs);
			$("#mrjrq").text(resp.rjrq);
			$("#mxqkssj").text(resp.xqkssj);
			$("#mxqjssj").text(resp.xqjssj);
			$("#msqkssj").text(resp.sqkssj);
			$("#msqjssj").text(resp.sqjssj);
			$("#msfjs").text(resp.sfjs);
			
			$("#msqlx").html(toOptions(resp.sqlxList));
			$("#mdsr").html(toOptions(resp.dsrList));
			
			
			$("#msqkssjLabel").text(toLabel(resp.sqlxList)+"开始时间");
			$("#msqjssjLabel").text(toLabel(resp.sqlxList)+"结束时间");
			
		},
		complete:function(resp){
			
		}
	});
}


function apply(){
	
}

function shenqingModalReset(){
	
	$("#mah").text("载入中。。。");
	$("#majmc").text("载入中。。。");
	$("#mbafy").text("载入中。。。");
	$("#mfxdd").text("载入中。。。");
	$("#msqcs").text("载入中。。。");
	$("#mrjrq").text("载入中。。。");
	$("#mxqkssj").text("载入中。。。");
	$("#mxqjssj").text("载入中。。。");
	$("#msqkssj").text("载入中。。。");
	$("#msqjssj").text("载入中。。。");
	$("#msfjs").text("载入中。。。");
	$("#msqlx").html(toOptions([]));
	$("#mdsr").html(toOptions([]));
	
	var date = new Date();
	$("#msqsj").val(date.Format("yyyy-MM-dd"));
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
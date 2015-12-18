/**
 * 
 */
var baseUrl = getRootPath();
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
	//初始化日期
	var date = new Date();
	$("#startDate1").val(date.Format("yyyy-MM")+"-01");
	$("#endDate1").val(date.Format("yyyy-MM-dd"));
	$("#startDate2").val(date.Format("yyyy-MM")+"-01");
	$("#endDate2").val(date.Format("yyyy-MM-dd"));
	
	
	
	fetchData1();
	fetchData2();
		                    
});


function tongji1(){
	fetchData1();
}

function tongji2(){
	fetchData2();
}


function fetchData1(){
	var startDate = $("#startDate1").val();
	var endDate = $("#endDate1").val();
	$.ajax({
		url :  baseUrl+"/tjfx/sjtj/graph1",
		type : "post",
		data : {
			kssj:startDate,
			jssj:endDate
		},
		dataType : 'html',
		success : function(resp) {
			resp = $.parseJSON(resp);
			var barTitles = [];
			var nums = [];
			for(var i = 0 ; i < resp.length ; i++){
				barTitles.push(resp[i].s_type);
				nums.push(resp[i].i_sz);
			}
			var statusStatChart = echarts.init(document.getElementById('statusStat'));
			var option1 = {
				    title : {
				        text: '案件状态柱形图',
				        subtext: startDate+" 至 "+endDate,
				        x:'center'
				    },
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				    	orient : 'vertical',
				        x : 'left',
				        data:['案件数量']
				    },
				    toolbox: {
				        show : false,
				        feature : {
				            mark : {show: true},
				            dataView : {show: true, readOnly: false},
				            magicType : {show: true, type: ['line', 'bar']},
				            restore : {show: true},
				            saveAsImage : {show: true}
				        }
				    },
				    calculable : true,
				    xAxis : [
				        {
				            type : 'category',
				            data : barTitles
				        }
				    ],
				    yAxis : [
				        {
				            type : 'value'
				        }
				    ],
				    series : [
				        {
				            name:'案件数量',
				            type:'bar',
				            data:nums,
				            markPoint : {
				                data : [
				                    {type : 'max', name: '最大值'},
				                    {type : 'min', name: '最小值'}
				                ]
				            },
				            markLine : {
				                data : [
				                    {type : 'average', name: '平均值'}
				                ]
				            }
				        }
				    ]
				};
			statusStatChart.setOption(option1); 
		},
		complete:function(resp){
		}
	});
}

function fetchData2(){
	var startDate = $("#startDate2").val();
	var endDate = $("#endDate2").val();
	var condition = $("#condition").val();
	$.ajax({
		url :  baseUrl+"/tjfx/sjtj/graph2",
		type : "post",
		data : {
			kssj:startDate,
			jssj:endDate,
			condition:condition
		},
		dataType : 'html',
		success : function(resp) {
			resp = $.parseJSON(resp);
			var legend = [];
			var nums = [];
			for(var i = 0 ; i < resp.length ; i++){
				legend.push(resp[i].s_type);
				nums.push({value:resp[i].i_sz,name:resp[i].s_type});
			}
			var typeStatChart = echarts.init(document.getElementById('typeStat'));
			option2 = {
				    title : {
				        text: '案件状态饼图',
				        subtext: startDate+" 至 "+endDate+" "+condition,
				        x:'center'
				    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    color:['red', 'green','orange','blueviolet','blue','pink'],
				    legend: {
				        orient : 'vertical',
				        x : 'left',
				        data:legend
				    },
				    toolbox: {
				        show : false,
				        feature : {
				            mark : {show: true},
				            dataView : {show: true, readOnly: false},
				            magicType : {
				                show: true, 
				                type: ['pie', 'funnel'],
				                option: {
				                    funnel: {
				                        x: '25%',
				                        width: '50%',
				                        funnelAlign: 'left',
				                        max: 1548
				                    }
				                }
				            },
				            restore : {show: true},
				            saveAsImage : {show: true}
				        }
				    },
				    calculable : true,
				    series : [
				        {
				            name:'案件数量',
				            type:'pie',
				            radius : '55%',
				            center: ['50%', '60%'],
				            data:nums
				        }
				    ]
				};
				typeStatChart.setOption(option2);
		},
		complete:function(resp){
		}
	});
}
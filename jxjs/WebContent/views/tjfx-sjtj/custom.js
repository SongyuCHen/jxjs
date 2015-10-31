/**
 * 
 */
var baseUrl = getRootPath();
$(function(){

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
}

function tongji2(){
	
}


function fetchData1(){
	var startDate = $("#startDate1").val();
	var endDate = $("#endDate1").val();
	$.ajax({
		url :  baseUrl+"/tjfx/sjtj/graph1",
		type : "get",
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
				        subtext: startDate+" 至 "+endDate
				    },
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
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
	var startDate = $("#startDate1").val();
	var endDate = $("#endDate1").val();
	$.ajax({
		url :  baseUrl+"/tjfx/sjtj/graph2",
		type : "get",
		data : {
			kssj:startDate,
			jssj:endDate
		},
		dataType : 'html',
		success : function(resp) {
			resp = $.parseJSON(resp);
			alert(resp);
			var typeStatChart = echarts.init(document.getElementById('typeStat'));
			option2 = {
				    title : {
				        text: '某站点用户访问来源',
				        subtext: '纯属虚构',
				        x:'center'
				    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    legend: {
				        orient : 'vertical',
				        x : 'left',
				        data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
				    },
				    toolbox: {
				        show : true,
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
				            name:'访问来源',
				            type:'pie',
				            radius : '55%',
				            center: ['50%', '60%'],
				            data:[
				                {value:335, name:'直接访问'},
				                {value:310, name:'邮件营销'},
				                {value:234, name:'联盟广告'},
				                {value:135, name:'视频广告'},
				                {value:1548, name:'搜索引擎'}
				            ]
				        }
				    ]
				};
				typeStatChart.setOption(option2);
		},
		complete:function(resp){
		}
	});
}
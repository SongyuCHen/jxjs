<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.css"/><jsp:text/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/xtdj-jxjssq/custom.css"/><jsp:text/>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"><jsp:text/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/locales/bootstrap-datetimepicker.zh-CN.js"><jsp:text/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/xtdj-jxjssq/custom.js"><jsp:text/></script>
</head>
<body>
	<div class="search-area">
		<div class="float-left float-gap">
			<div class="float-left time-text">
				<label class="label-control">案号</label>
			</div>
			<div class="float-left time-input">
				<input type="text" class="form-control" id="caseNumber"/>
			</div>				
		</div>
				
		<div class="float-left float-gap">
			<div class="float-left time-text">
				<label class="label-control">当事人</label>
			</div>
			<div class="float-left time-input">
				<input type="text" class="form-control" id="dsr"/>
			</div>				
		</div>
		<div class="float-left float-gap">
			<div class="float-left time-text">
				<label class="label-control">开始时间</label>
			</div>
			<div class="float-left time-input">
				<div class="input-group date form_date">
					<input type="text" class="form-control" id="startDate" readonly />
					<span class="input-group-addon" id="addSpan">
						<span class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</div>
		</div>

		<div class="float-left float-gap">
			<div class="float-left time-text">
				<label class="label-control">结束时间</label>
			</div>
			<div class="float-left time-input">
				<div class="input-group date form_date">
					<input type="text" class="form-control"  id="endDate" readonly />
					<span class="input-group-addon" id="addSpan">
						<span class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</div>
		</div>
		<div class="float-left float-gap">
			<button class="btn btn-success" onclick="search();">查询</button>
		</div>
	</div>
	
	<div class="table-wrapper">
		<img id="loading" src="${pageContext.request.contextPath}/images/loading.gif"/>
		<div class="table-main">
			<table id="dataTable"
				class="dataTable table table-hover table-striped">
				<thead>
					<tr id="table-main-thead-tr">
						<th width="5%"></th>
						<th width="8%">序号</th>
						<th width="17%">案号</th>
						<th width="15%">案件名称</th>
						<th width="15%">立案日期</th>
						<th width="15%">结案日期</th>
						<th width="15%">办案法院</th>
						<th width="10%">案由</th>
					</tr>
				</thead>
				<tbody>					
				</tbody>
			</table>
			<div class="operating">
				<button class="btn btn-primary" onclick="shenqing();">申请</button>
				<button class="btn loc-right" onclick="print()">打印</button>
				<button class="btn loc-right" onclick="exports()">导出</button>
				<div class="loc-right">列表：</div>			
			</div>
		</div>
	</div>
	
	<div class="modal fade" role="dialog" id="shenqingModal">
  		<div class="modal-dialog modal-lg" role="document">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title" id="gridSystemModalLabel">申请</h4>
      				</div>
      		<div class="modal-body">
        		<div class="container-fluid">
  					<div class="row">
  						<div class="col-md-2">
  							案号
  						</div>
  						<div class="float-left sq-input">
  							<input type="text" class="sq-text" id="mah">  
  						</div>
  						<div class="col-md-2">当事人</div>
  						<div class="col-md-2 noborder" style="padding:0px;" edited="true">
  							<select style="width:100%;height:100%"  id="mdsr">
  								<option>张三分</option>
  								<option>马虎疼</option>
  							</select>
  						</div>
					</div>
					<div class="row">
  						<div class="col-md-2">
  							案件名称
  						</div>
  						<div class="float-left sq-input">
  							<input type="text" class="sq-text" id="majmc"> 
  						</div>
  						<div class="col-md-2">申请类型</div>
  						<div class="col-md-2 noborder" style="padding:0px;">
  							<select style="width:100%;height:100%;"  id="msqlx" onchange="sqlxChanged(this);">  							
  								<option>减刑</option>
  								<option>假释</option>
  							</select>
  						</div>
					</div>
					<div class="space"></div>
					<div class="row">
  						<div class="col-md-2">
  							办案法院
  						</div>
  						<div class="float-left sq-input" >
  							<input type="text" class="sq-text" id="mbafy"> 
  						</div>
  						<div class="col-md-2">申请时间</div>
  						<div class="col-md-2" style="padding:2px 0px;">
  							<div class="input-group date form_date">
								<input type="text" class="form-control" id="msqsj" readonly />
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-calendar">
									</span>
								</span>
							</div>
  						</div>
					</div>
					<div class="row">
  						<div class="col-md-2">
  							服刑地点
  						</div>
  						<div class="float-left sq-input" >
  							<input type="text" class="sq-text" id="mfxdd"> 
  						</div>
  						<div class="col-md-2">申请次数</div>
  						<div class="float-left sq-input2">
  							<input type="text" class="sq-text2" id="msqcs"> 
  						</div>
					</div>
					<div class="row">
  						<div class="col-md-2">
  							已减刑期
  						</div>
  						<div class="float-left sq-input" >
  							<input type="text" class="sq-text" id="myjxq"> 
  						</div>
  						<div class="col-md-2">生效判决刑罚</div>
  						<div class="col-md-2 noborder" style="padding:0px;" >
  							<select style="width:100%;height:100%"  id="msxpjxf">
  								<option></option>
  								<option></option>
  							</select>
  						</div>
					</div>
					<div class="space"></div>
					<div class="row">
  						<div class="col-md-2">入监日期</div>
  						<div class="col-md-2"  style="padding:2px 0px;">
  							<div class="input-group date form_date">
								<input type="text" class="form-control" id="mrjrq" readonly />
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-calendar">
									</span>
								</span>
							</div>
  						</div>
  						<div class="col-md-2">刑期开始时间</div>
  						<div class="col-md-2"  style="padding:2px 0px;">
  							<div class="input-group date form_date">
								<input type="text" class="form-control" id="mxqkssj" readonly />
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-calendar">
									</span>
								</span>
							</div>
  						</div>
  						<div class="col-md-2">刑期结束时间</div>
  						<div class="col-md-2"  style="padding:2px 0px;">
  							<div class="input-group date form_date">
								<input type="text" class="form-control" id="mxqjssj" readonly />
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-calendar">
									</span>
								</span>
							</div>
  						</div>
					</div>
					<div class="row">
  						<div class="col-md-2" id="msqkssjLabel">申请开始时间</div>
  						<div class="col-md-2"  style="padding:2px 0px;">
  							<div class="input-group date form_date">
								<input type="text" class="form-control" id="msqkssj" readonly />
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-calendar">
									</span>
								</span>
							</div>
  						</div>
  						<div class="col-md-2" id="msqjssjLabel">申请结束时间</div>
  						<div class="col-md-2"  style="padding:2px 0px;">
  							<div class="input-group date form_date">
								<input type="text" class="form-control"  id="msqjssj" readonly />
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-calendar">
									</span>
								</span>
							</div>
  						</div>
  						<div class="col-md-2" style="font-size:10px;padding-top:2px;">是否不得假释罪犯申请减刑</div>
  						<div class="col-md-2" style="padding:0px;">
  						<select style="width:100%;height:100%"  id="msfjs">  								
  								<option>否</option>
  								<option>是</option>
  							</select></div>
					</div>
				
				</div>
      		</div>
      		<div class="modal-footer">
        		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        		<button type="button" class="btn btn-primary" onclick="apply();">确定 </button>
      		</div>
    		</div><!-- /.modal-content -->
  		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

</body>
</html>
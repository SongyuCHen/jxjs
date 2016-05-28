<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/ajcl-dsplb/custom.css"/><jsp:text/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.css"/><jsp:text/>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"><jsp:text/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/locales/bootstrap-datetimepicker.zh-CN.js"><jsp:text/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/ajcl-dsplb/custom.js"><jsp:text/></script>
</head>
<body>
	<div class="searching">
		<img
			src="${pageContext.request.contextPath}/images/searching-logo.png" />
		<input id="dataTable-search-input" type="text" class="form-control" />
		<!-- <button class="btn btn-info" onclick="dataTable_search();">检索</button> -->
	</div>
	<div class="table-wrapper">
		<img id="loading" src="${pageContext.request.contextPath}/images/loading.gif"/>
		<div class="table-main">
			<table id="dataTable"
				class="dataTable table table-hover table-striped">
				<thead>
					<tr id="table-main-thead-tr">
						<th><input type="checkbox" id="checkAll" onclick="checkAll();"/></th>
						<th>序号</th>
						<th>原审案号</th>
						<th>当事人</th>
						<th>生效法院</th>
						<th>申请类型</th>
						<th>申请时间</th>
						<th>申请次数</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<div class="operating">
				<button class="btn btn-primary" onclick="shenpi()">审批</button>
				<button class="btn btn-primary" onclick="tuihui()">退回</button>
				<button class="btn loc-right" onclick="print()">打印</button>
				<button class="btn loc-right" onclick="exports()">导出</button>
				<div class="loc-right">列表：</div>			
			</div>
		</div>
	</div>
	
	
	<div class="modal fade" role="dialog" id="caseDetailModal">
  		<div class="modal-dialog" role="document">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title" id="gridSystemModalLabel">Modal title</h4>
      				</div>
      		<div class="modal-body">
        		<textarea class="form-control" rows="3" id="caseDetailTextarea"></textarea>
      		</div>
      		<div class="modal-footer">
        		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        		<button type="button" class="btn btn-primary">Save changes</button>
      		</div>
    		</div><!-- /.modal-content -->
  		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<div class="modal fade" role="dialog" id="shenpiModal">
  		<div class="modal-dialog" role="document">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title" id="gridSystemModalLabel">审批</h4>
      				</div>
      		<div class="modal-body">
        		<div class="container-fluid">
        			<div class="row"></div>
  					<div class="row">
  						<div class="col-md-3 dlabel">
  							审批时间:
  						</div>
  						<div class="col-md-3" id="currentDateShenpi">
  							2015-10-15
  						</div>
  						<div class="col-md-3 dlabel">审批人:</div>
  						<div class="col-md-3">${currentUser.realname}</div>
					</div>
					<div class="row">
  						<div class="col-md-3 dlabel">审批意见:</div>
  						<div class="col-md-9">
  							<textarea rows="3" cols="50" id="spyjShenpi">符合立案条件</textarea>  							
  						</div>
					</div>
					<div class="row"></div>
				</div>
      		</div>
      		<div class="modal-footer">
        		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        		<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="approval()">确定 </button>
      		</div>
    		</div><!-- /.modal-content -->
  		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<div class="modal fade" role="dialog" id="tuihuiModal">
  		<div class="modal-dialog" role="document">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title" id="gridSystemModalLabel">退回</h4>
      				</div>
      		<div class="modal-body">
        		<div class="container-fluid">
        			<div class="row"></div>
  					<div class="row">
  						<div class="col-md-3 dlabel">
  							审批时间:
  						</div>
  						<div class="col-md-3"  id="currentDateTuihui">
  							2015-10-15
  						</div>
  						<div class="col-md-3 dlabel">审批人:</div>
  						<div class="col-md-3">${currentUser.realname}</div>
					</div>
					<div class="row">
  						<div class="col-md-3 dlabel">退回原因:</div>
  						<div class="col-md-9">
  							<textarea rows="3" cols="50" id="spyjTuihui">材料不全</textarea>
  						</div>
					</div>
					<div class="row"></div>
				</div>
      		</div>
      		<div class="modal-footer">
        		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        		<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="reject()">确定 </button>
      		</div>
    		</div><!-- /.modal-content -->
  		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
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
  						<div class="col-md-2 noborder" style="padding:0px;">
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
  						<div class="col-md-6" id="mbafy">
  							null
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
  								<option>是</option>
  								<option>否</option>
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


<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/ajcl-dsplb/custom.css"/><jsp:text/>
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
        		"内容"
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
  						<div class="col-md-3">
  							2015-10-15
  						</div>
  						<div class="col-md-3 dlabel">审批人:</div>
  						<div class="col-md-3">${currentUser.realname}</div>
					</div>
					<div class="row">
  						<div class="col-md-3 dlabel">审批意见:</div>
  						<div class="col-md-9">
  							<textarea rows="3" cols="50">符合立案条件</textarea>
  						</div>
					</div>
					<div class="row"></div>
				</div>
      		</div>
      		<div class="modal-footer">
        		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        		<button type="button" class="btn btn-primary" data-dismiss="modal">确定 </button>
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
  						<div class="col-md-3">
  							2015-10-15
  						</div>
  						<div class="col-md-3 dlabel">审批人:</div>
  						<div class="col-md-3">${currentUser.realname}</div>
					</div>
					<div class="row">
  						<div class="col-md-3 dlabel">退回原因:</div>
  						<div class="col-md-9">
  							<textarea rows="3" cols="50">材料不全</textarea>
  						</div>
					</div>
					<div class="row"></div>
				</div>
      		</div>
      		<div class="modal-footer">
        		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        		<button type="button" class="btn btn-primary" data-dismiss="modal">确定 </button>
      		</div>
    		</div><!-- /.modal-content -->
  		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</body>
</html>


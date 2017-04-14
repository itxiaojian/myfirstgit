<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
</head>
<body>
	<div class="wrapper">
	<div class="panel" style="margin-bottom: 1px;">
		<div class="panel-body">
			<div style="text-align:center;margin-bottom:-2px"></div>
                <form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
                
			<div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label">设备编号：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value=""  name="sbbh" style="width:100%;" id="sbbh" required data-msg-required="设备编号必填" minlength="1" data-msg-minlength="必填">
					</div>
					<label class="col-sm-2 col-sm-2 control-label">设备名称：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="" name="sbmc" style="width:100%;" id="sbmc" required data-msg-required="设备名称必填" minlength="1" data-msg-minlength="必填">
				</div>
			</div>

					<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label">设备条形码：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="txmbh" name="txmbh" style="width:100%;">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">维保人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="wbr" name="wbr" style="width:100%;">
						</div>
					</div>

					<div class="panel-body">
					    <label class="col-sm-2 col-sm-2 control-label" >维保状态：</label>
						<div class="col-sm-10">
							<select class="form-control input-lg m-bot15" name="wbzt" style="font-size:14px; height:25px;">
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="wbzt" items="${wbzt}" varStatus="obj">
										<option value="${wbzt.zdz }">${wbzt.zdmc }</option>
								</c:forEach>
					        </select>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">维保时间：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="wbsj" name="wbsj" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width:100%;">
						</div>
					</div>
					
					<div class="panel-body">
					    <label class="col-sm-2 col-sm-2 control-label" >维保内容：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="wbnr" name="wbnr" style="width:100%;">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">维保费用：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="wbfy" name="wbfy" style="width:100%;">
						</div>
					</div>

					<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label">备注：</label>
						<div class="col-sm-10">
							<textarea class="form-control" truetype="textarea" id="bz"
								name="bz" rows="3" style="width: 280%;"></textarea>
						</div>
					</div>
					<div style="text-align: center">
						<div class="form-group" style="margin-top: 89px; margin-left: -271px;">
							<button type="button" class="btn btn-success"
								onClick="save()">提交</button>
							<button type="button" class="btn btn-success"
								onClick="exit();">返回</button>
						</div>
					</div>
				</form>
		  </div>
	   </div>
    </div>
</body>
<script>
//返回
function exit(){
	/* var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
}

//提交
function save() {
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/sbgl/YsbBxjl/save";
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : $('#myForm').serialize(),// 你的formid
			async : false,
			error : function(request) {
				alert("保存失败,请联系管理员。");
			},
			success : function(data) {
				alert('保存成功！');
				var PAGESIZE = 20;
				window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	            window.parent.ACT_DEAL_WINDOW.close();
			}
		});
	}
} 
</script>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet"
	href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="<%=path%>/resources/css/jygl/style.css">
	
	
</head>

<script type="text/javascript">
function close(){
	var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
    window.parent.ACT_DEAL_WINDOW.close();
}


function openwin() {  
    var id = $("#id").val(); 
    location.href="Hfxx?id="+id;
}
	</script>
<body>
	<div class="wrapper">
		<div class="panel">
			<header class="panel-heading"> 发文信息 </header>
			<form action="" class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
				<input type="hidden" name="id" id="id" value="${fwxx.id }">

				<div class="panel-body" >
						<label class="col-sm-2 col-sm-2 control-label">主题：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="zt" value="${fwxx.zt }" disabled="true" style="width: 280%;" >
					</div>
					 
			</div>

				<div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label">正文：</label>
					<div class="col-sm-10">
						<textarea class="form-control" truetype="textarea"  disabled="true" name="zw" rows="3" style="width: 280%;" >${fwxx.zw} </textarea>
					</div>
				</div>
				<div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label">发送时间：</label>
					<div class="col-sm-10">
					<!--拉取当前时间到文本框  -->
						<%
							Date date = new Date();
							SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String strdate = sdate.format(date);
						%>
						<input type="text" value="<%=strdate%>" name="fssj" class="form-control" disabled="true" style="width: 90%;" 
							onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
					</div>
					<label class="col-sm-2 col-sm-2 control-label">附件：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text"  disabled="true"
							value="${fwxx.fj}" name="fj">
					</div>
					
				</div>
				
				<div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label">发文单位：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text"  disabled="true" style="width: 90%;" 
							value="${fwxx.bmbh}" name="bmbh">
					</div>
					<label class="col-sm-2 col-sm-2 control-label">发文人：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value="${fwxx.fwr}" disabled="true" style="width: 100%;" name="fwr">
					</div>
				</div>

				<div style="text-align: center">
					<div class="panel-body">
						<a class="btn btn-success" onclick="openwin();" type="submit" style="width: 56px; margin-top: 11px; padding-left: 15px; border-left-width: 1px; margin-left: -296px;">回复</a>
							<input class="btn btn-success"type="button" style="width: 60px; margin-top: 11px;" onclick="self.close();" value="关闭">
					</div>

				</div>

			</form>

		</div>

	</div>

	</div>
</body>
</html>
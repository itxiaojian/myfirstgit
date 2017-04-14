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
function openwin() {  
    var id = $("#id").val(); 
    location.href="khxx?id="+id;
}  


function close(){
	var PAGESIZE = 10;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
    window.parent.ACT_DEAL_WINDOW.close();
}

	</script>
<body>
	<div class="wrapper">
		<div class="panel">
			<header class="panel-heading"> 投诉信息 </header>
			<form action="" class="form-horizontal tasi-form" name="myForm"
				id="myForm" method="post">
				<input type="hidden" name="id" id="id" value="${tsxx.id }">

				<div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label" >投诉人：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value="${tsxx.tsr }" disabled="true" style="width:400%;height:28px;"
							name="tsr"  >
					</div>
				</div>
				
				<div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label" >被投诉人：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text"  style="width:400%;height:28px;"
							value="${tsxx.btsr}" name="btsr"  disabled="true" >
					</div>
				</div>

				<div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label">投诉类型：</label>
					<div class="col-sm-10">
						<select class="form-control input-lg m-bot15" name="tslx"   disabled="true"      style="width:400%;height:28px;"     
							style="font-size: 14px; height: 25px;">
							<option selected="selected">${tsxx.tslx }</option>
							<c:forEach var="tslx" items="${tslx}" varStatus="obj">
								<option  >${tslx.zdmc }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label" >投诉日期：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" 
							value="${tsxx.tsrq }" name="tsrq" disabled="true" style="width:400%;height:28px;"
							onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
					</div>
				</div>

				<div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label">投诉内容：</label>
					<div class="col-sm-10">
						<textarea class="form-control"  disabled="ture" truetype="textarea"  name="tsnr" style="width: 400%;height: 80px;">${tsxx.tsnr}</textarea>
					</div>
				</div>
				
				<%-- <div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label">处理日期：</label>
					<div class="col-sm-10">
					<!--拉取当前时间到文本框  -->
						<%
							Date date = new Date();
							SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String strdate = sdate.format(date);
						%>
						<input type="text" value="<%=strdate%>" name="clrq" class="form-control"
							onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
					</div>
				</div> --%>
				
				<%-- <div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">处理状态：</label>
				<div class="col-sm-10">
					<select class="form-control input-lg m-bot15" name="clzt" style="font-size:14px; height:40px;">
				<c:forEach var="clzt" items="${clzt}" varStatus="obj">
						<option value="${clzt.zdz }" <c:if test="${clzt.zdz=='1' }">selected="selected"</c:if> >${clzt.zdmc }</option>
				</c:forEach>
					</select>
				</div>
			</div> --%>
				<div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label">备注：</label>
					<div class="col-sm-10">
						<textarea class="form-control"  disabled="ture" truetype="textarea"  name="bz" style="width: 400%;height: 80px;">${tsxx.bz}</textarea>
					</div>
				</div>
				<div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label"></label>
					<div class="col-sm-10">
						<textarea class="form-control"  disabled="ture" truetype="textarea"  name="cljg" style="display:none">${tsxx.cljg}</textarea>
					</div>
				</div>
				<div class="panel-body">
					
					<label class="col-sm-2 col-sm-2 control-label"></label>
					<div class="col-sm-10">
						<input class="form-control" type="hidden" value="${tsxx.clzt}" disabled="true" style="width:400%;height:28px;"
							name="clzt">
					</div>
				</div>

				<div style="text-align: center">
					<div class="panel-body">
						 <input class="btn btn-success"
							type="button" onclick="self.close();" value="关闭">
					</div>

				</div>

			</form>

		</div>

	</div>

	</div>
</body>
</html>
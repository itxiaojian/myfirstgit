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
	<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
	<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
	<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
	<script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
<%--     <link href="<%=path%>/resources/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/> --%>
<%--     <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.min.js"></script> --%>
<%--     <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script> --%>
<%--     <script type="text/javascript" src="<%=path%>/resources/js/cps/checkData.js"></script> --%>
    
<!-- 		<meta http-equiv="pragma" content="no-cache"> -->
<!-- 		<meta http-equiv="cache-control" content="no-cache"> -->
<!-- 		<meta http-equiv="expires" content="0"> -->
<!-- 		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> -->
<!-- 		<meta http-equiv="description" content="This is my page"> -->

</head>
<body >
<div class="wrapper">
	<div class="panel" style="margin-bottom: 1px;">
		<div class="panel-body">
			<div style="text-align:center;margin-bottom:-2px"></div>
			<form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post"  style="overflow:scroll;overflow:hidden">
				<c:forEach var="daxx" items="${daxx}" varStatus="obj">
					<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">档案标题：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="dabt" name="dabt" disabled="true" value="${daxx.dabt }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">档案类型：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="dalx" name="dalx" disabled="true" value="${daxx.dalx }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">档案关键字：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="dagjz" name="dagjz" disabled="true" value="${daxx.dagjz }">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">所属机构：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="ssjgid" name="ssjgid" disabled="true" value="${daxx.ssjgid }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">档案类目：</label>
						<div class="col-sm-10">
							<input class="form-control"  type="text" id="lmmc" name="lmmc" disabled="true" value="${daxx.lmmc }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">档案密级：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="damj" name="damj" disabled="true" value="${daxx.damj }">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px; padding-top: 2px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">保管期限：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="bgqx" name="bgqx" disabled="true" value="${daxx.bgqx }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">归档内容：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="gdnr" name="gdnr" disabled="true" value="${daxx.gdnr }" >
						</div>
						<label class="col-sm-2 col-sm-2 control-label">附件：</label>
						<div class="col-sm-10">
							<input type="text" name="fjid"  class="form-control" name="fjid" disabled="true" value="${daxx.fjid }">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px; padding-top: 2px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">可查看人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="kckrxm" name="kckrxm" disabled="true" value="${daxx.kckrxm }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">归档人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="gdr" name="gdr" disabled="true" value="${daxx.gdr }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">是否清档：</label>
						<div class="col-sm-10">
							<c:choose>
								<c:when test="${daxx.sfqd == 1 }">
									<input class="form-control" type="text" id="sfqd" name="sfqd" disabled="true" value="是">
								</c:when>
								<c:otherwise>
									<input class="form-control" type="text" id="sfqd" name="sfqd" disabled="true" value="否">
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="6" name="bz" disabled="true"
									  truetype="textarea" style="width: 99%;height: 35px;">${daxx.bz}</textarea>
						</div>
					</div>
				</c:forEach>
				
				<div style="text-align: center">
					<div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 75px;">
						<button type="button" class="btn btn-success"
								onClick="exit();">关闭</button>
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
</script>
<style>
	.form-control.form-control1 {
		background-color: #fff;
		border: 1px solid #ccc;
		border-radius: 4px;
		box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
		color: #555;
		display: block;
		font-size: 14px;
		height: 30px;
		line-height: 1.42857;
		padding: 6px 12px;
		transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
		vertical-align: middle;
		width: 100%;
	}
	a.link {
		background-color: #5cb85c;
		border-radius: 4px;
		color: #fff;
		cursor: pointer;
		display: inline-block;
		float: left;
		font: 13px/19px "Microsoft YaHei",Verdana,Geneva,sans-serif;
		padding: 1%;
		margin-top: 3px;
		text-align: center;
		text-decoration: none;
		width: 10%;
	}
</style>

</html>

<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*;"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%
	String ysjlwjm = request.getParameter("ysjlwjm");
    String url = "/zjyw/resources/home/"+ysjlwjm;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>原始记录查看</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
		<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
		<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
		<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
		<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
		<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
		<script type="text/javascript">
	        function exit(){
	        	window.history.back(-1);
	        }
    	</script>
	</head>
	<body>
		<form id="form1">
		    <div style="text-align: left;margin-bottom: 9px;">
				<div class="form-group" style="margin-top: 0px;margin-bottom: 9px;">
					<button type="button" style="margin-left: 13px; margin-top: 9px;" class="btn btn-success" onClick="exit();">返回</button>
				</div>
			</div>
			<div style="width: auto; height: 700px;">
				<img height=100% width=100% src="/zjyw/resources/home/<%=ysjlwjm%>"></img>
			</div>
			
		</form>
	</body>
</html>
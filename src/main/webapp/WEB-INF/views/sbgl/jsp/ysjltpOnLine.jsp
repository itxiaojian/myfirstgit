<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*;"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<% String path = request.getContextPath();%>
<%
	String jdzssub = request.getParameter("jdzssub");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>文件查看</title>
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
			<c:if test="${cs=='null'}">
		    <div style="text-align: left;margin-bottom: 9px;">
				<div class="form-group" style="margin-top: 0px;margin-bottom: 9px;">
					<button type="button" style="margin-left: 13px; margin-top: 9px;" class="btn btn-success" onClick="exit();">返回</button>
				</div>
			</div>
			</c:if>
			<div style="width: auto; height: 700px;">
				<img height=100% width=100% src="/zjyw/<%=jdzssub%>"></img>
			</div>
		</form>
	</body>
</html>
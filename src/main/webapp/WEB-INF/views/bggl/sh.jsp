<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<% String path = request.getContextPath();
String bgbh = request.getParameter("bgbh");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
	<div class="wrapper">
		<div style="height: 80px;text-align:center;">
		  <label style="margin-top: 10%;font-size: 21px">请稍候，任务处理中...</label>
		</div>
<!-- 		<div align="center"> -->
<!-- 			<br> -->
<!-- 			<input type="submit" class="btn btn-primary" onclick="queding();" value="确定" /> -->
<!-- 		</div> -->
		<div style="width:0px;height:0px;border-width: 0px;">
			<iframe id="test1" src="<%=path%>/jygl/YjyBgxx/bgcc?bgbh=<%=bgbh%>" style="width:0px;height:0px;border-width: 0px;"></iframe>
		</div>
	</div>
</body>
</html>
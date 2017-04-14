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

<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/source/css/jquery-ui-1.8.16.custom.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/source/css/main.css" />
<script type="text/javascript" src="<%=path%>/resources/js/source/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/source/js/jquery-ui-1.8.16.custom.min.js"></script> 
<script type="text/javascript" src="<%=path%>/resources/js/source/js/script.js"></script>

</head>
<script type="text/javascript">

function loadTest1(){
	document.getElementById('test1').src='<%=path%>/jygl/YjyBgxx/fengmian?bgbh=<%=bgbh%>';
}
window.setTimeout(loadTest1,1000);

function loadTest2(){
	document.getElementById('test2').src='<%=path%>/jygl/YjyBgxx/shouye?bgbh=<%=bgbh%>';
}
window.setTimeout(loadTest2,1000);

</script>
<body>
	<div class="wrapper">
		<div style="height: 80px;text-align:center;">
		  <label style="margin-top: 10%;font-size: 21px">正在生成报告，请稍候...</label>
		</div>
		
	        <div id="progress1" style="margin-top: -4%">
	            <div class="percent"></div>
	            <div class="pbar"></div>
<!-- 	            <div class="elapsed"></div> -->
	        </div>
    	
		<div style="width:0px;height:0px;border-width: 0px;">
			<iframe id="test1" src="" style="width:0px;height:0px;border-width: 0px;"></iframe>
	    	<iframe id="test2" src="" style="width:0px;height:0px;border-width: 0px;"></iframe>
		</div>
	</div>
</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
String bgbh = request.getParameter("bgbh");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/source/js/jquery-ui-1.8.16.custom.min.js"></script> 
<script type="text/javascript" src="<%=path%>/resources/js/source/js/script.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/source/css/jquery-ui-1.8.16.custom.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/source/css/main.css" />
<%-- <script type="text/javascript" src="<%=path%>/resources/js/app.js"></script> --%>

</head>
<script type="text/javascript">

function CS(){
		document.getElementById('test1').src='<%=path%>/jygl/YjyBgxx/ybbg?bgbh=<%=bgbh %>';
		document.getElementById('test2').src='<%=path%>/jygl/YjyBgxx/fengmian?bgbh=<%=bgbh%>';
		document.getElementById('test3').src='<%=path%>/jygl/YjyBgxx/shouye?bgbh=<%=bgbh%>';
}

// function loadTest1(){

// }
// window.setTimeout(loadTest1,0);

// function loadTest2(){
// }
// window.setTimeout(loadTest2,0);

// function loadTest3(){
// }
// window.setTimeout(loadTest3,0);

</script>
<body onload="CS()">
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
	    	<iframe id="test3" src="" style="width:0px;height:0px;border-width: 0px;"></iframe>
		</div>
	</div>
</body>
</html>
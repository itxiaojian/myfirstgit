<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<link href="<%=path%>/resources/bootstrap/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<meta name="viewport"
	content="width=device-width,user-scalable=yes, initial-scale=1,maximum-scale=3">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<link type="text/css" rel="stylesheet"
	href="<%=path%>/resources/css/xyxw.css" />
<title>我的任务</title>
<style type="text/css">
.anniu {
	position: absolute;
	top: 11%;
	right: 88%
}

.return {
	position: absolute;
	top: 11%;
	left: 88%
}
</style>
</head>
<script type="text/javascript">
    function save(id){
    	location.href="<%=path%>/wxpt/WglXgxx/wglWdrwXq?id="+id;
    };
  </script>
 <script type="text/javascript">
		function query(){	
			if($('#search').val()=="样品名称"){$('#search').val('');}
			$("#myForm").submit();
		}
 </script>
 <!--  <script type="text/javascript">
 $(document).ready(function(){
	  $("#t3").click(function(){
	    $("#rwxq").attr("src","<%=path%>/resources/img/rwxq2.png");
	  });
	});
 </script>-->
 
   
<body style="overflow: auto;">
	<div class="main">
		<div class="DYtop">
			<img style="width: 100%;" src="<%=path%>/resources/img/wxptLOGO.png" />

		</div>

		<div class="middle" style="padding-bottom: 2px;position: relative;">
			<h1 style="color: #0D91DE"><b>我的任务</b></h1>
			<div class="anniu">
				<a href="<%=path%>/wxpt/WglXgxx/wglZy?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/zyan.png" />
				</a>
			</div>
			<div class="return">
				<a href="<%=path%>/wxpt/WglXgxx/wglZy?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/return.png" />
				</a>
			</div>
			
		</div>

		<div class="bottom" style="position: relative;">
			<div class="h"></div>
			<div>
			<p></p>
			<div align="center">
			<form action="<%=path%>/wxpt/WglXgxx/wxptWdrw" id="myForm" method="post">
			<input type="text" style="width: 70%;hight:30%;" value="样品名称" id="search"  name="search" />                     
					<script language="javascript"> 
 	                    var s=document.getElementById("search");
 	                    s.onfocus=function(){if(this.value==this.defaultValue)this.value=''};
	                    s.onblur=function (){if(/^\s*$/.test(this.value)){this.value=this.defaultValue;this.style.color='#aaa'}}
	                    s.onkeydown=function(){	this.style.color='#333'}
                    </script> 
			
			<img  onclick="query();" src="<%=path%>/resources/img/ss.gif" style="width: 20px; height: 20px;margin-top: -3px;"/>
			</form>
			</div>
			<form action="" id="form" name="form" method="post">
			<div style="position: relative;" align="center">
			<p></p>
			<table class="table table-striped table-hover table-bordered" id="editable-sample">
			           <tr>	
							<td align="center" style="width: 74px;">任务节点</td>
							<td align="center" style="width: 115px;">检验类型</td>
							<td align="center" style="width: 113px;">样品名称</td>
							<td align="center" style="width: 115px;">要求开始时间</td>
						</tr>
			         <c:forEach var="getwdrw" items="${getwdrw}" varStatus="obj">
						<tr id="t3">
						<%-- <tr id="t3" style="cursor: pointer;" href="javascript:void(0);" onclick="save('${getwdrw.id }');">	 --%>
						<%-- 	<td align="center" style="width: 74px;"><img alt="" id="rwxq" src="<%=path%>/resources/img/rwxq1.gif" onclick="this.src='<%=path%>/resources/img/rwxq2.png'" style="height: 24px;width: 24px;"></td> --%>
							<td align="center" style="width: 113px;">${getwdrw.rwlx }</td>
							<td align="center" style="width: 113px;">${getwdrw.rwly }</td>
							<td align="center" style="width: 113px;">${getwdrw.rwmc }</td>
							<td align="center" style="width: 115px;">${getwdrw.yqksrq }</td>
						</tr>
			         </c:forEach>	
				</table>
			</div>
			</form>
		</div>    
	</div>
	
</body>

</html>
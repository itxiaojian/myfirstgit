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
<body style="overflow: auto;">
	<div class="main">
		<div class="DYtop">
			<img style="width: 100%;" src="<%=path%>/resources/img/wxptLOGO.png" />

		</div>

		<div class="middle" style="padding-bottom: 2px;position: relative;">
			<h1 style="color: #0D91DE"><b>我的任务详情</b></h1>
			<div class="anniu">
				<a href="<%=path%>/wxpt/WglXgxx/wglZy?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/zyan.png" />
				</a>
			</div>
			<div class="return">
				<a href="<%=path%>/wxpt/WglXgxx/wglWdrw?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/return.png" />
				</a>
			</div>
			  
		</div>

		<div class="bottom" style="position: relative;">
			<div class="h"></div>
			<div>
			<p></p>
			<div style="position: relative;" align="center">
			<p></p>
			<c:forEach var="getWdrw" items="${getWdrw}" varStatus="obj">
			<div class="form-group">
			<table border="2" style="width: 100%;height: 30px;" bordercolor="#E0E0E0">
			<tr>
			   <td align="center" style="height: 37px;">任务负责人：</td>
			    <td align="center">${getWdrw.rwfzr}</td>
			     <td align="center">报告编号：</td>
			      <td align="center">${getWdrw.bgbh}</td>
			</tr>
			<tr>
			    <td align="center" style="height: 37px;">任务名称：</td>
			     <td align="center">${getWdrw.rwmc}</td>
			      <td align="center">所属项目：</td>
			       <td align="center">${getWdrw.ssxm}</td>
			</tr>
			<tr>
			   <td align="center" style="height: 37px;">任务类型：</td>
			    <td align="center">${getWdrw.rwlx}</td>
			     <td align="center">要求开始日期：</td>
			      <td align="center">${getWdrw.yqksrq}</td>
			</tr>
			<tr>
			   <td align="center" style="height: 37px;">要求结束日期：</td>
			    <td align="center">${getWdrw.yqjsrq}</td>
			     <td align="center">实际开始日期：</td>
			      <td align="center">${getWdrw.sjksrq}</td>
			</tr>
			<tr>
			   <td align="center" style="height: 37px;">实际结束日期：</td>
			    <td align="center">${getWdrw.sjjsrq}</td>
			       <td align="center">完成进度：</td>
			        <td align="center">${getWdrw.wcjd}</td>
                    </td>
			</tr>
			<tr> 
			     <td align="center" style="height: 37px;">任务来源：</td>
			      <td align="center">${getWdrw.rwly}</td>
			</tr>
			</table>
			</div>
			</c:forEach>
			</div>
		</div>
	</div>
	
</body>
</html>
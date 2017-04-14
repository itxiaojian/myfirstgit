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
<title>工作汇报详情</title>
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
			<h1 style="color: #0D91DE"><b>工作汇报详情</b></h1>
			<div class="anniu">
				<a href="<%=path%>/wxpt/WglXgxx/wglZy?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/zyan.png" />
				</a>
			</div>
			<div class="return">
				<a href="<%=path%>/wxpt/WglXgxx/wglGzhbList1?openId=${openId}"
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
			<table border="2" style="width: 100%;height: 30px;" bordercolor="#E0E0E0">
			<c:forEach var="data" items="${hblistxq1}" varStatus="status">
			<tr>
			   <td align="center" style="height: 37px;">汇报类型：</td>
			    <td align="center">${data.hblxmc}</td>
			     <td align="center">汇报人：</td>
			      <td align="center">${data.hbrxm}</td>
			       <td align="center"></td>
			        <td align="center"><a href=""></a></td>
			</tr>
			<tr>
			    <td align="center" style="height: 37px;">接收人：</td>
			     <td align="center">${data.jsrxm}</td>
			      <td align="center">汇报日期：</td>
			       <td align="center">${data.hbrq}</td>
			</tr>
				<tr>
				<td align="center" style="height: 37px;">汇报内容：</td>
			    <td align="left" colspan="3">${data.hbnr}</td>
				</tr>
				</c:forEach>
			</table>
			</div>
		</div>
	</div>
	
</body>
</html>
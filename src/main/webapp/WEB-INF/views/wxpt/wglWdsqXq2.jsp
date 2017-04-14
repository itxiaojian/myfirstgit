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
<title>申请详情</title>
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
			<h1 style="color: #0D91DE"><b>申请详情</b></h1>
			<div class="anniu">
				<a href="<%=path%>/wxpt/WglXgxx/wglZy?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/zyan.png" />
				</a>
			</div>
			<div class="return">
				<a href="<%=path%>/wxpt/WglXgxx/wglWdsqList?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/return.png" />
				</a>
			</div>
			
		</div>

		<div class="bottom" style="position: relative;height:300px;">
			<div class="h"></div>
			<div>
			<p></p>
			<div style="position: relative;" align="center">
			<p></p>
			<table border="2" style="width: 100%;height:200px;" bordercolor="#E0E0E0">
			<c:forEach var="data" items="${cswdsqdetail}" varStatus="status">
			<tr>
			   <td align="center" style="">申请类型：</td>
			    <td align="center"> 
	   	     <c:choose>
			   <c:when test="${data.sqlx==0 }">
			               培训
			   </c:when>
			   <c:when test="${data.sqlx==1}">
			              加班
			   </c:when>
			   <c:when test="${data.sqlx==2}">
			              工作请假
			   </c:when>
			   <c:when test="${data.sqlx==3}">
			             出差申请
			   </c:when>
			   <c:when test="${data.sqlx==4}">
			             外出
			   </c:when>
			   <c:when test="${data.sqlx==5}">
			              物品采购
			   </c:when>
			    <c:otherwise>
			             费用报销
			   </c:otherwise>
			   </c:choose></td>
			     <td align="center">申请名称：</td>
			      <td align="center">
                <c:choose>
			        <c:when test="${data.sqlx==0}">
			                           培训请假
			        </c:when>
			   <c:when test="${data.sqlx==1}">
			                 加班申请
			   </c:when>
			   <c:when test="${data.sqlx==2}">
			               工作请假
			   </c:when>
			     <c:when test="${data.sqlx==3}">
			                 出差请假
			     </c:when>
			   <c:when test="${data.sqlx==4}">
			              外出请假
			   </c:when>
			   <c:when test="${data.sqlx==5}">
			              物品采购申请
			   </c:when>
			   <c:otherwise>
			              费用报销
			   </c:otherwise>
			   </c:choose></td>
			       <td align="center">申请原由：</td>
			        <td align="center">${data.sqnr}</td>
			</tr>
			<tr>
			    <td align="center" style="">申请人：</td>
			     <td align="center">${data.sqrxm}</td>
			      <td align="center">申请日期：</td>
			       <td align="center">${data.sqrq}</td>
			       <td align="center">申请状态：</td>
			    <td align="center">${data.ztmc}</td>
			</tr>
			<tr>
			     <td align="center">开始时间：</td>
			     <td align="center">${data.sjsj}</td>
				 <td align="center">结束时间：</td>
			     <td align="center">${data.xjsj}</td>
			     <td align="center"></td>
			     <td align="center"></td>
			</tr>
			<tr>
		     	<td align="center">备注：</td>
			    <td align="center">无</td>
			   	<td align="center"></td>
			    <td align="center"></td>
			</tr>
			</c:forEach>
			</table>
			</div>
		</div>
	</div>
	
</body>
</html>
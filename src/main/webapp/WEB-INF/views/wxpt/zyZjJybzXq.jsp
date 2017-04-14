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
<title>设备信息</title>
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
			<h1 style="color: #0D91DE"><b>检验标准详情</b></h1>
			<div class="anniu">
				<a href="<%=path%>/wxpt/ZyZjxgxx/zhuye?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/zyan.png" />
				</a>
			</div>
			<div class="return">
				<a href="<%=path%>/wxpt/ZyZjxgxx/zyJybz?openId=${openId}"
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
			<c:forEach var="getbzxx" items="${getbzxx}" varStatus="obj">
			<div class="form-group">
			<table border="2" style="width:100%;height: 30px;" bordercolor="#E0E0E0">
			<tr>
			   <td align="center" style="height: 37px;"><b>标准编号</b></td>
			    <td align="center">${getbzxx.bzbh}</td>
			     <td align="center"><b>标准名称</b></td>
			      <td align="center">${getbzxx.bzmc }</td>
			       <td align="center"><b>名称附注</b></td>
			        <td align="center">${getbzxx.bzmc_fz }</td>
			</tr>
			<tr>
			    <td align="center" style="height: 37px;"><b>标准类别</b></td>
			     <td align="center">${getbzxx.bzlb }</td>
			      <td align="center"><b>标准级别</b></td>
			       <td align="center">${getbzxx.bzjb }</td>
			        <td align="center"><b>启用日期</b></td>
			         <td align="center" >${getbzxx.qyrq }</td>
			</tr>
				<tr>
			   <td align="center" style="height: 37px;"><b>最后修改时间</b></td>
			    <td align="center">${getbzxx.zhxgsj }</td>
			     <td align="center"><b>修改人</b></td>
			      <td align="center">${getbzxx.xgr }</td>
			       <td align="center"><b>废止状态</b></td>
			        <td><input align="center" type="hidden" name="fzzt" value="${getbzxx.fzzt }"/>
                                  	<c:choose>
                                  		<c:when test="${getbzxx.fzzt  =='0'}"><span style="text-align:center;display:block;" >正常使用</span></c:when>
                                  		<c:when test="${getbzxx.fzzt  =='1'}"><span style="text-align:center;display:block;" >停用</span></c:when>
                                  	    <c:when test="${getbzxx.fzzt  =='2'}"><span style="text-align:center;display:block;"  >废除</span></c:when>
                                  	</c:choose>
                                  </td>
			</tr>
				<tr>
			   <td align="center" style="height: 37px;"><b>废止人</b></td>
			    <td align="center">${getbzxx.fzdjr }</td>
			     <td align="center"><b>审核状态</b></td>
			     <td><input type="hidden" name="fzzt" value="${getbzxx.shzt }"/>
                                  	<c:choose>
                                  		<c:when test="${getbzxx.shzt  =='0'}"><span style="text-align:center;display:block;" >未审核</span></c:when>
                                  		<c:when test="${getbzxx.shzt  =='1'}"><span style="text-align:center;display:block;" >通过</span></c:when>
                                  	    <c:when test="${getbzxx.shzt  =='2'}"><span style="text-align:center;display:block;" >未通过</span></c:when>
                                  	</c:choose>
                                  </td>
			       <td align="center"><b>审核日期</b></td>
			        <td align="center">${getbzxx.shrq }</td>
			</tr>
			<tr>
			   <td align="center" style="height: 37px;"><b>审核人</b></td>
			    <td align="center">${getbzxx.shr }</td>
			     <td align="center"><b>开始时间</b></td>
			      <td align="center">${getbzxx.kssj }</td>
			       <td align="center"><b>结束时间</b></td>
			        <td align="center">${getbzxx.jssj }</td>
			</tr>
			<tr>
				<td align="center" style="height: 37px;"><b>备&nbsp;&nbsp;&nbsp;注</b></td>
			    <td align="center" colspan="5">${getbzxx.bz }</td>
			</tr>
			</table>
			</div>
			</c:forEach>
			</div>
			</div>
		</div>
	</div>
	
</body>
</html>
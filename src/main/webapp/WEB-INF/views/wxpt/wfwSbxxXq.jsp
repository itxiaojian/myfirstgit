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
			<h1 style="color: #0D91DE"><b>设备信息详情</b></h1>
			<div class="anniu">
				<a href="<%=path%>/wxpt/WfwXgxx/wfwZy"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/zyan.png" />
				</a>
			</div>
			<div class="return">
				<a href="<%=path%>/wxpt/WfwXgxx/wfwSbxx"
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
			<c:forEach var="getSbxx" items="${getSbxx}" varStatus="obj">
			<div class="form-group">
			<table border="2" style="width: 100%;height: 30px;" bordercolor="#E0E0E0">
			<tr>
			   <td align="center" >设备编号：</td>
			   <td align="center">${getSbxx.sbbh}</td>
			   <td align="center">设备名称：</td>
			   <td align="center">${getSbxx.sbmc}</td>
			</tr>
			<tr>
			    <td align="center" >设备类型：</td>
			    <td align="center">${getSbxx.sblx}</td>
			    <td align="center">设备型号：</td>
			    <td align="center">${getSbxx.sbxh}</td>
			</tr>
			<tr>
			    <td align="center" >使用科室：</td>
			    <td align="center">${getSbxx.syks}</td>
			    <td align="center">使用范围：</td>
			    <td align="center">${getSbxx.syfw}</td>
			</tr>
			<tr>
			    <td align="center">设备级别：</td>
			    <td align="center" >${getSbxx.sbjb}</td>
			    <td align="center">生产厂家：</td>
			    <td align="center">${getSbxx.sccj}</td>
			</tr>
			<tr>
			    <td align="center" >出厂编号：</td>
			    <td align="center">${getSbxx.ccbh}</td>
			    <td align="center">出厂日期：</td>
			    <td align="center">${getSbxx.ccrq}</td>
			</tr>
			<tr>
			    <td align="center">购买日期：</td>
			    <td align="center">${getSbxx.gmrq}</td>
			    <td align="center" style="height: 37px;">购买价格：</td>
			    <td align="center">${getSbxx.gmjg}</td>
			</tr>
			<tr>
			    <td align="center">检验周期：</td>
			    <td align="center">${getSbxx.jyzq}</td>
			    <td align="center">使用期限：</td>
			    <td align="center">${getSbxx.syqx}</td>
			</tr>
			<tr>
			    <td align="center" style="height: 37px;">上次检定日期：</td>
			    <td align="center">${getSbxx.scjdrq}</td>
			    <td align="center">下次检定日期：</td>
			    <td align="center">${getSbxx.xcjdrq}</td>
			</tr>
            <tr>
			    <td align="center">状态：</td>
			    <td><input type="hidden" name="syzt" value="${sbxx.zt }"/>
                <c:choose>
                	<c:when test="${sbxx.zt  =='0'}"><span class="label label-success label-mini">正常</span></c:when>
                    <c:when test="${sbxx.zt  =='1'}"><span class="label label-danger label-mini">报废</span></c:when>
                 </c:choose>
                </td>
			   <td align="center" style="height: 37px;">设备维护人：</td>
			   <td align="center">${getSbxx.sbwhr}</td>
			</tr>
			<tr>
			    <td align="center">停用日期：</td>
			    <td align="center">${getSbxx.tyrq}</td>
			    <td align="center">停用原因：</td>
			    <td align="center">${getSbxx.tyyy}</td>
			</tr>
			<tr>
			    <td align="center">开始时间：</td>
			    <td align="center">${getSbxx.kssj}</td>
			    <td align="center" style="height: 37px;">结束时间：</td>
			    <td align="center">${getSbxx.jssj}</td>
			</tr>
			<tr>
			    <td align="center" style="height: 37px;">报废日期：</td>
			    <td align="center">${getSbxx.bfrq}</td>
			    <td align="center">报废原因：</td>
			    <td align="center">${getSbxx.bfyy}</td>
			</tr>
			<tr>
			    <td align="center" style="height: 37px;">数量：</td>
			    <td align="center">${getSbxx.sl}</td>
			    <td align="center">单位：</td>
			    <td align="center">${getSbxx.dw}</td>
			</tr>
				<tr>
				<td align="center" style="height: 37px;">备注：</td>
			    <td align="left" colspan="3">${getSbxx.bz}</td>
				</tr>
			</table>
			</div>
			</c:forEach>
			</div>
		</div>
	</div>
	
</body>
</html>
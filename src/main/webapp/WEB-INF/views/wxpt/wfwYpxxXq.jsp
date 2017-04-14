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
<title>样品信息详情</title>
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
			<h1 style="color: #0D91DE"><b>样品信息详情</b></h1>
			<div class="anniu">
				<a href="<%=path%>/wxpt/WfwXgxx/wfwZy"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/zyan.png" />
				</a>
			</div>
			<div class="return">
				<a href="<%=path%>/wxpt/WfwXgxx/wfwYpxx"
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
			<c:forEach var="getypxx" items="${getypxx}" varStatus="obj">
			<div class="form-group" style="width: 100%">
			<table class="biaoge"border="2" style="width:100%;" bordercolor="#E0E0E0";>
			<tr>
			   <td align="center" style="height: 37px;">样品编号</td>
			   <td align="center">${getypxx.ypbh}</td>
			   <td align="center">样品名称</td>
			   <td align="center">${getypxx.ypmc}</td>
			</tr>
			 <tr>
			    <td align="center" style="height: 37px;">样品类型</td>
			    <td align="center">${getypxx.yplx}</td>
			    <td align="center">检验类型</td>
			    <td align="center">${getypxx.jylx}</td>
			</tr>
			<tr>
			    <td align="center" style="height: 37px;">样品类型</td>
			    <td align="center">${getypxx.yplx}</td>
			    <td align="center">所在城市</td>
			    <td align="center" >${getypxx.szcs}</td>
			</tr>
			<tr>
			    <td align="center" style="height: 37px;">规格型号</td>
			    <td align="center">${getypxx.ggxh}</td>
			    <td align="center">生产日期\批次</td>
			    <td align="center">${getypxx.scrqpc}</td>
			</tr>
			<tr>
			    <td align="center">样品等级</td>
			    <td align="center">${getypxx.ypdj}</td>
			    <td align="center" style="height: 37px;">样品状态</td>
			    <td align="center">${getypxx.ypzt}</td>
			</tr>
		    <tr>
			    <td align="center">抽样地点</td>
			    <td align="center">${getypxx.cydd}</td>
			    <td align="center">抽样日期</td>
			    <td align="center">${getypxx.cyrq}</td>
			</tr>
			<tr>
			    <td align="center">抽样基数</td>
			    <td align="center">${getypxx.cyjs}</td>
			    <td align="center">样品数量</td>
			    <td align="center">${getypxx.ypsl}</td>
			</tr>
			<tr>
			    <td align="center">委托单位地址</td>
			    <td align="center">${getypxx.wtdwdz}</td>
			    <td align="center">委托单位</td>
			    <td align="center">${getypxx.wtdw}</td>
			</tr>
			<tr>
			   <td align="center">受检单位</td>
			   <td align="center">${getypxx.sjdw}</td>
			   <td align="center">受检单位地址</td>
			   <td align="center">${getypxx.sjdwdz}</td>
			</tr>
			<tr>
			   <td align="center">联系人</td>
			   <td align="center">${getypxx.lxr}</td>
			   <td align="center">电话</td>
			   <td align="center">${getypxx.dh}</td>
			</tr>
			<tr>
			   <td align="center">邮编</td>
			   <td align="center">${getypxx.yb}</td>
			   <td align="center">生产单位</td>
			   <td align="center">${getypxx.scdw}</td>
			</tr>
			<tr>
			   <td align="center">生产单位地址</td>
			   <td align="center">${getypxx.scdwdz}</td>
			   <td align="center">生产单位联系人</td>
			   <td align="center">${getypxx.scdwlxr}</td>
			</tr>
			<tr>
			   <td align="center">生产单位电话</td>
			   <td align="center">${getypxx.scdwdh}</td>
			   <td align="center">生产单位邮编</td>
			   <td align="center">${getypxx.scdwyb}</td>
			</tr>
			<tr>
			   <td align="center">检验项目</td>
			   <td align="center">${getypxx.jyxm}</td>
			   <td align="center">检验依据</td>
			   <td align="center">${getypxx.jyyj}</td>
			</tr>
			<tr>
			   <td align="center">抽样人员</td>
			   <td align="center">${getypxx.cyry}</td>
			   <td align="center">检查封样人员</td>
			   <td align="center">${getypxx.jcfyry}</td>
			</tr>
			<tr>
			   <td align="center">检验科室</td>
			   <td align="center">${getypxx.jyks}</td>
			   <td align="center">检验科室编号</td>
			   <td align="center">${getypxx.jyksbh}</td>
			</tr>
			<tr>
			   <td align="center">业务科室</td>
			   <td align="center">${getypxx.ywks}</td>
			   <td align="center">业务科室编号</td>
			   <td align="center">${getypxx.ywksbh}</td>
			</tr>
			<tr>
			   <td align="center">检验合同号</td>
			   <td align="center">${getypxx.jyhth}</td>
			   <td align="center">检验费用</td>
			   <td align="center">${getypxx.jyfy}</td>
			</tr>
			<tr>
			   <td align="center">样品登记人员</td>
			   <td align="center">${getypxx.djry}</td>
			   <td align="center">样品登记时间</td>
			   <td align="center">${getypxx.djsj}</td>
			</tr>
			<tr>
			   <td align="center">报告编号</td>
			   <td align="center">${getypxx.bgbh}</td>
			   <td align="center">到样时间</td>
			   <td align="center">${getypxx.dyrq}</td>
			</tr>
			<tr>
			   <td align="center" style="height: 37px;">样品检测状态</td>
			   <td><input type="hidden" name="fzzt" value="${getypxx.jyzt }"/>
                                  	<c:choose>
                                  		<c:when test="${getypxx.jyzt  =='1'}"><span style="text-align:center;display:block;" >登记</span></c:when>
                                  		<c:when test="${getypxx.jyzt  =='2'}"><span style="text-align:center;display:block;" >检验中</span></c:when>
                                  	    <c:when test="${getypxx.jyzt  =='3'}"><span style="text-align:center;display:block;" >检验完</span></c:when>
                                  	    <c:when test="${getypxx.jyzt  =='4'}"><span style="text-align:center;display:block;" >编制中</span></c:when>
                                  	    <c:when test="${getypxx.jyzt  =='5'}"><span style="text-align:center;display:block;" >已发放</span></c:when>
                                  	</c:choose>
                                  </td>
			     <td align="center">到样时间</td>
			     <td align="center">${getypxx.dyrq}</td>
			</tr>
				<tr>
				<td align="center" style="height: 37px;">备注：</td>
			    <td align="left" colspan="3">${getypxx.bz}</td>
				</tr>
			</table>
			</div>
			</c:forEach>
			</div>
		</div>
	</div>
	
</body>
</html>
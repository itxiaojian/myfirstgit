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
<title>简介</title>
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
			<h1 style="color: #0D91DE"><b>简介</b></h1>
			<div class="anniu">
				<a href="<%=path%>/wxpt/ZyZjxgxx/zhuye?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> 
					<img style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/zyan.png" />
				</a>
			</div>
			<div class="return">
				<a href="<%=path%>/wxpt/ZyZjxgxx/zhuye?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/return.png" />
				</a>
			</div>
			
		</div>

		<div class="bottom">
			<div class="h">
			</div>
			
			<div>
				<p style="text-indent: 28px;">
					安徽省产品质量监督检验研究院成立于1981年，是国家质量技术监督行政部门依法设置的产品质量监督检验机构，检验业务完全独立于生产、使用、销售单位及其主管部门，属非盈利性社会公益性机构，隶属于安徽省质量技术监督局。是安徽省内检验范围最广，综合实力最强的专业化科研型公共服务检测平台。
				</p>
				<p style="text-indent: 28px;">
					国家认监委指定的“CCC”认证检测机构、国家电子信息产品污染控制自愿性认证检测机构。中国质量认证中心、中国电磁兼容认证中心、中国方圆认证中心，美国UPC、ICC、澳大利亚Water Mark、 WELS、加拿大CUPC、英国NQA、法国BV等多家国内外认证机构合作授签约实验室。检验能力覆盖建筑节能、装修材料、排灌节水、化工、消防、电工电气、轻工机械、家具、黄金珠宝等2300多种产品，是国家质检总局指定的“建筑工程材料、人造板、化妆品、电线电缆、蓄电池、水泵、复混肥、配装眼镜等产品生产许可证发证检验机构。承担产品质量监督、司法鉴定、产品认证、国内外企业公众委托等各类检验任务、检测设备的研制、产品标准的制修订，检测方法的研究以及产品质量风险监控与预警职能。
				</p>
				<p style="text-indent: 28px;">
					本院现有在岗职工200余人，其中博士4名，硕士25名，教授级工程师5名，高级工程师23名。形成以博士、高级职称人员为骨干，以硕士、中级职称人员为支撑，各类技术人员为基础的专业化人才梯队。拥有两大检测实验基地，分别位于合肥市包河工业园延安路13号、合肥市经济技术开发区天都路33号。挂靠有国家排灌及节水设备质量监督检验中心、国家建筑节能产品质量监督检验中心、国家公共安全产品质量监督检验中心（筹）。
				</p>
			</div>
			
		</div>
	</div>
</body>
</html>
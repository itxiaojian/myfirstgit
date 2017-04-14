<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>移动质检业务管理平台</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/system/login/css/padstyle.css"></link>
<link rel="apple-touch-icon" href="<%=path%>/system/login/images/padicon.png"/>
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<style>
.ZJ_mian_banner{ width:100%; height:225px; background:url(img/banner.png) center no-repeat; background-size:cover;}
.ZJ_mian_left{ position:absolute; left:-130px; top:0px; bottom:0px;width:130px; background:url(img/L_BJ02.png) center no-repeat; background-size:cover;overflow:auto; z-index:5;}
</style>
</head>
<body>
<div class="ipad">
    <div class="ZJ_top">
        <span id="L_btn"><img src="img/top_01.png"/></span>
        <span>移动质检业务管理平台</span>
        <span><a onclick="exit();"><img src="img/top_03.png"/></a></span>
        <span><img src="img/top_02.png"/>欢迎您：${sessionScope['LOGIN_USER'].xm}&nbsp;&nbsp;</span>
    </div>
    <div class="ZJ_mian">
        <div class="ZJ_mian_left" id="left_nav">
        	<ul>
            	<a href="<%=path%>/system/layout/main1.jsp"><li><img src="img/L_01.png"/>&nbsp;&nbsp;平台首页</li></a>
                <a href="<%=path%>/ZjPad/CydjPage"><li><img src="img/L_02.png"/>&nbsp;&nbsp;抽样登记</li></a>
                <a href="<%=path%>/ZjPad/ZxxxList"><li><img src="img/L_03.png"/>&nbsp;&nbsp;检验咨询</li></a>
                <a href="<%=path%>/ZjPad/ypcxPage"><li><img src="img/L_04.png"/>&nbsp;&nbsp;样品查询</li></a>
                <a href="<%=path%>/ZjPad/bgcxPage"><li><img src="img/L_05.png"/>&nbsp;&nbsp;报告查询</li></a>
                <a href="<%=path%>/ZjPad/bgshlist?ypcs=2"><li><img src="img/L_06.png"/>&nbsp;&nbsp;报告审核</li></a>
                <a href="<%=path%>/ZjPad/bgshlist?ypcs=3"><li><img src="img/L_07.png"/>&nbsp;&nbsp;报告批准</li></a>
                <a href="<%=path%>/ZjPad/warnPage"><li><img src="img/L_08.png"/>&nbsp;&nbsp;报告预警</li></a>
                <a href="<%=path%>/ZjPad/sbcxPage"><li><img src="img/L_11.png"/>&nbsp;&nbsp;设备查询</li></a>
                <a href="<%=path%>/ZjPad/tjtbPage"><li><img src="img/L_12.png"/>&nbsp;&nbsp;统计图表</li></a>
                <a href="<%=path%>/ZjPad/tjbbPage"><li><img src="img/L_12.png"/>&nbsp;&nbsp;统计报表</li></a>
            </ul>
        </div>
        <div class="ZJ_mian_right" id="main_R" style=" height: 100%;">
        	<div class="ZJ_mian_banner">&nbsp;</div>
            <div class="ZJ_mian_right_icon">
            	<span><img src="img/b_01.png"/><br/>质量监督检验</span>
                <span><img src="img/b_02.png"/><br/>质量仲裁检验</span>
                <span><img src="img/b_03.png"/><br/>质量鉴定检验</span>
                <span><img src="img/b_04.png"/><br/>委托的产（商）品检验</span>
            </div>
            <div class="ZJ_mian_right_title">&nbsp;&nbsp;公司简介</div>
            <div class="ZJ_mian_right_msg">
            	安徽省产品质量监督检验研究院成立于1981年，是国家质量技术监督行政部门依法设置的产品质量监督检验机构，检验业务完全独立于生产、使用、销售单位及其主管部门，属非盈利性社会公益性机构，隶属于安徽省质量技术监督局。是安徽省内检验范围最广，综合实力最强的专业化科研型公共服务检测平台。
本院现有在岗职工200余人，其中博士4名，硕士25名，教授级工程师5名，高级工程师23名。形成以博士、高级职称人员为骨干，以硕士、中级职称人员为支撑，各类技术人员为基础的专业化人才梯队。拥有两大检测实验基地，分别位于合肥市包河工业园延安路13号、合肥市经济技术开发区天都路33号。挂靠有国家排灌及节水设备质量监督检验中心、国家建筑节能产品质量监督检验中心、国家公共安全产品质量监督检验中心（筹）。实验室面积20426m2，技术装备4000余台（套），固定资产过亿元。被国家质检总局评为“全国产品质量监督工作先进单位”、“科技兴检先进集体”，被共青团中央授予“全国青年文明号”荣誉称号，被中共安徽省直属机关工作委员会评为“省直文明单位”，被中共安徽省纪委、安徽省监察厅确定为“廉政文化建设示范点”，2012年被评为“安徽名牌”。
		   </div>
        </div>
    </div>
   	<div class="foot">安徽省产品质量监督检查研究院  皖ICP备08001861号-1  地址：合肥市包河工业园延安路13号  邮政编码：230051  电话：0551-63356268  63855622</div>
</div>
<script>
	$("#L_btn").click(function(){
		$("#left_nav").animate({marginLeft:130},1000)
	})
	$("#main_R").click(function(){
		$("#left_nav").animate({marginLeft:0},1000)
	})
	
	 function exit(){
// 		success: function () {
	       msg="确定退出？";
       		if(confirm(msg)){
       			location.href="<%=path%>/j_spring_security_logout"
   			}
// 		}
	}
	
	function toRight(url){
		top.content.location=url;
	}
</script>
</body>
</html>

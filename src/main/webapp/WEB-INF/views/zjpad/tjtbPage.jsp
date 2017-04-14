<%@page contentType="text/html" import="java.util.* ,java.util.Date" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<%  String path = request.getContextPath();
Date date = new Date();
SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-dd");
String enddate = edate.format(date);
%>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="" />
    <meta name="author" content="Mosaddek" />
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina" />
    <link rel="shortcut icon" href="<%=path%>/resources/index/img/favicon.png" />

     <title>移动质检业务平台</title>

    <link rel="stylesheet" type="text/css" href="<%=path%>/system/login/css/padstyle.css" />
    <script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
  <style>
		.btn3 {
		    -moz-user-select: none;
		    background-image: none;
		    border: 1px solid transparent;
		    border-radius: 4px;
		    cursor: pointer;
		    display: inline-block;
		    font-size: 12px;
		    font-weight: normal;
		    height: 24px;
		    line-height: 1.42857;
		    margin-bottom: 0;
		    padding: 0;
		    text-align: center;
		    vertical-align: middle;
		    white-space: nowrap;
		    width: 124% !important;
		    background-color: #f1c500;
		    border-color: #f1c500;
		    color: #ffffff;
		}
		.kobe {
            color: #188cde;
            }
		.ZJ_mian_banner{ width:100%; height:240px; background:url(/zjyw/system/layout/img/banner.png) center no-repeat; background-size:cover;}
		.ZJ_mian_left{ position:absolute; left:-130px; top:0px; bottom:0px;width:130px; background:url(/zjyw/system/layout/img/L_BJ02.png) center no-repeat; background-size:cover;overflow:auto; z-index:5;}
  </style>
    
  </head>

  <body>
  <div class="ipad">
    <div class="ZJ_top">
        <span id="L_btn"><img src="<%=path%>/system/layout/img/top_01.png"/></span>
        <span>移动质检业务管理平台</span>
        <span><a onclick="exit();"><img src="<%=path%>/system/layout/img/top_03.png"/></a></span>
        <span><img src="<%=path%>/system/layout/img/top_02.png"/>欢迎您：${sessionScope['LOGIN_USER'].xm}&nbsp;&nbsp;</span>
    </div>
    <div class="ZJ_mian">
        <div class="ZJ_mian_left" id="left_nav">
        	<ul>
            	<a href="<%=path%>/system/layout/main1.jsp"><li><img src="<%=path%>/system/layout/img/L_01.png"/>&nbsp;&nbsp;平台首页</li></a>
                <a href="<%=path%>/ZjPad/CydjPage"><li><img src="<%=path%>/system/layout/img/L_02.png"/>&nbsp;&nbsp;抽样登记</li></a>
                <a href="<%=path%>/ZjPad/ZxxxList"><li><img src="<%=path%>/system/layout/img/L_03.png"/>&nbsp;&nbsp;检验咨询</li></a>
                <a href="<%=path%>/ZjPad/ypcxPage"><li><img src="<%=path%>/system/layout/img/L_04.png"/>&nbsp;&nbsp;样品查询</li></a>
                <a href="<%=path%>/ZjPad/bgcxPage"><li><img src="<%=path%>/system/layout/img/L_05.png"/>&nbsp;&nbsp;报告查询</li></a>
                <a href="<%=path%>/ZjPad/bgshlist?ypcs=2"><li><img src="<%=path%>/system/layout/img/L_06.png"/>&nbsp;&nbsp;报告审核</li></a>
                <a href="<%=path%>/ZjPad/bgshlist?ypcs=3"><li><img src="<%=path%>/system/layout/img/L_07.png"/>&nbsp;&nbsp;报告批准</li></a>
                <a href="<%=path%>/ZjPad/warnPage"><li><img src="<%=path%>/system/layout/img/L_08.png"/>&nbsp;&nbsp;报告预警</li></a>
<%--                 <a href="<%=path%>/ypgl/YYpYj/ypyjPage;"><li><img src="<%=path%>/system/layout/img/L_09.png">&nbsp;&nbsp;样品移交</li></a> --%>
                <a href="<%=path%>/ZjPad/sbcxPage"><li><img src="<%=path%>/system/layout/img/L_11.png"/>&nbsp;&nbsp;设备查询</li></a>
                <a href="<%=path%>/ZjPad/tjtbPage"><li><img src="<%=path%>/system/layout/img/L_12.png"/>&nbsp;&nbsp;统计图表</li></a>
            </ul>
        </div>
        <div class="ZJ_mian_right" id="main_R">
      <div class="ZJ_mian_banner">&nbsp;</div>
            <div class="ZJ_mian_right_icon">
            	<span style=" margin-top:100px"><a class="kobe" href="<%=path%>/ZjPad/tjPage?cs=5"><img src="<%=path%>/system/layout/img/tj_01.png"/><br/>科室收入统计</a></span>
                <span style=" margin-top:100px"><a class="kobe" href="<%=path%>/ZjPad/tjPage?cs=2"><img src="<%=path%>/system/layout/img/tj_02.png"/><br/>成本汇总统计</a></span>
                <span style=" margin-top:100px"><a class="kobe" href="<%=path%>/ZjPad/tjPage?cs=3"><img src="<%=path%>/system/layout/img/tj_03.png"/><br/>工资薪金统计</a></span>
                <span style=" margin-top:100px"><a class="kobe" href="<%=path%>/ZjPad/tjPage?cs=6"><img src="<%=path%>/system/layout/img/tj_04.png"/><br/>绩效考核统计</a></span>
<%--                 <span style=" margin-top:50px"><a class="kobe" href="<%=path%>/ZjPad/tjPage?cs=5"><img src="<%=path%>/system/layout/img/tj_05.png"/><br/>科室收入统计</a></span> --%>
<%--                 <span style=" margin-top:50px"><a class="kobe" href="<%=path%>/ZjPad/tjPage?cs=6"><img src="<%=path%>/system/layout/img/tj_06.png"/><br/>绩效考核统计</a></span> --%>
<%--                 <span style=" margin-top:50px"><a class="kobe" href="<%=path%>/ZjPad/tjPage?cs=7"><img src="<%=path%>/system/layout/img/tj_07.png"/><br/>检验报告统计</a></span> --%>
<%--                 <span style=" margin-top:50px"><a class="kobe" href="<%=path%>/ZjPad/tjPage?cs=8"><img src="<%=path%>/system/layout/img/tj_08.png"/><br/>工作量统计</a></span> --%>
            </div>
        </div>
    </div>
   	<div class="foot">安徽省产品质量监督检查研究院  皖ICP备08001861号-1  地址：合肥市包河工业园延安路13号  邮政编码：230051  电话：0551-63356268  63855622</div>
</div>
	<script type="text/javascript">
		function exit(){
		       msg="确定退出？";
		   		if(confirm(msg)){
		   			location.href="<%=path%>/j_spring_security_logout"
					}
		}

			$("#L_btn").click(function(){
				$("#left_nav").animate({marginLeft:130},1000)
			})
			$("#main_R").click(function(){
				$("#left_nav").animate({marginLeft:0},1000)
			})
	</script>
	
  </body>
</html>

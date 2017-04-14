<%@page contentType="text/html" import="java.util.* ,java.util.Date" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<% 
 String path = request.getContextPath();
 Date date = new Date();
 SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 String enddate = edate.format(date);
// 	List<Map<String,Object>> list=(List)request.getAttribute("zdmc");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>移动质检业务平台</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/resources/bootstrap/js/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path%>/resources/bootstrap/js/bootstrap-reset.css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="<%=path%>/system/login/css/padstyle.css" />
    <!--external css-->
    <link href="<%=path%>/resources/bootstrap/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="<%=path%>/resources/index/css/owl.carousel.css" type="text/css" />
<!--     <link rel="stylesheet" href="css/owl.carousel.css" type="text/css"> -->
    <!-- Custom styles for this template -->
    <link href="<%=path%>/resources/bootstrap/style.css" rel="stylesheet">
    <link href="<%=path%>/resources/bootstrap/css/style-responsive.css" rel="stylesheet" />
	<style>
		.wrapper1 {
			display: inline-block;
			padding: 15px;
			width: 100%;
		}
		select[multiple], select[size] {
		    height: 20%;
		}
		.form-control1 {
		    background-color: #fff;
		    background-image: none;
		    font-size: 14px;
		    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
		    vertical-align: middle;
		    border: 1px solid #e2e2e4;
    		box-shadow: none;
    		color: #000000;
		}
		.input-lg1 {
		    border-radius: 6px;
		}
		.Div5{
			float:left;
		}
		.btn {
			padding: 6px;
		    width: 20% !important;
		}
		.btn1 {
		    -moz-user-select: none;
		    background-image: none;
		    border: 1px solid transparent;
		    border-radius: 4px;
		    cursor: pointer;
		    display: inline-block;
		    font-size: 14px;
		    font-weight: normal;
		    line-height: 1.42857;
		    margin-bottom: 0;
		    padding: 0;
		    text-align: center;
		    vertical-align: middle;
		    white-space: nowrap;
		    width: 88% !important;
		    height:29px;
		}
		.btn2 {
			padding: 6px;
		    width: 15% !important;
		    padding-bottom: 2px; 
		    padding-top: 3px;
		}
		.gradeY {
		    color: red;
		    font-family: "Open Sans",sans-serif;
		    font-size: 13px;
		}
		.gradeZ {
		    color: #EDB840;
		    font-family: "Open Sans",sans-serif;
		    font-size: 13px;
		}
		.gradeX {
		    color: green;
		    font-family: "Open Sans",sans-serif;
		    font-size: 13px;
		}
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
		    width: 100% !important;
		    background-color: #f1c500;
		    border-color: #f1c500;
		    color: #ffffff;
		}
		.btnkobe {
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
		    width: 100% !important;
		    background-color: #78CD51;
		    border-color: #78CD51;
		    color: #ffffff;
		}
		
		a {
    		color: green;
		}
		.ZJ_mian_banner{ width:100%; height:240px; background:url(/zjyw/system/layout/img/banner.png) center no-repeat; background-size:cover;}
		.ZJ_mian_left{ position:absolute; left:-130px; top:0px; bottom:0px;width:130px; background:url(/zjyw/system/layout/img/L_BJ02.png) center no-repeat; background-size:cover;overflow:auto; z-index:5;}
	</style>
  </head>

  <body class="contentStyle" onload="" >
  <div class="ipad">
    <div class="ZJ_top">
        <span id="L_btn"><img src="<%=path%>/system/layout/img/top_01.png"></span>
        <span>移动质检业务管理平台</span>
        <span><a onclick="exit();"><img src="<%=path%>/system/layout/img/top_03.png"></a></span>
        <span><img src="<%=path%>/system/layout/img/top_02.png">欢迎您：${sessionScope['LOGIN_USER'].xm}&nbsp;&nbsp;</span>
    </div>
    <div class="ZJ_mian" style="background-color: #fff">
        <div class="ZJ_mian_left" id="left_nav">
        	<ul>
            	<a href="<%=path%>/system/layout/main1.jsp"><li><img src="<%=path%>/system/layout/img/L_01.png">&nbsp;&nbsp;平台首页</li></a>
                <a href="<%=path%>/ZjPad/CydjPage"><li><img src="<%=path%>/system/layout/img/L_02.png">&nbsp;&nbsp;抽样登记</li></a>
                <a href="<%=path%>/ZjPad/ZxxxList"><li><img src="<%=path%>/system/layout/img/L_03.png">&nbsp;&nbsp;检验咨询</li></a>
                <a href="<%=path%>/ZjPad/ypcxPage"><li><img src="<%=path%>/system/layout/img/L_04.png">&nbsp;&nbsp;样品查询</li></a>
                <a href="<%=path%>/ZjPad/bgcxPage"><li><img src="<%=path%>/system/layout/img/L_05.png">&nbsp;&nbsp;报告查询</li></a>
                <a href="<%=path%>/ZjPad/bgshlist?ypcs=2"><li><img src="<%=path%>/system/layout/img/L_06.png">&nbsp;&nbsp;报告审核</li></a>
                <a href="<%=path%>/ZjPad/bgshlist?ypcs=3"><li><img src="<%=path%>/system/layout/img/L_07.png">&nbsp;&nbsp;报告批准</li></a>
                <a href="<%=path%>/ZjPad/warnPage"><li><img src="<%=path%>/system/layout/img/L_08.png">&nbsp;&nbsp;报告预警</li></a>
<%--                 <a href="<%=path%>/ypgl/YYpYj/ypyjPage;"><li><img src="<%=path%>/system/layout/img/L_09.png">&nbsp;&nbsp;样品移交</li></a> --%>
                <a href="<%=path%>/ZjPad/sbcxPage"><li><img src="<%=path%>/system/layout/img/L_11.png">&nbsp;&nbsp;设备查询</li></a>
                <a href="<%=path%>/ZjPad/tjtbPage"><li><img src="<%=path%>/system/layout/img/L_12.png">&nbsp;&nbsp;统计图表</li></a>
                <a href="<%=path%>/ZjPad/tjbbPage"><li><img src="<%=path%>/system/layout/img/L_12.png"/>&nbsp;&nbsp;统计报表</li></a>
            </ul>
        </div>
        <div class="ZJ_mian_right" id="main_R">
            <div class="panel-body" style="padding: 75px 0px 0px;">
               <div class="tab-content tasi-tab">
                   <div id="Div6" style="overflow:auto;height:520px;"> 
                     <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered table-hover personal-task table-striped" id="table">
                      <thead>
                         <tr>
                         </tr>
                      </thead>
                      <tbody>
                       </tbody>
                     </table> 
                     </div>
            <div id="Div4">
			<div id="table_length" class="dataTables_length" style="float:left;margin-top: 6px; padding-right: 0px; padding-top: 0px; padding-bottom: 0px;">
				<div>
					<label style="float: left;">
						每页显示</label>
					<select class="form-control" name="size1" size="1" aria-controls="table" id="size" onchange="window.onload();" style="float: left;padding: 0px;width: 50px;">
						<option value="10" selected="selected">10</option>
						<option value="20">20</option>
						<option value="50">50</option>
						<option value="100">100</option>
					</select>
					<label style="float: left;">条</label>
				</div>
			</div>
			<div id="Div5">
				<div style="float:left;margin-top: 6px;">显示第 0 到 0条 共0条</div>
				<div id="table_paginate" class="dataTables_paginate paging_two_button" style="float:left;margin-top: 6px; padding-top: 0px; padding-bottom: 0px;">
					<a href="javascript:;" onclick="" class="paginate_disabled_previous">上一页</a>
					<a href="javascript:;" onclick="" class="paginate_enabled_next" style="color:green">下一页</a>
				</div>
			</div>
		</div>
        </div>
    </div>
    </div>
    </div>
    <div class="foot">安徽省产品质量监督检查研究院  皖ICP备08001861号-1  地址：合肥市包河工业园延安路13号  邮政编码：230051  电话：0551-63356268  63855622</div>
    </div>
    <!--<script src="js/jquery.js"></script>-->
    <script type="text/javascript" language="javascript" src="<%=path %>/resources/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/resources/bootstrap/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="<%=path %>/resources/bootstrap/js/multiselect.js"></script>
    <script src="<%=path %>/resources/bootstrap/js/multiselect.min.js"></script>
    <script src="<%=path %>/resources/bootstrap/js/prettify.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jyzxxx/cplxPage1.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/index/js/editable-table.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
  	<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
	<script type="text/javascript"> 
				//查看样品信息
		function toView(cplx){
 			location.href="cpmcView?cplx="+cplx;
		}
				
		//返回
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


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

    <title>移动质检业务管理平台</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/resources/bootstrap/js/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path%>/resources/bootstrap/js/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="<%=path%>/resources/bootstrap/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="<%=path%>/resources/index/css/owl.carousel.css" type="text/css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/system/login/css/padstyle.css">		
    <!-- Custom styles for this template -->
    <link href="<%=path%>/resources/bootstrap/style.css" rel="stylesheet">
    <link href="<%=path%>/resources/bootstrap/css/style-responsive.css" rel="stylesheet" />
	<style>
	.ZJ_mian_left{ position:absolute; left:-130px; top:0px; bottom:0px;width:130px; background:url(/zjyw/system/layout/img/L_BJ02.png) center no-repeat; background-size:cover;overflow:auto; z-index:5;}
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
		.tab-bg-dark-navy-blue {
            background: #188cde none repeat scroll 0 0;
		    border-bottom: medium none;
		    border-radius: 5px 5px 0 0;
		}
	</style>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body onload="" >
  <div class="ZJ_top">
        <span id="L_btn"><img src="<%=path%>/system/layout/img/top_01.png"></span>
        <span>移动质检业务管理平台</span>
        <span><a onclick="exit();"><img src="<%=path%>/system/layout/img/top_03.png"></a></span>
        <span><img src="<%=path%>/system/layout/img/top_02.png">欢迎您：${sessionScope['LOGIN_USER'].xm}&nbsp;&nbsp;</span>
    </div>
    <div class="ZJ_mian" style="height: 94%;">
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
  <section id="container" >
      <!--main content start-->
      <section id="main-content1">
          <section class="wrapper1" style="padding: 0px;">
              <!-- page start-->
              <section class="panel" style="margin-bottom: 0px;">
<%--                    <c:if test="${kobe == 24 }"> --%>
<%--                    <header class="panel-heading"><a href="<%=path%>/tjgl/bgcx/warnPage?kobe=24" target="content" onfocus="this.blur()"><span>报告预警</span></a></header> --%>
<!-- 					<div style="text-align: center"> -->
<!-- 						<div class="panel-body" style="width: 134px;"> -->
<!-- 							<button type="button" class="btnkobe" onClick="exit();">返回</button> -->
<!-- 						</div> -->
<!-- 					</div> -->
<%-- 				    </c:if> --%>
				  <div style="padding: 15px;">
						<div class="row" style="width:50%;float:left;padding-left: 15px;">
						<input type="hidden" id="dqsj" value="<%=enddate%>">
						</div>
				  </div>
				  <header class="panel-heading tab-bg-dark-navy-blue"style="width:227px;padding: 0px;" >
                    <ul class="nav nav-tabs nav-justified " style="margin-left: 0px; margin-right: 0px;">
                        <li class="active" >
                            <a href="#popular" data-toggle="tab" >
                              	  	未完成报告
                            </a>
                        </li>
                        <li>
                            <a href="#comments" data-toggle="tab" >
                                	已完成报告
                            </a>
                        </li>
                    </ul>
                 </header>
                 <div class="panel-body" style="padding-left: 0px; padding-right: 0px; padding-bottom: 0px;">
                    <div class="tab-content tasi-tab">
                        <div class="tab-pane active" id="popular"> 
                        <div id="Div6" style="overflow:auto;height:512px;"> 
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
											<option value="25">25</option>
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
										<a href="javascript:;" onclick="" class="paginate_enabled_next">下一页</a>
									</div>
								</div>
							</div>
                          </div>
                          
                        <div class="tab-pane" id="comments">
                           <div id="Div9" style="overflow:auto;height:512px"> 
                          <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered table-hover personal-task table-striped" id="table1">
                           <thead>
                              <tr>
                              </tr>
                           </thead>
                           <tbody>
                            </tbody>
                          </table>
                          </div> 
                          <div id="Div7">
								<div id="table_length1" class="dataTables_length" style="float:left;margin-top: 6px; padding-right: 0px; padding-top: 0px; padding-bottom: 0px;">
									<label style="float: left;">
										每页显示</label>
										<select class="form-control" name="size1" size="1" aria-controls="table" id="size1" onchange="window.onload();" style="float: left;padding: 0px;width: 50px;">
											<option value="10" selected="selected">10</option>
											<option value="25">25</option>
											<option value="50">50</option>
											<option value="100">100</option>
										</select>

									<label style="float: left;">条</label>
								</div>
								<div id="Div8" >
									<div >显示第 0 到 0条 共0条</div>
									<div id="table_paginate1" class="dataTables_paginate paging_two_button" style="float:left;margin-top: 6px;padding: 0px;">
										<a href="javascript:;" onclick="" class="paginate_disabled_previous">上一页</a>
										<a href="javascript:;" onclick="" class="paginate_enabled_next">下一页</a>
									</div>
								</div>
							</div>
                          </div>
                        </div>
                        </div>
              </section>
              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
  </section>
  <div class="foot">安徽省产品质量监督检查研究院  皖ICP备08001861号-1  地址：合肥市包河工业园延安路13号  邮政编码：230051  电话：0551-63356268  63855622</div>
</div>
</div>
    <!-- js placed at the end of the document so the pages load faster -->
    <!--<script src="js/jquery.js"></script>-->
    <script type="text/javascript" language="javascript" src="<%=path %>/resources/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/resources/bootstrap/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="<%=path %>/resources/bootstrap/js/multiselect.js"></script>
    <script src="<%=path %>/resources/bootstrap/js/multiselect.min.js"></script>
    <script src="<%=path %>/resources/bootstrap/js/prettify.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/tjgl/bgyj.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/index/js/editable-table.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
  	<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
	<script type="text/javascript"> 
				//查看样品信息
		function toView(id,djlx,ypbh){
<%-- 			location.href="<%=path%>/ypgl/YYpYpxx/ypxxOnLookView?id="+id+"&djlx="+djlx+"&ypbh="+ypbh; --%>
			window.open('<%=path%>/ypgl/YYpYpxx/ypxxOnLookView?id='+id+'&djlx='+djlx+'&ypbh='+ypbh+'&kobe='+8,"查看样品信息","height=600px, width=1000px,top=100px, left=200px, toolbar=no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no");
		}
				
		//返回
		function exit(){
// 		success: function () {
	       msg="确定退出？";
       		if(confirm(msg)){
       			location.href="<%=path%>/j_spring_security_logout"
   			}
// 		}
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
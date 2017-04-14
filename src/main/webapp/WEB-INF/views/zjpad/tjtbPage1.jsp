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

    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/resources/index/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=path%>/resources/index/css/bootstrap-reset.css" rel="stylesheet" />
    <!--external css-->
    <link href="<%=path%>/resources/index/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="<%=path%>/resources/index/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="<%=path%>/resources/index/css/owl.carousel.css" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/system/login/css/padstyle.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/system/login/css/padstyle1.css" />
    <!-- Custom styles for this template -->
    <link href="<%=path%>/resources/index/css/style.css" rel="stylesheet" />
    <link href="<%=path%>/resources/index/css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
  <style>
        .ZJ_mian_banner{ width:100%; height:240px; background:url(/zjyw/system/layout/img/banner.png) center no-repeat; background-size:cover;}
		.ZJ_mian_left{ position:absolute; left:-130px; top:0px; bottom:0px;width:130px; background:url(/zjyw/system/layout/img/L_BJ02.png) center no-repeat; background-size:cover;overflow:auto; z-index:5;}
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
                <a href="<%=path%>/ZjPad/tjbbPage"><li><img src="<%=path%>/system/layout/img/L_12.png"/>&nbsp;&nbsp;统计报表</li></a>
            </ul>
        </div>
        <div class="ZJ_mian_right" id="main_R">
      <!--main content start-->
              <div class="row">
              <div class="col-lg-5 charts--container">
						  <ul>
						    <li class="chart">
						      <div class="border-head">
		                          <h3 style="color:#CD950C;"><b>月度报表费用统计(万元)</b></h3>
		                      </div>
						      <div id="lineChart">
						        <svg id="lineChartSVG" class="lineChart--svg">
						          <defs>
						            <linearGradient id="lineChart--gradientBackgroundArea" x1="0" x2="0" y1="0" y2="1">
						              <stop class="lineChart--gradientBackgroundArea--top" offset="0%" />
						              <stop class="lineChart--gradientBackgroundArea--bottom" offset="100%" />
						            </linearGradient>
						          </defs>
						        </svg>
						      </div>
						    </li>
						  </ul>
                  </div>
                  <div class="col-lg-5 charts--container" style="width: 100%;">
                  <ul>
					<li class="chart">
                      <div class="border-head">
                          <h3 style="color:#CD950C;"><b>当月检验登记任务排名</b></h3>
                      </div>
                      <div class="custom-bar-chart">
                          <ul class="y-axis">
                              <li><span>1000</span></li>
                              <li><span>800</span></li>
                              <li><span>600</span></li>
                              <li><span>400</span></li>
                              <li><span>200</span></li>
                              <li><span>0</span></li>
                          </ul>
                              <div class="bar" style="left: 2%;width: 45px;">
	                              <div class="title" style="width: 128%;left: -5px;">徐琳琳</div>
	                              <div class="value tooltips" data-original-title="335" data-toggle="tooltip" data-placement="top" style="background-color:#EE9A00;">33.5%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;width: 45px;">
	                              <div class="title" style="width: 128%;left: -5px;">唐沁雨</div>
	                              <div class="value tooltips" data-original-title="286" data-toggle="tooltip" data-placement="top" style="background-color:#EE9A00;">28.6%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;width: 45px;">
	                              <div class="title" style="width: 128%;left: -5px;">田军</div>
	                              <div class="value tooltips" data-original-title="312" data-toggle="tooltip" data-placement="top" style="background-color:#EE9A00;">31.2%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;width: 45px;">
	                              <div class="title" style="width: 128%;left: -5px;">徐速</div>
	                              <div class="value tooltips" data-original-title="277" data-toggle="tooltip" data-placement="top" style="background-color:#EE9A00;">27.7%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;width: 45px;">
	                              <div class="title" style="width: 128%;left: -5px;">王俊海</div>
	                              <div class="value tooltips" data-original-title="256" data-toggle="tooltip" data-placement="top" style="background-color:#EE9A00;">25.6%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;width: 45px;">
	                              <div class="title" style="width: 128%;left: -5px;">李阳</div>
	                              <div class="value tooltips" data-original-title="289" data-toggle="tooltip" data-placement="top" style="background-color:#EE9A00;">28.9%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;width: 45px;">
	                              <div class="title" style="width: 128%;left: -5px;">李耀</div>
	                              <div class="value tooltips" data-original-title="308" data-toggle="tooltip" data-placement="top" style="background-color:#EE9A00;">30.8%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;width: 45px;">
	                              <div class="title" style="width: 128%;left: -5px;">张文明</div>
	                              <div class="value tooltips" data-original-title="296" data-toggle="tooltip" data-placement="top" style="background-color:#EE9A00;">29.6%</div>
	                          </div>
<%--                           <c:forEach var="data" items="${ywkssf}" varStatus="obj"> --%>
<!-- 	                          <div class="bar" style="left: 2%;"> -->
<%-- 	                              <div class="title" style="width: 128%;left: -5px;">${data.djry}</div> --%>
<%-- 	                              <div class="value tooltips" data-original-title="${data.ywl}" data-toggle="tooltip" data-placement="top" style="background-color:#EE9A00;">${data.bfb }%</div> --%>
<!-- 	                          </div> -->
<%--                           </c:forEach> --%>
                      </div>
                       </li>
						  </ul>
                  </div>
                  
				  
              </div>
			    <div class="row">
				  <div class="col-lg-5 charts--container">
				  <ul>
					<li class="chart">
                              <div class="border-head">
		                          <h3 style="color:#CD5555;"><b>当月检验费用占比</b></h3>
		                      </div>
                              <div class="panel-body">
                                  <div id="hero-donut" class="graph"></div>
                              </div>
                              </li></ul>
                  </div>
				  
				  
                  <div class="col-lg-5 charts--container" style="height: 433px;">
                  <ul>
					<li class="chart">
                      <div class="border-head">
                          <h3 style="color:#CD5555;"><b>月度报告数统计</b></h3>
                      </div>
                      <div class="custom-bar-chart">
                          <ul class="y-axis">
                              <li><span>5000</span></li>
                              <li><span>4000</span></li>
                              <li><span>3000</span></li>
                              <li><span>2000</span></li>
                              <li><span>1000</span></li>
                              <li><span>0</span></li>
                          </ul>
                           <div class="bar" style="left: 2%;">
	                              <div class="title">7月</div>
	                              <div class="value tooltips" data-original-title="3179" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">63.58%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;">
	                              <div class="title">8月</div>
	                              <div class="value tooltips" data-original-title="2987" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">59.74%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;">
	                              <div class="title">9月</div>
	                              <div class="value tooltips" data-original-title="3254" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">60.08%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;">
	                              <div class="title">10月</div>
	                              <div class="value tooltips" data-original-title="2976" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">59.52%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;">
	                              <div class="title">11月</div>
	                              <div class="value tooltips" data-original-title="2269" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">45.38%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;">
	                              <div class="title">12月</div>
	                              <div class="value tooltips" data-original-title="2074" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">41.48%</div>
	                          </div>
                              <div class="bar" style="left: 2%;">
	                              <div class="title">16年1月</div>
	                              <div class="value tooltips" data-original-title="2369" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">47.38%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;">
	                              <div class="title">2月</div>
	                              <div class="value tooltips" data-original-title="2245" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">44.9%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;">
	                              <div class="title">3月</div>
	                              <div class="value tooltips" data-original-title="2679" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">53.58%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;">
	                              <div class="title">4月</div>
	                              <div class="value tooltips" data-original-title="3049" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">60.98%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;">
	                              <div class="title">5月</div>
	                              <div class="value tooltips" data-original-title="3145" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">62.9%</div>
	                          </div>
	                          <div class="bar" style="left: 2%;">
	                              <div class="title">6月</div>
	                              <div class="value tooltips" data-original-title="3366" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">67.32%</div>
	                          </div>
<%--                           <c:forEach var="data" items="${aybgsf}" varStatus="obj"> --%>
<!-- 	                          <div class="bar"> -->
<%-- 	                              <div class="title">${data.yf}月</div> --%>
<%-- 	                              <div class="value tooltips" data-original-title="${data.je}" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">${data.bfb}%</div> --%>
<!-- 	                          </div> -->
<%--                           </c:forEach> --%>
                      </div>
                      </li></ul>
                  </div>
                          
              </div>
              </div>
              </div>
              <div class="foot">安徽省产品质量监督检查研究院  皖ICP备08001861号-1  地址：合肥市包河工业园延安路13号  邮政编码：230051  电话：0551-63356268  63855622</div>
              </div>	 
             
            
  
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="<%=path%>/resources/index/js/jquery.js"></script>
    <script src="<%=path%>/resources/index/js/jquery-1.8.3.min.js"></script>
    <script src="<%=path%>/resources/index/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="<%=path%>/resources/index/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="<%=path%>/resources/index/js/jquery.scrollTo.min.js"></script>
    <script src="<%=path%>/resources/index/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="<%=path%>/resources/index/js/jquery.sparkline.js" type="text/javascript"></script>
    <script src="<%=path%>/resources/index/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
    <script src="<%=path%>/resources/index/js/owl.carousel.js" ></script>
    <script src="<%=path%>/resources/index/js/jquery.customSelect.min.js" ></script>
    <script src="<%=path%>/resources/index/js/respond.min.js" ></script>

    <script class="include" type="text/javascript" src="<%=path%>/resources/index/js/jquery.dcjqaccordion.2.7.js"></script>

    <!--common script for all pages-->
    <script src="<%=path%>/resources/index/js/common-scripts.js"></script>
    <script src="<%=path%>/system/login/js/d3.v3.min.js"></script>
    <script src="<%=path%>/system/login/js/index.js"></script>
    
	<script type="text/javascript">
		var str=${ywksbt};
	</script>
	
    <!--script for this page-->
    <script src="<%=path%>/resources/index/js/sparkline-chart.js"></script>
    <script src="<%=path%>/resources/index/js/easy-pie-chart.js"></script>
     <script src="<%=path %>/resources/bootstrap/js/bootstrap.min.js"></script>
<%--     <script type="text/javascript" src="<%=path%>/resources/js/sys/indexbgyj.js"></script> --%>
    <script src="<%=path%>/resources/index/js/morris-script1.js"></script>
    <script src="<%=path%>/resources/index/assets/morris.js-0.4.3/morris.min.js" type="text/javascript"></script>
    <script src="<%=path%>/resources/index/assets/morris.js-0.4.3/raphael-min.js" type="text/javascript"></script>
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
  
  <script>

      //owl carousel

      $(document).ready(function() {
          $("#owl-demo").owlCarousel({
              navigation : true,
              slideSpeed : 300,
              paginationSpeed : 400,
              singleItem : true,
			  autoPlay:true

          });
      });

      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>

  </body>
</html>

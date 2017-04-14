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

    <title>安徽省质检院综合业务管理平台</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/resources/index/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=path%>/resources/index/css/bootstrap-reset.css" rel="stylesheet" />
    <!--external css-->
    <link href="<%=path%>/resources/index/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="<%=path%>/resources/index/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="<%=path%>/resources/index/css/owl.carousel.css" type="text/css" />
    <!-- Custom styles for this template -->
    <link href="<%=path%>/resources/index/css/style.css" rel="stylesheet" />
    <link href="<%=path%>/resources/index/css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
  <style>
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
		    width: 124% !important;
		    background-color: #f1c500;
		    border-color: #f1c500;
		    color: #ffffff;
		}
  </style>
    
  </head>

  <body>
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <!--state overview start-->
              <div class="row state-overview">
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol blue">
                              <i class="icon-bar-chart"></i>
                          </div>
                          <div class="value">
                              <h1 class=" count4">
                                  0
                              </h1>
                              <p style="color:#191970;">年度总收费(万元)</p>
                          </div>
                      </section>
                  </div>
				  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol yellow">
                              <i class="icon-shopping-cart"></i>
                          </div>
                          <div class="value">
                              <h1 class=" count3">
                                  0
                              </h1>
                              <p style="color:#191970;">报告收费(万元)</p>
                        </div>
                      </section>
                  </div>
				  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol terques">
                              <i class="icon-user"></i>
                          </div>
                          <div class="value">
                              <h1 class="count">
                                  0
                              </h1>
                              <p style="color:#191970;">报告总数</p>
                          </div>
                      </section>
                  </div>
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol red">
                              <i class="icon-tags"></i>
                          </div>
                          <div class="value">
                              <h1 class=" count2">
                                  0
                              </h1>
                              <p style="color:#191970;">成本费用(万元)</p>
                        </div>
                      </section>
                  </div>
                  
              </div>
              <!--state overview end-->
              
              <div class="row">
                   <div class="col-lg-19">
                      <!--work progress start-->
                      <section class="panel">
                          <div class="panel-body progress-panel">
                              <div class="task-progress">
                              <input type="hidden" id="dqsj" value="<%=enddate%>">
                                  <h1>报告预警</h1>
                                  <p></p>
                              </div>
                              <div class="task-progress" style="margin-left: 90%;">
                                  <a href="<%=path%>/tjgl/bgcx/warnPage?kobe=24">更多>></a>
                                  <p></p>
                              </div>
                              <header class="panel-heading tab-bg-dark-navy-blue"style="width:227px;padding: 0px; height: 34px; margin-top: 49px;" >
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
                           <table class="table table-hover personal-task" >
                              <tbody>
                              <tr>
                                  <td style="text-align:center;"><b>状态</b></td>
                                  <td style="text-align:center;"><b>报告编号</b></td>
								  <td style="text-align:center;"><b>样品名称</b></td>
								  <td style="text-align:center;"><b>样品登记时间</b></td>
								  <td style="text-align:center;"><b>完成期限</b></td>
								  <td style="text-align:center;"><b>签收人</b></td>
								  <td style="text-align:center;"><b>主检人</b></td>
								  <td style="text-align:center;"><b>审核人</b></td>
								  <td style="text-align:center;"><b>批准人</b></td>
								  <td style="text-align:center;"><b>报告状态</b></td>
								  <td style="text-align:center;"><b>收费情况</b></td>
								  <td style="text-align:center;"><b>移交情况</b></td>
                              </tr>
                               <c:forEach var="data" items="${bgyj}" varStatus="obj"> 
                               <c:if test="${data.workDayVal<0}">
                               <tr class="gradeY">
                                  <td class="gradeY"><button type="button" class="btn3" style = "background-color:red;border: 1px solid red;">过期</button></td>
                                  </c:if>
                                  <c:if test="${data.workDayVal>=0 && data.workDayVal<=3}"> 
                               <tr class="gradeZ">
                                  <td class='gradeZ'><button type='button' class='btn3'>即将过期</button></td>
                                </c:if> 
                                  <c:if test="${data.workDayVal>3}"> 
                               <tr class="gradeX">
                                  <td class='gradeX'><button type='button' class='btn3' style = 'background-color:green;border: 1px solid #797979;'>正常</button></td>
                                  </c:if>
                                  <td style="text-align:center;">${data.ypbh }</td>
								  <td style="text-align:center;">${data.ypmc }</td>
								  <td style="text-align:center;">${data.djsj }</td>
								  <td style="text-align:center;">${data.wcqx }</td>
								  <c:if test="${data.ypzt1 ==0 }">
								  <td style="text-align:center;">${data.qsr }</td>
								  <td style="text-align:center;"></td>
								  <td style="text-align:center;"></td>
								  <td style="text-align:center;"></td>
								  </c:if>
								  <c:if test="${data.ypzt1 == 2 || data.ypzt1 == 1 }">
								  <td style="text-align:center;">${data.qsr }</td>
								  <td style="text-align:center;">${data.bzr }</td>
								  <td style="text-align:center;"></td>
								  <td style="text-align:center;"></td>
								  </c:if>
								  <c:if test="${data.ypzt1 ==3 }">
								  <td style="text-align:center;">${data.qsr }</td>
								  <td style="text-align:center;">${data.bzr }</td>
								  <td style="text-align:center;">${data.shr }</td>
								  <td style="text-align:center;"></td>
								  </c:if>
								  <c:if test="${data.ypzt1 >=4 && data.ypzt1 <= 7 }">
								  <td style="text-align:center;">${data.qsr }</td>
								  <td style="text-align:center;">${data.bzr }</td>
								  <td style="text-align:center;">${data.shr }</td>
								  <td style="text-align:center;">${data.pzr }</td>
								  </c:if>
								  <c:if test="${data.ypzt1 ==8 }">
								  <td style="text-align:center;"></td>
								  <td style="text-align:center;"></td>
								  <td style="text-align:center;"></td>
								  <td style="text-align:center;"></td>
								  </c:if>
								  <td style="text-align:center;">${data.ypjyzt }</td>
<%-- 								  <td style="text-align:center;">${data.ypzt1 }</td>  --%>
								  <c:if test="${data.jyfy==0}">
 								  <td style="text-align:center;">无费用</td> 
								  </c:if>
								  <c:if test="${data.ysfje == 0 && data.jyfy!=0}">
 								  <td style="text-align:center;">待收费</td> 
								  </c:if>
								  <c:if test="${data.jyfy > data.ysfje && data.ysfje != 0 }">
								  <td style="text-align:center;">收费中</td>
								  </c:if>
								  <c:if test="${data.ysfje == data.jyfy && data.ysfje != 0 }">
								  <td style="text-align:center;">已收费</td>
								  </c:if>
								  <c:if test="${data.ypyj == 0 || data[i].YPYJ == null}">
								  <td style="text-align:center;">不移交</td>
								  </c:if>
								  <c:if test="${data.ypyj == 1 && data.yjzt == 0 }">
								  <td style="text-align:center;">未移交</td>
								  </c:if>
								  <c:if test="${data.ypyj == 1 && data.yjzt == 1 }">
								  <td style="text-align:center;">已移交</td>
								  </c:if>
							  </tr>
                              </c:forEach>
                              </tbody>
                          </table>
                          </div>
                          <div class="tab-pane" id="comments">
                           <table class="table table-hover personal-task" >
                              <tbody>
                              <tr>
                                  <td style="text-align:center;"><b>状态</b></td>
                                  <td style="text-align:center;"><b>报告编号</b></td>
								  <td style="text-align:center;"><b>样品名称</b></td>
								  <td style="text-align:center;"><b>样品登记时间</b></td>
								  <td style="text-align:center;"><b>完成期限</b></td>
								  <td style="text-align:center;"><b>签收人</b></td>
								  <td style="text-align:center;"><b>主检人</b></td>
								  <td style="text-align:center;"><b>审核人</b></td>
								  <td style="text-align:center;"><b>批准人</b></td>
								  <td style="text-align:center;"><b>报告状态</b></td>
								  <td style="text-align:center;"><b>收费情况</b></td>
								  <td style="text-align:center;"><b>移交情况</b></td>
                              </tr>
                               <c:forEach var="data" items="${bgyj1}" varStatus="obj"> 
                                  <c:if test="${data.workDayVal<0}">
                               <tr class="gradeY">
                                  <td class="gradeY"><button type="button" class="btn3" style = "background-color:red;border: 1px solid red;">过期</button></td>
                                  </c:if>
                                  <c:if test="${data.workDayVal>=0}"> 
                               <tr class="gradeX">
                                  <td class='gradeX'><button type='button' class='btn3' style = 'background-color:green;border: 1px solid #797979;'>正常</button></td>
                                  </c:if>
                                  <td style="text-align:center;">${data.ypbh }</td>
								  <td style="text-align:center;">${data.ypmc }</td>
								  <td style="text-align:center;">${data.djsj }</td>
								  <td style="text-align:center;">${data.wcqx }</td>
								  <c:if test="${data.ypzt1 ==0 }">
								  <td style="text-align:center;">${data.qsr }</td>
								  <td style="text-align:center;"></td>
								  <td style="text-align:center;"></td>
								  <td style="text-align:center;"></td>
								  </c:if>
								  <c:if test="${data.ypzt1 == 2 || data.ypzt1 == 1 }">
								  <td style="text-align:center;">${data.qsr }</td>
								  <td style="text-align:center;">${data.bzr }</td>
								  <td style="text-align:center;"></td>
								  <td style="text-align:center;"></td>
								  </c:if>
								  <c:if test="${data.ypzt1 ==3 }">
								  <td style="text-align:center;">${data.qsr }</td>
								  <td style="text-align:center;">${data.bzr }</td>
								  <td style="text-align:center;">${data.shr }</td>
								  <td style="text-align:center;"></td>
								  </c:if>
								  <c:if test="${data.ypzt1 >=4 && data.ypzt1 <= 7 }">
								  <td style="text-align:center;">${data.qsr }</td>
								  <td style="text-align:center;">${data.bzr }</td>
								  <td style="text-align:center;">${data.shr }</td>
								  <td style="text-align:center;">${data.pzr }</td>
								  </c:if>
								  <c:if test="${data.ypzt1 ==8 }">
								  <td style="text-align:center;"></td>
								  <td style="text-align:center;"></td>
								  <td style="text-align:center;"></td>
								  <td style="text-align:center;"></td>
								  </c:if>
								  <td style="text-align:center;">${data.ypjyzt }</td>
<%-- 								  <td style="text-align:center;">${data.ypzt1 }</td>  --%>
								  <c:if test="${data.jyfy==0}">
 								  <td style="text-align:center;">无费用</td> 
								  </c:if>
								  <c:if test="${data.ysfje == 0 && data.jyfy != 0}">
 								  <td style="text-align:center;">待收费</td> 
								  </c:if>
								  <c:if test="${data.jyfy > data.ysfje && data.ysfje != 0 }">
								  <td style="text-align:center;">收费中</td>
								  </c:if>
								  <c:if test="${data.ysfje == data.jyfy && data.ysfje != 0 }">
								  <td style="text-align:center;">已收费</td>
								  </c:if>
								  <c:if test="${data.ypyj == 0 || data[i].YPYJ == null}">
								  <td style="text-align:center;">不移交</td>
								  </c:if>
								  <c:if test="${data.ypyj == 1 && data.yjzt == 0 }">
								  <td style="text-align:center;">未移交</td>
								  </c:if>
								  <c:if test="${data.ypyj == 1 && data.yjzt == 1 }">
								  <td style="text-align:center;">已移交</td>
								  </c:if>
							  </tr>
                              </c:forEach>
                              </tbody>
                              </table>
                          </div>
                          </div>
                          </div>
                          </div>
                          </section>
                      <!--work progress end-->
                  </div>
              </div>

              <div class="row">
                  <div class="col-lg-8">
                      <!--custom chart start-->
                      <div class="border-head">
                          <h3 style="color:#CD5555;"><b>当年收入（万元）</b></h3>
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
                          <c:forEach var="data" items="${aybgsf}" varStatus="obj">
	                          <div class="bar">
	                              <div class="title">${data.yf}月</div>
	                              <div class="value tooltips" data-original-title="${data.je}万元" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">${data.bfb}%</div>
	                          </div>
                          </c:forEach>
                      </div>
                      <!--custom chart end-->
                  </div>
				  <div class="col-lg-4">
                          <section class="panel">
                              <header class="panel-heading">
                                  各部门收入占比
                              </header>
                              <div class="panel-body">
                                  <div id="hero-donut" class="graph"></div>
                              </div>
                          </section>
                  </div>
              </div>
			    <div class="row">
				  <div class="col-lg-8" style="width: 100%;">
                      <!--custom chart start-->
                      <div class="border-head">
                          <h3 style="color:#CD950C;"><b>业务科收入统计（万元）</b></h3>
                      </div>
                      <div class="custom-bar-chart">
                          <ul class="y-axis">
                              <li><span>500</span></li>
                              <li><span>400</span></li>
                              <li><span>300</span></li>
                              <li><span>200</span></li>
                              <li><span>100</span></li>
                              <li><span>0</span></li>
                          </ul>
                          <c:forEach var="data" items="${ywkssf}" varStatus="obj">
	                          <div class="bar" style="left: 2%;">
	                              <div class="title" style="width: 128%;left: -5px;">${data.bmmc}</div>
	                              <div class="value tooltips" data-original-title="${data.je}万元" data-toggle="tooltip" data-placement="top" style="background-color:#EE9A00;">${data.bfb }%</div>
	                          </div>
                          </c:forEach>
                      </div>
                      <!--custom chart end-->
                  </div>
              </div>
              
              <div class="row">
                   <div class="col-lg-19">
                      <!--user info table start-->
                      <section class="panel">
                          <div class="panel-body" style="height:59px;">
                              <div class="task-thumb-details">
                                  <h1><a href="#">各部门排行</a></h1>
                                  <p></p>
                              </div>
                          </div>
                          <table class="table table-hover personal-task">
                              <tbody>
                              	<c:forEach var="data" items="${ywksph}" varStatus="obj">
	                                <tr>
	                                    <td>
	                                        <i class=" icon-tasks"></i>
	                                    </td>
	                                    <td>${data.bmmc}</td>									
	                                    <td>${data.rs}人</td>
	                                    <td>${data.je}万元</td>
	                                </tr>
                                </c:forEach>
                              </tbody>
                          </table>
                      </section>
                      <!--user info table end-->
                  </div>
              </div>	 
              <div class="row">
                  <div class="col-lg-19">
                      <!--work progress start-->
                      <section class="panel">
                          <div class="panel-body progress-panel">
                              <div class="task-progress">
                                  <h1>客户信息统计</h1>
                                  <p></p>
                              </div>
                              
                          </div>
                          <table class="table table-hover personal-task" >
                              <tbody>
                              <tr>
                                  <td></td>
                                  <td style="text-align:center;">1月</td>
                                  <td style="text-align:center;">2月</td>
								  <td style="text-align:center;">3月</td>
								  <td style="text-align:center;">4月</td>
								  <td style="text-align:center;">5月</td>
								  <td style="text-align:center;">6月</td>
								  <td style="text-align:center;">7月</td>
								  <td style="text-align:center;">8月</td>
								  <td style="text-align:center;">9月</td>
								  <td style="text-align:center;">10月</td>
								  <td style="text-align:center;">11月</td>
								  <td style="text-align:center;">12月</td>
                              </tr>
                              <tr>
                                  <td style="text-align:center;">客户业务量（万元）</td>
                                  <c:forEach var="data" items="${aybgsf}" varStatus="obj">
	                                  <td style="text-align:center;">${data.je}</td>
                                  </c:forEach>
                              </tr>
                              <tr>
                                  <td style="text-align:center;">现有客户量</td>
                                  <c:forEach var="data" items="${xykhl}" varStatus="obj">
	                                  <td style="text-align:center;">${data.rs}</td>
                                  </c:forEach>
                              </tr>
                              <tr>
                                  <td style="text-align:center;">当月新增客户量</td>
                                  <c:forEach var="data" items="${yxzkhl}" varStatus="obj">
	                                  <td style="text-align:center;">${data.rs}</td>
                                  </c:forEach>
                              </tr>
                              <tr>
                                  <td style="text-align:center;">客户拜访次数</td>
                                  <c:forEach var="data" items="${ykhbfl}" varStatus="obj">
	                                  <td style="text-align:center;">${data.rs}</td>
                                  </c:forEach>
                              </tr>
                              </tbody>
                          </table>
                      </section>
                      <!--work progress end-->
                  </div>
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
    
	<script type="text/javascript">
		var ndzsf=${ndzsf};
		var bgsf=${bgsf};
		var bgzs=${bgzs};
		var cbfy=${cbfy};
		var str=${ywksbt};
	</script>
	
    <!--script for this page-->
    <script src="<%=path%>/resources/index/js/sparkline-chart.js"></script>
    <script src="<%=path%>/resources/index/js/easy-pie-chart.js"></script>
    <script src="<%=path%>/resources/index/js/count.js"></script>
     <script src="<%=path %>/resources/bootstrap/js/bootstrap.min.js"></script>
<%--     <script type="text/javascript" src="<%=path%>/resources/js/sys/indexbgyj.js"></script> --%>
    <script src="<%=path%>/resources/index/js/morris-script1.js"></script>
    <script src="<%=path%>/resources/index/assets/morris.js-0.4.3/morris.min.js" type="text/javascript"></script>
    <script src="<%=path%>/resources/index/assets/morris.js-0.4.3/raphael-min.js" type="text/javascript"></script>

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

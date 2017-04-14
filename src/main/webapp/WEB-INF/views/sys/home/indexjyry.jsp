<%@page contentType="text/html" import="java.util.* ,java.util.Date" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="/WEB-INF/tld/fn.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<% String path = request.getContextPath();
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
             
              <!--state overview end-->

              <div class="row" style="margin-top:10px;">
                  <div class="col-lg-4">
                      <!--user info table start-->
                      <section class="panel">
                          <div class="panel-body" style="height:59px;">
                              <div class="task-thumb-details">
                                  <h1><a href="#">任务列表</a></h1>
                                  <p></p>
                              </div>
                          </div>
                          <table class="table table-hover personal-task">
                              <tbody>
                                <c:forEach var="Rwlb" items="${Rwlb}" varStatus="obj" begin="0" end="3">
                                 <tr>
                                      <td align="center">${Rwlb.bgbh}</td> 
                                      <td align="center">${Rwlb.stime}</td> 
                                      <td align="center">${Rwlb.name}</td> 
                                     <td> <a class="btn btn-xs btn-success" onclick="alert('当前${Rwlb.name}有一条编号为${Rwlb.bgbh}的任务');" type="submit"> 查看</a></td>
                                 </tr>
                                 </c:forEach>
                              </tbody>
                          </table>
                      </section>
                      <!--user info table end-->
                  </div>
                  <div class="col-lg-8">
                      <!--work progress start-->
                      <section class="panel">
                          <div class="panel-body progress-panel">
                              <div class="task-progress">
                                  <h1>人员工作汇总</h1>
                                  <p></p>
                              </div>
                          </div>
                          <table class="table table-hover personal-task">
                              <tbody>
                              <tr>
                                  <td align="center"><b>人员名称</b></td>
								  <td align="center"><b>总任务量</b></td>
                                  <td align="center"><b>已完成数</b></td>
								  <td align="center"><b>未完成数</b></td>
                                  <td align="center"><b>操   作</b></td>
                              </tr>
                              <c:forEach  var="Gzhz" items="${Gzhz}" varStatus="obj" begin="0" end="3">
                                 <tr>
                                      <td align="center">${Gzhz.NAME_} </td>
                                      <td align="center">${Gzhz.SRWS}</td> 
                                      <td align="center">${Gzhz.ERWS}</td> 
                                      <td align="center">${Gzhz.SRWS - Gzhz.ERWS}</td> 
                                     <td> <a class="btn btn-xs btn-success" onclick="alert('当前${Gzhz.NAME_}已完成${Gzhz.ERWS}条任务，还有${Gzhz.SRWS - Gzhz.ERWS}条任务未完成');" type="submit"> 查看</a></td>
                                 </tr>
                                 </c:forEach>
                              </tbody>
                          </table>
                      </section>
                      <!--work progress end-->
                  </div>
              </div>
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
             <div class="row" style="margin-top:10px;">
				  <div class="col-lg-4">
                      <!--user info table start-->
                      <section class="panel">
                          <div class="panel-body" style="height:59px;">
                              <div class="task-thumb-details">
                                  <h1><a href="#">设备情况</a></h1>
                                  <p></p>
                              </div>
                          </div>
                          <table class="table table-hover personal-task">
                              <tbody>
                                <tr>
                                    <td></td>
                                    <td align="center"><b>设备名称</b></td>									
                                    <td align="center"><b>采购时间</b></td>
                                    <td align="center"><b>状态</b></td>
                                </tr>
                                <c:forEach begin="0" end="9" var="data" items="${sbqk }" varStatus="obj">
	                                <tr>
	                                    <td>
<!-- 	                                        <i class="icon-warning-sign"></i> -->
	                                        <i class=" icon-bell-alt"></i>
	                                    </td>
	                                    <td>${data.sbmc}</td>									
	                                    <td>${data.gmrq}</td>
	                                    <td>${data.syzt}</td>
	                                </tr>
                                </c:forEach>
                              </tbody>
                          </table>
                      </section>
                      <!--user info table end-->
                  </div>
				   <div class="col-lg-8">
                      <!--work progress start-->
                      <section class="panel">
                          <div class="panel-body progress-panel">
                              <div class="task-progress">
                                  <h1>缴费情况（元）</h1>
                                  <p></p>
                              </div>
                          </div>
                          <table class="table table-hover personal-task">
                              <tbody>
                              <tr>
                                  <td align="center"><b>报告编号</b></td>
								  <td align="center"><b>检验项目名称</b></td>
                                  <td align="center"><b>应缴费金额</b></td>
								  <td align="center"><b>已缴费金额</b></td>
                                  <td align="center"><b>缴费状态</b></td>
                              </tr>
                               <c:forEach begin="0" end="9"  var="data" items="${jfqk }" varStatus="obj">
	                                <tr>
	                                    <td>${data.bgbh}</td>									
	                                    <td>${data.ypmc}</td>
	                                    <td align="center">${data.jyfy}</td>
	                                    <td align="center">${data.ysfje}</td>
	                                    <td align="center">
	                                    <c:if test="${data.ysfje == 0 }"><span style="color:red">待收费</span></c:if>
	                                    <c:if test="${data.ysfje != 0 && data.ysfje < data.jyfy }"><span style="color:blue">收费中</span></c:if>
	                                    <c:if test="${data.ysfje == data.jyfy }">已收费</c:if>
	                                    </td>
	                                </tr>
                                </c:forEach>
                              </tbody>
                          </table>
                      </section>
                      <!--work progress end-->
                  </div>  
              </div>
            
  
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/jquery-1.8.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="js/jquery.sparkline.js" type="text/javascript"></script>
    <script src="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
    <script src="js/owl.carousel.js" ></script>
    <script src="js/jquery.customSelect.min.js" ></script>
    <script src="js/respond.min.js" ></script>

    <script class="include" type="text/javascript" src="js/jquery.dcjqaccordion.2.7.js"></script>

    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>

    <!--script for this page-->
    <script src="js/sparkline-chart.js"></script>
    <script src="js/easy-pie-chart.js"></script>
    <script src="js/count.js"></script>
     <script src="<%=path %>/resources/bootstrap/js/bootstrap.min.js"></script>
<%--     <script type="text/javascript" src="<%=path%>/resources/js/sys/indexbgyj.js"></script> --%>
    <script src="js/morris-script.js"></script>
    <script src="assets/morris.js-0.4.3/morris.min.js" type="text/javascript"></script>
    <script src="assets/morris.js-0.4.3/raphael-min.js" type="text/javascript"></script>

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

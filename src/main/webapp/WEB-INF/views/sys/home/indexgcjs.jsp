<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<% String path = request.getContextPath();%>
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
  </head>

  <body>
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <div class="row">
                  <div class="col-lg-8" style="margin-top:10px;">
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
	                              <div class="value tooltips" data-original-title="${data.je}万元" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">${data.bfb }%</div>
	                          </div>
                          </c:forEach> 
                      
                      </div>
                      <!--custom chart end-->
                  </div>
                 <div class="col-lg-4" style="margin-top:10px;">
                      <!--user info table start-->
                      <section class="panel">
                          <div class="panel-body" style="height:59px;">
                              <div class="task-thumb-details">
                                  <h1><a href="#">标准过期提醒</a></h1>
                                  <p></p>
                              </div>
                          </div>
                          <table class="table table-hover personal-task">
                              <tbody>
                                <tr>
                                    <td></td>
                                    <td align="center"><b>标准名称</b></td>									
                                    <td align="center"><b>启动时间</b></td>
                                    <td align="center"><b>废止时间</b></td>
                                </tr>
                                <c:forEach begin="0" end="9" var="data" items="${bzgqtx}" varStatus="obj">
	                                <tr>
	                                    <td>
	                                        <i class=" icon-tasks"></i>
	                                    </td>
	                                    <td>${data.bzmc}</td>									
	                                    <td>${data.qyrq}</td>
	                                    <td>${data.fzrq}</td>
	                                </tr>
                                </c:forEach>
                              </tbody>
                          </table>
                      </section>
                      <!--user info table end-->
                  </div>
              </div>
              <div class="row">
                  <div class="col-lg-4">
                      <!--user info table start-->
                      <section class="panel">
                          <div class="panel-body" style="height:59px;">
                              <div class="task-thumb-details">
                                  <h1><a href="#">检测室排行</a></h1>
                                  <p></p>
                              </div>
                          </div>
                          <table class="table table-hover personal-task">
                              <tbody>
                                <tr>
                                    <td><b>检验室名称</b></td>
									<td align="center"><b>任务总量</b></td>
									<td align="center"><b>人员名称</b></td>
                                </tr>
                                <c:forEach begin="0" end="9" var="data" items="${jcsph}" varStatus="obj">
	                                <tr>
	                                    <td>${data.jyks}</td>
	                                    <td>${data.rws}</td>									
	                                    <td>${data.name_}</td>
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
                                  <h1>报告进度</h1>
                                  <p></p>
                              </div>
                          </div>
                          <table class="table table-hover personal-task">
                              <tbody>
                              <tr>
                                  <td><b>检验室名称</b></td>
                                  <td align="center"><b>报告总量</b></td>
                                  <td align="center"><b>完成数</b></td>
                                  <td align="center"><b>未完成数</b></td>
                              </tr>
                              <c:forEach begin="0" end="9" var="data" items="${bgjd}" varStatus="obj">
	                                <tr>
	                                    <td>${data.jyks}</td>
	                                    <td align="center">${data.ywc + data.wwc}</td>
	                                    <td align="center">${data.ywc}</td>									
	                                    <td align="center">${data.wwc}</td>
	                                </tr>
                                </c:forEach>
                              </tbody>
                          </table>
                      </section>
                      <!--work progress end-->
                  </div>
              </div>
              <div class="row">
                  <div class="col-lg-4">
                      <!--user info table start-->
                      <section class="panel">
                          <div class="panel-body" style="height:59px;">
                              <div class="task-thumb-details">
                                  <h1><a href="#">科研项目进度</a></h1>
                                  <p></p>
                              </div>
                          </div>
                          <table class="table table-hover personal-task">
                              <tbody>
                                <tr>
                                    <td><b>科研项目名称</b></td>
									<td align="center"><b>立项时间</b></td>
									<td align="center"><b>所属科室</b></td>
<!-- 									<td align="center"><b>完成进度</b></td> -->
<!-- 									<td align="center"><b>操作</b></td> -->
                                </tr>
                                <c:forEach begin="0" end="9" var="data" items="${kyxmjd}" varStatus="obj">
	                                <tr>
	                                    <td>${data.kymc}</td>
	                                    <td>${data.kssj}</td>									
	                                    <td>${data.ks_id}</td>
<!-- 	                                    <td align="center"><a href="#">查看</a></td> -->
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
                                  <h1>基础改造情况</h1>
                                  <p></p>
                              </div>
                              <div class="task-option">
                                  开始时间&nbsp;<select class="styled"></select>&nbsp;&nbsp;&nbsp;&nbsp;
								  结束时间&nbsp;<select class="styled"></select>
                              </div>
                          </div>
                          <table class="table table-hover personal-task">
                              <tbody>
                              <tr>
                                  <td><b>设备名称</b></td>
                                  <td align="center"><b>设备参数</b></td>
                                  <td align="center"><b>生产厂家</b></td>
                                  <td align="center"><b>型号规格</b></td>
								  <td align="center"><b>改造预算</b></td>
								  <td align="center"><b>使用部门</b></td>
								  <td align="center"><b>操作</b></td>
                              </tr>
                              <tr>
                                  <td>双目生物显微镜</td>
                                  <td align="center">LIOO JS-500</td>
                                  <td align="center">上海点应光学</td>
                                  <td align="center">LIOO JS-500</td>
								  <td align="center">5000元</td>
								  <td align="center">食品产品检测室</td>
								  <td align="center"><a href="#">查看</a></td>
                              </tr>
                              <tr>
                                  <td>双目生物显微镜</td>
                                  <td align="center">LIOO JS-500</td>
                                  <td align="center">上海点应光学</td>
                                  <td align="center">LIOO JS-500</td>
								  <td align="center">5000元</td>
								  <td align="center">食品产品检测室</td>
								  <td align="center"><a href="#">查看</a></td>
                              </tr>
                              <tr>
                                  <td>双目生物显微镜</td>
                                  <td align="center">LIOO JS-500</td>
                                  <td align="center">上海点应光学</td>
                                  <td align="center">LIOO JS-500</td>
								  <td align="center">5000元</td>
								  <td align="center">食品产品检测室</td>
								  <td align="center"><a href="#">查看</a></td>
                              </tr>
                              <tr>
                                  <td>双目生物显微镜</td>
                                  <td align="center">LIOO JS-500</td>
                                  <td align="center">上海点应光学</td>
                                  <td align="center">LIOO JS-500</td>
								  <td align="center">5000元</td>
								  <td align="center">食品产品检测室</td>
								  <td align="center"><a href="#">查看</a></td>
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
    <script src="<%=path%>/resources/index/js/jquery.scrollTo.min.js"></script>
    <script src="<%=path%>/resources/index/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="<%=path%>/resources/index/js/jquery.sparkline.js" type="text/javascript"></script>
    <script src="<%=path%>/resources/index/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
    <script src="<%=path%>/resources/index/js/owl.carousel.js" ></script>
    <script src="<%=path%>/resources/index/js/jquery.customSelect.min.js" ></script>
    <script src="<%=path%>/resources/index/js/respond.min.js" ></script>


    <!--common script for all pages-->
    <script src="<%=path%>/resources/index/js/common-scripts.js"></script>

    <!--script for this page-->
    <script src="<%=path%>/resources/index/js/sparkline-chart.js"></script>
    <script src="<%=path%>/resources/index/js/easy-pie-chart.js"></script>
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

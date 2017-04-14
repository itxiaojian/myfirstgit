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
  <section id="container" >
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <!--state overview start-->
              <div class="row state-overview">
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol terques">
                              <i class="icon-user"></i>
                          </div>
                          <div class="value">
                              <h1 class="count">
                                  0
                              </h1>
                              <p>档案总数</p>
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
                              <span class=" count4"></span></h1>
                              <p>合同汇总</p>
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
                              <span class=" count4"></span></h1>
                              <p>采购统计</p>
                        </div>
                      </section>
                  </div>
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol blue">
                              <i class="icon-bar-chart"></i>
                          </div>
                          <div class="value">
                              <h1 class=" count4">
                                  0
                              </h1>
                              <p>单位收费(万)</p>
                          </div>
                      </section>
                  </div>
              </div>
              <!--state overview end-->

              <div class="row">
                   <div class="col-lg-8">
                      <!--custom chart start-->
                      <div class="border-head">
                          <h3 style="color:#CD5555;"><b>单位收费汇总</b></h3>
                      </div>
                      <div class="custom-bar-chart">
                          <ul class="y-axis">
                              <li><span>10000</span></li>
                              <li><span>8000</span></li>
                              <li><span>6000</span></li>
                              <li><span>4000</span></li>
                              <li><span>2000</span></li>
                              <li><span>0</span></li>
                          </ul>
                          <c:forEach var="data" items="${dwsfhz}" varStatus="obj">
	                          <div class="bar">
	                              <div class="title">${data.yf}月</div>
	                              <div class="value tooltips" data-original-title="${data.je}" data-toggle="tooltip" data-placement="top" style="background-color:#DC143C;">${data.bfb }%</div>
	                          </div>
                          </c:forEach>
                      </div>
                      <!--custom chart end-->
                  </div>
                  <div class="col-lg-4">
                      <div class="panel terques-chart">
                          <div class="panel-body chart-texture">
                              <div class="chart">
                                  <div class="heading">
                                      <span>${dqyf}月</span>
                                      <strong>${zsf}万 </strong>
                                  </div>
                                   <div class="sparkline" data-type="line" data-resize="true" data-height="75" data-width="90%" data-line-width="1" data-line-color="#fff" data-spot-color="#fff" data-fill-color="" data-highlight-line-color="#fff" data-spot-radius="4"  data-data="${jcssr}">
                                  </div> 
                              </div>
                          </div>
                          <div class="chart-tittle">
                              <span class="title">检测室收入</span>                             
                          </div>
                          
                      </div>
                      
                       <div class="panel terques-chart">
                          <div class="panel-body chart-texture">
                              <div class="chart">
                                  <div class="heading">
                                      <span>${dqyf}月</span>
                                      <strong>${ywzsf}万 </strong>
                                  </div>
                                   <div class="sparkline" data-type="line" data-resize="true" data-height="75" data-width="90%" data-line-width="1" data-line-color="#fff" data-spot-color="#fff" data-fill-color="" data-highlight-line-color="#fff" data-spot-radius="4"  data-data="${ywkssr}">
                                  </div> 
                              </div>
                          </div>
                          <div class="chart-tittle">
                              <span class="title">业务科室收入</span>                             
                          </div>
                      </div>
                  
              </div>
              <div class="row">
                   <div class="col-lg-4">
                      <!--user info table start-->
                      <section class="panel">
                          <div class="panel-body" style="height:59px;">
                              
                              <div class="task-thumb-details">
                                  <h1><a href="#">档案统计</a></h1>
                                  <p></p>
                              </div>
                          </div>
                          <table class="table table-hover personal-task">
                              <tbody>
                                <tr>
									<td align="center"><b>档案类型</b></td>									
                                    <td align="center"><b>档案数量</b></td>
                                </tr>
                                <c:forEach var="Datj" items="${Datj}" varStatus="obj">
                                 <tr>
                                       <td cishu>${Datj.dalx}</td>
                                       <td cishu>${Datj.cishu}</td> 
                                   
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
                                  <h1>采购进度</h1>
                                  <p></p>
                              </div>
                              <div class="task-option">
                                  <select class="styled">
                                      <option>检测设备</option>
                                      <option>办公用品</option>
                                      <option>网络设备</option>
									  <option>其他</option>
                                  </select>
                              </div>
                          </div>
                          <table class="table table-hover personal-task">
                              <tbody>
                              <tr>
                                  <td>1</td>
                                  <td>
                                      IBM System x3850 X63837I01
                                  </td>
                                  <td>
                                      <span class="badge bg-important">75%</span>
                                  </td>
                                  <td>
                                    <div id="work-progress1"></div>
                                  </td>
                              </tr>
                              <tr>
                                  <td>2</td>
                                  <td>
                                      惠普（HP） HP Laserjet PRO P1108激光打印机
                                  </td>
                                  <td>
                                      <span class="badge bg-success">43%</span>
                                  </td>
                                  <td>
                                      <div id="work-progress2"></div>
                                  </td>
                              </tr>
                              <tr>
                                  <td>3</td>
                                  <td>
                                      世仪SY-WSS双金属温度计
                                  </td>
                                  <td>
                                      <span class="badge bg-info">67%</span>
                                  </td>
                                  <td>
                                      <div id="work-progress3"></div>
                                  </td>
                              </tr>
                              <tr>
                                  <td>4</td>
                                  <td>
                                      M5000 CCD全谱火花直读光谱仪
                                  </td>
                                  <td>
                                      <span class="badge bg-warning">30%</span>
                                  </td>
                                  <td>
                                      <div id="work-progress4"></div>
                                  </td>
                              </tr>
                              <tr>
                                  <td>5</td>
                                  <td>
                                      动力电池防爆试验箱
                                  </td>
                                  <td>
                                      <span class="badge bg-primary">15%</span>
                                  </td>
                                  <td>
                                      <div id="work-progress5"></div>
                                  </td>
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

    <!--script for this page-->
	<script type="text/javascript">
			var bgzs=${dazs};
			var cbfy=${hthz};
			var bgsf=${cgtj};
	</script>
    
    <script>
    var ndzsf=${dwsf}; 
    </script>
    
    <script src="<%=path%>/resources/index/js/sparkline-chart.js"></script>
    <script src="<%=path%>/resources/index/js/easy-pie-chart.js"></script>
    <script src="<%=path%>/resources/index/js/count.js"></script>



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

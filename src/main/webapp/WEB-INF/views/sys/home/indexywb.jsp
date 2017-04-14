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
                              <p>工作量汇总</p>
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
                              <p>缴费情况（万元）</p>
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
                              <p>月收入（万元）</p>
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
                              <p>本年收入(万元)</p>
                          </div>
                      </section>
                  </div>
              </div>
              <div class="tab-pane" id="chartjs">
					  <div class="tab-pane" id="chartjs">          
                  <div class="row">
                      <div class="col-lg-19">
                          <section class="panel">
                              <header class="panel-heading">
                                  <h4 style="color:#CD950C;"><b>当年收入统计（万元）</b></h4>
                              </header>
                              <div class="panel-body text-center">
                                  <canvas id="bar" height="300" width="1200"></canvas>
                              </div>
                          </section>
                      </div>
                    
                  </div>
              </div>
			</div>
				  
              <div class="row">
                   <div class="col-lg-4">
                      <!--user info table start-->
                      <section class="panel">
                          <div class="panel-body" style="height:59px;">
                              
                              <div class="task-thumb-details">
                                  <h1><a href="#">收费情况</a></h1>
                                  <p></p>
                              </div>
                          </div>
                          <table class="table table-hover personal-task">
                              <tbody>
                                <tr>
									<td align="center"><b>人员名称</b></td>									
                                    <td align="center"><b>应到款</b></td>
                                    <td align="center"><b>实到款</b></td>
									<td align="center"><b>未到款</b></td>
                                </tr>
                                <c:forEach var="Bgsf" items="${Bgsf}" varStatus="obj" begin="0" end="3">
                                 <tr>
                                       <td>${Bgsf.sfr} </td>
                                       <td>${Bgsf.ydk}</td> 
                                       <td>${Bgsf.sdk}</td>
                                       <td>${Bgsf.ydk - Bgsf.sdk}</td>
                                 </tr>
                                 </c:forEach>
                              </tbody>
                               
                          </table>
                      </section>
                      <!--user info table end-->
                  </div> 
                  
                    <div class="row">
                  <div class="col-lg-19">
                      <!--work progress start-->
                      <section class="panel">
                          <div class="panel-body progress-panel">
                            <!--   <div class="task-progress">
                                  <h1>客户信息统计</h1>
                                  <p></p>
                              </div> -->
                              
                          </div>
                          <table class="table table-hover personal-task" >
                              <div class="panel-body progress-panel">
                              <div class="task-progress">
                                  <h1 style="margin-left: 25px;">客户信息统计</h1>
                                  <p></p>
                              </div>
                              
                          </div>
                              <tbody>
                              <tr>
                                  <td style="text-align:center;">月份</td>
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
                                  <c:forEach var="data" items="${khywl}" varStatus="obj">
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
				 </div>
				<div class="row">
                  <div class="col-lg-4">
                      <!--user info table start-->
                      <section class="panel">
                          <div class="panel-body" style="height:59px;">
                              
                              <div class="task-thumb-details">
                                  <h1><a href="#">业务当月排行</a></h1>
                                  <p></p>
                              </div>
                          </div>
                          <table class="table table-hover personal-task">
                              <tbody>
                                <tr>
									<td align="center"><b>人员名称</b></td>									
                                    <td align="center"><b>月份</b></td>
                                    <td align="center"><b>业务量</b></td>
                                </tr>
                                <c:forEach var="Ywyph" items="${Ywyph}" varStatus="obj">
                                 <tr>
                                       <td>${Ywyph.djry }</td>
                                       <td>${dqyf}月</td> 
                                       <td>${Ywyph.cishu}</td>
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
<!-- 						      <a href="#" class="task-thumb"> -->
<%--                                   <img src="<%=path%>/resources/index/img/jindu.jpg" alt=""></a> --%>
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
    
			var bgzs = ${gzlhz} ;
			var cbfy = ${ywjfqk} ;
			var bgsf = ${ywysr} ; 
			var ndzsf=${ywnsr} ; 
			var str1=${dnsrtj1} ;
			var str2=${dnsrtj2} ;  
			
    </script>
    <script src="<%=path%>/resources/index/js/sparkline-chart.js"></script>
    <script src="<%=path%>/resources/index/js/easy-pie-chart.js"></script>
    <script src="<%=path%>/resources/index/js/count.js"></script>
    <script src="<%=path%>/resources/index/assets/chart-master/zztChart.js"></script>
    <!-- script for this page only-->
    <script src="<%=path%>/resources/index/js/zzt-chartjs.js"></script>


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

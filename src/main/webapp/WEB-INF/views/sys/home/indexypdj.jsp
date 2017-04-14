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
             
              <!--state overview end-->

              <div class="row" style="margin-top:50px; margin-left:20px;">
                  <div style="width: 30%;float:left;">
                      <!--user info table start-->
                          <div class="panel-body" style="height:59px;" align="center">
                              <a type="submit" class="btn btn-success" href="/zjyw/ypgl/YYpYpxx/YpdjPage">
                                  <img src="<%=path%>/resources/index/img/ypdj.png" alt="">&nbsp;&nbsp;样品登记
							  </a>  
                          </div>
                      <!--user info table end-->
                  </div>
				  <div style="width: 30%;float:left;">
				  		<div class="panel-body" style="height:59px;" align="center">
                              <a type="submit" class="btn btn-success" href="/zjyw/jygl/YjyJyxx/JyxxPage.*">
                                  <img src="<%=path%>/resources/index/img/jygl.png" alt="">&nbsp;&nbsp;检验查询
							  </a>  
						</div>
                  </div>
				   <div  style="width: 30%;float:left;">
				  		<div class="panel-body" style="height:59px;" align="center">
                              <a type="submit" class="btn btn-success" href="/zjyw/jygl/YjyBgxx/BgxxPage.*">
                                  <img src="<%=path%>/resources/index/img/bgck.png" alt="">&nbsp;&nbsp;报告查询
							  </a>  
						</div>
                  </div> 
              </div>
				<div class="row" style="margin-top:50px; margin-left:20px;">
					<div style="width: 30%;float:left;">
							<div class="panel-body" style="height:59px;" align="center">
								  <a type="submit" class="btn btn-success" href="/zjyw/dagl/YdaXx/DaXxPage.*">
									  <img src="<%=path%>/resources/index/img/bggd.png" alt="">&nbsp;&nbsp;档案归档
								  </a>  
							</div>
					  </div>
					   <div style="width: 30%;float:left;">
							<div class="panel-body" style="height:59px;" align="center">
								  <a type="submit" class="btn btn-success" href="/zjyw/khgl/YKhKhxx/KhxxPage.*">
									  <img src="<%=path%>/resources/index/img/khgl.png" alt="">&nbsp;&nbsp;客户管理
								  </a>  
							</div>
					  </div>
					   <div style="width: 30%;float:left;">
							<div class="panel-body" style="height:59px;" align="center">
								  <a type="submit" class="btn btn-success" href="/zjyw/sbgl/YSbXx/SbxxPage.*">
									  <img src="<%=path%>/resources/index/img/sbgl.png" alt="">&nbsp;&nbsp;设备管理
								  </a>  
							</div>
					  </div>  
				  </div>
				  <div class="row" style="margin-top:50px; margin-left:20px;">
					 <div style="width: 30%;float:left;">
							<div class="panel-body" style="height:59px;" align="center">
								  <a type="submit" class="btn btn-success" href="/zjyw/jybzgl/jybzglPage.*">
									  <img src="<%=path%>/resources/index/img/jybzck.png" alt="">&nbsp;&nbsp;收费标准
								  </a>  
							</div>
					  </div>
					  <div style="width: 30%;float:left;">
							<div class="panel-body" style="height:59px;" align="center">
								  <a type="submit" class="btn btn-success" href="/zjyw/cwgl/YcwBgsf/BgsfPage.*">
									  <img src="<%=path%>/resources/index/img/bgsf.png" alt="">&nbsp;&nbsp;报告收费
								  </a>  
							</div>
					  </div>
					   <div style="width: 30%;float:left;">
							<div class="panel-body" style="height:59px;" align="center">
								  <a type="submit" class="btn btn-success" href="/zjyw/cps/process/taskXN/pendWorkPoolIndex.*">
									  <img src="<%=path%>/resources/index/img/xxck.png" alt="">&nbsp;&nbsp;我的任务
								  </a>  
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
    <script src="<%=path%>/resources/index/js/sparkline-chart.js"></script>
    <script src="<%=path%>/resources/index/js/easy-pie-chart.js"></script>
    <script src="<%=path%>/resources/index/js/count.js"></script>
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
  
  <script  type="text/javascript">
	 function openypxxwin() {  
		window.open("ypdj.html", "样品信息", "height=700, width=1000, toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no") ;
	} 
  </script>

  </body>
</html>
  
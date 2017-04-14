<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<%  String path = request.getContextPath();%>
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
    <link href="<%=path%>/resources/index/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" 
    type="text/css" media="screen"/>
    
    <link rel="stylesheet" href="<%=path%>/resources/index/css/owl.carousel.css" type="text/css" />
    <!-- Custom styles for this template -->
    <link href="<%=path%>/resources/index/css/style.css" rel="stylesheet" />
    <link href="<%=path%>/resources/index/css/style-responsive.css" rel="stylesheet" />
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
    
    <script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>

	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css"/>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery.easyui.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
    
    
    <script>
		function load() {
			$('#ksmc').combotree({
		        url: '<%=path%>/test/xlsList?optype=getchildtree',
		        'onLoadSuccess': function (node, data) {
		            //在panel控件load完成的时候处理当前显示值，如果不处理，则combotree1的显示值有可能会不正确
		            if (data.length > 0) {
		                var val = ""; //jsp页面初始化时combotree1的初始id值
		                var txt = $('#ksmc').combotree('getText'); //combotree1当前的显示text值
		                if (val != "" && val == txt) {
		                    var urlstr = "<%=path%>/test/xlsList" + "?optype=gettext&id=" + val;
		                    $.get(urlstr,
		                            function (gettxt) {
		                                if (gettxt != "")
		                                    $('#ksmc').combotree('setText', gettxt);
		                            }
		                    );
		                }
		            }
		        },
		    });
		}
	</script>	
  </head>

  <body onload="load();">
  <div style="display:none;">
    <ul class="tab-menu tab" id="tabMenuID_">
        <li class="tab-selected" title="成本统计">
            <a href="<%=path%>/sjbb/Cbtj/CbtjPage" target="content" onfocus="this.blur()"><span>成本统计</span></a>
        </li>
    </ul>
  </div>
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <div class="row">
                  <div class="col-lg-19">
                      <!--work progress start-->
                      <section class="panel">
                          <div class="panel-body progress-panel">
<!-- 						      <a href="#" class="task-thumb"> -->
<!--                                   <img src="img/jindu.jpg" alt=""></a> -->
                              <div class="task-progress">
                                  <h1>成本统计</h1>
                              </div>
                              
                          </div>
                          <hr/>
                          <div class="form-group" style="padding-bottom: 0px;padding-left: 0px;">
	                          <label class="col-sm-2 col-sm-2 control-label"  style="width: 6%; margin-left: 0.7%;">科室名称:</label>
							  <div style="margin-top: -5px; margin-bottom: 10px; border-bottom-width: 0px;">
			                       <input id="ksmc" name="ksmc" class="easyui-combotree" value="" style="height: 34px;width: 238px;"/>
			                  </div>
			                  <label class="col-sm-2 col-sm-2 control-label" style="width: 74px;">所属月份:</label>
							  <div class="col-sm-10">
								   <input id="yf" class="form-control" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM'})" name="yf" style="width: 22%;
								    padding-bottom: 6px; margin-bottom: 14px;"/>
							  </div>
						  </div>
                          <table class="table table-hover personal-task" >
                              <tbody>
                              <tr>
                              	<td></td>
                              	<td style="text-align:center;">科室名称</td>
                              	<td style="text-align:center;">所属月份</td>
                                <td style="text-align:center;">成本类型</td>
                                <td style="text-align:center;">成本金额</td>
                              </tr>
                              <c:forEach var="data" items="${sjbbCbtj }" varStatus="obj">
	                                <tr>
	                                    <td>
	                                        <i class=" icon-tasks"></i>
	                                    </td>
	                                    <td style="text-align:center;">${data.ksmc }</td>
	                                    <td style="text-align:center;">${data.lrrq }</td>		
	                                    <td style="text-align:center;">${data.zdmc }</td>									
	                                    <td style="text-align:center;">${data.je }元</td>
	                                </tr>
                              </c:forEach>
                              </tbody>
                          </table>
                      </section>
                      <!--work progress end-->
                  </div>
              </div>
  </body>
</html>

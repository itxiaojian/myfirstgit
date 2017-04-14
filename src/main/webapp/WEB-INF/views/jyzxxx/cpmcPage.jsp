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

    <title>安徽省质检院综合业务管理平台</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/resources/bootstrap/js/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path%>/resources/bootstrap/js/bootstrap-reset.css" rel="stylesheet">
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
		    width: 120% !important;
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
	</style>
  </head>

  <body class="contentStyle" onload="" >
  <div style="display:none;">
	<ul class="tab-menu tab" id="tabMenuID_">
		<li class="tab-selected" title="信息查询">
		<a href="<%=path%>/jyzxxx/YJyXxcx/XxcxPage" target="content" onfocus="this.blur()"><span>信息查询</span></a>
		</li>
	</ul>
  </div>
 		<section id="container" >
      <!--main content start-->
      <section id="main-content1">
          <section class="wrapper1" style="padding: 0px;">
              <!-- page start-->
              <section class="panel" style="margin-bottom: 0px;">
            <div class="panel-body" style="padding-left: 0px; padding-right: 0px; padding-bottom: 0px;">
            
		              <div class="form-group" style="height: 35px; margin-bottom: 0px;">
		              <label class="col-sm-2 control-label" style="width:6%;top: 6px;">产&nbsp;品&nbsp;类&nbsp;型:</label>
					  <div class="col-sm-10" style="width:16%">
					  <input class="form-control" id="cplx" name="cplx" style="height:28px;width: 100%;margin-left: 10%" value="${cplx }"/>
					  </div>
					  <label class="col-sm-2 control-label" style="width:6%;top: 6px;">产&nbsp;品&nbsp;名&nbsp;称:</label>
					  <div class="col-sm-10" style="width:16%">
					  <input class="form-control" id="cpmc" name="cpmc" style="height:28px;width: 100%;margin-left: 10%" value="${cpmc }"/>
					  </div>
					  <label class="col-sm-2 control-label" style="width:6%;top: 6px;">检&nbsp;验&nbsp;依&nbsp;据:</label>
					  <div class="col-sm-10" style="width:16%">
					  <input class="form-control" id="jyyj" name="jyyj" style="height:28px;width: 100%;margin-left: 10%" value="${jyyj }"/>
					  </div>
					  <label class="col-sm-2 control-label" style="width: 5%;">
							<a class="btn btn-xs btn-success" data-toggle="modal" type="button" onclick="toView();" style="margin-top: 2px; padding-bottom: 3px; padding-top: 3px;">查询</a>
                      </label>
                      <label class="col-sm-2 control-label" style="width: 5%;">
							<a class="btn btn-xs btn-success" data-toggle="modal" type="button" onclick="setValue();" style="margin-top: 2px; padding-bottom: 3px; padding-top: 3px;">清空</a>
                      </label>
                      <label class="col-sm-2 control-label" style="width: 5%;">
                            <a class="btn btn-xs btn-success" data-toggle="modal" type="button" onclick="exit();" style="margin-top: 2px; padding-bottom: 3px; padding-top: 3px;">返回</a>
                      </label>
                      <!-- <label class="col-sm-2 control-label" style="width: 5%;">
                            <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="getExcelValue();" type="button" data-toggle="modal">导出Excel</a>
                      </label> -->
				  </div>
               <div class="tab-content tasi-tab">
                   <div id="Div6" style="overflow: auto; height: 520px; padding-left: 0px; margin-left: 14px; margin-right: 0px; width: 1315px;">
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
			<input type="hidden" id="cplx" name="cplx" value="${cplx}">
		</div>
        </div>
    </div>
    </section>
    </section>
    </section>
    </section>                      
    <!-- js placed at the end of the document so the pages load faster -->
    <!--<script src="js/jquery.js"></script>-->
    <script type="text/javascript" language="javascript" src="<%=path %>/resources/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/resources/bootstrap/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="<%=path %>/resources/bootstrap/js/multiselect.js"></script>
    <script src="<%=path %>/resources/bootstrap/js/multiselect.min.js"></script>
    <script src="<%=path %>/resources/bootstrap/js/prettify.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jyzxxx/cpmcPage.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/index/js/editable-table.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
  	<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
	<script type="text/javascript"> 
		//查询方法
		function toView(){
			var cplx=$("#cplx").val();
			var cpmc=$("#cpmc").val();
			var jyyj=$("#jyyj").val();
 			location.href="XxcxPage1?cplx="+cplx+"&cpmc="+cpmc+"&jyyj="+jyyj;
		}
		
		//返回
		function setValue(){
		     $("#cplx").val("");
		     $("#cpmc").val("");
		     $("#jyyj").val("");
		}		
				
		//返回
		function exit(){
		     window.history.back(-1);
		}
	</script>
  </body>
</html>


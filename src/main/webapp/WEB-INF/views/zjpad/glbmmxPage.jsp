<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
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

    <title>移动质检业务平台</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/resources/index/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=path%>/resources/index/css/bootstrap-reset.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/system/login/css/padstyle.css" />
    <script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js" />
    
    <!--external css-->
    <link href="<%=path%>/resources/index/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="<%=path%>/resources/index/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" 
    type="text/css" media="screen"/>
    <link rel="stylesheet" href="<%=path%>/resources/index/css/owl.carousel.css" type="text/css" />
    <!-- Custom styles for this template -->
    <link href="<%=path%>/resources/index/css/style.css" rel="stylesheet" />
    <link href="<%=path%>/resources/index/css/style-responsive.css" rel="stylesheet" />
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css"/>
    
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css"/>
	
<script>
    function getExcelValue(){
		var ksmc=$('#ksmc').val();
		var bmmc=$('#bmmc').val();
		var cxsjstr=$('#cxsjstr').val();
		var cxsjend=$('#cxsjend').val();
		$.ajax({
            success: function () {
            		if(confirm("确定下载查询结果吗?")){
        				var fileName = cxsjstr+"至"+cxsjend+"期间"+bmmc+"收入明细";
            	    	var url = "exportKssrmx3?fileName="+fileName+"&ksmccx="+ksmc+"&cxsjstr="+cxsjstr+"&cxsjend="+cxsjend;
            	    	url = encodeURI(url);
            	    	url = encodeURI(url);
            	    	window.open(url);
        			}
            }
	   });
	}
</script>   
  </head>

<body style="color: #333;">
<div class="ipad">
    <div class="ZJ_top">
        <span id="L_btn"></span>
        <span>移动质检业务管理平台</span>
        <span></span>
        <span><img src="<%=path%>/system/layout/img/top_02.png"/>欢迎您：${sessionScope['LOGIN_USER'].xm}&nbsp;&nbsp;</span>
    </div>
    <div class="ZJ_mian">
        <div class="ZJ_mian_left" id="left_nav">
        	<ul>
            </ul>
        </div>
        <div class="ZJ_mian_right" id="main_R">
<div class="panel-body" style="width:100%">
        <div class="col-lg-12">
            <section class="panel" style="margin-bottom: 0px;">
            <div class="panel-body" style="border-color:#fff;padding-bottom: 0px;"> 
                               <div class="form-group"> 
                                  <c:forEach var="data" items="${bmmc}" varStatus="obj">
                                  <h1 style="font-size: 24px;">${cxsjstr}至${cxsjend}期间${data.bmmc}收入明细一览：</h1>
                                  <input type="hidden" class="hidden" id="ksmc" name="ksmc" value="${ksmccx}"/>
                                  <input type="hidden" class="hidden" id="bmmc" name="bmmc" value="${data.bmmc}"/>
                                  <input type="hidden" class="hidden" id="cxsjstr" name="cxsjstr" value="${cxsjstr}"/>
                                  <input type="hidden" class="hidden" id="cxsjend" name="cxsjend" value="${cxsjend}"/>
                                  </c:forEach> 
                                  <p></p> 
                               </div> 
                          <table class="table table-hover personal-task table-striped table-bordered" >
                           <thead>
                              <tr>
                                <td>部门名称</td>
                              	<td>金额</td>
                                <td>收费时间</td>
                                <td>发票号</td>
                                <td>收费项目</td>
                                <td>备注</td>
                              </tr>
                           </thead>
                           <tbody>
                              <c:forEach var="data" items="${glbmsfmx}" varStatus="obj">
	                                <tr>
	                                    <td>${data.bmmc}</td>
	                                    <td>${data.sfje}</td>
	                                    <td>${data.sfrq}</td>
	                                    <td>${data.fphm}</td>
	                                    <td>${data.srfl}</td>
	                                    <td>${data.bz}</td>
	                                </tr>
                              </c:forEach>
                            </tbody>
                          </table>
                          </div> 
                      </section>
                      <!--work progress end-->
                  </div>
              </div>
              </div>
              </div>
              <div class="foot">安徽省产品质量监督检查研究院  皖ICP备08001861号-1  地址：合肥市包河工业园延安路13号  邮政编码：230051  电话：0551-63356268  63855622</div>
              </div>
              
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/index/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/index/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/index/js/editable-table.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery.easyui.min.js"></script>
	
  </body>
  
	<style>
			.form-control1 {
			background-color: #fff;
		    border: 1px solid #ccc;
		    border-radius: 4px;
		    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
		    color: #555;
		    display: block;
		    font-size: 12px;
		    height: 30px;
		    line-height: 1.42857;
		    padding: 5px 4px;
		    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
		    vertical-align: middle;
		    width: 100%;
		}
		    .form-control {
			background-color: #fff;
		    border: 1px solid #ccc;
		    border-radius: 4px;
		    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
		    color: #555;
		    display: block;
		    font-size: 12px;
		    height: 30px;
		    line-height: 1.42857;
		    padding: 6px 6px;
		    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
		    vertical-align: middle;
		    width: 100%;
		}
		.table > thead > tr > th, .table > tbody > tr > th, .table > tfoot > tr > th, .table > thead > tr > td, .table > tbody > tr > td, .table > tfoot > tr > td {
		    border-top: 1px solid #ddd;
		    line-height: 1.42857;
		    padding: 2px;
		    vertical-align: top;
		}
		.table-bordered > thead > tr > th, .table-bordered > thead > tr > td {
		    border-bottom-width: 1px;
		}
		table td {
		    white-space: nowrap;
		}
		.btn {
	        font-size: 11px;
	    }
	    .form-group h1 {
		    color: #39b5aa;
		    font-size: 18px;
		    font-weight: 400;
		    margin: 0;
		    padding: 0;
		}
		</style>
  
</html>

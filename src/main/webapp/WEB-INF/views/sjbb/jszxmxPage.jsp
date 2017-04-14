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
			var px=$('#px').val();
			$.ajax({
	            success: function () {
	            		if(confirm("确定下载查询结果吗?")){
	        				var fileName = cxsjstr+"至"+cxsjend+"期间"+bmmc+"收入明细";
	            	    	var url = "exportKssrmx1?fileName="+fileName+"&ksmccx="+ksmc+"&cxsjstr="+cxsjstr+"&cxsjend="+cxsjend+"&px="+px;
	            	    	url = encodeURI(url);
	            	    	url = encodeURI(url);
	            	    	window.open(url);
	        			}
	            }
		   });
		}
	    
	    function getExcelValue1(){
			var ksmc=$('#ksmc').val();
			var bmmc=$('#bmmc').val();
			var cxsjstr=$('#cxsjstr').val();
			var cxsjend=$('#cxsjend').val();
			var px=$('#px').val();
			$.ajax({
	            success: function () {
	            		if(confirm("确定下载查询结果吗?")){
	        				var fileName = cxsjstr+"至"+cxsjend+"期间"+bmmc+"收入明细";
	            	    	var url = "exportKssrmx2?fileName="+fileName+"&ksmccx="+ksmc+"&cxsjstr="+cxsjstr+"&cxsjend="+cxsjend+"&px="+px;
	            	    	url = encodeURI(url);
	            	    	url = encodeURI(url);
	            	    	window.open(url);
	        			}
	            }
		   });
		}
	    
	    function getExcelValue2(){
			var ksmc=$('#ksmc').val();
			var bmmc=$('#bmmc').val();
			var cxsjstr=$('#cxsjstr').val();
			var cxsjend=$('#cxsjend').val();
			var px=$('#px').val();
			$.ajax({
	            success: function () {
	            		if(confirm("确定下载查询结果吗?")){
	        				var fileName = cxsjstr+"至"+cxsjend+"期间"+bmmc+"内委收入明细";
	            	    	var url = "exportKssrmx4?fileName="+fileName+"&ksmccx="+ksmc+"&cxsjstr="+cxsjstr+"&cxsjend="+cxsjend+"&px="+px;
	            	    	url = encodeURI(url);
	            	    	url = encodeURI(url);
	            	    	window.open(url);
	        			}
	            }
		   });
		}
	</script>  
  </head>
<body>
<div class="panel-body">
        <div class="col-lg-12">
            <section class="panel" style="margin-bottom: 0px;">
            <div class="panel-body" style="border-color:#fff;padding-bottom: 0px;"> 
                               <div class="task-progress"> 
                                  <c:forEach var="data" items="${bmmc}" varStatus="obj">
                                  <h1>${cxsjstr}至${cxsjend}期间${data.bmmc}收入明细一览：</h1>
                                  <input type="hidden" class="hidden" id="ksmc" name="ksmc" value="${ksmccx}"/>
                                  <input type="hidden" class="hidden" id="bmmc" name="bmmc" value="${data.bmmc}"/>
                                  <input type="hidden" class="hidden" id="cxsjstr" name="cxsjstr" value="${cxsjstr}"/>
                                  <input type="hidden" class="hidden" id="cxsjend" name="cxsjend" value="${cxsjend}"/>
                                  <input type="hidden" class="hidden" id="px" name="px" value="${px}"/>
                                  </c:forEach> 
                                  <p></p> 
                               </div> 
                           </div>
                <header class="panel-heading tab-bg-dark-navy-blue" >
                    <ul class="nav nav-tabs nav-justified ">
                        <li class="active" >
                            <a href="#popular" data-toggle="tab">检验报告</a>
                        </li>
                        <li>
                            <a href="#comments" data-toggle="tab">技术服务</a>
                        </li>
                        <li>
                            <a href="#kobe" data-toggle="tab" >
                                	院内委托
                            </a>
                        </li>
                    </ul>
                </header>
                <div class="panel-body">
                    <div class="tab-content tasi-tab">
                        <div class="tab-pane active" id="popular">                          
                          <div>
                          	  <label class="col-sm-2 control-label">
                                 <button type="button" class="btn btn-success" onclick="getExcelValue();">导出Excel</button>
                              </label>
                          </div>  
                          <table class="table table-hover personal-task table-striped table-bordered" >
                           <thead>
                              <tr>
                                <td>检验报告编号</td>
                              	<td>样品名称</td>
                              	<td>检验科室</td>
                              	<td>检验费用</td>
                                <td>本次实收</td>
                                <td>收费时间</td>
                                <td>检验类别</td>
                                <td>委托单位</td>
                                <td>编制人</td>
                                <td>审核人</td>
                              </tr>
                           </thead>
                           <tbody>
                              <c:forEach var="data" items="${jszxbgsfmx}" varStatus="obj">
	                                <tr>
	                                    <td>${data.bgbh}</td>
	                                    <td>${data.ypmc}</td>
	                                    <td>${data.bmmc}</td>
	                                    <c:if test="${data.jyfy>0}"><td>${data.jyfy}</td></c:if>
	                                    <c:if test="${data.jyfy<0}"><td>${0-data.jyfy}</td></c:if>
	                                    <td>${data.ysfje}</td>
	                                    <td>${data.jyjsrq}</td>
	                                    <td>${data.jylx}</td>
	                                    <td>${data.wtdw}</td>
	                                    <td>${data.xm}</td>
	                                    <td>${data.bsdx}</td>
	                                </tr>
                              </c:forEach>
                            </tbody>
                          </table> 
                          </div>
                          
                        <div class="tab-pane" id="comments">
                          <label class="col-sm-2 control-label" >
                               <button type="button" class="btn btn-success" onclick="getExcelValue1();">导出Excel</button>
                          </label>
                          <table class="table table-hover personal-task table-striped table-bordered" >
                           <thead>
                              <tr>
                                <td>协议编号</td>
                                <td>检验科室</td>
                              	<td>客户名称</td>
                              	<td>协议金额</td>
                                <td>本次实收</td>
                                <td>收费时间</td>
                              </tr>
                           </thead>
                           <tbody>
                              <c:forEach var="data" items="${jszxxysfmx}" varStatus="obj">
	                                <tr>
	                                    <td>${data.xybh}</td>
	                                    <td>${data.bmmc}</td>
	                                    <td>${data.khmc}</td>
	                                    <c:if test="${data.xyje>0}"><td>${data.xyje}</td></c:if>
	                                    <c:if test="${data.xyje<0}"><td>${0-data.xyje}</td></c:if>
	                                    <td>${data.bcss}</td>
	                                    <td>${data.sfrq}</td>
	                                </tr>
                              </c:forEach>
                            </tbody>
                          </table> 
                          </div>
                          
                           <div class="tab-pane" id="kobe">  
                          <div>
                          	  <label class="col-sm-2 control-label">
                                 <button type="button" class="btn btn-success" onclick="getExcelValue2();">导出Excel</button>
                              </label>
                          </div>  	                        
                          <table class="table table-hover personal-task table-striped table-bordered" >
                           <thead>
                              <tr>
                                <td>检验报告编号</td>
                              	<td>样品名称</td>
                              	<td>检验项目</td>
                                <td>检验费用</td>
                                <td>委托部门</td>
                                <td>委托时间</td>
                                <td>承检部门</td>
                                <td>经办人</td>
                                <td>接收人</td>
                              </tr>
                           </thead>
                           <tbody>
                              <c:forEach var="data" items="${jszxnwmx}" varStatus="obj">
	                                <tr>
	                                    <td>${data.bgbh}</td>
	                                    <td>${data.ypmc}</td>
	                                    <td>${data.jyxm}</td>
	                                    <td>${data.jyfy}</td>
	                                    <td>${data.wtbm}</td>
	                                    <td>${data.wtrq}</td>
	                                    <td>${data.cjbm}</td>
	                                    <td>${data.jbr}</td>
	                                    <td>${data.jsr}</td>
	                                </tr>
                              </c:forEach>
                            </tbody>
                          </table> 
                          </div>
                        
                        </div>
                        </div>
                      </section>
                      <!--work progress end-->
                  </div>
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
		</style>
  
</html>

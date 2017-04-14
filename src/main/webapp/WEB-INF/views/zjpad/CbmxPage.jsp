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
    
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css"/>
	
    <script>
	    function getExcelValue(){
			var ksmc=$('#ksmc').val();
			var bmmc=$('#bmmc').val();
			var ksyf=$('#ksyf').val();
			var jsyf=$('#jsyf').val();
			$.ajax({
	            success: function () {
	            		if(confirm("确定下载查询结果吗?")){
	            			var fileName = bmmc+ksyf+"至"+jsyf+"期间成本明细";
	            	    	var url = "exportCbtjmx?fileName="+fileName+"&ksmc="+ksmc+"&ksyf="+ksyf+"&jsyf="+jsyf;
	            	    	url = encodeURI(url);
	            	    	url = encodeURI(url);
	            	    	window.open(url);
	        			}
	            }
		   });
		}
	</script>
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
		</style>   
  </head>

<body style="color: #333;">
      <!--main content start-->
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
        	    <a href="<%=path%>/system/layout/main1.jsp"><li><img src="<%=path%>/system/layout/img/L_01.png">&nbsp;&nbsp;平台首页</li></a>
                <a href="<%=path%>/ZjPad/CydjPage"><li><img src="<%=path%>/system/layout/img/L_02.png">&nbsp;&nbsp;抽样登记</li></a>
                <a href="<%=path%>/ZjPad/ZxxxList"><li><img src="<%=path%>/system/layout/img/L_03.png">&nbsp;&nbsp;检验咨询</li></a>
                <a href="<%=path%>/ZjPad/ypcxPage"><li><img src="<%=path%>/system/layout/img/L_04.png">&nbsp;&nbsp;样品查询</li></a>
                <a href="<%=path%>/ZjPad/bgcxPage"><li><img src="<%=path%>/system/layout/img/L_05.png">&nbsp;&nbsp;报告查询</li></a>
                <a href="<%=path%>/ZjPad/bgshlist?ypcs=2"><li><img src="<%=path%>/system/layout/img/L_06.png">&nbsp;&nbsp;报告审核</li></a>
                <a href="<%=path%>/ZjPad/bgshlist?ypcs=3"><li><img src="<%=path%>/system/layout/img/L_07.png">&nbsp;&nbsp;报告批准</li></a>
                <a href="<%=path%>/ZjPad/warnPage"><li><img src="<%=path%>/system/layout/img/L_08.png">&nbsp;&nbsp;报告预警</li></a>
<%--                 <a href="<%=path%>/ypgl/YYpYj/ypyjPage;"><li><img src="<%=path%>/system/layout/img/L_09.png">&nbsp;&nbsp;样品移交</li></a> --%>
                <a href="<%=path%>/ZjPad/sbcxPage"><li><img src="<%=path%>/system/layout/img/L_11.png">&nbsp;&nbsp;设备查询</li></a>
                <a href="<%=path%>/ZjPad/tjtbPage"><li><img src="<%=path%>/system/layout/img/L_12.png">&nbsp;&nbsp;统计图表</li></a>
                <a href="<%=path%>/ZjPad/tjbbPage"><li><img src="<%=path%>/system/layout/img/L_12.png"/>&nbsp;&nbsp;统计报表</li></a>
            </ul>
        </div>
        <div class="ZJ_mian_right" id="main_R">
              <div class="row">
                  <div class="col-lg-19">
                      <!--work progress start-->
                      
                          <div class="panel-body" style="border-color:#fff;">
                              <div class="task-progress">
                              <c:forEach var="data" items="${bmmc}" varStatus="obj">
                                  <h1 style="font-size: 24px;">${data.bmmc}${ksyf}至${jsyf}期间成本明细一览：</h1>
                                  <input type="hidden" class="hidden" id="ksmc" name="ksmc" value="${ksmccx}"/>
                                  <input type="hidden" class="hidden" id="bmmc" name="bmmc" value="${data.bmmc}"/>
                                  <input type="hidden" class="hidden" id="ksyf" name="ksyf" value="${ksyf}"/>
                                  <input type="hidden" class="hidden" id="jsyf" name="jsyf" value="${jsyf}"/>
                               </c:forEach>
                                  <p></p>
                              </div>
                          </div>
                          <table class="table table-hover personal-task table-striped table-bordered" id="table" >
                           <thead>
                              <tr>
                              	<td style="text-align:center;"><b>科目</b></td>
                              	<td style="text-align:center;"><b>发生时间</b></td>
                              	<td style="text-align:center;"><b>凭证代码</b></td>
                                <td style="text-align:center;"><b>摘要</b></td>
                                <td style="text-align:center;"><b>金额</b></td>
                              </tr>
                           </thead>
                           <tbody>
                                   <c:forEach var="data" items="${cbmx}" varStatus="obj">
	                                <tr rowspan="${data.fylx}">
	                                    <td style="text-align:center;vertical-align:middle;">${data.fylx}</td>
	                                    <td style="text-align:center;vertical-align:middle;">${data.fssj}</td>
	                                    <td style="text-align:center;vertical-align:middle;">${data.pjbh}</td>
	                                    <td style="text-align:center;">${data.fyxq}</td>
	                                    <td style="text-align:center;">${data.je}</td>
	                                </tr>
	                                </c:forEach>
                            </tbody>
                          </table>
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
			    <script type="text/javascript">
			    	      var tab = document.getElementById("table");
			       		  var maxCol = 1, val, count, start;
		
			       		  for(var col = maxCol-1; col >= 0 ; col--){
			       			  count = 1;
			       			  val = "";
			       			  for(var i=0; i<tab.rows.length; i++){
			       				  if(val == tab.rows[i].cells[col].innerHTML){
			       					  count++;
			       				  }else{
			       					  if(count > 1){ //合并
			       						  start = i - count;
			       						  tab.rows[start].cells[col].rowSpan = count;
			       						  for(var j=start+1; j<i; j++){
			       							  tab.rows[j].cells[col].style.display = "none";
			       						  }
			       						  count = 1;
			       					  }
			       					  val = tab.rows[i].cells[col].innerHTML;
			       				  }
			       			  }
			       			  if(count > 1 ){ //合并，最后几行相同的情况下
			       				  start = i - count;
			       				  tab.rows[start].cells[col].rowSpan = count;
			       				  for(var j=start+1; j<i; j++){
			       					  tab.rows[j].cells[col].style.display = "none";
			       				  }
			       			  }
			       		  }
		  </script>
  </body>
</html>

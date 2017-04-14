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
    <script type="text/javascript">var PATH = '<%=path%>';</script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="" />
    <meta name="author" content="Mosaddek" />
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina" />
    <link rel="shortcut icon" href="<%=path%>/resources/index/img/favicon.png" />

    <title>移动质检业务平台</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/resources/index/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=path%>/resources/index/css/bootstrap-reset.css" rel="stylesheet" />
    <!--external css-->
    <link href="<%=path%>/resources/index/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="<%=path%>/resources/bootstrap/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="<%=path%>/resources/index/css/owl.carousel.css" type="text/css" />
    <!-- Custom styles for this template -->
    <link href="<%=path%>/resources/index/css/style.css" rel="stylesheet" />
    <link href="<%=path%>/resources/index/css/style-responsive.css" rel="stylesheet" />
    
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/system/login/css/padstyle.css" />
    <script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js" />
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/index/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/index/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/index/js/editable-table.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery.easyui.min.js"></script>  
    <script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
	<script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
    
    <script>
	function load() {
		 var url = "<%=path%>/sjbb/Ygfltj/getYgflhz";
		 //var ksmc = document.getElementById("ksmc").value;
		 var ksmc = "";
         var ssyf = document.getElementById("yf").value;
		 $.ajax({
             cache: true,
             type: "POST",
             url: url,
             data: {ksmc: ksmc, ssyf: ssyf},
             async: false,
             error: function (request) {
                 alert("查询失败,请联系管理员。");
             },
             success: function (data) {
            	var del = $("#table");
     			del.remove();
             	var str="<table><thead><tr>"
                  	+"<td style='width: 10%;padding-left: 30px;'bgcolor='#32a9eb'><b>科室</b></td>"
                  	+"<td style='text-align:center;'bgcolor='#32a9eb'><b>所属月份</b></td>"
                  	+"<td style='text-align:center;'bgcolor='#32a9eb'><b>基本工资</b></td>"
                  	+"<td style='text-align:center;'bgcolor='#32a9eb'><b>岗位绩效工资</b></td>"
                    +"<td style='text-align:center;'bgcolor='#32a9eb'><b>积分绩效工资</b></td>"
                    +"<td style='text-align:center;'bgcolor='#32a9eb'><b>业务绩效工资</b></td>"
                    +"<td style='text-align:center;'bgcolor='#32a9eb'><b>社会保险费</b></td>"
                    +"<td style='text-align:center;'bgcolor='#32a9eb'><b>公积金</b></td>"
                    +"<td style='text-align:center;'bgcolor='#32a9eb'><b>...</b></td>"
                    +"<td style='text-align:center;'bgcolor='#32a9eb'><b>合计</b></td>"
                    +"</tr></thead><tbody>";
             	for(var i=0;i<data.length;i++){
             		str=str+"<tr>"
             		+"<td style='padding-left: 38px;'><a onclick='ckmx("+data[i].KS_ID+")' class='btn btn-xs btn-sucess'>"+ data[i].BMMC+"</a></td>"	
             		+"<td style='text-align:center;'>"+data[i].SSYF+"</td>"	
             		+"<td style='text-align:center;'>"+data[i].GZ+"</td>"
             		+"<td style='text-align:center;'>"+data[i].GWJXGZ+"</td>"
             		+"<td style='text-align:center;'>"+data[i].JFJXGZ+"</td>"
             		+"<td style='text-align:center;'>"+data[i].DBJ+"</td>"
             		+"<td style='text-align:center;'>"+data[i].SHBYF+"</td>"
             		+"<td style='text-align:center;'>"+data[i].GJJ+"</td>"
             		+"<td style='text-align:center;'>...</td>"
             		+"<td style='text-align:center;'>"+data[i].HJ+"</td>"
                    +"</tr>";
             	} 
             	str=str+"</tbody><table>";
             	 var oTest = document.getElementById("Div1");
                 var newNode = document.createElement("table");
                 newNode.setAttribute('class', 'table table-hover personal-task table-striped table-bordered');
                 newNode.setAttribute('id', 'table');
                 newNode.innerHTML = str;
                 oTest.insertBefore(newNode, null);
            	 
             }
		 });
	}
	
	function ckmx(ksmccx) {
        var ssyfcx = document.getElementById("yf").value;
		window.open('YgflmxPage?ksmccx='+ksmccx+'&ssyfcx='+ssyfcx,'样品标签','height=400px, width=1000px,top=200px, left=300px, toolbar=no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no');
	}
	
	function getExcelValue(){
		var ksmc = "";
		var ssyf=$('#yf').val();
		$.ajax({
            success: function () {
            		if(confirm("确定下载查询结果吗?")){
        				var fileName = ssyf+"月份工资薪金汇总";
            	    	var url = "exportYgfl?fileName="+fileName+"&ksmc="+ksmc+"&ssyf="+ssyf;
            	    	url = encodeURI(url);
            	    	url = encodeURI(url);
            	    	window.open(url);
        			}
            }
	   });
	}
	
	function back(){
			window.history.back(-1);
}
	
	function exit(){
// 		success: function () {
	       msg="确定退出？";
       		if(confirm(msg)){
       			location.href="<%=path%>/j_spring_security_logout"
   			}
// 		}
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
		</style>
  </head>
<body onload="load();" style="color: #333;">
 <div class="ipad">
    <div class="ZJ_top">
        <span id="L_btn"></span>
        <span>移动质检业务管理平台</span>
        <span><a onclick="exit();"><img src="<%=path%>/system/layout/img/top_03.png"/></a></span>
        <span><img src="<%=path%>/system/layout/img/top_02.png"/>欢迎您：${sessionScope['LOGIN_USER'].xm}&nbsp;&nbsp;</span>
    </div>
    <div class="ZJ_mian">
        <div class="ZJ_mian_left" id="left_nav">
        	<ul>
            </ul>
        </div>
        <div class="ZJ_mian_right" id="main_R">
      <!--main content start-->
              <div class="row" style="width: 100%;">
                  <div class="col-lg-19" style="margin-left: 5px; width: 100%;">
                      <!--work progress start-->
                          <div class="form-group" style="height: 35px; margin-bottom: 0px;margin-left: 60px;">
			                  <label class="col-sm-2 control-label" style="width:6%;top: 6px;">月&nbsp;&nbsp;份:</label>
							  <div class="col-sm-10" style="width:16%">
							  <% Date date = new Date();
							     SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM");
							     String strdate = sdate.format(date); %>
							  <input id="yf" name="yf" value="<%=strdate%>" style="height:28px;width: 100%;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width: 5%;">
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="load();" type="button" data-toggle="modal">查询</a>
                              </label>
                              <label class="col-sm-2 control-label" style="width: 5%;">
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="back();" type="button" data-toggle="modal">返回</a>
                              </label>
						  </div>
						  <div id="Div1" name="Div1" style="display:'none'"></div>
                      <!--work progress end-->
                  </div>
              </div>
              </div>
              </div>
              <div class="foot">安徽省产品质量监督检查研究院  皖ICP备08001861号-1  地址：合肥市包河工业园延安路13号  邮政编码：230051  电话：0551-63356268  63855622</div>
              </div>
  </body>
</html>
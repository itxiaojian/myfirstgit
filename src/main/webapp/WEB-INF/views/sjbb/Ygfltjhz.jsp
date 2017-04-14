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

    <title>安徽省质检院综合业务管理平台</title>

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
    
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
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
                  	+"<td style='width: 10%;'><b>科室</b></td>"
                  	+"<td style='text-align:center;'><b>所属月份</b></td>"
                  	+"<td style='text-align:center;'><b>基本工资</b></td>"
                  	+"<td style='text-align:center;'><b>岗位绩效工资</b></td>"
                    +"<td style='text-align:center;'><b>积分绩效工资</b></td>"
                    +"<td style='text-align:center;'><b>业务绩效工资</b></td>"
                    +"<td style='text-align:center;'><b>社会保险费</b></td>"
                    +"<td style='text-align:center;'><b>公积金</b></td>"
                    +"<td style='text-align:center;'><b>交通费</b></td>"
                    +"<td style='text-align:center;'><b>通讯费</b></td>"
                    +"<td style='text-align:center;'><b>误餐费</b></td>"
                    +"<td style='text-align:center;'><b>其他</b></td>"
                    +"<td style='text-align:center;'><b>合计</b></td>"
                    +"</tr></thead><tbody>";
             	for(var i=0;i<data.length;i++){
             		if(data[i].KS_ID=='100110'||data[i].KS_ID=='100130'||data[i].KS_ID=='100210'||data[i].KS_ID=='100220'||data[i].KS_ID=='100260'||data[i].KS_ID=='100270'||data[i].KS_ID=='100280'||data[i].KS_ID=='100250'||data[i].KS_ID=='100240'||data[i].KS_ID=='100230'){
             			str=str+"<tr style='color:green'>"
                 		+"<td style='text-align:left;vertical-align: middle;'><a onclick='ckmx("+data[i].KS_ID+")' style='color:green' class='btn btn-xs btn-sucess'><b>"+ data[i].BMMC+"</b></a></td>"	
                 		+"<td style='text-align:center;'><b>"+data[i].SSYF+"</b></td>"	
                 		+"<td style='text-align:center;'><b>"+data[i].GZ+"</b></td>"
                 		+"<td style='text-align:center;'><b>"+data[i].GWJXGZ+"</b></td>"
                 		+"<td style='text-align:center;'><b>"+data[i].JFJXGZ+"</b></td>"
                 		+"<td style='text-align:center;'><b>"+data[i].DBJ+"</b></td>"
                 		+"<td style='text-align:center;'><b>"+data[i].SHBYF+"</b></td>"
                 		+"<td style='text-align:center;'><b>"+data[i].GJJ+"</b></td>"
                 		+"<td style='text-align:center;'><b>"+data[i].JTFF+"</b></td>"
                 		+"<td style='text-align:center;'><b>"+data[i].TXF+"</b></td>"
                 		+"<td style='text-align:center;'><b>"+data[i].WCF+"</b></td>"
                 		+"<td style='text-align:center;'><b>"+data[i].QTFL+"</b></td>"
                 		+"<td style='text-align:center;'><b>"+data[i].HJ+"</b></td>"
                        +"</tr>";
             		}else{
             		str=str+"<tr>"
             		+"<td><a onclick='ckmx("+data[i].KS_ID+")' class='btn btn-xs btn-sucess'>"+ data[i].BMMC+"</a></td>"	
             		+"<td style='text-align:center;'>"+data[i].SSYF+"</td>"	
             		+"<td style='text-align:center;'>"+data[i].GZ+"</td>"
             		+"<td style='text-align:center;'>"+data[i].GWJXGZ+"</td>"
             		+"<td style='text-align:center;'>"+data[i].JFJXGZ+"</td>"
             		+"<td style='text-align:center;'>"+data[i].DBJ+"</td>"
             		+"<td style='text-align:center;'>"+data[i].SHBYF+"</td>"
             		+"<td style='text-align:center;'>"+data[i].GJJ+"</td>"
             		+"<td style='text-align:center;'>"+data[i].JTFF+"</td>"
             		+"<td style='text-align:center;'>"+data[i].TXF+"</td>"
             		+"<td style='text-align:center;'>"+data[i].WCF+"</td>"
             		+"<td style='text-align:center;'>"+data[i].QTFL+"</td>"
             		+"<td style='text-align:center;'>"+data[i].HJ+"</td>"
                    +"</tr>";
             		}
               			
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
</script> 
  </head>

  <body onload="load();" style="color: #333;">
<div style="display:none;">
    <ul class="tab-menu tab" id="tabMenuID_">
        <li class="tab-selected" title="工资薪金统计">
            <a href="<%=path%>/sjbb/Ygfltj/FltjhzPage" target="content" onfocus="this.blur()"><span>工资薪金统计</span></a>
        </li>
    </ul>
</div>
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <div class="row">
                  <div class="col-lg-19" style="margin-left: 5px; width: 100%;">
                      <!--work progress start-->
                      <section class="panel">
                          <div class="panel-body" style="border-color:#fff;">
                              <div class="task-progress">
                                  <h1>各科室工资薪金汇总：</h1>
                                  <p></p>
                              </div>
                              
                          </div>
                          <div class="form-group" style="height: 35px; margin-bottom: 0px;">
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
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="getExcelValue();" type="button" data-toggle="modal">导出Excel</a>
                              </label>
						  </div>
						  <div id="Div1" name="Div1" style="display:'none'"></div>
                      </section>
                      <!--work progress end-->
                  </div>
              </div>
        
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
		</style>
  
</html>

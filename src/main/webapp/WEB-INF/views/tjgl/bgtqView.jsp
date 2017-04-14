<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<%  String path = request.getContextPath();%>
<html lang="en" style="overflow: hidden;">
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
		 var url = "<%=path%>/tjgl/bgcx/getBgyq";
		 var ksmc = document.getElementById("ksmc").value;
         var ksyf = document.getElementById("ksyf").value;
         var jsyf = document.getElementById("jsyf").value;
         if(ksyf==null || ksyf=="" || jsyf==null || jsyf==""){
        	 alert("请选择查询时间！");
        	 return false;
         }
//          if(ksmc==''&&ssyf==''){
//         	 alert('请至少添加一个条件查询');
//         	 return false;
//          }
		 $.ajax({
             cache: true,
             type: "POST",
             url: url,
             data: {ksmc: ksmc, ksyf: ksyf,jsyf:jsyf},
             async: false,
             error: function (request) {
                 alert("查询失败,请联系管理员。");
             },
             success: function (data) {
            	var del = $("#table");
     			del.remove();
             	var str="<table>"
//              	<thead><tr>"
//                   	+"<td width:10%;'><b>检验报告编号</b></td>"
//                   	+"<td style='width: 142px;'><b>主检科室</b></td>"
//                   	+"<td style='width: 200px;'><b>样品名称</b></td>"
//                   	+"<td style='width: 48px;'><b>编制人</b></td>"
//                   	+"<td style='width: 90px;'><b>样品登记日期</b></td>"
//                   	+"<td style='width: 90px;'><b>审核日期</b></td>"
//                   	+"<td style='width: 90px;'><b>接收日期</b></td>"
//                   	+"<td style='width: 90px;'><b>发放日期</b></td>"
//                   	+"<td style='width: 116px;'><b>检验类别</b></td>"
//                   	+"<td style='width: 90px;'><b>完成期限</b></td>"
//                   	+"<td style='width: 90px;'><b>批准日期</b></td>"
//                     +"<td><b>拖期天数</b></td>"
//                     +"</tr></thead>
                    +"<tbody>";
             	for(var i=0;i<data.length;i++){
           			str=str+"<tr>"
           			+"<td style='width: 10%;'>"+data[i].YPBH+"</td>"
             		+"<td style='width: 142px;'>"+data[i].JYKS+"</td>"
             		+"<td style='width: 200px;'>"+data[i].YPMC+"</td>"
             		+"<td style='width: 48px;'>"+data[i].BZR+"</td>"
             		+"<td style='width: 90px;'>"+data[i].DJSJ+"</td>"
                    +"<td style='width: 90px;'>"+data[i].BPSJ+"</td>"
                    +"<td style='width: 90px;'>"+data[i].JSSJ+"</td>"
                    +"<td style='width: 90px;'>"+data[i].FFRQ+"</td>"
                    +"<td style='width: 116px;'>"+data[i].JYLX+"</td>"
                    +"<td style='width: 90px;'>"+data[i].WCQX+"</td>"
                    +"<td style='width: 90px;'>"+data[i].PZSJ+"</td>"
                    +"<td>"+data[i].TQTS+"</td>"
                    +"</tr>";
             	} 
             	str=str+"</tbody><table>";
             	 var oTest = document.getElementById("Div1");
                 var newNode = document.createElement("table");
                 newNode.setAttribute('class', 'table table-hover personal-task table-striped table-bordered');
                 newNode.setAttribute('id', 'table');
                 newNode.innerHTML = str;
                 oTest.insertBefore(newNode, null);
//                  if(data.length > 0){
			        	creatDiv(data);
// 			        }
             }
		 });
	}
	
	function creatDiv(data){
		var del1 = $("#Div2");
		del1.remove();
		var html="";
		if(data.length>0){
		html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-bottom: 0px; padding-top: 0px;'>统计结果共 "+data[0].COUNT+" 条</div>"
		+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-bottom: 0px; padding-top: 0px;'>";
		}else{
			html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-bottom: 0px; padding-top: 0px;'>统计结果共 0 条</div>"
			+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-bottom: 0px; padding-top: 0px;'>";
		}
		html=html+"</div>";
		var oTest1 = document.getElementById("Div3");
		var newNode1 = document.createElement("div");
		newNode1.setAttribute('class', 'Div2');
		newNode1.setAttribute('id', 'Div2');
		newNode1.innerHTML = html;
		oTest1.insertBefore(newNode1, null);
	}
	
	function isNull(string){
		if(string!=0||string!=''){
// 			alert(string);
// 			alert(string.toString().lastIndexOf('.'));
             if(string.toString().lastIndexOf('.')>0){
//             	 return string.toString().substring(0,string.toString().lastIndexOf('.')+3) 
            	 return string.toFixed(2)
             }else return string.toFixed(2)
		}else{
			return string
		}
	}
	
	function ckmx(ksmccx) {
		//var ksmccx = document.getElementById("ksmc").value;
        var ksyf = document.getElementById("ksyf").value;
        var jsyf = document.getElementById("jsyf").value;
		window.open('CbmxPage?ksmccx='+ksmccx+'&ksyf='+ksyf+'&jsyf='+jsyf,'成本明细标签','height=400px, width=1000px,top=200px, left=300px, toolbar=no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no');
	}
	
	function getExcelValue(){
		var ksmc=$('#ksmc').val();
		var ksyf = document.getElementById("ksyf").value;
        var jsyf = document.getElementById("jsyf").value;
		$.ajax({
            success: function () {
            		if(confirm("确定下载查询结果吗?")){
        				var fileName = ksyf+"至"+jsyf+"报告拖期统计表";
            	    	var url = "exportBgtq?fileName="+fileName+"&ksmc="+ksmc+"&ksyf="+ksyf+"&jsyf="+jsyf;
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
        <li class="tab-selected" title="报告拖期查询">
            <a href="<%=path%>/tjgl/bgcx/opentqPage" target="content" onfocus="this.blur()"><span>报告拖期查询</span></a>
        </li>
    </ul>
</div>
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <div class="row">
                  <div class="col-lg-19" style="margin-left: 5px; width: 100%;">
                      <!--work progress start-->
                      <section class="panel" style="width: 100%">
                          <div class="panel-body" style="border-color:#fff;">
                          </div>
                          <div class="form-group" style="height: 35px; margin-bottom: 0px;">
	                          <label class="col-sm-2 control-label" style="width: 6%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">主检科室:</label>
							  <div class="col-sm-10" style="width:15%;padding-left: 0px;">
							   <select class="form-control1 m-bot15" name="ksmc" id="ksmc" style="height: 27px;">
							            <option selected="selected" value="">请选择...</option>
								<c:forEach var="ksmc" items="${ksmc}" varStatus="obj">
										<option value="${ksmc.id}">${ksmc.bmmc}</option>
								</c:forEach>
					           </select>
							  </div>
			                  <label class="col-sm-2 control-label" style="width:17%;top: 6px;">统计时间（以批准日期为准）从:</label>
							  <div class="col-sm-10" style="width:15%">
							  <% Date date = new Date();
 							     SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-01"); 
 							     String strdate = sdate.format(date);
 							     SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-dd");
 							     String enddate = edate.format(date);%> 
							  <input id="ksyf" name="ksyf" value="<%=strdate%>" style="height:28px;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width:6%;top: 6px;">到:</label>
							  <div class="col-sm-10" style="width:15%">
							  <input id="jsyf" name="jsyf" value="<%=enddate%>" style="height:28px;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width: 5%;">
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="load();" type="button" data-toggle="modal">查询</a>
                              </label>
                              <label class="col-sm-2 control-label" style="width: 5%;">
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="getExcelValue();" type="button" data-toggle="modal">导出Excel</a>
                              </label>
						  </div>
						  </div>
						  <div id="Div3"></div>
						  <div id="Div2" name="Div1" class="Div2"></div>
						  <br></br>
						  <table style="margin-left: 4px;"><thead><tr>
                  	      <td style="width: 10%;"><b>检验报告编号</b></td>
                  	      <td style="width: 142px;"><b>主检科室</b></td>
                  	      <td style="width: 200px;"><b>样品名称</b></td>
                  	      <td style="width: 48px;"><b>编制人</b></td>
                  	      <td style="width: 90px;"><b>样品登记日期</b></td>
                  	      <td style="width: 90px;"><b>审核日期</b></td>
                  	      <td style="width: 90px;"><b>接收日期</b></td>
                  	      <td style="width: 90px;"><b>发放日期</b></td>
                  	      <td style="width: 116px;"><b>检验类别</b></td>
                  	      <td style="width: 90px;"><b>完成期限</b></td>
                  	      <td style="width: 90px;"><b>批准日期</b></td>
                          <td><b>拖期天数</b></td>
                          </tr></thead><tbody></tbody></table>
						  <div id="Div1" name="Div1" style="overflow: auto;height: 486px; width: 100%;"></div>
						  </div>
						  </section>
                      </section>
                      <!--work progress end-->
	
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

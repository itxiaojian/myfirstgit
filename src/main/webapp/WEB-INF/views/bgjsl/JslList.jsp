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
    var num=1;
	function load() {
		 var url = "<%=path%>/bgjsl/getBgcxList";
		 var ypbh = document.getElementById("ypbh").value;
		 var ksmc = document.getElementById("ksmc").value;
         var ksyf = document.getElementById("ksyf").value;
         var jsyf = document.getElementById("jsyf").value;
         var csjd = document.getElementById("csjd").value;
         var size=$('#size').val();
         var count=parseInt($('#size').val());
         if(ksyf==null || ksyf=="" || jsyf==null || jsyf==""){
        	 alert("请选择查询时间！");
        	 return false;
         }
		 $.ajax({
             cache: true,
             type: "POST",
             url: url,
             data: {ksmc: ksmc, ksyf: ksyf,jsyf:jsyf,ypbh:ypbh,csjd:csjd,start: 0, limit: size,size: count},
             async: false,
             error: function (request) {
                 alert("查询失败,请联系管理员。");
             },
             success: function (data) {
            	var del = $("#table");
     			del.remove();
             	var str="<table>"
                    +"<tbody>";
             	for(var i=0;i<data.length;i++){
           			str=str+"<tr>"
           			+"<td style='width: 4%;text-align: center;'><b>"+(i+1)+"<b></td>"
           			+"<td style='width: 9%;'>"+data[i].BGBH+"</td>"
             		+"<td style='width: 12%;'>"+data[i].BMMC+"</td>"
             		+"<td style='width: 17%;'>"+data[i].YPMC+"</td>"
             		+"<td style='width: 10%;'>"+data[i].JYLX+"</td>"
             		+"<td style='width: 6%;'>"+isNull(data[i].WCQX)+"</td>"
                    +"<td style='width: 5%;'>"+data[i].JDMC+"</td>"
             		+"<td style='width: 10%;'>"+data[i].KSSJ+"</td>"
             		+"<td style='width: 10%;'>"+isNull(data[i].SHSJ)+"</td>"
                    +"<td style='width: 6%;'>"+isNull(data[i].JDRY)+"</td>"
                    +"<td style='width: 5%;'>"+data[i].SJC+"</td>"
                    +"</tr>";
             	} 
             	str=str+"</tbody><table>";
             	 var oTest = document.getElementById("Div1");
                 var newNode = document.createElement("table");
                 newNode.setAttribute('class', 'table table-hover personal-task table-striped table-bordered');
                 newNode.setAttribute('id', 'table');
                 newNode.innerHTML = str;
                 oTest.insertBefore(newNode, null);
			        	if(data.length > 0){
				        	creatPage(0,data,size);
				        }
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
	
	function creatPage(obj,data,size){
		var del = $("#Div5");
		del.remove();
		var html="";
		if(obj==0){
        	if(size < data[0].count){
        		html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>显示第 "+1+" 到 "+size+"条 共 "+data[0].count+"条</div>"
        			+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>";
        	}else{
        		html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>显示第 "+1+" 到 "+data[0].count+"条 共 "+data[0].count+"条</div>"
        			+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>";
        	}
		}else{
			if(size < data[0].count){
				html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>显示第 "+(obj+1)+" 到 "+size+"条 共 "+data[0].count+"条</div>"
				+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>";
			}else{
				html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>显示第 "+(obj+1)+" 到 "+data[0].count+"条 共 "+data[0].count+"条</div>"
				+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>";
			}
		}
		if(num > 1){
			html=html+"<a href='javascript:;' onclick='getValueFys()' class='paginate_disabled_previous'>上一页</a>";
		}else{
			html=html+"上一页";
		}
		if(num < data[0].pages){
			html=html+"<a href='javascript:;' onclick='getValueFyx()' class='paginate_enabled_next' style='margin-left: 14px;'>下一页</a>";
		}else{
			html=html+"下一页";
		}
		html=html+"</div>";
		var oTest = document.getElementById("Div4");
		var newNode = document.createElement("div");
		newNode.setAttribute('class', 'Div5');
		newNode.setAttribute('id', 'Div5');
		newNode.innerHTML = html;
		oTest.insertBefore(newNode, null);
	}
	
	//判断字段是否有值
    function isNull(string){
		if(string==null||string=='null'){
			return '';
		}else{
			return string
		}
	}
	
    function getValueFys(){
		num--;
		var url = "<%=path%>/bgjsl/getBgcxList";
		var start=parseInt($('#size').val())*num-parseInt($('#size').val());
		var size=parseInt($('#size').val())*num;
		var count=parseInt($('#size').val());
		var ypbh = document.getElementById("ypbh").value;
		var ksmc = document.getElementById("ksmc").value;
        var ksyf = document.getElementById("ksyf").value;
        var jsyf = document.getElementById("jsyf").value;
        var csjd = document.getElementById("csjd").value;
        $.ajax({
            cache: true,
            type: "POST",
            url: url,
            data: {ksmc: ksmc, ksyf: ksyf,jsyf:jsyf,ypbh:ypbh,csjd:csjd,start: start, limit: size,size: count},
            async: false,
            error: function (request) {
                alert("查询失败,请联系管理员。");
            },
            success: function (data) {
           	var del = $("#table");
    			del.remove();
            	var str="<table>"
                   +"<tbody>";
            	for(var i=0;i<data.length;i++){
          			str=str+"<tr>"
          			+"<td style='width: 4%;text-align: center;'><b>"+(i+1)+"<b></td>"
          			+"<td style='width: 9%;'>"+data[i].BGBH+"</td>"
            		+"<td style='width: 12%;'>"+data[i].BMMC+"</td>"
            		+"<td style='width: 17%;'>"+data[i].YPMC+"</td>"
            		+"<td style='width: 10%;'>"+data[i].JYLX+"</td>"
            		+"<td style='width: 6%;'>"+isNull(data[i].WCQX)+"</td>"
                   +"<td style='width: 5%;'>"+data[i].JDMC+"</td>"
            		+"<td style='width: 10%;'>"+data[i].KSSJ+"</td>"
            		+"<td style='width: 10%;'>"+isNull(data[i].SHSJ)+"</td>"
                   +"<td style='width: 6%;'>"+isNull(data[i].JDRY)+"</td>"
                   +"<td style='width: 5%;'>"+data[i].SJC+"</td>"
                   +"</tr>";
            	} 
            	str=str+"</tbody><table>";
            	 var oTest = document.getElementById("Div1");
                var newNode = document.createElement("table");
                newNode.setAttribute('class', 'table table-hover personal-task table-striped table-bordered');
                newNode.setAttribute('id', 'table');
                newNode.innerHTML = str;
                oTest.insertBefore(newNode, null);
			        	if(data.length > 0){
				        	creatPage(0,data,size);
				        }
            }
		 });
	}
    
    function getValueFyx(){
		num++;
		var url = "<%=path%>/bgjsl/getBgcxList";
		var start=parseInt($('#size').val())*num-parseInt($('#size').val());
		var size=parseInt($('#size').val())*num;
		var count=parseInt($('#size').val());
		var ypbh = document.getElementById("ypbh").value;
		var ksmc = document.getElementById("ksmc").value;
        var ksyf = document.getElementById("ksyf").value;
        var jsyf = document.getElementById("jsyf").value;
        var csjd = document.getElementById("csjd").value;
        $.ajax({
            cache: true,
            type: "POST",
            url: url,
            data: {ksmc: ksmc, ksyf: ksyf,jsyf:jsyf,ypbh:ypbh,csjd:csjd,start: start, limit: size,size: count},
            async: false,
            error: function (request) {
                alert("查询失败,请联系管理员。");
            },
            success: function (data) {
           	var del = $("#table");
    			del.remove();
            	var str="<table>"
                   +"<tbody>";
            	for(var i=0;i<data.length;i++){
          			str=str+"<tr>"
          			+"<td style='width: 4%;text-align: center;'><b>"+(i+1)+"<b></td>"
          			+"<td style='width: 9%;'>"+data[i].BGBH+"</td>"
            		+"<td style='width: 12%;'>"+data[i].BMMC+"</td>"
            		+"<td style='width: 17%;'>"+data[i].YPMC+"</td>"
            		+"<td style='width: 10%;'>"+data[i].JYLX+"</td>"
            		+"<td style='width: 6%;'>"+isNull(data[i].WCQX)+"</td>"
                   +"<td style='width: 5%;'>"+data[i].JDMC+"</td>"
            		+"<td style='width: 10%;'>"+data[i].KSSJ+"</td>"
            		+"<td style='width: 10%;'>"+isNull(data[i].SHSJ)+"</td>"
                   +"<td style='width: 6%;'>"+isNull(data[i].JDRY)+"</td>"
                   +"<td style='width: 5%;'>"+data[i].SJC+"</td>"
                   +"</tr>";
            	} 
            	str=str+"</tbody><table>";
            	 var oTest = document.getElementById("Div1");
                var newNode = document.createElement("table");
                newNode.setAttribute('class', 'table table-hover personal-task table-striped table-bordered');
                newNode.setAttribute('id', 'table');
                newNode.innerHTML = str;
                oTest.insertBefore(newNode, null);
			        	if(data.length > 0){
				        	creatPage(0,data,size);
				        }
            }
		 });
	}
	
	function getExcelValue(){
		var ypbh=$('#ypbh').val();
		var ksmc=$('#ksmc').val();
		var ksyf = document.getElementById("ksyf").value;
        var jsyf = document.getElementById("jsyf").value;
        var csjd = document.getElementById("csjd").value;
		$.ajax({
            success: function () {
            		if(confirm("确定下载查询结果吗?")){
        				var fileName = ksyf+"至"+jsyf+"报告及时率统计表";
            	    	var url = "exportBgtq?fileName="+fileName+"&ksmc="+ksmc+"&ksyf="+ksyf+"&jsyf="+jsyf+"&csjd="+csjd+"&ypbh="+ypbh;
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
            <a href="<%=path%>/bgjsl/JslListPage" target="content" onfocus="this.blur()"><span>报告及时率查询</span></a>
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
	                          <label class="col-sm-2 control-label" style="width:7%;top: 6px;">样品编号:</label>
							  <div class="col-sm-10" style="width:10%">
							  <input id="ypbh" name="ypbh"  style="height:28px;" class="form-control" type="text" />
							  </div>
	                          <label class="col-sm-2 control-label" style="width: 6%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">主检科室:</label>
							  <div class="col-sm-10" style="width:15%;padding-left: 0px;">
							   <select class="form-control1 m-bot15" name="ksmc" id="ksmc" style="height: 27px;">
							            <option selected="selected" value="">请选择...</option>
								<c:forEach var="ksmc" items="${ksmc}" varStatus="obj">
										<option value="${ksmc.id}">${ksmc.bmmc}</option>
								</c:forEach>
					           </select>
							  </div>
							  <label class="col-sm-2 control-label" style="width: 6%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">超时节点:</label>
							  <div class="col-sm-10" style="width:10%;padding-left: 0px;">
							   <select class="form-control1 m-bot15" name="csjd" id="csjd" style="height: 27px;">
							            <option selected="selected" value="">请选择...</option>
								<c:forEach var="csjd" items="${csjd}" varStatus="obj">
										<option value="${csjd.bz}">${csjd.bz}</option>
								</c:forEach>
					           </select>
							  </div>
			                  <label class="col-sm-2 control-label" style="width:7%;top: 6px;">统计时间从:</label>
							  <div class="col-sm-10" style="width:10%">
							  <% Date date = new Date();
 							     SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-01"); 
 							     String strdate = sdate.format(date);
 							     SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-dd");
 							     String enddate = edate.format(date);%> 
							  <input id="ksyf" name="ksyf" value="<%=strdate%>" style="height:28px;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width:3%;top: 6px;">到:</label>
							  <div class="col-sm-10" style="width:10%">
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
<!-- 						  <div id="Div3"></div> -->
<!-- 						  <div id="Div2" name="Div1" class="Div2"></div> -->
<!-- 						  <br></br> -->
						  <div  style="width: 100%;" >
						  <table style="margin-left: 4px;width: 100%;"><thead><tr>
						  <td style="width: 4%;text-align: center;"><b>序号</b></td>
                  	      <td style="width: 9%;"><b>检验报告编号</b></td>
                  	      <td style="width: 12%;"><b>主检科室</b></td>
                  	      <td style="width: 17%;"><b>样品名称</b></td>
                  	      <td style="width: 10%;"><b>检验类型</b></td>
                  	      <td style="width: 6%;"><b>完成期限</b></td>
                  	      <td style="width: 5%;"><b>超时节点</b></td>
                  	      <td style="width: 10%;"><b>开始时间</b></td>
                  	      <td style="width: 10%;"><b>结束时间</b></td>
                  	      <td style="width: 6%;"><b>节点人员</b></td>
                  	      <td style="width: 5%;"><b>超时时间（小时）</b></td>
                          </tr></thead><tbody></tbody></table></div>
						  <div id="Div1" name="Div1" style="overflow: auto;height: 486px; width: 100%;"></div>
						  <div id="Div4">
								<div id="table_length" class="dataTables_length" style="float:left;margin-top: 6px; padding-right: 0px; padding-top: 0px; padding-bottom: 0px;">
									<div>
										<label style="float: left;">
											每页显示</label>
										<select class="form-control" name="size1" size="1" aria-controls="table" id="size" onchange="window.onload();" style="float: left;padding: 0px;width: 50px;margin-top: 0px;">
											<option value="10" >10</option>
											<option value="20" selected="selected">20</option>
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
										<a href="javascript:;" onclick="" class="paginate_enabled_next">下一页</a>
									</div>
								</div>
							</div>
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

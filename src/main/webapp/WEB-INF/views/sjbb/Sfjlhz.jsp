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
    function onload1(){
		  var url = "<%=path%>/sjbb/Ygfltj/getBgsfjl";
			 var srfl = document.getElementById("srfl1").value;
			 var sfr = document.getElementById("sfr1").value;
	         var cxsjstr = document.getElementById("cxsjstr1").value;
	         var cxsjend = document.getElementById("cxsjend1").value;
	         var jyks = document.getElementById("jyks1").value;
	         var ywks = document.getElementById("ywks1").value;
	         if(cxsjend < cxsjstr){
		    	  alert('查询结束时间大于开始时间，请修改后重新查询！');
		    	   	 return false;
		      }
			 $.ajax({
	             cache: true,
	             type: "POST",
	             url: url,
	             data: {srfl: srfl,sfr:sfr,cxsjstr:cxsjstr, cxsjend: cxsjend,jyks:jyks,ywks:ywks},
	             async: false,
	             error: function (request) {
	                 alert("查询失败,请联系管理员。");
	             },
	             success: function (data) {
	            	var del = $("#table");
	     			del.remove();
	             	var str="<table><thead>"
		                  	+"<tr>"
		                  	+"<td style='text-align:center;'><b>报告编号</b></td>"
		                  	+"<td style='text-align:center;'><b>样品名称</b></td>"
		                  	+"<td style='text-align:center;'><b>检验科室</b></td>"
		                  	+"<td style='text-align:center;'><b>业务科室</b></td>"
		                  	+"<td style='text-align:center;'><b>生产单位</b></td>"
		                  	+"<td style='text-align:center;'><b>受检单位</b></td>"
		                  	+"<td style='text-align:center;'><b>委托单位</b></td>"
		                  	+"<td style='text-align:center;'><b>检验费用（元）</b></td>"
		                  	+"<td style='text-align:center;'><b>剩缴金额（元）</b></td>"
		                  	+"<td style='text-align:center;'><b>已收费金额（元）</b></td>"
		                  	+"<td style='text-align:center;'><b>本次实收（元）</b></td>"
		                  	+"<td style='text-align:center;'><b>票据号码</b></td>"
		                  	+"<td style='text-align:center;'><b>收入分类</b></td>"
		                  	+"<td style='text-align:center;'><b>收费人</b></td>"
		                  	+"<td style='text-align:center;'><b>收费时间</b></td>"
		                  	+"</tr></thead>"
		              for(var i=0;i<data.length;i++){
		            	  str=str+"<tbody><tr style='font-size:13px;'>"
	                 		+"<td style='text-align:center;'>"+isNull(data[i].BGBH)+"</td>"
	                 		+"<td style='text-align:center;'>"+isNull(data[i].YPMC)+"</td>"
	                 		+"<td style='text-align:center;'>"+isNull(data[i].KS_ID)+"</td>"
	                 		+"<td style='text-align:center;'>"+isNull(data[i].SSYWKS)+"</td>"
	                 		+"<td style='text-align:center;'>"+isNull(data[i].SCDW)+"</td>"
	                 		+"<td style='text-align:center;'>"+isNull(data[i].SJDW)+"</td>"
	                 		+"<td style='text-align:center;'>"+isNull(data[i].WTDW)+"</td>"
	                 		+"<td style='text-align:center;'>"+isNull(data[i].JYFY)+"</td>"
	                 		+"<td style='text-align:center;'>"+isNull(data[i].YSJE)+"</td>"
	                 		+"<td style='text-align:center;'>"+isNull(data[i].YSFJE)+"</td>"
	                 		+"<td style='text-align:center;'>"+isNull(data[i].BCSS)+"</td>"
	                 		+"<td style='text-align:center;'>"+isNull(data[i].PJHM)+"</td>"
	                 		+"<td style='text-align:center;'>"+isNull(data[i].SRFL)+"</td>"
	                 		+"<td style='text-align:center;'>"+isNull(data[i].SFR)+"</td>"
	                 		+"<td style='text-align:center;'>"+isNull(data[i].JYJSRQ)+"</td>"
	                 		+"</tr></tbody>";
	             		}
		                    
	             	 var oTest = document.getElementById("Div1");
	                 var newNode = document.createElement("table");
	                 newNode.setAttribute('class', 'table table-hover personal-task table-striped table-bordered');
	                 newNode.setAttribute('id', 'table');
	                 newNode.innerHTML = str;
	                 oTest.insertBefore(newNode, null);
	             }
			 });
	  }
    
  //判断字段是否有值
    function isNull(string){
		if(string==null||string=='null'){
			return '/';
		}else{
			return string
		}
	}
    
    function onload2(){
		  var url = "<%=path%>/sjbb/Ygfltj/getXysfjl";
			 var sfr = document.getElementById("sfr2").value;
	         var cxsjstr = document.getElementById("cxsjstr2").value;
	         var cxsjend = document.getElementById("cxsjend2").value;
	         var jyks = document.getElementById("jyks2").value;
	         var ywks = document.getElementById("ywks2").value;
	         if(cxsjend < cxsjstr){
		    	  alert('查询结束时间大于开始时间，请修改后重新查询！');
		    	   	 return false;
		      }
			 $.ajax({
	             cache: true,
	             type: "POST",
	             url: url,
	             data: {sfr:sfr,cxsjstr:cxsjstr, cxsjend: cxsjend,jyks:jyks,ywks:ywks},
	             async: false,
	             error: function (request) {
	                 alert("查询失败,请联系管理员。");
	             },
	             success: function (data) {
	            	var del = $("#table");
	     			del.remove();
	             	var str="<table><thead>"
		                  	+"<tr>"
		                  	+"<td style='text-align:center;'><b>协议编号</b></td>"
		                  	+"<td style='text-align:center;'><b>客户名称</b></td>"
		                  	+"<td style='text-align:center;'><b>检验科室</b></td>"
		                  	+"<td style='text-align:center;'><b>业务科室</b></td>"
		                  	+"<td style='text-align:center;'><b>协议金额（元）</b></td>"
		                  	+"<td style='text-align:center;'><b>剩缴金额（元）</b></td>"
		                  	+"<td style='text-align:center;'><b>已收金额（元）</b></td>"
		                  	+"<td style='text-align:center;'><b>本次实收（元）</b></td>"
		                  	+"<td style='text-align:center;'><b>票据号码</b></td>"
		                  	+"<td style='text-align:center;'><b>收费人</b></td>"
		                  	+"<td style='text-align:center;'><b>收费时间</b></td>"
		                  	+"</tr></thead>"
		              for(var i=0;i<data.length;i++){
		            	  str=str+"<tbody><tr style='font-size:13px;'>"
	                 		+"<td style='text-align:center;'>"+data[i].XYBH+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].KHMC+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].JYKS_ID+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].YWKS_ID+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].XYJE+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].YSJE+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].YSFJE+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].BCSS+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].PJHM+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].SFR+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].SFRQ+"</td>"
	                 		+"</tr></tbody>";
	             		}
	             	 var oTest = document.getElementById("Div2");
	                 var newNode = document.createElement("table");
	                 newNode.setAttribute('class', 'table table-hover personal-task table-striped table-bordered');
	                 newNode.setAttribute('id', 'table');
	                 newNode.innerHTML = str;
	                 oTest.insertBefore(newNode, null);
	             }
			 });
	  }
    
    
    function onload3(){
		  var url = "<%=path%>/sjbb/Ygfltj/getGlsfjl";
			 var sfr = document.getElementById("sfr3").value;
			 var srfl = document.getElementById("srfl3").value;
	         var cxsjstr = document.getElementById("cxsjstr3").value;
	         var cxsjend = document.getElementById("cxsjend3").value;
	         var glbm = document.getElementById("glbm").value;
	         if(cxsjend < cxsjstr){
		    	  alert('查询结束时间大于开始时间，请修改后重新查询！');
		    	   	 return false;
		      }
			 $.ajax({
	             cache: true,
	             type: "POST",
	             url: url,
	             data: {sfr:sfr,srfl:srfl,cxsjstr:cxsjstr, cxsjend: cxsjend,glbm:glbm},
	             async: false,
	             error: function (request) {
	                 alert("查询失败,请联系管理员。");
	             },
	             success: function (data) {
	            	var del = $("#table");
	     			del.remove();
	             	var str="<table><thead>"
		                  	+"<tr>"
		                  	+"<td style='text-align:center;'><b>部门名称</b></td>"
		                  	+"<td style='text-align:center;'><b>发票号</b></td>"
		                  	+"<td style='text-align:center;'><b>收费项目</b></td>"
		                  	+"<td style='text-align:center;'><b>收费金额（元）</b></td>"
		                  	+"<td style='text-align:center;'><b>票据号码</b></td>"
		                  	+"<td style='text-align:center;'><b>收费人</b></td>"
		                  	+"<td style='text-align:center;'><b>收费时间</b></td>"
		                  	+"</tr></thead>"
		              for(var i=0;i<data.length;i++){
		            	  str=str+"<tbody><tr style='font-size:13px;'>"
	                 		+"<td style='text-align:center;'>"+data[i].BMBH+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].FPHM+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].SFXMMC+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].SFJE+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].PJHM+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].SFR+"</td>"
	                 		+"<td style='text-align:center;'>"+data[i].SFRQ+"</td>"
	                 		+"</tr></tbody>";
	             		}
	             	 var oTest = document.getElementById("Div3");
	                 var newNode = document.createElement("table");
	                 newNode.setAttribute('class', 'table table-hover personal-task table-striped table-bordered');
	                 newNode.setAttribute('id', 'table');
	                 newNode.innerHTML = str;
	                 oTest.insertBefore(newNode, null);
	             }
			 });
	  }
       
    
    
    
	    function getExcelValue1(){
			var jyks=$('#jyks1').val();
			var ywks=$('#ywks1').val();
			var cxsjstr=$('#cxsjstr1').val();
			var cxsjend=$('#cxsjend1').val();
			var srfl=$('#srfl1').val();
			var sfr=$('#sfr1').val();
			$.ajax({
	            success: function () {
	            		if(confirm("确定下载查询结果吗?")){
	        				var fileName = cxsjstr+"至"+cxsjend+"期间报告收费记录";
	            	    	var url = "exportBgsfjl?fileName="+fileName+"&jyks="+jyks+"&ywks="+ywks+"&cxsjstr="+cxsjstr+"&cxsjend="+cxsjend+"&sfr="+sfr+"&srfl="+srfl;
	            	    	url = encodeURI(url);
	            	    	url = encodeURI(url);
	            	    	window.open(url);
	        			}
	            }
		   });
		}
	    
	    function getExcelValue2(){
	    	var jyks=$('#jyks2').val();
			var ywks=$('#ywks2').val();
			var cxsjstr=$('#cxsjstr2').val();
			var cxsjend=$('#cxsjend2').val();
			var sfr=$('#sfr2').val();
			$.ajax({
	            success: function () {
	            		if(confirm("确定下载查询结果吗?")){
	        				var fileName = cxsjstr+"至"+cxsjend+"期间协议收费记录";
	            	    	var url = "exportXysfjl?fileName="+fileName+"&jyks="+jyks+"&ywks="+ywks+"&cxsjstr="+cxsjstr+"&cxsjend="+cxsjend+"&sfr="+sfr;
	            	    	url = encodeURI(url);
	            	    	url = encodeURI(url);
	            	    	window.open(url);
	        			}
	            }
		   });
		}
	    
	    function getExcelValue3(){
	    	var glbm=$('#glbm').val();
			var cxsjstr=$('#cxsjstr3').val();
			var cxsjend=$('#cxsjend3').val();
			var srfl=$('#srfl3').val();
			var sfr=$('#sfr3').val();
			$.ajax({
	            success: function () {
	            		if(confirm("确定下载查询结果吗?")){
	        				var fileName = cxsjstr+"至"+cxsjend+"期间管理服务收费记录";
	            	    	var url = "exportGlbmjl?fileName="+fileName+"&glbm="+glbm+"&cxsjstr="+cxsjstr+"&cxsjend="+cxsjend+"&srfl="+srfl+"&sfr="+sfr;
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
<div style="display:none;">
<ul class="tab-menu tab" id="tabMenuID_">
    <li class="tab-selected" title="收费记录查询">
        <a href="<%=path%>/sjbb/Ygfltj/SfjlhzPage" target="content" onfocus="this.blur()"><span>收费记录查询</span></a>
      </li>
  </ul>
</div>
<div class="panel-body" style="padding: 0px;" >
        <!-- <header class="panel-heading" style="padding-left: 650px;">样品信息</header> -->
        <div class="col-lg-12" style="padding-right: 0px; padding-left: 0px;">
            <section class="panel" style="margin-bottom: 0px;">
            <div class="panel-body" style="border-color:#fff;padding-bottom: 0px;"> 
                           </div>
                <header class="panel-heading tab-bg-dark-navy-blue" >
                    <ul class="nav nav-tabs nav-justified ">
                        <li class="active" >
                            <a href="#popular" data-toggle="tab" >报告收费记录</a>
                        </li>
                        <li>
                            <a href="#comments" data-toggle="tab" >协议收费记录</a>
                        </li>
                        <li>
                            <a href="#kobe" data-toggle="tab" >服务收费记录</a>
                        </li>
                    </ul>
                </header>
                <div class="panel-body" style="padding: 8px 0px 0px 8px;">
                    <div class="tab-content tasi-tab">
                        <div class="tab-pane active" id="popular">  
                          <div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;height: 30px;">
                          	  <label class="col-sm-2 control-label" style="width:9%;top: 6px;padding-left: 0;padding-right: 0;">收费时间从：</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0;padding-right: 0;">
							  <% Date date = new Date();
 							     SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-dd");
 							     String enddate = edate.format(date); 
 							    SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-01");
		                         String strdate = sdate.format(date);%>
							  <input id="cxsjstr1" name="cxsjstr1" value="<%=strdate%>" style="height:28px;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width:4%;top: 6px;padding-left: 11px;padding-right: 0px;">到:</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0;padding-right: 0;">
							  <input id="cxsjend1" name="cxsjend1" value="<%=enddate%>" style="height:28px;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width: 9%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">检验科室:</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0px;padding-right: 0px;">
							   <select class="form-control1 m-bot15" name="jyks1" id="jyks1" >
							            <option selected="selected" value="">全部</option>
								<c:forEach var="jyks" items="${jyks}" varStatus="obj">
										<option value="${jyks.bmbh}">${jyks.bmmc}</option>
								</c:forEach>
					           </select>
							  </div>
							  <label class="col-sm-2 control-label" style="width: 9%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">业务科室:</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0px;padding-right: 0px;">
							   <select class="form-control1 m-bot15" name="ywks1" id="ywks1" >
							            <option selected="selected" value="">全部</option>
								<c:forEach var="ywks" items="${ywks}" varStatus="obj">
										<option value="${ywks.bmbh}">${ywks.bmmc}</option>
								</c:forEach>
					           </select>
							  </div>
							  <label class="col-sm-2 control-label" style="width:7%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">收费人:</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0px;padding-right: 0px;">
							   <select class="form-control1 m-bot15" name="sfr1" id="sfr1" >
							            <option selected="selected" value="">全部</option>
								<c:forEach var="sfr" items="${sfr}" varStatus="obj">
										<option value="${sfr.yhbh}">${sfr.xm}</option>
								</c:forEach>
					           </select>
							  </div>
                          </div>
                          <div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;height: 30px;">
                              <label class="col-sm-2 control-label" style="width: 9%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">收入分类:</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0px;padding-right: 0px;">
							   <select class="form-control1 m-bot15" name="srfl1" id="srfl1" >
							            <option selected="selected" value="">全部</option>
								<c:forEach var="srfl" items="${srfl}" varStatus="obj">
										<option value="${srfl.zdmc}">${srfl.zdmc}</option>
								</c:forEach>
					           </select>
							  </div>
							  <label class="col-sm-2 control-label" style="width: 6%;padding-left: 23px;left: 750px;">
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="onload1();" type="button" data-toggle="modal">查询</a>
                              </label>
                              <label class="col-sm-2 control-label" style="width: 9%;left: 750px;">
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="getExcelValue1();" type="button" data-toggle="modal">导出Excel</a>
                              </label>
                          </div> 
                           <div id="Div1" name="Div1" style="display:'none';height: 476px;"></div>
                          </div>
                          
                        <div class="tab-pane" id="comments">
                         <div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;height: 30px;">
                          	  <label class="col-sm-2 control-label" style="width:9%;top: 6px;padding-left: 0;padding-right: 0;">收费时间从：</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0;padding-right: 0;">
							  <input id="cxsjstr2" name="cxsjstr2" value="<%=strdate%>" style="height:28px;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width:4%;top: 6px;padding-left: 11px;padding-right: 0px;">到:</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0;padding-right: 0;">
							  <input id="cxsjend2" name="cxsjend2" value="<%=enddate%>" style="height:28px;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width: 9%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">检验科室:</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0px;padding-right: 0px;">
							   <select class="form-control1 m-bot15" name="jyks2" id="jyks2" >
							            <option selected="selected" value="">全部</option>
								<c:forEach var="jyks" items="${jyks}" varStatus="obj">
										<option value="${jyks.bmbh}">${jyks.bmmc}</option>
								</c:forEach>
					           </select>
							  </div>
							  <label class="col-sm-2 control-label" style="width: 9%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">业务科室:</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0px;padding-right: 0px;">
							   <select class="form-control1 m-bot15" name="ywks2" id="ywks2" >
							            <option selected="selected" value="">全部</option>
								<c:forEach var="ywks" items="${ywks}" varStatus="obj">
										<option value="${ywks.bmbh}">${ywks.bmmc}</option>
								</c:forEach>
					           </select>
							  </div>
                              <label class="col-sm-2 control-label" style="width:7%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">收费人:</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0px;padding-right: 0px;">
							   <select class="form-control1 m-bot15" name="sfr2" id="sfr2" >
							            <option selected="selected" value="">全部</option>
								<c:forEach var="sfr" items="${sfr}" varStatus="obj">
										<option value="${sfr.yhbh}">${sfr.xm}</option>
								</c:forEach>
					           </select>
							  </div>
						 </div>
						  <div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;height: 30px;">
							  <label class="col-sm-2 control-label" style="width: 6%;padding-left: 23px;left: 1000px;">
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="onload2();" type="button" data-toggle="modal">查询</a>
                              </label>
                              <label class="col-sm-2 control-label" style="width: 9%;left: 1000px;">
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="getExcelValue2();" type="button" data-toggle="modal">导出Excel</a>
                              </label>
                          </div> 
                            <div id="Div2" name="Div2" style="display:'none';height: 476px;"></div>
                          </div>
                          
                          <div class="tab-pane" id="kobe">  
                          <div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;height: 30px;">
                          	  <label class="col-sm-2 control-label" style="width:9%;top: 6px;padding-left: 0;padding-right: 0;">收费时间从：</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0;padding-right: 0;">
							  <input id="cxsjstr3" name="cxsjstr3" value="<%=strdate%>" style="height:28px;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width:4%;top: 6px;padding-left: 11px;padding-right: 0px;">到:</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0;padding-right: 0;">
							  <input id="cxsjend3" name="cxsjend3" value="<%=enddate%>" style="height:28px;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width: 9%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">管理部门:</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0px;padding-right: 0px;">
							   <select class="form-control1 m-bot15" name="glbm" id="glbm" >
							            <option selected="selected" value="">全部</option>
								<c:forEach var="glbm" items="${glbm}" varStatus="obj">
										<option value="${glbm.bmbh}">${glbm.bmmc}</option>
								</c:forEach>
					           </select>
							  </div>
							  <label class="col-sm-2 control-label" style="width: 9%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">收入分类:</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0px;padding-right: 0px;">
							   <select class="form-control1 m-bot15" name="srfl3" id="srfl3" >
							            <option selected="selected" value="">全部</option>
								<c:forEach var="srfl" items="${srfl}" varStatus="obj">
										<option value="${srfl.zdmc}">${srfl.zdmc}</option>
								</c:forEach>
					           </select>
							  </div>
                              <label class="col-sm-2 control-label" style="width:7%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">收费人:</label>
							  <div class="col-sm-10" style="width:12%;padding-left: 0px;padding-right: 0px;">
							   <select class="form-control1 m-bot15" name="sfr3" id="sfr3" >
							            <option selected="selected" value="">全部</option>
								<c:forEach var="sfr" items="${sfr}" varStatus="obj">
										<option value="${sfr.yhbh}">${sfr.xm}</option>
								</c:forEach>
					           </select>
							  </div>
							<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 100%;height: 30px;">
							  <label class="col-sm-2 control-label" style="width: 6%;padding-left: 23px;left: 1000px;">
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="onload3();" type="button" data-toggle="modal">查询</a>
                              </label>
                              <label class="col-sm-2 control-label" style="width: 9%;left: 1000px;">
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="getExcelValue3();" type="button" data-toggle="modal">导出Excel</a>
                              </label>
                          </div> 
                          </div>
                           <div id="Div3" name="Div3" style="display:'none';height: 476px;"></div>
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

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
	<link rel="stylesheet" type="text/css" href="<%=path%>/system/login/css/padstyle.css" />
    <script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js" />
	<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/index/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/index/js/editable-table.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
	<script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
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

  <body onload="" style="color: #333;">
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
                          <div class="form-group" style="height: 35px; margin-bottom: 0px;margin-left: 24px;margin-top: 4px;">
			                  <label class="col-sm-2 control-label" style="width:12%;top: 6px;">查询时间从:</label>
							  <div class="col-sm-10" style="width:20%">
							  <% Date date = new Date();
 							     SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-dd");
 							     String enddate = edate.format(date); 
 							    SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-01");
		                         String strdate = sdate.format(date);%>
							  <input id="cxsjstr" name="cxsjstr" value="<%=strdate%>" style="height:28px;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width:3%;top: 6px;">到:</label>
							  <div class="col-sm-10" style="width:20%">
							  <input id="cxsjend" name="cxsjend" value="<%=enddate%>" style="height:28px;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width: 9%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">收入分类:</label>
							  <div class="col-sm-10" style="width:20%;padding-left: 0px;">
							   <select class="form-control1 m-bot15" name="srfl" id="srfl" >
							            <option selected="selected" value="">全部</option>
								<c:forEach var="srfl" items="${srfl}" varStatus="obj">
										<option value="${srfl.zdmc }">${srfl.zdmc }</option>
								</c:forEach>
					           </select>
							  </div>
							  <label class="col-sm-2 control-label" style="width: 5%;">
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="window.onload();" type="button" data-toggle="modal">查询</a>
                              </label>
                              <label class="col-sm-2 control-label" style="width: 5%;">
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="back();" type="button" data-toggle="modal">返回</a>
                              </label>
						  </div>
						  <div id="Div1" name="Div1" style="margin-left: 16px;"></div>
                      <!--work progress end-->
                  </div>
              </div>
	</div>
	</div>
	<div class="foot">安徽省产品质量监督检查研究院  皖ICP备08001861号-1  地址：合肥市包河工业园延安路13号  邮政编码：230051  电话：0551-63356268  63855622</div>
    </div>
	<script type="text/javascript">
	
	function back(){
		window.history.back(-1);
}
	//动态合并类型相同的科室
	  window.onload = function(){
		  var url = "<%=path%>/sjbb/Ygfltj/getKssrtj";
			 var srfl = document.getElementById("srfl").value;
	         var cxsjstr = document.getElementById("cxsjstr").value;
	         var cxsjend = document.getElementById("cxsjend").value;
	         if(cxsjend!= null && cxsjend!="" ){
	        	 if(cxsjstr!= null && cxsjstr!=""){
	        		 if(cxsjend < cxsjstr){
	        			 alert('查询结束时间小于开始时间，请修改后重新查询！');
	        			 return false;
	        		 }
	        	 }
		      }
			 $.ajax({
	             cache: true,
	             type: "POST",
	             url: url,
	             data: {srfl: srfl,cxsjstr:cxsjstr, cxsjend: cxsjend},
	             async: false,
	             error: function (request) {
	                 alert("查询失败,请联系管理员。");
	             },
	             success: function (data) {
	            	var del = $("#table");
	     			del.remove();
	             	var str="<table><thead>"
	                  	+"<tr>"
	                  	+"<td colspan='2' style='text-align:center;width:15%;'><b>科室</b></td>"
	                  	+"<td colspan='2' style='text-align:center;'><b>检验收入应收款</b></td>"
	                  	+"<td colspan='2' style='text-align:center;'><b>检验收入实到款</b></td>"
	                  	+"<td colspan='2' style='text-align:center;'><b>技术服务收入</b></td>"
	                  	+"<td rowspan='2' style='text-align:center;vertical-align: middle;'><b>合计应收款</b></td>"
	                  	+"<td rowspan='2' style='text-align:center;vertical-align: middle;'><b>合计实收款</b></td>"
	                  	+"<td rowspan='2' style='text-align:center;vertical-align: middle;'><b>管理服务收入</b></td>"
	                  	+"</tr>"
	                  	+"<tr>"
	                  	+"<td style='text-align:center;width:9%;'><b>科室类型</b></td>"
	                  	+"<td style='width:15%;'><b>科室名称</b></td>"
	                  	+"<td style='text-align:center;'><b>主检应收款</b></td>"
	                  	+"<td style='text-align:center;'><b>内委应收款</b></td>"
	                  	+"<td style='text-align:center;'><b>主检实到款</b></td>"
	                  	+"<td style='text-align:center;'><b>内委实到款</b></td>"
	                  	+"<td style='text-align:center;'><b>技术服务应收款</b></td>"
	                  	+"<td style='text-align:center;'><b>技术服务实到款</b></td>"
	                    +"</tr></thead><tbody>";
	             	for(var i=0;i<data.length;i++){
	             		if (data[i].PX == 2 || data[i].PX == 4 || data[i].PX == 6 || data[i].PX == 8){
	             			str=str+"<tr rowspan='"+data[i].BMLX+"' style='font-size:13px;color:red;'>"
	             			+"<td colspan='2' style='text-align:center;'><b>合计</b></td>"	
	                 		+"<td style='text-align:center;'><b>"+data[i].JYSFYSK+"</b></td>"
	                 		+"<td style='text-align:center;'><b>"+data[i].NWYSK+"</b></td>"
	                 		+"<td style='text-align:center;'><b>"+data[i].JYSFYSF+"</b></td>"
	                 		+"<td style='text-align:center;'><b>"+data[i].NWYSF+"</b></td>"
	                 		+"<td style='text-align:center;'><b>"+data[i].JSFWYSK+"</b></td>"
	                 		+"<td style='text-align:center;'><b>"+data[i].JSFWYSF+"</b></td>"
	                 		+"<td style='text-align:center;'><b>"+(data[i].JYSFYSK + data[i].NWYSK + data[i].JSFWYSK)+"</b></td>"
	                 		+"<td style='text-align:center;'><b>"+(data[i].JYSFYSF + data[i].NWYSF + data[i].JSFWYSF)+"</b></td>"
	                 		+"<td style='text-align:center;'><b>"+data[i].GLBMSF+"</b></td>"
	                 		+"</tr>";
	             		}else{
	             			
	             			if(data[i].BMLX == '100500'){
	             				str=str+"<tr rowspan='"+data[i].BMLX+"'>"
	             				+"<td style='text-align:center;vertical-align: middle;background-color: #fff;'><b>专业检测实验室</b></td>"
	             				+"<td><a onclick='ckmx(1,"+ data[i].BMBH+")' class='btn btn-xs btn-sucess'>"+ data[i].BMMC+"</a></td>"	
		                 		+"<td style='text-align:center;'>"+data[i].JYSFYSK+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].NWYSK+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].JYSFYSF+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].NWYSF+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].JSFWYSK+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].JSFWYSF+"</td>"
		                 		+"<td style='text-align:center;'>"+(data[i].JYSFYSK + data[i].NWYSK + data[i].JSFWYSK)+"</td>"
		                 		+"<td style='text-align:center;'>"+(data[i].JYSFYSF + data[i].NWYSF + data[i].JSFWYSF)+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].GLBMSF+"</td>"
		                 		+"</tr>";
	             			}else if(data[i].BMLX == '100200'){
	             				str=str+"<tr rowspan='"+data[i].BMLX+"'>"
	             				+"<td style='text-align:center;vertical-align: middle;background-color: #fff;'><b>业务科</b></td>"
	             				+"<td><a onclick='ckmx(3,"+ data[i].BMBH+")' class='btn btn-xs btn-sucess'title='点击查看明细'>"+ data[i].BMMC+"</a></td>"	
		                 		+"<td style='text-align:center;'>"+data[i].JYSFYSK+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].NWYSK+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].JYSFYSF+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].NWYSF+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].JSFWYSK+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].JSFWYSF+"</td>"
		                 		+"<td style='text-align:center;'>"+(data[i].JYSFYSK + data[i].NWYSK + data[i].JSFWYSK)+"</td>"
		                 		+"<td style='text-align:center;'>"+(data[i].JYSFYSF + data[i].NWYSF + data[i].JSFWYSF)+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].GLBMSF+"</td>"
		                 		+"</tr>";
	             			}else if(data[i].BMLX == '100400'){
	             				str=str+"<tr rowspan='"+data[i].BMLX+"'>"
	             				+"<td style='text-align:center;vertical-align: middle;background-color: #fff;'><b>工程技术中心</b></td>"
	             				+"<td><a onclick='ckmx(5,"+ data[i].BMBH+")' class='btn btn-xs btn-sucess'title='点击查看明细'>"+ data[i].BMMC+"</a></td>"	
		                 		+"<td style='text-align:center;'>"+data[i].JYSFYSK+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].NWYSK+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].JYSFYSF+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].NWYSF+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].JSFWYSK+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].JSFWYSF+"</td>"
		                 		+"<td style='text-align:center;'>"+(data[i].JYSFYSK + data[i].NWYSK + data[i].JSFWYSK)+"</td>"
		                 		+"<td style='text-align:center;'>"+(data[i].JYSFYSF + data[i].NWYSF + data[i].JSFWYSF)+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].GLBMSF+"</td>"
		                 		+"</tr>";
	             			}else if(data[i].BMLX == '100700'){
	             				str=str+"<tr rowspan='"+data[i].BMLX+"'>"
	             				+"<td style='text-align:center;vertical-align: middle;background-color: #fff;'><b>管理服务部门</b></td>"
	             				+"<td><a onclick='ckmx(7,"+ data[i].BMBH+")' class='btn btn-xs btn-sucess' title='点击查看明细'>"+ data[i].BMMC+"</a></td>"	
		                 		+"<td style='text-align:center;'>"+data[i].JYSFYSK+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].NWYSK+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].JYSFYSF+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].NWYSF+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].JSFWYSK+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].JSFWYSF+"</td>"
		                 		+"<td style='text-align:center;'>"+(data[i].JYSFYSK + data[i].NWYSK + data[i].JSFWYSK)+"</td>"
		                 		+"<td style='text-align:center;'>"+(data[i].JYSFYSF + data[i].NWYSF + data[i].JSFWYSF)+"</td>"
		                 		+"<td style='text-align:center;'>"+data[i].GLBMSF+"</td>"
		                 		+"</tr>";
	             			}
	             		}
	             	} 
	             	str=str+"</tbody><table>";
	             	 var oTest = document.getElementById("Div1");
	                 var newNode = document.createElement("table");
	                 newNode.setAttribute('class', 'table table-hover personal-task table-striped table-bordered');
	                 newNode.setAttribute('id', 'table');
	                 newNode.innerHTML = str;
	                 oTest.insertBefore(newNode, null);
	            	 
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
	             }
			 });
	  };
	  
	  function ckmx(px,ksmccx) {
	        var cxsjstr = document.getElementById("cxsjstr").value;
	        var cxsjend = document.getElementById("cxsjend").value;
	        var srfl = document.getElementById("srfl").value;
			window.open('KssrmxPage?ksmccx='+ksmccx+'&px='+px+'&cxsjstr='+cxsjstr+'&cxsjend='+cxsjend+'&srfl='+srfl,"科室收入明细","height=600px, width=1000px,top=100px, left=200px, toolbar=no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no");
		}
	  
	  
	  function getExcelValue(){
			var cxsjstr=$('#cxsjstr').val();
			var cxsjend=$('#cxsjend').val();
			var srfl=$('#srfl').val();
			
			$.ajax({
	            success: function () {
	            		if(confirm("确定下载查询结果吗?")){
	        				var fileName = cxsjstr+"至"+cxsjend+"期间科室"+srfl+"收入报表";;
	            	    	var url = "export?fileName="+fileName+"&srfl="+srfl+"&cxsjstr="+cxsjstr+"&cxsjend="+cxsjend;
	            	    	url = encodeURI(url);
	            	    	url = encodeURI(url);
	            	    	window.open(url);
	        			}
	            }
		   });
		}
  </script>
  </body>
</html>

<%@page contentType="text/html" import="java.util.* ,java.util.Date" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<% 
 String path = request.getContextPath();
 Date date = new Date();
 SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-dd");
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
		    border-radius: 4px;
    		box-shadow: none;
    		color: #000000;
		}
		.input-lg1 {
		    border-radius: 6px;
		}
		.btn {
			padding: 6px;
		    width: 20% !important;
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
		.btnx {
			padding: 6px;
		    width: 50px !important;
		    padding-bottom: 2px; 
		    padding-top: 3px;
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
		.form-control1::-moz-placeholder {
    		color: #999;
		}
	</style>
  </head>
  <body>
  <div style="display:none;">
	<ul class="tab-menu tab" id="tabMenuID_">
		<li class="tab-selected" title="检验费用修改">
		<a href="<%=path%>/ypgl/YYpYpxx/ypfyUpdate" target="content" onfocus="this.blur()"><span>检验费用修改</span></a>
		</li>
	</ul>
  </div>
  <section id="container" >
      <!--main content start-->
      <section id="main-content1">
          <section class="wrapper1">
              <!-- page start-->
              <section class="panel">
                  <header class="panel-heading"><a href="<%=path%>/ypgl/YYpYpxx/ypfyUpdate" target="content" onfocus="this.blur()"><span>检验费用修改</span></a></header>
				  <div style="padding: 15px; height: 222px;">
						<div class="row" style="width:700px;float:left;padding-left: 15px;">
						<form action="" method="post" id="myForm">
							<input id="id" name="id" type="hidden" value=""/>
							<input id="bid" name="bid" type="hidden" value=""/>
							<input id="djlx" name="djlx" type="hidden" value=""/>
							<input id="jyhth" name="jyhth" type="hidden" value=""/>
							<div style="width: 850px;margin-top: 10px;height:30px;" align="center">
							<label style="margin-left: 20px;">报告编号：</label>
							<input id="bgbh" name="bgbh" class="form-control1" style="height: 100%;">
								<input class="btn btnx btn-success" type="button" onclick="getValue();" style="margin-left: 14px;height: 100%;" value="查询">
							</div>
							<div style="width: 797px;margin-top: 10px;height:30px;margin-bottom: 28px;" align="center">
								<label style="margin-left: 20px;">原检验费用（元）：</label>
							    <input id="bfjyfy" name="bfjyfy" readonly="true" type="text" style="height: 100%;" placeholder="原费用，不可编辑" class="form-control1">
							    <input class="btn btnx btn-success" type="button" onclick="getLook();" style="margin-left: 14px;height: 100%;" value="查看">
							    <br><b id="sfzt" style="color:red;color: red; margin-left: -72px;"></b>
							</div>
							<div style="border-style: solid none;border-bottom:thick; margin-left: 90px; width: 80%;"></div>
							<div style="width: 730px;margin-top: 10px;height:30px;" align="center">
								<label style="margin-left: 20px;">修改的费用（元）：</label>
							    <input id="jyfy" name="jyfy" class="form-control1" style="height: 100%;" onkeyup="value=value.replace(/[^\d.]/g,'') " 
							    placeholder="金额格式,可保留两位小数" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d.]/g,'')">
							</div>
							<div style="width: 670px;margin-top: 10px;height:30px;margin-left: 70px;" align="center">
								<input class="btn btn2 btn-success" type="button" style="margin-left: 3%;" onclick="saveValue();" value="提交">
								<input class="btn btn2 btn-success" type="button" style="margin-left: 3%;" onclick="getClear();" value="清空">
							</div>
						</form>
						</div>
				  </div>
              </section>
              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <!--<script src="js/jquery.js"></script>-->
     <script type="text/javascript" language="javascript" src="<%=path %>/resources/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/resources/bootstrap/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="<%=path %>/resources/bootstrap/js/multiselect.js"></script>
    <script src="<%=path %>/resources/bootstrap/js/multiselect.min.js"></script>
    <script src="<%=path %>/resources/bootstrap/js/prettify.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/index/js/editable-table.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
  	<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
  	<script type="text/javascript">
//   	查询 
  	function getValue(){
			var bgbh=$('#bgbh').val();
			var url = "<%=path%>/ypgl/YYpYpxx/getValue";
			 if(bgbh == null && bgbh=="" ){
       			 alert('请先输入报告编号再查询！');
		      }
			$.ajax({
				 cache: true,
	             type: "POST",
	             url: url,
	             data: {bgbh: bgbh},
	             async: false,
	             error: function (request) {
	                 alert("查询失败,请联系管理员。");
	             },
	             success: function (data) {
// 	            	 alert(data.length);
	            	 if(data.length > 0 ){
	            	 $("#bfjyfy").val(data[0].JYFY);
	            	 $("#id").val(data[0].ID);
	            	 $("#djlx").val(data[0].DJLX);
	            	 $("#bid").val(data[0].BID);
	            	 $("#jyhth").val(data[0].JYHTH);
	            	 if(data[0].YSFJE !=0 && data[0].JYFY != 0){
// 	            		 $("#sfzt").val("已收费");
	            		 document.getElementsByTagName('b')[0].innerHTML = '收费中';
	            	 }
	            	 if(data[0].YSFJE ==data[0].JYFY && data[0].JYFY != 0){
// 	            		 $("#sfzt").val("已收费");
	            		 document.getElementsByTagName('b')[0].innerHTML = '已收费';
	            	 }
	            	 if(data[0].JYHTH != null){
// 	            		 $("#sfzt").val("已收费");
	            		 document.getElementsByTagName('b')[0].innerHTML = '技术协议'+data[0].JYHTH+'扣费';
	            	 }
	            	 }else{
	            		 alert("未查询到符合条件的报告，请校队编号后重新查询！");
	            		 $("#bfjyfy").val("");
		            	 $("#id").val("");
		            	 $("#djlx").val("");
		            	 $("#jyfy").val("");
		            	 $("#jyhth").val("");
		            	 document.getElementsByTagName('b')[0].innerHTML = '';
	            	 }
	             }
		   });
		}
		
	//查看样品信息
	function getLook(){
		    var id = document.getElementById("id").value;
	        var djlx = document.getElementById("djlx").value;
	        var ypbh = document.getElementById("bgbh").value;
// 	        alert(djlx);
	        if(djlx != null && djlx != ""  ){
				window.open('<%=path%>/ypgl/YYpYpxx/ypxxOnLookView?id='+id+'&djlx='+djlx+'&ypbh='+ypbh+'&kobe='+8,"查看样品信息","height=600px, width=1000px,top=100px, left=200px, toolbar=no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no");
	        }else{
	        	alert("请先查询，再查看样品信息！");
	        	return false;
	        }
	}
//   	 清空
  	 function getClear(){
	            	 $("#bfjyfy").val("");
	            	 $("#id").val("");
	            	 $("#djlx").val("");
	            	 $("#jyfy").val("");
	            	 $("#bgbh").val("");
	            	 $("#jyhth").val("");
	            	 document.getElementsByTagName('b')[0].innerHTML = '';
		}
		
//	修改保存检验费用
   	function saveValue(){
 			var bgbh=$('#bgbh').val();
 			var id=$('#id').val();
 			var bid=$('#bid').val();
 			var jyfy=$('#jyfy').val();
 			var bfjyfy=$('#bfjyfy').val();
 			var jyhth=$('#jyhth').val();
 			var url = "<%=path%>/ypgl/YYpYpxx/saveValue";
 			 if(bgbh == null && bgbh=="" ){
        			 alert('请先查询后再修改提交！');
        			 return false;
 		      }else if(jyfy == bfjyfy){
 		    	 alert('并未对检验费用进行修改！');
 		    	 return false;
 		      }
 			if(confirm("确定提交?")){
 			$.ajax({
 				 cache: true,
 	             type: "POST",
 	             url: url,
 	             data: {bgbh: bgbh,id:id,bid:bid,jyfy:jyfy,bfjyfy:bfjyfy,jyhth:jyhth},
 	             async: false,
 	             error: function (request) {
 	                 alert("修改失败,请联系管理员。");
 	             },
 	             success: function (data) {
 	            	 if(data == '1'){
 	            		 alert('修改成功！');
 	            		 $("#bfjyfy").val("");
 		            	 $("#id").val("");
 		            	 $("#jyfy").val("");
 		            	 $("#bgbh").val("");
 		            	 $("#djlx").val("");
 		            	 $("#jyhth").val("");
 		            	 document.getElementsByTagName('b')[0].innerHTML = '';
 	            	 }else if(data == '3'){
 	            		alert('该协议剩余金额不足以支付修改后的检验费用，请核实后提交！');
 	            	 }
 	             }
 		   });
 			}
 		}
  	</script>
  </body>
</html>


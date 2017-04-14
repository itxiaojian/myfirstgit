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
    <script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
	
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
		 var url = "<%=path%>/sjbb/Cbtj/getCbtj";
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
     			var str="<table><thead><tr>"
                  	+"<td style='text-align:center;width:15%;'bgcolor='#32a9eb'><b>科室名称</b></td>"
                  	+"<td style='text-align:center;'bgcolor='#32a9eb'><b>工资薪金</b></td>"
                  	+"<td style='text-align:center;'bgcolor='#32a9eb'><b>差旅费</b></td>"
                  	+"<td style='text-align:center;'bgcolor='#32a9eb'><b>材料工器具</b></td>"
                  	+"<td style='text-align:center;'bgcolor='#32a9eb'><b>办公费</b></td>"
                  	+"<td style='text-align:center;'><b>...</b></td>"
                    +"<td style='text-align:center;'bgcolor='#32a9eb'><b>合计</b></td>"
                    +"</tr></thead><tbody>";
             	for(var i=0;i<data.length;i++){
             		str=str+"<tr>"
             		+"<td style='padding-left: 38px;'><a onclick='ckmx("+data[i].KSBH+")' class='btn btn-xs btn-sucess'>"+ data[i].BMMC+"</a></td>"	
             		+"<td style='text-align:center;'><b>"+data[i].GZXJ+"</b></td>"
             		+"<td style='text-align:center;'><b>"+data[i].CLF+"</b></td>"
             		+"<td style='text-align:center;'><b>"+data[i].CLGQJ+"</b></td>"
             		+"<td style='text-align:center;'><b>"+data[i].BGF+"</b></td>"
             		+"<td style='text-align:center;'><b>...</b></td>"
                    +"<td style='text-align:center;color:red'><b>"+data[i].HJ+"</b></td>"
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
        				var fileName = ksyf+"至"+jsyf+"月成本统计报表";
            	    	var url = "exportCbtj?fileName="+fileName+"&ksmc="+ksmc+"&ksyf="+ksyf+"&jsyf="+jsyf;
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
		.btn-success {
		    background-color: #69dae1;
		    border-color: #69dae1;
		    color: #fff;
		}
		.sliu{
		    color: #69dae1;
		    font-size: 20px;
		    text-align: center;
		    width: 81%;
		}
		.btn-success:hover,.btn-success:focus,.btn-success:active,.btn-success.active,.open .dropdown-toggle.btn-success{
			color: #fff;
			background-color: #32A9EB;
			border-color: #32A9EB
		}
.ZJ_mian_left{ position:absolute; left:-130px; top:0px; bottom:0px;width:130px; background:url(/zjyw/system/layout/img/L_BJ02.png) center no-repeat; background-size:cover;overflow:auto; z-index:5;}
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
              <div class="row" style="width: 83%;">
                  <div class="col-lg-19" style="margin-left: 5px; width: 100%;">
                      <!--work progress start-->
                      <section class="panel" style="overflow: auto; width: 120%">
                          <div class="panel-body" style="border-color:#fff;">
                          </div>
                          <div class="form-group" style="height: 35px; margin-bottom: 0px;margin-left: 60px;">
	                          <label class="col-sm-2 control-label" style="width: 6%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">科&nbsp;&nbsp;室:</label>
							  <div class="col-sm-10" style="width:15%;padding-left: 0px;">
							   <select class="form-control1 m-bot15" name="ksmc" id="ksmc" style="height: 27px;">
							            <option selected="selected" value="">请选择...</option>
								<c:forEach var="ksmc" items="${ksmc}" varStatus="obj">
										<option value="${ksmc.id}">${ksmc.bmmc}</option>
								</c:forEach>
					           </select>
							  </div>
			                  <label class="col-sm-2 control-label" style="width:12%;top: 6px;">开始月份:</label>
							  <div class="col-sm-10" style="width:15%">
							  <% Date date = new Date();
 							     SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM"); 
 							     String strdate = sdate.format(date); %> 
							  <input id="ksyf" name="ksyf" value="<%=strdate%>" style="height:28px;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width:12%;top: 6px;">结束月份:</label>
							  <div class="col-sm-10" style="width:15%">
							  <input id="jsyf" name="jsyf" value="<%=strdate%>" style="height:28px;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width: 20%;">
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="load();" type="button" data-toggle="modal">查询</a>
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px; margin-left: 8%;" onclick="back()" type="button" data-toggle="modal">返回</a>
                              </label>
						  </div>
						  <div id="Div1" name="Div1" style="display:'none'"></div>
                      </section>
                      <!--work progress end-->
                  </div>
              </div>
	</div>
	</div>
	<div class="foot">安徽省产品质量监督检查研究院  皖ICP备08001861号-1  地址：合肥市包河工业园延安路13号  邮政编码：230051  电话：0551-63356268  63855622</div>
	</div>
  </body>
</html>

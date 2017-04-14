<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%> --%>
<%@page contentType="text/html" import="java.util.* ,java.util.Date" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<% String path = request.getContextPath();
Date date = new Date();
 SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-dd");
 String enddate = edate.format(date);%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="Mosaddek">
	<meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<link rel="shortcut icon" href="img/favicon.png">

	<title>移动质检业务管理平台</title>

	<!-- Bootstrap core CSS -->
	<link href="<%=path%>/resources/bootstrap/js/bootstrap.min.css" rel="stylesheet">
	<link href="<%=path%>/resources/bootstrap/js/bootstrap-reset.css" rel="stylesheet">
	<!--external css-->
	<link href="<%=path%>/resources/bootstrap/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/system/login/css/padstyle.css">
	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
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
			box-shadow: none;
			color: #000000;
		}
		.input-lg1 {
			border-radius: 6px;
		}
		.Div5{
			float:left;
		}
		.btn {
			padding: 6px;
		    width: 20% !important;
		}
		.btn2 {
			padding: 6px;
		    width: 20% !important;
		    padding-bottom: 2px; 
		    padding-top: 3px;
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
		.gradeY {
		    color: red;
		    font-family: "Open Sans",sans-serif;
		    font-size: 13px;
		}
		.gradeZ {
		    color: #EDB840;
		    font-family: "Open Sans",sans-serif;
		    font-size: 13px;
		}
		.gradeX {
		    color: green;
		    font-family: "Open Sans",sans-serif;
		    font-size: 13px;
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
.ZJ_mian_left{ position:absolute; left:-130px; top:0px; bottom:0px;width:130px; background:url(/zjyw/system/layout/img/L_BJ02.png) center no-repeat; background-size:cover;overflow:auto; z-index:5;}
	</style>
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>

<body>
<div class="ipad">
    <div class="ZJ_top">
        <span id="L_btn"><img src="<%=path%>/system/layout/img/top_01.png"></span>
        <span>移动质检业务管理平台</span>
        <span><a onclick="exit();"><img src="<%=path%>/system/layout/img/top_03.png"></a></span>
        <span><img src="<%=path%>/system/layout/img/top_02.png">欢迎您：${sessionScope['LOGIN_USER'].xm}&nbsp;&nbsp;</span>
    </div>
    <div class="ZJ_mian" style="height: 94%;">
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
	<!--main content start-->
		<section class="wrapper1" style="height: 100%;">
			<!-- page start-->
			<section class="panel" style="height: 96%;">
				<div style="padding: 15px;">
					<div class="row" style="width:50%;float:left;padding-left: 15px;">
						<form action="" method="post" id="myForm">
							<input id="cxtj" name="cxtj" type="hidden" value=""/>
							<input type="hidden" id="dqsj" value="<%=enddate%>">
							<textarea rows="" cols="" readonly="readonly" id="xsmc" name="xsmc" style="width:100%;height: 100px;resize: none;border: 1px solid #47474d;" class="form-control1 textarea"></textarea>
                            <div class="col-sm-10" style="width: 14%;padding-left: 0px; padding-right: 0px;">
                                <input type="radio" id="xzlb" name="xzlb" value="and"checked="checked" style="margin-left: 2px;"/><label for="and" style="margin-bottom: 0px;margin-left: 4px;">并且</label> 
                                <input type="radio" id="xzlb" name="xzlb" value="or" style="margin-top: 4px;margin-left: 2px;"/><label for="or" style="margin-bottom: 0px;margin-left: 4px;">或</label> 
                            </div>
							<label style="margin-left: 10px;">属性：</label>
							<select class="form-control1 input-lg1 m-bot15 textinput" name="xzzd" id="xzzd" style="width:22%;margin-top: 10px;" onchange="showTj(this.value);">
								<option value="">请选择...</option>
								<c:forEach  var="data" items="${zdmc1}" varStatus="obj" >
									<option value="${data.code}">${data.name}</option>
								</c:forEach>
							</select>
							<label style="margin-left:2px;">条件：</label>
							<select class="form-control1 input-lg1 m-bot15 textinput" name="xztj" id="xztj" style="width:21%;margin-top: 10px;" onchange="showQj(this.value);">
								<option value=">">大于</option>
								<option value="<">小于</option>
								<option value="=">等于</option>
								<option value=">=">大于等于</option>
								<option value="<=">小于等于</option>
								<option value="like" selected>包含</option>
								<option value="not like">不包含</option>
<!-- 								<option value="between">区间</option> -->
							</select>
							<div style="width: 100%;display: block;" id="Div2">
								<div id="Div3">
								</div>
							</div>
							<div style="width: 100%;margin-top: 10px;" align="center">
								<input class="btn btn2 btn-success" type="button"  onclick="addTj();" value="添加条件">
								<input class="btn btn2 btn-success" type="button" style="margin-left: 3%;" onclick="doEmpty();" value="清空条件">
								<input class="btn btn2 btn-success" type="button" style="margin-left: 3%;" onclick="getValue();" value="开始查询">
<!-- 								<input class="btn btn2 btn-success" type="button" style="margin-left: 3%;" onclick="getExcelValue();" value="导出Excel"> -->
							</div>
						</form>
					</div>

					<div class="row" style="width:50%;float:left;margin-left: 3%;">
						<div class="col-xs-5">
							<select name="from" id="multiselect" class="form-control" size="10" multiple="multiple" da style="height: 30px;border: 1px solid #47474d;">
								<c:forEach  var="data" items="${zdmc1}" varStatus="obj" >
									    <option value="${data.code}">${data.name}</option>
								    </c:forEach>
							</select>
						</div>

						<div class="col-xs-2" style="padding-left: 0px;padding-right: 0px;">
							<button type="button" id="multiselect_undo" class="btn1 btn-primary btn-block">撤销</button>
							<button type="button" id="multiselect_rightAll" class="btn1 btn-default btn-block"><img src="<%=path%>/resources/bootstrap/image/allr.png"></img></button>
							<button type="button" id="multiselect_rightSelected" class="btn1 btn-default btn-block"><img src="<%=path%>/resources/bootstrap/image/rig.png"></button>
							<button type="button" id="multiselect_leftSelected" class="btn1 btn-default btn-block"><img src="<%=path%>/resources/bootstrap/image/lep.png"></button>
							<button type="button" id="multiselect_leftAll" class="btn1 btn-default btn-block"><img src="<%=path%>/resources/bootstrap/image/alll.png"></img></button>
							<button type="button" id="multiselect_redo" class="btn1 btn-warning btn-block">恢复</button>
						</div>

						<div class="col-xs-5">
							<select name="to" id="multiselect_to" class="form-control" size="10" multiple="multiple" style="height: 203px;border: 1px solid #47474d;"></select>
						</div>
					</div>
				</div>
				<div class="panel-body" style="margin-top: 200px; padding-bottom: 0px; padding-top: 0px; padding-right: 10px;">
					<div class="adv-table" id="Div1">
						<div id="Div6" style="overflow:auto;height:342px;">
							<table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered" id="table">
								<thead>
								<tr>
								</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						<div id="Div4">
							<div id="table_length" class="dataTables_length" style="float:left;padding-bottom: 0px; padding-top: 0px; margin-top: 6px;">
								<label>
									每页显示
									<select class="form-control" name="size" size="1" aria-controls="table" id="size" style="padding: 0px;" onchange="getValue();">
										<option value="10" selected="selected">10</option>
										<option value="25">25</option>
										<option value="50">50</option>
										<option value="100">100</option>
									</select>
									条
								</label>
							</div>
							<div id="Div5" class="Div5">
								<div id="table_info" class="dataTables_info" style="float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;">显示第 0 到 0条 共0条</div>
								<div id="table_paginate" class="dataTables_paginate paging_two_button" style="float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;">
									<a href="javascript:;" onclick="" class="paginate_disabled_previous">上一页</a>
									<a href="javascript:;" onclick="" class="paginate_enabled_next">下一页</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- page end-->
		</section>
	<!--main content end-->
   	<div class="foot">安徽省产品质量监督检查研究院  皖ICP备08001861号-1  地址：合肥市包河工业园延安路13号  邮政编码：230051  电话：0551-63356268  63855622</div>
    </div>
</div>
</div>

<!-- js placed at the end of the document so the pages load faster -->
<!--<script src="js/jquery.js"></script>-->
<script type="text/javascript" language="javascript" src="<%=path %>/resources/bootstrap/js/jquery.js"></script>
<script src="<%=path %>/resources/bootstrap/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="<%=path %>/resources/bootstrap/js/multiselect.js"></script> 
<script src="<%=path %>/resources/bootstrap/js/multiselect.min.js"></script>
<script src="<%=path %>/resources/bootstrap/js/prettify.min.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    	var path='<%=path%>';
    	var ypjyztzdzList = [];
    	var ypjyztzdmcList = [];
    	
    	var ksidList = [];
    	var bmmcList = [];
    	
    	var ywksidList = [];
    	var ywbmmcList = [];
    	
    	var bgfsfszdzList = [];
    	var bgfsfszdmcList = [];
    	
    	var bzridList = [];
    	var bzrxmList = [];
    	
    	var jylxList = [];
    	<%
    	// 这段可以用EL和JSTL等方法代替
    	List<Map<String,Object>> bzr=(List)request.getAttribute("bzrlist");
    	for (Map<String,Object> currentValue : bzr) {%>
    	// 这段服务器端得部分可以用EL和JSTL代替
    	bzridList.push("<%=currentValue.get("yhbh")%>");
    	bzrxmList.push("<%=currentValue.get("xm")%>");
    	<% } %>
    	
    	<%
    	// 这段可以用EL和JSTL等方法代替
    	List<Map<String,Object>> bgfsfs=(List)request.getAttribute("bgfsfs");
    	for (Map<String,Object> currentValue : bgfsfs) {%>
    	// 这段服务器端得部分可以用EL和JSTL代替
    	bgfsfszdzList.push("<%=currentValue.get("zdz")%>");
    	bgfsfszdmcList.push("<%=currentValue.get("zdmc")%>");
    	<% } %>
    	
    	<%
    	// 这段可以用EL和JSTL等方法代替
    	List<Map<String,Object>> jyks=(List)request.getAttribute("jyksList");
    	for (Map<String,Object> currentValue : jyks) {%>
    	// 这段服务器端得部分可以用EL和JSTL代替
    	ksidList.push("<%=currentValue.get("id")%>");
    	bmmcList.push("<%=currentValue.get("bmmc")%>");
    	<% } %>
    	
    	<%
    	// 这段可以用EL和JSTL等方法代替
    	List<Map<String,Object>> ywks=(List)request.getAttribute("ywksList");
    	for (Map<String,Object> currentValue : ywks) {%>
    	// 这段服务器端得部分可以用EL和JSTL代替
    	ywksidList.push("<%=currentValue.get("id")%>");
    	ywbmmcList.push("<%=currentValue.get("bmmc")%>");
    	<% } %>
    	
    	<%
    	// 这段可以用EL和JSTL等方法代替
    	List<Map<String,Object>> ypjyzt=(List)request.getAttribute("ypjyzt");
    	for (Map<String,Object> currentValue : ypjyzt) {%>
    	// 这段服务器端得部分可以用EL和JSTL代替
    	ypjyztzdzList.push("<%=currentValue.get("zdz")%>");
    	ypjyztzdmcList.push("<%=currentValue.get("zdmc")%>");
    	<% } %>
    	
    	<%
    	// 这段可以用EL和JSTL等方法代替
    	List<Map<String,Object>> jylx=(List)request.getAttribute("jylx");
    	for (Map<String,Object> currentValue : jylx) {%>
    	// 这段服务器端得部分可以用EL和JSTL代替
    	jylxList.push("<%=currentValue.get("zdz")%>");
    	<% } %>
    </script>
<script type="text/javascript" src="<%=path%>/resources/js/tjgl/ypcx.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>

<script type="text/javascript">
	jQuery(document).ready(function($) {
		$('#multiselect').multiselect({
			keepRenderingSort: true
		});
// 			alert(window.screen.width);
		if(window.screen.width=='939'||window.screen.width=='1024'){
			$('#Div6').width('100%');
		}else if(window.screen.width=='1173'||window.screen.width=='1280'){
			$('#Div6').width('100%');
		}else if(window.screen.width=='1360'||window.screen.width=='1247'){
			$('#Div6').width('100%');
		}else if(window.screen.width=='1440'||window.screen.width=='1320'){
			$('#Div6').width('100%');
		}else if(window.screen.width=='1600'||window.screen.width=='1467'){
			$('#Div6').width('100%');
		}else{
			$('#Div6').width('100%');
		}
	});
	
	$("#L_btn").click(function(){
		$("#left_nav").animate({marginLeft:130},1000)
	})
	$("#main_R").click(function(){
		$("#left_nav").animate({marginLeft:0},1000)
	})
	
	function exit(){
// 		success: function () {
	       msg="确定退出？";
       		if(confirm(msg)){
       			location.href="<%=path%>/j_spring_security_logout"
   			}
// 		}
	}
</script>

</body>
</html>


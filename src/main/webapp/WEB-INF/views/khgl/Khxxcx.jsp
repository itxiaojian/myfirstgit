<%@page contentType="text/html" import="java.util.* ,java.util.Date" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<% String path = request.getContextPath();%>
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
	</style>
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>

<body>
<div style="display:none;">
	<ul class="tab-menu tab" id="tabMenuID_">
		<li class="tab-selected" title="客户档案查询">
			<a href="<%=path%>/khgl/khxxcx/openPage" target="content" onfocus="this.blur()"><span>客户档案查询</span></a>
		</li>
	</ul>
</div>
<section id="container" >
	<!--main content start-->
	<section id="main-content1">
		<section class="wrapper1">
			<!-- page start-->
			<section class="panel">
				<header class="panel-heading"><a href="<%=path%>/khgl/khxxcx/openPage" target="content" onfocus="this.blur()"><span>客户信息查询</span></a></header>
				<div style="padding: 15px;">
					<div class="row" style="width:50%;float:left;padding-left: 15px;">
						<form action="" method="post" id="myForm">
							<input id="cxtj" name="cxtj" type="hidden" value=""/>
							<select size="10" id="xsmc" name="xsmc" style="width:100%;height: 100px;resize: none;border: 1px solid #47474d;" class="form-control1 textarea"></select>
							<div class="col-sm-10" style="width: 9%;padding-left: 0px; padding-right: 0px;">
                                <input type="radio" id="xzlb" name="xzlb" value="and"checked="checked"/><label for="and" style="margin-bottom: 0px;margin-left: 4px;">并且</label> 
                                <input type="radio" id="xzlb" name="xzlb" value="or" style="margin-top: 0px;margin-top: 4px;"/><label for="or" style="margin-bottom: 0px;margin-left: 4px;">或</label> 
                            </div>
							<label style="margin-left: 10px;">属性：</label>
							<select class="form-control1 input-lg1 m-bot15 textinput" name="xzzd" id="xzzd" style="width:22%;margin-top: 10px;" onchange="showTj(this.value);">
								<option value="">请选择...</option>
								<c:forEach var="data" items="${zdmc}" varStatus="obj">
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
								<option value="between">区间</option>
							</select>
<!-- 							<label style="margin-left:2px;">类别：</label> -->
<!-- 							<select class="form-control1 input-lg1 m-bot15 textinput" name="xzlb" id="xzlb" style="width:10%;margin-top: 10px;"> -->
<!-- 								<option value="and">与</option> -->
<!-- 								<option value="or">或</option> -->
<!-- 							</select> -->
							<div style="width: 100%;display: block;" id="Div2">
								<div id="Div3">
								</div>
							</div>
							<div style="width: 100%;margin-top: 10px;" align="center">
								<input class="btn btn2 btn-success" type="button"  onclick="addTj();" value="添加条件">
								<input class="btn btn2 btn-success" type="button" style="margin-left: 3%;" onclick="deleteOption(true);" value="删除条件">
								<input class="btn btn2 btn-success" type="button" style="margin-left: 3%;" onclick="doEmpty();" value="清空条件">
								<input class="btn btn2 btn-success" type="button" style="margin-left: 3%;" onclick="getValue();" value="开始查询">
								<input class="btn btn2 btn-success" type="button" style="margin-left: 3%;" onclick="getExcelValue();" value="导出Excel">
							</div>
						</form>
					</div>

					<div class="row" style="width:50%;float:left;margin-left: 3%;">
						<div class="col-xs-5">
							<select name="from" id="multiselect" class="form-control" size="10" multiple="multiple" da style="height: 203px;border: 1px solid #47474d;">
								<c:forEach var="data" items="${zdmc}" varStatus="obj">
									<option value="${data.code}">${data.name}</option>
								</c:forEach>
							</select>
						</div>

						<div class="col-xs-2">
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
				<div class="panel-body" style="margin-top: 248px;">
					<div class="adv-table" id="Div1">
						<div id="Div6" style="overflow-x:auto;">
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
							<div id="table_length" class="dataTables_length" style="float:left;">
								<label>
									每页显示
									<select class="form-control" name="size" size="1" aria-controls="table" id="size" onchange="getValue();">
										<option value="10" selected="selected">10</option>
										<option value="25">25</option>
										<option value="50">50</option>
										<option value="100">100</option>
									</select>
									条
								</label>
							</div>
							<div id="Div5" class="Div5">
								<div id="table_info" class="dataTables_info" style="float:left;margin-top: 6px;">显示第 0 到 0条 共0条</div>
								<div id="table_paginate" class="dataTables_paginate paging_two_button" style="float:left;margin-top: 6px;">
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
	</section>
	<!--main content end-->
</section>

<!-- js placed at the end of the document so the pages load faster -->
<!--<script src="js/jquery.js"></script>-->
<script type="text/javascript" language="javascript" src="<%=path %>/resources/bootstrap/js/jquery.js"></script>
<script src="<%=path %>/resources/bootstrap/js/bootstrap.min.js"></script>
<%--<script class="include" type="text/javascript" src="<%=path %>/resources/bootstrap/js/multiselect.js"></script>--%>
<script src="<%=path %>/resources/bootstrap/js/multiselect.min.js"></script>
<script src="<%=path %>/resources/bootstrap/js/prettify.min.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    	var path='<%=path%>';
    	var idList = [];
    	var mcList = [];
    	
    	<%
    	// 这段可以用EL和JSTL等方法代替
     	List<Map<String,Object>> zjlx=(List)request.getAttribute("zjlx");
     	for (Map<String,Object> currentValue : zjlx) {%>
    	// 这段服务器端得部分可以用EL和JSTL代替
    	idList.push("<%=currentValue.get("zdz")%>");
    	mcList.push("<%=currentValue.get("zdmc")%>");
    	<% } %>
    </script>
<script type="text/javascript" src="<%=path%>/resources/js/khgl/khxxcx.js"></script>
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
</script>
</body>
</html>


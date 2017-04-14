<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
%>
<html eiiebffcjbffiheggaebebgceaeccbia_b="1"
	bdgjjgagedbdaebhbjbcabcdgeeebecf_b="1"
	idceifdedfeiefjgfcjfbchejgbcbeid_b="1">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微海报</title>
<meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wsh/shwhb/bootstrap-custom.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wsh/shwhb/jquery-ui-custom.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wbm/core.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wsh/shwhb/pc_edit.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wbm/home.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wsh/shwhb/index.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wsh/shwhb/edit.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wbm/activity.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wbm/uploadify.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wsh/shwhb/fill.css">
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wsh/shwhb/jquery-1.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wsh/shwhb/jquery-ui-1.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wsh/shwhb/bootstrap.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wsh/shwhb/jquery-ui-1.8.22.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wbm/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wbm/filter.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wbm/global.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wsh/shwhb/home.js"></script>
<script>
jQuery(function($) {
	$("#add_page").click(function() {
		$("#divHidden").show();
	});

	$("#cancel").click(function() {
		$("#divHidden").hide();
	});
	
});
	</script>
</head>

<body>
	<iframe style="display: none;"></iframe>
	<style type="text/css">
.WPA3-SELECT-PANEL {
	z-index: 2147483647;
	width: 463px;
	height: 292px;
	margin: 0;
	padding: 0;
	border: 1px solid #d4d4d4;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 15px #d4d4d4;
}

.WPA3-SELECT-PANEL * {
	position: static;
	z-index: auto;
	top: auto;
	left: auto;
	right: auto;
	bottom: auto;
	width: auto;
	height: auto;
	max-height: auto;
	max-width: auto;
	min-height: 0;
	min-width: 0;
	margin: 0;
	padding: 0;
	border: 0;
	clear: none;
	clip: auto;
	background: transparent;
	color: #333;
	cursor: auto;
	direction: ltr;
	filter:;
	float: none;
	font: normal normal normal 12px "Helvetica Neue", Arial, sans-serif;
	line-height: 16px;
	letter-spacing: normal;
	list-style: none;
	marks: none;
	overflow: visible;
	page: auto;
	quotes: none;
	-o-set-link-source: none;
	size: auto;
	text-align: left;
	text-decoration: none;
	text-indent: 0;
	text-overflow: clip;
	text-shadow: none;
	text-transform: none;
	vertical-align: baseline;
	visibility: visible;
	white-space: normal;
	word-spacing: normal;
	word-wrap: normal;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	-ms-box-shadow: none;
	-o-box-shadow: none;
	box-shadow: none;
	-webkit-border-radius: 0;
	-moz-border-radius: 0;
	-ms-border-radius: 0;
	-o-border-radius: 0;
	border-radius: 0;
	-webkit-opacity: 1;
	-moz-opacity: 1;
	-ms-opacity: 1;
	-o-opacity: 1;
	opacity: 1;
	-webkit-outline: 0;
	-moz-outline: 0;
	-ms-outline: 0;
	-o-outline: 0;
	outline: 0;
	-webkit-text-size-adjust: none;
	font-family: Microsoft YaHei, Simsun;
}

.WPA3-SELECT-PANEL a {
	cursor: auto;
}

.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-TOP {
	height: 25px;
}

.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-CLOSE {
	float: right;
	display: block;
	width: 47px;
	height: 25px;
	background:
		url(http://combo.b.qq.com/crm/wpa/release/3.3/wpa/views/SelectPanel-sprites.png)
		no-repeat;
}

.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-CLOSE:hover {
	background-position: 0 -25px;
}

.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-MAIN {
	padding: 23px 20px 45px;
}

.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-GUIDE {
	margin-bottom: 42px;
	font-family: "Microsoft Yahei";
	font-size: 16px;
}

.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-SELECTS {
	width: 246px;
	height: 111px;
	margin: 0 auto;
}

.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-CHAT {
	float: right;
	display: block;
	width: 88px;
	height: 111px;
	background:
		url(http://combo.b.qq.com/crm/wpa/release/3.3/wpa/views/SelectPanel-sprites.png)
		no-repeat 0 -80px;
}

.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-CHAT:hover {
	background-position: -88px -80px;
}

.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-AIO-CHAT {
	float: left;
}

.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-QQ {
	display: block;
	width: 76px;
	height: 76px;
	margin: 6px;
	background:
		url(http://combo.b.qq.com/crm/wpa/release/3.3/wpa/views/SelectPanel-sprites.png)
		no-repeat -50px 0;
}

.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-QQ-ANONY {
	background-position: -130px 0;
}

.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-LABEL {
	display: block;
	padding-top: 10px;
	color: #00a2e6;
	text-align: center;
}

.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-BOTTOM {
	padding: 0 20px;
	text-align: right;
}

.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-INSTALL {
	color: #8e8e8e;
}
</style>
	<style type="text/css">
.WPA3-CONFIRM {
	z-index: 2147483647;
	width: 285px;
	height: 141px;
	margin: 0;
	background: url(data : image/ png;
	base64
	,iVBORw0KGgoAAAANSUhEUgAAAR0AAACNCAMAAAC9pV6+AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAA
	ADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDU
	uMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPH
	JkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIge
	G1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0
	YW5jZUlEPSJ4bXAuaWlkOjU5QUIyQzVCNUIwQTExRTJCM0FFRDNCMTc1RTI3Nzg4IiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjU5QUIyQzVDNUIwQTExRTJCM0FFRDNCMTc1RTI3Nzg4Ij4gPHhtcE1
	NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6NTlBQjJDNTk1QjBBMTFFMkIzQUVEM0IxNzVFMjc3ODgiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6NTlBQjJDNUE1QjBBMTFFMk
	IzQUVEM0IxNzVFMjc3ODgiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE
	+IDw/eHBhY2tldCBlbmQ9InIiPz6QoyAtAAADAFBMVEW5xdCkvtNjJhzf6Ozo7/LuEQEhHifZ1tbv8vaibw7/9VRVXGrR3en4+vuveXwZGCT///82N0prTRrgU0MkISxuEg2uTUqvEwO2tbb2mwLn0dHOiQ
	nExMacpKwoJzT29/n+qAF0mbf9xRaTm6abm5vTNBXJ0tvFFgH/KgD
	+ugqtra2yJRSkq7YPDxvZGwDk7O//2zfoIgH7/f1GSV6PEAhERUtWWF2EiZHHNix1dXWLk53/ySLppQt/gID9IAH7Mgj0JQCJNTTj4+QaIi0zNDr/0Cvq9f/s
	+/5eYGrn9fZ0eYXZ5O3/tBD8/f5udHy6naTV2t9obHl8gY9ubW/19fXq8fXN2uT/5z/h7PC2oaVmZWoqJR6mMCL3+f33KQM1Fhr6NRT9///w/v/ftrjJDQby9vpKkcWHc3vh7vvZ5uvpPycrMEHu7/De7fn
	e5+709voyKSTi7PVbjrcuLTnnNAzHFhD7/P3aDwDfNxTj6vHz9fj09vj3///19/ny9PevuMI9PEPw8/bw8vbx9PdhYWHx8/fy9ff19vj19vny9fjw8/fc6fOosbza5/LX5fDV4+/U4u7S4e3R4O3O3uvd6v
	Te6vTd6fPb6PPb6PLW5PDZ5/HW5O/Z5vHV5O/T4e7T4u7Y5vHY5fHO3evR4OzP3+vP3uvQ3+xGt/9Lg7Dz9vjv8/X7+/3d5+vi6+7g6ezh6u3w9Pbc5+rt8vTl7fDn7vHr8fP2+Pr3+fv6+/zq8PPc5urb5
	en4+/7Y5epGsvjN3erW4OXf6+/s8/bn8PPk7vLv9fiAyfdHrO6Aorz09vnx9fnz9Pb09/vv8fVHsfd+zP/jwyLdExFekLipYWLN3OjR3Oa0k5n/9fXX6PDh7vDU4ey6fAzV4+5HOSHIoBP
	+/v3b6OppaGrT4Ovk6/Lw8PE8P1Pz
	+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
	AAAABJRU5ErkJggg==)
	no-repeat;
}

.WPA3-CONFIRM {
	*background-image:
		url(http://combo.b.qq.com/crm/wpa/release/3.3/wpa/views/panel.png);
}

.WPA3-CONFIRM * {
	position: static;
	z-index: auto;
	top: auto;
	left: auto;
	right: auto;
	bottom: auto;
	width: auto;
	height: auto;
	max-height: auto;
	max-width: auto;
	min-height: 0;
	min-width: 0;
	margin: 0;
	padding: 0;
	border: 0;
	clear: none;
	clip: auto;
	background: transparent;
	color: #333;
	cursor: auto;
	direction: ltr;
	filter:;
	float: none;
	font: normal normal normal 12px "Helvetica Neue", Arial, sans-serif;
	line-height: 16px;
	letter-spacing: normal;
	list-style: none;
	marks: none;
	overflow: visible;
	page: auto;
	quotes: none;
	-o-set-link-source: none;
	size: auto;
	text-align: left;
	text-decoration: none;
	text-indent: 0;
	text-overflow: clip;
	text-shadow: none;
	text-transform: none;
	vertical-align: baseline;
	visibility: visible;
	white-space: normal;
	word-spacing: normal;
	word-wrap: normal;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	-ms-box-shadow: none;
	-o-box-shadow: none;
	box-shadow: none;
	-webkit-border-radius: 0;
	-moz-border-radius: 0;
	-ms-border-radius: 0;
	-o-border-radius: 0;
	border-radius: 0;
	-webkit-opacity: 1;
	-moz-opacity: 1;
	-ms-opacity: 1;
	-o-opacity: 1;
	opacity: 1;
	-webkit-outline: 0;
	-moz-outline: 0;
	-ms-outline: 0;
	-o-outline: 0;
	outline: 0;
	-webkit-text-size-adjust: none;
}

.WPA3-CONFIRM * {
	font-family: Microsoft YaHei, Simsun;
}

.WPA3-CONFIRM .WPA3-CONFIRM-TITLE {
	height: 40px;
	margin: 0;
	padding: 0;
	line-height: 40px;
	color: #2b6089;
	font-weight: normal;
	font-size: 14px;
	text-indent: 80px;
}

.WPA3-CONFIRM .WPA3-CONFIRM-CONTENT {
	height: 55px;
	margin: 0;
	line-height: 55px;
	color: #353535;
	font-size: 14px;
	text-indent: 29px;
}

.WPA3-CONFIRM .WPA3-CONFIRM-PANEL {
	height: 30px;
	margin: 0;
	padding-right: 16px;
	text-align: right;
}

.WPA3-CONFIRM .WPA3-CONFIRM-BUTTON {
	position: relative;
	display: inline-block !important;
	display: inline;
	zoom: 1;
	width: 99px;
	height: 30px;
	margin-left: 10px;
	line-height: 30px;
	color: #000;
	text-decoration: none;
	font-size: 12px;
	text-align: center;
}

.WPA3-CONFIRM .WPA3-CONFIRM-BUTTON-FOCUS {
	width: 78px;
}

.WPA3-CONFIRM .WPA3-CONFIRM-BUTTON .WPA3-CONFIRM-BUTTON-TEXT {
	line-height: 30px;
	text-align: center;
	cursor: pointer;
}

.WPA3-CONFIRM-CLOSE {
	position: absolute;
	top: 7px;
	right: 7px;
	width: 10px;
	height: 10px;
	cursor: pointer;
}
</style>
	<form id="context-data-form" class="none">
		<input name="context" value="http://weixiao.qq.com" type="hidden">
	</form>
	<div id="header-management"></div>
	<div class="container">
		<div class="row home-container">
			<div class="span2"></div>
			<div class="span12">
				<div class="right-content">

					<!--模板不同edit_mobile不同-->

					<h3 class="bread-crumb">
						
	<a href="<%=path%>/wsh/ShWhb/toCreatWhb">微海报</a>
						<span class="gt"> &gt; </span> ${poster_name}
					</h3>
					<section class="container-fluid border-1scbcbcb">
						<section class="row-fluid">
							<div class="span2">
								<img
									src="${photo_route}"
									class="img_size">
							</div>
							<div class="span10 p15">
								<p class="lh30">
									<strong> ${poster_name} </strong>
								</p>
								<p class="lh30">背景音乐：
								<c:if test="${music_name==''}">未选择音乐</c:if>
								${music_name}</p>
								<a class="edit-to float-right"
									href="">
									<img
									src="<%=path%>/resources/js/wsh/shwhb/icon-edit.png">
									编辑
								</a>
							</div>
						</section>
					</section>
					<section id="vue_edit" class="vue_edit">
						<!--v-if-start-->
						<!--v-if-end-->
						<!--v-if-start-->
						<!--v-if-end-->
						<!--v-if-start-->
						<div id="divHidden" style="display:none;">
						<section class="add_page_sections">
							<section class="add_section_box">
								<section>
									<span>请选择页面模板</span> <i id="cancel" class="add_cancel iconfontEdit"><img
											style="width: 25px; height: 25px;"
											src="<%=path%>/resources/js/wsh/shwhb/cancel.png"></i>
								</section>
								<section class="add_templates_box">
									<section class="add_crosswise">
										<section class="add_templates"
											data-poster_template_section_id="27">
											<img id="photo1"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section1.jpg">
											<p>单图片</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel1"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="28">
											<img id="photo2"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section2.jpg">
											<p>上图下文白底</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel2"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="29">
											<img id="photo3"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section3.jpg">
											<p>上图下文红底</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel3"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="30">
											<img id="photo4"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section4.jpg">
											<p>中部文字</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel4"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="31">
											<img id="photo5"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section5.jpg">
											<p>暗底白字</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel5"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="32">
											<img id="photo6"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section6.jpg">
											<p>文字封面</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel6"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="33">
											<img id="photo7"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section7.jpg">
											<p>黑板报</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel7"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="34">
											<img id="photo8"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section8.jpg">
											<p>白底暗字</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel8"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="35">
											<img id="photo9"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section9.jpg">
											<p>白底黑板报</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel9"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="36">
											<img id="photo10"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section10.jpg">
											<p>靠下粗白</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel10"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="37">
											<img id="photo11"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section11.jpg">
											<p>靠下白底黑字</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel11"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="38">
											<img id="photo12"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section12.jpg">
											<p>靠下斜白底黑字</p>
											<i class="add_sure iconfontEdit"></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="39">
											<img
												src="<%=path%>/resources/js/wsh/shwhb/cover_section13.jpg">
											<p>分享页面</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel12"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="49">
											<img id="photo13"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section14.jpg">
											<p>文字组合左下</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel13"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="50">
											<img id="photo14"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section15.jpg">
											<p>文字组合右上</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel14"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="51">
											<img id="photo15"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section16.jpg">
											<p>黑底白字下方</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel15"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<section class="add_templates"
											data-poster_template_section_id="52">
											<img id="photo16"
												src="<%=path%>/resources/js/wsh/shwhb/cover_section17.jpg">
											<p>竖版文字左方</p>
											<i class="add_sure iconfontEdit"><img
													id="click_cancel16"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
										</section>
										<!--v-repeat-->
									</section>
								</section>
								<a class="btn btn-success add_choose">确定</a>
							</section>
						</section>
						</div>
						<!--v-if-end-->
						<section class="edit_block" id="edit_block">
							<section class="page_choose">
								<!--v-repeat-->
								<div class="add_page" id="add_page">+</div>
							</section>
							<!--v-repeat-->
							<!--v-if-start-->
							<section class="notify_create">点击上方加号添加新页面</section>
							<!--v-if-end-->
						</section>
						<section class="phone" id="phone">
							<section class="phone_ac">
								<span>页面预览</span> <a class="a_preview" id="preview"> <i
									class="iconfontPhone icon_phone"><img
											style="width: 32px; height: 32px;"
											src="<%=path%>/resources/js/wsh/shwhb/mobile.png"></i> <span id="preview_text">手机预览海报</span>
								</a>
							</section>
							<section id="qrcode" class="qrcode">
								<div id="pre_qrcode"></div>
								"
							</section>
							<!--v-if-start-->
							<section class="section-drag"></section>
							<!--v-if-end-->
							<!--v-repeat-->
							<a class="a_publish" id="a_publish">发布</a>
						</section>
					</section>
					<!-- 海报id -->
					<script>
						window.general = "1";
						window.poster_id = "12655";
						window.template_id = "2";
						window.absolute_url = "http://weixiao.qq.com/home/14506/activity/";
						window.timestamp = "";
						window.token = "c98226ab72302c9c5ab98306274de032";
					</script>

					<script type="text/javascript"
						src="<%=path%>/resources/js/wsh/shwhb/jquery.js"></script>
					<script type="text/javascript"
						src="<%=path%>/resources/js/wsh/shwhb/vue.js"></script>
					<script type="text/javascript"
						src="<%=path%>/resources/js/wsh/shwhb/ajax.js"></script>
					<script type="text/javascript"
						src="<%=path%>/resources/js/wsh/shwhb/qrcode.js"></script>
					<script type="text/javascript"
						src="<%=path%>/resources/js/wsh/shwhb/vue_edit.js"></script>
				</div>
			</div>
		</div>
	</div>

	<style>
.version-modal {
	padding-bottom: 20px;
}

.version-modal .version-model-body {
	padding: 20px;
	margin-bottom: 20px;
	max-height: 100%;
}

.version-modal .version-model-body ul,.version-modal .version-model-body ol
	{
	margin: 14px 0 14px 0;
	padding: 0 0 0 40px;
}

.version-modal .version-model-body ul,.version-modal .version-model-body ul li
	{
	list-style: disc;
}

.version-modal .version-model-body ol,.version-modal .version-model-body ol li
	{
	list-style: decimal;
}

.version-header {
	height: 70px;
	text-align: center;
	background-color: #f3f3f3;
}

.version-publish-date {
	color: #ac7b53;
	margin-bottom: 10px;
}

.version-sure-btn {
	margin-left: 40%;
	margin-right: 40%;
	background-color: #ff900c;
	color: #fff;
	font-size: 13px;
	padding: 10px;
	border-radius: 5px;
	cursor: pointer;
}
</style>
	<!-- start 用户第一次接入时候显示二维码，扫描关注可以获得微校新手帮助大礼包 -->
	<div class="hide qrcode-dialog" id="qrcode_dialog">
		<div class="qrcode-shadow"></div>
		<div class="qrcode">
			<a href="javascript:void(0);" class="qrcode-close">X</a>
			<p class="qrcode-tips">
				<img
					src="<%=path%>/resources/js/wsh/shwhb/success.png">&nbsp;&nbsp;成功接入微校
			</p>
			<img class="qrcode-check"
				src="<%=path%>/resources/js/wsh/shwhb/showqrcode.txt">
			<p>微信扫一扫二维码</p>
			<p>
				获取<span class="qrcode-gift">微校新手大礼包</span>
			</p>
		</div>
	</div>
	<script type="text/javascript" charset="UTF-8">
		jQuery(function($) {
			function showUpdateDialog() {
				var is_show = 0;
				if (is_show) {
					$('.version-modal').modal({
						backdrop : 'static',
						keyboard : false
					});
					$('.version-modal').modal('show');
				}
				$('#sure')
						.click(
								function() {
									$
											.ajax({
												type : 'post',
												data : {
													"publish_date" : $(
															'.version-publish-date')
															.attr("data-time")
												},
												dataType : 'json',
												url : "http://weixiao.qq.com/home/14506/index/set_version",
												success : function(data) {
													$('.version-modal').modal(
															'hide');
												}
											});
								});
			}

			var $qrcode = $('#qrcode_dialog');
			var $close = $('.qrcode-close');
			// 获取url参数
			function getUrlParam(name) {
				var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
				var r = window.location.search.substr(1).match(reg);
				if (r != null)
					return r[2];// unescape(r[2]);
				return null;
			}
			if (getUrlParam('qrcode')) {
				$qrcode.removeClass('hide');
				$close.click(function() {
					$qrcode.addClass('hide');
					showUpdateDialog();
				});
			} else {
				showUpdateDialog();
			}
		});
	</script>
	<!-- end -->
	<script type="text/javascript"
		src="<%=path%>/resources/js/wsh/shwhb/stats"
		charset="UTF-8"></script>
</body>
</html>
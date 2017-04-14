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
	href="<%=path%>/resources/js/wbm/home.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wsh/shwhb/fill.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wsh/shwhb/edit.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wsh/shwhb/index.css">

<script type="text/javascript"
	src="<%=path%>/resources/js/wsh/shwhb/jquery-1.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wsh/shwhb/bootstrap.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wsh/shwhb/jquery-ui-1.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wsh/shwhb/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wbm/filter.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wbm/global.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wsh/shwhb/home.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet"
	type="text/css" id="theme" themeColor="lightBlue" />
<link href="<%=path%>/resources/css/base.css" rel="stylesheet" />
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	jQuery(function($) {
		$(".create_poster").click(function() {
			$("#divHidden").show();
		});

		$(".cancel").click(function() {
			$("#divHidden").hide();
		});
		
	});
</script>

<script type="text/javascript">
	jQuery(function($) {
		var flag = true;
		var div = document.getElementById("click_cancel1");
		var div1 = document.getElementById("click_cancel2");
		var div2 = document.getElementById("click_cancel3");
		// var div3=document.getElementById("click_cancel4"); 
		$("#photo1").click(function() {
			if (flag) {
				div.style.display = "block";
				div1.style.display = "none";
				div2.style.display = "none";
				// div3.style.display="none"; 
			} else {
				div.style.display = "none";
			}
			flag = !flag;
		});
		$("#photo2").click(function() {
			if (flag) {
				div1.style.display = "block";
				div.style.display = "none";
				div2.style.display = "none";
			} else {
				div1.style.display = "none";
			}
			flag = !flag;
		});
		$("#photo3").click(function() {
			if (flag) {
				div2.style.display = "block";
				div.style.display = "none";
				div1.style.display = "none";
			} else {
				div2.style.display = "none";
			}
			flag = !flag;
		});
		/* $("#photo4").click(function() {
			if(flag) 
		        div3.style.display="block"; 
		    else 
		        div3.style.display="none"; 
			 flag=!flag; 
		}); */
		
		/* $(".tem_choose").click(function(){
			var a=div.style.display = "none";
			var b=div1.style.display = "none";
			var c=div2.style.display = "none";
			if(a && b && c){
				alert('请选择模板!');
				return false;
				}
			$('#formId').submit();
		}); */
	});
	
	   function deleteTem(id){
			   if(confirm("您确定要删除吗？")){
				   $.ajax({
						cache : true,
						type : "POST",
						url : "<%=path%>/wsh/ShWhb/deleteMb",
						data : {
							id:$('.myform'+id).val(),},
						async : false,
						error : function(request) {
							alert("网络错误,删除错误!");
						},
						success : function(data) {
								window.self.location="<%=path%>/wsh/ShWhb/toCreatWhb";
								 alert("删除成功!");
						}
							});
				   }
	   }
	   function conMb(){
		   var div= document.getElementById("click_cancel1");
		   var div1 = document.getElementById("click_cancel2");
		   var div2 = document.getElementById("click_cancel3");
		   var a=div.style.display;
		   var b=div1.style.display;
		   var c=div2.style.display;
		 //  alert(typeof(a));
			if(a=='none' && b=='none' && c=='none'){
				alert('请选择模板!');
				return false;
				}
			$('#formId').submit();
	   }
</script>
</head>

<body>
	<iframe style="display: none;"></iframe>
	<div style="display:none;">
	<ul class="tab-menu tab" id="tabMenuID_">
		<li class="tab-selected" title="微海报">
		<a href="<%=path%>/wsh/ShWhb/toCreatWhb" target="content" onfocus="this.blur()"><span>微海报</span></a>
		</li>
	</ul>
	</div>
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
	background:
		url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAR0AAACNCAMAAAC9pV6+AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjU5QUIyQzVCNUIwQTExRTJCM0FFRDNCMTc1RTI3Nzg4IiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjU5QUIyQzVDNUIwQTExRTJCM0FFRDNCMTc1RTI3Nzg4Ij4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6NTlBQjJDNTk1QjBBMTFFMkIzQUVEM0IxNzVFMjc3ODgiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6NTlBQjJDNUE1QjBBMTFFMkIzQUVEM0IxNzVFMjc3ODgiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6QoyAtAAADAFBMVEW5xdCkvtNjJhzf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)
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

	<div class="container">
		<div class="row home-container">
			<div class="span2"></div>
			<div class="span12">
				<div class="right-content">
					<div id="poster_model">
						<!--v-if-start-->
						<!--v-if-end-->
						<!--v-if-start-->
						<!--v-if-end-->
						<!-- <section class="page_tips error" v-if="is_show_notify"
							v-transition>
							<div class="inner" v-model="notify_text"></div>
						</section>
						<section class="page_tips error success" v-if="is_show_success"
							v-transition>
							<div class="inner" v-model="notify_text"></div>
						</section> -->
						<form action="<%=path%>/wsh/ShWhb/toSaveWhb" method ="post" id="formId">
						<div style="display: none" id="divHidden">
							<section id="poster_choose" class="poster_choose"
								style="height: 100%" v-transition>
								<section class="tem_box">
									<section>
										<span class="tem_title">请选择海报模板</span> <i
											class="cancel iconfont" v-on="click: hide_choose_templates"><img
											style="width: 32px; height: 32px;"
											src="<%=path%>/resources/js/wsh/shwhb/cancel.png">
											</i>
									</section>
									<c:if test="${empty listMb}">没有模板！</c:if>
									<section class="tems">
										<c:forEach var="data" begin="0" end="2" step="1" items="${listMb}" varStatus="status">

											<div class="tem" data-template_id="${data.id}"
												id="photo${status.count }">
												<img class="photo" src='${data.mbtp}' />
												<p class="tem_name">${data.bz}</p>
												<i class=" iconfont"><img
													id="click_cancel${status.count}"
													style="width: 32px; height: 32px; display: none;"
													src="<%=path%>/resources/js/wsh/shwhb/confirm.png" /></i>
											</div>
										</c:forEach>
									</section>
									<input class="btn btn-success add-apply-btn tem_choose"
									style= "top:-25px; position:relative;width:95px;height:27px"
										 type="button" value="确定" onClick="conMb()"/>
								</section>
							</section>
						</div>
						</form>
						<!--v-if-start-->
						<!--v-if-end-->
						<section class="create_title">
							<h3 class="title_name">微海报</h3>
							<a class="btn btn-success add-apply-btn create_poster">+创建海报</a>
						</section>
						<!--v-if-start-->
						<!--v-if-end-->
						<!--v-if-start-->
						<!--v-if-end-->
						<!--v-if-start-->
						<c:if test="${empty list}">
						</c:if>
						<c:if test="${!empty list}">
							<section class="unpublished">
								<h1>未发布</h1>
								<section class="unpublished_list">
									<c:forEach var="data" items="${list}" varStatus="obj">
										<div class="unpublished_lists">
											<a href="/wxpt/wsh/ShWhb/toAddWhb"><img
												src='${data.mbtp}' data-poster_id="12536"></a>
											<section class="lists_inf">
												<p>${data.bz}</p>
												<div>
													<span class="time">${data.cjsj}</span> <i
														class="iconfont delete" data-poster_id="12536"
														onClick="deleteTem(${data.id})">
														<img style="width: 15px; height: 15px;"
														src="<%=path%>/resources/js/wsh/shwhb/delete.png"></i> <a
														href="/wxpt/wsh/ShWhb/toAddWhb"><i
														class="iconfont edit"><img style="width: 15px; height: 15px;"
														src="<%=path%>/resources/js/wsh/shwhb/modify.png"></i> </a>
														<input value="${data.id}" class="myform${data.id}" name="id" style="display:none;"/>
												</div>
											</section>
										</div>
									</c:forEach>
									<!--v-repeat-->
								</section>
							</section>
						</c:if>
						<!--v-if-end-->
						<!--v-if-start-->
						<c:if test="${empty map}">
							<section class="published">
								<h1>已发布</h1>
								<!--v-if-start-->
								<section class="published_none">
									<img src="<%=path%>/resources/js/wsh/shwhb/info.png">
									<h2 class="none_title">还没有发布微海报</h2>
									<h2 class="none_title1">赶快发布微海报，和大家一起分享和传播吧！</h2>
								</section>
								<!--v-if-end-->
								<section class="published_list">
									<!--v-repeat-->
								</section>
							</section>
						</c:if>
						<!--v-if-end-->
						<c:if test="${! empty map}">
							<section class="published">
								<h1>已发布</h1>
								<section class="published_list">
									<!--v-repeat-->
									<c:forEach var="data" items="${map}" varStatus="obj">
										<div class="unpublished_lists">
											<a href="/wxpt/wsh/ShWhb/toAddWhb"><img
												src='${data.mbtp}' data-poster_id="12536"></a>
											<section class="lists_inf">
												<p>${data.bz}</p>
												<div>
													<span class="time">${data.cjsj}</span> <i
														class="iconfont delete" data-poster_id="12536"
														onClick="deleteTems('${data.id}')">
														<img style="width: 15px; height: 15px;"
														src="<%=path%>/resources/js/wsh/shwhb/delete.png"></i> <a
														href="/wxpt/wsh/ShWhb/toAddWhb"><i
														class="iconfont edit"><img style="width: 15px; height: 15px;"
														src="<%=path%>/resources/js/wsh/shwhb/modify.png"></i> </a>
												</div>
												<input value="${data.id}" class="myform" name="id" style="display:none;"/>
											</section>
										</div>
									</c:forEach>
								</section>
							</section>
						</c:if>
					</div>
					<script>
						window.absolute_url = "http://weixiao.qq.com/home/14506/activity/";
					</script>
					<script type="text/javascript"
						src="<%=path%>/resources/js/wsh/shwhb/qrcode.js"></script>
					<script type="text/javascript"
						src="<%=path%>/resources/js/wsh/shwhb/vue.js"></script>
					<script type="text/javascript"
						src="<%=path%>/resources/js/wsh/shwhb/vue_index.js"></script>
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
	<script type="text/javascript"
		src="<%=path%>/resources/js/wsh/shwhb/stats" charset="UTF-8"></script>
	<script charset="utf-8" src="<%=path%>/resources/js/wsh/shwhb/wpa.php"></script>
	<script type="text/javascript"
		src="<%=path%>/resources/js/wsh/shwhb/stats" charset="UTF-8"></script>

</body>
</html>
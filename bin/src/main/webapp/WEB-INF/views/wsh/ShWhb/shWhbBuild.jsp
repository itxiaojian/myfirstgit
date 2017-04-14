<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
%>
<%
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
	String value = formatter.format(currentTime); //将日期时间格式化
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
<script type="text/javascript">
	(function(w) {
		w._config = {
			SYS_PATH : 'http://weixiao.qq.com'
		};

		w.get_config = function(name, default_value) {
			default_value = default_value ? default_value : null;
			return _config[name] ? _config[name] : default_value;
		};

		w.add_config = function(name, value) {
			_config[name] = value;
		}
	})(window);
</script>

<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wbm/bootstrap-custom.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wsh/shwhb/jquery-ui-custom.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wbm/core.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wbm/home.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wsh/shwhb/edit.css">
<script type="text/javascript"
	src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wsh/shwhb/fill.css" />

<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wbm/activity.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/js/wsh/shwhb/uploadify.css" />

<script type="text/javascript"
	src="<%=path%>/resources/js/wsh/shwhb/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wbm/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wsh/shwhb/jquery-ui-1.8.22.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wbm/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wbm/filter.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/wbm/jquery.uploadify.min.js"></script>
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
<script type="text/javascript"
	src="<%=path%>/resources/js/ajaxfileupload.js"></script>
<script type="text/javascript">
    var i=0;
    function toAddImg(){
    	if(i>=0){
    		if ($("#file1").val().length > 0) {
    			$("#file1").val("");
    		}
    	}
    	$("#file1").click();
    }
    function selectFile(){
    	if ($("#file1").val().length > 0) {
            ajaxFileUpload();
            i++;
        } else {
            alert("请选择图片");
        }
    }
    function ajaxFileUpload() {
        $.ajaxFileUpload({
            url : '<%=path%>/wsh/upload/tempimg', //用于文件上传的服务器端请求地址
			secureuri : false, //一般设置为false
			fileElementId : 'file1', //文件上传空间的id属性  <input type="file" id="file" name="file" />
			type : 'post',
			dataType : 'HTML', //返回值类型 一般设置为json
			success : function(data, status) //服务器成功响应处理函数
			{

				$("#poster_template_cover").attr("src", data);
				$("#fileName").val(data);
				$("#file1").val("");
				if (typeof (data.error) != 'undefined') {
					if (data.error != '') {
						alert(data.error);
					} else {
						alert(data.msg);
					}
				}
			},
			error : function(data, status, e)//服务器响应失败处理函数
			{
				alert(e);
			}
		})
		return false;
	}
</script>

<script type="text/javascript">
	jQuery(function($) {
		//背景音乐打开
		$(".switch").click(function() {
			$("#divHidden").show();
		});
         //背景音乐框的叉的取消按钮
		$(".music_cancel").click(function() {
			$("#divHidden").hide();
		});
         //添加背景音乐的保存按钮
		$("#music_save").click(function() {
			var radioes = $('input:radio:checked').val();
			if (radioes == '' || radioes == null) {
				alert("请选择一个音乐！");
				return false;
			}
			$("#divHidden").hide();
			var a = $('input:radio:checked').next('span').text();
			$('#music_name_hidden').val(a);
			$('#music_name').text(a);
			$('#music_select').show();
			$('#switch_img').show();
			$('.switch').hide();
		});
         //选择音乐 的链接
		$("#music_select").click(function() {
			$("#divHidden").show();
		});
		//背景开关的显示与消失
		$("#switch_img").click(function(){
			$("#switch_img").hide();
			$(".switch").show();
			$('input:radio:checked').val('');
			$('#music_select').hide();
			var small= $('#music_id');
		    for (var i = 0; i < small.length; i++) {
		            small[i].checked = false;
		    }
		    $('#music_name').text('');
		});
	});

	function valite() {
		var name = $('#poster_name').val();
		if (name == '' | name == null) {
			alert('请输入海报名称!');
			return false;
		}
		/* var a = $('#file1').val();
		if(a=='' || a==null){
		alert('请选择一个图片!');
		return false;
		}  */
		$('#publish-form').submit();
	}
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

					<h3>创建微海报</h3>
					<section>
						<header class="inf_title">微海报基本信息</header>
						<form id="publish-form" action="<%=path%>/wsh/ShWhb/toAddWhb"
							method="post">
							<!--v-if-start-->
							<!--v-if-end-->

							<!-- music_alert_box -->
							<div id="divHidden" style="display: none">
								<section class="music_choose" height="70% " v-transition>
									<section class="music_box">
										<section>
											<span class="music_title">选择背景音乐</span> <i
												class="music_cancel iconfont"
												v-on="click: hide_choose_music"> <img id=""
												style="width: 32px; height: 32px;"
												src="<%=path%>/resources/js/wsh/shwhb/cancel.png" />
											</i>
											<c:if test="${empty list}">
												<p>没有添加背景音乐</p>
											</c:if>
										</section>
										<c:forEach var="data" items="${list}" varStatus="obj">
											<section>
												<div>
													<label for="music_${data.id} "> <input
														id="music_id" type="radio" name="music"
														value="${data.fjlj}" /> <span>${data.fjmc}</span><span
														class="listen_music"> </span>
													</label>
												</div>
											</section>
										</c:forEach>
										<input type="button" id="music_save" value="保存"
											style="width: 45px; height: 24px; align: center; left-margin: 99px;"
											class="btn btn-success" />
									</section>
								</section>
							</div>
							<!-- music_alert_box -->

							<label for="poster_name"> <span class="notify_import">*</span>
								<span class="poster_name_notify">海报名称： </span> <input
								id="poster_name" class="poster_name" name="poster_name" value=""
								style="overfolw: visible; height: 25px; width: 140px;"
								type="text"> <!--v-if-start--> <!--v-if-end-->
							</label> <br />
							<div class="poster_music">
								背景音乐： <span class="switch" style="display:marker"> <span class="switch_st"></span></span>
								&nbsp;&nbsp;&nbsp;<img id="switch_img" style="width: 6%; height: 13%; display: none;cursor:pointer;"
									src="<%=path%>/resources/js/wsh/shwhb/switch.png" />
								&nbsp;&nbsp;&nbsp; <span id="music_name"
									style="font-size: 15px; opacity: 0.5;"></span>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span
									style="font-size: 13px; cursor: pointer; text-decoration: underline; display: none; color: #0866AE"
									id="music_select">选择音乐</span>
								<!--v-if-start-->
								<!--v-if-end-->
								<!--v-if-start-->
								<!--v-if-end-->
							</div>
							<br />
							<!-- 							<div class="upload-box bg-green"> -->
							<!-- 								<ul id="upload-img-list" -->
							<!-- 									class="upload-img-list group border-box" -->
							<!-- 									style="position: relative;"> -->
							<!-- 									<li> -->
							<!-- 										<div id="add-product-image" class="btn-add-img" -->
							<!-- 											style="z-index: 1;" onclick="toAddImg();"> -->
							<!-- 											<span class="notify_import">*</span>  -->
							<!-- 											<img id="img1" -->
							<!-- 												alt="海报封面:" src="" align="center" -->
							<!-- 												style="height: 100%; text-align: center;" /> -->
							<!-- 										</div> -->
							<!-- 									</li> -->
							<!-- 									<div id="uploadDiv" class="controls upload" -->
							<!-- 										style="position: absolute; top: 25px; left: 35px; width: 163px; height: 161px; overflow: hidden; z-index: 0;"> -->
							<!-- 										<input id="file1" name="file" type="file"  -->
							<!-- 											style="font-size: 999px; opacity: 0; position: absolute; top: 0px; left: 0px; width: 100%; height: 100%;" -->
							<!-- 											accept="image/*" capture="camera" onchange="selectFile();"> -->
							<!-- 									</div> -->
							<!-- 								</ul> -->
							<!-- 							</div> -->

							<div class="poster_img">
								<div>
									<span class="poster_cover">海报封面：</span> <img
										id="poster_template_cover" class="poster_template_cover"
										src="<%=path%>/resources/js/wsh/shwhb/template_cover_002.jpg" />
									<div id="uploader" class="uploadify"
										style="height: 30px; width: 80px;">
										<div id="uploadify-button">
											<span class="uploadify-button-text" onclick="file1.click()"
												style="cursor: pointer;">上传图片</span>
											<div style="display: none;">
												<input id="file1" name="file" type="file"
													font-size: 999px; opacity: 0; position:
													absolute; top: 0px; left: 0px; width: 100%; height: 100%;" 
		 											accept="image/*"
													capture="camera" onchange="selectFile();">
											</div>
										</div>
									</div>
								</div>

							</div>
							<br /> <br />
							<div class="poster_input">
								<input type="button" value="创建海报" id="create_submit"
									onClick="valite()" class="btn btn-success create" /> <input
									name="music_id" value="" type="hidden"> <input
									name="music_name" id="music_name_hidden" value="" type="hidden">
								<input name="fileName" id="fileName" value="" type="hidden">

							</div>
						</form>

					</section>

					<script type="text/javascript"
						src="<%=path%>/resources/js/wsh/shwhb/vue.min.js"></script>
					<script type="text/javascript"
						src="<%=path%>/resources/js/wsh/shwhb/vue_fill.js"></script>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
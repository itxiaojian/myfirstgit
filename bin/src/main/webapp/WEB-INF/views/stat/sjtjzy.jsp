<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,user-scalable=no">

<meta content="no-cache" http-equiv="Pragma" />
<meta content="no-cache" http-equiv="Cache-Control" />
<meta content="0" http-equiv="Expires" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width,user-scalable=no, initial-scale=1,maximum-scale=3" />
<link type="text/css" rel="stylesheet"
	href="<%=path%>/resources/css/wfw.css" />
<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet"
	type="text/css" id="theme" themeColor="lightBlue" />
<link href="<%=path%>/resources/css/base.css" rel="stylesheet" />
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<script type="text/javascript">
	/* 返回首页 */
	function shouye() {
		WeixinJSBridge.call("closeWindow");
	}
</script>
<style type="text/css">
#content {
	height: 400px;
	padding-left: 0px;
}

.main {
	height: 100%;
}
.content1{
    height: 35%;
}
.yi{
    width: 33.3%;
    text-align: center;
}
.yi img {
    height: 80px;
    width: 80px;
}
</style>

<title>数据统计主页</title>
</head>
<body>
	<div style="display: none;">
		<ul class="tab-menu tab" id="tabMenuID_">
			<li class="tab-selected" title="数据统计主页"><a href="#"
				target="content" onfocus="this.blur()"><span>数据统计主页</span></a></li>
		</ul>
	</div>
	<div class="top">
		<img style="width: 100%;" src="<%=path%>/resources/img/wfw.png" />

		<div class="anniu" style="position: absolute; top: 3%; left: 87%;">
			<a href="#" style="float: right; width: 40px; height: 50px;"
				onclick="shouye()"> <img style="width: 70%"
				src="<%=path%>/resources/img/syan.png" />
			</a>
		</div>
	</div>

	<div id="content">

		<!-- 主要代码 Start ================================ -->
		<!-- 第一页 -->
		<div class="main">
			<!-- 第一行 -->
			<div class="content1">
				<!-- 在校学生 -->
				<div class="yi">
					<a href="<%=path%>/stat/echarts/student?openId=${openId}"
						class="img"> <img
						src="<%=path%>/resources/img/zxxs.png" />
						<p>在校学生</p>
					</a>
				</div>
				<!-- 师资力量查询 -->
				<div class="yi">
					<a href="<%=path%>/stat/echarts/teacher?openId=${openId}" class="img"> 
					<img src="<%=path%>/resources/img/szll.png" />
						<p>师资力量</p>
					</a>
				</div>
				<!-- 馆藏图书分类查询  -->
				<div class="yi">
					<a href="<%=path%>/stat/echarts/library?openId=${openId}"
						class="img"> <img
						src="<%=path%>/resources/img/gctsfl.png" />
						<p>馆藏图书</p>
					</a>
				</div>
			</div>

			<!-- 第二行 -->
			<div class="content1">
				<!-- 外借图书分类-->
				<div class="yi">
					<a href="<%=path%>/stat/echarts/libraryborrow?openId=${openId}"
						class="img"> <img
						src="<%=path%>/resources/img/wjtsfl.png" />
						<p>外借图书</p>
					</a>
				</div>
				<!-- 学生选课分类 -->
				<div class="yi">
					<a href="<%=path%>/stat/echarts/lession?openId=${openId}"
						class="img"> <img src="<%=path%>/resources/img/xsxk.png" />
						<p>学生选课</p>
					</a>
				</div>
				<!-- 教师学历 -->
				<div class="yi">
					<a href="<%=path%>/stat/echarts/jsxl?openId=${openId}"
						class="img"> <img
						src="<%=path%>/resources/img/jsxl.png" />
						<p>教师学历</p>
					</a>
				</div>
			</div>

			<!-- 第三行 -->
			<div class="content1">
				<!-- 生源地 -->
				<div class="yi">
					<a href="<%=path%>/stat/echarts/syd?openId=${openId}"
						class="img"> <img
						src="<%=path%>/resources/img/syd.png" />
						<p style="margin-left: 7px;">生源地</p>
					</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 主要代码 End ================================ -->

	<div class="footer">
		<div class="footer-bottom" data-role="none"
			style="width: 100%; font-size: 100%;text-align: left;">copyright 2015黄山学院</div>
	</div>
</body>
</html>

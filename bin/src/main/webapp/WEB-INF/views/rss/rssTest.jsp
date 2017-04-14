<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html>
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta name="viewport"
	content="width=device-width,user-scalable=yes, initial-scale=1,maximum-scale=3">
<link href="<%=path%>/resources/bootstrap/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="<%=path%>/resources/css/xwlb.css" />
<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet"
	type="text/css" id="theme" themeColor="lightBlue" />
<link href="<%=path%>/resources/css/base.css" rel="stylesheet" />
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/rss/rss.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<title>新闻列表</title>
<script type="text/javascript">
    path="<%=path%>";
	url_rss= "http://www.hsu.edu.cn/rss/news.jsp?siteId=1&pageId=3&channelId=3&channelSort=11";
</script>
</head>
<body style="overflow: auto;">
	<div class="main">
		<div class="DYtop">
			<img style="width: 100%; height: 100%;"
				src="<%=path%>/resources/img/BT.jpg" /><br />
			<div class="anniu">
				<a href="<%=path%>/wzy/ZyXyxw/zhuye?openId=${openId}"
					style="float: right; width: 40px; height: 50px;"> <img
					style="width: 70%" src="<%=path%>/resources/img/zyan.png" />
				</a>
			</div>
		</div>

		<div class="middle">
			<h1>学院新闻</h1>
		</div>

		<div class="bottom">
			<div class="tupian">
				<img src="<%=path%>/resources/img/LBT.png" />
			</div>
			<div id="tbl1"></div>
			<div id="loading" style="display: none">
				<font color='red'>正在加载数据。。。</font>
			</div>
		</div>
	</div>
</body>
</html>
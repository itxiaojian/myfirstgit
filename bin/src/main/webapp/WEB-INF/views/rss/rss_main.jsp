<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%
	String path = request.getContextPath();
%>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
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
<script type="text/javascript" src="<%=path%>/resources/js/rss/rss_main.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<script type="text/javascript">
    path="<%=path%>";
	</script>
	<style type="text/css">
	.bt5{
	color: #000000;
    font-size: 16px;
    font-weight: bold;
    }
	</style>
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

		<div>
		    <input id='links' value='${url}' type="hidden">
		</div>
		<div id="head">
        <table width="98%" cellspacing="0" cellpadding="0" border="0" align="center">
        	<tbody>
        		<tr>
        			<td valign="middle" align="center" height="50" id="bt5">
        				${title}
        			<td>
        		</tr>
        		<tr>
        			<td bgcolor="#eeeeee" align="center" height="20" width='100%'>
        				<font style="color:#666666;font-size:12px;">编辑发布:${author} &nbsp;&nbsp;&nbsp; 时间:${time}</font>
        			<td>
        		</tr>
        	</tbody>
        </table>
        </div>
		<div class="bottom">
			<div id="main">
			</div>
		</div>
	</div>
</body>
</html>
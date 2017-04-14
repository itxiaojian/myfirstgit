<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"/> 
<title>绑定帐号</title>
<link rel="shortcut icon" href="<%=path%>/system/login/resources/images/favicon.ico" />
<link href="<%=path%>/system/login/resources/style/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path%>/system/login/resources/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/resources/js/jquery.i18n.properties-1.0.9.js" ></script>
<script type="text/javascript" src="<%=path%>/system/login/resources/js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/resources/js/md5.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/resources/js/page_login.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script type="text/javascript">
	var homePath="<%=path%>";
</script>
<!--[if IE]>
  <script src="resources/js/html5.js"></script>
<![endif]-->
<!--[if lte IE 6]>
	<script src="resources/js/DD_belatedPNG_0.0.8a-min.js" language="javascript"></script>
	<script>
	  DD_belatedPNG.fix('div,li,a,h3,span,img,.png_bg,ul,input,dd,dt');
	</script>
<![endif]-->
<script type="text/javascript">
	function load(){
		var yhjy="${yhjy}";
		if(yhjy=='Y'){
			alert("该微信号已绑定过账户！且已经被停用，请联系管理员。");
			//WeixinJSBridge.call("closeWindow");
		}
	}
</script>
</head>
<body class="loginbody" style="margin: 0px;" onload="load();">
<div class="dataEye">
	<div class="loginbox">
		<div class="login-content">
			<div class="loginbox-title">
				<h3>绑定帐号</h3>
			</div>
			<form id="signupForm">
			<input type="hidden" name="url" id="url" value="${url }">
			<input type="hidden" name="openId" id="openId" value="${openId }">
			<div class="login-error"></div>
			<div class="row">
				<label class="field">用户名</label>
				<input type="text" class="input-text-user input-click" name="email" id="email">
			</div>
			<div class="row">
				<label class="field">密码</label>
				<input type="password" class="input-text-password input-click" name="password" id="password">
			</div>
			<div class="row btnArea">
				<a class="login-btn" id="submit">绑定帐号</a>
			</div>
			<div class="row tips">
<p>注意：一个微信号只可以绑定一个通行证，一个通行证可以绑定多个微信号。</p>
			</div>
			</form>
		</div>
	</div>
</div>
<div class="loading">
<!-- 	<div class="mask"> -->
<!-- 		<div class="loading-img"> -->
<%-- 		<img src="<%=path%>/system/login/resources/images/loading.gif" width="31" height="31"> --%>
<!-- 		</div> -->
<!-- 	</div> -->
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="no-cache" http-equiv="Pragma" />
<meta content="no-cache" http-equiv="Cache-Control" />
<meta content="0" http-equiv="Expires" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1,maximum-scale=3" />
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/wsh.css" />
<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="lightBlue" />
<link href="<%=path%>/resources/css/base.css" rel="stylesheet" />
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js" type="text/javascript"></script>
<script type="text/javascript">
		/* 返回首页 */
		function shouye() {
			WeixinJSBridge.call("closeWindow");
		}
</script>

<title>微质检</title>
</head>

<body class="body">
	<div style="display: none;">
		<ul class="tab-menu tab" id="tabMenuID_">
			<li class="tab-selected" title="微质检主页"><a href="#"
				target="content" onfocus="this.blur()"><span>微主页</span></a></li>
		</ul>
	</div>
	<style type="text/css">
body {
	line-height: 100%
}
</style>
	<div class="top">
		<img style="width: 100%;" src="<%=path%>/resources/img/zylogo.png" />
	</div>
	<div id="wrapper" style="overflow: hidden; width: 100%;margin-top: 3%;">
			<a href="#"><img style="width:98%;" src="<%=path%>/resources/img/zlwhg.jpg" /></a>
		</div>

	<!-- 第一页 -->
	<div class="main" style="width: 100%; height: 100%;">
		<!-- 第一行 -->
		<div class="content1" >
			<div class="yi">
				<div class="middle">
					<a id="div" href="<%=path%>/wxpt/ZyZjxgxx/zyZjjj"
						style="height: 100%; width: 100%; float: left;"class="img"> <img
						src="<%=path%>/resources/img/jj.png" width="80px" height="80px" />
					</a>
				</div>
			</div>
			<div class="yi">
				<div class="middle">
					<a href="<%=path%>/wxpt/ZyZjxgxx/zyZzjg"
						style="height: 100%; width: 100%;" class="img"> 
						<img src="<%=path%>/resources/img/zzjg.png" width="80px" height="80px">
						 </img>
					</a>
				</div>
			</div>
			<div class="er">
				<div class="middle">
					<a href="<%=path%>/wxpt/ZyZjxgxx/zyfzlc"
						style="height: 100%; width: 100%; float: left;"class="img"> 
						<img src="<%=path%>/resources/img/fzlc.png" width="80px" height="80px" >
							 </img>
					</a>
				</div>
			</div>
		</div>

		<!-- 第二行 -->
		<div class="content1">
			<div class="yi">
				<div class="middle">
					<a href="<%=path%>/wxpt/ZyZjxgxx/zyZjxwlb"
						style="height: 100%; width: 100%; float: left;" class="img"> 
						<img src="<%=path%>/resources/img/zjxw.png" width="80px" height="80px" >
						 </img>
					</a>
				</div>
			</div>
			<div class="yi">
				<div class="middle">
					<a href="<%=path%>/wxpt/ZyZjxgxx/zyBslc"
						style="height: 100%; width: 100%;"class="img"> 
						<img src="<%=path%>/resources/img/bslc.png" width="80px" height="80px">
						 </img>
					</a>
				</div>
			</div >
			<div class="er">
				<div class="middle">
					<a href="<%=path%>/wxpt/ZyZjxgxx/zyJybz"
						style="height: 100%; width: 100%; float: right;" class="img">
						<img src="<%=path%>/resources/img/jybz.png" width="80px" height="80px">
						</img>
					</a>
				</div>
			</div>	
		</div>

		<!-- 第三行 -->
		<div class="content1">
				<div class="yi">
					<div class="middle">
						<a href="<%=path%>/wxpt/ZyZjxgxx/zyzlg" style="height: 100%; width: 100%; float: left;"
							class="img"> 
							<img src="<%=path%>/resources/img/zlg.png" width="80px" height="80px">
							</img>
						</a>
					</div>
				</div>
			<div class="yi">
				<div class="middle">
					<a href="<%=path%>/wxpt/ZyZjxgxx/zyppg"
						style="height: 100%; width: 100%;" class="img"> 
						<img src="<%=path%>/resources/img/ppg.png" width="80px" height="80px">
						</img>
					</a>
				</div>
			</div>
			<div class="er">
				<div class="middle">
					<a href="<%=path%>/wxpt/ZyZjxgxx/zylxwm"
						style="height: 100%; width: 100%; float: right;" class="img">
						<img src="<%=path%>/resources/img/lxwm.png" width="80px" height="80px">
						</img>
					</a>
				</div>
			</div>
		</div>
		</div>

	<div class="footer">
		<div class="footer-bottom" data-role="none"
			style="width: 100%; font-size: 50%;margin-top: -150px; color:#000000 ">copyright©2015 安徽省产品质量监督检验研究院</div>
	</div>
</body>
</html>
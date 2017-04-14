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
	
	//在校学生
	function div_zxxs(){
		window.location.href="<%=path%>/stat/echarts/student?openId=${openId}";
	}
	//师资力量
	function div_szll(){
		window.location.href="<%=path%>/stat/echarts/teacher?openId=${openId}";
	}
	//馆藏图书
	function div_gcts(){
		window.location.href="<%=path%>/stat/echarts/library?openId=${openId}";
	}
	//外借图书
	function div_wjts(){
		window.location.href="<%=path%>/stat/echarts/libraryborrow?openId=${openId}";
	}
	//学生选课
	function div_xsxk(){
		window.location.href="<%=path%>/stat/echarts/lession?openId=${openId}";
	}
	//教师学历
	function div_jsxl(){
		window.location.href="<%=path%>/stat/echarts/jsxl?openId=${openId}";
	}
	//生源地
	function div_syd(){
		window.location.href="<%=path%>/stat/echarts/syd?openId=${openId}";
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

.content1 {
	height: 35%;
}

.yi {
	width: 33.3%;
	text-align: center;
}

.yi img {
	height: 80px;
	width: 80px;
}

.td1 {
	margin-right: 50%;
}

.content2{
width:100%;
height:37%;
}

.font1{
font-size:14px;
font-weight:600;
font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
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
			<a href="<%=path%>/wfw/zy/zhuye?openId=${openId}" style="float: right; width: 40px; height: 50px;"
				onclick="shouye()"> <img style="width: 70%"
				src="<%=path%>/resources/img/zyan.png" />
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
				<div class="content2" style="background: #DBF1FB;cursor:pointer;" align="center" onClick="div_zxxs()">
					<table>
						<tr>
							<td align="right"><img class="img1" width="40px" height="40px"
								src="<%=path%>/resources/images/zxxs.png" /></td>
							<td class="td0" width="150px" height="40px" align="left"><p>
									<font class="font1">在校学生统计</font>
								</p></td>
							<td class="td1" align="left">
								<img class="img2" width="40px" height="40px"
									src="<%=path%>/resources/images/tz.png" /></td>
						</tr>
					</table>
				</div>
				<div>
					<table>
						<tr>
							<td></td>
						</tr>
					</table>
				</div>

				<!-- 师资力量 -->
				<div  class="content2" style="background: #DBF1FB;cursor:pointer;" align="center" onClick="div_szll()">
					<table>
						<tr>
							<td align="right"><img class="img1" width="40px" height="40px"
								src="<%=path%>/resources/images/szll.png" /></td>
							<td class="td0" width="150px" height="40px" align="left"><p>
									<font class="font1">师资力量统计</font>
								</p></td>
							<td class="td1" align="left">
								<img class="img2" width="40px" height="40px"
									src="<%=path%>/resources/images/tz.png" /></td>
						</tr>
					</table>
				</div>
				<div>
					<table>
						<tr>
							<td ></td>
						</tr>
					</table>
				</div>

				<!-- 馆藏图书分类 -->
				<div class="content2" style="background: #DBF1FB;cursor:pointer;" align="center" onClick="div_gcts()">
					<table>
						<tr>
							<td align="right"><img class="img1" width="40px" height="40px"
								src="<%=path%>/resources/images/gcts.png" /></td>
							<td class="td0" width="150px" height="40px" align="left"><p>
									<font class="font1">馆藏图书分类统计</font>
								</p></td>
							<td class="td1" align="left">
							<img class="img2" width="40px" height="40px"
									src="<%=path%>/resources/images/tz.png" /></td>
						</tr>
					</table>
				</div>
				<div>
					<table>
						<tr>
							<td></td>
						</tr>
					</table>
				</div>
				
					<!-- 外借图书分类 -->
				<div  class="content2" style="background: #DBF1FB;cursor:pointer;" align="center" onClick="div_wjts()">
					<table>
						<tr>
							<td align="right"><img class="img1" width="40px" height="40px"
								src="<%=path%>/resources/images/wjts.png" /></td>
							<td class="td0" width="150px" height="40px" align="left"><p>
									<font class="font1">外借图书分类统计</font>
								</p></td>
							<td class="td1" align="left">
								<img class="img2" width="40px" height="40px"
									src="<%=path%>/resources/images/tz.png" /></td>
						</tr>
					</table>
				</div>
				<div>
					<table>
						<tr>
							<td></td>
						</tr>
					</table>
				</div>

				<!-- 学生选课 -->
				<div class="content2" style="background: #DBF1FB;cursor:pointer;" align="center" onClick="div_xsxk()">
					<table>
						<tr>
							<td align="right"><img class="img1" width="40px" height="40px"
								src="<%=path%>/resources/images/xsxk.png" /></td>
							<td class="td0" width="150px" height="40px" align="left"><p>
									<font class="font1">学生选课分类统计</font>
								</p></td>
							<td class="td1" align="left">
								 <img class="img2 imgs" width="40px" height="40px"
									src="<%=path%>/resources/images/tz.png" /></td>
						</tr>
					</table>
				</div>
				<div>
					<table>
						<tr>
							<td></td>
						</tr>
					</table>
				</div>

				<!-- 教师学历 -->
				<div class="content2" style="background: #DBF1FB;cursor:pointer;" align="center" onClick="div_jsxl()">
					<table>
						<tr>
							<td align="right"><img class="img1" width="40px" height="40px"
								src="<%=path%>/resources/images/jsxl.png" /></td>
							<td class="td0" width="150px" height="40px" align="left"><p>
									<font class="font1">教师学历统计</font>
								</p></td>
							<td class="td1" align="left">
								 <img class="img2" width="40px" height="40px"
									src="<%=path%>/resources/images/tz.png" /></td>
						</tr>
					</table>
				</div>
				<div>
					<table>
						<tr>
							<td></td>
						</tr>
					</table>
				</div>

				<!-- 生源地 -->
				<div class="content2" style="background: #DBF1FB;cursor:pointer;" align="center" onClick="div_syd()">
					<table>
						<tr> 
							<td align="right"><img class="img1" width="40px" height="40px"
								src="<%=path%>/resources/images/syd.png" /></td>
							<td class="td0" width="150px" height="40px" align="left"><p>
									<font class="font1">生源地统计</font>
								</p></td>
							<td class="td1" align="left">
								 <img class="img2" width="40px" height="40px"
									src="<%=path%>/resources/images/tz.png" /></td>
						</tr>
					</table>
				</div>
				<div>
					<table>
						<tr>
							<td></td>
						</tr>
					</table>
				</div>

			</div>
		</div>
	</div>
	<!-- 主要代码 End ================================ -->

	<div class="footer">
		<div class="footer-bottom" data-role="none"
			style="width: 100%; font-size: 100%; text-align: center;"><font color="#008B00">copyright
			2015黄山学院</font></div>
	</div>
</body>
</html>

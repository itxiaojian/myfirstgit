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

<title>检验咨询</title>

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
			background-color: Green;
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
		    padding: 6px;
		    text-align: center;
		    vertical-align: middle;
		    white-space: nowrap;
		    width: 126% !important;
		    height:36px;
		}
	</style>
</head>

<body class="body">
	<div style="display: none;">
		<ul class="tab-menu tab" id="tabMenuID_">
			<li class="tab-selected" title="检验咨询主页"><a href="#"
				target="content" onfocus="this.blur()"><span>检验咨询</span></a></li>
		</ul>
	</div>
	<style type="text/css">
body {
	line-height: 100%
}
</style>
<%-- 	<div class="top">
		<img style="width: 100%;" src="<%=path%>/resources/img/zylogo.png" />
	</div>
	<div id="wrapper" style="overflow: hidden; width: 100%;margin-top: 3%;">
			<a href="#"><img style="width:98%;" src="<%=path%>/resources/img/zlwhg.jpg" /></a>
		</div> --%>

	<!-- 第一页 -->
	<div class="main" style="width: 100%; height: 100%;">
	
		<!-- 第一行 -->
		<div class="content1" >
          <div style="width: 100%; height:50%;margin-top: 20px;" align="center">
			<input  class="btn btn-success" type="button" style="width: 60px;height:92px;color:white;font-size:28px; margin-right: 30px;" onclick=" " value="建筑节能"/>
			<input  class="btn btn-success" type="button" style="width: 60px;height:92px;color:white;font-size:28px; margin-right: 30px;" onclick=" " value="节水排灌"/>
			<input  class="btn btn-success" type="button" style="width: 60px;height:92px;color:white;font-size:28px; margin-right: 30px;" onclick=" " value="装饰装修材料"/>
          </div>
        </div>

		<!-- 第二行 -->
		<div class="content1">
			<div style="width: 100%;margin-top:20px;" align="center">
			<input  class="btn btn-success" type="button" style="width: 60px;height:92px;color:white;font-size:28px; margin-right: 30px;" onclick=" " value="电器"/>
			
			<input  class="btn btn-success" type="button" style="width: 60px;height:92px;color:white;font-size:28px; margin-right: 30px;" onclick=" " value="化工"/>
			
			<input  class="btn btn-success" type="button" style="width: 60px;height:92px;color:white;font-size:28px; margin-right: 30px;" onclick=" " value="信息机电"/>
          </div>
		</div>

		<!-- 第三行 -->
		<div class="content1">
		
		   <div style="width: 100%;margin-top: 20px;" align="center">
			<input  class="btn btn-success" type="button" style="width: 60px;height:92px;color:white;font-size:28px; margin-right: 30px;" onclick=" " value="食品"/>
			<input  class="btn btn-success" type="button" style="width: 60px;height:92px;color:white;font-size:28px ;margin-right: 30px;" onclick=" " value="消防"/>
			<input  class="btn btn-success" type="button" style="width: 60px;height:92px;color:white;font-size:28px; margin-right: 30px;" onclick=" " value="机械装备"/>
          </div>
          
		</div>
		
		<!-- 第四行 -->
		<div class="content1">
		
		   <div style="width: 100%;margin-top: 20px;" align="center">
			<input  class="btn btn-success" type="button" style="width: 60px;height:92px;color:white;font-size:28px; margin-right: 30px;" onclick=" " value="轻纺及高分子"/>
			<input  class="btn btn-success" type="button" style="width: 60px;height:92px;color:white;font-size:28px; margin-right: 30px;" onclick=" " value="汽车零部件"/>
			<input  class="btn btn-success" type="button" style="width: 60px;height:92px;color:white;font-size:28px; margin-right: 30px;" onclick=" " value="黄金珠宝"/>
          </div>
          
		</div>
		
		
		<div class="content1">
					<div class="middle">
							<img src="<%=path%>/resources/img/wxts.png" width="160px;" style="margin-top: 48px; margin-left: 18px;">
							</img>
					</div>
		</div>
		</div>

	<div class="footer">
		<div class="footer-bottom" data-role="none"
			style="width: 100%; font-size: 50%;margin-top: 20px; color:red;font-size:12px; margin-top: 56px; ">咨询过程如下：选择检验类别——>选择产品类别——>选择检验样品——>显示样品的检验标准——>显示所需的设备信息、可操作人员信息、资质信息、检验项目、检验费用等信息。</div>
	</div>
</body>
</html>
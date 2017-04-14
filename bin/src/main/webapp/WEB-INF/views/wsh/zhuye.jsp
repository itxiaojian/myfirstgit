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
		/*var appid="${map.appid}";//$('#appid').val();
		var nonceStr="${map.nonceStr}";//$('#nonceStr').val();
		var timestamp="${map.timestamp}";//$('#timestamp').val();
		var signature="${map.signature}";//$('#signature').val();
		wx.config({
		      debug: false,
		      appId: appid,
		      timestamp: timestamp,
		      nonceStr: nonceStr,
		      signature: signature,
		      jsApiList: [
		        'checkJsApi',
		        'onMenuShareTimeline',
		        'onMenuShareAppMessage',
		        'onMenuShareQQ',
		        'onMenuShareWeibo',
		        'hideMenuItems',
		        'showMenuItems',
		        'hideAllNonBaseMenuItem',
		        'showAllNonBaseMenuItem',
		        'translateVoice',
		        'startRecord',
		        'stopRecord',
		        'onRecordEnd',
		        'playVoice',
		        'pauseVoice',
		        'stopVoice',
		        'uploadVoice',
		        'downloadVoice',
		        'chooseImage',
		        'previewImage',
		        'uploadImage',
		        'downloadImage',
		        'getNetworkType',
		        'openLocation',
		        'getLocation',
		        'hideOptionMenu',
		        'showOptionMenu',
		        'closeWindow',
		        'scanQRCode',
		        'chooseWXPay',
		        'openProductSpecificView',
		        'addCard',
		        'chooseCard',
		        'openCard'
		      ]
		  });
		alert(signature);
		alert(wx);
		wx.ready(function () {
			// 1 判断当前版本是否支持指定 JS 接口，支持批量判断
			document.querySelector('#wsqsys').onclick = function () {
				alert(111);
				wx.scanQRCode({
				    needResult: 0, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
				    scanType: ["qrCode","barCode"], // 可以指定扫二维码还是一维码，默认二者都有
				    success: function (res) {
				        var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
				    }
				});
			    alert(333);
			};
			
		});*/
</script>
<title>微生活</title>
</head>

<body class="body">
	<div style="display: none;">
		<ul class="tab-menu tab" id="tabMenuID_">
			<li class="tab-selected" title="微生活主页"><a href="#"
				target="content" onfocus="this.blur()"><span>微生活主页</span></a></li>
		</ul>
	</div>
	<style type="text/css">
body {
	line-height: 100%
}
</style>
	<div class="top">
		<img style="width: 100%;" src="<%=path%>/resources/img/wsh.png" />
		<div class="anniu" style="position: absolute; top:3%; left: 87%;">
			<a href="#" style="float:right;width:40px;height:50px;" onclick="shouye()" >
			   <img  style="width:70%"
			    src="<%=path%>/resources/img/syan.png" />
			    </a>
			</div>
	</div>

	<!-- 第一页 -->
	<div class="main" style="width: 100%; height: 100%;">
		<input type="hidden" value="${map.appid }" name="appid" id="appid" />
		<input type="hidden" value="${map.nonceStr }" name="nonceStr" id="nonceStr" />
		<input type="hidden" value="${map.timestamp }" name="timestamp" id="timestamp" />
		<input type="hidden" value="${map.signature }" name="signature" id="signature" />
		<!-- 第一行 -->
		<div class="content1">
			<div class="yi">
				<div class="middle">
					<a id="div" href="<%=path%>/wsh/ShSwzl/toSwzlList?openId=${openId}"
						style="height: 100%; width: 100%; float: left" class="img"> <img
						src="<%=path%>/resources/img/swzl.png" width="40px" height="40px" />
						<p>失物招领</p>
					</a>
				</div>
			</div>
			<div class="yi">
				<div class="middle">
					<a href="<%=path%>/wsh/ShWxcjjg/toWxcj?openId=${openId}"
						style="height: 100%; width: 100%;" class="img"> <img
						src="<%=path%>/resources/img/wxcj.png" width="40px" height="40px">
						<p>微信抽奖</p> </img>
					</a>
				</div>
			</div>
			<div class="er">
				<div class="middle">
					<a href="<%=path%>/wsh/ShXyxx/toXyxx?openId=${openId}"
						style="height: 100%; width: 100%; float: left" class="img"> <img
						src="<%=path%>/resources/img/xyxx.png" width="40px" height="40px">
							<p>校友信息</p> </img>
					</a>
				</div>
			</div>
		</div>

		<!-- 第二行 -->
		<div class="content1">
			<div class="yi">
				<div class="middle">
					<a href="<%=path%>/wsh/ShWbm/toWbmSjList?openId=${openId}"
						style="height: 100%; width: 100%; float: left" class="img"> <img
						src="<%=path%>/resources/img/wbm.png" width="40px" height="40px">
						<p>微报名</p> </img>
					</a>
				</div>
			</div>
			<div class="yi">
				<div class="middle">
					<a href="<%=path%>/wsh/WjObject/toDcwj?openId=${openId}"
						style="height: 100%; width: 100%;" class="img"> <img
						src="<%=path%>/resources/img/wjdc.png" width="40px" height="40px">
						<p>微问卷</p> </img>
					</a>
				</div>
			</div>
			<div class="er">
				<div class="middle">
					<a href="<%=path%>/wsh/ShXcsk/toShxcskRoute?openId=${openId}"
						style="height: 100%; width: 100%; float: right;" class="img">
						<img src="<%=path%>/resources/img/xccx.png" width="40px"
						height="40px">
						<p>校车时刻</p> </img>
					</a>
				</div>
			</div>
		</div>

		<!-- 第三行 -->
		<div class="content1">
				<div class="yi">
					<div class="middle">
						<a href="#" style="height: 100%; width: 100%; float: left"
							class="img"> <img src="<%=path%>/resources/img/why.png"
							width="40px" height="40px">
								<p>微会议</p> </img>
						</a>
					</div>
				</div>
			<div class="yi">
				<div class="middle">
					<a href="<%=path%>/wzy/ZyWdtc/shBbqDetail?openId=${openId}"
						style="height: 100%; width: 100%;" class="img"> <img
						src="<%=path%>/resources/img/bbq.png" width="40px" height="40px">
						<p>表白墙</p> </img>
					</a>
				</div>
			</div>
			<div class="er">
				<div class="middle">
					<a href="<%=path%>/wsh/ShEssc/toEsscList?openId=${openId}"
						style="height: 100%; width: 100%; float: right;" class="img">
						<img src="<%=path%>/resources/img/essc.png" width="40px"
						height="40px">
						<p>二手市场</p> </img>
					</a>
				</div>
			</div>
		</div>

		<!-- 第四行 -->
		<div class="content1">
			<div class="yi">
			<div class="middle">
					<a href="http://weixiao.qq.com/poster/view/12658" style="height: 100%; width: 100%; float: right;"
						class="img"> <img src="<%=path%>/resources/img/whb.png"
						width="40px" height="40px">
						<p>微海报</p> </img>
					</a>
				</div>
			</div>
			<div class="yi">
				<div class="middle">
					<a
						href="<%=path%>/wsh/ShWsq/toDemo"
						style="height: 100%; width: 100%;" class="img"> <img
						src="<%=path%>/resources/img/wsq.png" width="40px" height="40px">
						<p>微上墙</p> </img>
					</a>
				</div>
			</div>
			<!-- 数据统计 -->
			<div class="er">
						    <a href="<%=path%>/stat/zy/sjtjzy?openId=${openId}"
								class="img"> <img
								src="<%=path%>/resources/img/sjtj.png" width="40px" height="40px"  />
								<p>数据统计</p>
							</a>
						</div>
		</div>
	</div>
	<div class="footer">
		<div class="footer-bottom" data-role="none"
			style="width: 100%; font-size: 50%;margin-top: -80px;">copyright 2015黄山学院</div>
	</div>
	</div>
</body>
</html>
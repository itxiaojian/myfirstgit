<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
<link href="<%=path%>/resources/bootstrap/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="<%=path%>/resources/css/xyxw.css" />
	
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<script type="text/javascript">
		/* 返回首页 */
	 	function shouye() {
			//WeixinJSBridge.call("closeWindow");
			location.href="<%=path%>/wxpt/WfwXgxx/wfwZy";
		} 
</script>
<title>微服务</title>
<style type="text/css">
.anniu {
	position: absolute;
	top: 11%;
	right: 88%
}
.return {
	position: absolute;
	top: 11%;
	left: 88%
}
</style>

</head>
<body style="overflow: auto;" ontouchstart="">
 <input type="hidden" value="${map.appid}" id="appid" />
 <input type="hidden" value="${map.nonceStr}" id="nonceStr" />
 <input type="hidden" value="${map.timestamp}" id="timestamp" />
 <input type="hidden" value="${map.signature}" id="signature" />
	<div class="main" style="width: 100%;hight:100%">
		<div class="DYtop">
			<img style="width: 100%;" src="<%=path%>/resources/img/wxptLOGO.png" />
		</div>

		<div class="middle" style="padding-bottom: 2px;position: relative;">
			<h1 >微服务</h1>
			<div class="anniu">
				<a href="#"
					style="float: left; width: 40px; height: 50px;"onclick="shouye()"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/zyan.png" />
				</a>
			</div>
		</div>

		<div class="bottom" style="width: 100%;">
			    <div class="1" style="width: 90%;hight:100%;float: left;">
			    <p></p>
                </div>
                
		        <div>			 
               		<HR width="100%" color=#987cb9 style="margin-top:10px;margin-bottom:7px;" >
               </div>  
               
			    <div class="2" style="width: 100%;">
			    <div class="wxapi_container">
			    <div class="wxapi_index_container">
                </div>
			            <div  id="scanQRCode0" class="lbox_close wxapi_form img" style="width: 50%; height: 80%;text-align:center;">
					    	<img src="<%=path%>/resources/img/sys.png" style="width:  55px; height: 55px;"/>
					    <span style="width:100%;height:100%;color:black;margin-left:40px;">
					    <button style="border:none;background-color:transparent;border:0;font-weight: bold;color:black;"  
					   >扫一扫</button><span style="color:white">吧</span></span>
			    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
                <script>
 				 /*
 				  * 注意：
 				  * 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。
 				  * 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。
 				  * 3. 常见问题及完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
 				  *
 				  * 开发中遇到问题详见文档“附录5-常见错误及解决办法”解决，如仍未能解决可通过以下渠道反馈：
 				  * 邮箱地址：weixin-open@qq.com
 				  * 邮件主题：【微信JS-SDK反馈】具体问题
 				  * 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。
 				  */
                $(function(){
                	//alert(appid );
                });
             var appid="${map.appid}";
	         var nonceStr="${map.nonceStr}";//$('#nonceStr').val();
	         var timestamp="${map.timestamp}";//$('#timestamp').val();
	         var signature="${map.signature}";//$('#signature').val();
	         wx.config({
	         debug: false,
	         appId: '${map.appid}',
	   	     timestamp: '${map.timestamp}',
	   	     nonceStr: '${map.nonceStr}',
	   	     signature: '${map.signature}',
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
</script>
<script src="<%=path%>/resources/js/demo.js"> </script>	
				      </div> 
			     </div>
			    </div> 
		   <div>
			    <HR  width="100%" color=#987cb9 style="margin-top:7px;margin-bottom:7px;" >
	      </div> 
			    
	     <div>
			    <HR width="100%" color=#987cb9 style="margin-top:7px;margin-bottom:7px;" >
		  </div> 
			
			 <div class="3" style="width: 100%;">
			  <a href="<%=path%>/wxpt/WfwXgxx/wfwYpxx" style="text-decoration:none">
			     <div>
			            <div class="img" style="width: 50%; height: 80%;text-align:center;">
					    	<img src="<%=path%>/resources/img/ypxx.gif" style="width:  55px; height: 55px;"/>
					    	<span style="width:100%;height:100%;color:black;margin-left:40px;"><b>样品信息</b></span>
				        </div>
			     </div>
				        </a>
			    </div>
			    
			    <div>
			    <HR  width="100%" color=#987cb9 style="margin-top:7px;margin-bottom:7px;">
			    </div>
			    
			    <div>
			    <HR  width="100%" color=#987cb9 style="margin-top:7px;margin-bottom:7px;">
			    </div>
			    
			  <div class="4" style="width: 100%;">
			  <a href="<%=path%>/wxpt/WfwXgxx/wfwSbxx" style="text-decoration:none">
			        <div>
			            <div class="img" style="width: 50%; height: 80%;text-align:center;">
					    	<img src="<%=path%>/resources/img/sbxx.gif" style="width:  55px; height: 55px;"/>
					    	<span style="width:100%;height:100%;color:black;margin-left:40px;"><b>设备信息</b></span>
				        </div>
			     </div>
			        </a>
			    </div>
			    
			    <div>
			    <HR  width="100%" color=#987cb9 style="margin-top:7px;margin-bottom:7px;">
			    </div>
			    
			    <div>
			    <HR  width="100%" color=#987cb9 style="margin-top:7px;margin-bottom:7px;">
			    </div>
			    
			     <div class="5" style="width: 100%;">
			     <a href="<%=path%>/wxpt/WfwXgxx/wfwBgxx" style="text-decoration:none">
			       <div>
			            <div class="img" style="width: 50%; height: 80%;text-align:center;">
					    	<img src="<%=path%>/resources/img/bgxx.gif" style="width:  55px; height: 55px;"/>
					    	<span style="width:100%;height:100%;color:black;margin-left:40px;"><b>报告信息</b></span>
				        </div>
			       </div>
			        </a>
			    </div>
			    
			    <div>
			    <HR  width="100%" color=#987cb9 style="margin-top:7px;margin-bottom:7px;">
			    </div>
			    
			    <div>
			    <HR  width="100%" color=#987cb9 style="margin-top:7px;margin-bottom:7px;">
			    </div>
			    
			     <div class="6" style="width: 100%;">
			     <a href="<%=path%>/wxpt/WfwXgxx/sjtjBuilding" style="text-decoration:none">
			         <div>
			            <div class="img" style="width: 50%; height: 80%;text-align:center;">
					    	<img src="<%=path%>/resources/img/sjtj.png" style="width:  55px; height: 55px;"/>
					    	<span style="width:100%;height:100%;color:black;margin-left:40px;"><b>数据统计</b></span>
				        </div>
			     </div>
			        </a>
			    </div>
			    <div>
			    <HR  width="100%" color=#987cb9 style="margin-top:7px;margin-bottom:7px;">
			    </div> 
		</div>
	</div>

</body>
</html>
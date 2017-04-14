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
<link href="<%=path%>/resources/bootstrap/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<meta name="viewport"
	content="width=device-width,user-scalable=yes, initial-scale=1,maximum-scale=3">
<link type="text/css" rel="stylesheet"
	href="<%=path%>/resources/css/xyxw.css" />
	
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<script type="text/javascript">
		/* 返回首页 */
		function shouye() {
			WeixinJSBridge.call("closeWindow");
		}
</script>
<title>微管理</title>
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
<body style="overflow: auto;">
<input type="hidden" value="${openId}"  id="openId"/>
	<div class="main" style="width: 100%;hight:100%">
		<div class="DYtop">
			<img style="width: 100%;" src="<%=path%>/resources/img/wxptLOGO.png" />
		</div>

		<div class="middle" style="padding-bottom: 2px;position: relative;">
			<h1 >微管理</h1>
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
			
			 <div class="3" style="width: 100%;">
			  <a href="<%=path%>/wxpt/WglXgxx/wglWdrw" style="text-decoration:none">
			       <div>
			            <div class="img" style="width: 50%; height: 80%;text-align:center;">
					    	<img src="<%=path%>/resources/img/wdrw.gif" style="width:  55px; height: 55px;"/>
					    <span style="width:100%;height:100%;color:black;margin-left:40px;"><b>我的任务</b></span>
				        </div>
			       </div>
			  </a>
			    </div>
			    
			    <div>
			  		 <HR width="100%" color=#987cb9 style="margin-top:7px;margin-bottom:7px;" >
			    </div>
			    
			    <div>
			    	 <HR width="100%" color=#987cb9 style="margin-top:7px;margin-bottom:7px;" >
			    </div>
			    
			  <div class="4" style="width: 100%;">
			  <a href="<%=path%>/wxpt/WglXgxx/wglWdsq?openId=${openId}" style="text-decoration:none">
			       <div>
			            <div class="img" style="width: 50%; height: 80%;text-align:center;">
					    	<img src="<%=path%>/resources/img/wdsq.gif" style="width:  55px; height: 55px;"/>
					    <span style="width:100%;height:100%;color:black;margin-left:40px;"><b>我的申请</b></span>
				        </div>
			       </div>
			        </a>
			    </div>
			    
			    <div>
			    	 <HR width="100%" color=#987cb9 style="margin-top:7px;margin-bottom:7px;" >
			    </div>
			    
			    <div>
			     	<HR width="100%" color=#987cb9 style="margin-top:7px;margin-bottom:7px;" >
			    </div>
			    
			     <div class="5" style="width: 100%;">
			     <a href="<%=path%>/wxpt/WglXgxx/wglGzhb" style="text-decoration:none">
			       <div>
			            <div class="img" style="width: 50%; height: 80%;text-align:center;">
					    	<img src="<%=path%>/resources/img/gzhb.gif" style="width:  55px; height: 55px;"/>
					    <span style="width:100%;height:100%;color:black;margin-left:40px;"><b>工作汇报</b></span>
				        </div>
			       </div>
			        </a>
			    </div>
			    <div>
			   		 <HR width="100%" color=#987cb9 style="margin-top:7px;margin-bottom:7px;" >
			    </div>
		</div>
	</div>
</body>
</html>
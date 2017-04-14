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
<title>汇报事项</title>
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
<style type="text/css">
a{text-decoration:none;}
</style>
</head>
<body style="overflow: auto;">
	<div class="main" style="width: 100%;hight:100%">
		<div class="DYtop">
			<img style="width: 100%;" src="<%=path%>/resources/img/wxptLOGO.png" />
		</div>

		<div class="middle" style="padding-bottom: 2px;position: relative;">
			<h1 >汇报事项</h1>
			<div class="anniu">
				<a  href="<%=path%>/wxpt/WglXgxx/wglZy?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> 
			    <img style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/zyan.png" />
				</a>
			</div>
			<div class="return">
				<a href="<%=path%>/wxpt/WglXgxx/wglGzhb?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/return.png" />
				</a>
			</div>
		</div>

		<div class="bottom" style="width: 100%;">
			  <%--   <div class="1" style="width: 90%;hight:100%;float: left;">
			    <p></p>
			    <div align="center">
			       <input type="text" style="width: 70%;hight:30%;" value="搜索" id="search" />
                    <script language="javascript">
	                    var s=document.getElementById("search");
	                    s.onfocus=function(){if(this.value==this.defaultValue)this.value=''};
	                    s.onblur=function (){if(/^\s*$/.test(this.value)){this.value=this.defaultValue;this.style.color='#aaa'}}
	                    s.onkeydown=function(){	this.style.color='#333'}
                    </script>
						<img src="<%=path%>/resources/img/ss.gif" style="width: 20px; height: 20px;margin-top: -3px;"/>
				    </div>
                </div>
                <br>
                <br> --%>
                
               <div>			 
               <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
               </div>
               <a href="<%=path%>/wxpt/WglXgxx/hbxx?hblx=1" style="text-decoration:none">
			    <p style="color: black;"><b>&nbsp;&nbsp;&nbsp;&nbsp;日报&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;></b></p>
			    </a>
			    <div>
			    <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
			    </div>
			    
			    <div>
			    <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
			    </div>
			    <a href="<%=path%>/wxpt/WglXgxx/hbxx?hblx=2" style="text-decoration:none">
				<p style="color: black;"><b>&nbsp;&nbsp;&nbsp;&nbsp;周报&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;></b></p>
			    </a>
			    <div>
			    <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
			    </div>
			    
			    <div>
			    <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
			    </div>
			    <a href="<%=path%>/wxpt/WglXgxx/hbxx?hblx=3" style="text-decoration:none">
				<p style="color: black;"><b>&nbsp;&nbsp;&nbsp;&nbsp;月报&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;></b></p>
			   </a>
			    <div>
			    <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
			    </div>
			    
			  <%--   <div>
			    <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
			    </div>
			    <a href="<%=path%>/wxpt/WglXgxx/hbxx?hblx=4" style="text-decoration:none">
                <p style="color: black;"><b>&nbsp;&nbsp;&nbsp;&nbsp;季报&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;></b></p>
			 </a>
			    <div>
			    <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
			    </div> --%>
			    
			   <%--  <div>
			    <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
			    </div>
			    <a href="<%=path%>/wxpt/WglXgxx/hbxx?hblx=5" style="text-decoration:none">
			    <p style="color: black;"><b>&nbsp;&nbsp;&nbsp;&nbsp;年报&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;></b></p>
			   </a>
			    <div>
			    <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
			    </div> --%>
			    
		</div>
	</div>
</body>
</html>
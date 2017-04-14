<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<% String path = request.getContextPath();%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
   <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>  
 <link href="<%=path%>/resources/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<meta name="viewport" content="width=device-width,user-scalable=yes, initial-scale=1,maximum-scale=3">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/xyxw.css" />

<title>办事流程</title>
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
       <div  class="DYtop" >
         <img style="width:100%;" src="<%=path%>/resources/img/zylogo.png" />
       </div>
       
       <div class="middle"style="position: relative;">
			<h1 style="padding-bottom: 16px;color: #0D91DE"><b>办事流程</b></h1>
			<div class="anniu">
			    <a href="<%=path%>/wxpt/ZyZjxgxx/zhuye?openId=${openId}" 
			       style="float: left; width: 40px; height: 50px;"> 
			    <img style="width: 70%;heght: 39%; margin-left: 16px;" src="<%=path%>/resources/img/zyan.png" />
			    </a>
		    </div>
		    <div class="return">
			    <a href="<%=path%>/wxpt/ZyZjxgxx/zhuye?openId=${openId}" 
			       style="float: left; width: 40px; height: 50px;"> 
			    <img style="width: 70%;heght: 39%;  margin-left: -7px;" src="<%=path%>/resources/img/return.png" />
			    </a>
		    </div>
       </div>
       <div class="wrapper">
	   <div class="main" style="width: 98%; height: 98%; margin-top: 3%; margin-left: 14px;">
		     <div style="width: 100%; height: 20%;margin-top: 10px;">
				 <div class="img" style="width: 20%; height: 100%;float: left;">
					<img src="<%=path%>/resources/img/ypdj.png" style="width: 50px; height: 50px;" />
					<p><small style="width: 100%; height: 100%;color:#558DF7"><b>样品登记</b></small></p>
				 </div>
				 
				 <div class="img" style="width: 20%; height: 100%;float: left;">
					<img src="<%=path%>/resources/img/yjt.png" style="width: 60px; height: 15px;margin-top: 23px;" />
				 </div>
				 
				 <div class="img" style=" width: 20%; height: 100%;float: left;">
					<img src="<%=path%>/resources/img/ypsh.png" style="width: 50px; height: 50px;" />
					<p><small style="width: 100%; height: 100%;color:#558DF7"><b>样品审核</b></small></p>
				 </div>
				 
				 <div class="img"style=" width: 20%; height: 100%;float: left;">
					<img src="<%=path%>/resources/img/yjt.png"style="width: 60px; height: 15px;margin-top: 23px;" />
				 </div>
				
				 <div class="img"style=" width: 20%; height: 100%;float: left;">
					<img src="<%=path%>/resources/img/rwxd.png" style="width: 50px; height: 50px;" />
					<p><small style="width: 100%; height: 100%;color:#558DF7"><b>任务下达</b></small></p>
				 </div>
		     </div>
		     
		     <div style="width: 100%; height: 20%;">
				<div class="img"style="width: 100%; height: 20%;">
					<img src="<%=path%>/resources/img/xjt.png" style="width: 20px; height: 30px;margin-left: 83%;" />
				</div>
			 </div>
			 
			 <div style="width: 100%; height: 20%;margin-top: 10px;">
				<div class="img" style=" width: 20%; height: 20%;float: right;">
					<img src="<%=path%>/resources/img/ypjy.png" style="width: 50px; height: 50px;" />
					<p><small style="width: 100%; height: 100%;color:#558DF7"><b>样品检验</b></small></p>
			    </div>
			    
				<div class="img" style=" width:20%; height: 20%;float: right;">
					<img src="<%=path%>/resources/img/zjt.png" style="width: 60px; height: 15px;margin-top: 23px;" />
				</div>
				<div class="img" style=" width: 20%; height: 20%;float: right;">
					<img src="<%=path%>/resources/img/ypsh.png"style="width: 50px; height: 50px;" />
					<p><small style="width: 150%; height: 100%; margin-left: -16px;color:#558DF7"><b>中心主任审核</b></small></p>
				</div>
				<div class="img" style=" width: 20%; height:20%;float: right;">
					<img src="<%=path%>/resources/img/zjt.png"style="width: 60px; height: 15px;margin-top: 23px;" />
				</div>
				<div class="img"style=" width: 20%; height: 20%;float: right;">
					<img src="<%=path%>/resources/img/ypdj.png"style="width: 50px; height: 50px;" />
				    <p><small style="width: 100%; height: 100%;color:#558DF7"><b>报告编制</b></small></p>
				</div>
		    </div>
		
		    <div style="width: 100%; height: 20%;">
				<div class="img"style="width: 100%; height: 20%;">
					<img src="<%=path%>/resources/img/xjt.png" style="width: 20px; height: 30px;margin-left: 15px;" />
				</div>
			 </div>
			 
		     <div style="width: 100%; height: 20%;margin-top: 10px;">
				 <div class="img" style="width: 20%; height: 100%;float: left;">
					<img src="<%=path%>/resources/img/ypsh.png" style="width: 50px; height: 50px;" />
					<p><small style="width: 150%; height: 100%; margin-left:-12px;color:#558DF7"><b>中心主任审核</b></small></p>
				 </div>
				 
				 <div class="img" style="width: 20%; height: 100%;float: left;">
					<img src="<%=path%>/resources/img/yjt.png" style="width: 60px; height: 15px;margin-top: 23px;" />
				 </div>
				 
				 <div class="img" style=" width: 20%; height: 100%;float: left;">
					<img src="<%=path%>/resources/img/jsyjzxpz.png" style="width: 50px; height: 50px;" />
					<p><small style="width: 180%; height: 100%;margin-left:-27px;color:#558DF7"><b>技术研究中心批准</b></small></p>
				 </div>
				 
				 <div class="img"style=" width: 20%; height: 100%;float: left;">
					<img src="<%=path%>/resources/img/yjt.png"style="width: 60px; height: 15px;margin-top: 23px;" />
				 </div>
				
				 <div class="img"style=" width: 20%; height: 100%;float: left;">
					<img src="<%=path%>/resources/img/bgff.png" style="width: 50px; height: 50px;" />
					<p><small style="width: 100%; height: 100%;color:#558DF7"><b>报告发放</b></small></p>
				 </div>
		     </div>
		     
		     <div style="width: 100%; height: 20%;">
				<div class="img"style="width: 100%; height: 20%;">
					<img src="<%=path%>/resources/img/xjt.png" style="width: 20px; height: 30px;margin-left: 83%;" />
				</div>
			 </div>
			 
			 <div style="width: 100%; height: 20%;margin-top: 10px;">
				<div class="img" style=" width: 20%; height: 20%;float: right;">
					<img src="<%=path%>/resources/img/bgdy.png" style="width: 50px; height: 50px;" />
					<p><small style="width: 100%; height: 100%;color:#558DF7"><b>报告打印</b></small></p>
			    </div>
	   </div>
	   </div>
	   </div>
</body>
</html>
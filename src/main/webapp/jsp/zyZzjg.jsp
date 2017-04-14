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

<title>组织架构</title>
</head>
<body style="overflow: auto;">
   <div class="main">
      <div  class="DYtop" >
               <img style="width:100%; "  src="<%=path%>/resources/img/zylogo.png" />
      </div>
      <div class="middle" style="position: relative;">
		<h1 style="padding-bottom: 16px; margin-bottom: 0px;">组织架构</h1>
		 <div class="anniu">
			 <a href="#" style="float: left; width: 40px; height: 50px;"> 
			 <img style="width: 70%;heght: 39%; margin-left: 16px;" src="<%=path%>/resources/img/zyan.png" />
			 </a>
		 </div>
		 <div class="return">
			 <a href="#" style="float: left; width: 40px; height: 50px;"> 
			 <img style="width: 70%;heght: 39%;  margin-left: -7px;" src="<%=path%>/resources/img/return.png" />
			 </a>
		 </div>
	   </div>
        <div class="wrapper">
             <a href="#" style="overflow: hidden; width: 100%;margin-top: 0%;">
		     <img style="width:98%;  margin-left: 5px; border-top-width: 1px; " src="<%=path%>/resources/img/zzjg.jpg" />
		     </a>
	   </div>
   </div>
</body>
</html>
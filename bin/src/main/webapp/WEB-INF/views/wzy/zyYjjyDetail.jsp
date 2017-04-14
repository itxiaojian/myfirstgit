 <%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<% String path = request.getContextPath();%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
   <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>  
 <link href="<%=path%>/resources/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<meta name="viewport" content="width=device-width,user-scalable=yes, initial-scale=1,maximum-scale=3">
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
  	<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
	<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="lightBlue"/>
	<link href="<%=path%>/resources/css/base.css" rel="stylesheet" />
	<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
	<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/xyxw.css" />
	
	
	<title>一键救援</title>
</head>
<body style="overflow: auto;">
   <div class="main">
     <div  class="DYtop" >
               <img style="width:100%;height: 100%; "  src="<%=path%>/resources/img/BT.jpg" />
               <div class="anniu">
               <a href="<%=path%>/wzy/ZyXyxw/zhuye?openId=${openId}" style="float:right;width:40px;height:50px;"  >
			   <img  style="width:70%"
			    src="<%=path%>/resources/img/zyan.png" />
			    </a>
			</div>
		
       </div>
       <div class="neirong">
          <div class="shang">
               <h style="font-weight:bold;">一键救援</h>
          </div>
          <div class="xia">
                <p>请点击电话号码直接拨打</p>
               <c:forEach items="${map}" var="map">
                <p>${map.bmmc }</p>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <img style="width: 10%;" src="<%=path%>/resources/img/dianhuatubiao.jpg" />
                <a href="tel:${map.dhhm}">${map.dhhm}</a>
                </c:forEach>
          </div>
       </div>
   </div>
</body>
</html>
<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% String path = request.getContextPath();%>

<html eiiebffcjbffiheggaebebgceaeccbia_b="1" bdgjjgagedbdaebhbjbcabcdgeeebecf_b="1" idceifdedfeiefjgfcjfbchejgbcbeid_b="1">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>培养方案明细</title>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1"></meta>
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<link href="<%=path%>/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/resources/css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<script src="<%=path%>/resources/js/jquery/jquery.min.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/xyxw.css" />
<script type="text/javascript">
    function return_prepage()  
    {  
    if(window.document.referrer==""||window.document.referrer==window.location.href)  
    {  
    window.location.href="{dede:type}[field:typelink /]{/dede:type}";  
    }else  
    {  
    window.location.href=window.document.referrer;  
    }  
      
    }  
    </script>
</head>
<body style="overflow: auto;">
   <div class="main">
       <div class="middle">
				<h1>培养方案具体信息</h1>
				<div class="anniu" >
				   <a style="float:right;width:30px;height:30px;" href="#" onclick="return_prepage();">
			   <img  style="width:65%" src="<%=path%>/resources/img/fanhui.png" />
			   </a>
			      </div>
		    
       </div>
       <c:forEach var="data" items="${list}" varStatus="obj">
       <div class="bottom">
             <div class="h">
                <h2 style="height: 5%">${data.fabt}</h2>
             </div>
             <div  style="font-size:80%;text-align:center;"> 教师工号：${data.jsgh}&nbsp;&nbsp;&nbsp;添加时间：<fmt:formatDate value="${data.tjsj}" type="date" dateStyle="medium"/> </div>
             <div >
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${data.famx}
             </div>
       </div>
       </c:forEach>
   </div>
</body>
</html>

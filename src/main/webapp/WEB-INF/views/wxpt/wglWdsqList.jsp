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
	<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<script src="<%=path%>/resources/mobiscroll/js/mobiscroll.core-2.5.2.js" type="text/javascript"></script>  
<script src="<%=path%>/resources/mobiscroll/js/mobiscroll.core-2.5.2-zh.js" type="text/javascript"></script>  
<link href="<%=path%>/resources/mobiscroll/css/mobiscroll.core-2.5.2.css" rel="stylesheet" type="text/css" />  
<link href="<%=path%>/resources/mobiscroll/css/mobiscroll.animation-2.5.2.css" rel="stylesheet" type="text/css" />  
<script src="<%=path%>/resources/mobiscroll/js/mobiscroll.datetime-2.5.1.js" type="text/javascript"></script>  
<script src="<%=path%>/resources/mobiscroll/js/mobiscroll.datetime-2.5.1-zh.js" type="text/javascript"></script>
<title>我的申请</title>
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
<script type="text/javascript">
$(function () {  
    var currYear = (new Date()).getFullYear();    
    var opt={};  
    opt.date = {preset : 'date'};  
    //opt.datetime = { preset : 'datetime', minDate: new Date(2012,3,10,9,22), maxDate: new Date(2014,7,30,15,44), stepMinute: 5  };  
    opt.datetime = {preset : 'datetime'};  
    opt.time = {preset : 'time'};  
    opt.default = {  
        theme: 'jqm', //皮肤样式  
        display: 'modal', //显示方式   
        mode: 'scroller', //日期选择模式  
        dateFormat : 'yy-mm-dd', // 日期格式 
        dateOrder : 'yymmdd', //面板中日期排列格式  
        lang:'zh',  
        startYear:currYear - 20, //开始年份  
        endYear:currYear + 20 //结束年份  
    };  

    $("#search").val('').scroller('destroy').scroller($.extend(opt['date'], opt['default']));  
    var optDateTime = $.extend(opt['datetime'], opt['default']);  
    
});

function ss(){
	var openId=$('#openId').val();
	var time=$('#search').val();
	location.href="<%=path%>/wxpt/WglXgxx/wglWdsqList?time="+time+"&openId="+openId;
}
</script>
</head>
<body style="overflow: auto;">
<input type="hidden" value="${openId}" id="openId" />
	<div class="main">
		<div class="DYtop">
			<img style="width: 100%;" src="<%=path%>/resources/img/wxptLOGO.png" />

		</div>

		<div class="middle" style="padding-bottom: 2px;position: relative;">
			<h1 style="color: #0D91DE"><b>我的申请</b></h1>
			<div class="anniu">
				<a href="<%=path%>/wxpt/WglXgxx/wglZy?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/zyan.png" />
				</a>
			</div>
			<div class="return">
				<a href="<%=path%>/wxpt/WglXgxx/wglWdsq?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/return.png" />
				</a>
			</div>
			
		</div>

		<div class="bottom" style="position: relative;">
			<div class="h"></div>
			<div>
			<p></p>
			<div align="center">
								<input type="text" style="width: 70%;hight:30%;" value="搜索" id="search" />
                    <script language="javascript">
	                    var s=document.getElementById("search");
	                    s.onfocus=function(){if(this.value==this.defaultValue)this.value=''};
	                    s.onblur=function (){if(/^\s*$/.test(this.value)){this.value=this.defaultValue;this.style.color='#aaa'}}
	                    s.onkeydown=function(){	this.style.color='#333'}
                    </script>
			<a href="#" onclick="ss()">
				<img src="<%=path%>/resources/img/ss.gif" style="width: 20px; height: 20px;margin-top: -3px;"/></a>
			</div>
			<div style="position: relative;" align="center">
			<p></p>
			<table border="2" style="width: 100%;height: 30px;" bordercolor="#E0E0E0" class="table table-striped table-hover table-bordered">
			<tr>
			   <td  align="center" style="height: 37px;"><B>序号</B></td>
			   <td align="center"><B>申请人</B></td>
			    <td align="center"><B>申请类型</B></td>
			      <td align="center"><B>申请日期</B></td>
			        <td align="center"><B>操作</B></td>
			</tr>
			<c:forEach var="data" items="${wdsqlist}" varStatus="status">
			<tr>
			   <td align="center" style="height: 37px;">${status.count}</td>
			   <td align="center">${data.sqrxm}</td>
			   <td align="center">
			   <c:choose>
			   <c:when test="${data.sqlx==0 }">
			               培训
			   </c:when>
			   <c:when test="${data.sqlx==1}">
			              加班
			   </c:when>
			   <c:when test="${data.sqlx==2}">
			              工作请假
			   </c:when>
			   <c:when test="${data.sqlx==3}">
			             出差申请
			   </c:when>
			   <c:when test="${data.sqlx==4}">
			             外出
			   </c:when>
			   <c:when test="${data.sqlx==5}">
			              物品采购
			   </c:when>
			    <c:otherwise>
			             费用报销
			   </c:otherwise>
			   </c:choose>
               </td>
			   <td align="center">${data.sqrq}</td>
			   <td align="center"><a class="edit" 
			    href="<%=path%>/wxpt/WglXgxx/wglWdsqXq?id=${data.sqid}&openId=${openId}">详情</a></td>
			</tr>
		    </c:forEach>
			</table>
			</div>
		</div>
	</div>
	
</body>
</html>
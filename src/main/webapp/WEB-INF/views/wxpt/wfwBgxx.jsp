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
<title>报告信息</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<link href="<%=path%>/resources/bootstrap/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<meta name="viewport"
	content="width=device-width,user-scalable=yes, initial-scale=1,maximum-scale=3">
<link type="text/css" rel="stylesheet"
	href="<%=path%>/resources/css/xyxw.css" />
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript">
  function cx(){
	  var  bgbh= $('#search').val();
	  if(bgbh=='报告编号'){
		  bgbh='';
	  }
	  var openId = $('#openId').val();
	  location.href="<%=path%>/wxpt/WfwXgxx/wfwBgxx?openId="+openId+"&bgbh="+bgbh;
  }
</script>
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
<input type="hidden" value='${openId}' id="openId"/>
	<div class="main">
		<div class="DYtop">
			<img style="width: 100%;" src="<%=path%>/resources/img/wxptLOGO.png" />
		</div>

		<div class="middle" style="padding-bottom: 2px;position: relative;">
			<h1 style="color: #0D91DE"><b>报告信息</b></h1>
			<div class="anniu">
				<a href="<%=path%>/wxpt/WfwXgxx/wfwZy"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/zyan.png" />
				</a>
			</div>
			<div class="return">
				<a href="<%=path%>/wxpt/WfwXgxx/wfwZy"
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
					<input type="text" style="width: 70%;hight:30%;" value="报告编号" id="search" />
                    <script language="javascript">
	                    var s=document.getElementById("search");
	                    s.onfocus=function(){if(this.value==this.defaultValue)this.value=''};
	                    s.onblur=function (){if(/^\s*$/.test(this.value)){this.value=this.defaultValue;this.style.color='#aaa'}}
	                    s.onkeydown=function(){	this.style.color='#333'}
                    </script>
			<a href ="#" onclick="cx()">
				<img src="<%=path%>/resources/img/ss.gif" style="width: 20px; height: 20px;margin-top: -3px;"/></a>
			</div>
			<div style="position: relative;" align="center">
			<p></p>
			<table border="2" style="width: 100%;height: 30px;" bordercolor="#E0E0E0" class="table table-striped table-hover table-bordered">
			<tr>
			   <td align="center" style="height: 37px;"><B>序号</B></td>
			    <td align="center"><B>报告编号</B></td>
			     <td align="center"><B>名称</B></td>
			      <!-- <td align="center"><B>抽样单位</B></td> -->
			        <td align="center"><B>操作</B></td>
			</tr>
		   <c:forEach var="data" items="${bgxx}" varStatus="status">
			<tr>
			   <td align="center" style="height: 37px;">${status.count}</td>
			   <td align="center">${data.bgbh}</td>
			   <td align="center">${data.bgmc}</td>
			  <%--  <td align="center">${data.cydw}</td> --%>
			   <td align="center"><a class="edit" href="<%=path%>/wxpt/WfwXgxx/wfwBgxxXq?id=${data.id}">详情</a></td>
			</tr>
			</c:forEach>
			</table>
			</div>
		</div>
	</div>
	
</body>
</html>
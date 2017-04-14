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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<link type="text/css" rel="stylesheet"
	href="<%=path%>/resources/css/xyxw.css" />
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
<title>样品信息</title>
</head>
<script type="text/javascript">
    function save(id){
    	// alert(id);
    	location.href="<%=path%>/wxpt/WfwXgxx/wfwYpxxXq?id="+id;
    };
  </script>
   <script type="text/javascript">
		function query(){
		//	var search = $("#search").val();
		//	alert(search);
			var search = $("#search").val();
			if(search=='样品编号&样品名称'){
				$("#search").val('');
			}
			$("#myForm").submit();
		}
 </script>
  <% int s = 0; %>
<body style="overflow: auto;">
	<div class="main">
		<div class="DYtop">
			<img style="width: 100%;" src="<%=path%>/resources/img/wxptLOGO.png" />
		</div>

		<div class="middle" style="padding-bottom: 2px;position: relative;">
			<h1 style="color: #0D91DE"><b>样品信息</b></h1>
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
			<form action="<%=path%>/wxpt/WfwXgxx/wxptYpxx" id="myForm" method="post">
					<input type="text" style="width: 70%;hight:30%;" value="样品编号&样品名称" id="search" name="search"/>
                    <script language="javascript">
	                    var s=document.getElementById("search");
	                    s.onfocus=function(){if(this.value==this.defaultValue)this.value=''};
	                    s.onblur=function (){if(/^\s*$/.test(this.value)){this.value=this.defaultValue;this.style.color='#aaa'}}
	                    s.onkeydown=function(){	this.style.color='#333'}
                    </script>
			<img onclick="query();"src="<%=path%>/resources/img/ss.gif" style="width: 20px; height: 20px;margin-top: -3px;"/>
			</form>
			</div>
			<form action="" id="form" name="form" method="post">
			<div style="position: relative;" align="center">
			<p></p>
			<table border="2" style="width: 100%;height: 30px;" bordercolor="#E0E0E0" class="table table-striped table-hover table-bordered" id="editable-sample">
			<thead>
			<tr>
			   <td align="center" style="height: 37px;"><B>序号</B></td>
			    <td align="center"><B>样品编号</B></td>
			     <td align="center"><B>样品名称</B></td>
			     <!--  <td align="center"><B>委托单位</B></td> -->
			        <td align="center"><B>操作</B></td>
			</tr>
			</thead>
					<tbody>
						<c:forEach var="getypxx" items="${getypxx}" varStatus="obj">
						<tr class="">
						    <% s++; %>
							<td align="center"><%=s %></td>
							<td align="center">${getypxx.ypbh }</td>
							<td align="center">${getypxx.ypmc }</td>
							<%-- <td align="center">${getypxx.wtdw }</td> --%>
							<td align="center"><a class="edit" href="javascript:void(0);" onClick="save('${getypxx.id }');">详情</a></td>
						</tr>
						</c:forEach>
					</tbody>
			</table>
			</div>
			</form>
		</div>
	</div>
	
</body>
</html>
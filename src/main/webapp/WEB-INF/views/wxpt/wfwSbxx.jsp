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
<title>设备信息</title>
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
<script type="text/javascript">
    function save(id){
    	location.href="<%=path%>/wxpt/ZyZjxgxx/zyZjSbxxXq?id="+id;
    };
  </script>
 <script type="text/javascript">
		function query(){
	//		var search = $("#search").val();
	//		alert(search);
	var search = $("#search").val();
	if(search=='设备编号&设备名称'){
		$("#search").val('');
	}
	$("#myForm").submit();
		}
 </script>
<body style="overflow: auto;">
	<div class="main">
		<div class="DYtop">
			<img style="width: 100%;" src="<%=path%>/resources/img/wxptLOGO.png" />

		</div>

		<div class="middle" style="padding-bottom: 2px;position: relative;">
			<h1 style="color: #0D91DE"><b>设备信息</b></h1>
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
			<form action="<%=path%>/wxpt/WfwXgxx/wxptSbxx" id="myForm" method="post">
			<input type="text" style="width: 70%;hight:30%;" value="设备编号&设备名称" id="search"  name="search" />
            <script language="javascript">
	                    var s=document.getElementById("search");
	                    s.onfocus=function(){if(this.value==this.defaultValue)this.value=''};
	                    s.onblur=function (){if(/^\s*$/.test(this.value)){this.value=this.defaultValue;this.style.color='#aaa'}}
	                    s.onkeydown=function(){	this.style.color='#333'}
            </script>
			<a href="#"  onclick="query();">
				<img src="<%=path%>/resources/img/ss.gif" style="width: 20px; height: 20px;margin-top: -3px;"/></a>
			</form>
			</div>
			<form action="" id="form" name="form" method="post">
			<div style="position: relative;" align="center">
			<p></p>
			<table class="table table-striped table-hover table-bordered" id="editable-sample">
					<thead>
						<tr class="">
							<td align="center"><b>序号</b></td>
							<td align="center"><b>设备编号</b></td>
							<td align="center"><b>设备名称</b></td>
							<!-- <td align="center"><b>型号</b></td>
							<td align="center"><b>类型</b></td> -->
							<td align="center"><b>操作</b></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="getsbxx" items="${getsbxx}" varStatus="status">
						<tr class="">
							<td align="center">${status.count}</td>
							<td align="center">${getsbxx.sbbh}</td>
							<td align="center">${getsbxx.sbmc}</td>
							<%-- <td align="center">${getsbxx.sbxh }</td>
							<td align="center">${getsbxx.sblx }</td> --%>
							<td align="center"><a class="edit" href="javascript:void(0);"onClick="save('${getsbxx.id }');">详情</a></td>
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
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
<title>检验标准</title>
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
    	// alert(id);
    	location.href="<%=path%>/wxpt/ZyZjxgxx/zyZjJybzXq?id="+id;
    };
  </script>
<% int s = 0; %>

<body style="overflow: auto;">
	<div class="main">
		<div class="DYtop">
			<img style="width: 100%;" src="<%=path%>/resources/img/wxptLOGO.png" />

		</div>

		<div class="middle" style="padding-bottom: 2px;position: relative;">
			<h1 style="color: #0D91DE"><b>检验标准</b></h1>
			<div class="anniu">
				<a href="<%=path%>/wxpt/ZyZjxgxx/zhuye?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/zyan.png" />
				</a>
			</div>
			<div class="return">
				<a href="<%=path%>/wxpt/ZyZjxgxx/zhuye?openId=${openId}"
					style="float: left; width: 40px; height: 50px;"> <img
					style="width: 60%;heght: 20px;" src="<%=path%>/resources/img/return.png" />
				</a>
			</div>
			
		</div>

		<div class="bottom" style="position: relative;">
			<div class="h"></div>
			<div>
			<div style="position: relative;" align="center">
			<p></p>
			<table class="table table-striped table-hover table-bordered" id="editable-sample">
					<thead>
						<tr class="">
							<td align="center"><b>序号</b></td>
							<td align="center"><b>标准编号</b></td>
							<td align="center"><b>标准名称</b></td>
							<td align="center"><b>标准类别</b></td>
							<td align="center"><b>操作</b></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="getbzxx" items="${getbzxx}" varStatus="obj">
						<tr class="">
						    <% s++; %>
							<td align="center"><%=s%></td>
							<td align="center">${getbzxx.bzbh }</td>
							<td align="center">${getbzxx.bzmc }</td>
							<td align="center">${getbzxx.bzlb }</td>
							<td align="center"><a class="edit" href="javascript:void(0);" onClick="save('${getbzxx.id }');">详情</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>
<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
%>

<html eiiebffcjbffiheggaebebgceaeccbia_b="1"
	bdgjjgagedbdaebhbjbcabcdgeeebecf_b="1"
	idceifdedfeiefjgfcjfbchejgbcbeid_b="1">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>贫困生信息</title>
<meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=3.0,user-scalable=yes;">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<link href="<%=path%>/resources/css/style.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/resources/css/common.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<script src="<%=path%>/resources/js/jquery/jquery.min.js"
	type="text/javascript"></script>
<style type="text/css"></style>
<script type="text/javascript">
	function query() {
		$("#myForm").submit();
	}
</script>
</head>

<body id="cardunion" class="mode_webapp2"
	style="background-color: white;">
	<div style="display: none;">
		<ul class="tab-menu tab" id="tabMenuID_">
			<li class="tab-selected" title="贫困生信息"><a href="#"
				target="content" onfocus="this.blur()"><span>贫困生信息</span></a></li>
		</ul>
	</div>
	<div class="bg1">
		<div class="style1">
			<div class="wwx_f_l" style="position: relative;">
			<a class="font1" href="<%=path%>/wfw/ZsPksxx/toPksxx?openId=${openId }">学号&姓名</a>
			&nbsp;&nbsp;&nbsp;
				<!-- <span class="font1">学号</span> -->
			</div>
			<form action="<%=path%>/wfw/ZsPksxx/toPksxx" id="myForm"
				class="wwx_f_a" 
				method="post">
				<input type="text" class="inputhaha" name="code" id="code" > 
				<input type="hidden" name="openId" id="openId" value="${openId }">
				<span>
				<a class="font1" href="#" style="margin-left: 10px;"
					onclick="query();">查询</a></span>
			</form>
			<div class="wwx_clear"></div>
			<div class="anniu" style="left:85%;">
	    <a style="float:right;width:40px;height:50px;" href="<%=path%>/wfw/zy/zhuye?openId=${openId}" >
			   <img style="width:80%" src="<%=path%>/resources/img/wfwzy.png" >
		    </a>
	 </div>
		</div>
	</div>
	<div class="zhengwen">
<!-- 	<div>
		<div class="style2">
			<span class="color1">贫困生信息</span>
		</div>
	</div> -->
	<div>
		<div class="style4">
		<c:if test="${empty list}">
		<div class="text">
			<p>贫困生信息暂无...</p>
		</div>
	</c:if>
			<c:forEach var="data" items="${list}" varStatus="obj">
				<div class="maring1">
					<div class="wwx_f_l" style="width: 100%">
						<table style="width: 100%;font-size:17px;">
							<tr>
								<td>学号</td>
								<td>${data.xh }</td>
						    </tr>
						    <tr>
					            <td>姓名</td>
					            <td>${data.xm }</td>
					        </tr>
						    <tr>
								<td>贫困生等级</td>
								<td>${data.pksdj }</td>
							</tr>
							<tr>
								<td>班级</td>
								<td>${data.bj}</td>
						    </tr>
						    <tr>
								<td>学院</td>
								<td>${data.xy }</td>
							</tr>
							<tr>
								<td>专业</td>
								<td>${data.zy }</td>
							</tr>
							<tr>
								<td>备注</td>
								<td>${data.bz }</td>
							</tr>
						</table>
					</div>
					<div class="wwx_clear"></div>
				</div>
			</c:forEach>
		</div>
		<div class="style4" style="text-align: center;">
			<c:choose>
				<c:when test="${pages > 1}">
					<a href="<%=path%>/wfw/ZsPksxx/toPksxx?pages=${pages - 1}&openId=${openId}">上一页</a>
				</c:when>
				<c:otherwise>
						上一页
					</c:otherwise>
			</c:choose>
			第${pages}页
			<c:choose>
				<c:when test="${pages < count}">
					<a href="<%=path%>/wfw/ZsPksxx/toPksxx?pages=${pages + 1}&openId=${openId}">下一页</a>
				</c:when>
				<c:otherwise>
					下一页
				</c:otherwise>
			</c:choose>
			总共${count}页
		</div>
	</div>
	</div>
</body>
<script type="text/javascript">
$(function() {
    $("table tr:nth-child(odd)").addClass("odd-row");
	$("table td:first-child, table th:first-child").addClass("first");
	$("table td:last-child, table th:last-child").addClass("last");
});
</script>
</html>
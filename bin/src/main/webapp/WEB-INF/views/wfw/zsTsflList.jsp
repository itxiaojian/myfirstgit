<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% String path = request.getContextPath();%>

<html eiiebffcjbffiheggaebebgceaeccbia_b="1" bdgjjgagedbdaebhbjbcabcdgeeebecf_b="1" idceifdedfeiefjgfcjfbchejgbcbeid_b="1">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>图书分类信息</title>
<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<link href="<%=path%>/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/resources/css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<script src="<%=path%>/resources/js/jquery/jquery.min.js" type="text/javascript"></script><style type="text/css"></style><style type="text/css"></style><style type="text/css"></style>
<script type="text/javascript">
	function query(){
		var keyWord = $("#zl").val();
		if(keyWord == null || keyWord == ""){
			alert("请输入关键词查询!");
			return false;
		}else{
			$("#myForm").submit();
		}
	}
</script>
</head>

<body id="cardunion" class="mode_webapp2" style="background-color: white;">
<div style="display:none;">
<ul class="tab-menu tab" id="tabMenuID_">
	<li class="tab-selected" title="图书分类">
	<a href="#" target="content" onfocus="this.blur()"><span>图书分类</span></a>
	</li>
</ul>
</div>
<div class="bg1">
	<div class="style1">
		<div class="wwx_f_l" style="position: relative;">
		<a class="font1" href="<%=path%>/wfw/ZsTsfl/toTsfl?openId=${openId }">种类</a>
		&nbsp;&nbsp;&nbsp;
			<!-- <span class="font1" >种类</span> -->
		</div>
		<form action="<%=path%>/wfw/ZsTsfl/toTsfl" id="myForm" class="wwx_f_a"  method="post">
			<input type="text" class="inputhaha" name="zl" id="zl" >
			<input type="hidden" name="openId" id="openId" value="${openId }">
			<span><a class="font1" href="#" style="margin-left: 10px;" onclick="query();">查询</a></span>
			</form>
				<div class="wwx_clear"></div>
				<div class="anniu" style="left:85%;">
	    <a style="float:right;width:40px;height:50px;" href="<%=path%>/wfw/zy/zhuye?openId=${openId}" >
			   <img style="width:80%" src="<%=path%>/resources/img/wfwzy.png" >
		    </a>
	 </div>
	</div>
</div>
<!-- <div>
	<div class="style2" style="margin-top: 70px;">
		<span class="color1">图书分类信息</span>
	</div>
</div> -->
<div class="zhengwen">
	<div class="style4">
	<c:if test="${empty list}">
		<div class="text">
			<p>图书分类信息暂无...</p>
		</div>
	</c:if>
	<c:forEach var="data" items="${list}" varStatus="obj">
		<div class="maring1">
				<div class="wwx_f_l" style="width:100%">
					<table style="width: 100%;">
					    <tr>
					       <td>种类</td>
					       <td>${data.zl }</td>
					    </tr>
					    <tr>
					       <td>数量</td>
					       <td>${data.sl }</td>
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
						<a href="<%=path%>/wfw/ZsTsfl/toTsfl?pages=${pages - 1}&openId=${openId}">上一页</a>
					</c:when>
					<c:otherwise>
						上一页
					</c:otherwise>
				</c:choose>
				第${pages}页
				<c:choose>
					<c:when test="${pages < count}">
						<a href="<%=path%>/wfw/ZsTsfl/toTsfl?pages=${pages + 1}&openId=${openId}">下一页</a>
					</c:when>
					<c:otherwise>
					下一页
				</c:otherwise>
				</c:choose>
				总共${count}页
			</div>
</div>
</body>
<script type="text/javascript">
	function toMx(id){
		location.href="<%=path%>/wfw/ZsPjxx/detail?id="+id;
	};
	$(function() {
	    $("table tr:nth-child(odd)").addClass("odd-row");
		$("table td:first-child, table th:first-child").addClass("first");
		$("table td:last-child, table th:last-child").addClass("last");
	});
</script>
</html>
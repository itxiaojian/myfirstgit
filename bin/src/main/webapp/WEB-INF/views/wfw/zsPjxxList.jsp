<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% String path = request.getContextPath();%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>评教信息</title>
<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=3.0,user-scalable=yes;">
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
<script type="text/javascript">
	function query(){
		$("#myForm").submit();
	}
</script>
</head>

<body id="cardunion" class="mode_webapp2" style="background-color: white;">
<div style="display:none;">
<ul class="tab-menu tab" id="tabMenuID_">
	<li class="tab-selected" title="评教信息">
	<a href="#" target="content" onfocus="this.blur()"><span>评教信息</span></a>
	</li>
</ul>
</div>
<div class="bg1">
	<div class="style1">
		<div class="wwx_f_l" style="position: relative;">
			<a class="font1" href="<%=path%>/wfw/ZsPjxx/toPjxx?openId=${openId }">教师工号&姓名</a>
			&nbsp;&nbsp;&nbsp;
			<!-- <span class="font1">教师工号</span> -->
		</div>
		<form action="<%=path%>/wfw/ZsPjxx/toPjxx" id="myForm" class="wwx_f_a"  method="post">
			<input type="text" class="inputhaha" name="code" id="code" >
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
<div class="zhengwen">
<!-- <div>
	<div class="style2">
		<span class="color1">评教信息</span>
	</div>
</div> -->
<div>
	<div class="style4">
	<c:if test="${empty list}">
		<div class="text">
			<p>评教信息暂无...</p>
		</div>
	</c:if>
	<c:forEach var="data" items="${list}" varStatus="obj">
		<div class="maring1">
				<div class="wwx_f_l" style="width:100%">
					<table style="width: 100%;">
					    <tr>
					       <td>教师工号</td>
					       <td>${data.jsgh }</td>
					    </tr>
					    <%-- <tr>
					       <td>序号</td>
					       <td>${data.xh }</td>
					    </tr> --%>
					    <tr>
					       <td>教师姓名</td>
					       <td>${data.jsxm }</td>
					    </tr>
					    <tr>
					       <td>任教科目</td>
					       <td>${data.rjkm }</td>
					    </tr>
					    <tr>
					       <td>评教学年</td>
					       <td>${data.ksxn }</td>
					    </tr>
					    <tr>
					       <td>评教学期</td>
					       <td>${data.ksxq }</td>
					    </tr>
					    <tr>
					        <td>添加时间</td>
					        <td>${data.tjsj }</td>
					    </tr>
					    <tr>
					       <td>状态</td>
					       <td >
					       <c:choose>
					           <c:when test="${data.zt =='1' }"><span style="color:green" id="zt${obj.count}">进行中</span></c:when>
					           <c:when test="${data.zt =='2' }"><span style="color:red" id="zt${obj.count}">过期</span></c:when>
					         </c:choose>
					       </td>
					    </tr>
					    <tr>
					       <td>备注</td>
					       <td>${data.bz }</td>
					    </tr>
					    <tr>
					        <td>操作</td>
					        <td>
					           <a href="javascript:;" onclick="toMx(${data.id},${data.zt})"><span style="color:blue">评价</span></a>
					        </td>
					    </tr>
					</table><br />
				</div>
				<div class="wwx_clear"></div>
			</div>	
		</c:forEach>
		</div>
	<div class="style4" style="text-align: center;">
				<c:choose>
					<c:when test="${pages > 1}">
						<a href="<%=path%>/wfw/ZsPjxx/zsPjxxList?pages=${pages - 1}&openId=${openId}">上一页</a>
					</c:when>
					<c:otherwise>
						上一页
					</c:otherwise>
				</c:choose>
				第${pages}页
				<c:choose>
					<c:when test="${pages < count}">
						<a href="<%=path%>/wfw/ZsPjxx/zsPjxxList?pages=${pages + 1}&openId=${openId}">下一页</a>
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
	function toMx(id,num){
		//var i = $("#zt"+num).html();
		//alert(num);
		if(num == "2"){
			alert("评教信息已过期。");
		}else{
		    location.href="<%=path%>/wfw/ZsPjxx/detail?id="+id;
		}
	};
	$(function() {
	    $("table tr:nth-child(odd)").addClass("odd-row");
		$("table td:first-child, table th:first-child").addClass("first");
		$("table td:last-child, table th:last-child").addClass("last");
	});
</script>
</html>
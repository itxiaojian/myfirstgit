<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% String path = request.getContextPath();%>

<html eiiebffcjbffiheggaebebgceaeccbia_b="1" bdgjjgagedbdaebhbjbcabcdgeeebecf_b="1" idceifdedfeiefjgfcjfbchejgbcbeid_b="1">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>网络选修课信息</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,user-scalable=yes, initial-scale=1,maximum-scale=3"></meta>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/icons.css" />
    <link href="<%=path%>/resources/css/common.css" rel="stylesheet" type="text/css">
	<link href="<%=path%>/resources/css/style.css" rel="stylesheet" type="text/css">

	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
  	<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
	<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="lightBlue"/>

<script type="text/javascript">
function Change(){
    var objS = document.getElementById("pid");
    var grade = objS.options[objS.selectedIndex].value;
    var openId = document.getElementById("openId").value;
    location.href="<%=path%>/wfw/ZsXxkxx/toXxkxxByQh?ksqh="+grade+"&openId="+openId;
	}
</script>
</head>

<body id="cardunion" class="mode_webapp2" style="background-color: white;">
<div style="display:none;">
<ul class="tab-menu tab" id="tabMenuID_">
	<li class="tab-selected" title="选修课信息">
	<a href="#" target="content" onfocus="this.blur()"><span>选修课信息</span></a>
	</li>
</ul>
</div>

<input type="hidden" name="openId" id="openId" value="${openId }"> 
<div class="bg1">
	<div class="style1">
		<div class="wwx_f_l" style="position: relative;">
		<a class="font1" href="<%=path%>/wfw/ZsXxkxx/toXxkxx?openId=${openId }">学年学期</a>
			<span>
					<select class="SelectList width7" id="pid" onchange="Change()" style="top: -1px;left: 10px;">
						<c:forEach var="list" items="${qhlist}" varStatus="s">
							<option value="${list.ksqh }" <c:if test="${list.ksqh==qh }">selected="selected"</c:if>>${list.ksqh }</option>
						</c:forEach>
					</select>
				</span>
		</div>
	<%-- 	<form action="<%=path%>/wfw/ZsXxkxx/toXxkxx" id="myForm" class="wwx_f_a"  method="post">
			<input type="text" class="inputhaha" name="xh" id="xh">
			<span><a class="font1" href="#" style="margin-left: 10px;" onclick="query();">查询</a></span>
			</form> --%>
				<div class="wwx_clear"></div>
				 <div class="anniu" style="left:85%;">
	    <a style="float:right;width:40px;height:50px;" href="<%=path%>/wfw/zy/zhuye?openId=${openId}" >
			   <img style="width:80%" src="<%=path%>/resources/img/wfwzy.png" >
		    </a>
	 </div>
		    
	</div>
</div>
<form action="<%=path%>/wfw/ZsXxkxx/toXxkxxByQh" id="myForm" method="post">
<div class="zhengwen">
<!-- <div>
	<div class="style2">
		<span class="color1">网络选修课信息</span>
	</div>
</div> -->
<div>
	<div class="style4">
	<c:if test="${empty cjlist}">
		<div class="text">
			<p>网络选修课信息暂无...</p>
		</div>
	</c:if>
	<c:forEach var="data" items="${cjlist}" varStatus="obj">
		<div class="maring1">
				<div class="wwx_f_l" style="width:100%">
					<table style="width: 100%; font-size:17px;">
					    <tr>
					       <td>学号</td>
					       <td>${data.xh }</td>
					    </tr>
					    <tr>
					       <td>学年</td>
					       <td>${data.xn }</td>
					    </tr>
					    <tr>
					       <td>课程名称</td>
					       <td>${data.kcmc}</td>
					    </tr>
					    <tr>
					       <td>学期</td>
					       <td>${data.xq }</td>
					    </tr>
					    <tr>
					       <td>上课地点</td>
					       <td>${data.skdd }</td>
					    </tr>
					    <tr>   
					       <td>课程编号</td>
					       <td>${data.kcbh }</td>
					    </tr>
					    <tr>
					       <td>任课老师</td>
					       <td>${data.sklsgh }</td>
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
</div>
</div>
</form>
</body>
<script type="text/javascript">
$(function() {
    $("table tr:nth-child(odd)").addClass("odd-row");
	$("table td:first-child, table th:first-child").addClass("first");
	$("table td:last-child, table th:last-child").addClass("last");
});
</script>
</html>
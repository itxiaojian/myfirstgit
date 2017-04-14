<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
%>

<html eiiebffcjbffiheggaebebgceaeccbia_b="1"
	bdgjjgagedbdaebhbjbcabcdgeeebecf_b="1"
	idceifdedfeiefjgfcjfbchejgbcbeid_b="1">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,user-scalable=no, initial-scale=1,">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<script src="<%=path%>/resources/js/jquery/jquery.min.js"
	type="text/javascript"></script>
<title>教室查询</title>
<meta name="viewport" content="user-scalable=no,width=device-width">
<meta name="apple-mobile-web-app-capable" content="yes">
<link href="<%=path%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/styles.css">
<script>
	//console.log=function(){}
</script>
<script type="text/javascript">
	function query(){
		var keyWord = $("#kcmc").val();
		if(keyWord == null || keyWord == ""){
			alert("请输入关键词查询!");
			return false;
		}else{
			$("#myForm").submit();
		}
	}
	
	function Change(){
        var objS = document.getElementById("pid");
        var jxlmc = objS.options[objS.selectedIndex].value;
        if(jxlmc == "选择教学楼查看"){
        	 location.href="<%=path%>/wfw/ZsJscx/toJscx";
        }else{
             location.href="<%=path%>/wfw/ZsJscx/toJscx?jxl="+jxlmc;
        }
   	}
</script>
</head>

<body class="s-app ng-scope s-app--inApp"
	ng-controller="MainCtrl as app"
	ng-class="{
      's-app--deskTop': app.isDeskTop,
      's-app--inApp': app.isInnerApp,
      's-app--ios': app.isIos7 }">
	<div style="display: none;">
		<ul class="tab-menu tab" id="tabMenuID_">
			<li class="tab-selected" title="教室查询 "><a href="#"
				target="content" onfocus="this.blur()"><span>教室查询</span></a></li>
		</ul>
	</div>

	<style class="ng-scope">

 .p-freeClassroom {
	color: #000000;
}

.p-freeClassroom .search {
	border: 1px solid rgb(91, 192, 222);
	margin: 5px auto;
	width: 95%;
}

.table-classroom {
	table-layout: fixed;
}

.table-classroom td {
	padding: 5px 3px !important;
	text-align: center;
	vertical-align: middle !important;
}

.td-title {
	background-color: #eee;
	font-weight: bold;
}

.td-title.ver-top {
	vertical-align: top !important;
}

.sp-title {
	width: 1em;
	margin: 0 auto;
	display: block;
	line-height: 1.1;
	padding: 0.5em 0;
}

.room-use {
	background: #5cb85c;
	color: #ffffff;
}

.room-lesson {
	background: #5bc0de;	
	color: #ffffff;
} 
</style>
	<div class="p-freeClassroom dock-fill scroll-y  ng-scope" style="text-align: center;">
<div  class="bg1">
	<div class="style1">
		<div class="wwx_f_l" style="position: relative;left: -9px;">
		<a class="font1" href="<%=path%>/wfw/ZsJscx/toJscx?openId=${openId }">课程名称</a>
		</div>
		<form action="<%=path%>/wfw/ZsJscx/toJscx" id="myForm" class="wwx_f_l" style="width: 55%;margin-top: 4px;" method="post">
			<input type="text" class="input1" name="kcmc" id="kcmc" style="width: 100px;float:left;">
			<input type="hidden" name="openId" id="openId" value="${openId }">
			<span style="float: left; margin-top: 5px;"><a class="font1" href="#" style="margin-left: 10px;" onclick="query();">查询</a></span>
			</form>
				<div class="wwx_clear"></div>
	</div>
	<div class="anniu" style="left:85%;">
	    <a style="float:right;width:40px;height:50px;" href="<%=path%>/wfw/zy/zhuye?openId=${openId}" >
			   <img style="width:80%" src="<%=path%>/resources/img/wfwzy.png" >
		    </a>
	 </div>
</div>

		<div class="dock-fill scroll-y" style="margin-top: 75px;" watch-scroll-top="">
		<h1 class="action-bar__tie" ng-switch="actionBar.viewList.length" style="text-align: center;">
		<span class="action-bar__tie__norm ng-binding ng-scope"
			ng-switch-when="1" ng-bind="actionBar.viewList[0].name">教室查询</span>
	    </h1>
	    
	            <span>
					<select class="form-control search none-appearance ng-valid ng-dirty" id="pid" onchange="Change()">
					    <option value="选择教学楼查看">选择教学楼查看</option>
						<c:forEach var="data" items="${listAllJxl}" varStatus="obj">
							<option value="${data.jxl}" <c:if test="${data.jxl==jxl }">selected="selected"</c:if>>${data.jxl }</option>
						</c:forEach>
					</select>
				</span>
				
			<table class="table table-bordered table-classroom"
				ng-show="roomList.length>0" style="width:98%">
				<tbody>
      
					<tr>
						<td colspan="2" class="td-title ng-binding" ng-bind="dateStr"
							style="min-width: 125px; width: 125px;">07月10日(星期五)</td>
						<td colspan="7" class="text-center td-title">节次</td>
					</tr>

					<tr>
						<td class="td-title" style="width: 65px;">教学楼</td>
						<td class="td-title" style="width: 80px;">教室</td>
						<td class="td-title">1</td>
						<td class="td-title">2</td>
						<td class="td-title">3</td>
						<td class="td-title">4</td>
						<td class="td-title">5</td>
						<td class="td-title">6</td>
						<td class="td-title">7</td>
					</tr>
					<c:forEach var="data" items="${list}" varStatus="obj">
					<tr class="ng-scope"
						ng-repeat="room in roomList|filter:searchText.value" bindonce="">
						<td class="td-title ng-scope ver-top"
							ng-class="{'ver-top':room.rep}" bo-if="room.rep" rowspan="${data.num}">
							<span class="sp-title" bo-bind="room.jxl">${data.jxl }</span>
						</td>
					</tr>
					<c:forEach var="dataJs" items="${data.listJS}" varStatus="obj"> 
					<tr class="ng-scope"
						ng-repeat="room in roomList|filter:searchText.value" bindonce="">
						<td class="td-title" bo-bind="room.js">${dataJs.name }</td>
						<c:forEach var="dataJsKc" items="${dataJs.kcList}" varStatus="obj">
								
							<c:if test="${dataJsKc.yk==1}">
								<td class="ng-scope room-use" bindonce="" ng-repeat="jc in room.jcList"
								bo-bind="jc.jyqk" bo-class="jc.css">${dataJsKc.kcmc }</td>
							</c:if>
							<c:if test="${dataJsKc.yk==0}">
							<td class="ng-scope" bindonce="" ng-repeat="jc in room.jcList"
								bo-bind="jc.jyqk" bo-class="jc.css">空</td>
							</c:if>
						</c:forEach>
							
					</tr>
					</c:forEach>
					</c:forEach>
					
				</tbody>
			</table>

		</div>
		<br>

	</div>
</body>
</html>
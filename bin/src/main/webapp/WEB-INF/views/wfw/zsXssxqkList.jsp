<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String path = request.getContextPath();%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,,maximum-scale=3,user-scalable=yes;">
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/icons.css" />
    <script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
    <script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
	<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="lightBlue"/>
	<link href="<%=path%>/resources/css/common.css" rel="stylesheet" type="text/css">
	<link href="<%=path%>/resources/css/style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript">
		function Change(){
	        var objS = document.getElementById("pid");
	        var grade = objS.options[objS.selectedIndex].value;
	        location.href="<%=path%>/wfw/ZsXssxqk/toXssxqkByQh?bjbh="+grade;
       	}
	</script>
	<title>学生实习信息</title>
  </head>
 
  <body style="max-width:640px;margin-left: auto;margin-right: auto;">
  <div style="display:none;">
<ul class="tab-menu tab" id="tabMenuID_">
	<li class="tab-selected" title="学生实习信息">
	<a href="#" target="content" onfocus="this.blur()"><span>学生实习信息</span></a>
	</li>
</ul>
</div>
   <form action="<%=path%>/wfw/ZsXssxqk/toXssxqkByQh" method="POST" id="Form1">  
   <div class="tab-container">
   <div class="bg1">
	<div class="style1">
		<div class="wwx_f_l" style="position: relative;">
		<a class="font1" style="color:white;" href="<%=path%>/wfw/ZsXssxqk/toXssxqkByQh?openId=${openId }">班级查询</a>
		<span>
					<select class="SelectList width7" id="pid" onchange="Change()" style="top: -1px;left: 10px;">
						<c:forEach var="list" items="${qhlist}" varStatus="s">
							<option value="${list.bjbh }" <c:if test="${list.bjbh==bjbh }">selected="selected"</c:if>>${list.bjmc }</option>
						</c:forEach>
					</select>
				</span>
		</div>
				<div class="wwx_clear"></div>
				<div class="anniu" >
				<a style="float:right;width:40px;height:50px;" href="<%=path%>/wfw/zy/zhuye?openId=${openId}" >
			   <img style="width:70%" src="<%=path%>/resources/img/wfwzy.png" >
			   </a>
			      </div>
	</div>
</div>
   
				<%-- <!--我的奖惩-->
				<label style="font-size: 15pt;">微服务-学生实习查询</label><br /><br />
				<span>
					<select class="SelectList width7" id="pid" onchange="Change()">
						<c:forEach var="list" items="${qhlist}" varStatus="s">
							<option value="${list.bjbh }" <c:if test="${list.bjbh==bjbh }">selected="selected"</c:if>>${list.bjmc }</option>
						</c:forEach>
					</select>
				</span>
				<a href="<%=path%>/wfw/zy/zhuye?openId=${openId}" >
                  <div class="zhuye">
			   <img style="width:70%" src="<%=path%>/resources/img/zyan.png" >
			      </div>
		    </a> --%>
<div>
	<div class="style4">
	<c:if test="${empty cjlist}">
		<div class="text">
			<p>学生实习信息暂无...</p>
		</div>
	</c:if>
	<c:forEach var="data" items="${cjlist}" varStatus="obj">
		<div class="maring1">
				<div class="wwx_f_l" style="width:100%">
					<table style="width:100%; font-size: 17px;">
					    <tr>
					       <td>学号</td>
					       <td>${data.xh }</td>
					    </tr>
					    <tr>
					       <td>学生姓名</td>
					       <td>${data.XSXM }</td>
					    </tr>
					    <tr>
					       <td>班级编号</td>
					       <td>${data.BJBH }</td>
					    </tr>
					    <tr>
					        <td>实习地点</td> 
					        <td>${data.SXDD }</td>
					    </tr>
					    <tr>
					        <td>详细说明</td>
					        <td>${data.XXSM }</td>
					    </tr>
					    <tr>
					        <td>开始时间</td> 
					        <td>${data.kssj }</td>
					    </tr>
					    <tr>
					        <td>结束时间</td>
					        <td>${data.jssj }</td>
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

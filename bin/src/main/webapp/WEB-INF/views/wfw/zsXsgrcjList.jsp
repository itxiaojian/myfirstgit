<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String path = request.getContextPath();%>
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,user-scalable=yes, initial-scale=1,maximum-scale=3"></meta>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/icons.css" />
    <link href="<%=path%>/resources/css/common.css" rel="stylesheet" type="text/css">
	<link href="<%=path%>/resources/css/style.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/heeh.css" />

	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
  	<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
	<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="lightBlue"/>

	<script type="text/javascript">
		function Change(){
	        var objS = document.getElementById("pid");
	        var openId = document.getElementById("openId").value;
	        var grade = objS.options[objS.selectedIndex].value;
	        location.href="<%=path%>/wfw/ZsXscj/toXscjByQh?ksqh="+grade+"&openId="+openId;
       	}
		  $(function() {
	      	$("table tr:nth-child(odd)").addClass("odd-row");
		  	$("table td:first-child, table th:first-child").addClass("first");
		  	$("table td:last-child, table th:last-child").addClass("last");
		  });
	</script>
	<title>我的成绩</title>
  </head>
 
  <body style="max-width:640px;margin-left: auto;margin-right: auto;">
  <div style="display:none;">
<ul class="tab-menu tab" id="tabMenuID_">
	<li class="tab-selected" title="成绩查询">
	<a href="#" target="content" onfocus="this.blur()"><span>成绩查询</span></a>
	</li>
</ul>
</div>
   <form action="<%=path%>/wfw/ZsXscj/toXscjByQh" method="POST" id="Form1"> 
   <input type="hidden" name="openId" id="openId" value="${openId }"> 
   <div class="bg1">
	<div class="style1">
		<div class="wwx_f_l" style="position: relative;">
		<a class="font1" style="color:white;" href="<%=path%>/wfw/ZsXscj/toXscj?openId=${openId }">查询学年学期</a>
		<span>
					<select class="SelectList width7" id="pid" onchange="Change()" style="top: -1px;left: 10px;">
						<c:forEach var="list" items="${qhlist}" varStatus="s">
							<option value="${list.ksqh }" <c:if test="${list.ksqh==qh }">selected="selected"</c:if>>${list.ksqh }</option>
						</c:forEach>
					</select>
				</span>
		</div>
				<div class="wwx_clear"></div>
				<div class="anniu" style="left:90%;top:15%;" >
				<a style="float:right;width:40px;height:50px;" href="<%=path%>/wfw/zy/zhuye?openId=${openId}" >
			   <img style="width:70%" src="<%=path%>/resources/img/wfwzy.png" >
			   </a>
			      </div>
	</div>
</div>
   <div class="tab-container">
<div>
	<div class="style4">
	<c:if test="${empty cjlist}">
		<div class="text">
			<p>考试成绩信息暂无...</p>
		</div>
	</c:if> 
	<c:forEach var="data" items="${cjlist}" varStatus="obj">
		<div class="maring1">
				<div class="wwx_f_l" style="width:100%">
					<table style="width:100%;font-size: 17px;">
					     <tr>
					       <td>学号</td>
					       <td>${data.xh }</td>   
					    </tr>
					    <tr>
					       <td>考试学期</td>
					       <td>${data.KSXQ }</td>   
					    </tr>
					    <tr>
					       <td>学生姓名</td>
					       <td>${data.xm }</td>
					    </tr>
					    <tr>
					        <td>考试科目</td>
					        <td>${data.KSKM }</td>
					    </tr>
					    <tr>
					        <td>考试成绩</td>
					        <td>${data.KSCJ }</td>
					    </tr>
					    <tr>
					        <td>是否通过</td>
					        <td>
					         <c:choose>
					           <c:when test="${data.sftg =='0' }"><span style="color:red">不通过</span></c:when>
					           <c:when test="${data.sftg =='1' }"><span style="color:blue">通过</span></c:when>
					         </c:choose>
					        </td>
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
  

</html>

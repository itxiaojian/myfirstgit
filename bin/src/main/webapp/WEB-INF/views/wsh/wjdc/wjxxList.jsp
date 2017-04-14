<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String path = request.getContextPath();%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,user-scalable=yes, initial-scale=1,maximum-scale=3"></meta>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/icons.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/heeh.css" />

	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<%--   	<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script> --%>
	<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="lightBlue"/>
	<link href="<%=path%>/resources/css/base.css" rel="stylesheet" />
	<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
	
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/mobiscroll/mobiscroll.custom-2.13.2.min.css">  
 <!--时间控件mobiscroll-->  
   <script src="<%=path%>/resources/mobiscroll/js/mobiscroll.core-2.5.2.js" type="text/javascript"></script>  
   <script src="<%=path%>/resources/mobiscroll/js/mobiscroll.core-2.5.2-zh.js" type="text/javascript"></script>  
  
  
   <link href="<%=path%>/resources/mobiscroll/css/mobiscroll.core-2.5.2.css" rel="stylesheet" type="text/css" />  
   <link href="<%=path%>/resources/mobiscroll/css/mobiscroll.animation-2.5.2.css" rel="stylesheet" type="text/css" />  
   <script src="<%=path%>/resources/mobiscroll/js/mobiscroll.datetime-2.5.1.js" type="text/javascript"></script>  
   <script src="<%=path%>/resources/mobiscroll/js/mobiscroll.datetime-2.5.1-zh.js" type="text/javascript"></script>

	<script type="text/javascript">
	function preview_onClick2(id,status,openId){
		   var topicCode = id;
		   if(status==1 || status==2)
		   {
			   preview(topicCode,openId);
		   }
		   else
		   {
			alert("该问卷尚未发布，不能参与!");
		   }
	}
	function preview(id,openId){
		window.self.location="<%=path%>/wsh/WjQuestion/toDcwj?id="+id+"&openId="+openId;
	}
	function query(){
		$('#Form1').submit();
	}
	function preview_onClick3(id){
		window.self.location="<%=path%>/wsh/WjObject/toWjDcjgSj?id="+id;
	}
	</script>
	<link href="<%=path%>/resources/css/tab-import.css" rel="stylesheet" style="text/css" />
	<link href="<%=path%>/resources/css/css.css" rel="stylesheet" style="text/css" />
	<title>问卷调查</title>
	<style>
		
	</style>
  </head>
 
  <body style="overflow: auto;">
  <div style="display:none;">
<ul class="tab-menu tab" id="tabMenuID_">
	<li class="tab-selected" title="调查问卷信息">
	<a href="#" target="content" onfocus="this.blur()"><span>微问卷信息</span></a>
	</li>
</ul>
</div>
   <form action="<%=path%>/wsh/WjObject/toDcwj" method="POST" id="Form1">  
<div class="bg1">
	<div class="style1">
		<div class="wwx_f_l" style="position: relative;">
		<a class="font1" style="color:white;" href="#">问卷查询</a>
		<span><input id="bt" name="bt" onblur="query();"
				style="border:1px solid #dddddd;margin-left: 10px; margin-bottom: 4px;"/></span>
		</div>
				<div class="wwx_clear"></div>
				<div class="anniu" style="left:90%;top:15%;" >
				<a style="float:right;width:40px;height:50px;" href="<%=path%>/wsh/zy/zhuye?openId=${openId}" >
			   <img style="width:70%" src="<%=path%>/resources/img/wfwzy.png" >
			   </a>
			      </div>
	</div>
</div>
   <div class="tab-container">
				<!--我的工资-->
				<input type="hidden" id="date" name="date" value="${time}">
				<input type="hidden" name="openId" id="openId" value="${openId }"> 
					<table border="0" align="center" cellpadding="0" style="margin-top:80px;margin-bottom: 10px;width:100%; "
						cellspacing="0" class="content02">
						<c:if test="${empty list}">
								
										<div class="text" style="margin-top:80px;margin-bottom: 10px;width:100%; ">
											<p>微问卷信息暂无...</p>
										</div>
								
								
							</c:if>  
						<c:if test="${!empty list}">
						<tr class="bgcolor03">
						    <td width="10%" align="center" style="font-weight:bold;height:1%;">序号</td>
						    <td width="30%" align="center" style="font-weight:bold;height:1%;">标题</td>
						    <td width="40%" align="center" style="font-weight:bold;height:1%;">更新时间</td>
						    <td width="20%" align="center" style="font-weight:bold;height:1%;">操作</td>
					 	</tr>
					  </c:if>
							<c:forEach var="data" items="${list}" varStatus="obj">  <!-- varStatus="status" -->
							
						<!-- 判断偶数行 -->
						<c:if test="${obj.count%2 == '0'}">
							<tr class="bgcolor01">
							    <td align="center">${obj.count}</td>
							    <td align="center">${data.title}</td>
							    <td align="center">${data.createtime}</td>
							    <td align="center">
							    <c:if test="${data.sfcy eq 0 }">
							    	<a href="#" onclick="preview_onClick2('${data.oid}','${data.state}','${openId }');">点击进入</a>
							    </c:if>
							    <c:if test="${data.sfcy eq 1 }">
							    	<a href="#" onclick="preview_onClick3('${data.oid}');">查看结果</a>
							    </c:if>
							    </td>
						  </tr>
					 </c:if>
					 <!-- 判断奇数行 -->
					<c:if test="${obj.count%2 != '0'}">
					 	<tr class="bgcolor02">
							    <td align="center">${obj.count}</td>
							    <td align="center">${data.title}</td>
							    <td align="center">${data.createtime}</td>
							    <td align="center">
							    <c:if test="${data.sfcy eq 0 }">
							    	<a href="#" onclick="preview_onClick2('${data.oid}','${data.state}','${openId }');">点击进入</a>
							    </c:if>
							    <c:if test="${data.sfcy eq 1 }">
							    	<a href="#" onclick="preview_onClick3('${data.oid}');">查看结果</a>
							    </c:if>
							    </td>
					  </tr>
					</c:if>
					  
					  
			 </c:forEach>
					</table> </div>
		</form>		
  </body>
</html>

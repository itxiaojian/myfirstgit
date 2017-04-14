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
	

	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
  	<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
	<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="lightBlue"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/ext/resources/css/ext-all.css" />
    <script type="text/javascript" src="<%=path%>/resources/js/ext/ext-base.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/ext/ext-all.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/ext/ext-lang-zh_CN.js"></script>
    
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/icons.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/index.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/cps_icons.css" />
	<script type="text/javascript" src="<%=path%>/resources/js/ux/ST.ux.util.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/ux/ST.ux.ExtField.js"></script>	
	<script type="text/javascript" src="<%=path%>/resources/js/ux/Ext.ux.PagePlugins.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/ux/uxGrid.js"></script>

	<script type="text/javascript">
	
		ActDealWindow = Ext.extend(Ext.Window,{
		    constructor: function(grid) {
		    	ActDealWindow.superclass.constructor.call(this, {
		            width: 800,
		            anchor: '100%',
		            maximized :true,
		            height: 400,
		            resizable : false,
		            plain: true,
		            modal: true,
		            autoScroll: true,
		            closeAction: 'close',
		            html:'<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src=""></iframe>'
		        });
		    }
		});	
	
		function Change(){
	        var objS = document.getElementById("pid");
	        var grade = objS.options[objS.selectedIndex].value;
	        var openId = document.getElementById("openId").value;
	        location.href="<%=path%>/wfw/ZsXsjc/toXsjcByQh?ksqh="+grade+"&openId="+openId;
       	}
		
		function toMx(id){
	        //location.href="<%=path%>/wfw/ZsXsjc/toXsjcById?id="+id;
	        
	        var url = "<%=path%>/wfw/ZsXsjc/toXsjcById/" + id;   	
        	var html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
        	var ACT_DEAL_WINDOW = new ActDealWindow();
        	ACT_DEAL_WINDOW.setTitle("奖惩详细信息");
        	ACT_DEAL_WINDOW.html = html;
        	ACT_DEAL_WINDOW.show();
       	}
	</script>
	<style>
	  th,td {
	padding-bottom: 13px;
	padding-top: 13px;
	text-align: center;
	width: 50%;
}
	</style>
	<title>我的奖惩</title>
  </head>
 
  <body style="max-width:640px;margin-left: auto;margin-right: auto;">
  <div style="display:none;">
<ul class="tab-menu tab" id="tabMenuID_">
	<li class="tab-selected" title="奖惩查询信息">
	<a href="#" target="content" onfocus="this.blur()"><span>奖惩查询信息</span></a>
	</li>
</ul>
</div>
   <form action="<%=path%>/wfw/ZsXsjc/toXsjcByQh" method="POST" id="Form1"> 
   <input type="hidden" name="openId" id="openId" value="${openId }"> 
   <div class="bg1">
	<div class="style1">
		<div class="wwx_f_l" style="position: relative;">
		<a class="font1" style="color:white;" href="<%=path%>/wfw/ZsXsjc/toXsjc?openId=${openId }">查询学年学期</a>
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
				<%-- <!--我的奖惩-->
				<label style="font-size: 15pt;">微服务-奖惩查询</label><br /><br />
				<span>
					<select class="SelectList width7" id="pid" onchange="Change()">
						<c:forEach var="list" items="${qhlist}" varStatus="s">
							<option value="${list.ksqh }" <c:if test="${list.ksqh==qh }">selected="selected"</c:if>>${list.ksqh }</option>
						</c:forEach>
					</select>
				</span> --%>
				
<div>
	<div class="style4">
	<c:if test="${empty cjlist}">
		<div class="text">
			<p>奖惩信息暂无...</p>
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
					       <td>姓名</td>
					       <td>${data.xm }</td>
					    </tr>
					    <tr>
					       <td>奖惩类型</td>
					       <td>
					       <c:choose>
					       <c:when test="${data.JCLX =='0'}">奖励</c:when>
					       <c:when test="${data.JCLX =='1'}"><span style="color:red">惩罚</span></c:when>
					       <c:when test="${data.JCLX =='2'}">奖学金</c:when>
					       <c:when test="${data.JCLX =='3'}">助学金</c:when>
					       </c:choose>
					       </td>
					     </tr>
					     <tr>
					       <td>奖惩结果</td>
					       <td>${data.JCJG }</td>
					    </tr>
					    <tr>
					        <td>奖惩事由</td>
					        <td>${data.JCSY }</td>
					    </tr>
					    <tr>
					        <td>操作</td>
					        <td>
					        <a href="javascript:;" onclick="toMx(${data.id})"><span style="color:blue">详细</span></a>
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
  <script type="text/javascript">
$(function() {
    $("table tr:nth-child(odd)").addClass("odd-row");
	$("table td:first-child, table th:first-child").addClass("first");
	$("table td:last-child, table th:last-child").addClass("last");
});
</script>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<% String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 	<meta content="no-cache" http-equiv="Pragma" />
	<meta content="no-cache" http-equiv="Cache-Control" />
	<meta content="0" http-equiv="Expires" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta charset="utf-8" />
<!-- 	暂且不需要的js文件 -->
<%-- 	<script type="text/javascript" src="<%=path%>/resources/js/ux/OrgSingelSelectAll.js"></script> --%>
<%--   	<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script> --%>
<%-- 	<script type="text/javascript" src="<%=path%>/resources/js/ux/uxVtypes.js"></script> --%>
<%-- 	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/ux/fileuploadfield/css/fileuploadfield.css" /> --%>
<%-- 	<script type="text/javascript" src="<%=path%>/resources/js/ux/fileuploadfield/FileUploadField.js"></script> --%>
<%-- 	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT> --%>
<%-- 	<script type="text/javascript" src="<%=path%>/resources/js/ux/ST.ux.util.js"></script> --%>
<%-- 	<script type="text/javascript" src="<%=path%>/resources/js/ux/ST.ux.ExtField.js"></script>	 --%>

<!-- 暂且不需要的css文件 -->
<%-- 	<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="lightBlue"/> --%>
<%-- 	<link href="<%=path%>/resources/css/base.css" rel="stylesheet" /> --%>
<%-- 	<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/> --%>
<%-- 	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/index.css" /> --%>

	<!-- 必要文件 -->
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/ext/resources/css/ext-all.css" />
    <script type="text/javascript" src="<%=path%>/resources/js/ext/ext-base.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/ext/ext-all.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/ext/ext-lang-zh_CN.js"></script>
    <script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/ux/uxGrid.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/ux/Ext.ux.PagePlugins.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/ux/uxForm.js"></script>
     <!-- 添加这2个文件用来支持GRID复制 -->
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/ux/gridCopy/gridCopy.css" />
    <script type="text/javascript" src="<%=path%>/resources/js/ux/gridCopy/gridCopy.js"></script>
    
	<!-- 按钮图标 -->
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/icons.css" />
	
	<c:if test="${ypcs == 4 || ypcs == 5}">
	<script type="text/javascript" src="<%=path%>/resources/js/cps/process/pendWorkOrderPool1.js"></script>
	</c:if>
	<c:if test="${ypcs == 0 ||ypcs == 1 || ypcs == 2 || ypcs == 3 }">
	<script type="text/javascript" src="<%=path%>/resources/js/cps/process/pendWorkOrderPool.js"></script>
	</c:if>

	<script type="text/javascript">
		Ext.onReady(function(){
			var height = $(window).height();
			var width = $(window).width();
				});
	</script>
<style>
		.x-grid-record-red table{
   			 background: #FFDAB9; 
   		 } 
.hide{display:none;}
.nodata{color:red;text-align:center;}
#scrollContent{border:1px solid #cccccc;}
 .ext-strict{height:100%;} 
</style>
</head>
<body style="background-color:#ffffff;">
<div style="display:none;">
<ul class="tab-menu tab" id="tabMenuID_">
	
		<c:if test="${ypcs == 0}">
			<li class="tab-selected" title="任务分配">
				<a href="<%=path%>/cps/process/taskXN/pendWorkPoolIndex?ypcs=0" target="content" onfocus="this.blur()"><span>任务分配</span></a>
			</li>
		</c:if>
		<c:if test="${ypcs == 1}">
			<li class="tab-selected" title="报告编制">
				<a href="<%=path%>/cps/process/taskXN/pendWorkPoolIndex?ypcs=1" target="content" onfocus="this.blur()"><span>报告编制</span></a>
			</li>
		</c:if>
		<c:if test="${ypcs == 2}">
			<li class="tab-selected" title="报告审核">
				<a href="<%=path%>/cps/process/taskXN/pendWorkPoolIndex?ypcs=2" target="content" onfocus="this.blur()"><span>报告审核</span></a>
			</li>
		</c:if>
		<c:if test="${ypcs == 3}">
			<li class="tab-selected" title="报告批准">
				<a href="<%=path%>/cps/process/taskXN/pendWorkPoolIndex?ypcs=3" target="content" onfocus="this.blur()"><span>报告批准</span></a>
			</li>
		</c:if>
		<c:if test="${ypcs == 4}">
			<li class="tab-selected" title="报告接收">
				<a href="<%=path%>/cps/process/taskXN/pendWorkPoolIndex?ypcs=4" target="content" onfocus="this.blur()"><span>报告接收</span></a>
			</li>
		</c:if>
		<c:if test="${ypcs == 5}">
			<li class="tab-selected" title="报告归档">
				<a href="<%=path%>/cps/process/taskXN/pendWorkPoolIndex?ypcs=5" target="content" onfocus="this.blur()"><span>报告归档</span></a>
			</li>
		</c:if>
</ul>
</div>
	<form method="post" id="searchForm" action="<%=path%>/sys/SysUser/list">
	<input type="hidden" id="startId" name="start" value="0"/>	
	<input type="hidden" id="limitId" name="limit" value="10"/>
	<input type="hidden" id="ypcs" name="ypcs" value="${ypcs}"/>
 	</form>
	
	<div class="clear"></div>
	<script type="text/javascript">
		var YPCS=$("#ypcs").val();//获取参数
		var PROJECT_NAME=$("#projectName").val();//获取跟目录
	</script>
</body>
</html>
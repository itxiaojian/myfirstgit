<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*;"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%
PageOfficeCtrl poCtrl=new PageOfficeCtrl(request);
//设置服务器页面
poCtrl.setServerPage(request.getContextPath()+"/poserver.zz");

poCtrl.setTitlebar(true); //隐藏标题栏
poCtrl.setMenubar(false); //隐藏菜单栏
poCtrl.setOfficeToolbars(false);//隐藏Office工具条
poCtrl.setAllowCopy(false);//禁止拷贝
// poCtrl.setCustomToolbar(false);//隐藏自定义工具栏
//添加自定义按钮
//poCtrl.addCustomToolButton("返回","Fanhui",20);
//设置保存页面
// poCtrl.setSaveFilePage("save");
//poCtrl.setSaveFilePage("savePage");
//打开Word文档
poCtrl.webOpen(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+request.getAttribute("fileName"),OpenModeType.docReadOnly,"刘佚名");
poCtrl.setTagId("PageOfficeCtrl1");//此行必需
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>报告详情</title>
   	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
	<script type="text/javascript">
	        function Fanhui(){
	        	window.history.go(-1);
	        }
    </script>
</head>
<body>
    <form id="form1" >
    <div style=" width:auto; height:700px;">
        <po:PageOfficeCtrl id="PageOfficeCtrl1">
        </po:PageOfficeCtrl>
    </div>
    </form>
</body>
</html>

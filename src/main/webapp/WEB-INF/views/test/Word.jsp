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
// poCtrl.setCustomToolbar(false);//隐藏自定义工具栏
//添加自定义按钮
poCtrl.addCustomToolButton("保存","Save",1);
poCtrl.addCustomToolButton("打印预览","PrintView",7);
poCtrl.addCustomToolButton("打印","Print",6);
//设置保存页面
poCtrl.setSaveFilePage("save");
//poCtrl.setSaveFilePage("savePage");
//打开Word文档
String docPath=request.getSession().getServletContext().getRealPath("resources/doc");
poCtrl.webOpen(request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("fileName"),OpenModeType.docNormalEdit,"刘佚名");
poCtrl.setTagId("PageOfficeCtrl1");//此行必需
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>最简单的打开保存Word文件</title>
   	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
	<script type="text/javascript">
        function load() {
        	document.getElementById("PageOfficeCtrl1").FullScreen = true;
//         	document.getElementById("PageOfficeCtrl1").SaveAs( 'c:\', true ); 
        }
    </script>
</head>
<body onload="load();">
    <script type="text/javascript">
        function Save() {
            document.getElementById("PageOfficeCtrl1").WebSave();
        }
        function Print() {
            document.getElementById("PageOfficeCtrl1").PrintOut( true, '' ); 
        }
        function PrintView() {
            document.getElementById("PageOfficeCtrl1").PrintPreview();
        }
    </script>
    <form id="form1" >
    <div style=" width:auto; height:700px;">
        <po:PageOfficeCtrl id="PageOfficeCtrl1">
        </po:PageOfficeCtrl>
    </div>
    </form>
</body>
</html>

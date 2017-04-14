<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*;"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();
  String bgbh = request.getParameter("bgbh");%>
<%
PageOfficeCtrl poCtrl=new PageOfficeCtrl(request);
//设置服务器页面
poCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
//添加自定义按钮
// poCtrl.addCustomToolButton("保存","Save",1);
// poCtrl.addCustomToolButton("返回","Back",21);
//隐藏自定义工具栏
poCtrl.setCustomToolbar(true);
poCtrl.setOfficeToolbars(false);
poCtrl.setMenubar(true); //隐藏菜单栏
//设置保存页面
// poCtrl.setSaveFilePage("savepage");
//poCtrl.setSaveFilePage("savePage");
//打开Word文档
poCtrl.webOpen("/zjyw/resources/doc/"+bgbh+".doc", OpenModeType.docReadOnly, "张三");
poCtrl.setTagId("PageOfficeCtrl1");//此行必需
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>查看报告信息</title>
   	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
</head>
<body>
    <script type="text/javascript">
        function Save() {
            document.getElementById("PageOfficeCtrl1").WebSave();
        }
        function Back(){
        	window.history.back(-1);
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

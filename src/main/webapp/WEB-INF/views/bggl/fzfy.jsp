<%@page import="java.io.File"%>
<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*;"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%
	String bgbh = request.getParameter("bgbh");
	String bg = request.getParameter("bg");
	//******************************卓正PageOffice组件的使用*******************************
	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
	poCtrl1.setServerPage(request.getContextPath()+"/poserver.zz");
	poCtrl1.setCaption("编制附页");
	poCtrl1.setSaveFilePage(path+"/jygl/YjyBgxx/savePageTest?filename="+bgbh+"fy");
// 	WordDocument worddoc = new WordDocument();
	
// 	poCtrl1.setWriter(worddoc);

	//隐藏菜单栏
	//poCtrl1.setMenubar(false);
	//隐藏自定义工具栏
	//poCtrl1.setCustomToolbar(false);
	poCtrl1.setCustomToolbar(true);
	poCtrl1.setOfficeToolbars(false);

	//添加自定义按钮
	poCtrl1.addCustomToolButton("保存", "Save", 21);
	poCtrl1.addCustomToolButton("       ", "", 21);
	poCtrl1.addCustomToolButton("返回","Fanhui",21);
	poCtrl1.addCustomToolButton("       ", "", 21);
	poCtrl1.addCustomToolButton("温馨提示：当前报告为编号为："+bgbh+"的附页","",21);
	
	poCtrl1.webOpen("/zjyw/resources/doc/"+bg+"fy.doc", OpenModeType.docNormalEdit, "张三");
	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>预览报告信息</title>
		<script type="text/javascript">
	        function Fanhui(){
	        	window.history.back();
	        }
	        
	        function Save() {
		    	document.getElementById("PageOfficeCtrl1").WebSave();
			}
	        
	        function Zuida(){
	        	document.getElementById("PageOfficeCtrl1").FullScreen = true;
	        }
    	</script>
	</head>
	<body onload="Zuida()">
     <br />
		<form id="form1">
			<div style="width: auto; height: 700px;">
				<!--**************   PageOffice 客户端代码开始    ************************-->
				<po:PageOfficeCtrl id="PageOfficeCtrl1">
				</po:PageOfficeCtrl>
				<!--**************   PageOffice 客户端代码结束    ************************-->
			</div>
		</form>
	</body>
</html>
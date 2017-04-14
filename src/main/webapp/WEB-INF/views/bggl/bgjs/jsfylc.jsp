<%@page import="java.io.File"%>
<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*;"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%
	String bgbh = request.getParameter("bgbh");
	//******************************卓正PageOffice组件的使用*******************************
	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
	poCtrl1.setServerPage(request.getContextPath()+"/poserver.zz");
	poCtrl1.setSaveFilePage("savePage");
// 	WordDocument worddoc = new WordDocument();
	
// 	poCtrl1.setWriter(worddoc);

	//隐藏菜单栏
	//poCtrl1.setMenubar(false);
	//隐藏自定义工具栏
	//poCtrl1.setCustomToolbar(false);
	poCtrl1.setCustomToolbar(true);
	poCtrl1.setOfficeToolbars(false);

	//添加自定义按钮
	poCtrl1.addCustomToolButton("保存", "Save()", 1);
	poCtrl1.addCustomToolButton("返回","Fanhui",21);
	
// 	poCtrl1.setJsFunction_AfterDocumentOpened("AfterDocumentOpened");
	
	File file=new File(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fyG.doc");    
	if(!file.exists())    
	{    
		poCtrl1.webOpen("/zjyw/resources/home/"+bgbh+"fyG.doc", OpenModeType.docNormalEdit, "张三");
	}else{
		poCtrl1.webOpen("/zjyw/resources/doc/"+bgbh+"fyG.doc", OpenModeType.docNormalEdit, "张三");
	}
	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>预览报告信息</title>
		<script type="text/javascript">
		  //保存
		    function Save() {
		    	document.getElementById("PageOfficeCtrl1").WebSave();
			}
	        function Fanhui(){
	        	window.history.back();
	        }
	      //word编辑器最大化
	        function hehe(){
	        	document.getElementById("PageOfficeCtrl1").FullScreen = true;
	        }
	      //word编辑器最大化
	         $(function(){
	        	 document.getElementById("PageOfficeCtrl1").FullScreen = true;
		      });
    	</script>
	</head>
	<body>
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
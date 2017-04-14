<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*;"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%
	String ysjlwjm = request.getParameter("ysjlwjm");
	//******************************卓正PageOffice组件的使用*******************************
	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
	poCtrl1.setServerPage(request.getContextPath()+"/poserver.zz"); //此行必须
	WordDocument worddoc = new WordDocument();

	//隐藏菜单栏
	//poCtrl1.setMenubar(false);
	//隐藏自定义工具栏
	//poCtrl1.setCustomToolbar(false);
	poCtrl1.setCustomToolbar(true);
	poCtrl1.setOfficeToolbars(false);
	poCtrl1.setAllowCopy(false);//禁止拷贝

	//添加自定义按钮
	poCtrl1.addCustomToolButton("返回","Fanhui",21);
	
	poCtrl1.setJsFunction_AfterDocumentOpened("AfterDocumentOpened");
		poCtrl1.webOpen("/zjyw/resources/home/"+ysjlwjm, OpenModeType.docReadOnly, "张三");
	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>原始记录查看</title>
		<script type="text/javascript">
	        function Fanhui(){
	        	window.history.back(-1);
	        }
    	</script>
	</head>
	<body>
		<form id="form1">
			<div style="width: auto; height: 700px;">
				<!--**************   PageOffice 客户端代码开始    ************************-->
<%-- 				<po:FileMakerCtrl id="FileMakerCtrl1" > --%>
<%-- 				</po:FileMakerCtrl> --%>
				<po:PageOfficeCtrl id="PageOfficeCtrl1">
				</po:PageOfficeCtrl>
				<!--**************   PageOffice 客户端代码结束    ************************-->
			</div>
		</form>
	</body>
</html>
<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*;"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%
	String bgbh = request.getParameter("bgbh");
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
	poCtrl1.addCustomToolButton("返回","Fanhui",13);
	poCtrl1.addCustomToolButton("        ", "", 21);
	poCtrl1.addCustomToolButton("温馨提示：当前报告编号为："+bgbh+"。","",21);
	
	poCtrl1.setJsFunction_AfterDocumentOpened("AfterDocumentOpened");
		poCtrl1.webOpen("/zjyw/resources/doc/"+bgbh+".doc", OpenModeType.docReadOnly, "张三");
// 	if(request.getAttribute("gai") == "0"){
// 	}else if(request.getAttribute("gai") == "1"){
// 		poCtrl1.webOpen("/zjyw/resources/doc/"+bgbh+"G.doc", OpenModeType.docReadOnly, "张三");
// 	}
	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>预览报告信息</title>
		<script type="text/javascript">
	        function Fanhui(){
	        	window.history.back(-1);
	        }
    	</script>
	</head>
	<body>
		<form id="form1">
			<div style="width: auto; height: auto;">
				<!--**************   PageOffice 客户端代码开始    ************************-->
				<po:PageOfficeCtrl id="PageOfficeCtrl1">
				</po:PageOfficeCtrl>
				<!--**************   PageOffice 客户端代码结束    ************************-->
			</div>
		</form>
	</body>
</html>
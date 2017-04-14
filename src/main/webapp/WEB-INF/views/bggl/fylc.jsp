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
	//保存路径
	poCtrl1.setSaveFilePage("savePage");
	poCtrl1.setCaption("编制附页");
	poCtrl1.setMenubar(true); //菜单栏
	

	//添加自定义按钮
	poCtrl1.addCustomToolButton("保存", "Save()", 1);
	poCtrl1.addCustomToolButton("          ", "", 21);
	poCtrl1.addCustomToolButton("返回","Fanhui",13);
	poCtrl1.addCustomToolButton("       ", "", 21);
	poCtrl1.addCustomToolButton(bgbh,"",21);
	poCtrl1.addCustomToolButton("         ", "", 21);
	poCtrl1.addCustomToolButton("温馨提示：当前报告编号为："+bgbh+"。附页编制时，如需离开，请点击保存按钮！","",21);
	
	
	
	File file=new File(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fy.doc");    
	if(!file.exists())    
	{    
		poCtrl1.webOpen("/zjyw/resources/fylc/"+bgbh+"fy.doc", OpenModeType.docNormalEdit, "request.getParameter('xm')");
	}else{
		poCtrl1.webOpen("/zjyw/resources/doc/"+bgbh+"fy.doc", OpenModeType.docNormalEdit, "request.getParameter('xm')");
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
	        function Zuida(){
	        	document.getElementById("PageOfficeCtrl1").FullScreen = true;
	        }
    	</script>
	</head>
	<body onload="Zuida()">
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
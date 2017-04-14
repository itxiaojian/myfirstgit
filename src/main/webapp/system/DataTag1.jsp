<%@ page language="java" import="java.util.*"
	import="java.util.* ,java.awt.* ,com.zhuozhengsoft.pageoffice.FileMakerCtrl,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*,java.text.SimpleDateFormat,java.util.Date" pageEncoding="gb2312"%>
	<%@page import="java.io.FileOutputStream"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
	//PageOffice组件的使用
	//设置服务器页面
	FileMakerCtrl fmCtrl = new FileMakerCtrl(request);
	fmCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
	//定义WordDocument对象
	WordDocument doc = new WordDocument();	
	//定义DataTag对象
	DataTag deptTag = doc.openDataTag("{部门名}");
	//给DataTag对象赋值
	deptTag.setValue("B部门");
	deptTag.getFont().setColor(Color.GREEN);
	
	DataTag userTag = doc.openDataTag("{姓名}");
	userTag.setValue("李四");
	userTag.getFont().setColor(Color.GREEN);
	
	DataTag dateTag = doc.openDataTag("【时间】");
	
		doc.openDataRegion("PO_company").setValue("合肥智圣系统集成有限公司");
	dateTag.setValue(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
	dateTag.getFont().setColor(Color.BLUE);
	//打开Word文件
	//pCtrl.webOpen("doc/test2.doc", OpenModeType.docNormalEdit, "张佚名");
		fmCtrl.setWriter(doc);
		fmCtrl.setJsFunction_OnProgressComplete("OnProgressComplete()");
		fmCtrl.fillDocument("doc/test1.doc", DocumentOpenType.Word);
		fmCtrl.setSaveFilePage("Save1.jsp?filename=test13");
		fmCtrl.setTagId("FileMakerCtrl1"); //此行必须
		
		
//	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
//	poCtrl1.setServerPage(request.getContextPath()+"/poserver.zz"); //此行必须
//// 添加一个自定义工具条上的按钮，AddCustomToolButton的参数说明，详见开发帮助
//poCtrl1.addCustomToolButton("测试按钮","myTest",0);
//	//打开文件
//	poCtrl1.webOpen("doc/test13.doc", OpenModeType.docNormalEdit, "张三");
//	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'DataTag.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<!--**************   卓正 PageOffice 客户端代码开始    ************************-->

			<script language="javascript" type="text/javascript">
				function OnProgressComplete() {
					//document.getElementById("FileMakerCtrl1").PrintOut();
					window.parent.myFunc(); //调用父页面的js函数
				} function myTest() {
            document.getElementById("PageOfficeCtrl1").Alert("测试成功！");
        }
			</script>
			<!--**************   卓正 PageOffice 客户端代码结束    ************************-->
			<po:FileMakerCtrl id="FileMakerCtrl1"/>
				      	<%--打开服务器上指定磁盘路径下的文件<br/>--%>

		<%--<po:PageOfficeCtrl id="PageOfficeCtrl1" />--%>
    
   
  </body>
</html>

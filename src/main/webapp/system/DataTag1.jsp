<%@ page language="java" import="java.util.*"
	import="java.util.* ,java.awt.* ,com.zhuozhengsoft.pageoffice.FileMakerCtrl,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*,java.text.SimpleDateFormat,java.util.Date" pageEncoding="gb2312"%>
	<%@page import="java.io.FileOutputStream"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
	//PageOffice�����ʹ��
	//���÷�����ҳ��
	FileMakerCtrl fmCtrl = new FileMakerCtrl(request);
	fmCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
	//����WordDocument����
	WordDocument doc = new WordDocument();	
	//����DataTag����
	DataTag deptTag = doc.openDataTag("{������}");
	//��DataTag����ֵ
	deptTag.setValue("B����");
	deptTag.getFont().setColor(Color.GREEN);
	
	DataTag userTag = doc.openDataTag("{����}");
	userTag.setValue("����");
	userTag.getFont().setColor(Color.GREEN);
	
	DataTag dateTag = doc.openDataTag("��ʱ�䡿");
	
		doc.openDataRegion("PO_company").setValue("�Ϸ���ʥϵͳ�������޹�˾");
	dateTag.setValue(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
	dateTag.getFont().setColor(Color.BLUE);
	//��Word�ļ�
	//pCtrl.webOpen("doc/test2.doc", OpenModeType.docNormalEdit, "������");
		fmCtrl.setWriter(doc);
		fmCtrl.setJsFunction_OnProgressComplete("OnProgressComplete()");
		fmCtrl.fillDocument("doc/test1.doc", DocumentOpenType.Word);
		fmCtrl.setSaveFilePage("Save1.jsp?filename=test13");
		fmCtrl.setTagId("FileMakerCtrl1"); //���б���
		
		
//	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
//	poCtrl1.setServerPage(request.getContextPath()+"/poserver.zz"); //���б���
//// ���һ���Զ��幤�����ϵİ�ť��AddCustomToolButton�Ĳ���˵���������������
//poCtrl1.addCustomToolButton("���԰�ť","myTest",0);
//	//���ļ�
//	poCtrl1.webOpen("doc/test13.doc", OpenModeType.docNormalEdit, "����");
//	poCtrl1.setTagId("PageOfficeCtrl1"); //���б���
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
    	<!--**************   ׿�� PageOffice �ͻ��˴��뿪ʼ    ************************-->

			<script language="javascript" type="text/javascript">
				function OnProgressComplete() {
					//document.getElementById("FileMakerCtrl1").PrintOut();
					window.parent.myFunc(); //���ø�ҳ���js����
				} function myTest() {
            document.getElementById("PageOfficeCtrl1").Alert("���Գɹ���");
        }
			</script>
			<!--**************   ׿�� PageOffice �ͻ��˴������    ************************-->
			<po:FileMakerCtrl id="FileMakerCtrl1"/>
				      	<%--�򿪷�������ָ������·���µ��ļ�<br/>--%>

		<%--<po:PageOfficeCtrl id="PageOfficeCtrl1" />--%>
    
   
  </body>
</html>

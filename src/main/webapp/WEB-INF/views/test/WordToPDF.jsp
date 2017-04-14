<%@ page language="java"
	import="java.util.*, com.zhuozhengsoft.pageoffice.*"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%
PageOfficeCtrl pocCtrl=new PageOfficeCtrl(request);
//���÷�����ҳ��
pocCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
//�����Զ��尴ť
pocCtrl.addCustomToolButton("����", "Save()", 1);
pocCtrl.addCustomToolButton("����ΪPDF�ļ�", "SaveAsPDF()", 1);
//���ñ���ҳ��
pocCtrl.setSaveFilePage("save");
String fileName = "test.doc";
String pdfName = fileName.substring(0, fileName.length() - 4) + ".pdf";
//���ļ�
pocCtrl.webOpen(path+"/resources/doc/" + fileName, OpenModeType.docNormalEdit, "������");
pocCtrl.setTagId("PageOfficeCtrl1");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Word�ļ�ת����PDF��ʽ</title>
		<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
		<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
		<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
		<script type="text/javascript">
        //����
        function Save() {
            document.getElementById("PageOfficeCtrl1").WebSave();
        }

        //����ΪPDF�ļ�
        function SaveAsPDF() {
            document.getElementById("PageOfficeCtrl1").WebSaveAsPDF();
<%--             window.open("OpenPDF.jsp?fileName=<%=pdfName %>"); --%>
            window.open("<%=path %>/test/saveToPdfPage?fileName=<%=pdfName %>");
        }
    </script>
	</head>
	<body>
		<form id="form1">
			<div style="width: auto; height: 700px;">
				<po:PageOfficeCtrl id="PageOfficeCtrl1">
				</po:PageOfficeCtrl>
			</div>
		</form>
	</body>
</html>

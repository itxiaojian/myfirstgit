<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="com.zhuozhengsoft.pageoffice.PDFCtrl"%>
<%@page import="com.zhuozhengsoft.pageoffice.ThemeType"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();
 String jdzssub = request.getParameter("jdzssub");%>
<%
PDFCtrl pdfCtrl=new PDFCtrl(request);
//���÷�����ҳ��
pdfCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
//����Զ��尴ť
String cs = request.getParameter("cs");
if(cs==null){
	pdfCtrl.addCustomToolButton("����","Fanhui",21);
}
//�����Զ��幤����
pdfCtrl.setCustomToolbar(true);
// pdfCtrl.setOfficeToolbars(false);
pdfCtrl.setMenubar(true); //���ز˵���
//���ñ���ҳ��
// poCtrl.setSaveFilePage("savepage");
//poCtrl.setSaveFilePage("savePage");
//��Word�ĵ�
pdfCtrl.webOpen(request.getSession().getServletContext().getRealPath("")+"/"+request.getAttribute("jdzssub"));
pdfCtrl.setTagId("PDFCtrl1");//���б���
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�ļ��鿴</title>
		<!--**************   ׿�� PageOffice �ͻ��˴��뿪ʼ    ************************-->
		<script language="javascript" type="text/javascript">
	function Print() {
		//alert(document.getElementById("PDFCtrl1").Caption);//��ʾ����
		document.getElementById("PDFCtrl1").ShowDialog(4);
	}
	function SwitchFullScreen() {
		document.getElementById("PDFCtrl1").FullScreen = !document
				.getElementById("PDFCtrl1").FullScreen;
	}
	function SetPageReal() {
		document.getElementById("PDFCtrl1").SetPageFit(1);
	}
	function SetPageFit() {
		document.getElementById("PDFCtrl1").SetPageFit(2);
	}
	function SetPageWidth() {
		document.getElementById("PDFCtrl1").SetPageFit(3);
	}
	function ZoomIn() {
		document.getElementById("PDFCtrl1").ZoomIn();
	}
	function ZoomOut() {
		document.getElementById("PDFCtrl1").ZoomOut();
	}
	function FirstPage() {
		document.getElementById("PDFCtrl1").GoToFirstPage();
	}
	function PreviousPage() {
		document.getElementById("PDFCtrl1").GoToPreviousPage();
	}
	function NextPage() {
		document.getElementById("PDFCtrl1").GoToNextPage();
	}
	function LastPage() {
		document.getElementById("PDFCtrl1").GoToLastPage();
	}
	function RotateRight() {
		document.getElementById("PDFCtrl1").RotateRight();
	}
	function RotateLeft() {
		document.getElementById("PDFCtrl1").RotateLeft();
	}
    function Fanhui(){
    	window.history.back(-1);
    }
</script>
<body>
    <form id="form1" >
    <div style=" width:auto; height:700px;">
        <po:PDFCtrl id="PDFCtrl1">
        </po:PDFCtrl>
    </div>
    </form>
</body>
</html>

<%@page import="org.apache.poi.POIXMLDocument"%>
<%@page import="org.apache.poi.xwpf.usermodel.XWPFDocument"%>
<%@ page language="java"
	import="java.util.* ,java.awt.* ,com.zhuozhengsoft.pageoffice.FileMakerCtrl,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*,java.text.SimpleDateFormat,java.util.Date"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%String bgbh=request.getParameter("bgbh");

WordDocument worddoc = new WordDocument();
	//���
		if(request.getAttribute("nf") == null){
				
		}else{
			DataRegion dataRegion19 = worddoc.openDataRegion("PO_nf");
			dataRegion19.setValue(""+request.getAttribute("nf"));
		}
		
	//��
		if(request.getAttribute("h") == null){
			
		}else{
			DataRegion dataRegion20 = worddoc.openDataRegion("PO_h");
			dataRegion20.setValue(""+request.getAttribute("h"));
		}
		
	//��
		if(request.getAttribute("z") == null){
			
		}else{
			DataRegion dataRegion21 = worddoc.openDataRegion("PO_z");
			dataRegion21.setValue(""+request.getAttribute("z"));
		}
		
		FileMakerCtrl fmCtrl = new FileMakerCtrl(request);
		fmCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
		fmCtrl.setWriter(worddoc);
// 		fmCtrl.setJsFunction_OnProgressComplete("OnProgressComplete()");
		fmCtrl.fillDocument(request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("sub"), DocumentOpenType.Word);
		fmCtrl.setSaveFilePage(path+"/jygl/YjyBgxx/saveFyPage?filename="+bgbh+"fy");
// 		if(request.getAttribute("gai") == "0"){
// 		}else if(request.getAttribute("gai") == "1"){
// 			fmCtrl.setSaveFilePage(path+"/jygl/YjyBgxx/saveFyPage?filename="+bgbh+"fy");
// 		}
		fmCtrl.setTagId("FileMakerCtrl1"); //���б���
		
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>��򵥵Ĵ򿪱���Word�ļ�</title>
   	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
</head>
<style>
        html, body
        {
            height: 100%;
        }
        .main
        {
            height: 100%;
        }
    </style>
<body>
    <form id="form1" >
    <div style=" width:auto; height:700px;">
    	<po:FileMakerCtrl id="FileMakerCtrl1" />
<%--         <po:PageOfficeCtrl id="PageOfficeCtrl1"> --%>
<%--         </po:PageOfficeCtrl> --%>
    </div>
    </form>
</body>
</html>

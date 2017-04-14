<%@page import="java.io.File"%>
<%@ page language="java"
	import="java.util.* ,java.awt.* ,com.zhuozhengsoft.pageoffice.FileMakerCtrl,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*,java.text.SimpleDateFormat,java.util.Date"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%String bgbh=request.getParameter("bgbh");

WordDocument worddoc = new WordDocument();
	//年份
		if(request.getAttribute("nf") == null){
				
		}else{
			DataRegion dataRegion19 = worddoc.openDataRegion("PO_nf");
			dataRegion19.setValue(""+request.getAttribute("nf"));
		}
		
	//号
		if(request.getAttribute("h") == null){
			
		}else{
			DataRegion dataRegion20 = worddoc.openDataRegion("PO_h");
			dataRegion20.setValue(""+request.getAttribute("h"));
		}
		
	//字
		if(request.getAttribute("z") == null){
			
		}else{
			DataRegion dataRegion21 = worddoc.openDataRegion("PO_z");
			dataRegion21.setValue(""+request.getAttribute("z"));
		}
	
	//页数
	if(request.getAttribute("pages") == null){
		
	}else{
		DataRegion dataRegion21 = worddoc.openDataRegion("PO_pages");
		dataRegion21.setValue(""+request.getAttribute("pages"));
	}
	
		FileMakerCtrl fmCtrl = new FileMakerCtrl(request);
		
		fmCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
		fmCtrl.setWriter(worddoc);
		fmCtrl.fillDocument(request.getSession().getServletContext().getRealPath("resources/home")+"/"+"gjbg.doc", DocumentOpenType.Word);
		fmCtrl.setSaveFilePage(path+"/jygl/YjyBgxx/savePageTest?filename="+bgbh+"gjbg");
		fmCtrl.setTagId("FileMakerCtrl1"); //此行必须
		
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>最简单的打开保存Word文件</title>
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

<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*;"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%
	String bgbh = request.getParameter("bgbh");
	//******************************卓正PageOffice组件的使用*******************************
	WordDocument worddoc = new WordDocument();

//封面
		DataRegion data1 = worddoc.openDataRegion("PO_p1");
		data1.setValue("[word]"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fm"+".doc"+"[/word]");
// 	if(request.getAttribute("gai") == "0"){
// 	}else{
// 		DataRegion data1 = worddoc.openDataRegion("PO_p1");
// 		data1.setValue("[word]"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fmG"+".doc"+"[/word]");
// 	}
	
//首页
		DataRegion data2 = worddoc.openDataRegion("PO_p2");
		data2.setValue("[word]"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"sy"+".doc"+"[/word]");
// 	if(request.getAttribute("gai") == "0"){
// 	}else{
// 		DataRegion data2 = worddoc.openDataRegion("PO_p2");
// 		data2.setValue("[word]"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"syG"+".doc"+"[/word]");
// 	}
	
//附页
		DataRegion data3 = worddoc.openDataRegion("PO_p3");
		data3.setValue("[word]"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fy"+".doc"+"[/word]");
// 	if(request.getAttribute("gai") == "0"){
// 	}else{
// 		DataRegion data3 = worddoc.openDataRegion("PO_p3");
// 		data3.setValue("[word]"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fy"+".doc"+"[/word]");
// 	}

	FileMakerCtrl fmCtrl = new FileMakerCtrl(request);
	fmCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
	fmCtrl.setWriter(worddoc);
	if("0".equals( request.getAttribute("fl")) || "4".equals( request.getAttribute("fl")) || "6".equals( request.getAttribute("fl"))){
		fmCtrl.fillDocument(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"ybbg.doc", DocumentOpenType.Word);
			fmCtrl.setSaveFilePage(path+"/jygl/YjyBgxx/savePageTest?filename="+bgbh);
// 		if(request.getAttribute("gai") == "0"){
// 		}else if(request.getAttribute("gai") == "1"){
// 			fmCtrl.setSaveFilePage(path+"/jygl/YjyBgxx/savePageTest?filename="+bgbh+"G");
// 		}
	}else if("1".equals( request.getAttribute("fl")) ){
		fmCtrl.fillDocument(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"gpbg.doc", DocumentOpenType.Word);
			fmCtrl.setSaveFilePage(path+"/jygl/YjyBgxx/savePageTest?filename="+bgbh);
// 		if(request.getAttribute("gai") == "0"){
// 		}else if(request.getAttribute("gai") == "1"){
// 			fmCtrl.setSaveFilePage(path+"/jygl/YjyBgxx/savePageTest?filename="+bgbh+"G");
// 		}
	}else if("2".equals( request.getAttribute("fl")) || "5".equals( request.getAttribute("fl")) ){
		fmCtrl.fillDocument(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"gjbg.doc", DocumentOpenType.Word);
			fmCtrl.setSaveFilePage(path+"/jygl/YjyBgxx/savePageTest?filename="+bgbh);
// 		if(request.getAttribute("gai") == "0"){
// 		}else if(request.getAttribute("gai") == "1"){
// 			fmCtrl.setSaveFilePage(path+"/jygl/YjyBgxx/savePageTest?filename="+bgbh+"G");
// 		}
	}
	fmCtrl.setTagId("FileMakerCtrl1"); //此行必须
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>预览报告信息</title>
	</head>
	<body>
		<form id="form1">
			<div style="width: auto; height: 700px;">
				<!--**************   PageOffice 客户端代码开始    ************************-->
				<po:FileMakerCtrl id="FileMakerCtrl1" >
				</po:FileMakerCtrl>
				<!--**************   PageOffice 客户端代码结束    ************************-->
			</div>
		</form>
	</body>
</html>
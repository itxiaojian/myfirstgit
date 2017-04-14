<%@page import="java.io.File"%>
<%@ page language="java" import="java.util.*"
	import="java.util.* ,java.awt.* ,com.zhuozhengsoft.pageoffice.FileMakerCtrl,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*,java.text.SimpleDateFormat,java.util.Date" pageEncoding="gb2312"%>
	<%@page import="java.io.FileOutputStream"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%
String bgbh = request.getParameter("bgbh");
//设置服务器页面
//添加自定义按钮

	WordDocument doc = new WordDocument();

	//主检人
	if(request.getAttribute("zjr") == null){
		
	}else{
		File file=new File(request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("zjr"));    
		if(!file.exists())    
		{    
			DataRegion dataRegion30 = doc.openDataRegion("PO_zjr");
			dataRegion30.setValue("");
		}else{
			DataRegion dataRegion28 = doc.openDataRegion("PO_zjr");
			dataRegion28.setValue("[image]"+request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("zjr")+"[/image]");
		}
	}
	
	//审核人
	if(request.getAttribute("shr") == null){
		
	}else{
		File file=new File(request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("shr"));    
		if(!file.exists())    
		{    
			DataRegion dataRegion30 = doc.openDataRegion("PO_shr");
			dataRegion30.setValue("");
		}else{
			DataRegion dataRegion29 = doc.openDataRegion("PO_shr");
			dataRegion29.setValue("[image]"+request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("shr")+"[/image]");
		}
	}
	
	
	FileMakerCtrl fmCtrl = new FileMakerCtrl(request);
	fmCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
	fmCtrl.setWriter(doc);
// 	fmCtrl.setJsFunction_OnProgressComplete("OnProgressComplete()");
		fmCtrl.setSaveFilePage(path+"/jygl/YjyBgxx/savePageTest?filename="+bgbh+"sy");
		fmCtrl.fillDocument(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"sy.doc", DocumentOpenType.Word);
// 	if(request.getAttribute("gai") == "0"){
// 	}else if(request.getAttribute("gai") == "1"){
// 		fmCtrl.setSaveFilePage(path+"/jygl/YjyBgxx/savePageTest?filename="+bgbh+"syG");
// 		fmCtrl.fillDocument(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"syG.doc", DocumentOpenType.Word);
// 	}
	fmCtrl.setTagId("FileMakerCtrl1"); //此行必须

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>首页预览</title>
</head>
<body>
    <form id="form1" >
    <div style=" width:auto; height:700px;">
        <po:FileMakerCtrl id="FileMakerCtrl1" >
        </po:FileMakerCtrl>
    </div>
    </form>
</body>
</html>

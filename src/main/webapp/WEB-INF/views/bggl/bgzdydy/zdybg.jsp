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
	if("1".equals(request.getAttribute("ymids"))){
		//封面
		if(request.getAttribute("gai") == "0"){
			DataRegion data1 = worddoc.openDataRegion("PO_p1");
			data1.setValue("[word]"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fmzdy"+".doc"+"[/word]");
		}else{
			DataRegion data1 = worddoc.openDataRegion("PO_p1");
			data1.setValue("[word]"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fmGzdy"+".doc"+"[/word]");
		}
	}
	
	if("2".equals(request.getAttribute("ymids"))){
		//首页
		if(request.getAttribute("gai") == "0"){
			DataRegion data2 = worddoc.openDataRegion("PO_p2");
			data2.setValue("[word]"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"sy"+".doc"+"[/word]");
		}else{
			DataRegion data2 = worddoc.openDataRegion("PO_p2");
			data2.setValue("[word]"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"syG"+".doc"+"[/word]");
		}
		
	}
	
	
// //附页
// 	if(request.getAttribute("gai") == "0"){
// 		DataRegion data3 = worddoc.openDataRegion("PO_p3");
// 		data3.setValue("[word]"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fy"+".doc"+"[/word]");
// 	}else{
// 		DataRegion data3 = worddoc.openDataRegion("PO_p3");
// 		data3.setValue("[word]"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fy"+".doc"+"[/word]");
// 	}

	poCtrl1.setWriter(worddoc);

	//隐藏菜单栏
	//poCtrl1.setMenubar(false);
	//隐藏自定义工具栏
	//poCtrl1.setCustomToolbar(false);
	poCtrl1.setCustomToolbar(true);
	poCtrl1.setOfficeToolbars(false);
	poCtrl1.setMenubar(true); //隐藏菜单栏
	poCtrl1.setAllowCopy(false);//禁止拷贝

	//添加自定义按钮
// 	poCtrl1.addCustomToolButton("另存为PDF文件", "SaveAsPDF()", 1);
	poCtrl1.addCustomToolButton("返回","Fanhui",21);
	poCtrl1.addCustomToolButton("打印预览","PrintView",7);
	poCtrl1.addCustomToolButton("打印","Print",6);
	
	//设置保存页面
	poCtrl1.setSaveFilePage(path+"/jygl/YjyBgxx/savePDF");
	String fileName = "Jybg.doc";
	String pdfName = fileName.substring(0, fileName.length() - 4) + ".pdf";
	
	poCtrl1.setJsFunction_AfterDocumentOpened("AfterDocumentOpened");
	if("0".equals( request.getAttribute("fl")) || "4".equals( request.getAttribute("fl")) || "6".equals( request.getAttribute("fl"))){
		poCtrl1.webOpen("/zjyw/resources/doc/ybbg.doc", OpenModeType.docReadOnly, "");
	}else if("1".equals( request.getAttribute("fl")) ){
		poCtrl1.webOpen("/zjyw/resources/doc/gpbg.doc", OpenModeType.docReadOnly, "");
	}else if("2".equals( request.getAttribute("fl")) ||"5".equals( request.getAttribute("fl")) ){
		poCtrl1.webOpen("/zjyw/resources/doc/gjbg.doc", OpenModeType.docReadOnly, "");
	}
	String docPath=request.getSession().getServletContext().getRealPath("resources")+"/doc";
	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
	
// 	FileMakerCtrl fmCtrl = new FileMakerCtrl(request);
// 	fmCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
// 	fmCtrl.setSaveFilePage("savePageTest?filename="+bgbh);
// 	fmCtrl.setWriter(worddoc);
// 	fmCtrl.setJsFunction_OnProgressComplete("OnProgressComplete()");
// 	fmCtrl.fillDocument(request.getSession().getServletContext().getRealPath("resources/doc")+"/Jybg.doc", DocumentOpenType.Word);
// 	fmCtrl.setTagId("FileMakerCtrl1"); //此行必须
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>预览报告信息</title>
		<script type="text/javascript">
<%-- 			alert("<%=pdfName %>"); --%>
			//另存为PDF文件
	        function SaveAsPDF() {
	            document.getElementById("PageOfficeCtrl1").WebSaveAsPDF();
	<%--             window.open("OpenPDF.jsp?fileName=<%=pdfName %>"); --%>
	            window.open("<%=path %>/jygl/YjyBgxx/saveToThreePdfPage?fileName=<%=pdfName %>");
	        }
	        function AfterDocumentOpened() {
	            document.getElementById("PageOfficeCtrl1").SetEnableFileCommand(3, false); // 禁止保存
	            document.getElementById("PageOfficeCtrl1").SetEnableFileCommand(4, true); // 禁止另存
	            document.getElementById("PageOfficeCtrl1").SetEnableFileCommand(5, true); //禁止打印
	            document.getElementById("PageOfficeCtrl1").SetEnableFileCommand(6, true); // 禁止页面设置
	        }
	        
	        function Fanhui(){
	        	window.history.go(-1);
	        }
	       //word编辑器最大化
	         function hehe(){
	         	document.getElementById("PageOfficeCtrl1").FullScreen = true; 
	         }
	         function PrintView() {
	             document.getElementById("PageOfficeCtrl1").PrintPreview();
	         }
	         
	         function Print() {
	         	var bgbh='${bgbh}';
	 	        document.getElementById("PageOfficeCtrl1").PrintOut( true, '' ); 
	             var url = "<%=path%>/jygl/YjyBgxx/updateDycs";
	             $.ajax({
	                  cache: true,
	                  type: "POST",
	                  url: url,
	                  data: {bgbh:bgbh},// 你的formid
	                  async: false,
	                  error: function (request) {
	                       alert("连接失败,请联系管理员。");
	                  },
	                  success: function (data) {
	                     	
	                  }
	             });
	         }
    	</script>
	</head>
	<body onload="hehe();">
		<form id="form1">
			<div style="width: auto; height: 700px;">
				<!--**************   PageOffice 客户端代码开始    ************************-->
<%-- 				<po:FileMakerCtrl id="FileMakerCtrl1" > --%>
<%-- 				</po:FileMakerCtrl> --%>
				<po:PageOfficeCtrl id="PageOfficeCtrl1">
				</po:PageOfficeCtrl>
				<!--**************   PageOffice 客户端代码结束    ************************-->
			</div>
<!-- 			<div style="width:0px;height:0px;border-width: 0px;"> -->
<%-- 				<iframe id="test1" src="<%=path%>/jygl/YjyBgxx/bgcc?bgbh=<%=bgbh%>" style="width:0px;height:0px;border-width: 0px;"></iframe> --%>
<!-- 			</div> -->
		</form>
	</body>
</html>
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
	if("3".equals(request.getAttribute("ymids"))){
		//附页
			DataRegion data3 = worddoc.openDataRegion("PO_p1");
			data3.setValue("[word]"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fy"+".doc"+"[/word]");
// 		if(request.getAttribute("gai") == "0"){
// 		}else{
// 			DataRegion data3 = worddoc.openDataRegion("PO_p1");
// 			data3.setValue("[word]"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fy"+".doc"+"[/word]");
// 		}
	}
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
	poCtrl1.addCustomToolButton("打印预览","PrintView",7);
	poCtrl1.addCustomToolButton("打印","Print",6);
	poCtrl1.addCustomToolButton("返回","Fanhui",21);
	
	poCtrl1.setJsFunction_AfterDocumentOpened("AfterDocumentOpened");
	if("0".equals( request.getAttribute("fl")) || "4".equals( request.getAttribute("fl")) || "6".equals( request.getAttribute("fl"))){
		poCtrl1.webOpen("/zjyw/resources/doc/ybbgfy.doc", OpenModeType.docReadOnly, "");
	}else if("1".equals( request.getAttribute("fl")) ){
		poCtrl1.webOpen("/zjyw/resources/doc/gpbgfy.doc", OpenModeType.docReadOnly, "");
	}else if("2".equals( request.getAttribute("fl")) ||"5".equals( request.getAttribute("fl")) ){
		poCtrl1.webOpen("/zjyw/resources/doc/gjbgfy.doc", OpenModeType.docReadOnly, "");
	}
	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>预览报告信息</title>
		<script type="text/javascript">
	        
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
				<po:PageOfficeCtrl id="PageOfficeCtrl1">
				</po:PageOfficeCtrl>
				<!--**************   PageOffice 客户端代码结束    ************************-->
			</div>
		</form>
	</body>
</html>
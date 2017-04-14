<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*;"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%
PDFCtrl poCtrl = new PDFCtrl(request);
//设置服务器页面
poCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
poCtrl.setCaption("报告整体打印");
poCtrl.setTitlebar(true); //隐藏标题栏
poCtrl.setMenubar(false); //隐藏菜单栏
// poCtrl.setOfficeToolbars(false);//隐藏Office工具条
// poCtrl.setCustomToolbar(false);//隐藏自定义工具栏
poCtrl.setAllowCopy(false);//禁止拷贝
//添加自定义按钮
	poCtrl.addCustomToolButton("        ", "", 21);
	poCtrl.addCustomToolButton("打印","Print",6);
	poCtrl.addCustomToolButton("        ", "", 21);
//设置保存页面
poCtrl.setServerPage(request.getContextPath()+"/poserver.zz"); //此行必须
//打开Word文档
poCtrl.webOpen(request.getSession().getServletContext().getRealPath("resources/qfz")+"/"+request.getAttribute("fileName"));
poCtrl.setTagId("PDFCtrl1");//此行必需
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>报告整体打印</title>
   	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
    
     <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
</head>
<script type="text/javascript">
			function Print() {
				var bgbh='${bgbh}';
			    document.getElementById("PDFCtrl1").PrintOut( true, '' ); 
				 var url = "<%=path%>/jygl/YjyBgxx/deleteqfz";
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
<body>
    <form id="form1" >
    <div style=" width:auto; height:auto;">
        <po:PDFCtrl id="PDFCtrl1" />
    </div>
    <input type="hidden" id="bgbh"  value="${bgbh }">
    </form>
</body>
</html>

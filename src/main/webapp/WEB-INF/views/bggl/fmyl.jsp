<%@ page language="java" import="java.util.*"
	import="java.util.* ,java.awt.* ,com.zhuozhengsoft.pageoffice.FileMakerCtrl,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*,java.text.SimpleDateFormat,java.util.Date" pageEncoding="gb2312"%>
	<%@page import="java.io.FileOutputStream"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%
	String bgbh = request.getParameter("bgbh");
	//******************************卓正PageOffice组件的使用*******************************
	FileMakerCtrl fmCtrl = new FileMakerCtrl(request);
	fmCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
	//添加自定义按钮
// 	poCtrl1.addCustomToolButton("保存","Save",1);
// 	poCtrl1.addCustomToolButton("返回","Fanhui",21);
// 	//设置保存页面
// 	poCtrl1.setSaveFilePage("savePage");

	WordDocument worddoc = new WordDocument();
	//先在要插入word文件的位置手动插入书签,书签必须以“PO_”为前缀
	//给DataRegion赋值,值的形式为："[word]word文件路径[/word]、[excel]excel文件路径[/excel]、[image]图片路径[/image]"
	//图片1
	if(request.getAttribute("rztbdz1") == null){
		
	}else{
	DataRegion data1 = worddoc.openDataRegion("PO_p1");
	data1.setValue("[image]"+request.getSession().getServletContext().getRealPath("resources/home")+
			"/"+request.getAttribute("rztbdz1")+"[/image]");
	}
	//图片2
	if(request.getAttribute("rztbdz2") == null){
		
	}else{
		DataRegion data2 = worddoc.openDataRegion("PO_p2");
		data2.setValue("[image]"+request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("rztbdz2")+"[/image]");
	}
	//图片3
	if(request.getAttribute("rztbdz3") == null){
		
	}else{
		DataRegion data3 = worddoc.openDataRegion("PO_p3");
		data3.setValue("[image]"+request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("rztbdz3")+"[/image]");
	}
	//图片4
	if(request.getAttribute("rztbdz4") == null){
		
	}else{
		DataRegion data4 = worddoc.openDataRegion("PO_p4");
		data4.setValue("[image]"+request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("rztbdz4")+"[/image]");
	}
	//图片5
	if(request.getAttribute("rztbdz5") == null){
		
	}else{
		DataRegion data5 = worddoc.openDataRegion("PO_p5");
		data5.setValue("[image]"+request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("rztbdz5")+"[/image]");
	}
	//图片6
	if(request.getAttribute("rztbdz6") == null){
		
	}else{
		DataRegion data6 = worddoc.openDataRegion("PO_p6");
		data6.setValue("[image]"+request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("rztbdz6")+"[/image]");
	}
	//单位名称图片
	if(request.getAttribute("dwmctp") == null){
		
	}else{
		DataRegion data7 = worddoc.openDataRegion("PO_dwmctp");
		data7.setValue("[image]"+request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("dwmctp")+"[/image]");
	}
	//样品名称
	if(request.getAttribute("ypmc") == null){
		
	}else{
		DataRegion data7 = worddoc.openDataRegion("PO_ypmc");
		data7.setValue(""+request.getAttribute("ypmc"));
	}
	//受检单位
	if(request.getAttribute("sjdw") == null){
		DataRegion data8 = worddoc.openDataRegion("PO_sjdw");
		data8.setValue("/");
	}else{
		DataRegion data8 = worddoc.openDataRegion("PO_sjdw");
		data8.setValue(""+request.getAttribute("sjdw"));
	}
	//检验类别
	if(request.getAttribute("jylx") == null){
		
	}else{
		DataRegion data9 = worddoc.openDataRegion("PO_jylx");
		/* data9.setValue(""+request.getAttribute("jylx")); */
		String jylx = request.getAttribute("jylx").toString();
		String jylxRep ="";
		if(jylx.contains("委托检验（")){
			jylxRep = jylx.replace(jylx,"委托检验");
			data9.setValue(jylxRep);
		}else{
			data9.setValue(jylx);
		}
	}
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
	
// 	//字
// 			if(request.getAttribute("gai") == "0"){
				
// 			}else if(request.getAttribute("gai") == "1"){
// 				DataRegion dataRegion22 = worddoc.openDataRegion("PO_gai");
// 				dataRegion22.setValue("[image]"+request.getSession().getServletContext().getRealPath("resources/home")+"/"+"gai.png"+"[/image]");
// 			}

//建工中心（院）
	//工程名称
		if(request.getAttribute("gcmc") == null){
			
		}else{
			DataRegion data8 = worddoc.openDataRegion("PO_gcmc");
			data8.setValue(""+request.getAttribute("gcmc"));
		}
	//建设单位
		if(request.getAttribute("jsdw") == null){
			DataRegion data8 = worddoc.openDataRegion("PO_jsdw");
			data8.setValue("/");
		}else{
			DataRegion data8 = worddoc.openDataRegion("PO_jsdw");
			data8.setValue(""+request.getAttribute("jsdw"));
		}
	//建设单位
		if(request.getAttribute("sgdw") == null){
			DataRegion data8 = worddoc.openDataRegion("PO_sgdw");
			data8.setValue("/");
		}else{
			DataRegion data8 = worddoc.openDataRegion("PO_sgdw");
			data8.setValue(""+request.getAttribute("sgdw"));
		}
	
		//生产单位
		if(request.getAttribute("scdw") == null){
			DataRegion data8 = worddoc.openDataRegion("PO_scdw");
			data8.setValue("/");
		}else{
			DataRegion data8 = worddoc.openDataRegion("PO_scdw");
			data8.setValue(""+request.getAttribute("scdw"));
		}
		
		//委托单位
		if(request.getAttribute("wtdw") == null){
			DataRegion data8 = worddoc.openDataRegion("PO_wtdw");
			data8.setValue("/");
		}else{
			DataRegion data8 = worddoc.openDataRegion("PO_wtdw");
			data8.setValue(""+request.getAttribute("wtdw"));
		}

	fmCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
	fmCtrl.setSaveFilePage("savePageTest?filename="+bgbh+"fm");
// 	if(request.getAttribute("gai") == "0"){
// 	}else if(request.getAttribute("gai") == "1"){
// 		fmCtrl.setSaveFilePage("savePageTest?filename="+bgbh+"fmG");
// 	}
	fmCtrl.setWriter(worddoc);
	fmCtrl.fillDocument(request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("sub"), DocumentOpenType.Word);
	fmCtrl.setTagId("FileMakerCtrl1"); //此行必须
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>封面预览</title>
	</head>
	<body>
		<form id="form1">
			<div style="width: auto; height: 700px;">
				<!--**************   PageOffice 客户端代码开始    ************************-->
				<po:FileMakerCtrl id="FileMakerCtrl1">
				</po:FileMakerCtrl>
				<!--**************   PageOffice 客户端代码结束    ************************-->
			</div>
		</form>
	</body>
</html>
<%@ page language="java" import="java.util.*"
	import="java.util.* ,java.awt.* ,com.zhuozhengsoft.pageoffice.FileMakerCtrl,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*,java.text.SimpleDateFormat,java.util.Date" pageEncoding="gb2312"%>
	<%@page import="java.io.FileOutputStream"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%
	String bgbh = request.getParameter("bgbh");
	//******************************׿��PageOffice�����ʹ��*******************************
	FileMakerCtrl fmCtrl = new FileMakerCtrl(request);
	fmCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
	//�����Զ��尴ť
// 	poCtrl1.addCustomToolButton("����","Save",1);
// 	poCtrl1.addCustomToolButton("����","Fanhui",21);
// 	//���ñ���ҳ��
// 	poCtrl1.setSaveFilePage("savePage");

	WordDocument worddoc = new WordDocument();
	//����Ҫ����word�ļ���λ���ֶ�������ǩ,��ǩ�����ԡ�PO_��Ϊǰ׺
	//��DataRegion��ֵ,ֵ����ʽΪ��"[word]word�ļ�·��[/word]��[excel]excel�ļ�·��[/excel]��[image]ͼƬ·��[/image]"
	//��Ʒ����
	if(request.getAttribute("ypmc") == null){
		
	}else{
		DataRegion data7 = worddoc.openDataRegion("PO_ypmc");
		data7.setValue(""+request.getAttribute("ypmc"));
	}
	//�ܼ쵥λ
	if(request.getAttribute("sjdw") == null){
		DataRegion data8 = worddoc.openDataRegion("PO_sjdw");
		data8.setValue("/");
	}else{
		DataRegion data8 = worddoc.openDataRegion("PO_sjdw");
		data8.setValue(""+request.getAttribute("sjdw"));
	}
	//�������
	if(request.getAttribute("jylx") == null){
		
	}else{
		DataRegion data9 = worddoc.openDataRegion("PO_jylx");
		/* data9.setValue(""+request.getAttribute("jylx")); */
		String jylx = request.getAttribute("jylx").toString();
		String jylxRep ="";
		if(jylx.contains("ί�м��飨")){
			jylxRep = jylx.replace(jylx,"ί�м���");
			data9.setValue(jylxRep);
		}else{
			data9.setValue(jylx);
		}
	}
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
	
/* 	//��
			if(request.getAttribute("gai") == "0"){
				
			}else if(request.getAttribute("gai") == "1"){
				DataRegion dataRegion22 = worddoc.openDataRegion("PO_gai");
				dataRegion22.setValue("[image]"+request.getSession().getServletContext().getRealPath("resources/home")+"/"+"gai.png"+"[/image]");
			} */
			
// 			//�����ά��
// 			DataRegion dataRegion22 = worddoc.openDataRegion("PO_gai");
// 			dataRegion22.setValue("[image]"+request.getSession().getServletContext().getRealPath("resources/ewmtp")+"/"+bgbh+".png"+"[/image]");

//�������ģ�Ժ��
	//��������
		if(request.getAttribute("gcmc") == null){
			
		}else{
			DataRegion data8 = worddoc.openDataRegion("PO_gcmc");
			data8.setValue(""+request.getAttribute("gcmc"));
		}
	//���赥λ
		if(request.getAttribute("jsdw") == null){
			DataRegion data8 = worddoc.openDataRegion("PO_jsdw");
			data8.setValue("/");
		}else{
			DataRegion data8 = worddoc.openDataRegion("PO_jsdw");
			data8.setValue(""+request.getAttribute("jsdw"));
		}
	//���赥λ
		if(request.getAttribute("sgdw") == null){
			DataRegion data8 = worddoc.openDataRegion("PO_sgdw");
			data8.setValue("/");
		}else{
			DataRegion data8 = worddoc.openDataRegion("PO_sgdw");
			data8.setValue(""+request.getAttribute("sgdw"));
		}
	
		//������λ
		if(request.getAttribute("scdw") == null){
			DataRegion data8 = worddoc.openDataRegion("PO_scdw");
			data8.setValue("/");
		}else{
			DataRegion data8 = worddoc.openDataRegion("PO_scdw");
			data8.setValue(""+request.getAttribute("scdw"));
		}
		
		//ί�е�λ
		if(request.getAttribute("wtdw") == null){
			DataRegion data8 = worddoc.openDataRegion("PO_wtdw");
			data8.setValue("/");
		}else{
			DataRegion data8 = worddoc.openDataRegion("PO_wtdw");
			data8.setValue(""+request.getAttribute("wtdw"));
		}

	fmCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
		fmCtrl.setSaveFilePage("savePageTest?filename="+bgbh+"fmdc");
	/* if(request.getAttribute("gai") == "0"){
	}else if(request.getAttribute("gai") == "1"){
		fmCtrl.setSaveFilePage("savePageTest?filename="+bgbh+"fmGdc");
	} */
	fmCtrl.setWriter(worddoc);
// 	fmCtrl.setJsFunction_OnProgressComplete("OnProgressComplete()");
	fmCtrl.fillDocument(request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("sub"), DocumentOpenType.Word);
	fmCtrl.setTagId("FileMakerCtrl1"); //���б���
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>����Ԥ��</title>
	</head>
	<body>
		<form id="form1">
			<div style="width: auto; height: 700px;">
				<!--**************   PageOffice �ͻ��˴��뿪ʼ    ************************-->
				<po:FileMakerCtrl id="FileMakerCtrl1">
				</po:FileMakerCtrl>
				<!--**************   PageOffice �ͻ��˴������    ************************-->
			</div>
		</form>
	</body>
</html>
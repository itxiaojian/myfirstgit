<%@page import="java.io.File"%>
<%@ page language="java" import="java.util.*"
	import="java.util.* ,java.awt.* ,com.zhuozhengsoft.pageoffice.FileMakerCtrl,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*,java.text.SimpleDateFormat,java.util.Date" pageEncoding="gb2312"%>
	<%@page import="java.io.FileOutputStream"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%
String bgbh = request.getParameter("bgbh");
//���÷�����ҳ��
//����Զ��尴ť

	WordDocument doc = new WordDocument();

//��Ʒ����
	if(request.getAttribute("ypmc") == null){
		DataRegion dataRegion1 = doc.openDataRegion("PO_ypmc");
		dataRegion1.setValue("/");
	}else{
		DataRegion dataRegion1 = doc.openDataRegion("PO_ypmc");
		dataRegion1.setValue(""+request.getAttribute("ypmc"));
}

//�ܼ쵥λ
	if(request.getAttribute("sjdw") == null){
		DataRegion dataRegion2 = doc.openDataRegion("PO_sjdw");
		dataRegion2.setValue("/");
	}else{
		DataRegion dataRegion2 = doc.openDataRegion("PO_sjdw");
		dataRegion2.setValue(""+request.getAttribute("sjdw"));
	}

//�ܼ쵥λ�绰
	if(request.getAttribute("dh") == null){
		DataRegion dataRegion2 = doc.openDataRegion("PO_dh");
		dataRegion2.setValue("/");
	}else{
		DataRegion dataRegion2 = doc.openDataRegion("PO_dh");
		dataRegion2.setValue(""+request.getAttribute("dh"));
	}
	
//������λ
	if(request.getAttribute("scdw") == null){
		DataRegion dataRegion3 = doc.openDataRegion("PO_scdw");
		dataRegion3.setValue("/");
	}else{
		DataRegion dataRegion3 = doc.openDataRegion("PO_scdw");
		dataRegion3.setValue(""+request.getAttribute("scdw"));
	}

//������λ�绰
	if(request.getAttribute("scdwdh") == null){
		DataRegion dataRegion3 = doc.openDataRegion("PO_scdwdh");
		dataRegion3.setValue("/");
	}else{
		DataRegion dataRegion3 = doc.openDataRegion("PO_scdwdh");
		dataRegion3.setValue(""+request.getAttribute("scdwdh"));
	}
	
//�����ص�
	if(request.getAttribute("cydd") == null){
		DataRegion dataRegion4 = doc.openDataRegion("PO_cydd");
		dataRegion4.setValue("/");
	}else{
		DataRegion dataRegion4 = doc.openDataRegion("PO_cydd");
		dataRegion4.setValue(""+request.getAttribute("cydd"));
	}
	
//��Ʒ����
	if(request.getAttribute("ypsl") == null){
		DataRegion dataRegion5 = doc.openDataRegion("PO_ypsl");
		dataRegion5.setValue("/");
	}else{
		DataRegion dataRegion5 = doc.openDataRegion("PO_ypsl");
		dataRegion5.setValue(""+request.getAttribute("ypsl"));
	}
	
//��������
	if(request.getAttribute("cyjs") == null){
		DataRegion dataRegion6 = doc.openDataRegion("PO_cyjs");
		dataRegion6.setValue("/");
	}else{
		DataRegion dataRegion6 = doc.openDataRegion("PO_cyjs");
		dataRegion6.setValue(""+request.getAttribute("cyjs"));
	}
	
//��Ʒ״̬
	if(request.getAttribute("ypzt") == null){
		DataRegion dataRegion7 = doc.openDataRegion("PO_ypzt");
		dataRegion7.setValue("/");
	}else{
		DataRegion dataRegion7 = doc.openDataRegion("PO_ypzt");
		dataRegion7.setValue(""+request.getAttribute("ypzt"));
	}
	
//ί�е�λ
	if(request.getAttribute("wtdw") == null){
		DataRegion dataRegion8 = doc.openDataRegion("PO_wtdw");
		dataRegion8.setValue("/");
	}else{
		DataRegion dataRegion8 = doc.openDataRegion("PO_wtdw");
		dataRegion8.setValue(""+request.getAttribute("wtdw"));
	}
	
//������Ա
	if(request.getAttribute("cyry") == null){
		DataRegion dataRegion9 = doc.openDataRegion("PO_cyry");
		dataRegion9.setValue("/");
	}else{
		DataRegion dataRegion9 = doc.openDataRegion("PO_cyry");
		dataRegion9.setValue(""+request.getAttribute("cyry"));
	}
	
//����ͺ�
	if(request.getAttribute("ggxh") == null){
		DataRegion dataRegion10 = doc.openDataRegion("PO_xxgg");
		dataRegion10.setValue("/");
	}else{
		DataRegion dataRegion10 = doc.openDataRegion("PO_xxgg");
		dataRegion10.setValue(""+request.getAttribute("ggxh"));
	}
	
//�������
	if(request.getAttribute("jylx") == null){
		DataRegion dataRegion11 = doc.openDataRegion("PO_jylx");
		dataRegion11.setValue("/");
	}else{
		DataRegion dataRegion11 = doc.openDataRegion("PO_jylx");
		dataRegion11.setValue(""+request.getAttribute("jylx"));
	}
	
//��Ʒ�ȼ�
	if(request.getAttribute("ypdj") == null){
		DataRegion dataRegion12 = doc.openDataRegion("PO_ypdj");
		dataRegion12.setValue("/");
	}else{
		DataRegion dataRegion12 = doc.openDataRegion("PO_ypdj");
		dataRegion12.setValue(""+request.getAttribute("ypdj"));
	}
	
//�Ǽ�����
	if(request.getAttribute("dyrq") == null){
		DataRegion dataRegion13 = doc.openDataRegion("PO_dyrq");
		dataRegion13.setValue("/");
	}else{
		DataRegion dataRegion13 = doc.openDataRegion("PO_dyrq");
		dataRegion13.setValue(""+request.getAttribute("dyrq"));
	}
	
//��������
	if(request.getAttribute("cyrq") == null){
		DataRegion dataRegion14 = doc.openDataRegion("PO_cyrq");
		dataRegion14.setValue("/");
	}else{
		DataRegion dataRegion14 = doc.openDataRegion("PO_cyrq");
		dataRegion14.setValue(""+request.getAttribute("cyrq"));
	}
	
//������Ŀ
	if(request.getAttribute("jyxm") == null){
		DataRegion dataRegion15 = doc.openDataRegion("PO_jyxm");
		dataRegion15.setValue("/");
	}else{
		DataRegion dataRegion15 = doc.openDataRegion("PO_jyxm");
		dataRegion15.setValue(""+request.getAttribute("jyxm"));
	}
	
//������������
	if(request.getAttribute("scrqpc") == null){
		DataRegion dataRegion16 = doc.openDataRegion("PO_scrqpc");
		dataRegion16.setValue("/");
	}else{
		DataRegion dataRegion16 = doc.openDataRegion("PO_scrqpc");
		dataRegion16.setValue(""+request.getAttribute("scrqpc"));
	}
	
//��������Ա
	if(request.getAttribute("jcfyry") == null){
		DataRegion dataRegion17 = doc.openDataRegion("PO_jcfyry");
		dataRegion17.setValue("/");
	}else{
		DataRegion dataRegion17 = doc.openDataRegion("PO_jcfyry");
		dataRegion17.setValue(""+request.getAttribute("jcfyry"));
	}
	
//��������
	if(request.getAttribute("jyyj") == null){
		DataRegion dataRegion18 = doc.openDataRegion("PO_jyyj");
		dataRegion18.setValue("/");
	}else{
		DataRegion dataRegion18 = doc.openDataRegion("PO_jyyj");
		dataRegion18.setValue(""+request.getAttribute("jyyj"));
	}
	
//���
	if(request.getAttribute("nf") == null){
			
	}else{
		DataRegion dataRegion19 = doc.openDataRegion("PO_nf");
		dataRegion19.setValue(""+request.getAttribute("nf"));
	}
	
//��
	if(request.getAttribute("h") == null){
		
	}else{
		DataRegion dataRegion20 = doc.openDataRegion("PO_h");
		dataRegion20.setValue(""+request.getAttribute("h"));
	}
	
//��
	if(request.getAttribute("z") == null){
		
	}else{
		DataRegion dataRegion21 = doc.openDataRegion("PO_z");
		dataRegion21.setValue(""+request.getAttribute("z"));
	}
	
//�̱�
	if(request.getAttribute("sb") == null){
		DataRegion dataRegion22 = doc.openDataRegion("PO_sb");
		dataRegion22.setValue("/");
	}else{
		DataRegion dataRegion22 = doc.openDataRegion("PO_sb");
		dataRegion22.setValue(""+request.getAttribute("sb"));
	}

//ί�е�λ��ַ
	if(request.getAttribute("wtdwdz") == null){
		DataRegion dataRegion23 = doc.openDataRegion("PO_wtdwdz");
		dataRegion23.setValue("/");
	}else{
		DataRegion dataRegion23 = doc.openDataRegion("PO_wtdwdz");
		dataRegion23.setValue(""+request.getAttribute("wtdwdz"));
	}

//������λ
	if(request.getAttribute("cydw") == null){
		DataRegion dataRegion24 = doc.openDataRegion("PO_cydw");
		dataRegion24.setValue("/");
	}else{
		DataRegion dataRegion24 = doc.openDataRegion("PO_cydw");
		dataRegion24.setValue(""+request.getAttribute("cydw"));
	}

//��������
	if(request.getAttribute("jyrq") == null){
		DataRegion dataRegion25 = doc.openDataRegion("PO_jyrq");
		dataRegion25.setValue("/");
	}else{
		DataRegion dataRegion25 = doc.openDataRegion("PO_jyrq");
		dataRegion25.setValue(""+request.getAttribute("jyrq"));
	}

// //�����������
// 	if(request.getAttribute("jyjsrq") == null){
// 		DataRegion dataRegion25 = doc.openDataRegion("PO_jyjsrq");
// 		dataRegion25.setValue("/");
// 	}else{
// 		DataRegion dataRegion25 = doc.openDataRegion("PO_jyjsrq");
// 		dataRegion25.setValue(""+request.getAttribute("jyjsrq"));
// 	}

//�������
	if(request.getAttribute("jyjl") == null){
		DataRegion dataRegion26 = doc.openDataRegion("PO_jyjl");
		dataRegion26.setValue("/");
	}else{
		DataRegion dataRegion26 = doc.openDataRegion("PO_jyjl");
		dataRegion26.setValue(""+request.getAttribute("jyjl"));
	}

//��ע
	if(request.getAttribute("bz") == null){
		DataRegion dataRegion27 = doc.openDataRegion("PO_bz");
		dataRegion27.setValue("�����հס�");
	}else{
		DataRegion dataRegion27 = doc.openDataRegion("PO_bz");
		dataRegion27.setValue(""+request.getAttribute("bz"));
	}

//ʩ����λ
	if(request.getAttribute("sgdw") == null){
		DataRegion dataRegion28 = doc.openDataRegion("PO_sgdw");
		dataRegion28.setValue("/");
	}else{
		DataRegion dataRegion28 = doc.openDataRegion("PO_sgdw");
		dataRegion28.setValue(""+request.getAttribute("sgdw"));
	}

//����λ
	if(request.getAttribute("jldw") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_jldw");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_jldw");
		dataRegion29.setValue(""+request.getAttribute("jldw"));
	}

//������
	if(request.getAttribute("jlr") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_jlr");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_jlr");
		dataRegion29.setValue(""+request.getAttribute("jlr"));
	}

//��֤��λ
	if(request.getAttribute("jzdw") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_jzdw");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_jzdw");
		dataRegion29.setValue(""+request.getAttribute("jzdw"));
	}

//��֤��
	if(request.getAttribute("jzr") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_jzr");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_jzr");
		dataRegion29.setValue(""+request.getAttribute("jzr"));
	}

//��������
	if(request.getAttribute("gcmc") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_gcmc");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_gcmc");
		dataRegion29.setValue(""+request.getAttribute("gcmc"));
	}

//���̵�ַ
	if(request.getAttribute("gcdz") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_gcdz");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_gcdz");
		dataRegion29.setValue(""+request.getAttribute("gcdz"));
	}

//������Ƶ�λ
	if(request.getAttribute("gcsjdw") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_gcsjdw");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_gcsjdw");
		dataRegion29.setValue(""+request.getAttribute("gcsjdw"));
	}

//���赥λ
	if(request.getAttribute("jsdw") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_jsdw");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_jsdw");
		dataRegion29.setValue(""+request.getAttribute("jsdw"));
	}

//�������˵��
	if(request.getAttribute("jyqksm") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_jyqksm");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_jyqksm");
		dataRegion29.setValue(""+request.getAttribute("jyqksm"));
	}

//������ʽ
	if(request.getAttribute("zdmc") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_lyfs");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_lyfs");
		dataRegion29.setValue(""+request.getAttribute("zdmc"));
	}

//���������
	if(request.getAttribute("cydbh") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_cydbh");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_cydbh");
		dataRegion29.setValue(""+request.getAttribute("cydbh"));
	}

//������Դ
	if(request.getAttribute("rwly") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_rwly");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_rwly");
		dataRegion29.setValue(""+request.getAttribute("rwly"));
	}

//ҳ��
	if(request.getAttribute("pages") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_pages");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_pages");
		dataRegion29.setValue(""+request.getAttribute("pages"));
	}
	
//������
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
	
//�����
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
	
//��׼��
	if(request.getAttribute("pzr") == null){
		
	}else{
		File file=new File(request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("pzr"));    
		if(!file.exists())    
		{    
			DataRegion dataRegion30 = doc.openDataRegion("PO_pzr");
			dataRegion30.setValue("");
		}else{
			DataRegion dataRegion29 = doc.openDataRegion("PO_pzr");
			dataRegion29.setValue("[image]"+request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("pzr")+"[/image]");
		}
	}
	
//���
	if(request.getAttribute("year") == null){
		
	}else{
		DataRegion data2 = doc.openDataRegion("PO_nian");
		data2.setValue(""+request.getAttribute("year"));
	}
//�·�
	if(request.getAttribute("mon") == null){
		
	}else{
		DataRegion data2 = doc.openDataRegion("PO_yue");
		data2.setValue(""+request.getAttribute("mon"));
	}
//��
	if(request.getAttribute("date") == null){
		
	}else{
		DataRegion data2 = doc.openDataRegion("PO_ri");
		data2.setValue(""+request.getAttribute("date"));
	}
	
	
	FileMakerCtrl fmCtrl = new FileMakerCtrl(request);
	fmCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
	fmCtrl.setWriter(doc);
// 	fmCtrl.setJsFunction_OnProgressComplete("OnProgressComplete()");
	fmCtrl.fillDocument(request.getSession().getServletContext().getRealPath("resources/home")+"/"+request.getAttribute("sub"), DocumentOpenType.Word);
		fmCtrl.setSaveFilePage(path+"/jygl/YjyBgxx/savePageTest?filename="+bgbh+"sydc");
/* 	if(request.getAttribute("gai") == "0"){
	}else if(request.getAttribute("gai") == "1"){
		fmCtrl.setSaveFilePage(path+"/jygl/YjyBgxx/savePageTest?filename="+bgbh+"syGdc");
	} */
	fmCtrl.setTagId("FileMakerCtrl1"); //���б���

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>��ҳԤ��</title>
   	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
	<base href="http://www.microsoft.com/typography/web/embedding/demos/3/" />
</head>
 <style type="text/css">
	 @font-face {
		 font-family: BorderWeb;
		 src:url(BORDERW0.eot);
	}
	body{
		FONT-FAMILY: "BorderWeb"
	}
 </style>
<body>
	<script type="text/javascript">
        function Fanhui(){
        	window.history.go(-1);
        }
    </script>
    <form id="form1" >
    <div style=" width:auto; height:700px;">
        <po:FileMakerCtrl id="FileMakerCtrl1" >
        </po:FileMakerCtrl>
    </div>
    </form>
</body>
</html>

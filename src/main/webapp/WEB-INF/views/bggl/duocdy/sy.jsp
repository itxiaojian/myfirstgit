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

//样品名称
	if(request.getAttribute("ypmc") == null){
		DataRegion dataRegion1 = doc.openDataRegion("PO_ypmc");
		dataRegion1.setValue("/");
	}else{
		DataRegion dataRegion1 = doc.openDataRegion("PO_ypmc");
		dataRegion1.setValue(""+request.getAttribute("ypmc"));
}

//受检单位
	if(request.getAttribute("sjdw") == null){
		DataRegion dataRegion2 = doc.openDataRegion("PO_sjdw");
		dataRegion2.setValue("/");
	}else{
		DataRegion dataRegion2 = doc.openDataRegion("PO_sjdw");
		dataRegion2.setValue(""+request.getAttribute("sjdw"));
	}

//受检单位电话
	if(request.getAttribute("dh") == null){
		DataRegion dataRegion2 = doc.openDataRegion("PO_dh");
		dataRegion2.setValue("/");
	}else{
		DataRegion dataRegion2 = doc.openDataRegion("PO_dh");
		dataRegion2.setValue(""+request.getAttribute("dh"));
	}
	
//生产单位
	if(request.getAttribute("scdw") == null){
		DataRegion dataRegion3 = doc.openDataRegion("PO_scdw");
		dataRegion3.setValue("/");
	}else{
		DataRegion dataRegion3 = doc.openDataRegion("PO_scdw");
		dataRegion3.setValue(""+request.getAttribute("scdw"));
	}

//生产单位电话
	if(request.getAttribute("scdwdh") == null){
		DataRegion dataRegion3 = doc.openDataRegion("PO_scdwdh");
		dataRegion3.setValue("/");
	}else{
		DataRegion dataRegion3 = doc.openDataRegion("PO_scdwdh");
		dataRegion3.setValue(""+request.getAttribute("scdwdh"));
	}
	
//抽样地点
	if(request.getAttribute("cydd") == null){
		DataRegion dataRegion4 = doc.openDataRegion("PO_cydd");
		dataRegion4.setValue("/");
	}else{
		DataRegion dataRegion4 = doc.openDataRegion("PO_cydd");
		dataRegion4.setValue(""+request.getAttribute("cydd"));
	}
	
//样品数量
	if(request.getAttribute("ypsl") == null){
		DataRegion dataRegion5 = doc.openDataRegion("PO_ypsl");
		dataRegion5.setValue("/");
	}else{
		DataRegion dataRegion5 = doc.openDataRegion("PO_ypsl");
		dataRegion5.setValue(""+request.getAttribute("ypsl"));
	}
	
//抽样基数
	if(request.getAttribute("cyjs") == null){
		DataRegion dataRegion6 = doc.openDataRegion("PO_cyjs");
		dataRegion6.setValue("/");
	}else{
		DataRegion dataRegion6 = doc.openDataRegion("PO_cyjs");
		dataRegion6.setValue(""+request.getAttribute("cyjs"));
	}
	
//样品状态
	if(request.getAttribute("ypzt") == null){
		DataRegion dataRegion7 = doc.openDataRegion("PO_ypzt");
		dataRegion7.setValue("/");
	}else{
		DataRegion dataRegion7 = doc.openDataRegion("PO_ypzt");
		dataRegion7.setValue(""+request.getAttribute("ypzt"));
	}
	
//委托单位
	if(request.getAttribute("wtdw") == null){
		DataRegion dataRegion8 = doc.openDataRegion("PO_wtdw");
		dataRegion8.setValue("/");
	}else{
		DataRegion dataRegion8 = doc.openDataRegion("PO_wtdw");
		dataRegion8.setValue(""+request.getAttribute("wtdw"));
	}
	
//抽样人员
	if(request.getAttribute("cyry") == null){
		DataRegion dataRegion9 = doc.openDataRegion("PO_cyry");
		dataRegion9.setValue("/");
	}else{
		DataRegion dataRegion9 = doc.openDataRegion("PO_cyry");
		dataRegion9.setValue(""+request.getAttribute("cyry"));
	}
	
//规格型号
	if(request.getAttribute("ggxh") == null){
		DataRegion dataRegion10 = doc.openDataRegion("PO_xxgg");
		dataRegion10.setValue("/");
	}else{
		DataRegion dataRegion10 = doc.openDataRegion("PO_xxgg");
		dataRegion10.setValue(""+request.getAttribute("ggxh"));
	}
	
//检验类别
	if(request.getAttribute("jylx") == null){
		DataRegion dataRegion11 = doc.openDataRegion("PO_jylx");
		dataRegion11.setValue("/");
	}else{
		DataRegion dataRegion11 = doc.openDataRegion("PO_jylx");
		dataRegion11.setValue(""+request.getAttribute("jylx"));
	}
	
//样品等级
	if(request.getAttribute("ypdj") == null){
		DataRegion dataRegion12 = doc.openDataRegion("PO_ypdj");
		dataRegion12.setValue("/");
	}else{
		DataRegion dataRegion12 = doc.openDataRegion("PO_ypdj");
		dataRegion12.setValue(""+request.getAttribute("ypdj"));
	}
	
//登记日期
	if(request.getAttribute("dyrq") == null){
		DataRegion dataRegion13 = doc.openDataRegion("PO_dyrq");
		dataRegion13.setValue("/");
	}else{
		DataRegion dataRegion13 = doc.openDataRegion("PO_dyrq");
		dataRegion13.setValue(""+request.getAttribute("dyrq"));
	}
	
//抽样日期
	if(request.getAttribute("cyrq") == null){
		DataRegion dataRegion14 = doc.openDataRegion("PO_cyrq");
		dataRegion14.setValue("/");
	}else{
		DataRegion dataRegion14 = doc.openDataRegion("PO_cyrq");
		dataRegion14.setValue(""+request.getAttribute("cyrq"));
	}
	
//检验项目
	if(request.getAttribute("jyxm") == null){
		DataRegion dataRegion15 = doc.openDataRegion("PO_jyxm");
		dataRegion15.setValue("/");
	}else{
		DataRegion dataRegion15 = doc.openDataRegion("PO_jyxm");
		dataRegion15.setValue(""+request.getAttribute("jyxm"));
	}
	
//生产日期批次
	if(request.getAttribute("scrqpc") == null){
		DataRegion dataRegion16 = doc.openDataRegion("PO_scrqpc");
		dataRegion16.setValue("/");
	}else{
		DataRegion dataRegion16 = doc.openDataRegion("PO_scrqpc");
		dataRegion16.setValue(""+request.getAttribute("scrqpc"));
	}
	
//检查封样人员
	if(request.getAttribute("jcfyry") == null){
		DataRegion dataRegion17 = doc.openDataRegion("PO_jcfyry");
		dataRegion17.setValue("/");
	}else{
		DataRegion dataRegion17 = doc.openDataRegion("PO_jcfyry");
		dataRegion17.setValue(""+request.getAttribute("jcfyry"));
	}
	
//检验依据
	if(request.getAttribute("jyyj") == null){
		DataRegion dataRegion18 = doc.openDataRegion("PO_jyyj");
		dataRegion18.setValue("/");
	}else{
		DataRegion dataRegion18 = doc.openDataRegion("PO_jyyj");
		dataRegion18.setValue(""+request.getAttribute("jyyj"));
	}
	
//年份
	if(request.getAttribute("nf") == null){
			
	}else{
		DataRegion dataRegion19 = doc.openDataRegion("PO_nf");
		dataRegion19.setValue(""+request.getAttribute("nf"));
	}
	
//号
	if(request.getAttribute("h") == null){
		
	}else{
		DataRegion dataRegion20 = doc.openDataRegion("PO_h");
		dataRegion20.setValue(""+request.getAttribute("h"));
	}
	
//字
	if(request.getAttribute("z") == null){
		
	}else{
		DataRegion dataRegion21 = doc.openDataRegion("PO_z");
		dataRegion21.setValue(""+request.getAttribute("z"));
	}
	
//商标
	if(request.getAttribute("sb") == null){
		DataRegion dataRegion22 = doc.openDataRegion("PO_sb");
		dataRegion22.setValue("/");
	}else{
		DataRegion dataRegion22 = doc.openDataRegion("PO_sb");
		dataRegion22.setValue(""+request.getAttribute("sb"));
	}

//委托单位地址
	if(request.getAttribute("wtdwdz") == null){
		DataRegion dataRegion23 = doc.openDataRegion("PO_wtdwdz");
		dataRegion23.setValue("/");
	}else{
		DataRegion dataRegion23 = doc.openDataRegion("PO_wtdwdz");
		dataRegion23.setValue(""+request.getAttribute("wtdwdz"));
	}

//抽样单位
	if(request.getAttribute("cydw") == null){
		DataRegion dataRegion24 = doc.openDataRegion("PO_cydw");
		dataRegion24.setValue("/");
	}else{
		DataRegion dataRegion24 = doc.openDataRegion("PO_cydw");
		dataRegion24.setValue(""+request.getAttribute("cydw"));
	}

//检验日期
	if(request.getAttribute("jyrq") == null){
		DataRegion dataRegion25 = doc.openDataRegion("PO_jyrq");
		dataRegion25.setValue("/");
	}else{
		DataRegion dataRegion25 = doc.openDataRegion("PO_jyrq");
		dataRegion25.setValue(""+request.getAttribute("jyrq"));
	}

// //检验结束日期
// 	if(request.getAttribute("jyjsrq") == null){
// 		DataRegion dataRegion25 = doc.openDataRegion("PO_jyjsrq");
// 		dataRegion25.setValue("/");
// 	}else{
// 		DataRegion dataRegion25 = doc.openDataRegion("PO_jyjsrq");
// 		dataRegion25.setValue(""+request.getAttribute("jyjsrq"));
// 	}

//检验结论
	if(request.getAttribute("jyjl") == null){
		DataRegion dataRegion26 = doc.openDataRegion("PO_jyjl");
		dataRegion26.setValue("/");
	}else{
		DataRegion dataRegion26 = doc.openDataRegion("PO_jyjl");
		dataRegion26.setValue(""+request.getAttribute("jyjl"));
	}

//备注
	if(request.getAttribute("bz") == null){
		DataRegion dataRegion27 = doc.openDataRegion("PO_bz");
		dataRegion27.setValue("此栏空白。");
	}else{
		DataRegion dataRegion27 = doc.openDataRegion("PO_bz");
		dataRegion27.setValue(""+request.getAttribute("bz"));
	}

//施工单位
	if(request.getAttribute("sgdw") == null){
		DataRegion dataRegion28 = doc.openDataRegion("PO_sgdw");
		dataRegion28.setValue("/");
	}else{
		DataRegion dataRegion28 = doc.openDataRegion("PO_sgdw");
		dataRegion28.setValue(""+request.getAttribute("sgdw"));
	}

//监理单位
	if(request.getAttribute("jldw") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_jldw");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_jldw");
		dataRegion29.setValue(""+request.getAttribute("jldw"));
	}

//监理人
	if(request.getAttribute("jlr") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_jlr");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_jlr");
		dataRegion29.setValue(""+request.getAttribute("jlr"));
	}

//见证单位
	if(request.getAttribute("jzdw") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_jzdw");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_jzdw");
		dataRegion29.setValue(""+request.getAttribute("jzdw"));
	}

//见证人
	if(request.getAttribute("jzr") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_jzr");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_jzr");
		dataRegion29.setValue(""+request.getAttribute("jzr"));
	}

//工程名称
	if(request.getAttribute("gcmc") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_gcmc");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_gcmc");
		dataRegion29.setValue(""+request.getAttribute("gcmc"));
	}

//工程地址
	if(request.getAttribute("gcdz") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_gcdz");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_gcdz");
		dataRegion29.setValue(""+request.getAttribute("gcdz"));
	}

//工程设计单位
	if(request.getAttribute("gcsjdw") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_gcsjdw");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_gcsjdw");
		dataRegion29.setValue(""+request.getAttribute("gcsjdw"));
	}

//建设单位
	if(request.getAttribute("jsdw") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_jsdw");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_jsdw");
		dataRegion29.setValue(""+request.getAttribute("jsdw"));
	}

//检验情况说明
	if(request.getAttribute("jyqksm") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_jyqksm");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_jyqksm");
		dataRegion29.setValue(""+request.getAttribute("jyqksm"));
	}

//来样方式
	if(request.getAttribute("zdmc") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_lyfs");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_lyfs");
		dataRegion29.setValue(""+request.getAttribute("zdmc"));
	}

//抽样单编号
	if(request.getAttribute("cydbh") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_cydbh");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_cydbh");
		dataRegion29.setValue(""+request.getAttribute("cydbh"));
	}

//任务来源
	if(request.getAttribute("rwly") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_rwly");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_rwly");
		dataRegion29.setValue(""+request.getAttribute("rwly"));
	}

//页数
	if(request.getAttribute("pages") == null){
		DataRegion dataRegion29 = doc.openDataRegion("PO_pages");
		dataRegion29.setValue("/");
	}else{
		DataRegion dataRegion29 = doc.openDataRegion("PO_pages");
		dataRegion29.setValue(""+request.getAttribute("pages"));
	}
	
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
	
//批准人
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
	
//年份
	if(request.getAttribute("year") == null){
		
	}else{
		DataRegion data2 = doc.openDataRegion("PO_nian");
		data2.setValue(""+request.getAttribute("year"));
	}
//月份
	if(request.getAttribute("mon") == null){
		
	}else{
		DataRegion data2 = doc.openDataRegion("PO_yue");
		data2.setValue(""+request.getAttribute("mon"));
	}
//日
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
	fmCtrl.setTagId("FileMakerCtrl1"); //此行必须

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>首页预览</title>
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

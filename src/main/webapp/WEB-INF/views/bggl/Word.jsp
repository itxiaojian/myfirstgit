<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*;"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%
PageOfficeCtrl poCtrl=new PageOfficeCtrl(request);
//设置服务器页面
poCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
poCtrl.setCaption("报告多次打印");
poCtrl.setTitlebar(true); //隐藏标题栏
poCtrl.setMenubar(false); //隐藏菜单栏
poCtrl.setOfficeToolbars(false);//隐藏Office工具条
// poCtrl.setCustomToolbar(false);//隐藏自定义工具栏
poCtrl.setAllowCopy(false);//禁止拷贝
//添加自定义按钮
// poCtrl.addCustomToolButton("打印预览","PrintView",7);
// poCtrl.addCustomToolButton("打印","Print",6);
if("1".equals( request.getAttribute("bztsbg"))){
	poCtrl.addCustomToolButton("打印预览","PrintView",7);
	poCtrl.addCustomToolButton("打印","Print",6);
}else{
	poCtrl.addCustomToolButton("报告打印","Bgdy",6);
}
//设置保存页面
poCtrl.setSaveFilePage("save");
//poCtrl.setSaveFilePage("savePage");
//打开Word文档
poCtrl.webOpen(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+request.getAttribute("fileName"),OpenModeType.docReadOnly,"刘佚名");
poCtrl.setTagId("PageOfficeCtrl1");//此行必需
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>报告多次打印</title>
   	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
    
     <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
     <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/DialogBySHF.css">
    <script type="text/javascript" src="<%=path%>/resources/css/jygl/DialogBySHF.js"></script>
    <script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <script type="text/javascript">
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
    function PrintView() {
        document.getElementById("PageOfficeCtrl1").PrintPreview();
    }
        function Bgdy() {
        	var bgbh='${bgbh}';
        	$.DialogBySHF.Dialog({ Width: 300, Height: 200, Title: "系统提示", URL: '<%=path%>/jygl/YjyBgxx/duocdy?bgbh='+bgbh });
        	 var d = new Delay(); 
		 		d.wait(9500).run(function(m){ //等待3秒 
					//封面
					 var fm = "<%=path%>/resources/doc/"+bgbh+"fmdc.doc";
					createXMLHttpRequest();
					xmlHttp.open("GET",fm,true);
					xmlHttp.send(null);
					xmlHttp.onreadystatechange = function(){
					    if(xmlHttp.readyState==4){
					        if(xmlHttp.status==200){
					       	//首页
								 var sy = "<%=path%>/resources/doc/"+bgbh+"sydc.doc";
					            createXMLHttpRequest();
					            xmlHttp.open("GET",sy,true);
					            xmlHttp.send(null);
					            xmlHttp.onreadystatechange = function(){
					                if(xmlHttp.readyState==4){
					                    if(xmlHttp.status==200){
					                    	location.href = "<%=path%>/jygl/YjyBgxx/ylbgduo?bgbh=" + bgbh;
					                    }else {
					                        alert("操作失败，请重新操作！");
					                         $.DialogBySHF.Close(); 
					                    }
					                }
					            }
					        }
					        <%-- else {
					       	//封面G
								 var fmG = "<%=path%>/resources/doc/"+bgbh+"fmGdc.doc";
					            createXMLHttpRequest();
					            xmlHttp.open("GET",fmG,true);
					            xmlHttp.send(null);
					            xmlHttp.onreadystatechange = function(){
					                if(xmlHttp.readyState==4){
					                    if(xmlHttp.status==200){
					                			//首页G
					               			 var syG = "<%=path%>/resources/doc/"+bgbh+"syGdc.doc";
					                           createXMLHttpRequest();
					                           xmlHttp.open("GET",syG,true);
					                           xmlHttp.send(null);
					                           xmlHttp.onreadystatechange = function(){
					                               if(xmlHttp.readyState==4){
					                                   if(xmlHttp.status==200){
					                                	   location.href = "<%=path%>/jygl/YjyBgxx/ylbgduo?bgbh=" + bgbh;
					                                   }else {
					                                       alert("操作失败，请重新操作！");
					                                       $.DialogBySHF.Close();
					                                   }
					                               }
					                           }
					                    }else {
					                        alert("操作失败，请重新操作！");
					                        $.DialogBySHF.Close();
					                    }
					                }
					            }
					        } --%>
					    }
					}
		 		});
        }
        
    	var xmlHttp= null;
        //判断浏览器
        function createXMLHttpRequest() {
            if (window.XMLHttpRequest) {
                //Firefox,Netscape,Chrome,Safari等浏览器
                xmlHttp = new XMLHttpRequest();
            } else if (window.ActiveXObject) { //IE浏览器
                try {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); //创建xmlHttp对象
                } catch (e) {
                    try {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); //创建xmlHttp对象
                    } catch (e) { }
                }
            }
        }
    	
    	function Delay(){ 
    		this.funList= []; 
    		this.index = 0; 
    		this.re = null; 
    		this.isloop = false; 
    		}; 
    		Delay.prototype = { 
    		wait:function(m){ 
    		if(this.funList[this.index] && typeof this.funList[this.index].fun != 'function'){ 
    		m += this.funList[this.index].m; 
    		} 
    		this.funList[this.index] = {m:m,fun:null}; 
    		return this; 
    		}, 
    		run:function(fun){ 
    		if(typeof this.funList[this.index].fun != 'function'){ 
    		this.funList[this.index].fun = fun; 
    		this.index++; 
    		}else{ 
    		this.index++; 
    		this.funList[this.index] = {'m':0,'fun':fun}; 
    		} 
    		this.start(); 
    		return this; 
    		}, 
    		start:function(){ 
    		var self = this; 
    		if(this.re) return; 
    		var setOutrun = function(funList,index){ 
    		if(funList[index] == undefined){ 
    		clearTimeout(self.re); 
    		return false; 
    		} 
    		var m = funList[index].m, 
    		fun = funList[index].fun; 
    		typeof fun == 'function' || (fun = function(){}); 
    		self.re = setTimeout(function(){ 
    		if(fun(index) === false)return false; 
    		if(self.isloop){ 
    		index = -1; 
    		self.isloop = false; 
    		} 
    		setOutrun(funList,++index); 
    		},m); 
    		} 
    		setOutrun(this.funList,0); 
    		}, 
    		stop:function(){ 
    		return clearTimeout(this.re); 
    		}, 
    		goStart:function(){ 
    		var self = this, 
    		fun = function(){ 
    		self.isloop = true; 
    		}; 
    		if(this.funList[this.index] && typeof this.funList[this.index].fun != 'function'){ 
    		this.funList[this.index].fun = fun; 
    		this.index++; 
    		}else{ 
    		this.funList[this.index] = {'m':0,'fun':fun}; 
    		} 
    		this.start(); 
    		} 
    		};
    </script>
    <form id="form1" >
    <div style=" width:auto; height:auto;">
        <po:PageOfficeCtrl id="PageOfficeCtrl1">
        </po:PageOfficeCtrl>
    </div>
    </form>
</body>
</html>

<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*;"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<% String path = request.getContextPath();%>
<%
	String bgbh = request.getParameter("bgbh");
	//******************************卓正PageOffice组件的使用*******************************
	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
	poCtrl1.setServerPage(request.getContextPath()+"/poserver.zz"); //此行必须
	poCtrl1.setSaveFilePage("savePage");
	poCtrl1.setCaption("报告编辑");
	WordDocument worddoc = new WordDocument();
	
// 	//封面
// 			DataRegion data1 = worddoc.openDataRegion("PO_p1");
// 			data1.setEditing(false);
// 	//首页
// 			DataRegion data2 = worddoc.openDataRegion("PO_p2");
// 			data2.setEditing(false);
// 			DataRegion data3 = worddoc.openDataRegion("PO_p3");
// 			data3.setEditing(true);
// 			poCtrl1.setWriter(worddoc);
	
	//隐藏菜单栏
	//poCtrl1.setMenubar(false);
	//隐藏自定义工具栏
	//poCtrl1.setCustomToolbar(false);
	poCtrl1.setCustomToolbar(true);
	poCtrl1.setOfficeToolbars(true);
	poCtrl1.setMenubar(false); //隐藏菜单栏
// 	poCtrl1.setAllowCopy(false);//禁止拷贝

	//添加自定义按钮
	poCtrl1.addCustomToolButton("提交审核","agree",22);
	poCtrl1.addCustomToolButton("          ","",22);
	poCtrl1.addCustomToolButton("保存","save",1);
// 	poCtrl1.addCustomToolButton("          ","",22);
// 	poCtrl1.addCustomToolButton("修改首页页码","yema",21);
	poCtrl1.addCustomToolButton("       ", "", 21);
	poCtrl1.addCustomToolButton("返回","Fanhui",21);
	poCtrl1.addCustomToolButton("       ", "", 21);
	poCtrl1.addCustomToolButton("温馨提示：当前报告编号为："+bgbh+"。报告编制时，如需离开，请点击保存按钮！","",21);
	
	
	poCtrl1.webOpen("/zjyw/resources/doc/"+bgbh+".doc", OpenModeType.docNormalEdit, "");
	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>预览报告信息</title>
		<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.min.js"></script>
		 <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
		 <script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
		 <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/DialogBySHF.css">
    <script type="text/javascript" src="<%=path%>/resources/css/jygl/DialogBySHF.js"></script>
	</head>
	<body onload="Zuida()">
		<form id="form1">
			<div style="width: auto; height: auto;">
				<!--**************   PageOffice 客户端代码开始    ************************-->
				<po:PageOfficeCtrl id="PageOfficeCtrl1">
				</po:PageOfficeCtrl>
				<!--**************   PageOffice 客户端代码结束    ************************-->
			</div>
		</form>
		<form name="submitForm" id="optionForm" method="post">
		<input type="hidden" name="projectName" id="projectName" value="${pageContext.request.contextPath}"/>
			<input type="hidden" name="taskId" value="${taskId}"/>
            <input type="hidden" name="tname" id="tname" value="${tname}"/>
            <input type="hidden" name="businessKey" value="${businessKey}"/>
            <input type="hidden" name="userCode" value="${userCode}"/>
            <input type="hidden" name="lineVariable" id="lineVar" value="${lineVar}"/>
            <input type="hidden" name = "value" id="valueInputId" />
            <input type="hidden" name="ypbh" value="${ypbh}" />	
			<input type="hidden" name="ypmc" value="${ypmc}" />	
			 <input type="hidden" name="jyshry" value="${bsdx }">
         </form>
	</body>
	<script type="text/javascript">
	        function Fanhui(){
	        	window.history.go(-1);
	        }
	        function save(){
	        	document.getElementById("PageOfficeCtrl1").WebSave();
	        }
	        function Zuida(){
	        	document.getElementById("PageOfficeCtrl1").FullScreen = true;
	        }
	        function yema(){
	            var value=document.getElementById("PageOfficeCtrl1").RunMacro("myFunc1", 'Function myFunc1() \r\n myFunc1=Application.Selection.Information(4) \r\n End Function');
	            document.getElementById("PageOfficeCtrl1").WebSave();
	            $.DialogBySHF.Dialog({ Width: 300, Height: 200, Title: "系统提示", URL: '<%=path%>/jygl/YjyBgxx/sy?bgbh='+bgbh+'&ym='+value });
					var d = new Delay(); 
					d.wait(10000).run(function(m){ //等待3秒 
location.href = "<%=path%>/jygl/YjyBgxx/ymxg?bgbh="+bgbh+"&userCode="+userCode+"&taskId="+taskId+"&businessKey="+creditId+"&lineVar="+lineVar+"&tname="+tname;
					});
	           }
	        
	        var bgbh = "<%=bgbh%>";
	    	var userCode = "${userCode}";
	    	var taskId = "${taskId}";
	    	var creditId = "${businessKey}";
	    	var url=$("#projectName").val();//获取跟目录
	    	var options = {  
	    			//   target: '#output',          //把服务器返回的内容放入id为output的元素中     
	    			   beforeSubmit: showRequest,  //提交前的回调函数  
	    			   success: showResponse,      //提交后的回调函数  
	    			   url: url+'/cps/deal/dealYPZJAct',   //默认是form的action， 如果申明，则会覆盖 
	    			   //type: type,               //默认是form的method（get or post），如果申明，则会覆盖  
	    			   dataType: 'json',           //html(默认), xml, script, json...接受服务端返回的类型  
	    			   //clearForm: true,          //成功提交后，清除所有表单元素的值  
	    			   //resetForm: true,          //成功提交后，重置所有表单元素的值  
	    			   timeout: 10000              //限制请求的时间，当请求大于10秒后，跳出请求  
	    			};
	    	function showRequest(formData, jqForm, options){  
	    		   //formData: 数组对象，提交表单时，Form插件会以Ajax方式自动提交这些数据，格式如：[{name:user,value:val },{name:pwd,value:pwd}]  
	    		   //jqForm:   jQuery对象，封装了表单的元素     
	    		   //options:  options对象  
	    		  // var queryString = $.param(formData);   //name=1&address=2  
	    		  // var formElement = jqForm[0];              //将jqForm转换为DOM对象  
	    		   //var address = formElement.address.value;  //访问jqForm的DOM元素  
	    		   return true;  //只要不返回false，表单都会提交,在这里可以对表单元素进行验证  
	    	};  
	    	function showResponse(responseText, statusText){  
	    			 if(responseText.success == true) {
	    				   alert('任务处理成功!');
	    	                window.parent.pendPoolGrid.store.load();
	    	                window.parent.ACT_DEAL_WINDOW.close();
	    			 }else {
	    				   alert('任务处理失败!');
	    			 }
	    	};		
	    	//批准
	    	function agree() {
	    		 var returnFlag = checkApproveData();
	             if (returnFlag) {
	             	msg = "确定提交吗？";
	                 if (confirm(msg)) {
	                 	document.getElementById("PageOfficeCtrl1").WebSave();
	                     $("#valueInputId").val(1);
	                     $("#optionForm").ajaxForm(options);
	                     $("#optionForm").submit();
	                 }
	             } else {
	                 window.onbeforeunload = function () {
	                     return '将丢失未保存的数据!';
	                 }
	                 return false;
	             }
	    	}
	    	//不批准
	    	function disagree() {
	    		$("#valueInputId").val(0);
	    		$("#optionForm").ajaxForm(options); 
	    	}
	    	//校验输入的审批意见
	    	function checkApproveData() {
	    		var returnFlag = true;
	    		/* var optinoContent = $("#optinoContentId").val();
	    		if (optinoContent == null ||  optinoContent=="" ) {
	    			returnFlag = false;
	    			alert('请填写意见!');
	    			return returnFlag;
	    		} */
	    		return returnFlag;
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
</html>
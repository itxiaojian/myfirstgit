<%@page import="java.io.File"%>
<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*;"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<% String path = request.getContextPath();%>
<%
	String bgbh = request.getParameter("bgbh");
	//******************************卓正PageOffice组件的使用*******************************
	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
	poCtrl1.setServerPage(request.getContextPath()+"/poserver.zz");
	poCtrl1.setCaption("编制特殊报告");
	poCtrl1.setSaveFilePage(path+"/jygl/YjyBgxx/savePageTest?filename="+bgbh);
	//保存路径
	poCtrl1.setMenubar(true); //菜单栏
	

	//添加自定义按钮
	poCtrl1.addCustomToolButton("提交审核","agree",22);
	poCtrl1.addCustomToolButton("       ","",22);
	poCtrl1.addCustomToolButton("保存", "Save()", 1);
	poCtrl1.addCustomToolButton("          ", "", 21);
	poCtrl1.addCustomToolButton("返回","Fanhui",21);
	poCtrl1.addCustomToolButton("       ", "", 21);
	poCtrl1.addCustomToolButton(bgbh,"",21);
	poCtrl1.addCustomToolButton("         ", "", 21);
	poCtrl1.addCustomToolButton("温馨提示：当前报告编号为："+bgbh+"。报告编制时，如需离开，请点击保存按钮！","",21);
	
	File file=new File(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+".doc");    
	if(!file.exists())    
	{    
		poCtrl1.webOpen("/zjyw/resources/doc/Jybg.doc", OpenModeType.docNormalEdit, "");
	}else{
		poCtrl1.webOpen("/zjyw/resources/doc/"+bgbh+".doc", OpenModeType.docNormalEdit, "");
	}
	
	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>预览特殊报告</title>
		<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.min.js"></script>
	    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
		<script type="text/javascript">
		  //保存
		    function Save() {
		    	document.getElementById("PageOfficeCtrl1").WebSave();
			}
	        function Fanhui(){
	        	window.history.back();
	        }
	        function Zuida(){
	        	document.getElementById("PageOfficeCtrl1").FullScreen = true;
	        }
    	</script>
	</head>
	<body onload="Zuida()">
		<form id="form1">
			<div style="width: auto; height: 700px;">
				<!--**************   PageOffice 客户端代码开始    ************************-->
				<po:PageOfficeCtrl id="PageOfficeCtrl1">
				</po:PageOfficeCtrl>
				<!--**************   PageOffice 客户端代码结束    ************************-->
			</div>
		</form>
		<form name="submitForm" id="optionForm" method="post">
			<input type="text" name="projectName" id="projectName" value="${pageContext.request.contextPath}"/>
			<input type="text" name="value" id="valueInputId"/>
			<input type="text" name="taskId" value="${taskId}"/>
            <input type="text" name="tname" value="${tname}"/>
            <input type="text" name="businessKey" value="${businessKey}"/>
            <input type="text" name="userCode" value="${userCode}"/>
            <input type="text" name="lineVariable" value="${lineVar}"/>
            <input type="text" name="jyshry" value="${bsdx }">
            <input type="text" name="ypbh" value="${ypbh }">
            <input type="text" name="ypmc" value="${ypmc }">
         </form>
	</body>
	
	<script type="text/javascript">
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
	                window.parent.pendPoolGrid.store.load({params:{start:0,limit:20}});
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
</script>
</html>
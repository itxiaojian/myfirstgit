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
	poCtrl1.setCaption("报告审核");
	WordDocument worddoc = new WordDocument();
	
	if("0".equals( request.getAttribute("bztsbg"))){
		DataRegion data2 = worddoc.openDataRegion("PO_p2");
		data2.setValue("[word]"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"sy"+".doc"+"[/word]");
	}
	
	poCtrl1.setWriter(worddoc);

	//隐藏菜单栏
	//poCtrl1.setMenubar(false);
	//隐藏自定义工具栏
	//poCtrl1.setCustomToolbar(false);
	poCtrl1.setCustomToolbar(true);
	poCtrl1.setOfficeToolbars(false);
	poCtrl1.setAllowCopy(false);//禁止拷贝

	//添加自定义按钮
	poCtrl1.addCustomToolButton("通过","agree",5);
	poCtrl1.addCustomToolButton("        ","",21);
	poCtrl1.addCustomToolButton("不通过","CS",3);
	poCtrl1.addCustomToolButton("        ","",21);
	poCtrl1.addCustomToolButton("返回","Fanhui",13);
	poCtrl1.addCustomToolButton("        ", "", 21);
	poCtrl1.addCustomToolButton("温馨提示：当前报告编号为："+bgbh+"。","",21);
	
	poCtrl1.setJsFunction_AfterDocumentOpened( "AfterDocumentOpened()");
	poCtrl1.webOpen("/zjyw/resources/doc/"+bgbh+".doc", OpenModeType.docReadOnly, "");
// 	if(request.getAttribute("gai") == "0"){
// 	}else if(request.getAttribute("gai") == "1"){
// 		poCtrl1.webOpen("/zjyw/resources/doc/"+bgbh+"G.doc", OpenModeType.docReadOnly, "request.getParameter('xm')");
// 	}
	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>预览报告信息</title>
		<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.min.js"></script>
		 <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
		 <script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
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
		<c:choose>
 			<c:when test="${bztsbg == 0 }">
 				<div style="width:0px;height:0px;border-width: 0px;">
	        		<iframe id="test1" src="" style="width:0px;height:0px;border-width: 0px;"></iframe>
<%-- 	        		<%=path%>/jygl/YjyBgxx/pzr?bgbh=${bgbh }&key=${businessKey}&pzr=${pzr} --%>
  				</div>
 			</c:when>
	 	</c:choose>
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
			<input type="hidden" name="pzr" id="pzr" value="${pzr}" />	
         </form>
	</body>
	
	<script type="text/javascript">
	function RunMacro2(){        //获取总页数
        var value=document.getElementById("PageOfficeCtrl1").RunMacro("myFunc1", 'Function myFunc1() \r\n myFunc1=Application.Selection.Information(4) \r\n End Function');
        alert(value);
       }
	
			function Zuida(){
		    	document.getElementById("PageOfficeCtrl1").FullScreen = true;
		    }
	
	        function Fanhui(){
	        	window.history.back(-1);
	        }
	        var bgbh = "${bgbh}";
	        var userCode = "${userCode}";
	    	var taskId = "${taskId}";
	    	var creditId = "${businessKey}";
	    	var userCode = "${userCode}";
	        var lineVar = $("#lineVar").val();
	        var tname =  $("#tname").val();
	        var pzr = $("#pzr").val();
	        
			function AfterDocumentOpened(){
			 	document.getElementById('test1').src='<%=path%>/jygl/YjyBgxx/pzr?bgbh='+bgbh+'&key='+creditId+'&pzr='+pzr;
			}
	        function CS(){
var openUrl = "<%=path%>/jygl/YjyBgxx/CS?bgbh="+bgbh+"&userCode="+userCode+"&taskId="+taskId+"&businessKey="+creditId+"&lineVar="+lineVar+"&tname="+tname+"&cs=1";
	        	var iWidth=600; //弹出窗口的宽度;
	        	var iHeight=300; //弹出窗口的高度;
	        	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	        	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	        	window.open(openUrl,"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft); 
	        }
	        
	        var url=$("#projectName").val();//获取跟目录
			var options = {  
					//   target: '#output',          //把服务器返回的内容放入id为output的元素中     
					   beforeSubmit: showRequest,  //提交前的回调函数  
					   success: showResponse,      //提交后的回调函数  
					   url: url+'/cps/deal/dealYZZJSHAct',   //默认是form的action， 如果申明，则会覆盖  
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
				if(returnFlag) {
					msg = "是否确定？";
                    if (confirm(msg)) {
						document.getElementById("PageOfficeCtrl1").WebSave();
						$("#valueInputId").val(1);
						$("#optionForm").ajaxForm(options);  
						$("#optionForm").submit();
                    }
				}else{
					window.onbeforeunload = function(){ return '将丢失未保存的数据!'; }
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
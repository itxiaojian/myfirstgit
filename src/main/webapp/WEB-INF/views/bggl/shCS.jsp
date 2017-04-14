<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<% String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>  
<title>请填写不通过的意见</title>
<link href="<%=path%>/resources/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
</head>
<body>
<div class="panel panel-success" style="border-bottom: 0px;">
	  <div id="opinionDiv" class="panel-heading">填写意见:</div>
	  <div class="panel-body" >
			<form name="submitForm" id="optionForm" method="post">
			<input type="hidden" name="projectName" id="projectName" value="${pageContext.request.contextPath}"/>
				<input type="hidden" name="businessKey" value="${businessKey}" />	
				<input type="hidden" name="taskId" value="${taskId}" />	
				<input type="hidden" name="userCode" value="${userCode}" />	
				<input type="hidden" name="ypbh" value="${ypbh}" />	
				<input type="hidden" name="ypmc" value="${ypmc}" />	
				<input type="hidden" name = "lineVariable" id="lineVar"  value="${lineVar}" />	
				<input type="hidden" name = "tname" id="tname"  value="${tname}" />
				<input type="hidden" name = "value" id="valueInputId" />
				<textarea class="form-control" rows="6" name = "optionContent" id="optinoContentId"></textarea>
				<textarea name="signData" hidden=true cols="60" rows="6" id="signDataID"></textarea>
				<div align="center">
					<br>
					<input type="submit" class="btn btn-primary" onclick="disagree();" value="提交" />
					<input type="button" class="btn btn-danger" onclick="aaa();" value="关闭" />
				</div>
			</form>
	  </div>
	</div>
</body>
<script type="text/javascript">
		function aaa(){
			window.close();
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
					   window.opener.location.href = "<%=path%>/cps/process/taskXN/pendWorkPoolIndex?ypcs=2";
						window.close();	
				 }else {
					   alert('任务处理失败!');
				 }
		};
		
		//批准
		function agree(bgbh) {
			var returnFlag = checkApproveData();
			if(returnFlag) {
				$("#valueInputId").val(1);
				$("#optionForm").ajaxForm(options);  
			}else{
				window.onbeforeunload = function(){ return '将丢失未保存的数据!'; }
				return false;
			}
		}
		//不批准
		function disagree() {
			var bgbh = "${ypbh}";
			var url = "<%=path%>/jygl/YjyBgxx/deletesypz";
		    $.ajax({
		        cache: true,
		        type: "POST",
		        url: url,
		        data: {bgbh:bgbh},
		        async: false,
		        error: function (request) {
		            alert("请联系管理员。");
		        },
		        success: function (msg) {
		        	if(msg == "1" || msg == "0"){
		        		$("#valueInputId").val(0);
		    			$("#optionForm").ajaxForm(options); 
		        	}
		        }
		    });
			
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
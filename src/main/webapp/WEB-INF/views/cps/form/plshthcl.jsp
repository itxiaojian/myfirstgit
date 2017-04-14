<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<% String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>  
    <link href="<%=path%>/resources/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
<!-- <title>Insert title here</title> -->
</head>
<body>
   <form name="submitForm" id="optionForm" method="post">
	<div class="panel panel-success" style="margin-bottom: 0px;">
			  <div id="opinionDiv" class="panel-heading">填写意见：</div>
			   <div class="panel-body" >
					<input type="hidden" name="projectName" id="projectName" value="${pageContext.request.contextPath}"/>
					<input type="hidden" name="userCode" value="${userCode}" />	
					<input type="hidden" name = "lineVariable" value="${lineVar}" />	
					<input type="hidden" name = "tname" value="${tname}" />
					<input type="hidden" name = "value" id="valueInputId" />
					<c:forEach items="${taskIds}" var="node">  
						<input type="hidden" value="${node }" name="taskIds"/>	
					</c:forEach>  
					<c:forEach items="${businessKeys}" var="node">  
				        <input type="hidden" value="${node }" name="businessKeys"/>	
					</c:forEach>
					<div>
					<textarea class="form-control" rows="3" name = "optionContent" id="optinoContentId"></textarea>
					<br>
						<input type="button" class="btn btn-primary" onclick="disagree();" value="不通过" style="margin-left: 42%;"/>
					</div>
						<br>
						<br>
	  		   </div>
		</div>
	</form>
</body>
</html>
<script type="text/javascript">
	var url=$("#projectName").val();//获取跟目录
	var options = {  
			//   target: '#output',          //把服务器返回的内容放入id为output的元素中     
			   beforeSubmit: showRequest,  //提交前的回调函数  
			   success: showResponse,      //提交后的回调函数  
			   url: url+'/cps/deal/dealPLYZZJSHAct',   //默认是form的action， 如果申明，则会覆盖  
			   //type: type,               //默认是form的method（get or post），如果申明，则会覆盖  
			   dataType: 'json',           //html(默认), xml, script, json...接受服务端返回的类型  
			   //clearForm: true,          //成功提交后，清除所有表单元素的值  
			   //resetForm: true,          //成功提交后，重置所有表单元素的值  
			   timeout: 10000              //限制请求的时间，当请求大于10秒后，跳出请求  
			};
	
	function showRequest(formData, jqForm, options){  
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
	//不通过
	function disagree() {
		msg = "是否确定？";
        if (confirm(msg)) {
			$("#valueInputId").val(0);
			$("#optionForm").ajaxForm(options); 
			$("#optionForm").submit();
        }
	}
	//校验输入的审批意见
	function checkApproveData() {
		var returnFlag = true;
		return returnFlag;
	}
</script>
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
	  <div id="opinionDiv1" class="panel-heading"><span style="color: red">*</span> 选择检验人员:</div>
	  		<br>
			   <div class="input-group" style="width: 100%;margin: auto;">
				   <select class="form-control input-sm" name="jyry" id="jyry" style="width:95%; margin-left: 20px;">
					   	<option value="">请选择...</option>
					   <c:forEach var="data" items="${listypzjUser}" varStatus="status">
					   	<option value="${data.dlm}" >${data.xm}</option>
					   </c:forEach>
				   </select>
			   </div>
			  <br>
			  <div id="opinionDiv" class="panel-heading">操作：</div>
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
					<div><br>
						<input type="button" class="btn btn-primary" onclick="agree();" value="任务发放" style="margin-left: 42%;"/>
					</div>
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
			   url: url+'/cps/deal/dealPLKSZRFPRWAct',   //默认是form的action， 如果申明，则会覆盖  
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
	                window.parent.pendPoolGrid.store.load({params:{start:0,limit:20}});
	                window.parent.ACT_DEAL_WINDOW.close();
			 }else {
				   alert('任务处理失败!');
			 }
	};		
	//批准
	function agree() {
		var returnFlag = checkApproveData();
		if ($("#jyry").val() == "") {
            alert("请选择检验人员！");
            return false;
        }
		if(returnFlag) {
			 msg = "是否确定？";
	         if (confirm(msg)) {
				$("#valueInputId").val(1);
				$("#optionForm").ajaxForm(options);  
				$("#optionForm").submit();
	         }
		}else{
			window.onbeforeunload = function(){ return '将丢失未保存的数据!'; }
			return false;
		}
	}
	//校验输入的审批意见
	function checkApproveData() {
		var returnFlag = true;
		return returnFlag;
	}
</script>
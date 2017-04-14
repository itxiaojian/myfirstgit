<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<% String path = request.getContextPath();%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/bootstrap/bootstrap.min.css" />
  </head>
  <body>

	<div class="panel panel-danger">
	<%--   <div class="panel-heading">流程运行轨迹</div>
		    <table>
	  			<tr>
	  				<td>开始&nbsp;&nbsp;&nbsp;&nbsp;&rArr;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<c:forEach var="data" items="${optionList}" varStatus="status"> 
							<td>${data.actName}&nbsp;&nbsp;&nbsp;&nbsp;&rArr;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</c:forEach> 
					<c:forEach var="data" items="${runningAct}" varStatus="status"> 
							<td><font color="red">${data.actName}</font></td>
					</c:forEach>  		
					<c:if test="${fn:length(runningAct) == 0 }">
					  	 	<td>结束</td>
					</c:if>		 				
	  			</tr>
	  		</table>
		</div> --%>
		
		<div class="panel-heading">流程运行轨迹</div>
		    <table  style="table-layout:fixed;font-size: 12px">
	  			<tr  style="word-wrap:break-word;">
	  				<td>开始</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&rArr;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<c:forEach var="data" items="${optionList}" varStatus="status"> 
							<td align="center">${data.shjdmc}<br><c:if test="${data.shzt == 0 }">
					  	 	<span style='color:red'>(不通过)</span>
					  	 	</c:if>
					  	 	<c:if test="${data.shzt == 1 }">
					  	 	<span style='color:green'>(通过)</span>
					  	 	</c:if>
					  	 	<c:if test="${data.shzt == 3 }">
					  	 	<span style='color:blue'>(解锁)</span>
					  	 	</c:if>
					  	 	<c:if test="${data.shzt == 2 }">
					  	 	<span style='color:grey'>(归档)</span>
					  	 	</c:if>
					  	 	
					 </td>
					 <td>&nbsp;&nbsp;&nbsp;&nbsp;&rArr;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</c:forEach> 
					<c:forEach var="data" items="${runningAct}" varStatus="status"> 
							<td><font color="red">${data.actName}</font></td>
					</c:forEach>  		
					<c:if test="${fn:length(runningAct) == 0 }">
					  	 	<td>结束</td>
					</c:if>		 				
	  			</tr>
	  		</table>
		</div>
	  
	<div class="panel panel-danger">
	  <div class="panel-heading">流程图</div>
	  <div class="panel-body">
	    <img src = "<%=path%>${showProcessUrl}" alt="流程运行轨迹"></img>
	  </div>
	</div>  
 		<div class="panel panel-success">
	  <!-- Default panel contents -->
	  <div class="panel-heading">历史阶段意见:</div>	
	  <!-- Table -->
		<table class="table table-striped table-bordered" style="margin: auto;table-layout:fixed;font-size: 12px">
			<tr style="font-size: 13px">
				<td style="width:50px;font-weight: bold;" align="center">阶段</td>
				<td style="font-weight: bold;" width="50" align="center" >操作人</td>
				<td style="font-weight: bold;" width="40" align="center">审批动作</td>
				<td style="font-weight: bold;" width="40" align="center">下个节点人员</td>
				<td style="font-weight: bold;" width="260" align="center">审批意见</td>
				<td style="font-weight: bold;" width="70" align="center">操作时间</td>
			</tr>			
			<c:forEach var="data" items="${optionList}" varStatus="status">
				<tr>
					<td align="center" style="word-wrap:break-word">${data.shjdmc}</td>
					<td align="center" style="word-wrap:break-word">${data.shr}</td>
					<td align="center" style="word-wrap:break-word">
						<c:if test="${data.shzt == '1'}">
							通过
						</c:if>
						<c:if test="${data.shzt == '0'}">
							不通过
						</c:if>
						<c:if test="${data.shzt == '3'}">
							解锁
						</c:if>
						<c:if test="${data.shzt == '2'}">
							归档
						</c:if>
					</td>
					<td align="center" style="word-wrap:break-word">${data.xgjdry}</td>
					<td id="optionContentId${data.shyj}"                 	 	
						<c:if test="${data.signData == ''}">
							class="optionContentClass"
						</c:if>
						<c:if test="${data.signData != ''}">
							class="optionContentSignClass"
						</c:if> 
					align="center" style="word-wrap:break-word">${data.shyj}</td>
					<td align="center" style="word-wrap:break-word">${data.shsj}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
 	
  </body>
</html>
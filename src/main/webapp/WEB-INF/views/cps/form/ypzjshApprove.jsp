<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<% String path = request.getContextPath();
String bgbh = request.getParameter("bgbh");
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
   <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>  
    <link href="<%=path%>/resources/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
    <style type="text/css">
		.thbg {
				padding: 6px 12px; 
				background-color: #eeeeee;	
		}   
		.optionContentSignClass{
			width:250px;
		} 
		.optionContentClass{
			width:250px;
		} 
		a{
			cursor:pointer;
		}
    </style>
   </head> 
  <body>
  	<?xml version="1.0" encoding="iso-8859-1"?>  
	<!-- 贷款业务数据 -->
 <div class="panel panel-success">
 		<c:choose>
 			<c:when test="${bztsbg == 0 }">
	 			<div style="width:0px;height:0px;border-width: 0px;">
					<iframe id="test1" src="<%=path%>/jygl/YjyBgxx/shr?bgbh=${bgbh }&key=${businessKey}" style="width:0px;height:0px;border-width: 0px;"></iframe>
					<iframe id="test2" src="" style="width:0px;height:0px;border-width: 0px;"></iframe>
				</div>
 			</c:when>
 		</c:choose>
		<div class="panel-heading">样品信息:</div>
		<table class="table table-bordered">
			<tr>
				<th class="thbg">样品编号</th>
				<td>${mapBusi.ypbh}</td>
				<th class="thbg">样品名称</th>
				<td>
					<a onclick="viewCreditPdf('${mapBusi.id}','${mapBusi.djlx}');" title="点击查看样品信息">${mapBusi.ypmc}</a>
<%-- 					<input type="submit" class="btn btn-primary bzbg" onclick="ylbg('${mapBusi.bgbh}');" value="预览报告" --%>
<!-- 						style="position: relative; left: 200px;" /> -->
				</td>
			</tr>
		</table>
	</div>	  

<!-- 审批意见表单填写 -->
	<div class="panel panel-success">
		<div id="opinionDiv1" class="panel-heading"><span style="color: red">*</span> 选择检验批准人:</div>
        <br>
        <div class="input-group" style="width: 100%;margin: auto;">
	            <select class="form-control input-sm" name="pzr" id="pzr" style="width:95%; margin-left: 20px;">
	                 	<option value="">请选择...</option>
	                <c:forEach var="data" items="${listypzjpzUser}" varStatus="status">
	                    <option value="${data.dlm}">${data.xm}</option>
	                </c:forEach>
	            </select>
        </div>
        <div id="opinionDiv" class="panel-heading" style="margin-top: 2%;">操作:</div>
	  <div class="panel-body" >
			<form name="submitForm" id="optionForm" method="post">
			<input type="hidden" name="projectName" id="projectName" value="${pageContext.request.contextPath}"/>
				<input type="hidden" name="businessKey" value="${businessKey}" />	
				<input type="hidden" name="taskId" value="${taskId}" />	
				<input type="hidden" name="userCode" value="${userCode}" />	
				<input type="hidden" name="ypbh" value="${mapBusi.ypbh}" />	
				<input type="hidden" name="ypmc" value="${mapBusi.ypmc}" />	
				<input type="hidden" name = "lineVariable" id="lineVar"  value="${lineVar}" />	
				<input type="hidden" name = "tname" id="tname"  value="${tname}" />
				<input type="hidden" name = "value" id="valueInputId" />
<!-- 				<textarea class="form-control" rows="3" name = "optionContent" id="optinoContentId"></textarea> -->
<!-- 				<textarea name="signData" hidden=true cols="60" rows="6" id="signDataID"></textarea> -->
				<div align="center">
					<br>
					<input type="button" class="btn btn-primary" style="margin-left: -82px;"
						 onclick="ylbg('${mapBusi.bgbh}');" value="报告审核" />
					<input type="submit" class="btn btn-danger" style="margin-left: 97px;"
						onclick="disagree();" value="不通过" />
				</div>
			</form>
	  </div>
	</div>
	<!--历史审批意见-->
	<div class="panel panel-success">
		<!-- Default panel contents -->
		<div class="panel-heading">历史阶段意见:</div>
		<!-- Table -->
		<table class="table table-striped table-bordered" style="margin: auto;table-layout:fixed;font-size: 12px">
			<tr style="font-size: 13px">
				<td style="width:50px;font-weight: bold;" align="center">阶段</td>
				<td style="font-weight: bold;" width="50" align="center" >操作人</td>
				<td style="font-weight: bold;" width="40" align="center">审批动作</td>
				<td style="font-weight: bold;" width="260" align="center">审批意见</td>
				<td style="font-weight: bold;" width="110" align="center">操作时间</td>
			</tr>
			<c:forEach var="data" items="${listOption}" varStatus="status">
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
<script type="text/javascript">
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
	
	var ypid = $("#ypid").val();
	var ypid = $("#ypbh").val();
	var userCode = "${userCode}";
	var taskId = "${taskId}";
	var creditId = "${businessKey}";
	var userCode = "${userCode}";
    var lineVar = $("#lineVar").val();
    var tname =  $("#tname").val();
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
	
	function viewCreditPdf(ypid,djlx) {
		
		   window.open("<%=path%>/jygl/YjyJyxx/lcypxx?ypid="+ypid+"&djlx=" + djlx, "样品信息", "height=750, width=1000, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no") ;
		} 
	
	//报告生成
	function ylbg(bgbh){
		 var pzr = $("#pzr").val();
		 if ($("#pzr").val() == "") {
             alert("请选择批准人！");
             return false;
         }
		location.href = "<%=path%>/jygl/YjyBgxx/shbgck?bgbh="+bgbh+"&userCode="+userCode+"&taskId="+taskId+"&businessKey="+creditId+"&lineVar="+lineVar+"&tname="+tname+"&pzr="+pzr;
	}
	
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
		msg = "是否确定？";
        if (confirm(msg)) {
        	var bgbh = "${bgbh}";
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
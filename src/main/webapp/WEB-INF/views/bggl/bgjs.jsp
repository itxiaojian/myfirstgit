<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css">
<script type="text/javascript" src="<%=path%>/resources/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/upload.css">
<script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.qrcode.min.js"></script>

<style type="text/css">
	 .wbk{
	  	border-left:0px;
	  	border-top:0px;
	  	border-right:0px;
	  	border-bottom:1px;
	  	box-shadow:0px 0px 0px;
	  	margin-left: 0px;
	    margin-top: 7px;
	    font-size:14px;
 	}
 	.div{
	 	padding-bottom: 3px;
	 	margin-bottom: 0px;
	 	margin-top: 4px;
	 	width: 100%;
	 	height: 31px;
 	}
 	.bt{
 		margin-top: 11px;
 		font-size: 12px;
    	font-weight: 700;
 	}
 	.srk{
 		right: 3%;
 	}
</style>
</head>

<body >
	<div class="wrapper">
                <c:forEach var="bgxx" items="${bgxx}" varStatus="obj">
					<div class="form-group div">
						<label class="col-sm-2 control-label bt">报告编号：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="bgbh" name="bgbh" value="${bgxx.bgbh }" onfocus=this.blur()>
						</div>
						<label class="col-sm-2 control-label bt">报告名称：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="bgmc" name="bgmc" value="${bgxx.bgmc }" onfocus=this.blur()>
						</div>
						<label class="col-sm-2 control-label bt">样品名称：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="ypmc" name="ypmc" value="${ypxx.ypmc }" onfocus=this.blur()>
						</div>
					</div>
					<div class="form-group div">
						<label class="col-sm-2 control-label bt">编制人：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="bzr" name="bzr" value="${bgxx.bzr }" onfocus=this.blur()>
						</div>
						<label class="col-sm-2 control-label bt">接收单位：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="jsdw" name="jsdw" value="${bgxx.jsdw }" onfocus=this.blur()>
						</div>
						<label class="col-sm-2 bt control-label">接收人：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="jsr" name="jsr" value="${bgxx.jsr }" onfocus=this.blur()>
						</div>
					</div>
					<div class="form-group div">
						<label class="col-sm-2 bt control-label">发放日期：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="ffrq" name="ffrq" value="${bgxx.ffrq }" onfocus=this.blur()>
						</div>
						<label class="col-sm-2 bt control-label">发放状态：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="ffzt" name="ffzt" value="${bgxx.ffzt }" onfocus=this.blur()>
						</div>
						<label class="col-sm-2 bt control-label">退检日期：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="tjrq" name="tjrq" value="${bgxx.tjrq }" onfocus=this.blur()>
						</div>
				    </div>
					<div class="form-group div">
					    <label class="col-sm-2 bt control-label">退检原因：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="tjryy" name="tjyy" value="${bgxx.tjyy }" onfocus=this.blur()>
						</div>
						<label class="col-sm-2 bt control-label">退检人：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="tjr" name="tjr" value="${bgxx.tjr }" onfocus=this.blur()>
						</div>
						<label class="col-sm-2 bt control-label">编制方式：</label>
						<div class="col-sm-10 srk">
							<c:choose>
								<c:when test="${bgxx.bzfs == 0 }">
									<input class="form-control wbk" type="text" id="bzfs" name="bzfs" value="一般样品登记" onfocus=this.blur()>
								</c:when>
								<c:when test="${bgxx.bzfs == 1 }">
									<input class="form-control wbk" type="text" id="bzfs" name="bzfs" value="工程类样品登记" onfocus=this.blur()>
								</c:when>
							</c:choose>
						</div>
					</div>
					<div class="form-group div" style="height:40px;">
						<label class="col-sm-2 bt control-label">检验结论：</label>
						<div class="col-sm-13 srk">
							<textarea class="form-control ckeditor textarea wbk" rows="6"  name="jyjl" onfocus=this.blur()
							 style="width: 99.6%;height: 35px;resize:none;">${bgxx.jyjl }</textarea>
						</div>
					</div>
					<div class="form-group div">
						<label class="col-sm-2 bt control-label">是否解锁：</label>
						<div class="col-sm-10 srk">
							<c:choose>
								<c:when test="${bgxx.sfjs == 0 }">
									<input class="form-control wbk" type="text" id="sfjs" name="sfjs" value="未解锁" onfocus=this.blur()>
								</c:when>
								<c:when test="${bgxx.sfjs == 1 }">
									<input class="form-control wbk" type="text" id="sfjs" name="sfjs" value="已解锁" onfocus=this.blur()>
								</c:when>
							</c:choose>
						</div>
						<label class="col-sm-2 bt control-label">报审对象：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="bsdx" name="bsdx" value="${bgxx.bsdx }" onfocus=this.blur()>
						</div>
						<label class="col-sm-2 control-label bt">检验日期：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="jyrq" name="jyrq" value="${bgxx.jyrq }" onfocus=this.blur()>
						</div>
					</div>
					<div class="form-group div">
						<label class="col-sm-2 bt control-label">抽样对象：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="cydx" name="cydx" value="${bgxx.cydx }" onfocus=this.blur()>
						</div>
						<label class="col-sm-2 bt control-label">打印状态：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="dyzt" name="dyzt" value="${bgxx.dyzt }" onfocus=this.blur()>
						</div>
						<label class="col-sm-2 bt control-label">打印次数：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="dycs" name="dycs" value="${bgxx.dycs }" onfocus=this.blur()>
						</div>
					</div>
					<div class="form-group div">
						<label class="col-sm-2 bt control-label">报告编制日期：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="bgbzrq" name="bgbzrq" value="${bgxx.bgbzrq }" onfocus=this.blur()>
						</div>
						<label class="col-sm-2 bt control-label">报告打印时间：</label>
						<div class="col-sm-10 srk">
							<input class="form-control wbk" type="text" id="bgdysj" name="bgdysj" value="${bgxx.bgdysj }" onfocus=this.blur()>
						</div>
					</div>
					<div class="form-group div">
						<label class="col-sm-2 bt control-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
						<div class="col-sm-13 srk">
							<textarea class="form-control ckeditor textarea wbk" rows="6" name="bz" 
							truetype="textarea" style="width: 99.6%;height: 35px;resize:none;"></textarea>
						</div>
					</div>
					</c:forEach>
	</div>
	<form name="submitForm" id="optionForm" method="post">
		<input type="hidden" name="value" id="valueInputId" /> <input
			type="hidden" name="projectName" id="projectName"
			value="${pageContext.request.contextPath}" />
		<input type="hidden" id="id" name="id" value="${ypxx.id }">
		<div>
			<div class="form-group"
				style="width: 90%; padding-top: 6px; margin-left: 75px;">
<!-- 				<input class="btn btn-success" value="解锁" type="submit"  -->
<!-- 					onclick="disagree();">  -->
					<input class="btn btn-success" value="解锁" type="button" style="margin-left: 35%;" onclick="CS();"> 
					<input class="btn btn-success" style="margin-left: 10%;"
					type="button" onclick="exit();" value="返回">
			</div>
		</div>
	</form>
</body>
<script>
//返回
function exit(){
// 	var PAGESIZE = 20;
// 	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); 
    window.parent.ACT_DEAL_WINDOW.close();
}

var url=$("#projectName").val();//获取跟目录
var options = {  
		//   target: '#output',          //把服务器返回的内容放入id为output的元素中     
		   beforeSubmit: showRequest,  //提交前的回调函数  
		   success: showResponse,      //提交后的回调函数  
		   url: url+'/cps/deal/dealWebJs',   //默认是form的action， 如果申明，则会覆盖  
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
		   var PAGESIZE=20;
		   window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); 
           window.parent.ACT_DEAL_WINDOW.close();
	 }else {
		   alert('任务处理失败!');
	 }
};
//不批准
function disagree() {
	$("#valueInputId").val(0);
	$("#optionForm").ajaxForm(options); 
}

function CS(){
		msg = "是否确定？";
    	if (confirm(msg)) {
	 		var bgbh = $("#bgbh").val();
			var url = "<%=path%>/jygl/YjyBgxx/deletebg";
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
			        		$("#optionForm").submit();
		        	}
		        }
		    });
		}
	}
</script>
<style>
.form-control.form-control1 {
    background-color: #fff;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
    color: #555;
    display: block;
    font-size: 14px;
    height: 30px;
    line-height: 1.42857;
    padding: 6px 12px;
    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
    vertical-align: middle;
    width: 100%;
}
a.link {
    background-color: #5cb85c;
    border-radius: 4px;
    color: #fff;
    cursor: pointer;
    display: inline-block;
    float: left;
    font: 13px/19px "Microsoft YaHei",Verdana,Geneva,sans-serif;
    padding: 1%;
    margin-top: 3px;
    text-align: center;
    text-decoration: none;
    width: 10%;
}
</style>

</html>

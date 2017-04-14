<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<% String path = request.getContextPath();
   String a = ".pdf";
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
   <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>  
	<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
	<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
<%--     <script type="text/javascript" src="<%=path%>/system/layout/jquery.js"></script> --%>
 <script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/yz/jquery-1.10.2.min.js"></script>
<%-- 	<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script> --%>
	<script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
	<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>

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
   </head> 
  <body>
  	<?xml version="1.0" encoding="iso-8859-1"?>  
	<!-- 贷款业务数据 -->
	<div class="panel panel-success">
		<div class="panel-heading">样品信息:</div>
		<table class="table table-bordered">
			<tr>
				<th class="thbg">样品编号</th>
				<td>${mapBusi.ypbh}</td>
				<th class="thbg">样品名称</th>
				<td>
					<a onclick="viewCreditPdf('${mapBusi.id}','${mapBusi.djlx}');" title="点击查看样品信息">${mapBusi.ypmc}</a>
					<input type="submit" class="btn btn-primary bzbg" onclick="ylbg('${mapBusi.bgbh}');" value="预览报告"
						style="position: relative; left: 200px;" />
				</td>
			</tr>
		</table>
	</div>	  

<!-- 审批意见表单填写 -->
	<div class="panel panel-success">
	  <div id="opinionDiv" class="panel-heading">归档登记:</div>
	  <div class="panel-body" >
			<form name="submitForm" id="optionForm" method="post" class="form-horizontal tasi-form">
			<input type="hidden" name="projectName" id="projectName" value="${pageContext.request.contextPath}"/>
				<input type="hidden" name="businessKey" value="${businessKey}" />	
				<input type="hidden" name="taskId" value="${taskId}" />	
				<input type="hidden" name="userCode" value="${userCode}" />	
				<input type="hidden" name = "lineVariable" value="${lineVar}" />	
				<input type="hidden" name = "tname" value="${tname}" />
				<input type="hidden" name = "value" id="valueInputId" />
<!-- 				<textarea type="hidden" class="form-control" rows="3" name = "optionContent" id="optinoContentId"></textarea> -->
				<textarea  name="signData" hidden=true cols="60" rows="6" id="signDataID"></textarea>
<!-- 				<div align="center"> -->
<!-- 					<br> -->
<!-- 					<input type="submit" class="btn btn-primary" onclick="agree();" value="解锁" /> -->
<%-- 					<input type="submit" class="btn btn-danger" onclick="disagree('${mapBusi.id}');" value="归档" /> --%>
<!-- 				</div> -->
				<div style="width: 1px; height: 1px; overflow: hidden;">
                   <iframe id="iframe1" name="iframe1" src=""></iframe>
                </div>
                
					<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">档案标题：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="dabt" name="dabt" readOnly=true value="${mapBusi.ypmc}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">档案类型：</label>
						<div class="col-sm-10">
							<select class="form-control input-lg m-bot15" name="dalx" style="padding-left: 2px;" >
								<c:forEach var="dalx" items="${dalx}" varStatus="obj">
									<option value="${dalx.zdz }">${dalx.zdmc }</option>
								</c:forEach>
							</select>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">档案关键字：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="dagjz" name="dagjz" value="检验报告">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">所属机构：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="ssjgid" name="ssjgid" readOnly="true" value="${jyks}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">归档内容：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="gdnr" name="gdnr" value="检验报告" >
						</div>
						<label class="col-sm-2 col-sm-2 control-label">档案类目：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="lmmc" name="lmmc"value="自动归档报告">
						</div>
						<a href="#myDalm" data-toggle="modal"
                            class="btn btn-xs btn-sucess" style="margin-top: 5px;">选择</a>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px; padding-top: 2px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">档案密级：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="damj" name="damj" value="一级" readonly="true">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">保管期限：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="bgqx" name="bgqx" value="10年" readonly="true">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">可查看人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="kckrxm" name="kckrxm">
						</div>
                         <a href="#myKckr" data-toggle="modal"
                            class="btn btn-xs btn-sucess" style="margin-top: 5px;">选择</a>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px; padding-top: 2px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件：</label>
						<div class="col-sm-10">
							<input type="text" name="fjid"  class="form-control" readOnly=true value="${mapBusi.bgbh}<%=a%>"/>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">原始记录：</label>
						<c:if test="${ywysjl == 1 || ywysjl == null}">
						<div class="col-sm-10" style="top:7px;">
							<b style="color:red;">此报告尚未上传原始记录</b>
						</div>
						</c:if>
						<c:if test="${ywysjl == 0}">
						<div class="col-sm-10">
							<a data-toggle="modal"
                            class="btn btn-xs btn-sucess" onclick="ysjl('${ysjlwjm}','${bz}');" style="margin-top: 5px;">点击查看</a>
                        </div>
						</c:if>
						<div class="hidden">
							<input type="text" class="hidden" id="ysjlwjm" readOnly=true value="${ysjlwjm}"/>
						</div>
						<div class="col-sm-10">
							<input type="text" class="hidden" id="bz" readOnly=true value="${bz}"/>
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="6" name="bz" id="optinoContentId"
									  truetype="textarea" style="width: 99%;height: 35px;"></textarea>
						</div>
					</div>
				
				<div style="text-align: center">
					<div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 75px; margin-bottom: 7px;">
						<input type="submit" class="btn btn-danger" onclick="disagree('${mapBusi.bgbh}');" value="归档" />
					</div>
				</div>
			</form>
			
			<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myDalm" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<section class="panel" id="sectDalm">
							<header class="panel-heading">选择档案类目</header>
							<label style="margin-left: 6px;">类目名称:</label>&nbsp;&nbsp;&nbsp;<input id="sslmmc" name="sslmmc">
							<button onClick="getDalm();">查询</button>
							<span id="sbzDalm"></span>
							<div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
								<div class="col-lg-offset-2 col-lg-10" style="margin-top: 7px;">
									<button type="button" class="btn btn-default" onClick="closeDalm();"
											style="margin-left:28%;">取消
									</button>
								</div>
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
		
		<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myKckr" class="modal fade">
			<div class="modal-dialog" style = "left: 22px; top: 158px;">
				<div class="modal-content">
					<div class="modal-body">
						<section class="panel" id="sectKckr">
							<header class="panel-heading">查询人员并选择</header>
							<label style="margin-left: 6px;">姓名:</label>&nbsp;&nbsp;&nbsp;<input id="xm" name="xm">&nbsp;&nbsp;&nbsp;
							<label style="margin-left: 6px;">科室:</label>&nbsp;&nbsp;&nbsp;<input id="bmmc" name="bmmc">
							<button onClick="getKckr();">查询</button>
							<span id="sbzKckr"></span>
							<div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
								<div class="col-lg-offset-2 col-lg-10" style="margin-top: 7px;">
								    <button type="button" class="btn btn-default" onclick="saveKckr();"
		                                    style="margin-left: 16px;">确定
		                            </button>
									<button type="button" class="btn btn-default" onClick="closeKckr();"
											style="margin-left:38%;">取消
									</button>
								</div>
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
			
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
  <script type="text/javascript">
	var userCode = "${userCode}";
	var taskId = "${taskId}";
	var creditId = "${businessKey}";
	var url=$("#projectName").val();//获取跟目录
	var options = {  
			//   target: '#output',          //把服务器返回的内容放入id为output的元素中     
			   beforeSubmit: showRequest,  //提交前的回调函数  
			   success: showResponse,      //提交后的回调函数  
			   url: url+'/cps/deal/dealJSZXJSAct',   //默认是form的action， 如果申明，则会覆盖  
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
		location.href="<%=path%>/jygl/YjyBgxx/jsbgck?bgbh="+bgbh;
	}
	
	//查看原始记录
	function ysjl(ysjlwjm,bz){
		location.href="<%=path%>/jygl/YjyBgxx/ysjlck?ysjlwjm="+ysjlwjm+"&bz="+bz;
// 		window.open('ysjlck?ysjlwjm='+ysjlwjm+'&bz='+bz,"原始记录查看","height=600px, width=1000px,top=100px, left=200px, toolbar=no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no");
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
	function agree() {
		var returnFlag = checkApproveData();
		if(returnFlag) {
			$("#valueInputId").val(1);
			$("#optionForm").ajaxForm(options);  
		}else{
			window.onbeforeunload = function(){ return '将丢失未保存的数据!'; }
			return false;
		}
	}
	
	//归档提交
	function disagree(bgbh) {
		msg="确定要提交？";
		if (confirm(msg)) {
			var url = "<%=path%>/dagl/YdaXx/save?bgbh="+bgbh;
			$.ajax({
				cache : true,
				type : "POST",
				url : url,
				data : $('#optionForm').serialize(),// 你的formid
				async : false,
				error : function(request) {
					alert("归档失败,请联系管理员。");
				},
				success : function(data) {
					$("#valueInputId").val(0);
			 		$("#optionForm").ajaxForm(options);
					alert('归档成功！');
					window.close();
				}
			});
		}
	}
	
	
	//打开类目信息窗口
	function getDalm() {
		var del = $("#table");
		del.remove();
		var lmmc = document.getElementById("sslmmc").value;
//     var khflcx = document.getElementById("khflcx").value;
		var url = "<%=path%>/dagl/YdaLmgl/getDalm";
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : {lmmc:lmmc},
			async : false,
			error : function(request) {
				alert("选择失败,请联系管理员。");
				$('#myDalm').modal('show');
			},
			success : function(data) {
				var del = $("#table");
				del.remove();
				var str="<table><thead><tr><th>类目名称</th><th>档案密级</th><th>保管期限</th>"
						+"<th>操作</th></tr></thead><tbody>";
				for(var i=0;i<data.length;i++){
					str=str+"<tr id='"+data[i].ID+"'><td>"+data[i].LMMC+"</td><td>"+data[i].DAMJ
							+"</td><td>"+data[i].BGQX+"</td><td><input type ='button' onClick='saveDalm("+data[i].ID+");' value='选择'></td>";
				}
				str=str+"</tbody><table>";
				var oTest = document.getElementById("sectDalm");
				var newNode = document.createElement("table");
				var befNode = document.getElementById("sbzDalm");
				newNode.setAttribute('class','table');
				newNode.setAttribute('id','table');
				newNode.innerHTML =str;
				oTest.insertBefore(newNode,befNode);
			}
		});
		$("#lmmc").val("");
		$('#myDalm').modal('show');
	}

	//关闭类目窗口
	function closeDalm() {
		$('#myDalm').modal('hide');
		var del = $("#table");
		del.remove();
	}

	var Dalm = null;
	//选择档案类目
	function saveDalm(id) {
		//msg = "确定选择？";
		//if (confirm(msg)) {
		var url = "<%=path%>/dagl/YdaLmgl/getDalmById";
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : {id:id},
			async : false,
			error : function(request) {
				alert("选择失败,请联系管理员。");
			},
			success : function(data) {
				//alert(data[0].KHMC);
				dalm = data;
				$("#lmmc").val(data[0].LMMC);
				$("#damj").val(data[0].DAMJ);
				$("#bgqx").val(data[0].BGQX);
				$('#myDalm').modal('hide');
			}
		});
		//}
	}
	
	
	//打开人员信息窗口
	 function getKckr() {
		var del = $("#table");
		del.remove();
		var xm = document.getElementById("xm").value;
        var bmmc = document.getElementById("bmmc").value;
		var url = "<%=path%>/yhgl/SysYh/getKckr";
		 if((xm!="" && xm!=null) || (bmmc!="" && bmmc!=null)){
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : {xm:xm,bmmc:bmmc},
			async : false,
			error : function(request) {
				alert("选择失败,请联系管理员。");
				//$('#myKckr').modal('show');
			},
			success : function(data) {
				var del = $("#table");
				del.remove();
				var str="<table><thead><tr><th>姓名</th><th>科室</th>"
						+"<th>操作</th></tr></thead><tbody>";
				for(var i=0;i<data.length;i++){
					str=str+"<tr id='"+data[i].YHBH+"'><td>"+data[i].XM+"</td><td>"+data[i].BMMC
							+"</td><td><input name='checkSfxmmx' type='checkbox' value = '" + data[i].YHBH + "'/></td>";
				}
				str=str+"</tbody><table>";
				var oTest = document.getElementById("sectKckr");
				var newNode = document.createElement("table");
				var befNode = document.getElementById("sbzKckr");
				newNode.setAttribute('class','table');
				newNode.setAttribute('id','table');
				newNode.innerHTML =str;
				oTest.insertBefore(newNode,befNode);
			}
		});
		}else {
        	alert("请输入查询条件！");
        	return false;
        }
		$("#xm").val("");
		$("#bmmc").val("");
		/* $('#myKckr').modal('show'); */
	}

	//关闭人员窗口
	function closeKckr() {
		$('#myKckr').modal('hide');
		var del = $("#table");
		del.remove();
	}

	var Kckr = null;
	//选择委托单位
	function saveKckr(yhbh) {
		var r = document.getElementsByName("checkSfxmmx");
		var ryxm ="";
        for (var i = 0; i < r.length; i++) {
            if (r[i].checked) {
            	var a = r[i].value;
            	var td = $("#" + a).find("td");
            	if(ryxm==""){
            		ryxm += $(td[0]).text();
            	}else{
	            	ryxm += ","+$(td[0]).text();
            	}
            	$("#kckrxm").val(ryxm);
            	$('#myKckr').modal('hide');
            }
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
</html>


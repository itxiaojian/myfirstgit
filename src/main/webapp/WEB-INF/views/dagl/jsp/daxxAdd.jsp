<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
    String a = ".pdf";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
	<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
	<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
	<script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
<%--     <link href="<%=path%>/resources/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/> --%>
<%--     <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.min.js"></script> --%>
<%--     <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script> --%>
<%--     <script type="text/javascript" src="<%=path%>/resources/js/cps/checkData.js"></script> --%>
    
<!-- 		<meta http-equiv="pragma" content="no-cache"> -->
<!-- 		<meta http-equiv="cache-control" content="no-cache"> -->
<!-- 		<meta http-equiv="expires" content="0"> -->
<!-- 		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> -->
<!-- 		<meta http-equiv="description" content="This is my page"> -->

</head>
<body >
<div class="wrapper">
	<div class="panel" style="margin-bottom: 1px;">
		<header class="panel-heading">归档登记</header>
		<div class="panel-body">
			<div style="text-align:center;margin-bottom:-2px"></div>
			<form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post"  style="overflow:scroll;overflow-x:hidden">
				<c:forEach var="ypxx" items="${ypxx}" varStatus="obj">
					<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">档案标题：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="dabt" name="dabt" readOnly=true value="${ypxx.ypmc }">
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
							<input class="form-control" type="text" id="dagjz" name="dagjz">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">所属机构：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="ssjgid" name="ssjgid" readOnly="true" value="${ypxx.jyks }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">档案类目：</label>
						<div class="col-sm-10">
							<input class="form-control" onClick="getDalm()" type="text" id="lmmc" name="lmmc">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">档案密级：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="damj" name="damj">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px; padding-top: 2px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">保管期限：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="bgqx" name="bgqx">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">归档内容：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="gdnr" name="gdnr" >
						</div>
						<label class="col-sm-2 col-sm-2 control-label">附件：</label>
						<div class="col-sm-10">
							<input type="text" name="fjid"  class="form-control" value="${ypxx.bgbh}<%=a %>"/>
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px; padding-top: 2px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">可查看人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="kckrxm" name="kckrxm">
						</div>
                         <a href="#myKckr" data-toggle="modal"
                            class="btn btn-xs btn-sucess" style="margin-top: 5px;">选择</a>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="6" name="bz"
									  truetype="textarea" style="width: 99%;height: 35px;"></textarea>
						</div>
					</div>
				</c:forEach>
				
				<div style="text-align: center">
					<div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 75px;">
						<button class="btn btn-success" type="button" onClick="save()">提交</button>
						<button type="button" class="btn btn-success" onClick="javascript:window.close();">关闭</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myDalm" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h4 class="modal-title">抽样人员选择</h4>
            </div> -->
			<div class="modal-body">
				<!-- <form class="form-horizontal" role="form"> -->
				<section class="panel" id="sectDalm">
					<header class="panel-heading">选择档案类目</header>
					<label style="margin-left: 6px;">类目名称:</label>&nbsp;&nbsp;&nbsp;<input id="sslmmc" name="sslmmc">
					<button onClick="getDalm();">查询</button>
					<span id="sbzDalm"></span>
					<div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
						<div class="col-lg-offset-2 col-lg-10" style="margin-top: 40px;">
							<button type="button" class="btn btn-default" onClick="closeDalm();"
									style="margin-left:38%;">取消
							</button>
						</div>
					</div>
				</section>
				<!-- </form> -->
			</div>
		</div>
	</div>
</div>

<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myKckr" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<section class="panel" id="sectKckr">
					<header class="panel-heading">查询人员并选择</header>
					<label style="margin-left: 6px;">姓名:</label>&nbsp;&nbsp;&nbsp;<input id="xm" name="xm">&nbsp;&nbsp;&nbsp;
					<label style="margin-left: 6px;">科室:</label>&nbsp;&nbsp;&nbsp;<input id="bmmc" name="bmmc">
					<button onClick="getKckr();">查询</button>
					<span id="sbzKckr"></span>
					<div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
						<div class="col-lg-offset-2 col-lg-10" style="margin-top: 40px;">
						    <button type="button" class="btn btn-default" onclick="saveKckr();"
                                    style="margin-left: 100px;">确定
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

</body>
<script>

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
	//选择委托单位
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

	//提交
	function save() {
		msg="确定要提交？";
		if (confirm(msg)) {
			var url = "<%=path%>/dagl/YdaXx/save";
			$.ajax({
				cache : true,
				type : "POST",
				url : url,
				data : $('#myForm').serialize(),// 你的formid
				async : false,
				error : function(request) {
					alert("保存失败,请联系管理员。");
				},
				success : function(data) {
// 					$("#valueInputId").val(0);
// 			 		$("#optionForm").ajaxForm(options);
					alert('保存成功！');
					window.close();
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

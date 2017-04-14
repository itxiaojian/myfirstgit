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
<script type="text/javascript"
	src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet"
	href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="<%=path%>/resources/css/jygl/style.css">
	
	
</head>

<script type="text/javascript">


function close(){
	var PAGESIZE = 10;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
    window.parent.ACT_DEAL_WINDOW.close();
}
function save() {
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/rsgl/YRsXzinfoKc/save";
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
				alert('保存成功！');
				var PAGESIZE = 20;
				window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	            window.parent.ACT_DEAL_WINDOW.close();
			} 
		});
	}
} 
	</script>
<body>
	<div class="wrapper">
		<div class="panel">
			<header class="panel-heading"> 薪资扣除</header>
			<form action="" class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
			<div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label">人员编号：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value=""  name="rybh">
					</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">缺勤扣除：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="" name="qqkc">
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">养老保险：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="" name="ylbx">
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">月份：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="" name="yf" onClick="WdatePicker({dateFmt:'yyyy-MM '})">
				</div>
			</div>
			
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label"> 医保 ：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="" name="yb">
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">失业保险：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="" name="sybx">
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">社保小计：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="" name="sbxj">
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">住房公积金：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="" name="zfgjj">
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">个税：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="" name="gs">
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">扣除小计：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="" name="kcxj">
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">备注：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="" name="bz">
				</div>
			</div>

			<div style="text-align: center">
				<div class="panel-body">
					<input class="btn btn-success" value="提交" type="button" onclick="save();">
 
                        <input class="btn btn-success" type="button" onclick="self.close();" value="关闭本页面">
				</div>
			</div>
			</form>
		</div>
	</div>

	</div>
</body>
</html>
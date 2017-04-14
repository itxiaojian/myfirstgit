<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<% String path = request.getContextPath();%>
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
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
</head>
<script>
function save() {
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/cwgl/YCwKssr/update";
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

//退出
function exit(){
	/* var PAGESIZE = 10;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
}

</script>
<body >
<div class="wrapper">
	<div class="panel">
	<!-- <header class="panel-heading" style="padding-left: 650px;"> 科室收入</header> -->
		<div class="panel-body">
		<div style="text-align:center;margin-bottom:10px">
		</div>
		<form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
			<c:forEach var="kssr" items="${kssr}" varStatus="obj">
			<input type="hidden" name="id" id="id" value="${kssr.id }">
			<div class="form-group" style="padding-bottom: 0px;padding-left: 0px; display:none;">
			    <label class="col-sm-2 col-sm-2 control-label">录入日期：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="lrrq" name="lrrq" value="${kssr.lrrq }" 
					       onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
				    <span class="help-inline" style="float:left;">yyyy-mm-dd</span>					       
				</div>
			    <label class="col-sm-2 col-sm-2 control-label">录入人:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="lrr" name="lrr" value="${kssr.lrr }">
				</div>
			</div>
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				<label class="col-sm-2 col-sm-2 control-label">科室编号:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ksbh" name="ksbh" value="${kssr.ksbh }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">科室名称：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ksmc" name="ksmc" value="${kssr.ksmc }">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
			    <label class="col-sm-2 col-sm-2 control-label">检验编号:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="jybh" name="jybh" value="${kssr.jybh }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">项目名称：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ypmc" name="ypmc" value="${kssr.ypmc }">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 0px;padding-left: 0px;">
			   <label class="col-sm-2 col-sm-2 control-label">样品详情:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ypxq" name="ypxq" value="${kssr.ypxq }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">成本金额：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" value="${kssr.cbje }" name="cbje">
					<span class="input-group-addon">.00</span>
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
			    <label class="col-sm-2 col-sm-2 control-label">收款金额：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" value="${kssr.skje }" name="skje">
					<span class="input-group-addon">.00</span>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">核算收入：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" value="${kssr.hssr }" name="hssr">
					<span class="input-group-addon">.00</span>
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
			    <label class="col-sm-2 col-sm-2 control-label">修改金额：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="xgje" name="xgje" value="${kssr.xgje }">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				<label class="col-sm-2 col-sm-2 control-label">修改原因：</label>
				<div class="col-sm-13">
					<textarea class="form-control ckeditor textarea" rows="2" name="xgyy" 
					truetype="textarea" style="width: 1094px;">${kssr.xgyy }</textarea>
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				<label class="col-sm-2 col-sm-2 control-label">备注</label>
				<div class="col-sm-13">
					<textarea class="form-control ckeditor textarea" rows="5" name="bz" 
					truetype="textarea" style="width: 1094px;">${kssr.bz }</textarea>
				</div>
			</div>
			</c:forEach>
		</form>
		<div style="text-align: center">
			<div class="panel-body">
				<button type="button" class="btn btn-primary"
					onClick="save()">修改</button>
				<button type="button" class="btn btn-success"
					onClick="exit();">返回</button>
			</div>
		</div>
		<footer class="site-footer">
			<div class="text-center">
				2015 &版权所有; 合肥智圣系统集成有限责任公司. <a href="#" class="go-top"> <i class="icon-angle-up"></i></a>
			</div>
		</footer>
		</div>
	</div>
</div>
</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
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
<script type="text/javascript"
	src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
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


  function update(type){

	var url="";
	var msg="";
	
	if(type==0){
		url="<%=path%>/rsgl/YRsXzInfo/update";
			msg = "确定要提交信息吗？";
			if (confirm(msg)) {
				$.ajax({
					cache : true,
					type : "POST",
					url : url,
					data : $('#myForm').serialize(),// 你的formid
					async : false,
					error : function(request) {
						alert("保存失败，请联系管理员。");
					},
					success : function(data) {

						/* if(data=='1'){
							alert('保存成功！'); 
							history.go(0) ;
						}else{ */
						alert("保存成功");
						history.go(0);
					}

				});
			}
		}
	}
</script>
<body>
	<div class="wrapper">
		<div class="panel">
			<header class="panel-heading"> 薪资管理修改 </header>
			<form action="" class="form-horizontal tasi-form" name="myForm"
				id="myForm" method="post">
				<c:forEach var="xzgl" items="${xzgl}" varStatus="obj">
					<input type="hidden" id="id" name="id" value="${xzgl.id}">
					<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label">人员编号：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" value="${xzgl.rybh}" style="width:100%;height:28px;"
								name="rybh">
						</div>
						
						<label class="col-sm-2 col-sm-2 control-label">人员姓名：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" value="${xzgl.ryxm}" style="width:100%;height:28px;
								name="ryxm">
						</div>
						
						<label class="col-sm-2 col-sm-2 control-label">基本工资：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" value="${xzgl.jbgz}" style="width:100%;height:28px;
								name="jbgz">
						</div>
					</div>

					<div class="panel-body"> 
					
					    <label class="col-sm-2 col-sm-2 control-label">月份：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" value="${xzgl.yf}" style="width:100%;height:28px;
								name="yf" onClick="WdatePicker({dateFmt:'yyyy-MM '})">
						</div>
						<label class="col-sm-2 col-sm-2 control-label"> 绩效工资 ：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" value="${xzgl.jxgz}" style="width:100%;height:28px;
								name="jxgz">
						</div>
						
						<label class="col-sm-2 col-sm-2 control-label">加班费：</label>
						<div class="col-sm-10"> 
							<input class="form-control" type="text" value="${xzgl.jbf}" style="width:100%;height:28px;
								name="jbf">
						</div>
					</div>
					
					<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label">午餐补助：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" value="${xzgl.id}" style="width:100%;height:28px;
								name="wcbz">
						</div>
						
						<label class="col-sm-2 col-sm-2 control-label">实发工资：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" value="${xzgl.sfgz}" style="width:100%;height:28px;
								name="sfgz">
						</div>
						
						<label class="col-sm-2 col-sm-2 control-label">应发工资：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" value="${xzgl.yfgz}" style="width:100%;height:28px;
								name="yfgz">
						</div>
					</div>
					<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label">其他：</label>
						<div class="col-sm-13">
							<textarea rows="3" name="qt" class="form-control" style="width:99.5%;">${xzgl.qt}</textarea>
						</div>
					</div>
					
					<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label">备注：</label>
						<div class="col-sm-13">
							<textarea rows="3" name="bz" class="form-control" style="width:99.5%;">${xzgl.bz}</textarea>
						</div>
					</div>

					<div style="text-align: center">
						<div class="panel-body" style="width: 100%;  margin-top: 37px;">
							<input class="btn btn-success" value="提交" type="button"
								onclick="update(0);"> <input class="btn btn-success"
								type="button" onclick="self.close();" value="关闭">
						</div>
					</div>
				</c:forEach>
			</form>
		</div>
	</div>

	</div>
</body>
</html>
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
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/upload.css">
<script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
.form-control111 {
    background-color: #fff;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
    color: #555;
    font-size: 12px;
    height:21px;
    padding: 1px 6px;
    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
}
.tabCss111{
	width: 80%; 
	height: 76px;
	margin-left: 95px;
}
</style>
</head>
<script>
//退出
function exit(){
	var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
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
		<input type="hidden" name="num1" id="num1" value="${size }">
		<input type="hidden" name="nwbh" id="nwbh" value="${nwxx.id }">
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				<label class="col-sm-2 control-label">承检部门：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="cjbm" name="cjbm" value="${nwxx.cjbmmc }" readonly="readonly">
				</div>
				<label class="col-sm-2 control-label">接收人：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="jsr" name="jsr" value="${nwxx.jsrxm }" readonly="readonly">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				<label class="col-sm-2 col-sm-2 control-label">委托部门：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="wtbmmc" name="wtbmmc" readonly="readonly" value="${nwxx.wtbmmc }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">委托日期：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="wtrq" name="wtrq" readonly="readonly" value="${nwxx.wtrq }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">要求检验结果报告日期：</label>
				<div class="col-sm-10">
					<input class="form-control Wdate" type="text" id="yqwcrq" name="yqwcrq" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${nwxx.yqwcrq }" readonly="readonly">
				</div>
			</div>
<!-- 		</form> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
<!-- 	<div class="panel"> -->
<!-- 		<header class="panel-heading" style="text-align: center;"> 样品明细</header> -->
<!-- 		<div class="panel-body"> -->
<!-- 			<form class="form-horizontal tasi-form" name="myForm2" id="myForm2"  method="post"> -->
			<input type="hidden" name="Jybh" id="Jybh" value="">
			<input type="hidden" name="num" id="num" value="${size }">
			<div class="form-group" id="xsDiv" style="margin-top:50px">
				<table style="width: 80%; height: 76px;margin-left: 95px;" id="xsTab">
					<tbody id="mybody">
					<tr>	
						<th style="text-align:center">样品名称</th>
						<th style="text-align:center">样品编号</th>
						<th style="text-align:center">规格型号</th>
						<th style="text-align:center">检验依据</th>
						<th style="text-align:center">检验项目</th>
						<th style="text-align:center">检验费（元）</th>
						<th style="text-align:center">是否需要退样</th>
						<th style="text-align:center">样品保存期限</th>
<!-- 						<th></th> -->
					</tr>
						<c:forEach var="data" items="${nwmx }" varStatus="obj">
					<tr id="tr">
						<td>
							<input type="hidden" name="mxid${obj.count }" id="mxid${obj.count }" value="${data.id }">
							<textarea style="height: 37px;" class="form-control" type="text" id="ypmc${obj.count }" name="ypmc${obj.count }" readonly="readonly">${data.ypmc }</textarea>
						</td>
						<td><textarea style="height: 37px;" class="form-control" type="text" id="ypbh${obj.count }" name="ypbh${obj.count }" readonly="readonly">${data.bgbh }</textarea></td>
						<td><textarea style="height: 37px;" class="form-control" type="text" id="ggxh${obj.count }" name="ggxh${obj.count }" readonly="readonly">${data.ggxh }</textarea></td>
						<td><textarea style="height: 37px;" class="form-control" type="text" id="jyyj${obj.count }" name="jyyj${obj.count }" readonly="readonly">${data.jyyj }</textarea></td>
						<td><textarea style="height: 37px;" class="form-control" type="text" id="jyxm${obj.count }" name="jyxm${obj.count }" readonly="readonly">${data.jyxm }</textarea></td>
						<td><textarea style="height: 37px;" class="form-control" type="text" id="je${obj.count }" name="je${obj.count }" readonly="readonly">${data.jyfy }</textarea></td>
						<td style="width:10%"><textarea style="height: 37px;" class="form-control" type="text" id="sfty${obj.count }" name="sfty${obj.count }" readonly="readonly">${data.sfty}</textarea>
						</td>
						<td><textarea style="height: 37px;" class="form-control" type="text" id="bcqx${obj.count }" name="bcqx${obj.count }" readonly="readonly">${data.ypbgqx }</textarea></td>
					</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div style="text-align:center;margin-bottom:10px">
				<input class="btn btn-success" value="关闭" type="button" onclick="exit();">
		    </div>
			</form>
		</div>
	</div>
</div>
</body>
</html>
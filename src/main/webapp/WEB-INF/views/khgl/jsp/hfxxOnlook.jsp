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
<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css">
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/upload.css">
<script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.qrcode.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery.validate.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/yz/yzstyle.css">
</head>

<script type="text/javascript">
//输入的时候回车可以跳到下一个输入域
$(function () {
    //回车代替tab
    $('input:text:first').focus();
    //如果有其他输入类型可以在此处加入
    var $target = $('input,button,select');
    $target.bind('keydown', function (e) {
        var key = e.which;
        if (key == 13) {
            e.preventDefault();
            var nxtIdx = $target.index(this) + 1;
            if ($target.eq(nxtIdx).attr("type") == "submit") {
                $target.eq(nxtIdx).click();
            } else {
                $target.eq(nxtIdx).focus();
            }
        }
    });
});

//返回
function exit(){
	/* var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
}

	</script>
<body>
		<div class="wrapper">
		<div class="panel">
		<c:forEach var="hfxx" items="${hfxx}" varStatus="obj">
		<header class="panel-heading" style=" padding-bottom: 0px;"><b style="font-size: 19px;margin-left: 40%;">客户回访拜访记录表</b></header>
		<header class="panel-heading" style="padding-top: 0px; padding-bottom: 0px;"><b style="font-size: 13px;margin-left: 38%;">客户编号：${hfxx.khbh}</b></header>
			<form action="" class="form-horizontal tasi-form bl-form bl-formhor" name="myForm" id="myForm" method="post">
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
				<label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;"><span style="color:red">*</span>客户名称：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="khmc" name="khmc" value="${hfxx.khmc}" disabled="true" style="width:110%;">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">客户地址：</label>
				  <div class="col-sm-10">
					<input class="form-control" type="text" style="width:110%;" id="khdz" name="khdz" disabled="true" value="${hfxx.khdz}" >
				  </div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
				  <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">拜访人员：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" style="width:110%;" id="bfry" name="bfry" disabled="true" value="${hfxx.bfry}">
					</div>
				  <label class="col-sm-2 col-sm-2 control-label">人员职务：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" style="width:110%;" id="ryzw" name="ryzw" disabled="true" value="${hfxx.ryzw}">
					</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
			   <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">联系电话：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="lxdh" name="lxdh" value="${hfxx.lxdh}" disabled="true" style="width:110%;" onkeyup="value=value.replace(/[^\d]/g,'') "   
                                   onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">拜访日期：</label>
                  <div class="col-sm-10">
                  <input class="form-control Wdate" type="text" id="bfrq" name="bfrq" value="${hfxx.bfrq}" disabled="true" style="width:110%;" onClick="WdatePicker({dateFmt:' yyyy-MM-dd'})" >
                  </div>
			   </div>
			   
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
			    <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">合作情况：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" style="width:110%;" id="hzqk" name="hzqk" disabled="true" value="${hfxx.hzqk}">
					</div>
			    <label class="col-sm-2 col-sm-2 control-label">客户评价：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" style="width:110%;" id="khpj" name="khpj" disabled="true" value="${hfxx.khpj}">
					</div>
			</div>
				<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
					<label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">拜访记录：</label>
					<div class="col-sm-10">
						<textarea class="form-control"  truetype="textarea" id ="bfjl" name="bfjl" disabled="true" rows="3" style="width:258%; ">${hfxx.bfjl}</textarea>
					</div>
				</div>
				<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
					<label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">客户意见和要求：</label>
					<div class="col-sm-10">
						<textarea class="form-control"   truetype="textarea" id ="yjyq" name="yjyq" disabled="true" rows="3" style="width:258%; ">${hfxx.yjyq}</textarea>
					</div>
				</div>
				<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
					<label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">分析对策与建议：</label>
					<div class="col-sm-10">
						<textarea class="form-control"   truetype="textarea" id ="dcjy" name="dcjy" disabled="true" rows="3" style="width:258%; ">${hfxx.dcjy}</textarea>
					</div>
				</div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%; ">
			    <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">业务人员：</label>
				<div class="col-sm-10" >
					<input class="form-control" type="text" id="ywry" name="ywry" value="${hfxx.ywry}" disabled="true" style="width:110%;">
			    </div>
			</div>
			<div style="text-align: center">
				<div class="form-group"  style="margin-top: 10px; margin-left: -7%; width: 110%;">
				    <button type="button" class="btn btn-success"onClick="exit();">返回</button>
				</div>
			</div>
			</form>
			</c:forEach>
		</div>
	</div>

</body>
</html>
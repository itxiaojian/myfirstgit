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

function close(){
	var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
    window.parent.ACT_DEAL_WINDOW.close();
}



	</script>
	<% Date date = new Date();
     SimpleDateFormat edate = new SimpleDateFormat("yyyy");
     String year = edate.format(date);%>
<body>
		<div class="wrapper">
		<div class="panel">
		<header class="panel-heading" style=" padding-bottom: 0px;"><b style="font-size: 19px;margin-left: 45%;">客户档案</b></header>
		<c:forEach var="khxx" items="${khxx}" varStatus="obj">
		<header class="panel-heading" style="padding-top: 0px; padding-bottom: 0px;"><b style="font-size: 13px;margin-left: 38%;">主体信息（客户编号：${khxx.khbh}<span style="color:red">*</span>）</b></header>
			<form action="" class="form-horizontal tasi-form bl-form bl-formhor" name="myForm" id="myForm" method="post">
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
				<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>单位/个人：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="khmc" name="khmc" value="${khxx.khmc}" disabled="true"  style="width:110%;">
				</div>
				 <label class="col-sm-2 col-sm-2 control-label">客户生日：</label>
                  <div class="col-sm-10">
                  <input class="form-control Wdate" style="width:110%;" type="text" id="sr" name="sr" value="${khxx.sr}" disabled="true" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" >
                  </div>
				<label class="col-sm-2 col-sm-2 control-label">省市县区：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" style="width:110%;" id="ds" name="ds" value="${khxx.ds}" disabled="true">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
			      <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>详细地址：</label>
				  <div class="col-sm-10">
					<input class="form-control" type="text" style="width:110%;" id="khdz" name="khdz" value="${khxx.khdz}" disabled="true" >
				  </div>
				  <label class="col-sm-2 col-sm-2 control-label">单位网址：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" style="width:110%;" id="dwwz" name="dwwz" value="${khxx.dwwz}" disabled="true">
					</div>
				  <label class="col-sm-2 col-sm-2 control-label">成立时间：</label>
                  <div class="col-sm-10">
                  <input class="form-control Wdate" type="text" id="clsj" name="clsj" value="${khxx.clsj}" disabled="true" style="width:110%;" >
                  </div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
			   <label class="col-sm-2 col-sm-2 control-label">单位性质：</label>
					<div class="col-sm-10">
						<input class="form-control Wdate" type="text" id="dwxz" name="dwxz" value="${khxx.dwxz}" disabled="true" style="width:110%;" >
	                </div>
	            <label class="col-sm-2 col-sm-2 control-label">主导产品：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" id="jycpmc" name="jycpmc" value="${khxx.jycpmc}" disabled="true" style="width:110%;">
				    </div>
			      <label class="col-sm-2 col-sm-2 control-label">注册资金(元)：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="${khxx.zczj}" disabled="true" name="zczj" style="width:110%;" >
				</div>
			   </div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
			    <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>业务金额(元)：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ywje" name="ywje" style="width:110%;"value="${khxx.ywje}" disabled="true">
			    </div>
			    <label class="col-sm-2 col-sm-2 control-label">客户等级：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="khfl" name="khfl" style="width:110%;"value="${khxx.khfl}" disabled="true">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">预登记账号：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" style="width:110%;" id="ydjzh" name="ydjzh" value="${khxx.khbh}" readonly="readonly">
				</div>
			</div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
				<label class="col-sm-2 col-sm-2 control-label" >证件类型：</label>
				<div class="col-sm-10" >
					<input class="form-control" type="text" id="zjlx" name="zjlx" style="width:110%;"value="${khxx.zjlx}" disabled="true">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">证件号码：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" style="width:110%;" value="${khxx.zjhm }" disabled="true" name="zjhm">
				</div>
				</div>
				<div class="form-group" style="padding-bottom: 3px;margin-bottom: 14px;margin-top: 4px; width: 100%;">
					<label class="col-sm-2 col-sm-2 control-label">备注信息：</label>
					<div class="col-sm-10">
						<textarea class="form-control" truetype="textarea" disabled="true" name="bz" rows="1" style="width:400%; ">${khxx.bz}</textarea>
					</div>
				</div>
				<header class="panel-heading" style="padding-top: 0px; padding-bottom: 0px;"><b style="font-size: 13px;margin-left: 46%;">联系信息</b></header>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%; ">
			    <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">法人姓名：</label>
				<div class="col-sm-10" >
					<input class="form-control" type="text" id="frxm" name="frxm" value="${khxx.frxm}" disabled="true" style="width:110%;">
			    </div>
			    <label class="col-sm-2 col-sm-2 control-label" >联络人员：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" style="width:110%;" id="lxr" name="lxr" value="${khxx.lxr}" disabled="true">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
				<label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">手机号码：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="sjhm" name="sjhm" style="width:110%;" value="${khxx.sjhm}" disabled="true">
				</div>
				<label class="col-sm-2 col-sm-2 control-label" >手机号码：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="sjhm1" name="sjhm1" style="width:110%;" value="${khxx.sjhm1 }" disabled="true">
				</div>
			</div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
			<label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">固定电话：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="${khxx.gddh}" name="gddh" style="width:110%;"disabled="true">
				</div>
			<label class="col-sm-2 col-sm-2 control-label" >固定电话：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="gddh1" name="gddh1" style="width:110%;" value="${khxx.gddh1 }" disabled="true">
				</div>
		    </div>
		    <div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
		        <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">传真号码：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="cz" name="cz" style="width:110%;"value="${khxx.cz}" disabled="true" >
				</div>
				<label class="col-sm-2 col-sm-2 control-label" >传真号码：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="cz1" name="cz1" style="width:110%;" value="${khxx.cz1}" disabled="true">
				</div>
		    
		    </div>
		    <div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
		        <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">电子邮箱：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="dzyx" name="dzyx" style="width:110%;" value="${khxx.dzyx}" disabled="true" >
				</div>
				<label class="col-sm-2 col-sm-2 control-label" >电子邮箱：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="dzyx1" name="dzyx1" style="width:110%;"value="${khxx.dzyx1}" disabled="true">
				</div>
		    
		    </div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
		        <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">法人QQ：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="frqq" name="frqq" style="width:110%;"value="${khxx.frqq}" disabled="true">
				</div>
				<label class="col-sm-2 col-sm-2 control-label" >联络QQ：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="llqq" name="llqq" style="width:110%;" value="${khxx.llqq}" disabled="true" >
				</div>
		    
		    </div>
		    
			<div style="text-align: center">
				<div class="form-group"  style="margin-top: 10px; margin-left: -7%; width: 110%;">
                    <input class="btn btn-success" type="button" onclick="self.close();" value="关闭">
				</div>
			</div>
			</form>
			</c:forEach>
		</div>
	</div>

</body>
</html>
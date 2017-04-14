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

</head>
<body >
	<div class="wrapper">
	<div class="panel" style="margin-bottom: 1px;">
		<div class="panel-body">
			<div style="text-align:center;margin-bottom:-2px"></div>
			<c:forEach var="glsf" items="${glsf}" varStatus="obj">
                <form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
					<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>部门名称：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="bmbh" name="bmbh" disabled="true" value ="${glsf.bmbh}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>发票号码：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="fphm" name="fphm" disabled="true" value ="${glsf.fphm}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">收入分类：</label>
						<div class="col-sm-10">
							<select id="selectedRoleId" class="form-control" name="srfl" disabled="true" >
                            <c:forEach items="${srfl}" var="srfl">
                                <c:choose>
                                         <c:when test="${srfl.zdz == glsf.srfl}">
                                               <option selected = "selected" value="${srfl.zdz}">${srfl.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${srfl.zdz}">${srfl.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">收费项目名称：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sfxmmc" name="sfxmmc" disabled="true" value ="${glsf.sfxmmc}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">收费金额（元）：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" onkeyup="value=value.replace(/[^\d]/g,'') "   
                                   onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"   
                             id="sfje" name="sfje" value ="${glsf.sfje}" disabled="true"> 
						</div>
						<label class="col-sm-2 col-sm-2 control-label">缴费日期：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="sfrq" name="sfrq" disabled="true" value ="${glsf.sfrq}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
							 onkeyup="value=value.replace(/[^\d]/g,'') "   
                                   onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" >
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">收费人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sfr" name="sfr" disabled="true" value ="${glsf.sfr}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">凭据分类：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sfr" name="sfr" disabled="true" value ="${glsf.pjfl}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">凭据号码：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sfr" name="sfr" disabled="true" value ="${glsf.pjhm}">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="6" name="bz" disabled="true"
							truetype="textarea" style="width: 99%;height: 35px;">${glsf.bz}</textarea>
						</div>
					</div>
					<div style="text-align: center">
						<div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 75px;">
					        <input class="btn btn-success" type="button" onclick="exit();" value="返回">
						</div>
					</div>
				</form>
				</c:forEach>
		  </div>
	   </div>
    </div>
</body>
<script>

//二维码图片
$(function(){
	var str = "${url}";
	$("#code").qrcode({
		width: 100,
		height:100,
		text: str
	});
});



//返回
function exit(){
	/* var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
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

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

<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery-1.10.2.min.js"></script>

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
<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery.validate.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/yz/yzstyle.css">
</head>

<body>
	<div class="wrapper" style="height: 514px;">
	<div class="panel" style="margin-bottom: 1px;">
		<div class="panel-body">
			<div style="text-align:center;margin-bottom:-2px"></div>
                <form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post" enctype="multipart/form-data">
                <c:forEach var="sbxx" items="${sbxx}" varStatus="obj">
                    <input type="hidden" name="id" id="id" value="${sbxx.id }">
					<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>设备编号：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sbbh" name="sbbh"  value="${sbxx.sbbh }" 
							required data-msg-required="设备编号必填" minlength="1">
						</div>
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>设备名称：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sbmc" name="sbmc"  value="${sbxx.sbmc }" 
							required data-msg-required="设备名称必填" minlength="1">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">出厂编号：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="ccbh" name="ccbh"  value="${sbxx.ccbh }">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">生产厂家：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sccj" name="sccj"  value="${sbxx.sccj }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">厂家联系人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="cjlxr" name="cjlxr"  value="${sbxx.cjlxr }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">厂家电话：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" onkeyup="value=value.replace(/[^\d]/g,'') "   
                                   onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"   
                             id="cjdh" name="cjdh"  value="${sbxx.cjdh }" placeholder="请输入数字格式"> 
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 0px;margin-bottom: 0px; padding-top: 2px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">厂家地址：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="cjdz" name="cjdz"  value="${sbxx.cjdz }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">启用日期：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="qysj" name="qysj" value="${sbxx.qysj }"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
							 onkeyup="value=value.replace(/[^\d]/g,'') "   
                                   onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" >
						</div>
						<label class="col-sm-2 col-sm-2 control-label">放置地点：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="fzdd" name="fzdd"  value="${sbxx.fzdd }">
						</div>
				    </div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
					    <label class="col-sm-2 col-sm-2 control-label">设备状态：</label>
						<div class="col-sm-10">
                            <c:if test="${sbxx.sbzt != null}">
							<select id="selectedRoleId" class="form-control" name="sbzt" required data-msg-required="设备状态必填">
                            <c:forEach items="${sbzt}" var="sbzt">
                                <c:choose>
                                         <c:when test="${sbzt.zdz == sbxx.sbzt}">
                                               <option selected = "selected" value="${sbzt.zdz}">${sbzt.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${sbzt.zdz}">${sbzt.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${sbxx.sbzt == null}">
                           <select class="form-control input-lg m-bot15" name="sbzt" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="sbzt" items="${sbzt}" varStatus="obj">
										<option value="${sbzt.zdz }">${sbzt.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">规格型号：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sbxh" name="sbxh"  value="${sbxx.sbxh }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">计量单位：</label>
						<div class="col-sm-10">
                            <c:if test="${sbxx.dw != null}">
							<select id="selectedRoleId" class="form-control" name="dw" >
                            <c:forEach items="${dw}" var="dw">
                                <c:choose>
                                         <c:when test="${dw.zdz == sbxx.dw}">
                                               <option selected = "selected" value="${dw.zdz}">${dw.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${dw.zdz}">${dw.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${sbxx.dw == null}">
                           <select class="form-control input-lg m-bot15" name="dw" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="dw" items="${dw}" varStatus="obj">
										<option value="${dw.zdz }">${dw.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if> 
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">购买价格（元）：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="gmjg" name="gmjg"  value="${sbxx.gmjg }"
							onkeyup="value=value.replace(/[^\d]/g,'') "   
                            onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">测量范围（准确度/不确定度）：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="clfw" name="clfw"  value="${sbxx.clfw }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">配件信息：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="pjxx" name="pjxx"  value="${sbxx.pjxx }">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">保管人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sbwhr" name="sbwhr"  value="${sbxx.sbwhr }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">购买日期：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="gmrq" name="gmrq" value="${sbxx.gmrq }"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
							onkeyup="value=value.replace(/[^\d]/g,'') "   
                            onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">操作人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sbczr" name="sbczr"  value="${sbxx.sbczr }">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">是否有操作规程：</label>
						<div class="col-sm-10">
                            <c:if test="${sbxx.sfyczgc != null}">
							<select id="selectedRoleId" class="form-control" name="sfyczgc" >
                            <c:forEach items="${sfyczgc}" var="sfyczgc">
                                <c:choose>
                                         <c:when test="${sfyczgc.zdz == sbxx.sfyczgc}">
                                               <option selected = "selected" value="${sfyczgc.zdz}">${sfyczgc.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${sfyczgc.zdz}">${sfyczgc.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${sbxx.sfyczgc == null}">
                           <select class="form-control input-lg m-bot15" name="sfyczgc" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="sfyczgc" items="${sfyczgc}" varStatus="obj">
										<option value="${sfyczgc.zdz }">${sfyczgc.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">是否有使用记录：</label>
						<div class="col-sm-10">
                           <c:if test="${sbxx.sfysyjl != null}">
							<select id="selectedRoleId" class="form-control" name="sfysyjl" >
                            <c:forEach items="${sfysyjl}" var="sfysyjl">
                                <c:choose>
                                         <c:when test="${sfysyjl.zdz == sbxx.sfysyjl}">
                                               <option selected = "selected" value="${sfysyjl.zdz}">${sfysyjl.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${sfysyjl.zdz}">${sfysyjl.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${sbxx.sfysyjl == null}">
                           <select class="form-control input-lg m-bot15" name="sfysyjl" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="sfysyjl" items="${sfysyjl}" varStatus="obj">
										<option value="${sfysyjl.zdz }">${sfysyjl.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">是否有期间核查：</label>
						<div class="col-sm-10">
                            <c:if test="${sbxx.sfyqjhc != null}">
							<select id="selectedRoleId" class="form-control" name="sfyqjhc" >
                            <c:forEach items="${sfyqjhc}" var="sfyqjhc">
                                <c:choose>
                                         <c:when test="${sfyqjhc.zdz == sbxx.sfyqjhc}">
                                               <option selected = "selected" value="${sfyqjhc.zdz}">${sfyqjhc.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${sfyqjhc.zdz}">${sfyqjhc.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${sbxx.sfyqjhc == null}">
                           <select class="form-control input-lg m-bot15" name="sfyqjhc" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="sfyqjhc" items="${sfyqjhc}" varStatus="obj">
										<option value="${sfyqjhc.zdz }">${sfyqjhc.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">是否有功能检查：</label>
						<div class="col-sm-10">
						<c:if test="${sbxx.sfygnjc != null}">
							<select id="selectedRoleId" class="form-control" name="sfygnjc" >
                            <c:forEach items="${sfygnjc}" var="sfygnjc">
                                <c:choose>
                                         <c:when test="${sfygnjc.zdz == sbxx.sfygnjc}">
                                               <option selected = "selected" value="${sfygnjc.zdz}">${sfygnjc.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${sfygnjc.zdz}">${sfygnjc.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${sbxx.sfygnjc == null}">
                           <select class="form-control input-lg m-bot15" name="sfygnjc" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="sfygnjc" items="${sfygnjc}" varStatus="obj">
										<option value="${sfygnjc.zdz }">${sfygnjc.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>使用科室：</label>
						<div class="col-sm-10">
						<c:if test="${sbxx.syks != null}">
						    <select id="selectedRoleId" class="form-control"  name="syks" required data-msg-required="使用科室必填" minlength="1">
                            <c:forEach items="${syks}" var="syks">
                                <c:choose>
                                         <c:when test="${syks.bmbh == sbxx.syks}">
                                               <option selected = "selected" value="${syks.bmbh}">${syks.bmmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${syks.bmbh}">${syks.bmmc}</option>
                                         </c:otherwise>
                               </c:choose>
                            </c:forEach>
                           </select> 
						</c:if>
						<c:if test="${sbxx.syks == null}">
						    <select class="form-control input-lg m-bot15" name="syks" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="syks" items="${syks}" varStatus="obj" >
										<option value="${syks.bmbh }">${syks.bmmc }</option>
								</c:forEach>
					        </select>
						</c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>使用状态：</label>
						<div class="col-sm-10">
                            <c:if test="${sbxx.syzt != null}">
							<select id="selectedRoleId" class="form-control" name="syzt" required data-msg-required="使用状态必填" minlength="1">
                            <c:forEach items="${syzt}" var="syzt">
                                <c:choose>
                                         <c:when test="${syzt.zdz == sbxx.syzt}">
                                               <option selected = "selected" value="${syzt.zdz}">${syzt.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${syzt.zdz}">${syzt.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${sbxx.syzt == null}">
                           <select class="form-control input-lg m-bot15" name="syzt" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="syzt" items="${syzt}" varStatus="obj">
										<option value="${syzt.zdz }">${syzt.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
					    <label class="col-sm-2 col-sm-2 control-label">下次检定日期：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="xcjdrq" name="xcjdrq" value="${sbxx.xcjdrq }"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
							onkeyup="value=value.replace(/[^\d]/g,'') "   
                            onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
						</div>
					    <label class="col-sm-2 col-sm-2 control-label">操作规程：</label>
                        <div class="box">
                               <input type="text" name="copyFile" value="${sbxx.czgc }"  class="textbox" />
					            <a href="javascript:void(0);"  class="link">...</a>
					            <input type="file" class="uploadFile" name="attachMentFile" id="attachMentFile"
					             onchange="getFile(this,'copyFile')" />
						</div>
						<label class="col-sm-2 col-sm-2 control-label">使用说明书：</label>
                        <div class="box">
                                <input type="text" name="copyFile2" value="${sbxx.sysms }"  class="textbox" />
					            <a href="javascript:void(0);"  class="link">...</a>
					            <input type="file" class="uploadFile" name="attachMentFile2" id="attachMentFile2"
					             onchange="getFile(this,'copyFile2')" />
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
					    <label class="col-sm-2 col-sm-2 control-label">使用说明书附件：</label>
                        <div class="box">
                               <input type="text" name="copyFile3" value="${sbxx.sysmffj}" class="textbox" />
					            <a href="javascript:void(0);"  class="link">...</a>
					            <input type="file" class="uploadFile" name="attachMentFile3" id="attachMentFile3"
					             onchange="getFile(this,'copyFile3')" />
						</div>
					    <label class="col-sm-2 col-sm-2 control-label">设备照片：</label>
                        <div class="box">
                               <input type="text" name="copyFile5" value="${sbxx.sbzp }" class="textbox" />
					            <a href="javascript:void(0);"  class="link">...</a>
					            <input type="file" class="uploadFile" name="attachMentFile5" id="attachMentFile5"
					             onchange="getFile(this,'copyFile5')" />
						</div>
						<label class="col-sm-2 col-sm-2 control-label">功能检查方法：</label>
                        <div class="box">
                               <input type="text" name="copyFile4" value="${sbxx.gnjcff }"  class="textbox" />
					            <a href="javascript:void(0);"  class="link">...</a>
					            <input type="file" class="uploadFile" name="attachMentFile4" id="attachMentFile4"
					             onchange="getFile(this,'copyFile4')" />
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
					    <label class="col-sm-2 col-sm-2 control-label">期间核查方法：</label>
                        <div class="box">
                                <input type="text" name="copyFile1" value="${sbxx.qjhcff }" class="textbox" />
					            <a href="javascript:void(0);"  class="link">...</a>
					            <input type="file" class="uploadFile" name="attachMentFile1" id="attachMentFile1"
					             onchange="getFile(this,'copyFile1')" />
						</div>
					    <label class="col-sm-2 col-sm-2 control-label">标准度等级不确定度：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="bzddj" name="bzddj"  value="${sbxx.bzddj }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">计量情况：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="jlqk" name="jlqk"  value="${sbxx.jlqk }">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">检定单位：</label>
						<div class="col-sm-10">
                            <c:if test="${sbxx.jddw != null}">
							<select id="selectedRoleId" class="form-control" name="jddw" >
                            <c:forEach items="${jddw}" var="jddw">
                                <c:choose>
                                         <c:when test="${jddw.zdz == sbxx.jddw}">
                                               <option selected = "selected" value="${jddw.zdz}">${jddw.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${jddw.zdz}">${jddw.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${sbxx.jddw == null}">
                           <select class="form-control input-lg m-bot15" name="jddw" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="jddw" items="${jddw}" varStatus="obj">
										<option value="${jddw.zdz }">${jddw.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">检定周期：</label>
						<div class="col-sm-10">
                            <c:if test="${sbxx.jyzq != null}">
							<select id="selectedRoleId" class="form-control" name="jyzq" >
                            <c:forEach items="${jyzq}" var="jyzq">
                                <c:choose>
                                         <c:when test="${jyzq.zdz == sbxx.jyzq}">
                                               <option selected = "selected" value="${jyzq.zdz}">${jyzq.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${jyzq.zdz}">${jyzq.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${sbxx.jyzq == null}">
                           <select class="form-control input-lg m-bot15" name="jyzq" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="jyzq" items="${jyzq}" varStatus="obj">
										<option value="${jyzq.zdz }">${jyzq.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">计量结果：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="jljg" name="jljg"  value="${sbxx.jljg }">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
					    <label class="col-sm-2 col-sm-2 control-label">检定费用（元）：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="jdfy" name="jdfy"  value="${sbxx.jdfy }"
							onkeyup="value=value.replace(/[^\d]/g,'') "   
                            onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
						</div>
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>仪器状况：</label>
						<div class="col-sm-10">
                             <c:if test="${sbxx.yqzk != null}">
							<select id="selectedRoleId" class="form-control" name="yqzk" required data-msg-required="仪器状况必填" minlength="1">
                            <c:forEach items="${yqzk}" var="yqzk">
                                <c:choose>
                                         <c:when test="${yqzk.zdz == sbxx.yqzk}">
                                               <option selected = "selected" value="${yqzk.zdz}">${yqzk.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${yqzk.zdz}">${yqzk.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${sbxx.yqzk == null}">
                           <select class="form-control input-lg m-bot15" name="yqzk" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="yqzk" items="${yqzk}" varStatus="obj">
										<option value="${yqzk.zdz }">${yqzk.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
					    <label class="col-sm-2 col-sm-2 control-label" >设备精度：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sbjb" name="sbjb"  value="${sbxx.sbjb}">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top:0px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">确认记录：</label>
                        <div class="box">
                                <input type="text" name="copyFile6" value="${sbxx.sbfj }"  class="textbox" />
					            <a href="javascript:void(0);"  class="link">...</a>
					            <input type="file" class="uploadFile" name="attachMentFile6" id="attachMentFile6"
					             onchange="getFile(this,'copyFile6')" />
						</div>
						<label class="col-sm-2 col-sm-2 control-label">使用参数：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="syfw" name="syfw"  value="${sbxx.syfw }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">登记日期：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="ccrq" name="ccrq" value="${sbxx.ccrq }"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
							onkeyup="value=value.replace(/[^\d]/g,'') "   
                            onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top:0px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">检定/校准/检查：</label>
                        <div class="box">
                                <input type="text" id="copyFile7" name="copyFile7" value="${sbxx.jdzs}"  class="textbox" />
					            <a href="javascript:void(0);"  class="link">...</a>
					            <input type="file" class="uploadFile" name="attachMentFile7" id="attachMentFile7"
					             onchange="getFile(this,'copyFile7')" style="width: 255px;" />
						</div>
						<a onClick="exit2();"  class="link" style="padding: 2px 0px; width: 4%;">高拍仪</a>
						<c:if test="${sbxx.jdzs != null}">
						<div class="col-sm-10" style="width:3%; padding-left: 0px;">
							<a class="btn btn-xs btn-sucess" onClick="exit1();" style="margin-top: 5px;color:red;">删除</a>
                        </div>
                        <label class="col-sm-2 col-sm-2 control-label" style="width: 6%;">使用部门：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sybm" name="sybm"  value="${sbxx.sybm }">
						</div>
						</c:if>
						<c:if test="${sbxx.jdzs == null}">
						<label class="col-sm-2 col-sm-2 control-label" style="width: 9%;" >使用部门：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sybm" name="sybm"  value="${sbxx.sybm }">
						</div>
						</c:if>
						<label class="col-sm-2 col-sm-2 control-label">停用日期：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="tyrq" name="tyrq" value="${sbxx.tyrq }" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
							onkeyup="value=value.replace(/[^\d]/g,'') "   
                            onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="6" name="bz" 
							truetype="textarea" style="width: 99%;height: 49px;">${sbxx.bz }</textarea>
						</div>
					</div>
					
					<div class="hidden" style="padding-bottom: 6px;margin-bottom: 0px;margin-left: 100px; width: 90%;">
						<div class="col-sm-10">
							<input class="hidden" type="text" id="bfyy" name="bfyy" readonly="true" value="${sbxx.bfyy }">
							<input class="hidden" type="text" id="jdzs" name="jdzs" readonly="true" value="${sbxx.jdzs }">
							<input class="hidden" type="text" id="jdzssub" name="jdzssub" readonly="true" value="${sbxx.jdzssub }">
						</div>
						<div class="col-sm-10">
							<input class="hidden" name="bfrq" readonly="true" value="${sbxx.bfrq }"onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="form-control Wdate" />
						</div>
					</div>
					<div class="hidden" style="padding-bottom: 6px;margin-bottom: 0px;margin-left: 100px; width: 90%;">
						<div class="col-sm-10">
							<input class="hidden" type="text" id="tyyy" name="tyyy" readonly="true" value="${sbxx.tyyy }">
						</div>
<!-- 						<div class="col-sm-10"> -->
<%-- 							<input class="hidden" name="tyrq" readonly="true"  value="${sbxx.tyrq }"onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="form-control Wdate" /> --%>
<!-- 						</div> -->
					</div>
					</c:forEach>
					
					<div style="text-align: center">
						<div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 105px;">
<!-- 							<input class="btn btn-success" value="提交" type="submit" > -->
							<input class="btn btn-success" value="提交" type="submit" >
					        <input class="btn btn-success" type="button" onclick="exit();" value="返回">
						</div>
					</div>
				</form>
		  </div>
	   </div>
    </div>
</body>

<script type="text/javascript">

//获取上传文件名
function getFile(obj,inputName){
	var file_name = $(obj).val();
	$("input[name='"+inputName+"']").val(file_name);
}

// function save() {
// 	msg="确定要提交？";
// 	if (confirm(msg)) {
<%-- 		var url = "<%=path%>/sbgl/YSbXx/save"; --%>
// 		$.ajax({
// 			cache : true,
// 			type : "POST",
// 			url : url,
// 			data : $('#myForm').serialize(),// 你的formid
// 			async : false,
// 			error : function(request) {
// 				alert("保存失败,请联系管理员。");
// 			},
// 			success : function(data) {
// 				alert('保存成功！');
// 				var PAGESIZE = 20;
// 				window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
// 	            window.parent.ACT_DEAL_WINDOW.close();
// 			}
// 		});
// 	}
// } 

//查看检定证书
function exit1(){
	msg = "确定要删除检定证书？";
    if (confirm(msg)) {
    	$("#copyFile7").val("");
    	$("#attachMentFile7").val("");
    	$("#jdzs").val("");
   	    $("#jdzssub").val("");
   	
   	var options = { 
		        url:'<%=path%>/sbgl/YSbXx/save',
    		        //beforeSubmit:  showRequest,  //提交前处理 
    		success: function(data) {
									if(data=='1'){
										alert('删除成功！'); 
// 										var PAGESIZE = 20;
// 										window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
// 							            window.parent.ACT_DEAL_WINDOW.close();
									}else{
										alert("删除失败，请联系管理员。");
										history.go(0) ;
									}
								},  //处理完成 
    		resetForm: false,  
    		dataType:  'json'  
    };  
//      	alert(options);
//		    $('#myForm').submit(function() { //注意这里的index_form    
//		    	alert(5);
	    	$('#myForm').ajaxSubmit(options); 
//		    	alert(5.5);
	    	return false;
	}
}
//高拍仪方法
function exit2(){
	var id=$('#id').val();
// 	alert(id);
	location.href="<%=path%>/sbgl/YSbXx/gyyOnUse?id="+id;
}
    	
//返回
function exit(){
	/* var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
}

//保存
$(function(){
//		alert(1);
//		alert(2);
	$("#myForm").validate({
		submitHandler: function() {
//				alert(3);
        msg = "确定要提交？";
        if (confirm(msg)) {
//         	alert(4);
        	var options = { 
     		        url:'<%=path%>/sbgl/YSbXx/save',
            		        //beforeSubmit:  showRequest,  //提交前处理 
            		success: function(data) {
       									if(data=='1'){
       										alert('保存成功！'); 
       										var PAGESIZE = 20;
       										window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
       							            window.parent.ACT_DEAL_WINDOW.close();
       									}else{
       										alert("保存失败，请联系管理员。");
       										history.go(0) ;
       									}
       								},  //处理完成 
            		resetForm: true,  
            		dataType:  'json'  
            };  
//	          	alert(options);
//	   		    $('#myForm').submit(function() { //注意这里的index_form    
//	   		    	alert(5);
   		    	$('#myForm').ajaxSubmit(options); 
//	   		    	alert(5.5);
   		    	return false;//防止dialog 自动关闭     
//	   		    });
//	   		 alert(6);
		}
		} 
});
 });
 

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
label.error{
    color: red!important;
}
</style>
</html>

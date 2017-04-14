<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
</head>
<body>
	<div class="wrapper">
	<div class="panel" style="margin-bottom: 1px;">
		<div class="panel-body">
			<div style="text-align:center;margin-bottom:-2px"></div>
                <form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
                <c:forEach var="sbxx" items="${sbxx}" varStatus="obj">
                    <input type="hidden" name="id" id="id" value="${sbxx.id }">
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;margin-top: 4px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">检定周期：</label>
						<div class="col-sm-10">
							<c:if test="${sbxx.jyzq != null}">
							<select id="selectedRoleId" class="form-control" name="jyzq" disabled="true">
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
                           <select class="form-control input-lg m-bot15" name="jyzq" style="padding-left: 2px;" disabled="true" >
								<option selected="selected" value=""></option>
								<c:forEach var="jyzq" items="${jyzq}" varStatus="obj">
										<option value="${jyzq.zdz }">${jyzq.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">上次检定日期：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" value="${sbxx.xcjdrq }" name="scjdrq" readonly="true" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
						</div>
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>下次检定日期：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate"  name="xcjdrq" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
						</div>
					</div>
					
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;margin-top: -1px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">设备编号：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sbbh" name="sbbh" disabled="true" value="${sbxx.sbbh }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">设备名称：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sbmc" name="sbmc" disabled="true" value="${sbxx.sbmc }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">出厂编号：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="ccbh" name="ccbh" disabled="true" value="${sbxx.ccbh }">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">生产厂家：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sccj" name="sccj" disabled="true" value="${sbxx.sccj }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">厂家联系人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="cjlxr" name="cjlxr" disabled="true" value="${sbxx.cjlxr }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">厂家电话：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" onkeyup="value=value.replace(/[^\d]/g,'') "   
                                   onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"   
                             id="cjdh" name="cjdh" disabled="true" value="${sbxx.cjdh }"> 
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 0px;margin-bottom: 0px; padding-top: 2px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">厂家地址：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="cjdz" name="cjdz" disabled="true" value="${sbxx.cjdz }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">启用日期：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="qysj" name="qysj" value="${sbxx.qysj }" disabled="true" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
							 onkeyup="value=value.replace(/[^\d]/g,'') "   
                                   onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" >
						</div>
						<label class="col-sm-2 col-sm-2 control-label">放置地点：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="fzdd" name="fzdd" disabled="true" value="${sbxx.fzdd }">
						</div>
				    </div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
					    <label class="col-sm-2 col-sm-2 control-label">设备状态：</label>
						<div class="col-sm-10">
							<c:if test="${sbxx.sbzt != null}">
							<select id="selectedRoleId" class="form-control" name="sbzt" disabled="true" >
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
                           <select class="form-control input-lg m-bot15" name="sbzt" style="padding-left: 2px;" disabled="true" >
								<option selected="selected" value=""></option>
								<c:forEach var="sbzt" items="${sbzt}" varStatus="obj">
										<option value="${sbzt.zdz }">${sbzt.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">规格型号：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sbxh" name="sbxh" disabled="true" value="${sbxx.sbxh }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">计量单位：</label>
						<div class="col-sm-10">
							<c:if test="${sbxx.dw != null}">
							<select id="selectedRoleId" class="form-control" name="dw" disabled="true" >
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
                           <select class="form-control input-lg m-bot15" name="dw" style="padding-left: 2px;" disabled="true" >
								<option selected="selected" value=""></option>
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
							<input class="form-control" type="text" id="gmjg" name="gmjg" disabled="true" value="${sbxx.gmjg }"
							onkeyup="value=value.replace(/[^\d]/g,'') "   
                            onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">测量范围（准确度/不确定度）：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="clfw" name="clfw" disabled="true" value="${sbxx.clfw }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">配件信息：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="pjxx" name="pjxx" disabled="true" value="${sbxx.pjxx }">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">保管人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sbwhr" name="sbwhr" disabled="true" value="${sbxx.sbwhr }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">购买日期：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="gmrq" name="gmrq" value="${sbxx.gmrq }" disabled="true" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
							onkeyup="value=value.replace(/[^\d]/g,'') "   
                            onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">操作人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sbczr" name="sbczr" disabled="true" value="${sbxx.sbczr }">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">是否有操作规程：</label>
						<div class="col-sm-10">
							<c:if test="${sbxx.sfyczgc != null}">
							<select id="selectedRoleId" class="form-control" name="sfyczgc"  disabled="true">
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
                           <select class="form-control input-lg m-bot15" name="sfyczgc" style="padding-left: 2px;" disabled="true" >
								<option selected="selected" value=""></option>
								<c:forEach var="sfyczgc" items="${sfyczgc}" varStatus="obj">
										<option value="${sfyczgc.zdz }">${sfyczgc.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">是否有使用记录：</label>
						<div class="col-sm-10">
							<c:if test="${sbxx.sfysyjl != null}">
							<select id="selectedRoleId" class="form-control" name="sfysyjl" disabled="true">
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
                           <select class="form-control input-lg m-bot15" name="sfysyjl" style="padding-left: 2px;" disabled="true" >
								<option selected="selected" value=""></option>
								<c:forEach var="sfysyjl" items="${sfysyjl}" varStatus="obj">
										<option value="${sfysyjl.zdz }">${sfysyjl.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">是否有期间核查：</label>
						<div class="col-sm-10">
							<c:if test="${sbxx.sfyqjhc != null}">
							<select id="selectedRoleId" class="form-control" name="sfyqjhc" disabled="true" >
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
                           <select class="form-control input-lg m-bot15" name="sfyqjhc" style="padding-left: 2px;" disabled="true" >
								<option selected="selected" value=""></option>
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
							<select id="selectedRoleId" class="form-control" name="sfygnjc" disabled="true" >
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
                           <select class="form-control input-lg m-bot15" name="sfygnjc" style="padding-left: 2px;" disabled="true" >
								<option selected="selected" value=""></option>
								<c:forEach var="sfygnjc" items="${sfygnjc}" varStatus="obj">
										<option value="${sfygnjc.zdz }">${sfygnjc.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">使用科室：</label>
						<div class="col-sm-10">
							<c:if test="${sbxx.syks != null}">
						    <select id="selectedRoleId" class="form-control"  name="syks" disabled="true">
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
						    <select class="form-control input-lg m-bot15" name="syks" style="padding-left: 2px;" disabled="true" >
								<option selected="selected" value=""></option>
					        </select>
						</c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">使用状态：</label>
						<div class="col-sm-10">
							<c:if test="${sbxx.syzt != null}">
							<select id="selectedRoleId" class="form-control" name="syzt" disabled="true">
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
                           <select class="form-control input-lg m-bot15" name="syzt" style="padding-left: 2px;" disabled="true">
								<option selected="selected" value=""></option>
								<c:forEach var="syzt" items="${syzt}" varStatus="obj">
										<option value="${syzt.zdz }">${syzt.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
					    
					    <label class="col-sm-2 col-sm-2 control-label">操作规程：</label>
                        <div class="col-sm-10">
                               <input class="form-control" type="text" id="czgc" name="czgc" disabled="true" value="${sbxx.czgc }" >
						</div>
						<label class="col-sm-2 col-sm-2 control-label">使用说明书：</label>
                        <div class="col-sm-10">
                                <input class="form-control" type="text" id="sysms" name="sysms" disabled="true" value="${sbxx.sysms }">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
					    <label class="col-sm-2 col-sm-2 control-label">使用说明书附件：</label>
                        <div class="col-sm-10">
                               <input class="form-control" type="text" id="sysmffj" name="sysmffj" disabled="true" value="${sbxx.sysmffj }">
						</div>
					    <label class="col-sm-2 col-sm-2 control-label">设备照片：</label>
                        <div class="col-sm-10">
                               <input class="form-control" type="text" id="sbzp" name="sbzp" disabled="true" value="${sbxx.sbzp }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">功能检查方法：</label>
                        <div class="col-sm-10">
                               <input class="form-control" type="text" id="gnjcff" name="gnjcff" disabled="true" value="${sbxx.gnjcff }">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
					    <label class="col-sm-2 col-sm-2 control-label">期间核查方法：</label>
                        <div class="col-sm-10">
                                <input class="form-control" type="text" id="qjhcff" name="qjhcff" disabled="true" value="${sbxx.qjhcff }">
						</div>
					    <label class="col-sm-2 col-sm-2 control-label">标准度等级不确定度：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="bzddj" name="bzddj" disabled="true" value="${sbxx.bzddj }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">计量情况：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="jlqk" name="jlqk" disabled="true" value="${sbxx.jlqk }">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">检定单位：</label>
						<div class="col-sm-10">
							<c:if test="${sbxx.jddw != null}">
							<select id="selectedRoleId" class="form-control" name="jddw" disabled="true">
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
                           <select class="form-control input-lg m-bot15" name="jddw" style="padding-left: 2px;" disabled="true">
								<option selected="selected" value=""></option>
								<c:forEach var="jddw" items="${jddw}" varStatus="obj">
										<option value="${jddw.zdz }">${jddw.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
						
						<label class="col-sm-2 col-sm-2 control-label">计量结果：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="jljg" name="jljg" disabled="true" value="${sbxx.jljg }">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
					    <label class="col-sm-2 col-sm-2 control-label">检定费用（元）：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="jdfy" name="jdfy" disabled="true" value="${sbxx.jdfy }"
							onkeyup="value=value.replace(/[^\d]/g,'') "   
                            onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">仪器状况：</label>
						<div class="col-sm-10">
							<c:if test="${sbxx.yqzk != null}">
							<select id="selectedRoleId" class="form-control" name="yqzk" disabled="true" >
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
                           <select class="form-control input-lg m-bot15" name="yqzk" style="padding-left: 2px;" disabled="true">
								<option selected="selected" value=""></option>
								<c:forEach var="yqzk" items="${yqzk}" varStatus="obj">
										<option value="${yqzk.zdz }">${yqzk.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
					    <label class="col-sm-2 col-sm-2 control-label" >设备精度：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sbjb" name="sbjb" disabled="true" value="${sbxx.sbjb}">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top:0px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">其他附件：</label>
                        <div class="col-sm-10">
                              <input class="form-control" type="text" id="sbfj" name="sbfj" disabled="true" value="${sbxx.sbfj }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">使用参数：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="syfw" name="syfw" disabled="true" value="${sbxx.syfw }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">登记日期：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="ccrq" name="ccrq" value="${sbxx.ccrq }" disabled="true" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
							onkeyup="value=value.replace(/[^\d]/g,'') "   
                            onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="6" name="bz" disabled="true"
							truetype="textarea" style="width: 99%;height: 30px;">${sbxx.bz }</textarea>
						</div>
					</div>
					</c:forEach>
					<div style="text-align: center">
						<div class="form-group" style="margin-top: 2px;">
							<button type="button" class="btn btn-primary"
								onClick="save()">提交</button>
							<button type="button" class="btn btn-success"
								onClick="exit();">返回</button>
						</div>
				    </div>
				</form>
		  </div>
	   </div>
    </div>
</body>
<script>
//返回
function exit(){
	/* var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
}

//提交
function save() {
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/sbgl/YSbXx/jding";
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : $('#myForm').serialize(),// 你的formid
			async : false,
			error : function(request) {
				alert("检定失败,请联系管理员。");
			},
			success : function(data) {
				alert('检定成功！');
				var PAGESIZE = 20;
				window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	            window.parent.ACT_DEAL_WINDOW.close();
			}
		});
	}
} 
</script>
</html>

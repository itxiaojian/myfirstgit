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
<body>
	<div class="wrapper">
		<div class="panel" style="margin-bottom: 1px;">
			<div class="panel-body">
				<div style="text-align: center; margin-bottom: -2px"></div>
				<form class="form-horizontal tasi-form" name="myForm" id="myForm"
					method="post">
					<c:forEach var="sbjdjl" items="${sbjdjl}" varStatus="obj">
						<input type="hidden" name="id" id="id" value="${sbjdjl.id }">
						<div class="panel-body">
							<label class="col-sm-2 col-sm-2 control-label">设备编号：</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="sbbh" name="sbbh"
									disabled="true" value="${sbjdjl.sbbh }">
							</div>
							<label class="col-sm-2 col-sm-2 control-label">设备名称：</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="sbmc" name="sbmc"
									disabled="true" value="${sbjdjl.sbmc }">
							</div>
						</div>

						<div class="panel-body">
							<label class="col-sm-2 col-sm-2 control-label">设备条形码：</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="sbtxm" name="sbtxm"
									disabled="true" value="${sbjdjl.sbtxm }">
							</div>
							<label class="col-sm-2 col-sm-2 control-label">检验开始时间：</label>
							<div class="col-sm-10">
								<input class="form-control Wdate" type="text" id="sysj"
									name="sysj" disabled="true" value="${sbjdjl.sysj }"
									onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
							</div>
						</div>

						<div class="panel-body">
							<label class="col-sm-2 col-sm-2 control-label">检定单位：</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="jddw" name="jddw"
									disabled="true" value="${sbjdjl.jddw }">
							</div>
							<label class="col-sm-2 col-sm-2 control-label">检定状态：</label>
							<div class="col-sm-10">
								<c:if test="${sbjdjl.jdzt != null}">
							<select id="selectedRoleId" class="form-control" name="jdzt" disabled="true" >
                            <c:forEach items="${jdzt}" var="jdzt">
                                <c:choose>
                                         <c:when test="${jdzt.zdz == sbjdjl.jdzt}">
                                               <option selected = "selected" value="${jdzt.zdz}">${jdzt.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${jdzt.zdz}">${jdzt.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${sbjdjl.jdzt == null}">
                           <select class="form-control input-lg m-bot15" name="jdzt" style="padding-left: 2px;" disabled="true" >
								<option selected="selected" value=""></option>
								<c:forEach var="jdzt" items="${jdzt}" varStatus="obj">
										<option value="${jdzt.zdz }">${jdzt.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
							</div>

						</div>

						<div class="panel-body">
							<label class="col-sm-2 col-sm-2 control-label">检定结果：</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="jdjg" name="jdjg"
									disabled="true" value="${sbjdjl.jdjg }">
							</div>
							<label class="col-sm-2 col-sm-2 control-label">检定结论：</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="jdjl" name="jdjl"
									disabled="true" value="${sbjdjl.jdjl }">
							</div>
						</div>
						<div class="panel-body">
							<label class="col-sm-2 col-sm-2 control-label">检定费用：</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="jdfy" name="jdfy"
									disabled="true" value="${sbjdjl.jdfy }">
							</div>
							<label class="col-sm-2 col-sm-2 control-label">检定人：</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="jdr" name="jdr"
									disabled="true" value="${sbjdjl.jdr }">
							</div>
						</div>
					<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">备注：</label>
				<div class="col-sm-10">
					<textarea class="form-control"  disabled="true" truetype="textarea" id="bz" name="bz" rows="3" style="width:280%; height:120px;"></textarea>
				</div>
			</div>
						<div style="text-align: center" >
							<div class="form-group" style="margin-left:-209px;margin-top: 30px;">
								<button type="button" class="btn btn-success" onClick="exit();">返回</button>
							</div>
						</div>
					</c:forEach>
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

</script>
</html>
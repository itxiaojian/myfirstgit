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
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
</head>
<script>

//退出
function exit(){
	/* var PAGESIZE = 10;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close(); 
}
<% int s = 0; %>
</script>
<body >
<div class="wrapper" >
	<div class="panel" style="margin-bottom: 1px;">
		<div class="panel-body">
		<div style="text-align:center;margin-bottom:10px"></div>
		<form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post" >
			<c:forEach var="bgsf" items="${bgsf}" varStatus="obj">
			<input type="hidden" name="id" id="id" value="${bgsf.id }">
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: -6px; width: 101%;">
				<label class="col-sm-2 col-sm-2 control-label">报告编号：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="bgbh" name="bgbh" disabled="true" value="${bgsf.bgbh }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">样品名称：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ypmc" name="ypmc" disabled="true" value="${bgsf.ypmc }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">受检单位：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="sjdw" name="sjdw" disabled="true" value="${bgsf.sjdw }">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: -6px; width: 101%;">
				<label class="col-sm-2 col-sm-2 control-label">检验科室：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ks_id" name="ks_id" disabled="true" value="${bgsf.ks_id }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">业务科室：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ssywks" name="ssywks" disabled="true" value="${bgsf.ssywks }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">登记日期：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="jyjsrq" name="jyjsrq" value="${bgsf.jyjsrq }" disabled="true" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
							onkeyup="value=value.replace(/[^\d]/g,'') "   
                            onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
						</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: -6px; width: 101%;">
				<label class="col-sm-2 col-sm-2 control-label">收费状态：</label>
					<div class="col-sm-10">
						  <c:if test="${bgsf.ysje != 0 && bgsf.ysfje == bgsf.ysje && bgsf.jyfy > 0}">
						  <input class="form-control" type="text" id="sfzt" name="sfzt" disabled="true" value="已收费">
						  </c:if>
						  <c:if test="${bgsf.ysje == 0 || bgsf.ysfje < bgsf.ysje}">
						  <input class="form-control" type="text" id="sfzt" name="sfzt" disabled="true" value="待收费">
						  </c:if>
						  <c:if test="${bgsf.jyfy < 0 }">
						  <input class="form-control" type="text" id="sfzt" name="sfzt" disabled="true" value="退费记录">
						  </c:if>
					</div>
				<label class="col-sm-2 col-sm-2 control-label">检验费用（元）：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" id="jyfy" name="jyfy" disabled="true" value="${bgsf.jyfy }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">修改收费金额（元）：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" id="xgje" name="xgje" disabled="true" value="${bgsf.xgje}">
				</div>
			</div>	
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: -6px; width: 101%;">
			     <label class="col-sm-2 col-sm-2 control-label">应收金额（元）：</label>
				<div class="input-group m-bot15 col-sm-10">
				<c:if test="${bgsf.ysje!=0}">
				<input class="form-control" type="text" id="ysje" name="ysje" readonly="true" value="${bgsf.ysje}">
				</c:if>
			    <c:if test="${bgsf.ysje == 0}">
			    <input class="form-control" type="text" id="ysje" name="ysje" readonly="true" value="待定，请点击收费后填写修改金额">
			    </c:if>  
				</div>
				<label class="col-sm-2 col-sm-2 control-label">已收金额（元）：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ysfje" name="ysfje" disabled="true" value="${bgsf.ysfje}">
				</div>
			</div>	
			<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="6" name="bz" disabled="true" 
							truetype="textarea" style="width: 99%;height: 33px;">${bgsf.bz }</textarea>
						</div>
					</div>
			</c:forEach>
			<header class="panel-heading" style="padding-left: 58px;font-size: 11px; font-weight: 0;">检验项目及收费明细：</header>
			<div style="position: relative; top: -44px;" align="center">
			<p></p>
			<table class="table1 table-striped table-hover table-bordered" id="editable-sample">
					<thead style="height: 30px;">
						<tr class="">
							<td align="center"><b>序号</b></td>
							<td align="center"><b>收费项目编号</b></td>
							<td align="center"><b>收费项目名称</b></td>
							<td align="center"><b>计量单位</b></td>
							<td align="center"><b>金额（元）</b></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sfxm" items="${sfxm}" varStatus="obj">
						<tr class="" style="height:30px;">
						    <% s++; %>
							<td align="center"><%=s %></td>
							<td align="center">${sfxm.xmbh }</td>
							<td align="center">${sfxm.xmmc }</td>
							<td align="center">${sfxm.jldw }</td>
							<td align="center">
							 <c:if test="${sfxm.xgje != null }">${sfxm.xgje}</c:if>
							 <c:if test="${sfxm.xgje == null }">${sfxm.je}</c:if>
							</td>
<%-- 							<td align="center">${sfxm.xgje }</td> --%>
<%-- 							<td align="center"><a class="edit" href="javascript:void(0);"onClick="save('${getsbxx.id }');">详情</a></td> --%>
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
.panel-heading {
	padding-left: 58px;
	font-size: 11px; 
	font-weight: 0;

}
</style>
</html>
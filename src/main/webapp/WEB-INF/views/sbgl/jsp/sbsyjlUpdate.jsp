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
                <c:forEach var="sbsyjl" items="${sbsyjl}" varStatus="obj">
                    <input type="hidden" name="id" id="id" value="${sbsyjl.id }">
					<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label" >设备编号：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sbbh" name="sbbh" value="${sbsyjl.sbbh }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">设备名称：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sbmc" name="sbmc" value="${sbsyjl.sbmc }">
						</div>
					</div>
					
					<div class="panel-body">
					    <label class="col-sm-2 col-sm-2 control-label" >设备条形码：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sbtxm" name="sbtxm" value="${sbsyjl.sbtxm }">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">检验报告编号：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="bgbh" name="bgbh" value="${sbsyjl.bgbh }">
						</div>
					</div>
					
					<div class="panel-body">
					    <label class="col-sm-2 col-sm-2 control-label" >使用状态：</label>
						<div class="col-sm-10">
						    <c:if test="${sbsyjl.syzt != null}">
							<select id="selectedRoleId" class="form-control" name="syzt" >
                            <c:forEach items="${syzt}" var="syzt">
                                <c:choose>
                                         <c:when test="${syzt.zdz == sbsyjl.syzt}">
                                               <option selected = "selected" value="${syzt.zdz}">${syzt.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${syzt.zdz}">${syzt.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${sbsyjl.syzt == null}">
                           <select class="form-control input-lg m-bot15" name="syzt" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="syzt" items="${syzt}" varStatus="obj">
										<option value="${syzt.zdz }">${syzt.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">使用时间：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="sysj" name="sysj" value="${sbsyjl.sysj }" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
						</div>
					</div>
					
					<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label" >设备附件：</label>
						<div class="col-sm-13">
							<div enctype="multipart/form-data" method="post" action="file?file=upload">
                                <div class="file-container-main" style="width: 188px;">
                                   <div class="file-container" style="width: 188px;">
                                   <table cellspacing="0" cellpadding="0" style="border-style:none;position:absolute;z-index:10;">
                                   <tbody>
                                         <tr>
                                            <td class="ali01" style="border-style:none;padding:0;margin:0;">
                                                <input class="textinput" type="text" style="width: 128px;">
                                            </td>
                                            <td class="ali01" style="border-style:none;;padding:0;margin:0;">
                                                <input class="fileBtn" type="button" value="">
                                            </td>
                                         </tr>
                                   </tbody>
                                   </table>
                                   <input class="fileComponent" type="file" style="width: 97%; height: 35px; position: absolute; z-index: 20;
                                    font-size: 118px; opacity: 0; left: 192px; top: 0px;" siez="16" name="fj" value="${sbsyjl.fj }" truetype="file">
                                   </div>
                                 </div>
                                       <br>
                           </div>
                       </div>
					</div>
					
					<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label" >备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="6" name="bz"    
							truetype="textarea" style="width:60%;">${sbsyjl.bz }</textarea>
						</div>
					</div>
									<div style="text-align: center">
						<div class="form-group"  style="margin-top: 30px; margin-left: -251px;">
							<button type="button" class="btn btn-success"
								onClick="save()">提交</button>
							<button type="button" class="btn btn-success"
								onClick="exit();">返回</button>
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

//提交
function save() {
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/sbgl/YsbSyjl/update";
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
</script>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
//提交
function save() {
	msg="确定提交修改？";
	if (confirm(msg)) {
		var url = "<%=path%>/cwgl/YcwBgsf/jlUpdate";
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : $('#myForm').serialize(),// 你的formid
			async : false,
			error : function(request) {
				alert("修改失败,请联系管理员。");
			},
			success : function(data) {
				alert('修改成功！');
				var PAGESIZE = 20;
				window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	            window.parent.ACT_DEAL_WINDOW.close();
			}
		});
	}
}
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
				<label class="col-sm-2 col-sm-2 control-label">委托部门：</label>
				<div class="col-sm-10">
					<c:choose>
						  <c:when test="${bgsf.wtbm != null}">
						  <input class="form-control" type="text" id="wtbm" name="wtbm" disabled="true" value="${bgsf.wtbm }">
						  </c:when>
						  <c:otherwise>
						  <input class="form-control" type="text" id="wtbm" name="wtbm" disabled="true" value="无">
						  </c:otherwise>
					   </c:choose>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">承检科室：</label>
				<div class="col-sm-10">
					<c:choose>
						  <c:when test="${bgsf.cjbm != null}">
						  <input class="form-control" type="text" id="cjbm" name="cjbm" disabled="true" value="${bgsf.cjbm }">
						  </c:when>
						  <c:otherwise>
						  <input class="form-control" type="text" id="cjbm" name="cjbm" disabled="true" value="无">
						  </c:otherwise>
					   </c:choose>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">承检金额（元）：</label>
				<div class="col-sm-10">
						  <c:if test="${bgsf.cjbm != null && bgsf.cjfy != null}">
						  <input class="form-control" type="text" id="cjfy" name="cjfy" disabled="true" value="${bgsf.cjfy}">
						  </c:if>
						  <c:if test="${bgsf.cjbm != null && bgsf.cjfy == null}">
						  <input class="form-control" type="text" id="cjfy" name="cjfy" disabled="true" value="暂无">
						  </c:if>
						  <c:if test="${bgsf.cjbm == null}">
						  <input class="form-control" type="text" id="cjfy" name="cjfy" disabled="true" value="无">
						  </c:if>
				</div>
			</div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: -6px; width: 101%;">
				<label class="col-sm-2 col-sm-2 control-label">收费状态：</label>
					<div class="col-sm-10">
						  <c:if test="${ bgsf.ysfje == bgsf.jyfy && bgsf.jyfy > 0 && bgsf.xgje == -1}">
						  <input class="form-control" type="text" id="sfzt" name="sfzt" disabled="true" value="已收费">
						  </c:if>
						  <c:if test="${bgsf.ysfje > 0 && bgsf.ysfje < bgsf.jyfy}">
						  <input class="form-control" type="text" id="sfzt" name="sfzt" disabled="true" value="收费中">
						  </c:if>
						  <c:if test="${bgsf.ysfje < 0 && bgsf.ysfje < bgsf.jyfy && bgsf.xgje == -1}">
						  <input class="form-control" type="text" id="sfzt" name="sfzt" disabled="true" value="收费中">
						  </c:if>
						  <c:if test="${ bgsf.xgje == 1 && bgsf.ysfje == 0}">
						  <input class="form-control" type="text" id="sfzt" name="sfzt" disabled="true" value="待收费">
						  </c:if>
						  <c:if test="${ bgsf.ysfje < 0 }">
						  <input class="form-control" type="text" id="sfzt" name="sfzt" disabled="true" value="退费记录">
						  </c:if>
						  <c:if test="${ bgsf.xgje == 2 }">
						  <input class="form-control" type="text" id="sfzt" name="sfzt" disabled="true" value="已退费">
						  </c:if>
					</div>
				<label class="col-sm-2 col-sm-2 control-label">检验费用（元）：</label>
				<div class="input-group m-bot15 col-sm-10">
				   <c:if test="${ bgsf.jyfy < 0 }">
					<input class="form-control" type="text" id="jyfy" name="jyfy" disabled="true" value="${0-bgsf.jyfy}">
					</c:if>
					<c:if test="${ bgsf.jyfy > 0 }">
					<input class="form-control" type="text" id="jyfy" name="jyfy" disabled="true" value="${bgsf.jyfy}">
					</c:if>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">已收金额（元）：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ysfje" name="ysfje" disabled="true" value="${bgsf.ysfje}">
				</div>
			</div>	
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: -6px; width: 101%;">
			   <label class="col-sm-2 col-sm-2 control-label">剩缴金额（元）：</label>
				<div class="input-group m-bot15 col-sm-10">
<%-- 				<c:if test="${bgsf.ysje!=0}"> --%>
				<input class="form-control" type="text" id="ysje" name="ysje" readonly="true" value="${bgsf.ysje}">
<%-- 				</c:if> --%>
<%-- 			    <c:if test="${bgsf.ysje == 0}"> --%>
<!-- 			    <input class="form-control" type="text" id="ysje" name="ysje" readonly="true" value="待定，请点击收费后填写修改金额"> -->
<%-- 			    </c:if>   --%>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">收入分类：</label>
				<div class="col-sm-10">
<%-- 					<input class="form-control" type="text" id="srfl" name="srfl" disabled="true" value="${bgsf.srfl}"> --%>
				    <c:if test="${bgsf.srfl != null}">
							<select id="srfl" class="form-control" name="srfl">
                            <c:forEach items="${srfl}" var="srfl">
                                <c:choose>
                                         <c:when test="${srfl.zdz == bgsf.srfl}">
                                               <option selected = "selected" value="${srfl.zdz}">${srfl.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${srfl.zdz}">${srfl.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${bgsf.srfl == null}">
                           <select class="form-control input-lg m-bot15" name="srfl" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="srfl" items="${srfl}" varStatus="obj">
										<option value="${srfl.zdz }">${srfl.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">票据分类：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="pjfl" name="pjfl" disabled="true" value="${bgsf.pjfl}">
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
			<input style="border: #000" name="num" type="hidden" value="${num}">
			<label class="col-sm-2 col-sm-2 control-label">缴费记录：</label>
			<div style="position: relative; top: 2px;" align="left">
<!-- 			<table class="table1 table-striped table-hover table-bordered" id="editable-sample"> -->
			<table id="mytable" cellspacing="0" style="border:0px;table-layout: fixed;width:82%">
					<thead style="height: 30px;">
						<tr class="">
							<td align="center" scope="col" style="width: 5%;"><b>序&nbsp;&nbsp;号</b></td>
<!-- 							<td align="center"><b>报告编号</b></td> -->
<!-- 							<td align="center"><b>受检单位</b></td> -->
<!-- 							<td align="center"><b>所属科室</b></td> -->
							<td align="center" scope="col"><b>检验金额（元）</b></td>
<!-- 							<td align="center"><b>修改金额（元）</b></td> -->
							<td align="center" scope="col"><b>剩缴金额（元）</b></td>
							<td align="center" scope="col"><b>已收金额（元）</b></td>
							<td align="center" scope="col"><b>本次实收（元）</b></td>
							<td align="center" scope="col"><b>票据号码</b></td>
							<td align="center" scope="col" style="width: 8%;"><b>收&nbsp;费&nbsp;人</b></td>
							<td align="center" scope="col" style="width: 13%;"><b>收费日期</b></td>
							<td align="center" scope="col"><b>本次收费备注</b></td>
						</tr>
					</thead>
					<tbody >
						<c:forEach var="bgsfjl" items="${bgsfjl}" varStatus="obj">
						 <tr class="" style="height:30px;">
						    <% s++; %>
							<td align="center" class="row"><%=s %></td>
                            <c:if test="${bgsfjl.jyfy>0}">
                            <td align="center" class="row">${bgsfjl.jyfy}</td>
                            </c:if>
                            <c:if test="${bgsfjl.jyfy<0}">
                            <td align="center" class="row">${0-bgsfjl.jyfy}</td>
                            </c:if>
							<td align="center" class="row">${bgsfjl.ysfje}</td>
							<td align="center" class="row">${bgsfjl.ysje}</td>
							<td align="center" class="row">${bgsfjl.bcss}</td>
							<td align="center" class="row"><input style="border: #000" name="id<%=s%>" type="hidden" value="${bgsfjl.id}"><input style="border: #000" name="pjhm<%=s%>" value="${bgsfjl.pjhm}"></td>
							<td align="center" class="row">${bgsfjl.sfr}</td>
							<td align="center" class="row">${bgsfjl.jyjsrq}</td>
							<td style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;" align="center" class="row">${bgsfjl.bz}</td>
<%-- 						 </c:if> --%>
						 </tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			  <div style="text-align:center;margin-bottom:10px; margin-bottom: 10px;margin-top: 16px;">
							<input class="btn btn-success" value="提交" type="button" onclick="save();">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
body {   
font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;   
color: #4f6b72;   
background: #E6EAE9;   
}   
  
a {   
color: #c75f3e;   
}   
  
#mytable {   
width: 83%;   
padding: 0;   
margin: 0;   
}   
  
caption {   
padding: 0 0 5px 0;   
width: 700px;   
font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;   
text-align: right;   
}   
  
th {   
font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;   
color: #4f6b72;   
border-right: 1px solid #C1DAD7;   
border-bottom: 1px solid #C1DAD7;   
border-top: 1px solid #C1DAD7;   
letter-spacing: 2px;   
text-transform: uppercase;   
text-align: left;   
padding: 6px 6px 6px 12px;   
background: #CAE8EA  no-repeat;   
}   
  
th.nobg {   
border-top: 0;   
border-left: 0;   
border-right: 1px solid #C1DAD7;   
background: none;   
}   
  
td {   
border-right: 1px solid #C1DAD7;   
border-bottom: 1px solid #C1DAD7;   
background: #fff; 
white-space:nowrap;
overflow:hidden;  
font-size:11px;   
padding: 6px 6px 6px 12px;   
color: #4f6b72;   
}   
  
  
td.alt {   
background: #F5FAFA;   
color: #797268;   
}   
  
th.spec {   
border-left: 1px solid #C1DAD7;   
border-top: 0;   
background: #fff no-repeat;   
font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;   
}   
  
th.specalt {   
border-left: 1px solid #C1DAD7;   
border-top: 0;   
background: #f5fafa no-repeat;   
font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;   
color: #797268;   
}   
/*---------for IE 5.x bug*/   
html>body td{ font-size:11px;}   
body,td,th {      
font-size: 12px;   
}   
</style>
</html>
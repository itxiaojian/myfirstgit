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
//提交
function save() {
	msg="确定退费？";
	if (confirm(msg)) {
		var bcss = document.getElementById("bcss").value;
		var xyje = document.getElementById("xyje").value;
	    if( parseInt(bcss) > parseInt(xyje)){
	   	 alert('本次实收金额输入有误，请检查！');
	   	 return false;
	    }
		var url = "<%=path%>/cwgl/YcwJsfwxysf/tFei";
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : $('#myForm').serialize(),// 你的formid
			async : false,
			error : function(request) {
				alert("退费失败,请联系管理员。");
			},
			success : function(data) {
				alert('退费成功！');
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
			<c:forEach var="xysf" items="${xysf}" varStatus="obj">
			<input type="hidden" name="id" id="id" value="${xysf.id }">
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: -6px; width: 101%;">
				<label class="col-sm-2 col-sm-2 control-label">协议编号：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="xybh" name="xybh" disabled="true" value="${xysf.xybh }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">客户名称：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="khmc" name="khmc" disabled="true" value="${xysf.khmc }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">客户地址：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="khdz" name="khdz" disabled="true" value="${xysf.khdz }">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: -6px; width: 101%;">
				<label class="col-sm-2 col-sm-2 control-label">协议类型：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="xylx" name="xylx" disabled="true" value="${xysf.xylx }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">法人代表：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="frdb" name="frdb" disabled="true" value="${xysf.frdb }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">联系电话：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="lxdh" name="lxdh" disabled="true" value="${xysf.lxdh }">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: -6px; width: 101%;">
				<label class="col-sm-2 col-sm-2 control-label">涉及产品名称：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="cpmc" name="cpmc" disabled="true" value="${xysf.cpmc }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">服务项目：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="fwxm" name="fwxm" disabled="true" value="${xysf.fwxm }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">生效日期：</label>
				<div class="col-sm-10">
					<input class="form-control Wdate" type="text" id="sxrq" name="sxrq" value="${xysf.sxrq }" disabled="true" onClick="WdatePicker({dateFmt:'yy-mm-dd hh24:mi:ss'})">
				</div>
			</div>	
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: -6px; width: 101%;">
			    <label class="col-sm-2 col-sm-2 control-label">终止日期：</label>
					<div class="col-sm-10">
					  <input class="form-control Wdate" type="text" id="zzrq" name="zzrq" value="${xysf.zzrq }" disabled="true" onClick="WdatePicker({dateFmt:'yy-mm-dd hh24:mi:ss'})">
					</div>
				<label class="col-sm-2 col-sm-2 control-label">协议科室：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="xyks_id" name="xyks_id" disabled="true" value="${xysf.xyks_id}">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">执行标准：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="zxbz" name="zxbz" disabled="true" value="${xysf.zxbz}">
				</div>
			</div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: -6px; width: 101%;">
			    <label class="col-sm-2 col-sm-2 control-label">协议摘要：</label>
					<div class="col-sm-10">
					  <input class="form-control Wdate" type="text" id="xyzy" name="xyzy" value="${xysf.xyzy }" disabled="true" onClick="WdatePicker({dateFmt:'yy-mm-dd hh24:mi:ss'})">
					</div>
				<label class="col-sm-2 col-sm-2 control-label">所属科室：</label>
					<div class="col-sm-10">
					  <input class="form-control Wdate" type="text" id="ssks_id" name="ssks_id" value="${xysf.ssks_id }" disabled="true">
					</div>
				<label class="col-sm-2 col-sm-2 control-label">付款方式：</label>
				<div class="col-sm-10">
							<select id="selectedRoleId" class="form-control" name="fkfs" disabled="true">
                            <c:forEach items="${fkfs}" var="fkfs">
                                <c:choose>
                                         <c:when test="${fkfs.zdz == xysf.fkfs}">
                                               <option selected = "selected" value="${fkfs.zdz}">${fkfs.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${fkfs.zdz}">${fkfs.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
				</div>
			</div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: -6px; width: 101%;">
			    <label class="col-sm-2 col-sm-2 control-label">报告编号：</label>
					<div class="col-sm-10">
					  <input class="form-control Wdate" type="text" id="bgbh" name="bgbh" value="${xysf.bgbh }" disabled="true">
					</div>
				<label class="col-sm-2 col-sm-2 control-label">客户已获取证情况：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="qzqk" name="qzqk" disabled="true" value="${xysf.qzqk}">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">客户详细情况：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="xxqk" name="xxqk" disabled="true" value="${xysf.xxqk}">
				</div>
			</div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: -6px; width: 101%;">
			    <label class="col-sm-2 col-sm-2 control-label">协议负责人：</label>
					<div class="col-sm-10">
					  <input class="form-control Wdate" type="text" id="xyfzr" name="xyfzr" value="${xysf.xyfzr }" disabled="true">
					</div>
				<label class="col-sm-2 col-sm-2 control-label">检验科室：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="jyks_id" name="jyks_id" disabled="true" value="${xysf.jyks_id}">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">业务科室：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ywks_id" name="ywks_id" disabled="true" value="${xysf.ywks_id}">
				</div>
			</div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: -6px; width: 101%;">
				<label class="col-sm-2 col-sm-2 control-label">协议金额：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="xyje" name="xyje" disabled="true" value="${xysf.xyje}">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">应收金额：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ysje" name="ysje" readonly = "true" value="${xysf.ysje}">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">已收金额：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ysfje" name="ysfje" readonly = "true" value="${xysf.ysfje}">
				</div>
			</div>			
			<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">登记日期：</label>
						<div class="col-sm-10">
						  <input class="form-control Wdate" type="text" id="sfrq" name="sfrq" value="${xysf.sfrq }" disabled="true" onClick="WdatePicker({dateFmt:'yy-mm-dd hh24:mi:ss'})">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">票据分类：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="pjfl" name="pjfl" disabled="true" value="${xysf.pjfl}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">退费金额：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="bcss" name="bcss" value="${xysf.bcss}">
						</div>
			</div>
			<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">本次退费备注：</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="6" name="bz"  
							truetype="textarea" style="width: 99%;height: 33px;"></textarea>
						</div>
			</div>
			
			</c:forEach>
			<header class="panel-heading" style="padding-left: 58px;font-size: 11px; font-weight: 0;">缴退费记录：</header>
			<div style="position: relative; top: -44px;" align="center">
			<p></p>
			<table id="mytable" class="table1 table-striped table-hover table-bordered"  id="editable-sample"
			style="border:0px;table-layout: fixed;width:82%" >
					<thead style="height: 30px;">
						<tr class="">
							<td align="center"><b>序号</b></td>
							<td align="center"><b>协议编号</b></td>
							<td align="center"><b>客户名称</b></td>
							<td align="center"><b>所属科室</b></td>
							<td align="center"><b>应收金额</b></td>
							<td align="center"><b>已收金额</b></td>
							<td align="center"><b>本次实收</b></td>
							<td align="center"><b>票据号码</b></td>
							<td align="center"><b>缴费日期</b></td>
							<td align="center"><b>收费人</b></td>
							<td align="center"><b>本次收退费备注</b></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="xysfjl" items="${xysfjl}" varStatus="obj">
						<tr class="" style="height:30px;">
						    <% s++; %>
							<td align="center"><%=s %></td>
							<td align="center">${xysfjl.xybh}</td>
							<td align="center">${xysfjl.khmc}</td>
							<td align="center">${xysfjl.ssks_id}</td>
							<td align="center">${xysfjl.ysje}</td>
							<td align="center">${xysfjl.ysfje}</td>
							<td align="center">${xysfjl.bcss}</td>
							<td align="center">${xysfjl.pjhm}</td>
							<td align="center">${xysfjl.sfrq}</td>
							<td align="center">${xysfjl.sfr}</td>
							<td style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;" align="center">${xysfjl.bz}</td>
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
/* padding: 6px 6px 6px 12px;    */
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
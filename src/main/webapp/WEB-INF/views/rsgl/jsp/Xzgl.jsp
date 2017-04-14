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
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
</head>
<script>
function save() {
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/rsgl/YRsXzInfo/save";
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : $('#myForm').serialize(),// 你的formid
			async : false,
			/* error : function(request) {
				alert("保存失败,请联系管理员。");
			},
			success : function(data) {
				alert('保存成功！');
				var PAGESIZE = 10;
				window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	            window.parent.ACT_DEAL_WINDOW.close();
			} */
		});
		
		var url2 = "<%=path%>/rsgl/YRsXzinfoKc/insert";
		$.ajax({
			cache : true,
			type : "POST",
			url : url2,
			data : $('#myForm2').serialize(),// 你的formid
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

//增加新一行
var i = 1;
function addTr(){
	var num=i+1;
	var oTest = document.getElementById("mybody");
	var newNode = document.createElement("tr");
	newNode.setAttribute('id','mybody'+num);
	newNode.style.marginLeft="12%";
	newNode.innerHTML ="<tr><td><input class='form-control' type='hidden' name='rybh"+num+"' id='rybh"+num+"'></td>"
		+"<td><input class='form-control Wdate' type='hidden' id='yf"+num+"' name='yf"+num+
		"' onClick='WdatePicker({dateFmt:&quot;yyyy-MM&quot;})' readonly='true'></td>"
		+"<td><input class='form-control' type='text' name='qqkc"+num+"' id='qqkc"+num+"'style='padding-left: 0px; width: 74px;'></td>"
		+"<td><input class='form-control' type='text' name='ylbx"+num+"' id='ylbx"+num+"'style='padding-left: 0px; width: 74px;'></td>"
		+"<td><input class='form-control' type='text' name='yb"+num+"' id='yb"+num+"' style='padding-left: 0px; width: 74px;'></td>"
		+"<td><input class='form-control' type='text' name='sybx"+num+"' id='sybx"+num+"' style='padding-left: 0px; width: 74px;'></td>"
		+"<td><input class='form-control' type='text' name='sbxj"+num+"' id='sbxj"+num+"'style='padding-left: 0px; width: 74px;'></td>"
		+"<td><input class='form-control' type='text' name='zfgjj"+num+"' id='zfgjj"+num+"' style='padding-left: 0px; width: 74px;'></td>"
		+"<td><input class='form-control' type='text' name='gs"+num+"' id='gs"+num+"' style='padding-left: 0px; width: 74px;'></td>"
		+"<td><input class='form-control' type='text' name='kcxj"+num+"' id='kcxj"+num+"' style='padding-left: 0px; width: 74px;'></td>"
		+"<td><a href='javascript:;' onclick='deleteTr("+num+");'>"
		+"<span  style='text-align: right;' >"
		+"<img src='<%=path%>/resources/images/iconfont-shanchu.png' alt='删除' height='25px' width='25px' style='margin-bottom: 5px;'/>"
		+"</span></a></td>"
		+"</tr>"
	oTest.insertBefore(newNode,null);
	i++;
	document.getElementById("num").value=i; 
	//alert($('#num').val());
}

//删除行
function deleteTr(num){
	if(confirm("您确定要删除吗？")){
		if(num==i){
			var del = $("#mybody"+i);
			del.remove();
			i--;
			document.getElementById("num").value=i;
		}else{
			alert("请删除最新的一行！");
		}
	}
}

//退出
function exit(){
	/* var PAGESIZE = 10;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
}

</script>
<body >
<div class="wrapper">
	<div class="panel">
	<!-- <header class="panel-heading" style="padding-left: 650px;"> 成本信息</header> -->
		<div class="panel-body">
		<div style="text-align:center;margin-bottom:10px">
		</div>
		<form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
		<label class="col-sm-2 col-sm-2 control-label"></label>
		
		<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				<div class="col-sm-10">
					<input class="form-control" type="hidden" id="rybh" name="rybh"
					<c:if test="${rybh != null}">
								value="${rybh }"
					</c:if>
					>
				</div>
		</div>
		
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				
				<label class="col-sm-2 col-sm-2 control-label"style="margin-left:-31px;">人员姓名：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ryxm" name="ryxm" style="width:100%;">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">月份：</label>
				<div class="col-sm-10">
					<input class="form-control Wdate" type="text" id="yf" name="yf" 
					       onClick="WdatePicker({dateFmt:'yyyy-MM'})" readonly="true" style="width:100%;">       
				</div>
				
				<label class="col-sm-2 col-sm-2 control-label">实发工资：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" name="sfgz" style="width:70%;">
					<span class="input-group-addon"style="width:20%;">元</span>
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 0px;padding-left: 0px;">
				<label class="col-sm-2 col-sm-2 control-label" style="margin-left:-31px;">基本工资：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" name="jbgz" style="width:70%;">
					<span class="input-group-addon">元</span>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">绩效工资：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" name="jxgz" style="width:70%;">
					<span class="input-group-addon">元</span>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">加班费：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" name="jbf" style="width:70%;">
					<span class="input-group-addon">元</span>
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 0px;padding-left: 0px;">
				<label class="col-sm-2 col-sm-2 control-label" style="margin-left:-31px;">其他：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" name="qt" style="width:70%;">
					<span class="input-group-addon">元</span>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">午餐补助：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" name="wcbz" style="width:70%;">
					<span class="input-group-addon">元</span>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">应发工资：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" name="yfgz" style="width:70%;">
					<span class="input-group-addon">元</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 col-sm-2 control-label" style="margin-left:-31px;">备注:</label>
				<div class="col-sm-13">
					<textarea class="form-control ckeditor textarea" rows="4" name="bz" 
					truetype="textarea" style="width: 100%;"></textarea>
				</div>
			</div>
		</form>
		</div>
	</div>
	
	<div class="panel">
		<header class="panel-heading" style="padding-left: 0px; margin-left: 50%;"> 薪资扣除</header>
		<div class="panel-body" >
			<form class="form-horizontal tasi-form" name="myForm2" id="myForm2"  method="post" style="margin-left: 5%;">
			<input type="hidden" name="num" id="num" value="1">
			<div class="form-group" style="padding-bottom: 0px; padding-left: 0px; 
			     margin-left: 32px; margin-right: 0px; width: 1279px;">
				<table>
					<tr>
						<th  style="width: 1px;"></th>
						<th  style="width: 1px;"></th>
						<th style="padding-left: 0px; width: 6%;">缺勤扣除</th>
						<th style="padding-left: 0px; width: 6%;">养老保险</th>
						<th style="padding-left: 0px; width: 6%;">医保</th>
						<th style="padding-left: 0px; width: 6%;">失业保险</th>
						<th style="padding-left: 0px; width: 6%;">社保小计</th>
						<th style="padding-left: 0px; width: 6%;">住房公积金</th>
						<th style="padding-left: 0px; width: 6%;">个税</th>
						<th style="padding-left: 0px; width: 6%;">扣除小计</th>
						<th></th>
					</tr>
					<tbody id="mybody">
					<tr id="tr">
						<td><input class="form-control" type="hidden" name="rybh1" name="rybh1" <c:if test="${rybh != null}"> value="${rybh }"</c:if>></td>
						<td><input class="form-control Wdate" type="hidden" id="yf1" name="yf1" 
					       onClick="WdatePicker({dateFmt:'yyyy-MM'})" readonly="true"></td>
						<td><input class="form-control" type="text" name="qqkc1" name="qqkc1"></td>
						<td><input class="form-control" type="text" name="ylbx1" name="ylbx1"></td>
						<td><input class="form-control" type="text" name="yb1" name="yb1"></td>
						<td><input class="form-control" type="text" name="sybx1" name="sybx1"></td>
						<td><input class="form-control" type="text" name="sbxj1" name="sbxj1"></td>
						<td><input class="form-control" type="text" name="zfgjj1" name="zfgjj1"></td>
						<td><input class="form-control" type="text" name="gs1" name="gs1"></td>
						<td><input class="form-control" type="text" name="kcxj1" name="kcxj1"></td>
						<td><a href="javascript:;" onclick="deleteTr();">
								<span  style="text-align: right;" >
									<img src="<%=path%>/resources/images/iconfont-shanchu.png" alt="删除" height="25px" width="25px" style="margin-bottom: 5px;"/>
								</span>
							</a>
						</td>		
					</tr>
					</tbody>
				</table>
			</div>
			<div style="text-align:center;margin-bottom:10px">
				<input class="btn btn-success" id="btnAdd" value="新增" type="button" onclick="addTr();">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="btn btn-success" value="提交" type="button" onclick="save();">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="btn btn-success" value="关闭" type="button" onclick="exit();">
		    </div>
			</form>
		</div>
	</div>
</div>
</body>
</html>
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
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
</head>
<script>
function save() {
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/cwgl/YCwKssr/save";
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
		
		var url2 = "<%=path%>/cwgl/YCwKssrmx/insert";
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
				var PAGESIZE = 10;
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
	newNode.innerHTML ="<tr><td><input class='form-control' type='text' name='jybh"+num+"' id='jybh"+num+"'></td>"
		+"<td><input class='form-control' type='text' name='fymc"+num+"' id='fymc"+num+"'></td>"
		+"<td><input class='form-control' type='text' name='fylx"+num+"' id='fylx"+num+"'></td>"
		+"<td><input class='form-control' type='text' name='fynr"+num+"' id='fynr"+num+"'></td>"
		+"<td><input class='form-control' type='text' name='je"+num+"' id='je"+num+"'></td>"
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
	var PAGESIZE = 10;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
    window.parent.ACT_DEAL_WINDOW.close();
}

</script>
<body >
<div class="wrapper">
	<div class="panel">
	<!-- <header class="panel-heading" style="padding-left: 650px;"> 科室收入</header> -->
		<div class="panel-body">
		<div style="text-align:center;margin-bottom:10px">
		</div>
		<form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				<label class="col-sm-2 col-sm-2 control-label">科室编号:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ksbh" name="ksbh">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">科室名称：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ksmc" name="ksmc">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">检验编号:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="jybh" name="jybh">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				<label class="col-sm-2 col-sm-2 control-label">项目名称：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ypmc" name="ypmc">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">样品详情:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ypxq" name="ypxq">
				</div>
			    <label class="col-sm-2 col-sm-2 control-label">成本金额：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" name="cbje">
					<span class="input-group-addon">.00</span>
			    </div>
			</div>
			
			<div class="form-group" style="padding-bottom: 0px;padding-left: 0px;">
				<label class="col-sm-2 col-sm-2 control-label">收款金额：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" name="skje">
					<span class="input-group-addon">.00</span>
			    </div>
				<label class="col-sm-2 col-sm-2 control-label">核算收入：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" name="hssr">
					<span class="input-group-addon">.00</span>
			    </div>
				<label class="col-sm-2 col-sm-2 control-label">备注：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="bz" name="bz">
				</div>
			</div>
		</form>
		</div>
	</div>
	
	<div class="panel">
		<header class="panel-heading" style="padding-left: 650px;"> 收入明细</header>
		<div class="panel-body">
			<form class="form-horizontal tasi-form" name="myForm2" id="myForm2"  method="post">
			<input type="hidden" name="num" id="num" value="1">
			<div class="form-group">
				<table style="margin-left: 106px; width: 1198px; height: 76px;">
					<tbody id="mybody">
					<tr>
						<th style="text-align:center">检验编号</th>
						<th style="text-align:center">费用名称</th>
						<th style="text-align:center">费用类型</th>
						<th style="text-align:center">费用内容</th>
						<th style="text-align:center">金额</th>
						<th></th>
					</tr>
					<tr id="tr">
						<td><input class="form-control" type="text" name="jybh1" name="jybh1"></td>
						<td><input class="form-control" type="text" name="fymc1" name="fymc1"></td>
						<td><input class="form-control" type="text" name="fylx1" name="fylx1"></td>
						<td><input class="form-control" type="text" name="fynr1" name="fynr1"></td>
						<td><input class="form-control" type="text" name="je1" name="je1"></td>
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
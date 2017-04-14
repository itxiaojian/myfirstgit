<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
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
<script type="text/javascript" src="<%=path%>/resources/datePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css">
<script type="text/javascript" src="<%=path%>/resources/js/jquery.easyui.min.js"></script>

</head>
<script>
function load() {
	$('#ksbh').combotree({
		url: '<%=path%>/test/ssksList?optype=getchildtree',
        'onLoadSuccess': function (node, data) {
            //在panel控件load完成的时候处理当前显示值，如果不处理，则combotree1的显示值有可能会不正确
            if (data.length > 0) {
                var val = ""; //jsp页面初始化时combotree1的初始id值
                var txt = $('#ksbh').combotree('getText'); //combotree1当前的显示text值
                if (val != "" && val == txt) {
                    var urlstr = "<%=path%>/test/xlsList" + "?optype=gettext&id=" + val;
                    $.get(urlstr,
                            function (gettxt) {
                                if (gettxt != "")
                                    $('#ksbh').combotree('setText', gettxt);
                            }
                    );
                }
            }
        },
    });
	if(window.screen.width=='1024'){
		$('.combo').width('148px');
		$('.combo-text').width('148px');
	}else if(window.screen.width=='1280'){
		$('.combo').width('185px');
		$('.combo-text').width('185px');
	}else if(window.screen.width=='1360'){
		$('.combo').width('200px');
		$('.combo-text').width('200px');
	}else if(window.screen.width=='1440'){
		$('.combo').width('215px');
		$('.combo-text').width('215px');
	}else if(window.screen.width=='1600'){
		$('.combo').width('240px');
		$('.combo-text').width('240px');
	}else{
		$('.combo').width('148px');
		$('.combo-text').width('148px');
	}
}


function save() {
// 	if($("#jybh").val()==""){
// 		alert("请输入检验编号");
// 		return false;
// 	}
	$(".jybh1").val($("#jybh").val());
// 	$(".ksbh1").val($("#ksbh").val());
// 	var bcss = document.getElementById("ksbh").value;
// 	var bcss1 = document.getElementById("ksbh1").value;
// 	alert(bcss);
// 	alert(bcss1);
	msg="确定要提交？";
	if (confirm(msg)) {
<%-- 		var url = "<%=path%>/cbgl/YCwCbxx/save"; --%>
// 		$.ajax({
// 			cache : true,
// 			type : "POST",
// 			url : url,
// 			data : $('#myForm').serialize(),// 你的formid
// 			async : false,
			/* error : function(request) {
				alert("保存失败,请联系管理员。");
			},
			success : function(data) {
				alert('保存成功！');
				var PAGESIZE = 10;
				window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	            window.parent.ACT_DEAL_WINDOW.close();
			} */
// 		});
		
		var url2 = "<%=path%>/cwgl/YCwCbmx/insert";
		$.ajax({
			cache : true,
			type : "POST",
			url : url2,
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

//增加新一行
var i = 1;
function addTr(){
	var num=i+1;
	var oTest = document.getElementById("mybody");
	var newNode = document.createElement("tr");
	newNode.setAttribute('id','mybody'+num);
	newNode.style.marginLeft="12%";
	var ssyf = document.getElementById("fssj1").value;
	newNode.innerHTML ="<tr><td style='display:none'><input type='text' name='jybh"+num+"' class='jybh1'></td>"
		/* +"<td><input class='form-control' type='text' name='fylx"+num+"' id='fylx"+num+"'></td>" */
		+"<td style='width: 8%;'><input class='form-control Wdate' type='text' id='fssj"+num+"' name='fssj"+num
		+"' onClick='WdatePicker({dateFmt:&quot;yyyy-MM&quot;})'style='height: 21px;' value='"+ssyf+"'></td>"
		+"<td><select class='form-control input-lg m-bot15' name='fylx"+num+"' id='fylx"+num+"'>"
	    	+"<option selected='selected' value=''>请选择...</option>"
	        +"<c:forEach var='cblx' items='${cblx}' varStatus='obj'>"
	            +"<option value='${cblx.zdz }'>${cblx.zdmc }</option>"
	        +"</c:forEach>"
	        +"</select></td>"
	    +"<td><input class='form-control' type='text' name='pjbh"+num+"' id='pjbh"+num+"'></td>"
		+"<td><input class='form-control' type='text' name='xmmc"+num+"' id='xmmc"+num+"'></td>"
		+"<td><input class='form-control' type='text' name='fyxq"+num+"' id='fylx"+num+"'></td>"
		+"<td><input class='form-control je' type='text' name='je"+num+"' id='je"+num+"'"
		+" onBlur='getje()'onkeyup='value=value.replace(/[^\d.]/g,'')' placeholder='请输入金钱格式,可保留两位小数' "
		+" onbeforepaste='clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d.]/g,'')'></td>"
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

//动态获取已修改费用并onBlur事件后赋值给合计
function getje() {
	var cbhj=0;
    $(".je").each(function(){
    	var a = $(this).val();
//             alert($(this).val());
            if(a==null||a==""){
//             	alert(2);
            	a=0;
            }
            cbhj+=parseFloat(a);
            $("#cbhj").val(cbhj);
        });
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
	
	var cbhj=0;
    $(".je").each(function(){
    	var a = $(this).val();
//             alert($(this).val());
            if(a==null||a==""){
//             	alert(2);
            	a=0;
            }
            cbhj+=parseFloat(a);
            $("#cbhj").val(cbhj);
    });
}

//退出
function exit(){
	/* var PAGESIZE = 10;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close(); 
}

</script>
<body onload="load();">
<div class="wrapper">
	<div class="panel">
	<!-- <header class="panel-heading" style="padding-left: 650px;"> 成本信息</header> -->
		<div class="panel-body">
		<div style="text-align:center;margin-bottom:10px">
		</div>
		<form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post" 
		style="overflow-x:hidden">
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				<label class="col-sm-2 col-sm-2 control-label">科室名称:</label>
				<div class="col-sm-10" style="margin-top: 5px;">
                    <input id="ksbh" name="ksbh" class="easyui-combotree" value="" 
                    style="height: 34px;width: 238px;"/>
                </div>
				<label class="col-sm-2 col-sm-2 control-label">检验编号：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="jybh" name="jybh">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">项目名称:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ypmc" name="ypmc">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				<label class="col-sm-2 col-sm-2 control-label">项目详细内容：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="xxnr" name="xxnr">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">成本合计:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="cbhj" name="cbhj" readonly = "true">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">备注：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="bz" name="bz">
				</div>
			</div>
			<div class="panel">
		<header class="panel-heading" style="padding-left: 637px;"> 费用明细</header>
		<div class="panel-body">
<!-- 			<form class="form-horizontal tasi-form" name="myForm2" id="myForm2"  method="post"  -->
<!-- 			style="overflow-x:hidden"> -->
			<input type="hidden" name="num" id="num" value="1">
			<div class="form-group" style="padding-bottom: 0px; 
			     padding-left: 0px; margin-left: 41px; margin-right: 0px;">
				<table style="width: 1234px;">
					<tr>
						<th style="display:none">检验编号</th>
						<th style="padding-left: 20px;">所属月份</th>
						<th style="padding-left: 20px;">费用类型</th>
						<th style="padding-left: 75px;">票据编号</th>
						<th style="padding-left: 75px;">费用名称</th>
						<th style="padding-left: 75px;">费用内容</th>
						<th style="padding-left: 75px;">金额</th>
						<th></th>
					</tr>
					<tbody id="mybody">
					<tr id="tr">
						<td style="display: none" ><input type="text" class="jybh1" name="jybh1"></td>
						<% Date date = new Date();
 							     SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM");
 							     String enddate = edate.format(date);%>
						<td style="width: 8%;"><input class="form-control Wdate" type="text" id="fssj1" name="fssj1"
                           onClick="WdatePicker({dateFmt:'yyyy-MM'})" style="height: 21px;" value="<%=enddate%>"></td>
						<td><select class="form-control input-lg m-bot15" name="fylx1" id="fylx1">
                            	<option selected="selected" value="">请选择...</option>
                                <c:forEach var="cblx" items="${cblx}" varStatus="obj">
                                    <option value="${cblx.zdz }">${cblx.zdmc }</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><input class="form-control" type="text" id="pjbh1" name="pjbh1" ></td>
						<td><input class="form-control" type="text" id="xmmc1" name="xmmc1"></td>
						<td><input class="form-control" type="text" id="fyxq1" name="fyxq1" ></td>
						<td><input class="form-control je" type="text" id="je1" name="je1" onBlur="getje()" 
						onkeyup="value=value.replace(/[^\d.]/g,'') " placeholder="请输入金钱格式,可保留两位小数"
                        onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d.]/g,'')"></td>
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
		</div>
	</div>
		</form>
		</div>
	</div>
	
</div>
</body>
</html>
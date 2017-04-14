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
        'onChange': function (n, o) {
            $("#ks_id").val(n);
        }
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
 	/* if($("#fylx").val()==""){
 		alert("请输入检验编号");
 		return false;
 	} */
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
		
		var url2 = "<%=path%>/cbgl/YCwCbxx/update";
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
				alert('修改成功！');
				var PAGESIZE = 20;
				window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	            window.parent.ACT_DEAL_WINDOW.close();
			}
		});
	}

} 

//增加新一行
var num=${cbmxLen};
function addTr(){
	num++;
	var oTest = document.getElementById("mybody");
	var newNode = document.createElement("tr");
	newNode.setAttribute('id','ycmybody'+num);
	newNode.style.marginLeft="12%";
	var ssyf = document.getElementById("ycfssj").value;
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
		+" onBlur='getje()'onkeyup='value=value.replace(/[^\w\.\/]/ig,'')' placeholder='请输入金钱格式,可保留两位小数' "
		+" onbeforepaste='clipboardData.setData('text',clipboardData.getData('text').replace(/[^\w\.\/]/ig,''))'></td>"
		+"<td><a href='javascript:;' onclick='deleteTr("+num+");'>"
		+"<span  style='text-align: right;' >"
		+"<img src='<%=path%>/resources/images/iconfont-shanchu.png' alt='删除' height='25px' width='25px' style='margin-bottom: 5px;'/>"
		+"</span></a></td>"
		+"</tr>"
	oTest.insertBefore(newNode,null);
	document.getElementById("num").value = num;
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
	/* if(confirm("您确定要删除吗？")){
		if(num==i){
			var del = $("#mybody"+i);
			del.remove();
			i--;
			document.getElementById("num").value=i;
		}else{
			alert("请删除最新的一行！");
		}
	} */
	var del = $("#ycmybody"+num);
	del.remove();
	
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
			<c:forEach var="cbxx" items="${cbxx}" varStatus="obj">
			<input type="hidden" name="id" id="id" value="${cbxx.id }">
			<input type="hidden" name="cbbh" id="cbbh" value="${cbxx.cbbh }">
			<input type="hidden" id="ks_id" name="ks_id" value="${cbxx.ksbh }">
			<input class="form-control Wdate" type="hidden" id="fssj" name="fssj" value="${cbxx.fssj}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
			<% Date date = new Date();
 			   SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM");
 			   String enddate = edate.format(date);%>
			<input class="form-control Wdate" type="hidden" id="ycfssj" name="ycfssj"
                onClick="WdatePicker({dateFmt:'yyyy-MM'})" style="height: 21px;" value="<%=enddate%>">
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				<label class="col-sm-2 col-sm-2 control-label">科室名称:</label>
				<div class="col-sm-10" style="margin-top: 5px;">
                    <input id="ksbh" name="ksbh" class="easyui-combotree" style="height: 34px;width: 238px;" value="${cbxx.ksmc }"/>
                </div>
				<label class="col-sm-2 col-sm-2 control-label">检验编号：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="jybh" name="jybh" value="${cbxx.jybh }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">项目名称:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ypmc" name="ypmc" value="${cbxx.ypmc }">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				<label class="col-sm-2 col-sm-2 control-label">项目详细内容：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="xxnr" name="xxnr" value="${cbxx.xxnr }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">成本合计:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="cbhj" name="cbhj" readonly = "true" value="${cbxx.cbhj }"> 
				</div>
				<label class="col-sm-2 col-sm-2 control-label">修改原因：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="xgyy" name="xgyy" value="${cbxx.xgyy }">
				</div>
					<input class="form-control Wdate" type="hidden" id="lrrq" name="lrrq" 
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${cbxx.lrrq }">
			</div>
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				<input class="form-control" type="hidden" id="lrr" name="lrr" value="${cbxx.lrr }">
				
				<label class="col-sm-2 col-sm-2 control-label">备注：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="bz" name="bz" value="${cbxx.bz }">
				</div>
			</div>
			</c:forEach>
			
		<div class="panel">
		<header class="panel-heading" style="padding-left: 637px;"> 费用明细</header>
		<div class="panel-body">
<!-- 			<form class="form-horizontal tasi-form" name="myForm2" id="myForm2"  method="post"  -->
<!-- 			style="overflow-x:hidden"> -->
			<input type="hidden" name="num" id="num" value="${cbmxLen}">
			<div class="form-group" style="padding-bottom: 0px; 
			     padding-left: 0px; margin-left: 41px; margin-right: 0px;">
				<table style="width: 1234px;">
					<tr>
						<th style="padding-left: 20px;">所属月份</th>
						<th style="padding-left: 20px;">费用类型</th>
						<th style="padding-left: 75px;">票据编号</th>
						<th style="padding-left: 75px;">费用名称</th>
						<th style="padding-left: 75px;">费用内容</th>
						<th style="padding-left: 75px;">金额</th>
						<th></th>
					</tr>
					<tbody id="mybody">
						<tr id="tr" style="display: none" ><td></td></tr>
						<c:forEach var="cbmx" items="${cbmx}" varStatus="obj">
							<tr id="ycmybody${obj.count }">
								<td style="display: none" ><input type="text" class="jybh${obj.count }" name="jybh${obj.count }"></td>
						<% Date date = new Date();
 							     SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM");
 							     String enddate = edate.format(date);%>
						<td style="width: 8%;"><input class="form-control Wdate" type="text" id="fssj${obj.count }" name="fssj${obj.count }"
                           onClick="WdatePicker({dateFmt:'yyyy-MM'})" style="height: 21px;" value="${cbmx.fssj}"></td>
						<td><select class="form-control input-lg m-bot15" name="fylx${obj.count }" id="fylx${obj.count }">
                            	<option selected = "selected" value="">请选择...</option>
									<c:forEach items="${cblx}" var="cblx">
                           				<c:choose>
                               			<c:when test="${cblx.zdz == cbmx.fylx}">
                                     		<option selected = "selected" value="${cblx.zdz}">${cblx.zdmc}</option>
                               			</c:when>
                               			<c:otherwise>
                                     		<option value="${cblx.zdz}">${cblx.zdmc}</option>
                               			</c:otherwise>
                               			</c:choose>
		                           </c:forEach> 
                            </select>
                        </td>
                        <td><input class="form-control" type="text" id="pjbh${obj.count }" name="pjbh${obj.count }" value="${cbmx.pjbh}"></td>
						<td><input class="form-control" type="text" id="xmmc${obj.count }" name="xmmc${obj.count }" value="${cbmx.xmmc}"></td>
						<td><input class="form-control" type="text" id="fyxq${obj.count }" name="fyxq${obj.count }" value="${cbmx.fyxq}"></td>
						<td><input class="form-control je" type="text" id="je${obj.count }" name="je${obj.count }" onBlur="getje()" 
						onkeyup="value=value.replace(/[^\w\.\/]/ig,'') " placeholder="请输入金钱格式,可保留两位小数" 
						onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\w\.\/]/ig,''))"
						value="${cbmx.je}"></td>
						<td><a href="javascript:;" onclick="deleteTr('${obj.count }');">
									<span  style="text-align: right;" >
										<img src="<%=path%>/resources/images/iconfont-shanchu.png" alt="删除" height="25px" width="25px" style="margin-bottom: 5px;"/>
									</span>
							</a>
						</td>
							</tr>
						</c:forEach>
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
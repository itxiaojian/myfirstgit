<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
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
<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css">
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/upload.css">
<script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.qrcode.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery.validate.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/yz/yzstyle.css">
</head>

<script type="text/javascript">
//输入的时候回车可以跳到下一个输入域
$(function () {
    //回车代替tab
    $('input:text:first').focus();
    //如果有其他输入类型可以在此处加入
    var $target = $('input,button,select');
    $target.bind('keydown', function (e) {
        var key = e.which;
        if (key == 13) {
            e.preventDefault();
            var nxtIdx = $target.index(this) + 1;
            if ($target.eq(nxtIdx).attr("type") == "submit") {
                $target.eq(nxtIdx).click();
            } else {
                $target.eq(nxtIdx).focus();
            }
        }
    });
});

//提交
function save() {
	var khmc = document.getElementById("khmc").value;
	var bfry = document.getElementById("bfry").value;
    if( khmc ==null||khmc==''){
   	 alert('客户名称必填！');
   	 return false;
    }
    if( bfry ==null||bfry==''){
      	 alert('拜访人员必填！');
      	 return false;
       }
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/khgl/YKhHfxx/save";
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

//返回
function exit(){
	/* var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
}

//打开协议信息窗口
function getKh() {
		var del = $("#table");
	    del.remove();
		var khmccx = document.getElementById("khmccx").value;
	    var frxmcx = document.getElementById("frxmcx").value;
		var url = "<%=path%>/khgl/YKhKhxx/getKhxx";
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : {khmccx:khmccx,frxmcx:frxmcx},
			async : false,
			error : function(request) {
				alert("选择失败,请联系管理员。");
			},
			success : function(data) {
				var del = $("#table");
				del.remove();
	        	var str="<table><thead><tr><th>客户名称</th><th>法人姓名</th><th>手机号码</th><th>客户地址</th>"
					   +"<th>操作</th></tr></thead><tbody>";
	        	for(var i=0;i<data.length;i++){
	        		str=str+"<tr id='"+isNull(data[i].ID)+"'><td>"+isNull(data[i].KHMC)+"</td><td>"+isNull(data[i].FRXM)+"</td><td>"+isNull(data[i].SJHM)+"</td><td>"+isNull(data[i].KHDZ)+"</td><td><input type ='button' onClick='saveKhxx("+isNull(data[i].ID)+");' value='选择'></td>";
	        	} 
	        	str=str+"</tbody><table>";
	        	var oTest = document.getElementById("sectKhxx");
	    		var newNode = document.createElement("table");
	    		var befNode = document.getElementById("sbzKhxx");
	    		newNode.setAttribute('class','table');
	    		newNode.setAttribute('id','table');
	    		newNode.innerHTML =str;
	    		oTest.insertBefore(newNode,befNode);
			}
		});
		$("#khmccx").val("");
		$("#frxmcx").val("");
	}
	
//判断字段是否有值
function isNull(string){
	if(string==null||string=='null'){
		return '';
	}else{
		return string
	}
}
	
function saveKhxx(id) {
	 //msg = "确定选择？";
   //if (confirm(msg)) {
  	 var url = "<%=path%>/khgl/YKhKhxx/getJsfwglById";
   	 $.ajax({
   		cache : true,
   		type : "POST",
   		url : url,
   		data : {id:id},
   		async : false,
   		error : function(request) {
   			alert("选择失败,请联系管理员。");
   		},
   		success : function(data) {
   			khxx = data;
   			$("#khmc").val(data[0].KHMC);
   			$("#khbh").val(data[0].KHBH);
   			$("#khbh1").val(data[0].KHBH);
   			$("#frdb").val(data[0].FRXM);
   			$("#khdz").val(data[0].KHDZ);
   			$('#myModalKhxx').modal('hide');
   		}
   	  });
   //}
}
	
//关闭用户信息窗口
function closeKh() {
    $('#myModalKhxx').modal('hide');
    var del = $("#table");
    del.remove();
}



	</script>
<body>
		<div class="wrapper">
		<div class="panel">
		<header class="panel-heading" style=" padding-bottom: 0px;"><b style="font-size: 19px;margin-left: 40%;">客户回访拜访记录表</b></header>
		<header class="panel-heading" style="padding-top: 0px; padding-bottom: 0px;margin-top: 10px;margin-bottom: 8px;"><b style="font-size: 13px;margin-left: 38%;">客户编号:
		      <input style="border:none;width: 105px;padding-left: 15px;" disabled="true" id="khbh1">
		      <a class="btn btn-xs btn-success" href="#myModalKhxx" data-toggle="modal" type="button" onClick="getKh();" style="width:4%;margin-top: -2px;">请选择</a></b>
		</header>
			<form action="" class="form-horizontal tasi-form bl-form bl-formhor" name="myForm" id="myForm" method="post">
			<input type="hidden" name="khbh" id="khbh" value="${khbh}">
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
				<label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;"><span style="color:red">*</span>客户名称：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="khmc" name="khmc" readonly="true" required data-msg-required="客户名称必填" minlength="1"  style="width:110%;">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">客户地址：</label>
				  <div class="col-sm-10">
					<input class="form-control" type="text" style="width:110%;" readonly="true" id="khdz" name="khdz" >
				  </div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
				  <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;"><span style="color:red">*</span>拜访人员：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" style="width:110%;" id="bfry" name="bfry">
					</div>
				  <label class="col-sm-2 col-sm-2 control-label">人员职务：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" style="width:110%;" id="ryzw" name="ryzw">
					</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
			   <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">联系电话：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="lxdh" name="lxdh" style="width:110%;" onkeyup="value=value.replace(/[^\d]/g,'') "   
                                   onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">拜访日期：</label>
                  <div class="col-sm-10">
                  <input class="form-control Wdate" type="text" id="bfrq" name="bfrq" style="width:110%;" onClick="WdatePicker({dateFmt:' yyyy-MM-dd'})" >
                  </div>
			   </div>
			   
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
			    <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">合作情况：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" style="width:110%;" id="hzqk" name="hzqk">
					</div>
			    <label class="col-sm-2 col-sm-2 control-label">客户评价：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" style="width:110%;" id="khpj" name="khpj">
					</div>
			</div>
				<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
					<label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">拜访记录：</label>
					<div class="col-sm-10">
						<textarea class="form-control"  truetype="textarea" id ="bfjl" name="bfjl" rows="3" style="width:258%; "></textarea>
					</div>
				</div>
				<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
					<label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">客户意见和要求：</label>
					<div class="col-sm-10">
						<textarea class="form-control"   truetype="textarea" id ="yjyq" name="yjyq" rows="3" style="width:258%; "></textarea>
					</div>
				</div>
				<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
					<label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">分析对策与建议：</label>
					<div class="col-sm-10">
						<textarea class="form-control"   truetype="textarea" id ="dcjy" name="dcjy" rows="3" style="width:258%; "></textarea>
					</div>
				</div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%; ">
			    <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">业务人员：</label>
				<div class="col-sm-10" >
					<input class="form-control" type="text" id="ywry" name="ywry" style="width:110%;">
			    </div>
			</div>
			<div style="text-align: center">
				<div class="form-group"  style="margin-top: 10px; margin-left: -7%; width: 110%;">
					<button type="button" class="btn btn-success" onClick="save()">提交</button>
				    <button type="button" class="btn btn-success"onClick="exit();">返回</button>
				</div>
			</div>
			</form>
		</div>
	</div>
</body>
<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalKhxx" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <!-- <form class="form-horizontal" role="form"> -->
                <section class="panel" id="sectKhxx">
                    <header class="panel-heading">选择客户信息</header>
                    <label style="margin-left: 6px;">客户名称:</label>&nbsp;&nbsp;&nbsp;<input id="khmccx" name="khmccx">&nbsp;&nbsp;&nbsp;
                    <label>法人姓名:</label>&nbsp;&nbsp;&nbsp;<input id="frxmcx" name="frxmcx">
                    <button onClick="getKh();">查询</button>
                    <span id="sbzKhxx"></span>
                    <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
                        <div class="col-lg-offset-2 col-lg-10" style="margin-top: 40px;">
                            <button type="button" class="btn btn-default" onClick="closeKh();"
                                    style="margin-left: 20px;">取消
                            </button>
                        </div>
                    </div>
                </section>
                <!-- </form> -->
            </div>
        </div>
    </div>
</div>
</html>
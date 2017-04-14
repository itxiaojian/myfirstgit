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
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/upload.css">
<script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
.form-control111 {
    background-color: #fff;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
    color: #555;
    font-size: 12px;
    height:21px;
    padding: 1px 6px;
    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
}
.tabCss111{
	width: 80%; 
	height: 76px;
	margin-left: 95px;
}
</style>
</head>
<script>
function save() {
	var cjbm=$('#cjbm').val();
	if(cjbm==''||cjbm==null){
		alert('请选择承检部门！');
		return false;
	}
	var jsr=$('#jsr').val();
	if(jsr==''||jsr==null){
		alert('请选择接收人！');
		return false;
	}
	var yqwcrq=$('#yqwcrq').val();
	if(yqwcrq==''||yqwcrq==null){
		alert('请选择完成日期！');
		return false;
	}
	var count=document.getElementById("num").value;
	if(count>0){
		for(var a=1;a<=count;a++){
			var ypmc=$('#ypmc'+a).val();
			if(ypmc==''||ypmc==null){
				alert('请选择样品！');
				return false;
			}
		}
	}
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "save";
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
				if(data=='1'){
					alert('保存成功！');
					var PAGESIZE = 20;
					window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
		            window.parent.ACT_DEAL_WINDOW.close();
				}else{
					alert('保存失败！');
				}
			}
		});
	}

} 
var j = 1;
function getNumber(num){
	j=num;
}
//增加新一行
var i = 1;
function addTr(){
	var num=i+1;
	var oTest = document.getElementById("mybody");
	var newNode = document.createElement("tr");
	newNode.setAttribute('id','mybody'+num);
	newNode.style.marginLeft="12%";
	newNode.innerHTML ="<tr>"
		+"<td><label class='btn btn-success'><a class='btn btn-xs btn-sucess' style='color: white; padding-left: 0px; padding-right: 0px; border-right-width: 0px; border-left-width: 0px; width: 72px;' data-toggle='modal' href='#myModal' onclick='getNumber("+num+");'>选择委托样品</a></label></td>"
		+"<td><textarea style='height: 37px;' class='form-control' type='text' name='ypmc"+num+"' id='ypmc"+num+"' readonly='readonly'></textarea></td>"
		+"<td><textarea style='height: 37px;' class='form-control' type='text' name='ypbh"+num+"' id='ypbh"+num+"' readonly='readonly'></textarea></td>"
		+"<td><textarea style='height: 37px;' class='form-control' type='text' name='ggxh"+num+"' id='ggxh"+num+"' readonly='readonly'></textarea></td>"
		+"<td><textarea style='height: 37px;' class='form-control' type='text' name='jyyj"+num+"' id='jyyj"+num+"' readonly='readonly'></textarea></td>"
		+"<td><textarea style='height: 37px;' class='form-control' type='text' name='jyxm"+num+"' id='jyxm"+num+"' ></textarea></td>"
		+"<td><textarea style='height: 37px;' class='form-control' type='text' name='je"+num+"' id='je"+num+"' ></textarea></td>"
		+"<td style='width:10%;'><select style='height: 37px;' class='form-control input-lg m-bot15' id='sfty"+num+"' name='sfty"+num+"'>"
		+"<option value='0'>是</option><option value='1'>否</option></select></td>"
		+"<td><textarea style='height: 37px;' class='form-control Wdate' onClick='WdatePicker({dateFmt:&quot;yyyy-MM-dd&quot;})' type='text' name='bcqx"+num+"' id='bcqx"+num+"' ></textarea></td>"
		+"<td><a href='javascript:;' onclick='deleteTr("+num+");'>"
		+"<span  style='text-align: right;' >"
		+"<img src='<%=path%>/resources/images/iconfont-shanchu.png' alt='删除' height='25px' width='25px' style='margin-top:3px'/>"
		+"</span></a></td>"
		+"</tr>"
	oTest.insertBefore(newNode,null);
	i++;
	document.getElementById("num").value=i; 
	document.getElementById("num1").value=i; 
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
			document.getElementById("num1").value=i;
		}else{
			alert("请删除最新的一行！");
		}
	}
}

//退出
function exit(){
	var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
    window.parent.ACT_DEAL_WINDOW.close();
}

//加载次数
var jzcs=1;
var checked=[];
//打开收费信息窗口
function getSfxmmx(type) {
	if(type=='1'){
		jzcs++;
	}else{
		jzcs=1;
	}
    var url = "getYpxx";
    var cpbhcx = document.getElementById("cpbhcx").value;
    var cpmccx = document.getElementById("cpmccx").value;
    var start = document.getElementById("start").value;
    var end = document.getElementById("end").value;
    if((cpmccx!=""&&cpmccx!=null) || (cpbhcx!=""&&cpbhcx!=null) || (start!=""&&start!=null) || (end!=""&&end!=null)){
    	document.getElementById('Div1').style.height='220px'; 
        $.ajax({
            cache: true,
            type: "POST",
            url: url,
            data: {cpbhcx: cpbhcx,cpmccx: cpmccx,start: start, end: end,jzcs:jzcs},
            async: false,
            error: function (request) {
                alert("选择失败,请联系管理员。");
            },
            success: function (data) {
                var del = $("#table");
                del.remove();
                var str = "<table><thead><tr><th style='width:80px'>样品名称</th><th style='width:60px'>委托单位</th><th style='width:50px'>规格型号</th><th style='width:50px'>检验依据</th>"
                        + "<th style='width:30px'>操作</th></tr></thead><tbody>";
                for (var i = 0; i < data.length; i++) {
                    /* str = str + "<tr id='id" + i + "' name='id" + i + "'><td style='width:80px'>" + data[i].YPMC + "</td><td style='width:60px'>" + data[i].WTDW + "</td>"
                            + "<td style='width:50px'>" + data[i].GGXH + "</td><td style='width:50px'>" + data[i].JYYJ + "</td><td style='width:30px'><input "
                            + "name='checkSfxmmx' type='checkbox' onclick='getDj(this,\""+ data[i].YPMC +"\",\"id"+i+"\");' "; */
                    str = str + "<tr id='id" + i + "' name='id" + i + "'><td style='width:80px'>" + isNull(data[i].YPMC) + "</td><td style='width:60px'>" + isNull(data[i].WTDW) + "</td>"
                    		+ "<td style='width:50px'>" + isNull(data[i].GGXH) + "</td><td style='width:50px'>" + isNull(data[i].JYYJ)
                    		+ "</td><td><input type ='button' onClick='setYpxx(\""+isNull(data[i].YPMC)+"\",\""+data[i].YPBH+"\",\""+isNull(data[i].GGXH)+"\",\""+isNull(data[i].JYYJ)+"\");' value='选择'></td>";        
                    /* for(var j=0;j<checked.length;j++){
                    	if(('id'+i)==checked[j]){
                        	str = str + "checked='checked' ";
                    	}
                    } */
                    str = str + "</tr>";
                }
                str = str + "</tbody><table>";
                var oTest = document.getElementById("Div1");
                var newNode = document.createElement("table");
                newNode.setAttribute('class', 'table');
                newNode.setAttribute('id', 'table');
                newNode.innerHTML = str;
                oTest.insertBefore(newNode, null);
            }
        });
    }else {
    	alert("请输入查询条件！");
    	return false;
    }
}

var yxxms=0;
function getDj(obj,mc,id){
	var mcxs=$('#mcxs').val();
	if(obj.checked==true){
		yxxms++;
		if(mcxs!=null&&mcxs!=''){
    		$('#mcxs').val(mcxs+','+mc);
		}else{
			$('#mcxs').val(mc);
		}
		checked.push(id);
	}else{
		yxxms--;
		var r = document.getElementsByName("checkSfxmmx");
		var yxmc='';
		for (var i = 0; i < r.length; i++) {
            if (r[i].checked) {
            	var a = r[i].value;
            	var td = $("#" + a).find("td");
            	yxmc=yxmc+$(td[0]).text()+",";
            }
		}
		$('#mcxs').val(yxmc.substr(0, yxmc.length-1));
		checked.pop();
	}
}

//关闭收费窗口
function closeWin() {
    var del = $("#table");
    del.remove();
    $('#myModal').modal('hide');
    document.getElementById('Div1').style.height='0px';
    $('#mcxs').val('');
    checked.splice(0,checked.length);
    yxxms=0;
}

//保存信息
function setYpxx(ypmc,ypbh,ggxh,jyyj) {
    <%-- var xmmccx = document.getElementById("xmmccx").value;
	var r = document.getElementsByName("checkSfxmmx");
	var ypmc='';
	var wtdw='';
	var ggxh='';
	for (var i = 0; i < r.length; i++) {
        if (r[i].checked) {
        	var a = r[i].value;
        	var td = $("#" + a).find("td");
        	ypmc=ypmc+$(td[0]).text()+",";
        	wtdw=wtdw+$(td[1]).text()+",";
        	ggxh=ggxh+$(td[2]).text()+",";
        }
	}
	ypmc=ypmc.substr(0, ypmc.length-1);
	wtdw=wtdw.substr(0, wtdw.length-1);
	ggxh=ggxh.substr(0, ggxh.length-1);
	var url = "getYpxxList";
    $.ajax({
        cache: true,
        type: "POST",
        url: url,
        data: {xmmccx:xmmccx,ypmc:ypmc,wtdw:wtdw,ggxh:ggxh},// 你的formid
        async: false,
        error: function (request) {
            alert("操作失败,请联系管理员。");
        },
        success: function (data) {
        	var del = $("#xsTab");
            del.remove();
            document.getElementById("num").value=data.length;
            document.getElementById("num1").value=data.length;
            var str = "<table><tbody id='mybody'><tr><th style='text-align:center'>样品名称</th><th style='text-align:center'>样品编号</th><th style='text-align:center'>规格型号</th>"
					+ "<th style='text-align:center'>检验依据</th><th style='text-align:center'>检验项目</th><th style='text-align:center'>检验费（元）</th><th style='text-align:center'>是否需要退样</th>"
					+ "<th style='text-align:center'>样品保存期限</th><th></th></tr>";
			for(var i = 0; i < data.length; i++){
				str = str + "<tr id='tr'><td><textarea style='height: 37px;' class='form-control' type='text' id='ypmc"+(i+1)+"' name='ypmc"+(i+1)+"' readonly='readonly'>" + data[i].ypmc + ""
					+ "</textarea></td><td><textarea style='height: 37px;' class='form-control' type='text' id='ypbh"+(i+1)+"' name='ypbh"+(i+1)+"' readonly='readonly'>" + data[i].ypbh + "</textarea></td>"
					+ "<td><textarea style='height: 37px;' class='form-control' type='text' id='ggxh"+(i+1)+"' name='ggxh"+(i+1)+"' readonly='readonly'>" + data[i].ggxh + "</textarea></td>"
					+ "<td><textarea style='height: 37px;' class='form-control' type='text' id='jyyj"+(i+1)+"' name='jyyj"+(i+1)+"' readonly='readonly'>" + data[i].jyyj + "</textarea></td>"
					+ "<td><a href='#myModalJyxm' data-toggle='modal' onclick='getJyxmPlean(\"jyxm"+(i+1)+"\",\"ypbh"+(i+1)+"\");'><textarea style='height: 37px;' class='form-control' type='text' id='jyxm"+(i+1)+"' name='jyxm"+(i+1)+"' readonly='readonly'></textarea></a></td>"
					+ "<td><textarea style='height: 37px;' class='form-control' type='text' id='je"+(i+1)+"' name='je"+(i+1)+"' readonly='readonly'></textarea></td>"
					+ "<td style='width:10%;'><select style='height: 37px;' class='form-control input-lg m-bot15' id='sfty"+(i+1)+"' name='sfty"+(i+1)+"'>"
					+ "<option value='0'>是</option><option value='1'>否</option></select></td>"
					+ "<td><textarea style='height: 37px;' class='form-control' type='text' id='bcqx"+(i+1)+"' name='bcqx"+(i+1)+"' value='/'></textarea></td>"
					+ "<td><a href='javascript:;' onclick='deleteTr("+(i+1)+");'><span  style='text-align: right;' >"
					+ "<img src='<%=path%>/resources/images/iconfont-shanchu.png' alt='删除' height='25px' width='25px' style='margin-top:3px'/></span>"
					+ "</a></td></tr>";
			}		
			str = str + "</tbody></table>";
            var oTest = document.getElementById("xsDiv");
            var newNode = document.createElement("table");
            newNode.setAttribute('class', 'tabCss111');
            newNode.setAttribute('id', 'xsTab');
            newNode.innerHTML = str;
            oTest.insertBefore(newNode, null);
        }
    });
    var del = $("#table");
    del.remove();
    $("#cpmccx").val("");
    $("#xmmccx").val("");
    $('#myModal').modal('hide');
    document.getElementById('Div1').style.height='0px';
    $('#mcxs').val('');
    checked.splice(0,checked.length);
    yxxms=0; --%>
    
    $("#ypmc"+(j)).val(ypmc);
    $("#ypbh"+(j)).val(ypbh);
    $("#ggxh"+(j)).val(ggxh);
    $("#jyyj"+(j)).val(jyyj);
    $('#myModal').modal('hide');
    
}

var checkedJyxm=[];
//打开窗口
function getJyxmPlean(id,ypbhid) {
  	var ypbh=$('#'+ypbhid).val();
  	if(ypbh==''){
  		alert('请先选择样品');
  		return false;
  	}
  	$('#Jybh').val(id);
  	var url = "getJyxm";
  	document.getElementById('Div1Jyxm').style.height='220px'; 
      $.ajax({
          cache: true,
          type: "POST",
          url: url,
          data: {ypbh: ypbh},
          async: false,
          error: function (request) {
              alert("选择失败,请联系管理员。");
          },
          success: function (data) {
              var del = $("#tableJyxm");
              del.remove();
              var str = "<table><thead><tr><th style='width:80px'>报告编号</th><th style='width:60px'>项目编号</th><th style='width:50px'>项目名称</th><th style='width:50px'>项目金额</th>"
                      + "<th style='width:30px'>操作</th></tr></thead><tbody>";
              for (var i = 0; i < data.length; i++) {
                  str = str + "<tr id='" + data[i].BGBH + "' name='" + data[i].BGBH + "'><td style='width:80px'>" + data[i].BGBH + "</td><td style='width:60px'>" + data[i].XMBH + "</td>"
                          + "<td style='width:50px'>" + data[i].XMMC + "</td><td style='width:50px'>" + data[i].XGJE + "</td><td style='width:30px'><input "
                          + "name='checkJyxm' type='checkbox' onclick='getJyxm(this,\""+ data[i].XMMC +"\",\"" + data[i].BGBH + "\");' ";
                  for(var j=0;j<checkedJyxm.length;j++){
                  	if(data[i].BGBH==checkedJyxm[j]){
                      	str = str + "checked='checked' ";
                  	}
                  }
                  str = str + "value = '" + data[i].BGBH + "'/></td></tr>";
              }
              str = str + "</tbody><table>";
              var oTest = document.getElementById("Div1Jyxm");
              var newNode = document.createElement("table");
              newNode.setAttribute('class', 'table');
              newNode.setAttribute('id', 'tableJyxm');
              newNode.innerHTML = str;
              oTest.insertBefore(newNode, null);
          }
      });
}

function getJyxm(obj,mc,id){
	var mcxs=$('#mcxsJyxm').val();
	if(obj.checked==true){
		if(mcxs!=null&&mcxs!=''){
    		$('#mcxsJyxm').val(mcxs+','+mc);
		}else{
			$('#mcxsJyxm').val(mc);
		}
		checked.push(id);
	}else{
		var r = document.getElementsByName("checkJyxm");
		var yxmc='';
		for (var i = 0; i < r.length; i++) {
            if (r[i].checked) {
            	var a = r[i].value;
            	alert(a);
            	var td = $("#" + a).find("td");
            	yxmc=yxmc+$(td[2]).text()+",";
            }
		}
		$('#mcxsJyxm').val(yxmc.substr(0, yxmc.length-1));
		checked.pop();
	}
}

//关闭检验项目窗口
function closeWinJyxm() {
    var del = $("#tableJyxm");
    del.remove();
    $('#myModalJyxm').modal('hide');
    document.getElementById('Div1Jyxm').style.height='0px';
    $('#mcxsJyxm').val('');
    checkedJyxm.splice(0,checked.length);
}

//保存信息
function setJyxm() {
	var id=$('#Jybh').val();
	var mcxs=$('#mcxsJyxm').val();
	$('#'+id).val(mcxs);
    var del = $("#tableJyxm");
    del.remove();
    $('#myModalJyxm').modal('hide');
    document.getElementById('Div1Jyxm').style.height='0px';
    $('#mcxsJyxm').val('');
    checkedJyxm.splice(0,checked.length);
}

function addOptions(v) { 
	var sel = document.getElementById('jsr');
	sel.options.length = 1; //清空原来的option        
	$.ajax({  
            url: "getYhbyBm",    //后台webservice里的方法名称  
            type: "POST",  
            dataType: "json",  
            data:{bmbh : v}, 
            traditional: true,  
            success: function (data) { 
                for (var i = 0; i < data.length; i++) {  
                    var jsonObj =data[i];
					sel.options.add(new Option(data[i].XM, data[i].DLM));        
                }  
            },  
            error: function (msg) {  
                alert("出错了！");  
            }  
        });            
}

//判断字段是否有值
function isNull(string){
	if(string==null||string=='null'){
		return '';
	}else{
		return string
	}
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
		<input type="hidden" name="num1" id="num1" value="1">
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				<label class="col-sm-2 control-label">承检部门：</label>
				<div class="col-sm-10">
					<select class="form-control input-lg m-bot15" id="cjbm" name="cjbm" onchange="addOptions(this.value);">
						<option value="">请选择...</option>
						<c:forEach var="data" items="${cjbm }" varStatus="obj">
							<option value="${data.BMBH }">${data.BMMC }</option>
						</c:forEach>
					</select>
<!-- 					<input class="form-control" type="text" id="cjbm" name="cjbm"> -->
				</div>
				<label class="col-sm-2 control-label">接收人：</label>
				<div class="col-sm-10">
					<select class="form-control input-lg m-bot15" id="jsr" name="jsr">
						<option value="">请选择...</option>
					</select>
<!-- 					<input class="form-control" type="text" id="jsr" name="jsr"> -->
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 10px;padding-left: 0px;">
				<label class="col-sm-2 col-sm-2 control-label">委托部门：</label>
				<div class="col-sm-10">
					<input class="form-control" type="hidden" id="wtbm" name="wtbm" readonly="readonly" value="${wtbm }">
					<input class="form-control" type="text" id="wtbmmc" name="wtbmmc" readonly="readonly" value="${wtbmmc }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">委托日期：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="wtrq" name="wtrq" readonly="readonly" value="${wtrq }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">要求检验结果报告日期：</label>
				<div class="col-sm-10">
					<input class="form-control Wdate" type="text" id="yqwcrq" name="yqwcrq" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
				</div>
			</div>
<!-- 		</form> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
<!-- 	<div class="panel"> -->
<!-- 		<header class="panel-heading" style="text-align: center;"> 样品明细</header> -->
<!-- 		<div class="panel-body"> -->
<!-- 			<form class="form-horizontal tasi-form" name="myForm2" id="myForm2"  method="post"> -->
			<input type="hidden" name="Jybh" id="Jybh" value="">
			<input type="hidden" name="num" id="num" value="1">
			<div class="form-group" id="xsDiv" style="margin-top:50px">
				<table style="width: 80%; height: 76px;margin-left: 95px;" id="xsTab">
					<tbody id="mybody">
					<tr>	
					    <th></th>
						<th style="text-align:center">样品名称</th>
						<th style="text-align:center">样品编号</th>
						<th style="text-align:center">规格型号</th>
						<th style="text-align:center">检验依据</th>
						<th style="text-align:center">检验项目</th>
						<th style="text-align:center">检验费（元）</th>
						<th style="text-align:center">是否需要退样</th>
						<th style="text-align:center">样品保存期限</th>
						<th></th>
					</tr>
					<tr id="tr">
						<td><label class="btn btn-success"><a class="btn btn-xs btn-sucess" style="color: white; 
						padding-left: 0px; padding-right: 0px; border-right-width: 0px; border-left-width: 0px; width: 72px;" 
						data-toggle="modal" href="#myModal">选择委托样品</a></label>
	                 		</td>
						<td><textarea style="height: 37px;" class="form-control" type="text" id="ypmc1" name="ypmc1" readonly="readonly"></textarea></td>
						<td><textarea style="height: 37px;" class="form-control" type="text" id="ypbh1" name="ypbh1" readonly="readonly"></textarea></td>
						<td><textarea style="height: 37px;" class="form-control" type="text" id="ggxh1" name="ggxh1" readonly="readonly"></textarea></td>
						<td><textarea style="height: 37px;" class="form-control" type="text" id="jyyj1" name="jyyj1" readonly="readonly"></textarea></td>
						<td><textarea style="height: 37px;" class="form-control" type="text" id="jyxm1" name="jyxm1" ></textarea></td>
						<td><textarea style="height: 37px;" class="form-control" type="text" id="je1" name="je1" ></textarea></td>
						<td style="width:10%">
<!-- 							<textarea style="height: 37px;" class="form-control" type="text" id="sfty1" name="sfty1" readonly="readonly"></textarea> -->
							<select style="height: 37px;" class="form-control input-lg m-bot15" id="sfty1" name="sfty1">
								<option value="0">是</option>
								<option value="1">否</option>
							</select>
						</td>
						<td><textarea style="height: 37px;" class="form-control Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" type="text" id="bcqx1" name="bcqx1" ></textarea></td>
						<td><a href="javascript:;" onclick="deleteTr(1);">
									<span  style="text-align: right;" >
										<img src="<%=path%>/resources/images/iconfont-shanchu.png" alt="删除" height="25px" width="25px" style="margin-top:3px"/>
									</span>
							</a>
						</td>		
					</tr>
					</tbody>
				</table>
			</div>
			<div style="text-align:center;margin-bottom:10px">
				<!-- <label class="btn btn-success">
                	<a href="#myModal" data-toggle="modal"
                 		class="btn btn-xs btn-sucess" style="color: white;">选择委托样品</a>
                </label>
                &nbsp;&nbsp;&nbsp; -->
 				<input class="btn btn-success" id="btnAdd" value="新增" type="button" onclick="addTr();">
 				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="btn btn-success" value="提交" type="button" onclick="save();" style="height: 36px;margin-left: -20px;">
				&nbsp;&nbsp;&nbsp;
				<input class="btn btn-success" value="关闭" type="button" onclick="exit();" style="height: 36px;">
		    </div>
			</form>
		</div>
	</div>
</div> 
</body>

<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <section class="panel" id="sect" style="margin-bottom: 90px;">
                    <header class="panel-heading">样品信息</header>
                    <label style="margin-left: 6px;">样品编号:</label>&nbsp;<input id="cpbhcx" name="cpbhcx">&nbsp;&nbsp;&nbsp;
                    <label style="margin-left: 6px;">样品名称:</label>&nbsp;<input id="cpmccx" name="cpmccx">
                    <br/>
                    &nbsp;&nbsp;<label>登记开始时间:</label>&nbsp;<input class="form-control111 Wdate" type="text" id="start" name="start" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" >
                    <label>登记结束时间:</label>&nbsp;<input class="form-control111 Wdate" type="text" id="end" name="end" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" >
                    <button onClick="getSfxmmx(0);">查询</button>
                    <br/>
                    <!-- <label style="margin-left: 6px;">已选样品:</label> <textarea rows="2" id="mcxs" name="mcxs" truetype="textarea" style="width: 85%;"></textarea> -->
                    <div id="Div1" style="overflow:auto"></div>
                    <span id="sbz"></span>
                    <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
                        <div class="col-lg-offset-2 col-lg-10" style="margin-top: 10px;">
                            <button type="button" class="btn btn-default" onclick="getSfxmmx(1);"
                                    style="margin-left: 120px;">加载更多...
                            </button>
                        </div>
                    </div>
                    <!-- <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
                        <div class="col-lg-offset-2 col-lg-10" style="margin-top: 10px;">
                            <button type="button" class="btn btn-default" onclick="setYpxx();"
                                    style="margin-left: 100px;">确定
                            </button>
                            <button type="button" class="btn btn-default" onClick="closeWin();"
                                    style="margin-left: 20px;">取消
                            </button>
                        </div>
                    </div> -->
                </section>
            </div>
        </div>
    </div>
</div>

<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalJyxm" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <section class="panel" id="sectJyxm" style="margin-bottom: 90px;">
                    <header class="panel-heading">检验项目</header>
                    <label style="margin-left: 6px;">已选项目:</label> <textarea rows="2" id="mcxsJyxm" name="mcxsJyxm" truetype="textarea" style="width: 85%;"></textarea>
                    <div id="Div1Jyxm" style="overflow:auto"></div>
                    <span id="sbzJyxm"></span>
                    <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
                        <div class="col-lg-offset-2 col-lg-10" style="margin-top: 10px;">
                            <button type="button" class="btn btn-default" onclick="setJyxm();"
                                    style="margin-left: 100px;">确定
                            </button>
                            <button type="button" class="btn btn-default" onClick="closeWinJyxm();"
                                    style="margin-left: 20px;">取消
                            </button>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>
</html>
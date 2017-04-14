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
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>

<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery-1.10.2.min.js"></script>

<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css">
<script type="text/javascript" src="<%=path%>/resources/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/upload.css">
<script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.qrcode.min.js"></script>
<script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery.validate.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/yz/yzstyle.css">
</head>
<body >
	<div class="wrapper">
	<div class="panel" style="margin-bottom: 1px; height: 605px;">
		<div class="panel-body" style="height: 603px;">
			<div style="text-align:center;margin-bottom:-2px"></div>
                <form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post" enctype="multipart/form-data">
					<input type="hidden" name="num" id="num" value="1">
					<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 10px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">产品编号：</label>
						<div class="col-sm-10" style="width: 154px;">
							<input class="form-control" type="text" id="cpbh" name="cpbh" readonly="readonly">
						</div>
						<div class="col-sm-10" style="padding-left: 0px; width: 100px;">
	                        <label class="col-sm-2 col-sm-2 control-label">
	                                <a href="#myModalYpxx" data-toggle="modal" class="btn btn-xs btn-sucess" style="color:green;" 
	                                onClick="getYpxxList(0);" >选择已有产品</a>
	                        </label>
                        </div>
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>产品名称：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="cpmc" name="cpmc" required data-msg-required="产品名称必填" minlength="1">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;margin-top: 10px;">
						<label class="col-sm-2 col-sm-2 control-label">产品类型：</label>
						<div class="col-sm-10">
							<select class="form-control input-lg m-bot15" name="cplx" id="cplx" >
                            	<option selected="selected" value="">请选择...</option>
                                <c:forEach var="cplx" items="${cplx}" varStatus="obj">
                                    <option value="${cplx.zdmc }">${cplx.zdmc }</option>
                                </c:forEach>
                            </select>
						</div>
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>检验依据：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="jyyj" name="jyyj" 
							required data-msg-required="检验依据必填" minlength="1"
							onkeyup="this.value=this.value.replace(/^ +| +$/g,'')">
						</div>
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>是否批准：</label>
						<div class="col-sm-10">
							<select class="form-control input-lg m-bot15" id="sfpz" name="sfpz" required data-msg-required="是否批准必填">
								<option selected="selected" value="">请选择...</option>
						        <option value="0">是</option>
						        <option value="1">否</option>
						    </select>
						</div>
					</div>
					
					<div>
						<div class="form-group" style="width: 90%; padding-top: 6px; margin-left: 20px;">
						<input id="btnAdd" class="btn btn-success" type="button" style="padding-left: 12px; padding-top: 2px; 
						padding-bottom: 2px; width: 80px; height: 30px;" onclick="addTr();" value="新增" >
						</div>
					</div>		
					<div class="form-group" style="padding-bottom: 0px; 
					     padding-left: 0px; margin-left: 41px; margin-right: 0px;">
						<table style="width: 1330px;margin-top: 26px;">
							<tr>
								<th>检验项目</th>
								<th style="width: 85px;">对应标准条款号</th>
								<th>规格型号</th>
								<th>样品数量</th>
								<th>检测费用</th>
								<th>计量单位</th>
								<th>检验周期（天）</th>
								<th style="width: 81px;">院资质认定</th>
								<th style="width: 81px;">院CNAS</th>
								<th style="width: 81px;">国排中心CMA/CAL</th>
								<th style="width: 81px;">国建中心CMA/CAL</th>
								<th style="width: 81px;">院食品省级资质认定</th>
								<th>环境要求</th>
								<th>设备编号</th>
								<th>设备名称</th>
								<th>人员</th>
								<th>备注</th>
								<th></th>
							</tr>
							<tbody id="mybody">
							<tr id="tr">
		                        <td><input class="form-control" type="text" id="jcxm1" name="jcxm1" 
		                        	required data-msg-required="检验项目必填"></td>
								<td><input class="form-control" type="text" id="dybztkh1" name="dybztkh1"></td>
								<td><input class="form-control" type="text" id="ggxh1" name="ggxh1" ></td>
								<td><input class="form-control" type="text" id="ypsl1" name="ypsl1" ></td>
								<td><input class="form-control je" type="text" id="jcfy1" name="jcfy1"  
								onkeyup="value=value.replace(/[^\d.]/g,'') " placeholder="请输入金钱格式,可保留两位小数"
		                        onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d.]/g,'')"></td>
		                        <td><input class="form-control" type="text" id="jldw1" name="jldw1" ></td>
		                        <td><input class="form-control" type="text" id="jyzq1" name="jyzq1" ></td>
								<td>
									<select class="form-control input-lg m-bot15" id="yzzrd1" name="yzzrd1">
										<option selected="selected" value="">请选择...</option>
								        <option value="0">是</option>
								        <option value="1">否</option>
								    </select>    
								</td>
								<td>
									<select class="form-control input-lg m-bot15" id="yzz1" name="yzz1">
										<option selected="selected" value="">请选择...</option>
								        <option value="0">是</option>
								        <option value="1">否</option>
								    </select>    
								</td>
								<td>
									<select class="form-control input-lg m-bot15" id="gpzz1" name="gpzz1">
										<option selected="selected" value="">请选择...</option>
								        <option value="0">是</option>
								        <option value="1">否</option>
								    </select>    
								</td>
								<td>
									<select class="form-control input-lg m-bot15" id="gjzz1" name="gjzz1">
										<option selected="selected" value="">请选择...</option>
								        <option value="0">是</option>
								        <option value="1">否</option>
								    </select>    
								</td>
								<td>
									<select class="form-control input-lg m-bot15" id="yspzz1" name="yspzz1">
										<option selected="selected" value="">请选择...</option>
								        <option value="0">是</option>
								        <option value="1">否</option>
								    </select>    
								</td>
								<td><input class="form-control" type="text" id="hjyq1" name="hjyq1"></td>
								<td><input class="form-control" type="text" id="sbbh1" name="sbbh1" ></td>
								<td><input class="form-control" type="text" id="sbmc1" name="sbmc1" ></td>
								<td><input class="form-control" type="text" id="ry1" name="ry1" ></td>
								<td><input class="form-control" type="text" id="bz1" name="bz1" ></td>
								<td><a href="javascript:;" onclick="deleteTr(1);">
											<span  style="text-align: right;" >
												<img src="<%=path%>/resources/images/iconfont-shanchu.png" alt="删除" height="25px" width="25px" style="margin-bottom: 5px;"/>
											</span>
									</a>
								</td>		
							</tr>
							</tbody>
						</table>
					</div>
					<div>
						<div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 75px;">
							<input class="btn btn-success" style="margin-left: 30%;" value="提交" type="submit" />
					        <input class="btn btn-success" style="margin-left: 20px;" type="button" onclick="exit();" value="返回">
						</div>
					</div>
				</form>
		  </div>
	   </div>
    </div>
    
<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalYpxx" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <section class="panel" id="sectYpxx">
                    <header class="panel-heading">产品信息</header>
                    <label style="margin-left: 6px;">产品编号:</label>&nbsp;&nbsp;&nbsp;<input id="cpbhcx" name="cpbhcx">&nbsp;&nbsp;&nbsp;
                    <label>产品名称:</label>&nbsp;&nbsp;&nbsp;<input id="cpmccx" name="cpmccx">
                    <button onClick="getYpxxList(0);">查询</button>
                    <span id="sbzYpxx"></span>
                    <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
                        <div class="col-lg-offset-2 col-lg-10" style="margin-top: 10px;">
                            <button type="button" class="btn btn-default" onclick="getYpxxList(1);"
                                    style="margin-left: 120px;">加载更多...
                            </button>
                        </div>
                    </div>
                    <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
                        <div class="col-lg-offset-2 col-lg-10" style="margin-top: 40px;">
                            <button type="button" class="btn btn-default" onClick="closeYpxxWin();"
                                    style="margin-left: 20px;">取消
                            </button>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>
    
    
</body>

<script>

//保存
$(function(){
	$("#myForm").validate({
		submitHandler: function() {
        msg = "确定要提交？";
        if (confirm(msg)) {
        	var options = { 
     		        url:'<%=path%>/jyzxxx/YJyZxxx/save',
            		        //beforeSubmit:  showRequest,  //提交前处理 
            		success: function(data) {
								   if(data=='1'){
										alert('操作成功！'); 
										var PAGESIZE = 20;
										window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
							            window.parent.ACT_DEAL_WINDOW.close();
								   }else{
										alert("保存失败，请联系管理员。");
										//history.go(0) ;
								   }
								   alert(data);
							 },  //处理完成 
            		resetForm: true,  
            		dataType:  'json'  
            };  
   		    	$('#myForm').ajaxSubmit(options); 
   		    	return false;//防止dialog 自动关闭     
		}
		} 
    });
});


//返回
function exit(){
	/* var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
}

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

function close(){
	var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
    window.parent.ACT_DEAL_WINDOW.close();
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
	    +"<td><input class='form-control' type='text' name='jcxm"+num+"' id='jcxm"+num+"' required data-msg-required='检验项目必填'></td>"
		+"<td><input class='form-control' type='text' name='dybztkh"+num+"' id='dybztkh"+num+"'></td>"
		+"<td><input class='form-control' type='text' name='ggxh"+num+"' id='ggxh"+num+"'></td>"
		+"<td><input class='form-control' type='text' name='ypsl"+num+"' id='ypsl"+num+"'></td>"
		+"<td><input class='form-control' type='text' name='jcfy"+num+"' id='jcfy"+num+"'"
		+" onkeyup='value=value.replace(/[^\d.]/g,'')' placeholder='请输入金钱格式,可保留两位小数' "
		+" onbeforepaste='clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d.]/g,'')'></td>"
		+"<td><input class='form-control' type='text' name='jyzq"+num+"' id='jyzq"+num+"'></td>"
		+"<td><select class='form-control input-lg m-bot15' name='yzzrd"+num+"' id='yzzrd"+num+"'>"
				+"<option selected='selected' value=''>请选择...</option>"
				+"<option value='0'>需要</option>"
				+"<option value='1'>不需要</option>"
	        +"</select>"
        +"</td>"
        +"<td><select class='form-control input-lg m-bot15' name='yzz"+num+"' id='yzz"+num+"'>"
				+"<option selected='selected' value=''>请选择...</option>"
				+"<option value='0'>需要</option>"
				+"<option value='1'>不需要</option>"
		    +"</select>"
		+"</td>"
		+"<td><select class='form-control input-lg m-bot15' name='gpzz"+num+"' id='gpzz"+num+"'>"
				+"<option selected='selected' value=''>请选择...</option>"
				+"<option value='0'>需要</option>"
				+"<option value='1'>不需要</option>"
		    +"</select>"
		+"</td>"
		+"<td><select class='form-control input-lg m-bot15' name='gjzz"+num+"' id='gjzz"+num+"'>"
				+"<option selected='selected' value=''>请选择...</option>"
				+"<option value='0'>需要</option>"
				+"<option value='1'>不需要</option>"
			+"</select>"
		+"</td>"
		+"<td><select class='form-control input-lg m-bot15' name='yspzz"+num+"' id='yspzz"+num+"'>"
				+"<option selected='selected' value=''>请选择...</option>"
				+"<option value='0'>需要</option>"
				+"<option value='1'>不需要</option>"
			+"</select>"
		+"</td>"
		+"<td><input class='form-control' type='text' name='hjyq"+num+"' id='hjyq"+num+"'></td>"
		+"<td><input class='form-control' type='text' name='sbbh"+num+"' id='sbbh"+num+"'></td>"
		+"<td><input class='form-control' type='text' name='sbmc"+num+"' id='sbmc"+num+"'></td>"
		+"<td><input class='form-control' type='text' name='ry"+num+"' id='ry"+num+"'></td>"
		+"<td><input class='form-control' type='text' name='bz"+num+"' id='bz"+num+"'></td>"
		+"<td><a href='javascript:;' onclick='deleteTr("+num+");'>"
		+"<span  style='text-align: right;' >"
		+"<img src='<%=path%>/resources/images/iconfont-shanchu.png' alt='删除' height='25px' width='25px' style='margin-bottom: 5px;'/>"
		+"</span></a></td>"
		+"</tr>"
	oTest.insertBefore(newNode,null);
	i++;
	document.getElementById("num").value=i; 
}

//删除行
function deleteTr(num){
	if(confirm("您确定要删除吗？")){
		var del = $("#mybody"+num);
		del.remove();
	}
}

var ypjzcs=1;
//打开产品信息信息窗口
function getYpxxList(type) {
	if(type=='1'){
		ypjzcs++;
	}else{
		ypjzcs=1;
	}
    
    var cpbhcx = document.getElementById("cpbhcx").value;
	var cpmccx = document.getElementById("cpmccx").value;
	var url = "<%=path%>/jyzxxx/YJyZxxx/yccpList";
	$.ajax({
		cache : true,
		type : "POST",
		url : url,
		data : {cpbhcx:cpbhcx,cpmccx:cpmccx,ypjzcs:ypjzcs},
		async : false,
		error : function(request) {
			alert("选择失败,请联系管理员。");
		},
		success : function(data) {
			var del = $("#table");
			del.remove();
        	var str="<table><thead><tr><th>产品编号</th><th>产品名称</th><th>产品类型</th>"
				   +"<th>操作</th></tr></thead><tbody>";
        	for(var i=0;i<data.length;i++){
        		str=str+"<tr id='"+data[i].ID+"'><td>"+isNull(data[i].CPBH)+"</td><td>"+isNull(data[i].CPMC)+"</td><td>"+isNull(data[i].CPLX)
        		+"</td><td><input type ='button' onClick='ypfz(\""+data[i].CPBH+"\",\""+data[i].CPMC+"\",\""+data[i].CPLX+"\");' value='选择'></td>";
        	}
        	str=str+"</tbody><table>";
        	var oTest = document.getElementById("sectYpxx");
    		var newNode = document.createElement("table");
    		var befNode = document.getElementById("sbzYpxx");
    		newNode.setAttribute('class','table');
    		newNode.setAttribute('id','table');
    		newNode.innerHTML =str;
    		oTest.insertBefore(newNode,befNode);
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

//选择产品编号
function ypfz(cpbh,cpmc,cplx) {
	$("#cpbh").val(cpbh);
	$("#cpmc").val(cpmc);
	$("#cplx").val(cplx);
	$("#cpbhcx").val("");
	$("#cpmccx").val("");
	$('#myModalYpxx').modal('hide');
}

//关闭样品信息窗口
function closeYpxxWin() {
	$("#cpbhcx").val("");
	$("#cpmccx").val("");
    var del = $("#table");
    del.remove();
    $('#myModalYpxx').modal('hide');
}
</script>
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
a.link {
    background-color: #5cb85c;
    border-radius: 4px;
    color: #fff;
    cursor: pointer;
    display: inline-block;
    float: left;
    font: 13px/19px "Microsoft YaHei",Verdana,Geneva,sans-serif;
    padding: 1%;
    margin-top: 3px;
    text-align: center;
    text-decoration: none;
    width: 10%;
}
label.error{
    color: red!important;
}
</style>

</html>

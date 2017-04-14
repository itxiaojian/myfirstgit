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
<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery.validate.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/yz/yzstyle.css">
</head>

<body>
	<div class="wrapper" style="height: 514px;">
	<div class="panel" style="margin-bottom: 1px;">
		<div class="panel-body">
			<div style="text-align:center;margin-bottom:-2px"></div>
                <form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post" enctype="multipart/form-data">
					<input type="hidden" name="num" id="num" value="${zxxxLen}">
					<input type="hidden" name="jyyjOld" id="jyyjOld" value="${fhJyyj}">
					<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 10px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">产品编号：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="cpbh" name="cpbh" readonly="readonly" value="${fhCpbh}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>产品名称：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="cpmc" name="cpmc" required 
							data-msg-required="产品名称必填" minlength="1" value="${fhCpmc}">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;margin-top: 10px;">
						<label class="col-sm-2 col-sm-2 control-label">产品类型：</label>
						<div class="col-sm-10">
							<select class="form-control input-lg m-bot15" id="cplx" name="cplx" >
								 <option selected = "selected" value="">请选择...</option>
								 <c:forEach items="${cplx}" var="cplx">
                                       <c:choose>
                                       <c:when test="${cplx.zdmc == fhCplx}">
                                            <option selected = "selected" value="${cplx.zdmc}">${cplx.zdmc}</option>
                                       </c:when>
                                       <c:otherwise>
                                            <option value="${cplx.zdmc}">${cplx.zdmc}</option>
                                       </c:otherwise>
                                       </c:choose>
                                  </c:forEach> 
					         </select>
						</div>
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>检验依据：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="jyyj" name="jyyj" required data-msg-required="检验依据必填" 
							onkeyup="this.value=this.value.replace(/^ +| +$/g,'')"
							minlength="1" value="${fhJyyj}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>是否批准：</label>
						<div class="col-sm-10">
							<select class="form-control input-lg m-bot15" id="sfpz" name="sfpz" required data-msg-required="是否批准必填">
										<c:choose>
										<c:when test="${0 == fhSfpz}">
		                                         <option value="">请选择...</option>
		                                         <option selected = "selected" value="0">是</option>
										         <option value="1">否</option>
		                                </c:when>
		                                <c:when test="${1 == fhSfpz}">
		                                		 <option value="">请选择...</option>
		                                         <option value="0">是</option>
		                                         <option selected = "selected" value="1">否</option>
		                                </c:when>
		                                <c:otherwise>
                                            <option selected = "selected" value="">请选择...</option>
                                            <option value="0">是</option>
                                            <option value="1">否</option>
                                        </c:otherwise>
		                                </c:choose>
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
							    <!-- <tr id="tr" style="display: none" ><td></td></tr> -->
							<c:forEach var="zxxx" items="${zxxx}" varStatus="obj">
								<tr id="mybody${obj.count }">
		                        <td><input class="form-control" type="text" id="jcxm${obj.count }" name="jcxm${obj.count }" value="${zxxx.jcxm}"></td>
								<td><input class="form-control" type="text" id="dybztkh${obj.count }" name="dybztkh${obj.count }" value="${zxxx.dybztkh}"></td>
								<td><input class="form-control" type="text" id="ggxh${obj.count }" name="ggxh${obj.count }" value="${zxxx.ggxh}"></td>
								<td><input class="form-control" type="text" id="ypsl${obj.count }" name="ypsl${obj.count }" value="${zxxx.ypsl}"></td>
								<td><input class="form-control je" type="text" id="jcfy${obj.count }" name="jcfy${obj.count }"  
								onkeyup="value=value.replace(/[^\d.]/g,'') " placeholder="请输入金钱格式,可保留两位小数" value="${zxxx.jcfy}"
		                        onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d.]/g,'')"></td>
		                        <td><input class="form-control" type="text" id="jldw${obj.count }" name="jldw${obj.count }" value="${zxxx.jldw}"></td>
		                        <td><input class="form-control" type="text" id="jyzq${obj.count }" name="jyzq${obj.count }" value="${zxxx.jyzq}"></td>
								
								<td>
									<select class="form-control input-lg m-bot15" id="yzzrd${obj.count }" name="yzzrd${obj.count }" style="padding-left: 2px;" >
										<c:choose>
										<c:when test="${0 == zxxx.yzzrd}">
		                                         <option value="">请选择...</option>
		                                         <option selected = "selected" value="0">是</option>
										         <option value="1">否</option>
		                                </c:when>
		                                <c:when test="${1 == zxxx.yzzrd}">
		                                		 <option value="">请选择...</option>
		                                         <option value="0">是</option>
		                                         <option selected = "selected" value="1">否</option>
		                                </c:when>
		                                <c:otherwise>
                                            <option selected = "selected" value="">请选择...</option>
                                            <option value="0">是</option>
                                            <option value="1">否</option>
                                        </c:otherwise>
		                                </c:choose>
							        </select> 
								</td>
								<td>
									<select class="form-control input-lg m-bot15" id="yzz${obj.count }" name="yzz${obj.count }" style="padding-left: 2px;" >
										<c:choose>
										<c:when test="${0 == zxxx.yzz}">
		                                         <option value="">请选择...</option>
		                                         <option selected = "selected" value="0">是</option>
										         <option value="1">否</option>
		                                </c:when>
		                                <c:when test="${1 == zxxx.yzz}">
		                                		 <option value="">请选择...</option>
		                                         <option value="0">是</option>
		                                         <option selected = "selected" value="1">否</option>
		                                </c:when>
		                                <c:otherwise>
                                            <option selected = "selected" value="">请选择...</option>
                                            <option value="0">是</option>
                                            <option value="1">否</option>
                                        </c:otherwise>
		                                </c:choose>
							        </select>    
								</td>
								<td>
									<select class="form-control input-lg m-bot15" id="gpzz${obj.count }" name="gpzz${obj.count }" style="padding-left: 2px;" >
										<c:choose>
										<c:when test="${0 == zxxx.gpzz}">
		                                         <option value="">请选择...</option>
		                                         <option selected = "selected" value="0">是</option>
										         <option value="1">否</option>
		                                </c:when>
		                                <c:when test="${1 == zxxx.gpzz}">
		                                		 <option value="">请选择...</option>
		                                         <option value="0">是</option>
		                                         <option selected = "selected" value="1">否</option>
		                                </c:when>
		                                <c:otherwise>
                                            <option selected = "selected" value="">请选择...</option>
                                            <option value="0">是</option>
                                            <option value="1">否</option>
                                        </c:otherwise>
		                                </c:choose>
							        </select>   
								</td>
								<td>
									<select class="form-control input-lg m-bot15" id="gjzz${obj.count }" name="gjzz${obj.count }" style="padding-left: 2px;" >
										<c:choose>
										<c:when test="${0 == zxxx.gjzz}">
		                                         <option value="">请选择...</option>
		                                         <option selected = "selected" value="0">是</option>
										         <option value="1">否</option>
		                                </c:when>
		                                <c:when test="${1 == zxxx.gjzz}">
		                                		 <option value="">请选择...</option>
		                                         <option value="0">是</option>
		                                         <option selected = "selected" value="1">否</option>
		                                </c:when>
		                                <c:otherwise>
                                            <option selected = "selected" value="">请选择...</option>
                                            <option value="0">是</option>
                                            <option value="1">否</option>
                                        </c:otherwise>
		                                </c:choose>
							        </select>     
								</td>
								<td>
									<select class="form-control input-lg m-bot15" id="yspzz${obj.count }" name="yspzz${obj.count }" style="padding-left: 2px;" >
										<c:choose>
										<c:when test="${0 == zxxx.yspzz}">
		                                         <option value="">请选择...</option>
		                                         <option selected = "selected" value="0">是</option>
										         <option value="1">否</option>
		                                </c:when>
		                                <c:when test="${1 == zxxx.yspzz}">
		                                		 <option value="">请选择...</option>
		                                         <option value="0">是</option>
		                                         <option selected = "selected" value="1">否</option>
		                                </c:when>
		                                <c:otherwise>
                                            <option selected = "selected" value="">请选择...</option>
                                            <option value="0">是</option>
                                            <option value="1">否</option>
                                        </c:otherwise>
		                                </c:choose>
							        </select>   
								</td>
								<td><input class="form-control" type="text" id="hjyq${obj.count }" name="hjyq${obj.count }" value="${zxxx.hjyq}"></td>
								<td><input class="form-control" type="text" id="sbbh${obj.count }" name="sbbh${obj.count }" value="${zxxx.sbbh}"></td>
								<td><input class="form-control" type="text" id="sbmc${obj.count }" name="sbmc${obj.count }" value="${zxxx.sbmc}"></td>
								<td><input class="form-control" type="text" id="ry${obj.count }" name="ry${obj.count }" value="${zxxx.ry}"></td>
								<td><input class="form-control" type="text" id="bz${obj.count }" name="bz${obj.count }" value="${zxxx.bz}"></td>
								<td><a href="javascript:;" onclick="deleteTr(1);">
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
					
					<div>
						<div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 105px;">
							<input class="btn btn-success" style="margin-left: 30%;" value="提交" type="submit" >
					        <input class="btn btn-success" style="margin-left: 20px;" type="button" onclick="exit();" value="返回">
						</div>
					</div>
				</form>
		  </div>
	   </div>
    </div>
</body>

<script type="text/javascript">

//返回
function exit(){
	/* var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
}

//提交
$(function(){
	$("#myForm").validate({
		submitHandler: function() {
        msg = "确定要提交？";
        if (confirm(msg)) {
        	var options = { 
     		        url:'<%=path%>/jyzxxx/YJyZxxx/update',
            		        //beforeSubmit:  showRequest,  //提交前处理 
            		success: function(data) {
       									if(data=='1'){
       										alert('操作成功！'); 
       										var PAGESIZE = 20;
       										window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
       							            window.parent.ACT_DEAL_WINDOW.close();
       									}else{
       										alert("保存失败，请联系管理员。");
       									}
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
 
//增加新一行
var num=${zxxxLen};
function addTr(){
	num++;
	var oTest = document.getElementById("mybody");
	var newNode = document.createElement("tr");
	newNode.setAttribute('id','mybody'+num);
	newNode.style.marginLeft="12%";
	newNode.innerHTML ="<tr>"
	    +"<td><input class='form-control' type='text' name='jcxm"+num+"' id='jcxm"+num+"'></td>"
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
	document.getElementById("num").value=num; 
}

//删除行
function deleteTr(num){
	if(confirm("您确定要删除吗？")){
		var del = $("#mybody"+num);
		del.remove();
	}
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

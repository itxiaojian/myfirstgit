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
                <form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
                <c:forEach var="ysjl" items="${ysjl}" varStatus="obj">
					<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">报告编号：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="bgbh" name="bgbh" readonly="true" value="${ysjl.bgbh}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">报告状态：</label>
						<div class="col-sm-10">
                            <c:forEach items="${ypjyzt}" var="ypjyzt" >
                               <c:if test="${ypjyzt.zdz == ysjl.ypjyzt}">
                                   <input class="form-control" type="text" id="ypjyzt" name="ypjyzt" disabled="true" value="${ypjyzt.zdmc}">
                               </c:if>
                           </c:forEach>
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">编制人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="bzr" name="bzr" disabled="true" value="${ysjl.bzr}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">编制方式：</label>
						<div class="col-sm-10">
						    <c:if test="${ysjl.bzfs == 0}">
							<input class="form-control" type="text" id="bzfs" name="bzfs" disabled="true" value="一般样品登记">
							</c:if>
							<c:if test="${ysjl.bzfs == 1}">
							<input class="form-control" type="text" id="bzfs" name="bzfs" disabled="true" value="工程类样品登记">
							</c:if>
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 0px;margin-bottom: 0px; padding-top: 2px;width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">检验开始日期：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="jyrq" name="jyrq" disabled="true" value="${ysjl.jyrq}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">检验结束日期：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="jyjsrq" name="jyjsrq" disabled="true" value="${ysjl.jyjsrq}">
						</div>
				    </div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
					    <label class="col-sm-2 col-sm-2 control-label">是否有原始记录：</label>
						<div class="col-sm-10">
                            <c:if test="${ysjl.ywysjl == null||ysjl.ywysjl == 1}">
                            <input class="form-control" type="text" id="ywysjl" name="ywysjl" disabled="true" value="否">
                           </c:if>
                           <c:if test="${ysjl.ywysjl == 0}">
                           <input class="form-control" type="text" id="ywysjl" name="ywysjl" disabled="true" value="有">
                           </c:if>
						</div>
					    <label class="col-sm-2 col-sm-2 control-label">原始记录：</label>
                        <div class="box">
                             <input type="text" name="copyFile" class="textbox" value="${ysjl.ysjlwjm}" />
				             <a href="javascript:void(0);"  class="link">请选择</a>
				             <input type="file" class="uploadFile" name="attachMentFile" id="attachMentFile"
				             onchange="getFile(this,'copyFile')" />
				             <input type="hidden" id="ysjlwjm" name="ysjlwjm">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px;width: 101%;">
					    <label class="col-sm-2 col-sm-2 control-label">上传人员：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="scry" name="scry" readonly="true"  value="${ysjl.scry}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">上传时间：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="scsj" name="scsj" readonly="true"  value="${ysjl.scsj}">
						</div>
					</div>
					<div class="hidden" style="padding-bottom: 6px;margin-bottom: 0px;margin-left: 100px; width: 90%;">
						<div class="col-sm-10">
							<input class="hidden" type="text" id="ysjlsjm" name="ysjlsjm" readonly="true" value="${ysjl.ysjlsjm}">
							<input class="hidden" type="text" name="ysjllj" readonly="true" value="${ysjl.ysjllj}">
							<input class="hidden" type="text" name="bz" readonly="true" value="${ysjl.bz}">
						</div>
					</div>
					<div style="text-align: center">
						<div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 105px;">
							<input class="btn btn-success" value="提交" type="submit">
							<input class="btn btn-success" type="button" onclick="exit();" value="返回">
							<input class="btn btn-success" type="button" onclick="gyyOnUse();" value="使用高拍仪采集原始记录">
						</div>
					</div>
					</c:forEach>
				</form>
		  </div>
	   </div>
    </div>
</body>

<script type="text/javascript">

//打开高影仪页面
function gyyOnUse(){
	location.href='<%=path%>/jygl/YjyYsjl/gyyOnUse';
}

//获取上传文件名
function getFile(obj,inputName){
	var file_name = $(obj).val();
	$("input[name='"+inputName+"']").val(file_name);
	$("#ysjlwjm").val(file_name);
// 	ajaxFileUpload();
}
function ajaxFileUpload() {
    $.ajaxFileUpload({
        url : '<%=path%>/ypgl/upload/tempimg', //用于文件上传的服务器端请求地址
        secureuri : false, //一般设置为false
        fileElementId : 'attachMentFile', //文件上传空间的id属性  <input type="file" id="file" name="file" />
        type : 'post',
        dataType : 'HTML', //返回值类型 一般设置为json
        success : function(data, status) //服务器成功响应处理函数
        {
            /* $("#img1").attr("src", data);
            $("#fileName").val(data);
            $("#file1").val(""); */
            if (typeof (data.error) != 'undefined') {
                if (data.error != '') {
                    alert(data.error);
                } else {
                    alert(data.msg);
                }
            }
        },
        error : function(data, status, e)//服务器响应失败处理函数
        {
            alert(e);
        }
    })
    return false;
}

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
    var options = {  
        url:'<%=path%>/jygl/YjyYsjl/save',
        //beforeSubmit:  showRequest,  //提交前处理 
        success:       function(data) {
//         				alert(data);
							if(data=='1'){
								alert('保存成功！'); 
								var PAGESIZE = 20;
								window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
					            window.parent.ACT_DEAL_WINDOW.close();
							}else if (data=='2'){
								alert('未上传或未修改原始记录！');
							}else{
								alert("保存失败，请联系管理员。");
								history.go(0) ;
							}
						},  //处理完成 
        resetForm: true,  
        dataType:  'json'  
       };  
  
    $('#myForm').submit(function() { //注意这里的index_form     
    	$(this).ajaxSubmit(options);      
    	return false;//防止dialog 自动关闭     
    }); 
		}
		});
});

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
input.textbox {
    border: 1px solid #ccc;
    border-radius: 4px;
    color: #555;
    float: left;
    height: 24px;
    line-height: 24px;
    margin-right: 4px;
    margin-top: 3px;
    padding-left: 4px;
    width: 75%;
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
     width: 22%;
}
</style>
</html>

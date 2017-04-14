<%@page language="java" contentType="text/html"  pageEncoding="UTF-8" %>
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

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="<%=path%>/resources/js/yz/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet"
	href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="<%=path%>/resources/css/jygl/style.css">
	
	<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery.validate.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/yz/yzstyle.css">
	
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

function close(){
	var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
    window.parent.ACT_DEAL_WINDOW.close();
}

/*  function openwin1() {  
    //var id = $("#id").val(); 
    location.href="Yh";
}   */ 
 
 /* function openwin() {  
	    //var id = $("#id").val(); 
	    location.href="YhCs";
	}   */

 
 /* function openswpd(num,value1,value2) {
// 	var str = value1+"-"+value2; */
//	var str = value1+value2;
//	var yhbh = $("#yhbh").val(); 
 //   location.href = "Yhb?yhbh="+yhbh+"&type="+num+"&value="+str;
//}   */

function openwin() {  
    var yhbh = $("#yhbh").val(); 
   // location.href="Yh?yhbh="+yhbh;
    window.open("<%=path%>/sfwgl/YsfwFwxx/Yhb?yhbh=="+yhbh, "用户信息", "height=750, width=800, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no") ;
	
} 

function openwin1() {  
    var yhbh = $("#yhbh").val(); 
   // location.href="Yh?yhbh="+yhbh;
    window.open("<%=path%>/sfwgl/YsfwFwxx/Yh?yhbh=="+yhbh, "用户信息", "height=750, width=800, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no") ;
	
} 

<%--  $(function(){
		//jquery.validate
		$("#myForm").validate({
			submitHandler: function() {
				//验证通过后 的js代码写在这里
			  if ($("#btsr").val() == "") {
               alert("信息填写不完整！");
               return false;
           }  
           if ($("#tsbr").val() == "") {
               alert("信息填写不完整！");
               return false;
           }
          
           msg = "确定要提交？";
           if (confirm(msg)) {
               var url = "<%=path%>/tsxx/YtsXx/save";
               $.ajax({
                   cache: true,
                   type: "POST",
                   url: url,
                   data: $('#myForm').serialize(),// 你的formid
                   async: false,
                   error: function (request) {
                       alert("保存失败,请联系管理员。");
                   },
                   success : function(data) {

						if (data == '1') {
							alert('保存成功！');
							var PAGESIZE = 20;
							window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
				            window.parent.ACT_DEAL_WINDOW.close();
						} else {
							alert("保存失败，请联系管理员。");
						}

					}
               });
           }
			}
		})
	}) --%>
//获取上传文件名
function getFile(obj,inputName){
	var file_name = $(obj).val();
	$("input[name='"+inputName+"']").val(file_name);
}

$(function(){ 
    var options = {  
        url:'<%=path%>/sfwgl/YsfwFwxx/save',
        //beforeSubmit:  showRequest,  //提交前处理  
        success:       function(data) {
							if(data=='1'){
								alert('保存成功！'); 
								var PAGESIZE = 20;
								window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
					            window.parent.ACT_DEAL_WINDOW.close();
							}else{
								alert("保存失败，请联系管理员。");
								var PAGESIZE = 20;
								window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
					            window.parent.ACT_DEAL_WINDOW.close();
							}
						},  //处理完成 
        resetForm: true,  
        dataType:  'json'  
       };  
    $('#myForm').submit(function() { //注意这里的index_form     
    	$(this).ajaxSubmit(options);      
    	return false;//防止dialog 自动关闭     
    }); 

});


	</script>
<body>
	<div class="wrapper">
		<div class="panel">
			<form action="" class="form-horizontal tasi-form" name="myForm" id="myForm" method="post" enctype="multipart/form-data">
			   <div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label">
					<a class="btn btn-xs btn-success" onclick="openwin();" type="submit"> 收件人 ：</a>
					</label>
					<div class="col-sm-10">
						<input class="form-control" type="hidden"name="yhbh" id="yhbh" 
						style="width:400%;height:30px;">
						<input class="form-control" name="sjr" id="sjr"  placeholder="--请选择--" 
						style="width:400%;height:30px;" onclick="openwin();" >

					</div>
			 </div> 
			 
			 <div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label">
					<a class="btn btn-xs btn-success" onclick="openwin1();" type="submit"> 抄送人 ：</a>
					</label>
					<div class="col-sm-10">
						<input class="form-control" type="hidden"name="yhbh" id="yhbh"  
						style="width:400%;height:30px;">
						<input class="form-control" name="cs" id="cs" placeholder="--请选择--"
						style="width:400%;height:30px;" onclick="openwin1();" >

					</div>
			 </div> 
			 
			 <%--  <div class="panel-body">
				 <label class="col-sm-2 col-sm-2 control-label">
			        <a class="btn btn-xs btn-success" onclick="openswpd (2,'${cs }','${cs }');"  type="submit"> 抄送人：</a>
			     </label>
			      <label class="col-sm-2 col-sm-2 control-label">抄送人：</label> 
				<div class="col-sm-10">
					<input items="${cs}" var="cs" class="form-control" type="text" name="cs" style="width: 200%;" 
							<c:if test="${cs != null}">
								value="${cs }"
							</c:if> 
							<c:if test="${cs != null}">
								value="${cs}"
							</c:if> 
						>
		       </div>
				      
				
				 <label class="col-sm-2 col-sm-2 control-label"
				style="margin-left: 630px; height: 26px; width: 41px; padding-top: 6px;">
					<a class="btn btn-xs btn-success" onclick="openswpd (2,'${cs }','${cs }');" type="submit"
					style="height: 27px; width: 46px; padding: 4px 0px 0px; margin-top: -37px; margin-left: 0px; top:-28px;  margin-bottom: -14px;"> 选择</a>
				</label> 
			</div> --%>    
			
			
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">主题：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="" name="zt" style="width:400%;" >
				</div>
			</div>
			
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">正文：</label>
				<div class="col-sm-10">
					<textarea class="form-control" truetype="textarea"  name="zw" rows="3" style="width:400%;" required data-msg-required="正文不能为空" minlength="1" data-msg-minlength="正文不能为空"></textarea>
				</div>
			</div>
			
			<div class="panel-body">
				<!-- <label class="col-sm-2 col-sm-2 control-label">附件：</label>
				<div class="col-sm-10">
                    <input class="fileComponent" type="file" style="width: 97%; height: 50px; position: absolute; z-index: 20; font-size: 118px;" 
                    	size="16" id="attachMentFile" name="attachMentFile" truetype="file">
                </div> -->
                <label class="col-sm-2 col-sm-2 control-label">附件：</label>
                        <div class="box">
                                <input type="text" name="copyFile"  class="textbox" />
					            <a href="javascript:void(0);"  class="link" style="width:18px;height:28px;">...</a>
					            <input type="file" class="uploadFile" name="attachMentFile" id="attachMentFile"
					             onchange="getFile(this,'copyFile')" />
						</div>
						
				<label class="col-sm-2 col-sm-2 control-label" style="width: 70%; left: -30px; top: -27px;">发文单位：</label>
				<div class="col-sm-10" style="top: -27px;">
					<input class="form-control" type="text" value="" name="bmbh"  style="margin-left: -30px;">
				</div>
            </div>
            
            <div class="panel-body">
				
			</div>
            
			<div>
			  <label class="col-sm-2 col-sm-2 control-label" style="padding-left: 0px; width: 62px;"></label>
				<div class="col-sm-10">
						<!--拉取当前时间到文本框  -->
						<%
							Date date = new Date();
							SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String strdate = sdate.format(date);
						%>
						<input type="hidden" value="<%=strdate%>" name="fssj" class="form-control"
							onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
				</div>
			</div>
			 <div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label"></label>
				<div class="col-sm-10">
					<input class="form-control" type="hidden" value="" name="fwr">
				</div>
				
			</div>
			<div style="text-align: center">
				<div class="panel-body">
					
<!-- 					<input class="btn btn-success" value="提交" type="button" onclick="save(0);"> -->
					 <input class="btn btn-success" value="提交" type="submit">
					 <input class="btn btn-success" type="button" onclick="self.close();" value="返回">
				</div>
			</div>
			</form>
		</div>
	
	</div>
	

	</div>
</body>
</html>
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

function openwin() {  
    //var id = $("#id").val(); 
    location.href="Yh";
} 

$(function(){ 
    var options = {  
        url:'<%=path%>/sfwgl/YsfwHfb/save',
        //beforeSubmit:  showRequest,  //提交前处理 
        success:       function(data) {
							if(data=='1'){
								alert('保存成功！'); 
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
  
    $('#myForm').submit(function() { //注意这里的index_form     
    	$(this).ajaxSubmit(options);      
    	return false;//防止dialog 自动关闭     
    }); 
});


	</script>
<body>
	<div class="wrapper">
		<div class="panel">
			<header class="panel-heading"> 回复信息 </header>
				<form action="" class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
				<input type="hidden" name="id" id="id" value="${hfxx.id }">
			<div class="panel-body">
				<!-- <form class="form-horizontal tasi-form" method="get"> -->
					<label class="col-sm-2 col-sm-2 control-label">回复内容 ：</label>
					<div class="col-sm-10">
						<textarea class="form-control" truetype="textarea"   name="hfbr" rows="3" style="width:450%;height:200px;" required data-msg-required="回复内容不能为空" minlength="1" data-msg-minlength="回复内容不能为空"></textarea>
					</div>
			</div>
		
            
	       <div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">回复时间：</label>
				<div class="col-sm-10">
						<!--拉取当前时间到文本框  -->
						<%
							Date date = new Date();
							SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String strdate = sdate.format(date);
						%>
						<input type="text" value="<%=strdate%>" name="hfsj" class="form-control"
							onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
				</div>
				
				<label class="col-sm-2 col-sm-2 control-label"  style="padding-left: 49px;margin-left: -32px; width: 113px;">回复人：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="" name="hfr">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">附件：</label>
				<div class="col-sm-10">
                    <input class="fileComponent" type="file" style="width: 97%; height: 35px;margin-left: -32px; position: absolute; z-index: 20; font-size: 118px; opacity: 0; left: 0px; top: 0px;" 
                    	siez="16" id="attachMentFile" name="attachMentFile" truetype="file">
                </div>
			</div>
			 
			<div style="text-align: center">
				<div class="panel-body"  style="padding-top: 22px; padding-left: 0px; padding-bottom: 0px;">
					
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
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
<script type="text/javascript"src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>

<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css">
<script type="text/javascript" src="<%=path%>/resources/js/jquery.easyui.min.js"></script>
<script type="text/javascript"src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>

<link type="text/css" rel="stylesheet"href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet"href="<%=path%>/resources/css/jygl/style.css">
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

$(function() {

	  //ComboTree控件初始化
		$('#ks_id').combotree({
			url: '<%=path%>/test/xlsList?optype=getchildtree',
	    'onLoadSuccess': function(node,data){ 
	    //在panel控件load完成的时候处理当前显示值，如果不处理，则combotree1的显示值有可能会不正确
		        if(data.length>0){
				       var val = "1"; //jsp页面初始化时combotree1的初始id值
			         var txt = $('#ks_id').combotree('getText'); //combotree1当前的显示text值

			        //当首次进入这个jsp页面，在combotree1还没有执行url获取jason树数据时，
			        //由于控件的处理机制，其内部的panel控件已经在进行初始化了，不过此时参数node=null,data=null
			        //而在第一次执行url获取了jason树数据之后，因为combotree1尚未设置node，因此此时node=null,但是data != null
			        //而初始化之后，在下拉列表onchange时,此时node!=null，而且data != null
			        //因此可以通过此种变化规则获取id=val时对应的text显示值
			        //(此处的说明比较绕口，你可以先尝试去掉这个'onLoadSuccess'事件，
			        //然后测试一下当前显示值在jsp页面初始化、点击父节点打开子节点列表、findforward返回时的变化情况就知道了^_^)
	             if(val != "" && val==txt){
	   			        //combotree1只有在data中找到id=val对应的node节点，显示值才会变为node的text属性值，否则只显示为id=val值
	             	  //此时data中不包含id=val对应的node节点，因此需要单独通过ajax获取id=val时的text值
	                var urlstr = "<%=path%>/test/xlsList" +"?optype=gettext&id="+val;
	                $.get(urlstr,
	                      function(gettxt){
	                	      if(gettxt!="")
	             	            $('#ks_id').combotree('setText',gettxt);
	                      }  
	                  );
	               }
		        }
			},/*,
			'onChange': function(n,o){
				  //变更当前节点，触发变更事件处理
			    dochange();
			 }*/
		});

		
	});
function close(){
	var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
    window.parent.ACT_DEAL_WINDOW.close();
}


function update(type){

	var url="";
	var msg="";
	
	if(type==0){
		url="<%=path%>/bzxx/YsfBzxx/update";
		msg="确定要提交行业信息吗？";
	
	
	if (confirm(msg)) {
		//getMrjh();
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : $('#myForm').serialize(),// 你的formid
			async : false,
			/* error : function(request) {
				alert("保存失败，请联系管理员。");
			}, */
			success : function(data) {
				
				if(data=='1'){
					alert('保存成功！'); 
					var PAGESIZE = 20;
					window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
		            window.parent.ACT_DEAL_WINDOW.close();
				}else{
					alert("保存失败，请联系管理员。");
				}
				
			}
		});
	}
	}
}
	</script>
	</head>
<body>
		<div class="wrapper">
		<div class="panel" style="margin-bottom: 1px;">
		<div style="text-align:center;margin-bottom:-2px"></div>
			<form action="" class="form-horizontal tasi-form" name="myForm"id="myForm" method="post">
			 <c:forEach var="bzxx" items="${bzxx}" varStatus="obj">
			<input type="hidden" name="id" id="id" value="${bzxx.id }">
				<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 300%;">
					<label class="col-sm-2 col-sm-2 control-label"  style="width: 117px; border-left-width: 0px; padding: 3px 0px 0px 9px; height: 19px; border-top-width: 0px; margin-left: 6px; margin-top: 4px;">收费标准编号：</label> 
					<div class="col-sm-10">
						<textarea rows="1" truetype="textarea" class="form-control"  name="sfbzbh" required data-msg-required="收费标准编号不能为空" minlength="1" data-msg-minlength="收费标准编号不能为空">${bzxx.sfbzbh }</textarea>
					</div>
				</div>
				

				<div class="form-group"  style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 300%;">
					<label class="col-sm-2 col-sm-2 control-label"style="width: 117px; border-left-width: 0px; padding: 3px 0px 0px 9px; height: 19px; border-top-width: 0px; margin-left: 6px; margin-top: 4px;">产品名称：</label>
					<div class="col-sm-10">
						<textarea rows="2" truetype="textarea" class="form-control"  name="cpmc" required data-msg-required="产品名称不能为空" minlength="1" data-msg-minlength="产品名称不能为空">${bzxx.cpmc }</textarea>
					</div>
				</div>
				
				<%-- <div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">产品类型：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value="${bzxx.cplx }" name="cplx">
					</div>
				</div> --%>
			
				<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 300%;">
					<label class="col-sm-2 col-sm-2 control-label"style="width: 117px; border-left-width: 0px; padding: 3px 0px 0px 9px; height: 19px; border-top-width: 0px; margin-left: 6px; margin-top: 4px;">规格型号：</label>
					<div class="col-sm-10">
						<textarea rows="2" truetype="textarea" class="form-control"  name="ggxh">${bzxx.ggxh }</textarea>
					</div>
				</div>
			
				<div style="text-align: center">
					<div class="panel-body" style="margin-left: -220px;">
						<input class="btn btn-success" value="提交" type="submit"> 
						<input class="btn btn-success"type="button" onclick="javascript:window.close();" value="关闭">
					</div>
				</div>
				</c:forEach>
			</form>
			
		</div>
		
	</div>

	</div>
</body>
</html>

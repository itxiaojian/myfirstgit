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
<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery-1.10.2.min.js"></script>
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
<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery.validate.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/yz/yzstyle.css">


<script>

$(function() {

	  //ComboTree控件初始化
		$('#ks_id').combotree({
			url: '<%=path%>/test/ssksList?optype=getchildtree',
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
			},
			'onChange': function(n,o){
				$("#ksbh").val(n);
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
	});
	
	
function save() {
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/cwgl/YCwYgfl/update";
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
				alert('修改成功！');
				var PAGESIZE = 20;
				window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	            window.parent.ACT_DEAL_WINDOW.close();
			} 
		});
	}

} 

//退出
function exit(){
    window.parent.ACT_DEAL_WINDOW.close();
}

</script>
</head>
<body >
<div class="wrapper">
	<div class="panel">
	<!-- <header class="panel-heading" style="padding-left: 650px;"> 员工工资薪金</header> -->
		<div class="panel-body">
		<div style="text-align:center;margin-bottom:10px">
		</div>
		<form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post" >
			<c:forEach var="ygfl" items="${ygfl}" varStatus="obj">
			<input type="hidden" name="id" id="id" value="${ygfl.id }">
			<input type="hidden" name="ksbh" id="ksbh" value="${ygfl.ks_id}">
			<div class="hidden"  style="padding-bottom: 0px;padding-left: 0px; display:none;">
					<input class="form-control" type="hidden" id="lrrq" name="lrrq" value="${ygfl.lrrq }" 
					       onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
					<input class="form-control" type="hidden" id="lrr" name="lrr" value="${ygfl.lrr }">
			</div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;width:100%;">
				<label class="col-sm-2 col-sm-2 control-label"  >所属科室：</label>
					<div class="col-sm-10" >
						<input id="ks_id" name="ks_id" class="easyui-combotree" style="height: 34px;width: 238px;" value="${ygfl.ksmc }"/>
					</div>
				<label class="col-sm-2 col-sm-2 control-label">员工姓名：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ygxm" name="ygxm" value="${ygfl.ygxm }">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;width:100%;">
				<label class="col-sm-2 col-sm-2 control-label" >所属月份：</label>
				<div class="col-sm-10">
					<input class="form-control Wdate" type="text" id="ssyf" name="ssyf"
                           onClick="WdatePicker({dateFmt:'yyyy-MM'})" value="${ygfl.ssyf }" >       
				</div>
				<label class="col-sm-2 col-sm-2 control-label">工资薪金名称：</label>
				<div class="col-sm-10">
                    <select class="form-control input-lg m-bot15" name="gzxjmc" id="gzxjmc" >
                    	<option selected = "selected" value="">请选择...</option>
						<c:forEach items="${fllx}" var="fllx">
               				<c:choose>
                   			<c:when test="${fllx.zdz == ygfl.gzxjmc}">
                         		<option selected = "selected" value="${fllx.zdz}">${fllx.zdmc}</option>
                   			</c:when>
                   			<c:otherwise>
                         		<option value="${fllx.zdz}">${fllx.zdmc}</option>
                   			</c:otherwise>
                   			</c:choose>
                        </c:forEach> 
                    </select>
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;width:100%;">
				<label class="col-sm-2 col-sm-2 control-label">金额：</label>
				<div class="input-group m-bot15 col-sm-10">
					<input class="form-control" type="text" value="${ygfl.flhj }" id="flhj" name="flhj">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">工资薪金详情：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="gzxjxq" name="gzxjxq" value="${ygfl.gzxjxq }"  />
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;width:100%;">
				<label class="col-sm-2 col-sm-2 control-label">备注：</label>
                <div class="col-sm-13">
					<textarea class="form-control ckeditor textarea" rows="3" name="bz" truetype="textarea" >${ygfl.bz }</textarea>
                </div>
			</div>
	 
			<div style="margin: 20px; margin-bottom: 10px; margin-left: 35%;">
				<input class="btn btn-success" value="提交" type="button" onclick="save();">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="btn btn-success" value="关闭" type="button" onclick="exit();">
		    </div>
		    </c:forEach>
		</form>
		</div>
	</div>
</div>

</body>
</html>
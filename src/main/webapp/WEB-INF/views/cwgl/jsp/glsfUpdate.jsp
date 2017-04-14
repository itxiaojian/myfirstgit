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
<body >
	<div class="wrapper">
	<div class="panel" style="margin-bottom: 1px;">
		<div class="panel-body">
			<div style="text-align:center;margin-bottom:-2px"></div>
			<c:forEach var="glsf" items="${glsf}" varStatus="obj">
                <form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
                <input type="hidden" name="id" id="id" value="${glsf.id}">
                <input type="hidden" name="sfrq" id="sfrq" value="${glsf.sfrq}">
                <input type="hidden" name="sfr" id="sfr" value="${glsf.sfr}">
                <input type="hidden" name="bmbh" id="bmbh1" value="${glsf.bmbh}">
					<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>部门名称：</label>
						<div class="col-sm-10">
						<input id="bmbh" name="bmbh1" class="easyui-combotree" value="${glsf.bmbh}" style="width:221%;height: 34px;"/>
<!-- 							<select id="selectedRoleId" class="form-control" name="bmbh" > -->
<%--                             <c:forEach items="${glbm}" var="glbm"> --%>
<%--                                 <c:choose> --%>
<%--                                          <c:when test="${glbm.bmmc == glsf.bmbh}"> --%>
<%--                                                <option selected = "selected" value="${glbm.bmbh}">${glbm.bmmc}</option> --%>
<%--                                          </c:when> --%>
<%--                                          <c:otherwise> --%>
<%--                                                <option value="${glbm.bmbh}">${glbm.bmmc}</option> --%>
<%--                                          </c:otherwise> --%>
<%--                                </c:choose> --%>
<%--                            </c:forEach>  --%>
<!--                            </select> -->
						</div>
						<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>发票号码：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="fphm" name="fphm" value ="${glsf.fphm}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">收入分类：</label>
						<div class="col-sm-10">
							<select id="selectedRoleId" class="form-control" name="srfl" >
                            <c:forEach items="${srfl}" var="srfl">
                                <c:choose>
                                         <c:when test="${srfl.zdz == glsf.srfl}">
                                               <option selected = "selected" value="${srfl.zdz}">${srfl.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${srfl.zdz}">${srfl.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">收费项目名称：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="sfxmmc" name="sfxmmc" value ="${glsf.sfxmmc}">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">收费金额（元）：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" onkeyup="value=value.replace(/[^\d]/g,'') "   
                                   onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"   
                             id="sfje" name="sfje" value ="${glsf.sfje}"> 
						</div>
<!-- 						<label class="col-sm-2 col-sm-2 control-label">缴费日期：</label> -->
<!-- 						<div class="col-sm-10"> -->
<%-- 							<input class="form-control Wdate" type="text" id="sfrq" name="sfrq" value ="${glsf.sfrq}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" --%>
<!-- 							 onkeyup="value=value.replace(/[^\d]/g,'') "    -->
<!--                                    onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" > -->
<!-- 						</div> -->
					</div>
					<div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
					   <label class="col-sm-2 col-sm-2 control-label">凭据分类：</label>
						<div class="col-sm-10">
                            <c:if test="${glsf.pjfl != null}">
							<select id="selectedRoleId" class="form-control" name="pjfl">
                            <c:forEach items="${pjfl}" var="pjfl">
                                <c:choose>
                                         <c:when test="${pjfl.zdz == glsf.pjfl}">
                                               <option selected = "selected" value="${pjfl.zdz}">${pjfl.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${pjfl.zdz}">${pjfl.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${glsf.pjfl == null}">
                           <select class="form-control input-lg m-bot15" name="pjfl" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="pjfl" items="${pjfl}" varStatus="obj">
										<option value="${pjfl.zdz }">${pjfl.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
                        </div>
					   <label class="col-sm-2 col-sm-2 control-label">凭据号码：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="pjhm" name="pjhm"  value ="${glsf.pjhm}">
						</div>
					</div>
					<div class="form-group" style="padding-bottom: 2px;margin-bottom: 0px;padding-top: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="6" name="bz" 
							truetype="textarea" style="width: 99%;height: 35px;">${glsf.bz}</textarea>
						</div>
					</div>
					<div style="text-align: center">
						<div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 75px;">
							<input class="btn btn-success" value="提交" type="button" onclick="save();">
					        <input class="btn btn-success" type="button" onclick="exit();" value="返回">
						</div>
					</div>
				</form>
				</c:forEach>
		  </div>
	   </div>
    </div>
</body>
<script>
//获取上传文件名
function getFile(obj,inputName){
	var file_name = $(obj).val();
	$("input[name='"+inputName+"']").val(file_name);
}

//二维码图片
$(function(){
	var str = "${url}";
	$("#code").qrcode({
		width: 100,
		height:100,
		text: str
	});
});

$(function() {
	  //ComboTree控件初始化
		$('#bmbh').combotree({
			url: '<%=path%>/test/ssksList?optype=getchildtree',
	    'onLoadSuccess': function(node,data){ 
	    //在panel控件load完成的时候处理当前显示值，如果不处理，则combotree1的显示值有可能会不正确
		        if(data.length>0){
				       var val = ""; //jsp页面初始化时combotree1的初始id值
			         var txt = $('#bmbh').combotree('getText'); //combotree1当前的显示text值

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
	             	            $('#bmbh').combotree('setText',gettxt);
	                      }  
	                  );
	               }
		        }
			},
			'onChange': function (n, o) {
                $("#bmbh1").val(n);
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


//返回
function exit(){
	/* var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
}

//提交
 function save() {
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/cwgl/YcwGlbmsf/update";
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
</style>

</html>

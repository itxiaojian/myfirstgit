<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.qrcode.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery.validate.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/yz/yzstyle.css">
</head>
<script type="text/javascript">
function close(){
	var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
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
function update(type){

	var url="";
	var msg="";
	
	if(type==0){
		url="<%=path%>/khgl/YKhHyxx/update";
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
				
				if(data=='0'){
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
		var url = "<%=path%>/khgl/YKhHyxx/update";
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : $('#myForm').serialize(),// 你的formid
			async : false,
			error : function(request) {
				alert("修改失败,请联系管理员。");
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

//下面是一些常用的验证规则扩展

/*-------------验证插件配置 懒人建站http://www.51xuediannao.com/-------------*/

//配置错误提示的节点，默认为label，这里配置成 span （errorElement:'span'）
$.validator.setDefaults({
	errorElement:'span'
});

//配置通用的默认提示语
$.extend($.validator.messages, {
	required: '必填',
	equalTo: "请再次输入相同的值"
});

/*-------------扩展验证规则 懒人建站http://www.51xuediannao.com/-------------*/
//邮箱
jQuery.validator.addMethod("mail", function (value, element) {
	var mail = /^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$/;
	return this.optional(element) || (mail.test(value));
}, "邮箱格式不对");

//电话验证规则
jQuery.validator.addMethod("phone", function (value, element) {
	var phone = /^0\d{2,3}-\d{7,8}$/;
	return this.optional(element) || (phone.test(value));
}, "电话格式如：0371-68787027");

//区号验证规则
jQuery.validator.addMethod("ac", function (value, element) {
	var ac = /^0\d{2,3}$/;
	return this.optional(element) || (ac.test(value));
}, "区号如：010或0371");

//无区号电话验证规则 
jQuery.validator.addMethod("noactel", function (value, element) {
	var noactel = /^\d{7,8}$/;
	return this.optional(element) || (noactel.test(value));
}, "电话格式如：68787027");

//手机验证规则
jQuery.validator.addMethod("mobile", function (value, element) {
	var mobile = /^1[3|4|5|7|8]\d{9}$/;
	return this.optional(element) || (mobile.test(value));
}, "手机格式不对");

//邮箱或手机验证规则
jQuery.validator.addMethod("mm", function (value, element) {
	var mm = /^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/;
	return this.optional(element) || (mm.test(value));
}, "格式不对");

//电话或手机验证规则
jQuery.validator.addMethod("tm", function (value, element) {
	var tm=/(^1[3|4|5|7|8]\d{9}$)|(^\d{3,4}-\d{7,8}$)|(^\d{7,8}$)|(^\d{3,4}-\d{7,8}-\d{1,4}$)|(^\d{7,8}-\d{1,4}$)/;
	return this.optional(element) || (tm.test(value));
}, "格式不对");

//年龄
jQuery.validator.addMethod("age", function(value, element) {
	var age = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
	return this.optional(element) || (age.test(value));
}, "不能超过120岁");
///// 20-60   /^([2-5]\d)|60$/

//传真
jQuery.validator.addMethod("fax",function(value,element){
	var fax = /^(\d{3,4})?[-]?\d{7,8}$/;
	return this.optional(element) || (fax.test(value));
},"传真格式如：0371-68787027");

//验证当前值和目标val的值相等 相等返回为 false
jQuery.validator.addMethod("equalTo2",function(value, element){
	var returnVal = true;
	var id = $(element).attr("data-rule-equalto2");
	var targetVal = $(id).val();
	if(value === targetVal){
		returnVal = false;
	}
	return returnVal;
},"不能和原始密码相同");

//大于指定数
jQuery.validator.addMethod("gt",function(value, element){
	var returnVal = false;
	var gt = $(element).data("gt");
	if(value > gt && value != ""){
		returnVal = true;
	}
	return returnVal;
},"不能小于0 或空");

//汉字
jQuery.validator.addMethod("chinese", function (value, element) {
	var chinese = /^[\u4E00-\u9FFF]+$/;
	return this.optional(element) || (chinese.test(value));
}, "格式不对");

//指定数字的整数倍
jQuery.validator.addMethod("times", function (value, element) {
	var returnVal = true;
	var base=$(element).attr('data-rule-times');
	if(value%base!=0){
		returnVal=false;
	}
	return returnVal;
}, "必须是发布赏金的整数倍");

//身份证
jQuery.validator.addMethod("idCard", function (value, element) {
	var isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;//(15位)
	var isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;//(18位)

	return this.optional(element) || (isIDCard1.test(value)) || (isIDCard2.test(value));
}, "格式不对");
</script>
<body>
	<div class="wrapper">

		<div class="panel">
			<header class="panel-heading"></header>
			<form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
<%-- 			<c:forEach var="hyxx" items="${hyxx}" varStatus="obj"> --%>
			      <input type="hidden" name="id" id="id" value="${hyxx.id }">
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
				<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>行业名称：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="${hyxx.hymc}" id="hymc" name="hymc"  required data-msg-required="行业名称必填" minlength="1" data-msg-minlength="行业名称必填">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
				<label class="col-sm-2 col-sm-2 control-label" >所属分类：</label>
						<div class="col-sm-10">
						  <c:if test="${hyxx.ssfl != 1}">
						    <select id="selectedRoleId" class="form-control" name="ssfl">
                            <c:forEach items="${ssfl}" var="ssfl">
                                <c:choose>
                                         <c:when test="${ssfl.hymc == hyxx.ssfl}">
                                               <option selected = "selected" value="${ssfl.hymc}">${ssfl.hymc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${ssfl.hymc}">${ssfl.hymc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach>
                           </select>
                          </c:if>
                          <c:if test="${hyxx.ssfl == 1}">
						    <select id="selectedRoleId" class="form-control" name="ssfl">
                            <c:forEach items="${ssfl}" var="ssfl">
                                <c:choose>
                                         <c:when test="${hyxx.ssfl == 1}">
                                               <option selected = "selected" value="${hyxx.ssfl}">一级分类</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${ssfl.hymc}">${ssfl.hymc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach>
                           </select>
                          </c:if>
						</div>
			</div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
				<label class="col-sm-2 col-sm-2 control-label" >分类级别：</label>
						<div class="col-sm-10">
						    <select id="selectedRoleId" class="form-control" name="jb">
                            <c:forEach items="${jb}" var="jb">
                                <c:choose>
                                         <c:when test="${jb.zdz == hyxx.jb}">
                                               <option selected = "selected" value="${jb.zdz}">${jb.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${jb.zdz}">${jb.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach>
                           </select>
						</div>
			</div>
			<div class="form-group"style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
				<label class="col-sm-2 col-sm-2 control-label">备注：</label>
				<div class="col-sm-10">
					<textarea class="form-control" truetype="textarea" id="bz" value="${hyxx.bz}" name="bz" rows="3" style="height:100px;">${hyxx.bz }</textarea>
				</div>
			</div>

			<div style="text-align: center">
				<div class="panel-body" style="margin-left: -47px; margin-top: 16px;">
					<button type="button" class="btn btn-primary"onClick="save()">提交</button>
					<button type="button" class="btn btn-success"onClick="exit();">返回</button>
				</div>
			</div>
<%-- 			</c:forEach> --%>
</form>
		</div>
	</div>
	</div>
</body>
</html>




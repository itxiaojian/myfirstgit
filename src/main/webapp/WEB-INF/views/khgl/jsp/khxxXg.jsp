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

 $(function(){
	//jquery.validate
	$("#myForm").validate({
		submitHandler: function() {
			//验证通过后 的js代码写在这里
		  /* if ($("#khbh").val() == "") {
              alert("信息填写不完整！");
              return false;
          }  
          if ($("#khmc").val() == "") {
              alert("信息填写不完整！");
              return false;
          }
          if ($("#sr").val() == "") {
              alert("信息填写不完整！");
              return false;
          }  
          if ($("#lrsj").val() == "") {
              alert("信息填写不完整！");
              return false;
          }
          if ($("#clsj").val() == "") {
              alert("信息填写不完整！");
              return false;
          }
          if ($("#zjhm").val() == "") {
              alert("信息填写不完整！");
              return false;
          }
          if ($("#lxr").val() == "") {
              alert("信息填写不完整！");
              return false;
          } */
         
         
          msg = "确定要提交？";
          msg1="该证件号码已存在是否重复录入？";
          if (confirm(msg)) {
              var url = "<%=path%>/khgl/YKhKhxx/update";
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
						}else if(confirm(msg1)) {
					              var url = "<%=path%>/khgl/YKhKhxx/update1";
					              $.ajax({
					                  cache: true,
					                  type: "POST",
					                  url: url,
					                  data: $('#myForm').serialize(),// 你的formid
					                  async: false,
					                  error: function (request) {
					                      alert("保存失败,请联系管理员!");
					                  },
					                  success : function(data) {
											if (data == '1') {
												alert('保存成功!');
												var PAGESIZE = 20;
												window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
									            window.parent.ACT_DEAL_WINDOW.close();
											} 
											 else {
												alert("保存失败!");
											} 

										}
					              });
					          }

					}
              });
          }
		}
	})
}) 

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
	<% Date date = new Date();
     SimpleDateFormat edate = new SimpleDateFormat("yyyy");
     String year = edate.format(date);%>
<body>
		<div class="wrapper">
		<div class="panel">
		<header class="panel-heading" style=" padding-bottom: 0px;"><b style="font-size: 19px;margin-left: 45%;">客户档案</b></header>
		<c:forEach var="khxx" items="${khxx}" varStatus="obj">
		<header class="panel-heading" style="padding-top: 0px; padding-bottom: 0px;"><b style="font-size: 13px;margin-left: 38%;">主体信息（客户编号：${khxx.khbh}<span style="color:red">*</span>）</b></header>
			<form action="" class="form-horizontal tasi-form bl-form bl-formhor" name="myForm" id="myForm" method="post">
			<input type="hidden" name="id" id="id" value="${khxx.id}">
			<input type="hidden" name="khbh" id="khbh" value="${khxx.khbh}">
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
				<label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>单位/个人：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="khmc" name="khmc" value="${khxx.khmc}" required data-msg-required="单位名称必填" minlength="1"  style="width:110%;">
				</div>
				 <label class="col-sm-2 col-sm-2 control-label">客户生日：</label>
                  <div class="col-sm-10">
                  <input class="form-control Wdate" style="width:110%;" type="text" id="sr" name="sr"value="${khxx.sr}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" >
                  </div>
				<label class="col-sm-2 col-sm-2 control-label">省市县区：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" style="width:110%;" id="ds" name="ds"value="${khxx.ds}">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
			      <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>详细地址：</label>
				  <div class="col-sm-10">
					<input class="form-control" type="text" style="width:110%;" id="khdz" name="khdz" value="${khxx.khdz}" required data-msg-required="详细地址必填" minlength="1" >
				  </div>
				  <label class="col-sm-2 col-sm-2 control-label">单位网址：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" style="width:110%;" id="dwwz" name="dwwz" value="${khxx.dwwz}">
					</div>
				  <label class="col-sm-2 col-sm-2 control-label">成立时间：</label>
                  <div class="col-sm-10">
                  <input class="form-control Wdate" type="text" id="clsj" name="clsj" value="${khxx.clsj}" style="width:110%;" onClick="WdatePicker({dateFmt:' yyyy-MM-dd'})" >
                  </div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
			   <label class="col-sm-2 col-sm-2 control-label">单位性质：</label>
					<div class="col-sm-10">
						<select id="selectedRoleId" class="form-control" id="dwxz" name="dwxz" style="font-size:12px; height:25px;width:110%;">
                            <c:forEach items="${dwxz}" var="dwxz" >
                                <c:choose>
                                         <c:when test="${dwxz.zdmc == khxx.dwxz}">
                                               <option selected = "selected" value="${dwxz.zdmc}">${khxx.dwxz}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${dwxz.zdmc}">${dwxz.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach>
                           </select>
	                </div>
	            <label class="col-sm-2 col-sm-2 control-label">主导产品：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" id="jycpmc" value="${khxx.jycpmc}" name="jycpmc" style="width:110%;">
				    </div>
			      <label class="col-sm-2 col-sm-2 control-label">注册资金(元)：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="${khxx.zczj}" name="zczj" style="width:110%;" onkeyup="value=value.replace(/[^\d]/g,'') "   
                                   onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" >
				</div>
			   </div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
			    <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>业务金额(元)：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="ywje" name="ywje" value="${khxx.ywje}" style="width:110%;"onkeyup="value=value.replace(/[^\d]/g,'') "   
                                   onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"required data-msg-required="业务金额必填" minlength="1">
			    </div>
			    <label class="col-sm-2 col-sm-2 control-label">客户等级：</label>
				<div class="col-sm-10">
					<select id="selectedRoleId" class="form-control" id="khfl" name="khfl" style="font-size:12px; height:25px;width:110%;">
                            <c:forEach items="${khfl}" var="khfl" >
                                <c:choose>
                                         <c:when test="${khfl.hymc == khxx.khfl}">
                                               <option selected = "selected" value="${khfl.hymc}">${khxx.khfl}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${khfl.hymc}">${khfl.hymc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach>
                           </select>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">预登记账号：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" style="width:110%;" id="ydjzh" name="ydjzh" value="${khxx.khbh}" readonly="readonly">
				</div>
			</div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
				<label class="col-sm-2 col-sm-2 control-label" >证件类型：</label>
				<div class="col-sm-10" >
					<select id="selectedRoleId" class="form-control" id="zjlx" name="zjlx" style="font-size:12px; height:25px;width:110%;">
                            <c:forEach items="${zjlx}" var="zjlx" >
                                <c:choose>
                                         <c:when test="${zjlx.zdz == khxx.zjlx}">
                                               <option selected = "selected" value="${zjlx.zdz}">${khxx.zjlx}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${zjlx.zdz}">${zjlx.zdz}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach>
                           </select>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">证件号码：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" style="width:110%;" value="${khxx.zjhm}" name="zjhm">
				</div>
				</div>
				<div class="form-group" style="padding-bottom: 3px;margin-bottom: 14px;margin-top: 4px; width: 100%;">
					<label class="col-sm-2 col-sm-2 control-label">备注信息：</label>
					<div class="col-sm-10">
						<textarea class="form-control"   truetype="textarea"  name="bz" rows="1" style="width:400%; ">${khxx.bz}</textarea>
					</div>
				</div>
				<header class="panel-heading" style="padding-top: 0px; padding-bottom: 0px;"><b style="font-size: 13px;margin-left: 46%;">联系信息</b></header>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%; ">
			    <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">法人姓名：</label>
				<div class="col-sm-10" >
					<input class="form-control" type="text" id="frxm" name="frxm" value="${khxx.frxm}" style="width:110%;">
			    </div>
			    <label class="col-sm-2 col-sm-2 control-label" >联络人员：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" style="width:110%;" id="lxr" name="lxr" value="${khxx.lxr}">
				</div>
			</div>
			
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
				<label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">手机号码：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="sjhm" name="sjhm" value="${khxx.sjhm}" style="width:110%;"   placeholder="请输入正确的手机号码格式" data-rule-mobile="true" 
                                                        data-msg-mobile="请输入正确的格式">
				</div>
				<label class="col-sm-2 col-sm-2 control-label" >手机号码：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="sjhm1" name="sjhm1" value="${khxx.sjhm1}" style="width:110%;"   placeholder="请输入正确的手机号码格式" data-rule-mobile="true" 
                                                        data-msg-mobile="请输入正确的格式">
				</div>
			</div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
			<label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">固定电话：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="${khxx.gddh}" name="gddh" style="width:110%;" onkeyup="value=value.replace(/[^\d]/g,'') "   
                                   onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
				</div>
			<label class="col-sm-2 col-sm-2 control-label" >固定电话：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="gddh1" name="gddh1" value="${khxx.gddh1}" style="width:110%;" onkeyup="value=value.replace(/[^\d]/g,'') "   
                                   onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
				</div>
		    </div>
		    <div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
		        <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">传真号码：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="cz" name="cz" value="${khxx.cz}" style="width:110%;" data-rule-fax="true" 
                                                        data-msg-fax="请输入正确的传真格式" data-msg-minlength="请输入正确的传真格式" >
				</div>
				<label class="col-sm-2 col-sm-2 control-label" >传真号码：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="cz1" name="cz1" value="${khxx.cz1}" style="width:110%;" data-rule-fax="true" 
                                                        data-msg-fax="请输入正确的传真格式" data-msg-minlength="请输入正确的传真格式" >
				</div>
		    
		    </div>
		    <div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
		        <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">电子邮箱：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="dzyx" name="dzyx" value="${khxx.dzyx}" style="width:110%;" >
				</div>
				<label class="col-sm-2 col-sm-2 control-label" >电子邮箱：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="dzyx1" name="dzyx1" value="${khxx.dzyx1}" style="width:110%;">
				</div>
		    
		    </div>
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 100%;">
		        <label class="col-sm-2 col-sm-2 control-label" style="margin-left: 16%;">法人QQ：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="frqq" name="frqq" value="${khxx.frqq}" style="width:110%;"onkeyup="value=value.replace(/[^\d]/g,'') "   
                          onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
				</div>
				<label class="col-sm-2 col-sm-2 control-label" >联络QQ：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="llqq" name="llqq" value="${khxx.llqq}" style="width:110%;" onkeyup="value=value.replace(/[^\d]/g,'') "   
                          onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" >
				</div>
		    
		    </div>
		    
			<div style="text-align: center">
				<div class="form-group"  style="margin-top: 10px; margin-left: -7%; width: 110%;">
					<input class="btn btn-success" value="提交" type="submit" >
                    <input class="btn btn-success" type="button" onclick="self.close();" value="关闭">
				</div>
			</div>
			</form>
			</c:forEach>
		</div>
	</div>

	</div>
</body>
</html>
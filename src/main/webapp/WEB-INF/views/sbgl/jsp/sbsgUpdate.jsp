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
<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>

<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css">
<script type="text/javascript" src="<%=path%>/resources/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery.validate.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/yz/yzstyle.css">
</head>
<body>
	<div class="wrapper">
	<div class="panel" style="margin-bottom: 1px;">
		<div class="panel-body">
			<div style="text-align:center;margin-bottom:-2px"></div>
                <form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
                <c:forEach var="sbsg" items="${sbsg}" varStatus="obj">
                    <input type="hidden" name="id" id="id" value="${sbsg.id }">
						<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label">申购编号：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" value="${sbsg.sgbh }" name="sgbh"
								style="width: 100%;" id="sgbh" required data-msg-required="不能为空"
								minlength="1" data-msg-minlength="不能为空">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">设备名称：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" value="${sbsg.sbmc }" name="sbmc"
								style="width: 100%;" id="sbmc" required data-msg-required="不能为空"
								minlength="1" data-msg-minlength="不能为空">
						</div>
					</div>

					<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label">设备类型：</label>
						<div class="col-sm-10">
							<c:if test="${sbsg.sblx != null}">
							<select id="selectedRoleId" class="form-control" name="sblx" >
                            <c:forEach items="${sblx}" var="sblx">
                                <c:choose>
                                         <c:when test="${sblx.zdz == sbsg.sblx}">
                                               <option selected = "selected" value="${sblx.zdz}">${sblx.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${sblx.zdz}">${sblx.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${sbsg.sblx == null}">
                           <select class="form-control input-lg m-bot15" name="sblx" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="sblx" items="${sblx}" varStatus="obj">
										<option value="${sblx.zdz }">${sblx.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">设备型号：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" value="${sbsg.sbxh }" name="sbxh"
								style="width: 100%;" id="sbxh">
						</div>
					</div>

					<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label">设备级别：</label>
						<div class="col-sm-10">
							<c:if test="${sbsg.sbjb != null}">
							<select id="selectedRoleId" class="form-control" name="sbjb" >
                            <c:forEach items="${sbjb}" var="sbjb">
                                <c:choose>
                                         <c:when test="${sbjb.zdz == sbsg.sbjb}">
                                               <option selected = "selected" value="${sbjb.zdz}">${sbjb.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${sbjb.zdz}">${sbjb.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${sbsg.sbjb == null}">
                           <select class="form-control input-lg m-bot15" name="sbjb" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="sbjb" items="${sbjb}" varStatus="obj">
										<option value="${sbjb.zdz }">${sbjb.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">使用科室：</label>
						<div class="col-sm-10">
							<c:if test="${sbsg.syks != null}">
						    <select id="selectedRoleId" class="form-control"  name="syks">
                            <c:forEach items="${syks}" var="syks">
                                <c:choose>
                                         <c:when test="${syks.bmbh == sbsg.syks}">
                                               <option selected = "selected" value="${syks.bmbh}">${syks.bmmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${syks.bmbh}">${syks.bmmc}</option>
                                         </c:otherwise>
                               </c:choose>
                            </c:forEach>
                           </select> 
						</c:if>
						<c:if test="${sbsg.syks == null}">
						    <select class="form-control input-lg m-bot15" name="syks" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="syks" items="${syks}" varStatus="obj" >
										<option value="${syks.bmbh }">${syks.bmmc }</option>
								</c:forEach>
					        </select>
						</c:if>
						</div>
					</div>


					<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label">使用范围：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" value="${sbsg.syfw }" name="syfw"
								style="width: 100%; height: 25px;" id="syfw">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">生产厂家：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" value="${sbsg.sccj }" name="sccj"
								style="width: 100%; height: 25px;" id="sccj">
						</div>
					</div>


					<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label">申购日期：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" value="${sbsg.sgrq }"
								name="sgrq" style="width: 100%; height: 25px;" id="sgrq"
								onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">申购价格：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" value="${sbsg.sccj }" name="sccj"
								style="width: 100%; height: 25px;" id="sccj">
						</div>
					</div>



					<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label">设备申购人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" value="${sbsg.sbsgr }" name="sbsgr"
								style="width: 100%; height: 25px;" id="sbsgr">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">到货要求时间：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" value="${sbsg.dhyqsj }"
								name="dhyqsj" style="width: 100%; height: 25px;" id="dhyqsj"
								onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
						</div>
					</div>

					<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label">备注：</label>
						<div class="col-sm-10">
							<textarea class="form-control" truetype="textarea" id="bz"
								name="bz" rows="3" style="width: 280%; height: 120px;">${sbsg.bz }</textarea>
						</div>
					</div>
					
					 <div style="text-align: center">
				<div class="panel-body" style="padding-left: 0px; padding-right: 181px; margin-left: -75px; margin-top: 40px;">
					<input class="btn btn-success" value="提交" type="submit" >
                        <input class="btn btn-success" type="button" onclick="self.exit();" value="关闭">
				</div>
			</div>
			</c:forEach>
				</form>
		  </div>
	   </div>
    </div>
</body>
<script>

$(function() {
	  //ComboTree控件初始化
		$('#syks').combotree({
			url: '<%=path%>/test/ssksList?optype=getchildtree',
	    'onLoadSuccess': function(node,data){ 
	    //在panel控件load完成的时候处理当前显示值，如果不处理，则combotree1的显示值有可能会不正确
		        if(data.length>0){
				       var val = ""; //jsp页面初始化时combotree1的初始id值
			         var txt = $('#syks').combotree('getText'); //combotree1当前的显示text值

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
	             	            $('#syks').combotree('setText',gettxt);
	                      }  
	                  );
	               }
		        }
			}/*,
			'onChange': function(n,o){
				  //变更当前节点，触发变更事件处理
			    dochange();
			 }*/
		});
	});

//返回
function exit(){
	/* var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
}

//提交
<%-- function save() {
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/sbgl/YSbSg/update";
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
				alert('保存成功！');
				var PAGESIZE = 20;
				window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	            window.parent.ACT_DEAL_WINDOW.close();
			}
		});
	}
}  --%>
$(function(){
	//jquery.validate
	$("#myForm").validate({
		submitHandler: function() {
			//验证通过后 的js代码写在这里
		  if ($("#sgbh").val() == "") {
              alert("信息填写不完整！");
              return false;
          }  
          if ($("#sbmc").val() == "") {
              alert("信息填写不完整！");
              return false;
          }
         
          msg = "确定要提交？";
          if (confirm(msg)) {
        	  var url = "<%=path%>/sbgl/YSbSg/update";
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
      				alert('保存成功！');
      				var PAGESIZE = 20;
      				window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      	            window.parent.ACT_DEAL_WINDOW.close();
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
</html>
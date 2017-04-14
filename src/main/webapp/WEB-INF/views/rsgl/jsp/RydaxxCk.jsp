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
<link type="text/css" rel="stylesheet"href="<%=path%>/resources/css/jygl/style.css">
<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery.validate.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/yz/yzstyle.css">
	
    <title>安徽省质检院综合业务管理平台</title>
    <!-- Bootstrap core CSS -->
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap-reset.css">
	<script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.qrcode.min.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<script type="text/javascript">

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
		$('#bmmc').combotree({
			url: '<%=path%>/test/ssksList?optype=getchildtree',
	    'onLoadSuccess': function(node,data){ 
	    //在panel控件load完成的时候处理当前显示值，如果不处理，则combotree1的显示值有可能会不正确
		        if(data.length>0){
				      //jsp页面初始化时combotree1的初始id值
			         var txt = $('#bmmc').combotree('getText'); //combotree1当前的显示text值

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
	             	            $('#bmmc').combotree('setText',gettxt);
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

//返回
function close(){
	/* var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
}

$(function(){
	//jquery.validate
	$("#myForm").validate({
		submitHandler: function() {
			//验证通过后 的js代码写在这里
		  if ($("#rybh").val() == "") {
              alert("信息填写不完整！");
              return false;
          }  
		  if ($("#ryxm").val() == "") {
              alert("信息填写不完整！");
              return false;
          }  
		  if ($("#sr").val() == "") {
              alert("信息填写不完整！");
              return false;
          }  
          msg = "确定要提交？";
          if (confirm(msg)) {
              var url = "<%=path%>/rsgl/YRsRydaxx/update";
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

//提交
<%-- function update() {
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/rsgl/YRsRydaxx/update";
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
	</script>
	</head>
	
	 <style>
  .wbk{
  	border-left:0px;
  	border-top:0px;
  	border-right:0px;
  	border-bottom:1px;
  	box-shadow:0px 0px 0px;
  	margin-left: -9px;
    margin-top: 7px;
    font-size:14px;
  }
  
  .bc{
  	font-weight: 900;
  	text-align: right;
  	padding-top: 9px;
  }
  
  </style>
<body>
	<div class="wrapper">
		<div class="panel">
			<header class="panel-heading" > 人员档案信息 </header>
			<form action="" class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
			<c:forEach var="rydaxx" items="${rydaxx}" varStatus="obj">
			
			<input type="hidden" id="yhbh" name="yhbh" value="${rydaxx.yhbh }">
			<div class="panel-body">
					<label class="col-sm-2 col-sm-2 control-label">登录名：</label>
					<div class="col-sm-10">
						<input class="form-control wbk" type="text" value="${rydaxx.dlm }"  name="dlm" onfocus=this.blur()>
					</div>
					<label class="col-sm-2 col-sm-2 control-label">姓名：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.xm }" name="xm" onfocus=this.blur()>
				</div>
			</div>
			<div class="panel-body">
						<label class="col-sm-2 col-sm-2 control-label">性别：</label>
				       <div class="col-sm-10">
					   <input class="form-control wbk" type="text" value="${rydaxx.xb }" name="xb" onfocus=this.blur()>
				       </div>
			</div>
					
					
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">密码</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.mm }" name="mm" onfocus=this.blur()>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">部门编号：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.bmbh }" name="bmbh" onfocus=this.blur()  >
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label"> 部门名称：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" name="bmmc"  value="${rydaxx.bmmc} "  onfocus=this.blur()>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">手机号：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.sjh }" name="sjh" onfocus=this.blur()>
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">邮箱：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.yx }" name="yx" onfocus=this.blur()>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">最后登录时间：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.zhdlsj }" name="zhdlsj" onfocus=this.blur()>
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">状态：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.yhzt }" name="yhzt" onfocus=this.blur()>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">是否持有上岗证：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.cyzt }" name="cyzt" onfocus=this.blur()>
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">上岗证编号：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.sgzbh }" name="sgzbh" onfocus=this.blur()>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">生日：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.sr }" name="sr" onfocus=this.blur()>
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">联系电话：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.lxdh }" name="lxdh" onfocus=this.blur()>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">职务：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.zw }" name="zw" onfocus=this.blur()>
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">家庭地址：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.jtdz }" name="jtdz" onfocus=this.blur()>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">学历：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.xl }" name="xl" onfocus=this.blur()>
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">毕业院校：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.byyx }" name="byyx" onfocus=this.blur()>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">政治面貌：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.zzmm }" name="zzmm" onfocus=this.blur()>
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">民族：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.mz }" name="mz" onfocus=this.blur()>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">别名：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.bm }" name="bm" onfocus=this.blur()>
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">用户排序号：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.yhpxh }" name="yhpxh" onfocus=this.blur()>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">管理范围：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.glfw }" name="glfw" onfocus=this.blur()>
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">QQ：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.qq }" name="qq" onfocus=this.blur()>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">部门名称：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.bmmc }" name="bmmc" onfocus=this.blur()>
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">电子签名（存DLM.png）：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.dzqm }" name="dzqm" onfocus=this.blur()>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">电子签名图片随机名：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.yhjs }" name="yhjs" onfocus=this.blur()>
				</div>
			</div>
			<div class="panel-body">
				<label class="col-sm-2 col-sm-2 control-label">闲置时间：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.xzsj }" name="xzsj" onfocus=this.blur()>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">电子签名路径：</label>
				<div class="col-sm-10">
					<input class="form-control wbk" type="text" value="${rydaxx.dzqmlj }" name="dzqmlj" onfocus=this.blur()>
				</div>
			</div>
			<div style="text-align: center">
				<div class="panel-body" style="margin-left: -255px; margin-top: 50px;">
				<!-- 	<input class="btn btn-success" value="提交" type="submit" > -->
 
                        <input class="btn btn-success" type="button" onclick="self.close();" value="关闭">
				</div>
			</div>
			</c:forEach>
			</form>
		</div>
	</div>

	</div>
</body>
</html>
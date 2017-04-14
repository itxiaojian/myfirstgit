$(document).ready(function() {

	// 获取JS传递的语言参数
	var utils = new Utils();
	var args = utils.getScriptArgs();

	// 隐藏Loading/登录失败 DIV
	$(".loading").hide();
	$(".login-error").hide();

	// 加载国际化语言包资源
	//utils.loadProperties(args.lang);

	// 输入框激活焦点、移除焦点
	jQuery.focusblur = function(focusid) {
		var focusblurid = $(focusid);
		var defval = focusblurid.val();
		focusblurid.focus(function() {
			var thisval = $(this).val();
			if (thisval == defval) {
				$(this).val("");
			}
		});
		focusblurid.blur(function() {
			var thisval = $(this).val();
			if (thisval == "") {
				$(this).val(defval);
			}
		});

	};
	/* 下面是调用方法 */
	$.focusblur("#email");
	$.focusblur("#password");

	// 获取表单验证对象[填写验证规则]
	var validate = $("#signupForm").validate({
		rules : {
			email : {
				required : true//,
				//email : true
			},
			password : {
				required : true,
				minlength : 4,
				maxlength : 16
			}
		},
		messages : {
			email : {
				required : $.i18n
						.prop("请输入用户名！"),
				email : $.i18n
						.prop("Form.PleaseInputCorrectEmail")
			},
			password : {
				required : $.i18n
						.prop("请输入密码！"),
				minlength : jQuery
						.format($.i18n
								.prop("密码长度少于4个字符，请重新输入！")),
				maxlength : jQuery
						.format($.i18n
								.prop("密码长度大于16个字符，请重新输入！"))
			}
		}
	});

	// 输入框激活焦点、溢出焦点的渐变特效
	if ($("#email").val()) {
		$("#email").prev().fadeOut();
	}

	if ($("#password").val()) {
		$("#password").prev().fadeOut();
	}
	$("#email").focus(function() {
		$(this).prev().fadeOut();
	});
	$("#email").blur(function() {
		if (!$("#email").val()) {
			$(this).prev().fadeIn();
		}
	});
	$("#password").focus(function() {
		$(this).prev().fadeOut();
	});
	$("#password").blur(function() {
		if (!$("#password").val()) {
			$(this).prev().fadeIn();
		}
	});

	// ajax提交登录
	$("#submit").bind("click", function() {
		login(validate);
	});
});

function login(validate) {
	// 校验Email, password，校验如果失败的话不提交
	//var username=$("#email").val();
	//var password=$("#password").val();
	var openId=$("#openId").val();
	var url=$("#url").val();
	if (validate.form()) {
		$.ajax({
			url : "/wxpt/sys/SysWxyh/save",
			type : "post",
			data : {
				username : $("#email").val(),
				password : $("#password").val(),
				openId : openId
			},
			dataType : "json",
			beforeSend : function() {
				$('.loading').show();
			},
			success : function(data) {
				$('.loading').hide();
				if (data=="1") {
						//window.location.href = "pages/index.jsp";
					//location.href = "/wxpt/j_spring_security_check?j_username="+username+"&j_password="+password;
					location.href = "/wxpt"+url+"?openId="+openId;
				} else if (data=="0"){
					alert("用户名或密码不正确，请重新输入！");
				} else if (data=="2"){
					alert("该微信号已绑定过账户！");
				} else if (data=="3"){
					alert("该微信号已绑定过账户！且已经被停用，请联系管理员。");
				}
			}
		});
	}
}

var Utils = function() {
};

/*Utils.prototype.loadProperties = function(lang) {
	jQuery.i18n.properties({// 加载资浏览器语言对应的资源文件
		name : 'ApplicationResources',
		language : lang,
		path : 'resources/i18n/',
		mode : 'map',
		callback : function() {// 加载成功后设置显示内容
		}
	});
};*/

Utils.prototype.getScriptArgs = function() {// 获取多个参数
	var scripts = document.getElementsByTagName("script"),
	// 因为当前dom加载时后面的script标签还未加载，所以最后一个就是当前的script
	script = scripts[scripts.length - 1], src = script.src, reg = /(?:\?|&)(.*?)=(.*?)(?=&|$)/g, temp, res = {};
	while ((temp = reg.exec(src)) != null)
		res[temp[1]] = decodeURIComponent(temp[2]);
	return res;
};
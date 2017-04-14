Date.prototype.format = function(format) {
	var o = {

		"M+" : this.getMonth() + 1, // month
		"d+" : this.getDate(),// day
		"h+" : this.getHours(), // hour
		"m+" : this.getMinutes(), // minute
		"s+" : this.getSeconds(), // second
		"q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
		"S" : this.getMilliseconds()
		// millisecond
	}

	if (/(y+)/.test(format))
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4
						- RegExp.$1.length));
	for (var k in o)
		if (new RegExp("(" + k + ")").test(format))
			format = format.replace(RegExp.$1, RegExp.$1.length == 1
							? o[k]
							: ("00" + o[k]).substr(("" + o[k]).length));
	return format;
}
var defaultValidateErrorPlacement = function(lable, element) {
	if (element.hasClass("l-textarea")) {
		element.addClass("l-textarea-invalid");
	} else if (element.hasClass("l-text-field")) {
		element.parent().addClass("l-text-invalid");
	} else if (element[0].type == "textarea") {
		if (lable.html() != "") {
			element.addClass("l-textarea-invalid");
			// alert(lable.html())
		} else {
			element.removeClass("l-textarea-invalid");
		}
	} else if (element[0].type == "radio") {
		var e = element.parent().parent();
		e.addClass("l-text-invalid invalid-"
				+ (element[0].name.replace(/(\.)/g, "-")));
		e.attr("title", lable.html());
	} else {
		lable.appendTo(element.parents("td:first").next("td"));
	}
	$(element).removeAttr("title").ligerHideTip();
	$(element).attr("title", lable.html());
	// 修复下拉框不能显示错误提示的问题
	$(element).parent().parent().attr("title", lable.html());
};

var defaultValidateSuccess = function(lable) {
	var element = $("#" + lable.attr("for"));
	if (element.hasClass("l-textarea")) {
		element.removeClass("l-textarea-invalid");
	} else if (element.hasClass("l-text-field")) {
		element.parent().removeClass("l-text-invalid");
	}
	$(".invalid-" + (lable.attr("for").replace(/(\.)/g, "-")))
			.removeClass("l-text-invalid");
};

var deafultValidate = function(validateElements) {
	$.validator.addMethod("notnull", function(value, element, regexp) {
				if (!value)
					return true;
				return !$(element).hasClass("l-text-field-null");
			}, "不能为空");
	var requiredFiles = $(":input[validate*='required']");
	$.each(requiredFiles, function(i, field) {
		$("label[for=" + field.id + "]").before("<font color='red'>*</font>");
			// $("label[for=" + field.id + "]").css("color","red");
		})

	return validateElements.validate({
				ignore : ":hidden,.hidden",
				errorPlacement : function(lable, element) {
					defaultValidateErrorPlacement(lable, element);
				},
				success : function(lable) {
					defaultValidateSuccess(lable);
				}
			});
};

var GetUrlParam = function() {
	return window.location.href.replace(_ctxPath + "/", "")
}
var SetButtons = function(toolbar, url) {
	return;// 禁用该功能
	if (!url) {
		url = 'system/authority!getButton.action';
		url += '?opts.url=' + GetUrlParam();
	}
	$.getJSON(url, function(data) {
				if (!data)
					return;
				var buttons = [];
				$(data).each(function(i, dataitem) {
							var btn = {
								text : this.name,
								icon : this.icon,
								id : this.id
							};
							try {
								btn.click = f_btnClick;
							} catch (e) {
								parent.toastMsg("按钮功能尚未定义");
							}
							buttons.push(btn);
						});
				toolbar.ligerToolBar({
							items : buttons
						});
			});
};

var idCardNoUtil = {

	provinceAndCitys : {
		11 : "北京",
		12 : "天津",
		13 : "河北",
		14 : "山西",
		15 : "内蒙古",
		21 : "辽宁",
		22 : "吉林",
		23 : "黑龙江",
		31 : "上海",
		32 : "江苏",
		33 : "浙江",
		34 : "安徽",
		35 : "福建",
		36 : "江西",
		37 : "山东",
		41 : "河南",
		42 : "湖北",
		43 : "湖南",
		44 : "广东",
		45 : "广西",
		46 : "海南",
		50 : "重庆",
		51 : "四川",
		52 : "贵州",
		53 : "云南",
		54 : "西藏",
		61 : "陕西",
		62 : "甘肃",
		63 : "青海",
		64 : "宁夏",
		65 : "新疆",
		71 : "台湾",
		81 : "香港",
		82 : "澳门",
		91 : "国外"
	},

	powers : ["7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9",
			"10", "5", "8", "4", "2"],

	parityBit : ["1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"],

	genders : {
		male : "男",
		female : "女"
	},

	checkAddressCode : function(addressCode) {
		var check = /^[1-9]\d{5}$/.test(addressCode);
		if (!check)
			return false;
		if (idCardNoUtil.provinceAndCitys[parseInt(addressCode.substring(0, 2))]) {
			return true;
		} else {
			return false;
		}
	},

	checkBirthDayCode : function(birDayCode) {
		var check = /^[1-9]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))$/.test(birDayCode);
		if (!check)
			return false;
		var yyyy = parseInt(birDayCode.substring(0, 4), 10);
		var mm = parseInt(birDayCode.substring(4, 6), 10);
		var dd = parseInt(birDayCode.substring(6), 10);
		var xdata = new Date(yyyy, mm - 1, dd);
		if (xdata > new Date()) {
			return false;// 生日不能大于当前日期
		} else if ((xdata.getFullYear() == yyyy)
				&& (xdata.getMonth() == mm - 1) && (xdata.getDate() == dd)) {
			return true;
		} else {
			return false;
		}
	},

	getParityBit : function(idCardNo) {
		var id17 = idCardNo.substring(0, 17);

		var power = 0;
		for (var i = 0; i < 17; i++) {
			power += parseInt(id17.charAt(i), 10)
					* parseInt(idCardNoUtil.powers[i]);
		}

		var mod = power % 11;
		return idCardNoUtil.parityBit[mod];
	},

	checkParityBit : function(idCardNo) {
		var parityBit = idCardNo.charAt(17).toUpperCase();
		if (idCardNoUtil.getParityBit(idCardNo) == parityBit) {
			return true;
		} else {
			return false;
		}
	},

	checkIdCardNo : function(idCardNo) {
		// 15位和18位身份证的基本校验
		var check = /^\d{15}|(\d{17}(\d|x|X))$/.test(idCardNo);
		if (!check)
			return false;
		// 判断长度为15位或18位
		if (idCardNo.length == 15) {
			return idCardNoUtil.check15IdCardNo(idCardNo);
		} else if (idCardNo.length == 18) {
			return idCardNoUtil.check18IdCardNo(idCardNo);
		} else {
			return false;
		}
	},

	// 校验15位的身份证
	check15IdCardNo : function(idCardNo) {
		// 15位身份证的基本校验
		var check = /^[1-9]\d{7}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}$/
				.test(idCardNo);
		if (!check)
			return false;
		// 校验地址码
		var addressCode = idCardNo.substring(0, 6);
		check = idCardNoUtil.checkAddressCode(addressCode);
		if (!check)
			return false;
		var birDayCode = '19' + idCardNo.substring(6, 12);
		// 校验日期码
		return idCardNoUtil.checkBirthDayCode(birDayCode);
	},

	// 校验18位的身份证
	check18IdCardNo : function(idCardNo) {
		// 18位身份证的基本格式校验
		var check = /^[1-9]\d{5}[1-9]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}(\d|x|X)$/
				.test(idCardNo);
		if (!check)
			return false;
		// 校验地址码
		var addressCode = idCardNo.substring(0, 6);
		check = idCardNoUtil.checkAddressCode(addressCode);
		if (!check)
			return false;
		// 校验日期码
		var birDayCode = idCardNo.substring(6, 14);
		check = idCardNoUtil.checkBirthDayCode(birDayCode);
		if (!check)
			return false;
		// 验证校检码
		return idCardNoUtil.checkParityBit(idCardNo);
	},

	formateDateCN : function(day) {
		var yyyy = day.substring(0, 4);
		var mm = day.substring(4, 6);
		var dd = day.substring(6);
		return yyyy + '-' + mm + '-' + dd;
	},

	// 获取信息
	getIdCardInfo : function(idCardNo) {
		var idCardInfo = {
			gender : "", // 性别
			birthday : "" // 出生日期(yyyy-mm-dd)
		};
		if (idCardNo.length == 15) {
			var aday = '19' + idCardNo.substring(6, 12);
			idCardInfo.birthday = idCardNoUtil.formateDateCN(aday);
			if (parseInt(idCardNo.charAt(14)) % 2 == 0) {
				idCardInfo.gender = idCardNoUtil.genders.female;
			} else {
				idCardInfo.gender = idCardNoUtil.genders.male;
			}
		} else if (idCardNo.length == 18) {
			var aday = idCardNo.substring(6, 14);
			idCardInfo.birthday = idCardNoUtil.formateDateCN(aday);
			if (parseInt(idCardNo.charAt(16)) % 2 == 0) {
				idCardInfo.gender = idCardNoUtil.genders.female;
			} else {
				idCardInfo.gender = idCardNoUtil.genders.male;
			}

		}
		return idCardInfo;
	},

	getId15 : function(idCardNo) {
		if (idCardNo.length == 15) {
			return idCardNo;
		} else if (idCardNo.length == 18) {
			return idCardNo.substring(0, 6) + idCardNo.substring(8, 17);
		} else {
			return null;
		}
	},

	getId18 : function(idCardNo) {
		if (idCardNo.length == 15) {
			var id17 = idCardNo.substring(0, 6) + '19' + idCardNo.substring(6);
			var parityBit = idCardNoUtil.getParityBit(id17);
			return id17 + parityBit;
		} else if (idCardNo.length == 18) {
			return idCardNo;
		} else {
			return null;
		}
	}
};
// 验证护照是否正确
function checknumber(number) {
	var str = number;
	// 在JavaScript中，正则表达式只能使用"/"开头和结束，不能使用双引号
	var Expression = /(P\d{7})|(G\d{8})/;
	var objExp = new RegExp(Expression);
	if (objExp.test(str) == true) {
		return true;
	} else {
		return false;
	}
};

/**
 * 隐藏一个对象时 将其中的表单元素设为disabled
 * 
 * @param {}
 *            el
 */
function comm_hide(el) {
	el.css("display", "none");
	el.find("input, select, textarea").each(function(idx, f) {
				$(f).attr("disabled", "disabled")
			})
}

/**
 * 显示一个对象时 将其中的表单元素取消disabled
 * 
 * @param {}
 *            el
 */
function comm_show(el) {
	el.css("display", "");
	el.find("input, select, textarea").each(function(idx, f) {
				$(f).attr("disabled", "")
			})
}
// 去左空格
function lTrim(str) {
	if (str.charAt(0) == " ") {
		str = str.slice(1); // 将空格从字串中去掉
		str = lTrim(str); // 递归调用
	}
	return str;
}

// 去右空格
function rTrim(str) {
	var iLength;
	iLength = str.length;
	if (str.charAt(iLength - 1) == " ") {
		str = str.slice(0, iLength - 1); // 将空格从字串中去掉
		str = rTrim(str); // 递归调用
	}
	return str;
}

function doTrim() {
	$(":input[class!='noTrim']").keyup(function() {
				var oldValue = $(this).val();
				var newValue = rTrim(lTrim(oldValue));
				if (newValue != oldValue) {
					$(this).val(newValue);
				}
			});
}

function toTrimDBC() {
	$(":input[class=='trimDBC']").keyup(function() {
				var oldValue = $(this).val();
				if (oldValue != "") {
					var newValue = "";
					for (var i = 0; i < oldValue.length; i++) {
						var c = oldValue.charCodeAt(i);
						if (c == 12288 || c == 32) {
							continue;
						}
						if (c > 65280 && c < 65375 && c != 65288 && c != 65289) {
							newValue += String.fromCharCode(c - 65248);
							continue;
						}
						newValue += String.fromCharCode(c);
					}
					if (newValue != oldValue) {
						$(this).val(newValue);
					}
				}
			});
}

// 给textarea 增加统计输入多少字
function addMaxlength() {
	$("textarea[validate*='maxlength']").each(function() {
		if ($(this).attr("validate").indexOf("maxlength") > -1) {
			var validate = $(this).attr("validate");
			var length = validate.match(/\d+/ig);
			$(this).after("<br><label for='valuelength' style='color:red' id='valuelength'>"+ this.value.length + "</label>/" + length + "个字符");
			$(this).keyup(function() {
						len = this.value.length;
						if (len > length) {
							this.value = this.value.substring(0, length);
							len = length;
						}
						$(this).next().next().text(len);
					});
			$(this).keydown(function() {
						len = this.value.length;
						if (len > length) {
							this.value = this.value.substring(0, length);
							len = length;
						}
						$(this).next().next().text(len);
					});
			$(this).blur(function() {
						len = this.value.length;
						if (len > length) {
							this.value = this.value.substring(0, length);
							len = length;
						}
						$(this).next().next().text(len);
					});
		}
	});
}

$(function() {
	doTrim();
	toTrimDBC();
	addMaxlength();
	if (jQuery.validator) {
		// 字母数字
		jQuery.validator.addMethod("alnum", function(value, element) {
					return this.optional(element)
							|| /^[a-zA-Z0-9]+$/.test(value);
				}, "只能包括英文字母和数字");

		// 小数点两位的数字
		jQuery.validator.addMethod("decimal", function(value, element) {
					return this.optional(element)
							|| /^\d+(\.\d{2})?$/.test(value);
				}, "请输入正数或者带小数点两位的数");
		// 小数点两位的数字
		jQuery.validator.addMethod("positive", function(value, element) {
					return this.optional(element)
							|| /^[0-9]*[1-9][0-9]*$/.test(value);
				}, "请输入正整数");
		
		// 手机号码验证
		jQuery.validator.addMethod("cellphone", function(value, element) {
					var length = value.length;
					return this.optional(element)
							|| (length == 11 && /^(1\d{10})$/.test(value));
				}, "请正确填写手机号码");

		// 电话号码验证
		// 匹配格式：11位手机号码3-4位区号，7-8位直播号码，1－4位分机号如：12345678901、1234-12345678-1234
		jQuery.validator.addMethod("telephone", function(value, element) {
			var tel = /^((1\d{10})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/g;
			return this.optional(element) || (tel.test(value));
		}, "请正确填写电话号码");

		// 邮政编码验证
		jQuery.validator.addMethod("zipcode", function(value, element) {
					var tel = /^[0-9]{6}$/;
					return this.optional(element) || (tel.test(value));
				}, "请正确填写邮政编码");

		// 汉字
		jQuery.validator.addMethod("chcharacter", function(value, element) {
					var tel = /^[\u4e00-\u9fa5]+$/;
					return this.optional(element) || (tel.test(value));
				}, "请输入汉字");

		// 汉字
		jQuery.validator.addMethod("qq", function(value, element) {
					var tel = /^[1-9][0-9]{4,}$/;
					return this.optional(element) || (tel.test(value));
				}, "请输入正确的QQ");
		// 身份证验证
		jQuery.validator.addMethod("isIdCardNo", function(value, element) {
					return this.optional(element)
							|| idCardNoUtil.checkIdCardNo(value);
				}, "请正确输入您的身份证");

		// 用户名
		jQuery.validator.addMethod("username", function(value, element) {
					return this.optional(element)
							|| /^[a-zA-Z][a-zA-Z0-9_]+$/.test(value);
				}, "用户名格式不正确，请以字母开头，并且只能包含数字以及下划线！");
		
		// 数据库表
//		jQuery.validator.addMethod("tablename", function(value, element) {
//					return this.optional(element)
//							|| /^[a-zA-Z][a-zA-Z0-9_]+$/.test(value);
//				}, "数据库表格式不正确，只能输入字母、数字、下划线");
		jQuery.validator.addMethod("tablename", function(value, element) {
					return this.optional(element)
							|| /^\w{1,50}$/.test(value);
				}, "数据库表格式不正确，只能包括英文字母、数字和下划线的组合 禁止输入空格");
		
		// 日期比较
		jQuery.validator.addMethod("compareDate", function(value, element,
						param) {
					var length = value.length;
					var date1 = null;
					if (param.id == "") {
						date1 = new Date().format("yyyy-MM-dd hh:mm:ss");
					} else {
						date1 = $(param.id).val();
					}
					if(date1==''){
					return true;
					}
					if (param.lt) {// 当前不能小于
						return date1 < value;
					} else {// 当前不能大于
						return date1 >= value;
					}
				}, "日期范围错误");
				
		// 邮政编码验证
		jQuery.validator.addMethod("zipcode", function(value, element) {
					var tel = /^[0-9]{6}$/;
					return this.optional(element) || (tel.test(value));
				}, "请正确填写邮政编码");
				
	// url验证
	jQuery.validator.addMethod("url", function(value, element) {
			 var strRegex = "^((https|http|ftp|rtsp|mms)?://)"       
                //+ "?(([0-9a-zA-Z_!~*'().&=+$%-]+: )?[0-9a-zA-Z_!~*'().&=+$%-]+@)?" //ftp的user@      
                + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184      
                + "|" // 允许IP和DOMAIN（域名）      
                + "([0-9a-zA-Z_!~*'()-]+\.)*" // 域名- www.      
                + "([0-9a-zA-Z][0-9a-zA-Z-]{0,61})?[0-9a-zA-Z]\." // 二级域名      
                + "[a-zA-Z]{2,6})" // first level domain- .com or .museum      
                + "(:[0-9]{1,4})?" // 端口- :80      
                + "((/?)|"       
                + "(/[0-9a-zA-Z_!~*'().;?:@&=+$,%#-]+)+/?)$";      
			var re=new RegExp(strRegex);
			
			return this.optional(element) || (re.test(value));	
			}, "请正确填写链接");
				

		jQuery.validator.addMethod("username_check", function(value, element) {
					var newLoginName = $("#loginName").val();
					var oldLoginName = $("#oldLoginName").val();
					if ('' == newLoginName && '' == oldLoginName)
						return true;
					var result = false;
					// 设置同步
					$.ajaxSetup({
								async : false
							});
					$.post("system/user!checkLoginName.action", {
								'newLoginName' : newLoginName,
								'oldLoginName' : oldLoginName
							}, function(data) {
								result = !eval(data);
							});
					// 恢复异步
					$.ajaxSetup({
								async : true
							});
					return result;
				}, "用户名已经存在");
	}

	// 为列表搜索栏输入框增加回车自动搜索功能，要求输入文本框必须在<div
	// class="l-panel-search">中，搜索按钮必须为id="searchbtn"
	$('.l-panel-search').find(":input[type!='hidden']").each(function(idx, f) {
				if (f.tagName == "SELECT" || f.type == "checkbox") {
					$(f).bind('afterupdate', function(e) {
								$('#searchbtn').trigger('click');
							})
				}
				$(f).bind('keyup', function(e) {
							if (e.keyCode == 13) {
								$('#searchbtn').trigger('click');
							}
						})
			});
	// 搜索按钮后面自动添加清空按钮，规则为清空不为隐藏域的输入框，赋值为空
	$('#searchbtn')
			.parent()
			.after('<div class="l-panel-search-item"><a id="clearbtn"></a><div>')
});

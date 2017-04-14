/*
 * Translated default messages for the jQuery validation plugin.
 * Locale: CN
 */
jQuery.extend(jQuery.validator.messages, {
        required: "<span style='color:red;font-size:12px'title='必填字段不能为空'>必填字段不能为空</span>",
		remote: "<span style='color:red;font-size:12px' title='请修正该字段'> 请修正该字段</span>",
		email: "<span style='color:red;font-size:12px' title='请输入正确格式的电子邮件' > 请输入正确格式的电子邮件</span>",
		url: "<span style='color:red;font-size:12px' title='请输入合法的网址'> 请输入合法的网址</span>",
		date: "<span style='color:red;font-size:12px' title='请输入合法的日期'>请输入合法的日期</span>",
		dateISO: "<span style='color:red;font-size:12px' title='请输入合法的日期 (ISO)'> 请输入合法的日期 (ISO).</span>",
		number: "<span style='color:red;font-size:12px'title='请输入合法的数字'> 请输入合法的数字</span>",
		tel : "<span style='color:red;font-size:12px'title='请输入有效数字'> 请输入有效数字</span>",
		digits: "<span style='color:red;font-size:12px' title='只能输入整数'> 只能输入整数</span>",
		creditcard: "<span style='color:red;font-size:12px' title='请输入合法的信用卡号'> 请输入合法的信用卡号</span>",
		equalTo: "<span style='color:red;font-size:12px' title='请再次输入相同的值'> 请再次输入相同的值</span>",
		accept: "<span style='color:red;font-size:12px' title='请输入拥有合法后缀名的字符串'> 请输入拥有合法后缀名的字符串</span>",
		maxlength: jQuery.validator.format("<span style='color:red;font-size:12px' title='请输入一个长度最多是 {0} 的字符串'> 请输入一个长度最多是 {0} 的字符串</span>"),
		minlength: jQuery.validator.format("<span style='color:red;font-size:12px' title='请输入一个长度最少是 {0} 的字符串'> 请输入一个长度最少是 {0} 的字符串</span>"),
		rangelength: jQuery.validator.format("<span style='color:red;font-size:12px' title='请输入一个长度介于 {0} 和 {1} 之间的字符串'> 请输入一个长度介于 {0} 和 {1} 之间的字符串</span>"),
		range: jQuery.validator.format("<span style='color:red;font-size:12px' title='请输入一个介于 {0} 和 {1} 之间的值'> 请输入一个介于 {0} 和 {1} 之间的值</span>"),
		max: jQuery.validator.format("<span style='color:red;font-size:12px' title='请输入一个最大为 {0} 的值'> 请输入一个最大为 {0} 的值</span>"),
		min: jQuery.validator.format("<span style='color:red;font-size:12px' title='请输入一个最小为 {0} 的值'> 请输入一个最小为 {0} 的值</span>")
});
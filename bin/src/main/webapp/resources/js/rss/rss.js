var path="";
var url_rss;
String.prototype.replaceAll  = function(s1,s2){     
    return this.replace(new RegExp(s1,"gm"),s2);     
};

$(function(){ 
	//console.log($(' <link>http://blog.sina.com.cn/xujinglei</link>').text());
var html=""; 
var bgcolor="";
var url = path+"/rss/rssTest";
		$.ajax({
			url : url,
			data : {
				url_rss : url_rss,
			},
			type : "get",
			//dataType:($.browser.msie) ? "text" : "xml", 
			success : function(data) {
				var rst = eval(data);
				$("item", rst.message).each(
						function(index, element) {
							var info = $(element).html().replaceAll('\r','').replaceAll('\n','').replaceAll('\t','');
                            var d = info.split('<link>');
							var f = d[1].split('<description>');
							var tem = /[^\u4e00-\u9fa5]/g;
							/* bgcolor = index % 2 == 0 ? " bgcolor='#F1F1F1' "
									: " bgcolor='#FFFFFF' "; */
							html += "<table><tr><table style='width: 100%;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;'><tr><a title='"+$(this).find("title").text().replace(tem,"")+"' href='"
									+ path+"/rss/main?url="+f [0]+"&title="+$(this).find("title").text().replace(tem,"")
									+"&time="+$(this).find("pubDate").text()+"&author="+$(this).find("author").text()
									+ "'>"
									+ FormatContent($(this).find("title").text().replace(tem,""),13)
									+"</a><span style='float: right;font-color:white'>"
									+ $(this).find("pubDate").text()
									+"</span>"
									+ "</tr></table>"
							+"</tr></table>";
						});
				$("#tbl1 tr:not(':first')").remove();//移除非第一行 
				$("#tbl1").append(html);//绑定数据到table 
			},
			complete : function() {
				$("#loading").hide();
			},
			beforeSend : function(x) {
				x.setRequestHeader("Content-Type", "charset=utf-8"); 
				$("#loading").show();
			},
			error : function() {
				alert("error");
			}
		});
	});

	/** 
	 * 时间对象的格式化; 
	 */
	Date.prototype.format = function(format) {
		/* 
		 * eg:format="YYYY-MM-dd hh:mm:ss"; 
		 */
		var o = {
			"M+" : this.getMonth() + 1, // month 
			"d+" : this.getDate(), // day 
			"h+" : this.getHours(), // hour 
			"m+" : this.getMinutes(), // minute 
			"s+" : this.getSeconds(), // second 
			"q+" : Math.floor((this.getMonth() + 3) / 3), // quarter 
			"S" : this.getMilliseconds(),
		// millisecond 
		};
		if (/(y+)/.test(format)) {
			format = format.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		}
		for ( var k in o) {
			if (new RegExp("(" + k + ")").test(format)) {
				format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
						: ("00" + o[k]).substr(("" + o[k]).length));
			}
		}
		return format;
	};
	//格式化标题信息 
	function FormatContent(word, length) {
		return word.length > length ? word.substring(0, length) + "..." : word;
	}
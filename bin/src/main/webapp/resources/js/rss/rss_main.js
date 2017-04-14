//点击标题出现正文
var html='';
var path='';
String.prototype.replaceAll  = function(s1,s2){     
    return this.replace(new RegExp(s1,"gm"),s2);     
};
$(function(){ 
		$.ajax({
			url :path+ '/rss/mainList',
			data : {
				url : $('#links').val(),
			},
			type : "get",
			success : function(data) {
				var rst = eval(data);
			  $("table", rst.message).find('p').each(
						function(index, element) {
							if($(this).find('img').length !=0){ 
								var c = $(this).find('img')[0].src;
							    var f= c.substring( c.indexOf('/')).substring(c.substring( c.indexOf('/')).indexOf('/')+2);
							    var g = f.indexOf('/');
							    var d = f.substring(g+1);
							    if($(this).find('a').length !=0){
							    	var c = $(this).find('a').attr('href');
							           html+=" <p align='center'><img border='0' alt='' src=  'http://www.hsu.edu.cn/" +d+"'/>." +
							           		"<a id='file1' target=_blank  href='http://www.hsu.edu.cn/"+c+"'>"+ $(this).text()+"</a>" +
							           		"</p>";
							    }else{
							    	html+=" <p align='center'><img border='0' alt='' src=  'http://www.hsu.edu.cn/" +d +"'/></p>";
							    }
							}else{
						    	if($(this).attr('align').length!=0){
						    		var l = $(this).attr('align');
								html+="<p align='"+l+"'>"+$(this).text()+"</p>";
						    	}else{
						    		html+="<p>"+$(this).text()+"</p>";
						    	}
							}
						});
				$("#main").append(html);//绑定数据到table 
			},
			error : function() {
				alert("error");
			}
		});
});
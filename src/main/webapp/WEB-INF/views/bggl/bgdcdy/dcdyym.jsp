<%@page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/taglib.jsp" %>
<%  String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery-1.10.2.min.js"></script>
<script type="text/javascript"src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<script type="text/javascript"src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery.validate.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.min.js"></script>
     <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/DialogBySHF.css">
    <script type="text/javascript" src="<%=path%>/resources/css/jygl/DialogBySHF.js"></script>
<title>提醒信息</title>
<style type="text/css">
.diyi{
	text-align: center;
	font-size:17px;
	width: 100%;
	margin-top: 17%;
}
.dier{
	text-align: center;
	margin-top: 5%;
}
.hs{
	background-color:red;
	border-color:red;
}
</style>
</head>
<body>
<input type="hidden" name="bgbh" id="bgbh" value="${bgbh }">
<div class="diyi">
	是否进行报告打印？该条报告只可打印一次。
</div>
<div class="dier">
	<input type="button" class="btn btn-primary" onclick="dybg();" value="打印报告"/>
<!-- 	<input type="button" class="btn btn-primary hs" onclick="parent.close(); parent.parent.close() " value="关闭"/> -->
</div>
</body>
<script type="text/javascript">
	function dybg(){
		var bgbh = $("#bgbh").val();
        $.DialogBySHF.Dialog({ Width: 300, Height: 200, Title: "系统提示", URL: '<%=path%>/jygl/YjyBgxx/dcck?bgbh='+bgbh });
        var d = new Delay(); 
 		d.wait(9500).run(function(m){ //等待3秒 
 			//封面自定义
			 var sy = "<%=path%>/resources/doc/"+bgbh+"fmzdy.doc";
            createXMLHttpRequest();
            xmlHttp.open("GET",sy,true);
            xmlHttp.send(null);
            xmlHttp.onreadystatechange = function(){
                if(xmlHttp.readyState==4){
                    if(xmlHttp.status==200){
                    	location.href = "<%=path%>/jygl/YjyBgxx/yldcbg?bgbh=" + bgbh;
                    }else {
                        alert("操作失败，请重新操作！");
                         $.DialogBySHF.Close(); 
                    }
                }
            }
 		});
	}
	var xmlHttp= null;
    //判断浏览器
    function createXMLHttpRequest() {
        if (window.XMLHttpRequest) {
            //Firefox,Netscape,Chrome,Safari等浏览器
            xmlHttp = new XMLHttpRequest();
        } else if (window.ActiveXObject) { //IE浏览器
            try {
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); //创建xmlHttp对象
            } catch (e) {
                try {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); //创建xmlHttp对象
                } catch (e) { }
            }
        }
    }
    
	function Delay(){ 
		this.funList= []; 
		this.index = 0; 
		this.re = null; 
		this.isloop = false; 
		}; 
		Delay.prototype = { 
		wait:function(m){ 
		if(this.funList[this.index] && typeof this.funList[this.index].fun != 'function'){ 
		m += this.funList[this.index].m; 
		} 
		this.funList[this.index] = {m:m,fun:null}; 
		return this; 
		}, 
		run:function(fun){ 
		if(typeof this.funList[this.index].fun != 'function'){ 
		this.funList[this.index].fun = fun; 
		this.index++; 
		}else{ 
		this.index++; 
		this.funList[this.index] = {'m':0,'fun':fun}; 
		} 
		this.start(); 
		return this; 
		}, 
		start:function(){ 
		var self = this; 
		if(this.re) return; 
		var setOutrun = function(funList,index){ 
		if(funList[index] == undefined){ 
		clearTimeout(self.re); 
		return false; 
		} 
		var m = funList[index].m, 
		fun = funList[index].fun; 
		typeof fun == 'function' || (fun = function(){}); 
		self.re = setTimeout(function(){ 
		if(fun(index) === false)return false; 
		if(self.isloop){ 
		index = -1; 
		self.isloop = false; 
		} 
		setOutrun(funList,++index); 
		},m); 
		} 
		setOutrun(this.funList,0); 
		}, 
		stop:function(){ 
		return clearTimeout(this.re); 
		}, 
		goStart:function(){ 
		var self = this, 
		fun = function(){ 
		self.isloop = true; 
		}; 
		if(this.funList[this.index] && typeof this.funList[this.index].fun != 'function'){ 
		this.funList[this.index].fun = fun; 
		this.index++; 
		}else{ 
		this.funList[this.index] = {'m':0,'fun':fun}; 
		} 
		this.start(); 
		} 
		};
</script>
</html>
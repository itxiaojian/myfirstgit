<%@page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/taglib.jsp" %>
<%  String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/DialogBySHF.css">
<script type="text/javascript" src="<%=path%>/resources/css/jygl/DialogBySHF.js"></script>
<link href="<%=path%>/resources/bootstrap/style.css" rel="stylesheet">
<%-- <script src="<%=path%>/resources/js/form-component.js"></script> --%>
<title>选择打印</title>
<style type="text/css">
body{
	background: #fff;
}
.has-js .label_check,.has-js .label_radio {
	padding-left: 22px;
}
.diyi .disan{
	float:left;
}
.disan{
 	margin-top: 3%;
	text-align: center;
}
.diyi{
	margin-top: 10%;
	text-align: center;
}
.dier{
	text-align: center;
	margin-top: 7%;
}
.hs{
	background-color:red;
	border-color:red;
}
.zt{
	font-size:17px;
}
 		.label_check{ 
			background: rgba(0, 0, 0, 0) url("<%=path%>/resources/img/checkbox/check-off.png") no-repeat scroll 0 0;
 			padding-left: 5px; 
 			margin-right: 5px; 
 		} 
 		.label_check input[type="checkbox"] {
		    visibility: hidden;
		}
		.label_check.c_on{ 
			background: rgba(0, 0, 0, 0) url("<%=path%>/resources/img/checkbox/check-on.png") no-repeat scroll 0 0;
 			padding-left: 5px; 
 			margin-right: 5px; 
 		} 
 		.label_check.c_off{ 
			background: rgba(0, 0, 0, 0) url("<%=path%>/resources/img/checkbox/check-off.png") no-repeat scroll 0 0;
 			padding-left: 5px; 
 			margin-right: 5px; 
 		} 
	</style>
</head>
<body onload="doDoc();">
<input type="hidden" name="bgbh" id="bgbh" value="${bgbh }">
<div class="diyi">
	<label class="label_check" for="checkbox-1" id="lable1" style="display:inline-block;cursor:pointer;">
		<input type="checkbox" class="label_check" name="ymids" value="1" id="checkbox-1" onclick="gouxuan(1);">
		<span class="zt">封面</span>&nbsp;&nbsp;&nbsp;&nbsp;
	</label>
	<label class="label_check" for="checkbox-2" id="lable2" style="display:inline-block;cursor:pointer;">
		<input type="checkbox" class="label_check" name="ymids" value="2" id="checkbox-2" onclick="gouxuan(2);">
		<span class="zt">首页</span>&nbsp;&nbsp;&nbsp;&nbsp;
	</label>
	<label class="label_check" for="checkbox-3" id="lable3" style="display:inline-block;cursor:pointer;">
		<input type="checkbox" class="label_check" name="ymids" value="3" id="checkbox-3" onclick="gouxuan(3);">
		<span class="zt">附页</span>&nbsp;&nbsp;&nbsp;&nbsp;
	</label>
</div>
<div class="disan">
	<label class="label_check" for="checkbox-4" id="lable4" style="display:inline-block;cursor:pointer;">
		<input type="checkbox" class="label_check" name="ymids" value="4" id="checkbox-4" onclick="gouxuan(4);">
		<span class="zt">认证章</span>&nbsp;&nbsp;&nbsp;&nbsp;
	</label>
	<label class="label_check" for="checkbox-5" id="lable5" style="display:inline-block;cursor:pointer;">
		<input type="checkbox" class="label_check" name="ymids" value="5" id="checkbox-5" onclick="gouxuan(5);">
		<span class="zt">封面内的单位名称</span>&nbsp;&nbsp;&nbsp;&nbsp;
	</label>
<!-- 	<input type="checkbox" name="ymids" value="5">封面内的单位名称 -->

</div>
<div class="dier">
	<input type="button" class="btn btn-success" onclick="dybg();" value="打印报告"/>
<!-- 	<input type="button" class="btn btn-primary hs" onclick="parent.close(); parent.parent.close() " value="关闭"/> -->
</div>
</body>
<script type="text/javascript">
	function gouxuan(data){
       	var lable=$("#lable"+data);
  		var obj=$("#checkbox-"+data);
		if(obj.prop("checked")){
			obj.prop("checked", true);
		}else{
			obj.removeAttr("checked");
		}
   		if(lable.attr('class')=='label_check c_off'||lable.attr('class')=='label_check'){
	  		lable.attr("class", "label_check c_on");
   		}else{
   			lable.attr("class", "label_check c_off");
   		}
	}
	
	function dybg(){
	var ymids = [];
		var bgbh = $("#bgbh").val();
        $('input[name="ymids"]:checked').each(
                function () {
                	ymids.push($(this).val());
                }
        );
        if (ymids == "") {
            alert("请选择需要打印的页面！");
            return false;
        }
			if(ymids == "2,4" || ymids == "2,5" || ymids == "2,4,5" || ymids == "2,3,4,5" || 
			   ymids == "3,4" || ymids == "3,5" || ymids == "3,4,5" || ymids == "2,3,5" || ymids == "2,3,4" || ymids == "4,5"){
				alert("操作有误！");
			}else {
	        	$.DialogBySHF.Dialog({ Width: 300, Height: 200, Title: "系统提示", URL: '<%=path%>/jygl/YjyBgxx/dyck?bgbh='+bgbh +"&ymids="+ymids });
			        var d = new Delay(); 
			 		d.wait(9500).run(function(m){ //等待3秒 
			 			//当勾选了需要生成封面zdy的打印选项时，应验证有无生成封面zdy
				        if(ymids == "1" || ymids == "1,4" || ymids == "1,5" || ymids == "1,2" || ymids == "1,2,4" || ymids == "1,2,5" ||
				           ymids == "1,3" || ymids == "1,3,4" || ymids == "1,3,5" || ymids == "1,2,3" || ymids == "1,2,3,4" || ymids == "1,2,3,5"){
				        	//封面zdy
	            			 var fmzdy = "<%=path%>/resources/doc/"+bgbh+"fmzdy.doc";
	                        createXMLHttpRequest();
	                        xmlHttp.open("GET",fmzdy,true);
	                        xmlHttp.send(null);
	                        xmlHttp.onreadystatechange = function(){
	                            if(xmlHttp.readyState==4){
	                                if(xmlHttp.status==200){
	                                	location.href = "<%=path%>/jygl/YjyBgxx/zdybg?bgbh=" + bgbh +"&ymids="+ymids;
	                                }
// 	                                else {
// 	                                	//封面Gzdy
<%-- 	                        			 var fmG = "<%=path%>/resources/doc/"+bgbh+"fmGzdy.doc"; --%>
// 	                                    createXMLHttpRequest();
// 	                                    xmlHttp.open("GET",fmG,true);
// 	                                    xmlHttp.send(null);
// 	                                    xmlHttp.onreadystatechange = function(){
// 	                                        if(xmlHttp.readyState==4){
// 	                                            if(xmlHttp.status==200){
<%-- 	                                            	location.href = "<%=path%>/jygl/YjyBgxx/zdybg?bgbh=" + bgbh +"&ymids="+ymids; --%>
// 	                                            }else {
// 	                                                alert("操作失败，请重新操作！");
// 	                                                $.DialogBySHF.Close();
// 	                                            }
// 	                                        }
// 	                                    }
// 	                                }
	                            }
	                        }
				        }else {
			 				location.href = "<%=path%>/jygl/YjyBgxx/zdybg?bgbh=" + bgbh +"&ymids="+ymids;
				        }
			 		});
			}

	}
	function doDoc(){
		var ymids = [];
		$('input[name="ymids"]:checked').each(
                function () {
                	ymids.push($(this).val());
                }
        );
		for(var i=0;i<ymids.length;i++){
			var lable=$("#lable"+ymids[i]);
			var obj=$("#checkbox-"+ymids[i]);
			if(obj.prop("checked")){
				obj.prop("checked", true);
			}else{
				obj.removeAttr("checked");
			}
	   		if(lable.attr('class')=='label_check c_off'||lable.attr('class')=='label_check'){
		  		lable.attr("class", "label_check c_on");
	   		}else{
	   			lable.attr("class", "label_check c_off");
	   		}
		}
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
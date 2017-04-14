<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${setting['app']}</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 
<script>
if(window.parent != window) {
	window.parent.location.href = "<%=request.getContextPath()%>/system/login/login.jsp";		
}
	$(document).ready(function(){
		//居中
		 document.getElementById("username").focus();
		 $("#username").keydown(function(event){
		 	if(event.keyCode==13){
				login()
			}
		 })
		 $("#password").keydown(function(event){
		 	if(event.keyCode==13){
				login()
			}
		 })
		 
	})


    function validateEmpty(str){
    	if (str == "") {
    	return true;
    	}
    	return false;
    }
function login(){
	//var comCode = document.getElementById("comCode").value;
	var loginName = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	if(validateEmpty(loginName)){
		   return false;
		}
	//if(validateEmpty(comCode)){
	//	   return false;
	//	}
	if(loginName.length<1 || loginName.length> 20){
		   return false;
		}
	if(validateEmpty(password)){
	     return false;
	}
	
	var objChk = document.getElementById("chkRememberPass");  
    if(objChk.checked){  
        //添加cookie  
        addCookie("userName",loginName,7,"/");  
//         addCookie("userPass",password,7,"/");  
    }
  	document.getElementById("loginForm").submit();
  }
  
  
  
function addCookie(name,value,days,path){   /**添加设置cookie**/  
    var name = escape(name);  
    var value = escape(value);  
    var expires = new Date();  
    expires.setTime(expires.getTime() + days * 3600000 * 24);  
    //path=/，表示cookie能在整个网站下使用，path=/temp，表示cookie只能在temp目录下使用  
    path = path == "" ? "" : ";path=" + path;  
    //GMT(Greenwich Mean Time)是格林尼治平时，现在的标准时间，协调世界时是UTC  
    //参数days只能是数字型  
    var _expires = (typeof days) == "string" ? "" : ";expires=" + expires.toUTCString();  
    document.cookie = name + "=" + value + _expires + path;  
}  
function getCookieValue(name){  /**获取cookie的值，根据cookie的键获取值**/  
    //用处理字符串的方式查找到key对应value  
    var name = escape(name);  
    //读cookie属性，这将返回文档的所有cookie  
    var allcookies = document.cookie;         
    //查找名为name的cookie的开始位置  
    name += "=";  
    var pos = allcookies.indexOf(name);      
    //如果找到了具有该名字的cookie，那么提取并使用它的值  
    if (pos != -1){                                             //如果pos值为-1则说明搜索"version="失败  
        var start = pos + name.length;                  //cookie值开始的位置  
        var end = allcookies.indexOf(";",start);        //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置  
        if (end == -1) end = allcookies.length;        //如果end值为-1说明cookie列表里只有一个cookie  
        var value = allcookies.substring(start,end); //提取cookie的值  
        return (value);                           //对它解码        
    }else{  //搜索失败，返回空字符串  
        return "";  
    }  
}  
function deleteCookie(name,path){   /**根据cookie的键，删除cookie，其实就是设置其失效**/  
    var name = escape(name);  
    var expires = new Date(0);  
    path = path == "" ? "" : ";path=" + path;  
    document.cookie = name + "="+ ";expires=" + expires.toUTCString() + path;  
}  
  
/**实现功能，保存用户的登录信息到cookie中。当登录页面被打开时，就查询cookie**/  
window.onload = function(){  
    var userNameValue = getCookieValue("userName");  
    document.getElementById("username").value = unescape(userNameValue);  
    var userPassValue = getCookieValue("userPass");  
    document.getElementById("password").value = userPassValue;  
}  
</script>

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>${setting['app']}</span>    
    <ul>
    <li><a href="#">帮助</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    
    <form id="loginForm" action="<%=path%>/j_spring_security_check" class="login_form" method="post">
    <ul>
    <li><input name="j_username" id="username" type="text" class="loginuser" value="" onclick="JavaScript:this.value=''"/></li>
    <li><input name="j_password" id="password" type="password" class="loginpwd" value="" onclick="JavaScript:this.value=''"/></li>
    <li><input name="" type="submit" class="loginbtn" value="登录"  onclick="login()"  /><label><input id="chkRememberPass" name="chkRememberPass" type="checkbox" checked="checked" />记住密码</label></li>
    </ul>
    </form>
    
    
    </div>
    
    </div>
    
    
    
    <div class="loginbm">版权所有 ：${setting['copyright'] }</div>
	
    
</body>

</html>

<%@ page import="java.sql.*" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<script language="JavaScript">
function add()
   {  if(form1.boy.value=="")
      {alert("input name " ); 
       return false;}
    else
    if(form1.pass.value=="")
      {alert("input password  " ); 
       return false;}
    else
    if(form1.code.value=="")
      {alert("input  verifycode " ); 
       return false;}
    else
    if(document.getElementById("showcheckA").innerHTML!=form1.code.value)
      {alert('验证码错误');
       return false;}
    else
      {alert(form1.boy.value+'你好');
       return ture;}
}

function showcheck() {
	if(document.getElementById("showcheckA")!=undefined){
	    document.getElementById("showcheckA").innerHTML=String(Math.ceil(Math.random()*9)) + String(Math.ceil(Math.random()*9)) + String(Math.ceil(Math.random()*9)) + String(Math.ceil(Math.random()*9));
	}
}

</script>
<body  onload="showcheck()"  bgcolor="#107000">
<% 
if(request.getParameter("out")!=null)
   {session.removeAttribute("login");
    session.removeAttribute("me");}
   if(session.getAttribute("login")!=null&&session.getAttribute("login").equals("OK"))
   {out.println("<h4><font color='white'>你已登录</font></h4>");
    out.println("<a href='welcome.jsp'><font color='white'>返回主页</font></a>");
    }
   else
     {if((session.getAttribute("login")==null||!session.getAttribute("login").equals("OK"))&&request.getParameter("boy")!=null&&request.getParameter("pass")!=null)
      {String strName=request.getParameter("boy");
       String strPass=request.getParameter("pass");
	   Class.forName("com.mysql.jdbc.Driver");
	   String strConn="JDBC:odbc:ShopData";
	   String strUser="sa";
	   String strPassword="root";
	  Connection conn=DriverManager.getConnection(strConn,strUser,strPassword);
	  Statement stmt=conn.createStatement();
          String strSql="select count(*) from Customer where Cname='"+strName+"'and Cpass='"+strPass+"'";
          ResultSet result=stmt.executeQuery(strSql);
          result.next();
       if(result.getInt(1)==1)
         {session.setAttribute("login","OK");
          session.setAttribute("me",strName);
	  result.close();
	  stmt.close();
	  conn.close();
          response.sendRedirect("welcome.jsp");
          }
         else
         {
         %><h4><font color="white">登录错误，请输入正确的用户名和密码</font></h4><%
          }
       }
       else
         if(session.getAttribute("login")==null)
          {out.println("<h4><font color='white'>你注销了或没登录，请登录</font></h4>");}
%>
<font size=5 color="black">
  <form action=""  onsubmit="javascript:return add();" method="post" name="form1"  >
     name  <input type="text" name="boy"> <br>
     password <input type="password" name="pass"><br> 
     verifycode  <input type="text" name="code" id="code">
     <span id="showcheckA" name="showcheckA" style="font-size:16pt;color='black';background-image: url(fuzzy.jpg);"></span>
     <a onclick="showcheck()" href="#">看不清 换下一张</a></div><br>
     <input type="submit" onclick="" value="提交" name="submit">
<a href="register.jsp">注册</a>
  </form> 
<%}%>
</font>
</body>
</html>
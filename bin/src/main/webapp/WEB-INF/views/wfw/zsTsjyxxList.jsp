<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String path = request.getContextPath();%>
<html>
  <head>
   <link href="<%=path%>/resources/css/tsjyxx.css" rel="stylesheet" type="text/css">
  
   <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,user-scalable=yes, initial-scale=1,maximum-scale=3"></meta>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/icons.css" />
  <link href="<%=path%>/resources/css/tsjyxx.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<%--   	<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script> --%>
	<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="lightBlue"/>
	<link href="<%=path%>/resources/css/base.css" rel="stylesheet" />
	<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
	
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/mobiscroll/mobiscroll.custom-2.13.2.min.css">  
 <!--时间控件mobiscroll-->  
   <script src="<%=path%>/resources/mobiscroll/js/mobiscroll.core-2.5.2.js" type="text/javascript"></script>  
   <script src="<%=path%>/resources/mobiscroll/js/mobiscroll.core-2.5.2-zh.js" type="text/javascript"></script>  
  
  
   <link href="<%=path%>/resources/mobiscroll/css/mobiscroll.core-2.5.2.css" rel="stylesheet" type="text/css" />  
   <link href="<%=path%>/resources/mobiscroll/css/mobiscroll.animation-2.5.2.css" rel="stylesheet" type="text/css" />  
   <script src="<%=path%>/resources/mobiscroll/js/mobiscroll.datetime-2.5.1.js" type="text/javascript"></script>  
   <script src="<%=path%>/resources/mobiscroll/js/mobiscroll.datetime-2.5.1-zh.js" type="text/javascript"></script>
  
   

<script type="text/javascript">
	//上月 下月
	/*function change(obj){
		document.getElementById("addflag").value=obj;
	  	var time=document.getElementById("date").value;
	  	var arr = time.split("-");
	    var date = new Date(arr[0], (parseFloat(arr[1])+parseFloat(obj)), 1);
		var d = new Date();
		d = new Date(d.getFullYear(), (d.getMonth()+1), d.getDate());
		if(date>d){
			alert("只能查询当前月以前的数据！");
			return false;
		}else{
	  		return true;
		}
    }*/
    $(function () {  
        var currYear = (new Date()).getFullYear();    
        var opt={};  
        opt.date = {preset : 'date'};  
        //opt.datetime = { preset : 'datetime', minDate: new Date(2012,3,10,9,22), maxDate: new Date(2014,7,30,15,44), stepMinute: 5  };  
        opt.datetime = {preset : 'datetime'};  
        opt.time = {preset : 'time'};  
        opt.default = {  
            theme: 'jqm', //皮肤样式  
            display: 'modal', //显示方式   
            mode: 'scroller', //日期选择模式  
            dateFormat : 'yy-mm', // 日期格式 
            dateOrder : 'yymm', //面板中日期排列格式  
            lang:'zh',  
            startYear:currYear - 20, //开始年份  
            endYear:currYear + 20 //结束年份  
        };  

        $("#appDateTime").val('').scroller('destroy').scroller($.extend(opt['date'], opt['default']));  
        var optDateTime = $.extend(opt['datetime'], opt['default']);  
        
    });
    function getValue(){
    	//alert($('#appDateTime').val());
    	$('#Form1').submit();
    }
    function setValue(){
    	var time=$('#date').val();
    	$("#appDateTime").val(time);
    }
	</script>
    <%-- <link href="<%=path%>/resources/css/tab-import.css" rel="stylesheet" style="text/css" />
	<link href="<%=path%>/resources/css/css.css" rel="stylesheet" style="text/css" /> --%>
	<title>图书借阅信息</title>
  </head>
 
  <body style="max-width:640px;margin-left: auto;margin-right: auto;" onload="setValue();">
  <div style="display:none;">
<ul class="tab-menu tab" id="tabMenuID_">
	<li class="tab-selected" title="图书借阅信息">
	<a href="#" target="content" onfocus="this.blur()"><span>图书借阅信息</span></a>
	</li>
</ul>
</div>
   <form action="<%=path%>/wfw/ZsTsjyxx/toTsjyxxBysj" method="POST" id="Form1"> 
   <input type="hidden" id="date" name="date" value="${time}">
   <input type="hidden" name="openId" id="openId" value="${openId }"> 
   <div class="bg1">
	<div class="style1">
		<div class="wwx_f_l" style="position: relative;">
		<a class="font1" style="color:white;" href="<%=path%>/wfw/ZsTsjyxx/toTsjyxx?openId=${openId }">归还时间</a>
		<input id="appDateTime" name="time" onchange="getValue();" 
		       style="border:1px solid #dddddd;margin-left: 10px; margin-bottom: 4px;"/> 
		</div>
				<div class="wwx_clear"></div>
				<div class="anniu" style="left:90%;top:15%;" >
				<a style="float:right;width:40px;height:50px;" href="<%=path%>/wfw/zy/zhuye?openId=${openId}" >
			   <img style="width:70%" src="<%=path%>/resources/img/wfwzy.png" >
			   </a>
			      </div>
	</div>
</div>
   <div class="tab-container">
				<%-- <!--我的成绩-->
				<label style="font-size: 15pt;">微服务-图书借阅查询</label><br /><br />
				<a href="<%=path%>/wfw/zy/zhuye?openId=${openId}" >
                  <div class="zhuye">
			   <img style="width:70%" src="<%=path%>/resources/img/zyan.png" >
			      </div>
		    </a> --%>
	<div>
	<div class="style4">
	                   <c:if test="${empty cjlist}">
										<div class="text" style="padding-top: 32px;">
											<p>图书借阅信息暂无...</p>
										</div>
						</c:if> 
	<c:forEach var="data" items="${cjlist}" varStatus="obj">
		<div class="maring1">
				<div class="wwx_f_l" style="width:100%">
					<table class="biaoge" style="width:100%; font-size: 17px;">
					    <tr>
					       <td class="td">学号/工号</td>
					       <td>${data.bh }</td>
					    <tr>
					    <tr>
					       <td class="td">姓名</td>
					       <td>${data.xm }</td>
					    <tr>
					    <tr>
					       <td class="td">图书书名</td>
					       <td>${data.TSMC }</td>
					    <tr>
					       <td class="td">图书编号</td>
					       <td class="td">${data.TSBH }</td>
					    </tr>
					    <tr>
					        <td class="td">借出时间</td>
					        <td class="td">${data.JCSJ }</td>
					    </tr>
					    <tr>
					        <td class="td">归还时间</td>
					        <td class="td">${data.GHSJ }</td>
					    </tr>
					</table>
				</div>
				<div class="wwx_clear"></div>
			</div>	
		</c:forEach>
		</div>		
		</div>
   </div>
		</form>		
  </body>
  <script type="text/javascript">
$(function() {
    $("table tr:nth-child(odd)").addClass("odd-row");
	$("table td:first-child, table th:first-child").addClass("first");
	$("table td:last-child, table th:last-child").addClass("last");
});
</script>
</html>

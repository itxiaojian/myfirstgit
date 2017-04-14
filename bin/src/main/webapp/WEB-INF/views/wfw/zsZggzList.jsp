<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String path = request.getContextPath();%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,user-scalable=yes, initial-scale=1,maximum-scale=3"></meta>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/icons.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/heeh.css" />
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
        opt.date = {preset : 'date',maxDate:new Date()};  
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
	<link href="<%=path%>/resources/css/tab-import.css" rel="stylesheet" style="text/css" />
	<link href="<%=path%>/resources/css/css.css" rel="stylesheet" style="text/css" />
	<title>我的工资</title>
	<style>
		.td_left {
			text-align: center;
			padding-left: 5px;
			width: 10%;
		}
		.td_right {
			text-align: center;
			padding-right: 5px;
			width: 10%;
		}
	</style>
  </head>
 
  <body style="overflow: auto;" onload="setValue();">
  <div style="display:none;">
<ul class="tab-menu tab" id="tabMenuID_">
	<li class="tab-selected" title="个人工资信息">
	<a href="#" target="content" onfocus="this.blur()"><span>个人工资信息</span></a>
	</li>
</ul>
</div>
   <form action="<%=path%>/wfw/ZsZggz/toZggzxxBysj" method="POST" id="Form1" style="margin-top: 60px;">  
<div class="bg1">
	<div class="style1">
		<div class="wwx_f_l" style="position: relative;">
		<a class="font1" style="color:white;" href="<%=path%>/wfw/ZsZggz/toZggzxx?openId=${openId }">工资发放时间</a>
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
   <input type="hidden" name="openId" id="openId" value="${openId }"> 
   <div class="tab-container">
				<!--我的工资-->
<!-- 				<input type="hidden" id="addflag" name="addflag" value=""> -->
				<input type="hidden" id="date" name="date" value="${time}">
<%-- 				<input type="hidden" id="time" name="time" value="${time}"> --%>
				<!-- <label style="font-size: 15pt;color:#58cbfa;">工资查询</label><br /> -->
				<!-- <input id="appDateTime" name="time" style="border: 1px solid #dddddd;" onchange="getValue();"/>  -->
<!-- 				<table  border="0" align="center" cellpadding="0" style="margin-top: 30px;border-width: 1px 2px 2px 1px;border-style: solid;width:100%;" -->
<!-- 						cellspacing="0"> -->
<!-- 						<tr> -->
<!-- 							<td align="center" width="20%"><input type="submit" title="上一月" style="width:17px;height:20px;cursor: pointer;" onClick="return change('-1')" id="log" class="me_f" name="log" value=" ">&nbsp;</td> -->
<%-- 							<td align="center" width="60%"><label style="font-size: 15pt;">微服务-工资查询${date}</label></td> --%>
<!-- 							<td align="center" width="20%"><input type="submit" title="下一月" style="width:15px;height:18px;cursor: pointer;" onClick="return change('1')" id="log" name="log"  class="me_b" value=" ">&nbsp;</td> -->
<!-- 						</tr> -->
<!-- 				</table> -->
                        <c:if test="${empty map}">
								
										<div class="text">
											<p>工资信息暂无...</p>
										</div>
						</c:if>
					<table border="0" align="center" cellpadding="0" style="margin-top: 10px;margin-bottom: 10px;width:100%; "
						cellspacing="0" class="content02">
						  
						<c:forEach var="map" items="${map}" varStatus="obj">
						<tr class="bgcolor01">
								<td class="d_right" style="width:40%;" align="center" >
									基本工资
								</td>
								<td class="td_left" style="width:60%;" align="center" >
									${map.jbgz }
								</td>
						</tr>
						<tr class="bgcolor02">
								<td class="td_right" width="40%" align="center">
									监考补助
								</td>
								<td class="td_left" width="60%" align="center">
									${map.jkbz }
								</td>
						</tr>	
						<tr class="bgcolor01">
								<td class="td_right" width="40%" align="center">
									坐班补助
								</td>
								<td class="td_left" width="60%" align="center">
									${map.zbbz }
								</td>
						</tr>
						<tr class="bgcolor02">
								<td class="td_right" width="40%" align="center">
									上课补助
								</td>
								<td class="td_left" width="60%" align="center">
									${map.skbz }
								</td>
						</tr>	
						<tr class="bgcolor01">
								<td class="td_right" width="40%" align="center">
									论文补助
								</td>
								<td class="td_left" width="60%" align="center">
									${map.lwbz }
								</td>
						</tr>
						<tr class="bgcolor02">
								<td class="td_right" width="40%" align="center">
									工资合计
								</td>
								<td class="td_left" width="60%" align="center">
									${map.gzhj }
								</td>
						</tr>	
						<tr class="bgcolor01">
								<td class="td_right" width="40%" align="center">
									社保扣除
								</td>
								<td class="td_left" width="60%" align="center">
									${map.sbkc }
								</td>
						</tr>
						<tr class="bgcolor02">
								<td class="td_right" width="40%" align="center">
									公积金扣除
								</td>
								<td class="td_left" width="60%" align="center">
									${map.gjjkc }
								</td>
						</tr>	
						<tr class="bgcolor01">
								<td class="td_right" width="40%" align="center">
									实发工资
								</td>
								<td class="td_left" width="60%" align="center">
									${map.sfgz }
								</td>
						</tr>
						</c:forEach>
					</table> </div>
		</form>		
  </body>
</html>

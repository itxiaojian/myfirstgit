<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib prefix="fn" uri="/WEB-INF/tld/fn.tld" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" style="margin-top: -10px;">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<link href="<%=path%>/resources/bootstrap/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<meta name="viewport"
	content="width=device-width,user-scalable=yes, initial-scale=1,maximum-scale=3">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=path%>/system/login/css/padstyle.css">
	<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<link type="text/css" rel="stylesheet"
	href="<%=path%>/resources/css/xyxw.css" />
<title>移动质检业务平台</title>
<style type="text/css">
.anniu {
	position: absolute;
	top: 11%;
	right: 88%
}

.return {
	position: absolute;
	top: 11%;
	left: 88%
}
.ZJ_mian_left{ position:absolute; left:-130px; top:0px; bottom:0px;width:130px; background:url(/zjyw/system/layout/img/L_BJ02.png) center no-repeat; background-size:cover;overflow:auto; z-index:5;}
</style>
</head>
<script type="text/javascript">
    function save(id){
    	location.href="<%=path%>/wxpt/WglXgxx/wglWdrwXq?id="+id;
    };
    
  </script>
 <script type="text/javascript">
		function query(){	
			if($('#search').val()=="样品名称"){$('#search').val('');}
			$("#myForm").submit();
		}
 </script>
 
   
<body style="overflow: auto;">
<div class="ipad">
    <div class="ZJ_top">
        <span id="L_btn"><img src="<%=path%>/system/layout/img/top_01.png"></span>
        <span>移动质检业务管理平台</span>
        <span><a onclick="exit();"><img src="<%=path%>/system/layout/img/top_03.png"></a></span>
        <span><img src="<%=path%>/system/layout/img/top_02.png">欢迎您：${sessionScope['LOGIN_USER'].xm}&nbsp;&nbsp;</span>
    </div>
    <div class="ZJ_mian">
        <div class="ZJ_mian_left" id="left_nav">
        	<ul>
            	<a href="<%=path%>/system/layout/main1.jsp"><li><img src="<%=path%>/system/layout/img/L_01.png">&nbsp;&nbsp;平台首页</li></a>
                <a href="<%=path%>/ZjPad/CydjPage"><li><img src="<%=path%>/system/layout/img/L_02.png">&nbsp;&nbsp;抽样登记</li></a>
                <a href="<%=path%>/ZjPad/ZxxxList"><li><img src="<%=path%>/system/layout/img/L_03.png">&nbsp;&nbsp;检验咨询</li></a>
                <a href="<%=path%>/ZjPad/ypcxPage"><li><img src="<%=path%>/system/layout/img/L_04.png">&nbsp;&nbsp;样品查询</li></a>
                <a href="<%=path%>/ZjPad/bgcxPage"><li><img src="<%=path%>/system/layout/img/L_05.png">&nbsp;&nbsp;报告查询</li></a>
                <a href="<%=path%>/ZjPad/bgshlist?ypcs=2"><li><img src="<%=path%>/system/layout/img/L_06.png">&nbsp;&nbsp;报告审核</li></a>
                <a href="<%=path%>/ZjPad/bgshlist?ypcs=3"><li><img src="<%=path%>/system/layout/img/L_07.png">&nbsp;&nbsp;报告批准</li></a>
                <a href="<%=path%>/ZjPad/warnPage"><li><img src="<%=path%>/system/layout/img/L_08.png">&nbsp;&nbsp;报告预警</li></a>
<%--                 <a href="<%=path%>/ypgl/YYpYj/ypyjPage;"><li><img src="<%=path%>/system/layout/img/L_09.png">&nbsp;&nbsp;样品移交</li></a> --%>
                <a href="<%=path%>/ZjPad/sbcxPage"><li><img src="<%=path%>/system/layout/img/L_11.png">&nbsp;&nbsp;设备查询</li></a>
                <a href="<%=path%>/ZjPad/tjtbPage"><li><img src="<%=path%>/system/layout/img/L_12.png">&nbsp;&nbsp;统计图表</li></a>
                <a href="<%=path%>/ZjPad/tjbbPage"><li><img src="<%=path%>/system/layout/img/L_12.png"/>&nbsp;&nbsp;统计报表</li></a>
            </ul>
        </div>
        <div class="ZJ_mian_right" id="main_R">

		<div style="position: relative;">
			<div class="h"></div>
			<div>
			<p></p>
			<div align="center">
			
			<form action="<%=path%>/wxpt/WglXgxx/wglbgshlist" id="myForm" method="post">
			<input type="text" style="width: 40%;hight:40%; margin-left: 0%; margin-top: 10px;" id="search"  name="cxtj" value="${cxtj}" />                     
					<script language="javascript"> 
 	                    var s=document.getElementById("search");
 	                    s.onfocus=function(){if(this.value==this.defaultValue)this.value=''};
	                    s.onblur=function (){if(/^\s*$/.test(this.value)){this.value='样品名称';this.style.color='#aaa'}}
	                    s.onkeydown=function(){	this.style.color='#333'}
                    </script> 
			<input type="hidden" name="ypcs" value="${ypcs}" />
			<a onclick="query();" style="color: black;cursor:pointer;">
			<img onclick="query();" src="<%=path%>/resources/img/cx.png" style="width: 20px; height: 20px;margin-top: -3px;"/>
			<b>查询</b></a>
			</form>
			
			</div>
			<form action="" id="form" name="form" method="post">
			<div style="position: relative;" align="center">
			<p></p>
			<table border="2" style="width: 100%;height: 30px;" bordercolor="#E0E0E0" class="table table-striped table-hover table-bordered" id="editable-sample">
			         <thead>
			           <tr>	
			           		<td align="center" style="display:none"> taskID</td>
			           		<td align="center" style="display:none"> assignee</td>
			           		<td align="center" style="display:none"> businessKey</td>
							<td align="center" style="width: 25%;border:0px"bgcolor="#32a9eb"> 样品编号</td>
							<td align="center" style="width: 30%;border:0px"bgcolor="#63c3f5">样品名称</td>
							<td align="center" style="width: 30%;border:0px"bgcolor="#3ab6f6">样品类型</td>
							<td align="center" style="width: 15%;border:0px"bgcolor="#119ee6">操作</td>
						</tr>
						</thead>
			         <c:forEach var="getwdrw" items="${getwdrw}" varStatus="obj">
						<tr id="t3">
							<td align="center" style="width: 75px;display:none">${getwdrw.taskId} </td>
							<td align="center" style="width: 75px;display:none">${getwdrw.assignee }</td>
							<td align="center" style="width: 75px;display:none">${getwdrw.businessKey }</td>
							<td align="center" style="border:0px;">${getwdrw.ypbh }</td> 
							<td align="center" style="border:0px;">${getwdrw.ypmc }</td> 
							<td align="center" style="border:0px;">${getwdrw.jylx}</td> 
					
					<td align="center" style="border:0px;">
							<c:if test="${getwdrw.assignee =='' || getwdrw.assignee == null }">
								<a class="edit" onclick="qianshou('${getwdrw.taskId}');" style="border:0px;">签收</a>
							</c:if>
							<c:if test="${getwdrw.assignee !='' && getwdrw.assignee != null && ypcs==2 }">
							<a class="edit" href="<%=path%>/ZjPad/openTaskDealPage/${getwdrw.taskId}/${getwdrw.businessKey}/${ypcs}" style="border:0px;">审核</a>
							</c:if>
							<c:if test="${getwdrw.assignee !='' && getwdrw.assignee != null && ypcs==3 }">
							<a class="edit" href="<%=path%>/ZjPad/openTaskDealPage/${getwdrw.taskId}/${getwdrw.businessKey}/${ypcs}" style="border:0px;">批准</a>
							</c:if>
					 </td> 
						</tr>
			         </c:forEach>	
				</table>
			</div>
			</form>
		</div>    
	</div>
</div>
</div>
	<div class="foot">安徽省产品质量监督检查研究院  皖ICP备08001861号-1  地址：合肥市包河工业园延安路13号  邮政编码：230051  电话：0551-63356268  63855622</div>
</div>
</body>
<script type="text/javascript">

	function qianshou(taskId,assignee){
             var url = "<%=path%>/wxpt/WglXgxx/wglWdrwqs";
             $.ajax({
                 cache: true,
                 type: "POST",
                 url: url,
                 data: {taskId:taskId},// 你的formid
                 async: false,
                 error: function (request) {
                     alert("保存失败,请联系管理员。");
                 },
                 success : function(data) {
                	 window.location.reload();
     			}
             });
	}

	 function exit(){
//	 		success: function () {
		       msg="确定退出？";
	       		if(confirm(msg)){
	       			location.href="<%=path%>/j_spring_security_logout"
	   			}
//	 		}
		}
	 
	 $("#L_btn").click(function(){
			$("#left_nav").animate({marginLeft:130},1000)
		})
		$("#main_R").click(function(){
			$("#left_nav").animate({marginLeft:0},1000)
		})
</script>
</html>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<% String path = request.getContextPath();%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
   <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>  
    <link href="<%=path%>/resources/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/system/login/css/padstyle.css">
    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/cps/checkData.js"></script>
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/DialogBySHF.css">
    <script type="text/javascript" src="<%=path%>/resources/css/jygl/DialogBySHF.js"></script>
    <title>移动质检业务平台</title>
    <style type="text/css">
		.thbg {
				padding: 6px 12px; 
				background-color: #eeeeee;	
		}   
		.optionContentSignClass{
			width:250px;
		} 
		.optionContentClass{
			width:250px;
		} 
		a{
			cursor:pointer;
		}
		.ZJ_mian_left{ position:absolute; left:-130px; top:0px; bottom:0px;width:130px; background:url(/zjywpad/system/layout/img/L_BJ02.png) center no-repeat; background-size:cover;overflow:auto; z-index:5;}
    </style>
   </head> 
  <body>
  	<?xml version="1.0" encoding="iso-8859-1"?>  
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
	<div class="panel panel-success">
	    <div style="width:0px;height:0px;border-width: 0px;">
	        <iframe id="test1" src="<%=path%>/jygl/YjyBgxx/pzr?bgbh=${bgbh }&key=${businessKey} "
	                style="width:0px;height:0px;border-width: 0px;"></iframe>
	        <iframe id="test2" src="" style="width:0px;height:0px;border-width: 0px;"></iframe>
   		</div>
		<div class="panel-heading">样品信息:</div>
		<table class="table table-bordered">
			<tr>
				<th class="thbg">样品编号</th>
				<td>${mapBusi.ypbh}</td>
				<th class="thbg">样品名称</th>
				<td>
					<a target="_blank" href="<%=path%>/jygl/YjyJyxx/lcypxx?ypid=${mapBusi.id}&djlx=${mapBusi.djlx}" title="点击查看样品信息">${mapBusi.ypmc}</a>
				</td>
			</tr>
		</table>
	</div>	  

<!-- 审批意见表单填写 -->
	<div class="panel panel-success">
	  <div class="panel-body" >
			<form name="submitForm" id="optionForm" method="post">
			<input type="hidden" name="projectName" id="projectName" value="${pageContext.request.contextPath}"/>
				<input type="hidden" name="businessKey" value="${businessKey}" />	
				<input type="hidden" name="taskId" value="${taskId}" />	
				<input type="hidden" name="userCode" value="${userCode}" />	
				<input type="hidden" name = "lineVariable" id="lineVar" value="${lineVar}" />	
				<input type="hidden" name = "tname" id="tname" value="${tname}" />
				<input type="hidden" name = "value" id="valueInputId" />
				<div align="center">
					<br>
					<input type="button" class="btn btn-primary" style="margin-left: -82px;"
						onclick="ylbg('${mapBusi.bgbh}');" value="报告批准" />
					<input type="submit" class="btn btn-danger" style="margin-left: 97px;"
						onclick="disagree();" value="不通过" />
				    <input type="button" class="btn btn-primary" style="margin-left: 97px;"
						onclick="back();" value="返回" />
				</div>
			</form>
	  </div>
	</div>
	<!--历史审批意见-->
	<div class="panel panel-success">
		<div class="panel-heading">历史阶段意见:</div>
		<!-- Table -->
		<table class="table table-striped table-bordered" style="margin: auto;table-layout:fixed;font-size: 12px">
			<tr style="font-size: 13px">
				<td style="width:50px;font-weight: bold;" align="center">阶段</td>
				<td style="font-weight: bold;" width="50" align="center" >操作人</td>
				<td style="font-weight: bold;" width="40" align="center">审批动作</td>
				<td style="font-weight: bold;" width="260" align="center">审批意见</td>
				<td style="font-weight: bold;" width="110" align="center">操作时间</td>
			</tr>
			<c:forEach var="data" items="${listOption}" varStatus="status">
				<tr>
					<td align="center" style="word-wrap:break-word">${data.shjdmc}</td>
					<td align="center" style="word-wrap:break-word">${data.shr}</td>
					<td align="center" style="word-wrap:break-word">
						<c:if test="${data.shzt == '1'}">
							通过
						</c:if>
						<c:if test="${data.shzt == '0'}">
							不通过
						</c:if>
						<c:if test="${data.shzt == '3'}">
							解锁
						</c:if>
						<c:if test="${data.shzt == '2'}">
							归档
						</c:if>
					</td>
					<td id="optionContentId${data.shyj}"
							<c:if test="${data.signData == ''}">
								class="optionContentClass"
							</c:if>
							<c:if test="${data.signData != ''}">
								class="optionContentSignClass"
							</c:if>
						align="center" style="word-wrap:break-word">${data.shyj}</td>
					<td align="center" style="word-wrap:break-word">${data.shsj}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</div>
	</div>
	<div class="foot">安徽省产品质量监督检查研究院  皖ICP备08001861号-1  地址：合肥市包河工业园延安路13号  邮政编码：230051  电话：0551-63356268  63855622</div>
	</div>
	
  </body>
</html>
<script type="text/javascript">

$("#L_btn").click(function(){
	$("#left_nav").animate({marginLeft:130},1000)
})
$("#main_R").click(function(){
	$("#left_nav").animate({marginLeft:0},1000)
})

function back(){
//	 		success: function () {
		       msg="确定返回？您填写的数据有可能丢失！";
	       		if(confirm(msg)){
	       			window.history.back(-1);
	   			}
//	 		}
		}
		
	var userCode = "${userCode}";
	var taskId = "${taskId}";
	var creditId = "${businessKey}";
	var userCode = "${userCode}";
    var lineVar = $("#lineVar").val();
    var tname =  $("#tname").val();
	var url=$("#projectName").val();//获取跟目录
	var options = {  
			//   target: '#output',          //把服务器返回的内容放入id为output的元素中     
			   beforeSubmit: showRequest,  //提交前的回调函数  
			   success: showResponse,      //提交后的回调函数  
			   url: url+'/cps/deal/dealJSZXPZAct',   //默认是form的action， 如果申明，则会覆盖  
			   //type: type,               //默认是form的method（get or post），如果申明，则会覆盖  
			   dataType: 'json',           //html(默认), xml, script, json...接受服务端返回的类型  
			   //clearForm: true,          //成功提交后，清除所有表单元素的值  
			   //resetForm: true,          //成功提交后，重置所有表单元素的值  
			   timeout: 10000              //限制请求的时间，当请求大于10秒后，跳出请求  
			};
	
	function viewCreditPdf(ypid,djlx) {
		href="<%=path%>/jygl/YjyJyxx/lcypxx?ypid="+ypid+"&djlx=" + djlx;
		} 
	
	//报告生成
	function ylbg(bgbh){
		var fileUrl = "<%=path%>/resources/doc/"+bgbh+"sypz.doc";
        createXMLHttpRequest();
        xmlHttp.open("GET",fileUrl,true);
        xmlHttp.send(null);
        xmlHttp.onreadystatechange = function(){
            if(xmlHttp.readyState==4){
                if(xmlHttp.status==200){
		location.href = "<%=path%>/jygl/YjyBgxx/pzbgck?bgbh="+bgbh+"&userCode="+userCode+"&taskId="+taskId+"&businessKey="+creditId+"&lineVar="+lineVar+"&tname="+tname;
                }
            }
        }
		
		
	}
	
	function showRequest(formData, jqForm, options){  
		   //formData: 数组对象，提交表单时，Form插件会以Ajax方式自动提交这些数据，格式如：[{name:user,value:val },{name:pwd,value:pwd}]  
		   //jqForm:   jQuery对象，封装了表单的元素     
		   //options:  options对象  
		  // var queryString = $.param(formData);   //name=1&address=2  
		  // var formElement = jqForm[0];              //将jqForm转换为DOM对象  
		   //var address = formElement.address.value;  //访问jqForm的DOM元素  
		   return true;  //只要不返回false，表单都会提交,在这里可以对表单元素进行验证  
	};  
	function showResponse(responseText, statusText){ 
			 if(responseText.success == true) {
				   alert('任务处理成功!');
	                window.parent.pendPoolGrid.store.load();
	                window.parent.ACT_DEAL_WINDOW.close();
			 }else {
				   alert('任务处理失败!');
			 }
	};		
	//批准
	function agree() {
		var returnFlag = checkApproveData();
		if(returnFlag) {
			$("#valueInputId").val(1);
			$("#optionForm").ajaxForm(options);  
		}else{
			window.onbeforeunload = function(){ return '将丢失未保存的数据!'; }
			return false;
		}
	}
	//不批准
	function disagree() {
		msg = "是否确定？";
        if (confirm(msg)) {
			$("#valueInputId").val(0);
			$("#optionForm").ajaxForm(options); 
        }
	}
	//校验输入的审批意见
	function checkApproveData() {
		var returnFlag = true;
		/* var optinoContent = $("#optinoContentId").val();
		if (optinoContent == null ||  optinoContent=="" ) {
			returnFlag = false;
			alert('请填写意见!');
			return returnFlag;
		} */
		return returnFlag;
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
</script>
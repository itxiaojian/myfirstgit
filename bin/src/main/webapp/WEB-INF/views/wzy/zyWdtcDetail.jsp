<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta name="viewport"
	content="width=device-width,user-scalable=no, initial-scale=1">
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<title>我要吐槽</title>
<script src="<%=path%>/resources/js/wzy/jquery.js"></script>
<script src="<%=path%>/resources/js/wzy/json2.js"></script>
<link type="text/css" href="<%=path%>/resources/css/tucao.css"
	rel="stylesheet" />
<link type="text/css" href="<%=path%>/resources/css/page.css"
	rel="stylesheet" />
	<link type="text/css" rel="stylesheet"
	href="<%=path%>/resources/css/xyxw.css" />
<style>
#replay {
	z-index: 1000;
	display: none;
}
</style>
</head>
<body style="background:#efefef;">
	<div id="test"></div>
	<div id="header" class="header">
		<img src="<%=path%>/resources/img/BT.jpg" style="width: 100%;" />
		<div class="anniu" style="left: 88%">
			<a href="<%=path%>/wzy/ZyXyxw/zhuye?openId=${openId}" style="float:right;width:40px;height:50px;" >
			   <img  style="width:70%"
			    src="<%=path%>/resources/img/zyan.png" />
			    </a>
			</div>
	</div>
	<div class="tctotal">
		<div class="tctotal_left">
		<c:forEach items="${list2}" var="data">
			<span id="tc_ListCount" class="tctotalnum">${data.size }</span> 话题
		</c:forEach>
		</div>
		<div class="tctotal_right">
		<c:forEach items="${list3}" var="data">
			<span id="tc_AccessCount" class="tctotalnum">${data.size }</span> 赞
		</c:forEach>
		</div>
		<input type="hidden" id="openid" value="${openId}">
	</div>

	<div class="content">
		<c:forEach items="${list}" var="list">
			<div class="tclist">
				<div class="tcheader">
					<img src="${list.txdz}" class="tcheadimg" />
				</div>
				<div class="tccontent">
					<div class="tctitle">${list.tcrxm}</div>
					<div class="tctime">${list.tcsj}</div>
					<div class="tctext">${list.tcnr}</div>
					<div class="tcbutton">
						<a href="javascript:void(0);" onclick="DoTCZhan(${list.id})">
							<img src="<%=path%>/resources/img/zan.png" style="width:20px;height:20px;"/> 赞 (<span
							id="t_tucao_zhan_${list.id}">${list.bzcs}</span>)
						</a> <a href="javascript:void(0);" onclick="DisplayReply(${list.id})">
							<img src="<%=path%>/resources/img/huifu.png" style="width:20px;height:20px;" /> 回复 (<span
							id="t_tucao_reply_">${list.hfcs}</span>)
						</a>
							<c:if test="${list.tcr==openId }">
						<a href="javascript:void(0);" onclick="DisplayDelete('${list.id }','${openId}')">
							<img src="<%=path%>/resources/images/iconfont-shanchu.png" style="width:20px;height:20px;" /> 删除 <span
							id="t_tucao_delete_"></span>
						</a>
						</c:if>
					</div>
					<div class="tcreply">
						<c:forEach items="${list.listHF}" var="listHF">
							<div id="t_tucao_morereply_">
								<div class="tcreplaylist">
									<span class="tcreplayname"> ${listHF.hfrxm }:</span> 
									<span class="tcreplaymsg"> ${listHF.hfnr} </span>
									<br/>
									<span class="tctime">${listHF.hfsj} </span>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<!-- <div style="height: 200px;"></div> -->
	<div class="tcsubmit">
		<div class="tcsubmittitle">
			<a href="#" class="tcsubmita" onclick="DisplaySubmit();"><img
				src="<%=path%>/resources/img/write.png" /> 发话题</a>
		</div>
		<div class="tcsubmitbar">
			<p>
				<textarea id="t_tucao_text" maxlength="140" rows="4"></textarea>
			</p>
			<div class="tcsubmitbutton">
				<span class="tcsubmitbutton_num">140字</span> <a class="tcsubmitb"
					href="#" onclick="DoTuCao();">发表</a> <a class="tcsubmitb" href="#"
					onclick="DisplaySubmit();">取消</a>
			</div>
		</div>
	</div>
	<div id="replay" class="tcsubmit">
		<div class="tcsubmittitle">
			<a href="#" class="tcsubmita"><img
				src="<%=path%>/resources/img/write.png" /> 我要回复</a>
		</div>
		<p>
			<textarea id="t_tucao_reply" maxlength="140" rows="4"></textarea>
		</p>
		<div class="tcsubmitbutton">
			<span class="tcsubmitbutton_num">140字</span> <a class="tcsubmitb"
				href="#" onclick="DoTCReply();">回复</a> <a class="tcsubmitb" href="#"
				onclick="DisplayReply();">取消</a>
		</div>
	</div>
	<form method="post"
		action="tucao.aspx?OpenID=oRvupjoWhCKA3zufAtcpx0XnFtI8" id="form1">
		<div class="aspNetHidden">
			<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE"
				value="/wEPDwUKMTY0MDc2Nzg2N2Rk9Cyx3Iii1rsx0f/do2egB6ykfZPbyTNcn1e+64jQGu8=" />
		</div>

		<div class="aspNetHidden">

			<input type="hidden" name="__VIEWSTATEGENERATOR"
				id="__VIEWSTATEGENERATOR" value="ADBD8E75" />
		</div>
	</form>
</body>
</html>
<script>

function DisplaySubmit() {   //发话题
	if ($(".tcsubmitbar").css("display") == "block") {
		$(".tcsubmitbar").css("display", "none");
	} else {
		$(".tcsubmitbar").css("display", "block");
	}
}

function DoTuCao() {   //发布
	if ($("#t_tucao_text").val() == "") {
		return;
	}
	var tcnr = $("#t_tucao_text").val();
	var openId = $("#openid").val();
	//var openId = 'ocFFwuHOpoUHVQQGNgcRsMFbYVGg';
	$(document).ready(
			function() {
				$.ajax({
					type : "POST",
					url : "<%=path%>/wzy/ZyWdtc/doTucao",
					data : {tcnr:tcnr,openId:openId},
					//contentType : "text/plain",
					dataType : "json",
					success : function(msg) {
						if (msg.success) {
							document.location.reload();
						} else {
							alert(msg.message);
						}
					}
				});

			});
	}

/* 	var RTid = "";
	function DisplayReply(id) { //我要回复
		
		if ($("#replay").css("display") == "block") {
			$("#replay").css("display", "none");
			RTid = "";
		} else {
			$("#replay").css("display", "block");
			RTid = id;
		}
	} */

	
	function DoTCZhan(id,thisid) {    //赞
		var openId = $("#openid").val();
		$(document).ready(
				function() {
					$.ajax({
						type : "POST",
						url : "<%=path%>/wzy/ZyWdtc/doTczhan",
						data : {id:id,openId:openId},
						//contentType : "application/json; charset=utf-8",
						dataType : "json",
						success : function(msg) {
							if(msg.success){
								$("#t_tucao_zhan_" + id).text(
										parseInt($("#t_tucao_zhan_" + id)
												.text()) + 1);
								/* document.location.reload(); */
							}else{
								alert("您已经赞过！");
							}
							
							
						}
						
					});
				});
	}
	
	
	var RTid = "";
	function DisplayReply(id) { //我要回复
		if ($("#replay").css("display") == "block") {
			$("#replay").css("display", "none");
			RTid = "";
		} else {
			$("#replay").css("display", "block");
			RTid = id;
		}
	}
	
	function DoTCReply(id) {   //回复
		if ($("#t_tucao_reply").val() == "") {
			return;
		}
		var hfnr = $("#t_tucao_reply").val();
		//var openId = 'ocFFwuHOpoUHVQQGNgcRsMFbYVGg';
		var openId = $("#openid").val();
		openId
		$(document).ready(
				function() {
					$.ajax({
						type : "POST",
						url : "<%=path%>/wzy/ZyWdtc/doTcreply",
						data : {hfnr:hfnr, id:RTid,openId:openId},
						//contentType : "application/json; charset=utf-8",
						dataType : "json",
						success : function(msg) {
							 document.location.reload();
						}
					});
				});
	}
	
	//删除  DisplayDelete
	function DisplayDelete(id,openId) {    //删除
		//var openId = 'ocFFwuHOpoUHVQQGNgcRsMFbYVGg';
		var openId = $("#openid").val();
				 if(confirm("您确定要删除吗？")){
					$.ajax({
						type : "POST",
						url : 'deleteWdtcList',
						data : {id:id,openId:openId},
						dataType : "json",
						success : function(msg) {
							if(msg.success){
								alert("删除成功！");
								 document.location.reload(); 
							}else{
								alert("删除失败！请联系管理员");
							}
						}
						
					});
				}
	}; 
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1" />
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js" />
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js" />
<script type="text/javascript" src="<%=path%>/resources/js/app.js" />
<script src="<%=path%>/libs/js/framework.js" type="text/javascript" />
<script src="<%=path%>/resources/js/wzy/jquery.js"></script>
<script src="<%=path%>/resources/js/wzy/json2.js"></script>
<link type="text/css" href="<%=path%>/resources/css/tucao.css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/bbq.css" />

<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet"
	type="text/css" id="theme" themeColor="lightBlue" />
<link href="<%=path%>/resources/css/base.css" rel="stylesheet" />
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<title>表白墙</title>
<style>
#replay {
	z-index: 1000;
	display: none;
}
</style>
</head>

<body>
<div style="display:none;">
<ul class="tab-menu tab" id="tabMenuID_">
	<li class="tab-selected" title="表白墙">
	<a href="#" target="content" onfocus="this.blur()"><span>表白墙</span></a>
	</li>
</ul>
</div>
     <div class="main">
        <div class="DYtop">
           <div class="p"><p>表白墙</p></div>
           <input type="hidden" id="openid" value="${openId}" />
        </div>
        <div class="anniu" style="left: 88%">
			<a href="<%=path%>/wsh/zy/zhuye?openId=${openId}" style="float:right;width:40px;height:50px;" >
			   <img  style="width:70%"
			    src="<%=path%>/resources/img/wfwzy.png" />
			    </a>
			</div>
        <div class="zhengwen">
        <c:forEach items="${list}" var="list">
           <div class="tclist" style="margin-left: auto;margin-right: auto;width:90%;border-top-width: 15px;padding-bottom: 0em;">
               <%-- <div class="tx">
                 <img src="${list.txdz}"  />
               </div> --%>
               <div class="content">
               <div class="tcheader">
					<img src="${list.txdz}" class="tcheadimg" />
				</div>
				<div class="shanchu" style="float:right;">
                <c:if test="${list.tcr==openId }">
                       <a class="S_txt2" href="javascript:void(0);" onclick="DisplayDelete('${list.id }','${openId}')">
                      <span class="pos">
                        <span class="line S_line1" style="border-right-width: 0px;"> 删除  </span>
                      </span>
                      </a>
                   </c:if>
               </div>
               <div class="xm"><span>${list.tcrxm}</span></div>
               <div class="rq"><span>${list.tcsj}</span></div>
               <div class="bbnr">${list.tcnr}</div>
               </div>
               
               <div class="foot">
                 <ul class="WB_row_line WB_row_r4 clearfix S_line2">
                   <li>
                       <a class="S_txt2" href="javascript:void(0);" onclick="DisplayReply(${list.id})">
                      <span class="pos">
                        <span class="line S_line1"> 评论 (<span id="t_tucao_reply_">${list.hfcs}</span>) </span>
                      </span>
                      </a>
                   </li>
                   
                   <li>
                       <a class="S_txt2" href="javascript:void(0);" onclick="DoTCZhan(${list.id})">
                      <span class="pos">
                        <span class="line S_line1" style="border-right-width: 0px;"> 祝福 (<span id="t_tucao_zhan_${list.id}">${list.bzcs}</span>)
                      </span>
                      </a>
                   </li>
                 </ul>
               </div>
               
                <div class="tcreply" style="padding-top: 0em;">
						<c:forEach items="${list.listHF}" var="listHF">
							<div id="t_tucao_morereply_">
								<div class="tcreplaylist" style="margin-top: 0.3em;">
									<span class="tcreplayname"> ${listHF.hfrxm }:</span> 
									<span class="tcreplaymsg"> ${listHF.hfnr} </span>
									<br/>
									<span class="tctime">${listHF.hfsj} </span>
								</div>
							</div>
						</c:forEach>
					</div>
           </div>
           </c:forEach>
        </div>
     
      </div>
     <!--  <div style="height: 200px;"></div> -->
	<div class="tcsubmit">
		<div class="tcsubmittitle">
			<a href="#" class="tcsubmita" onclick="DisplaySubmit();"><img
				src="<%=path%>/resources/img/write.png" />我要表白</a>
		</div>
		<div class="tcsubmitbar">
			<p>
				<textarea id="t_tucao_text" maxlength="140" rows="4"></textarea>
			</p>
			<div class="tcsubmitbutton">
				<span class="tcsubmitbutton_num">140字</span> <a class="tcsubmitb"
					href="#" onclick="DoBiaoBai();">发送</a> <a class="tcsubmitb" href="#"
					onclick="DisplaySubmit();">取消</a>
			</div>
		</div>
	</div>
	<div id="replay" class="tcsubmit">
		<div class="tcsubmittitle">
			<a href="#" class="tcsubmita"><img
				src="<%=path%>/resources/img/write.png" /> 回复表白</a>
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

function DoBiaoBai() {   //发布表白墙
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
					url : "<%=path%>/wzy/ZyWdtc/doBiaoBai",
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
	
	function DoTCZhan(id,thisid) {    //祝福
		var openId = $("#openid").val();
		//var openId = 'ocFFwuHOpoUHVQQGNgcRsMFbYVGg';
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
								alert("谢谢您的支持^0^");
							}else{
								alert("您已祝福过，请勿重复^0^");
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
	
	function DoTCReply(id) {   //表白回复
		if ($("#t_tucao_reply").val() == "") {
			return;
		}
		var hfnr = $("#t_tucao_reply").val();
		var openId = $("#openid").val();
		//var openId = 'ocFFwuHOpoUHVQQGNgcRsMFbYVGg';
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
	};
	
	//删除  DisplayDelete
	function DisplayDelete(id,openId) {    //删除
		//var openId = 'ocFFwuHOpoUHVQQGNgcRsMFbYVGg';
		var openId = $("#openid").val();
				 if(confirm("您确定要删除吗？")){
					$.ajax({
						type : "POST",
						url : 'deleteBbqList',
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
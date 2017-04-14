<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" class=" js ">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport"
		content="width=device-width,user-scalable=no, initial-scale=1"></meta>
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Cache-Control" content="no-store">
<meta http-equiv="Expires" content="0">
<title>设备信息</title>
<link href="<%=path%>/resources/skin/base.css" rel="stylesheet"></link>
	<link href="<%=path%>/resources/skin/wjend.css" rel="stylesheet"></link>
		<link href="<%=path%>/resources/skin/darkblue.css" rel="stylesheet"></link>
			<link href="<%=path%>/resources/skin/hcheckbox.css" rel="stylesheet"></link>
<script type="text/javascript">
</script>
</head>
<body>
	<p style="display: none;" class="hei_cq" _hei="1323" id="body"></p>

	<div class="wjContent clear" id="survey_page"
		style="width: 85%;">
		<div class="content" id="begin_content">


			<div class="wjtitle mtop project_title">
				<h1>${map.sbmc }</h1>
			</div>
			<div class="wjintro mtop desc_begin">
			</div>

			<div class="wjhr mtop" ></div>

		</div>
		<div id="question_box">
			<div class="maxtop btns title" id="loader_div_1"
				style="display: none; text-align: center;width: 100%;">
				<img src="<%=path%>/resources/skin/loader.gif" alt=""> <br>
				加载中...
			</div>
		<form method="post" action="" name="myForm" id="myForm">
				<!-- Append question's html code here. -->
<!-- 					<div class="wjques maxtop question jqtransformdone" -->
<%-- 						 questiontype="${data.qtype}"> --%>
<%-- 						<div class="title" id="title${obj.count}">${data.seq}.${data.content}</div> --%>
<%-- 						<div id="tip_${obj.count}" class="red"></div> --%>
						<div class="matrix" style="text-align: center;">
						
							<table style="width: 100%;">
								<tbody>
									<tr>
										<td style="text-align: center;">设备编号：</td>
										<td style="text-align: center;">
											${map.sbbh }
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">规格型号：</td>
										<td style="text-align: center;">
											${map.sbxh }
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											设备类别：
										</td>
										<td style="text-align: center;">${map.sblx }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											生产厂家：
										</td>
										<td style="text-align: center;">${map.sccj }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											出厂编号：
										</td>
										<td style="text-align: center;">
											${map.ccbh }
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											登记日期：
										</td>
										<td style="text-align: center;">
											${map.ccrq }
										</td>
									</tr>
									
									<tr>
										<td style="text-align: center;">
											购买日期：
										</td>
										<td style="text-align: center;">${map.gmrq }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											购买价格：
										</td>
										<td style="text-align: center;">${map.gmjg }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											使用部门：
										</td>
										<td style="text-align: center;">
											${map.syks }
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											使用参数：
										</td>
										<td style="text-align: center;">
											${map.syfw }
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											使用状态：
										</td>
										<td style="text-align: center;">
											<c:choose>
		                                  		<c:when test="${map.syzt  =='0'}"><span class="label label-success label-mini">在用</span></c:when>
		                                  		<c:when test="${map.syzt  =='1'}"><span class="label label-danger label-mini">报废</span></c:when>
		                                  		<c:when test="${map.syzt  =='2'}"><span class="label label-danger label-mini">检定</span></c:when>
		                                  		<c:when test="${map.syzt  =='3'}"><span class="label label-danger label-mini">维修</span></c:when>
		                                  		<c:when test="${map.syzt  =='4'}"><span class="label label-danger label-mini">停用</span></c:when>
                                  			</c:choose>
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											使用期限：
										</td>
										<td style="text-align: center;">
											${map.syqx }
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											上次检定日期：
										</td>
										<td style="text-align: center;">${map.scjdrq }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											下次检定日期：
										</td>
										<td style="text-align: center;">${map.xcjdrq }</td>
									</tr>
									
								</tbody>
							</table>
						</div>
					</div>
		</form>
		</div>
		<div class="maxtop btns" id="control_panel" >
<%-- 			<div class="WJButton wj_color" id="next_button" style="" onclick="btnOK_onclick(myForm,${oid });">提 交</div> --%>
			<div class="red fL" id="err_msg"></div>
			<div class="wjprogress" id="progress_bar" style="display: none;">
				<span>20%</span>
				<div class="bar">
					<div class="barbox"></div>
				</div>
			</div>
		</div>
		<div class="maxtop btns title" id="loader_div" 
			style="display: none; text-align: center;">
			<img src="<%=path%>/resources/skin/loader.gif" alt=""> <br>
					<div id="loader_text">正在保存...</div>
		</div>
		<div class="conthank" id="survey_end" style="display: none;" >
			<p id="seq_content"
				style="text-align: center; color: #999; margin-bottom: 60px; margin-top: -60px;">&nbsp;</p>
			<p id="end_desc"></p>
			<div class="show_results" id="show_results">

				<!-- Baidu Button BEGIN -->

			</div>
		</div>
		<div class="Error_message" id="error_msg_box" style="display: none;">
			<span class="error_text"></span>
			<div href="javascript:;" class="WJButton wj_color"
				style="display: none;" id="reupload_answer">&nbsp;&nbsp;重新提交&nbsp;&nbsp;</div>
			<a href=""
				class="WJButton wj_color" style="display: none;" id="fankui">&nbsp;&nbsp;马上联系我们&nbsp;&nbsp;</a>
		</div>
	</div>
	<!--wjContent end-->
	<style type="text/css">
.ma_auto {
	width: none;
}

.instructions div {
	float: none;
}

.wjtext {
	text-align: center;
}

.wjtext a {
	display: inline;
}
</style>

	<script type="text/javascript"
		src="<%=path%>/resources/js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript">
		
	</script>
	<!--加载提示-->
	<link type="text/css" rel="stylesheet"
		href="<%=path%>/resources/skin/load.css">
		<script type="text/javascript" src="<%=path%>/resources/skin/load.js"></script>
</body>
</html>
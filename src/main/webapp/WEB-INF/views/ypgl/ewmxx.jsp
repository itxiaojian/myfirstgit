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
<meta name="viewport"content="width=device-width,user-scalable=no, initial-scale=1"></meta>
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Cache-Control" content="no-store">
<meta http-equiv="Expires" content="0">
<title>样品信息</title>



<link href="<%=path%>/resources/skin/base.css" rel="stylesheet"></link>
<link href="<%=path%>/resources/skin/wjend.css" rel="stylesheet"></link>
<link href="<%=path%>/resources/skin/darkblue.css" rel="stylesheet"></link>
<link href="<%=path%>/resources/skin/hcheckbox.css" rel="stylesheet"></link>

<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/wbm/bootstrap-custom1.min.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/wbm/jquery-ui-custom.min.css">
<%-- 	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/wbm/core.css"> --%>
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/wbm/home.css">

<%-- <link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/wbm/activity.css"> --%>
			
<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.qrcode.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/wbm/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery-ui-1.8.22.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/wbm/filter.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/wbm/global.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script type="text/javascript">

	function ypxxYjiao() {                  //移交
		var id = $("#id").val(); 
		var ypbh = $("#ypbh").val();
		var djlx = $("#djlx").val();
		location.href="<%=path%>/ypgl/YYpYj/ypxxYjiaoView?id="+id+"&ypbh="+ypbh+"&djlx="+djlx;
	}
</script>
</head>
<body>
	<p style="display: none;" class="hei_cq" _hei="1323" id="body"></p>

	<div class="wjContent clear" id="survey_page"
		style="width: 85%;">
		<div class="content" id="begin_content">


			<div class="wjtitle mtop project_title">
				<h1>${map.ypmc }</h1>
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
							<input type="hidden" class="hidden" id="id" name="id" value="${map.id }" />
							<input type="hidden" class="hidden" id="ypbh" name="ypbh" value="${map.ypbh }" />
							<input type="hidden" class="hidden" id="djlx" name="djlx" value="${map.djlx }" />
							<table style="width: 100%;">
								<tbody>
									<tr>
										<td style="text-align: center;">检验科室：</td>
										<td style="text-align: center;">
											${map.jyks }
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">业务科室：</td>
										<td style="text-align: center;">
											${map.ywks }
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">字号：</td>
										<td style="text-align: center;">
											${map.zh }
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">登记类型：</td>
										<td style="text-align: center;">
											<c:choose>
												<c:when test="${map.djlx == 0 }">
													一般样品登记
												</c:when>
												<c:when test="${map.djlx == 1 }">
													工程样品登记
												</c:when>
												<c:when test="${map.djlx == 2 }">
													食药样品登记
												</c:when>
												<c:when test="${map.djlx == 3 }">
													抽样登记
												</c:when>
											    <c:otherwise>
											    	${map.djlx }
											    </c:otherwise>
											</c:choose>
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">样品名称：</td>
										<td style="text-align: center;">
											${map.ypmc }
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">样品编号：</td>
										<td style="text-align: center;">
											${map.ypbh }
										</td> 
									</tr>
									<tr>
										<td style="text-align: center;">样品数量：</td>
										<td style="text-align: center;">
											${map.ypsl }
										</td> 
									</tr>
									<tr>
										<td style="text-align: center;">商标：</td>
										<td style="text-align: center;">
											${map.sb }
										</td> 
									</tr>
									<tr>
										<td style="text-align: center;">检验状态：</td>
										<td style="text-align: center;">
											<c:choose>
		                                  		<c:when test="${map.ypjyzt  =='0'}"><span class="label label-success label-mini">待检</span></c:when>
		                                  		<c:when test="${map.ypjyzt  =='1'}"><span class="label label-danger label-mini">待编制</span></c:when>
		                                  		<c:when test="${map.ypjyzt  =='0'}"><span class="label label-success label-mini">已编制</span></c:when>
		                                  		<c:when test="${map.ypjyzt  =='1'}"><span class="label label-danger label-mini">已审核</span></c:when>
		                                  		<c:when test="${map.ypjyzt  =='0'}"><span class="label label-success label-mini">已批准</span></c:when>
		                                  		<c:when test="${map.ypjyzt  =='1'}"><span class="label label-danger label-mini">已接收</span></c:when>
		                                  		<c:when test="${map.ypjyzt  =='0'}"><span class="label label-success label-mini">结束</span></c:when>
		                                  		<c:when test="${map.ypjyzt  =='0'}"><span class="label label-success label-mini">已解锁</span></c:when>
                                  			</c:choose>
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">检验类型：</td>
										<td style="text-align: center;">
											${map.jylx }
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											来样方式：
										</td>
										<td style="text-align: center;">
											<c:choose>
		                                  		<c:when test="${map.lyfs  =='0'}"><span class="label label-success label-mini">直送</span></c:when>
		                                  		<c:when test="${map.lyfs  =='1'}"><span class="label label-danger label-mini">快递</span></c:when>
                                  			</c:choose>
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											所在城市：
										</td>
										<td style="text-align: center;">${map.szcs }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											规格型号：
										</td>
										<td style="text-align: center;">
											${map.ggxh }
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											生产日期\批次：
										</td>
										<td style="text-align: center;">
											${map.scrqpc }
										</td>
									</tr>
									
									<tr>
										<td style="text-align: center;">
											样品等级\类型：
										</td>
										<td style="text-align: center;">${map.ypdj }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											样品状态：
										</td>
										<td style="text-align: center;">${map.ypzt }</td>
									</tr>
									<%-- <tr>
										<td style="text-align: center;">
											抽样地点：
										</td>
										<td style="text-align: center;">
											${map.cydd }
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											抽样日期：
										</td>
										<td style="text-align: center;">
											${map.cyrq }
										</td>
									</tr> --%>
									<tr>
										<td style="text-align: center;">
											委托单位：
										</td>
										<td style="text-align: center;">
											${map.wtdw }
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											受检单位：
										</td>
										<td style="text-align: center;">${map.sjdw }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											联系人：
										</td>
										<td style="text-align: center;">${map.lxr }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											电话：
										</td>
										<td style="text-align: center;">${map.dh }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											邮编：
										</td>
										<td style="text-align: center;">${map.yb }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											生产单位：
										</td>
										<td style="text-align: center;">${map.scdw }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											检验项目：
										</td>
										<td style="text-align: center;">${map.jyxm }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											检验依据：
										</td>
										<td style="text-align: center;">${map.jyyj }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											检验费用：
										</td>
										<td style="text-align: center;">${map.jyfy }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											检验费用待定：
										</td>
										<td style="text-align: center;">
											<c:choose>
		                                  		<c:when test="${map.jyfydd  =='0'}"><span class="label label-success label-mini">待定</span></c:when>
		                                  		<c:when test="${map.jyfydd  =='1'}"><span class="label label-danger label-mini">不待定</span></c:when>
                                  			</c:choose>
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											验后需退库：
										</td>
										<td style="text-align: center;">
											<c:choose>
		                                  		<c:when test="${map.yhxtk  =='0'}"><span class="label label-success label-mini">退</span></c:when>
		                                  		<c:when test="${map.yhxtk  =='1'}"><span class="label label-danger label-mini">不退</span></c:when>
                                  			</c:choose>
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											检验合同号：
										</td>
										<td style="text-align: center;">${map.jyhth }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											检查封样人员：
										</td>
										<td style="text-align: center;">${map.jcfyry }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											报告发送方式：
										</td>
										<td style="text-align: center;">
											<c:choose>
		                                  		<c:when test="${map.bgfsfs  =='0'}"><span class="label label-success label-mini">邮寄</span></c:when>
		                                  		<c:when test="${map.bgfsfs  =='1'}"><span class="label label-danger label-mini">自取（本院）</span></c:when>
                                  				<c:when test="${map.bgfsfs  =='1'}"><span class="label label-danger label-mini">自取（中心）</span></c:when>
                                  			</c:choose>
										</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											完成期限：
										</td>
										<td style="text-align: center;">${map.wcqx }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											附件：
										</td>
										<td style="text-align: center;">${map.fj }</td>
									</tr>
									<tr>
										<td style="text-align: center;">
											备注：
										</td>
										<td style="text-align: center;">${map.bz }</td>
									</tr>
								</tbody>
							</table>
							<div id="footer" align="center" style="margin-top: 5%;height: 66px;">
								<button type="button" class="btn btn-success" style="padding-left: 0px; left: 0px;margin-left: 35%; height: 33px; width: 93px;" 
								onclick="ypxxYjiao();">移交</button>
								<!-- <button type="button" class="btn btn-success" onclick="window.close();">关闭</button> -->
							</div>
						</div>
						</form>
					</div>
					
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/tld/fn.tld" %>
<%
	String path = request.getContextPath();
%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="no-cache" http-equiv="Pragma" />
<meta content="no-cache" http-equiv="Cache-Control" />
<meta content="0" http-equiv="Expires" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="utf-8" />

<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/css/icons.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/css/index.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/css/icons.css" />

<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet"
	type="text/css" id="theme" themeColor="lightBlue" />
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet"
	type="text/css" />
<%-- <link href="<%=path%>/resources/css/khCss.css" rel="stylesheet" --%>
<!-- 	type="text/css" /> -->
	
<style type="text/css">
table.gridtable {
	border-collapse: collapse;
	border: 0;
	width: 100%;
	margin-left: 15px;
	line-height:20px;
}
table.gridtable td {
	border: solid #000 1px;
	width: 10%
}
</style>
<!--居中显示end-->
</head>
<body style="background-color: #ffffff;">
	<div align="center;" style="height: 980px;">
		<h1 align="right" style="font-size: 15px;line-height:10px;">CX4.4.1-01</h1>
		<h1 align="center" style="font-size: 20px;line-height:10px;">国家排灌及节水设备产品质量监督检验中心</h1>
		<h1 align="center" style="font-size: 20px;line-height:10px;">国&nbsp;家&nbsp;建筑&nbsp;节能&nbsp;产品&nbsp;质量&nbsp;监督&nbsp;检验&nbsp;中&nbsp;心</h1>
		<h1 align="center" style="font-size: 20px;line-height:10px;">安&nbsp;徽&nbsp;省&nbsp;产品&nbsp;质量&nbsp;监督&nbsp;检验&nbsp;研&nbsp;究&nbsp;院</h1>
		<h1 align="center" style="font-size: 20px;line-height:10px;">委&nbsp;托&nbsp;检&nbsp;验&nbsp;协&nbsp;议&nbsp;书</h1>
		<label style="font-size: 15px;float: right;line-height:10px;">（${fn:substring(ypxx.ypbh, 0, 4)  }）皖检&nbsp;&nbsp;${zh }&nbsp;&nbsp;字第（${fn:substring(ypxx.ypbh, fn:length(ypxx.ypbh)-5,fn:length(ypxx.ypbh))  }）号</label><br/>
		<form action="" id="Form" method="post">
			<table width="100%" class="gridtable">
				<tr>
					<td width="24" rowspan="16" style="text-align: center;width: 5%;">客<br/>
						&nbsp;<br/>
						户<br/>
						&nbsp;<br/>
						填<br/>
						&nbsp;<br/>
						写</td>
					<td width="100" rowspan="2" style="width: 10%;">样品名称</td>
					<td width="200" rowspan="2" style="width: 31%;">
						<c:choose>
	        				<c:when test="${ypxx.ypmc == '' || ypxx.ypmc == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.ypmc }
					        </c:otherwise>
						</c:choose>
					</td>
					<td width="80" colspan="2" rowspan="2" style="width: 8%;">
							型号规<br />格等级
						</td>
					<td width="120" colspan="4" rowspan="2" style="width: 33%;">
						<c:choose>
	        				<c:when test="${ypxx.ggxh == '' || ypxx.ggxh == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.ggxh }
					        </c:otherwise>
						</c:choose>
					</td>
					<td width="57" colspan="1" style="width: 4%;">数量</td>
					<td width="129" colspan="4" style="width: 10%;">
						<c:choose>
							<c:when test="${fn:length(ypxx.ypsl)!=0&&fn:length(ypxx.ypsl)<=10 }">
								${ypxx.ypsl }
							</c:when>
							<c:when test="${fn:length(ypxx.ypsl)==0 }">
								/ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</c:when>
							<c:otherwise>
								${ypxx.ypsl }
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td width="57" colspan="1" style="width: 4%;">商标</td>
					<td width="129" colspan="4" style="width: 10%;">
						<c:choose>
							<c:when test="${fn:length(ypxx.sb)!=0&&fn:length(ypxx.sb)<=10 }">
								${ypxx.sb }
							</c:when>
							<c:when test="${fn:length(ypxx.sb)==0 }">
								/ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</c:when>
							<c:otherwise>
								${ypxx.sb }
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td width="100" style="width: 10%;">生产日期<br />或批号</td>
					<td width="240" colspan="2" style="width: 31%;">
						<c:choose>
	        				<c:when test="${ypxx.scrqpc == '' || ypxx.scrqpc == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.scrqpc }
					        </c:otherwise>
						</c:choose>
					</td>
					<td width="60" style="width: 8%;">联系人</td>
					<td width="103" colspan="2" style="width: 10%;">
						<c:choose>
	        				<c:when test="${ypxx.lxr == '' || ypxx.lxr == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.lxr }
					        </c:otherwise>
						</c:choose>
					</td>
					<td width="48" colspan="1" style="width: 8%;">电话</td>
					<td width="155" colspan="6">
						<c:choose>
	        				<c:when test="${ypxx.dh == '' || ypxx.dh == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.dh }
					        </c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td width="100" rowspan="3" style="width: 10%;">样品生产厂</td>
					<td width="240" colspan="2" rowspan="3" style="width: 31%;">
						<c:choose>
	        				<c:when test="${ypxx.scdw == '' || ypxx.scdw == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.scdw }
					        </c:otherwise>
						</c:choose>
					</td>
					<td width="60" rowspan="2" style="width: 8%;">委托单<br />位地址</td>
					<td width="306" colspan="9" rowspan="2">
						<c:choose>
	        				<c:when test="${ypxx.wtdwdz == '' || ypxx.wtdwdz == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.wtdwdz }
					        </c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
				</tr>
				
				<tr>
					<td width="60" rowspan="2" style="width: 8%;">经济类型</td>
					<td width="80" colspan="1" rowspan="2"></td>
					<td width="60" colspan="1" rowspan="2" style="width: 8%;">规模/人数</td>
					<td width="70" colspan="1" rowspan="2">&nbsp;</td>
					<td rowspan="2" style="width: 4%;">产值</td>
					<td colspan="5" rowspan="2" style="border-top-width: 0;">&nbsp;</td>
				</tr>
				<tr>
					<td width="100" rowspan="3" style="width: 10%;">委托单位<br />（客户）</td>
					<td width="240" colspan="2" rowspan="3" style="width: 31%;">
						<c:choose>
	        				<c:when test="${ypxx.wtdw == '' || ypxx.wtdw == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.wtdw }
					        </c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr style="height: 40px;">
					<td width="60" rowspan="2" style="width: 8%;">受检单位</td>
					<td width="306" colspan="2" rowspan="2">
						<c:choose>
	        				<c:when test="${ypxx.sjdw == '' || ypxx.sjdw == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.sjdw }
					        </c:otherwise>
						</c:choose>
					</td>
					<td width="60" rowspan="2" style="width: 8%;">身份证明</td>
					<td width="306" colspan="6" rowspan="2">&nbsp;</td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td width="727" colspan="13" rowspan="3" valign="top"><span align="left">检验依据及项目：</span>
						<c:choose>
							<c:when test="${ypxx.jyxm == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jyxm }
							</c:otherwise>
						</c:choose>
						<c:choose>
	        				<c:when test="${ypxx.jyyj == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jyyj }
							</c:otherwise>
<%-- 							<c:otherwise> --%>
<%-- 								<c:forEach var="data" items="${jyxm }" varStatus="status"> --%>
<%-- 									<span style="float:left;margin-left: 10px;">${data.xmmc }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --%>
<%-- 								</c:forEach> --%>
<%-- 					        </c:otherwise> --%>
						</c:choose>
					</td>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
					<td width="727" colspan="13"><span align="left">检验要求：</span></td>
				</tr>
				<tr>
					<td width="100" style="width: 10%;">样品处理<br />意见</td>
					<td width="614" colspan="12">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>
							<div style="width: 8px;height: 8px;border:1px solid #000;margin-top: 7px;display: inline;">&nbsp;&nbsp;&nbsp;</div>&nbsp;&nbsp;&nbsp;&nbsp;异议期满后取回
						</span>&nbsp;&nbsp;&nbsp;&nbsp;
						<span><div style="width: 8px;height: 8px;border:1px solid #000;margin-top: 7px;display: inline;">&nbsp;&nbsp;&nbsp;</div>&nbsp;&nbsp;&nbsp;&nbsp;委托质检院（中心）自行处理</span>&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td width="100" style="width: 10%;">取报告方式</td>
					<td width="614" colspan="12">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>
							<div style="width: 8px;height: 8px;border:1px solid #000;margin-top: 7px;display: inline;">&nbsp;&nbsp;&nbsp;</div>&nbsp;&nbsp;&nbsp;&nbsp;自取
						</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span><div style="width: 8px;height: 8px;border:1px solid #000;margin-top: 7px;display: inline;">&nbsp;&nbsp;&nbsp;</div>&nbsp;&nbsp;&nbsp;&nbsp;邮寄</span>&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td width="727" colspan="13">
						<span align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.我方保证对所提供的一切资料，实物的真实性负责，并提供必要合作。</span><br />
						<span align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.我方认可质检院报告系针对送检样品所作出的。</span><br /> 
						<span align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.本次委托检验费为双方协议商定，由我方支付。</span><br />
						<span style="float: right;">委托人签名：                                年    月    日</span>
					</td>
				</tr>
				<tr>
					<td width="24" rowspan="4" style="text-align: center;width: 5%;">
						质<br/>
						检<br/>
						院<br/>
						︵<br/>
						中<br/>
						心<br/>
						︶<br/>
						填<br/>
						写
					</td>
					<td width="100" style="width: 10%;">样品特性<br />和状态</td>
					<td width="614" colspan="12" style="border-top-width: 0;">
						<c:choose>
	        				<c:when test="${ypxx.ypzt == '' || ypxx.ypzt == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.ypzt }
					        </c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td width="100" style="width: 10%;">检测费</td>
					<td width="338" colspan="3">
						<c:choose>
	        				<c:when test="${ypxx.jyfy == '' || ypxx.jyfy == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jyfy }
					        </c:otherwise>
						</c:choose>
					</td>
					<td width="200" colspan="2">商定完成时间</td>
					<td colspan="6">
						<c:choose>
	        				<c:when test="${ypxx.dyrq == '' || ypxx.dyrq == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.dyrq }
					        </c:otherwise>
						</c:choose>
							&nbsp;-&nbsp;
						<c:choose>
	        				<c:when test="${ypxx.wcqx == '' || ypxx.wcqx == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.wcqx }
					        </c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td width="727" colspan="13">
						<span align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.本院(中心)保证检验的公正性，对检验数据负责，并对委托单位所提供的实物和技术资料保密。</span><br />
						<span align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.对送检样品，超过异议期间的，不予保存。</span><br /> 
						<span align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.异议期限为委托方收到检验报告之次日起十五天。</span><br />
						<div style="position:absolute; width:100%; height: 150px;margin-left: 75%;">
<%-- 						<img src="<%=path%>/resources/images/ywslz.png" alt="" style="width: 150px;height: 150px;"/> --%>
						</div>
						<div style="width:100%;height: 100px; padding-top: 40px;">
						<span align="center">                                                                                                业务受理员签名：</span><br /> 
						<span style="margin-left: 85%;">年    月    日</span><br /> 
						<span align="center">                                                                                                参加评审人员：</span>
						</div>
					</td>
				</tr>
				<tr>
					<td width="727" colspan="13">备注</td>
				</tr>
			</table>
			1、本协议一式三联，第一联交检验部门，第二联交客户取报告凭证，第三联存根<br />
			2、本院业务联系电话:（0551）63356268（研究院）63855622（中心）传真:（0551）63499507（研究院）63852920（中心）地址:（院）合肥市包河工业区延安路13号，（中心）合肥市经济技术开发区天都路33号。<br />
			3、报告查询方式:请登陆我院网站Http://www.ahzjy.org.cn（页面右下角）进行查询。<br />
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta content="no-cache" http-equiv="Pragma" />
	<meta content="no-cache" http-equiv="Cache-Control" />
	<meta content="0" http-equiv="Expires" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta charset="utf-8" />
    
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/icons.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/index.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/icons.css" />
	
	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
	<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="lightBlue"/>
	<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/resources/css/khCss.css" rel="stylesheet" type="text/css"/>
	
<title>安徽省产品质量监督检验研究院业务流转单</title>
</head>
<body style="background-color:#ffffff;">
<div align="center;" style="height: 940px;">
	<h1 align="right" style="font-size: 17px;">CX4.4.1-02</h1>
	<c:if test="${zhfl=='0' || zhfl=='4' }">
		<h1 align="center" style="font-size: 25px;">安徽省产品质量监督检验研究院业务流转单</h1>
	</c:if>
	<c:if test="${zhfl=='6'}">
		<h1 align="center" style="font-size: 25px;">安徽省产品质量监督检验研究院</h1>
		<h1 align="center" style="font-size: 25px;">安防工程业务流转单</h1>
	</c:if>
	<c:if test="${zhfl=='2' || zhfl=='5' }">
		<h1 align="center" style="font-size: 25px;">国家建筑节能产品质量监督检验中心业务流转单</h1>
	</c:if>
	<c:if test="${zhfl=='1' }">
		<h1 align="center" style="font-size: 25px;">国家排灌及节水设备质量监督检验中心业务流转单</h1>
	</c:if>
	<c:if test="${zhfl=='3' }">
		<h1 align="center" style="font-size: 25px;">国家公共安全产品质量监督检验中心</h1>
	</c:if>
	<form action="" id="Form" method="post">
	<c:choose>
	        <c:when test="${ypxx.zh == 'XI' }">
				<table align="center">
					<tr style="height: 40px;">
						<td>承检科室</td>
						<td colspan="2" align="left" style="text-align: left;">
						<c:choose>
	        				<c:when test="${ypxx.jyks == '' || ypxx.jyks == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jyks }
					        </c:otherwise>
						</c:choose>
						</td>
						<td>报告编号</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.bgbh == '' || ypxx.bgbh == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.bgbh }
					        </c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr style="height: 60px;">
						<td>工程名称</td>
						<td colspan="2" align="left" style="text-align: left;width: 18%;">
							<c:choose>
	        				<c:when test="${ypxx.gcmc == '' || ypxx.gcmc == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.gcmc }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>工程地址</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.gcdz == '' || ypxx.gcdz == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.gcdz }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr style="height: 40px;">
						<td>委托单位</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.wtdw == '' || ypxx.wtdw == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.wtdw }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>委托单位地址</td>
						<td colspan="2" align="left" style="text-align: left;">
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
			        <tr style="height: 40px;">
						<td>建设单位</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.jsdw == '' || ypxx.jsdw == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jsdw }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>施工单位</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.sgdw == '' || ypxx.sgdw == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.sgdw }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr style="height: 40px;">
						<td>受检单位</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.sjdw == '' || ypxx.sjdw == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.sjdw }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>受检单位地址</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.sjdwdz == '' || ypxx.sjdwdz == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.sjdwdz }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr style="height: 40px;">
						<td>联系人</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.lxr == '' || ypxx.lxr == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.lxr }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>联系电话</td>
						<td colspan="2" align="left" style="text-align: left;">
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
			        <tr style="height: 40px;">
						<td>检验性质</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.jylx == '' || ypxx.jylx == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jylx }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>检验项目</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.jyxm == '' || ypxx.jyxm == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jyxm }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr style="height: 40px;">
						<td>协议起始日期</td>
						<td colspan="2" align="left" style="text-align: left;"></td>
						<td>检验日期</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.dyrq == '' || ypxx.dyrq == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.dyrq }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr style="height: 40px;">
						<td>受理人</td>
						<td align="left">
							<c:choose>
	        				<c:when test="${ypxx.djry == '' || ypxx.djry == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.djry }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>检测费</td>
						<td align="left">
							<c:choose>
	        				<c:when test="${ypxx.jyfy == '' || ypxx.jyfy == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jyfy }
					        </c:otherwise>
							</c:choose>
						</td>
			            <td>报告完成期限</td>
						<td align="left">
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
			        <tr style="height: 40px;">
						<td>流转单打印</td>
						<td colspan="2" align="left"></td>
						<td>校对</td>
						<td colspan="2" align="left"></td>
			        </tr>
			        <tr>
						<td>检验依据及项目</td>
						<td colspan="5" height="60px" align="left" style="text-align: left;">
<%-- 							<span style="float:left;margin-left: 10px;">${ypxx.jyxm }</span><br /> --%>
							<span style="float:left;margin-left: 10px;">${ypxx.jyyj }</span>
						</td>
			        </tr>
			        <tr>
						<td>使用认可标志确认</td>
						<td colspan="5" height="50px" align="center">
							<c:forEach var="tb" items="${rztb }" varStatus="status">
								<div style="float: left;margin-left: 3px;" align="center">
									<div style="width: 8px;height: 8px;border:1px solid #000;margin-top: 7px;"></div>
									<span style="margin-left: 5px;">${tb.rzmc }</span>&nbsp;&nbsp;&nbsp;
								</div>
							</c:forEach>
						</td>
			        </tr>
			        <tr>
						<td>检验结论</td>
						<td colspan="5" height="60px" align="left"></td>
			        </tr>
			        <tr>
						<td>备注</td>
						<td colspan="5" height="60px" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.bz == '' || ypxx.bz == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.bz }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr>
						<td valign="top" colspan="2" style="border-right: #f6f6f6 0px solid;"> 
							<p style="text-align: left;">	
							批准：
							</p>
			                <p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日
			                </p>
						</td>
						<td valign="top" colspan="2" style="border-left: #f6f6f6 0px solid;border-right: #f6f6f6 0px solid;"><p style="text-align: left;">审核：</p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</p></td>
						<td valign="top" colspan="2" style="border-left: #f6f6f6 0px solid;"><p style="text-align: left;">主检：</p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</p></td>
			        </tr>
				</table>
			</c:when>
			<c:when test="${ypxx.zh == 'JG' || ypxx.zh == 'JJG' }">
				<table align="center">
					<tr>
						<td>承检科室</td>
						<td colspan="2" align="left">
							<c:choose>
	        				<c:when test="${ypxx.jyks == '' || ypxx.jyks == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jyks }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>报告编号</td>
						<td colspan="2" align="left">
							<c:choose>
	        				<c:when test="${ypxx.bgbh == '' || ypxx.bgbh == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.bgbh }
					        </c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr style="height: 60px;">
						<td>产品名称</td>
						<td colspan="2" align="left" style="text-align: left;width: 18%;">
							<c:choose>
	        				<c:when test="${ypxx.ypmc == '' || ypxx.ypmc == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.ypmc }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>型号规格</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.ggxh == '' || ypxx.ggxh == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.ggxh }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
					<tr>
						<td>样品等级</td>
						<td align="left">
							<c:choose>
	        				<c:when test="${ypxx.ypdj == '' || ypxx.ypdj == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.ypdj }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>商标</td>
						<td align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.sb == '' || ypxx.sb == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.sb }
					        </c:otherwise>
							</c:choose>
						</td>
			            <td>生产日期或批号</td>
						<td align="left">
							<c:choose>
	        				<c:when test="${ypxx.scrqpc == '' || ypxx.scrqpc == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.scrqpc }
					        </c:otherwise>
							</c:choose>
						</td>
					</tr>
			        <tr>
						<td>样品数量</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.ypsl == '' || ypxx.ypsl == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.ypsl }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>样品特性和状态</td>
						<td colspan="2" align="left" style="text-align: left;">
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
						<td></td>
						<td colspan="5" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.gcmc == '' || ypxx.gcmc == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.gcmc }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr style="height: 60px;">
						<td>施工单位</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.sgdw == '' || ypxx.sgdw == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.sgdw }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>生产单位</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.scdw == '' || ypxx.scdw == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.scdw }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr style="height: 60px;">
						<td>委托单位</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.wtdw == '' || ypxx.wtdw == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.wtdw }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>委托单位地址</td>
						<td colspan="2" align="left" style="text-align: left;">
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
			        <tr style="height: 60px;">
						<td>监理单位</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.jldw == '' || ypxx.jldw == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jldw }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>监理人</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.jlr == '' || ypxx.jlr == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jlr }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr>
						<td>见证单位</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.jzdw == '' || ypxx.jzdw == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jzdw }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>见证人</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.jzr == '' || ypxx.jzr == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jzr }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr>
						<td>联系人</td>
						<td colspan="2" align="left">
							<c:choose>
	        				<c:when test="${ypxx.lxr == '' || ypxx.lxr == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.lxr }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>电话</td>
						<td colspan="2" align="left">
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
						<td>检验日期</td>
						<td colspan="2" align="left"></td>
						<td>到样日期</td>
						<td colspan="2" align="left">
							<c:choose>
	        				<c:when test="${ypxx.dyrq == '' || ypxx.dyrq == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.dyrq }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr>
						<td>受理人</td>
						<td align="left">
							<c:choose>
	        				<c:when test="${ypxx.djry == '' || ypxx.djry == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.djry }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>检测费</td>
						<td align="left">
							<c:choose>
	        				<c:when test="${ypxx.jyfy == '' || ypxx.jyfy == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jyfy }
					        </c:otherwise>
							</c:choose>
						</td>
			            <td>报告完成期限</td>
						<td align="left">
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
						<td>流转单打印</td>
						<td colspan="2" align="left"></td>
						<td>校对</td>
						<td colspan="2" align="left"></td>
			        </tr>
			        <tr>
						<td>样品库接收人</td>
						<td align="left"></td>
						<td>领样人</td>
						<td align="left"></td>
			            <td>退样人</td>
						<td align="left"></td>
					</tr>
			        <tr>
						<td>检验依据及项目</td>
						<td colspan="5" height="60px" align="left" style="text-align: left;">
<%-- 							<span style="float:left;margin-left: 10px;">${ypxx.jyxm }</span><br /> --%>
							<span style="float:left;margin-left: 10px;">${ypxx.jyyj }</span>
						</td>
			        </tr>
			        <tr>
						<td>使用认可标志确认</td>
						<td colspan="5" height="50px" align="center">
							<c:forEach var="tb" items="${rztb }" varStatus="status">
								<div style="float: left;margin-left: 3px;" align="center">
									<div style="width: 8px;height: 8px;border:1px solid #000;margin-top: 7px;"></div>
									<span style="margin-left: 5px;">${tb.rzmc }</span>&nbsp;&nbsp;&nbsp;
								</div>
							</c:forEach>
						</td>
			        </tr>
			        <tr>
						<td>检验结论</td>
						<td colspan="5" height="60px" align="left"></td>
			        </tr>
			        <tr>
						<td>备注</td>
						<td colspan="5" height="60px" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.bz == '' || ypxx.bz == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.bz }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr>
						<td valign="top" colspan="2" style="border-right: #f6f6f6 0px solid;"> 
							<p style="text-align: left;">	
							批准：
							</p>
			                <p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日
			                </p>
						</td>
						<td valign="top" colspan="2" style="border-left: #f6f6f6 0px solid;border-right: #f6f6f6 0px solid;"><p style="text-align: left;">审核：</p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</p></td>
						<td valign="top" colspan="2" style="border-left: #f6f6f6 0px solid;"><p style="text-align: left;">主检：</p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</p></td>
			        </tr>
				</table>
			</c:when>
			<c:otherwise>
				<table align="center">
					<tr>
						<td>承检科室</td>
						<td colspan="2" align="left">
							<c:choose>
	        				<c:when test="${ypxx.jyks == '' || ypxx.jyks == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jyks }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>报告编号</td>
						<td colspan="2" align="left">
							<c:choose>
	        				<c:when test="${ypxx.bgbh == '' || ypxx.bgbh == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.bgbh }
					        </c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr style="height: 60px;">
						<td>产品名称</td>
						<td colspan="2" align="left" style="text-align: left;width: 18%;">
							<c:choose>
	        				<c:when test="${ypxx.ypmc == '' || ypxx.ypmc == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.ypmc }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>型号规格</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.ggxh == '' || ypxx.ggxh == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.ggxh }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
					<tr>
						<td>样品等级</td>
						<td align="left">
							<c:choose>
	        				<c:when test="${ypxx.ypdj == '' || ypxx.ypdj == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.ypdj }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>商标</td>
						<td align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.sb == '' || ypxx.sb == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.sb }
					        </c:otherwise>
							</c:choose>
						</td>
			            <td>抽样基数</td>
						<td align="left">
							<c:choose>
	        				<c:when test="${ypxx.cyjs == '' || ypxx.cyjs == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.cyjs }
					        </c:otherwise>
							</c:choose>
						</td>
					</tr>
			        <tr>
						<td>样品数量</td>
						<td colspan="2" align="left">
							<c:choose>
	        				<c:when test="${ypxx.ypsl == '' || ypxx.ypsl == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.ypsl }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>生产日期或批号</td>
						<td colspan="2" align="left">
							<c:choose>
	        				<c:when test="${ypxx.scrqpc == '' || ypxx.scrqpc == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.scrqpc }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr>
						<td>样品特性和状态</td>
						<td colspan="5" align="left">
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
			        <tr style="height: 60px;">
						<td>受检单位</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.sjdw == '' || ypxx.sjdw == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.sjdw }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>抽样单位</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.cydw == '' || ypxx.cydw == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.cydw }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr style="height: 60px;">
						<td>生产单位</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.scdw == '' || ypxx.scdw == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.scdw }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>委托单位</td>
						<td colspan="2" align="left" style="text-align: left;">
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
			        <tr style="height: 60px;">
						<td>抽样地点</td>
						<td colspan="2" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.cydd == '' || ypxx.cydd == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.cydd }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>委托单位地址</td>
						<td colspan="2" align="left" style="text-align: left;">
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
						<td>联系人</td>
						<td colspan="2" align="left">
							<c:choose>
	        				<c:when test="${ypxx.lxr == '' || ypxx.lxr == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.lxr }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>电话</td>
						<td colspan="2" align="left">
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
						<td>抽样日期</td>
						<td colspan="2" align="left">
							<c:choose>
	        				<c:when test="${ypxx.cyrq == '' || ypxx.cyrq == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.cyrq }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>检验性质</td>
						<td colspan="2" align="left">
							<c:choose>
	        				<c:when test="${ypxx.jylx == '' || ypxx.jylx == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jylx }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr>
						<td>检验日期</td>
						<td colspan="2" align="left"></td>
						<td>到样日期</td>
						<td colspan="2" align="left">
							<c:choose>
	        				<c:when test="${ypxx.dyrq == '' || ypxx.dyrq == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.dyrq }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr>
						<td>受理人</td>
						<td align="left">
							<c:choose>
	        				<c:when test="${ypxx.djry == '' || ypxx.djry == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.djry }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>检测费</td>
						<td align="left">
							<c:choose>
	        				<c:when test="${ypxx.jyfy == '' || ypxx.jyfy == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.jyfy }
					        </c:otherwise>
							</c:choose>
						</td>
			            <td>报告完成期限</td>
						<td align="left">
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
						<td>抽样人员</td>
						<td colspan="2" align="left">
							<c:choose>
	        				<c:when test="${ypxx.cyry == '' || ypxx.cyry == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.cyry }
					        </c:otherwise>
							</c:choose>
						</td>
						<td>业务科室</td>
						<td colspan="2" align="left">
							<c:choose>
	        				<c:when test="${ypxx.ywks == '' || ypxx.ywks == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.ywks }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr>
						<td>流转单打印</td>
						<td colspan="2" align="left"></td>
						<td>校对</td>
						<td colspan="2" align="left"></td>
			        </tr>
			        <tr>
						<td>样品库接收人</td>
						<td align="left"></td>
						<td>领样人</td>
						<td align="left"></td>
			            <td>退样人</td>
						<td align="left"></td>
					</tr>
			        <tr>
						<td>检验依据及项目</td>
						<td colspan="5" height="60px" align="left" style="text-align: left;">
<%-- 							<span style="float:left;margin-left: 10px;">${ypxx.jyxm }</span><br /> --%>
							<span style="float:left;margin-left: 10px;">${ypxx.jyyj }</span>
						</td>
			        </tr>
			        <tr>
						<td>使用认可标志确认</td>
						<td colspan="5" height="50px" align="center">
							<c:forEach var="tb" items="${rztb }" varStatus="status">
								<div style="float: left;margin-left: 3px;" align="center">
									<div style="width: 8px;height: 8px;border:1px solid #000;margin-top: 7px;"></div>
									<span style="margin-left: 5px;">${tb.rzmc }</span>&nbsp;&nbsp;&nbsp;
								</div>
							</c:forEach>
						</td>
			        </tr>
			        <tr>
						<td>检验结论</td>
						<td colspan="5" height="60px" align="left"></td>
			        </tr>
			        <tr>
						<td>备注</td>
						<td colspan="5" height="60px" align="left" style="text-align: left;">
							<c:choose>
	        				<c:when test="${ypxx.bz == '' || ypxx.bz == null }">
								/
							</c:when>
							<c:otherwise>
								${ypxx.bz }
					        </c:otherwise>
							</c:choose>
						</td>
			        </tr>
			        <tr>
						<td valign="top" colspan="2" style="border-right: #f6f6f6 0px solid;"> 
							<p style="text-align: left;">	
							批准：
							</p>
			                <p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日
			                </p>
						</td>
						<td valign="top" colspan="2" style="border-left: #f6f6f6 0px solid;border-right: #f6f6f6 0px solid;"><p style="text-align: left;">审核：</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</p></td>
						<td valign="top" colspan="2" style="border-left: #f6f6f6 0px solid;"><p style="text-align: left;">主检：</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</p></td>
			        </tr>
				</table>
			</c:otherwise>
		</c:choose>
	</form>
</div>
<!-- <div style="text-align: center;margin-top: 4%;height: 60px;"> -->
<!-- 	<input type="button"  class="btn btn-primary" onclick=" a()" value="打印"/> -->
<!-- 	<input type="button"  class="btn btn-success" onclick=" b()" value="关闭"/> -->
<!-- </div> -->
</body>
<style type="text/css">
	.hide {
		display: none
	}
	
	.nodata {
		color: red;
		text-align: center
	}
	
	#scrollContent {
		border: 1px solid #ccc
	}
	
	table {
		border-collapse: collapse;
		border: 0;
		width: 89%
	}
	
	td {
		border: solid #000 1px;
		width: 15%;
		text-align: center
	}
	
	tr {
		height: 10px
	}
	
	.inp {
		border-top-width: 0;
		border-right-width: 0;
		border-bottom-width: 1px;
		border-left-width: 0;
		border-top-style: dashed;
		border-right-style: dashed;
		border-bottom-style: dashed;
		border-left-style: dashed;
		border-top-color: #000;
		border-right-color: #000;
		border-bottom-color: #000;
		border-left-color: #000;
		border-color: black;
		width: 50px;
		outline: 0;
		text-align: center
	}
	
	.input_bg1 {
		border: 1px solid #ccc;
		padding: 0 3px;
		width: 700px
	}
	
	.input_bg1:hover {
		background: #fffae6;
		border: 1px solid #ffd553
	}
</style>
</html>

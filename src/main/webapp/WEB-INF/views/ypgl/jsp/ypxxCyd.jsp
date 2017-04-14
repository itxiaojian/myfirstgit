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
	
	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
	<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="lightBlue"/>
	<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/resources/css/ccd.css" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery.jqprint-0.3.js"></script>
<%-- 	<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css" /> --%>
<!--居中显示end-->

<script language="javascript">
	function  a(){
		$("#ddd").jqprint();
	}
</script>
<style type="text/css">
	button, html input[type="button"], input[type="reset"], input[type="submit"] {
    cursor: pointer;
}
.btn-primary {
    background-color: #41cac0;
    border-color: #41cac0;
    color: #fff;
}
.btn {
    -moz-user-select: none;
    background-image: none;
    border: 1px solid transparent;
    border-radius: 4px;
    cursor: pointer;
    display: inline-block;
    font-size: 14px;
    font-weight: normal;
    line-height: 1.42857;
    margin-bottom: 0;
    padding: 6px 12px;
    text-align: center;
    vertical-align: middle;
    white-space: nowrap;
}
</style>
</head>
<body style="background-color:#ffffff;">
<input type="button"  class="btn btn-primary" onclick=" a()" value="打印" style="margin-left:90%;margin-top:1%;"/>
<div  style="height: 860px;text-align:center;" id="ddd" class="aaa">
	<h1 align="center" style="font-size: 22px;font-weight: 900;"><span>安徽省产品质量监督抽查/复查抽样单</span></h1>
	<label style="font-size: 12px;float: right;line-height:10px;">编号：${cydbh }&nbsp;&nbsp;&nbsp;&nbsp;</label>
	<form action="" id="Form" method="post">
<%-- 	<c:choose> --%>
		<table cellspacing="0" cellpadding="0" style="margin-left: 5%;">
  <col width="30" />
  <col width="126" />
  <col width="81" />
  <col width="152" />
  <col width="81" />
  <col width="30" />
  <col width="209" />
<!--   <tr height="18"> -->
<!--     <td colspan="7" rowspan="3" height="54" width="500" style="border-top:0px;border-left:0px;border-right:0px;text-align:center;"> -->
<!--     	<span style="font-size:28px;"></span><br /> -->
<!--     	<span style="float:right;">编号：No.A 1502801</span> -->
<!--     </td> -->
<!--   </tr> -->
  <tr height="18"> </tr>
<!--   <tr height="22"> -->
<!--     <td colspan="7" height="22">编号：No.A 1502801</td> -->
<!--   </tr> -->
  <tr height="26">
    <td colspan="2" height="26" style="border-bottom:0px;"><span style="font-size:10px;">任务来源</span></td>
    <td colspan="2" style="border-bottom:0px;">
    	<c:choose>
			<c:when test="${ypxx.rwly == '' || ypxx.rwly == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.rwly }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2" style="border-bottom:0px;"><span style="font-size:10px;">任务类型</span></td>
    <td style="border-bottom:0px;">
    	<c:choose>
			<c:when test="${ypxx.jylx == '' || ypxx.jylx == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.jylx }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:32px;">
    <td rowspan="3" height="78" style="width:4%;"><span style="font-size:10px;">受<br />检<br />单<br />位</span></td>
    <td><span style="font-size:10px;">名       称</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.sjdw == '' || ypxx.sjdw == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.sjdw }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">法人代表</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.sjdwfrdb == '' || ypxx.sjdwfrdb == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.sjdwfrdb }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:32px;">
    <td style="width: 17%;"><span style="font-size:10px;">通讯地址</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.sjdwdz == '' || ypxx.sjdwdz == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    <span style="font-size:10px;">${ypxx.sjdwdz }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">联 系 人</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.lxr == '' || ypxx.lxr == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.lxr }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:31px;">
    <td><span style="font-size:10px;">固定电话</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.sjdwgddh == '' || ypxx.sjdwgddh == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.sjdwgddh }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">手机号码</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.dh == '' || ypxx.dh == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.dh }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:26px;">
    <td rowspan="6" height="156" width="30"><span style="font-size:10px;">生<br />产<br />单<br />位</span></td>
    <td><span style="font-size:10px;">单位名称</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.scdw == '' || ypxx.scdw == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.scdw }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">单位地址</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.scdwdz == '' || ypxx.scdwdz == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.scdwdz }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:26px;">
    <td><span style="font-size:10px;">邮政编码</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.scdwyb == '' || ypxx.scdwyb == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.scdwyb }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">法人代表</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.scdwfrdb == '' || ypxx.scdwfrdb == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.scdwfrdb }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:26px;">
    <td><span style="font-size:10px;">联 系 人</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.scdwlxr == '' || ypxx.scdwlxr == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.scdwlxr }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">联系电话</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.scdwdh == '' || ypxx.scdwdh == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.scdwdh }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:26px;">
    <td><span style="font-size:10px;">营业执照</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.yyzz == '' || ypxx.yyzz == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.yyzz }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">机构代码</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.jgdm == '' || ypxx.jgdm == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.jgdm }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:26px;">
    <td><span style="font-size:10px;">人    数</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.rs == '' || ypxx.rs == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.rs }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">产    值</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.cz == '' || ypxx.cz == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.cz }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:25px;">
    <td><span style="font-size:10px;">产    量</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.cl == '' || ypxx.cl == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.cl }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">经济类型</span></td>
    <td>
    	<c:forEach items="${jjlx}" var="jjlx">
	        <c:choose>
	        <c:when test="${jjlx.zdz == ypxx.jjlx}">
	    		<span style="font-size:10px;">${jjlx.zdmc}</span>
		    </c:when>
			</c:choose>
		</c:forEach>                          				 
    </td>
  </tr>
  <tr style="height:26px;">
    <td rowspan="8" height="225" width="30"><span style="font-size:10px;">受<br />检<br />产<br />品<br />信<br />息</span></td>
    <td colspan="3">
    	<c:forEach items="${zslx}" var="zslx">
	        <c:choose>
	        <c:when test="${zslx.zdz == ypxx.zslx}">
	    		<span style="font-size:10px;">${zslx.zdmc}</span>
		    </c:when>
			</c:choose>
		</c:forEach>     
    </td>
    <td colspan="2"><span style="font-size:10px;">证书编号</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.zsbh == '' || ypxx.zsbh == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.zsbh }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:26px;">
    <td><span style="font-size:10px;">产品名称</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.ypmc == '' || ypxx.ypmc == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.ypmc }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">规格型号</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.ggxh == '' || ypxx.ggxh == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.ggxh }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:26px;">
    <td><span style="font-size:10px;">生产日期/批号</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.scrqpc == '' || ypxx.scrqpc == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.scrqpc }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">商    标</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.sb == '' || ypxx.sb == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.sb }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:26px;">
    <td><span style="font-size:10px;">抽样数量</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.cysl == '' || ypxx.cysl == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.cysl }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">产品等级</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.ypdj == '' || ypxx.ypdj == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.ypdj }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr height="43">
    <td><span style="font-size:10px;">抽样基数/批量</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.cyjs == '' || ypxx.cyjs == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.cyjs }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2" width="111"><span style="font-size:10px;">标注执行标准/<br />
      	技术文件</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.jyyj == '' || ypxx.jyyj == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.jyyj }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:26px;">
    <td><span style="font-size:10px;">抽样日期></span></td>
    <td colspan="2">
    	<c:choose>
   			<c:when test="${ypxx.cyrq == '' || ypxx.cyrq == null }">
		    	<span style="font-size:10px;">/</span>
	        </c:when>
	        <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.cyrq }</span>
            </c:otherwise>
	    </c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">封样状态</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.ypzt == '' || ypxx.ypzt == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.ypzt }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:26px;">
    <td><span style="font-size:10px;">备样量及封存地点</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.byljfcdd == '' || ypxx.byljfcdd == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.byljfcdd }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">寄送样地点</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.jsydd == '' || ypxx.jsydd == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.jsydd }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:26px;">
    <td><span style="font-size:10px;">是否为出口产品</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.sfwckcp == 0 }">
				<span style="font-size:10px;">是</span>
			</c:when>
			<c:when test="${ypxx.sfwckcp == 1 }">
				<span style="font-size:10px;">否</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.sfwckcp }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">寄送样截止日期</span></td>
    <td>
    	<c:choose>
   			<c:when test="${ypxx.jsyjzrq == '' || ypxx.jsyjzrq == null }">
		    	<span style="font-size:10px;">/</span>
	        </c:when>
	        <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.jsyjzrq }</span>
            </c:otherwise>
	    </c:choose>
    </td>
  </tr>
  <tr style="height:32px;">
    <td rowspan="3" height="78" width="30"><span style="font-size:10px;">抽<br />样<br />单<br />位</span></td>
    <td><span style="font-size:10px;">单位名称</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.cydw == '' || ypxx.cydw == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.cydw }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">联 系 人</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.cyry == '' || ypxx.cyry == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.cyry }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:32px;">
    <td><span style="font-size:10px;">单位地址</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.cydwdz == '' || ypxx.cydwdz == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.cydwdz }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">联系电话</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.cydwlxdh == '' || ypxx.cydwlxdh == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.cydwlxdh }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr style="height:32px;">
    <td><span style="font-size:10px;">邮政编码</span></td>
    <td colspan="2">
    	<c:choose>
			<c:when test="${ypxx.cydwyzbm == '' || ypxx.cydwyzbm == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.cydwyzbm }</span>
		    </c:otherwise>
		</c:choose>
    </td>
    <td colspan="2"><span style="font-size:10px;">传真/Email</span></td>
    <td>
    	<c:choose>
			<c:when test="${ypxx.czemail == '' || ypxx.czemail == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.czemail }</span>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
  <tr height="50">
    <td colspan="7" height="50" width="500" style="line-height: 100%;text-align:left;"><span style="font-size:10px;">备注（需要说明的其它问题）：</span><c:choose>
			<c:when test="${ypxx.bz == '' || ypxx.bz == null }">
				<span style="font-size:10px;">/</span>
			</c:when>
		    <c:otherwise>
		    	<span style="font-size:10px;">${ypxx.bz }</span>
		    </c:otherwise>
		</c:choose></td>
  </tr>
  <tr height="70">
    <td colspan="3" height="90" style="width:33%;"><span style="float:left;font-size:10px;">&nbsp;受检单位对上述内容无异议</span><br />
     <span style="float:left;font-size:10px;">&nbsp;受检单位签名（盖章）：</span><br />
		<br />
     <span style="float:right;font-size:10px;">年&nbsp;&nbsp;月&nbsp;&nbsp;日&nbsp;</span></td>
    <td colspan="2" style="width:33%;"><span style="float:left;font-size:10px;">&nbsp;生产单位对上述内容无异议</span><br />
      <span style="float:left;font-size:10px;">&nbsp;生产单位签名（盖章）：</span><br />
		<br />
      <span style="float:right;font-size:10px;">年&nbsp;&nbsp;月&nbsp;&nbsp;日&nbsp;</span></td>
    <td colspan="6" style="width:33%;"><span style="float:left;font-size:10px;">&nbsp;抽样人（签名）:</span><br />
    	<br />
     <span style="float:right;font-size:10px;">抽样单位（盖章）：&nbsp;</span><br />
     <span style="float:right;font-size:10px;">年&nbsp;&nbsp;月&nbsp;&nbsp;日&nbsp;</span></td>
  </tr>
  <tr style="height:60px;line-height: 100%;">
    <td colspan="7" rowspan="4" style="height:60px;" width="500"><span style="float:left;font-size:10px;">注:</span><br />
      <span style="float:left;font-size:10px;">&nbsp;&nbsp;1、技术文件指执行标准外的图纸、技术合同、产品说明书等有关产品技术的文件。</span><br />
      <span style="float:left;font-size:10px;">&nbsp;&nbsp;2、选择许可证、QS、CCC等类别后，填写相应证书编号。</span></td>
  </tr>
</table>
<%-- </c:choose> --%>
	</form>
</div>
</body>
</html>
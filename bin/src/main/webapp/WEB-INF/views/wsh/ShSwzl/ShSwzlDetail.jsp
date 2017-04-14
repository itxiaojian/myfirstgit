<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% String path = request.getContextPath();%>
<!-- saved from url=(0091)http://www.weiweixiao.net/index.php?g=Wap&m=LostFound&a=info&token=tojzqq1409283656&id=1427 -->
<html bdgjjgagedbdaebhbjbcabcdgeeebecf_c="1" eiiebffcjbffiheggaebebgceaeccbia_c="1" idceifdedfeiefjgfcjfbchejgbcbeid_c="1"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>失物招领</title>
<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<link href="<%=path%>/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/resources/css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<script src="<%=path%>/resources/js/jquery/jquery.min.js" type="text/javascript"></script><style type="text/css"></style><style type="text/css"></style><style type="text/css"></style>
<script type="text/javascript">
	function query(){
		var keyWord = $("#bt").val();
		if(keyWord == null || keyWord == ""){
			alert("请输入关键词查询!");
			return false;
		}else{
			$("#myForm").submit();
		}
	}
</script>
<script type="text/javascript">
    function return_prepage()  
    {  
    if(window.document.referrer==""||window.document.referrer==window.location.href)  
    {  
    window.location.href="{dede:type}[field:typelink /]{/dede:type}";  
    }else  
    {  
    window.location.href=window.document.referrer;  
    }  
      
    }  
    </script>
<style type="text/css">
	.style1{
		margin: 0px 5%;
		padding-top: 10px;
		padding-bottom: 5px;
	}
	.style2{
		margin-bottom: 0;
        margin-left: 5%;
        margin-right: 5%;
        margin-top: 40px;
		padding-top: 20px;
	}
	.bg1{
		background-color: #37b0c9;
	}
	.font1{
		font-weight: bold;
		color: white;
		font-size: 16px;
	}
	.input1{
		margin-left:5%;
		width:60%;
		height: 30px;
	}
	.input2 {
		margin-left: 10px;
		width: 65%;
		padding: 5px 5px;
		font-size: 16px;
	}
	.input3 {
		background-color: #37b0c9;
		padding: 0px 30px;
		border: none;
		color: white;
		font-size: 16px;
		line-height: 30px;
		font-weight: bold;
		
	}
	.input4{
		background-color: #e7838b;
		padding: 0px 30px;
		border: none;
		color: white;
		font-size: 16px;
		line-height: 30px;
		font-weight: bold;
		
	}
	.color1{
		color: #37b0c9;
	}
	.radioicon{
		margin-left: 20px;
		margin-right: 5px;
		position: relative;
		top:2px;
	}
	.margin1{
		margin-bottom: 10px;
	}
	.text1{
		float: left;
		width: 80px;
		text-align: right;
		
		font-size: 14px;
	}
	.text2{
	    text-align:left;
		float: left;
		width:70%;
		font-size: 14px;
	}
	.submit1{
		margin-left: 10px;
		margin-top:30px;
		text-align: center;
	}
</style>
</head>

<body id="cardunion" class="mode_webapp2" style="background-color: white;">
<div class="bg1">
	<div class="style1">
		<div class="wwx_f_l" style="position: relative;top: 4px;">
		<a class="font1" href="/wxpt/wsh/ShSwzl/toSwzlList?openId=${openId}">失物招领</a></div>
		<form action="/wxpt/wsh/ShSwzl/toSwzlList" id="myForm" class="wwx_f_l" style="width: 55%;margin-right: 10px;" method="post">
			<input type="text" class="input1" name="bt" id="bt">
			<span><a class="font1" href="javascript:;" style="margin-left: 10px;" onclick="query();">查询</a></span>
		</form>
		<div class="wwx_clear"></div>
		<a href="#" onclick="return_prepage();">
                  <div class="anniu">
			   <img  style="width:70%" src="<%=path%>/resources/img/fh.png" />
			      </div>
		    </a>
	</div>
</div>
<div class="style2">
	<div class="margin1">
				<div class="wwx_clear"></div>
	</div>
	<div class="margin1">
		<span style="color: red;">
			<c:if test="${map.lx=='1'&&map.jssj==null}">[失物]</c:if>
			<c:if test="${map.lx=='2'&&map.jssj==null}">[招领]</c:if>
			<c:if test="${map.jssj!=null}">[已认领]</c:if>
		</span>${map.bt }	</div>
	<div class="margin1">
		<div class="text1">发布日期：</div>
		<div class="text2">${map.fqsj }</div>
		<div class="wwx_clear"></div>
	</div>
	<c:if test="${map.jssj!=null }">
	<div class="margin1">
		<div class="text1">认领日期：</div>
		<div class="text2">${map.jssj }</div>
		<div class="wwx_clear"></div>
	</div>
	</c:if>
	<div class="margin1">
		<div class="text1">地点：</div>
		<div class="text2">${map.dd }</div>
		<div class="wwx_clear"></div>
	</div>
	<div class="margin1">
		<div class="text1">联系人：</div>
		<div class="text2">${map.fbrxm }</div>
		<div class="wwx_clear"></div>
	</div>
	<div class="margin1">
		<div class="text1">详情：</div>
		<div class="text2">${map.xwzs }</div>
		<div class="wwx_clear"></div>
	</div>
	<c:if test="${map.fbr==openId && map.jssj==null }">
		<div class="margin1">
			<div class="submit1">
				<a href="/wxpt/wsh/ShSwzl/update?id=${map.id }&openId=${openId}" class="input3">认领</a>
				 		</div>
			<div class="wwx_clear"></div>
		</div>
	</c:if>
	<c:if test="${map.jssj!=null }">
		<div class="margin1">
			<div class="submit1">
				<span class="input4">已认领</span>
				 		</div>
			<div class="wwx_clear"></div>
		</div>
	</c:if>
</div>
</body></html>
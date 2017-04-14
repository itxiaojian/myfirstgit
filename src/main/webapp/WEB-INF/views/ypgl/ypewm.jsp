<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<% 	
	String path = request.getContextPath();
// 	String xMurl=request.getRequestURL();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
<title>样品标签</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">

<script type="text/javascript">
</script>
<OBJECT classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" height="0" id="WebBrowser3" width="0" VIEWASTEXT>
</OBJECT>
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/wbm/bootstrap-custom1.min.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/wbm/jquery-ui-custom.min.css">
<%-- 	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/wbm/core.css"> --%>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/wbm/home.css">

	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/wbm/activity.css">

	<script type="text/javascript">var PATH="<%=path%>";</script>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.qrcode.min.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/wbm/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery-ui-1.8.22.min.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/wbm/filter.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/wbm/global.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
	<style id="qb_dict_style" type="text/css">
	.add-apply-btn1 {
	    margin-top: -47px;
	}
	#dict__tip {position: absolute; visibility: hidden;z-index: 50000; overflow:visible;}#dict__tip {border: 3px solid #2e9dff;padding: 0 12px 10px 12px;font-size: 12px;min-width:215px; max-width: 393px;background-color:#ffffff;box-shadow:0px 1px 8px rgba(0,0,0,0.2)}#dict__tip_translate_result {display:block;text-align:left; border: none; background: none}#dict__tip_translate_result span {margin:0px;padding:0px;line-height: 22px;font-family:Microsoft YaHei;font-size: 14px;color: #333333}#dict__tip_dict_info {border: none;background: none;position: relative;height: 30px;line-height: 30px;font-family:Microsoft YaHei,Tahoma, NSimsun, Simsun, sans-serif}#dict__tip_dict_info .dict-copyright {color: #999999;position: absolute;left: 0px;top: 0px}#dict__tip_dict_info .dict-link {position: absolute;right: 0px;top: 0px;}#dict__tip_dict_info #dict__tip_translate_link {padding-left: 10px;}#dict__tip_dict_info .dict-link a{color: #0066cc;text-decoration: none;}#dict__tip_dict_info .dict-link a:hover{text-decoration: underline;}</style>
	<style>     
		@media print {   
			.noprint {    
				display: none    
			}   
		}  
	</style> 
	<!--lodop打印控件start-->
	<script src="<%=path%>/resources/lodop/LodopFuncs.js" type="text/javascript"></script>
	<object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width="0" height="0" style="line-height:0px;"> 
	       <embed id="LODOP_EM" type="application/x-print-lodop" width="0" height="0" style="line-height:0px;"></embed>
	</object>
	<!--lodop打印控件end-->
	<!--打印的表格样式start-->
	<!-- <style id="printStyle">
	.tablePrint{
	 	border-collapse: collapse;
		border: 1px solid #000000;
		width: 100%;
		/* height: 50%;  */
 		background-color: White;
	}
	.tablePrint th{
	 	border-left: 1.0pt solid windowtext;
		border-right: 1.0pt solid windowtext;
		border-bottom: 1.0pt solid windowtext;
		word-wrap: normal;
		word-break: keep-all;
		overflow:hidden;
		border-color: #000000;
 		height:32px;  
		padding: 0 2px 0 4px;
		background-color:#cccccc;
		color:#000000;
/* 		font-weight: normal; */
/* 		line-height:32px;  */
	}
	.tablePrint td{
	 	border-left: 1.0pt solid windowtext;
		border-right: 1.0pt solid windowtext;
		border-bottom: 1.0pt solid windowtext;
		border-color: #000000;
		height:5px;
		padding: 1px 2px 1px 4px;
	}
	/* .tablePrint .printHide{
		display:none;
	}
	.table th, .table td {
    border: 1px solid #000;
    line-height: 18px;
    padding: 8px; */
}
	</style> -->
	
	 <style id="printStyle">
	 table {
    font-size: 9pt;
    font-weight: normal;
    color: #000000 ;
    text-decoration: none;
}
.tablePrint td {
    font-size: 9pt;
    font-weight: normal;
    color: #000000 ;
    text-decoration: none;
    
    border-left: 1.0pt solid windowtext;
	border-right: 1.0pt solid windowtext;
	border-bottom: 1.0pt solid windowtext;
	border-color: #000000;
}
.printfont{
    
    font-size: 9pt;
    font-weight: normal;
    color: #000000 ;
    text-decoration: none;
    
}
.tablePrint{
	 	border-collapse: collapse;
		border: 1px solid #000000;
		width: 100%;
		height: 50%;
 		background-color: White;
	}
	.tablePrint .printHide{
		display:none;
	}
	 </style>
	<!--打印的表格样式end-->
	<script type="text/javascript">
<%-- 		var xMurl="<%=xMurl%>"; --%>
			var str = "${url}";
		$(function(){
// 			alert(xMurl);
			//$('#code').qrcode(str);
			$("#code").qrcode({
				//render: "table",
				width: 100,
				height:100,
				text: str
			});
			
// 			$("#sub_btn").click(function(){
// 				$("#code").empty();
// 				var str = toUtf8($("#mytxt").val());
				
// 				$("#code").qrcode({
// 					render: "table",
// 					width: 200,
// 					height:200,
// 					text: str
// 				});
// 			});
		});
		function toUtf8(str) {   
		    var out, i, len, c;   
		    out = "";   
		    len = str.length;   
		    for(i = 0; i < len; i++) {   
		    	c = str.charCodeAt(i);   
		    	if ((c >= 0x0001) && (c <= 0x007F)) {   
		        	out += str.charAt(i);   
		    	} else if (c > 0x07FF) {   
		        	out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));   
		        	out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F));   
		        	out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));   
		    	} else {   
		        	out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));   
		        	out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));   
		    	}  
		    }   
		    return out;   
		}  
		//设置网页打印的页眉页脚为空
		function pagesetup_null(){                
		            var     hkey_root,hkey_path,hkey_key;
		            hkey_root="HKEY_CURRENT_USER";
		            hkey_path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
		            try{
		                            var RegWsh = new ActiveXObject("WScript.Shell");
		                            hkey_key="header";
		                        RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"");
		                        hkey_key="footer";
		                        RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"");
		                }catch(e){}
		}
		
		function printHandler(type){
			if(type=='0'){
				document.getElementById("sfby").innerHTML = "主";
			}else {
				document.getElementById("sfby").innerHTML = "备";
			}
 			var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));
 		    var strBodyStyle="<style>"+document.getElementById("printStyle").innerHTML+"</style>";
 		    var tableHtml;
 		    var tableObj=$('<table class="tablePrint"></table>');
 		    var tableCon=$('<div></div>');
  		    //LODOP.SET_PRINT_STYLEA(2,"FontName","隶书");
 		    tableCon.append(tableObj);
 		    tableObj.append($("#myTable").html());
 		    tableHtml=tableCon.html();
 			var strBodyHtml=strBodyStyle+"<body style='font-size: 1pt;'>"+tableHtml+"</body>";
 		    LODOP.PRINT_INIT("打印本页");
			LODOP.SET_PRINT_STYLE("FontSize",1);
 			LODOP.ADD_PRINT_TABLE(5,0,"33%","90%",strBodyHtml);
			LODOP.ADD_PRINT_BARCODE("8.8%","2.6%","18%","18%","QRCode",str);
			LODOP.SET_PRINT_PAGESIZE(0,700,500,"TMZ");
			LODOP.SET_PREVIEW_WINDOW(2,2,1,760,540,"");
 			LODOP.PREVIEW();
 			
 			document.getElementById("sfby").innerHTML = ""; 			
        }
		
	</script> 
</head>
	
	<body style="background-color: #fff;">
	<div style="display:none;" id="content"></div>
		<div class="container" style="width: 100%;">
			<div class="row home-container" style="padding-right: 0;">
				<div class="span12" style="margin-right: 0;width: 100%;">
					<div class="right-content">
<%-- 					<script type="text/javascript" src="<%=path%>/resources/js/wbm/qrcode.min.js"></script> --%>
<h3 class="noprint" style="text-align: center;" align="center">样品标签</h3>


<div>
		<table class="table table-hover" id="myTable" style="border-bottom:1px solid #DDD">
		<tbody>
			<tr>
				<td colspan="3" style="text-align: left;">样品名称：${map.ypmc }</td>
				<td style="text-align: center;" id="sfby"></td>
			</tr>
			<tr>
				<td colspan="4" style="text-align: left;">检验科室：${map.jyks }</td>
			</tr>
			<tr>
				<td rowspan="4" align="center"><div id="code" style="width: 100px;height: 100px;"></div></td>
				<td colspan="3" style="text-align: left;">样品编号：${map.ypbh }</td>
			</tr>
			<tr>
				<td colspan="3" style="text-align: left;">检验类别：${map.jylx }</td>
			</tr>
			<tr>
				<td colspan="3" style="text-align: left;">样品数量：${map.ypsl }</td>
			</tr>
			<tr>
				<td colspan="3" style="text-align: left;">到样日期：${map.dyrq }</td>
			</tr>
			<tr>
				<td align="center">留样</td>
				<td align="center">待检</td>
				<td align="center">在检</td>
				<td align="center">已检</td>
			</tr>
			<tr>
				<td align="center"></td>
				<td align="center">√</td>
				<td align="center"></td>
				<td align="center"></td>
			</tr>
		</tbody>
	</table>
	<%-- <input type="hidden" class="hidden" id="ypmcyc" name="ypmcyc" value="${map.ypmc }"> --%>
	<div id="footer" align="center" class="noprint" style="margin-top: 20px;">
		<button type="button" class="btn btn-success" onclick="printHandler(0);">打印主样</button>
		<button type="button" class="btn btn-success" onclick="printHandler(1);">打印备样</button>
		<button type="button" class="btn btn-success" onclick="window.close();">关闭</button>
	</div>
	</div>
					</div>
				</div>
			</div>
		</div>
		
<style>
.version-modal{
	padding-bottom:20px; 
}
.version-modal .version-model-body{
	padding: 20px;
	margin-bottom: 20px;
	max-height: 100%;
}
.version-modal .version-model-body ul,
.version-modal .version-model-body ol {
	margin: 14px 0 14px 0;
	padding: 0 0 0 40px;
}
.version-modal .version-model-body ul,
.version-modal .version-model-body ul li{
	list-style: disc;
}
.version-modal .version-model-body ol,
.version-modal .version-model-body ol li{
	list-style: decimal;
}

.version-header{
	height: 70px;
	text-align: center;
	background-color: #f3f3f3;
}
.version-publish-date{
	color: #ac7b53;
	margin-bottom: 10px;
}
.version-sure-btn{
	margin-left:40%;
	margin-right:40%;
	background-color: #ff900c;
	color: #fff;
	font-size: 13px;
	padding: 10px;
	border-radius:5px;
	cursor: pointer;
	
}
</style>

<script type="text/javascript">
</script>		

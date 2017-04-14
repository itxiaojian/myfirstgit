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
		
<title>设备标签</title>
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

	<script type="text/javascript">var prePath="<%=path%>";</script>
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
	<script src="<%=path%>/libs/lodop/LodopFuncs.js" type="text/javascript"></script>
	<object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width="0" height="0" style="line-height:0px;"> 
	       <embed id="LODOP_EM" type="application/x-print-lodop" width="0" height="0" style="line-height:0px;"></embed>
	</object>
	<!--lodop打印控件end-->
	<!--打印的表格样式start-->
	<style id="printStyle">
	.tablePrint{
	 	border-collapse: collapse;
		border: 1px solid #000000;
		width: 100%;
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
		font-weight: normal;
		line-height:32px; 
	}
	.tablePrint td{
	 	border-left: 1.0pt solid windowtext;
		border-right: 1.0pt solid windowtext;
		border-bottom: 1.0pt solid windowtext;
		border-color: #000000;
		height:30px; 
		padding: 1px 2px 1px 4px;
	}
	.tablePrint .printHide{
		display:none;
	}
	</style>
	<!--打印的表格样式end-->
	<script type="text/javascript">
<%-- 		var xMurl="<%=xMurl%>"; --%>
		$(function(){
// 			alert(xMurl);
			var str = "${url}";
			//$('#code').qrcode(str);
			$("#code").qrcode({
				//render: "table",
				width: 150,
				height:150,
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
		function printHandler(){
// 			var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM')); 
// 		    var strBodyStyle="<style>"+document.getElementById("printStyle").innerHTML+"</style>";
// 		    var tableHtml;
// 		    var tableObj=$('<table class="tablePrint"></table>');
// 		    var tableCon=$('<div></div>');
// 		    tableCon.append(tableObj);
// 		    tableObj.append($("#myTable").html());
// 		    tableHtml=tableCon.html();
// 			var strBodyHtml=strBodyStyle+"<body>"+tableHtml+"</body>";
// 		    LODOP.PRINT_INIT("打印本页");	
// 			LODOP.ADD_PRINT_TABLE(15,0,"99%","96%",strBodyHtml);
// 			LODOP.PREVIEW();

			pagesetup_null();
			window.print();
        }
		
	</script> 
</head>
	
	<body style="background-color: #fff;">
	<div style="display:none;" id="content"></div>
	<label class="noprint">注意：需要连接打印机才能正常测试。</label>
		<div class="container" style="width: 100%;">
			<div class="row home-container" style="padding-right: 0;">
				<div class="span12" style="margin-right: 0;width: 100%;">
					<div class="right-content">
<%-- 					<script type="text/javascript" src="<%=path%>/resources/js/wbm/qrcode.min.js"></script> --%>
<h3 class="noprint" style="text-align: center;" align="center">设备标签</h3>


<div>
		<table class="table table-hover" id="myTable" style="border-bottom:1px solid #DDD">
		<tbody>
			<tr>
				<td colspan="2" style="text-align: left;">设备名称：${map.sbmc }</td>
			</tr>
			<tr>
				<td style="text-align: left;">设备编号：${map.sbbh }</td>
				<td style="text-align: left;">
					规格型号：${map.sbxh }
				</td>
			</tr>
			<tr>
				<td style="text-align: left;">
					设备类别：${map.lbmc }
				</td>
				<td style="text-align: left;">生产厂家：${map.sccj }</td>
			</tr>
			<tr>
				<td rowspan="2" align="center"><div id="code" style="width: 150px;height: 150px;"></div></td>
				<td style="text-align: left;">
					出厂编号：${map.ccbh }
				</td>
			</tr>
			<tr>
				<td style="text-align: left;">
					登记日期：${map.ccrq }
				</td>
			</tr>
		</tbody>
	</table>
	<div id="footer" align="center" class="noprint" style="margin-top: 20px;">
		<button type="button" class="btn btn-success" onclick="printHandler();">打印</button>
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

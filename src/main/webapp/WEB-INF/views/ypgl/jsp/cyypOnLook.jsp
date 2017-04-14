<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.qrcode.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
</head>

<script type="text/javascript">
<%-- 		var xMurl="<%=xMurl%>"; --%>
		function load() {
			var str = "${url}";
			//$('#code').qrcode(str);
			$("#code").qrcode({
				//render: "table",
				width: 150,
				height:150,
				text: str
			});
			
			/* var rValue1 = $("#lRadio").val();
            initradio('lyfs',rValue1); */
            
            var rValue3 = $("#yRadio").val();
            initradio('ypyj',rValue3);
            
            var rValue2 = $("#jRadio").val();
            initradio('jyfydd',rValue2);
            
            var rValue4 = $("#bRadio").val();
            initradio('bgfsfs',rValue4);
            
            var rValue5 = $("#sRadio").val();
            initradio('sfwckcp',rValue5);
		}
		/* $(function(){
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
		
		$(function(){
			
            
        } */
        
        //根据后台传的值默认选中单选按钮
        function initradio(rName,rValue){
            var rObj = document.getElementsByName(rName);

            for(var i = 0;i < rObj.length;i++){
                if(rObj[i].value == rValue){
                    rObj[i].checked =  'checked';
                }
            }
        }
		
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
		/* //设置网页打印的页眉页脚为空
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
        } */
		
	</script>
<body onload="load();">
	<div class="wrapper">
	<div class="panel">
	<!-- <header class="panel-heading" style="padding-left: 650px;">样品信息</header> -->
		<div class="panel-body">
			<div style="text-align:center;margin-bottom:10px"></div>
                <form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
                <c:forEach var="ypxx" items="${ypxx}" varStatus="obj">
                    <input type="hidden" name="id" id="id" value="${ypxx.id }">
					<div class="form-group"
                        style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                       <label class="col-sm-2 col-sm-2 control-label"
                              style="margin-top: 15px;" >检验科室：</label>

                       <div class="col-sm-10" style="margin-top: 21px;">
                           <input id="jyks" name="jyks" class="form-control"  value="${ypxx.jyks }" readonly="true" />
                       </div>
                       <label class="col-sm-2 col-sm-2 control-label"
                              style="margin-top: 18px;">字号名称：</label>
                       <div class="col-sm-10" style="margin-top: 21px;">
                           <input class="form-control" type="text" id="zh" name="zh" value="${ypxx.zh }" readonly="readonly">
                       </div>
                       <label class="col-sm-2 col-sm-2 control-label">二维码图片:</label>
                       <div class="col-sm-10">
                           <div id="code" style="width: 150px;height: 150px;"></div>
                       </div>
                   </div>

                   <div class="form-group"
                        style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                       <label class="col-sm-2 col-sm-2 control-label">业务科室：</label>
                       <div class="col-sm-10">
                           <input id="ywks" name="ywks" class="form-control"  value="${ypxx.ywks }" readonly="true" />
                       </div>
                       <label class="col-sm-2 col-sm-2 control-label">样品编号：</label>
                       <div class="col-sm-10">
                           <input class="form-control" type="text" id="ypbh" name="ypbh" value="${ypxx.ypbh }" readonly="readonly">
                       </div>
                       <label class="col-sm-2 col-sm-2 control-label">报告编号：</label>
                       <div class="col-sm-10">
                           <input class="form-control" type="text" id="bgbh" name="bgbh" value="${ypxx.bgbh }" readonly="readonly">
                       </div>
                   </div>

                   <div class="form-group"
                        style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                       <label class="col-sm-2 col-sm-2 control-label">产品名称：</label>
                       <div class="col-sm-10">
                           <input class="form-control" type="text" id="ypmc" name="ypmc" value="${ypxx.ypmc }" readonly="readonly">
                       </div>
                       <label class="col-sm-2 col-sm-2 control-label">产品等级：</label>
                       <div class="col-sm-10">
                           <input class="form-control" type="text" id="ypdj" name="ypdj" value="${ypxx.ypdj }" readonly="readonly">
                       </div>
                       <label class="col-sm-2 col-sm-2 control-label">商标：</label>
                       <div class="col-sm-10">
                           <input class="form-control" type="text" id="sb" name="sb" value="${ypxx.sb }" readonly="readonly">
                       </div>
                   </div>

                   <div class="form-group"
                       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                      <label class="col-sm-2 col-sm-2 control-label">封样状态：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="ypzt" name="ypzt" value="${ypxx.ypzt }" readonly="readonly">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">任务来源：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="rwly" name="rwly" value="${ypxx.rwly }" readonly="readonly">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">规格型号：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="ggxh" name="ggxh" value="${ypxx.ggxh }" readonly="readonly">
                      </div>
                  </div>

				  <div class="form-group"
                       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
	                      <label class="col-sm-2 col-sm-2 control-label">生产日期/批号：</label>
	                      <div class="col-sm-10">
	                          <input class="form-control" type="text" id="scrqpc" name="scrqpc" value="${ypxx.scrqpc }" readonly="readonly">
	                      </div>
	                      <label class="col-sm-2 col-sm-2 control-label">备样量及封存地点：</label>
	                      <div class="col-sm-10">
	                          <input class="form-control" type="text" id="byljfcdd" name="byljfcdd" value="${ypxx.byljfcdd }" readonly="readonly">
	                      </div>
	                      <label class="col-sm-2 col-sm-2 control-label">寄送样地点：</label>
	                      <div class="col-sm-10">
	                          <input class="form-control" type="text" id="jsydd" name="jsydd" value="${ypxx.jsydd }" readonly="readonly">
	                      </div>
                   </div>

                   <div class="form-group"
                        style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                       <label class="col-sm-2 col-sm-2 control-label">寄送样截止日期：</label>
                       <div class="col-sm-10">
                           <input class="form-control Wdate" type="text" id="jsyjzrq" name="jsyjzrq"
                                  onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${ypxx.jsyjzrq }" disabled="true">
                       </div>
                       <label class="col-sm-2 col-sm-2 control-label">是否为出口产品：</label>
                       <div class="col-sm-10" style="margin-top: 5px;">
                           <label><input type="radio" name="sfwckcp" value="0" >是</label>
                           <label style="padding-left: 20px;"><input type="radio" name="sfwckcp" value="1">否</label>
                           <input type="hidden" name="sRadio" id="sRadio" value="${ypxx.sfwckcp }">
                       </div>
                      <label class="col-sm-2 col-sm-2 control-label">抽样单位：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="cydw" name="cydw" maxlength="36" value="${ypxx.cydw }" readonly="readonly">
                      </div>
                   </div>
                   
                   <div class="form-group"
                       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                      <label class="col-sm-2 col-sm-2 control-label">抽样单位联系人：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="cyry" name="cyry" value="${ypxx.cyry }" readonly="readonly">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">抽样单位电话：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="cydwlxdh" name="cydwlxdh" value="${ypxx.cydwlxdh }" readonly="readonly">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">邮政编码：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="cydwyzbm" name="cydwyzbm" value="${ypxx.cydwyzbm }" readonly="readonly" /> 
                      </div>	
                  </div>
                  									
					<div class="form-group"
                       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                      <label class="col-sm-2 col-sm-2 control-label">传真/Email：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="czemail" name="czemail" value="${ypxx.czemail }" readonly="readonly" /> 
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">抽样数量：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="cysl" name="cysl" value="${ypxx.cysl }" readonly="readonly">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">抽样日期：</label>
                      <div class="col-sm-10">
                          <input class="form-control Wdate" type="text" id="cyrq" name="cyrq"
                                 onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${ypxx.cyrq }" disabled="true">
                      </div>
                    </div>
                    
                    <div class="form-group"
                       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                       <label class="col-sm-2 col-sm-2 control-label">抽样基数：</label>
                       <div class="col-sm-10">
                           <input class="form-control" type="text" id="cyjs" name="cyjs" value="${ypxx.cyjs }" readonly="readonly"/> 
                       </div>
                      <label class="col-sm-2 col-sm-2 control-label">受检单位：</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" id="sjdw" name="sjdw" value="${ypxx.sjdw }" disabled="true">
                        </div>
                      <label class="col-sm-2 col-sm-2 control-label">受检单位地址：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="sjdwdz" value="${ypxx.sjdwdz }" disabled="true">
                      </div>
                    </div>
                    
                    <div class="form-group" 
                  		style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                      <label class="col-sm-2 col-sm-2 control-label">联系人：</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" id="lxr" name="lxr" value="${ypxx.lxr }" disabled="true">
                        </div>
                      <label class="col-sm-2 col-sm-2 control-label">电话：</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" id="sjdwgddh" name="sjdwgddh" value="${ypxx.sjdwgddh }" disabled="true">
                        </div>
                      <label class="col-sm-2 col-sm-2 control-label">受检单位法人代表：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="sjdwfrdb" name="sjdwfrdb" value="${ypxx.sjdwfrdb }" disabled="true">
                      </div>
                    </div>
					
					<div class="form-group"
                       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
	                    <label class="col-sm-2 col-sm-2 control-label">生产单位：</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" id="scdw" name="scdw" value="${ypxx.scdw }" disabled="true">
                        </div>
                        <label class="col-sm-2 col-sm-2 control-label">生产单位地址：</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" id="scdwdz" value="${ypxx.scdwdz }" disabled="true">
                        </div>
	                    <label class="col-sm-2 col-sm-2 control-label">生产单位联系人：</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" id="scdwlxr" value="${ypxx.scdwlxr }" disabled="true">
                        </div>
                    </div>
                    
                    <div class="form-group"
                       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
	                       <label class="col-sm-2 col-sm-2 control-label">生产单位者电话：</label>
	                       <div class="col-sm-10">
	                           <input class="form-control" type="text" id="scdwdh" value="${ypxx.scdwdh }" disabled="true">
	                       </div>
	                       <label class="col-sm-2 col-sm-2 control-label">生产单位邮编：</label>
	                       <div class="col-sm-10">
	                           <input class="form-control" type="text" id="scdwyb" value="${ypxx.scdwyb }" disabled="true">
	                       </div>
	                      <label class="col-sm-2 col-sm-2 control-label">生产单位法人代表：</label>
	                      <div class="col-sm-10">
	                          <input class="form-control" type="text" id="scdwfrdb" value="${ypxx.scdwfrdb }" disabled="true">
	                      </div>
                    </div>
					
					<div class="form-group"
                       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                      <label class="col-sm-2 col-sm-2 control-label">营业执照：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="yyzz" name="yyzz" value="${ypxx.yyzz }" disabled="true">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">机构代码：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="jgdm" name="jgdm" value="${ypxx.jgdm }" disabled="true">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">经济类型：</label>
	                  <div class="col-sm-10">
					  <select class="form-control input-lg m-bot15" name="jjlx" disabled="true">
					  <c:forEach items="${jjlx}" var="jjlx">
          			  <c:choose>
           			  <c:when test="${jjlx.zdz == ypxx.jjlx}">
                 	  <option selected = "selected" value="${jjlx.zdz}">${jjlx.zdmc}</option>
           			  </c:when>
           			  <c:otherwise>
                 	  <option value="${jjlx.zdz}">${jjlx.zdmc}</option>
           			  </c:otherwise>
       				  </c:choose>
   					  </c:forEach> 
					  </select>
					  </div>
                  </div>
                  
                  <div class="form-group"
                       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                      <label class="col-sm-2 col-sm-2 control-label">企业人数：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="rs" name="rs" value="${ypxx.rs }" disabled="true">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">企业产值：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="cz" name="cz" value="${ypxx.cz }" disabled="true">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">企业产量：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="cl" name="cl" value="${ypxx.cl }" disabled="true">
                      </div>
                  </div>
                  
                  <div class="form-group"
                       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                      <label class="col-sm-2 col-sm-2 control-label">证书类型：</label>
	                  <div class="col-sm-10">
					  <select class="form-control input-lg m-bot15" name="zslx" disabled="true">
					  <c:forEach items="${zslx}" var="zslx">
          			  <c:choose>
           			  <c:when test="${zslx.zdz == ypxx.zslx}">
                 	  <option selected = "selected" value="${zslx.zdz}">${zslx.zdmc}</option>
           			  </c:when>
           			  <c:otherwise>
                 	  <option value="${zslx.zdz}">${zslx.zdmc}</option>
           			  </c:otherwise>
       				  </c:choose>
   					  </c:forEach> 
					  </select>
					  </div>
                      <label class="col-sm-2 col-sm-2 control-label">证书编号：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="zsbh" name="zsbh" value="${ypxx.zsbh }" disabled="true">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">检验类型：</label>
	                  <div class="col-sm-10">
					  <select class="form-control input-lg m-bot15" name="jylx" disabled="true">
					  <c:forEach items="${jylx}" var="jylx">
          			  <c:choose>
           			  <c:when test="${jylx.zdz == ypxx.jylx}">
                 	  <option selected = "selected" value="${jylx.zdz}">${jylx.zdmc}</option>
           			  </c:when>
           			  <c:otherwise>
                 	  <option value="${jylx.zdz}">${jylx.zdmc}</option>
           			  </c:otherwise>
       				  </c:choose>
   					  </c:forEach> 
					  </select>
					  </div>
                    </div>
					
					<div class="form-group"
                         style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">检验项目：</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="2" name="jyxm" 
							truetype="textarea" style="width: 99.5%;" disabled="true">${ypxx.jyxm }</textarea>
						</div>
					</div>
					
					<div class="form-group"
                         style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label" disabled="true">检验依据：</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="2" name="jyyj" 
							truetype="textarea" style="width: 99.5%;" disabled="true">${ypxx.jyyj }</textarea>
						</div>
					</div>
					
					<div class="form-group"
                         style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                        <label class="col-sm-2 col-sm-2 control-label">检验费用：</label>
						<div class="input-group m-bot15 col-sm-10">
							<input class="form-control" type="text" value="${ypxx.jyfy }" name="jyfy" disabled="true">
							<span class="input-group-addon">元</span>
						</div>
                        <label class="col-sm-2 col-sm-2 control-label">检验费用待定：</label>
						<div class="col-sm-10" style="margin-top: 5px;">
                            <label><input type="radio" name="jyfydd" value="0">待定</label>
                            <label style="padding-left: 20px;"><input type="radio" name="jyfydd" 
                             checked="checked" value="1">不待定</label>
                            <input type="hidden" name="jRadio" id="jRadio" value="${ypxx.jyfydd }">   
                        </div>
                        <label class="col-sm-2 col-sm-2 control-label">验后需退库：</label>
		                  <div class="col-sm-10">
						  <select class="form-control input-lg m-bot15" name="yhxtk" disabled="true">
						  <c:forEach items="${yhxtk}" var="yhxtk">
	          			  <c:choose>
	           			  <c:when test="${yhxtk.zdz == ypxx.yhxtk}">
	                 	  <option selected = "selected" value="${yhxtk.zdz}">${yhxtk.zdmc}</option>
	           			  </c:when>
	           			  <c:otherwise>
	                 	  <option value="${yhxtk.zdz}">${yhxtk.zdmc}</option>
	           			  </c:otherwise>
	       				  </c:choose>
	   					  </c:forEach> 
						  </select>
						  </div>
                    </div> 
					
					<div class="form-group"
                         style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">备注</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="6" name="bz" 
							truetype="textarea" style="width: 99.5%;" disabled="true">${ypxx.bz }</textarea>
						</div>
					</div>
				</c:forEach>
				</form>
		  </div>
	   </div>
    </div>
    <c:if test="${kobe == null }">
	<div style="text-align: center">
		<div class="panel-body">
			<button type="button" class="btn btn-success"
				onClick="exit();">返回</button>
		</div>
	</div>
	</c:if>
</body>
<script>
//返回
function exit(){
	/* var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
}
</script>
</html>

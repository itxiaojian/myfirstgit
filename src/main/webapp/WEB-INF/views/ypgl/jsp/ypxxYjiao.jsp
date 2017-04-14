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
			
			var rValue1 = $("#lRadio").val();
            initradio('lyfs',rValue1);
            
            var rValue2 = $("#jRadio").val();
            initradio('jyfydd',rValue2);
            
            var rValue4 = $("#bRadio").val();
            initradio('bgfsfs',rValue4);
		}
		
		//返回
		function exit(){
			/* var PAGESIZE = 20;
			window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
		    window.parent.ACT_DEAL_WINDOW.close();
		}

		//提交
		function save() {
			msg="确定要移交？";
			if (confirm(msg)) {
				var url = "<%=path%>/ypgl/YYpYj/Yjiao";
				$.ajax({
					cache : true,
					type : "POST",
					url : url,
					data : $('#myForm').serialize(),// 你的formid
					async : false,
					error : function(request) {
						alert("移交失败,请联系管理员。");
					},
					success : function(data) {
						alert('移交成功！');
						parent.location.href = "<%=path%>/ypgl/YYpYj/yjjlPage";
					}
				});
			}
		} 
        
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
                    <input type="hidden" name="zlysl" id="zlysl" value="${ypxx.lysl }">
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
                           <input id="ywks" name="ywks" class="form-control"  value="${ypxx.ywks }" readonly="readonly" />
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
                       <label class="col-sm-2 col-sm-2 control-label">样品名称：</label>
                       <div class="col-sm-10">
                           <input class="form-control" type="text" id="ypmc" name="ypmc" value="${ypxx.ypmc }" readonly="readonly">
                       </div>
                       <label class="col-sm-2 col-sm-2 control-label">商标：</label>
                       <div class="col-sm-10">
                           <input class="form-control" type="text" id="sb" name="sb" value="${ypxx.sb }" readonly="readonly">
                       </div>
                       <label class="col-sm-2 col-sm-2 control-label">样品等级：</label>

                       <div class="col-sm-10">
                           <input class="form-control" type="text" id="ypdj" name="ypdj" value="${ypxx.ypdj }" readonly="readonly">
                       </div>
                   </div>

                   <div class="form-group"
                        style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                       <label class="col-sm-2 col-sm-2 control-label">样品状态：</label>
                       <div class="col-sm-10">
                           <input class="form-control" type="text" id="ypzt" name="ypzt" value="${ypxx.ypzt }" readonly="readonly">
                       </div>
                       <label class="col-sm-2 col-sm-2 control-label">来样方式：</label>
                       <div class="col-sm-10" style="margin-top: 5px;">
                           <label><input type="radio" name="lyfs" value="0" >直送</label>
                           <label style="padding-left: 20px;"><input type="radio" name="lyfs" value="1">快递</label>
                           <input type="hidden" name="lRadio" id="lRadio" value="${ypxx.lyfs }">
                       </div>
                       <label class="col-sm-2 col-sm-2 control-label">规格型号：</label>
                       <div class="col-sm-10">
                           <input class="form-control" type="text" id="ggxh" name="ggxh" value="${ypxx.ggxh }" readonly="readonly">
                       </div>
                   </div>


                   <div class="form-group"
                        style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                       <label class="col-sm-2 col-sm-2 control-label">所在城市：</label>

                       <div class="col-sm-10">
                           <input class="form-control" type="text" id="szcs" name="szcs" value="${ypxx.szcs }" readonly="readonly">
                       </div>
                       <label class="col-sm-2 col-sm-2 control-label">生产日期批次：</label>
                       <div class="col-sm-10">
                           <input class="form-control" type="text" id="scrqpc"
                                  name="scrqpc" value="${ypxx.scrqpc }" readonly="readonly">
                       </div>
                       <label for="ypsl" class="col-sm-2 col-sm-2 control-label">样品数量：</label>
                       <div class="col-sm-10">
                           <input class="form-control" type="text" id="ypsl" name="ypsl" value="${ypxx.ypsl }" readonly="readonly"/>
                       </div>
                   </div>

				   <div class="form-group"
                        style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">委托单位：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="wtdw" name="wtdw" value="${ypxx.wtdw }" disabled="true">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">委托单位地址：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="wtdwdz" name="wtdwdz" value="${ypxx.wtdwdz }" disabled="true">
						</div>
                        <label class="col-sm-2 col-sm-2 control-label">受检单位：</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" id="sjdw" name="sjdw" value="${ypxx.sjdw }" disabled="true">
                        </div>
					</div>
					
					<div class="form-group"
                        style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">受检单位地址：</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" id="sjdwdz" value="${ypxx.sjdwdz }" disabled="true">
                        </div>
						<label class="col-sm-2 col-sm-2 control-label">生产单位：</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" id="scdw" name="scdw" value="${ypxx.scdw }" disabled="true">
                        </div>
                        <label class="col-sm-2 col-sm-2 control-label">生产单位地址：</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" id="scdwdz" value="${ypxx.scdwdz }" disabled="true">
                        </div>
					</div>
					
					<div class="form-group"
                         style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">检验项目：</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="2" name="jyxm" 
							truetype="textarea" style="width: 996px;" disabled="true">${ypxx.jyxm }</textarea>
						</div>
					</div>
					
					<div class="form-group"
                         style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label" disabled="true">检验依据：</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="2" name="jyyj" 
							truetype="textarea" style="width: 996px;" disabled="true">${ypxx.jyyj }</textarea>
						</div>
					</div>
					
					<div class="form-group"
                         style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">检验费用：</label>
						<div class="input-group m-bot15 col-sm-10">
							<input class="form-control" type="text" value="${ypxx.jyfy }" name="jyfy" disabled="true">
							<span class="input-group-addon">元</span>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">到样日期：</label>
                        <div class="col-sm-10">
                            <input class="form-control Wdate" type="text" id="dyrq"
                                   name="dyrq" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${ypxx.dyrq }" disabled="true">
                        </div>
                        <label class="col-sm-2 col-sm-2 control-label">完成期限：</label>
                        <div class="col-sm-10">
                            <input class="form-control Wdate" type="text" id="wcqx"
                                   name="wcqx"
                                   onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${ypxx.wcqx }" disabled="true">
                        </div>
					</div>
					<div class="form-group"
                         style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
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
						<option selected = "selected" value=""></option>
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
					<div class="form-group" style="padding-bottom: 2px; padding-top: 0px; margin-bottom: 0px; 
                     width: 100%; margin-left: 0px; margin-right: 0px;">
                        <label class="col-sm-2 col-sm-2 control-label">报告发送方式：</label>
                        <div class="col-sm-10" style="margin-top: 5px;width: 40%;">
                            <label><input type="radio" name="bgfsfs" value="0" checked="checked">邮寄</label>
                            <label><input type="radio" name="bgfsfs" value="1">自取（本院）</label>
                            <label><input type="radio" name="bgfsfs" value="2">自取（中心）</label>
                            <input type="hidden" name="bRadio" id="bRadio" value="${ypxx.bgfsfs }">
                        </div>
                    </div>
					
					<div class="form-group"
                         style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">检查封样人员：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="jcfyry" name="jcfyry" value="${ypxx.jcfyry }" disabled="true">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">检验合同号：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="jyhth" name="jyhth" value="${ypxx.jyhth }" disabled="true">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">样品附件：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="fj" name="fj"  value="${ypxx.fj }" disabled="true">
						</div> 
					</div>
					
					<div class="form-group"
                         style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">移交时间：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="yjsj" name="yjsj" 
							onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">移交数量：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="yjsl" name="yjsl">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">接收人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="jsr" name="jsr">
						</div>
					</div>
					
					<div class="form-group"
                         style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">接收时间：</label>
						<div class="col-sm-10">
							<input class="form-control Wdate" type="text" id="jssj" name="jssj" 
							onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">移交人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="yjr" name="yjr">
						</div>
						<label class="col-sm-2 col-sm-2 control-label">办理人：</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="blr" name="blr">
						</div>
					</div>

					<div class="form-group"
                         style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						<label class="col-sm-2 col-sm-2 control-label">备注</label>
						<div class="col-sm-13">
							<textarea class="form-control ckeditor textarea" rows="3" name="bz" 
							truetype="textarea" style="width: 996px;"></textarea>
						</div>
					</div>
				</c:forEach>
				</form>
		  </div>
	   </div>
    </div>
	<div style="text-align: center">
		<div class="panel-body">
			<button type="button" class="btn btn-primary"
				onClick="save()">移交</button>
			<button type="button" class="btn btn-success"
				onClick="exit();">返回</button>
		</div>
	</div>
</body>

</html>

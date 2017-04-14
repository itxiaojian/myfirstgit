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
<script type="text/javascript">var PATH = '<%=path%>';</script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery-1.10.2.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css">
    <script type="text/javascript" src="<%=path%>/resources/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/datePicker/WdatePicker.js"></script>
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/upload.css">
    <script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.qrcode.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
    <script language="javascript" src="<%=path%>/resources/lodop/LodopFuncs.js"></script>
    <script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/yz/jquery.validate.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/yz/yzstyle.css">
<script type="text/javascript">
//输入的时候回车可以跳到下一个输入域
$(function () {
    //回车代替tab
    $('input:text:first').focus();
    //如果有其他输入类型可以在此处加入
    var $target = $('input,button,select');
    $target.bind('keydown', function (e) {
        var key = e.which;
        if (key == 13) {
            e.preventDefault();
            var nxtIdx = $target.index(this) + 1;
            if ($target.eq(nxtIdx).attr("type") == "submit") {
                $target.eq(nxtIdx).click();
            } else {
                $target.eq(nxtIdx).focus();
            }
        }
    });
});


$(function() {
	$('#ks_id').combotree({
		url: '<%=path%>/test/ssksList?optype=getchildtree',
    'onLoadSuccess': function(node,data){ 
	        if(data.length>0){
			       var val = "1"; 
		         var txt = $('#ks_id').combotree('getText'); 
             if(val != "" && val==txt){
                var urlstr = "<%=path%>/test/xlsList" +"?optype=gettext&id="+val;
                $.get(urlstr,
                      function(gettxt){
                	      if(gettxt!="")
             	            $('#ks_id').combotree('setText',gettxt);
                      }  
                  );
               }
	        }
		},
		'onChange': function (n, o) {
            $("#ks_id1").val(n);
        }
	});
	$('#jyks_id').combotree({
		 url: '<%=path%>/test/xlsList?optype=getchildtree&id=100500',
    'onLoadSuccess': function(node,data){ 
	        if(data.length>0){
			       var val = "1"; 
		         var txt = $('#jyks_id').combotree('getText'); 
             if(val != "" && val==txt){
                var urlstr = "<%=path%>/test/xlsList" +"?optype=gettext&id="+val;
                $.get(urlstr,
                      function(gettxt){
                	      if(gettxt!="")
             	            $('#jyks_id').combotree('setText',gettxt);
                      }  
                  );
               }
	        }
		},
		'onChange': function (n, o) {
            $("#jyks_id1").val(n);
        }
	});
	
	$('#yeks_id').combotree({
		 url: '<%=path%>/test/xlsList1?optype=getchildtree',
    'onLoadSuccess': function(node,data){ 
	        if(data.length>0){
			       var val = "1"; 
		         var txt = $('#yeks_id').combotree('getText'); 
             if(val != "" && val==txt){
                var urlstr = "<%=path%>/test/xlsList" +"?optype=gettext&id="+val;
                $.get(urlstr,
                      function(gettxt){
                	      if(gettxt!="")
             	            $('#yeks_id').combotree('setText',gettxt);
                      }  
                  );
               }
	        }
		},
		'onChange': function (n, o) {
            $("#yeks_id1").val(n);
        }
	});
	if(window.screen.width=='1024'){
		$('.combo').width('148px');
		$('.combo-text').width('148px');
	}else if(window.screen.width=='1280'){
		$('.combo').width('185px');
		$('.combo-text').width('185px');
	}else if(window.screen.width=='1360'){
		$('.combo').width('200px');
		$('.combo-text').width('200px');
	}else if(window.screen.width=='1440'){
		$('.combo').width('215px');
		$('.combo-text').width('215px');
	}else if(window.screen.width=='1600'){
		$('.combo').width('240px');
		$('.combo-text').width('240px');
	}else{
		$('.combo').width('148px');
		$('.combo-text').width('148px');
	}
});

	
//返回
function close(){
	/* var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
}

//提交
 $(function() {
	 $("#myForm").validate({
		 submitHandler: function() {
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/jsfwgl/YjsfwXyxx/update";
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : $('#myForm').serialize(),// 你的formid
			async : false,
			error : function(request) {
				alert("修改失败,请联系管理员。");
			},
			success : function(data) {
				alert('修改成功！');
				var PAGESIZE = 20;
				window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	            window.parent.ACT_DEAL_WINDOW.close();
			}
		});
	}
	}
	})
})

//打开客户信息窗口
function getKhxx() {
	var del = $("#table");
    del.remove();
	var khmccx = document.getElementById("khmccx").value;
    var frxmcx = document.getElementById("frxmcx").value;
	var url = "<%=path%>/khgl/YKhKhxx/getKhxx";
	$.ajax({
		cache : true,
		type : "POST",
		url : url,
		data : {khmccx:khmccx,frxmcx:frxmcx},
		async : false,
		error : function(request) {
			alert("选择失败,请联系管理员。");
		},
		success : function(data) {
			var del = $("#table");
			del.remove();
        	var str="<table><thead><tr><th>客户名称</th><th>法人姓名</th><th>手机号码</th><th>客户地址</th>"
				   +"<th>操作</th></tr></thead><tbody>";
        	for(var i=0;i<data.length;i++){
        		str=str+"<tr id='"+data[i].ID+"'><td>"+data[i].KHMC+"</td><td>"+data[i].FRXM+"</td><td>"+data[i].SJHM+"</td><td>"+data[i].KHDZ+"</td><td><input type ='button' onClick='saveKhxx("+data[i].ID+");' value='选择'></td>";
        	} 
        	str=str+"</tbody><table>";
        	var oTest = document.getElementById("sectKhxx");
    		var newNode = document.createElement("table");
    		var befNode = document.getElementById("sbzKhxx");
    		newNode.setAttribute('class','table');
    		newNode.setAttribute('id','table');
    		newNode.innerHTML =str;
    		oTest.insertBefore(newNode,befNode);
		}
	});
	$("#khmccx").val("");
	$("#frxmcx").val("");
}

function saveKhxx(id) {
	 //msg = "确定选择？";
    //if (confirm(msg)) {
   	 var url = "<%=path%>/khgl/YKhKhxx/getJsfwglById";
    	 $.ajax({
    		cache : true,
    		type : "POST",
    		url : url,
    		data : {id:id},
    		async : false,
    		error : function(request) {
    			alert("选择失败,请联系管理员。");
    		},
    		success : function(data) {
    			khxx = data;
    			$("#khmc").val(data[0].KHMC);
    			$("#frdb").val(data[0].FRXM);
    			$("#lxdh").val(data[0].SJHM);
    			$("#khdz").val(data[0].KHDZ);
    			$('#myModalKhxx').modal('hide');
    		}
    	  });
    //}
}


//关闭客户窗口
function closeKhxx() {
    $('#myModalKhxx').modal('hide');
    var del = $("#table");
    del.remove();
}

	</script>
	</head>
<body>
		<div class="wrapper" style="height: 514px;">
		   <div class="panel" style="margin-bottom: 1px;">
		     <div class="panel-body">
		       <div style="text-align:center;margin-bottom:-2px"></div>
			     <form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
			     <c:forEach var="jsfw" items="${jsfw}" varStatus="obj">
			        <input type="hidden" name="id" id="id" value="${jsfw.id }">
			        <input type="hidden" name="syje" id="syje" value="${jsfw.syje }">
			        <input type="hidden" name="bfxyje" id="bfxyje" value="${jsfw.xykh}">
			        <input type="hidden" name="djrq" id="djrq" value="${jsfw.djrq}">
			         <input type="hidden" name="ks_id" id="ks_id1" value="${jsfw.ks_id }">
			          <input type="hidden" name="jyks_id" id="jyks_id1" value="${jsfw.jyks_id }">
			           <input type="hidden" name="yeks_id" id="yeks_id1" value="${jsfw.yeks_id }">
			           <input type="hidden" name="bfxybh" id="xybh" value="${jsfw.xybh}">
			        
			      <div class="panel-body" >
					   <label class="col-sm-2 col-sm-2 control-label" >协议编号：</label>
					   <div class="col-sm-10" > 
						 <input class="form-control" type="text" id="xybh" name="xybh" value="${jsfw.xybh }" required data-msg-required="协议编号不能为空" style="height:28px;"
								minlength="1" data-msg-minlength="不能为空">
					   </div>
			           <label class="col-sm-2 col-sm-2 control-label" >客户名称：</label>
					   <div class="col-sm-10" >
						  <input class="form-control" type="text" id="khmc"  name="khmc" value="${jsfw.khmc }" required data-msg-required="客户名称不能为空" style="height:28px;"
								minlength="1" data-msg-minlength="不能为空">
					   </div>
					    <div class="col-sm-10" style="width: 6%;margin-top: 6px;"">
					    <a href="#myModalKhxx" style="width: 62%;margin-top:-3px;"data-toggle="modal" type="button" onClick="getKhxx();">请选择</a>
                        </div>
					   <label class="col-sm-2 col-sm-2 control-label" style="width: 7%;" >客户地址：</label>
					   <div class="col-sm-10" >
					      <input class="form-control" type="text" id="khdz"  name="khdz" value="${jsfw.khdz }" style="height:28px;">
					   </div>
			     </div>
			
			       <div class="panel-body" >
				        <label class="col-sm-2 col-sm-2 control-label" >法人代表：</label>
						<div class="col-sm-10" >
							<input class="form-control" type="text" id="frdb" name="frdb" value="${jsfw.frdb }" style="height:28px;">
						</div>
						<label class="col-sm-2 col-sm-2 control-label" >联系电话：</label>
						<div class="col-sm-10" >
							<input class="form-control" type="text" id="lxdh"  name="lxdh" value="${jsfw.lxdh }" style="height:28px;">
						</div>
						<label class="col-sm-2 col-sm-2 control-label" >涉及产品名称：</label>
						<div class="col-sm-10" >
							<input class="form-control" type="text" id="cpmc" name="cpmc" value="${jsfw.cpmc }" style="height:28px;">
				        </div>
			    </div>

			     <div class="panel-body" >
						<label class="col-sm-2 col-sm-2 control-label" >服务项目：</label>
						<div class="col-sm-10" >
							<input class="form-control" type="text" id="fwxm"  name="fwxm" value="${jsfw.fwxm }" style="height:28px;">
						</div>
						<label class="col-sm-2 col-sm-2 control-label" >协议类型：</label>
						<div class="col-sm-10" >
							<input class="form-control" type="text" id="xylx" name="xylx" value="${jsfw.xylx }" style="height:28px;">
						</div>
						
						 <label class="col-sm-2 col-sm-2 control-label" >付款方式：</label>
					    <div class="col-sm-10" >
							<c:if test="${jsfw.fkfs != null}">
							<select id="selectedRoleId" class="form-control" name="fkfs">
                            <c:forEach items="${fkfs}" var="fkfs">
                                <c:choose>
                                         <c:when test="${fkfs.zdz == jsfw.fkfs}">
                                               <option selected = "selected" value="${fkfs.zdz}">${fkfs.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${fkfs.zdz}">${fkfs.zdmc}</option>
                                         </c:otherwise>
                               </c:choose>
                           </c:forEach> 
                           </select>
                           </c:if>
                           <c:if test="${jsfw.fkfs == null}">
                           <select class="form-control input-lg m-bot15" name="fkfs" style="padding-left: 2px;" >
								<option selected="selected" value="">请选择...</option>
								<c:forEach var="fkfs" items="${fkfs}" varStatus="obj">
										<option value="${fkfs.zdz }">${fkfs.zdmc }</option>
								</c:forEach>
					        </select>
                           </c:if>
					    </div>
						
			    </div>
			
			      <div class="panel-body" >
						<label class="col-sm-2 col-sm-2 control-label" >生效日期：</label>
					    <div class="col-sm-10" >
						   <input class="form-control Wdate" type="text" id="sxrq" style="height:28px;" name="sxrq" value="${jsfw.sxrq }" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" required data-msg-required="生效日期不能为空"
								minlength="1" data-msg-minlength="不能为空">
					    </div>
					    <label class="col-sm-2 col-sm-2 control-label" >终止日期：</label>
					    <div class="col-sm-10" >
						   <input class="form-control Wdate" type="text" id="zzrq" name="zzrq" style="height:28px;" value="${jsfw.zzrq }" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" required data-msg-required="终止日期不能为空"
								minlength="1" data-msg-minlength="不能为空">
					    </div>
					    <label class="col-sm-2 col-sm-2 control-label" >协议金额：</label>
					    <div class="col-sm-10" >
						<input class="form-control" type="text" id="xykh" name="xykh" value="${jsfw.xykh }" style="height:28px;">
					    </div>
			    </div>
			    <div class="panel-body" >
				   <label class="col-sm-2 col-sm-2 control-label" >项目联系人：</label>
				   <div class="col-sm-10" >
					    <input class="form-control" type="text" id="xmlxr" name="xmlxr" style="height:28px;" value="${jsfw.xmlxr }">
				   </div>
				   <label class="col-sm-2 col-sm-2 control-label" >项目电话：</label>
				   <div class="col-sm-10" >
					    <input class="form-control" type="text" id="dhhm" name="dhhm" style="height:28px;" value="${jsfw.dhhm }">
				   </div>
			   </div>
			     <div class="panel-body" >
					   <label class="col-sm-2 col-sm-2 control-label" >协议摘要：</label>
					   <div class="col-sm-13">
					   <textarea class="form-control ckeditor textarea" rows="3" id="xyzy" name="xyzy" 
							truetype="textarea" style="width: 100%;margin-top: 5px;" 
							maxlength="120" data-msg-maxlength="最多输入120个字">${jsfw.xyzy }</textarea>
					   </div>
			    </div>
			     <div class="panel-body" >
					   <label class="col-sm-2 col-sm-2 control-label" >执行标准：</label>
					   <div class="col-sm-10" >
					      <input class="form-control" id="bz_id" name="bz_id" value="${jsfw.bz_id }" style="height:28px;" >
				       </div>
				       <label class="col-sm-2 col-sm-2 control-label" >已出具检验批次报告编号：</label>
					   <div class="col-sm-10" >
					      <input class="form-control"  id="jybh_id" name="jybh_id" value="${jsfw.jybh_id }" style="height:28px;" >
					   </div>
					   <label class="col-sm-2 col-sm-2 control-label" >客户经济类型及规模：</label>
					   <div class="col-sm-10" >
						 <input class="form-control" id="khjlgm" name="khjlgm" value="${jsfw.khjlgm }"  style="height:28px;">
					   </div>
			    </div>
			    
                  <div class="panel-body" >
					    <label class="col-sm-2 col-sm-2 control-label" >客户已获取证情况：</label>
					    <div class="col-sm-10" >
						   <input class="form-control"  id="khhz_info"  name="khhz_info" value="${jsfw.khhz_info }" style="height:28px;" >
					    </div>
					    <label class="col-sm-2 col-sm-2 control-label" >协议负责人：</label>
					    <div class="col-sm-10" >
						   <input class="form-control" id="xyfzr" name="xyfzr" value="${jsfw.xyfzr }" style="height:28px;">
					    </div>
			    </div>
			
			
			 <div class="panel-body" >
					   <label class="col-sm-2 col-sm-2 control-label" >协议科室：</label>
					    <div class="col-sm-10" >
						 <input id="ks_id" name="ks_id1" class="easyui-combotree" value="${jsfw.ksmc1}" style="width:221%;height: 34px;"/>
					    </div>
					    
					    <label class="col-sm-2 col-sm-2 control-label" >检验科室：</label>
					    <div class="col-sm-10" >
					       <input id="jyks_id" name="jyks_id1" value="${jsfw.ksmc2 }" class="easyui-combotree" value="1" style="width:221%;height: 34px;"/>
					    </div>
					    
					    <label class="col-sm-2 col-sm-2 control-label" >业务科室：</label>
					    <div class="col-sm-10" >
					       <input id="yeks_id" name="yeks_id1" value="${jsfw.ksmc3}" class="easyui-combotree" value="1" style="width:221%;height: 34px;"/>
				        </div>
			   </div>
			   
                <div class="panel-body" >
					 <label class="col-sm-2 col-sm-2 control-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
					 <div class="col-sm-13">
					 <textarea class="form-control ckeditor textarea" rows="6" id="bz" name="bz"  
							truetype="textarea" style="width: 100%;height: 65px;margin-top: 5px;" 
							maxlength="120" data-msg-maxlength="最多输入120个字">${jsfw.bz }</textarea>
					 </div>
			   </div>
			   <div style="text-align: center" >
				  <div class="form-group" style="margin-top: 31px;margin-left: 100px; width: 80%;">
					<input class="btn btn-success" value="提交" type="submit" >
                    <input class="btn btn-success" type="button" onclick="self.close();" value="关闭">
				</div>
			    </div>
			  </c:forEach>
			</form>
		</div>
	</div>
 </div>
</body>
<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalKhxx" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <!-- <form class="form-horizontal" role="form"> -->
                <section class="panel" id="sectKhxx">
                    <header class="panel-heading">选择委托单位</header>
                    <label style="margin-left: 6px;">客户名称:</label>&nbsp;&nbsp;&nbsp;<input id="khmccx" name="khmccx">&nbsp;&nbsp;&nbsp;
                    <label>法人姓名:</label>&nbsp;&nbsp;&nbsp;<input id="frxmcx" name="frxmcx">
                    <button onClick="getKhxx();">查询</button>
                    <span id="sbzKhxx"></span>
                    <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
                        <div class="col-lg-offset-2 col-lg-10" style="margin-top: 40px;">
                            <button type="button" class="btn btn-default" onClick="closeKhxx();"
                                    style="margin-left: 20px;">取消
                            </button>
                        </div>
                    </div>
                </section>
                <!-- </form> -->
            </div>
        </div>
    </div>
</div>

</html>
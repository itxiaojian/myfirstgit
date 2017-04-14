<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
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
		});
		
		$('#jyks_id').combotree({
			 url: '<%=path%>/test/xlsList?optype=getchildtree&id=100250',
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

$(function(){
	//jquery.validate
	$("#myForm").validate({
		submitHandler: function() {
			//验证通过后 的js代码写在这里
          msg = "确定要提交？";
          if (confirm(msg)) {
              var url = "<%=path%>/jsfwgl/YjsfwXyxx/save";
              $.ajax({
                  cache: true,
                  type: "POST",
                  url: url,
                  data: $('#myForm').serialize(),// 你的formid
                  async: false,
                  error: function (request) {
                      alert("保存失败,请联系管理员。");
                  },
                  success : function(data) {
      				alert('保存成功！');
      				var PAGESIZE = 20;
      				window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      	            window.parent.ACT_DEAL_WINDOW.close();
      			}
              });
          }
		}
	})
}) 

//下面是一些常用的验证规则扩展

	/*-------------验证插件配置 懒人建站http://www.51xuediannao.com/-------------*/

	//配置错误提示的节点，默认为label，这里配置成 span （errorElement:'span'）
	$.validator.setDefaults({
		errorElement:'span'
	});

	//配置通用的默认提示语
	$.extend($.validator.messages, {
		required: '必填',
		equalTo: "请再次输入相同的值"
	});

	/*-------------扩展验证规则 懒人建站http://www.51xuediannao.com/-------------*/
	//邮箱
	jQuery.validator.addMethod("mail", function (value, element) {
		var mail = /^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$/;
		return this.optional(element) || (mail.test(value));
	}, "邮箱格式不对");

	//电话验证规则
	jQuery.validator.addMethod("phone", function (value, element) {
		var phone = /^0\d{2,3}-\d{7,8}$/;
		return this.optional(element) || (phone.test(value));
	}, "电话格式如：0371-68787027");

	//区号验证规则
	jQuery.validator.addMethod("ac", function (value, element) {
		var ac = /^0\d{2,3}$/;
		return this.optional(element) || (ac.test(value));
	}, "区号如：010或0371");

	//无区号电话验证规则 
	jQuery.validator.addMethod("noactel", function (value, element) {
		var noactel = /^\d{7,8}$/;
		return this.optional(element) || (noactel.test(value));
	}, "电话格式如：68787027");

	//手机验证规则
	jQuery.validator.addMethod("mobile", function (value, element) {
		var mobile = /^1[3|4|5|7|8]\d{9}$/;
		return this.optional(element) || (mobile.test(value));
	}, "手机格式不对");

	//邮箱或手机验证规则
	jQuery.validator.addMethod("mm", function (value, element) {
		var mm = /^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/;
		return this.optional(element) || (mm.test(value));
	}, "格式不对");

	//电话或手机验证规则
	jQuery.validator.addMethod("tm", function (value, element) {
		var tm=/(^1[3|4|5|7|8]\d{9}$)|(^\d{3,4}-\d{7,8}$)|(^\d{7,8}$)|(^\d{3,4}-\d{7,8}-\d{1,4}$)|(^\d{7,8}-\d{1,4}$)/;
		return this.optional(element) || (tm.test(value));
	}, "格式不对");

	//年龄
	jQuery.validator.addMethod("age", function(value, element) {
		var age = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
		return this.optional(element) || (age.test(value));
	}, "不能超过120岁");
	///// 20-60   /^([2-5]\d)|60$/

	//传真
	jQuery.validator.addMethod("fax",function(value,element){
		var fax = /^(\d{3,4})?[-]?\d{7,8}$/;
		return this.optional(element) || (fax.test(value));
	},"传真格式如：0371-68787027");

	//验证当前值和目标val的值相等 相等返回为 false
	jQuery.validator.addMethod("equalTo2",function(value, element){
		var returnVal = true;
		var id = $(element).attr("data-rule-equalto2");
		var targetVal = $(id).val();
		if(value === targetVal){
			returnVal = false;
		}
		return returnVal;
	},"不能和原始密码相同");

	//大于指定数
	jQuery.validator.addMethod("gt",function(value, element){
		var returnVal = false;
		var gt = $(element).data("gt");
		if(value > gt && value != ""){
			returnVal = true;
		}
		return returnVal;
	},"不能小于0 或空");

	//汉字
	jQuery.validator.addMethod("chinese", function (value, element) {
		var chinese = /^[\u4E00-\u9FFF]+$/;
		return this.optional(element) || (chinese.test(value));
	}, "格式不对");

	//指定数字的整数倍
	jQuery.validator.addMethod("times", function (value, element) {
		var returnVal = true;
		var base=$(element).attr('data-rule-times');
		if(value%base!=0){
			returnVal=false;
		}
		return returnVal;
	}, "必须是发布赏金的整数倍");

	//身份证
	jQuery.validator.addMethod("idCard", function (value, element) {
		var isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;//(15位)
		var isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;//(18位)

		return this.optional(element) || (isIDCard1.test(value)) || (isIDCard2.test(value));
	}, "格式不对");
//提交
<%-- function save() {
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/jsfwgl/YjsfwXyxx/save";
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : $('#myForm').serialize(),// 你的formid
			async : false,
			error : function(request) {
				alert("保存失败,请联系管理员。");
			},
			success : function(data) {
				alert('保存成功！');
				var PAGESIZE = 20;
				window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	            window.parent.ACT_DEAL_WINDOW.close();
			}
		});
	}
}  --%>

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
		<div class="wrapper">
		   <div class="panel" style="margin-bottom: 1px;">
		     <div class="panel-body">
		       <div style="text-align:center;margin-bottom:-2px"></div>
			     <form action="" class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
			
			      <div class="panel-body" >
					 <label class="col-sm-2 col-sm-2 control-label" ><span style="color:red;">*</span>协议编号：</label>
					 <div class="col-sm-10" >
						<input class="form-control" style="height:28px;" type="text" name="xybh" required data-msg-required="协议编号不能为空" minlength="1" data-msg-minlength="协议编号不能为空">
					 </div>
					 
			         <label class="col-sm-2 col-sm-2 control-label"  ><span style="color:red;">*</span>客户名称</label>
					 <div class="col-sm-10" >
						<input class="form-control" style="height:28px;" type="text"  name="khmc" id="khmc" required data-msg-required="客户名称不能为空" minlength="1" data-msg-minlength="客户名称不能为空">
					 </div>
					 <div class="col-sm-10" style="width: 6%;margin-top: 6px;"">
					    <a href="#myModalKhxx" style="width: 62%;margin-top:-3px;"data-toggle="modal" type="button" onClick="getKhxx();">请选择</a>
                     </div>
					 
					 <label class="col-sm-2 col-sm-2 control-label" style="width: 7%;" >客户地址：</label>
					 <div class="col-sm-10" >
						<input class="form-control" type="text" id="khdz"  name="khdz" style="height:28px;">
					 </div>
			     </div>
			
			     <div class="panel-body" >
			        <label class="col-sm-2 col-sm-2 control-label" >法人代表：</label>
					<div class="col-sm-10" >
						<input class="form-control" type="text"  name="frdb" id="frdb" style="height:28px;">
					</div>
					<label class="col-sm-2 col-sm-2 control-label" >联系电话：</label>
					<div class="col-sm-10" >
						<input class="form-control" type="text"   name="lxdh" id="lxdh" style="height:28px;">
					</div>
					<label class="col-sm-2 col-sm-2 control-label" >涉及产品名称：</label>
					<div class="col-sm-10" >
						<input class="form-control" type="text"  name="cpmc" style="height:28px;">
			        </div>
			    </div>

			     <div class="panel-body" >
					<label class="col-sm-2 col-sm-2 control-label" >服务项目：</label>
					<div class="col-sm-10" >
						<input class="form-control" type="text"   name="fwxm" style="height:28px;">
					</div>
					<label class="col-sm-2 col-sm-2 control-label" >协议类型：</label>
					<div class="col-sm-10" >
						<input class="form-control" type="text"  name="xylx" style="height:28px;">
					</div>
					  <label class="col-sm-2 col-sm-2 control-label" >付款方式：</label>
				    <div class="col-sm-10" >
						<select class="form-control input-lg m-bot15" name="fkfs" style=" height:28px;margin-top:3px;">
							<option selected="selected" value="">请选择...</option>
							<c:forEach var="fkfs" items="${fkfs}" varStatus="obj" >
										<option value="${fkfs.zdz }">${fkfs.zdmc }</option>
							</c:forEach>
						</select>
				    </div>
					
			    </div>
			
			   <div class="panel-body" >
				  <label class="col-sm-2 col-sm-2 control-label" ><span style="color:red;">*</span>生效日期：</label>
                  <div class="col-sm-10" >
                  <input class="form-control Wdate" type="text" id="sxrq" name="sxrq" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="height:28px;" required data-msg-required="生效日期不能为空" minlength="1" data-msg-minlength="生效日期不能为空">
                  </div>
				    
				    <label class="col-sm-2 col-sm-2 control-label" ><span style="color:red;">*</span>终止日期：</label>
				    <div class="col-sm-10" >
					   <input class="form-control Wdate" type="text" style="height:28px;" name="zzrq" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" required data-msg-required="终止日期不能为空" minlength="1" data-msg-minlength="终止日期不能为空">
				    </div>
				    
				    <label class="col-sm-2 col-sm-2 control-label" >协议金额：</label>
				   <div class="col-sm-10" >
					<input class="form-control" type="text"  name="xykh" style="height:28px;">
				   </div>
			   </div>
			   
			   <div class="panel-body" >
				   <label class="col-sm-2 col-sm-2 control-label" >项目联系人：</label>
				   <div class="col-sm-10" >
					    <input class="form-control" type="text" id="xmlxr" name="xmlxr" style="height:28px;">
				   </div>
				   <label class="col-sm-2 col-sm-2 control-label" >项目电话：</label>
				   <div class="col-sm-10" >
					    <input class="form-control" type="text" id="dhhm" name="dhhm" style="height:28px;">
				   </div>
			   </div>
			   
			   <div class="panel-body" >
				   <label class="col-sm-2 col-sm-2 control-label" >协议摘要：</label>
				   <div class="col-sm-13">
				   <textarea class="form-control ckeditor textarea" rows="3" name="xyzy" 
						truetype="textarea" style="width: 100%;margin-top: 5px;"
						maxlength="120" data-msg-maxlength="最多输入120个字" ></textarea>
				   </div>
			   </div>
			    <div class="panel-body" >
				   <label class="col-sm-2 col-sm-2 control-label" >执行标准：</label>
				   <div class="col-sm-10" >
				      <input class="form-control"  name="bz_id" style="height:28px;">
			       </div>
			       <label class="col-sm-2 col-sm-2 control-label" >已出具检验批次报告编号：</label>
				   <div class="col-sm-10" >
				      <input class="form-control"  name="jybh_id" style="height:28px;">
				   </div>
				   <label class="col-sm-2 col-sm-2 control-label" >客户经济类型及规模：</label>
				   <div class="col-sm-10" >
					 <input class="form-control"  name="khjlgm" style="height:28px;">
				   </div>
			    </div>
			    
                 <div class="panel-body" >
				    <label class="col-sm-2 col-sm-2 control-label" >客户已获取证情况：</label>
				    <div class="col-sm-10" >
					   <input class="form-control"  name="khhz_info" style="height:28px;">
				    </div>
				    <label class="col-sm-2 col-sm-2 control-label" >协议负责人：</label>
				    <div class="col-sm-10" >
					   <input class="form-control"  name="xyfzr"  style="height:28px;">
				    </div>
				    
			    </div>
			    
			    <div class="panel-body" >
				    <label class="col-sm-2 col-sm-2 control-label" >协议科室：</label>
				   <div class="col-sm-10" >
					 <input id="ks_id" name="ks_id" class="easyui-combotree" value=" " style="padding-bottom: 2px;  width: 221%;">
				   </div>
				    <label class="col-sm-2 col-sm-2 control-label" >检验科室：</label>
				    <div class="col-sm-10" >
				       <input id="jyks_id" name="jyks_id" class="easyui-combotree" value=" " style="padding-bottom: 2px; width: 221%;">
				    </div>
				    <label class="col-sm-2 col-sm-2 control-label" >业务科室：</label>
				    <div class="col-sm-10" >
				       <input id="yeks_id" name="yeks_id" class="easyui-combotree" value=" " style="padding-bottom: 2px; width: 221%;">
			        </div>
			   </div>
               <div class="panel-body" >
				 <label class="col-sm-2 col-sm-2 control-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
				 <div class="col-sm-13">
				 <textarea class="form-control ckeditor textarea" rows="3" name="bz" 
						truetype="textarea" style="width: 100%;height: 65px;margin-top: 5px;" 
						maxlength="120" data-msg-maxlength="最多输入120个字"></textarea>
				 </div>
			  </div>
			  <div style="text-align: center" >
				<div class="form-group" style="margin-top: 5px;margin-left: 100px; width: 80%;">
					<input class="btn btn-success" value="提交" type="submit" >
                    <input class="btn btn-success" type="button" onclick="self.close();" value="关闭">
				</div>
			    </div>
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
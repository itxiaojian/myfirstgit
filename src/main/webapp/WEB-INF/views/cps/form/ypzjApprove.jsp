<%@page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/taglib.jsp" %>
<% String path = request.getContextPath();
String bgbh = request.getParameter("bgbh");
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
    <script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
    
<%--     <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script> --%>
<%--     <script type="text/javascript" src="<%=path%>/resources/datePicker/WdatePicker.js"></script> --%>
<%--     <script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.qrcode.min.js"></script> --%>
<%--     <script language="javascript" src="<%=path%>/resources/lodop/LodopFuncs.js"></script> --%>
    
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/upload.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css">
<%--     <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css"> --%>
<%--     <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css"> --%>
    
    <script type="text/javascript" src="<%=path%>/resources/js/yz/jquery.validate.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/yz/yzstyle.css">
    
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/DialogBySHF.css">
    <script type="text/javascript" src="<%=path%>/resources/css/jygl/DialogBySHF.js"></script>
    <script>
   
   	//var finaBgbh = document.getElementById("bgbh").value;
	$(function(){
		//jquery.validate
		$("#myForm").validate({
			submitHandler: function() {
				//验证通过后 的js代码写在这里
			  if ($("#jyksbh").val() == "") {
                  alert("请选择检验科室！");
                  return false;
              }
              if ($("#zh").val() == "") {
                  alert("请选择字号！");
                  return false;
              }
              if ($("#ywksbh").val() == "") {
                  alert("请选择业务科室！");
                  return false;
              }
              if ($("#ypmc").val() == "") {
                alert("请填写样品名称！");
                return false;
              }
              if ($("#jylx").val() == "") {
                  alert("请选择检验类型！");
                  return false;
              }
              
        	  msg = "确定要修改？";
              if (confirm(msg)) {
              	if (changeButton=="0"){
  	                var url = "<%=path%>/ypgl/YYpYpxx/update";
              	}else {
              		var url = "<%=path%>/ypgl/YYpYpxx/save";
              	}
              	var bgbhNum = document.getElementById("bgbh").value;
            	$(".sfmxBgbh").val(bgbhNum);
                $.ajax({
                    cache: true,
                    type: "POST",
                    url: url,
                    data: $('#myForm').serialize(),// 你的formid
                    async: false,
                    error: function (request) {
                        alert("保存失败,请联系管理员。");
                    },
                    success: function (data) {
                        sfTj = 1;
                        //alert('提交成功！');
                       /*  var PAGESIZE = 20;
                        window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
                        window.parent.ACT_DEAL_WINDOW.close(); */
                        <%-- location.href = "<%=path%>/ypgl/YYpYpxx/YpxxPage"; --%>
                        $("#bgbh1").val(bgbhNum);
                        var url = "<%=path%>/ypgl/YYpSfxmmx/save";
                        $.ajax({
                            cache: true,
                            type: "POST",
                            url: url,
                            data: $('#xmForm').serialize(),// 你的formid
                            async: false,
                            error: function (request) {
                                alert("保存失败,请联系管理员。");
                            },
                            success: function (data) {
                            	alert('提交成功！');
                            	var del = $("#table");
                                del.remove();
                                $("#cpmccx").val("");
                                $("#xmmccx").val("");
                                $('#myModal').modal('hide');
                                document.getElementById('Div1').style.height='0px';
                                $('#mcxs').val('');
                                checked.splice(0,checked.length);
                                checkedJe.splice(0,checkedJe.length);
                                yxxms=0;
                                window.opener.location.reload();
                            }
                        });
                        window.close();
                    }
                });
           	} 
		  }
		});
	});
             
	
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
	</script>
	
    <script type="text/javascript">
        
        //根据后台传的值默认选中单选按钮
        function initradio(rName,rValue){
            var rObj = document.getElementsByName(rName);

            for(var i = 0;i < rObj.length;i++){
                if(rObj[i].value == rValue){
                    rObj[i].checked =  'checked';
                }
            }
        }
        //返回
        function exit() {
            /* var PAGESIZE = 20;
             window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
            var close =window.parent.ACT_DEAL_WINDOW;
            if(close==undefined){
                this.close();
            }else{
                window.parent.ACT_DEAL_WINDOW.close();
            }
            <%-- location.href = "<%=path%>/ypgl/YYpYpxx/YpxxPage"; --%>
        }

        //获取上传文件名
        function getFile(obj,inputName){
        	var file_name = $(obj).val();
        	$("input[name='"+inputName+"']").val(file_name);
        	$("#fj").val(file_name);
        	ajaxFileUpload();
        }
      	
        function ajaxFileUpload() {
            $.ajaxFileUpload({
                url : '<%=path%>/ypgl/upload/tempimg', //用于文件上传的服务器端请求地址
                secureuri : false, //一般设置为false
                fileElementId : 'attachMentFile', //文件上传空间的id属性  <input type="file" id="file" name="file" />
                type : 'post',
                dataType : 'HTML', //返回值类型 一般设置为json
                success : function(data, status) //服务器成功响应处理函数
                {
                    /* $("#img1").attr("src", data);
                    $("#fileName").val(data);
                    $("#file1").val(""); */
                    if (typeof (data.error) != 'undefined') {
                        if (data.error != '') {
                            alert(data.error);
                        } else {
                            alert(data.msg);
                        }
                    }
                },
                error : function(data, status, e)//服务器响应失败处理函数
                {
                    alert(e);
                }
            })
            return false;
        }

        var sfTj = 0;
        var LODOP; //声明为全局变量      
        function PrintOneURL() {
            var ypbh = $("#ypbh").val();
            if (sfTj == 1) {
                LODOP = getLodop();
                LODOP.PRINT_INIT("流转单");
                LODOP.ADD_PRINT_URL(30, 20, 746, "95%", 'YpLzdPage?ypbh=' + ypbh);
// 				LODOP.ADD_PRINT_URL(30,20,746,"95%",'YpLzdPage?ypbh=2015DQ00003');
                LODOP.SET_PRINT_STYLEA(0, "HOrient", 3);
                LODOP.SET_PRINT_STYLEA(0, "VOrient", 3);
                //		LODOP.SET_SHOW_MODE("MESSAGE_GETING_URL",""); //该语句隐藏进度条或修改提示信息
                //		LODOP.SET_SHOW_MODE("MESSAGE_PARSING_URL","");//该语句隐藏进度条或修改提示信息
                LODOP.PREVIEW();
            } else {
                alert('请提交保存后再打印流转单。');
            }
        }
        
        function onPrintXysClick() {           //打印协议书
        	var ypbh = $("#ypbh").val();
        	if (sfTj == 1) {
	    		LODOP=getLodop();  
	    		LODOP.PRINT_INIT("委托协议书");
	    		LODOP.ADD_PRINT_URL(30,20,746,"95%",'YpJyxysPage?ypbh='+ypbh);
	//     		LODOP.ADD_PRINT_URL(30,20,746,"95%",'YpJyxysPage?ypbh=2015DQ00003');
	    		LODOP.SET_PRINT_STYLEA(0,"HOrient",3);
	    		LODOP.SET_PRINT_STYLEA(0,"VOrient",3);
	    		//	LODOP.SET_SHOW_MODE("MESSAGE_GETING_URL",""); //该语句隐藏进度条或修改提示信息
	    		//	LODOP.SET_SHOW_MODE("MESSAGE_PARSING_URL","");//该语句隐藏进度条或修改提示信息
	    		LODOP.PREVIEW();
        	} else {
                alert('请提交保存后再打印协议书！');
            }
        }
        
        function onPrintEwmClick() {           //打印二维码
        	var ypbh = $("#ypbh").val();
        	if (sfTj == 1) {
	    		/* LODOP=getLodop();  
	    		LODOP.PRINT_INIT("委托协议书");
	    		LODOP.ADD_PRINT_URL(30,20,746,"95%",'YpJyxysPage?ypbh='+ypbh);
	//     		LODOP.ADD_PRINT_URL(30,20,746,"95%",'YpJyxysPage?ypbh=2015DQ00003');
	    		LODOP.SET_PRINT_STYLEA(0,"HOrient",3);
	    		LODOP.SET_PRINT_STYLEA(0,"VOrient",3);
	    		//	LODOP.SET_SHOW_MODE("MESSAGE_GETING_URL",""); //该语句隐藏进度条或修改提示信息
	    		//	LODOP.SET_SHOW_MODE("MESSAGE_PARSING_URL","");//该语句隐藏进度条或修改提示信息
	    		LODOP.PREVIEW(); */
        		window.open('ypewmPage?ypbh='+ypbh,'样品标签','height=500px, width=600px,top=200px, left=300px, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
        	} else {
                alert('请提交保存后再打印二维码！');
            }
        }

        function getBh() {
        	if ($("#jyksbh").val() == "") {
                alert("请选择检验科室！");
                return false;
            }
            var jyksbh = document.getElementById("jyksbh").value;
            if (jyksbh == "") {
                alert("请先选择检验科室");
                return false;
            } else {
                var zhmc = document.getElementById("zh").value;
                //alert(zh);
                var url = "<%=path%>/ypgl/YYpYpxx/findZh";
                $.ajax({
                    cache: true,
                    type: "POST",
                    url: url,
                    data: {jyksbh: jyksbh, zhmc: zhmc},
                    async: false,
                    error: function (request) {
                        alert("编号生成失败,请联系管理员。");
                    },
                    success: function (data) {
                        //alert(data);
                        $("#ypbh").val(data);
                        $("#bgbh").val(data);
                        //alert("生成报告编号："+document.getElementById("ypbh").value);
                    }
                });

            }
        }

      //加载次数
        var jzcs=1;
        var checked=[];
        var checkedJe=[];
        //打开收费信息窗口
        function getSfxmmx(type) {
        	/* var bgbh = document.getElementById("bgbh").value;
        	if(bgbh==""){
        		alert("报告编号为空!");
        		return false;
        	} */
        	if(type=='1'){
        		jzcs++;
        	}else{
        		jzcs=1;
        	}
        	
            var url = "<%=path%>/ypgl/YYpYpxx/Sfxmmx";
            var cpmccx = document.getElementById("cpmccx").value;
            var xmmccx = document.getElementById("xmmccx").value;
            if((cpmccx!=""&&cpmccx!=null) || (xmmccx!=""&&xmmccx!=null)){
            	document.getElementById('Div1').style.height='320px'; 
	            $.ajax({
	                cache: true,
	                type: "POST",
	                url: url,
	                data: {cpmccx: cpmccx, xmmccx: xmmccx,jzcs:jzcs},
	                async: false,
	                error: function (request) {
	                    alert("选择失败,请联系管理员。");
	                },
	                success: function (data) {
	                    var del = $("#table");
	                    del.remove();
	                    var str = "<table><thead><tr><th style='width:90px'>产品名称</th><th style='width:100px;display:none'>项目编号</th><th style='width:100px'>项目名称</th><th style='width:50px'>单价金额</th><th style='width:50px'>计量单位</th>"
	                            + "<th style='width:30px'>操作</th></tr></thead><tbody>";
	                    for (var i = 0; i < data.length; i++) {
	                        str = str + "<tr id='" + data[i].ID + "' name='" + data[i].ID + "'><td style='width:90px'>" + data[i].CPMC + "</td><td style='width:100px;display:none'>" + data[i].XMBH + "</td>"+"</td><td style='width:100px'>" + data[i].XMMC + "</td>"
	                                + "<td style='width:50px'>" + data[i].DJ + "</td><td style='width:50px'>" + data[i].JLDW + "</td><td style='width:30px'><input "
	                                + "name='checkSfxmmx' id=check'"+data[i].ID+"' type='checkbox' onclick='getDj(this," + data[i].DJ + ",\""+ data[i].CPMC +"\",\""+data[i].XMBH+"\",\""+data[i].XMMC+"\",\""+data[i].JLDW+"\","+data[i].ID+");' ";
	                        for(var j=0;j<checked.length;j++){
	                        	if(data[i].ID==checked[j]){
		                        	str = str + "checked='checked' ";
	                        	}
	                        }
	                        str = str + "value = '" + data[i].ID + "'/></td></tr>";
	                    }
	                    str = str + "</tbody><table>";
// 	                    var oTest = document.getElementById("sect");
	                    var oTest = document.getElementById("Div1");
	                    var newNode = document.createElement("table");
// 	                    var befNode = document.getElementById("sbz");
	                    newNode.setAttribute('class', 'table');
	                    newNode.setAttribute('id', 'table');
	                    newNode.innerHTML = str;
// 	                    oTest.insertBefore(newNode, befNode);
	                    oTest.insertBefore(newNode, null);
	                    /* for (var i = 0; i < data.length; i++) {
		                    for(var a=0;a<checked.length;a++){ 
	                        	if(data[i].ID==checked[a]){
		                        	$('#in'+data[i].ID).val(checkedJe[a]);
	                        	}
	                        }
	                    } */
	                }
	            });
            }else {
            	alert("请输入查询条件！");
            	return false;
            }
        }
        
        var num=${ysfxmLen};
        //alert(num);
        
        function getDj(obj,dj,cpmc,xmbh,xmmc,jldw,id){
        	if(obj.checked==true){
        		num++;
            	var oTest = document.getElementById("mybody");
            	var newNode = document.createElement("tr");
            	newNode.setAttribute('id','mybody'+id);
            	newNode.style.marginLeft="12%";
            	newNode.innerHTML ="<tr><td>"+cpmc+"<input type='text' type='hidden' class='hidden' id='cpmc"+num+"' name='cpmc"+num+"' value='"+cpmc+"'/></td>"
            		+"<td>"+xmmc+"<input type='text' type='hidden' class='hidden' id='xmmc"+num+"' name='xmmc"+num+"' value='"+xmmc+"'/></td>"
            		+"<td style='display: none'><input type='text' type='hidden' class='hidden' id='xmbh"+num+"' name='xmbh"+num+"' value='"+xmbh+"'/></td>"
            		+"<td>"+dj+"<input type='text' type='hidden' class='hidden' id='dj"+num+"' name='dj"+num+"' value='"+dj+"'/></td>"
            		+"<td>"+jldw+"<input type='text' type='hidden' class='hidden' id='jldw"+num+"' name='jldw"+num+"' value='"+jldw+"'/></td>"
            		+"<td><input type='text' style='width:40px' class='jycs' id='sl"+num+"' name='sl"+num+"' value='1' onblur='getXgje("+num+");'/></td>"
            		+"<td><input type='text' style='width:40px' class='xgje' id='xgje"+num+"' name='xgje"+num+"' value='"+dj+"' /></td>"
            		+"<td><a href='javascript:;' onclick='deleteTr("+id+");'>"
            		+"<span  style='text-align: right;' >"
            		+"<img src='<%=path%>/resources/images/iconfont-shanchu.png' alt='删除' height='25px' width='25px' style='margin-bottom: 5px;'/>"
            		+"</span></a></td>"
            		+"</tr>"
            	oTest.insertBefore(newNode,null);
            	
            		
        		var ycoTest = document.getElementById("ycmybody");
               	var ycnewNode = document.createElement("tr");
               	ycnewNode.setAttribute('id','ycmybody'+id);
               	ycnewNode.innerHTML ="<tr><td style='text-align: center'>"+cpmc+"</td>"
               		+"<td style='text-align: center'>"+xmmc+"</td>"
               		+"<td style='text-align: center'>"+xmbh+"</td>"
               		+"<td style='text-align: center'>"+dj+"</td>"
               		+"<td style='text-align: center'>"+jldw+"</td>"
               		+"<td style='text-align: center' id='ycsl"+num+"'>1</td>"
               		+"<td style='text-align: center' id='ycxgje"+num+"'>"+dj+"</td>"
               		+"</tr>"
               	ycoTest.insertBefore(ycnewNode,null);	
        	}else{
        		deleteTr(id)
        	}
        }
        
        function getXgje(num){
        	var djje = $('#dj'+num).val();
        	var jycs = $('#sl'+num).val();
        	if(jycs!=null&&jycs!=""){
        		var djhj = parseInt(djje)*parseInt(jycs);
            	$('#xgje'+num).val(djhj);
            	$('#ycsl'+num).val(jycs);
            	$('#ycxgje'+num).val(djhj); 
            	
            	document.getElementById("ycsl"+num).innerHTML = jycs;
            	document.getElementById("ycxgje"+num).innerHTML = djhj;
        	}
        	
        }
        //删除行
        function deleteTr(trId){
       		var del = $("#mybody"+trId);
   			del.remove();
   			
   			var del = $("#ycmybody"+trId);
   			del.remove();
        }
        
        var flag = false;
        //选择收费明细
        function selectSfxmmx() {
            var yxxms=0;
            var jyfy=0;
            $(".xgje").each(function(){
                    //alert($(this).val());
                    yxxms++;
                    jyfy+=parseInt($(this).val());
                });
            
            if(yxxms>0){
            	var cswk=false;
            	$(".jycs").each(function(){
                    if($(this).val()==null || $(this).val()==""){
                    	cswk=true;
                    	return false;
                    }
                });
            	if(cswk){
            		alert("请输入检验次数!");
            	}else{
            		var dx = DX(yxxms);
                    $("#jyxm").val('共'+dx+'项【详见附页】');
                    $("#jyfy").val(jyfy);
                    document.getElementById("num").value = num;
                    $('#myModal').modal('hide');
            	}
            	
            }else{
                $("#jyxm").val('共 项【详见附页】');
                $("#jyfy").val(0);
                $('#myModal').modal('hide');
            }
        }
        
        //关闭收费窗口
        function closeWin() {
            /* var del = $("#table");
            del.remove(); */
            $('#myModal').modal('hide');
            document.getElementById('Div1').style.height='0px';
            $('#mcxs').val('');
            /* checked.splice(0,checked.length);
            checkedJe.splice(0,checkedJe.length); */
            //yxxms=0;
        }
        
        //打开客户信息窗口
        function getKhxx() {
        	var del = $("#table");
            del.remove();
        	var khmccx = document.getElementById("khmccx").value;
            var khflcx = document.getElementById("khflcx").value;
        	var url = "<%=path%>/khgl/YKhKhxx/getKhxx";
        	$.ajax({
        		cache : true,
        		type : "POST",
        		url : url,
        		data : {khmccx:khmccx,khflcx:khflcx},
        		async : false,
        		error : function(request) {
        			alert("选择失败,请联系管理员。");
        		},
        		success : function(data) {
        			var del = $("#table");
        			del.remove();
                	var str="<table><thead><tr><th>客户名称</th><th>客户分类</th><th>单位性质</th>"
        				   +"<th>操作</th></tr></thead><tbody>";
                	for(var i=0;i<data.length;i++){
                		str=str+"<tr id='"+data[i].ID+"'><td>"+data[i].KHMC+"</td><td>"+data[i].KHFL
                		+"</td><td>"+data[i].DWXZ+"</td><td><input type ='button' onClick='saveKhxx("+data[i].ID+");' value='选择'></td>";
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
        	$("#khflcx").val("");
        } 
        
        var khxx = null;
        //选择委托单位
        function saveKhxx(id) {
        	/*  msg = "确定选择？";
             if (confirm(msg)) { */
	        	 var url = "<%=path%>/khgl/YKhKhxx/getKhxxById";
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
	         			//alert(data[0].KHMC);
	         			khxx = data;
	         			$("#wtdw").val(data[0].KHMC);
	         			$("#wtdwdz").val(data[0].KHDZ);
	         			$("#wtlxr").val(data[0].LXR);
	         			$("#sjhm").val(data[0].SJHM1);
	         			$("#wtdwgddh").val(data[0].GDDH1);
	         			$('#myModalKhxx').modal('hide');
	         		}
	         	  });
             }
        /* } */
        
        //选择受检单位
        function getSjdw() {
        	var wtdw1 = document.getElementById("wtdw").value;
           	$("#sjdw").val(wtdw1);
           	var wtdwdz1 = document.getElementById("wtdwdz").value;
           	$("#sjdwdz").val(wtdwdz1);
           	var wtdwlxr1 = document.getElementById("wtlxr").value;
           	$("#lxr").val(wtdwlxr1);
        	var sjhm1 = document.getElementById("sjhm").value;
           	$("#dh").val(sjhm1);
           	var wtdwdh1 = document.getElementById("wtdwgddh").value;
           	$("#sjdwgddh").val(wtdwdh1);
           	var wtdwyb1 = document.getElementById("wtyb").value;
           	$("#yb").val(wtdwyb1);
        }
        
        //选择生产单位
        function getScdw() {
           	var sjdw = document.getElementById("sjdw").value;
           	$("#scdw").val(sjdw);
           	var sjdwdz = document.getElementById("sjdwdz").value;
           	$("#scdwdz").val(sjdwdz);
           	var lxr = document.getElementById("lxr").value;
           	$("#scdwlxr").val(lxr);
           	var sjhm1 = document.getElementById("dh").value;
           	$("#scdwdh").val(sjhm1);
           	var dh = document.getElementById("sjdwgddh").value;
           	$("#scdwgddh").val(dh);
           	var yb = document.getElementById("yb").value;
           	$("#scdwyb").val(yb);
        }
        
        //关闭客户窗口
        function closeKhxx() {
	        $('#myModalKhxx').modal('hide');
	        var del = $("#table");
	        del.remove();
        }
        
      //打开协议信息窗口
        function getJyhth() {
        	var del = $("#table");
            del.remove();
        	var jyhthkhmc = document.getElementById("jyhthkhmc").value;
            var jyhthkhdz = document.getElementById("jyhthkhdz").value;
        	var url = "<%=path%>/jsfwgl/YjsfwXyxx/getJyhth";
        	$.ajax({
        		cache : true,
        		type : "POST",
        		url : url,
        		data : {jyhthkhmc:jyhthkhmc,jyhthkhdz:jyhthkhdz},
        		async : false,
        		error : function(request) {
        			alert("选择失败,请联系管理员。");
        		},
        		success : function(data) {
        			var del = $("#table");
        			del.remove();
                	var str="<table><thead><tr><th>协议编号</th><th>客户名称</th><th>客户地址</th><th>法人代表</th>"
        				   +"<th>操作</th></tr></thead><tbody>";
                	for(var i=0;i<data.length;i++){
                		str=str+"<tr id='"+data[i].ID+"'><td>"+data[i].XYBH+"</td><td>"+data[i].KHMC+"</td><td>"+data[i].KHDZ
                		+"</td><td>"+data[i].FRDB+"</td><td><input type ='button' onClick='saveJyhth("+data[i].ID+");' value='选择'></td>";
                	} 
                	str=str+"</tbody><table>";
                	var oTest = document.getElementById("sectJyhth");
            		var newNode = document.createElement("table");
            		var befNode = document.getElementById("sbzJyhth");
            		newNode.setAttribute('class','table');
            		newNode.setAttribute('id','table');
            		newNode.innerHTML =str;
            		oTest.insertBefore(newNode,befNode);
        		}
        	});
        	$("#jyhthkhmc").val("");
        	$("#jyhthkhdz").val("");
        } 
        
        //获取检验合同号的值
        function saveJyhth(id) {
        	var td = $("#"+id).find("td");
        	$("#jyhth").val($(td[0]).text());
        	$('#myModalJyhth').modal('hide');
       }
        //关闭检验合同号窗口
        function closeJyhth() {
	        $('#myModalJyhth').modal('hide');
	        var del = $("#table");
	        del.remove();
        }
        
        var ypjzcs=1;
        //打开样品信息信息窗口
        function getYpxxList(type) {
        	if(type=='1'){
        		ypjzcs++;
        	}else{
        		ypjzcs=1;
        	}
        	/* var del = $("#table");
            del.remove(); */
            
            var ypbhcx = document.getElementById("ypbhcx").value;
        	var ypmccx = document.getElementById("ypmccx").value;
        	var djlx = document.getElementById("djlx").value;
        	var url = "<%=path%>/ypgl/YYpYpxx/ypfzList";
        	$.ajax({
        		cache : true,
        		type : "POST",
        		url : url,
        		data : {ypbhcx:ypbhcx,ypmccx:ypmccx,djlx:djlx,ypjzcs:ypjzcs},
        		async : false,
        		error : function(request) {
        			alert("选择失败,请联系管理员。");
        		},
        		success : function(data) {
        			var del = $("#table");
        			del.remove();
                	var str="<table><thead><tr><th>样品编号</th><th>样品名称</th><th>样品类型</th><th>生产单位</th>"
        				   +"<th>操作</th></tr></thead><tbody>";
                	for(var i=0;i<data.length;i++){
                		str=str+"<tr id='"+data[i].ID+"'><td>"+data[i].YPBH+"</td><td>"+data[i].YPMC+"</td><td>"+data[i].YPLX
                		+"</td><td>"+data[i].SCDW+"</td><td><input type ='button' onClick='ypfz("+data[i].ID+");' value='复制'></td>";
                	}
                	str=str+"</tbody><table>";
                	var oTest = document.getElementById("sectYpxx");
            		var newNode = document.createElement("table");
            		var befNode = document.getElementById("sbzYpxx");
            		newNode.setAttribute('class','table');
            		newNode.setAttribute('id','table');
            		newNode.innerHTML =str;
            		oTest.insertBefore(newNode,befNode);
        		}
        	});
        	/* $("#ypbhcx").val("");
        	$("#ypmccx").val(""); */
        } 
        
        //跳转到样品复制页面
        function ypfz(id) {
        	var oldId = document.getElementById("id").value;
        	var jyksfz = document.getElementById("jyks").value;
        	var jyksbhfz = document.getElementById("jyksbh").value;
        	var ypbhfz = document.getElementById("ypbh").value;
        	var zhfz = document.getElementById("zh").value;
        	location.href="xgfzPageView?id="+id+"&oldId="+oldId+"&jyks="+jyksfz+"&ypbh="+ypbhfz+"&zh="+zhfz+"&jyksbh="+jyksbhfz;
       }
      
        //关闭样品信息窗口
        function closeYpxxWin() {
        	$("#ypbhcx").val("");
        	$("#ypmccx").val("");
	        var del = $("#table");
	        del.remove();
	        $('#myModalYpxx').modal('hide');
        }
      
        var changeButton = "0";
        //追加当前样品
        function addThisYpxx() {
	        var jyksbh = document.getElementById("jyksbh").value;
            var zhmc = document.getElementById("zh").value;
            //alert(zh);
            var url = "<%=path%>/ypgl/YYpYpxx/findZh";
            $.ajax({
                cache: true,
                type: "POST",
                url: url,
                data: {jyksbh: jyksbh, zhmc: zhmc},
                async: false,
                error: function (request) {
                    alert("编号追加失败,请联系管理员。");
                },
                success: function (data) {
                    //alert(data);
                    $("#ypbh").val(data);
                    $("#bgbh").val(data);
                    changeButton = "1";
                    //alert("生成报告编号："+document.getElementById("ypbh").value);
                }
            });
	
        }
        
      //输入产品名称后,检验项目窗口获取产品名称
        function changeCpmccx() {
        	var cpmc = document.getElementById("ypmc").value;
        	$("#cpmccx").val(cpmc);
        }
      
      //检验项目数量大写
        function DX(n) {
            if (!/^(0|[1-9]\d*)(\.\d+)?$/.test(n))
                return "数据非法";
            var unit = "千百拾亿千百拾万千百拾元角分", str = "";
                n += "00";
            var p = n.indexOf('.');
            if (p >= 0)
                n = n.substring(0, p) + n.substr(p+1, 2);
                unit = unit.substr(unit.length - n.length);
            for (var i=0; i < n.length; i++)
                str += '零壹贰叁肆伍陆柒捌玖'.charAt(n.charAt(i)) + unit.charAt(i);
            return str.replace(/零(千|百|拾|角)/g, "零").replace(/(零)+/g, "零").replace(/零(万|亿|元)/g, "$1").replace(/(亿)万|壹(拾)/g, "$1$2").replace(/^元零?|零分/g, "").replace(/元$/g, "");
        }
      
        function checkLen(obj,len){
        	//alert(obj.value);
        	//len=checklength(obj.value);
        	  if(obj.value.replace(/[^/x00(-)/xFF]/g,'**').length>=len){
        	   obj.value=leftUTFString(obj.value,len);
        	  }
        	 }
        	 
        	 function getStringUTFLength(str) { 
        	  var value = str.replace(/[^/x00(-)/xff]/g,"  "); 
        	  return value.length; 
        	 }

        	 function leftUTFString(str,len) { 
        	  if(checklength(str)<=len) 
        	   return str; 
        	  var value = str.substring(0,len); 
        	 
        	  while(checklength(value)>len) { 
        	   value = value.substring(0,value.length-1); 
        	  } 
        	  return value; 
        	 } 
        	 
        	 function checklength(str) {
        		  //alert(str);
        		  ///<summary>获得字符串实际长度，中文2，英文1</summary>
        		  ///<param name="str">要获得长度的字符串</param>
        		  var realLength = 0, len = str.length, charCode = -1;
        		  for (var i = 0; i < len; i++) {
        		    charCode = str.charCodeAt(i);
        		    if (charCode >= 0 && charCode <= 128) realLength += 1;
        		    else realLength += 2;
        		  }
        		  //alert(realLength);
        		  return realLength;
        		}; 
        		function getCydd(n) {
        			document.getElementById("cydd").value=n;
        		}
    </script>
    
    <script type="text/javascript">
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
        
        
    </script>
</head>
<body onload="img()">
<?xml version="1.0" encoding="iso-8859-1"?>
<!-- 贷款业务数据 -->
<div class="panel panel-success">
    <div style="width:0px;height:0px;border-width: 0px;">
        <iframe id="test1" src="<%=path%>/jygl/YjyBgxx/edit?bgbh=${bgbh }&fyid=${fyid}" style="width:0px;height:0px;border-width: 0px;"></iframe>
    </div>
    <div class="panel-heading">样品信息:</div>
    <%-- <table class="table table-bordered">
        <tr>
            <th class="thbg">样品编号</th>
            <td>${mapBusi.ypbh}</td>
            <th class="thbg">样品名称</th>
            <td><a onclick="viewYpxx('${mapBusi.id}','${mapBusi.djlx}');" title="点击查看样品信息">${mapBusi.ypmc}</a></td>
            <td><a onclick="editYpxx('${mapBusi.id}','${mapBusi.djlx}','${taskId }');" title="点击修改样品信息">样品信息修改</a></td>
        </tr>
    </table> --%>
     <input type="hidden" id="taskId" name="taskId" value="${taskId }" />
     <input type="hidden" id="ypbh" name="ypbh" value="${bgbh }" />
     <input type="hidden" id="bmbh" name="bmbh" value="${ypxx.jyksbh }">
     
     <div class="panel-body">
			<div style="text-align:center;margin-bottom:10px"></div>
                <form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
                <c:forEach var="list" items="${list}" varStatus="obj">
                    <input type="hidden" name="id" id="id" value="${list.id }">
					<input class="form-control" type="hidden" id="jyksbh" name="jyksbh" value="${list.jyksbh }">
					<input class="form-control" type="hidden" id="ywksbh" name="ywksbh" value="${list.ywksbh }">
					<input class="form-control" type="hidden" id="ypjyzt" name="ypjyzt" value="${list.ypjyzt }">
					<input class="form-control" type="hidden" id="djlx" name="djlx" value="${list.djlx }">
					<input class="form-control" type="hidden" id="ypyj" name="ypyj" value="${list.ypyj }">
					<%-- <input class="form-control" type="hidden" id="yjzt" name="yjzt" value="${list.yjzt }"> --%>
					<input class="form-control" type="hidden" id="djry" name="djry" value="${list.djry }">
					<input class="form-control Wdate" type="hidden" id="djsj" name="djsj" 
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd hh24:mm:ss'})" value="${list.djsj }">
				<c:if test="${list.djlx=='0'}">
					
                    <div class="panel-body" >
                          <div class="form-group"
                               style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                               <input type="hidden" name="lysl" id="lysl" value="${list.lysl }"> 
                               <label class="col-sm-2 col-sm-2 control-label"
                                     style="margin-top: 15px;" ><span style="color:red">*</span>检验科室：</label>

                              <div class="col-sm-10" style="margin-top: 21px;">
                                  <input id="jyks" name="jyks" class="easyui-combotree" value="${list.jyks }"
                                         style="height: 34px;width: 238px;" readonly="true" />
                              </div>
                              <label class="col-sm-2 col-sm-2 control-label"
                                     style="margin-top: 18px;"><span style="color:red">*</span>字号名称：</label>

                              <div class="col-sm-10" style="margin-top: 21px;">
                                  <input class="form-control" type="text" id="zh" name="zh" value="${list.zh }" readonly="readonly">
                              </div>
                              <label class="col-sm-2 col-sm-2 control-label"
                                     style="margin-top: 19px;">是否移交:</label>
                              <!-- <div class="col-sm-10">
                                  <div id="code" style="width: 100px;height: 100px;"></div>
                              </div> -->
                              <div class="col-sm-10" style="margin-top: 23px;">
                                  <label><input type="radio" name="ypyj" value="0" >是</label>
                                  <label style="padding-left: 20px;"><input type="radio" name="ypyj" value="1">否</label>
                              	<input type="hidden" name="Radio1" id="Radio1" value="${list.ypyj }">
                              </div>
                          </div>

                          <div class="form-group"
                               style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                              <label class="col-sm-2 col-sm-2 control-label"
                                     style="margin-top: 0px;"><span style="color:red">*</span>业务科室：</label>
                              <div class="col-sm-10" style="margin-top: 4px;">
                                  <input id="ywks" name="ywks" class="easyui-combotree" value="${list.ywks }"
                                         style="height: 34px;" required readonly="true"/>
                              </div>
                              <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>样品编号：</label>
                              <div class="col-sm-10">
                                  <input class="form-control" type="text" id="ypbh" name="ypbh" value="${list.ypbh }" readonly="readonly">
                              </div>
                              <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>报告编号：</label>
                              <div class="col-sm-10">
                                  <input class="form-control" type="text" id="bgbh" name="bgbh" value="${list.bgbh }" readonly="readonly">
                              </div>
                          </div>

                          <div class="form-group"
                               style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                              <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>样品名称：</label>

                              <div class="col-sm-10">
                                  <input class="form-control" type="text" id="ypmc" name="ypmc" value="${list.ypmc }" 
                                  required data-msg-required="必填" placeholder="必填且最多输入36个字"
                                  minlength="1" data-msg-minlength="必填" onKeyUp="checkLen(this,72)" onBlur="changeCpmccx();">
                              </div>
                              <label class="col-sm-2 col-sm-2 control-label">样品类型：</label>

                              <div class="col-sm-10">
                                  <select class="form-control input-lg m-bot15" name="yplx">
                                      <option selected="selected" value="${list.yplx }">${list.yplx }</option>
                                      <option>电器产品</option>
                                      <option>化工产品</option>
                                      <option>信息机电产品</option>
                                      <option>食品产品</option>
                                      <option>消防产品</option>
                                      <option>机械装备产品</option>
                                      <option>建筑节能产品</option>
                                      <option>节水排灌产品</option>
                                      <option>装饰装修材料产品</option>
                                      <option>轻纺及高分子产品</option>
                                      <option>汽车零部件产品</option>
                                      <option>黄金珠宝</option>
                                  </select>
                              </div>
                              <label class="col-sm-2 col-sm-2 control-label">样品等级：</label>
                              <div class="col-sm-10">
                                  <input class="form-control" type="text" id="ypdj" name="ypdj" onKeyUp="checkLen(this,16)" 
                                  placeholder="最多输入8个字" value="${list.ypdj }">
                              </div>
                          </div>

                          <div class="form-group"
                               style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                              <label class="col-sm-2 col-sm-2 control-label">样品状态：</label>
                              <div class="col-sm-10">
                                  <input class="form-control" type="text" id="ypzt" name="ypzt" onKeyUp="checkLen(this,72)" 
                                  placeholder="最多输入38个字" value="${list.ypzt }">
                              </div>
                              <label class="col-sm-2 col-sm-2 control-label">来样方式：</label>
                              <div class="col-sm-10" style="margin-top: 5px;">
                                  <label><input type="radio" name="lyfs" value="0" >直送</label>
                                  <label style="padding-left: 20px;"><input type="radio" name="lyfs" value="1">快递</label>
                              	<input type="hidden" name="lRadio" id="lRadio" value="${list.lyfs }">
                              </div>
                              <label class="col-sm-2 col-sm-2 control-label">规格型号：</label>
                              <div class="col-sm-10">
                                  <input class="form-control" type="text" id="ggxh" name="ggxh" value="${list.ggxh }"  
                                  onKeyUp="checkLen(this,90)" placeholder="最多输入45个字">
                              </div>
                          </div>


                          <div class="form-group"
                               style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                              <label class="col-sm-2 col-sm-2 control-label">所在城市：</label>

                              <div class="col-sm-10">
                                  <input class="form-control" type="text" id="szcs" name="szcs" value="${list.szcs }"
                                  onKeyUp="checkLen(this,90)" placeholder="最多输入45个字">
                              </div>
                              <label class="col-sm-2 col-sm-2 control-label">生产日期批次：</label>

                              <div class="col-sm-10">
                                  <input class="form-control" type="text" id="scrqpc"
                                         name="scrqpc" value="${list.scrqpc }" 
                                         onKeyUp="checkLen(this,56)" placeholder="最多输入28个字">
                              </div>
                              <label class="col-sm-2 col-sm-2 control-label">抽样人员：</label>

                              <div class="col-sm-10">
                                  <input class="form-control" type="text" id="cyry" name="cyry" value="${list.cyry }" 
                                  onKeyUp="checkLen(this,32)" placeholder="最多输入16个字">
                              </div>
                          </div>

                          <div class="form-group"
                               style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                              <label class="col-sm-2 col-sm-2 control-label">抽样地点：</label>

                              <div class="col-sm-10">
                                  <input class="form-control" type="text" id="cydd" name="cydd" value="${list.cydd }" 
                                  onKeyUp="checkLen(this,90)" placeholder="最多输入45个字">
                              </div>
                              <label class="col-sm-2 col-sm-2 control-label">抽样日期：</label>
                              <div class="col-sm-10">
                                  <input class="form-control Wdate" type="text" id="cyrq"
                                         name="cyrq"
                                         onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${list.cyrq }">
                              </div>
                              <label class="col-sm-2 col-sm-2 control-label">抽样基数：</label>
                              <div class="col-sm-10">
                                  <input class="form-control" type="text" id="cyjs" name="cyjs" value="${list.cyjs }" 
                                  onKeyUp="checkLen(this,30)" placeholder="最多输入15个字"/> 
                              </div>
                          </div>
                          
                          <div class="form-group"
                               style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                              <label class="col-sm-2 col-sm-2 control-label">抽样单位：</label>
                              <div class="col-sm-10">
                                  <input class="form-control" type="text" id="cydw" name="cydw" value="${list.cydw }" 
                                  onKeyUp="checkLen(this,72)" placeholder="最多输入36个字">
                              </div>
                              <label class="col-sm-2 col-sm-2 control-label">商标：</label>
                              <div class="col-sm-10">
                                  <input class="form-control" type="text" id="sb" name="sb" value="${list.sb }" 
                                  onKeyUp="checkLen(this,40)" placeholder="最多输入20个字">
                              </div>
                              <label for="ypsl" class="col-sm-2 col-sm-2 control-label">样品数量：</label>
                              <div class="col-sm-10">
                                  <input class="form-control" type="text" id="ypsl" name="ypsl" value="${list.ypsl }" 
                                  onKeyUp="checkLen(this,52)" placeholder="最多输入26个字"/>
                              </div>
                          </div>
                          <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;
                                                     background:#cdffff; color:#000;">
                                                    <!-- <label class="col-sm-2 col-sm-2 control-label" style="padding-top: 4px;">
                                                    	<a class="btn btn-xs btn-success" href="#myModalKhxx" 
                                                    	   data-toggle="modal" type="button" onClick="getKhxx();">委托单位：</a>
                                                    </label> -->
                                                    <label class="col-sm-2 col-sm-2 control-label">委托单位：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="wtdw" name="wtdw" onKeyUp="checkLen(this,72)"
                                                        placeholder="最多输入36个字" value="${list.wtdw }" >
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">委托单位地址：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="wtdwdz" name="wtdwdz" onKeyUp="checkLen(this,90)" 
                                                        placeholder="最多输入45个字" value="${list.wtdwdz }" >
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">委托单位联系人：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="wtlxr" name="wtlxr" onKeyUp="checkLen(this,16)" 
                                                        placeholder="最多输入8个字" value="${list.wtlxr }">
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;
                                                     background:#cdffff; color:#000;">
                                                    
                                                    <label class="col-sm-2 col-sm-2 control-label">手机号码：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="sjhm" name="sjhm" 
                                                        placeholder="请输入正确的手机号码格式" data-rule-mobile="true" 
                                                        data-msg-mobile="请输入正确的格式" value="${list.sjhm }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">委托单位电话：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="wtdwgddh" name="wtdwgddh" onKeyUp="checkLen(this,34)" 
                                                        placeholder="最多输入17个字" value="${list.wtdwgddh }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">委托单位邮编：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="wtyb" name="wtyb" data-rule-number="true" 
                                                        data-msg-number="请输入正确的格式" data-msg-minlength="请输入正确的格式" 
                                                        minlength="6" maxlength="6" placeholder="请输入正确的格式" value="${list.wtyb }">
                                                    </div>
                                                    <!-- <label class="col-sm-2 col-sm-2 control-label" style="width: 30%; margin-left: 2%; 
                                                    	   padding-top: 0px; margin-top: 3px;">
                                                    <a class="btn btn-xs btn-success" href="#myModalKhxx" style="width: 62%"
                                                    	   data-toggle="modal" type="button" onClick="getKhxx();">选择委托单位</a>
                                					</label> -->
                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;
                                                     background:#ffffcd; color:#000;">
                                                    <label class="col-sm-2 col-sm-2 control-label">受检单位：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="sjdw" name="sjdw" onKeyUp="checkLen(this,72)"
                                                        placeholder="最多输入36个字" value="${list.sjdw }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">受检单位地址：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="sjdwdz" name="sjdwdz" onKeyUp="checkLen(this,90)" 
                                                        placeholder="最多输入45个字" value="${list.sjdwdz }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">受检单位联系人：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="lxr" name="lxr" onKeyUp="checkLen(this,16)" 
                                                        placeholder="最多输入8个字" value="${list.lxr }">
                                                    </div>
                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;
                                                     background:#ffffcd; color:#000;">
                                                    <label class="col-sm-2 col-sm-2 control-label">手机号码：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="dh" name="dh" 
                                                        placeholder="请输入正确的手机号码格式" data-rule-mobile="true" 
                                                        data-msg-mobile="请输入正确的格式" value="${list.dh }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">受检单位电话：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="sjdwgddh" name="sjdwgddh" onKeyUp="checkLen(this,34)" 
                                                        placeholder="最多输入17个字" value="${list.sjdwgddh }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">受检单位邮编：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="yb" name="yb" data-rule-number="true" 
                                                        data-msg-number="请输入正确的格式" data-msg-minlength="请输入正确的格式" 
                                                        placeholder="请输入正确的格式" minlength="6" maxlength="6" value="${list.yb }">
                                                    </div>
                                                    
                                                    <!-- <label class="col-sm-2 col-sm-2 control-label" style="width: 30%; margin-left: 2%; 
                                                    	   padding-top: 0px; margin-top: 3px;">
                                                    <button type="button" class="btn btn-xs btn-success" onClick="getSjdw();"
                                    						style="margin-left: 20px;width:62%">受检单位同委托单位</button>
                                					</label> -->

                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;
                                                     background:#99ff99; color:#000;">
                                                    <label class="col-sm-2 col-sm-2 control-label">生产单位：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="scdw" name="scdw" onKeyUp="checkLen(this,72)"
                                                        placeholder="最多输入36个字" value="${list.scdw }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">生产单位地址：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="scdwdz" name="scdwdz" onKeyUp="checkLen(this,90)" 
                                                        placeholder="最多输入45个字" value="${list.scdwdz }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">生产单位联系人：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="scdwlxr" name="scdwlxr" onKeyUp="checkLen(this,16)"
                                                        placeholder="最多输入8个字" value="${list.scdwlxr }">
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;
                                                     background:#99ff99; color:#000;">
                                                    <label class="col-sm-2 col-sm-2 control-label">手机号码：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="scdwdh" name="scdwdh" 
                                                        placeholder="请输入正确的手机号码格式" data-rule-mobile="true" 
                                                        data-msg-mobile="请输入正确的格式" value="${list.scdwdh }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">生产单位电话：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="scdwgddh" name="scdwgddh" maxlength="17" 
                                                        placeholder="最多输入17个字" value="${ypxx.scdwgddh }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">生产单位邮编：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="scdwyb"
                                                               name="scdwyb" data-rule-number="true" 
                                                        data-msg-number="请输入正确的格式" data-msg-minlength="请输入正确的格式" 
                                                        minlength="6" maxlength="6" placeholder="请输入正确的格式" value="${list.scdwyb }">
                                                    </div>
                                                    
                                                    <!-- <label class="col-sm-2 col-sm-2 control-label" style="width: 30%; margin-left: 2%; 
                                                    	   padding-top: 0px; margin-top: 3px;">
                                                    <button type="button" class="btn btn-xs btn-success" onClick="getScdw();"
                                    						style="margin-left: 20px;width:62%">生产单位同受检单位</button>
                                					</label> -->
                                                </div>
                                                <div style="text-align: center;margin-top: 10px;">
	                                        		<!-- <div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 50px;"> -->
	                                        			<!-- <label class="col-sm-2 col-sm-2 control-label" style="padding-top: 0px; 
	                                        			padding-left: 0px; margin-left: 0px;text-align: center"> -->
	                                                    <button class="btn btn-xs btn-success" style="width: 83px; height: 30px;" href="#myModalKhxx" 
	                                                    data-toggle="modal" type="button" onClick="getKhxx();">选择委托单位</button>
	                                					<!-- </label> -->
	                                        			<button type="button" class="btn btn-xs btn-success" style="width: 128px; height: 30px;" onClick="getSjdw();">受检单位同委托单位</button>
	                                    				<button type="button" class="btn btn-xs btn-success" style="width: 128px; height: 30px;" onClick="getScdw();">生产单位同受检单位</button>		
	                                    			<!-- </div> -->
                                        		</div>
                                        		
                                        		<div class="form-group"
                               style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">检验项目：</label>
                                                    <div class="col-sm-10">
										            <textarea class="form-control ckeditor textarea" rows="6" name="jyxm" id="jyxm" 
										            truetype="textarea" style="width: 409%;height: 35px;" onKeyUp="checkLen(this,320)" 
										            placeholder="最多输入160个字">${list.jyxm }</textarea>
                                                    </div>
                                                    <!-- <div class="col-sm-10" style="margin-top: 5px;left: 55%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">
                                                            <a href="#myModal" data-toggle="modal"
                                                               class="btn btn-xs btn-sucess">选择检验项目</a>
                                                    </label> -->
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group"
                               style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">检验依据：</label>
                                                    <div class="col-sm-13">
													<textarea class="form-control ckeditor textarea" rows="6" name="jyyj" 
														truetype="textarea" style="width: 99.5%;height: 35px;" onKeyUp="checkLen(this,150)" 
                                                  placeholder="最多输入75个字">${list.jyyj}</textarea>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group"
                               style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">检验费用：</label>
                                                    <c:if test="${sfzt != -1 }">
                                                    <div class="input-group m-bot15 col-sm-10" style="width: 19%;">
                                                        <input class="form-control" type="text" id="jyfy" name="jyfy" value="${list.jyfy }" 
                                                        data-rule-number="true" data-msg-number="请输入正确的数字" 
                                                        data-gt="0"  maxlength="10" placeholder="最多输入10位数字" readonly="readonly"/>
                                                        <span class="input-group-addon">元</span>
                                                    </div>
                                                    </c:if>
                                                    <c:if test="${sfzt == -1 }">
                                                    <div class="input-group m-bot15 col-sm-10" style="width: 19%;">
                                                        <input class="form-control" type="text" id="jyfy" name="jyfy" readonly="true" value="${list.jyfy }" 
                                                        data-rule-number="true" data-msg-number="请输入正确的数字" 
                                                        data-gt="0"  maxlength="10" placeholder="最多输入10位数字"/>
                                                        <span class="input-group-addon">元</span>
                                                    </div>
                                                    </c:if>
                                                    <label class="col-sm-2 col-sm-2 control-label">检验费用待定：</label>
                                                    <div class="col-sm-10" style="margin-top: 5px;">
                                                    <c:if test="${sfzt != -1 }">
                                                         <label><input type="radio" name="jyfydd" value="0">待定</label>
                                                        <label style="padding-left: 20px;"><input type="radio" name="jyfydd" 
                                                        value="1">不待定</label>
                                                    	<input type="hidden" name="jRadio" id="jRadio" value="${list.jyfydd }">
                                                    </c:if>
                                                    <c:if test="${sfzt == -1 }">
                                                        <label><input type="radio" name="jyfydd" value="0" readonly="true">待定</label>
                                                        <label style="padding-left: 20px;"><input type="radio" name="jyfydd" 
                                                        value="1">不待定</label>
                                                    	<input type="hidden" name="jRadio" id="jRadio" readonly="true" value="${list.jyfydd }">
                                                    </c:if>
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">验后需退库：</label>
                                                    <div class="col-sm-10">
													<select class="form-control input-lg m-bot15" name="yhxtk" >
													<option selected = "selected" value="">请选择...</option>
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
                                                    <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>检验类型：</label>
                                                    <div class="col-sm-10">
													<select class="form-control input-lg m-bot15" name="jylx"
													required data-msg-required="必填" readonly="readonly">
													<c:forEach items="${jylx}" var="jylx">
                                     				<c:choose>
                                         			<c:when test="${jylx.zdz == list.jylx}">
                                               		<option selected = "selected" value="${jylx.zdz}">${jylx.zdmc}</option>
                                         			</c:when>
                                         			<c:otherwise>
                                               		<option value="${jylx.zdz}">${jylx.zdmc}</option>
                                         			</c:otherwise>
                                     				</c:choose>
                                					</c:forEach> 
					        						</select>
													</div>
													
                                                    <c:if test="${sfzt != -1 }">
                                                    <label class="col-sm-2 col-sm-2 control-label" style="margin-top: -5px;
                                                     margin-bottom: 5px; width: 13%;" >
                                                    <a class="btn btn-xs btn-success" href="#myModalJyhth" data-toggle="modal" 
                                                       type="button" onClick="getJyhth();" style="width:85%">检验合同号</a>
                                					</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="jyhth" name="jyhth"
                                                         onKeyUp="checkLen(this,50)" placeholder="最多输入25个字" value="${list.jyhth}">
                                                    </div>
                                                    </c:if>
                                                    <c:if test="${sfzt == -1 }">
                                                    <label class="col-sm-2 col-sm-2 control-label" style="margin-top: -5px;
                                                     margin-bottom: 5px; width: 13%;" >检验合同号</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="jyhth" name="jyhth" readonly="true"
                                                         maxlength="25" placeholder="最多输入25个字" value="${list.jyhth}">
                                                    </div>
                                                    </c:if>
                                                    <label class="col-sm-2 col-sm-2 control-label">检查封样人员：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="jcfyry" name="jcfyry" value="${list.jcfyry}" 
                                                        onKeyUp="checkLen(this,16)" placeholder="最多输入8个字">
                                                    </div>
                                                </div>

                                                <div class="form-group"
                               style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">报告发送方式：</label>
                                                    <div class="col-sm-10" style="margin-top: 5px;width: 40%;">
                                                        <label><input type="radio" name="bgfsfs" value="0" checked="checked">邮寄</label>
                                                        <label><input type="radio" name="bgfsfs" value="1">自取（本院）</label>
                                                        <label><input type="radio" name="bgfsfs" value="2">自取（中心）</label>
                                                        <input type="hidden" name="bRadio" id="bRadio" value="${list.bgfsfs }">
                                                    </div>
                                                </div>

                                                <div class="form-group"
                               style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">到样日期：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control Wdate" type="text"  
                                                        value="${list.dyrq}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" disabled >
                                                        <input class="form-control Wdate" type="hidden" id="dyrq" name="dyrq" 
                                                        value="${list.dyrq}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" >
                                                    </div>
                                                    <%-- <label class="col-sm-2 col-sm-2 control-label">样品检测状态：</label>

                                                    <div class="col-sm-10">
                                                        <select class="form-control input-lg m-bot15" name="ypjyzt">
                                                            <c:forEach var="ypjyzt" items="${ypjyzt}" varStatus="obj">
                                                                <option value="${ypjyzt.zdz }">${ypjyzt.zdmc }</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div> --%>
                                                    <label class="col-sm-2 col-sm-2 control-label">完成期限：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control Wdate" type="text"   
                                                        value="${list.wcqx}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" disabled>
                                                        <input class="form-control Wdate" type="hidden" id="wcqx" name="wcqx" 
                                                        value="${list.wcqx}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" >
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">样品附件：</label>
							                        <div class="box">
						                                <input type="text" name="copyFile"  class="textbox" value="${list.fj}"/>
											            <a href="javascript:void(0);"  class="link">...</a>
											            <input type="file" class="uploadFile" name="file" id="attachMentFile"
											             onchange="getFile(this,'copyFile')" />
											            <input type="hidden" id="fj" name="fj">
													</div>
                                                </div>

                                                <div class="form-group"
                               style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">备注：</label>

                                                    <div class="col-sm-13">
													<textarea class="form-control ckeditor textarea" rows="6" name="bz" 
													truetype="textarea" style="width: 99.5%;height: 35px;" 
													placeholder="最多输入120个字" onKeyUp="checkLen(this,240)" >${list.bz}</textarea>
                                                    </div>
                                                </div>
                          <div style="text-align: center;margin-top: 10px;">
                  <div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 50px;">
                      <button type="submit" class="btn btn-primary" >修改</button>		
                  </div>
              </div>
              </div>
              </c:if>
					<c:if test="${list.djlx=='1'}">
						<div class="panel-body" style="overflow:scroll;overflow-x:hidden">
                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                     <label class="col-sm-2 col-sm-2 control-label"
                                                           style="margin-top: 15px;" ><span style="color:red">*</span>检验科室：</label>

                                                    <div class="col-sm-10" style="margin-top: 21px;">
                                                        <input id="jyks" name="jyks" class="easyui-combotree" value="${list.jyks }"
                                                               style="height: 34px;width: 238px;" readonly="true" />
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label"
                                                           style="margin-top: 18px;"><span style="color:red">*</span>字号名称：</label>

                                                    <div class="col-sm-10" style="margin-top: 21px;">
                                                        <input class="form-control" type="text" id="zh" name="zh" value="${list.zh }" readonly="readonly">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label"
						                                     style="margin-top: 19px;">是否移交:</label>
						                              <!-- <div class="col-sm-10">
						                                  <div id="code" style="width: 100px;height: 100px;"></div>
						                              </div> -->
						                              <div class="col-sm-10" style="margin-top: 23px;">
						                                  <label><input type="radio" name="ypyj" value="0" >是</label>
						                                  <label style="padding-left: 20px;"><input type="radio" name="ypyj" value="1">否</label>
						                              	<input type="hidden" name="Radio1" id="Radio1" value="${list.ypyj }">
						                              </div>
                                                </div>
 
                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label"
                                                           style="margin-top: 0px;"><span style="color:red">*</span>业务科室：</label>
                                                    <div class="col-sm-10" style="margin-top: 4px;">
                                                        <input id="ywks" name="ywks" class="easyui-combotree" value="${list.ywks }"
                                                               style="height: 34px;" required readonly="true"/>
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>样品编号：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="ypbh" name="ypbh" value="${list.ypbh }" readonly="readonly">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>报告编号：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="bgbh" name="bgbh" value="${list.bgbh }" readonly="readonly">
                                                    </div>
                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>样品名称：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" required data-msg-required="必填" minlength="1" 
		                                                data-msg-minlength="必填" maxlength="36" type="text" placeholder="必填且最多输入36个字"
		                                                placeholder="必填" id="ypmc" name="ypmc" onBlur="changeCpmccx();" value="${list.ypmc }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">样品类型：</label>

                                                    <div class="col-sm-10">
                                                        <select class="form-control input-lg m-bot15" name="yplx">
                                                            <option selected="selected" value="${list.yplx }">${list.yplx }</option>
                                                            <option>电器产品</option>
                                                            <option>化工产品</option>
                                                            <option>信息机电产品</option>
                                                            <option>食品产品</option>
                                                            <option>消防产品</option>
                                                            <option>机械装备产品</option>
                                                            <option>建筑节能产品</option>
                                                            <option>节水排灌产品</option>
                                                            <option>装饰装修材料产品</option>
                                                            <option>轻纺及高分子产品</option>
                                                            <option>汽车零部件产品</option>
                                                            <option>黄金珠宝</option>
                                                        </select>
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">样品等级：</label>
                                                    <div class="col-sm-10">
			                                              <input class="form-control" type="text" id="ypdj" name="ypdj" maxlength="8" 
			                                              placeholder="最多输入8个字" value="${list.ypdj }">
		                                        	</div>
                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">样品状态：</label>
                                                    <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="ypzt" name="ypzt" maxlength="38" 
		                                                placeholder="最多输入38个字" value="${list.ypzt }">
		                                            </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">来样方式：</label>
                                                    <div class="col-sm-10" style="margin-top: 5px;">
                                                        <label><input type="radio" name="lyfs" value="0" checked="checked">直送</label>
                                                        <label style="padding-left: 20px;"><input type="radio" name="lyfs" value="1">快递</label>
                                                    	<input type="hidden" name="lRadio" id="lRadio" value="${list.lyfs }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">规格型号：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="ggxh" name="ggxh" value="${list.ggxh }" 
                                                        maxlength="45" placeholder="最多输入45个字">
                                                    </div>
                                                </div>


                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">所在城市：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="szcs" name="szcs" value="${list.szcs }" 
                                                        maxlength="45" placeholder="最多输入45个字">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">生产日期批次：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="scrqpc"
                                                               name="scrqpc" value="${list.scrqpc }" 
                                                               onKeyUp="checkLen(this,56)" placeholder="最多输入28个字">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">商标：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="sb" name="sb" value="${list.sb }" 
                                                        maxlength="8" placeholder="最多输入8个字">
                                                    </div>
                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">领样日期：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control Wdate" type="text" id="lyrq"  value="${list.lyrq }"
		                                                       name="lyrq" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
		                                            </div> 
		                                            <label class="col-sm-2 col-sm-2 control-label">领样数量：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="lysl" name="lysl" value="${list.lysl }" 
		                                                maxlength="17" placeholder="最多输入17个字"/> 
		                                            </div>
		                                            <label class="col-sm-2 col-sm-2 control-label">领样人：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="lyr" name="lyr"
		                                                 value="${list.lyr }" maxlength="8" placeholder="最多输入8个字">
		                                            </div>
                                                </div>
                                                
                                                <div class="form-group"
		                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
		                                            <label class="col-sm-2 col-sm-2 control-label">抽样单位：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="cydw" name="cydw" value="${list.cydw }" 
                                                        maxlength="36" placeholder="最多输入36个字">
                                                    </div>
		                                            <label for="ypsl" class="col-sm-2 col-sm-2 control-label">样品数量：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="ypsl" name="ypsl" 
		                                                 maxlength="16" placeholder="最多输入16个字" value="${list.ypsl }" />
		                                            </div>
		                                        </div>
		                                        <div class="form-group"
		                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
		                                            <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>工程名称：</label>
		                                            <div class="col-sm-10">
		                                               <input class="form-control" type="text" id="gcmc" name="gcmc" required maxlength="36" 
		                                               placeholder="必填且最多输入36个字" value="${list.gcmc }" >
		                                            </div>
		                                            <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>工程地址：</label>
		                                            <div class="col-sm-10">
		                                               <input class="form-control" type="text" id="gcdz" name="gcdz"required maxlength="51" 
		                                               placeholder="必填且最多输入51个字" value="${list.gcdz }">
		                                            </div>
		                                            <label class="col-sm-2 col-sm-2 control-label">工程联系人：</label>
		                                            <div class="col-sm-10">
		                                               <input class="form-control" type="text" id="gclxr"
		                                                      value="${list.gclxr }" name="gclxr" maxlength="8" placeholder="最多输入8个字">
		                                            </div>
		                                        </div>
		                                        
		                                        <div class="form-group"
		                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
		                                            <label class="col-sm-2 col-sm-2 control-label">联系电话：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="dh" name="dh" placeholder="请输入正确的手机号码格式" 
		                                                data-rule-mobile="true" data-msg-mobile="请输入正确的手机号码格式" value="${list.dh }">
		                                            </div>
		                                            <label class="col-sm-2 col-sm-2 control-label">施工单位：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="sgdw" name="sgdw" maxlength="36" 
		                                                placeholder="最多输入36个字" value="${list.sgdw }">
		                                            </div>
		                                            <label class="col-sm-2 col-sm-2 control-label">设计单位：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="gcsjdw" name="gcsjdw" maxlength="36" 
		                                                placeholder="最多输入36个字" value="${list.gcsjdw }">
		                                            </div>
		                                        </div>

                                                <div class="form-group"
		                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
		                                            <!-- <label class="col-sm-2 col-sm-2 control-label" style="padding-top: 4px;">
		                                            	<a class="btn btn-xs btn-success" href="#myModalKhxx" 
		                                            	   data-toggle="modal" type="button" onClick="getKhxx();">委托单位：</a>
		                                            </label> -->
		                                            <label class="col-sm-2 col-sm-2 control-label">委托单位：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="wtdw" name="wtdw" maxlength="36" 
		                                                placeholder="最多输入36个字" value="${list.wtdw }">
		                                            </div>
		                                            <label class="col-sm-2 col-sm-2 control-label">委托单位地址：</label>
		
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="wtdwdz"
		                                                       name="wtdwdz" maxlength="45" placeholder="最多输入45个字" value="${list.wtdwdz }">
		                                            </div>
		                                            <label class="col-sm-2 col-sm-2 control-label" style="width: 30%; margin-left: 2%; 
		                                            	   padding-top: 0px; margin-top: 3px;">
		                                            <a class="btn btn-xs btn-success" href="#myModalKhxx" style="width: 62%"
		                                            	   data-toggle="modal" type="button" onClick="getKhxx();">选择委托单位</a>
		                        					</label>
		                                        </div>
		
		                                        <div class="form-group"
		                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
		                                            <label class="col-sm-2 col-sm-2 control-label">受检单位：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="sjdw" name="sjdw" maxlength="36" 
		                                                placeholder="最多输入36个字" value="${list.sjdw }">
		                                            </div>
		                                            <label class="col-sm-2 col-sm-2 control-label">受检单位地址：</label>
		
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="sjdwdz"
		                                                       name="sjdwdz" value="${list.sjdwdz }" maxlength="45" placeholder="最多输入45个字">
		                                            </div>
		                                            <label class="col-sm-2 col-sm-2 control-label" style="width: 30%; margin-left: 2%; 
		                                            	   padding-top: 0px; margin-top: 3px;">
		                                            <button type="button" class="btn btn-xs btn-success" onClick="getSjdw();"
		                            						style="margin-left: 20px;width:62%">受检单位同委托单位</button>
		                        					</label>
		                                            
		                                        </div>
		
		                                        <div class="form-group"
		                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
		                                            <label class="col-sm-2 col-sm-2 control-label">生产单位：</label>
		
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="scdw" name="scdw" maxlength="36" 
		                                                placeholder="最多输入36个字" value="${list.scdw }">
		                                            </div>
		                                            <label class="col-sm-2 col-sm-2 control-label">生产单位地址：</label>
		
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="scdwdz"
		                                                 name="scdwdz" value="${list.scdwdz }" maxlength="45" placeholder="最多输入45个字">
		                                            </div>
		                                            <label class="col-sm-2 col-sm-2 control-label" style="width: 30%; margin-left: 2%; 
		                                            	   padding-top: 0px; margin-top: 3px;">
		                                            <button type="button" class="btn btn-xs btn-success" onClick="getScdw();"
		                            						style="margin-left: 20px;width:62%">生产单位同受检单位</button>
		                        					</label>
		                                        </div>
		                                        
		                                        <div class="form-group"
		                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
		                                            <label class="col-sm-2 col-sm-2 control-label">建设单位：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="jsdw" name="jsdw" maxlength="36" 
		                                                placeholder="最多输入36个字" value="${list.jsdw }">
		                                            </div>
		                                            <label class="col-sm-2 col-sm-2 control-label">监理单位：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="jldw" name="jldw" maxlength="36" 
		                                                placeholder="最多输入36个字" value="${list.jldw }">
		                                            </div>
		                                            <label class="col-sm-2 col-sm-2 control-label">监理人：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="jlr" name="jlr" maxlength="8" 
		                                                placeholder="最多输入8个字" value="${list.jlr }">
		                                            </div>
		                                        </div>
		                                        
		                                        <div class="form-group"
		                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
		                                            <label class="col-sm-2 col-sm-2 control-label">见证单位：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="jzdw" name="jzdw" maxlength="36" 
		                                                placeholder="最多输入36个字" value="${list.jzdw }">
		                                            </div>
		                                            <label class="col-sm-2 col-sm-2 control-label">见证人：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="jzr" name="jzr" maxlength="8" 
		                                                placeholder="最多输入8个字" value="${list.jzr }">
		                                            </div>
		                                            <label class="col-sm-2 col-sm-2 control-label">受理人：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="slr" name="slr" maxlength="8" 
		                                                placeholder="最多输入8个字" value="${list.slr }">
		                                            </div>
		                                        </div>
		                                        <div class="form-group"
		                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">检验项目：</label>
                                                    <div class="col-sm-10">
										            <textarea class="form-control ckeditor textarea" rows="6" name="jyxm" id="jyxm" 
										            truetype="textarea" style="width: 409%;height: 35px;" maxlength="160" placeholder="最多输入160个字">${list.jyxm }</textarea>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group"
		                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">检验依据：</label>
                                                    <div class="col-sm-13">
													<textarea class="form-control ckeditor textarea" rows="6" name="jyyj" 
													truetype="textarea" style="width: 99.5%;height: 35px;" maxlength="75" 
                                                  placeholder="最多输入75个字">${list.jyyj}</textarea>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group"
		                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">检验费用：</label>
                                                    <c:if test="${sfzt != -1 }">
                                                    <div class="input-group m-bot15 col-sm-10" style="width: 19%;">
                                                        <input class="form-control" type="text" id="jyfy" name="jyfy" value="${list.jyfy }" 
                                                        data-msg-number="请输入正确的数字" data-gt="0"  maxlength="10" placeholder="最多输入10个数字"/>
                                                        <span class="input-group-addon">元</span>
                                                    </div>
                                                    </c:if>
                                                    <c:if test="${sfzt == -1 }">
                                                    <div class="input-group m-bot15 col-sm-10" style="width: 19%;">
                                                        <input class="form-control" type="text" id="jyfy" name="jyfy" value="${list.jyfy }" readonly="true" 
                                                        data-msg-number="请输入正确的数字" data-gt="0"  maxlength="10" placeholder="最多输入10个数字"/>
                                                        <span class="input-group-addon">元</span>
                                                    </div>
                                                    </c:if>
                                                    <label class="col-sm-2 col-sm-2 control-label">检验费用待定：</label>
                                                    <div class="col-sm-10" style="margin-top: 5px;">
                                                     <c:if test="${sfzt != -1 }">
                                                         <label><input type="radio" name="jyfydd" value="0">待定</label>
                                                        <label style="padding-left: 20px;"><input type="radio" name="jyfydd" 
                                                        value="1">不待定</label>
                                                    	<input type="hidden" name="jRadio" id="jRadio" value="${list.jyfydd }">
                                                    </c:if>
                                                    <c:if test="${sfzt == -1 }">
                                                        <label><input type="radio" name="jyfydd" value="0" readonly="true">待定</label>
                                                        <label style="padding-left: 20px;"><input type="radio" name="jyfydd" 
                                                        value="1">不待定</label>
                                                    	<input type="hidden" name="jRadio" id="jRadio" readonly="true" value="${list.jyfydd }">
                                                    </c:if>
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">验后需退库：</label>
                                                    <div class="col-sm-10">
													<select class="form-control input-lg m-bot15" name="yhxtk" >
													<option selected = "selected" value="">请选择...</option>
													<c:forEach items="${yhxtk}" var="yhxtk">
                                     				<c:choose>
                                         			<c:when test="${yhxtk.zdz == list.yhxtk}">
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
                                                    <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>检验类型：</label>
                                                    <div class="col-sm-10">
													<select class="form-control input-lg m-bot15" name="jylx" required data-msg-required="必填" readonly="readonly" >
													<c:forEach items="${jylx}" var="jylx">
                                     				<c:choose>
                                         			<c:when test="${jylx.zdz == list.jylx}">
                                               		<option selected = "selected" value="${jylx.zdz}">${jylx.zdmc}</option>
                                         			</c:when>
                                         			<c:otherwise>
                                               		<option value="${jylx.zdz}">${jylx.zdmc}</option>
                                         			</c:otherwise>
                                     				</c:choose>
                                					</c:forEach> 
					        						</select>
													</div>
													
		                                            <c:if test="${sfzt != -1 }">
                                                    <label class="col-sm-2 col-sm-2 control-label" style="margin-top: -5px;
                                                     margin-bottom: 5px; width: 13%;" >
                                                    <a class="btn btn-xs btn-success" href="#myModalJyhth" data-toggle="modal" 
                                                       type="button" onClick="getJyhth();" style="width:85%">检验合同号</a>
                                					</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="jyhth" name="jyhth"
                                                         maxlength="25" placeholder="最多输入25个字" value="${list.jyhth}">
                                                    </div>
                                                    </c:if>
                                                    <c:if test="${sfzt == -1 }">
                                                    <label class="col-sm-2 col-sm-2 control-label" style="margin-top: -5px;
                                                     margin-bottom: 5px; width: 13%;" >检验合同号</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="jyhth" name="jyhth" readonly="true"
                                                         maxlength="25" placeholder="最多输入25个字" value="${list.jyhth}">
                                                    </div>
                                                    </c:if>
                                                    <label class="col-sm-2 col-sm-2 control-label">检查封样人员：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="jcfyry" name="jcfyry" value="${list.jcfyry}" 
                                                        maxlength="8" placeholder="最多输入8个字">
                                                    </div>
                                                </div>

                                                <div class="form-group"
		                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">报告发送方式：</label>
                                                    <div class="col-sm-10" style="margin-top: 5px;width: 40%;">
                                                        <label><input type="radio" name="bgfsfs" value="0" checked="checked">邮寄</label>
                                                        <label><input type="radio" name="bgfsfs" value="1">自取（本院）</label>
                                                        <label><input type="radio" name="bgfsfs" value="2">自取（中心）</label>
                                                        <input type="hidden" name="bRadio" id="bRadio" value="${list.bgfsfs }">
                                                    </div>
                                                </div>

                                                <div class="form-group"
		                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">到样日期：</label>

<!--                                                     <div class="col-sm-10"> -->
<!--                                                         <input class="form-control Wdate" type="text" id="dyrq" -->
<%--                                                                name="dyrq" value="${ypxx.dyrq}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"> --%>
<!--                                                     </div> -->
                                                    <div class="col-sm-10">
                                                        <input class="form-control Wdate" type="text"  
                                                        value="${list.dyrq}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" disabled >
                                                        <input class="form-control Wdate" type="hidden" id="dyrq" name="dyrq" 
                                                        value="${list.dyrq}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" >
                                                    </div>
                                                    <%-- <label class="col-sm-2 col-sm-2 control-label">样品检测状态：</label>

                                                    <div class="col-sm-10">
                                                        <select class="form-control input-lg m-bot15" name="ypjyzt">
                                                            <c:forEach var="ypjyzt" items="${ypjyzt}" varStatus="obj">
                                                                <option value="${ypjyzt.zdz }">${ypjyzt.zdmc }</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div> --%>
                                                    <label class="col-sm-2 col-sm-2 control-label">完成期限：</label>
<!--                                                     <div class="col-sm-10"> -->
<!--                                                         <input class="form-control Wdate" type="text" id="wcqx" name="wcqx"  -->
<%--                                                         value="${ypxx.wcqx}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"> --%>
<!--                                                     </div> -->
                                                    <div class="col-sm-10">
                                                        <input class="form-control Wdate" type="text"   
                                                        value="${list.wcqx}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" disabled>
                                                        <input class="form-control Wdate" type="hidden" id="wcqx" name="wcqx" 
                                                        value="${list.wcqx}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" >
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">样品附件：</label>
							                        <div class="box">
						                                <input type="text" name="copyFile"  class="textbox" value="${list.fj}"/>
											            <a href="javascript:void(0);"  class="link">...</a>
											            <input type="file" class="uploadFile" name="file" id="attachMentFile"
											             onchange="getFile(this,'copyFile')" />
											            <input type="hidden" id="fj" name="fj">
													</div>
                                                </div>

                                                <div class="form-group"
		                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">备注：</label>

                                                    <div class="col-sm-13">
													<textarea class="form-control ckeditor textarea" rows="6" name="bz" 
													truetype="textarea" style="width: 99.5%;height: 35px;" maxlength="120" 
													placeholder="最多输入120个字">${list.bz}</textarea>
                                                    </div>
                                                </div>
                                                <div style="text-align: center;margin-top: 10px;">
                  <div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 50px;">
                      <button type="submit" class="btn btn-primary" >修改</button>		
                  </div>
              </div>
              </div>
					</c:if>
					<c:if test="${list.djlx=='2' }">
						<div class="panel-body" style="overflow:scroll;overflow-x:hidden">
                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <input type="hidden" name="lysl" id="lysl" value="${list.lysl }"> 
                                                    <label class="col-sm-2 col-sm-2 control-label"
                                                           style="margin-top: 15px;" ><span style="color:red">*</span>检验科室：</label>

                                                    <div class="col-sm-10" style="margin-top: 21px;">
                                                        <input id="jyks" name="jyks" class="easyui-combotree" value="${list.jyks }"
                                                               style="height: 34px;width: 238px;" readonly="true" />
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label"
                                                           style="margin-top: 18px;"><span style="color:red">*</span>字号名称：</label>
                                                    <div class="col-sm-10" style="margin-top: 21px;">
                                                        <input class="form-control" type="text" id="zh" name="zh" value="${list.zh }" readonly="readonly">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label"
					                                     style="margin-top: 19px;">是否移交:</label>
					                              <!-- <div class="col-sm-10">
					                                  <div id="code" style="width: 100px;height: 100px;"></div>
					                              </div> -->
					                              <div class="col-sm-10" style="margin-top: 23px;">
					                                  <label><input type="radio" name="ypyj" value="0" >是</label>
					                                  <label style="padding-left: 20px;"><input type="radio" name="ypyj" value="1">否</label>
					                              	<input type="hidden" name="Radio1" id="Radio1" value="${list.ypyj }">
					                              </div>
                                                </div>
 
                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label"
                                                           style="margin-top: 0px;"><span style="color:red">*</span>业务科室：</label>
                                                    <div class="col-sm-10" style="margin-top: 4px;">
                                                        <input id="ywks" name="ywks" class="easyui-combotree" value="${list.ywks }"
                                                               style="height: 34px;" required readonly="true"/>
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>样品编号：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="ypbh" name="ypbh" value="${list.ypbh }" readonly="readonly">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>报告编号：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="bgbh" name="bgbh" value="${list.bgbh }" readonly="readonly">
                                                    </div>
                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>食品名称：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="ypmc" name="ypmc" value="${list.ypmc }" 
                                                        required data-msg-required="必填" placeholder="必填且最多输入36个字"
                                                        minlength="1" data-msg-minlength="必填" maxlength="36" onBlur="changeCpmccx();">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">商标：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="sb" name="sb" value="${list.sb }" 
                                                        maxlength="8" placeholder="最多输入8个字">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">质量等级：</label>
		                                            <div class="col-sm-10">
			                                              <input class="form-control" type="text" id="ypdj" name="ypdj" maxlength="8" 
			                                              placeholder="最多输入8个字" value="${list.ypdj }">
			                                        </div>
                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">封样状态：</label>
		                                            <div class="col-sm-10">
			                                              <input class="form-control" type="text" id="ypzt" name="ypzt" maxlength="38" 
			                                              placeholder="最多输入38个字" value="${list.ypzt }">
			                                        </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">任务来源：</label>
                                                    <div class="col-sm-10">
													<select class="form-control input-lg m-bot15" name="rwly" >
													<option selected = "selected" value="">请选择...</option>
													<c:forEach items="${rwly}" var="rwly">
                                     				<c:choose>
                                         			<c:when test="${rwly.zdz == list.rwly}">
                                               		<option selected = "selected" value="${rwly.zdz}">${rwly.zdmc}</option>
                                         			</c:when>
                                         			<c:otherwise>
                                               		<option value="${rwly.zdz}">${rwly.zdmc}</option>
                                         			</c:otherwise>
                                     				</c:choose>
                                					</c:forEach> 
					        						</select>
													</div>
                                                    <label class="col-sm-2 col-sm-2 control-label">规格型号：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="ggxh" name="ggxh" value="${list.ggxh }"  
                                                        maxlength="45" placeholder="最多输入45个字">
                                                    </div>
                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">所在城市：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="szcs" name="szcs" value="${list.szcs }"
                                                        maxlength="45" placeholder="最多输入45个字">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">生产/加工/购进日期/食品批号：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="scrqpc"
                                                               name="scrqpc" value="${list.scrqpc }" 
                                                               onKeyUp="checkLen(this,56)" placeholder="最多输入28个字">
                                                    </div>
                                                    <label for="ypsl" class="col-sm-2 col-sm-2 control-label">样品数量：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="ypsl" name="ypsl" value="${list.ypsl }" 
                                                        maxlength="16" placeholder="最多输入16个字"/>
                                                    </div>
                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">抽样地点：</label>
		                                            <div class="col-sm-10">
		                                                <span style="margin-left:100px;width:18px;overflow:hidden;"> 
												            <select class="textinput valid input-lg m-bot15" onchange="getCydd(this.value)" 
												            style="width: 234px; margin-left: -100px; padding-top: 0px; height: 26px; 
												            margin-top: 2px; border-top-width: 0px;" keepdefaultstyle="true">
												            <c:forEach var="cydd" items="${cydd}" varStatus="obj">
		                                                        <option value="${cydd.zdz }">${cydd.zdmc }</option>
		                                                    </c:forEach>
												            </select>
												        </span>
												        <input class="form-control" id="cydd" name="cydd" value="${list.cydd }"
												        style="position: absolute; margin-top: -26px; height: 24px; width: 216px;">
		                                            </div>
		                                            
                                                    <label class="col-sm-2 col-sm-2 control-label">抽样日期：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control Wdate" type="text" id="cyrq"
                                                               name="cyrq"
                                                               onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${list.cyrq }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">抽样基数：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="cyjs" name="cyjs" value="${list.cyjs }" 
                                                        onKeyUp="checkLen(this,30)" placeholder="最多输入15个字"/> 
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">抽样单位：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="cydw" name="cydw" value="${list.cydw }" 
                                                        maxlength="36" placeholder="最多输入36个字">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">抽样人员：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="cyry" name="cyry" value="${list.cyry }" 
                                                        maxlength="16" placeholder="最多输入16个字">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">抽样单编号：</label>
		                                            <div class="col-sm-10">
		                                                <input class="form-control" type="text" id="cydbh" name="cydbh" value="${list.cydbh }" 
		                                                maxlength="30" placeholder="最多输入30个字">
		                                            </div>
                                                </div>
                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;
                                                     background:#cdffff; color:#000;">
                                                    <!-- <label class="col-sm-2 col-sm-2 control-label" style="padding-top: 4px;">
                                                    	<a class="btn btn-xs btn-success" href="#myModalKhxx" 
                                                    	   data-toggle="modal" type="button" onClick="getKhxx();">委托单位：</a>
                                                    </label> -->
                                                    <label class="col-sm-2 col-sm-2 control-label">委托单位：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="wtdw" name="wtdw" maxlength="36"
                                                        placeholder="最多输入36个字" value="${list.wtdw }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">委托单位地址：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="wtdwdz" name="wtdwdz" maxlength="45"
                                                         placeholder="最多输入45个字" value="${list.wtdwdz }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">委托单位联系人：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="wtlxr" name="wtlxr" maxlength="8" 
                                                        placeholder="最多输入8个字" value="${list.wtlxr }">
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;
                                                     background:#cdffff; color:#000;">
                                                    <label class="col-sm-2 col-sm-2 control-label">手机号码：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="sjhm" name="sjhm" 
                                                        placeholder="请输入正确的手机号码格式" data-rule-mobile="true" 
                                                        data-msg-mobile="请输入正确的格式" value="${list.sjhm }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">委托单位电话：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="wtdwgddh" name="wtdwgddh" maxlength="17" 
                                                        placeholder="最多输入17个字" value="${list.wtdwgddh }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">委托单位邮编：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="wtyb" name="wtyb" data-rule-number="true" 
                                                        data-msg-number="请输入正确的格式" data-msg-minlength="请输入正确的格式" 
                                                        minlength="6" maxlength="6" placeholder="请输入正确的格式" value="${list.wtyb }">
                                                    </div>
                                                    <!-- <label class="col-sm-2 col-sm-2 control-label" style="width: 30%; margin-left: 2%; 
                                                    	   padding-top: 0px; margin-top: 3px;">
                                                    <a class="btn btn-xs btn-success" href="#myModalKhxx" style="width: 62%"
                                                    	   data-toggle="modal" type="button" onClick="getKhxx();">选择委托单位</a>
                                					</label> -->
                                                </div>

                                        <div class="form-group"
                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;
                                                     background:#ffffcd; color:#000;">
                                            <label class="col-sm-2 col-sm-2 control-label">被抽样单位：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="sjdw" name="sjdw" maxlength="36"
                                                placeholder="最多输入36个字" value="${list.sjdw }">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">被抽样单位地址：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="sjdwdz"
                                                       name="sjdwdz" maxlength="45" placeholder="最多输入45个字" value="${list.sjdwdz }">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">联系人：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="lxr" name="lxr" maxlength="8" 
                                                placeholder="最多输入8个字" value="${list.lxr }">
                                            </div>
                                        </div>

                                        <div class="form-group"
                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;
                                                     background:#ffffcd; color:#000;">
                                            <label class="col-sm-2 col-sm-2 control-label">手机号码：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="dh" name="dh" 
                                                placeholder="请输入正确的手机号码格式" data-rule-mobile="true" 
                                                data-msg-mobile="请输入正确的格式" value="${list.sjdwgddh }">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">电话：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="sjdwgddh" name="sjdwgddh" maxlength="17" 
                                                placeholder="最多输入17个字" value="${list.dh }">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">邮编：</label>

                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="yb" name="yb" data-rule-number="true" 
                                                data-msg-number="请输入正确的格式" data-msg-minlength="请输入正确的格式" 
                                                minlength="6" maxlength="6" placeholder="请输入正确的格式" value="${list.yb }">
                                            </div>
                                        </div>

                                        <div class="form-group"
                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;
                                                     background:#99ff99; color:#000;">
                                            <label class="col-sm-2 col-sm-2 control-label">标示生产者：</label>

                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="scdw" name="scdw" maxlength="36"
                                                placeholder="最多输入36个字" value="${list.scdw }">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">标示生产地址：</label>

                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="scdwdz" name="scdwdz" maxlength="45" 
                                                placeholder="最多输入45个字" value="${list.scdwdz }">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">标示生产联系人：</label>

                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="scdwlxr" name="scdwlxr" maxlength="8" 
                                                placeholder="最多输入8个字" value="${list.scdwlxr }">
                                            </div>
                                        </div>
                                        
                                        <div class="form-group"
                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;
                                                     background:#99ff99; color:#000;">
                                            <label class="col-sm-2 col-sm-2 control-label">手机号码：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="scdwdh" name="scdwdh" 
                                                placeholder="请输入正确的手机号码格式" data-rule-mobile="true" 
                                                data-msg-mobile="请输入正确的格式" value="${list.scdwdh }">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">标示生产者电话：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="scdwgddh" name="scdwgddh" maxlength="17"
                                                 placeholder="最多输入17个字" value="${list.scdwgddh }">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">标示生产者邮编：</label>

                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="scdwyb"
                                                       name="scdwyb" data-rule-number="true" 
                                                data-msg-number="请输入正确的格式" data-msg-minlength="请输入正确的格式" 
                                                minlength="6" maxlength="6"  placeholder="请输入正确的格式" value="${list.scdwyb }">
                                            </div>
                                        </div>
                                        <div style="text-align: center;margin-top: 10px;">
                                                <button class="btn btn-xs btn-success" style="width: 83px; height: 30px;" href="#myModalKhxx" 
                                                data-toggle="modal" type="button" onClick="getKhxx();">选择委托单位</button>
                                    			<button type="button" class="btn btn-xs btn-success" style="width: 128px; height: 30px;" onClick="getSjdw();">受检单位同委托单位</button>
                                				<button type="button" class="btn btn-xs btn-success" style="width: 128px; height: 30px;" onClick="getScdw();">生产单位同受检单位</button>		
                                        </div>
                                        <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">检验项目：</label>
                                                    <div class="col-sm-10">
										            <textarea class="form-control ckeditor textarea" rows="6" name="jyxm" id="jyxm" 
										            truetype="textarea" style="width: 409%;height: 35px;" maxlength="160" placeholder="最多输入160个字">${list.jyxm }</textarea>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">检验依据：</label>
                                                    <div class="col-sm-13">
													<textarea class="form-control ckeditor textarea" rows="6" name="jyyj" 
														truetype="textarea" style="width: 99.5%;height: 35px;" maxlength="75" 
                                                  placeholder="最多输入75个字">${list.jyyj}</textarea>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">检验费用：</label>
                                                    <c:if test="${sfzt != -1 }">
                                                    <div class="input-group m-bot15 col-sm-10" style="width: 19%;">
                                                        <input class="form-control" type="text" id="jyfy" name="jyfy" value="${list.jyfy }" 
                                                        data-msg-number="请输入正确的数字" data-gt="0"  maxlength="10" placeholder="最多输入10个数字"/>
                                                        <span class="input-group-addon">元</span>
                                                    </div>
                                                    </c:if>
                                                    <c:if test="${sfzt == -1 }">
                                                    <div class="input-group m-bot15 col-sm-10" style="width: 19%;">
                                                        <input class="form-control" type="text" id="jyfy" name="jyfy" value="${list.jyfy }" readonly="true" 
                                                        data-msg-number="请输入正确的数字" data-gt="0"  maxlength="10" placeholder="最多输入10个数字"/>
                                                        <span class="input-group-addon">元</span>
                                                    </div>
                                                    </c:if>
                                                    <label class="col-sm-2 col-sm-2 control-label">检验费用待定：</label>
                                                    <div class="col-sm-10" style="margin-top: 5px;">
                                                        <c:if test="${sfzt != -1 }">
                                                         <label><input type="radio" name="jyfydd" value="0">待定</label>
                                                        <label style="padding-left: 20px;"><input type="radio" name="jyfydd" 
                                                        value="1">不待定</label>
                                                    	<input type="hidden" name="jRadio" id="jRadio" value="${list.jyfydd }">
                                                    </c:if>
                                                    <c:if test="${sfzt == -1 }">
                                                        <label><input type="radio" name="jyfydd" value="0" readonly="true">待定</label>
                                                        <label style="padding-left: 20px;"><input type="radio" name="jyfydd" 
                                                        value="1">不待定</label>
                                                    	<input type="hidden" name="jRadio" id="jRadio" readonly="true" value="${list.jyfydd }">
                                                    </c:if>  
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">验后需退库：</label>
                                                    <div class="col-sm-10">
													<select class="form-control input-lg m-bot15" name="yhxtk" >
													<option selected = "selected" value="">请选择...</option>
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
                                                    <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>检验类型：</label>
                                                    <div class="col-sm-10">
													<select class="form-control input-lg m-bot15" name="jylx"
													required data-msg-required="必填" readonly="readonly">
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
													
                                                    <c:if test="${sfzt != -1 }">
                                                    <label class="col-sm-2 col-sm-2 control-label" style="margin-top: -5px;
                                                     margin-bottom: 5px; width: 13%;" >
                                                    <a class="btn btn-xs btn-success" href="#myModalJyhth" data-toggle="modal" 
                                                       type="button" onClick="getJyhth();" style="width:85%">检验合同号</a>
                                					</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="jyhth" name="jyhth"
                                                         maxlength="25" placeholder="最多输入25个字" value="${list.jyhth}">
                                                    </div>
                                                    </c:if>
                                                    <c:if test="${sfzt == -1 }">
                                                    <label class="col-sm-2 col-sm-2 control-label" style="margin-top: -5px;
                                                     margin-bottom: 5px; width: 13%;" >检验合同号</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="jyhth" name="jyhth" readonly="true"
                                                         maxlength="25" placeholder="最多输入25个字" value="${list.jyhth}">
                                                    </div>
                                                    </c:if>
                                                    <label class="col-sm-2 col-sm-2 control-label">检查封样人员：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="jcfyry" name="jcfyry" value="${list.jcfyry}" 
                                                        maxlength="8" placeholder="最多输入8个字">
                                                    </div>
                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">报告发送方式：</label>
                                                    <div class="col-sm-10" style="margin-top: 5px;width: 40%;">
                                                        <label><input type="radio" name="bgfsfs" value="0" checked="checked">邮寄</label>
                                                        <label><input type="radio" name="bgfsfs" value="1">自取（本院）</label>
                                                        <label><input type="radio" name="bgfsfs" value="2">自取（中心）</label>
                                                        <input type="hidden" name="bRadio" id="bRadio" value="${list.bgfsfs }">
                                                    </div>
                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">样品到达日期：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control Wdate" type="text"  
                                                        value="${list.dyrq}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" disabled >
                                                        <input class="form-control Wdate" type="hidden" id="dyrq" name="dyrq" 
                                                        value="${list.dyrq}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" >
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">完成期限：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control Wdate" type="text"   
                                                        value="${list.wcqx}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" disabled>
                                                        <input class="form-control Wdate" type="hidden" id="wcqx" name="wcqx" 
                                                        value="${list.wcqx}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" >
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">样品附件：</label>
							                        <div class="box">
						                                <input type="text" name="copyFile"  class="textbox" value="${list.fj}"/>
											            <a href="javascript:void(0);"  class="link">...</a>
											            <input type="file" class="uploadFile" name="file" id="attachMentFile"
											             onchange="getFile(this,'copyFile')" />
											            <input type="hidden" id="fj" name="fj">
													</div>
                                                </div>
                                                <div class="form-group"
                               style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">备注：</label>

                                                    <div class="col-sm-13">
													<textarea class="form-control ckeditor textarea" rows="6" name="bz" 
													truetype="textarea" style="width: 99.5%;height: 35px;" 
													placeholder="最多输入120个字" onKeyUp="checkLen(this,240)" >${list.bz}</textarea>
                                                    </div>
                                                </div>
                          <div style="text-align: center;margin-top: 10px;">
                  <div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 50px;">
                      <button type="submit" class="btn btn-primary" >修改</button>		
                  </div>
              </div>
              </div>
					</c:if>
					<c:if test="${list.djlx=='3' }">
						<div class="panel-body" style="overflow:scroll;overflow-x:hidden">
                                                <div class="form-group"
                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                            <input class="form-control" type="hidden" id="bgbh" name="bgbh" value="${ypxx.ypbh }" readonly="readonly">
		                    <input type="hidden" name="bgbhOld" id="bgbhOld" value="${ypxx.bgbh }">
		                    <input type="hidden" name="lysl" id="lysl" value="${ypxx.lysl }"> 
                            <label class="col-sm-2 col-sm-2 control-label"
                                   style="margin-top: 15px;" ><span style="color:red">*</span>检验科室：</label>

                            <div class="col-sm-10" style="margin-top: 21px;">
                                <input id="jyks" name="jyks" class="easyui-combotree" value="${list.jyks }"
                                       style="height: 34px;width: 238px;" readonly="true" />
                            </div>
                            <label class="col-sm-2 col-sm-2 control-label"
                                   style="margin-top: 18px;"><span style="color:red">*</span>字号名称：</label>

                            <div class="col-sm-10" style="margin-top: 21px;">
                                <input class="form-control" type="text" id="zh" name="zh" value="${list.zh }" readonly="readonly">
                            </div>
                            <label class="col-sm-2 col-sm-2 control-label" style="margin-top: 18px;">是否移交：</label>
                            <div class="col-sm-10" style="margin-top: 23px;">
                                <label><input type="radio" name="ypyj" value="0" >是</label>
                                <label style="padding-left: 20px;"><input type="radio" name="ypyj" value="1">否</label>
                            	<input type="hidden" name="Radio1" id="Radio1" value="${list.ypyj }">
                            </div>
                        </div>

                        <div class="form-group"
                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                            <label class="col-sm-2 col-sm-2 control-label"
                                   style="margin-top: 0px;"><span style="color:red">*</span>业务科室：</label>
                            <div class="col-sm-10" style="margin-top: 4px;">
                                <input id="ywks" name="ywks" class="easyui-combotree" value="${list.ywks }"
                                       style="height: 34px;" required readonly="true"/>
                            </div>
                            <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>样品编号：</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" id="ypbh" name="ypbh" value="${list.ypbh }" readonly="readonly">
                            </div>
                            <!-- <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>报告编号：</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="hidden" id="bgbh" name="bgbh" value="" readonly="readonly">
                            </div> -->
                            <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>产品名称：</label>
                            <div class="col-sm-10">
                                <input class="form-control" placeholder="必填且最多输入36个字" required data-msg-required="必填"
                                minlength="1" data-msg-minlength="必填" maxlength="36" type="text"
                                id="ypmc" name="ypmc" onBlur="changeCpmccx();" value="${list.ypmc }">
                            </div>
                        </div>

                        <div class="form-group"
                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                            <label class="col-sm-2 col-sm-2 control-label">产品等级：</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" id="ypdj" name="ypdj" maxlength="8" 
                                placeholder="最多输入8个字" value="${list.ypdj }">
                            </div>
                            <label class="col-sm-2 col-sm-2 control-label">商标：</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" id="sb" name="sb" value="${list.sb }"
                                maxlength="8" placeholder="最多输入8个字">
                            </div>
                            <label class="col-sm-2 col-sm-2 control-label" >是否为出口产品：</label>
					        <div class="col-sm-10">
					           <label><input type="radio" checked="checked" name="sfwckcp" value="0">是</label>
					           <label style="padding-left: 20px;"><input type="radio" id="sfwckcp" name="sfwckcp" value="1">否</label>
					           <input type="hidden" name="Radio2" id="Radio2" value="${list.sfwckcp }">
					        </div>
                        </div>

                        <div class="form-group"
                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                            <label class="col-sm-2 col-sm-2 control-label">任务来源：</label>
					       <div class="col-sm-10">
					           <input class="form-control" type="text" id="rwly" name="rwly" maxlength="36"
					           placeholder="最多输入36个字" value="${list.rwly }">
					       </div>
                            <label class="col-sm-2 col-sm-2 control-label">规格型号：</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" id="ggxh" name="ggxh" value="${list.ggxh }" 
                                maxlength="45" placeholder="最多输入45个字">
                            </div>
                            <label class="col-sm-2 col-sm-2 control-label">生产日期/批次：</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" id="scrqpc"
                                       name="scrqpc" value="${list.scrqpc }" 
                                       onKeyUp="checkLen(this,56)" placeholder="最多输入28个字">
                            </div>
                        </div>
                        
                        <div class="form-group"
						       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
						      
						      <label class="col-sm-2 col-sm-2 control-label">备样量及封存地点：</label>
						      <div class="col-sm-10">
						          <input class="form-control" type="text" id="byljfcdd" name="byljfcdd" maxlength="36"
						          placeholder="最多输入36个字" value="${list.byljfcdd }" >
						      </div>
						      <label class="col-sm-2 col-sm-2 control-label">寄送样地点：</label>
						      <div class="col-sm-10">
						          <input class="form-control" type="text" id="jsydd" name="jsydd" maxlength="36"
						          placeholder="最多输入36个字" value="${list.jsydd }">
						      </div>
						      <label class="col-sm-2 col-sm-2 control-label">寄送样截止日期：</label>
						      <div class="col-sm-10">
						          <input class="form-control Wdate" type="text" id="jsyjzrq"
						                 name="jsyjzrq" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${list.jsyjzrq }">
						      </div>
						 </div>


                         <div class="form-group"
                              style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                             <label class="col-sm-2 col-sm-2 control-label">封样状态：</label>
					         <div class="col-sm-10">
					             <input class="form-control" type="text" id="ypzt" name="ypzt" maxlength="38" 
					             placeholder="最多输入38个字" value="${list.ypzt }">
					         </div>
                             <label class="col-sm-2 col-sm-2 control-label">抽样单位：</label>
                             <div class="col-sm-10">
                                 <input class="form-control" type="text" id="cydw" name="cydw" value="${list.cydw }" 
                                 maxlength="36" placeholder="最多输入36个字">
                             </div>
						     <label class="col-sm-2 col-sm-2 control-label">抽样单位地址：</label>
						     <div class="col-sm-10">
							     <input class="form-control" type="text" id="cydwdz" name="cydwdz" maxlength="36"
							           placeholder="最多输入36个字" value="${list.cydwdz }" >
						     </div>
                         </div>

                         <div class="form-group"
					           style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
					          <label class="col-sm-2 col-sm-2 control-label">抽样单位联系人：</label>
					          <div class="col-sm-10">
					              <input class="form-control" type="text" id="cyry" name="cyry" maxlength="8" 
					              placeholder="最多输入8个字" value="${list.cyry }">
					          </div>
					          <label class="col-sm-2 col-sm-2 control-label">抽样单位电话：</label>
					          <div class="col-sm-10">
					              <input class="form-control" type="text" id="cydwlxdh" name="cydwlxdh" maxlength="17" 
					              placeholder="最多输入17个字" value="${list.cydwlxdh }">
					          </div>
					          <label class="col-sm-2 col-sm-2 control-label">邮政编码：</label>
					          <div class="col-sm-10">
					              <input class="form-control" type="text" id="cydwyzbm" name="cydwyzbm" maxlength="8" 
					              placeholder="最多输入8个字" value="${list.cydwyzbm }"/> 
					          </div>	
					     </div>

           <div class="form-group"
                style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
               <label class="col-sm-2 col-sm-2 control-label">传真/Email：</label>
               <div class="col-sm-10">
                   <input class="form-control" type="text" id="czemail" name="czemail" maxlength="15"
                    placeholder="最多输入15个字" value="${list.czemail }"/> 
               </div>
               <label class="col-sm-2 col-sm-2 control-label">抽样数量：</label>
               <div class="col-sm-10">
                   <input class="form-control" type="text" id="cysl" name="cysl" maxlength="45" 
                   placeholder="最多输入45个字" value="${list.cysl }">
               </div>
               <label class="col-sm-2 col-sm-2 control-label">抽样日期：</label>
               <div class="col-sm-10">
                   <input class="form-control Wdate" type="text" id="cyrq"
                          name="cyrq" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${list.cyrq }">
               </div>
           </div>
                                              
                                              <div class="form-group"
                       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                      <label class="col-sm-2 col-sm-2 control-label">抽样基数/批量：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="cyjs" name="cyjs" 
                          onKeyUp="checkLen(this,30)" placeholder="最多输入15个字"/>  value="${list.cyjs }"/> 
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">受检单位：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="sjdw" name="sjdw" maxlength="36"
                          placeholder="最多输入36个字" value="${list.sjdw }">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">受检单位地址：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="sjdwdz"
                                 name="sjdwdz" maxlength="45" placeholder="最多输入45个字" value="${list.sjdwdz }">
                      </div>
                  </div>
                  
                  <div class="form-group" 
                  		style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                      <label class="col-sm-2 col-sm-2 control-label">联系人：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="lxr" name="lxr" maxlength="8" 
                          placeholder="最多输入8个字" value="${list.lxr }">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">电话：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="sjdwgddh" name="sjdwgddh" maxlength="17" 
                          placeholder="最多输入17个字" value="${list.sjdwgddh }">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">受检单位法人代表：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="sjdwfrdb" name="sjdwfrdb" maxlength="8" 
                          placeholder="最多输入8个字" value="${list.sjdwfrdb }">
                      </div>
                  </div>
                  
                  <div class="form-group"
                       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                      <label class="col-sm-2 col-sm-2 control-label">生产单位：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="scdw" name="scdw" maxlength="36"
                          placeholder="最多输入36个字" value="${list.scdw }" >
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">生产单位地址：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="scdwdz"
                                 name="scdwdz" maxlength="45" placeholder="最多输入45个字" value="${list.scdwdz }">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">生产单位联系人：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="scdwlxr"
                                 name="scdwlxr" maxlength="8" placeholder="最多输入8个字" value="${list.scdwlxr }">
                      </div>
                  </div>
                  
                  <div class="form-group"
                       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                       <label class="col-sm-2 col-sm-2 control-label">生产单位电话：</label>

                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="scdwdh"
                                 name="scdwdh" maxlength="17" placeholder="最多输入17个字" value="${list.scdwdh }">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">生产单位邮证编码：</label>

                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="scdwyb"
                                 name="scdwyb" data-rule-number="true" 
                          data-msg-number="请输入正确的格式" data-msg-minlength="请输入正确的格式" 
                          minlength="6" maxlength="6" placeholder="请输入正确的格式"  value="${list.scdwyb }">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">生产单位法人代表：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="scdwfrdb"
                                 name="scdwfrdb" maxlength="8" placeholder="最多输入8个字" value="${list.scdwfrdb }">
                      </div>
                  </div>
                  
                  <div class="form-group"
                       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                      <label class="col-sm-2 col-sm-2 control-label">营业执照：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="yyzz" name="yyzz" maxlength="35" 
                          placeholder="最多输入35个字" value="${list.yyzz }">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">机构代码：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="jgdm" name="jgdm" maxlength="35" 
                          placeholder="最多输入35个字" value="${list.jgdm }">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">经济类型：</label>
                      <div class="col-sm-10">
						<select class="form-control input-lg m-bot15" name="jjlx" >
						<option selected = "selected" value="">请选择...</option>
						<c:forEach items="${jjlx}" var="jjlx">
               				<c:choose>
                   			<c:when test="${jjlx.zdz == list.jjlx}">
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
                          <input class="form-control" type="text" id="rs" name="rs" maxlength="36"
                          placeholder="最多输入36个字" value="${list.rs }">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">企业产值：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="cz"
                                 name="cz" maxlength="36" placeholder="最多输入36个字" value="${list.cz }">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label">企业产量：</label>
                      <div class="col-sm-10">
                          <input class="form-control" type="text" id="cl"
                                 name="cl" maxlength="36" placeholder="最多输入36个字" value="${list.cl }">
                      </div>
                  </div>
                  
                  <div class="form-group"
                       style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                      <label class="col-sm-2 col-sm-2 control-label">证书类型：</label>
                      <div class="col-sm-10">
							<select class="form-control input-lg m-bot15" name="zslx" >
								<option selected = "selected" value="">请选择...</option>
								<c:forEach items="${zslx}" var="zslx">
	               				<c:choose>
	                   			<c:when test="${zslx.zdz == list.zslx}">
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
                          <input class="form-control" type="text" id="zsbh" name="zsbh" maxlength="35" 
                          placeholder="最多输入35个字" value="${list.zsbh }">
                      </div>
                      <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>检验类型：</label>
                      <div class="col-sm-10">
						<select class="form-control input-lg m-bot15" name="jylx"
						required data-msg-required="必填">
							<c:forEach items="${jylx}" var="jylx">
                   				<c:choose>
                       			<c:when test="${jylx.zdz == list.jylx}">
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
                                            
                  <div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                       <label class="col-sm-2 col-sm-2 control-label">检验项目：</label>
                       <div class="col-sm-10">
			            <textarea class="form-control ckeditor textarea" rows="6" name="jyxm" id="jyxm" 
			            truetype="textarea" style="width: 409%;height: 35px;" maxlength="160" placeholder="最多输入160个字">${list.jyxm }</textarea>
                       </div>
	              </div>
                         
                 <div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
	                    <label class="col-sm-2 col-sm-2 control-label">检验依据：</label>
	                    <div class="col-sm-13">
	                    	<textarea class="form-control ckeditor textarea" rows="6" name="jyyj" truetype="textarea" 
	                    	style="width: 99.5%;height: 35px;" maxlength="75" placeholder="最多输入75个字">${list.jyyj}</textarea>
	                	</div>
                 </div>
                                                
                 <div class="form-group" style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                        <label class="col-sm-2 col-sm-2 control-label">检验费用：</label>
                        <c:if test="${sfzt != -1 }">
                        <div class="input-group m-bot15 col-sm-10" style="width: 19%;">
                            <input class="form-control" type="text" id="jyfy" name="jyfy" value="${list.jyfy }" 
                            data-msg-number="请输入正确的数字" data-gt="0"  maxlength="10" placeholder="最多输入10个数字"/>
                            <span class="input-group-addon">元</span>
                        </div>
                        </c:if>
                        <c:if test="${sfzt == -1 }">
                        <div class="input-group m-bot15 col-sm-10" style="width: 19%;">
                            <input class="form-control" type="text" id="jyfy" name="jyfy" value="${list.jyfy }" readonly="true" 
                            data-msg-number="请输入正确的数字" data-gt="0"  maxlength="10" placeholder="最多输入10个数字"/>
                            <span class="input-group-addon">元</span>
                        </div>
                        </c:if>
                        <label class="col-sm-2 col-sm-2 control-label">检验费用待定：</label>
                        <div class="col-sm-10" style="margin-top: 5px;">
                            <c:if test="${sfzt != -1 }">
	                              <label><input type="radio" name="jyfydd" value="0">待定</label>
	                             <label style="padding-left: 20px;"><input type="radio" name="jyfydd" 
	                             value="1">不待定</label>
	                         	<input type="hidden" name="jRadio" id="jRadio" value="${list.jyfydd }">
	                         </c:if>
	                         <c:if test="${sfzt == -1 }">
	                             <label><input type="radio" name="jyfydd" value="0" readonly="true">待定</label>
	                             <label style="padding-left: 20px;"><input type="radio" name="jyfydd" 
	                             value="1">不待定</label>
	                         	<input type="hidden" name="jRadio" id="jRadio" readonly="true" value="${list.jyfydd }">
	                         </c:if> 
                        </div>
                        <label class="col-sm-2 col-sm-2 control-label">验后需退库：</label>
                        <div class="col-sm-10">
                        <select class="form-control input-lg m-bot15" name="yhxtk" >
                            <option selected = "selected" value="">请选择...</option>
                            <c:forEach items="${yhxtk}" var="yhxtk">
                  				<c:choose>
                      			<c:when test="${yhxtk.zdz == list.yhxtk}">
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
                                                    <label class="col-sm-2 col-sm-2 control-label">备注：</label>

                                                    <div class="col-sm-13">
													<textarea class="form-control ckeditor textarea" rows="6" name="bz" 
													truetype="textarea" style="width: 99.5%;height: 35px;" 
													placeholder="最多输入120个字" onKeyUp="checkLen(this,240)" >${list.bz}</textarea>
                                                    </div>
                                                </div>
                          <div style="text-align: center;margin-top: 10px;">
                  <div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 50px;">
                      <button type="submit" class="btn btn-primary" >修改</button>		
                  </div>
              </div>
              </div>
					</c:if>
              </c:forEach>
              </form>                      
         </div>
</div>
<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="sfModal" class="modal fade">
	<div class="modal-dialog">
	    <div class="modal-content">
	        <!-- <div class="modal-header">
	        <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
	        <h4 class="modal-title">抽样人员选择</h4>
	    </div> -->
	    <div class="modal-body">
	        <!-- <form class="form-horizontal" role="form"> -->
	        <!-- <section class="panel" id="sect"> -->
	            <header class="panel-heading">检验收费项目</header>
	            <label style="margin-left: 6px;">产品名称:</label>&nbsp;<input id="cpmccx" name="cpmccx" >&nbsp;&nbsp;&nbsp;
	            <label>项目名称:</label>&nbsp;&nbsp;&nbsp;<input id="xmmccx" name="xmmccx">
	            <button onClick="getSfxmmx(0);">查询</button>
	            <button onClick="dyqd();">打印</button><br/>
	            <label style="margin-left: 6px;" id="yxxm">已选项目:</label> <!-- <textarea rows="2" id="mcxs" name="mcxs" truetype="textarea" style="width: 85%;"></textarea> -->
	            
	            <form class="form-horizontal tasi-form" name="xmForm" id="xmForm" method="post">
		            <div id="hidden" align="center" style="display:'none'">
					     <input type="hidden" name="num" id="num" value="${ysfxmLen}">
					     <input type="hidden" name="bgbh1" id="bgbh1" >
					</div>
	            <table style="width: 100%;">
					<tr>
						<th>产品名称</th>
						<th>项目名称</th>
						<th style="display: none">项目编号</th>
						<th>单价金额</th>
						<th>计量单位</th>
						<th>检验次数</th>
						<th>修改金额</th>
						<th>操作</th>
					</tr>
					
					<tbody id="mybody">
						<tr id="tr" style="display: none" ><td></td></tr>
						<c:forEach var="ysfxm" items="${ysfxm}" varStatus="obj">
							<tr id="mybody${obj.count }">
								<td>${ysfxm.cpmc}<input type="text" type="hidden" class="hidden" id="cpmc${obj.count }" name="cpmc${obj.count }" value="${ysfxm.cpmc}"/></td>
								<td>${ysfxm.xmmc}<input type="text" type="hidden" class="hidden" id="xmmc${obj.count }" name="xmmc${obj.count }" value="${ysfxm.xmmc}"/></td>
								<td style="display: none"><input type="text" type="hidden" class="hidden" id="xmbh${obj.count }" name="xmbh${obj.count }" value="${ysfxm.xmbh}"/></td>
								<td>${ysfxm.je}<input type="text" type="hidden" class="hidden" id="dj${obj.count }" name="dj${obj.count }" value="${ysfxm.je}"/></td>
								<td>${ysfxm.jldw}<input type="text" type="hidden" class="hidden" id="jldw${obj.count }" name="jldw${obj.count }" value="${ysfxm.jldw}"/></td>
								<td><input type="text" style="width:40px" class="jycs" id="sl${obj.count }" name="sl${obj.count }" value="${ysfxm.sl}" onblur="getXgje('${obj.count }');"/></td>
								<td><input type="text" style='width:40px' class="xgje" id="xgje${obj.count }" name="xgje${obj.count }" value="${ysfxm.xgje}" /></td>
								<td><a href='javascript:;' onclick="deleteTr('${obj.count }');"><span style='text-align: right;' >
									<img src='<%=path%>/resources/images/iconfont-shanchu.png' alt='删除' height='25px' width='25px' style='margin-bottom: 5px;'/>
									</span></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</form>
	<!-- <div class="form-group" style="padding-bottom: 2px; padding-top: 0px; margin-bottom: 0px; 
	                                   width: 100%; margin-left: 0px; margin-right: 0px;">
	               <label style="margin-left: 6px;">费用合计:</label>
	               <input id="fyhj" id="num" name="fyhj">
	               </div> -->
	            <!-- <div id="Div1" style="overflow:auto"></div>
	            <span id="sbz"></span>
	            <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
	                <div class="col-lg-offset-2 col-lg-10" style="margin-top: 10px;">
	                    <button type="button" class="btn btn-default" onclick="getSfxmmx(1);"
	                            style="margin-left: 120px;">加载更多...
	                    </button>
	                </div>
	            </div> -->
	            <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
	                <div class="col-lg-offset-2 col-lg-10" style="margin-top: 10px;">
	                    <button type="button" class="btn btn-default" onClick="selectSfxmmx();" 
	                    		style="margin-left: 100px;">确定
	                    </button>
	                    <button type="button" class="btn btn-default" onClick="closeWin();"
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
<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalKhxx" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h4 class="modal-title">抽样人员选择</h4>
            </div> -->
            <div class="modal-body">
                <!-- <form class="form-horizontal" role="form"> -->
                <section class="panel" id="sectKhxx">
                    <header class="panel-heading">选择委托单位</header>
                    <label style="margin-left: 6px;">客户名称:</label>&nbsp;&nbsp;&nbsp;<input id="khmccx" name="khmccx">&nbsp;&nbsp;&nbsp;
                    <label>客户分类:</label>&nbsp;&nbsp;&nbsp;<input id="khflcx" name="khflcx">
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

<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalJyhth" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h4 class="modal-title">抽样人员选择</h4>
            </div> -->
            <div class="modal-body">
                <!-- <form class="form-horizontal" role="form"> -->
                <section class="panel" id="sectJyhth">
                    <header class="panel-heading">技术服务管理</header>
                    <label style="margin-left: 6px;">客户名称:</label>&nbsp;&nbsp;&nbsp;<input id="jyhthkhmc" name="jyhthkhmc">&nbsp;&nbsp;&nbsp;
                    <label>客户地址:</label>&nbsp;&nbsp;&nbsp;<input id="jyhthkhdz" name="jyhthkhdz">
                    <button onClick="getJyhth();">查询</button>
                    <span id="sbzJyhth"></span>
                    <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
                        <div class="col-lg-offset-2 col-lg-10" style="margin-top: 40px;">
                            <button type="button" class="btn btn-default" onClick="closeJyhth();"
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

<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalYpxx" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h4 class="modal-title">抽样人员选择</h4>
            </div> -->
            <div class="modal-body">
                <!-- <form class="form-horizontal" role="form"> -->
                <section class="panel" id="sectYpxx">
                    <header class="panel-heading">样品信息</header>
                    <label style="margin-left: 6px;">样品编号:</label>&nbsp;&nbsp;&nbsp;<input id="ypbhcx" name="ypbhcx">&nbsp;&nbsp;&nbsp;
                    <label>样品名称:</label>&nbsp;&nbsp;&nbsp;<input id="ypmccx" name="ypmccx">
                    <button onClick="getYpxxList(0);">查询</button>
                    <span id="sbzYpxx"></span>
                    <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
                        <div class="col-lg-offset-2 col-lg-10" style="margin-top: 10px;">
                            <button type="button" class="btn btn-default" onclick="getYpxxList(1);"
                                    style="margin-left: 120px;">加载更多...
                            </button>
                        </div>
                    </div>
                    <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
                        <div class="col-lg-offset-2 col-lg-10" style="margin-top: 40px;">
                            <button type="button" class="btn btn-default" onClick="closeYpxxWin();"
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


<div class="panel panel-success" style="height: 430px;">
    <div class="panel-heading">报告信息:</div>
    <input type="hidden" name="ypid" value="${mapBusi.id}"/>
    <form class="form-horizontal tasi-form" name="Form" id="Form" method="post">
        <input type="hidden" id="ypid" name="ypid" value="${ypid }">
        <input type="hidden" id="fmid" name="fmid" value="${fmid }">
        <input type="hidden" id="syid" name="syid" value="${syid }">
        <input type="hidden" id="fyid" name="fyid" value="${fyid }">
        <input type="hidden" id="bsdxtwo" name="bsdxtwo" value="">
        <input type="hidden" id="rzfs" name="rzfs" value="${rzfs }">
        <input type="hidden" name="bgbh" value="${mapBusi.ypbh}" />
        <input type="hidden" id="dw" name="dw" value="${dw }">
        <input type="hidden" id="pzz" name="pzz" value="${pzz }">
        <input type="hidden" id="bztsbg" name="bztsbg" value="${bztsbg }">
<%--         <input type="hidden" name="fpsj" value="${fpsj}">    任务分配时间 --%>
        <div class="form-group"
             style="padding-bottom: 2px; margin-bottom: 0px; padding-top: 0px; width: 101%;height: 313px;">
             
            <label class="col-sm-2 control-label" style="width: 16%;">检验日期：</label>
            <div class="col-sm-10" style="top: 1%;">
            	<c:choose>
						<c:when test="${jyrq == ''}">
							<input class="form-control" type="text" id="jyrq"
								name="jyrq">
						</c:when>
						<c:otherwise>
							<input class="form-control" type="text" id="jyrq"
								name="jyrq" value="${jyrq }">
						</c:otherwise>
				</c:choose>
<%-- 					<c:choose> --%>
<%-- 						<c:when test="${jyrq == ''}"> --%>
<!-- 							<input class="form-control Wdate" type="text" id="jyrq" -->
<!-- 								name="jyrq" onClick="WdatePicker({minDate:maxDate})"> -->
<%-- 						</c:when> --%>
<%-- 						<c:otherwise> --%>
<!-- 							<input class="form-control Wdate" type="text" id="jyrq" -->
<%-- 								name="jyrq" value="${jyrq }" --%>
<!-- 								onClick="WdatePicker({minDate:maxDate})"> -->
<%-- 						</c:otherwise> --%>
<%-- 					</c:choose> --%>
				</div>
<!--             <label class="col-sm-2 control-label" style="width: 16%;">检验结束日期：</label> -->
<!--             <div class="col-sm-10" style="width: 18%;top: 1%;"> -->
<%--             	<c:choose> --%>
<%--             		<c:when test="${empty jyjsrq }"> --%>
<!--             			<input class="form-control Wdate" type="text" id="jyjsrq" -->
<!-- 								name="jyjsrq" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"> -->
<%--             		</c:when> --%>
<%--             		<c:otherwise> --%>
<%--             			<input class="form-control Wdate" type="text" id="jyjsrq" value="${jyjsrq }" --%>
<!-- 								name="jyjsrq" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"> -->
<%--             		</c:otherwise> --%>
<%--             	</c:choose> --%>
            	
<!--             </div> -->
            <label class="col-sm-2 control-label" style="right: 80%;top:2%;width: 16%;width: 80%">检验结论：</label>
            <div class="col-sm-13" style="left: 16.8%; padding-left: 0px;top: -6%;width:75%">
            <c:choose>
            	<c:when test="${empty jyjl}">
					<textarea class="form-control ckeditor textarea" rows="6"
	                          name="jyjl" id="jyjl" truetype="textarea" style="height: 56px;resize:none;width: 87%;"maxlength="200" 
	                          onchange="this.value=this.value.substring(0, 200)" onkeydown="this.value=this.value.substring(0, 200)"></textarea>
                </c:when>
                <c:otherwise>
		            <textarea class="form-control ckeditor textarea" rows="6" 
		                          name="jyjl" id="jyjl" truetype="textarea" style="height: 56px;resize:none;width: 87%;"maxlength="200" 
	                          onchange="this.value=this.value.substring(0, 200)" onkeydown="this.value=this.value.substring(0, 200)">${jyjl }</textarea>
	            </c:otherwise>
	        </c:choose>
		        <div style="width: 11%; position: relative; float: right;margin-top: -5%; ">
	            	<a href="#myModaltwo" data-toggle="modal" onClick="jyyy();" class="btn btn-success">检验结论</a>
	            </div>
            </div>
            <label class="col-sm-2 control-label" style="right: 75%;top: 15%;width:16%">检验情况说明：</label>
            <div class="col-sm-13" style="left: 16.8%; padding-left: 0px;top: -2%;width:80%">
            <c:choose>
            	<c:when test="${empty jyqksm }">
            		<textarea class="form-control ckeditor textarea" rows="6" 
		                          name="jyqksm" id="jyqksm" truetype="textarea" style="height: 56px;resize:none;"maxlength="200" 
	                          onchange="this.value=this.value.substring(0, 200)" onkeydown="this.value=this.value.substring(0, 200)" 
	                          onkeyup="this.value=this.value.substring(0, 200)"></textarea>
            	</c:when>
            	<c:otherwise>
            		<textarea class="form-control ckeditor textarea" rows="6" 
		                          name="jyqksm" id="jyqksm" truetype="textarea" style="height: 56px;resize:none;"maxlength="200" 
	                          onchange="this.value=this.value.substring(0, 200)" onkeydown="this.value=this.value.substring(0, 200)" 
	                          onkeyup="this.value=this.value.substring(0, 200)">${jyqksm }</textarea>
            	</c:otherwise>
            </c:choose>
            </div>
            <label class="col-sm-2 control-label" style="right: 80%;top: 20%;width:16%">认证方式：</label>
            <div class="col-sm-13  hehe">
                <table class="table" style="width: 100%; margin-bottom: 0px;">
                    <c:forEach var="rztb" items="${rztb}" varStatus="obj">
                        <tbody style="border-top: 0px; float: left; height: 110px; width: 20%;">
	                        <tr>
	                            <td style="border-top-width: 0px; float: left;width:105%">
		                            <input name="rztbids" style="float: left;" value="${rztb.id }" id="rztbids_${obj.count }" type="checkbox"
		                                    onclick="showImg('img_${obj.count }');"/> 
		                            <span style="float: left"> 
		                            	<label class="label_check1"  for="rztbids_${obj.count }"> &nbsp;&nbsp;${rztb.rzmc }</label>
									</span>
	                                <div style="display: none; position: absolute; z-index: 1; margin-left: 20px;" id="img_${obj.count }">
		                                <img alt="${rztb.rzmc }" style="width: 107px; margin-top: 16px;position:absolute; z-index:1"
		                                         src="<%=path %>/${rztb.fjlj }/${rztb.sub }">
	                                </div>
	                            </td>
	                        </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>
            <div style="position: relative;top: 4%;" class="col-sm-13">
            	<c:choose>
            		<c:when test="${bztsbg == 1 }">
            			<label class="label_check c_on" for="checkbox-1" id="lable1" 
			            	style="display:inline-block;cursor:pointer;width: 21px; height: 21px;margin-left: 7%; margin-top: 0.5%;">
			            	<input type="checkbox" class="label_check" name="tsbg" value="1" id="checkbox-1" onclick="gouxuan();" style="float: left;">
			            	<span style="float: left;position: absolute;font-size:16px;">是</span>
	           		 	</label>
            		</c:when>
            		<c:otherwise>
            			<label class="label_check" for="checkbox-1" id="lable1" 
			            	style="display:inline-block;cursor:pointer;width: 21px; height: 21px;margin-left: 7%; margin-top: 0.5%;">
			            	<input type="checkbox" class="label_check" name="tsbg" value="1" id="checkbox-1" onclick="gouxuan();" style="float: left;">
			            	<span style="float: left;position: absolute;font-size:16px;">是</span>
	           		 	</label>
            		</c:otherwise>
            	</c:choose>
	            <span class="col-sm-2 control-label" id="checkbox-1" style="left:5.4%;">是否为特殊报告：</span>
		    </div>
		    <c:choose>
		    	<c:when test="${bztsbg == 1 }">
		    		<div id="syone" style="display:none;position: relative;top: 4%;text-align: center;width: 100%;" class="col-sm-13">
		    			<input type="button" class="btn btn-primary" onclick="bcsy('${mapBusi.bgbh}');" value="保存首页" style="margin-left: 5%;"/>
        			</div>
        			<div id="sytwo" style="position: relative;top: 4%;text-align: center;width: 100%;" class="col-sm-13">
		    			<input type="button" class="btn btn-primary" onclick="TSbcsy('${mapBusi.bgbh}');" value="保存首页" style="margin-left: 5%;"/>
        			</div>
		    	</c:when>
		    	<c:otherwise>
		    		<div id="syone" style="position: relative;top: 4%;text-align: center;width: 100%;" class="col-sm-13">
		    			<input type="button" class="btn btn-primary" onclick="bcsy('${mapBusi.bgbh}');" value="保存首页" style="margin-left: 5%;"/>
        			</div>
        			<div id="sytwo" style="display:none;position: relative;top: 4%;text-align: center;width: 100%;" class="col-sm-13">
		    			<input type="button" class="btn btn-primary" onclick="TSbcsy('${mapBusi.bgbh}');" value="保存首页" style="margin-left: 5%;"/>
        			</div>
		    	</c:otherwise>
		    </c:choose>
        </div>
    </form>
</div>

<!-- 审批意见表单填写 -->
<form name="submitForm" id="optionForm" method="post">
    <div class="panel panel-success">
        <div id="opinionDiv1" class="panel-heading"><span style="color: red">*</span> 选择检验审核人:</div>
        <br>
        <div class="input-group" style="width: 100%;margin: auto;">
        <c:choose>
        	<c:when test="${empty bsdx }">
	            <select class="form-control input-sm" name="jyshry" id="bsdx" style="width:95%; margin-left: 20px;">
	                 	<option value="">请选择...</option>
	                <c:forEach var="data" items="${listypzjshUser}" varStatus="status">
	                    <option value="${data.dlm}">${data.xm}</option>
	                </c:forEach>
	            </select>
        	</c:when>
        	<c:otherwise>
        		<select class="form-control input-sm" name="jyshry" id="bsdx" style="width:95%; margin-left: 20px;">
	                 	<option value="${bsdx }">${bsdx }</option>
	                <c:forEach var="data" items="${listypzjshUser}" varStatus="status">
	                    <option value="${data.dlm}">${data.xm}</option>
	                </c:forEach>
	            </select>
        	</c:otherwise>
        </c:choose>
        </div>
        <br>
        <div id="opinionDiv" class="panel-heading">操作:</div>
        <div class="panel-body">

            <input type="hidden" name="projectName" id="projectName" value="${pageContext.request.contextPath}"/>
            <input type="hidden" name="businessKey" value="${businessKey}"/>
            <input type="hidden" name="taskId" value="${taskId}"/>
            <input type="hidden" name="userCode" value="${userCode}"/>
            <input type="hidden" name="lineVariable" id="lineVar"  value="${lineVar}"/>
            <input type="hidden" name="tname" id="tname" value="${tname}"/>
            <input type="hidden" name="ypbh" value="${mapBusi.ypbh}" />
			<input type="hidden" name="ypmc" value="${mapBusi.ypmc}" />
            <input type="hidden" name="value" id="valueInputId"/>
<!--             <textarea class="form-control" rows="3" name="optionContent" id="optinoContentId"></textarea> -->
            <textarea name="signData" hidden=true cols="60" rows="6" id="signDataID"></textarea>
            <div>
                <br>
				<c:choose>
					<c:when test="${bztsbg == 1 }">
					    <div id="sgan" style="display: none;">
					    	<input type="button" class="btn btn-primary" onclick="scfy('${mapBusi.bgbh}');" 
					    		value="删除附页" style="margin-left: 25%;background-color: #f08080;border-color: #f08080;"/>
							<input class="btn btn-success" type="button" onClick="edit();" value="编辑附页" style="margin-left: 5%;">
							<a href="#myModal" data-toggle="modal" onClick="fuzhi(0);" class="btn btn-success" style="margin-left: 5%;">复制附页</a>
			                <input type="button" class="btn btn-primary" onclick="ylbg('${mapBusi.bgbh}');" value="报告生成" style="margin-left: 5%;"/>
			                <input type="button" class="btn btn-primary" onclick="zjtj('${mapBusi.bgbh}');" value="提交" style="margin-left: 5%;"/>
						</div>
	                
		           		<div id="tsbgdiv">
		           		<input type="button" class="btn btn-primary" onclick="sctsfy('${mapBusi.bgbh}');" 
					    		value="删除特殊报告" style="margin-left: 20%;background-color: #f08080;border-color: #f08080;"/>
					    	<input type="button" class="btn btn-success" onclick="tsbg()" value="特殊报告" style="margin-left: 15%;"/>
					    	<input type="button" class="btn btn-primary" onclick="zjtj('${mapBusi.bgbh}');" value="提交" style="margin-left: 16.5%;"/>
					    </div>
					</c:when>
					<c:otherwise>
						<div id="sgan">
					     	<input type="button" class="btn btn-primary" onclick="scfy('${mapBusi.bgbh}');" 
					     		value="删除附页" style="margin-left: 25%;background-color: #f08080;border-color: #f08080;"/>
							<input class="btn btn-success" type="button" onClick="edit();" value="编辑附页" style="margin-left: 5%;">
							<a href="#myModal" data-toggle="modal" onClick="fuzhi(0);" class="btn btn-success" style="margin-left: 5%;">复制附页</a>
			                <input type="button" class="btn btn-primary" onclick="ylbg('${mapBusi.bgbh}');" value="报告生成" style="margin-left: 5%;"/>
			                <input type="button" class="btn btn-primary" onclick="zjtj('${mapBusi.bgbh}');" value="提交" style="margin-left: 5%;"/>
						</div>
	                
		           		<div id="tsbgdiv" style="display: none;">
		           		<input type="button" class="btn btn-primary" onclick="sctsfy('${mapBusi.bgbh}');" 
					    		value="删除特殊报告" style="margin-left: 20%;background-color: #f08080;border-color: #f08080;"/>
					    	<input type="button" class="btn btn-success" onclick="tsbg()" value="特殊报告" style="margin-left: 15%;"/>
					    	<input type="button" class="btn btn-primary" onclick="zjtj('${mapBusi.bgbh}');" value="提交" style="margin-left: 16.5%;"/>
					    </div>
					</c:otherwise>
				</c:choose>
					
		                
            </div>

        </div>
    </div>
</form>
<!--历史审批意见-->
<div class="panel panel-success">
    <!-- Default panel contents -->
    <div class="panel-heading">历史阶段意见:</div>
    <!-- Table -->
    <table class="table table-striped table-bordered" style="margin: auto;table-layout:fixed;font-size: 12px">
        <tr style="font-size: 13px">
            <td style="width:50px;font-weight: bold;" align="center">阶段</td>
            <td style="font-weight: bold;" width="50" align="center">操作人</td>
            <td style="font-weight: bold;" width="40" align="center">审批动作</td>
            <td style="font-weight: bold;" width="260" align="center">审批意见</td>
            <td style="font-weight: bold;" width="110" align="center">操作时间</td>
        </tr>
        <c:forEach var="data" items="${listOption}" varStatus="status">
            <tr>
                <td align="center" style="word-wrap:break-word">${data.shjdmc}</td>
                <td align="center" style="word-wrap:break-word">${data.shr}</td>
                <td align="center" style="word-wrap:break-word">
                    <c:if test="${data.shzt == '1'}">
                        通过
                    </c:if>
                    <c:if test="${data.shzt == '0'}">
                        不通过
                    </c:if>
                    <c:if test="${data.shzt == '3'}">
                        解锁
                    </c:if>
                    <c:if test="${data.shzt == '2'}">
                        归档
                    </c:if>
                </td>
                <td id="optionContentId${data.shyj}"
                        <c:if test="${data.signData == ''}">
                            class="optionContentClass"
                        </c:if>
                        <c:if test="${data.signData != ''}">
                            class="optionContentSignClass"
                        </c:if>
                    align="center" style="word-wrap:break-word">${data.shyj}</td>
                <td align="center" style="word-wrap:break-word">${data.shsj}</td>
            </tr>
        </c:forEach>
    </table>
</div>

 <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
  <div class="modal-dialog" style="left: 0; width:91%;">
	  <div class="modal-content">
		    <div class="modal-body">
					<section class="panel" id="sect">
					   <header class="panel-heading" style="font-weight: bold;">选择报告</header>
					    <div style="width: 33%;float:left;height: 27px">
					    	<label class="cxtj">报告编号:</label>&nbsp;&nbsp;&nbsp;
					    	<input  id="cxbgbh" name="cxbgbh" class="wbk" style="width: 59%;">&nbsp;&nbsp;&nbsp;
					    </div>
	                    <div style="width: 33%;float: left;height: 27px;">
	                    	<label class="cxtj">报告编制人:</label>&nbsp;&nbsp;&nbsp;
	                    	<input id="cxbzr" name="cxbzr" class="wbk" style="width: 53%;">&nbsp;&nbsp;&nbsp;
	                    </div>
	                    <div style="width: 34%;float:left;height:27px;">
	                    	<label class="cxtj">委 托 单 位 :</label>&nbsp;&nbsp;&nbsp;
	                    	<input id="cxwtdw" name="cxwtdw" class="wbk" style="width: 57%;">&nbsp;&nbsp;&nbsp;
                    	</div>
                    	<div style="width: 33%;float:left;height: 27px;">
	                    	<label class="cxtj">受检单位:</label>&nbsp;&nbsp;&nbsp;
	                    	<input id="cxsjdw" name="cxsjdw" class="wb" style="width: 59%;">&nbsp;&nbsp;&nbsp;
	                    </div>
	                    <div style="width: 33%;float:left;height: 27px;">
	                    	<label class="cxtj">样  品  名  称 :</label>&nbsp;&nbsp;&nbsp;
	                    	<input id="cxypmc" name="cxypmc" class="wbk" style="width: 53%;margin-left: -0.5%;">&nbsp;&nbsp;&nbsp;
	                    </div>
	                    <div style="width: 33%;float:left;height: 27px;">
		                    <label class="cxtj">检验开始时间:</label>&nbsp;&nbsp;&nbsp;
		                    	<input id="cxjyrq" name="cxjyrq" class="wbk" style="width: 58.5%; margin-left: -3.3%;">&nbsp;&nbsp;&nbsp;
<!-- 			                    <input class="Wdate wbk" id="cxjyrq" name="cxjyrq" style="width: 50%;" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" onkeyup="value=value.replace(/[^\d]/g,'')" -->
<!-- 										onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">&nbsp;&nbsp;&nbsp; -->
						</div>
						<div style="width: 33%;float:left;height: 27px">
					    	<label class="cxtj">检验类别:</label>&nbsp;&nbsp;&nbsp;
					    	<input  id="cxjylx" name="cxjylx" class="wbk" style="width: 59%;">&nbsp;&nbsp;&nbsp;
					    </div>
					    <div style="width: 33%;float:left;height: 27px">
					    	<label class="cxtj">检 验 依 据:</label>&nbsp;&nbsp;&nbsp;
					    	<input  id="cxjyyj" name="cxjyyj" class="wbk" style="width: 54%;">&nbsp;&nbsp;&nbsp;
					    </div>
<!-- 						<div style="width: 35%;float:left;height: 28px;"> -->
<!-- 		                    <label class="cxtj">检验结束时间:</label>&nbsp;&nbsp;&nbsp; -->
<!-- 			                    <input class="Wdate wbk" id="cxjyjsrq" name="cxjyjsrq" style="width: 50%;" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" onkeyup="value=value.replace(/[^\d]/g,'')" -->
<!-- 										onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">&nbsp;&nbsp;&nbsp; -->
<!-- 						</div> -->
	                    <button class="btn btn-default" style="margin-left: 11%;" onClick="fuzhi(0);">查询</button>
	                    <button type="button" class="btn btn-default" onClick="closeYpxxWin();">清空</button>
					    <span id="sbz" ></span>
					    <div class="form-group" style="margin-left: 0px; margin-bottom: 7px; margin-right: 0px;">
                        <div class="col-lg-10" style="margin-top: 10px;">
                            <button type="button" class="btn btn-default" onclick="fuzhi(1);"
                                    style="margin-left: 50%;">加载更多...
                            </button>
                        </div>
                    </div>
					</section>
            </div>
       </div>
   </div>
</div>

<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModaltwo" class="modal fade">
  <div class="modal-dialog" style="left: 0; width:85%;">
	  <div class="modal-content" style="height: 525px;">
		    <div class="modal-body">
					   <header class="panel-heading" style="font-weight: bold;">选择检验用语</header>
					   <div style="width: 10%;height: 400px;border:1px solid #96c2f1;background:#eff7ff;float:left;">
					   <span class="jllb">结论类别1</span>
					   	<table class="table">
				   			<c:forEach var="jllb1" items="${jllb1}" varStatus="obj" >
						   		<tr>
						   			<td><input type="radio" name="1" value="${jllb1.zdz }" checked="checked;" onclick="jylb1();">${jllb1.zdmc }</td>
						   		</tr>
				   			</c:forEach>
					   	</table>
					   </div>
					   <div style="width: 10%;height: 400px;border:1px solid #96c2f1;background:#eff7ff;float:left;">
					   <span class="jllb">结论类别2</span>
					   	<table class="table">
					   		<c:forEach var="jllb2" items="${jllb2}" varStatus="obj" >
						   		<tr>
						   			<td>
						   				<input type="radio" name="2" value="${jllb2.zdz }" checked="checked;" onclick="jylb1();">${jllb2.zdmc }
						   			</td>
						   		</tr>
					   		</c:forEach>
					   	</table>
					   </div>
					   <div style="width: 80%;height: 400px;border:1px solid #96c2f1;float:left;">
					   <span class="jllb">检验结论</span>
						   <section id="sectwo">
						   	<span id="sbztwo" ></span>
						   </section>
					   </div>
					   <div style="float: right; margin-top: 1%;">
					   <input type="button" class="btn btn-primary" onclick="queding();" value="确认"/>
					   <input type="button" class="btn btn-primary" onclick="cancel();" value="关闭"/>
					   </div>
            </div>
       </div>
   </div>
</div>
</body>
</html>
<script type="text/javascript">

function gouxuan(){
   	var lable=$("#lable1");
		var obj=$("#checkbox-1");
	if(obj.prop("checked")){
		obj.prop("checked", true);
	}else{
		obj.removeAttr("checked");
	}
		if(lable.attr('class')=='label_check c_off'||lable.attr('class')=='label_check'){
  			lable.attr("class", "label_check c_on");
  			 document.getElementById("tsbgdiv").style.display = 'block';  
  			document.getElementById("sgan").style.display = 'none';
  			document.getElementById("sytwo").style.display = 'block';
  			document.getElementById("syone").style.display = 'none';
		}else{
			lable.attr("class", "label_check c_off");
			 document.getElementById("tsbgdiv").style.display = 'none';
			 document.getElementById("sgan").style.display = 'block';
			 document.getElementById("sytwo").style.display = 'none';
	  		 document.getElementById("syone").style.display = 'block';
		}
}

function Delay(){ 
	this.funList= []; 
	this.index = 0; 
	this.re = null; 
	this.isloop = false; 
	}; 
	Delay.prototype = { 
	wait:function(m){ 
	if(this.funList[this.index] && typeof this.funList[this.index].fun != 'function'){ 
	m += this.funList[this.index].m; 
	} 
	this.funList[this.index] = {m:m,fun:null}; 
	return this; 
	}, 
	run:function(fun){ 
	if(typeof this.funList[this.index].fun != 'function'){ 
	this.funList[this.index].fun = fun; 
	this.index++; 
	}else{ 
	this.index++; 
	this.funList[this.index] = {'m':0,'fun':fun}; 
	} 
	this.start(); 
	return this; 
	}, 
	start:function(){ 
	var self = this; 
	if(this.re) return; 
	var setOutrun = function(funList,index){ 
	if(funList[index] == undefined){ 
	clearTimeout(self.re); 
	return false; 
	} 
	var m = funList[index].m, 
	fun = funList[index].fun; 
	typeof fun == 'function' || (fun = function(){}); 
	self.re = setTimeout(function(){ 
	if(fun(index) === false)return false; 
	if(self.isloop){ 
	index = -1; 
	self.isloop = false; 
	} 
	setOutrun(funList,++index); 
	},m); 
	} 
	setOutrun(this.funList,0); 
	}, 
	stop:function(){ 
	return clearTimeout(this.re); 
	}, 
	goStart:function(){ 
	var self = this, 
	fun = function(){ 
	self.isloop = true; 
	}; 
	if(this.funList[this.index] && typeof this.funList[this.index].fun != 'function'){ 
	this.funList[this.index].fun = fun; 
	this.index++; 
	}else{ 
	this.funList[this.index] = {'m':0,'fun':fun}; 
	} 
	this.start(); 
	} 
	}; 

    var xmlHttp= null;
    //判断浏览器
    function createXMLHttpRequest() {
        if (window.XMLHttpRequest) {
            //Firefox,Netscape,Chrome,Safari等浏览器
            xmlHttp = new XMLHttpRequest();
        } else if (window.ActiveXObject) { //IE浏览器
            try {
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); //创建xmlHttp对象
            } catch (e) {
                try {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); //创建xmlHttp对象
                } catch (e) { }
            }
        }
    }
	function img(){
		//认证图片
		 var r = document.getElementsByName("rztbids");
		 var rzfs = $("#rzfs").val();
		 var arr=rzfs.split(",");
		 for (var i = 0; i < r.length; i++) {
			for(var j=0;j<arr.length;j++){
				if(r[i].value==arr[j]){
					r[i].checked=true;
				}
			} 
			 if (r[i].checked) {
				 var a = r[i].id;
				 var b = a.substring(8,9);
// 				 alert(b);
				 showImg('img_'+b);
			 }
		 }
		 
		 //是否为特殊报告
		 	var tsbg = [];
			$('input[name="tsbg"]:checked').each(
	                function () {
	                	tsbg.push($(this).val());
	                }
	        );
			for(var i=0;i<tsbg.length;i++){
				var lable=$("#lable"+tsbg[i]);
				var obj=$("#checkbox-"+tsbg[i]);
				if(obj.prop("checked")){
					obj.prop("checked", true);
				}else{
					obj.removeAttr("checked");
				}
		   		if(lable.attr('class')=='label_check c_off'||lable.attr('class')=='label_check'){
			  		lable.attr("class", "label_check c_on");
			  		document.getElementById("tsbgdiv").style.display = 'block';
			  		document.getElementById("sgan").style.display = 'none';
		   		}else{
		   			lable.attr("class", "label_check c_off");
		   			document.getElementById("tsbgdiv").style.display = 'none';
		   			document.getElementById("sgan").style.display = 'block';
		   		}
			}
		 
		//ComboTree控件初始化
         $('#jyks').combotree({
             url: '<%=path%>/test/xlsList?optype=getchildtree&id=100500',
             'onLoadSuccess': function (node, data) {
                 //在panel控件load完成的时候处理当前显示值，如果不处理，则combotree1的显示值有可能会不正确
                 if (data.length > 0) {
                     var val = ""; //jsp页面初始化时combotree1的初始id值
                     var txt = $('#jyks').combotree('getText'); //combotree1当前的显示text值
                     if (val != "" && val == txt) {
                         var urlstr = "<%=path%>/test/xlsList" + "?optype=gettext&id=" + val;
                         $.get(urlstr,
                                 function (gettxt) {
                                     if (gettxt != "")
                                         $('#jyks').combotree('setText', gettxt);
                                 }
                         );
                     }
                 }
             },
             'onChange': function (n, o) {
                 $("#jyksbh").val("");
                 var url = "<%=path%>/sys/SysArea/findBz";
                 $.ajax({
                     cache: true,
                     type: "POST",
                     url: url,
                     data: {n: n},
                     async: false,
                     error: function (request) {
                         alert("选择失败,请联系管理员。");
                     },
                     success: function (data) {
                         if (data == "1") {
                             alert("请选择专业检测实验室的部门！");
                         } else {
                             $("#jyksbh").val(n);
                             //var jyksbh = document.getElementById("jyksbh");
                             //jyksbh.setAttribute('value',n);
                             //alert(jyksbh.value);
                             $("#zh").val("请选择...");
                             //alert($("#zh").val());
                         }
                     }
                 });
                 //变更当前节点，触发变更事件处理
                 //dochange();
             }
         });
         //ComboTree控件初始化
         $('#ywks').combotree({
             url: '<%=path%>/test/xlsList1?optype=getchildtree',
             'onLoadSuccess': function (node, data) {
                 //在panel控件load完成的时候处理当前显示值，如果不处理，则combotree1的显示值有可能会不正确
                 if (data.length > 0) {
                     var val = ""; //jsp页面初始化时combotree1的初始id值
                     var txt = $('#ywks').combotree('getText'); //combotree1当前的显示text值
                     if (val != "" && val == txt) {
                         var urlstr = "<%=path%>/test/xlsList" + "?optype=gettext&id=" + val;
                         $.get(urlstr,
                                 function (gettxt) {
                                     if (gettxt != "")
                                         $('#ywks').combotree('setText', gettxt);
                                 }
                         );
                     }
                 }
             },
             'onChange': function (n, o) {
                 $("#ywksbh").val(n);
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
			//$('.panel,.combo-p').width('238px');
			//$('.combo-panel,.panel-body,.panel-body-noheader').width('238px');
         
         var rValue1 = $("#lRadio").val();
         initradio('lyfs',rValue1);
         
         var rValue2 = $("#jRadio").val();
         initradio('jyfydd',rValue2);
         
         var rValue3 = $("#Radio1").val();
         initradio('ypyj',rValue3);
         
         var rValue4 = $("#bRadio").val();
         initradio('bgfsfs',rValue4);
         
         var rValue5 = $("#Radio2").val();
         initradio('sfwckcp',rValue5);
         
         var a=document.getElementById("ypmc").value;
     	//alert(a);
     	$("#cpmccx").val(a);
	}

    var ypid = $("#ypid").val();
    var userCode = "${userCode}";
    var taskId = "${taskId}";
    var creditId = "${businessKey}";
    var lineVar = $("#lineVar").val();
    var tname =  $("#tname").val();
    var url = $("#projectName").val();//获取跟目录
    var options = {
        //   target: '#output',          //把服务器返回的内容放入id为output的元素中
        beforeSubmit: showRequest,  //提交前的回调函数
        success: showResponse,      //提交后的回调函数
        url: url + '/cps/deal/dealYPZJAct',   //默认是form的action， 如果申明，则会覆盖
        //type: type,               //默认是form的method（get or post），如果申明，则会覆盖
        dataType: 'json',           //html(默认), xml, script, json...接受服务端返回的类型
        //clearForm: true,          //成功提交后，清除所有表单元素的值
        //resetForm: true,          //成功提交后，重置所有表单元素的值
        timeout: 10000              //限制请求的时间，当请求大于10秒后，跳出请求
    };
    //查看样品信息
    function viewYpxx(ypid,djlx) {
        window.open("<%=path%>/jygl/YjyJyxx/lcypxx?ypid=" + ypid + "&djlx=" + djlx, "样品信息查看", "height=750, width=1000, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no");
    }
    //样品信息编辑
    function editYpxx(id, djlx,taskId) {
        window.open("<%=path%>/ypgl/YYpYpxx/ypxgApproveView?id=" + id + "&djlx=" + djlx + "&taskId=" + taskId, "样品信息修改", "height=750, width=1000, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no");
    }

    //报告生成
    function ylbg(bgbh) {
    	 var bgbh = $("#ypbh").val();
         if ($("#jyrq").val() == "") {
             alert("请输入检验日期！");
             return false;
         }
         if ($("#jyjl").val() == "") {
             alert("请输入检验结论！");
             return false;
         }
         var bsdx = $("#bsdx").val();
         $("#bsdxtwo").val(bsdx);
         if( $("#bsdx").val() == ""){
         	 alert("请选择报审对象！");
         	 return false;
         }
         var rztbid = [];
         $('input[name="rztbids"]:checked').each(
                 function () {
                     rztbid.push($(this).val());
                 }
         );
         if (rztbid == "") {
        	 if (confirm("确定不选择认证图标吗？")) {  
        		 $.ajax({
        			    cache: true,
        			    type: "POST",
        			    url: "<%=path%>/jygl/YjyBgxx/tijiao",
        			    data: $('#Form').serialize(),// 你的formid
        			    async: false,
        			    error: function (request) {
        			        alert("保存失败，请联系管理员!!!!");
        			    },
        			    success: function (data) {
        			        if (data == '1') {
        			       	 var fileUrl = "<%=path%>/resources/doc/"+bgbh+"fy.doc";
        			            createXMLHttpRequest();
        			            xmlHttp.open("GET",fileUrl,true);
        			            xmlHttp.send(null);
        			            xmlHttp.onreadystatechange = function(){
        			                if(xmlHttp.readyState==4){
        			                    if(xmlHttp.status==200){
        			                    	$.DialogBySHF.Dialog({ Width: 300, Height: 200, Title: "系统提示", URL: '<%=path%>/jygl/YjyBgxx/ccfmsy?bgbh='+bgbh });
        			                    	var d = new Delay(); 
        			                		d.wait(10000).run(function(m){ //等待3秒 
        			                			//封面
        			                			 var fm = "<%=path%>/resources/doc/"+bgbh+"fm.doc";
        			                            createXMLHttpRequest();
        			                            xmlHttp.open("GET",fm,true);
        			                            xmlHttp.send(null);
        			                            xmlHttp.onreadystatechange = function(){
        			                                if(xmlHttp.readyState==4){
        			                                    if(xmlHttp.status==200){
        			                                   	//首页
        			                            			 var sy = "<%=path%>/resources/doc/"+bgbh+"sy.doc";
        			                                        createXMLHttpRequest();
        			                                        xmlHttp.open("GET",sy,true);
        			                                        xmlHttp.send(null);
        			                                        xmlHttp.onreadystatechange = function(){
        			                                            if(xmlHttp.readyState==4){
        			                                                if(xmlHttp.status==200){
location.href = "<%=path%>/jygl/YjyBgxx/ylbg?bgbh="+bgbh+"&userCode="+userCode+"&taskId="+taskId+"&businessKey="+creditId+"&lineVar="+lineVar+"&tname="+tname;
        			                                                }else {
        			                                                    alert("操作失败，请重新操作！");
        			                                                     $.DialogBySHF.Close(); 
        			                                                }
        			                                            }
        			                                        }
        			                                    }else{
        			                                   	 alert("操作失败，请重新操作！");
        			                                        $.DialogBySHF.Close(); 
        			                                    }
        			                                }
        			                            }
        			                			
        			                		});
        			                    }else {
        			                        alert("请先编辑附页！");
        			                    }
        			                }
        			            }
        			        } else {
        			            alert("保存失败，请联系管理员。");
        			        }
        			    }
        			});
             }else{
            	 return false;
             }
         }
			$.ajax({
			    cache: true,
			    type: "POST",
			    url: "<%=path%>/jygl/YjyBgxx/tijiao",
			    data: $('#Form').serialize(),// 你的formid
			    async: false,
			    error: function (request) {
			        alert("保存失败，请联系管理员!!!!");
			    },
			    success: function (data) {
			        if (data == '1') {
			       	 var fileUrl = "<%=path%>/resources/doc/"+bgbh+"fy.doc";
			            createXMLHttpRequest();
			            xmlHttp.open("GET",fileUrl,true);
			            xmlHttp.send(null);
			            xmlHttp.onreadystatechange = function(){
			                if(xmlHttp.readyState==4){
			                    if(xmlHttp.status==200){
			                    	$.DialogBySHF.Dialog({ Width: 300, Height: 200, Title: "系统提示", URL: '<%=path%>/jygl/YjyBgxx/ccfmsy?bgbh='+bgbh });
			                    	var d = new Delay(); 
			                		d.wait(10000).run(function(m){ //等待3秒 
			                			//封面
			                			 var sy = "<%=path%>/resources/doc/"+bgbh+"sy.doc";
			                            createXMLHttpRequest();
			                            xmlHttp.open("GET",sy,true);
			                            xmlHttp.send(null);
			                            xmlHttp.onreadystatechange = function(){
			                                if(xmlHttp.readyState==4){
			                                    if(xmlHttp.status==200){
			                                   	//首页
			                            			 var fm = "<%=path%>/resources/doc/"+bgbh+"fm.doc";
			                                        createXMLHttpRequest();
			                                        xmlHttp.open("GET",fm,true);
			                                        xmlHttp.send(null);
			                                        xmlHttp.onreadystatechange = function(){
			                                            if(xmlHttp.readyState==4){
			                                                if(xmlHttp.status==200){
	location.href = "<%=path%>/jygl/YjyBgxx/ylbg?bgbh="+bgbh+"&userCode="+userCode+"&taskId="+taskId+"&businessKey="+creditId+"&lineVar="+lineVar+"&tname="+tname;
			                                                }else {
			                                                    alert("操作失败，请重新操作！");
			                                                     $.DialogBySHF.Close(); 
			                                                }
			                                            }
			                                        }
			                                    }else{
			                                   	 alert("操作失败，请重新操作！");
			                                        $.DialogBySHF.Close(); 
			                                    }
			                                }
			                            }
			                			
			                		});
			                    }else {
			                        alert("请先编辑附页！");
			                    }
			                }
			            }
			        } else {
			            alert("保存失败，请联系管理员。");
			        }
			    }
			});
    }
    
    function zjtj(bgbh){
    	var fileUrl = "<%=path%>/resources/doc/"+bgbh+".doc";
	     createXMLHttpRequest();
	     xmlHttp.open("GET",fileUrl,true);
	     xmlHttp.send(null);
	     xmlHttp.onreadystatechange = function(){
	         if(xmlHttp.readyState==4){
	             if(xmlHttp.status==200){
	           	  var returnFlag = checkApproveData();
	                 if (returnFlag) {
	                	 msg = "如修改报告首页信息时，请重新生成报告。";
	                     if (confirm(msg)) {
		                     $("#valueInputId").val(1);
		                     $("#optionForm").ajaxForm(options);
		                     $("#optionForm").submit();
	                     }
	                 } else {
	                     window.onbeforeunload = function () {
	                         return '将丢失未保存的数据!';
	                     }
	                     return false;
	                 }
	             }else {
	                 alert("请先生成报告！");
	             }
	         }
	     }
    }
    
    function scfy(bgbh){
		msg = "是否确定？";
        if (confirm(msg)) {
//         	var bgbh = "${bgbh}";
			var url = "<%=path%>/jygl/YjyBgxx/deletefy";
		    $.ajax({
		        cache: true,
		        type: "POST",
		        url: url,
		        data: {bgbh:bgbh},
		        async: false,
		        error: function (request) {
		            alert("请联系管理员。");
		        },
		        success: function (msg) {
		        	if(msg == "1"){
		        		alert("删除成功！");
		        	}else if(msg == "2"){
		        		alert("附页还未编制！");
		        	}
		        }
		    });
        }
    }
    
    function sctsfy(bgbh){
		msg = "是否确定？";
        if (confirm(msg)) {
//         	var bgbh = "${bgbh}";
			var url = "<%=path%>/jygl/YjyBgxx/deletetsbg";
		    $.ajax({
		        cache: true,
		        type: "POST",
		        url: url,
		        data: {bgbh:bgbh},
		        async: false,
		        error: function (request) {
		            alert("请联系管理员。");
		        },
		        success: function (msg) {
		        	if(msg == "1"){
		        		alert("删除成功！");
		        	}else if(msg == "2"){
		        		alert("特殊报告还未编制！");
		        	}
		        }
		    });
        }
    }

    function showRequest(formData, jqForm, options) {
        //formData: 数组对象，提交表单时，Form插件会以Ajax方式自动提交这些数据，格式如：[{name:user,value:val },{name:pwd,value:pwd}]
        //jqForm:   jQuery对象，封装了表单的元素
        //options:  options对象
        // var queryString = $.param(formData);   //name=1&address=2
        // var formElement = jqForm[0];              //将jqForm转换为DOM对象
        //var address = formElement.address.value;  //访问jqForm的DOM元素
        return true;  //只要不返回false，表单都会提交,在这里可以对表单元素进行验证
    }
    ;
    function showResponse(responseText, statusText) {
    	/* var bgbh='${mapBusi.bgbh}'; */
        if (responseText.success == true) {
        	alert('任务处理成功!');
                window.parent.pendPoolGrid.store.load({params:{start:0,limit:20}});
                window.parent.ACT_DEAL_WINDOW.close();
        } else {
            alert('任务处理失败!');
        }
    }
    ;
    //批准
    function agree(bgbh) {
    	  if ($("#bsdx").val() == "") {
              alert("请选择报审对象！");
              return false;
          }
    	  var fileUrl = "<%=path%>/resources/doc/"+bgbh+"fy.doc";
          createXMLHttpRequest();
          xmlHttp.open("GET",fileUrl,true);
          xmlHttp.send(null);
          xmlHttp.onreadystatechange = function(){
              if(xmlHttp.readyState==4){
                  if(xmlHttp.status==200){
// 						alert("附页存在！");
                	  var fileUrl = "<%=path%>/resources/doc/"+bgbh+".doc";
                      createXMLHttpRequest();
                      xmlHttp.open("GET",fileUrl,true);
                      xmlHttp.send(null);
                      xmlHttp.onreadystatechange = function(){
                          if(xmlHttp.readyState==4){
                              if(xmlHttp.status==200){
//                             	  alert("报告存在");
                            	  var returnFlag = checkApproveData();
                                  if (returnFlag) {
                                      $("#valueInputId").val(1);
                                      $("#optionForm").ajaxForm(options);
                                      $("#optionForm").submit();
                                  } else {
                                      window.onbeforeunload = function () {
                                          return '将丢失未保存的数据!';
                                      }
                                      return false;
                                  }
                              }else {
                            	  alert("请先预览报告！");
                              }
                          }
                      }
                  }else {
                      alert("请先编辑附页！");
                  }
              }
          }
    }
    //不批准
    function disagree() {
        $("#valueInputId").val(0);
        $("#optionForm").ajaxForm(options);
    }
    //校验输入的审批意见
    function checkApproveData() {
        var returnFlag = true;
        /* var optinoContent = $("#optinoContentId").val();
         if (optinoContent == null ||  optinoContent=="" ) {
         returnFlag = false;
         alert('请填写意见!');
         return returnFlag;
         } */
        return returnFlag;
    }

    //编辑附页
    function edit() {
    	var bgbh = $("#ypbh").val();
        location.href = "<%=path%>/jygl/YjyBgxx/fylc?bgbh=" + bgbh;
    }
    
    //保存首页(一般)
    function bcsy(bgbh){
    	if ($("#jyrq").val() == "") {
            alert("请输入检验日期！");
            return false;
        }
        if ($("#jyjl").val() == "") {
            alert("请输入检验结论！");
            return false;
        }
        $.ajax({
    	    cache: true,
    	    type: "POST",
    	    url: "<%=path%>/jygl/YjyBgxx/bcsy",
    	    data: $('#Form').serialize(),// 你的formid
    	    async: false,
    	    error: function (request) {
    	        alert("保存失败，请联系管理员!!!!");
    	    },
    	    success: function (data) {
    	    	 if (data == '1') {
    	    		 alert("温馨提示:首页保存成功！");
    	    	 }
    	    }
    	});	
    }
    
  //保存首页(特殊)
    function TSbcsy(bgbh){
    	if ($("#jyrq").val() == "") {
            alert("请输入检验日期！");
            return false;
        }
        if ($("#jyjl").val() == "") {
            alert("请输入检验结论！");
            return false;
        }
        $.ajax({
    	    cache: true,
    	    type: "POST",
    	    url: "<%=path%>/jygl/YjyBgxx/TSbcsy",
    	    data: $('#Form').serialize(),// 你的formid
    	    async: false,
    	    error: function (request) {
    	        alert("保存失败，请联系管理员!!!!");
    	    },
    	    success: function (data) {
    	    	 if (data == '1') {
    	    		 alert("温馨提示:首页保存成功！");
    	    	 }
    	    }
    	});	
    }
    
    //编辑特殊报告
    function tsbg() {
    	var bgbh = $("#ypbh").val();
    	var bsdx = $("#bsdx").val();
        $("#bsdxtwo").val(bsdx);
        if( $("#bsdx").val() == ""){
        	 alert("请选择报审对象！");
        	 return false;
        }
    	$.ajax({
    	    cache: true,
    	    type: "POST",
    	    url: "<%=path%>/jygl/YjyBgxx/tsbgtijiao",
    	    data: $('#Form').serialize(),// 你的formid
    	    async: false,
    	    error: function (request) {
    	        alert("保存失败，请联系管理员!!!!");
    	    },
    	    success: function (data) {
    	    	 if (data == '1') {
<%-- 	       	 		location.href = "<%=path%>/jygl/YjyBgxx/tsbg?bgbh=" + bgbh; --%>
	       	 	location.href = "<%=path%>/jygl/YjyBgxx/tsbg?bgbh="+bgbh+"&userCode="+userCode+"&taskId="+taskId+"&businessKey="+creditId+"&lineVar="+lineVar+"&tname="+tname;
    	    	 }
    	    }
    	});
    }

    //显示图片
    function showImg(id) {
        if (document.getElementById(id).style.display == 'none') {
            document.getElementById(id).style.display = 'block';
        } else {
            document.getElementById(id).style.display = 'none';
        }
    }
    
    //附页复制
    function fuzhi(type){
    	if(type=='1'){
    		fenye++;
    	}else{
    		fenye=1;
    	}
    	var bgbh = document.getElementById("cxbgbh").value;
    	var bzr = document.getElementById("cxbzr").value;
    	var wtdw = document.getElementById("cxwtdw").value;
    	var sjdw = document.getElementById("cxsjdw").value;
    	var ypmc = document.getElementById("cxypmc").value;
    	var jyrq = document.getElementById("cxjyrq").value;
    	var jylx = document.getElementById("cxjylx").value;
    	var jyyj = document.getElementById("cxjyyj").value;
//     	var jyjsrq = document.getElementById("cxjyjsrq").value;
    	
    	var url = "<%=path%>/jygl/YjyBgxx/bgxx";
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : {fenye:fenye,bgbh:bgbh,wtdw:wtdw,bzr:bzr,sjdw:sjdw,ypmc:ypmc,jyrq:jyrq,jylx:jylx,jyyj:jyyj},
			async : false,
			error : function(request) {
				alert("保存失败,请联系管理员。");
			},
			success : function(data) {
				var del = $("#table");
				del.remove();
            	var str="<table><thead><tr><th>报告编号</th><th>编制人</th><th>委托单位</th><th>受检单位</th><th>样品名称</th><th>检验时间</th><th>检验类别</th><th>检验依据</th>"
					   +"<th>操作</th></tr></thead><tbody>";
            	for(var i=0;i<data.length;i++){
            		str=str+"<tr><td>"+data[i].BGBH+"</td><td>"+data[i].BZR+"</td>"
            		+"<td>";
            		if(data[i].WTDW != null){ 
            			if(data[i].WTDW.length > 7){
            				str = str + data[i].WTDW.substring(0,6)+"..."
            			}else{
            				str = str +data[i].WTDW
            			}
            		}else{
            			str = str + "/" 
            		}
            		str=str+"</td><td>";
            		if(data[i].SJDW != null){ 
            			if(data[i].SJDW.length > 7){
            				str = str + data[i].SJDW.substring(0,6)+"..."
            			}else{
            				str = str +data[i].SJDW
            			}
            		}else{
            			str = str + "/" 
            		}
            		str=str+"</td>"
            		+"<td>";
            		if(data[i].YPMC.length > 10){
        				str = str + data[i].YPMC.substring(0,9)+"..."
        			}else{
        				str = str + data[i].YPMC
        			}
            		str=str+"</td><td>";
            		if(data[i].JYRQ.length > 10){
        				str = str + data[i].JYRQ.substring(0,9)+"..."
        			}else{
        				str = str + data[i].JYRQ
        			}
            		str=str+"</td>"
            		+"<td>"+data[i].JYLX+"</td><td>";
            		if(data[i].JYYJ != null){
            			if(data[i].JYYJ.length > 12){
            				str = str + data[i].JYYJ.substring(0,12)+"..."
            			}else{
            				str = str + data[i].JYYJ
            			}
            		}else{
            			str = str + "/" 
            		}
            		str=str+"</td>"
            		+"<td><input type ='button' onClick='saveMb1(\""+data[i].BGBH+"\");' value='复制'></td>";
            	} 
            	str=str+"</tbody><table>";
            	var oTest = document.getElementById("sect");
        		var newNode = document.createElement("table");
        		var befNode = document.getElementById("sbz");
        		newNode.setAttribute('class','table');
        		newNode.setAttribute('id','table');
        		newNode.innerHTML =str;
        		oTest.insertBefore(newNode,befNode);
			}
		});
} 
    
    function saveMb1(bg) {
    	var bgbh='${mapBusi.bgbh}';
    	var fileUrl = "<%=path%>/resources/doc/"+bg+"fy.doc";
        createXMLHttpRequest();
        xmlHttp.open("GET",fileUrl,true);
        xmlHttp.send(null);
        xmlHttp.onreadystatechange = function(){
            if(xmlHttp.readyState==4){
                if(xmlHttp.status==200){
    				location.href = "<%=path%>/jygl/YjyBgxx/fzfy?bgbh=" + bgbh + "&bg= " + bg;
    				$('#myModal').modal('hide');
                }else {
                    alert("此报告不存在！");
                }
            }
        }
    }
    
    function closeYpxxWin(){
    	$("#cxbgbh").val("");
    	$("#cxbzr").val(""); 
    	$("#cxwtdw").val("");
    	$("#cxsjdw").val("");
    	$("#cxypmc").val("");
    	$("#cxjyrq").val("");
    	$("#cxjylx").val("");
    	$("#cxjyyj").val("");
//     	$("#cxjyjsrq").val("");
//     	$('#myModal').modal('hide');
    }
    
    //常用检验结论用语
    function jyyy(){
    	var value="";
    	var radio=document.getElementsByName("1");
    	for(var i=0;i<radio.length;i++){
	    	if(radio[i].checked==true){
		    	value=radio[i].value;
		    	break;
	    	}
    	}
    	var value2="";
    	var radio2=document.getElementsByName("2");
    	for(var i=0;i<radio2.length;i++){
	    	if(radio2[i].checked==true){
		    	value2=radio2[i].value;
		    	break;
	    	}
    	}
    	var url = "<%=path%>/jygl/YjyBgxx/clyy";
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : {value:value,value2:value2},
			async : false,
			error : function(request) {
				alert("保存失败,请联系管理员。");
			},
			success : function(data) {
	    	var del = $("#table");
			del.remove();
	    	var str="<table><tbody>";
	    	for(var i=0;i<data.length;i++){
	    		str=str+"<tr><td><input type ='radio' id='"+data[i].ID+"' name='3' value='"+data[i].CGJLYY+"' onClick='haha(\""+data[i].ID+"\");'>"+data[i].CGJLYY+"</td>";
	    		}
				str=str+"</tbody><table>";
		    	var oTest = document.getElementById("sectwo");
				var newNode = document.createElement("table");
				var befNode = document.getElementById("sbztwo");
				newNode.setAttribute('class','table');
				newNode.setAttribute('id','table');
				newNode.innerHTML =str;
				oTest.insertBefore(newNode,befNode);
	    	} 
		});
    }
    
    function queding(){
    	var yp = ypid;
    	var zhi = document.getElementById("jyjl").value;
    	var url = "<%=path%>/jygl/YjyBgxx/findJyyj";
        $.ajax({
            cache: true,
            type: "POST",
            url: url,
            data: {yp:yp},
            async: false,
            error: function (request) {
                alert("请联系管理员。");
            },
            success: function (data) {
//                 alert(data);
            	for(var i=0;i<data.length;i++){
            			var a = data[i].JYYJ;
				    	var value=zhi.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\@\，\。\：\/\“”]/g,a);
				    	$("#jyjl").val(value);
    	    		}
            }
        });
    	$('#myModaltwo').modal('hide');
    }
    
    function haha(jyjlid){
    	var zhi = document.getElementById(jyjlid).value;
    	$("#jyjl").val(zhi);
    }
    
    function cancel(){
    	$('#myModaltwo').modal('hide');
    }
    
    function jylb1(){
    	
    	var value="";
    	var radio=document.getElementsByName("1");
    	for(var i=0;i<radio.length;i++){
	    	if(radio[i].checked==true){
		    	value=radio[i].value;
		    	break;
	    	}
    	}
    	var value2="";
    	var radio2=document.getElementsByName("2");
    	for(var i=0;i<radio2.length;i++){
	    	if(radio2[i].checked==true){
		    	value2=radio2[i].value;
		    	break;
	    	}
    	}
    	var url = "<%=path%>/jygl/YjyBgxx/clyy";
    	$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : {value:value,value2:value2},
			async : false,
			error : function(request) {
				alert("保存失败,请联系管理员。");
			},
			success : function(data) {
				var del = $("#table");
				del.remove();
				var str="<table><tbody>";
		    	for(var i=0;i<data.length;i++){
		    		str=str+"<tr><td><input type ='radio' id='"+data[i].ID+"' name='3' value='"+data[i].CGJLYY+"' onClick='haha(\""+data[i].ID+"\");'>"+data[i].CGJLYY+"</td>";
		    		}
					str=str+"</tbody><table>";
			    	var oTest = document.getElementById("sectwo");
					var newNode = document.createElement("table");
					var befNode = document.getElementById("sbztwo");
					newNode.setAttribute('class','table');
					newNode.setAttribute('id','table');
					newNode.innerHTML =str;
					oTest.insertBefore(newNode,befNode);
			}
    	});
    }
</script>
<style type="text/css">
    .thbg {
        padding: 6px 12px;
        background-color: #eeeeee;
    }

    .optionContentSignClass {
        height: 100%;
        width: 250px;
    }

    .optionContentClass {
        width: 250px;
    }

    a {
        cursor: pointer;
    }

    .bzbg {
        border-bottom-width: 0;
        border-top-width: 0;
        padding-bottom: 0;
        padding-top: 0;
        height: 26px;
    }

    .form-control.form-control1 {
        background-color: #fff;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
        color: #555;
        display: block;
        font-size: 14px;
        height: 30px;
        line-height: 1.42857;
        padding: 6px 12px;
        transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
        vertical-align: middle;
        width: 100%;
    }

    a.link {
        background-color: #5cb85c;
        border-radius: 4px;
        color: #fff;
        cursor: pointer;
        display: inline-block;
        float: left;
        font: 11px/19px "Microsoft YaHei", Verdana, Geneva, sans-serif;
        padding: 1%;
        margin-top: 3px;
        text-decoration: none;
        width: 9%;
    }

    .hehe {
        bottom: -3%;
        height: 25px;
        border: 1px solid #000;
        left: 16.9%;
        width: 80%;
        background-color: #fff;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
        color: #555;
        display: block;
        font-size: 12px;
        height: 120px;
        line-height: 1.42857;
        padding: 1px 6px;
        transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
        vertical-align: middle;
    }
    
    .abc{
    	width:10%;
    }
    .wbk{
    	background-color: #fff;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
	    color: #555;
	    font-size: 12px;
	    height: 24px;
	    line-height: 1.42857;
	    margin-top: 3px;
	    padding: 1px 6px;
	    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
	    vertical-align: middle;	
    }
    .wb{
    	background-color: #fff;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
	    color: #555;
	    font-size: 12px;
	    height: 24px;
	    line-height: 1.42857;
	    margin-top: 3px;
	    padding: 1px 6px;
	    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
    }
    .cxtj{
    	font-weight: 100;
    }
    .jllb{
    	font-weight: bolder;
    	font-size: 14px;
    }
    .label_check{ 
			background: rgba(0, 0, 0, 0) url("<%=path%>/resources/img/checkbox/check-off.png") no-repeat scroll 0 0;
 			padding-left: 5px; 
 			margin-right: 5px; 
 		} 
 		.label_check input[type="checkbox"] {
		    visibility: hidden;
		}
		.label_check.c_on{ 
			background: rgba(0, 0, 0, 0) url("<%=path%>/resources/img/checkbox/check-on.png") no-repeat scroll 0 0;
 			padding-left: 5px; 
 			margin-right: 5px; 
 		} 
 		.label_check.c_off{ 
			background: rgba(0, 0, 0, 0) url("<%=path%>/resources/img/checkbox/check-off.png") no-repeat scroll 0 0;
 			padding-left: 5px; 
 			margin-right: 5px; 
 		} 
</style>
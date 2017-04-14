<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
    <%-- <script type="text/javascript" src="<%=path%>/resources/js/ux/jquery.easyui.min.js"></script> --%>
    <script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
    <%-- <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script> --%>
    <script type="text/javascript" src="<%=path%>/resources/datePicker/WdatePicker.js"></script>
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/upload.css">
    <script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.qrcode.min.js"></script>
    <script language="javascript" src="<%=path%>/resources/lodop/LodopFuncs.js"></script>
    <script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
    
    <script type="text/javascript" src="<%=path%>/resources/js/ajaxfileupload.js"></script>
    
    <script type="text/javascript" src="<%=path%>/resources/js/yz/jquery.validate.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/yz/yzstyle.css">
    <!--common script for all pages-->
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="<%=path%>/resources/js/html5shiv.js"></script>
    <script src="<%=path%>/resources/js/respond.min.js"></script>
    <![endif]-->
    
    
   <script>
	$(function(){
		//jquery.validate
		$("#gcypForm").validate({
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
              
              if ($("#gcmc").val() == "") {
                  alert("请填写工程名称！");
                  return false;
                }
              if ($("#gcdz").val() == "") {
                  alert("请填写工程地址！");
                  return false;
              }
              
              if ($("#jylx").val() == "") {
                  alert("请选择检验类型！");
                  return false;
              }
              
              msg = "确定要提交？";
              if (confirm(msg)) {
                  var saveurl = "<%=path%>/ypgl/YYpYpxx/save";
                  var bgbhNum = document.getElementById("bgbh").value;
              	  $(".sfmxBgbh").val(bgbhNum);
                  $.ajax({
                      cache: true,
                      type: "POST",
                      url: saveurl,
                      data: $('#gcypForm').serialize(),// 你的formid
                      async: false,
                      error: function (request) {
                          alert("保存失败,请联系管理员。");
                      },
                      success: function (data) {
                          sfTj = 1;
                          document.getElementById("zjyp").disabled=false;
                          
                          if(data!="0" && data!=null){
                        	  $("#bgbh1").val(data);
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
                                  }
                              });
                          }else{
                        	  alert("保存失败,请联系管理员!");
                          }
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
    
        /*
         获取值
         function getValue(){
         var val = $('#cc').combotree('getValue');
         alert(val);
         var text = $('#cc').combotree('getText');
         alert(text);
         }
         添加值
         function setValue(){
         $('#cc').combotree('setValue', '122');
         }
         function disable(){
         $('#cc').combotree('disable');
         }
         function enable(){
         $('#cc').combotree('enable');
         }*/

        <%-- $(function() {

          //ComboTree控件初始化
            $('#sjdw').combotree({
                url: '<%=path%>/test/xlsList?optype=getchildtree',
            'onLoadSuccess': function(node,data){
            //在panel控件load完成的时候处理当前显示值，如果不处理，则combotree1的显示值有可能会不正确
                    if(data.length>0){
                           var val = ""; //jsp页面初始化时combotree1的初始id值
                         var txt = $('#sjdw').combotree('getText'); //combotree1当前的显示text值

                        //当首次进入这个jsp页面，在combotree1还没有执行url获取jason树数据时，
                        //由于控件的处理机制，其内部的panel控件已经在进行初始化了，不过此时参数node=null,data=null
                        //而在第一次执行url获取了jason树数据之后，因为combotree1尚未设置node，因此此时node=null,但是data != null
                        //而初始化之后，在下拉列表onchange时,此时node!=null，而且data != null
                        //因此可以通过此种变化规则获取id=val时对应的text显示值
                        //(此处的说明比较绕口，你可以先尝试去掉这个'onLoadSuccess'事件，
                        //然后测试一下当前显示值在jsp页面初始化、点击父节点打开子节点列表、findforward返回时的变化情况就知道了^_^)
                     if(val != "" && val==txt){
                               //combotree1只有在data中找到id=val对应的node节点，显示值才会变为node的text属性值，否则只显示为id=val值
                           //此时data中不包含id=val对应的node节点，因此需要单独通过ajax获取id=val时的text值
                        var urlstr = "<%=path%>/test/xlsList" +"?optype=gettext&id="+val;
                        $.get(urlstr,
                              function(gettxt){
                                  if(gettxt!="")
                                     $('#sjdw').combotree('setText',gettxt);
                              }
                          );
                       }
                    }
                },
                /* 'onChange': function(n,o){
                      //变更当前节点，触发变更事件处理
                    dochange();
                 } */
            });

        }); --%>

        function load() {
            $("#jyks").focus();
        	var i=0;
            //ComboTree控件初始化
            $('#jyks').combotree({
                url: '<%=path%>/test/xlsList?optype=getchildtree&id=100250',
                'onLoadSuccess': function (node, data) {
                    //在panel控件load完成的时候处理当前显示值，如果不处理，则combotree1的显示值有可能会不正确
                    if (data.length > 0) {
                        var val = ""; //jsp页面初始化时combotree1的初始id值
                        var txt = $('#jyks').combotree('getText'); //combotree1当前的显示text值
                        if (val != "" && val == txt) {
                            var urlstr = "<%=path%>/test/xlsList" + "?optype=gettext&id=" + val;
                            $.get(urlstr,function (gettxt) {
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
                                $("#zh").val("");
                                //alert($("#zh").val());
                                $("#zh").focus();
                            }
                        }
                    });
                    //变更当前节点，触发变更事件处理
                    //dochange();
                }
                ,
                keyHandler : {
            	    up : function(q) {
            	    	roots=$('#jyks').combotree('tree').tree('getRoots');
            	    	i=roots.length;
            			if(i>0 && i<=roots.length){
            				var val = roots[i].id; //jsp页面初始化时combotree1的初始id值
                            $('#jyks').combotree('setText', roots[i].text);
                            var txt = $('#jyks').combotree('getText'); //combotree1当前的显示text值
                            i--
                            $('#jyks').val(val);
            			}else{
            				i=0;
            				var val = roots[i].id; //jsp页面初始化时combotree1的初始id值
                            $('#jyks').combotree('setText', roots[i].text);
                            var txt = $('#jyks').combotree('getText'); //combotree1当前的显示text值
                            $('#jyks').val(val);
            			}
            		},
            		down : function(node, data) {
            			roots=$('#jyks').combotree('tree').tree('getRoots');
            			if(i<roots.length){
            				var val = roots[i].id; //jsp页面初始化时combotree1的初始id值
                            $('#jyks').combotree('setText', roots[i].text);
                            var txt = $('#jyks').combotree('getText'); //combotree1当前的显示text值
                            i++
                            $('#jyks').val(val);
            			}else{
            				i=0;
            				var val = roots[i].id; //jsp页面初始化时combotree1的初始id值
                            $('#jyks').combotree('setText', roots[i].text);
                            var txt = $('#jyks').combotree('getText'); //combotree1当前的显示text值
                            $('#jyks').val(val);
            			}
            		},
            		enter : function(node, data) {
            			roots=$('#jyks').combotree('tree').tree('getRoots');
            			var val = roots[i].id;
            			$('#jyks').combotree('setValue', roots[i].id);
            			$('#jyks').combotree('setText', roots[i].text);
            			$('#jyks').val(val);
            			i=0;
            			//$('#jyks').combobox('closePanel');
	        		}
        		}
            });
//             $('#jyks').combobox('textbox').bind('focus',function(){  
//                 $('#jyks').combobox('showPanel');
//             });  
//             $("#jyks").focus();
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
            $('#ywks').combobox('textbox').bind('focus',function(){  
                $('#ywks').combobox('showPanel');
            });
//             $("#ywks").focus();
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
            //生成二维码
            var str = "${url}";
            $("#code").qrcode({
                width: 100,
                height: 100,
                text: str
            });
        }
        //返回
        function exit() {
            /* var PAGESIZE = 20;
             window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
            //window.parent.ACT_DEAL_WINDOW.close();
             parent.location.href = "<%=path%>/ypgl/YYpYpxx/YpxxPage";
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
        //提交
        <%-- function save() {
				
    		  if ($("#jyksbh").val() == "") {
                    alert("请选择检验科室");
                    return false;
              }  
              if ($("#zh").val() == "") {
                  alert("请选择字号");
                  return false;
              }
             
              msg = "确定要提交？";
              if (confirm(msg)) {
                  var url = "<%=path%>/ypgl/YYpYpxx/save";
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
                          alert('保存成功！');
                          /* var PAGESIZE = 20;
                           window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
                           window.parent.ACT_DEAL_WINDOW.close(); */
                          location.href = "<%=path%>/ypgl/YYpYpxx/YpxxPage";
                          document.getElementById("zjyp").disabled=false;
                      }
                  });
              }
        } --%>

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
        	/* if ($("#jyksbh").val() == "") {
                alert("请选择检验科室！");
                return false;
            } */
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
        var k = 0;
        //打开收费信息窗口
        function getSfxmmx(type) {
        	k++;
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
            var zxxjyyj = document.getElementById("zxxjyyj").value;
            var jyyj = document.getElementById("jyyj").value;
            if((cpmccx!=""&&cpmccx!=null) || (xmmccx!=""&&xmmccx!=null) || (zxxjyyj!=""&&zxxjyyj!=null)){
            	if(k==1){
					var a = zxxjyyj;
					$("#jyyj").val(a);
            	}else{
            		var jyyj = document.getElementById("jyyj").value;
					var b = jyyj+","+zxxjyyj;
					$("#jyyj").val(b);
            	}
            	document.getElementById('Div1').style.height='320px'; 
	            $.ajax({
	                cache: true,
	                type: "POST",
	                url: url,
	                data: {cpmccx: cpmccx, xmmccx: xmmccx,jzcs:jzcs, zxxjyyj:zxxjyyj},
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

        /* function xgJe(){
        	checkedJe.splice(0,checkedJe.length);
        	var r = document.getElementsByName("checkSfxmmx");
    		for (var i = 0; i < r.length; i++) {
                if (r[i].checked) {
                	var a = r[i].value;
                	checkedJe.push($('#in'+a).val())
                }
    		}
        } */
        
        
        
        var num=1;
        function getDj(obj,dj,cpmc,xmbh,xmmc,jldw,id){
        	/* var mcxs=$('#mcxs').val(); */
        	if(obj.checked==true){
        		//yxxms++;
        		//jyfy+=dj;
        		/* $('#in'+id).val(dj);
        		if(mcxs!=null&&mcxs!=''){
	        		$('#mcxs').val(mcxs+','+mc);
        		}else{
        			$('#mcxs').val(mc);
        		}
        		checked.push(id);
        		checkedJe.push($('#in'+id).val()); */
        		
        		//i=0;
            	
            	var oTest = document.getElementById("mybody");
            	var newNode = document.createElement("tr");
            	newNode.setAttribute('id','mybody'+id);
            	newNode.style.marginLeft="12%";
            	newNode.innerHTML ="<tr><td>"+cpmc+"<input type='text' type='hidden' class='hidden' id='cpmc"+num+"' name='cpmc"+num+"' value='"+cpmc+"'/></td>"
            		+"<td>"+xmmc+"<input type='text' type='hidden' class='hidden' id='xmmc"+num+"' name='xmmc"+num+"' value='"+xmmc+"'/></td>"
            		+"<td style='display: none'><input type='text' type='hidden' class='hidden' id='xmbh"+num+"' name='xmbh"+num+"' value='"+xmbh+"'/></td>"
            		+"<td>"+dj+"<input type='text' type='hidden' class='hidden' id='dj"+num+"' name='dj"+num+"' value='"+dj+"'/></td>"
            		+"<td>"+jldw+"<input type='text' type='hidden' class='hidden' id='jldw"+num+"' name='jldw"+num+"' value='"+jldw+"'/></td>"
            		+"<td><input type='text' style='width:40px;' class='jycs' id='sl"+num+"' name='sl"+num+"' value='1' onblur='getXgje("+num+");'/></td>"
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
               	/* ycnewNode.style.marginLeft="12%"; */
               	ycnewNode.innerHTML ="<tr><td style='text-align: center'>"+cpmc+"</td>"
               		+"<td style='text-align: center'>"+xmmc+"</td>"
               		+"<td style='text-align: center'>"+xmbh+"</td>"
               		+"<td style='text-align: center'>"+dj+"</td>"
               		+"<td style='text-align: center'>"+jldw+"</td>"
               		+"<td style='text-align: center' id='ycsl"+num+"'>1</td>"
               		+"<td style='text-align: center' id='ycxgje"+num+"'>"+dj+"</td>"
               		+"</tr>"
               	ycoTest.insertBefore(ycnewNode,null);	
               		
            	num++;
            	//alert(num);
            	//document.getElementById("num").value=i; 
            	//alert($('#num').val());
        	}else{
        		/* $('#in'+id).val('');
        		var r = document.getElementsByName("checkSfxmmx");
        		var yxmc='';
        		for (var i = 0; i < r.length; i++) {
                    if (r[i].checked) {
                    	var a = r[i].value;
                    	var td = $("#" + a).find("td");
                    	yxmc=yxmc+$(td[2]).text()+",";
                    }
        		}
        		$('#mcxs').val(yxmc.substr(0, yxmc.length-1));
        		checked.pop();
        		checkedJe.pop(); */
        		//jyfy-=dj;
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
            	/* document.getElementById("ycsl"+num).value=jycs;
            	document.getElementById("ycxgje"+num).value=djhj; */
            	document.getElementById("ycsl"+num).innerHTML = jycs;
            	document.getElementById("ycxgje"+num).innerHTML = djhj;
        	}
        	
        }
        //删除行
        function deleteTr(trId){
        	/* if($("#check"+trId).checked==true){
        		alert(0);
        	} */
       		var del = $("#mybody"+trId);
   			del.remove();
   			
   			var del = $("#ycmybody"+trId);
   			del.remove();
   			//yxxms--;
   			//num--;
        }
        
        var flag = false;
        //选择收费明细
        function selectSfxmmx() {
           /*  var r = document.getElementsByName("checkSfxmmx");
            var del = $("#myDiv");
            del.remove();
            var num = 1;
            var str = "";
            var bgbh = document.getElementById("bgbh").value;
            //alert(bgbh);
            var oTest = document.getElementById("num");
            var newNode = document.createElement("div");
            newNode.setAttribute('id', 'myDiv');
            //var flag = false;
            var jyfy = 0;
            for (var i = 0; i < r.length; i++) {
                if (r[i].checked) {
                    flag = true;
                    var a = r[i].value;
                    var td = $("#" + a).find("td");
                    var xgje = $(td[5]).find('input').val();
                    str = str + "<input type='text' id='cpmc" + num + "' name='cpmc" + num + "' value='" + $(td[0]).text() + "'/>"
                    		+ "<input type='text' id='xmbh" + num + "' name='xmbh" + num + "' value='" + $(td[1]).text() + "'/>"
                            + "<input type='text' id='xmmc" + num + "' name='xmmc" + num + "' value='" + $(td[2]).text() + "'/>"
                            + "<input type='text' id='je" + num + "' name='je" + num + "' value='" + $(td[3]).text() + "'/>"
                            + "<input type='text' id='jldw" + num + "' name='jldw" + num + "' value='" + $(td[4]).text() + "'/>"
                            + "<input type='text' id='xgje" + num + "' name='xgje" + num + "' value='" + xgje + "'/>"
                            + "<input type='text' class='sfmxBgbh' id='bgbh" + num + "' name='bgbh" + num + "' value='" + bgbh + "'/>";
                    num = num + 1;
                    document.getElementById("num").value = num;
                    if(xgje!="" && xgje!=null ) {
                    	jyfy += parseInt(xgje);   
                    } else {
                    	jyfy += parseInt($(td[3]).text());
                    }
                }
            } */
            /* if(document.getElementById("num").value=="1"){ */
            
            	
            	
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
                    //alert($(this).val());
                    //var sl = parseInt($(this).val());
                    
                    if($(this).val()==null || $(this).val()==""){
                    	/* alert("请输入检验次数!");
                    	return false; */
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
            
            //document.getElementById("jyfy").value = jyfy;
            /* newNode.innerHTML = str;
            oTest.insertBefore(newNode, null);
            $('#myModal').modal('hide');
            document.getElementById('Div1').style.height='0px';
            $('#mcxs').val('');
            checked.splice(0,checked.length);
            checkedJe.splice(0,checkedJe.length); */
            //yxxms=0;
            
        }
        
       <%--  //样品保存时保存检验项目信息
        function saveSfxmmx() {
        	/* var bgbh = document.getElementById("bgbh").value;
        	$(".sfmxBgbh").val(bgbh); */
        	if (flag == true) {
                var url = "<%=path%>/ypgl/YYpSfxmmx/save";
                $.ajax({
                    cache: true,
                    type: "POST",
                    url: url,
                    data: $('#form').serialize(),// 你的formid
                    async: false,
                    error: function (request) {
                        //alert("保存失败,请联系管理员。");
                    },
                    success: function (data) {
                        //alert(data);
                        //alert('检验收费项目保存成功！');
                    }
                });
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
            } else {
                alert("请选择收费项目！");
                return false;
            }
        } --%>

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
                		str=str+"<tr id='"+data[i].ID+"'><td>"+isNull(data[i].KHMC)+"</td><td>"+isNull(data[i].KHFL)
                		+"</td><td>"+isNull(data[i].DWXZ)+"</td><td><input type ='button' onClick='saveKhxx("+data[i].ID+");' value='选择'></td>";
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
        	 //msg = "确定选择？";
             //if (confirm(msg)) {
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
	         			/* $("#wtdwlxr").val(data[0].LXR);
	         			$("#wtdwdh").val(data[0].GDDH); */
	         			$('#myModalKhxx').modal('hide');
	         		}
	         	  });
             //}
        }
        
        //选择受检单位
        function getSjdw() {
           	var wtdw1 = document.getElementById("wtdw").value;
           	$("#sjdw").val(wtdw1);
           	var wtdwdz1 = document.getElementById("wtdwdz").value;
           	$("#sjdwdz").val(wtdwdz1);
           /* 	var wtdwlxr1 = document.getElementById("wtdwlxr").value;
           	$("#lxr").val(wtdwlxr1);
           	var wtdwdh1 = document.getElementById("wtdwdh").value;
           	$("#dh").val(wtdwdh1); */
        }
        
        //选择生产单位
        function getScdw() {
           	var sjdw = document.getElementById("sjdw").value;
           	$("#scdw").val(sjdw);
           	var sjdwdz = document.getElementById("sjdwdz").value;
           	$("#scdwdz").val(sjdwdz);
           	/* var lxr = document.getElementById("lxr").value;
           	$("#scdwlxr").val(lxr);
           	var dh = document.getElementById("dh").value;
           	$("#scdwdh").val(dh);
           	var yb = document.getElementById("yb").value;
           	$("#scdwyb").val(yb); */
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
                		str=str+"<tr id='"+data[i].ID+"'><td>"+isNull(data[i].XYBH)+"</td><td>"+isNull(data[i].KHMC)+"</td><td>"+isNull(data[i].KHDZ)
                		+"</td><td>"+isNull(data[i].FRDB)+"</td><td><input type ='button' onClick='saveJyhth("+data[i].ID+");' value='选择'></td>";
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
                		str=str+"<tr id='"+data[i].ID+"'><td>"+isNull(data[i].YPBH)+"</td><td>"+isNull(data[i].YPMC)+"</td><td>"+isNull(data[i].YPLX)
                		+"</td><td>"+isNull(data[i].SCDW)+"</td><td><input type ='button' onClick='ypfz("+data[i].ID+");' value='复制'></td>";
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
        
        //判断字段是否有值
        function isNull(string){
			if(string==null||string=='null'){
				return '';
			}else{
				return string
			}
		}
        
        //跳转到样品复制页面
        function ypfz(id) {
        	location.href="gcypfzPageView?id="+id;
       }
      
        //关闭样品信息窗口
        function closeYpxxWin() {
        	$("#ypbhcx").val("");
        	$("#ypmccx").val("");
	        var del = $("#table");
	        del.remove();
	        $('#myModalYpxx').modal('hide');
        }
      
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
                    //changeButton = "1";
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
<body onload="load();">
<div style="display:none;">
    <ul class="tab-menu tab" id="tabMenuID_">
        <li class="tab-selected" title="样品登记">
            <a href="<%=path%>/ypgl/YYpYpxx/YpdjPage" target="content" onfocus="this.blur()"><span>样品登记</span></a>
        </li>
    </ul>
</div>
<div class="wrapper">
    <div class="panel">
        <!-- <header class="panel-heading" style="padding-left: 650px;">样品信息</header> -->
        <div class="col-lg-12">
                <div class="panel-body">
                    <form class="form-horizontal tasi-form" name="gcypForm" id="gcypForm" method="post">
                        <%--收放效果开始--%>
                        <div class="panel-group m-bot20" id="accordion">
                            <div class="panel panel-default" style="margin-top: 8px;">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a class="accordion-toggle" data-toggle="collapse"
                                           data-parent="#accordion"
                                           href="#collapseOne">
                                            <div>样品信息</div>
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseOne" class="panel-collapse collapse in">
                                    <div class="panel-body" style="overflow:scroll;overflow-x:hidden">
                                        <div class="form-group"
                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                            <label class="col-sm-2 col-sm-2 control-label"
                                                   style="margin-top: 15px;"><span style="color:red">*</span>检验科室：</label>

                                            <div class="col-sm-10" style="margin-top: 21px;">
                                                <input id="jyks" name="jyks" class="easyui-combotree" value="" required
                                                       style="height: 34px;width: 238px;"/>
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label"
                                                   style="margin-top: 18px;"><span style="color:red">*</span>字号名称：</label>
                                            <div class="col-sm-10" style="margin-top: 21px;">
                                                <select class="form-control input-lg m-bot15" id="zh" name="zh" 
                                                required onclick="getBh();">
                                                	<option selected="selected" value="">请选择...</option>
                                                    <c:forEach var="gczh" items="${gczh}" varStatus="obj">
                                                        <option value="${gczh.zhmc }">${gczh.zhmc }</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <!-- <label class="col-sm-2 col-sm-2 control-label"
                                                   style="margin-top: 19px;">二维码图片:</label>

                                            <div class="col-sm-10">
                                                <div id="code" style="width: 100px;height: 100px;"></div>
                                            </div> -->
                                            <label class="col-sm-2 col-sm-2 control-label" style="margin-top: 18px;">样品移交：</label>
                                            <div class="col-sm-10" style="margin-top: 24px;">
                                                <label><input type="radio" checked="checked" name="ypyj" value="0">是</label>
                                                <label style="padding-left: 20px;"><input type="radio" name="ypyj" value="1">否</label>
                                            </div>
                                        </div>

                                        <div class="form-group"
                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                            <label class="col-sm-2 col-sm-2 control-label"
                                                   style="margin-top: 0px;"><span style="color:red">*</span>业务科室：</label>
                                            <div class="col-sm-10" style="margin-top: 3px;">
                                                <input id="ywks" name="ywks" class="easyui-combotree" value=""
                                                       style="height: 34px;width: 238px;" required/>
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>样品编号：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="ypbh" name="ypbh" readonly="readonly">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>报告编号：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="bgbh" name="bgbh" readonly="readonly">
                                            </div>
                                        </div>
                                        
                                        <div class="form-group"
                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                            <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>样品名称：</label>

                                            <div class="col-sm-10">
<!--                                                         <input class="form-control" type="text" id="ypmc" name="ypmc"> -->
                                                <input class="form-control" required data-msg-required="必填" minlength="1" 
                                                data-msg-minlength="必填" onKeyUp="checkLen(this,72)" type="text" placeholder="必填且最多输入36个字"
                                                placeholder="必填" id="ypmc" name="ypmc" onBlur="changeCpmccx();">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">样品类型：</label>

                                            <div class="col-sm-10">
                                                <select class="form-control input-lg m-bot15" name="yplx" >
                                                    <option selected="selected" value="">请选择...</option>
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
	                                              placeholder="最多输入8个字">
	                                        </div>
	                                          <!-- <div class="col-sm-10">
	                                              <select class="form-control input-lg m-bot15" name="ypdj" >
	                                                  <option selected="selected" value="">请选择...</option>
	                                                  <option>一级</option>
	                                                  <option>二级</option>
	                                                  <option>三级</option>
	                                              </select>
	                                          </div> -->
	                                      </div>
	
	                                      <div class="form-group"
	                                           style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
	                                          <label class="col-sm-2 col-sm-2 control-label">样品状态：</label>
	                                          <!-- <div class="col-sm-10" style="margin-top: 5px; width: 19%;">
	                                              <label><input type="radio" name="ypzt" value="良好" checked="checked">良好</label>
	                                              <label style="padding-left: 10px;"><input type="radio" name="ypzt" value="损坏">损坏</label>
	                                              <label style="padding-left: 10px;"><input type="radio" name="ypzt" value="一般">一般</label>
	                                          </div> -->
	                                          <div class="col-sm-10">
	                                              <input class="form-control" type="text" id="ypzt" name="ypzt" onKeyUp="checkLen(this,76)"  
	                                              placeholder="最多输入38个字">
	                                          </div>
                                            <label class="col-sm-2 col-sm-2 control-label">来样方式：</label>
                                            <div class="col-sm-10" style="margin-top: 5px;">
                                                <label><input type="radio" name="lyfs" value="0" checked="checked">直送</label>
                                                <label style="padding-left: 20px;"><input type="radio" name="lyfs" value="1">快递</label>
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">规格型号：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="ggxh" name="ggxh" placeholder="最多输入50个字" 
                                                onKeyUp="checkLen(this,100)">
                                            </div>
                                        </div>


                                        <div class="form-group"
                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                            <label class="col-sm-2 col-sm-2 control-label">所在城市：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="szcs" name="szcs" onKeyUp="checkLen(this,90)" 
                                                placeholder="最多输入45个字">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">生产日期批次：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="scrqpc"
                                                       name="scrqpc" onKeyUp="checkLen(this,56)" placeholder="最多输入28个字">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">商标：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="sb" name="sb" onKeyUp="checkLen(this,40)" 
                                                placeholder="最多输入20个字">
                                            </div>
                                        </div>
                                        
                                        <div class="form-group"
                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                            <label class="col-sm-2 col-sm-2 control-label">领样日期：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control Wdate" type="text" id="lyrq"
                                                       name="lyrq" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
                                            </div> 
                                            <label class="col-sm-2 col-sm-2 control-label">领样数量：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="lysl" name="lysl"  
                                                onKeyUp="checkLen(this,34)" placeholder="最多输入17个字"/> 
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">领样人：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="lyr" name="lyr" onKeyUp="checkLen(this,16)" 
                                                placeholder="最多输入8个字">
                                            </div>
                                        </div>
                                        
                                        <div class="form-group"
                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                            <label class="col-sm-2 col-sm-2 control-label">抽样单位：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="cydw" name="cydw" onKeyUp="checkLen(this,72)"
                                                placeholder="最多输入36个字">
                                            </div>
                                            <label for="ypsl" class="col-sm-2 col-sm-2 control-label">样品数量：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="ypsl" name="ypsl" 
                                                 placeholder="最多输入14个字" onKeyUp="checkLen(this,28)"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a class="accordion-toggle" data-toggle="collapse"
                                           data-parent="#accordion"
                                           href="#collapseTwo">
                                            <div>工程信息</div>
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseTwo" class="panel-collapse collapse">
                                    <div class="panel-body" style="overflow:scroll;overflow-x:hidden">
                                    	<div class="form-group"
                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                            <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>工程名称：</label>
                                            <div class="col-sm-10">
                                                <!-- <input id="sjdw" name="sjdw" class="easyui-combotree" value="" style="width:248px;height: 34px;"/> -->
                                                <input class="form-control" type="text" id="gcmc" name="gcmc" required onKeyUp="checkLen(this,72)"
                                                placeholder="必填且最多输入36个字" >
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>工程地址：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="gcdz"
                                                       name="gcdz" required onKeyUp="checkLen(this,102)" placeholder="必填且最多输入51个字" >
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">工程联系人：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="gclxr"
                                                       name="gclxr" onKeyUp="checkLen(this,16)" placeholder="最多输入8个字">
                                            </div>
                                        </div>
                                        
                                        <div class="form-group"
                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                            <label class="col-sm-2 col-sm-2 control-label">联系电话：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="dh" name="dh" 
                                                placeholder="请输入正确的手机号码格式" data-rule-mobile="true" 
                                                data-msg-mobile="请输入正确的手机号码格式">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">施工单位：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="sgdw"
                                                       name="sgdw" onKeyUp="checkLen(this,72)" placeholder="最多输入36个字">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">设计单位：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="gcsjdw"
                                                       name="gcsjdw" onKeyUp="checkLen(this,72)" placeholder="最多输入36个字">
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
                                                <input class="form-control" type="text" id="wtdw" name="wtdw" onKeyUp="checkLen(this,72)"
                                                placeholder="最多输入36个字">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">委托单位地址：</label>

                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="wtdwdz"
                                                       name="wtdwdz" onKeyUp="checkLen(this,90)" placeholder="最多输入45个字">
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
                                                <input class="form-control" type="text" id="sjdw" name="sjdw" onKeyUp="checkLen(this,72)"
                                                placeholder="最多输入36个字">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">受检单位地址：</label>

                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="sjdwdz"
                                                       name="sjdwdz" onKeyUp="checkLen(this,90)" placeholder="最多输入45个字">
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
                                                <input class="form-control" type="text" id="scdw" name="scdw" onKeyUp="checkLen(this,72)"
                                                placeholder="最多输入36个字">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">生产单位地址：</label>

                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="scdwdz" name="scdwdz" onKeyUp="checkLen(this,90)" 
                                                placeholder="最多输入45个字">
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
                                                <input class="form-control" type="text" id="jsdw" name="jsdw" onKeyUp="checkLen(this,72)"
                                                placeholder="最多输入36个字">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">监理单位：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="jldw" name="jldw" onKeyUp="checkLen(this,72)"
                                                placeholder="最多输入36个字">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">监理人：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="jlr" name="jlr" onKeyUp="checkLen(this,16)"
                                                placeholder="最多输入8个字">
                                            </div>
                                        </div>
                                        
                                        <div class="form-group"
                                             style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                            <label class="col-sm-2 col-sm-2 control-label">见证单位：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="jzdw" name="jzdw" onKeyUp="checkLen(this,72)"
                                                placeholder="最多输入36个字">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">见证人：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="jzr" name="jzr" onKeyUp="checkLen(this,16)" 
                                                placeholder="最多输入8个字">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">受理人：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="slr" name="slr" onKeyUp="checkLen(this,16)"
                                                placeholder="最多输入8个字">
                                            </div>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a class="accordion-toggle" data-toggle="collapse"
                                           data-parent="#accordion"
                                           href="#collapseThree">
                                            <div>检验信息</div>
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseThree" class="panel-collapse collapse">
                                    <div class="panel-body" style="overflow:scroll;overflow-x:hidden">
                                    
                                        <div class="form-group" style="padding-bottom: 2px; padding-top: 0px; margin-bottom: 0px; 
                                        width: 100%; margin-left: 0px; margin-right: 0px;">
                                            <label class="col-sm-2 col-sm-2 control-label">检验项目：</label>
                                            <div class="col-sm-10">
		            						<textarea class="form-control ckeditor textarea" rows="6" name="jyxm" onKeyUp="checkLen(this,320)"
                                            id="jyxm" truetype="textarea" style="width: 409%;height: 35px;" 
                                            placeholder="最多输入160个字">共 项【详见附页】</textarea>
                                            </div>
                                            <div class="col-sm-10" style="margin-top: 5px;left: 55%;">
                                            <label class="col-sm-2 col-sm-2 control-label">
                                                    <a href="#myModal" data-toggle="modal"
                                                       class="btn btn-xs btn-sucess">选择检验项目</a>
                                            </label>
                                            </div>
                                            <!-- <div class="col-sm-13">
                                            </div> -->
                                        </div>
                                        
                                        <div class="form-group" style="padding-bottom: 2px; padding-top: 0px; margin-bottom: 0px; 
                                        width: 100%; margin-left: 0px; margin-right: 0px;">
                                            <label class="col-sm-2 col-sm-2 control-label">检验依据：</label>
                                            <div class="col-sm-13">
											<textarea class="form-control ckeditor textarea" rows="6" name="jyyj" id="jyyj"
                                          truetype="textarea" style="width: 99.5%;height: 35px;" onKeyUp="checkLen(this,150)" 
                                                  placeholder="最多输入75个字"></textarea>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group" style="padding-bottom: 2px; padding-top: 0px; margin-bottom: 0px; 
                                        width: 100%; margin-left: 0px; margin-right: 0px;">
                                            <label class="col-sm-2 col-sm-2 control-label">检验费用：</label>
                                            <div class="input-group m-bot15 col-sm-10" style="width: 19%;">
                                                <input class="form-control" type="text" id="jyfy" name="jyfy" data-rule-number="true" 
                                                        data-msg-number="请输入正确的数字" data-gt="0"  maxlength="10" placeholder="最多输入10个数字"/>
                                                        <span class="input-group-addon">元</span>
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">检验费用待定：</label>
                                            <div class="col-sm-10" style="margin-top: 5px;">
                                                <label><input type="radio" name="jyfydd" value="0">待定</label>
                                                <label style="padding-left: 20px;"><input type="radio" name="jyfydd" 
                                                 checked="checked" value="1">不待定</label>
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">验后需退库：</label>
                                            <div class="col-sm-10">
                                                <select class="form-control input-lg m-bot15" name="yhxtk" id="yhxtk" >
                                                	<option selected="selected" value="">请选择...</option>
                                                    <c:forEach var="yhxtk" items="${yhxtk}" varStatus="obj">
                                                        <option value="${yhxtk.zdz }">${yhxtk.zdmc }</option>
                                                    </c:forEach>
                                                </select>
                                            </div>   
                                        </div>

                                        <div class="form-group" style="padding-bottom: 2px; padding-top: 0px; margin-bottom: 0px;  
                                        width: 100%; margin-left: 0px; margin-right: 0px;">
                                            <label class="col-sm-2 col-sm-2 control-label"><span style="color:red">*</span>检验类型：</label>
                                            <div class="col-sm-10">
                                                <select class="form-control input-lg m-bot15" name="jylx" id="jylx" 
                                                required data-msg-required="必填" >
                                                	<option selected="selected" value="">请选择...</option>
                                                    <c:forEach var="jylx" items="${jylx}" varStatus="obj">
                                                        <option value="${jylx.zdz }">${jylx.zdmc }</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label" style="margin-top: -5px;
                                             margin-bottom: 5px; width: 13%;" >
                                            <a class="btn btn-xs btn-success" href="#myModalJyhth" data-toggle="modal" 
                                               type="button" onClick="getJyhth();" style="width:85%">检验合同号</a>
                        					</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="jyhth" name="jyhth" onKeyUp="checkLen(this,50)" 
                                                placeholder="最多输入25个字">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">检查封样人员：</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="jcfyry" name="jcfyry" onKeyUp="checkLen(this,16)" 
                                                placeholder="最多输入8个字">
                                            </div>
                                        </div>

                                        <div class="form-group" style="padding-bottom: 2px; padding-top: 0px; margin-bottom: 0px; 
                                         width: 100%; margin-left: 0px; margin-right: 0px;">
                                            <label class="col-sm-2 col-sm-2 control-label">报告发送方式：</label>
                                            <div class="col-sm-10" style="margin-top: 5px;width: 40%;">
                                                <label><input type="radio" name="bgfsfs" value="0" checked="checked">邮寄</label>
                                                <label><input type="radio" name="bgfsfs" value="1">自取（本院）</label>
                                                <label><input type="radio" name="bgfsfs" value="2">自取（中心）</label>
                                            </div>
                                        </div>

                                        <div class="form-group" style="padding-bottom: 2px; padding-top: 0px; margin-bottom: 0px; 
                                        width: 100%; margin-left: 0px; margin-right: 0px;">
                                            <label class="col-sm-2 col-sm-2 control-label">到样日期：</label>

                                            <div class="col-sm-10">
                                                <input class="form-control Wdate" type="text" id="dyrq"
                                                       name="dyrq"
                                                       onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
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
                                                <input class="form-control Wdate" type="text" id="wcqx" name="wcqx"
                                                       onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
                                            </div>
                                            <label class="col-sm-2 col-sm-2 control-label">样品附件：</label>
					                        <div class="box">
				                                <input type="text" name="copyFile"  class="textbox" />
									            <a href="javascript:void(0);"  class="link">...</a>
									            <input type="file" class="uploadFile" name="file" id="attachMentFile"
									             onchange="getFile(this,'copyFile')" />
									             <input type="hidden" id="fj" name="fj">
											</div>
                                        </div>

                                        <div class="form-group" style="padding-bottom: 2px; padding-top: 0px; margin-bottom: 0px; 
                                        width: 100%; margin-left: 0px; margin-right: 0px;">
                                             <label class="col-sm-2 col-sm-2 control-label">备注：</label>

                                             <div class="col-sm-13">
												<textarea class="form-control ckeditor textarea" rows="6" name="bz"
                               					truetype="textarea" style="width: 99.5%;height: 35px;" onKeyUp="checkLen(this,240)" 
                                                  placeholder="最多输入120个字"></textarea>
                                              </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            
                            <!-- <label class="col-sm-2 col-sm-2 control-label" type="hidden">检验科室编号：</label> -->
                            <div class="hidden">
                                <input type="hidden" class="hidden" id="jyksbh" name="jyksbh" value="">
                            </div>
                            <!-- <label class="col-sm-2 col-sm-2 control-label" type="hidden">业务科室编号：</label> -->
                            <div class="hidden">
                                <input type="hidden" class="hidden" id="ywksbh" name="ywksbh">
                            </div>
                            <!-- <label class="col-sm-2 col-sm-2 control-label">二维码编号：</label> -->
                            <div class="hidden">
                                <input type="hidden" class="hidden" id="ewmbh" name="ewmbh">
                            </div>
                            <input type="hidden" class="hidden" id="wtdwlxr" name="wtdwlxr">
                            <input type="hidden" class="hidden" id="wtdwdh" name="wtdwdh">
                            <input type="hidden" class="hidden" id="djlx" name="djlx" value="1">
                            
                            <div style="text-align: center;margin-top: 10px;">
                                <div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 50px;">
                                    <button type="button" class="btn btn-primary" disabled="disabled"
                                    		id="zjyp" name="zjyp" onClick="addThisYpxx();">追加样品
                                    </button>
                                    <button type="button" class="btn btn-primary"
                                            onClick="PrintOneURL();">打印流转单
                                    </button>
                                    <button type="button" class="btn btn-primary"
                                            onClick="onPrintXysClick();">打印协议书
                                    </button>
                                    <button type="button" class="btn btn-primary"
                                            onClick="onPrintEwmClick();">打印二维码
                                    </button>
                                    <button href="#myModalYpxx" data-toggle="modal" type="button" class="btn btn-success"
                                 			onClick="getYpxxList();">样品复制
                                    </button>
                                    <button type="submit" class="btn btn-primary" >提交</button>
                                    <button type="button" class="btn btn-success"
                                            onClick="exit();">返回
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
</div>


</body>

<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content" style="width: 140%;left: -15%;">
            <!-- <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h4 class="modal-title">抽样人员选择</h4>
            </div> -->
            <div class="modal-body">
                <!-- <form class="form-horizontal" role="form"> -->
                <section class="panel" id="sect">
                    <header class="panel-heading">检验收费项目</header>
                    <label style="margin-left: 6px;">产品名称:</label>&nbsp;<input id="cpmccx" name="cpmccx" value="${ypxxcpmc.ypxxcpmc }">&nbsp;&nbsp;&nbsp;
                    <label>检验依据:</label>&nbsp;&nbsp;&nbsp;<input id="zxxjyyj" name="zxxjyyj">&nbsp;&nbsp;&nbsp;
                    <label>项目名称:</label>&nbsp;&nbsp;&nbsp;<input id="xmmccx" name="xmmccx">
                    <button onClick="getSfxmmx(0);">查询</button>
                    <button onClick="dyqd();">打印</button><br/>
                    <label style="margin-left: 6px;" id="yxxm">已选项目:</label> <!-- <textarea rows="2" id="mcxs" name="mcxs" truetype="textarea" style="width: 85%;"></textarea> -->
                    <form id="xmForm" name="xmForm">
                    	<div id="hidden" align="center" style="display:'none'">
						     <input type="hidden" name="num" id="num" >
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
						</tbody>
					</table>
					</form>
					<!-- <div class="form-group" style="padding-bottom: 2px; padding-top: 0px; margin-bottom: 0px; 
                                        width: 100%; margin-left: 0px; margin-right: 0px;">
                    <label style="margin-left: 6px;">费用合计:</label>
                    <input id="fyhj" id="num" name="fyhj">
                    </div> -->
                    <div id="Div1" style="overflow:auto"></div>
                    <span id="sbz"></span>
                    <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
                        <div class="col-lg-offset-2 col-lg-10" style="margin-top: 10px;">
                            <button type="button" class="btn btn-default" onclick="getSfxmmx(1);"
                                    style="margin-left: 120px;">加载更多...
                            </button>
                        </div>
                    </div>
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

<!-- 隐藏已选中的检验项目--开始 -->
<div>
	<form id="ttt" style="display: none">
	    <table style="width:100%" class="tablePrint" id="table1">
			<tr>
				<th>产品名称</th>
				<th>项目名称</th>
				<th>项目编号</th>
				<th>单价金额</th>
				<th>计量单位</th>
				<th>检验次数</th>
				<th>修改金额</th>
			</tr>
			<tbody id="ycmybody">
				<tr id="tr" style="display: none" ><td></td></tr>
			</tbody>
		</table>
	</form>
</div>
<!-- 隐藏已选中的检验项目--结束 -->

<style>
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
</style>
<script type="text/javascript">
	function dyqd() {	
		CreateOneFormPage();	
		LODOP.PREVIEW();	
	};
	
	function CreateOneFormPage(){
		LODOP=getLodop();  
		var strBodyStyle="<style>"+document.getElementById("printStyle").innerHTML+"</style>";
		
		var tableHtml;
	    var tableObj=$('<table class="tablePrint"></table>');
	    var tableCon=$("<div  style='margin-left:1px;'></div>");
	    tableCon.append(tableObj);
	    tableObj.append($("#table1").html());
	    tableHtml=tableCon.html();
		var strBodyHtml=strBodyStyle+"<body style='font-size: 10pt;'>"+tableHtml+"</body>";
		
		LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_表单一");
		LODOP.SET_PRINT_STYLE("FontSize",20);
		LODOP.SET_PRINT_STYLE("Bold",1);
		LODOP.ADD_PRINT_TEXT("5%","35%","100%","100%","检验收费项目清单");
		LODOP.ADD_PRINT_HTM("10%","10%","80%","100%",strBodyHtml);
		/* LODOP.ADD_PRINT_TEXT("5%","0%","100%","100%","收费项目清单");
		LODOP.ADD_PRINT_HTM("10%","10%","80%","100%",strBodyHtml); */
	};
	
</script>
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
.tablePrint th {
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
</html>

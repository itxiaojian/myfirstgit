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
    <title>移动质检业务平台</title>
    <script type="text/javascript">var PATH = '<%=path%>';</script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
    <script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	
	<script type="text/javascript" src="<%=path%>/resources/js/yz/jquery-1.10.2.min.js"></script>
	
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css">
    <script type="text/javascript" src="<%=path%>/resources/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/datePicker/WdatePicker.js"></script>
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/system/login/css/padstyle.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/upload.css">
    <script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.qrcode.min.js"></script>
    <script language="javascript" src="<%=path%>/resources/lodop/LodopFuncs.js"></script>
    <script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
    
    <script type="text/javascript" src="<%=path%>/resources/js/ajaxfileupload.js"></script>
    
    <script type="text/javascript" src="<%=path%>/resources/js/yz/jquery.validate.js"></script>
    <!--common script for all pages-->
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="<%=path%>/resources/js/html5shiv.js"></script>
    <script src="<%=path%>/resources/js/respond.min.js"></script>
    <![endif]-->
    <style>
	.ZJ_mian_left{ position:absolute; left:-130px; top:0px; bottom:0px;width:130px; background:url(/zjyw/system/layout/img/L_BJ02.png) center no-repeat; background-size:cover;overflow:auto; z-index:5;}
	</style>
    
   <script>
   
   	//var finaBgbh = document.getElementById("bgbh").value;
	function save(){
		//jquery.validate
// 		$("#myForm").validate({
// 			submitHandler: function() {
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
              var fy = document.getElementById("jyfy").value;
              //alert(fy);
              if(parseInt(fy)>parseInt(jysyje)){
            	 alert("协议剩余金额不足支付此次检验，请与相关业务科联系！");
            	 return false;
              }
              
              msg = "确定要提交？";
              if (confirm(msg)) {
                  var saveurl = "<%=path%>/ypgl/YYpYpxx/save";
                  var bgbhNum = document.getElementById("ypbh").value;
              	  $(".sfmxBgbh").val(bgbhNum);
                  $.ajax({
                      cache: true,
                      type: "POST",
                      url: saveurl,
                      data: $('#myForm').serialize(),// 你的formid
                      async: false,
                      error: function (request) {
                          alert("保存失败,请联系管理员。");
                      },
                      success: function (data) {
                          sfTj = 1;
                          document.getElementById("zjyp").disabled=false;
                          
                          //alert(data);
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
              
// 			}
// 		});
	}
	
	 function exit(){
//  		success: function () {
 	       msg="确定退出？";
        		if(confirm(msg)){
        			location.href="<%=path%>/j_spring_security_logout"
    			}
//  		}
 	}

</script>   
    <script type="text/javascript">
    
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
            //生成二维码
            var str = "${url}";
            $("#code").qrcode({
                width: 100,
                height: 100,
                text: str
            });
        }

        var sfTj = 0;
        //提交

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
        
        function onPrintCydClick() {           //打印抽样单
        	if (sfTj == 1) { 
        		var ypbh = $("#ypbh").val();
         		window.open("YpCydPage?ypbh="+ypbh, "样品抽样单", "height=750, width=800, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no");
        	} else {
                alert('请提交保存后再打印抽样单！');
            }
           
        } 
        
        function onPrintEwmClick() {           //打印二维码
        	var ypbh = $("#ypbh").val();
        	if (sfTj == 1) {
        		window.open('ypewmPage?ypbh='+ypbh,'样品标签','height=500px, width=600px,top=200px, left=300px, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
        	} else {
                alert('请提交保存后再打印二维码！');
            }
        }

        function getBh() {
            var jyksbh = document.getElementById("jyksbh").value;
            if (jyksbh == "") {
                alert("请先选择检验科室");
                return false; 
            } else {
                var zhmc = document.getElementById("zh").value;
                if (zhmc == "") {
                    return false; 
                }
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
        	if(type=='1'){
        		jzcs++;
        	}else{
        		jzcs=1;
        	}
            var url = "<%=path%>/ypgl/YYpYpxx/Sfxmmx";
            var cpmccx = document.getElementById("cpmccx").value;
            var xmmccx = document.getElementById("xmmccx").value;
            if((cpmccx!=""&&cpmccx!=null) || (xmmccx!=""&&xmmccx!=null)){
            	document.getElementById('Div1').style.height='42%'; 
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
	                    var oTest = document.getElementById("Div1");
	                    var newNode = document.createElement("table");
	                    newNode.setAttribute('class', 'table');
	                    newNode.setAttribute('id', 'table');
	                    newNode.innerHTML = str;
	                    oTest.insertBefore(newNode, null);
	                }
	            });
            }else {
            	alert("请输入查询条件！");
            	return false;
            }
        }

        var num=1;
        function getDj(obj,dj,cpmc,xmbh,xmmc,jldw,id){
        	if(obj.checked==true){
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
            
        }
        

        //关闭收费窗口
        function closeWin() {
            $('#myModal').modal('hide');
            document.getElementById('Div1').style.height='0px';
            $('#mcxs').val('');
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
	         			$("#wtlxr").val(data[0].LXR);
	         			$("#sjhm").val(data[0].GDDH);
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
           	var wtdwlxr1 = document.getElementById("wtlxr").value;
           	$("#lxr").val(wtdwlxr1);
           	var wtdwdh1 = document.getElementById("sjhm").value;
           	$("#dh").val(wtdwdh1);
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
           	var dh = document.getElementById("dh").value;
           	$("#scdwdh").val(dh);
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
                	var str="<table><thead><tr><th>协议编号</th><th>客户名称</th><th>客户地址</th><th>剩余金额</th>"
        				   +"<th>操作</th></tr></thead><tbody>";
                	for(var i=0;i<data.length;i++){
                		str=str+"<tr id='"+data[i].ID+"'><td>"+isNull(data[i].XYBH)+"</td><td>"+isNull(data[i].KHMC)+"</td><td>"+isNull(data[i].KHDZ)
                		+"</td><td>"+isNull(data[i].SYJE)+"</td><td><input type ='button' onClick='saveJyhth("+data[i].ID+");' value='选择'></td>";
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
        var jysyje;
        function saveJyhth(id) {
        	var td = $("#"+id).find("td");
        	$("#jyhth").val($(td[0]).text());
        	jysyje = $(td[3]).text();
        	//alert(jysyje);
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
        	location.href="cyypfzPageView?id="+id;
        }
      
        //关闭样品信息窗口
        function closeYpxxWin() {
        	$("#ypbhcx").val("");
        	$("#ypmccx").val("");
	        var del = $("#table");
	        del.remove();
	        $('#myModalYpxx').modal('hide');
        }
      
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
<div class="ipad">
    <div class="ZJ_top">
        <span id="L_btn"><img src="<%=path%>/system/layout/img/top_01.png"></span>
        <span>移动质检业务管理平台</span>
        <span><a onclick="exit();"><img src="<%=path%>/system/layout/img/top_03.png"></a></span>
        <span><img src="<%=path%>/system/layout/img/top_02.png">欢迎您：${sessionScope['LOGIN_USER'].xm}&nbsp;&nbsp;</span>
    </div>
    <div class="ZJ_mian" style="background-color: #fff">
        <div class="ZJ_mian_left" id="left_nav">
        	<ul>
            	<a href="<%=path%>/system/layout/main1.jsp"><li><img src="<%=path%>/system/layout/img/L_01.png">&nbsp;&nbsp;平台首页</li></a>
                <a href="<%=path%>/ZjPad/CydjPage"><li><img src="<%=path%>/system/layout/img/L_02.png">&nbsp;&nbsp;抽样登记</li></a>
                <a href="<%=path%>/ZjPad/ZxxxList"><li><img src="<%=path%>/system/layout/img/L_03.png">&nbsp;&nbsp;检验咨询</li></a>
                <a href="<%=path%>/ZjPad/ypcxPage"><li><img src="<%=path%>/system/layout/img/L_04.png">&nbsp;&nbsp;样品查询</li></a>
                <a href="<%=path%>/ZjPad/bgcxPage"><li><img src="<%=path%>/system/layout/img/L_05.png">&nbsp;&nbsp;报告查询</li></a>
                <a href="<%=path%>/ZjPad/bgshlist?ypcs=2"><li><img src="<%=path%>/system/layout/img/L_06.png">&nbsp;&nbsp;报告审核</li></a>
                <a href="<%=path%>/ZjPad/bgshlist?ypcs=3"><li><img src="<%=path%>/system/layout/img/L_07.png">&nbsp;&nbsp;报告批准</li></a>
                <a href="<%=path%>/ZjPad/warnPage"><li><img src="<%=path%>/system/layout/img/L_08.png">&nbsp;&nbsp;报告预警</li></a>
<%--                 <a href="<%=path%>/ypgl/YYpYj/ypyjPage;"><li><img src="<%=path%>/system/layout/img/L_09.png">&nbsp;&nbsp;样品移交</li></a> --%>
                <a href="<%=path%>/ZjPad/sbcxPage"><li><img src="<%=path%>/system/layout/img/L_11.png">&nbsp;&nbsp;设备查询</li></a>
                <a href="<%=path%>/ZjPad/tjtbPage"><li><img src="<%=path%>/system/layout/img/L_12.png">&nbsp;&nbsp;统计图表</li></a>
                <a href="<%=path%>/ZjPad/tjbbPage"><li><img src="<%=path%>/system/layout/img/L_12.png"/>&nbsp;&nbsp;统计报表</li></a>
            </ul>
        </div>
        <div class="ZJ_mian_right" id="main_R">
        <form  name="myForm" id="myForm" method="post">
        	<div class="ZJ_Biao">
            	<div class="ZJ_Biao_title" style="margin-top: 4px;">样品信息</div>
                <div class="ZJ_Biao_msg">
                    <ul>
                        <li>
                        	&nbsp;&nbsp;<span style="color:red">*</span>检验科室&nbsp;&nbsp;
                            <input type="text" class="Biao_input01 easyui-combotree" id="jyks" name="jyks" required >
                        </li>
                        <li>
                        	&nbsp;&nbsp;<span style="color:red">*</span>业务科室&nbsp;&nbsp;
                            <input type="text" class="Biao_input01 easyui-combotree" id="ywks" name="ywks" required >
                        </li>
                        <li>
                        	&nbsp;&nbsp;<span style="color:red">*</span>字号名称&nbsp;&nbsp;
                            <select id="zh" name="zh" required onclick="getBh();" style="width: 61%;">
                            		<option selected="selected" value="">请选择...</option>
		                        <c:forEach var="ybzh" items="${ybzh}" varStatus="obj">
		                            <option value="${ybzh.zdmc }">${ybzh.zdmc }</option>
		                        </c:forEach>
                            </select>
                        </li>
                        <li>&nbsp;&nbsp;<span style="color:red">*</span>样品编号&nbsp;&nbsp;
                        <input type="text" class="Biao_input01" id="ypbh" name="ypbh"
                        placeholder="不可手输，自动填充" readonly="readonly" required style="width: 61%;" >
                        </li>
                    </ul>
                    <ul>
                        <li>
                        	&nbsp;&nbsp;<span style="color:red">*</span>产品名称&nbsp;&nbsp;
                            <input type="text" class="Biao_input01"placeholder="必填且最多输入36个字" required 
                            data-msg-required="必填" minlength="1" data-msg-minlength="必填" maxlength="36" type="text"
                            id="ypmc" name="ypmc" onBlur="changeCpmccx();" style="width: 61%;" >
                        </li>
                        <li>
                        	&nbsp;&nbsp;产品等级&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="ypdj" name="ypdj" 
                            placeholder="最多输入8个字" onKeyUp="checkLen(this,16)">
                        </li>
                        <li>
                        	&nbsp;&nbsp;商&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="sb" name="sb" maxlength="8" placeholder="最多输入8个字">
                        </li>
                        <li>&nbsp;&nbsp;是否为出口产品&nbsp;&nbsp;
                        	<input type="radio" checked="checked" name="sfwckcp" value="0" />是&nbsp;&nbsp;
                            <input type="radio" name="sfwckcp" value="1" />否
                        </li>
                    </ul>
                    <ul>
                        <li>
                        	&nbsp;&nbsp;任务来源&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="rwly" name="rwly" maxlength="36" 
                            placeholder="最多输入36个字">
                        </li>
                        <li>
                        	&nbsp;&nbsp;规格型号&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="ggxh" name="ggxh"  
                            placeholder="最多输入45个字" onKeyUp="checkLen(this,90)">
                        </li>
                        <li>
                        	&nbsp;&nbsp;生产日期/批号&nbsp;&nbsp;
                            <input type="text" class="Biao_input02" id="scrqpc" style="width: 125px;"
                            name="scrqpc" placeholder="最多输入28个字" onKeyUp="checkLen(this,56)">
                        </li>
                        <li>&nbsp;&nbsp;备样量及封存地点&nbsp;
                        	<input type="text" class="Biao_input02" id="byljfcdd" name="byljfcdd" 
                        	maxlength="36" placeholder="最多输入36个字" style="width: 43%;">
                        </li>
                    </ul>
                     <ul>
                        <li>
                        	&nbsp;&nbsp;寄送样地点&nbsp;&nbsp;
                            <input type="text" class="Biao_input03" id="jsydd" name="jsydd" 
                            maxlength="36" placeholder="最多输入36个字">
                        </li>
                        <li>
                        	&nbsp;&nbsp;寄送样截止日期&nbsp;
                            <input type="text" class="Biao_input02 Wdate" id="jsyjzrq"
                            name="jsyjzrq" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
                        </li>
                        <li>
                        	&nbsp;&nbsp;封样状态&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="ypzt" name="ypzt" maxlength="38" 
                            placeholder="最多输入38个字">
                        </li>
                        <li>&nbsp;&nbsp;抽样单位&nbsp;&nbsp;
                        	<input type="text" class="Biao_input01" id="cydw" name="cydw" maxlength="36"
                            placeholder="最多输入36个字">
                        </li>
                    </ul>
                    <ul>
                        <li>
                        	&nbsp;&nbsp;抽样单位地址&nbsp;&nbsp;
                            <input type="text" class="Biao_input02" id="cydwdz" name="cydwdz" maxlength="36"
                            placeholder="最多输入36个字" style="width: 132px;">
                        </li>
                        <li>
                        	&nbsp;&nbsp;抽样单位联系人&nbsp;&nbsp;
                            <input type="text" class="Biao_input02" id="cyry" name="cyry" maxlength="8" 
                            placeholder="最多输入8个字" style="width: 114px;">
                        </li>
                        <li>
                        	&nbsp;&nbsp;抽样单位电话&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="cydwlxdh" name="cydwlxdh" maxlength="17" 
                            placeholder="最多输入17个字" style="width: 132px;">
                        </li>
                        <li>&nbsp;&nbsp;邮政编码&nbsp;&nbsp;
                        	<input type="text" class="Biao_input01" id="cydwyzbm" name="cydwyzbm" maxlength="8"
                        	 placeholder="最多输入8个字">
                        </li>
                    </ul>
                    <ul>
                        <li>
                        	&nbsp;&nbsp;传真/Email&nbsp;&nbsp;
                            <input type="text" class="Biao_input03" id="czemail" name="czemail" maxlength="15" 
                            placeholder="最多输入15个字">
                        </li>
                        <li>
                        	&nbsp;&nbsp;抽样数量&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="cysl" name="cysl" maxlength="45" 
                            placeholder="最多输入45个字">
                        </li>
                        <li>
                        	&nbsp;&nbsp;抽样日期&nbsp;&nbsp;
                            <input type="text" class="Biao_input01 Wdate" id="cyrq"
                            name="cyrq" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
                        </li>
                        <li>&nbsp;&nbsp;抽样基数/批量&nbsp;
                        	<input type="text" class="Biao_input02" id="cyjs" name="cyjs" 
                            placeholder="最多输入8个字" onKeyUp="checkLen(this,16)" style="width: 128px;">
                        </li>
                    </ul>
           	   </div>
            </div>
            <div class="ZJ_Biao">
            	<div class="ZJ_Biao_title" style="margin-top: 8px;">厂家信息</div>
                <div class="ZJ_Biao_msg">
                    <ul>
                        <li>
                        	&nbsp;&nbsp;受检单位&nbsp;&nbsp;
                           <input type="text" class="Biao_input01" id="sjdw" name="sjdw" maxlength="36"
                           placeholder="最多输入36个字">
                        </li>
                        <li>
                            &nbsp;&nbsp;法人代表&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="sjdwfrdb" name="sjdwfrdb" maxlength="8" 
                            placeholder="最多输入8个字">
                        </li>
                        <li>
                        	&nbsp;&nbsp;联&nbsp;&nbsp;系&nbsp;&nbsp;人&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="lxr" name="lxr" maxlength="8" 
                            placeholder="最多输入8个字" style="width: 156px;">
                        </li>
                        <li>&nbsp;&nbsp;联系电话&nbsp;&nbsp;
                          <input type="text" class="Biao_input01" id="sjdwgddh" name="sjdwgddh" maxlength="17" 
                          placeholder="最多输入17个字">
                    </ul>
                    <ul>
                        <li style=" width:50%">
                        	&nbsp;&nbsp;单位地址&nbsp;&nbsp;
                            <input type="text" class="Biao_input04" id="sjdwdz"
                            name="sjdwdz" maxlength="45" placeholder="最多输入45个字" style="width: 82%;">
                        </li>
                        <li>&nbsp;</li>
                        <li>&nbsp;</li>
                    </ul>
                    <ul>
                        <li>
                        	&nbsp;&nbsp;生产单位&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="scdw" name="scdw" maxlength="36"
                            placeholder="最多输入36个字">
                        </li>
                        <li>
                        	&nbsp;&nbsp;法人代表&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="scdwfrdb"
                            name="scdwfrdb" maxlength="8" placeholder="最多输入8个字">
                        </li>
                        <li>
                        	&nbsp;&nbsp;联&nbsp;&nbsp;系&nbsp;&nbsp;人&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="scdwlxr"
                            name="scdwlxr" maxlength="8" placeholder="最多输入8个字" style="width: 156px;">
                        </li>
                        <li>&nbsp;&nbsp;联系电话&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="scdwdh"
                            name="scdwdh" maxlength="17" placeholder="最多输入17个字">
                    </ul>
                     <ul>
                        <li style=" width:50%">
                            &nbsp;&nbsp;单位地址&nbsp;&nbsp;
                            <input type="text" class="Biao_input04" id="scdwdz"
                            name="scdwdz" maxlength="45" placeholder="最多输入45个字" style="width: 82%;">
                        </li>
                        <li >
                        	&nbsp;&nbsp;单位邮编&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="scdwyb" name="scdwyb" data-rule-number="true" 
                            data-msg-number="请输入正确的格式" data-msg-minlength="请输入正确的格式" 
                            minlength="6" maxlength="6" placeholder="请输入正确的格式">
                        </li>
                        <li>
                        	&nbsp;
                        </li>
                    </ul>
                    <ul>
                        <li>
                        	&nbsp;&nbsp;营业执照&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="yyzz" name="yyzz" maxlength="35" placeholder="最多输入35个字">
                        </li>
                        <li>
                        	&nbsp;&nbsp;机构代码&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="jgdm" name="jgdm" maxlength="35" placeholder="最多输入35个字">
                        </li>
                        <li>
                        	&nbsp;&nbsp;经济类型&nbsp;&nbsp;
                            <select name="jjlx" id="jjlx" >
                          	<option selected="selected" value="">请选择...</option>
                              <c:forEach var="jjlx" items="${jjlx}" varStatus="obj">
                                  <option value="${jjlx.zdz }">${jjlx.zdmc }</option>
                              </c:forEach>
                           </select>
                        </li>
                        <li>&nbsp;&nbsp;企业人数&nbsp;&nbsp;
                        	<input type="text" class="Biao_input01" id="rs" name="rs" 
                        	maxlength="36" placeholder="最多输入36个字">
                        </li>
                    </ul>
                    <ul>
                        <li>
                        	&nbsp;&nbsp;企业产值&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="cz" name="cz" 
                            maxlength="36" placeholder="最多输入36个字">
                        </li>
                        <li>
                        	&nbsp;&nbsp;企业产量&nbsp;&nbsp;
                            <input type="text" class="Biao_input01" id="cl" name="cl" 
                            maxlength="36" placeholder="最多输入36个字">
                        </li>
                        <li>
                        	&nbsp;&nbsp;证书类型&nbsp;&nbsp;
                            <select name="zslx" id="zslx" >
                          	<option selected="selected" value="">请选择...</option>
                              <c:forEach var="zslx" items="${zslx}" varStatus="obj">
                                  <option value="${zslx.zdz }">${zslx.zdmc }</option>
                              </c:forEach>
                            </select>
                        </li>
                        <li>&nbsp;&nbsp;证书编号&nbsp;&nbsp;
                        	<input type="text" class="Biao_input01" id="zsbh" name="zsbh" 
                        	maxlength="35" placeholder="最多输入35个字">
                        </li>
                    </ul>
           	   </div>
            </div>
	         <div class="ZJ_Biao">
	         	<div class="ZJ_Biao_title" style="margin-top: 8px;">检验信息</div>
	             <div class="ZJ_Biao_msg">
	                 <ul>
	                     <li>
	                     	&nbsp;&nbsp;<span style="color:red">*</span>检验类型&nbsp;&nbsp;
	                         <select name="jylx" id="jylx" required data-msg-required="必填" style="width: 60%;" >
	                       	<option selected="selected" value="">请选择...</option>
	                           <c:forEach var="jylx" items="${jylx}" varStatus="obj">
	                               <option value="${jylx.zdz }">${jylx.zdmc }</option>
	                           </c:forEach>
	                         </select>
	                     </li>
	                     <li style=" width:35%">
	                     	&nbsp;&nbsp;检验项目&nbsp;&nbsp;
	                         <input type="text" class="Biao_input04" style="width: 74%;" name="jyxm" id="jyxm">
	                     </li>
	                     <li>
	                     	&nbsp;&nbsp;<a href="#myModal" data-toggle="modal" type="button" class="Biao_input_Btn" style="border:none;">请选择检验项目</a>
	                     </li>
	                 </ul>
	                 <ul>
	                     <li style="width:74%">
	                     	&nbsp;&nbsp;检验依据&nbsp;&nbsp;
	                         <input type="text" class="Biao_input05" name="jyyj" placeholder="最多输入75个字" 
	                         onKeyUp="checkLen(this,150)" style="width: 88%;">
	                     </li>
	                     <li>
	                     	&nbsp;&nbsp;验后需退库&nbsp;&nbsp;
	                         <select name="yhxtk" id="yhxtk" style="width: 61%;" >
	                         	<option selected="selected" value="">请选择...</option>
	                             <c:forEach var="yhxtk" items="${yhxtk}" varStatus="obj">
	                                 <option value="${yhxtk.zdz }">${yhxtk.zdmc }</option>
	                             </c:forEach>
	                         </select>
	                     </li>
	                 </ul>
	                 <ul>
	                     <li>
	                     	&nbsp;&nbsp;检验费用&nbsp;&nbsp;
	                         <input type="text" class="Biao_input01" id="jyfy" name="jyfy" data-rule-number="true" 
	                         data-msg-number="请输入正确的数字" data-gt="0"  maxlength="10" 
	                         placeholder="最多输入10位数字" value="0" style="width: 58%;">
	                         <span>元</span>
	                     </li>
	                     <li>&nbsp;&nbsp;检验费用待定&nbsp;&nbsp;
                        	 <input type="radio" checked="checked" name="jyfydd" value="1" />不待定&nbsp;&nbsp;
                             <input type="radio" name="jyfydd" value="0" />待定
	                         <input type="hidden" class="hidden" id="djlx" name="djlx" value="3">
	                         <input type="hidden" class="hidden" id="lysl" name="lysl" value="0">
	                         <input type="hidden" class="hidden" id="jyksbh" name="jyksbh" value="">
	                         <input type="hidden" class="hidden" id="ywksbh" name="ywksbh">
                        </li>
	                     <li style="width: 50%;">
	                     	&nbsp;&nbsp;备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注&nbsp;&nbsp;
	                         <input type="text" class="Biao_input01" name="bz" placeholder="最多输入120个字"
	                          maxlength="120" style="width: 82%;">
	                     </li>
	<!--                         <li>&nbsp;&nbsp;完成期限&nbsp;&nbsp; -->
	<!--                         	<input type="text" class="Biao_input01"> -->
	<!--                         </li> -->
	                 </ul>
	        	   </div>
	         </div>
	        </form>
        </div>
    </div>
   	<div class="foot" style="font-size:14px; background-color:#23b201"><span style=" float:left; margin-left:47%">
   	<a type="submit" style="font-size: 17px;color: #fff;cursor:pointer;" onclick="save();">
   	<img src="<%=path%>/system/layout/img/Add.png" style=" float:left; margin-top:5px">&nbsp;提交</a></span></div>
</div>

</body>

<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <!-- <form class="form-horizontal" role="form"> -->
                <section class="panel" id="sect" style="margin-bottom: 0px;height: 660px;">
                    <header class="panel-heading">检验收费项目</header>
                    <label style="margin-left: 6px;">产品名称:</label>&nbsp;<input id="cpmccx" name="cpmccx" value="${ypxxcpmc.ypxxcpmc }" style="width: 120px;">&nbsp;&nbsp;&nbsp;
                    <label>项目名称:</label>&nbsp;&nbsp;&nbsp;<input id="xmmccx" name="xmmccx" style="width: 120px;">&nbsp;&nbsp;&nbsp;
                    <button onClick="getSfxmmx(0);">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <button onClick="dyqd();">打印</button><br/>
                    <label style="margin-left: 6px;" id="yxxm">已选项目:</label>
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
                    <div id="Div1" style="overflow:auto;height:68%;"></div>
                    <span id="sbz"></span>
                    <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
                        <div class="col-lg-offset-2 col-lg-10" style="margin-top: 10px;">
                            <button type="button" class="btn btn-default" onclick="getSfxmmx(1);"
                                    style="margin-left: 40%;">加载更多...
                            </button>
                        </div>
                    </div>
                    <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
                        <div class="col-lg-offset-2 col-lg-10" style="margin-top: 10px;">
                            <button type="button" class="btn btn-default" onClick="selectSfxmmx();" 
                            		style="margin-left: 36%;">确定
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
	$("#L_btn").click(function(){
		$("#left_nav").animate({marginLeft:130},1000)
	})
	$("#main_R").click(function(){
		$("#left_nav").animate({marginLeft:0},1000)
	})
</script>
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

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
	
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css">
    <script type="text/javascript" src="<%=path%>/resources/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/upload.css">
    <script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.qrcode.min.js"></script>
    <script language="javascript" src="<%=path%>/resources/lodop/LodopFuncs.js"></script>
    <script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
    <!--common script for all pages-->
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="<%=path%>/resources/js/html5shiv.js"></script>
    <script src="<%=path%>/resources/js/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        function load() {
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
                                $("#zh").val("请选择...");
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
            //生成二维码
            var str = "${url}";
            $("#code").qrcode({
                width: 100,
                height: 100,
                text: str
            });
            
            $("#jyxm").val("");
            $("#jyfy").val("");
            
            var sfxmBgbh = document.getElementById("bgbh").value;
            var url = "<%=path%>/ypgl/YYpSfxmmx/deleteSfxmmx";
            $.ajax({
                cache: true,
                type: "POST",
                url: url,
                data: {sfxmBgbh:sfxmBgbh},
                async: false,
                error: function (request) {
                    //alert("保存失败,请联系管理员。");
                },
                success: function (data) {
                	
                }
            });
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
        }
        //返回
        function exit() {
            var close =window.parent.ACT_DEAL_WINDOW;
            if(close==undefined){
                this.close();
            }else{
                window.parent.ACT_DEAL_WINDOW.close();
            }
            //location.href = "<%=path%>/ypgl/YYpYpxx/YpxxPage";
        }

        //获取上传文件名
        function getFile(obj, inputName) {
            var file_name = $(obj).val();
            $("input[name='" + inputName + "']").val(file_name);
        }

        var sfTj = 0;
        //提交
        function save() {
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
                var url = "<%=path%>/ypgl/YypWsdjfh/save";
                $.ajax({
                    cache: true,
                    type: "POST",
                    url: url,
                    data: $('#myForm').serialize(),// 你的formid
                    async: false,
                    error: function (request) {
                        alert("处理失败,请联系管理员。");
                    },
                    success: function (data) {
                        sfTj = 1;
                        alert('处理成功！');
                        var PAGESIZE = 20;
                        window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
                        window.parent.ACT_DEAL_WINDOW.close();
                    }
                });
            }
        }

        var LODOP; //声明为全局变量      
        function PrintOneURL() {
            var ypbh = $("#ypbh").val();
            if (sfTj == 1) {
                LODOP = getLodop();
                LODOP.PRINT_INIT("流转单");
                LODOP.ADD_PRINT_URL(30, 20, 746, "95%", 'YpLzdPage?ypbh=' + ypbh);
                LODOP.SET_PRINT_STYLEA(0, "HOrient", 3);
                LODOP.SET_PRINT_STYLEA(0, "VOrient", 3);
                LODOP.PREVIEW();
            } else {
                alert('请提交保存后再打印流转单。');
            }
        };

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
                        $("#ypbh").val(data);
                        $("#bgbh").val(data);
                    }
                });

            }
        }

        //打开收费信息窗口
        function openWin() {
            var ypmc = $("#ypmc").val();
            location.href = "Sfxmmx?ypmc=" + ypmc;
        }

        //打开收费信息窗口
        function getSfxmmx() {
            var url = "<%=path%>/ypgl/YYpYpxx/Sfxmmx";
            var cpmccx = document.getElementById("cpmccx").value;
            var xmmccx = document.getElementById("xmmccx").value;
            if((cpmccx!=""&&cpmccx!=null) || (xmmccx!=""&&xmmccx!=null)){
	            $.ajax({
	                cache: true,
	                type: "POST",
	                url: url,
	                data: {cpmccx: cpmccx, xmmccx: xmmccx},
	                async: false,
	                error: function (request) {
	                    alert("选择失败,请联系管理员。");
	                },
	                success: function (data) {
	                    var del = $("#table");
	                    del.remove();
	                    var str = "<table><thead><tr><th>产品名称</th><th>项目名称</th><th>单价金额</th><th>计量单位</th><th>修改金额</th>"
	                            + "<th>操作</th></tr></thead><tbody>";
	                    for (var i = 0; i < data.length; i++) {
	                        str = str + "<tr id='" + data[i].ID + "' name='" + data[i].ID + "'><td>" + data[i].CPMC + "</td><td>" + data[i].XMMC + "</td>"
	                                + "<td>" + data[i].DJ + "</td><td>" + data[i].JLDW + "</td><td><input type='text' value=''/></td><td><input "
	                                + "name='checkSfxmmx' type='checkbox' value = '" + data[i].ID + "'/></td></tr>";
	                    }
	                    str = str + "</tbody><table>";
	                    var oTest = document.getElementById("sect");
	                    var newNode = document.createElement("table");
	                    var befNode = document.getElementById("sbz");
	                    newNode.setAttribute('class', 'table');
	                    newNode.setAttribute('id', 'table');
	                    newNode.innerHTML = str;
	                    oTest.insertBefore(newNode, befNode);
	                }
	            });
            }else {
            	alert("请输入查询条件！");
            	return false;
            }
        }

        //保存收费明细
        function saveSfxmmx() {
            var r = document.getElementsByName("checkSfxmmx");
            var del = $("#myDiv");
            del.remove();
            var num = 1;
            var str = "";
            var bgbh = document.getElementById("bgbh").value;
            var oTest = document.getElementById("num");
            var newNode = document.createElement("div");
            newNode.setAttribute('id', 'myDiv');
            var flag = false;
            var jyxm = "";
            for (var i = 0; i < r.length; i++) {
                if (r[i].checked) {
                    flag = true;
                    var a = r[i].value;
                    var td = $("#" + a).find("td");
                    var xgje = $(td[4]).find('input').val();
                    str = str + "<input type='text' id='cpmc" + num + "' name='cpmc" + num + "' value='" + $(td[0]).text() + "'/>"
                            + "<input type='text' id='xmmc" + num + "' name='xmmc" + num + "' value='" + $(td[1]).text() + "'/>"
                            + "<input type='text' id='je" + num + "' name='je" + num + "' value='" + $(td[2]).text() + "'/>"
                            + "<input type='text' id='jldw" + num + "' name='jldw" + num + "' value='" + $(td[3]).text() + "'/>"
                            + "<input type='text' id='xgje" + num + "' name='xgje" + num + "' value='" + xgje + "'/>"
                            + "<input type='text' id='bgbh" + num + "' name='bgbh" + num + "' value='" + bgbh + "'/>";
                    num = num + 1;
                    document.getElementById("num").value = num;
                    if(xgje!="" && xgje!=null ) {
                    	if (jyxm == "") {
                            jyxm = jyxm + $(td[1]).text() + "(" + xgje + "元)";
                        } else {
                            jyxm = jyxm + "," + $(td[1]).text() + "(" + xgje + "元)";
                        }
                    }else {
                    	if (jyxm == "") {
                            jyxm = jyxm + $(td[1]).text() + "(" + $(td[2]).text() + "元)";
                        } else {
                            jyxm = jyxm + "," + $(td[1]).text() + "(" + $(td[2]).text() + "元)";
                        }
                    }
                    
                }
            }
            newNode.innerHTML = str;
            oTest.insertBefore(newNode, null);
            
            if(document.getElementById("num").value=="1"){
        		alert("请选择检验项目！");
        		return false;
        	}
            
            if (flag == true) {
                var url = "<%=path%>/ypgl/YYpSfxmmx/save";
                $.ajax({
                    cache: true,
                    type: "POST",
                    url: url,
                    data: $('#form').serialize(),// 你的formid
                    async: false,
                    error: function (request) {
                        alert("保存失败,请联系管理员。");
                    },
                    success: function (data) {
                        alert('检验收费项目保存成功！');
                        var jyfyOld = document.getElementById("jyfy").value;
                        if (jyfyOld != "") {
                            var jyfyNew = parseInt(jyfyOld) + parseInt(data);
                            $("#jyfy").val(jyfyNew);
                        } else {
                            $("#jyfy").val(data);
                        }
                        var jyxmOld = document.getElementById("jyxm").value;
                        if (jyxmOld == "") {
                            var jyxmNew = jyxmOld + jyxm;
                            $("#jyxm").val(jyxmNew);
                        } else {
                            var jyxmNew = jyxmOld + "," + jyxm;
                            $("#jyxm").val(jyxmNew);
                        }
                    }
                });
                var del = $("#table");
                del.remove();
                $("#cpmccx").val("");
                $("#xmmccx").val("");
                $('#myModal').modal('hide');
            } else {
                alert("请选择收费项目！");
                return false;
            }
        }

        //关闭收费窗口
        function closeWin() {
            var del = $("#table");
            del.remove();
            $('#myModal').modal('hide');
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
        	 msg = "确定选择？";
             if (confirm(msg)) {
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
	         			khxx = data;
	         			$("#wtdw").val(data[0].KHMC);
	         			$("#wtdwdz").val(data[0].KHDZ);
	         			$("#wtdwlxr").val(data[0].LXR);
	         			$("#wtdwdh").val(data[0].GDDH);
	         			$('#myModalKhxx').modal('hide');
	         		}
	         	  });
             }
        }
        
        //选择受检单位
        function getSjdw() {
           	var wtdw1 = document.getElementById("wtdw").value;
           	$("#sjdw").val(wtdw1);
           	var wtdwdz1 = document.getElementById("wtdwdz").value;
           	$("#sjdwdz").val(wtdwdz1);
           	var wtdwlxr1 = document.getElementById("wtdwlxr").value;
           	$("#lxr").val(wtdwlxr1);
           	var wtdwdh1 = document.getElementById("wtdwdh").value;
           	$("#dh").val(wtdwdh1);
           	var yb = document.getElementById("yb").value;
           	$("#scdwyb").val(yb);
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
        }
        
        //关闭客户窗口
        function closeKhxx() {
	        $('#myModalKhxx').modal('hide');
	        var del = $("#table");
	        del.remove();
        }
        
    </script>
    
    <script type="text/javascript">
//         $(function () {
//             //回车代替tab
//             $('input:text:first').focus();
//             //如果有其他输入类型可以在此处加入
//             var $target = $('input,button,select');
//             $target.bind('keydown', function (e) {
//                 var key = e.which;
//                 if (key == 13) {
//                     e.preventDefault();
//                     var nxtIdx = $target.index(this) + 1;
//                     if ($target.eq(nxtIdx).attr("type") == "submit") {
//                         $target.eq(nxtIdx).click();
//                     } else {
//                         $target.eq(nxtIdx).focus();
//                     }
//                 }
//             });
//         });
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
		<div class="panel-body">
			<div style="text-align:center;margin-bottom:10px"></div>
                <form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
                    <input type="hidden" name="id" id="id" value="${ypxx.id }">
                    <input type="hidden" name="lysl" id="lysl" value="${ypxx.lysl }"> 
					<input class="form-control" type="hidden" id="jyksbh" name="jyksbh" value="${ypxx.jyksbh }">
					<input class="form-control" type="hidden" id="ywksbh" name="ywksbh" value="${ypxx.ywksbh }">
					<input class="form-control" type="hidden" id="ypjyzt" name="ypjyzt" value="${ypxx.ypjyzt }">
					<input class="form-control" type="hidden" id="djlx" name="djlx" value="${ypxx.djlx }">
					<input class="form-control" type="hidden" id="djry" name="djry" value="${ypxx.djry }">
					<input class="form-control Wdate" type="hidden" id="djsj" name="djsj" 
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${djsj }">
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
                                                           style="margin-top: 15px;">检验科室：</label>

                                                    <div class="col-sm-10" style="margin-top: 21px;">
                                                        <input id="jyks" name="jyks" class="easyui-combotree" value="${ypxx.jyksbh }"
                                                               style="height: 34px;width: 238px;" readonly="true" />
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label"
                                                           style="margin-top: 18px;">字号名称：</label>

                                                    <div class="col-sm-10" style="margin-top: 21px;">
                                                    	<c:forEach var="data" items="${zhList }" varStatus="st">
                                                    		<c:if test="${ypxx.zh == data.zh }">
		                                                        <input class="form-control" type="text" id="zh" name="zh" value="${data.zhmc }" readonly="readonly">
                                                    		</c:if>
                                                    	</c:forEach>
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label"
                                                           style="margin-top: 19px;">二维码图片:</label>

                                                    <div class="col-sm-10">
                                                        <div id="code" style="width: 100px;height: 100px;"></div>
                                                    </div>
                                                </div>
 
                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">样品编号：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="ypbh" name="ypbh" value="${ypxx.ypbh }" readonly="readonly">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">报告编号：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="bgbh" name="bgbh" value="${ypxx.bgbh }" readonly="readonly">
                                                    </div>
                                                    <label for="ypsl" class="col-sm-2 col-sm-2 control-label">样品数量：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="ypsl" name="ypsl" value="${ypxx.ypsl }"/>
                                                    </div>
                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">样品名称：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="ypmc" name="ypmc" value="${ypxx.ypmc }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">样品类型：</label>

                                                    <div class="col-sm-10">
                                                        <select class="form-control input-lg m-bot15" name="yplx">
                                                            <option selected="selected" value="${ypxx.yplx }">${ypxx.yplx }</option>
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
                                                        <select class="form-control input-lg m-bot15" name="ypdj">
                                                            <option selected="selected" value="${ypxx.ypdj }">${ypxx.ypdj }</option>
                                                            <option>一级</option>
                                                            <option>二级</option>
                                                            <option>三级</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">样品状态：</label>
                                                    <div class="col-sm-10" style="margin-top: 5px; width: 19%;">
                                                        <label><input type="radio" name="ypzt" value="良好" checked="checked">良好</label>
                                                        <label style="padding-left: 10px;"><input type="radio" name="ypzt" value="损坏">损坏</label>
                                                        <label style="padding-left: 10px;"><input type="radio" name="ypzt" value="一般">一般</label>
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">来样方式：</label>
                                                    <div class="col-sm-10" style="margin-top: 5px;">
                                                        <label><input type="radio" name="lyfs" value="0" checked="checked">直送</label>
                                                        <label style="padding-left: 20px;"><input type="radio" name="lyfs" value="1">快递</label>
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">规格型号：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="ggxh" name="ggxh" value="${ypxx.ggxh }">
                                                    </div>
                                                </div>


                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">所在城市：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="szcs" name="szcs" value="${ypxx.szcs }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">生产日期批次：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="scrqpc"
                                                               name="scrqpc" value="${ypxx.scrqpc }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">抽样人员：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="cyry" name="cyry" value="${ypxx.cyry }">
                                                    </div>
                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">抽样地点：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="cydd" name="cydd" value="${ypxx.cydd }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">抽样日期：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control Wdate" type="text" id="cyrq"
                                                               name="cyrq"
                                                               onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${cyrq }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">抽样基数：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="cyjs" name="cyjs" value="${ypxx.cyjs }">
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">商标：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="sb" name="sb" value="${ypxx.sb }">
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
                                                    <div>厂家信息</div>
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapseTwo" class="panel-collapse collapse">
                                            <div class="panel-body" style="overflow:scroll;overflow-x:hidden">
                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">委托单位：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="wtdw" name="wtdw" value="${ypxx.wtdw }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">委托单位地址：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="wtdwdz"
                                                               name="wtdwdz" value="${ypxx.wtdwdz }">
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
                                                        <!-- <input id="sjdw" name="sjdw" class="easyui-combotree" value="" style="width:248px;height: 34px;"/> -->
                                                        <input class="form-control" type="text" id="sjdw" name="sjdw" value="${ypxx.sjdw }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">受检单位地址：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="sjdwdz"
                                                               name="sjdwdz" value="${ypxx.sjdwdz }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">联系人：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="lxr" name="lxr" value="${ypxx.lxr }">
                                                    </div>
                                                    
                                                </div>

                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                    <label class="col-sm-2 col-sm-2 control-label">电话：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="dh" name="dh" value="${ypxx.dh }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">邮编：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="yb" name="yb" value="${ypxx.yb }">
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
                                                        <input class="form-control" type="text" id="scdw" name="scdw" value="${ypxx.scdw }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">生产单位地址：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="scdwdz"
                                                               name="scdwdz" value="${ypxx.scdwdz }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">生产单位联系人：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="scdwlxr"
                                                               name="scdwlxr" value="${ypxx.scdwlxr }">
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group"
                                                     style="padding-bottom: 2px;padding-top: 0px; margin-bottom: 0px; width: 101%;">
                                                     <label class="col-sm-2 col-sm-2 control-label">生产单位电话：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="scdwdh"
                                                               name="scdwdh" value="${ypxx.scdwdh }">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">生产单位邮编：</label>

                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="scdwyb"
                                                               name="scdwyb" value="${ypxx.scdwyb }">
                                                    </div>
                                                    
                                                    <label class="col-sm-2 col-sm-2 control-label" style="width: 30%; margin-left: 2%; 
                                                    	   padding-top: 0px; margin-top: 3px;">
                                                    <button type="button" class="btn btn-xs btn-success" onClick="getScdw();"
                                    						style="margin-left: 20px;width:62%">生产单位同受检单位</button>
                                					</label>
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
										            <textarea class="form-control ckeditor textarea" rows="6" name="jyxm" id="jyxm" 
										            truetype="textarea" style="width: 409%;height: 35px;">${ypxx.jyxm }</textarea>
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
                                                    <label class="col-sm-2 col-sm-2 control-label">检验费用：</label>
                                                    <div class="input-group m-bot15 col-sm-10" style="width: 19%;">
                                                        <input class="form-control" type="text" id="jyfy" name="jyfy" value="${ypxx.jyfy }" >
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">检验费用待定：</label>
                                                    <div class="col-sm-10" style="margin-top: 5px;">
                                                        <label><input type="radio" name="jyfydd" value="0">待定</label>
                                                        <label style="padding-left: 20px;"><input type="radio" name="jyfydd" 
                                                         checked="checked" value="1">不待定</label>
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">验后需退库：</label>
                                                    <div class="col-sm-10" style="margin-top: 5px;">
	                                                     <label style="width: 20%;">
	                                                     <input type="radio" name="yhxtk" value="0" checked="checked">退</label>
                                                         <label><input type="radio" name="yhxtk" value="1">不退</label>
                                                    </div>   
                                                </div>

                                                <div class="form-group" style="padding-bottom: 2px; padding-top: 0px; margin-bottom: 0px;  
                                                width: 100%; margin-left: 0px; margin-right: 0px;">
                                                    <label class="col-sm-2 col-sm-2 control-label">检验类型：</label>
                                                    <div class="col-sm-10">
													<select class="form-control input-lg m-bot15" name="jylx">
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
													
                                                    <label class="col-sm-2 col-sm-2 control-label">检验合同号：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="jyhth" name="jyhth" value="${ypxx.jyhth}">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">检查封样人员：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="text" id="jcfyry" name="jcfyry" value="${ypxx.jcfyry}">
                                                    </div>
                                                </div>

                                                <div class="form-group" style="padding-bottom: 2px; padding-top: 0px; margin-bottom: 0px; 
                                                 width: 100%; margin-left: 0px; margin-right: 0px;">
                                                    <label class="col-sm-2 col-sm-2 control-label"
                                                           style="margin-top: 0px;">业务科室：</label>
                                                    <div class="col-sm-10" style="margin-top: 4px;">
                                                        <input id="ywks" name="ywks" class="easyui-combotree" value="${ypxx.ywksbh }"
                                                               style="height: 34px;"/>
                                                    </div>
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
                                                               name="dyrq" value="${dyrq}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">完成期限：</label>
                                                    <div class="col-sm-10">
                                                        <input class="form-control Wdate" type="text" id="wcqx" name="wcqx" 
                                                        value="${wcqx}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
                                                    </div>
                                                    <label class="col-sm-2 col-sm-2 control-label">样品附件：</label>

                                                    <div class="box">
                                                        <input type="text" name="copyFile" class="textbox"/>
                                                        <a href="javascript:void(0);" class="link">...</a>
                                                        <input type="file" class="uploadFile" name="attachMentFile"
                                                               id="attachMentFile"
                                                               onchange="getFile(this,'copyFile')"/>
                                                        <input class="fileComponent" type="file" style="width: 97%; height: 30px; 
                                                        position: absolute; z-index: 20; font-size: 118px;
                                   opacity: 0; left: 0px; top: 0px;" size="16" id="attachMentFile" name="attachMentFile"
                                                               truetype="file">
                                                    </div>
                                                </div>

                                                <div class="form-group" style="padding-bottom: 2px; padding-top: 0px; margin-bottom: 0px; 
                                                width: 100%; margin-left: 0px; margin-right: 0px;">
                                                    <label class="col-sm-2 col-sm-2 control-label">检验依据：</label>
                                                    <div class="col-sm-13">
										<textarea class="form-control ckeditor textarea" rows="6" name="jyyj" 
										truetype="textarea" style="width: 99.5%;height: 35px;">${ypxx.jyyj}</textarea>
                                                    </div>
                                                </div>

                                                <div class="form-group" style="padding-bottom: 2px; padding-top: 0px; margin-bottom: 0px; 
                                                width: 100%; margin-left: 0px; margin-right: 0px;">
                                                    <label class="col-sm-2 col-sm-2 control-label">备注：</label>

                                                    <div class="col-sm-13">
													<textarea class="form-control ckeditor textarea" rows="6" name="bz" 
													truetype="textarea" style="width: 99.5%;height: 35px;">${ypxx.bz}</textarea>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    
                                    <div class="hidden">
                                        <input type="hidden" class="hidden" id="ewmbh" name="ewmbh" value="${ypxx.ewmbh}">
                                    </div>
                                    <input type="hidden" class="hidden" id="wtdwlxr" name="wtdwlxr">
                                    <input type="hidden" class="hidden" id="wtdwdh" name="wtdwdh">

                                    <div style="text-align: center;margin-top: 10px;">
                                        <div class="form-group" style="width: 90%;padding-top: 6px; margin-left: 50px;">
                                            <button type="button" class="btn btn-primary"
                                                    onClick="save()">提交
                                            </button>
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
        </section>
    </div>
</div>
</div>

<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <section class="panel" id="sect">
                    <header class="panel-heading">检验收费项目</header>
                    <label style="margin-left: 6px;">产品名称:</label>&nbsp;&nbsp;&nbsp;<input id="cpmccx" name="cpmccx">&nbsp;&nbsp;&nbsp;
                    <label>项目名称:</label>&nbsp;&nbsp;&nbsp;<input id="xmmccx" name="xmmccx">
                    <button onClick="getSfxmmx();">查询</button>
                    <span id="sbz"></span>
                    <div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
                        <div class="col-lg-offset-2 col-lg-10" style="margin-top: 40px;">
                            <button type="button" class="btn btn-default" onclick="saveSfxmmx();"
                                    style="margin-left: 100px;">确定
                            </button>
                            <button type="button" class="btn btn-default" onClick="closeWin();"
                                    style="margin-left: 20px;">取消
                            </button>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>
<div id="hidden" align="center" style="display:'none'">
    <form class="form-horizontal tasi-form" name="form" id="form" method="post">
        <input type="hidden" name="num" id="num" value="1">
    </form>
</div>
</body>

<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalKhxx" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
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
            </div>
        </div>
    </div>
</div>
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

</html>

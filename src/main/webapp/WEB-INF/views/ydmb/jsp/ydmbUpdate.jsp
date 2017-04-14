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
    <script type="text/javascript">var PATH='<%=path%>';</script>
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


<script type="text/javascript">
//返回
function exit(){
	/* var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
    window.parent.ACT_DEAL_WINDOW.close();
}

function openswpd(num,value1,value2,value3) {
	var str = value1+"/"+value2+"/"+value3;
	var id = $("#id").val(); 
	 location.href = "mb?id="+id+"&type="+num+"&value="+str;
} 

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

//提交
function update() {
	 if ($("#bmbh").val() == "") {
         alert("请选部门名称！");
         return false;
     }

     if ($("#zh").val() == "") {
         alert("请选择字号");
         return false;
     }
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/ydmb/YJyYdmb/update";
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
} 

function getMb1() {
		var url = "<%=path%>/ydmb/YJyYdmb/mb";
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : {},
			async : false,
			error : function(request) {
				alert("保存失败,请联系管理员。");
			},
			success : function(data) {
				var del = $("#table");
				del.remove();
            	var str="<table><thead><tr><th>编号</th><th>模板名称</th>"
					   +"<th>操作</th></tr></thead><tbody>";
            	for(var i=0;i<data.length;i++){
            		str=str+"<tr id='"+data[i].ID+"'><td>"+data[i].ID+"</td><td>"+data[i].MBMC+"</td><td><input type ='button' onClick='saveMb1 ("+data[i].ID+");' value='提交'></td>";
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
function getMb2() {
	var url = "<%=path%>/ydmb/YJyYdmb/mb";
	$.ajax({
		cache : true,
		type : "POST",
		url : url,
		data : {},
		async : false,
		error : function(request) {
			alert("保存失败,请联系管理员。");
		},
		success : function(data) {
			var del = $("#table");
			del.remove();
        	var str="<table><thead><tr><th>编号</th><th>模板名称</th>"
				   +"<th>操作</th></tr></thead><tbody>";
        	for(var i=0;i<data.length;i++){
        		str=str+"<tr id='"+data[i].ID+"'><td>"+data[i].ID+"</td><td>"+data[i].MBMC+"</td><td><input type ='button' onClick='saveMb2 ("+data[i].ID+");' value='提交'></td>";
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

function getMb3() {
	var url = "<%=path%>/ydmb/YJyYdmb/mb";
	$.ajax({
		cache : true,
		type : "POST",
		url : url,
		data : {},
		async : false,
		error : function(request) {
			alert("保存失败,请联系管理员。");
		},
		success : function(data) {
			var del = $("#table");
			del.remove();
        	var str="<table><thead><tr><th>编号</th><th>模板名称</th>"
				   +"<th>操作</th></tr></thead><tbody>";
        	for(var i=0;i<data.length;i++){
        		str=str+"<tr id='"+data[i].ID+"'><td>"+data[i].ID+"</td><td>"+data[i].MBMC+"</td><td><input type ='button' onClick='saveMb3 ("+data[i].ID+");' value='提交'></td>";
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

function saveMb1(id) {
	$("#fy").val(id);
	var td = $("#"+id).find("td");
	$("#fy_id").val($(td[1]).text());
	$('#myModal').modal('hide');
}

function load() {
    //ComboTree控件初始化
    $('#bmmc').combotree({
        url: '<%=path%>/test/xlsList?optype=getchildtree&id=100500',
        'onLoadSuccess': function (node, data) {
            //在panel控件load完成的时候处理当前显示值，如果不处理，则combotree1的显示值有可能会不正确
            if (data.length > 0) {
                var val = ""; //jsp页面初始化时combotree1的初始id值
                var txt = $('#bmmc').combotree('getText'); //combotree1当前的显示text值
                if (val != "" && val == txt) {
                    var urlstr = "<%=path%>/test/xlsList" + "?optype=gettext&id=" + val;
                    $.get(urlstr,
                            function (gettxt) {
                                if (gettxt != "")
                                    $('#bmmc').combotree('setText', gettxt);
                            }
                    );
                }
            }
        },
        'onChange': function (n, o) {
            $("#bmbh").val("");
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
                        $("#bmbh").val(n);
                        $("#zh").val("请选择...");
                    }
                }
            });
            //变更当前节点，触发变更事件处理
            //dochange();
        }
    });
}

function getBh() {
    var bmbh = document.getElementById("bmbh").value;
    if (bmbh == "") {
        alert("请先选择部门");
        return false;
    }<%--  else {
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

    } --%>
}

function saveMb2(id) {
	$("#fm").val(id);
	var td = $("#"+id).find("td");
	$("#fm_id").val($(td[1]).text());
	$('#myModal').modal('hide');
}
function saveMb3(id) {
	$("#sy").val(id);
	var td = $("#"+id).find("td");
	$("#sy_id").val($(td[1]).text());
	$('#myModal').modal('hide');
}
	
</script>
</head>
<body onload="load();">
	<div class="wrapper">
	<div class="panel">
	<!-- <header class="panel-heading" style="padding-left: 650px;">样品信息</header> -->
		<div class="panel-body">
		<c:forEach var="ydmb" items="${ydmb}" varStatus="obj">
                <form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
			<div style="text-align:center;margin-bottom:10px"></div>
				
                  <input type="hidden" name="id" id="id" value="${ydmb.id }">
                    <input type="hidden" name="sy" id="sy" value="${ydmb.sy }">
                    <input type="hidden" name="fy" id="fy" value="${ydmb.fy }">
                    <input type="hidden" name="fm" id="fm" value="${ydmb.fm }">
                    <input type="hidden" id="bmbh" name="bmbh">
                    <input type="hidden" id="ssbh" name="ssbh">
                    
                   <!--  <div class="form-group" style="padding-bottom: 10px; padding-left: 0px; width: 1135px;margin-bottom: 0px;">
					    <label class="col-sm-2 col-sm-2 control-label">模板分类：</label>
                         <div class="col-sm-10" style="margin-top: 5px; width: 50%;">
                           <label style="width: 20%;">
                           <input type="radio" name="mbfl" value="0" checked="checked">一般样品模板</label>
                              <label><input type="radio" name="mbfl" value="1">工程类样品模板</label>
                          </div>   
					</div> -->
					<%-- <div class="form-group"
						style="padding-bottom: 10px; padding-left: 0px; width: 100%; margin-bottom: 0px;">
						<label class="col-sm-2 col-sm-2 control-label"
							style="margin-top: 15px; border-left-width: 10px; padding-top: 14px; padding-left: 13px; width: 6.5%;">模板分类：</label>
						<div class="col-sm-10" style="margin-top: 21px;">
							<select class="form-control input-lg m-bot15" name="mbfl" 
								style="width: 100%; height: 28px;">
								<option selected="selected">${ydmb.mbfl}</option>
								<c:forEach var="mbfl" items="${mbfl}" varStatus="obj">
									<option value="${mbfl.zdz }">${mbfl.zdmc}</option>
								</c:forEach>
							</select>
						</div>
					</div> --%>
					<div class="form-group" style="padding-bottom: 10px; padding-left: 0px; width: 100%; margin-bottom: 0px;">
					<label class="col-sm-2 col-sm-2 control-label" style="margin-top: 15px; border-left-width: 10px; padding-top: 14px; padding-left: 13px; width: 80px;">模板分类：</label>
						<div class="col-sm-10" style="margin-top: 21px;">
							<select class="form-control input-lg m-bot15" name="mbfl" style="width: 100%; height: 28px;" >
								<c:forEach items="${mbfl}" var="mbfl">
                                     <c:choose>
                                         <c:when test="${mbfl.zdz == ydmb.mbfl}">
                                               <option selected = "selected" value="${mbfl.zdz}">${mbfl.zdmc}</option>
                                         </c:when>
                                         <c:otherwise>
                                               <option value="${mbfl.zdz}">${mbfl.zdmc}</option>
                                         </c:otherwise>
                                     </c:choose>
                                </c:forEach> 
					        </select>
						</div>
						</div>
					
					<div class="form-group" style="padding-bottom: 10px; padding-left: 0px; width: 100%; margin-bottom: 0px;">
					 <label class="col-sm-2 col-sm-2 control-label" style="margin-top: 15px; border-left-width: 10px; padding-top: 14px; padding-left: 13px; width: 80px;" >部门名称：</label>
                            <div class="col-sm-10" style="margin-top: 21px;">
                              <input id="bmmc" name="bmmc" class="easyui-combotree" value="${ydmb.bmmc }"
                                     style="margin-top: 15px; border-left-width: 10px; padding-top: 14px; padding-left: 13px; width:220%;"/>
                            </div>
                     </div>
                     
					<div class="form-group" style="padding-bottom: 10px; padding-left: 0px; width: 100%; margin-bottom: 0px;left:-75px;">
	                    <label class="col-sm-2 col-sm-2 control-label" style="margin-top: 15px; border-left-width: 10px; padding-top: 14px; padding-left: 13px; width: 80px;">选择字号：</label>      
							<div class="col-sm-10" style="margin-top: 21px;">
	                              <select class="form-control input-lg m-bot15"
	                                      id="zh" name="zh" value="${ydmb.zh}" onchange="getBh()">
	                                   <option selected="selected" >${ydmb.zh }</option>
						              <c:forEach var="zh" items="${zh}" varStatus="obj">
						              <option>${zh.zdmc }</option>
						              </c:forEach>
	                              </select>
	                        </div>     
					</div>
					
					
						 <div class="form-group" style="padding-bottom: 10px; padding-left: 0px; width: 100%; margin-bottom: 0px;">
						<label class="col-sm-2 col-sm-2 control-label" style="margin-top: -4px; border-left-width: 10px; padding-top: 14px; padding-left: 13px; width: 80px;">封面：</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="fm_id" name="fm_id" value="${ydmb.fm_id }">
								<a href="#myModal" data-toggle="modal"  class="btn btn-xs btn-sucess" onclick="getMb2()"  style="margin-top: -23px; margin-left: 280px;">选择</a>
							</div>
						</div> 
					
						<div class="form-group" style="padding-bottom: 10px; padding-left: 0px; width: 100%; margin-bottom: 0px;">
							<label class="col-sm-2 col-sm-2 control-label"  style="margin-top: -4px; border-left-width: 10px; padding-top: 14px; padding-left: 13px; width: 80px;">首页：</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="sy_id" name="sy_id" value="${ydmb.sy_id }">
								<a href="#myModal" data-toggle="modal" class="btn btn-xs btn-sucess" onclick="getMb3()"  style="margin-top: -23px; margin-left: 280px;">选择</a>
							</div>
						</div>
						<div class="form-group" style="padding-bottom: 10px; padding-left: 0px; width: 100%; margin-bottom: 0px;">
							<label class="col-sm-2 col-sm-2 control-label"   style="margin-top: -4px; border-left-width: 10px; padding-top: 14px; padding-left: 13px; width: 80px;">附页：</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="fy_id" name="fy_id" value="${ydmb.fy_id }">
								<a href="#myModal" data-toggle="modal" class="btn btn-xs btn-sucess" onclick="getMb1()"  style="margin-top: -23px; margin-left: 280px;">选择</a>
							</div>
						</div>
						
						</form>
						</c:forEach>
					</div>
					
				
				<div style="text-align: center">
			        <div class="panel-body">
				        <button type="button" class="btn btn-primary" onClick="update()">提交</button>
						<button type="button" class="btn btn-success" onClick="exit();">返回</button>
			        </div>
	            </div>
		  </div>
	   </div>
    </div>
    
 <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
  <div class="modal-dialog">
	  <div class="modal-content">
		    <div class="modal-body">
					<section class="panel" id="sect">
					   <header class="panel-heading">选择模板</header>
					    <span id="sbz" ></span>
			       	<div class="form-group" style="margin-left: 0px; margin-bottom: 1px; margin-right: 0px;">
			           <div class="col-lg-offset-2 col-lg-10"  style="margin-top: 40px; padding-left: 160px;">
			                 <button type="button" class="btn btn-default" onClick="$('#myModal').modal('hide');">取消</button>
					   </div>
				    </div>
					</section>
            </div>
       </div>
   </div>
</div>

</body>
</html>

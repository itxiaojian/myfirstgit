<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<% String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">

<link type="text/css" rel="stylesheet"href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet"href="<%=path%>/resources/css/jygl/style.css">
<title></title>
</head>
<script>
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

function openwinbz() {  
	    var id = $("#id").val(); 
	    location.href="sfbh?id="+id;
	} 

function save() {
	
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/bzxx/YsfBzxx/save";
		$.ajax({
			cache : true,
			type : "POST",
			url : url,
			data : $('#myForm').serialize(),// 你的formid
			async : false,
			/*  error : function(request) {
				alert("保存失败,请联系管理员。");
			},
			success : function(data) {
				alert('保存成功！');
				var PAGESIZE = 10;
				window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	            window.parent.ACT_DEAL_WINDOW.close();
			} */
		}); 
		var url2 = "<%=path%>/sfgl/Ysfxmxx/insert";
		$.ajax({
			cache : true,
			type : "POST",
			url : url2,
			data : $('#myForm2').serialize(),// 你的formid
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

//增加新一行
var i = 1;
function addTr(){
	var num=i+1;
	var oTest = document.getElementById("mybody");
	var newNode = document.createElement("tr");
	newNode.setAttribute('id','mybody'+num);
	newNode.style.marginLeft="20%";
	newNode.innerHTML ="<tr><td><input class='form-control' type='hidden' id='sfbzbh' name='sfbzbh' style='width:80%;'<c:if test='${sfbzbh != null}'>value='${sfbzbh }'</c:if>></td>"
	    +"<td><textarea rows='1'  class='form-control' truetype='textarea' name='xmbh' style='width:70%;margin-left:-7px;'></textarea></td>"
		+"<td><textarea rows='1'  class='form-control' truetype='textarea' name='xmmc' style='width:70%;margin-left:-7px;'></textarea></td>"
		+"<td><textarea rows='1'  class='form-control' truetype='textarea' name='cplx' style='width:70%;margin-left:-7px;'></textarea></td>"
	    +"<td><textarea rows='1'  class='form-control' truetype='textarea' name='cplxbh' style='width:70%;margin-left:-7px;'></textarea></td>"
		+"<td><select class='form-control' style='width:70%;height:36px;margin-left:-7px;' name='jldw"+num+"' id='jldw"+num+"'><option selected='selected' style='width:80%;'>${bzxx.jldw }</option><c:forEach var='jldw' items='${jldw}' varStatus='obj'><option>${jldw.zdmc }</option></c:forEach></select> </td>"
		+"<td><textarea rows='1'  class='form-control' truetype='textarea' name='dj' style='width:70%;margin-left:-7px;'></textarea></td>"
		+"<td><textarea rows='1'  class='form-control' truetype='textarea' name='bz' style='width:70%;margin-left:-7px;'></textarea></td>"
		+"<td><a href='javascript:;' onclick='deleteTr("+num+");'>"
		+"<span  style='text-align: right;' >"
		+"<img src='<%=path%>/resources/images/iconfont-shanchu.png' alt='删除' height='25px' width='25px'  style='margin-bottom: 5px; width: 34px; padding-left: 0px; border-left-width: 0px;  margin-left:-7px;'>"
		+"</span></a></td>"
		+"</tr>"
	oTest.insertBefore(newNode,null);
	i++;
	document.getElementById("num").value=i; 
	//alert($('#num').val());
}

//删除行
function deleteTr(num){
	if(confirm("您确定要删除吗？")){
		if(num==i){
			var del = $("#mybody"+i);
			del.remove();
			i--;
			document.getElementById("num").value=i;
		}else{
			alert("请删除最新的一行！");
		}
	}
}

//退出
function exit(){
	var PAGESIZE = 20;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
    window.parent.ACT_DEAL_WINDOW.close();
}

</script>
<body >
<div class="wrapper">
	<div class="panel">
	<header class="panel-heading" style="padding-left: 345px;">收费标准信息</header>
		<div class="panel-body" style="margin-bottom: 1px;">
		<div style="text-align:center;margin-bottom:-2px"></div>
		</div>
		<form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
			<div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 150%;">
				 <label class="col-sm-2 col-sm-2 control-label" style="width: 117px; border-left-width: 0px; padding: 3px 0px 0px 9px; height: 19px; border-top-width: 0px; margin-left: 6px; margin-top: 4px;">收费标准编号:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="sfbzbh" name="sfbzbh" style="width:200%;"
					<c:if test="${sfbzbh != null}">
								value="${sfbzbh }"
					</c:if>
					>
				</div> 
		 </div>
			  <div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 150%;">
				<label class="col-sm-2 col-sm-2 control-label" style="width: 117px; border-left-width: 0px; padding: 3px 0px 0px 9px; height: 19px; border-top-width: 0px; margin-left: 6px; margin-top: 4px;">产品名称：</label>
				<div class="col-sm-10">
					 <textarea class="form-control" truetype="textarea"  name="cpmc" rows="3" style="width:200%;"></textarea>
				</div>
			</div>
			
			 <div class="form-group" style="padding-bottom: 3px;margin-bottom: 0px;margin-top: 4px; width: 150%;">
				<label class="col-sm-2 col-sm-2 control-label" style="width: 117px; border-left-width: 0px; padding: 3px 0px 0px 9px; height: 19px; border-top-width: 0px; margin-left: 6px; margin-top: 4px;">规格型号：</label>
				<div class="col-sm-10">
			                  <!--  <input class="form-control" type="text" id="ggxh" name="ggxh"> -->
			                <textarea class="form-control" truetype="textarea"  name="ggxh" rows="3" style="width:200%;"></textarea>
			    </div>
			</div>
		</form>
		</div>
	</div>
	    
	<div class="panel">
		<header class="panel-heading" style="padding-left: 345px;"> 项目收费</header>
		<div class="panel-body">
			<form class="form-horizontal tasi-form" name="myForm2" id="myForm2"  method="post"  style="height: 139px; width: 1235px;">
			<input type="hidden" name="num" id="num" value="1">
			<div class="form-group" style="padding-bottom: 0px; 
			     padding-left: 0px; margin-left: 41px; margin-right: 0px;">
				<table>
					<tr>
						<th style="padding-left: -3px; width: 7%;"></th>
						<th style="padding-left: -3px; width: 7%;">项目编号</th>
						<th style="padding-left: -3px; width: 7%;">项目名称</th>
						<th style="padding-left: -3px; width: 7%;">产品类型</th>
						<th style="padding-left: -3px; width: 7%;">产品类型编号</th>
						<th style="padding-left: -3px; width: 7%;">计量单位</th>
						<th style="padding-left: -3px; width: 7%;">单价金额（元）</th>
						<th style="padding-left: -3px; width: 7%;">备注</th>
						<th></th>
					</tr>
					<tbody id="mybody">
					<tr id="tr">
						<td>
						<!-- <input class="form-control" type="text"  name="sfbzbh1" style="width:80%;"/> -->
						<!-- <textarea rows="1"  class="form-control" truetype="textarea" name="sfbzbh1" style="width:70%; margin-left: 0px;"></textarea> -->
						<input class="form-control" type="hidden" id="sfbzbh" name="sfbzbh1" style="width:80%;"
					    <c:if test="${sfbzbh != null}">
							 value="${sfbzbh }"
					    </c:if>
					>
						</td>
						<td>
						<textarea rows="1"  class="form-control" truetype="textarea" name="xmbh1" style="width:70%; margin-left: -7px;" required data-msg-required="项目编号不能为空" minlength="1" data-msg-minlength="项目编号不能为空"></textarea>
						</td>
						<td>
						<textarea rows="1"  class="form-control" truetype="textarea" name="xmmc1" style="width:70%; margin-left: -7px;" required data-msg-required="项目名称不能为空" minlength="1" data-msg-minlength="项目名称不能为空"></textarea>
						</td>
						<td>
						<textarea rows="1"  class="form-control" truetype="textarea" name="cpmc1" style="width:70%; margin-left: -7px;"></textarea>
						</td>
						<td>
						<textarea rows="1"  class="form-control" truetype="textarea" name="cplx1" style="width:70%; margin-left: -7px;"></textarea>
						</td>
						<td>
						<select class="form-control" name="jldw1" style="width:70%;height:36px; margin-left: -7px;">
						<option selected="selected" style="width:120px;hight:35px;">${bzxx.jldw }</option>
						<c:forEach var="jldw" items="${jldw}" varStatus="obj">
						<option>${jldw.zdmc }</option>
						</c:forEach>
					    </select>
						</td>
						<td>
						<textarea rows="1"  class="form-control" truetype="textarea" name="dj1" style="width:70%; margin-left:-7px;"></textarea>
						</td>
						<td>
						<textarea rows="1"  class="form-control" truetype="textarea" name="bz1" style="width:70%; margin-left: -7px;"></textarea>
						</td>
						
						
						<td><a href="javascript:;" onclick="deleteTr();">
									<span  style="text-align: right;" >
										<img src="<%=path%>/resources/images/iconfont-shanchu.png" alt="删除" height="25px" width="25px" style="margin-bottom: 5px; width: 34px; padding-left: 0px; border-left-width: 0px;  margin-left: -7px;"/>
									</span>
							</a>
						</td>		
					</tr>
					</tbody>
				</table>
			</div>
			<div style="text-align:center;margin-bottom:10px;margin-left: -256px;">
				<input class="btn btn-success" id="btnAdd" value="新增" style="width: 60px; margin-left: -230px;" type="button" onclick="addTr();">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="btn btn-success" value="提交" type="button" onclick="save();">
				<!-- <input class="btn btn-success" value="提交" type="submit"> -->
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="btn btn-success" value="关闭" type="button" onclick="exit();">
		    </div>
			</form>
		</div>
	</div>
</div>
</body>
</html>
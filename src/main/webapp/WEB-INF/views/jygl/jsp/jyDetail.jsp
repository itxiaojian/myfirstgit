<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<% String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
</head>
<script>
function openypxxwin() {  
	 var bgbh = $("#bgbh").val(); 
    window.open("ypxx?bgbh="+bgbh, "样品信息", "height=750, width=1000, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no") ;
} 

function opensbxxwin() {  
	 var id = $("#id").val();
   	 //window.open("ypsbxx?id="+id, "设备信息", "height=600, width=1200, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no") ;
 	location.href="ypsbxx?id="+id;
} 

function openwin() {  
    //window.open("ypjybz", "检验标准列表", "height=600, width=1000, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no") ;
    var id = $("#id").val(); 
    location.href="ypjybz?id="+id;
} 

function openswpd(num,value1,value2,value3) {
	var str = value1+"/"+value2+"/"+value3;
	var id = $("#id").val(); 
   //window.open("clyyList", "常规结论用语1", "height=750, width=1000, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no") ;
   location.href = "clyyList?id="+id+"&type="+num+"&value="+str;
} 
</script>
<body >
<div class="wrapper">
 <form action="" name="Form" id="Form" method="post">
<c:forEach var="jyxx" items="${jyxx}" varStatus="obj">
	<input type="hidden" name="bgbh" id="bgbh" value="${jyxx.bgbh }">
	<input type="hidden" name="id" id="id" value="${jyxx.id }">
	<div class="panel">
		<header class="panel-heading"> 样品检验 </header>
		<div class="panel-body">
		<div style="text-align:center;margin-bottom:10px">
			<a class="btn btn-success" onclick="openypxxwin();" type="submit"> 样品信息</a>
			<a class="btn btn-success" onclick="opensbxxwin();" type="submit"> 设备信息</a>
			<a class="btn btn-success" onclick="openwin();" type="submit"> 标准信息</a>
		</div>
			<div class="form-group" style="padding-bottom: 0px;">
				<label class="col-sm-2 col-sm-2 control-label">报告编号：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="${jyxx.bgbh }" name="bgbh" disabled="true">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">样品名称：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="ypmc" value="${jyxx.ypmc }">
				</div>
				<label class="col-sm-2 col-sm-2 control-label">样品类型：</label>
				<div class="col-sm-10">
					<select class="form-control input-lg m-bot15" name="yplx" style="font-size:14px; height:40px;">
						<option selected="selected">${jyxx.yplb }</option>
						<c:forEach var="yplx" items="${yplx}" varStatus="obj">
						<option>${yplx.hymc }</option>
						</c:forEach>
					</select>
				</div>
				<input class="form-control" type="hidden" name="sbxxid" id="sbxxid"
							<c:if test="${getsbxx != null}">
								value="${getsbxx }"
							</c:if> 
						>
			</div>
			
			<div class="form-group" >
				<label class="col-sm-2 col-sm-2 control-label">检验类型：</label>
				<div class="col-sm-10">
					<select class="form-control input-lg m-bot15" name="jylb" style="font-size:14px; height:40px;">
						<option selected="selected">${jyxx.jylb }</option>
				<c:forEach var="jylx" items="${jylx}" varStatus="obj">
						<option>${jylx.zdmc }</option>
				</c:forEach>
					</select>
				</div>
				<label class="col-sm-2 col-sm-2 control-label">登记日期：</label>
				<div class="col-sm-10">
					<input name="djrq"value="${jyxx.djrq }" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="form-control Wdate"/>
					<span class="help-inline" style="float:left;">yyyy-mm-dd</span>
				</div>
			</div>
			
			<div class="form-group">
			</div>
		</div>
	</div>
	
	
	<div class="panel">
		<header class="panel-heading"> 检验内容 </header>
		<div class="panel-body">
				<div class="form-group" style="padding-bottom: 0px;height: 21px;">
					<label class="col-sm-2 col-sm-2 control-label">
						<a class="btn btn-xs btn-success" onclick="openwin();" type="submit"> 检验依据：</a>
					</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="jyyj" 
							<c:if test="${getjybzmc != null}">
								value="${getjybzmc }"
							</c:if> 
						>
						<input class="form-control" type="hidden" name="bzbh"
							<c:if test="${getjybzbh != null}">
								value="${getjybzbh }"
							</c:if> 
						>
					</div>
					<label class="col-sm-2 col-sm-2 control-label">主检人：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value="${jyxx.zjr }" name="zjr">
					</div>
					<label class="col-sm-2 col-sm-2 control-label">检验日期：</label>
					<div class="col-sm-10">
						<input name="ksrq"value="${jyxx.ksrq }" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="form-control Wdate"/>
						<span class="help-inline">yyyy-mm-dd</span>
					</div>
				</div>
				
				<div class="form-group" style="height: 49px;">
					<label class="col-sm-2 col-sm-2 control-label">环境条件：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value="${jyxx.hjtj }" name="hjtj">
					</div>
					<label class="col-sm-2 col-sm-2 control-label">项目描述：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value="${jyxx.xmms }" name="xmms">
					</div>
					<label class="col-sm-2 col-sm-2 control-label">检验方法：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value="${jyxx.jyff }" name="jyff">
					</div>
				</div>
				
				<div class="form-group" style="padding-bottom: 0px;">
					<label class="col-sm-2 col-sm-2 control-label">判定标准：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value="${jyxx.pdyq }" name="pdyq">
					</div>
					<label class="col-sm-2 col-sm-2 control-label">检验费用：</label>
					<div class="input-group m-bot15 col-sm-10">
						<input class="form-control" type="text" value="${jyxx.jyfy }" name="jyfy">
						<span class="input-group-addon">.00</span>
					</div>
					<label class="col-sm-2 col-sm-2 control-label">加急费用：</label>
					<div class="input-group m-bot15 col-sm-10">
						<input class="form-control" type="text" value="${jyxx.jjfy }" name="jjfy">
						<span class="input-group-addon">.00</span>
					</div>
				</div>
				
				<div class="form-group" style="padding-bottom: 0px;">
					<label class="col-sm-2 col-sm-2 control-label">其他费用：</label>
					<div class="input-group m-bot15 col-sm-10">
						<input class="form-control" type="text" value="${jyxx.qtfy }" name="qtfy">
						<span class="input-group-addon">.00</span>
					</div>
				</div>
				
				<!-- <div class="form-group">
				</div> -->
		</div>
	</div>
	
	<div class="panel">
			<header class="panel-heading">检验项目</header>
		<div class="panel-body">
			<div class="adv-table editable-table ">
				<div class="clearfix">
					<div class="btn-group">
						<button id="editable-sample_new" class="btn green">新增 <i class="icon-plus"></i></button>
					</div>
					<div class="btn-group pull-right">
						<button class="btn dropdown-toggle" data-toggle="dropdown">工具栏 <i class="icon-angle-down"></i></button>
						<ul class="dropdown-menu pull-right">
							<li><a href="#">打印</a></li>
							<li><a href="#">保存PDF</a></li>
							<li><a href="#">导出Excel</a></li>
						</ul>	
					</div>
				</div>
				
			<div class="space15"></div>
				<table class="table table-striped table-hover table-bordered" id="editable-sample">
					<thead>
						<tr>
							<th>检验标准编号</th>
							<th>检验项目编号</th>
							<th>检验项目名称</th>
							<th>计量单位</th>
							<th>检验项目类型</th>
							<th>检验项目要求</th>
							<th>标准最大值</th>
							<th>标准最小值</th>
							<th>评定用语</th>
							<th>检验依据及方法</th>
							<th>单价</th>
							<th>评定方式</th>
							<th>默认检验员</th>
							<th>最低检出限</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="getxmxx" items="${getxmxx}" varStatus="obj">
						<tr class="">
							<td>${getxmxx.bzbh }</td>
							<td>${getxmxx.xmbh }</td>
							<td>${getxmxx.xmmc }</td>
							<td>${getxmxx.jldw }</td>
							<td>${getxmxx.xmlx }</td>
							<td>${getxmxx.xmyq }</td>
							<td>${getxmxx.bzmax }</td>
							<td>${getxmxx.bzmin }</td>
							<td>${getxmxx.pdyy }</td>
							<td>${getxmxx.jyyj }</td>
							<td>${getxmxx.dj }</td>
							<td>${getxmxx.pdfs }</td>
							<td>${getxmxx.mjyy }</td>
							<td>${getxmxx.zdcx }</td>
							<td><a class="edit" href="javascript:;">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a class="delete" href="javascript:;">删除</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<div class="panel">
		<header class="panel-heading">检验判定</header>
			<div class="panel-body">
					<div class="form-group"  style="height: 90px;">
						<label class="col-sm-2 col-sm-2 control-label">实物判定</label>
						<div class="col-sm-10" style=" width: 40%;">
<%-- 							<input type="textarea"  class="form-control" value="${jyxx.swpd }" name="swpd"> --%>
								<textarea rows="3" cols="60" name="swpd"><c:if test="${clyy1 != null}">${clyy1 }</c:if> 
								</textarea>
<!-- 								<input class="form-control" type="text" name="swpd" id="clyy" -->
									
<!-- 						> -->
						</div>
						<label class="col-sm-2 col-sm-2 control-label">
						<a class="btn btn-xs btn-success" onclick="openswpd(1,'${clyyid1 }','${clyyid2 }','${clyyid3 }');" type="submit"> 选择常规结论用语</a>
					    </label>
					</div>
					
					<div class="form-group"  style="height: 90px;">
						<label class="col-sm-2 col-sm-2 control-label">标识判定</label>
						<div class="col-sm-10" style=" width: 40%;">
<%-- 							<input type="text"  class="form-control" value="${jyxx.bzpd }" name="bzpd"> --%>
								<textarea rows="3" cols="60" name="bzpd"><c:if test="${clyy2 != null}">${clyy2 }</c:if> 
								</textarea>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">
						<a class="btn btn-xs btn-success" onclick="openswpd(2,'${clyyid1 }','${clyyid2 }','${clyyid3 }');" type="submit"> 选择常规结论用语</a>
					    </label>
					</div>
						<div class="form-group"  style="height: 90px;">
						<label class="col-sm-2 col-sm-2 control-label">检验结论</label>
						<div class="col-sm-10" style=" width: 40%;">
<%-- 							<input type="text" class="form-control" value="${jyxx.jyjl }" name="jyjl"> --%>
								<textarea rows="3" cols="60" name="jyjl"><c:if test="${clyy3 != null}">${clyy3 }</c:if> </textarea>
						</div>
						<label class="col-sm-2 col-sm-2 control-label">
						<a class="btn btn-xs btn-success" onclick="openswpd(3,'${clyyid1 }','${clyyid2 }','${clyyid3 }');" type="submit"> 选择常规结论用语</a>
					    </label>
					</div> 
			</div>
	</div>
	
	<div class="panel">
		<header class="panel-heading">认证方式</header>
			<div class="panel-body">
					<div class="checkboxes" style="width: 100%;">
						<table class="table" style="width:100%;" >
							<c:forEach var="rztb" items="${rztb}" varStatus="obj">
							<tbody style="border-top: 0px;float:left;">
								<tr>
									<td style=" border-top-width: 0px; float: left;">
										<input name="rztbids" style="float: left;" value="${rztb.id }" id="rztbids_${obj.count }" type="checkbox" onclick="showImg('img_${obj.count }');"/>
									 	<span style="float:left">
										 	<label class="label_check" for="rztbids_${obj.count }">
												&nbsp;&nbsp;${rztb.rzmc }
											</label>
										</span>
										<div style="display: none;position: absolute;z-index:9999;margin-left:20px;" id="img_${obj.count }">
											<img alt="${rztb.rzmc }" style="width: 142px;" src="<%=path %>/${rztb.fjlj }/${rztb.sub }">
										</div>
									</td>
								</tr>
							</tbody>
								</c:forEach>
						</table>
					</div>
			</div>
	</div>
	</c:forEach>
	<input type="hidden" name="rztbid" id="rztbid" value="">
	<div style="text-align:center">
		<div class="panel-body">
			<button type="button" class="btn btn-primary"  style="width: 66px;" onClick="tijiao();"> 提交</button>
			<button type="button" class="btn btn-success"  onclick="exit();">返回</button> 
		</div>
	</div>
</form>
</div>
</body>
<script type="text/javascript">
	function showImg(id){
		if(document.getElementById(id).style.display=='none'){
			document.getElementById(id).style.display='block';
		}else{
			document.getElementById(id).style.display='none';
		}
	}
	
    function tijiao(){
    	var sbxxid = $("#sbxxid").val();
    	if(sbxxid == ""){
    		alert("请添加设备信息");
    		return false;
    	}
    	var rztbid=[];
    	$('input[name="rztbids"]:checked').each(
    			function(){
//     				alert($(this).val());
    				rztbid.push($(this).val());
    			}
 		);
    	//alert(rztbid);
    	document.getElementById("rztbid").value=rztbid;
    	//alert($("#rztbid").val());
    	$.ajax({
			cache : true,
			type : "POST",
			url : "<%=path%>/jygl/YjyJyxx/tijiao",
 			data : $('#Form').serialize(),// 你的formid
			async : false,
			error : function(request) {
				alert("保存失败，请联系管理员。");
			},
			success : function(data) {
				if(data=='1'){
					alert('保存成功！');
					var PAGESIZE = 20;
					window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
		            window.parent.ACT_DEAL_WINDOW.close();
				}else{
					alert("保存失败，请联系管理员。");
				}
			}
		});
<%-- 			location.href="<%=path%>/jygl/YjyJyxx/JyxxPage; --%>
    };
    
  //退出
    function exit(){
    	var PAGESIZE = 10;
    	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
        window.parent.ACT_DEAL_WINDOW.close();
    }
  </script>
</html>
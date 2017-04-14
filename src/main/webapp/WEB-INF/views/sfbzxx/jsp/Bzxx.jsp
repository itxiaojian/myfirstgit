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
<script type="text/javascript"src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>

<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css">
<script type="text/javascript" src="<%=path%>/resources/js/jquery.easyui.min.js"></script>
<script type="text/javascript"src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet"href="<%=path%>/resources/css/jygl/bootstrap.min.css">
<link type="text/css" rel="stylesheet"href="<%=path%>/resources/css/jygl/style.css">

<script type="text/javascript">


function close(){
	var PAGESIZE = 10;
	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
    window.parent.ACT_DEAL_WINDOW.close();
}

function openwinbz() {  
    var id = $("#id").val(); 
    location.href="jybz?id="+id;
} 

function openwinxm() {  
    var id = $("#id").val(); 
    location.href="jyxm?id="+id;
} 


$(function() {
	  //ComboTree控件初始化
		$('#ks_id').combotree({
			url: '<%=path%>/test/xlsList?optype=getchildtree',
	    'onLoadSuccess': function(node,data){ 
	    //在panel控件load完成的时候处理当前显示值，如果不处理，则combotree1的显示值有可能会不正确
		        if(data.length>0){
				       var val = ""; //jsp页面初始化时combotree1的初始id值
			         var txt = $('#ks_id').combotree('getText'); //combotree1当前的显示text值

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
	             	            $('#ks_id').combotree('setText',gettxt);
	                      }  
	                  );
	               }
		        }
			}
		});
	});

  function save(type){

	var url="";
	var msg="";
	
	if(type==0){
		url="<%=path%>/bzxx/YsfBzxx/save";
			msg = "确定要提交收费标准信息吗？";

			if (confirm(msg)) {
				//getMrjh();
				$.ajax({
					cache : true,
					type : "POST",
					url : url,
					data : $('#myForm').serialize(),// 你的formid
					async : false,
					error : function(request) {
						alert("保存失败，请联系管理员。");
					},
					success : function(data) {

						if (data == '1') {
							alert('保存成功！');
							history.go(0);
						} else {
							alert("保存失败，请联系管理员。");
							alert(data);
						}

					}
				});
			}
		}
	}
</script>
</head>
<body>
	<div class="wrapper">
		<div class="panel">
			<form action="" class="form-horizontal tasi-form" name="myForm"
				id="myForm" method="post">
				<div class="form-group" style="padding-top: 15px">
					<label class="col-sm-2 col-sm-2 control-label"> 收费标准编号 ：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="sfbzbh">
					</div>
						<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">  收费标准名称 :</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value="" name="sfbzmc">
					</div>
				</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">产品类型：</label>
					<div class="col-sm-10">
						<select class="form-control input-lg m-bot15" name="cplx" style="font-size:14px; height:40px;">
						<option selected="selected">${bzxx.cplx }</option>
						<c:forEach var="cplx" items="${cplx}" varStatus="obj">
						<option>${cplx.hymc }</option>
						</c:forEach>
					</select>
					</div>
									<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">单位名称：</label>
					<div class="col-sm-10">
							<select class="form-control input-lg m-bot15" name="dw_id" style="font-size:14px; height:40px;">
						<option selected="selected">${bzxx.dw_id }</option>
				           <c:forEach var="dw_id" items="${dw_id}" varStatus="obj">
						<option>${dw_id.zdmc }</option>
				           </c:forEach>
					</select>
					</div>
				</div>

				</div>


				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">产品名称：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value="" name="cpmc">
					</div>
									<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">开始时间：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value="" name="kssj"
							onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
					</div>
				</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">结束时间：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value="" name="jssj"
							onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
					</div>
					<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">金额：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value="" name="je">
					</div>
				</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">规格型号：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value="" name="ggxh">
					</div>
					<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">
					<a class="btn btn-xs btn-success" onclick="openwinbz();" type="submit"> 检验标准编号 ：</a>
					</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="jybz_id"
							<c:if test="${getjybzbh != null}">
								value="${getjybzbh }"
							</c:if> 
						>
					</div>
				</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">检验标准名称：</label>
					<div class="col-sm-10">
						<!-- <input class="form-control" type="text" value="" name="bzmc"> -->
						
						<input class="form-control" type="text" name="bzmc"
							<c:if test="${getjybzmc != null}">
								value="${getjybzmc }"
							</c:if> >
					</div>
					<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">
					<a class="btn btn-xs btn-success" onclick="openwinxm();" type="submit"> 检验项目编号 ：</a>
					</label>
					<div class="col-sm-10">
						<input class="form-control" type="text"  name="jyxm_id"
						<c:if test="${getjyxmbh != null}">
								value="${getjyxmbh }"
						</c:if> 
						>
					</div>
				</div> 
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">检验项目名称：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text"  name="xmmc"
						<c:if test="${getjyxmmc != null}">
								value="${getjyxmmc }"
						</c:if> >
					</div>
					<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">科室名称：</label>
					<div class="col-sm-10">
						<input class="easyui-combotree" type="text" id="ks_id" name="ks_id" value="" style="width:248px;height: 34px;">
					</div>
				</div>
				</div>
				

				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">备注：</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" value="" name="bz">
					</div>
				</div>

				<div style="text-align: center">
					<div class="panel-body">
						<input class="btn btn-success" value="提交" type="button"onclick="save(0);"> 
						<input class="btn btn-success"type="button" onclick="javascript:window.close();" value="关闭">
					</div>
				</div>
			</form>
		</div>
	</div>

	</div>
</body>
</html>

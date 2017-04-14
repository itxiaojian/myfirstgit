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

<style type="text/css">
	 .wbk{
	  	border-left:0px;
	  	border-top:0px;
	  	border-right:0px;
	  	border-bottom:1px;
	  	box-shadow:0px 0px 0px;
	  	margin-left: 0px;
	    margin-top: 7px;
	    font-size:14px;
 	}
 	.div{
	 	padding-bottom: 3px;
	 	margin-bottom: 0px;
	 	margin-top: 4px;
	 	width: 100%;
	 	height: 31px;
 	}
 	.bt{
 		margin-top: 6px;
 		font-size: 12px;
    	font-weight: 700;
 	}
 	.srk{
 		right: 6%;
 	}
</style>
</head>

<body >
	<div class="wrapper">
	<form class="tasi-form" name="myForm" id="myForm" method="post"  style="overflow:scroll;overflow-x:hidden">
					<div class="form-group div">
						<label class="col-sm-2 control-label bt">结论类别1：</label>
						<div class="col-sm-10 srk">
							<select class="form-control input-lg m-bot15" id="jllb1" name="jllb1" style="padding-left: 2px;" >
										<option value="">请选择...</option>
								<c:forEach var="jllb1" items="${jllb1}" varStatus="obj" >
										<option value="${jllb1.zdz }">${jllb1.zdmc }</option>
								</c:forEach>
					        </select>
						</div>
						<label class="col-sm-2 control-label bt">结论类别2：</label>
						<div class="col-sm-10 srk">
							<select class="form-control input-lg m-bot15" id="jllb2" name="jllb2" style="padding-left: 2px;" >
										<option value="">请选择...</option>
								<c:forEach var="jllb2" items="${jllb2}" varStatus="obj" >
										<option value="${jllb2.zdz }">${jllb2.zdmc }</option>
								</c:forEach>
					        </select>
						</div>
					</div>
					<div class="form-group div" style="height:40px;">
						<label class="col-sm-2 bt control-label">常规结论用语：</label>
						<div class="col-sm-13 srk">
							<textarea class="form-control ckeditor textarea wbk" rows="6"  name="cgjlyy" id="cgjlyy"
							 style="width: 99.6%;height: 35px;resize:none;"></textarea>
						</div>
					</div>
					<div class="form-group div">
						<label class="col-sm-2 bt control-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
						<div class="col-sm-13 srk">
							<textarea class="form-control ckeditor textarea wbk" rows="6" name="bz" 
							truetype="textarea" style="width: 99.6%;height: 35px;resize:none;"></textarea>
						</div>
					</div>
			</form>
	</div>
	        <div align="center">
                <br>
                <input class="btn btn-success" value="提交" type="button"  onclick="add();">
                <input class="btn btn-success" type="button" onclick="exit();" value="返回">
            </div>
</body>
<script>
//返回
function exit(){
// 	var PAGESIZE = 20;
// 	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); 
    window.parent.ACT_DEAL_WINDOW.close();
}

function add() {
	if ($("#jllb1").val() == "") {
        alert("请选择结论类别1！");
        return false;
    }
	if ($("#jllb2").val() == "") {
        alert("请选择结论类别2！");
        return false;
    }
	if ($("#cgjlyy").val() == "") {
        alert("请输入常规结论用语！");
        return false;
    }
	msg="确定要提交？";
	if (confirm(msg)) {
		var url = "<%=path%>/jygl/YjyClyy/save";
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
				if (data == '1') {
					alert('保存成功！');
					var PAGESIZE = 20;
					window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
		            window.parent.ACT_DEAL_WINDOW.close();
				}else {
                    alert("保存失败，请联系管理员!");
                }
			}
		});
	}
}

</script>
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
    font: 13px/19px "Microsoft YaHei",Verdana,Geneva,sans-serif;
    padding: 1%;
    margin-top: 3px;
    text-align: center;
    text-decoration: none;
    width: 10%;
}
</style>

</html>

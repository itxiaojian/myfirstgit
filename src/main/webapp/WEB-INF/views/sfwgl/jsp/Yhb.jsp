<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<% String path = request.getContextPath();%>
<!DOCTYPE html>
<html lang="en">
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>安徽省质检院综合业务管理平台</title>

    <!-- Bootstrap core CSS -->
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap-reset.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
    
    <script type="text/javascript">
		function query(){
			$("#myForm").submit();
		}
	</script>
  </head>

  <body style="width:1700px;">

      <!--header end-->
      <!--sidebar start-->

      <!--sidebar end-->
      <!--main content start-->
      <section id="main-content1" style="margin-left: 7px;">
          <section class="wrapper1">
              <!-- page start-->
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <form action="<%=path%>/sfwgl/YsfwFwxx/Yh" id="myForm" style="margin-top: 7px;" method="post">
                          	  <span style="float:left; margin-top: 7px;margin-right: 10px; margin-left: 32px;font-weight:900;">用户信息:</span>
                          	  <input type="text" class="form-control" style="width: 200px;float:left;margin-bottom: 6px;" name="code" id="code" >
                          	  <a href="#" style="color:white;margin-left: 21px;" onclick="query();" class="btn btn-success">查询</a>
                          </form>
                          <form action="" name="Form" id="Form" method="post">
                          <table class="table table-striped table-advance table-hover" style="margin-top: 8px;border-top: 2px solid #ddd;">
                              <thead>
                              <tr>
                              	  <!-- <th style="display:none;">主键</th> -->
                                  <th style="display:none;">用户编号</th> 
                              	  <th style="width: 130px;">登录名</th>
                                  <th style="width:92px;">姓名</th>
                                 <!--  <th style="width:92px;">部门编号</th>
                                  <th style="width: 100px;">岗位编号</th>
                                  <th style="width: 110px;">手机号</th>
                                  <th style="width: 100px;">邮箱</th> -->
                                  <th>操作</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach var="Yh" items="${Yh}" varStatus="obj">
							  <tr>
							      <td style="display:none;"><input type="hidden" name="yhbh" value="${Yh.yhbh }"/>${Yh.yhbh }</td> 
						 	      <td ><input type="hidden" name="dlm" value="${Yh.dlm }"/>${Yh.dlm }</td> 
                                  <td><input type="hidden" name="xm" value="${Yh.xm }"/>${Yh.xm }</td>
                                <%--   <td><input type="hidden" name="bmbh" value="${Yh.bmbh }"/>${Yh.bmbh }</td>
                                  <td><input type="hidden" name="gwbh" value="${Yh.gwbh }"/>${Yh.gwbh }</td>
                                  <td><input type="hidden" name="sjh" value="${Yh.sjh }"/>${Yh.sjh }</td>
                                  <td><input type="hidden" name="yx" value="${Yh.yx }"/>${Yh.yx }</td> --%>
                                  <td>
                                 	  <label class="label_check" for="checkbox-02">
	                                 	<a href="javascript:void(0);" class="btn btn-primary" onClick="save ('${Yh.yhbh}','${Yh.xm }');">提交</a>
									  </label>
                                  </td>
                              </tr>
                              </c:forEach>
                              </tbody>
                          </table>
                              <!--  <input type="hidden" name="clyyid" id="clyyid" value=""> -->
				               <input type="hidden" name="type" id="type" value="${type }">
				               <input type="hidden" name="value" id="value" value="${value }">
                          </form>
                      </section>
                      <div style="text-align:center">
                        <div class="panel-body">
                              <button type="button" class="btn btn-success" onClick="javascript:window.history.go(-1);">返回</button> 
                        </div>
                      </div>
                  </div>
              </div>
              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer" style="margin-right: -16px;">
          <div class="text-center">
               2015 &版权所有; 合肥智圣系统集成有限责任公司.
          </div>
      </footer>
      <!--footer end-->
  </section>

 <script  type="text/javascript">
 
 <%-- function save(yhbh){
	 var viewId = $("#yhbh").val();
		var type = $("#type").val();
		var value = $("#value").val();
			location.href="<%=path%>/sfwgl/YsfwFwxx/fwAddView?ids="+yhbh;
			
 }; --%>
 
 <%-- function save(yhbh){
	 
	var viewId = $("#yhbh").val();
	var type = $("#type").val();
	var value = $("#value").val();
	var clyyid=[];
	/* $('input[name="clyyids1"]:checked').each(
			function(){
// 				alert($(this).val());
				clyyid.push($(this).val());
			}
		); */
 	//alert(yhbh);
//	document.getElementById("clyyid").value=clyyid;
/*  	alert($("#clyyid").val()); */
 location.href="<%=path%>/sfwgl/YsfwFwxx/fwAddView?id="+yhbh+"&yhbh="+yhbh+"&type="+type+"&value="+value; 
	
	
}; --%>

function save(yhbh,yhxm){
    window.opener.$("#sjr").val(yhxm);
    window.opener.$("#yhxm").val(yhbh);
    self.close();
};
</script> 
  </body>
</html>

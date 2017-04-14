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
                          <header class="panel-heading">
                              检验标准
                          </header>
                          <form action="<%=path%>/bzxx/YsfBzxx/jybz" id="myForm" style="margin-top: 7px;" method="post">
                          	  <span style="float:left; margin-top: 7px;margin-right: 10px; margin-left: 32px;font-weight:900;">检验标准名称:</span>
                          	  <input type="text" class="form-control" style="width: 200px;float:left;margin-bottom: 6px;" name="code" id="code" >
                          	  <a href="#" style="color:white;margin-left: 21px;" onclick="query();" class="btn btn-success">查询</a>
                          </form>
                          <form action="" name="Form" id="Form" method="post">
                          <table class="table table-striped table-advance table-hover" style="margin-top: 8px;border-top: 2px solid #ddd;">
                              <thead>
                              <tr>
                              	  <th style="display:none;">主键</th>
                                  <th style="width: 110px;">检验标准编号</th>
                                  <th style="width: 130px;">检验标准名称</th>
                                  <th>操作</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach var="jybz" items="${jybz}" varStatus="obj">
							  <tr>
							  	  <td style="display:none;"><input type="hidden" name="id" value="${jybz.id }"/></td>
                                  <td><input type="hidden" name="bzbh" value="${jybz.bzbh }"/>${jybz.bzbh }</td>
                                  <td><input type="hidden" name="bzmc" value="${jybz.bzmc }"/>${jybz.bzmc }</td>
                                  <td>
                                 	  <label class="label_check" for="checkbox-02">
	                                 	<a href="javascript:void(0);" class="btn btn-primary" onClick="save ('${jybz.id}','${id }');">提交</a>
									  </label>
                                  </td>
                              </tr>
                              </c:forEach>
                              </tbody>
                          </table>
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
 /* function openwin(bzbh) {  
     window.location.replace("ypjybzxm?bzbh="+bzbh, "检验项目", "height=700, width=1000, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no") ; 
}  */
 
 function save(id,viewId){
			location.href="<%=path%>/bzxx/YsfBzxx/sfAddView?ids="+id+"&id="+viewId;
 };
</script> 

  </body>
</html>

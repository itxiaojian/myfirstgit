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
		
	    function test(o) {
	    	if (!o.checked) {
	    		return;
	    	}
	    	var tr = o.parentNode.parentNode;
	    	var tds = tr.cells;
	    	var str = "you click ";
	    	for(var i = 0;i < tds.length;i++){
	    		//if (i < 3) {
	    			str = str + tds[i].innerHTML + "--";
	    		//}
	    	}
	    	alert(str);
    	}
		
	</script>
  </head>

  <!-- <body style="width: 1353px;"> -->
  <body style="width: 98%;">
      <section id="main-content1" style="margin-left: 7px;">
          <section class="wrapper1">
              <!-- page start-->
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <table class="table table-striped table-advance table-hover" style="margin-top: 8px;border-top: 2px solid #ddd;">
                              <thead>
                              <tr>
                              	  <!-- <th style="display:none;">主键</th> -->
                                  <!-- <th style="display:none;">项目编号</th> -->
                                  <th style="width: 130px;">项目编号</th>  
                              	  <th style="width: 130px;">项目名称</th>
                                  <th style="width:92px;">单价金额</th>
                                  <th style="width:92px;">计量单位</th>
                                  <th style="width:92px;">修改金额</th>
                                  <th>操作</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach var="Sfxmmx" items="${Sfxmmx}" varStatus="obj">
							  <tr>
							      <td><input type="hidden" name="xmbh" value="${Sfxmmx.xmbh }"/>${Sfxmmx.xmbh }</td>
						 	      <td><input type="hidden" name="xmmc" value="${Sfxmmx.xmmc }"/>${Sfxmmx.xmmc }</td>
                                  <td><input type="hidden" name="je" value="${Sfxmmx.dj }"/>${Sfxmmx.dj }</td>
                                  <td><input type="hidden" name="jldw" value="${Sfxmmx.jldw }"/>${Sfxmmx.jldw }</td>
                                  <td><input type="text" id="xgje" name="xgje" /></td>
                                  <td>
                                 	  <%-- <label class="label_check" for="checkbox-02">
	                                 	<a href="javascript:void(0);" class="btn btn-primary" onClick="save ('${Yh.yhbh}','${yhbh }');">提交</a>
									  </label> --%>
									  <!-- <input type="checkbox" onclick="test(this);"/> -->
									  <input type="checkbox" />
                                  </td>
                              </tr>
                              </c:forEach>
                              </tbody>
                          </table>
                      </section>
                      <div style="text-align:center">
                        <div class="panel-body">
                        		<button type="button" class="btn btn-primary" onClick="save()">提交</button>
                              <button type="button" class="btn btn-success" onClick="javascript:window.history.go(-1);">返回</button> 
                        </div>
                      </div>
                  </div>
              </div>
              <!-- page end-->
          </section>
      </section>
	  
	  <div style="display:none;">
	  	  <form class="form-horizontal tasi-form" name="myForm" id="myForm" method="post">
	  	  	 <table id="mytable">
	  	  	 	
	  	  	 </table>
	  	  </form>
	  </div>
  </body>
</html>

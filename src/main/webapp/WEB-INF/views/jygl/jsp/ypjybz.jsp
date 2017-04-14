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
                          <form action="<%=path%>/jygl/YjyJyxx/ypjybz" id="myForm" style="margin-top: 7px;" method="post">
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
                                  <th class="hidden-phone" style="width:98px;">标准类别</th>
                                  <th style="width:92px;">标准级别</th>
                                  <th style="width: 100px;">标准启用日期</th>
                                  <th style="width: 110px;">下属项目编号</th>
<!--                                   <th style="width: 100px;">最后修改日期</th> -->
<!--                                   <th style="width: 65px;">修改人</th> -->
                                  <th style="width: 80px;">废止状态</th>
                                  <th>废止日期</th>
                                  <th style="width: 100px;">废止登记人</th>
                                  <th style="width: 77px;">审核状态</th>
<!--                                   <th>审核日期</th> -->
<!--                                   <th style="padding-left: 0px; padding-right: 0px;">审核人</th> -->
                                  <th>开始时间</th>
                                  <th>结束时间</th>
                                  <th>操作</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach var="jybz" items="${jybz}" varStatus="obj">
							  <tr>
							  	  <td style="display:none;"><input type="hidden" name="id" value="${jybz.id }"/></td>
                                  <td><input type="hidden" name="bzbh" value="${jybz.bzbh }"/>${jybz.bzbh }</td>
                                  <td><input type="hidden" name="bzmc" value="${jybz.bzmc }"/>${jybz.bzmc }</td>
                                  <td><input type="hidden" name="bzlb" value="${jybz.bzlb }"/>${jybz.bzlb }</td>
                                  <td><input type="hidden" name="bzjb" value="${jybz.bzjb }"/>${jybz.bzjb }</td>
                                  <td><input type="hidden" name="qyrq" value="${jybz.qyrq }"/>${jybz.qyrq }</td>
                                  <td><input type="hidden" name="xmbh_id" value="${jybz.xmbh_id }"/>${jybz.xmbh_id }</td>
<%--                                   <td><input type="hidden" name="zhxgrq" value="${jybz.zhxgrq }"/>${jybz.zhxgrq }</td> --%>
<%--                                   <td><input type="hidden" name="xgr" value="${jybz.xgr }"/>${jybz.xgr }</td> --%>
                                  <td><input type="hidden" name="fzzt" value="${jybz.fzzt }"/>
                                  	<c:choose>
                                  		<c:when test="${jybz.fzzt  =='0'}"><span class="label label-success label-mini">正常</span></c:when>
                                  		<c:when test="${jybz.fzzt  =='1'}"><span class="label label-danger label-mini">停用</span></c:when>
                                  		<c:when test="${jybz.fzzt  =='2'}"><span class="label label-warning label-mini">废除</span></c:when>
                                  	</c:choose>
                                  </td>
                                  <td><input type="hidden" name="fzrq" value="${jybz.fzrq }"/>${jybz.fzrq }</td>
                                  <td><input type="hidden" name="fzdjr" value="${jybz.fzdjr }"/>${jybz.fzdjr }</td>
                                  <td><input type="hidden" name="shzt" value="${jybz.shzt }"/>
                                  	<c:choose>
                                  		<c:when test="${jybz.shzt  =='1'}"><span class="label label-success label-mini">通过</span></c:when>
                                  		<c:when test="${jybz.shzt  =='2'}"><span class="label label-danger label-mini">未通过</span></c:when>
                                  		<c:when test="${jybz.shzt  =='0'}"><span class="label label-warning label-mini">未审核</span></c:when>
                                  	</c:choose>
                                  </td>
<%--                                   <td><input type="hidden" name="shrq" value="${jybz.shrq }"/>${jybz.shrq }</td> --%>
<%--                                   <td><input type="hidden" name="shr" value="${jybz.shr }"/>${jybz.shr }</td> --%>
                                  <td><input type="hidden" name="kssj" value="${jybz.kssj }"/>${jybz.kssj }</td>
                                  <td><input type="hidden" name="jssj" value="${jybz.jssj }"/>${jybz.jssj }</td>
                                  <td>
                                 	  <label class="label_check" for="checkbox-02">
	                                 	<a href="javascript:void(0);" class="btn btn-primary" onClick="save('${jybz.id}','${id }');">提交</a>
									  </label>
                                  	  <a href="javascript:void(0);" class="btn btn-success" onClick="openwin('${jybz.bzbh}');">查看项目</a>
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
 function openwin(bzbh) {  
     window.location.replace("ypjybzxm?bzbh="+bzbh, "检验项目", "height=700, width=1000, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no") ; 
} 
 
 function save(id,viewId){
			location.href="<%=path%>/jygl/YjyJyxx/jyDetailView?ids="+id+"&id="+viewId;
 };
</script> 

  </body>
</html>

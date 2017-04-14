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

  <body style="width:1710px;">

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
                              检验项目
                          </header>
                          <form action="<%=path%>/jygl/YjyJyxx/ypjybzxm" id="myForm" style="margin-top: 7px;" method="post">
                          	  <span style="float:left; margin-top: 7px;margin-right: 10px; margin-left: 32px;font-weight:900;">检验项目名称:</span>
                          	  <input type="text" class="form-control" style="width: 200px;float:left;margin-bottom: 6px;" name="code" id="code" >
                          	  <input type="hidden" name="bzbh" id="bzbh" value="${bzbh }">
                          	  <a href="#" style="color:white;margin-left: 21px;" onclick="query();" class="btn btn-success">查询</a>
                          </form>
                          <table class="table table-striped table-advance table-hover" style="margin-top: 8px;border-top: 2px solid #ddd;">
                              <thead>
                              <tr>
                              	  <th style="width: 75px;">报告编号</th>
                                  <th style="width: 110px;">检验标准编号</th>
                                  <th style="width: 108px;">检验项目编号</th>
                                  <th style="width: 107px;">检验项目名称</th>
                                  <th style="width: 74px;">计量单位</th>
                                  <th style="width: 74px;">项目类型</th>
                                  <th style="width: 77px;">项目要求</th>
                                  <th style="width: 100px;">标准最大值</th>
                                  <th style="width: 91px;">标准最小值</th>
                                  <th style="width: 80px;">评定用语</th>
                                  <th style="width: 50px;">单价</th>
                                  <th style="width: 115px;">检验依据及方法</th>
                                  <th style="width: 77px;">评定方式</th>
                                  <th style="width: 90px;">默认检验员</th>
                                  <th style="width: 90px;">最低检出限</th>
                                  <th style="width: 52px;">排序</th>
                                  <th style="width: 82px;">子项目ID</th>
                                  <th style="width: 82px;">开始时间</th>
                                  <th style="width: 82px;">结束时间</th>
                                  <th>操作</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach var="jyxm" items="${jyxm }" varStatus="obj">
                              <tr>
                                  <td>${jyxm.bgbh }</td>
                                  <td>${jyxm.bzbh }</td>
                                  <td>${jyxm.xmbh } </td>
                                  <td>${jyxm.xmmc }</td>
                                  <td>${jyxm.jldw }</td>
                                  <td>${jyxm.xmlx }</td>
                                  <td>${jyxm.xmqb }</td>
                                  <td>${jyxm.bzmax }</td>
                                  <td>${jyxm.bxmin }</td>
                                  <td>${jyxm.pdyy }</td>
                                  <td>${jyxm.jyyj }</td>
                                  <td>${jyxm.dj }</td>
                                  <td>${jyxm.pdfs }</td>
                                  <td>${jyxm.mjyy }</td>
                                  <td>${jyxm.zdcx }</td>
                                  <td>${jyxm.xmpx }</td>
                                  <td>${jyxm.zxm_id }</td>
                                  <td>${jyxm.kssj }</td>
                                  <td>${jyxm.jssj }</td>
                                  <td>
	                                  <label class="label_check" for="checkbox-02">
	                                 	 <input name="sample-checkbox-02" id="checkbox-02" value="1" type="checkbox" /> 选择
								      </label>
                                  </td>
                              </tr>
                            </c:forEach>
                              </tbody>
                          </table>
                      </section>
					  <div style="text-align:center">
                        <div class="panel-body">
                              <button type="button" class="btn btn-primary" onClick="javascript:window.location.replace('ypjy.html');window.close();">提交</button>
							<!-- <button type="button" class="btn btn-success" onclick="history.go(-1)">返回</button>  -->
                            <button type="button" class="btn btn-success" onClick="javascript:window.location.replace('ypjybz.html');">返回</button> 
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

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="js/respond.min.js" ></script>

    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>


  </body>
</html>

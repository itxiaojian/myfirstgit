<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
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
    <script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>

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

  <body style="width:2100px;">

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
                              设备信息表
                          </header>
                          <form action="<%=path%>/jygl/YjyJyxx/ypsbxx" id="myForm" style="margin-top: 7px;" method="post">
                          	  <span style="float:left; margin-top: 7px;margin-right: 10px; margin-left: 32px;font-weight:900;">设备名称:</span>
                          	  <input type="text" class="form-control" style="width: 200px;float:left;margin-bottom: 6px;" name="code" id="code" >
                          	  <a href="#" style="color:white;margin-left: 21px;" onclick="query();" class="btn btn-success">查询</a>
                          </form>
                          <form action="" name="Form" id="Form" method="post">
                          <input type="hidden" name="num" id="num" value="1">
                          <table class="table table-striped table-advance table-hover" style="margin-top: 8px;border-top: 2px solid #ddd;">
                          
                              <thead>
                              <tr>
<!--                                   <th style="width:88px;">设备编号 </th> -->
                                  <th>设备条形码</th>
                                  <th class="hidden-phone" style="width:98px;">设备名称</th>
<!--                                   <th style="width:92px;">设备型号</th> -->
                                  <th style="width: 77px;">设备级别</th>
                                  <th style="width: 90px;">使用科室</th>
<!--                                   <th>出厂编号</th> -->
                                  <th>单位</th>
                                  <th>数量</th>
<!--                                   <th>检验周期</th> -->
<!--                                   <th>使用期限</th> -->
<!--                                   <th>上次检定日期</th> -->
<!--                                   <th>下次检定日期</th> -->
                                  <th>设备维护人</th>
                                  <th>开始日期</th>
                                  <th>结束日期</th>
                                  <th>使用状态</th>
                                  <th>使用数量</th>
                                  <th>使用环境</th>
                                  <th>使用人</th>
                                  <th>使用后状态</th>
                                  <th>使用日期</th>
                                  <th>操作</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach var="sbxx" items="${sbxx}" varStatus="obj">
                              	 <input type="hidden" name="id" value="${sbxx.id }"/>
                              <tr>
<%--                                   <td><input type="hidden" name="sbbh" value="${sbxx.sbbh }"/>${sbxx.sbbh }</td> --%>
                                  <td><input type="hidden" name="ewmbh" value="${sbxx.ewmbh }"/>${sbxx.ewmbh }</td>
                                  <td><input type="hidden" name="sbmc" value="${sbxx.sbmc }"/>${sbxx.sbmc }</td>
<%--                                   <td><input type="hidden" name="sbxh" value="${sbxx.sbxh }"/>${sbxx.sbxh }</td> --%>
                                  <td><input type="hidden" name="sbjb" value="${sbxx.sbjb }"/>${sbxx.sbjb }</td>
                                  <td><input type="hidden" name="syks" value="${sbxx.syks }"/>${sbxx.syks }</td>
<%--                                   <td><input type="hidden" name="ccbh" value="${sbxx.ccbh }"/>${sbxx.ccbh }</td> --%>
                                  <td><input type="hidden" name="dw" value="${sbxx.dw }"/>${sbxx.dw }</td>
                                  <td><input type="hidden" name="sl" value="${sbxx.sl }"/>${sbxx.sl }</td>
<%--                                   <td><input type="hidden" name="jyzq" value="${sbxx.jyzq }"/>${sbxx.jyzq }</td> --%>
<%--                                   <td><input type="hidden" name="syqx" value="${sbxx.syqz }"/>${sbxx.syqx }</td> --%>
<%--                                   <td><input type="hidden" name="scjdrq" value="${sbxx.scjdrq }"/>${sbxx.scjdrq }</td> --%>
<%--                                   <td><input type="hidden" name="xcjdrq" value="${sbxx.xcjdrq }"/>${sbxx.xcjdrq}</td> --%>
                                  <td><input type="hidden" name="sbwhr" value="${sbxx.sbwhr }"/>${sbxx.sbwhr }</td>
                                  <td><input type="hidden" name="kssj" value="${sbxx.kssj }"/>${sbxx.kssj }</td>
                                  <td><input type="hidden" name="jssj" value="${sbxx.jssj }"/>${sbxx.jssj }</td>
                                  <td><input type="hidden" name="syzt" value="${sbxx.syzt }"/>
                                  	<c:choose>
                                  		<c:when test="${sbxx.syzt  =='0'}"><span class="label label-success label-mini">正常</span></c:when>
                                  		<c:when test="${sbxx.syzt  =='1'}"><span class="label label-danger label-mini">报废</span></c:when>
                                  	</c:choose>
                                  </td>
                                  <td><input style="width:50px;" type="text" name="sysl1" /></td>
                                  <td><input style="width:100px;" type="text" name="syhj1" /></td>
                                  <td><input style="width:60px;" type="text" name="syr1" /></td>
                                  <td><select style="font-size:14px; height:23px;" name="syhzt1">
										<option selected="selected" value="0">正常</option>
										<option value="1">停用</option>
										<option value="2">报废</option>
									  </select>
								  </td>
								  <td>
								  	<input name="syrq1" style="width:150px;" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate"/>
								  </td>
                                  <td>
	                                  <label class="label_check" for="checkbox-02">
	                                 	<a href="javascript:void(0);" class="btn btn-primary" onClick="save('${sbxx.id}','${id }');">提交</a>
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

<script type="text/javascript">
    function save(id,viewId){
    	//alert(id);
    	            location.href="<%=path%>/jygl/YjyJyxx/jyDetailView?sbxxid="+id+"&id="+viewId;
//     	$.ajax({
// 			cache : true,
// 			type : "POST",
<%-- 			url : "<%=path%>/jygl/YjyJyxx/jyDetailView?sbxxid="+id+"&id="+viewId, --%>
//  			data : $('#Form').serialize(),// 你的formid
// 			async : false,
// 			error : function(request) {
// 				alert("保存失败，请联系管理员。");
// 			},
// 			success : function(data) {
// // 				if(data=='1'){
// 					alert('保存成功！');
// 					window.close();
// // 				}else{
// // 					alert("保存失败，请联系管理员。");
// // 				}
// 			}
// 		});
    };
  </script>

  </body>
</html>

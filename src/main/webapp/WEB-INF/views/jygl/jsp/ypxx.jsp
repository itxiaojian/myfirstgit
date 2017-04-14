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
	<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>

    <title>安徽省质检院综合业务管理平台</title>

    <!-- Bootstrap core CSS -->
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap-reset.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/style.css">
	<script type="text/javascript" src="<%=path%>/resources/js/wbm/jquery.qrcode.min.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css">

  </head>
  <script type="text/javascript">
  $(function(){
	  	var str = "${url}";
		$("#code").qrcode({
			width: 70,
			height:70,
			text: str
		});
	});
  </script>
  <style>
  .wbk{
  	border-left:0px;
  	border-top:0px;
  	border-right:0px;
  	border-bottom:1px;
  	box-shadow:0px 0px 0px;
  	margin-left: -9px;
    margin-top: 7px;
    font-size:14px;
  }
  
  .bc{
  	font-weight: 900;
  	text-align: right;
  	padding-top: 9px;
  }
  
  </style>
  <body>

  <section id="container1" >
      <!--sidebar end-->
      <!--main content start-->
      <section id="main-content1">
          <section class="wrapper1">
              <!-- page start-->

              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                           <header class="panel-heading">
                          </header>
                          <div class="panel-body">   
								   		 
                              <form class="form-horizontal tasi-form" method="get">
                              <c:forEach var="ypxx" items="${ypxx}" varStatus="obj">
                                  <div class="form-group">
                                  	 <label class="col-sm-2 bc" style="padding-top: 27px;">二维码编号：</label>
                                      <div class="col-sm-10">
                                          <input type="hidden" value="${ypxx.ewmbh }" id="ewmbh">
                                          <div id="code" style="width: 60px;height: 60px;padding-top: 2px;"></div>
                                      </div>
                                      <label class="col-sm-2 bc" style="padding-top: 27px;">样品编号：</label>
                                      <div class="col-sm-10" style="padding-top: 18px;">
                                          <input type="text" class="form-control wbk" value="${ypxx.ypbh }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc" style="padding-top: 27px;">报告编号：</label>
                                      <div class="col-sm-10" style="padding-top: 18px;">
                                          <input type="text"  class="form-control wbk" value="${ypxx.bgbh }" onfocus=this.blur()>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 bc">样品名称：</label>
                                      <div class="col-sm-10">
                                      	<input type="text" class="form-control wbk" value="${ypxx.ypmc }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">样品类型：</label>
                                      <div class="col-sm-10">
                                      	 	<input type="text" class="form-control wbk" value="${ypxx.yplx }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">检验类型：</label>
                                      <div class="col-sm-10">
                                           <input type="text" class="form-control wbk" value="${ypxx.jylx }" onfocus=this.blur()>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 bc">来样方式：</label>
                                      <div class="col-sm-10">
                                      <c:forEach items="${lyfs}" var="lyfs">
	                                       <c:choose>
		                                      <c:when test="${lyfs.zdz == ypxx.lyfs }">
	                                          	<input type="text"  class="form-control wbk" value="${lyfs.zdmc }" onfocus=this.blur()>
		                                      </c:when>
		                                    </c:choose>
	                                  </c:forEach>
                                      </div>
                                      <label class="col-sm-2 bc">所在城市：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.szcs }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">规格型号：</label>
                                      <div class="col-sm-10">
                                            <input type="text"  class="form-control wbk" value="${ypxx.ggxh }" onfocus=this.blur()>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 bc">生产日期\批次：</label>
                                      <div class="col-sm-10">
                                            <input type="text"  class="form-control wbk" value="${ypxx.scrqpc }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">样品等级：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.ypdj }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">样品状态：</label>
                                      <div class="col-sm-10">
                                             <input type="text"  class="form-control wbk" value="${ypxx.ypzt }" onfocus=this.blur()>
                                      </div>
                                  </div> 
                              	  <div class="form-group">
                                      <label class="col-sm-2 bc">抽样地点：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.cydd }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">抽样日期：</label>
                                      <div class="col-sm-10">
                                         <input class="form-control wbk" type="text" value="${ypxx.cyrq }" data-mask="9999-99-99" placeholder="" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">抽样基数：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.cyjs }" onfocus=this.blur()>
                                      </div>
                                  </div>  
                                  <div class="form-group">
                                      <label class="col-sm-2 bc">样品数量：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.ypsl }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">委托单位：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.wtdw }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">委托单位地址：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.wtdwdz }" onfocus=this.blur()>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 bc">受检单位：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.sjdw }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">受检单位地址：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.sjdwdz }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">联系人：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.lxr }" onfocus=this.blur()>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 bc">电话：</label>
		                           	  <div class="col-sm-10">
		                           	  <input type="text"  class="form-control wbk" value="${ypxx.dh }" onfocus=this.blur()>
		                           	  </div>
                                      <label class="col-sm-2 bc">邮编：</label>
                                      <div class="col-sm-10">
                                      	 <input type="text"  class="form-control wbk" value="${ypxx.yb }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">生产单位：</label>
                                      <div class="col-sm-10">
                                         <input type="text"  class="form-control wbk" value="${ypxx.scdw }" onfocus=this.blur()>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 bc">生产单位地址:</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.scdwdz }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">生产单位联系人：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.scdwlxr }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">生产单位电话：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.scdwdh }" onfocus=this.blur()>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 bc">生产单位邮编：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.scdwyb }" onfocus=this.blur()>
                                      </div>
                                  	  <label class="col-sm-2 bc">检验项目：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.jyxm }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">检验依据：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.jyyj }" onfocus=this.blur()>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                     <label class="col-sm-2 bc">到样日期：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.dyrq }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">报告发送方式：</label>
                                      <div class="col-sm-10">
	                                      <c:forEach items="${bgfsfs}" var="bgfsfs">
	                                      	<c:choose>
		                                      <c:when test="${bgfsfs.zdz == ypxx.bgfsfs }">
	                                          	<input type="text"  class="form-control wbk" value="${bgfsfs.zdmc }" onfocus=this.blur()>
		                                      </c:when>
		                                     </c:choose>
	                                       </c:forEach>
                                      </div>
                                      <label class="col-sm-2 bc">检验后须退库：</label>
                                      <div class="col-sm-10">
	                                      <c:forEach items="${yhxtk}" var="yhxtk">
		                                      	<c:choose>
			                                      <c:when test="${yhxtk.zdz == ypxx.yhxtk }">
		                                          	<input type="text"  class="form-control wbk" value="${yhxtk.zdmc }" onfocus=this.blur()>
			                                      </c:when>
			                                    </c:choose>
		                                   </c:forEach>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 bc">抽样人员：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.cyry }" onfocus=this.blur()>
                                      </div>
                                  	  <label class="col-sm-2 bc">检查封样人员：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.jcfyry }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">检验科室：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.jyks }" onfocus=this.blur()>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 bc">业务科室：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.ywks }" onfocus=this.blur()>
                                      </div>
                                  	  <label class="col-sm-2 bc">检验合同号：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.jyhth }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">检验费用：</label>
                                         <div class="input-group m-bot15 col-sm-10">
                                              <input type="text" class="form-control wbk" value="${ypxx.jyfy }" onfocus=this.blur()>
                                          </div>
                                  </div>
                                  <div class="form-group">
                                  	  <label class="col-sm-2 bc">检验费用待定：</label>
                                      <div class="col-sm-10">
	                                      <c:forEach items="${jyfydd}" var="jyfydd">
		                                      	<c:choose>
			                                      <c:when test="${jyfydd.zdz == ypxx.jyfydd }">
		                                          	<input type="text"  class="form-control wbk" value="${jyfydd.zdmc }" onfocus=this.blur()>
			                                      </c:when>
			                                    </c:choose>
			                               </c:forEach>
                                      </div>
                                      <label class="col-sm-2 bc">二维码图片：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.ewmtp }" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">样品检测状态：</label>
                                      <div class="col-sm-10">
                                      <c:forEach items="${ypjyzt}" var="ypjyzt">
                                      	<c:choose>
	                                      <c:when test="${ypjyzt.zdz == ypxx.ypjyzt }">
                                          	<input type="text"  class="form-control wbk" value="${ypjyzt.zdmc }" onfocus=this.blur()>
	                                      </c:when>
	                                    </c:choose>
			                          </c:forEach>
<%--                                           <input type="text"  class="form-control wbk" value="${ypxx.ypjyzt }" onfocus=this.blur()> --%>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                  	  <label class="col-sm-2 bc">样品登记人员：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.djry}" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">样品登记时间：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.djsj}" onfocus=this.blur()>
                                      </div>
                                      <label class="col-sm-2 bc">样品附件：</label>
                                      <div class="col-sm-10">
                                          <input type="text"  class="form-control wbk" value="${ypxx.fj}" onfocus=this.blur()>
                                      </div>
                                  </div>
<!--                                   <div class="form-group"> -->
<!--                                   	  <label class="col-sm-2 bc">检验科室编号：</label> -->
<!--                                       <div class="col-sm-10"> -->
<%--                                           <input type="text"  class="form-control wbk" value="${ypxx.jyksbh}" onfocus=this.blur()> --%>
<!--                                       </div> -->
<!--                                       <label class="col-sm-2 bc">业务科室编号：</label> -->
<!--                                       <div class="col-sm-10"> -->
<%--                                           <input type="text"  class="form-control wbk" value="${ypxx.ywksbh }" onfocus=this.blur()> --%>
<!--                                       </div> -->
<!--                                   </div> -->
                                  <div class="form-group">
                                  <label class="col-sm-2 bc">备注：</label>
                                      <div class="col-sm-13">
                                            <textarea class="form-control ckeditor wbk" name="editor1" rows="3" onfocus=this.blur()>${ypxx.bz }</textarea>
                                       </div>
                                       </div>
                              </c:forEach>
                              </form>
                          </div>
                      </section>
                     
					<div style="text-align:center; padding-bottom: 10px;">
                        <div class="panel-body">
                            <button type="button" class="btn btn-success" onClick="javascript:window.close();">关闭</button>
                          </div>
                      </div>

                  </div>
              </div>
              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              2015 &版权所有; 合肥智圣系统集成有限责任公司.
          </div>
      </footer>
      <!--footer end-->
  </section>
  </body>
</html>

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
        
        function close(){
        	/* var PAGESIZE = 20;
        	window.parent.constructionGrid.store.load({params:{start:0,limit:PAGESIZE}}); */
            window.parent.ACT_DEAL_WINDOW.close();
        }
        
    </script>
</head>
<body style="width:800px;">

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
                    <form action="<%=path%>/sys/home/Rwlb" id="myForm" style="margin-top: 7px;" method="post">
                    </form>
                    <form action="" name="Form" id="Form" method="post">
                        <table class="table table-striped table-advance table-hover" style="margin-top: 8px;border-top: 2px solid #ddd;">
                            <thead>
                            <tr>
                                <!-- <th style="display:none;">主键</th> -->
                                <th style="display:none;">用户编号</th>
                                <th style="width: 130px;">任务名称</th>
                                <th style="width:130px;">所属项目</th>
                                 <th style="width: 130px;">任务类型</th>
                                <th style="width:130px;">要求开始日期</th>
                                 <th style="width: 130px;">要求结束日期</th>
                                <th style="width:130px;">实际开始日期</th>
                                 <th style="width: 130px;">实际结束日期</th>
                                <th style="width:130px;">完成进度</th>
                                <th style="width:130px;">任务负责人</th>
                                 <th style="width: 130px;">任务来源</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="Rwlb" items="${Rwlb}" varStatus="obj">
                                <tr>
                                    <td style="display:none;"><input type="hidden" name="id" value="${Rwlb.id }"/>${Rwlb.id }</td>
                                    <td ><input type="hidden" name="rwmc" value="${Rwlb.rwmc }"/>${Rwlb.rwmc }</td>
                                    <td><input type="hidden" name="ssxm" value="${Rwlb.ssxm }"/>${Rwlb.ssxm }</td>
                                    <td ><input type="hidden" name="rwlx" value="${Rwlb.rwlx }"/>${Rwlb.rwlx }</td>
                                    <td><input type="hidden" name="yqksrq" value="${Rwlb.yqksrq }"/>${Rwlb.yqksrq }</td>
                                    <td ><input type="hidden" name="yqjsrq" value="${Rwlb.yqjsrq }"/>${Rwlb.yqjsrq }</td>
                                    <td><input type="hidden" name="sjksrq" value="${Rwlb.sjksrq }"/>${Rwlb.sjksrq }</td>
                                    <td ><input type="hidden" name="sjjsrq" value="${Rwlb.sjjsrq }"/>${Rwlb.sjjsrq }</td>
                                    <td><input type="hidden" name="wcjd" value="${Rwlb.wcjd }"/>${Rwlb.wcjd }</td>
                                     <td ><input type="hidden" name="rwfzr" value="${Rwlb.rwfzr }"/>${Rwlb.rwfzr }</td>
                                    <td><input type="hidden" name="rwly" value="${Rwlb.rwly }"/>${Rwlb.rwly }</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </form>
                </section>
                <div style="text-align:center">
                    <div class="panel-body">
                     <!-- <button type="button" class="btn btn-success" onClick="javascript:window.close();">返回</button> -->
                      <button type="button" class="btn btn-success" onClick="self.close">返回</button> 
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

    function save(yhbh,yhxm){
        window.opener.$("#btsr").val(yhxm);
        window.opener.$("#yhxm").val(yhbh);
        self.close();
    };

</script>
</body>
</html>

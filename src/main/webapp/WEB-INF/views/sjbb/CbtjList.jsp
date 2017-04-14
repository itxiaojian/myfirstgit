<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<%  String path = request.getContextPath();%>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
    <script type="text/javascript">var PATH = '<%=path%>';</script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="" />
    <meta name="author" content="Mosaddek" />
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina" />
    <link rel="shortcut icon" href="<%=path%>/resources/index/img/favicon.png" />

    <title>安徽省质检院综合业务管理平台</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/resources/index/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=path%>/resources/index/css/bootstrap-reset.css" rel="stylesheet" />
    <!--external css-->
    <link href="<%=path%>/resources/index/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="<%=path%>/resources/index/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" 
    type="text/css" media="screen"/>
    <link rel="stylesheet" href="<%=path%>/resources/index/css/owl.carousel.css" type="text/css" />
    <!-- Custom styles for this template -->
    <link href="<%=path%>/resources/index/css/style.css" rel="stylesheet" />
    <link href="<%=path%>/resources/index/css/style-responsive.css" rel="stylesheet" />
    
    <link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/jygl/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/icon.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/css/demo.css"/>
	
	<script type="text/javascript" src="<%=path%>/resources/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery.form.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/index/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/index/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/index/js/editable-table.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery.easyui.min.js"></script>
	
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
	<script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
    
    
    
    <script>
	function load() {
		 var url = "<%=path%>/sjbb/Cbtj/getCbtj";
		 var ksmc = document.getElementById("ksmc").value;
         var ksyf = document.getElementById("ksyf").value;
         var jsyf = document.getElementById("jsyf").value;
         if(ksyf==null || ksyf=="" || jsyf==null || jsyf==""){
        	 alert("请选择查询时间！");
        	 return false;
         }
//          if(ksmc==''&&ssyf==''){
//         	 alert('请至少添加一个条件查询');
//         	 return false;
//          }
		 $.ajax({
             cache: true,
             type: "POST",
             url: url,
             data: {ksmc: ksmc, ksyf: ksyf,jsyf:jsyf},
             async: false,
             error: function (request) {
                 alert("查询失败,请联系管理员。");
             },
             success: function (data) {
            	var del = $("#table");
     			del.remove();
             	var str="<table><thead><tr>"
                  	+"<td style='text-align:center;width:10%;'><b>科室名称</b></td>"
                  	+"<td style='text-align:center;'><b>工资薪金</b></td>"
                  	+"<td style='text-align:center;'><b>差旅费</b></td>"
                  	+"<td style='text-align:center;'><b>材料工器具</b></td>"
                  	+"<td style='text-align:center;'><b>办公费</b></td>"
                  	+"<td style='text-align:center;'><b>交通费</b></td>"
                  	+"<td style='text-align:center;'><b>招待费</b></td>"
                  	+"<td style='text-align:center;'><b>修缮检定</b></td>"
                  	+"<td style='text-align:center;'><b>培训费</b></td>"
                  	+"<td style='text-align:center;'><b>会议费</b></td>"
                  	+"<td style='text-align:center;'><b>邮电费</b></td>"
                    +"<td style='text-align:center;'><b>文印费</b></td>"
                    +"<td style='text-align:center;'><b>水电费</b></td>"
                    +"<td style='text-align:center;'><b>物管费</b></td>"
                    +"<td style='text-align:center;'><b>租赁费</b></td>"
                    +"<td style='text-align:center;'><b>技术服务费</b></td>"
                    +"<td style='text-align:center;'><b>业务协作费</b></td>"
                    +"<td style='text-align:center;'><b>咨询费</b></td>"
                    +"<td style='text-align:center;'><b>劳务费</b></td>"
                    +"<td style='text-align:center;'><b>外委检验费</b></td>"
                    +"<td style='text-align:center;'><b>折旧费</b></td>"
                    +"<td style='text-align:center;'><b>公务用车费</b></td>"
                    +"<td style='text-align:center;'><b>其他</b></td>"
                    +"<td style='text-align:center;'><b>合计</b></td>"
                    +"</tr></thead><tbody>";
             	for(var i=0;i<data.length;i++){
             		if(data[i].KSBH=='100110'||data[i].KSBH=='100130'||data[i].KSBH=='100210'||data[i].KSBH=='100220'||data[i].KSBH=='100260'||data[i].KSBH=='100270'||data[i].KSBH=='100280'||data[i].KSBH=='100250'||data[i].KSBH=='100240'||data[i].KSBH=='100230'){
           			str=str+"<tr style='color:green'>"
               		+"<td rowspan='2' style='text-align:left;vertical-align: middle;'><a onclick='ckmx("+data[i].KSBH+")' style='color:green' class='btn btn-xs btn-sucess'><b>"+ data[i].BMMC+"</b></a></td>"	
               		+"<td style='text-align:center;'><b>"+data[i].GZXJ+"</b></td>"
             		+"<td style='text-align:center;'><b>"+data[i].CLF+"</b></td>"
             		+"<td style='text-align:center;'><b>"+data[i].CLGQJ+"</b></td>"
             		+"<td style='text-align:center;'><b>"+data[i].BGF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].JTF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].ZDF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].XSJD+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].PXF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].HYF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].YD+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].WYF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].SDF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].WGF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].ZLF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].JF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].YWXZF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].ZXF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].LWF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].JYF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].ZJF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].GWYCF+"</b></td>"
                    +"<td style='text-align:center;'><b>"+data[i].QTFY+"</b></td>"
                    +"<td rowspan='2' style='text-align:center;vertical-align: middle;'><b>"+data[i].HJ+"</b></td>"
                    +"</tr>"
                    +"<tr style='color:green'>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].GZXJBFB)+"%</b></td>"
             		+"<td style='text-align:center;'><b>"+isNull(data[i].CLFBFB)+"%</b></td>"
             		+"<td style='text-align:center;'><b>"+isNull(data[i].CLGQJBFB)+"%</b></td>"
             		+"<td style='text-align:center;'><b>"+isNull(data[i].BGFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].JTFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].ZDFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].XSJDBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].PXFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].HYFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].YDBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].WYFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].SDFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].WGFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].ZLFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].JFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].YWXZFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].ZXFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].LWFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].JYFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].ZJFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].GWYCFBFB)+"%</b></td>"
                    +"<td style='text-align:center;'><b>"+isNull(data[i].QTFYBFB)+"%</b></td>"
                    +"</tr>";
             		}else{
             		str=str+"<tr>"
             		+"<td rowspan='2' style='text-align:center;vertical-align: middle;'><a onclick='ckmx("+data[i].KSBH+")' class='btn btn-xs btn-sucess'>"+ data[i].BMMC+"</a></td>"	
             		+"<td style='text-align:center;'>"+data[i].GZXJ+"</td>"
             		+"<td style='text-align:center;'>"+data[i].CLF+"</td>"
             		+"<td style='text-align:center;'>"+data[i].CLGQJ+"</td>"
             		+"<td style='text-align:center;'>"+data[i].BGF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].JTF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].ZDF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].XSJD+"</td>"
                    +"<td style='text-align:center;'>"+data[i].PXF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].HYF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].YD+"</td>"
                    +"<td style='text-align:center;'>"+data[i].WYF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].SDF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].WGF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].ZLF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].JF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].YWXZF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].ZXF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].LWF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].JYF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].ZJF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].GWYCF+"</td>"
                    +"<td style='text-align:center;'>"+data[i].QTFY+"</td>"
                    +"<td rowspan='2' style='text-align:center;vertical-align: middle;'>"+data[i].HJ+"</td>"
                    +"</tr>"
                    +"<tr>"
             		+"<td style='text-align:center;'>"+isNull(data[i].GZXJBFB)+"%</td>"
             		+"<td style='text-align:center;'>"+isNull(data[i].CLFBFB)+"%</td>"
             		+"<td style='text-align:center;'>"+isNull(data[i].CLGQJBFB)+"%</td>"
             		+"<td style='text-align:center;'>"+isNull(data[i].BGFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].JTFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].ZDFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].XSJDBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].PXFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].HYFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].YDBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].WYFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].SDFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].WGFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].ZLFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].JFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].YWXZFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].ZXFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].LWFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].JYFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].ZJFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].GWYCFBFB)+"%</td>"
                    +"<td style='text-align:center;'>"+isNull(data[i].QTFYBFB)+"%</td>"
                    +"</tr>";
             		}
             	} 
             	str=str+"</tbody><table>";
             	 var oTest = document.getElementById("Div1");
                 var newNode = document.createElement("table");
                 newNode.setAttribute('class', 'table table-hover personal-task table-striped table-bordered');
                 newNode.setAttribute('id', 'table');
                 newNode.innerHTML = str;
                 oTest.insertBefore(newNode, null);
            	 
             }
		 });
	}
	
	function isNull(string){
		if(string!=0||string!=''){
// 			alert(string);
// 			alert(string.toString().lastIndexOf('.'));
             if(string.toString().lastIndexOf('.')>0){
//             	 return string.toString().substring(0,string.toString().lastIndexOf('.')+3) 
            	 return string.toFixed(2)
             }else return string.toFixed(2)
		}else{
			return string
		}
	}
	
	function ckmx(ksmccx) {
		//var ksmccx = document.getElementById("ksmc").value;
        var ksyf = document.getElementById("ksyf").value;
        var jsyf = document.getElementById("jsyf").value;
		window.open('CbmxPage?ksmccx='+ksmccx+'&ksyf='+ksyf+'&jsyf='+jsyf,'成本明细标签','height=400px, width=1000px,top=200px, left=300px, toolbar=no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no');
	}
	
	function getExcelValue(){
		var ksmc=$('#ksmc').val();
		var ksyf = document.getElementById("ksyf").value;
        var jsyf = document.getElementById("jsyf").value;
		$.ajax({
            success: function () {
            		if(confirm("确定下载查询结果吗?")){
        				var fileName = ksyf+"至"+jsyf+"月成本统计报表";
            	    	var url = "exportCbtj?fileName="+fileName+"&ksmc="+ksmc+"&ksyf="+ksyf+"&jsyf="+jsyf;
            	    	url = encodeURI(url);
            	    	url = encodeURI(url);
            	    	window.open(url);
        			}
            }
	   });
	}
</script>   
  </head>

<body onload="load();" style="color: #333;">
<div style="display:none;">
    <ul class="tab-menu tab" id="tabMenuID_">
        <li class="tab-selected" title="成本信息统计">
            <a href="<%=path%>/sjbb/Cbtj/CbtjPage" target="content" onfocus="this.blur()"><span>成本信息统计</span></a>
        </li>
    </ul>
</div>
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <div class="row">
                  <div class="col-lg-19" style="margin-left: 5px; width: 100%;">
                      <!--work progress start-->
                      <section class="panel" style="overflow: auto; width: 120%">
                          <div class="panel-body" style="border-color:#fff;">
                              <div class="task-progress">
                                  <h1>各科室成本信息统计：</h1>
                                  <p></p>
                              </div>
                          </div>
                          <div class="form-group" style="height: 35px; margin-bottom: 0px;">
	                          <label class="col-sm-2 control-label" style="width: 6%;top: 6px; padding-left: 11px; padding-right: 0px; border-left-width: 0px;">科&nbsp;&nbsp;室:</label>
							  <div class="col-sm-10" style="width:15%;padding-left: 0px;">
							   <select class="form-control1 m-bot15" name="ksmc" id="ksmc" style="height: 27px;">
							            <option selected="selected" value="">请选择...</option>
								<c:forEach var="ksmc" items="${ksmc}" varStatus="obj">
										<option value="${ksmc.id}">${ksmc.bmmc}</option>
								</c:forEach>
					           </select>
							  </div>
			                  <label class="col-sm-2 control-label" style="width:6%;top: 6px;">开始月份:</label>
							  <div class="col-sm-10" style="width:15%">
							  <% Date date = new Date();
 							     SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM"); 
 							     String strdate = sdate.format(date); %> 
							  <input id="ksyf" name="ksyf" value="<%=strdate%>" style="height:28px;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width:6%;top: 6px;">结束月份:</label>
							  <div class="col-sm-10" style="width:15%">
							  <input id="jsyf" name="jsyf" value="<%=strdate%>" style="height:28px;" class="form-control Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM'})" />
							  </div>
							  <label class="col-sm-2 control-label" style="width: 5%;">
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="load();" type="button" data-toggle="modal">查询</a>
                                 <!-- <a class="btn btn-xs btn-success" style="margin-top: 2px; margin-left: 8%;" onclick="getExcelValue(table);" type="button" data-toggle="modal">导出Excel</a> -->
                              </label>
                              <label class="col-sm-2 control-label" style="width: 5%;">
                                 <a class="btn btn-xs btn-success" style="margin-top: 2px;" onclick="getExcelValue();" type="button" data-toggle="modal">导出Excel</a>
                              </label>
						  </div>
						  <div id="Div1" name="Div1" style="display:'none'"></div>
                      </section>
                      <!--work progress end-->
                  </div>
              </div>
	
  </body>
  
	<style>
			.form-control1 {
			background-color: #fff;
		    border: 1px solid #ccc;
		    border-radius: 4px;
		    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
		    color: #555;
		    display: block;
		    font-size: 12px;
		    height: 30px;
		    line-height: 1.42857;
		    padding: 5px 4px;
		    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
		    vertical-align: middle;
		    width: 100%;
		}
		    .form-control {
			background-color: #fff;
		    border: 1px solid #ccc;
		    border-radius: 4px;
		    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
		    color: #555;
		    display: block;
		    font-size: 12px;
		    height: 30px;
		    line-height: 1.42857;
		    padding: 6px 6px;
		    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
		    vertical-align: middle;
		    width: 100%;
		}
		.table > thead > tr > th, .table > tbody > tr > th, .table > tfoot > tr > th, .table > thead > tr > td, .table > tbody > tr > td, .table > tfoot > tr > td {
		    border-top: 1px solid #ddd;
		    line-height: 1.42857;
		    padding: 2px;
		    vertical-align: top;
		}
		.table-bordered > thead > tr > th, .table-bordered > thead > tr > td {
		    border-bottom-width: 1px;
		}
		</style>
  
</html>

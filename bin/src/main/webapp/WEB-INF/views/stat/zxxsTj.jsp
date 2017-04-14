<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在校学生统计</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, 
initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" > 
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<link href="<%=path%>/resources/js/stat/css/chosen.css" rel="stylesheet" />
<link href="<%=path%>/resources/js/stat/css/prism.css" rel="stylesheet" />
<link href="<%=path%>/resources/js/stat/css/style.css" rel="stylesheet" />
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/stat/js/chosen.jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/stat/js/prism.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<style type="text/css">
.even {
	background: white;
}

.odd {
	background: #F9F9F9;
}

table {
	*border-collapse: collapse; /* IE7 and lower */
	border-spacing: 0;
	width: 100%;
}

.bordered {
	border: solid #ccc 1px;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	-webkit-box-shadow: 0 1px 1px #ccc;
	-moz-box-shadow: 0 1px 1px #ccc;
	box-shadow: 0 1px 1px #ccc;
}

#thead {
	background-color: #dce9f9;
	background-image: -moz-linear-gradient(center top, #ebf3fc, #dce9f9);
	border-top: medium none;
	box-shadow: 0 1px 0 rgba(255, 255, 255, 0.8) inset;
	text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);
}

tbody tr:hover {
	background: #fbf8e9;
	-o-transition: all 0.1s ease-in-out;
	-webkit-transition: all 0.1s ease-in-out;
	-moz-transition: all 0.1s ease-in-out;
	-ms-transition: all 0.1s ease-in-out;
	transition: all 0.1s ease-in-out;
}

.bordered td,.bordered th {
	border-left: 1px solid #ccc;
	border-top: 1px solid #ccc;
	padding: 3px;
	text-align: left;
	
}

.bordered th {
	background-color: #dce9f9;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#ebf3fc),
		to(#dce9f9));
	background-image: -webkit-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: -moz-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: -ms-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: -o-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: linear-gradient(top, #ebf3fc, #dce9f9);
	-webkit-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	-moz-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	border-top: none;
	text-shadow: 0 1px 0 rgba(255, 255, 255, .5);
}

.bordered td:first-child,.bordered th:first-child {
	border-left: none;
}

.bordered th:first-child {
	-moz-border-radius: 6px 0 0 0;
	-webkit-border-radius: 6px 0 0 0;
	border-radius: 6px 0 0 0;
}

.bordered th:last-child {
	-moz-border-radius: 0 6px 0 0;
	-webkit-border-radius: 0 6px 0 0;
	border-radius: 0 6px 0 0;
}

.bordered th:only-child {
	-moz-border-radius: 6px 6px 0 0;
	-webkit-border-radius: 6px 6px 0 0;
	border-radius: 6px 6px 0 0;
}

.bordered tr:last-child td:first-child {
	-moz-border-radius: 0 0 0 6px;
	-webkit-border-radius: 0 0 0 6px;
	border-radius: 0 0 0 6px;
}

.bordered tr:last-child td:last-child {
	-moz-border-radius: 0 0 6px 0;
	-webkit-border-radius: 0 0 6px 0;
	border-radius: 0 0 6px 0;
}
</style>
</head>
<body>
	<!-- ECharts单文件引入 -->
	<script src="<%=path%>/resources/echarts/esl.js"></script>
	<script src="<%=path%>/resources/echarts/echarts.js"></script>
	<script type="text/javascript">
      var d1 = [];//x轴年月
	  var d2 = [];//学生数
	 // var oid="${oid}";
	 // var qseq="${qseq}";
    function showECharts(){
        $.ajax({
			  type: 'POST',
			  url: '<%=path%>/stat/echarts/getdata',
			 // data: {"oid":oid,"qseq":qseq},
			  async: false,  
			  dataType: 'json',
			  success: function(data){
			     $.each(data,function(i,value) {  
			         //年月日
					 d1.push(value.bmmc);
			         //学生数
			         d2.push(value.num);
			     });
			     require.config({
			         paths:{ 
			             echarts:'<%=path%>/resources/echarts/echarts',
			             'echarts/chart/bar' : '<%=path%>/resources/echarts/echarts-map',
			             'echarts/chart/line': '<%=path%>/resources/echarts/echarts-map',
			             'echarts/chart/map' : '<%=path%>/resources/echarts/echarts-map'
										}
									});

							require(
									[ 'echarts', 'echarts/chart/bar',
											'echarts/chart/line',
											'echarts/chart/map' ],
									function(ec) {
										//--- 折柱 ---
										var myChart = ec.init(document
												.getElementById('main'));
										myChart
												.setOption({
													 title : {
													        text: '在校学生统计',
													    },
													
													tooltip : {
														trigger : 'axis'
													},
													/*  legend : {
													    x:'center',y:'bottom',
														data : [ '在校人数统计' ]
													},  */
													grid:{
														x:'8%'
													},
													toolbox : {
														orient: 'vertical',
													    x: 'right',
													    y: 'center',
													    padding:12,
														show : true,
														feature : {
															mark : {
																show : true
															},
															dataView : {
																show : true,
																readOnly : false
															},
															magicType : {
																show : true,
																type : [
																		'line',
																		'bar' ]
															},
															restore : {
																show : true
															},
															saveAsImage : {
																show : true
															}
														}
													},

													calculable : true,
													yAxis : [ {
														type : 'value',
														boundaryGap : [ 0, 0.01 ],
													    name:"人数"
													} ],
													xAxis : [ {
														type : 'category',
														data : d1,
														boundaryGap : [ 0, 0.01 ],
														name:"院系"
														
													} ],
													series : [ {
														name : '在校学生统计',
														type : 'bar',
														data : d2,
														/* itemStyle : {
															normal : {
																color : function(
																		value) {
																	return "#"
																			+ 

("00000" + ((Math
																				

	.random() * 16777215 + 0.5) >> 0)
																				

	.toString(16))
																				

	.slice(-6);
																}
															}
														} */
													} ]
												});
									});
						}
					});
		}
	</script>
	<script type="text/javascript">
	  $(function() {
		  $(".chzn-select").chosen().change(function(){
				var html='';
				var param=$('.chzn-single').text();
				function test(){
				var str="";
				$('.chzn-select').find('option').each(function(){
					if($(this).text()==param){
						//alert(this.value);
						str +=this.value;
						//alert("str:"+str);
						return false;
					}
				});
				return str;
				}
			     $.ajax({
					url :'<%=path%>/stat/echarts/tofilter',
					data : {
						yx :test(),
							//$('.chzn-single').text(),
					},
					type : "get",
					success : function(data) {
                        $('#list').html('');
					var rst = eval(data);
					$.each(rst,function(i,value) { 
						if((i+1)%2==0){
                         html+="<tr class='even'><td>"+(i+1)+"</td>"+
                         "<td>"+value.bmmc+"</td>"+
                         "<td>"+value.num+"</td></tr>";
						}else{
							  html+="<tr class='odd'><td>"+(i+1)+"</td>"+
		                         "<td>"+value.bmmc+"</td>"+
		                         "<td>"+value.num+"</td></tr>";
						}				
						
					})
				     $('#list').append(html);
					},
					error : function() {
						alert("error");
					}
				  });
		        }); 
	    }); 
	</script>
</head>
<body onload="showECharts()">
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<!-- <div style="width: 100%; height: 10%; background: #FAFBFB;">
		<span style="opacity: 0.4;">在校学生统计</span>
	</div> -->
	<div id="main"
		style="height: 305px; border: 0px solid #ccc;width:100%"></div>
	<div id="table"
		style="height: 305px; border: 0px solid #ccc; padding: 10px;">
		<div>
		<select class="chzn-select" data-placeholder="院系"
			style="width:40%;" tabindex="1">
			<option value=""></option>
			<option value="">全部</option>
			<c:forEach var="data" items="${listBm}" varStatus="status">
			<option value="${data.bmbh}">${data.bmmc}</option>
			</c:forEach>
		</select>
	</div>
		<table class="bordered">
			<thead id="thead">
				<tr>
					<td height="20" style="width: 305px;">序号</td>
					<td height="20" style="width: 305px;">院系</td>
					<td height="20" style="width: 305px;">人数</td>
				</tr>
			</thead>
			<tbody id="list">
			<c:if test="${!empty list}">
				<c:forEach var="data" items="${list}" varStatus="status">
					<c:if test="${status.index % 2 == 0}">
						<tr class="even">
							<td><font size="2px">${status.count}</font></td>
							<td><font size="2px">${data.bmmc}</font></td>
							<td><font size="2px">${data.num}</font></td>
						</tr>
					</c:if>
					<c:if test="${status.index % 2 != 0}">
						<tr class="odd">
							<td style=""><font size="2px">${status.count}</font></td>
							<td><font size="2px">${data.bmmc}</font></td>
							<td><font size="2px">${data.num}</font></td>
						</tr>
					</c:if>
				</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>
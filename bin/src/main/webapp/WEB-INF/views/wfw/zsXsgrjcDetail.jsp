<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String path = request.getContextPath();%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1"></meta>
    <script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
	<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
    <script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
	<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="lightBlue"/>
	<link href="<%=path%>/resources/css/base.css" rel="stylesheet" />
	<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
	</script>
	<link href="<%=path%>/resources/css/tab-import.css" rel="stylesheet" style="text/css" />
	<link href="<%=path%>/resources/css/css.css" rel="stylesheet" style="text/css" />
	<title>我的奖惩</title>
	<style>
		.td_left {
			text-align: right;
			padding-left: 5px;
			width: 10%;
		}
		.td_right {
			text-align: right;
			padding-right: 5px;
			width: 10%;
		}
	</style>
  </head>
 
  <body style="overflow: auto;overflow-x: scroll;">
   <form action="" method="POST" id="Form1">  
   		<div class="tab-container">
				<!--我的奖惩-->
				<label style="font-size: 15pt;">微服务-奖惩查询-详细信息</label>
					<table width="90%" border="0" align="center" cellpadding="0" style="margin-top: 30px;margin-bottom: 30px; "
						cellspacing="0" class="content02">
						<tr class="bgcolor01">
								<td class="td_right" width="25%" align="center">
									学号：
								</td>
								<td class="td_left" width="25%" align="center">
									${map.xh }
								</td>
								<td class="td_right"width="25%" align="center">
									姓名：
								</td>
								<td class="td_left" width="25%" align="center">
									${map.xm }
								</td>
						</tr>
						<tr class="bgcolor02">
								<td class="td_right" width="25%" align="center">
									学年：
								</td>
								<td class="td_left" width="25%" align="center">
									${map.ksxn }
								</td>
								<td class="td_right"width="25%" align="center">
									学期：
								</td>
								<td class="td_left" width="25%" align="center">
									${map.ksxq }
								</td>
						</tr>
						<tr class="bgcolor01">
								<td class="td_right" width="25%" align="center">
									奖惩名称：
								</td>
								<td class="td_left" width="25%" align="center">
									${map.mc }
								</td>
								<td class="td_right"width="25%" align="center">
									奖惩事由：
								</td>
								<td class="td_left" width="25%" align="center">
									${map.jcsy }
								</td>
						</tr>
						<tr class="bgcolor02">
								<td class="td_right" width="25%" align="center">
									奖惩结果：
								</td>
								<td class="td_left" width="25%" align="center">
									${map.jcjg }
								</td>
								<td class="td_right"width="25%" align="center">
									奖惩金额：
								</td>
								<td class="td_left" width="25%" align="center">
									${map.je }
								</td>
						</tr>
						<tr class="bgcolor01">
								<td class="td_right" width="25%" align="center">
									备注：
								</td>
								<td class="td_left" width="75%" align="center" colspan="3">
									${map.bz }
								</td>
						</tr>
					</table> 
		</div>
	</form>		
  </body>
</html>

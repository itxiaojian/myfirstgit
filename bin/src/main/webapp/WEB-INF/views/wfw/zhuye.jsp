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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,user-scalable=no">

<meta content="no-cache" http-equiv="Pragma" />
<meta content="no-cache" http-equiv="Cache-Control" />
<meta content="0" http-equiv="Expires" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1,maximum-scale=3" />
<link type="text/css" rel="stylesheet" href="<%=path%>/resources/css/wfw.css" />
<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="lightBlue" />
<link href="<%=path%>/resources/css/base.css" rel="stylesheet" />
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></SCRIPT>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></SCRIPT>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>

<script src="<%=path%>/resources/js/TouchSlide.1.1.js"></script>

<title>微服务</title>
</head>
<body>
	<div style="display: none;">
		<ul class="tab-menu tab" id="tabMenuID_">
			<li class="tab-selected" title="微服务主页"><a href="#"
				target="content" onfocus="this.blur()"><span>微服务主页</span></a></li>
		</ul>
	</div>
	<div class="top">
		<img style="width: 100%;" src="<%=path%>/resources/img/wfw.png" />

		<div class="anniu" style="position: absolute; top: 3%; left: 87%;">
			<a href="#" style="float: right; width: 40px; height: 50px;"
				onclick="shouye()"> <img style="width: 70%"
				src="<%=path%>/resources/img/syan.png" />
			</a>
		</div>
	</div>

	<div id="content">

		<!-- 主要代码 Start ================================ -->
		<div id="leftTabBox" class="tabBox">
			<div class="bd">
			
			<!-- 第一页 -->
				<ul class="main">
					<!-- 第一行 -->
					<div class="content1">
						<!-- 考试成绩 -->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsXscj/toXscj?openId=${openId}"
								style="float: left" class="img">
								<img src="<%=path%>/resources/img/kscj.png" />
								<p>考试成绩</p>
							</a>
						</div>
						<!-- 个人奖惩查询 -->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsXsjc/toXsjc?openId=${openId}"
								class="img" style="width:50px;"> <img
								src="<%=path%>/resources/img/jc.png" />
								<p>个人奖惩</p>
							</a>
						</div>
						<!-- 个人工资查询  -->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsZggz/toZggzxx?openId=${openId}"
								class="img" style="width:50px;"> <img
								src="<%=path%>/resources/img/gz.png" />
								<p>个人工资</p>
							</a>
						</div>
						<!-- 图书借阅 -->
						<div class="er">
							<a href="<%=path%>/wfw/ZsTsjyxx/toTsjyxx?openId=${openId}"
								style="float: left;" class="img">
								<img src="<%=path%>/resources/img/tsjy.png" />
								<p>图书借阅</p>
							</a>
						</div>
					</div>

					<!-- 第二行 -->
					<div class="content1">
						<!-- 考试信息-->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsXsksapxx/toKsap?openId=${openId}"
								style="float: left" class="img">
								<img src="<%=path%>/resources/img/ksxx.png" />
								<p>考试信息</p>
							</a>
						</div>
						<!-- 实习信息 -->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsXssxqk/toXssxqk?openId=${openId}"
								class="img"> <img
								src="<%=path%>/resources/img/sxxx.png" />
								<p>实习信息</p>
							</a>
						</div>
						<!-- 缴欠费信息查询 -->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsXsjqfxx/toXsjqfxx?openId=${openId}"
								style="width: 60px" class="img"> <img
								src="<%=path%>/resources/img/jqfxx.png" />
								<p>缴欠费信息</p>
							</a>
						</div>
						<!-- 培养计划  -->
						<div class="er">
							<a href="<%=path%>/wfw/ZsPyfa/toPyfa?openId=${openId}"
								style="width:50px" class="img">
								<img src="<%=path%>/resources/img/pyjh.png" />
								<p>培养计划</p>
							</a>
						</div>
					</div>

					<!-- 第三行 -->
					<div class="content1">
						<!-- 学生贷款 -->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsXsdkxx/toXsdkxx?openId=${openId}"
								style="width:50px" class="img">
								<img src="<%=path%>/resources/img/xsdk.png" />
								<p>学生贷款</p>
							</a>
						</div>
						<!-- 监考信息 -->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsJsjkxx/toJsjkxx?openId=${openId}"
								style="width:50px" class="img"> <img
								src="<%=path%>/resources/img/jkxx.png" />
								<p>监考信息</p>
							</a>
						</div>
						<!-- 教学成果 -->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsJxcg/toJxcg?openId=${openId}"
								style="width:50px" class="img"> <img
								src="<%=path%>/resources/img/jxcg.png" />
								<p>教学成果</p>
							</a>
						</div>
						<!-- 学籍异动 -->
						<div class="er">
							<a href="<%=path%>/wfw/ZsXjyd/toXjyd?openId=${openId}"
								style="width:50px" class="img">
								<img src="<%=path%>/resources/img/xjyd.png" />
								<p>学籍异动</p>
							</a>
						</div>
					</div>
				</ul>
				
				
				<!-- 第二页 -->
				<ul class="main">
					<!-- 第四行 -->
					<div class="content1">
						<!-- 选修课信息-->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsXxkxx/toXxkxx?openId=${openId}"
								style="width:60px;float: left" class="img">
								<img src="<%=path%>/resources/img/xxk.png" />
								<p>选修课信息</p>
							</a>
						</div>
						<!-- 贫困生信息 -->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsPksxx/toPksxx?openId=${openId}"
								style="width:60px" class="img"> <img
								src="<%=path%>/resources/img/pks.png" />
								<p>贫困生信息</p>
							</a>
						</div>
						<!-- 科研项目 -->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsKyxm/toKyxm?openId=${openId}"
								style="width:50px" class="img"> <img
								src="<%=path%>/resources/img/kyxm.png" />
								<p>科研项目</p>
							</a>
						</div>
						<!-- 一卡通信息 -->
						<div class="er">
							<a href="<%=path%>/wfw/ZsYktxx/toYktxx?openId=${openId}"
								style="width:60px" class="img">
								<img src="<%=path%>/resources/img/ykt.png" />
								<p>一卡通信息</p>
							</a>
						</div>
					</div>

					<!-- 第五行 -->
					<div class="content1">
						<!-- 评教信息-->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsPjxx/toPjxx?openId=${openId}"
								style="width:50px" class="img">
								<img src="<%=path%>/resources/img/Pjxx.png" />
								<p>评教信息</p>
							</a>
						</div>
						<!-- 教师课表 -->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsKb/toJskb?openId=${openId}"
								style="width:50px" class="img"> <img
								src="<%=path%>/resources/img/jskb.png" />
								<p>教师课表</p>
							</a>
						</div>
						<!-- 个人课表 -->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsKb/toXskb?openId=${openId}"
								style="width:50px" class="img"> <img
								src="<%=path%>/resources/img/xskb.png" />
								<p>个人课表</p>
							</a>
						</div>
						<!-- 班级课表信息 -->
						<div class="er">
							<a href="<%=path%>/wfw/ZsKb/toBjkb?openId=${openId}"
								style="width:60px" class="img">
								<img src="<%=path%>/resources/img/bjkb.png" />
								<p>班级课表</p>
							</a>
						</div>
					</div>

					<!-- 第六行 -->
					<div class="content1">
						<!-- 图书分类查询 -->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsTsfl/toTsfl?openId=${openId}"
								style="width:60px" class="img">
								<img src="<%=path%>/resources/img/tsfl.png" />
								<p>图书分类</p>
							</a>
						</div>
						<!-- 教室查询-->
						<div class="yi">
							<a href="<%=path%>/wfw/ZsJscx/toJscx?openId=${openId}"
								style="width:50px" class="img"> <img
								src="<%=path%>/resources/img/jscx.png" />
								<p>教室查询</p>
							</a>
						</div>
						<!-- 四六级查询 -->
						<div class="yi">
							<a
								href="http://www.iweizhijia.com/mobile/cet/index/token/BgAKDUUGW2pQWQ9WV1QJAFFWVgVOLm8FCV8HWg--"
								style="width:60px" class="img"> <img
								src="<%=path%>/resources/img/sljks.png" />
								<p>四六级查询</p>
							</a>
						</div>
						<!-- 宿舍查询-->
						<div class="er">
							<a href="<%=path%>/wfw/ZsSscx/toSscx?openId=${openId}"
								style="width:50px" class="img">
								<img src="<%=path%>/resources/img/sscx.png" />
								<p>宿舍查询</p>
							</a>
						</div>
					</div>
				</ul>

			</div>
		</div>
		<!-- 主要代码 End ================================ -->

	</div>
	<div class="bottom1">
    <!-- 滑动标点 
    <ul class="section-btn">
      <li class="on"></li>
	  <li></li>
    </ul>-->
       <div class="bottom-hd">
         <img class="aaa" src="<%=path%>/resources/img/laba.png"></img><span class="xytz" style="float:left;">校园通知</span>
         <a class="xytz" style="float:right;"  href=""> 更多</a>
       </div>
       <div class="bottom-bd" >
       <ul class="ul">
         <li class="li">
           <span class="-list01-i-prefix mute"  ></span>
           <span class="xytz" style="float:left; ">没有新消息</span>
         </li>
       </ul>
       </div>
    </div>
    <div class="bottom2">
       <div class="bottom-hd" >
         <img class="aaa" src="<%=path%>/resources/img/xiaoxi.png"></img><span class="xytz" style="float:left;">校园短信</span>
         <a class="xytz" style="float:right;"  href=""> 更多</a>
       </div>
     <div class="bottom-bd">
       <ul class="ul">
         <li class="li">
           <span class="-list01-i-prefix mute"></span>
           <span class="xytz" style="float:left;margin-left: 0;">没有新消息</span>
         </li>
       </ul>
       </div>
    </div>

	<div class="footer">
<div class="footer-bottom" data-role="none" style="width: 100%;font-size:100%">
    copyright 2015黄山学院
</div>
</div>

<script type="text/javascript">
         //滑动翻页
         TouchSlide({
	         slideCell : "#leftTabBox",
	         effect : "leftLoop"
           });

	//翻页小点点
	var i=0;
    var $btn = $('.section-btn li');
    i++;if(i==$btn.length){i=0};
    i--;if(i<0){i=$btn.length-1};
    
    /* 返回首页 */
    function shouye() {
        WeixinJSBridge.call("closeWindow");
    }
</script>
</body>
</html>

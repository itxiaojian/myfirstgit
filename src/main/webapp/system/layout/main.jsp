<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<% String path = request.getContextPath();%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!--     <meta name="viewport" content="width=device-width, initial-scale=1.0"/> -->
<!--     <meta name="description" content=""/> -->
<!--     <link rel="shortcut icon" href="img/favicon.png"/> -->
 
    <title>${setting['app'] }</title>

    <!-- Bootstrap core CSS -->
	
    <link href="<%=path%>/resources/index/css/bootstrap.min.css" rel="stylesheet"></link>
    <link href="<%=path%>/resources/index/css/bootstrap-reset.css" rel="stylesheet"></link>
	
    <!--external css-->
    <link href="<%=path%>/system/layout/css/font-awesome.css" rel="stylesheet" />
    <link href="<%=path%>/system/layout/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="<%=path%>/resources/index/css/owl.carousel.css" type="text/css"></link>
    <!-- Custom styles for this template -->
    <link href="<%=path%>/resources/index/css/style.css" rel="stylesheet"></link>
    <link href="<%=path%>/resources/index/css/style-responsive.css" rel="stylesheet" />
    
    <link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="lightBlue"/>
	<link href="<%=path%>/system/layout/skin/style.css" rel="stylesheet" type="text/css" id="skin"  skinPath="system/layout/skin/"/>
<%--     <link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/> --%>
<%-- 	<link href="<%=path%>/libs/skins/lightBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="lightBlue"/> --%>
<%-- 	<link href="<%=path%>/system/layout/skin/style.css" rel="stylesheet" type="text/css" id="skin"  skinPath="system/layout/skin/"/> --%>
    <script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
    <script type="text/javascript" src="<%=path%>/libs/js/main.js"></script>
    
    <!--引入弹窗组件start-->
	<script type="text/javascript" src="<%=path%>/libs/js/popup/drag.js"></script>
	<script type="text/javascript" src="<%=path%>/libs/js/popup/dialog.js"></script>
	<!--引入弹窗组件end-->
    <script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
    
    <script type="text/javascript">
    
	function start() {
		
		
		$.ajax( {  
		    url:'<%=path%>/cps/process/taskXN/getPendPoolListSize',// 跳转到 action  
		    type:'POST',  
		    timeout : 90000, //超时时间设置，单位毫秒
		    cache:false,  
		    dataType:'json',  
		    success:function(data) {
		    	
		    	$("span[name='mytasknum']").each(function() {
	        		$(this).text(data.size0+data.size1+data.size2+data.size3+data.size4+data.size5+data.sfsize);
        		}); 
		        if(data.size0 !="0" ){
		        	$("span[name='size0']").each(function() {
		        		$(this).html("<li><a  href='<%=path%>/cps/process/taskXN/pendWorkPoolIndex?ypcs=0' target='content'><span class='label label-warning'><i class='icon-bell'></i></span> 您有 <span style='color:red'>"+data.size0+" 条任务分配</span>需要处理!<span class='small italic' name='mytasknum2'></span></a></li>");
	        		});
		        }else{
		        	$("span[name='size0']").each(function() {
	        		});  
		        }
		        if(data.size1 !="0" ){
		        	$("span[name='size1']").each(function() {
		        		$(this).html("<li><a  href='<%=path%>/cps/process/taskXN/pendWorkPoolIndex?ypcs=1' target='content'><span class='label label-warning'><i class='icon-bell'></i></span> 您有 <span style='color:red'>"+data.size1+" 条报告编制任务</span>需要处理!<span class='small italic' name='mytasknum2'></span></a></li>");
	        		});
		        }else{
		        	$("span[name='size1']").each(function() {
	        		});  
		        }
		        if(data.size2 !="0" ){
		        	$("span[name='size2']").each(function() {
		        		$(this).html("<li><a  href='<%=path%>/cps/process/taskXN/pendWorkPoolIndex?ypcs=2' target='content'><span class='label label-warning'><i class='icon-bell'></i></span> 您有 <span style='color:red'>"+data.size2+" 条报告审批任务</span>需要处理!<span class='small italic' name='mytasknum2'></span></a></li>");
	        		});
		        }else{
		        	$("span[name='size2']").each(function() {
	        		});  
		        }
		        if(data.size3 !="0" ){
		        	$("span[name='size3']").each(function() {
		        		$(this).html("<li><a  href='<%=path%>/cps/process/taskXN/pendWorkPoolIndex?ypcs=3'  target='content'><span class='label label-warning'><i class='icon-bell'></i></span> 您有 <span style='color:red'>"+data.size3+" 条报告批准任务</span>需要处理!<span class='small italic' name='mytasknum2'></span></a></li>");
	        		});
		        }else{
		        	$("span[name='size3']").each(function() {
	        		});  
		        }
		        if(data.size4 !="0" ){
		        	$("span[name='size4']").each(function() {
		        		$(this).html("<li><a  href='<%=path%>/cps/process/taskXN/pendWorkPoolIndex?ypcs=4'  target='content'><span class='label label-warning'><i class='icon-bell'></i></span> 您有 <span style='color:red'>"+data.size4+" 条报告接收任务</span>需要处理!<span class='small italic' name='mytasknum2'></span></a></li>");
	        		});
		        }else{
		        	$("span[name='size4']").each(function() {
	        		});  
		        }
		        if(data.size5 !="0" ){
		        	$("span[name='size5']").each(function() {
		        		$(this).html("<li><a  href='<%=path%>/cps/process/taskXN/pendWorkPoolIndex?ypcs=5'  target='content'><span class='label label-warning'><i class='icon-bell'></i></span> 您有 <span style='color:red'>"+data.size5+" 条报告归档任务</span>需要处理!<span class='small italic' name='mytasknum2'></span></a></li>");
	        		});
		        }else{
		        	$("span[name='size5']").each(function() {
	        		});  
		        }
		        
		        if(data.sfsize !="0" ){  
		        	$("span[name='mysfnum1']").each(function() {
		        		$(this).html("<li><a  href='<%=path%>/cwgl/YcwBgsf/BgsfPage.*'  target='content'><span class='label label-warning'><i class='icon-bell'></i></span> 您有 <span style='color:red'>"+data.sfsize+" 条收费信息任务</span>需要处理!<span class='small italic' name='mytasknum2'></span></a></li>");
	        		});
		        }else{
		        	$("span[name='mysfnum1']").each(function() {
	        		});  
		        }
		        
		     },  
		     error : function() {  
		          //alert("异常,请先刷新页面，如若不行，再联系管理员！");  
		     }  
		});
	}
    	
    	function toRight(url){
    		top.content.location=url;
    	}
    	function closeRight(){
    		if(document.getElementById("sidebar").display=='none'){
    			document.getElementById("sidebar").display='block';
    			document.getElementById("main-content").style.marginLeft='16%';
    			document.getElementById("wrapper").style.width='85%';
    			document.getElementById("content").width='100%';
    		}else{
	    		document.getElementById("sidebar").display='none';
	    		document.getElementById("sidebar").style.marginLeft='-16%';
	    		document.getElementById("wrapper").style.width='100%';
    			document.getElementById("content").width='100%';
    		}
    	}
    	function displayNav(tabNav){
    		try{
    			document.getElementById("tabMenuID_").innerHTML = tabNav;
    			
    			$("#tabMenuID_ a").click(function(){
    				$("#tabMenuID_ li").each(function(){
    					$(this).removeClass("tab-selected");
    				} );
    				$(this).parent().addClass("tab-selected");
    			} );
    		}catch(e){alert(e);}
    	}
    	function bookmarksite(title, url){
    	    if (window.sidebar) // firefox
    	        window.sidebar.addPanel(title, url, "");
    	    else 
    	        if (window.opera && window.print) { // opera
    	            var elem = document.createElement('a');
    	            elem.setAttribute('href', url);
    	            elem.setAttribute('title', title);
    	            elem.setAttribute('rel', 'sidebar');
    	            elem.click();
    	        }
    	        else 
    	            if (document.all)// ie
    	                window.external.AddFavorite(url, title);
    	}
    	function backHome(){
    		document.getElementById("frmleft").contentWindow.homeHandler();
    	}

    	function getContentHeight() {
    		$("#tabContent").height($("#rbox_middleright").height() - 50);
    		return $("#rbox_middleright").height() - 30;
    	}

    	function getContentWidth() {
    		return $("#rbox_middleright").width();
    	}
    	function closeProgress() {
    	    try {
    	        if (top.progressFlag == 1) {
    	            top.Dialog.close();
    	            top.progressFlag = 0
    	        } else {
    	            if (top.progressFlag == 2) {
    	                top.hideSimpleProgress();
    	                top.progressFlag = 0
    	            }
    	        }
    	    } catch(a) {}
    	}

    	function windowClose(){
    		window.opener=null;
    		  window.open('', '_self'); //IE7必需的.
    		  window.close();
    		}

    		var callbacks = new Array();

    		function title(title) {
    			if ($("#_Title_" + (Dialog._dialogArray.length-1)).length != 0) {
    				$("#_Title_" + (Dialog._dialogArray.length-1)).show();
    				$("#_Title_"+ (Dialog._dialogArray.length-1)).text(title);
    			}
    		}
    		//{url:'',width:'',height:'',params:{id:'',other:''}}
    		function onView(config) {
    			config = config ||{};
    			
    			var width = 700;
    			var height = 500;
    			var title = "";
    			if (config.width)
    				width = config.width;
    			
    			if (config.title)
    				title = config.title;
    			
    			if (config.height)
    				height = config.height;
    			
    			var iframeName = "InnerFrameName" + Dialog._dialogArray.length;
    			
    			var url=config.url;
    			$("#postForm").empty();
    			var post = false;
    			var params = config.params||{};
    			for(p in params) {
    				var val = params[p];
    				if ($.isArray(val)){
    					url=url+'?';
    					for(var i = 0; i < val.length; i++){
    						$("#postForm").append('<input type="hidden" name="' + p + '" value="' + val[i] + '"/>');
	    					if(i<val.length-1){
		    					url=url+p+'='+val[i]+'&';
	    					}else{
	    						url=url+p+'='+val[i];
	    					}
    					}
//     					alert('abc');
    				} else {
    					$("#postForm").append('<input type="hidden" name="' + p + '" value="' + val + '"/>');	
    					url=url+'?'+p+'='+val;
    				}
    				post = true;
    			}
    			if (post) {
	    			Dialog.open({InnerFrameName:iframeName,URL:url,Title:title,Width:width,Height:height,ShowOkButton:false,ShowCancelButton:false,CancelEvent:closeView,ButtonAlign:"center"}); 
	    			callbacks[Dialog._dialogArray.length - 1] = config.callback;
    				$("#postForm").attr("action",config.url);
    				$("#postForm").attr("target",iframeName);
    				$("#postForm").submit();
    			} else {
//     				$("[name="+iframeName+"]").attr("src",config.url);
	    			Dialog.open({InnerFrameName:iframeName,URL:config.url,Title:title,Width:width,Height:height,ShowOkButton:false,ShowCancelButton:false,CancelEvent:closeView,ButtonAlign:"center"}); 
	    			callbacks[Dialog._dialogArray.length - 1] = config.callback;
    			}
    		}

    		var params = {};

    		function funCall() {
    				if (callbacks[Dialog._dialogArray.length - 1] != null) {
    					callbacks[Dialog._dialogArray.length - 1].call();
    					callbacks[Dialog._dialogArray.length - 1] = null;
    				}
    		}

    		function closeView() {
    			funCall();
    			if (Dialog._dialogArray.length == 0) {
    				params = {};
    			}				
    			if(Dialog._dialogArray[Dialog._dialogArray.length - 1] != null)
    				Dialog._dialogArray[Dialog._dialogArray.length - 1].close();
    		}

    		function put(name, value) {
    			params[name] = value;
    		}

    		function get(name) {
    			var val = params[name];
    			params[name] = null;
    			return val;
    		}
    		
    		
    		function openwin()
    		{
	    		OpenWindow=window.open("", "newwin", "height=250, width=250,toolbar=no,scrollbars="+scroll+",menubar=no");
	    		OpenWindow.document.write("<BODY BGCOLOR=#ffffff>")
	    		OpenWindow.document.write("<h1>Hello!</h1>")
	    		OpenWindow.document.write("New window opened!")
	    		OpenWindow.document.write("</BODY>")
	    		OpenWindow.document.write("</HTML>")
	    		OpenWindow.document.close()
    		}
    		    </script> 
    </script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
    
    <style type="">
    	#_Container_0 {
			background-color: white;
		}
		div.tabMenuDiv {
/* 		    border-bottom: 3px solid #80c0e7; */
		    width: 100%;
/* 		    padding-top: 5px; */
		}
		div.tabMenuDiv ul {
		    font-weight: bold;
		    height: 25px;
		    list-style-type: none;
/* 		    margin: 0 0 0 4px; */
		    overflow: hidden;
		    padding: 0;
		    width: 100%;
		}
		div.tabMenuDiv ul li.tab-selected {
		    background-color: #3f3f3f;
		    height: 26px;
		}
		div.tabMenuDiv ul LI {
		    float: left;
/* 		    margin: 0 0 0 3px; */
		    min-width: 84px;
		    width: 120px;
		}
		div.tabMenuDiv ul * {
		    line-height: 24px;
		}
		
		div.tabMenuDiv ul LI A {
		    display: block;
		    font-size: 12px;
		    height: 25px;
		    padding-left: 3px;
		    padding-right: 3px;
		    text-align: center;
		    text-decoration: none;
		    white-space: nowrap;
		    color: white;
		}
		
		div.tabMenuDiv ul * {
		    line-height: 24px;
		}
		
		menu.extended li a {
		    display: inline-block;
		    padding: ;
		    width: 100%;
		}
		
 		.photo:hover {
			background:#EE9309;
		} 
    </style>
  </head>

<!--   <body onload="start()"> -->
  <body>

  <section id="container" >
      <!--header start-->
      <header class="header white-bg">
            <div class="sidebar-toggle-box" onclick="closeRight();">
                <div data-original-title="切换导航" data-placement="right" class="icon-reorder tooltips"></div>
            </div>
            <!--logo start-->
            <a href="<%=path%>/system/layout/main.jsp" class="logo" title="返回首页"><img alt="综合业务管理平台" src="<%=path%>/system/layout/skin/zybt.png" style="margin-top: -8px" /></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#" style="background-color:#FFFFFF;margin-bottom:5px; margin-top:-5px;">
                             <i>
								<img alt="" src="<%=path%>/resources/index/img/renwu.png" style="width:35px; height:35px;">
							</i>
                            <span class="badge bg-success"></span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">您有 6 条任务</p>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="task-info">
                                        <div class="desc">任务分配</div>
                                        <div class="percent">40%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">完成40%</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="task-info">
                                        <div class="desc">业务审批</div>
                                        <div class="percent">60%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">完成60%</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="task-info">
                                        <div class="desc">业务督办</div>
                                        <div class="percent">87%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 87%">
                                            <span class="sr-only">完成87%</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="task-info">
                                        <div class="desc">工作检查</div>
                                        <div class="percent">33%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 33%">
                                            <span class="sr-only">完成33%</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="task-info">
                                        <div class="desc">报告审核</div>
                                        <div class="percent">45%</div>
                                    </div>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar"  role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
                                            <span class="sr-only">完成45%/span>
                                        </div>
                                    </div>

                                </a>
                            </li>
                            <li class="external">
                                <a href="#">查看所有</a>
                            </li>
                        </ul>
                    </li>
                    <!-- settings end -->
                    <!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#" style="background-color:#FFFFFF;margin-bottom:5px; margin-top:-5px;">
                            <i>
							<img alt="" src="<%=path%>/resources/index/img/tszf.png" style="width:35px; height:35px;"/>
							</i>
							
                            <span class="badge bg-important"></span>
                        </a>
                        <ul class="dropdown-menu extended inbox" id="tszf">
                            <div class="notify-arrow notify-arrow-red"></div>
                            <li style="width: 200px">
                                <p class="red" style="width: 235px">特殊字符</p>
                            </li>
                            <li style="width: 235px"  id="tszfnr">
                            	<c:forEach var="data" items="${context['resources.listtszf']}" varStatus="status">
							   		<span class="tszf${status.index}" style="cursor: pointer; display: inline-block; height: 16px;line-height: 16px;margin: 1px 1px;text-align: center; width: 35px;" onmouseover="openTszf('tszf${status.index}')">${data.TSZF}</span>
								</c:forEach>
                            </li>
                        </ul>
                    </li>
                    <!-- inbox dropdown end -->
                    <!-- notification dropdown start-->
                    <li id="header_notification_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#" style="background-color:#FFFFFF;margin-bottom:5px; margin-top:-5px;">
                            <i>
							<img alt="" src="<%=path%>/resources/index/img/tixing.png" style="width:35px; height:35px;">
							</i>
                            <span class="badge bg-warning" name="mytasknum"></span>
                        </a>
                        <ul class="dropdown-menu extended notification">
                            <div class="notify-arrow notify-arrow-yellow"></div>
                            <li>
                                <p class="yellow">您有 <span name="mytasknum"> 0 </span> 条提醒</p>
                            </li>
                            	<span name="size0"></span>
                                <span name="size1"></span>
                                <span name="size2"></span>
                                <span name="size3"></span>
                                <span name="size4"></span>
                                <span name="size5"></span>
                                <span name="mysfnum1"></span>
                            
                        </ul>
                    </li>
                    <!-- notification dropdown end -->
					<li style="background-color:#FFFFFF;margin-bottom:5px; margin-top:-15px;" >
							<i>
								<iframe allowtransparency="true" frameborder="0" width="145px" height="30px" scrolling="no" src="http://tianqi.2345.com/plugin/widget/index.htm?s=3&z=3&t=0&v=0&d=3&bd=0&k=000000&f=&q=1&e=1&a=1&c=54511&w=180&h=36&align=center"></iframe>
							</i>
							<i>
								<div style="text-align:center;padding:6px;font-style: normal;" >
									<script>
										var weekDayLabels = new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
										var now = new Date();
										var year=now.getFullYear();
										var month=now.getMonth()+1;
										var day=now.getDate()
										var currentime = year+"年"+month+"月"+day+"日 "+weekDayLabels[now.getDay()]
										document.write(currentime)
									</script>
								</div>
							</i>
					</li>
                </ul>
                <!--  notification end -->
            </div>
            <div class="top-nav ">
                <!--search & user info start-->
                <ul class="nav pull-right top-menu">
                    <li>
                       <a href="<%=path %>/system/layout/main.jsp" style="height: 45px;" title="返回首页"><img alt="" src="img/desk.png" style="margin-top: -5px"></img></a>
                    </li>
                    <!-- user login dropdown start-->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
<!--                             <img alt="" width="31px" height="31px" src="img/avatar-mini2.jpg"> -->
                            <img alt="" width="31px" height="31px" src="<%=path%>/system/login/images/icon11.png">
                            <span class="username"><sec:authentication property="principal.xm"/></span>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu extended logout">
                            <div class="log-arrow-up"></div>
<!--                             <li><a href="#"><i class=" icon-suitcase"></i>个人信息</a></li> -->
<!--                             <li><a href="#"><i class="icon-cog"></i> 设置</a></li> -->
                            <li style="width: 100%;"><a href="#"><i class="icon-bell-alt"></i> 通知</a></li>
                            <li><a href="javascript:;" onclick='top.Dialog.confirm("确定要退出系统吗?",function(){window.location="<%=path%>/j_spring_security_logout"});'><i class="icon-key"></i> 注销</a></li>
                        </ul>
                    </li>
                    <!-- user login dropdown end -->
				</ul>
                <!--search & user info end-->
            </div>
        </header>
      <!--header end-->
      <!--sidebar start-->
<aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
                 
                 <c:forEach var="fun" items="${context['resources.functionList']}" varStatus="status">
 					<c:if test="${fun.parentId=='0'}">
<!--  						<input type="hidden" id=""></input> -->
<%--  						<li><a href="javascript:;" target="rightFrame" onclick="toMenu(${fun.id});return false;"><img src="<%=path%>/system/layout/skin/${fun.iconcls}.png" title="工作台" /><h2>${fun.name}</h2></a></li> --%>
	                   	<sec:authorizeUrl id="${fun.id}">
 						<li class="sub-menu">
                      		<a href="javascript:;" >
	                          		<img src="<%=path%>/system/layout/skin/${fun.iconcls}.png" title="工作台" />
	                          		<span>${fun.name}</span>
                      		</a>
	                      	<ul class="sub">
	                      		<c:forEach var="subFun" items="${context['resources.functionList']}" varStatus="sub">
			                      		<c:if test="${subFun.parentId==fun.id}">
			                      			<sec:authorizeUrl id="${subFun.id}">
			                      			<c:if test="${subFun.url==''||subFun.url eq null}">
			                      				 <li class="sub-menu">
				                                      <a  href="javascript:;">
				                                      	<img src="<%=path%>/system/layout/skin/${subFun.iconcls}.png" title="工作台" />
	                          							<span>${subFun.name}</span>
	                          						  </a>
				                                      <ul class="sub">
				                                      	<c:forEach var="subFun2" items="${context['resources.functionList']}" varStatus="sub">
									                      		<c:if test="${subFun2.parentId==subFun.id}">
									                      			<sec:authorizeUrl id="${subFun2.id}">
									                      			<c:if test="${subFun2.url==''||subFun2.url eq null}">
									                      				 <li class="sub-menu">
										                                      <a  href="javascript:;">
										                                      	<img src="<%=path%>/system/layout/skin/${subFun2.iconcls}.png" title="工作台" />
							                          							<span>${subFun2.name}</span>
							                          						  </a>
										                                      <ul class="sub">
										                                      	<c:forEach var="subFun1" items="${context['resources.functionList']}" varStatus="sub1">
														                      		<c:if test="${subFun1.parentId==subFun2.id}">
														                      			<sec:authorizeUrl id="${subFun1.id}">
										                                          			<li><a href="javascript:;" onclick="toRight('<%=path%>${subFun1.url}');"><img src="<%=path%>/system/layout/skin/${subFun1.iconcls}.png" title="工作台" />${subFun1.name}</a></li>
										                                          		</sec:authorizeUrl>
										                                          	</c:if>
										                                         </c:forEach>
										                                      </ul>
										                                  </li>
									                      			</c:if>
									                      			<c:if test="${subFun2.url!=''&&subFun2.url != null}">
									                      				<li><a href="javascript:;" onclick="toRight('<%=path%>${subFun2.url}');"><img src="<%=path%>/system/layout/skin/${subFun2.iconcls}.png" title="工作台" />${subFun2.name}</a></li>
									                      			</c:if>
									                      			</sec:authorizeUrl>
									                      		</c:if>
							                      		</c:forEach>
				                                      </ul>
				                                  </li>
			                      			</c:if>
			                      			<c:if test="${subFun.url!=''&&subFun.url != null}">
			                      				<li><a href="javascript:;" onclick="toRight('<%=path%>${subFun.url}');"><img src="<%=path%>/system/layout/skin/${subFun.iconcls}.png" title="工作台" />${subFun.name}</a></li>
			                      			</c:if>
			                      			</sec:authorizeUrl>
			                      		</c:if>
	                      		</c:forEach>
				            </ul>
                      	</li>
	                    </sec:authorizeUrl>
 					</c:if>
 				</c:forEach>
                  <!--multi level menu end-->
              </ul>
              <!-- sidebar menu end-->
          </div> </aside>
          <!--sidebar end-->
          <!--main content start-->
          <div id="main-content" style="width: 100%;height: 100%;margin-left: 16%;">
              <div id="wrapper" class="wrapper" style="width: 85%;height: 87%;margin-top: 80px;">
<!--                   page content goes here -->
					<div class="tabMenuDiv" style="">
					<ul id="tabMenuID_" class="tab"></ul>
					<div class="clear"></div>
					</div>
					<iframe width="100%" height="100%" frameBorder=0 id="content" name="content" allowTransparency="true" src="<%=path%>/sys/home/index"></iframe>
              </div>
          </div>
          <!--main content end-->
          <!--footer start-->
<!--           <footer class="site-footer" style="position: absolute;  bottom: 0;right:0;"> -->
<!--               <div class="text-center"> -->
<!--                   <a href="#" class="go-top"> -->
<!--                       <i class="icon-angle-up"></i> -->
<!--                   </a> -->
<!--               </div> -->
<!--           </footer> -->
          <!--footer end-->
      </section>

      </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="<%=path%>/resources/index/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="<%=path%>/resources/index/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="<%=path%>/resources/index/js/jquery.scrollTo.min.js"></script>
    <script src="<%=path%>/resources/index/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="<%=path%>/resources/index/js/respond.min.js" ></script>

    <!--common script for all pages-->
    <script src="<%=path%>/resources/index/js/common-scripts.js"></script>
    
	<script type="text/javascript" src="jquery.zclip.js"></script>
    
	<script language="JavaScript">
	if (window.addEventListener) {
		window.addEventListener('onload', myTimer, false); //firefox
		window.addEventListener('load', myTimer, false);
	} else if (window.attachEvent) {
		window.attachEvent('onload', myTimer); //IE
	} 
	//window.attachEvent("onload", myTimer); //绑定到onload事件
	function myTimer() {
		start();
		window.setTimeout("myTimer()", 2000000);//设置循环时间
	}
	
</script>
  </body>
</html>

<script type="text/javascript">

function openTszf(str){
	$("."+str).zclip({
	    path: "ZeroClipboard.swf",
	    copy: function(){
	    return $(this).text();
	    },
	    beforeCopy:function(){/* 按住鼠标时的操作 */
	        //$(this).css("color","orange");
	    },
	    afterCopy:function(){/* 复制成功后的操作 */
	        //alert("复制成功");
	    }
	});
}  
</script>

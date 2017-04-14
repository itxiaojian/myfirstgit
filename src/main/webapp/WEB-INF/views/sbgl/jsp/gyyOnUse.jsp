<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/security.tld" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<% String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/system/login/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/formValidator/validateEngine.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/app.js"></script>
<script src="<%=path%>/libs/js/framework.js" type="text/javascript"></script>
<title>使用高影仪采集原始记录</title>
<script type="text/javascript" src="<%=path%>/resources/js/sbgl/icapturevideo.js"></script>
<script type="text/javascript">	
	//初始化，打开高拍仪
	function init(){
		try{
			Content = document.getElementById("content");//获取文本框对象
			//WMSelect = document.getElementById("WaterMarkSelect");//根据js的脚本内容，必须先获取object对象	
			Capture = document.getElementById("Capture");//根据js的脚本内容，必须先获取object对象
			SetColorMode(0);
			SetFileType(0)		
			ResSelect = document.getElementById("Resolution_Select");//获取分辨率select标签的object对象
		}catch(err){
			alert("未找到ICaptureVideo.ocx控件，请重新安装");
		}
	}
	function onbeforeunload()   
	{   
		Capture.CloseDeviceEx();
		//Capture.Dispose();
		window.event.returnValue="确定要退出本页吗？"; 
	}
</script>


<style type="text/css">


body {
	font: 100%/1.4 Verdana, Arial, Helvetica, sans-serif;
	background-color: #4E5869;
	margin: 0;
	padding: 0;
	color: #000;
}

/* ~~ 元素/标签选择器 ~~ */
ul, ol, dl { /* 由于浏览器之间的差异，最佳做法是在列表中将填充和边距都设置为零。为了保持一致，您可以在此处指定需要的数值，也可以在列表所包含的列表项（LI、DT 和 DD）中指定需要的数值。请注意，除非编写一个更为具体的选择器，否则您在此处进行的设置将会层叠到 .nav 列表。 */
	padding: 0;
	margin: 0;
}
h1, h2, h3, h4, h5, h6, p {
	margin-top: 0;	 /* 删除上边距可以解决边距会超出其包含的 div 的问题。剩余的下边距可以使 div 与后面的任何元素保持一定距离。 */
	padding-right: 15px;
	padding-left: 15px; /* 向 div 内的元素侧边（而不是 div 自身）添加填充可避免使用任何方框模型数学。此外，也可将具有侧边填充的嵌套 div 用作替代方法。 */
}
a img { /* 此选择器将删除某些浏览器中显示在图像周围的默认蓝色边框（当该图像包含在链接中时） */
	border: none;
}

/* ~~ 站点链接的样式必须保持此顺序，包括用于创建悬停效果的选择器组在内。 ~~ */
a:link {
	color:#414958;
	text-decoration: underline; /* 除非将链接设置成极为独特的外观样式，否则最好提供下划线，以便可从视觉上快速识别 */
}
a:visited {
	color: #4E5869;
	text-decoration: underline;
}
a:hover, a:active, a:focus { /* 此组选择器将为键盘导航者提供与鼠标使用者相同的悬停体验。 */
	text-decoration: none;
}

/* ~~ 此容器包含所有其它 div，并依百分比设定其宽度 ~~ */
.container {
	width: 99%;
	height: 99%;
	max-width: 1920px;/* 可能需要最大宽度，以防止此布局在大型显示器上过宽。这将使行长度更便于阅读。IE6 不遵循此声明。 */
	min-width: 760px;/* 可能需要最小宽度，以防止此布局过窄。这将使侧面列中的行长度更便于阅读。IE6 不遵循此声明。 */
	background-color: #FFF;
	margin: 0 auto; /* 侧边的自动值与宽度结合使用，可以将布局居中对齐。如果将 .container 宽度设置为 100%，则不需要此设置。 */
	overflow: hidden; /* 此声明将使 .container 清除其包含的所有浮动列。 */
}

/* ~~ 以下是此布局的列。 ~~ 

1) 填充只会放置于 div 的顶部和/或底部。此 div 中的元素侧边会有填充。这样，您可以避免使用任何“方框模型数学”。请注意，如果向 div 自身添加任何侧边填充或边框，这些侧边填充或边框将与您定义的宽度相加，得出 *总计* 宽度。您也可以选择删除 div 中的元素的填充，并在该元素中另外放置一个没有任何宽度但具有设计所需填充的 div。

2) 由于这些列均为浮动列，因此未对其指定边距。如果必须添加边距，请避免在浮动方向一侧放置边距（例如：div 中的右边距设置为向右浮动）。在很多情况下，都可以改用填充。对于必须打破此规则的 div，应向该 div 的规则中添加“display:inline”声明，以控制某些版本的 Internet Explorer 会使边距翻倍的错误。

3) 由于可以在一个文档中多次使用类（并且一个元素可以应用多个类），因此已向这些列分配类名，而不是 ID。例如，必要时可堆叠两个侧栏 div。您可以根据个人偏好将这些名称轻松地改为 ID，前提是仅对每个文档使用一次。

4) 如果您更喜欢在右侧（而不是左侧）进行导航，只需使这些列向相反方向浮动（全部向右，而非全部向左），它们将按相反顺序显示。您无需在 HTML 源文件中移动 div。

*/
.sidebar1 {
	float: left;
	width: 20%;
	background-color: #93A5C4;
	padding-bottom: 10px;
}
.content {
	padding: 10px 0;
	width: 60%;
	float: left;
}
.sidebar2 {
	float: left;
	width: 20%;
	background-color: #93A5C4;
	padding: 10px 0;
}

/* ~~ 此分组的选择器为 .content 区域中的列表提供了空间 ~~ */
.content ul, .content ol { 
	padding: 0 15px 15px 40px; /* 此填充反映上述标题和段落规则中的右填充。填充放置于下方可用于间隔列表中其它元素，置于左侧可用于创建缩进。您可以根据需要进行调整。 */
}

/* ~~ 导航列表样式（如果选择使用预先创建的 Spry 等弹出菜单，则可以删除此样式） ~~ */
ul.nav {
	list-style: none; /* 这将删除列表标记 */
	border-top: 1px solid #666; /* 这将为链接创建上边框 – 使用下边框将所有其它项放置在 LI 中 */
	margin-bottom: 15px; /* 这将在下面内容的导航之间创建间距 */
}
ul.nav li {
	border-bottom: 1px solid #666; /* 这将创建按钮间隔 */
}
ul.nav a, ul.nav a:visited { /* 对这些选择器进行分组可确保链接即使在访问之后也能保持其按钮外观 */
	padding: 5px 5px 5px 15px;
	display: block; /* 这将为链接赋予块属性，使其填满包含它的整个 LI。这样，整个区域都可以响应鼠标单击操作。 */
	text-decoration: none;
	background-color: #8090AB;
	color: #000;
}
ul.nav a:hover, ul.nav a:active, ul.nav a:focus { /* 这将更改鼠标和键盘导航的背景和文本颜色 */
	background-color: #6F7D94;
	color: #FFF;
}

/* ~~ 其它浮动/清除类 ~~ */
.fltrt {  /* 此类可用于在页面中使元素向右浮动。浮动元素必须位于其在页面上的相邻元素之前。 */
	float: right;
	margin-left: 8px;
}
.fltlft { /* 此类可用于在页面中使元素向左浮动。浮动元素必须位于其在页面上的相邻元素之前。 */
	float: left;
	margin-right: 8px;
}
.clearfloat { /* 如果从 .container 中删除了 overflow:hidden，则可以将此类放置在 <br /> 或空 div 中，作为 #container 内最后一个浮动 div 之后的最终元素 */
	clear:both;
	height:0;
	font-size: 1px;
	line-height: 0px;
}
.sidebar1 #TabbedPanels1 .TabbedPanelsContentGroup .TabbedPanelsContent.TabbedPanelsContentVisible table tr td {
	font-family: Times New Roman, Times, serif;
}
.hidden{
	display:none!important;
	visibility:hidden!important;
	}

.button1 {
    font-size: 12px;
    height: 30px;
    text-align: center;
    width: 54px!important;
}

</style>
<link href="<%=path%>/resources/css/SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/resources/css/SpryAssets/SpryValidationRadio.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/resources/css/SpryAssets/SpryCollapsiblePanel.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 7]>
<style>
.content { margin-right: -1px; } /* 此 1px 负边距可以放置在此布局中的任何列中，且具有相同的校正效果。 */
ul.nav a { zoom: 1; }  /* 缩放属性将为 IE 提供其需要的 hasLayout 触发器，用于校正链接之间的额外空白 */
</style>
<![endif]-->
<script src="<%=path%>/resources/css/SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script src="<%=path%>/resources/css/SpryAssets/SpryValidationRadio.js" type="text/javascript"></script>
<script src="<%=path%>/resources/css/SpryAssets/SpryCollapsiblePanel.js" type="text/javascript"></script>

</head>
<body onLoad="init()" onBeforeUnload="onbeforeunload()">
<script type="text/javascript" FOR="Capture" EVENT="GetImageName(szFileName)" >
	//test(szFileName);
	CatchContinuousEvent(szFileName);
	//ScanReady 是控件的事件，每扫描完一张，控件就会触发这个事件，
	//strFile是事件的参数，表示扫描完后的绝对路径
</script>
<body>

<div class="container">
  <div class="sidebar1">
    <div style="width: 99%;height: 99%;border: 1px solid black;float:left">
    <!-- end .sidebar1 -->
    <br style="font-size:9px"><table width="99%" border="0">
      <tr>
        <td width="36%"><input id="open" type="button" style="width:75px;height:30px;text-align:center; font-size:12px; " value="打开" onclick="OpenDevice(CammeraType.value)"/></td>
        <td width="64%"><select name="CammeraType" id="CammeraType" style="width:99%; font-size:12px">
          <option value ="0">文档摄像头</option>
          <option value ="1">人像摄像头</option>
        </select></td>
      </tr>
      <tr>
        <td><span style="font-size:12px">
          <input id="close" type="button" style="width:75px;height:30px;text-align:center; font-size:12px;" value="返回" onclick="CloseDeviceEx()"/>
        </span></td>
        <td><span style="font-size:12px">分辨率：
            <select id="Resolution_Select" name="Resolution" style="width:65%;" onchange="SetResIndex(Resolution_Select.value)">
            </select>
        </span><span style="font-size:12px"> </span></td>
      </tr>
    </table>
    <table width="99%" border="0">
      <tr>
        <td width="35%" rowspan="2"><input type="button" name="btnCapture" id="btnCapture" value="拍摄" style="font-size:12px; width:99%; height:60px;" onclick="CaptureToFile()"/></td>
        <td width="45%" height="31"><input type="checkbox" name="checkMultiSource" id="checkMultiSource"/>
        <label for="checkMultiSource" style="font-size:12px" >标记为多页源</label></td>
        <td width="20%" rowspan="2"><input type="button" name="btnMakeMultiPage" id="btnMakeMultiPage" value="提交保存" style="font-size:12px; width:99%;height:60px;" onclick="BtnCreateMultiPageFile()"/></td>
      </tr>
      <tr>
        <td height="26"><input type="checkbox" name="checkBarcode" id="checkBarcode" onclick="SetBarcode()"/>
        <label for="checkBarcode" style="font-size:12px; width:99%">条形码识别</label></td>
      </tr>
    </table>
<br style="font-size:9px">
<div id="TabbedPanels1" class="TabbedPanels" style="width:99%">
    <ul class="TabbedPanelsTabGroup">
      <li class="TabbedPanelsTab" tabindex="0">拍摄设置</li>
      <li class="TabbedPanelsTab" tabindex="0">水印</li>
      <li class="TabbedPanelsTab" tabindex="0">Base64</li>
      <li class="TabbedPanelsTab" tabindex="0">录制视频</li>
      <li class="TabbedPanelsTab" tabindex="0">设备</li>
      <li class="TabbedPanelsTab" tabindex="0">高级功能</li>
</ul>
      <div class="TabbedPanelsContentGroup">
        <div class="TabbedPanelsContent">
          <table width="99%" border="0">
            <tr>
              <td width="24%" rowspan="2"><span style=" font-size:12px;">保存格式</span></td>
              <td><span id="spryradio1"  style=" font-size:12px;">
                <label>
                  <input name="rgFileType" type="radio" id="rgFileType_0" onchange="SetFileType(0)" value="0" checked="checked"/>
                  jpg</label>
              </span></td>
              <td><input type="radio" name="rgFileType" value="1" id="rgFileType_1" onchange="SetFileType(1)"/>
                <span style="font-size:12px">bmp</span></td>
              <td><input type="radio" name="rgFileType" value="2" id="rgFileType_2" onchange="SetFileType(2)"/>
                <span style="font-size:12px">png</span></td>
            </tr>
            <tr>
              <td><input type="radio" name="rgFileType" value="3" id="rgFileType_3" onchange="SetFileType(3)"/>
                <span style="font-size:12px">tif</span></td>
              <td><label>
                <input type="radio" name="rgFileType" value="4" id="rgFileType_4" onchange="SetFileType(4)"/>
                <span style="font-size:12px">pdf</span></label></td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td><span style="font-size:12px">色彩模式</span></td>
              <td><span id="spryradio2"  style=" font-size:12px;">
                <label>
                  <input name="rgColorMode" type="radio" id="rgColorMode_0" value="0" checked="checked" onchange="SetColorMode(0)"/>
                  彩色</label>
              </span></td>
              <td><span style=" font-size:12px;">
                <label>
                  <input type="radio" name="rgColorMode" value="1" id="rgColorMode_1" onchange="SetColorMode(1)"/>
                  灰度</label>
              </span></td>
              <td><span id="spryradio"  style=" font-size:12px;">
                <label>
                  <input type="radio" name="rgColorMode" value="2" id="rgColorMode_2" onchange="SetColorMode(2)"/>
                  黑白</label>
              </span></td>
            </tr>
            <tr>
              <td colspan="4"><span style="font-size:12px">DPI</span>
                <input name="DPI" type="text" id="DPI" align="center" valign="middle" style="width:14%;border-top: 1px solid #808080;border-right: 1px solid #D4D0C8;border-bottom: 1px solid #D4D0C8;border-left: 1px solid #808080;" value="200" size="4" onchange="SetDPI(DPI.value)"/>
                <span style="font-size:12px">曝光度</span> <span style="font-size:12px">
                  <input name="setExposure" type="text" id="setExposure2" style="width:12%;border-top: 1px solid #808080;border-right: 1px solid #D4D0C8;border-bottom: 1px solid #D4D0C8;border-left: 1px solid #808080;" value="10" size="4" onblur="SetExposure(setExposure.value)" />
                  </span> <span style="font-size:12px">JPG质量</span><span style="font-size:12px">
                    <input name="JPGQuality" type="text" id="JPGQuality" style="width:12%;border-top: 1px solid #808080;border-right: 1px solid #D4D0C8;border-bottom: 1px solid #D4D0C8;border-left: 1px solid #808080;" value="80" size="4" onblur="SetJPGQuality(JPGQuality.value)" />
                  </span></td>
            </tr>
            <tr> </tr>
            <tr> </tr>
          </table>
        </div>
        <div class="TabbedPanelsContent">
          <table width="99%" border="0">
            <tr>
              <td width="18%"><span style="font-size:12px">类型</span></td>
              <td colspan="3"><span id="spryradio3 " style="font-size:12px">
                <label>
                  <input name="rgWaterMarkType" type="radio" id="rgWaterMarkType_0" value="0" checked="checked" onchange="SetWaterMark(-1)"/>
                  无水印</label>
                <label>
                  <input type="radio" name="rgWaterMarkType" value="1" id="rgWaterMarkType_1" onchange="SetWaterMark(0)"/>
                  文字</label>
                <label>
                  <input type="radio" name="rgWaterMarkType" value="2" id="rgWaterMarkType_2" onchange="SetWaterMark(1)"/>
                  图片</label>
              </span></td>
            </tr>
            <tr>
              <td><span style="font-size: 12px"></span><span style="font-size: 12px">内容</span></td>
              <td colspan="3"><input name="WaterContent" type="text" id="WaterContent" align="center" valign="middle" style="width:99%;border-top: 1px solid #808080;border-right: 1px solid #D4D0C8;border-bottom: 1px solid #D4D0C8;border-left: 1px solid #808080; font-size:12px" value="水印测试" size="4" /></td>
            </tr>
            <tr>
              <td><span style="font-size:12px">透明</span></td>
              <td><input name="WaterTran" type="text" id="WaterTran" align="center" valign="middle" style="width:99%;border-top: 1px solid #808080;border-right: 1px solid #D4D0C8;border-bottom: 1px solid #D4D0C8;border-left: 1px solid #808080; font-size:12px" value="50" size="4" /></td>
              <td><span style="font-size:12px">位置</span></td>
              <td><label for="sWaterMarkPos"></label>
                <select name="sWaterMarkPos" id="sWaterMarkPos" style="width:99%; font-size:12px">
                  <option value="0">左上</option>
                  <option value="1">右上</option>
                  <option value="2">左下</option>
                  <option value="3">右下</option>
                  <option value="4">中央</option>
                </select></td>
            </tr>
            <tr>
              <td><span style="font-size:12px">颜色</span></td>
              <td><input name="WaterColor" type="text" id="WaterColor" align="center" valign="middle" style="width:99%;border-top: 1px solid #808080;border-right: 1px solid #D4D0C8;border-bottom: 1px solid #D4D0C8;border-left: 1px solid #808080; font-size:12px" value="0xFF0000" size="8" /></td>
              <td><span style="font-size:12px">字号</span></td>
              <td><label for="WaterFontSize"></label>
                <input type="text" name="WaterFontSize" id="WaterFontSize" align="center" valign="middle" style="width:99%;border-top: 1px solid #808080;border-right: 1px solid #D4D0C8;border-bottom: 1px solid #D4D0C8;border-left: 1px solid #808080; font-size:12px" value="256" size="8" /></td>
            </tr>
          </table>
        </div>
        <div class="TabbedPanelsContent"><span style=" font-size:12px;">选择需要Base64编码的图片文件
          <input id="OpenDesFileForBase64" type="file" style="width:99%; font-size:12px" name="OpenDesFileForBase64" onchange="OpenDesFileForBase64()" />
          <br />
          <input id="base" type="button" style="width:99%;height:30px;text-align:center; font-size:12px" value="开始base64编码" onclick="GetBase64string()"/>
          </span> <br />
  &nbsp;</div>
        <div class="TabbedPanelsContent"><span class="AccordionPanelContent"> </span><span class="AccordionPanelContent"> </span>
          <table width="99%" border="0">
            <tr>
              <td width="63%"><input id="StartRecordingVideo" type="button" style="width:99%;height:30px;text-align:center; font-size:12px" value="开始录制" onclick="StartRecordingVideo()"/></td>
              <td width="37%"><input type="radio" name="rgVideoType" value="0" id="rgVideoType_0" onchange="SetVideoType(0)"/>
                <span style="font-size:12px">avi</span></td>
            </tr>
            <tr>
              <td><input id="StopRecordingVideo" type="button" style="width:99%;height:30px;text-align:center;font-size:12px" value="停止录制" onclick="StopRecordingVideo()"/></td>
              <td><input type="radio" name="rgVideoType" value="1" id="rgVideoType_1" onchange="SetVideoType(1)"/>
                <span style="font-size:12px">asf</span></td>
            </tr>
          </table>
        </div>
        <div class="TabbedPanelsContent">
          <input id="ocxVersion" type="button" style="width:48%;height:30px;text-align:center;font-size:12px" value="控件版本" onclick="GetOcxVersion()"/>
          <input id="deviceProperty" type="button" style="width:48%;height:30px;text-align:center;font-size:12px" value="属性页" onclick="ShowDevicePage()"/>
          <input id="BtnHID" type="button" style="width:48%;height:30px;text-align:center;font-size:12px" value="硬件码" onclick="BtnHID()" />
          <input id="deviceState" type="button" style="width:48%;height:30px;text-align:center;font-size:12px" value="设备状态" onclick="GetDeviceState()"/>
          <input id="BtnTriggerFocuse" type="button" style="width:48%;height:30px;text-align:center;font-size:12px" value="触发自动对焦" onclick="TriggerAutoFocuse()" />
<!--           <input id="BtnSetPara" type="button" style="width:48%;height:30px;text-align:center;font-size:12px" value="设置参数" onclick="SetVideoPara()"/> -->
<!--           <input id="BtnGetPara" type="button" style="width:48%;height:30px;text-align:center;font-size:12px" value="获取参数" onclick="GetVideoPara()"/> -->
        </div>
        <div class="TabbedPanelsContent">
          <p>
            <input type="checkbox" name="checkReduceShadow" id="checkReduceShadow" onclick="SetResuceShadow()"/>
          <span style="font-size: 12px">去除阴影</span>
          <input type="checkbox" name="checkRepairDistortion" id="checkRepairDistortion" onclick="SetRepairDistortion()"/>
            <label for="checkRepairDistortion"></label>
            <label for="checkReduceShadow"></label>
          <span style="font-size: 12px">文档变形修补</span></p>
          <p>
            <input type="submit" name="StartContinuous" id="StartContinuous" value="开始连续拍摄" onclick="StartContinuous()"/>
          </p>
        </div>
</div>
    </div>
    <br style="font-size:9px">
    <div id="CollapsiblePanel1" class="CollapsiblePanel" style="width:99%">
      <div class="CollapsiblePanelTab" tabindex="0">图像旋转</div>
      <div class="CollapsiblePanelContent"><span class="AccordionPanelContent">
        <input id="AngleLeft" type="button" class="button1" style="width:54px;height:30px;text-align:center; font-size:12px" value="左转" onclick="SetDeviceRotation(270)"/>
        <input id="AngleVertical" type="button" class="button1" style="width:54px;height:30px;text-align:center;font-size:12px" value="上下" onclick="SetDeviceRotation(180)"/>
        <input id="AngleRight" type="button" class="button1" style="width:54px;height:30px;text-align:center;font-size:12px" value="右转" onclick="SetDeviceRotation(90)"/>
        <input id="AngleDefault" type="button" class="button1" style="width:54px;height:30px;text-align:center;font-size:12px" value="恢复" onclick="SetDeviceRotation(0)"/>
      </span></div>  
</div>
    <div id="CollapsiblePanel2" class="CollapsiblePanel" style="width:99%">
        <div class="CollapsiblePanelTab" tabindex="0">切边方式</div>
        <div class="CollapsiblePanelContent"><span id="spryradio3" style="font-size:12px">
          <label>
            <input name="rgCutPageType" type="radio" id="rgCutPageType_0" value="0" checked="checked" onchange="SetCutPageType(0)"/>
            不切边</label>
          <label>
            <input type="radio" name="rgCutPageType" value="1" id="rgCutPageType_1" onchange="SetCutPageType(1)"/>
            自动切边</label>
          <label>
            <input type="radio" name="rgCutPageType" value="2" id="rgCutPageType_2" onchange="SetCutPageType(2)"/>
            自定义切边</label>
          <br />
        <span class="radioRequiredMsg">请进行选择。</span></span></div>
      </div>
<div id="CollapsiblePanel3" class="CollapsiblePanel" style="width:99%">
          <div class="CollapsiblePanelTab" tabindex="0">合并图像</div>
          <div class="CollapsiblePanelContent"><span id="spryradio4" style="font-size:12px">
            <label>
              <input name="rgMergeImages" type="radio" id="rgMergeImages_0" value="0" checked="checked" onchange="SetMergePageType(-1)"/>
              不合并</label>
            <label>
              <input type="radio" name="rgMergeImages" value="1" id="rgMergeImages_1" onchange="SetMergePageType(0)"/>
              左右合并</label>
            <label>
              <input type="radio" name="rgMergeImages" value="2" id="rgMergeImages_2" onchange="SetMergePageType(1)"/>
              上下合并</label>
            <br />
          <span class="radioRequiredMsg">请进行选择。</span></span></div>
        </div>
      <br style="font-size:9px">
      <span style="font-size:12px">操作内容<br />
      <textarea name="content" cols="30" rows="6" id="content" style="width:95%; border: 1 solid #888888;LINE-HEIGHT:18px;padding: 3px; font-size:12px"></textarea>
    </span>
  </div></div>
  <div class="content" align="center">
    <div style="width: 99%;height: 99%;border: 1px solid black;float:left" align="center">
		  <div style="width:99%;height:99%" align="center">
			<object id="Capture" style ="width: 99%;height: 550px;border: 5 gray solid;" align="middle" classid="clsid:9A73DB73-2CA3-478D-9A3F-7E9D6A8D327C" codebase="CaptureVideo.cab#version=1,7,9,0">
		    </object>
	    </div>
	</div>
    <!-- end .content --></div>
<div class="sidebar2">
  <div style="width: 99%;height: 99%;border: 1px solid black;float:left">
          <div class="zTreeDemoBackground left">
		    <ul id="treeDemo2" class="ztree">
		      <li><img id="preview1" alt="" name="pic1" style="width:99%; max-height: 185px"/></li>
		      <li><img id="preview2" alt="" name="pic2" style="width:99%; max-height: 185px"/></li>
		      <li><img id="preview3" alt="" name="pic3" style="width:99%; max-height: 185px"/></li>
	       	</ul>
			
  </div>
<!--     end .sidebar2 --></div> 
<!--   <!-- end .container --> </div>
        <form class="hidden" name="myForm" id="myForm" method="post" >
        <input type="text" class="hidden" id="id" name="id" readOnly=true value="${id}"/>
        <input type="text" class="hidden" id="path" readOnly=true value="${path}"/>
        </form>
<script type="text/javascript">
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
var spryradio1 = new Spry.Widget.ValidationRadio("spryradio1");
var spryradio2 = new Spry.Widget.ValidationRadio("spryradio2");
var CollapsiblePanel1 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel1");
var CollapsiblePanel2 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel2");
var CollapsiblePanel3 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel3");
var spryradio3 = new Spry.Widget.ValidationRadio("spryradio3");
var spryradio4 = new Spry.Widget.ValidationRadio("spryradio4");

function BtnCreateMultiPageFile() {
// 	alert(imgeId);
	
	if( imgeId == img){
	   	 alert('还未采集原始记录！');
	   	 return false;
	    }
	imgeId =imgeId-1;
// 	alert(imgeId);
    var id=$('#id').val();
    var ids=$('#id').val();
//     alert(id);
	 msg="确定提交？";
		if (confirm(msg)) {
			var url = '<%=path%>/sbgl/YSbXx/saveGyy?imgeId='+imgeId+'&szPostfix='+szPostfix+'&ids='+ids;
			$.ajax({
				cache : true,
				type : "POST",
				url : url,
				data : $('#myForm').serialize(),// 你的formid
				async : false,
				error : function(request) {
					alert("提交失败,请联系管理员。");
				},
				success : function(data) {
					alert('提交成功！');
					location.href="<%=path%>/sbgl/YSbXx/sbxxUpdateView?id="+id;
				}
			});
		}
	
}

</script>
</body>
</html>

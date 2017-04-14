<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /><meta content="edge" http-equiv="X-UA-Compatible" /><meta name="viewport" content="height=device-height,width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no" /><title>
	我要吐槽
</title>
    <script src="js/jquery.js"></script>
    <script src="js/json2.js"></script>
    <link href="css/page.css" rel="stylesheet" /><link href="css/tucao.css" rel="stylesheet" />
    <style>
        #replay {z-index:1000;display:none;}
    </style>
</head>
<body>
    <div id="test"></div>
    <div id="header" class="header">
        <img src="img/wytc1.png" style="width:100%;" />
    </div>
    <div class="tctotal">
        <div class="tctotal_left"><span id="tc_ListCount" class="tctotalnum">0</span> 话题</div>
        <div class="tctotal_right"><span id="tc_AccessCount" class="tctotalnum">0</span> 访问</div>
    </div>
    <div class="content">
        
    </div>
    <div style="height:200px;"></div>
    <div class="tcsubmit">
        <div class="tcsubmittitle"><a href="#" class="tcsubmita" onclick="DisplaySubmit();"><img src="img/write.png" /> 发话题</a></div>
        <div class="tcsubmitbar">
            <p><textarea id="t_tucao_text" maxlength="140"rows="4"></textarea></p>
            <div class="tcsubmitbutton">
                <span class="tcsubmitbutton_num">140字</span>
                <a class="tcsubmitb" href="#" onclick="DoTuCao();">发表</a>
                <a class="tcsubmitb" href="#" onclick="DisplaySubmit();">取消</a>
            </div>
        </div>
    </div>
    <div id="replay" class="tcsubmit"> 
        <div class="tcsubmittitle"><a href="#" class="tcsubmita"><img src="../images/write.png" /> 我要回复</a></div>
        <p><textarea id="t_tucao_reply" maxlength="140"rows="4"></textarea></p>
        <div class="tcsubmitbutton">
            <span class="tcsubmitbutton_num">140字</span>
            <a class="tcsubmitb" href="#" onclick="DoTCReply();">回复</a>
            <a class="tcsubmitb" href="#" onclick="DisplayReply();">取消</a>
        </div>
    </div>
    <form method="post" action="tucao.aspx?OpenID=oRvupjsRYSywCPIoTpLvxjFDunkM" id="form1">
<div class="aspNetHidden">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKMTY0MDc2Nzg2N2Rk9Cyx3Iii1rsx0f/do2egB6ykfZPbyTNcn1e+64jQGu8=" />
</div>

<div class="aspNetHidden">

	<input type="hidden" name="__VIEWSTATEGENERATOR" id="__VIEWSTATEGENERATOR" value="ADBD8E75" />
</div>
    </form>
</body>
</html>
<script>
    var WaitingBar = "<div class=\"tcwaitbar\"><img src=\"../images/loader.gif\" style=\"width:16px;height:16px;padding:0em .5em 0em 0em;margin:0em;vertical-align:text-bottom;\" /><span>正在加载,请稍候...</span></div>";
    var OpenID = "oRvupjsRYSywCPIoTpLvxjFDunkM";
    $(document).ready(InitTCPage());

    function InitTCPage() {
        $.ajax({
            type: "POST",
            url: "WebService.asmx/InitTCPage",
            data: "{}",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (msg) {
                var json = eval("(" + msg.d + ")");
                $("#tc_ListCount").text(json.ListCount);
                $("#tc_AccessCount").text(json.AccessCount);
                GetTuCaoList(0)
            }
        });
    }

    var RTid = "";
    function DisplayReply(tid) {
        if ($("#replay").css("display") == "block") {
            $("#replay").css("display", "none");
            RTid = "";
        }
        else {
            $("#replay").css("display", "block");
            RTid = tid;
        }
    }

    function DisplaySubmit() {
        if ($(".tcsubmitbar").css("display") == "block") {
            $(".tcsubmitbar").css("display", "none");
        }
        else {
            $(".tcsubmitbar").css("display", "block");
        }
    }

    function GetTuCaoList(pagesize) {
        if (pagesize > 0) {
            $(".tcmorelist").remove();
        }
        $(".content").append(WaitingBar);

        $.ajax({
            type: "POST",
            url: "WebService.asmx/GetTuCaoList",
            data: "{CurrentPageIndex:" + pagesize + "}",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (msg) {
                //$("#test").text(msg.d);
                var TCList = "";
                //var json_data = eval("(" + msg.d + ")");
                var json_data = JSON.parse(msg.d);
                //alert(json_data.total);
                for (var i = 0; i < json_data.total; i++) {
                    TCList += "<div class=\"tclist\">";
                    TCList += "<div class=\"tcheader\"><img src=\"" + json_data.rows[i].headimgurl + "\" class=\"tcheadimg\" /></div>";
                    TCList += "<div class=\"tccontent\">";
                    TCList += "<div class=\"tctitle\">" + json_data.rows[i].nickname + "</div>";
                    TCList += "<div class=\"tctime\">" + json_data.rows[i].createtime + "</div>";
                    TCList += "<div class=\"tctext\">";
                    TCList += json_data.rows[i].tcontent;
                    TCList += "</div>";
                    TCList += "<div class=\"tcbutton\">";
                    TCList += "<a href=\"javascript:void(0);\" onclick=\"DoTCZhan('" + json_data.rows[i].tid + "','" + json_data.rows[i].openid + "');\">";
                    TCList += "<img src=\"images/dmz.png\" /> 赞 (<span id=\"t_tucao_zhan_" + json_data.rows[i].tid + "\">" + json_data.rows[i].zcount + "</span>)</a>";
                    TCList += "<a href=\"javascript:void(0);\" onclick=\"DisplayReply('" + json_data.rows[i].tid + "');\"><img src=\"images/msg.png\" /> 回复 (<span id=\"t_tucao_reply_" + json_data.rows[i].tid + "\">" + json_data.rows[i].rcount + "</span>)</a>";
                    TCList += "</div>";
                    TCList += "</div>";
                    if (json_data.rows[i].rcount > 0) {
                        var RList = "";
                        var loop = 0;
                        for (var j = 0; j < json_data.rows[i].rcount; j++) {
                            if (++loop > 3) {
                                RList += "<div id=\"t_tucao_morereply_" + json_data.rows[i].tid + "\" style=\"display:none;\">";
                            }
                            RList += "<div class=\"tcreplaylist\"><span class=\"tcreplayname\">"
                                + json_data.rows[i].rlists[j].nickname + ":</span><span class=\"tcreplaymsg\">" + json_data.rows[i].rlists[j].rcontent + "</span></div>";
                        }
                        if (loop > 3) {
                            RList += "</div>";
                        }
                        TCList += "<div class=\"tcreply\">" + RList + (json_data.rows[i].rcount > 3 ? "<div class=\"tcmore\"><a href=\"javascript:void(0);\" id=\"t_tucao_breplay_"
                            + json_data.rows[i].tid + "\" onclick=\"DisplayMoreReply('" + json_data.rows[i].tid + "');\">更多回复>></a></div>" : "") + "</div>";
                    }
                    TCList += "</div>";
                }

                TCList += "<div class=\"tcmorelist\"><a href=\"javascript:void(0);\" onclick=\"GetTuCaoList(" + (pagesize + 1) + ");\">更多吐槽>>></a></div>";

                $(".tcwaitbar").remove();
                if (pagesize == 0) {
                    $(".content").html(TCList);
                }
                else {
                    $(".content").append(TCList);
                }
            }
        });
    }

    function DoTuCao() {
        if ($("#t_tucao_text").val() == "") {
            return;
        }
        $(document).ready(function () {
            $.ajax({
                type: "POST",
                url: "WebService.asmx/DoTuCao",
                data: "{OpenID:'" + OpenID + "',Content:'" + $("#t_tucao_text").val() + "'}",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (msg) {
                    json = eval("(" + msg.d + ")");
                    if (json.Result == "OK") {
                        document.location.reload();
                    }
                    else {
                        alert(json.Msg);
                    }
                }
            });
        });
    }

    function DoTCReply() {
        $(document).ready(function () {
            $.ajax({
                type: "POST",
                url: "WebService.asmx/DoTCReply",
                data: "{TID:'" + RTid + "',OpenID:'" + OpenID + "',Content:'" + $("#t_tucao_reply").val() + "'}",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (msg) {
                    json = eval("(" + msg.d + ")");
                    if (json.Result == "OK") {
                        document.location.reload();
                    }
                    else {
                        alert(json.Msg);
                    }
                }
            });
        });
    }

    function DisplayMoreReply(tid) {
        if ($("#t_tucao_morereply_" + tid).css("display") == "none") {
            $("#t_tucao_morereply_" + tid).css("display", "block");
            $("#t_tucao_breplay_" + tid).text("隐藏回复>>");
        }
        else {
            $("#t_tucao_morereply_" + tid).css("display", "none");
            $("#t_tucao_breplay_" + tid).text("更多回复>>");
        }
    }

    function DoTCZhan(tid, openid) {
        $(document).ready(function () {
            $.ajax({
                type: "POST",
                url: "WebService.asmx/DoTCZhan",
                data: "{TID:'" + tid + "',OpenID:'" + openid + "'}",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (msg) {
                    json = eval("(" + msg.d + ")");
                    if (json.Result == "OK") {
                        $("#t_tucao_zhan_" + tid).text(parseInt($("#t_tucao_zhan_" + tid).text()) + 1);
                    }
                    else {
                        alert(json.Msg);
                    }
                }
            });
        });
    }
</script>
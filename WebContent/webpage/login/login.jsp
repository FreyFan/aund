<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kd.platform.core.util.SysThemesUtil,com.kd.platform.core.enums.SysThemesEnum"%> 
<%@ page import="java.util.Calendar" %>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<%
String lang = com.kd.platform.core.util.BrowserUtils.getBrowserLanguage(request);
String langurl = "plug-in/mutiLang/" + lang +".js";
SysThemesEnum sysTheme = SysThemesUtil.getSysTheme(request);
String lhgdialogTheme = SysThemesUtil.getLhgdialogTheme(sysTheme);
%>

<html>
<head>
<title>系统登录</title>
<link rel="shortcut icon" href="plug-in/login/images/favicon.ico">
<script src=<%=langurl%> type="text/javascript"></script>
<!--[if lt IE 9]>
   <script src="plug-in/login/js/html5.js"></script>
  <![endif]-->
<!--[if lt IE 7]>
  <script src="plug-in/login/js/iepng.js" type="text/javascript"></script>
  <script type="text/javascript">
	EvPNG.fix('div, ul, img, li, input'); //EvPNG.fix('包含透明PNG图片的标签'); 多个标签之间用英文逗号隔开。
</script>
  <![endif]-->
<link href="plug-in/login/css/zice.style.css" rel="stylesheet" type="text/css" />
<link href="plug-in/login/css/buttons.css" rel="stylesheet" type="text/css" />
<link href="plug-in/login/css/icon.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="plug-in/login/css/tipsy.css" media="all" />
<style type="text/css">
html {
	background-image: none;
}

label.iPhoneCheckLabelOn span {
	padding-left: 0px
}

#versionBar {
	background-color: #212121;
	position: fixed;
	width: 100%;
	height: 35px;
	bottom: 0;
	left: 0;
	text-align: center;
	line-height: 35px;
	z-index: 11;
	-webkit-box-shadow: black 0px 10px 10px -10px inset;
	-moz-box-shadow: black 0px 10px 10px -10px inset;
	box-shadow: black 0px 10px 10px -10px inset;
}

.copyright {
	text-align: center;
	font-size: 10px;
	color: #CCC;
}

.copyright a {
	color: #A31F1A;
	text-decoration: none
}

.on_off_checkbox {
	width: 0px;
}

#login .logo {
	width: 500px;
	height: 51px;
}
</style>
</head>
<body>
    <div id="alertMessage"></div>
    <div id="successLogin"></div>
    <div class="text_success"><img src="plug-in/login/images/loader_green.gif" alt="Please wait" /> <span><t:mutiLang langKey="common.login.success.wait"/></span></div>
    <div id="login">
        <div class="ribbon" style="background-image: url(plug-in/login/images/typelogin.png);"></div>
        <div class="inner">
            <div class="logo">
            	<h1 style="color: #6B3504;font-family: fzqt;font-size: 40px;">上沉原通</h1>
           	</div>
            <div class="formLogin">
                <form name="formLogin" id="formLogin" action="loginController.do?login" check="loginController.do?checkuser" method="post">
                    <input name="userKey" type="hidden" id="userKey" value="D1B5CC2FE46C4CC983C073BCA897935608D926CD32992B5900" />
                    <div class="tip">
                        <span style="font-size: 25px;">用户名：</span>
                        <input class="userName" style="width: 200px" name="userName" type="text" id="userName" title="用户名" iscookie="true" value="neuhouqin" nullmsg="请输入用户名!" />
                    </div>
                    <div class="tip">
                    	<span style="font-size: 25px;">密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
                       	<input class="password" style="width: 200px" name="password" type="password" id="password" title="密码" value="123456" nullmsg="请输入密码!" />
                    </div>
                    
                    <div class="tip">
                    	<span style="font-size: 25px;">验证码：</span>
                        <input class="randCode" style="width: 90px" name="randCode" type="text" id="randCode" title="" value="" nullmsg="请输入验证码!" />
                        <div style="float: right; margin-left:-130px; margin-right: 135px">
                            <img id="randCodeImage" src="randCodeImage" />
                        </div>
                    </div>
                   
                    <div class="loginButton">
                        <div style="float: left; margin-left: -9px;">
                            <input type="checkbox" id="on_off" name="remember" checked="ture" class="on_off_checkbox" value="0" />
                            <span class="f_help"><t:mutiLang langKey="common.remember.user"/></span>
                        </div>                        
                        <div style="float: right; padding: 3px 0; margin-right: -12px;">
                            <div>
                                <ul class="uibutton-group">
                                    <li><a class="uibutton normal" href="#" id="but_login"><t:mutiLang langKey="common.login"/></a></li>
                                    <li><a class="uibutton normal" href="#" id="forgetpass"><t:mutiLang langKey="common.reset"/></a></li>
                                </ul>
                            </div>
                            <%-- 
                            <div style="float: left; margin-left: 30px;"><a href="init.jsp"><span class="f_help"><t:mutiLang langKey="common.init.data"/></span></a></div>
                            --%>
                            <br>                            
                            <t:dictSelect id="langCode" field="langCode" typeGroupCode="lang" hasLabel="false" defaultVal="zh-cn"></t:dictSelect>
                        </div>
                        <div class="clear"></div>
                    </div>
                </form>
            </div>
        </div>
        <div class="shadow"></div>
    </div>
    <!--Login div-->
    <div class="clear"></div>
    <div id="versionBar">
        <div class="copyright">&copy; 上沉原通  2014~<%=(Calendar.getInstance().get(Calendar.YEAR))%> All Right Reserved &copy;</div>
    </div>
    <!-- Link JScript-->
    <script type="text/javascript" src="plug-in/jquery/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="plug-in/jquery/jquery.cookie.js"></script>
    <script type="text/javascript" src="plug-in/login/js/jquery-jrumble.js"></script>
    <script type="text/javascript" src="plug-in/login/js/jquery.tipsy.js"></script>
    <script type="text/javascript" src="plug-in/login/js/iphone.check.js"></script>
    <script type="text/javascript" src="plug-in/login/js/login.js"></script>
 <!--    <script type="text/javascript" src="plug-in/lhgDialog/lhgdialog.min.js"></script> -->
    <%=lhgdialogTheme %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	System.out.println(basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
    <!--<a href="main.html" target="_parent"><img src="images/logo1.png" title="JDS小案例2" /></a>-->
	<h6 style="color:#fff;font-size:25px;margin-top:20px;margin-left:20px">小米后台管理系统</h6>
    </div>
        
    <ul class="nav">
    </ul>
            
    <div class="topright">    
    <ul>
    <li><a href="#">${username }</a></li>
    <li><span><img src="images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="userServlet?flag=logout" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span></span>
    <i>消息</i>
    <b>0</b>
    </div>    
    
    </div>
</body>
</html>

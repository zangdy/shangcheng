<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
//jquery的页面加载函数
//页面加载完之后执行的代码逻辑
$(function(){
	$("#keyWords").click(function(){
		//发送ajax的请求到后台 添加搜索的关键词
		alert(111);
		var keyWords = $("#findKeyWords").val();
		$.get("indexServlet",{"flag":"addKeyWords","keyWords":keyWords},function(data){
			if(data=='true'){
				alert('关键词已经记录');
			}
		})
	})
	
})
window.onload=function(){
	function getTrolley(){
		//发起ajax的请求获取后台的购物车总数量
		$.get("indexServlet",{"flag":"totalTrolley"},function(data){
			$("#buyNum").html(data);
		})
	}
	
	getTrolley();
	
}
</script>
</head>
<body>

<div class="box">
      <div class="inner whiteGL">
          <div class="left">
              <a class="mix" href="">仿小米商城-学习专用</a>
          </div>
          <div class="right">
          		<c:if test="${empty username }">
          			<a class="mix" href="login.jsp">登录</a>
              		<a href="register.jsp">注册</a>
          		</c:if>
               <c:if test="${not empty username }">
          			<span ><font color="white" size="2">欢迎 您： ${username }</font></span>
          		</c:if>
              <a class="max"  href="">消息通知</a>
              <a href="${pageContext.request.contextPath }/trolleyServlet?flag=listTrolley">购物车(<span id="buyNum">0</span>)</a>
          </div>
      </div>
  </div>
  <div class="logo">
      <div class="logo_left">
          <div>
              <a href="javascript:void(0);" title="小米官网"><img class="xiaomi" src="img/logo.jpg"></a>
          </div>
      </div>
      <ul class="logo_center orangeGL">
          <a href="">小米手机</a>
          <a href="">红米</a>
          <a href="">笔记本</a>
          <a href="">电视</a>
          <a href="">盒子</a>
          <a href="">新品</a>
          <a href="">路由器</a>
          <a href="">智能硬件</a>
          <a href="">服务</a>
          <a href="">社区</a>
      </ul>
      <formv class="logo_right">
         <div class="logo_input">
         	<input type="text" id="findKeyWords">
         </div>
          <a class="logo_right_a" href="javascript:void(0)"  ><img id="keyWords" src="img/find.jpg"></a>         
      </formv>
  </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="css/index.css">
    <script src="js/jquery-3.3.1.js"></script>
    <style>

    </style>
<script type="text/javascript">
	//页面加载完成后执行的代码
	$(function(){
		$("#zphone").click(function(){
			var phoneNum = $("#phone_number").val();
			if(phoneNum==null||phoneNum==''){
				alert("请输入手机号");
				$("#phone_num").focus();				
			}
			$.ajax({
				url:"userServlet",
				data:{"phoneNum":phoneNum,"flag":"checkUserByPhone"},
				type: "post",
				success:function(data){
					//data如果是true表示没有查到用户
					if(data=='true'){
						//提示用户账号不存在  跳转注册页面
						alert("用户不存在 确认是否注册正确");
					}else{
						//调用发送手机验证码的方法
						sendSms(phoneNum);
					}
				}
			})
		})
		var timer ;
		var seconds = 59;
		function daojishi(){
			if(seconds>0){
				//将秒数-1
				seconds=seconds-1;
				$("#zphone").val(seconds);
				
				
			}else{
				$("#zphone").attr("disabled", false);
				seconds=59;
				$("#zphone").val("获取验证码");
				window.clearTimeout(timer);
			}
		}
		//发送手机号的功能
		function sendSms(phoneNum){
			$.ajax({
				url:"userServlet",
				data:{"phoneNum":phoneNum,"flag":"sendSms"},
				type: "get",
				success:function(data){
					//data如果是true表示发送成功执行倒计时的方法
					if(data){
						//将获取验证码按钮设置不可用
						$("#zphone").attr("disabled", true); 
						console.log("开启倒计时..");
						timer =  window.setInterval(daojishi,1000);
					}else{
						alert("发送失败");
					}
				}
			})
		}
		//绑定提交表单的触发事件
		$("#sub").click(function(){
			$("#f3").submit();
		})
	})

</script>
</head>
<body>
<div class="register_head_on">

</div>
<div class="register_head">
    <a href="index.html"><img src="img/logo.jpg" alt=""></a>
    <div class="register_head_right">
        <p class="register_head_right_p1">小 米 商 城</p>
        <p class="register_head_right_p2">让每个人都享受科技乐趣</p>
    </div>

</div>

<div class="register">
    <div class="register_boby">
        <div class="register_boby_min">
            <div class="register_boby_no1">
                <div class="register_boby_no1_in">
                    <span style="color: #ff6700">手机验证码登录 </span>
                </div>
            </div>
            <form id="f3" action="userServlet" method="post">
            
            <!-- fs区分的方法 -->
            <input name="flag" value="login" type="hidden">
            
            <div class="register_boby_no2">
            	<span id="msg" style="color: red;font-size: 12px;margin-left: 20px;"></span>
                <input id="phone_number" name="phone_number" type="text" placeholder="手机号码">
                
                <input name="code" id="code" type="text" placeholder="手机校验码" style="width: 200px; margin-left: 15px;float: left;">
                <!-- 新增加 -->
                <input id="zphone" type="button" value=" 获取手机验证码 " style="width: 138px;float: left;height: 53px;margin-left: 5px;"> 
                <div style="clear: both;">
                
                <div class="register_boby_no2_div">
                    <span id="sub">登录</span>
                </div>
            </div>
            </div>
            </form>
            
            <div class="register_boby_no3">
                <a href="javascript:void(0);" style="color: #ff6700">账号密码登录</a>
                <sapn class="register_boby_no3_span">
                    <a href="register.jsp">立即注册</a>
                    <span>|</span>
                    <a href="avascript:void(0);">忘记密码?</a>
                </sapn>

            </div>
            <div class="register_boby_no4">
                <img src="img/register02.jpg" alt="">
            </div>

        </div>
    </div>
</div>
<div class="register_foot">
    <img  src="img/register03.jpg" alt="">
</div>


</body>
</html>
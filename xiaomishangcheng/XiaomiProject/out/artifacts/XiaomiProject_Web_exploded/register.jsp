<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <link rel="stylesheet" href="css/index.css">
   <!--  <script type="text/javascript" src="js/jquery.1.11.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script type="text/javascript" src="js/messages_zh.js"></script> -->
    
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <!-- 引入脚本文件 -->
    <script type="text/javascript">
    	//当点击立即注册触发表单提交
    	$(function(){
    		//绑定div的触发事件
    		$("#btn").click(function(){
    			//姓名 电话 账号 密码
    			var name = $("#name").val();
    			if(name==''||name==null){
    				//将红色的提示文字显示再span标签内部
    				$("#s_name").html("<font color='red'>用户名必填</font>");
    				return;
    			}
    			var phone_number = $("#phone_number").val();
    			if(phone_number==''||phone_number==null){
    				//将红色的提示文字显示再span标签内部
    				$("#s_phone_number").html("<font color='red'>电话必填</font>");
    				return;
    			}
    			var username = $("#username").val();
    			if(username==''||username==null){
    				//将红色的提示文字显示再span标签内部
    				$("#s_username").html("<font color='red'>账号必填</font>");
    				return;
    			}
    			var password = $("#password").val();
    			if(password==''||password==null){
    				//将红色的提示文字显示再span标签内部
    				$("#s_password").html("<font color='red'>密码必填</font>");
    				return;
    			}
    			//表单的提交方法
    			$("#f4").submit();
    			
    		})
    		//ajax异步实现验证手机的唯一性
    		//ajax一般用于获取后台返回的json数据
    		$("#phone_number").blur(function(){
    			//获取当前输入的手机号 向后台发送请求得到验证后的结果
    			var phoneNum = $("#phone_number").val();
    			if(phoneNum==null||phoneNum==''){
    				$("#s_phone_number").html("<font color='red'>手机必填</font>");
					//使输入手机的input框获取到焦点
					$("#phone_number").focus();
					return;
    			}
    			//ajax的发送请求 data是请求成功后返回的数据
    			$.get("userServlet",{"phoneNum":phoneNum,"flag":"checkPhone"},function(data){
    				if(data=='true'){
    					$("#s_phone_number").html("<font color='green'>手机可用</font>");
    				}else{
    					$("#s_phone_number").html("<font color='red'>手机重复</font>");
    					//使输入手机的input框获取到焦点
    					$("#phone_number").focus();
    				}
    			})
    		
    		})
    		//ajax异步实现验证用户名的唯一性
    		$("#username").blur(function(){
    			//获取当前输入的手机号 向后台发送请求得到验证后的结果
    			var username = $("#username").val();
    			if(username==null||username==''){
    				$("#s_username").html("<font color='red'>账号必填</font>");
					//使输入手机的input框获取到焦点
					$("#username").focus();
					return;
    			}
    			//ajax的发送请求 data是请求成功后返回的数据
    			$.get("userServlet",{"username":username,"flag":"checkName"},function(data){
    				if(data=='true'){
    					$("#s_username").html("<font color='green'>账号可用</font>");
    				}else{
    					$("#s_username").html("<font color='red'>账号重复</font>");
    					//使输入手机的input框获取到焦点
    					$("#username").focus();
    				}
    			})
    		
    		})
    	})
    </script>
    
</head>
<body>
<body>
<div class="sign_background">
    <div class="sign_background_in">
        <div class="sign_background_no1">
            <a href="index.html"><img src="img/logo.jpg" alt=""></a>
        </div>
        <div class="sign_background_no2">注册小米帐号</div>
        <div class="sign_background_no3">
          
            <div class="sign_background_no5">
             	
             	<form id="f4" action="userServlet" method="post" enctype="multipart/form-data">
             		<input type="hidden" name="flag" value="register">
             		<table style="width: 500px;" border="0" cellspacing="0">
             			<tr>
             				<td width="25%" class="_left">姓名：</td>
             				<td><input type="text" id="name" name="name"><span id="s_name"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">性别：</td>
             				<td>
             					男<input type="radio" name="sex" checked="checked" value="1">
             				 	女<input type="radio" name="sex" value="0">
							</td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">电话号码：</td>
             				<td><input type="text" id="phone_number" name="phone_number" ><span id="s_phone_number"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">所在地区：</td>
             				<td><input type="text" name="area"></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">账号：</td>
             				<td><input type="text" id="username" name="username" ><span id="s_username"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">密码：</td>
             				<td><input type="text" name="password" id="password" ><span id="s_password"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">上传头像：</td>
             				<td><input type="file" name="photo"></td>
             			</tr>
             			<span color="red">${msg }</span>
             		</table>
             		<div class="sign_background_no6" id="btn" >立即注册</div>
             	</form>
             	 
            </div>
        </div>
        <div class="sign_background_no7">注册帐号即表示您同意并愿意遵守小米 <span>用户协议</span>和<span>隐私政策</span> </div>
    </div>
    <div class="sign_background_no8"><img src="img/sign01.jpg" alt=""></div>
	
</div>
</body>
</html>
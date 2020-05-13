<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	
	//获取项目名
	String path = request.getContextPath();
	//获取tomcat 协议+地址+端口号+ 获取项目名
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户信息</title>
<link href="<%=basePath %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>js/jquery-3.3.1.js"></script>

<script type="text/javascript">

// old write 
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});

//就绪函数
$(function(){
	//全选的触发事件
	$("#selectAll").click(function(){
		//获取所有的复选框 然后讲每个复选框的属性 checked 设置checked
		//this表示当前触发方法的控件本身
		$("input[type='checkbox']").prop('checked',this.checked);
		
	})
	$("#batchDelete").click(function(){
		//获取复选框中被转中的那一部分
		var deleteUsers = $("input[type='checkbox']:checked");
		//循环遍历得到每一个被删除的userid 传递到后台
		var deleteIds = "";
		for(var i=0;i<deleteUsers.length;i++){
			deleteIds=deleteIds+deleteUsers[i].value+",";
		}
		//将拼接的三个id传递到后台实现删除
		$.get("userServlet",{"flag":"batchDelete","deleteIds":deleteIds},function(data){
			if(data=='true'){
				location.href="userServlet?flag=findAllUser";
			}else{
				alert("删除失败");
			}
		})
	})
});


</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">用户管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        
        <!-- 
        
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t04.png" /></span>统计</li>
         -->
        <li  id="batchDelete" style="cursor: pointer;"><span><img src="<%=basePath %>images/t03.png" /></span>批量删除</li>
        </ul>

    </div>
    <table class="tablelist">
    	<thead>
	    	<tr>
		        <th><input id="selectAll" type="checkbox" /></th>
		        <th>id<i class="sort"><img src="<%=basePath %>images/px.gif" /></i></th>
		        <th>姓名</th>
		        <th>性别</th>
		        <th>电话号码</th>
		        <th>所在地区</th>
		        <th>权限</th>
		        <th>账号</th>
		       	<th>头像</th>
		       	<th>注册时间</th>
		       	<th>操作</th>
	        </tr>
	    </thead>
        <tbody>
            
            <c:forEach items="${pb.list }" var="user">
            	<tr>
			        <td><input id="checkbox_main" type="checkbox" value="${user.id }" /></td>
			        <td>${user.id}</td>
			        <td>${user.name}</td>
			        <td>${user.sex==1?'男':'女'}</td>
			        <td>${user.phone_number}</td>
			        <td>${user.area}</td>
			        <td>${user.manager==0?'管理员':'普通用户'}</td>
			        <td>${user.username}</td>
			        <td><img height="100px" src="${user.photo}"></td>
			        <td>${user.create_time}</td>
			        <td><a href="#">编辑 </a><a href="#"> 删除</a></td>
	        	</tr>
            </c:forEach>
            
        	
        	
        </tbody>
    </table>
   
    <div class="pagin">
    	<div class="message">共<i class="blue">${pb.totalCount }</i>条记录，
    	                                                    共<i class="blue">${pb.totalPage }</i>页&nbsp;当前显示第&nbsp;<i class="blue">${pb.pageNum }&nbsp;</i>页</div>
        <ul class="paginList">
	        
	         <li class="paginItem"><a href="userServlet?flag=findAllUser&pageNum=1&pageSize=${pb.pageSize }">首页</a></li>
	         <li class="paginItem"><a href="userServlet?flag=findAllUser&pageNum=${pb.pageNum-1 }&pageSize=${pb.pageSize }">上一页</a></li>
	         <c:forEach begin="1" end="${pb.totalPage }" var="i">
	         	 <li class="paginItem">
	         	 	<a  href="userServlet?flag=findAllUser&pageNum=${i }&pageSize=${pb.pageSize }">
	         	 		<font ${pb.pageNum==i?'color="red"':'' }>${i }</font>
	         	 	</a>
	         	 </li>
	         </c:forEach>
	         <li class="paginItem"><a href="userServlet?flag=findAllUser&pageNum=${pb.pageNum+1 }&pageSize=${pb.pageSize }">下一页</a></li>
	         <li class="paginItem"><a href="userServlet?flag=findAllUser&pageNum=${pb.totalPage }&pageSize=${pb.pageSize }">尾页</a></li>
	        
        </ul>
    </div>
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品分类</title>
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
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
function chageSize(){
	//获取下拉框选中的值
	var pageSize = $("#selectSize").val();
	//重新向后台发送请求 路径为查询数据但是传递分页查询的两个参数
	location.href="categoryServlet?flag=findAll&pageNum=${pb.pageNum}&pageSize="+pageSize;
}

</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">分类管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        
        
        <li class="click"><span><img src="<%=basePath %>images/t02.png" /></span>修改</li>
        <li><span><img src="<%=basePath %>images/t04.png" /></span>统计</li>
        <a href="${pageContext.request.contextPath }/categoryJsp/category_add.jsp"><li style="cursor: pointer;" ><span><img src="<%=basePath %>images/t01.png"  /></span>添加类别</li></a>
        <li style="cursor: pointer;" onclick="batchDelete()"><span><img src="<%=basePath %>images/t03.png" /></span>批量删除</li>
        </ul>

    </div>
    
    <table class="tablelist">
    	<thead>
    	<tr>
	        <th><input name="" type="checkbox" value="" /></th>
	        <th>序号<i class="sort"><img src="<%=basePath %>images/px.gif" /></i></th>
	        <th>类别名称</th>
	        <th>启用状态</th>
	        <th>排序序号</th>
	        <th>创建时间</th>
	        <th>描述</th>
	        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        	<c:forEach items="${pb.list }" var="cate">
        		<tr>
		        <td><input name="" type="checkbox" value="" /></td>
		        <td>${cate.id }</td>
		        <td>${cate.name }</td>
		        <td>${cate.state==0?'可用':'不可用' }</td>
		        <td>${cate.order_number }</td>
		        <td>${cate.create_time }</td>
		        <td>${cate.description }</td>
		        <td><a href="${pageContext.request.contextPath }/categoryServlet?flag=findOne&id=${cate.id}">编辑 </a>
		        	<a href="${pageContext.request.contextPath }/categoryServlet?flag=delete&id=${cate.id}"> 删除</a>
		        	</td>
		        
	        </tr>
        	</c:forEach>
	        
        
        
        </tbody>
    </table>
    <div class="pagin">
    	<div class="message">共<i class="blue">${pb.totalCount }</i>条记录，
    	                                                    共<i class="blue">${pb.totalPage }</i>页&nbsp;当前显示第&nbsp;<i class="blue">${pb.pageNum }&nbsp;</i>页
    		&nbsp;&nbsp;&nbsp;每页条数：
    		<select id="selectSize" onchange="chageSize();">
    			<option ${pb.pageSize==1?'selected':'' }>1</option>
    			<option ${pb.pageSize==3?'selected':'' }>3</option>
    			<option ${pb.pageSize==5?'selected':'' }>5</option>
    		</select>                                                    
 	    </div>
        <ul class="paginList">
	        
	         <li class="paginItem"><a href="categoryServlet?flag=findAll&pageNum=1&pageSize=${pb.pageSize }">首页</a></li>
	         <li class="paginItem"><a href="categoryServlet?flag=findAll&pageNum=${pb.pageNum-1 }&pageSize=${pb.pageSize }">上一页</a></li>
	         <c:forEach begin="1" end="${pb.totalPage }" var="i">
	         	 <li class="paginItem">
	         	 	<a  href="categoryServlet?flag=findAll&pageNum=${i }&pageSize=${pb.pageSize }">
	         	 		<font ${pb.pageNum==i?'color="red"':'' }>${i }</font>
	         	 	</a>
	         	 </li>
	         </c:forEach>
	         <li class="paginItem"><a href="categoryServlet?flag=findAll&pageNum=${pb.pageNum+1 }&pageSize=${pb.pageSize }">下一页</a></li>
	         <li class="paginItem"><a href="categoryServlet?flag=findAll&pageNum=${pb.totalPage }&pageSize=${pb.pageSize }">尾页</a></li>
	        
        </ul>
    </div>
    </div>
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>

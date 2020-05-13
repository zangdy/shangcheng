<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%	
	//获取项目名
	String path = request.getContextPath();
	//获取tomcat 协议+地址+端口号+ 获取项目名
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//获取tomcat 协议+地址+端口号
	String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品信息</title>
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



</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">商品管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        
        <li style="cursor: pointer;" ><span><img src="images/t01.png"  /></span>
        	<a href="${pageContext.request.contextPath}/commodityServlet?flag=addUI">添加商品</a>
        </li>
        <li style="cursor: pointer;" onclick="batchDelete()"><span><img src="images/t03.png" /></span>批量删除</li>
        </ul>

    </div>
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>序号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>商品类别</th>
        <th>商品名称</th>
        <th>商品颜色</th>
        <th>商品价格</th>
        <th width="10%">简介</th>
        <th width="20%">详情</th>
       	<th>商品展示图</th>
       	<th>所属模块</th>
       	<th>型号</th>
       	<th>生产日期</th>
       	<th>操作</th>
        </tr>
        </thead>
        <tbody>
        	<c:forEach items="${pb.list }" var="commodity">
        		<tr>
        			<td><input name="" type="checkbox" value=""/></td>
        			<td>${commodity.id }</td>
        			<td>${commodity.cname }</td>
        			<td>${commodity.name }</td>
        			<td>${commodity.color }</td>
        			<td>${commodity.price }</td>
        			<td>${commodity.description }</td>
        			<td>${commodity.full_description }</td>
        			<td><img height="100px" src="/xiaomiImg/${commodity.pic }"></img></td>
        			<td>
        				<c:if test="${commodity.state==1 }">普通商品</c:if>
        			  	<c:if test="${commodity.state==2 }">热卖</c:if>
        			  	<c:if test="${commodity.state==3 }">推荐</c:if>
        			  	<c:if test="${commodity.state==4 }">新品</c:if>
        			  	<c:if test="${commodity.state==5 }">明星单品</c:if>
        			
        			</td>
        			<td>${commodity.version }</td>
        			<td>${commodity.product_date }</td>
        			<td><a href="${pageContext.request.contextPath }/commodityServlet?flag=findOne&id=${commodity.id}">编辑 </a><a> 删除</a></td>
        		</tr>
        	</c:forEach>
        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">${pb.totalCount }</i>条记录，
                   			  共<i class="blue">${pb.totalPage }</i>页，
    	当前显示第&nbsp;<i class="blue">&nbsp;${pb.pageNum }</i>页</div>
        <ul class="paginList">
	        
	         <li class="paginItem"><a href="">首页</a></li>
	         <li class="paginItem"><a href="">上一页</a></li>
	         <li class="paginItem"><a href="">下一页</a></li>
	         <li class="paginItem"><a href="">尾页</a></li>
	         
	        
        </ul>
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
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>

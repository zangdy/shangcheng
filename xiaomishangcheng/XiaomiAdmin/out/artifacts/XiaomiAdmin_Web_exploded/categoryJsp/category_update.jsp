<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加类别</title>
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />

</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">添加类别</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>类别信息</span></div>
    
    <form action="${pageContext.request.contextPath }/categoryServlet" method="post">
     <input name="flag" type="hidden" value="update" />
     <input name="id" type="hidden" value="${cate.id }" />
	    <ul class="forminfo">
		    <li><label>类别名称</label>
		     <input name="name" type="text" class="dfinput" value="${cate.name }"/><i>类别名称不能超过30个字符</i></li>
		    <li><label>是否启用</label>
			    <cite>
				    <input name="status" type="radio" value="1" ${cate.state==1?'checked':'' } />禁用&nbsp;&nbsp;&nbsp;&nbsp;
				    <input name="status" type="radio" value="0" ${cate.state==0?'checked':'' }/>启用
			    </cite>
		    </li>
		    
		    <li><label>排序序号</label>
		    	<input name="order_number" type="text" class="dfinput" value="${cate.order_number }" /><i>输入数字，越大越靠后排列</i>
		    </li>
		    
		    <li><label>类别描述</label>
		    	<textarea name="description" cols="" rows="" class="textinput">
		    		${cate.description }
		    	</textarea>
		    </li>
		    
		    
		    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    </div>
</body>
</html>

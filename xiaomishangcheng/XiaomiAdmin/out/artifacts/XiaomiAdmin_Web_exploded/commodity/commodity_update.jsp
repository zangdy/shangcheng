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
<title>添加商品</title>
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="<%=basePath %>js/My97DatePicker/WdatePicker.js"></script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">添加商品</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>商品信息</span></div>
    
    <form action="${pageContext.request.contextPath }/commodityServlet" method="post" enctype="multipart/form-data">
    	<input name="flag" type="hidden" value="update"/>
    	<input name="id" type="hidden" value="${com.id }"/>
	    <ul class="forminfo">
	    	 
	    	 <!-- 商品分类信息 -->
	    	 <li>
	    	 	<label>商品分类</label>
	    	 	<select name="cid" class="dfinput">
	    	 		<option value="0">===请选择===</option>
					<c:forEach items="${cateList}" var="cate"> 
						<option ${cate.id==com.cid?'selected':'' } value="${cate.id }">${cate.name }</option>
					</c:forEach>
	    	 	</select>                                      
	    	 </li>
	    	 
	    	 
		    <li><label>商品名称</label><input name="name" value="${com.name }" type="text" class="dfinput" /><i>商品名称不能超过30个字符</i></li>
		    <li><label>颜色</label><input name="color" value="${com.color }" type="text" class="dfinput" /></li>
		    <li><label>规格尺寸</label><input name="size" value="${com.size }" type="text" class="dfinput" /></li>
		    <li><label>单价</label><input name="price" value="${com.price }" type="text" class="dfinput" /></li>
		    <li><label>简介</label>
		    	<textarea name="description" cols="10" rows="10" class="textinput" style="height: 80px">
		    		${com.description }
		    	</textarea>
		    </li>
		    <li><label>完整介绍</label>
		    	<textarea name="full_description" cols="10" rows="10" class="textinput" style="height: 80px">
		    		${com.full_description }
		    	</textarea>
		    </li>
		    <li><label>商品展示图</label>
		    	<img height="200px" src="../xiaomiImg/${com.pic }"></img>
		    	<input name="picOld" type="text" value="${com.pic }"/>
		    	<input name="pic" type="file"/>
		    </li>
		    <li><label>商品小类别</label>
			    <cite>
				    <input name="state" type="radio" ${com.state==1?'checked':'' } value="1"  />正常&nbsp;&nbsp;&nbsp;&nbsp;
				    <input name="state" type="radio" ${com.state==2?'checked':'' } value="2" />热门产品
				    <input name="state" type="radio" ${com.state==3?'checked':'' } value="3" />为你推荐
				    <input name="state" type="radio" ${com.state==4?'checked':'' } value="4" />新品
				    <input name="state" type="radio" ${com.state==5?'checked':'' } value="5" />小米明星单品
			    </cite>
		    </li>
		    <li><label>型号</label><input name="version" value="${com.version }" type="text" class="dfinput" /></li>
		    
		    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    </div>
</body>
</html>

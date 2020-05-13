<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	
	//获取项目名
	String path = request.getContextPath();
	//获取tomcat 协议+地址+端口号+ 获取项目名
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//获取tomcat 协议+地址+端口号
	String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
	
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>红米5 plus</title>
    <link rel="stylesheet" href="<%=basePath %>css/index.css">
    <script src="<%=basePath %>js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function addTrolley(cid){
		//cid表示当前被传递的商品id
		var user = "${user}" ;
		if(user==''||user==null){
			alert("请登陆以后，再提交购物车");
			location.href="login.jsp";
		}else{
			//向后台发送异步的ajax请求
			$.get("indexServlet",{"flag":"addTrolley","cid":cid},function(data){
				alert(data);
				//Number(参数)将其余类型转成数值的自带函数
				if(Number(data)>0){
					alert('添加成功');
					//将返回的data显示 针对单一商品购买可以满足需求 如果购买多个产品不合适
					//每次添加之后 返回的数值都是1 或者 0 改造成成功后获取后台的商品个数
					 getTrolley();
					
				}else{
					alert('添加失败');
				}
			})
		}
		
	}
	function getTrolley(){
		//发起ajax的请求获取后台的购物车总数量
		$.get("indexServlet",{"flag":"totalTrolley"},function(data){
			$("#buyNum").html(data);
		})
	}

</script>
</head>
<body>
    
    <jsp:include page="header.jsp"></jsp:include>
    
    <div class="plus5_no2 ">
        <div class="plus5_no2_in">
            <a class="plus5_no2_in_a"> 为方便您购买，请提前登录 </a>
            <a class="plus5_no2_in_a orange"style="color: pink;" href="login.jsp">立即登录</a>
            <a id="plus5_no2_in" class="plus5_no2_in_a" href="javascript:;">x</a>
        </div>
    </div>
    <div class="plus5_no3">
        <div class="plus5_no3_img">
            <img width="560px" height="560px" src="../xiaomiImg/${commodity.pic }" style="display: block" alt="">
        </div>
        <div class="plus5_no3_right">
            <h3>${commodity.name }</h3>
            <p class="plus5_no3_right_p2">
            	<span class="plus5_no3_right_span2">${commodity.description }</span>
            	<div style="font-size: 14px;">${commodity.full_description }</div>
            	
            </p>
            <p class="plus5_no3_right_p3">${commodity.price } 元<span class="plus5_no3_right_span3">${commodity.price } 元</span></p>
            <div class="plus5_no3_right_div4">
                <div class="plus5_no3_right_div4_in">
                    <p class="plus5_no3_right_p4">赠品</p><span>**</span>
                </div>
                <div class="plus5_no3_right_div4_in">
                    <p class="plus5_no3_right_p4">赠品</p><span>**</span>
                </div>


            </div>
            <div class="plus5_no3_right_div5">
                    <p >北京 北京市 东城区 永定门外街道 <span class="plus5_no3_right_div5_span"><a class="plus5_no3_right_div5_span" href="">修改</a> &nbsp;&nbsp;  有现货</span></p>
            </div>
            <div class="plus5_no3_right_div6">选择版本</div>
            <div class="plus5_no3_right_div7">
            
            	<li class="plus5_no3_right_div7_in plus5_no3_right_div7_in_hover">
                    <span class="plus5_no3_right_div7_span0 ">版本号</span>
                    <span class="plus5_no3_right_div7_span0 " >&nbsp;&nbsp;&nbsp;&nbsp;<font color="black">${commodity.version }</font></span>
                </li>
            </div>
            <div class="plus5_no3_right_div6">选择颜色</div>
            <div class="plus5_no3_right_div9">
            	<li class="plus5_no3_right_div7_in plus5_no3_right_div7_in_hover ">
            		<img src="img/plus5_phone_01.png" alt=""><span>${commodity.color }</span>
            	</li>
            </div>
            <div class="plus5_no3_right_div10">
                <p class="plus5_no3_right_div10_p1">${commodity.name } <span class="plus5_no3_right_div10_span0">${commodity.version }</span> <span class="plus5_no3_right_div10_span1"></span><span class="plus5_no3_right_div10_span2">${commodity.color }</span></p><span class="plus5_no3_right_span10">${commodity.price }元</span>
                <p class="plus5_no3_right_div10_p2" style="font-size: 18px;font-weight: bold;">总计 ：商品价格 ${commodity.price } 元</p>

            </div>
            <a href="javascript:void(0)" onclick=addTrolley(${commodity.id}); ><div class="plus5_no3_right_div11" style="cursor: pointer;" >加入购物车</div></a>
            <div class="plus5_no3_right_div12">
                <div class="plus5_no3_right_div12_y">√</div>
                <div class="plus5_no3_right_div12_z">七天无理由退货</div>
                <div class="plus5_no3_right_div12_y">√</div>
                <div class="plus5_no3_right_div12_z">15天质量问题换货</div>
                <div class="plus5_no3_right_div12_y">√</div>
                <div class="plus5_no3_right_div12_z">360天保障</div>
            </div>
            <a href="javascript:void (0);"></a>

        </div>
    </div>
    
    <jsp:include page="footer.jsp"></jsp:include>
    
   

</body>
</html>
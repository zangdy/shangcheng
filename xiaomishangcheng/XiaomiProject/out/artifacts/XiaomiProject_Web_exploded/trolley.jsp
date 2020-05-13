<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	
	//获取项目名
	String path = request.getContextPath();
	//获取tomcat 协议+地址+端口号+ 获取项目名
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	//加号减号触发的方法 传递数量做增减运算
	function addOrDeleteNumber(id,num,count){
		alert(count);
		if(Number(count)<=1&&Number(num)<0){
			alert('数量最少为1');
		}else{
			//将传递过来的数量 和被编辑数量的id 传递到后台
			location.href="${pageContext.request.contextPath}/trolleyServlet?flag=addOrdelete&id="+id+"&num="+num;
		}
	}
	function pay(totalMoney,totalCount){
		//将两个参数发送到后台生成订单数据存储
		location.href="${pageContext.request.contextPath}/orderServlet?"+
				"flag=createOrder&totalMoney="+totalMoney+"&totalCount="+totalCount;
	}
	
</script>
</head>
<body>
    <div class="order_head">
        <div class="head_background">
            <div class="head_box">
                <a href="index.html" class="head_left_a"><img src="img/logo.jpg" alt="" class="head_left_p"></a>
                <h1 class="head_h1">我的购物车</h1>
                <div class="head_right">
                    <span class="head_right_in"> ${user.name } </span>
                    <span class="head_right_in">|</span>
                    <a href="" class="head_right_in">我的订单</a>
                </div>

            </div>
        </div>
    </div>
    <div class="trolley_background">
        <div class="trolley_background_in">
            <div class="tro_tab_h">
                <div class="col tro_tab_check">
                    <h1 class="tro_tab_check_p">√</h1>
                    <span class="tro_tab_check_sp">全选</span>

                </div>
                <div class="col tro_tab_img">

                </div>
                <p class="col tro_tab_name">商品名称</p>
                <div class="col tro_tab_price">单价</div>
                <div class="col tro_tab_num">数量</div>
                <div class="col tro_tab_total">小计</div>
                <div class="col tro_tab_action">操作</div>

            </div>
            <c:set var="totalMoney" value="0"></c:set> 
            <c:set var="totalCount" value="0"></c:set> 
            <c:forEach items="${trolleyList }" var="tro">
            
            <div class="tro_tab_h1">
                <div class="col tro_tab_check">
                    <h1 class="tro_tab_check_p" style="background-color: #fff">
						<input type="checkbox" name="ids">
					</h1>
                    <span class="tro_tab_check_sp"></span>

                </div>
                <div class="col tro_tab_img">
                    <img src="/xiaomiImg/${tro.commodity.pic }" alt="商品图片">

                </div>
                <div class="col tro_tab_name">
                <!--<h2 tro_tab_name_h2>小米电视4A 32英寸 黑色 32英寸</h2>-->
               <li class="tro_tab_name_li1" style="font-size: 16px;">${tro.commodity.name }&nbsp;${tro.commodity.color }</li>
                </div>
                <div class="col tro_tab_price">
                    <span  id="price">${tro.commodity.price }</span><span>元</span>
                    
                </div>
                <div class="col tro_tab_num">
                    <a class="tro_tab_num_p1" id="subtract" href="javascript:void(0)" onclick="addOrDeleteNumber(${tro.id},-1,${tro.c_count })">-</a>
                    <input type="text" value="${tro.c_count }" id="num">
                    <c:set var="totalCount" value="${totalCount+tro.c_count }"></c:set>
                    <a class="tro_tab_num_p2" id="plus" href="javascript:void(0)" onclick="addOrDeleteNumber(${tro.id},1,${tro.c_count })">+</a>
                </div>
                <div class="col tro_tab_total "><span class="tro_tab_total_value" id="prices" >${tro.commodity.price*tro.c_count }</span>元
							<c:set var="totalMoney" value="${totalMoney+tro.commodity.price*tro.c_count }"></c:set>
                </div>
                <div class="col tro_tab_action" style="cursor: pointer;width: 40px;height: 40px;" onclick="delGoods()">删除</div>
            </div>
	           
             </c:forEach>
        </div>
        
        <div class="tro_close_bot ">
            <!--<p class="tro_bot_ppp">+</p>-->
            <p class="tro_close_p "> <a href="indexServlet?fs=index">继续购物 </a>  | 共<span>1000</span>种商品</p>
           
            <p class="tro_close_p_c">合计:<span id="close">${totalMoney }</span>元</p>
            
            <p class="tro_close_p_r" style="cursor: pointer;" onclick="pay(${totalMoney },${totalCount })">去结算</p>
        </div>

    </div>


   <jsp:include page="footer.jsp"></jsp:include>

   
</body>
</html>
package com.offfcn.servleet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;
import com.offfcn.entity.Category;
import com.offfcn.entity.Commodity;
import com.offfcn.entity.Trolley;
import com.offfcn.entity.User;
import com.offfcn.service.CategoryService;
import com.offfcn.service.CommodityService;
import com.offfcn.service.OrderService;
import com.offfcn.service.TrolleyService;

@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {
	
	private OrderService orderService = new OrderService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String flag=req.getParameter("flag");
		if(null!=flag&&flag.equals("createOrder")) {
			String totalCount= req.getParameter("totalCount");
			String totalMoney= req.getParameter("totalMoney");
			String orderNum = UUID.randomUUID().toString();
			//调用service生成订单表存储
			int i =orderService.saveOrder(totalCount,totalMoney,req,orderNum);
			if(i>0) {
				//跳转支付宝支付页面
				System.out.println(orderNum);
				res.sendRedirect("wappay/pay.jsp?WIDout_trade_no="+orderNum+"&WIDtotal_amount="
						+totalMoney+"&WIDsubject=小米商城收款&WIDbody=商品的描述信息y");
			}else {
				req.getRequestDispatcher("error.jsp").forward(req, res);
			}
			
		}if(null!=flag&&flag.equals("updateOrder")) {
			//获取传递的orderNum订单号 
			String orderNum = req.getParameter("orderNum");
			int i =orderService.updateStateByNum(orderNum);
			if(i>0) {
				//如果更新数据库的订单支付状态成功跳转首页//实际应该跳转订单详情页
				res.sendRedirect("indexServlet");
			}else {
				req.getRequestDispatcher("error.jsp").forward(req, res);
			}
			
			
		}
		
		
	}
}

package com.offfcn.servleet;

import java.io.IOException;
import java.util.List;

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
import com.offfcn.service.TrolleyService;

@WebServlet("/trolleyServlet")
public class TrolleyServlet extends HttpServlet {
	
	
	//创建商品service服务累
	private TrolleyService trolleyService = new TrolleyService();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String flag=req.getParameter("flag");
		if(null!=flag&&flag.equals("listTrolley")) {
			User user = (User) req.getSession().getAttribute("user");
			if(null==user) {
				req.getRequestDispatcher("login.jsp").forward(req, res);
			}else {
				Integer uid = user.getId();
				//通过当前session中存储的user对象id 获取属于登陆用户的购物车商品数据
				List<Trolley> list = trolleyService.findTrolleyList(uid);
				req.setAttribute("trolleyList", list);
				req.getRequestDispatcher("trolley.jsp").forward(req, res);
			}
				
		}if(null!=flag&&flag.equals("addOrdelete")) {
			//获取被编辑数量的id  和num数值
			String id = req.getParameter("id");
			String num = req.getParameter("num");
			int i = trolleyService.updateNumByid(id,num);
			System.out.println(i+"-----执行数量修改后的结果----");
			//修改执行完成后 跳回购物车的列表数据
			res.sendRedirect("trolleyServlet?flag=listTrolley");
		}
		
		
	}
}

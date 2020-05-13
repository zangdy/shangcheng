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
import com.offfcn.service.CategoryService;
import com.offfcn.service.CommodityService;
import com.offfcn.service.TrolleyService;

@WebServlet("/indexServlet")
public class IndexServlet extends HttpServlet {
	
	//创建分类的业务服务类用于查询分类的集合
	private CategoryService cateService = new CategoryService();
	//创建商品service服务累
	private CommodityService commodityService = new CommodityService();
	//创建商品service服务累
	private TrolleyService trolleyService = new TrolleyService();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String flag=req.getParameter("flag");
		if(null!=flag&&flag.equals("addKeyWords")) {
			//将传递的关键词获取
			String keyWords = req.getParameter("keyWords");
			//获取keyWords之后可以 获取原始的存储cookie 拼接字符串存储在原始cookie中存储数据value后 
			Cookie [] cookies = req.getCookies();
			if(null!=cookies&&cookies.length>0) {
				for(Cookie c:cookies) {
					String cname = c.getName();
					if(cname.equals("search_keyWords")) {
						//获取原始存储的cookie value 拼接关键词
						if(!c.getValue().contains(keyWords)) {
							keyWords = c.getValue()+"#"+keyWords;
						}else {
							keyWords=c.getValue();
						}
					}
				}
			}
			//创建cookie对象
			Cookie cookie  = new Cookie("search_keyWords",keyWords);
			cookie.setMaxAge(60*60*24);
			//添加res 保存在浏览器
			res.addCookie(cookie);
			res.getWriter().write("true");
			
		}else if(null!=flag&&flag.equals("detail")) {
			//获取传递的id参数 
			String id  = req.getParameter("id");
			//根据id得到对应的对象跳转到detail的jsp
			Commodity commodity = commodityService.findById(id);
			//数据装入req待会页面
			req.setAttribute("commodity", commodity);
			req.getRequestDispatcher("detail.jsp").forward(req, res);
			
		}else if(null!=flag&&flag.equals("addTrolley")){
			// 调用service 向数据库表中插入购物车的记录存储
			int i =trolleyService.saveTrollery(req);
			//将插入后的数量返回给前端浏览器 作为购物车中数量的展示使用
			System.out.println("返回给前端的数据为：====="+i);
			res.getWriter().write(i+"");
		}else if(null!=flag&&flag.equals("totalTrolley")){
			// 调用service 向数据库表中插入购物车的记录存储
			Long i =trolleyService.findTotalTrolley(req);
			//将插入后的数量返回给前端浏览器 作为购物车中数量的展示使用
			System.out.println("返回给前端的数据为：====="+i);
			res.getWriter().write(i+"");
		}else {
			//负责加载首页需要显示的各种数据
			//查询得到分类的列表数据 待会index.jsp
			List<Category> cateList = cateService.findAllCategory();
			req.setAttribute("cateList", cateList);
			//获取明星单品的list集合
			List<Commodity> starList = commodityService.findCommodityList(5,5);
			req.setAttribute("starList", starList);
			//获取分类的家电商品集合
			List<Commodity> jiadianList = commodityService.findCommodityListByCate();
			req.setAttribute("jiadianList", jiadianList);
			//获取推荐模块的数据
			List<Commodity> recList = null;
			//先判断cookie是否存储过用户浏览的关键词 如果有使用关键词搜索
			Cookie [] cookies = req.getCookies();
			//获取cookie中存储的关键词
			String keyWords = "";
			if(null!=cookies&&cookies.length>0) {
				for(Cookie c:cookies) {
					String cname = c.getName();
					if(cname.equals("search_keyWords")) {
						keyWords = c.getValue();
					}
				}
			}
			if(keyWords.length()>0) {
				 //如果关键词确实存在 使用该关键词搜索商品数据
				recList = commodityService.findCommodityListByKeyWords(keyWords, 4);
			}else {
				 //cookie中没有搜索过的关键词 查询state模块为3的数据
				 recList = commodityService.findCommodityList(3,4);
			}
			
			req.setAttribute("recList", recList);
			//跳转index页面
			req.getRequestDispatcher("index.jsp").forward(req, res);
		}
		
		
	}
}

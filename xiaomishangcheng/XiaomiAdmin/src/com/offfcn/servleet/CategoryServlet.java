package com.offfcn.servleet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offfcn.common.PageBean;
import com.offfcn.entity.Category;
import com.offfcn.service.CategoryService;

//针对当前的用户servlet 可以支持多个路径匹配
@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet {

	 
	//初始化分类的业务service实例
	CategoryService categoryService = new CategoryService();
	
	//专门处理用户请求的方法 但是用户的请求有多种 比如 登陆和注册就两种
	

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//先获取用户的操作标识
		String flag = req.getParameter("flag");
		if(flag.equals("findAll")) {
			//调用service 得到分类的分页数据返回
			String pageNum =req.getParameter("pageNum");
			String pageSize =req.getParameter("pageSize");
			PageBean pb = categoryService.findCategoryPage(pageNum,pageSize);
			//将获取得到的分页对象 包含五个属性的数据 返回浏览器
			req.setAttribute("pb", pb);
			req.getRequestDispatcher("categoryJsp/category_list.jsp").forward(req, res);
		}else if(flag.equals("findOne")) {
			//获取当前被编辑的记录id
			String id = req.getParameter("id");
			Category cate = categoryService.findById(id);
			req.setAttribute("cate", cate);
			req.getRequestDispatcher("categoryJsp/category_update.jsp").forward(req, res);
		}else if(flag.equals("update")) {
			//调用service执行数据库的记录更新
			//获取前端浏览器给 所有参数 调用service保存到数据库
			boolean result = categoryService.updateCategory(req);
			if(result) {
				//保存成功之后 跳转查询所有数据的list页面展示
				res.sendRedirect("categoryServlet?flag=findAll");
			}else {
				req.setAttribute("msg", "服务器繁忙..联系管理员");
				req.getRequestDispatcher("categoryJsp/category_update.jsp").forward(req, res);
			}
			
		}else if(flag.equals("delete")) {
			//获取当前被编辑的记录id
			String id = req.getParameter("id");
			//执行删除逻辑
			boolean result = categoryService.deleteById(id);
			//删除成功跳转查询数据页面
			if(result) {
				//保存成功之后 跳转查询所有数据的list页面展示
				res.sendRedirect("categoryServlet?flag=findAll");
			}else {
				req.setAttribute("msg", "服务器繁忙..联系管理员");
				req.getRequestDispatcher("categoryServlet?flag=findAll").forward(req, res);
			}
			
			
		}else if(flag.equals("add")) {
			//获取前端浏览器给 所有参数 调用service保存到数据库
			boolean result = categoryService.saveCategory(req);
			if(result) {
				//保存成功之后 跳转查询所有数据的list页面展示
				res.sendRedirect("categoryServlet?flag=findAll");
			}else {
				req.setAttribute("msg", "服务器繁忙..联系管理员");
				req.getRequestDispatcher("categoryJsp/category_add.jsp").forward(req, res);
			}
			
		}
		
		
	}
	
	public static void main(String[] args) {
		String s = "abc";
		String s1 = "abc";
		System.out.println(s==s1);
		String s2 = new String ("abcde");
		String s3= new String("abcde");
		System.out.println(s2==s3);
		System.out.println(s2.equals(s3));
	}
	
	
	

}

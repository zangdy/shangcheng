package com.offfcn.servleet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.UploadContext;

import com.offfcn.common.PageBean;
import com.offfcn.entity.Category;
import com.offfcn.entity.Commodity;
import com.offfcn.service.CategoryService;
import com.offfcn.service.CommodityService;

import util.UploadImg;

//针对当前的用户servlet 可以支持多个路径匹配
@WebServlet("/commodityServlet")
@MultipartConfig
public class CommodityServlet extends HttpServlet {

	//初始化分类的业务service实例
	CommodityService commodityService = new CommodityService();
	CategoryService categoryService = new CategoryService();
	
	//专门处理用户请求的方法 但是用户的请求有多种 比如 登陆和注册就两种
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//先获取用户的操作标识
		String flag = req.getParameter("flag");
		if(flag.equals("findAll")) {
			//调用service 得到分类的分页数据返回
			String pageNum =req.getParameter("pageNum");
			String pageSize =req.getParameter("pageSize");
			PageBean pb = commodityService.findComodityPage(pageNum,pageSize);
			//将获取得到的分页对象 包含五个属性的数据 返回浏览器
			req.setAttribute("pb", pb);
			req.getRequestDispatcher("commodity/commodity_list.jsp").forward(req, res);
		}else if(flag.equals("addUI")) {
		   //调用分类的service 得到所有的分类list集合跳转添加商品的页面
			List<Category> cateList = categoryService.findAllCategory();
			req.setAttribute("cateList", cateList);
			req.getRequestDispatcher("commodity/commodity_add.jsp").forward(req, res);
			
		}else if(flag.equals("add")) {
			//获取req中的part对象 判断是否有二进制文件上传
			Part part = req.getPart("pic");
			if(part.getSize()>0) {
				String fileName = UploadImg.uploadImg(part);
				if(fileName.equals("")) {
					req.setAttribute("msg", "文件只支持 jpg jpeg png");
					req.getRequestDispatcher("commodity/commodity_add.jsp").forward(req, res);
					return;
				}else {
					req.setAttribute("pic", fileName);
				}
			}
			//调用service存储商品数据到数据库
			boolean result = commodityService.save(req);
			if(result) {
				res.sendRedirect("commodityServlet?flag=findAll");
			}else {
				req.setAttribute("msg", "添加失败");
				req.getRequestDispatcher("commodity/commodity_add.jsp").forward(req, res);
			}
			
		}else if(flag.equals("findOne")) {
			//获取当前被编辑的记录id
			String id = req.getParameter("id");
			Commodity com = commodityService.findById(id);
			List<Category> cateList = categoryService.findAllCategory();
			req.setAttribute("com", com);
			System.out.println(req.getAttribute("com"));
			req.setAttribute("cateList", cateList);
			req.getRequestDispatcher("commodity/commodity_update.jsp").forward(req, res);
		}else if(flag.equals("update")) {
			//获取原始的数据库图片url
			String picOld = req.getParameter("picOld");
			req.setAttribute("picOld", picOld);
			//判断part对象是否存在文件 如果存在标识它需要重新更改文件
			Part part = req.getPart("pic");
			if(part.getSize()>0) {
				String fileName = UploadImg.uploadImg(part);
				if(fileName.equals("")) {
					req.setAttribute("message", "文件只支持 jpg jpeg png");
					req.getRequestDispatcher("commodity/commodity_add.jsp").forward(req, res);
					return;
				}else {
					req.setAttribute("picOld", fileName);
				}
			}
			//调用service执行数据库的记录更新
			//获取前端浏览器给 所有参数 调用service保存到数据库
			boolean result = commodityService.update(req);
			if(result) {
				res.sendRedirect("commodityServlet?flag=findAll");
			}else {
				req.setAttribute("msg", "添加失败");
				req.getRequestDispatcher("commodity/commodity_add.jsp").forward(req, res);
			}
			
		}else if(flag.equals("delete")) {
			//获取当前被编辑的记录id
			String id = req.getParameter("id");
			//执行删除逻辑
			boolean result = commodityService.deleteById(id);
			//删除成功跳转查询数据页面
			if(result) {
				//保存成功之后 跳转查询所有数据的list页面展示
				res.sendRedirect("categoryServlet?flag=findAll");
			}else {
				req.setAttribute("msg", "服务器繁忙..联系管理员");
				req.getRequestDispatcher("categoryServlet?flag=findAll").forward(req, res);
			}
			
			
		}
	}
	
	
	
	

}

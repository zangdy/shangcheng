package com.offfcn.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class UploadImg {
	
	
	//执行方法之后返回的是上传的文件名称
		public static String uploadImg(Part part,HttpServletRequest req) {
			
			
			//获取上传的文件名称
			String header = part.getHeader("Content-disposition");
			System.out.println(header);
			String fileName = header.substring(header.indexOf("filename")+10, header.length()-1);
			fileName = UUID.randomUUID()+fileName;
			//获取文件的格式 wwangyuting.jpg
			String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
			if(suffix.equals("jpg")||suffix.equals("jpeg")||suffix.equals("png")) {
				//将当前的文件存储到磁盘 最简洁的到操作存储到当前tomcat的项目目录之下
				//获取项目的根路径 就是磁盘下项目的绝对路径  String filePath = req.getServletContext().getRealPath("/");
				String filePath = "D://uploadImg";
				//如果目录不存在代码创建
				File file  = new File(filePath);
				if(!file.exists()) {
					file.mkdir();
				}
				System.out.println(filePath);
				//将文件写入到磁盘
				try {
					part.write(filePath+"/"+fileName);
					//讲更改后的文件名称 传入到req 作为service存储user的数据
					return fileName;
				} catch (IOException e) {
					e.printStackTrace();
					return "" ;
				}
				
			}else {
				
				return "" ;
			}
			
		}

}

package com.offfcn.service;

import java.util.List;

import com.offfcn.dao.CategoryDao;
import com.offfcn.entity.Category;

public class CategoryService {
	
	CategoryDao categoryDao = new CategoryDao();


	
	public List<Category> findAllCategory() {
		
		return categoryDao.findAll();
	}

	
	
}

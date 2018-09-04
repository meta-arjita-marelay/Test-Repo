package com.dao;

import com.entity.Category;

public interface CategoryDao extends BaseDao<Category>{
	public void insert(String title);
	public void updateCategory(Category category, int id);
	
}

package com.facade;


import java.util.List;


import com.dao.CategoryDao;
import com.dao.MySQLCategoryDao;
import com.entity.Category;

public class CategoryFacade {
private static CategoryFacade categoryFacade = new CategoryFacade();
    
	CategoryDao categoryDao = (CategoryDao) MySQLCategoryDao.getInstance();
 
    public static CategoryFacade getInstance(){
    	return categoryFacade;
    }
    public void insertCategory(String name){
    	categoryDao.insert(name);
    }
    public List<Category> getAll(){
    	return categoryDao.getAll();
    }
}

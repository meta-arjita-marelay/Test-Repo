package com.facade;


import java.util.List;


import com.Connection.Status;
import com.dao.AdvertisementDao;
import com.dao.BaseDao;
import com.dao.CategoryDao;
import com.dao.MySQLCategoryDao;
import com.entity.Category;

public class CategoryFacade {

	private static CategoryFacade categoryFacade = new CategoryFacade();

	CategoryDao categoryDao = (CategoryDao) MySQLCategoryDao.getInstance();

	public static CategoryFacade getInstance() {
		return categoryFacade;
	}

	public Status insertCategory(String name) {
		List<Category> categoryList = categoryDao.getAll();

		for (Category category : categoryList) {
			if (category.getName().equals(name)) {
				return Status.DUPLICATE;
			}
		}
		categoryDao.insert(name);
		return Status.INSERTED;
	}

	public List<Category> getAll() {
		return categoryDao.getAll();
	}
	
	public Status updateCategory(int id, Category category) {
		categoryDao.updateCategory(category , id);
		return Status.UPDATED;
	}
}


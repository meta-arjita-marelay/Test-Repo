package com.facade;

import java.util.List;



import com.dao.AdvertisementDao;
import com.dao.CategoryDao;
import com.dao.MySQLAdvertisementDao;
import com.dao.MySQLCategoryDao;
import com.entity.Advertisement;
import com.entity.Category;
import com.Connection.Status;



public class AdvertisementFacade {
	private static AdvertisementFacade advertisementFacade = new AdvertisementFacade();

	AdvertisementDao advertisementDao = (AdvertisementDao) MySQLAdvertisementDao.getInstance();
	CategoryDao categoryDao = (CategoryDao) MySQLCategoryDao.getInstance();

	public static AdvertisementFacade getInstance() {
		return advertisementFacade;
	}

	public Status insertAdvertisement(int category_id, String title, String description) {
		Advertisement advertisement = new Advertisement();
		advertisement.setCategory_id(category_id);
		advertisement.setTitle(title);
		advertisement.setDescription(description);
		List<Advertisement> advertisementList = advertisementDao.getAll();
		List<Category> categoryList = categoryDao.getAll();

		for (Advertisement advert : advertisementList) {
			if (advert.getTitle().equals(advertisement.getTitle())) {
				return Status.DUPLICATE;
			}
		}

		for (Category category : categoryList) {
			if (category.getId() != advertisement.getCategory_id()) {
				return Status.INVALID;
			}
		}

		advertisementDao.insert(advertisement);
		return Status.INSERTED;
	}

	public List<Advertisement> getAll() {
		return advertisementDao.getAll();
	}

	public List<Advertisement> getAllById(int id) {
		return advertisementDao.getAllById(id);
	}

	public Status updateName(String name, int id) {
		advertisementDao.updateName(name, id);
		return Status.UPDATED;
	}

	public void deleteAdv(int id){
		advertisementDao.delete(id);
	}

	
}
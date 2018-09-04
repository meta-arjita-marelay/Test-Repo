package com.metacube.advertismentwebservices.facade;

import java.util.List;

import com.metacube.advertismentwebservices.Common.Status;
import com.metacube.advertismentwebservices.dao.AdvertisementDao;
import com.metacube.advertismentwebservices.dao.CategoryDao;
import com.metacube.advertismentwebservices.dao.AdvertisementDao;
import com.metacube.advertismentwebservices.dao.CategoryDao;
import com.metacube.advertismentwebservices.model.Advertisement;
import com.metacube.advertismentwebservices.model.Category;

/**
 * Facade Class for advertisement table
 */
public class AdvertisementFacade {
	private static AdvertisementFacade advertisementFacade = new AdvertisementFacade();

	AdvertisementDao advertisementDao = (AdvertisementDao) AdvertisementDao
			.getInstance();
	CategoryDao categoryDao = (CategoryDao) CategoryDao.getInstance();

	/**
	 * method to create the singleton object
	 * 
	 * @return object
	 */
	public static AdvertisementFacade getInstance() {
		return advertisementFacade;
	}

	/**
	 * method to insert the data in the advertisement table
	 * 
	 * @param category_id
	 *            id of category
	 * @param title
	 *            title of advertisement
	 * @param description
	 *            description of advertisement
	 * @return
	 */
	public Status insertAdvertisement(int category_id, String title,
			String description) {
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

			if (category.getId() == advertisement.getCategory_id()) {
				advertisementDao.insert(advertisement);
				return Status.INSERTED;
			}
		}
		return Status.INVALID;
	}

	/**
	 * method to get the list of all advertisements
	 * 
	 * @return list of all advertisement
	 */
	public List<Advertisement> getAll() {
		return advertisementDao.getAll();
	}

	/**
	 * method to get the list of advertisements by id
	 * 
	 * @param id
	 *            id of category by which advertisement is to be searched
	 * @return list of advertisement which contain that category
	 */
	public List<Advertisement> getAllById(int id) {
		return advertisementDao.getAllById(id);
	}

	/**
	 * method to return the status updated
	 * 
	 * @param name
	 *            name of updated advertisement
	 * @param id
	 *            id of advertisement which is to be updated
	 * @return status of operation
	 */
	public Status updateName(String name, int id) {
		advertisementDao.updateName(name, id);
		return Status.UPDATED;
	}

	/**
	 * method to return the status deleted
	 * 
	 * @param id
	 *            id of advertisement to be deleted
	 * @return status of operation
	 */
	public Status deleteAdvertisement(int id) {

		List<Advertisement> advertisementList = advertisementDao.getAll();
		for (Advertisement advert : advertisementList) {
			if (advert.getId() == id) {
				advertisementDao.deleteAdvertisement(id);
				return Status.DELETED;
			}
		}
		return Status.NOT_FOUND;
	}

}

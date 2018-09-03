package com.facade;

import java.util.List;

import com.dao.AdvertisementDao;
import com.dao.MySQLAdvertisementDao;
import com.entity.Advertisement;



public class AdvertisementFacade {
	private static AdvertisementFacade advertisementFacade = new AdvertisementFacade();
    
	AdvertisementDao advertisementDao = (AdvertisementDao) MySQLAdvertisementDao.getInstance();
  
    
    public static AdvertisementFacade getInstance(){
    	return advertisementFacade;
    }


	public List<Advertisement> getAll() {
		return advertisementDao.getAll();
	}
	
	public List<Advertisement> getAllById(int id) {
		return advertisementDao.getAllById(id);
	}
	public void updateName(String name,int id){
		advertisementDao.updateName(name, id);
	}
}

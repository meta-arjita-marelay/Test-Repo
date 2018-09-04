package com.dao;

import java.util.List;


import com.entity.Advertisement;
import com.entity.Category;

public interface AdvertisementDao extends BaseDao<Advertisement> {
	public List<Advertisement> getAllById(int id);
	public void updateName(String name,int id);
	public void insert(Advertisement advertisement);
	public void delete(int id);
}

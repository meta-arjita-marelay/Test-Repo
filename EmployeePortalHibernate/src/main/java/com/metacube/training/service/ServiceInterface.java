package com.metacube.training.service;

import java.util.List;

/**
 * Service layer provides interface between database and controllers
 * 
 * @author Arjita
 *
 * @param <Object>
 */
@SuppressWarnings("hiding")
public interface ServiceInterface<Object> {
	/**
	 * method to get data of object by ID
	 * 
	 * @param id
	 * @return generic object
	 */
	Object getInfoById(int id);

	/**
	 * get all info of object
	 * 
	 * @return list of all objects
	 */
	List<Object> getAllInfo();

	/**
	 * method to delete info of given object by id
	 * 
	 * @param id
	 *            object id which is to be deleted
	 * @return true if successfully deleted els false
	 */
	boolean deleteInfo(int id);

	/**
	 * method to update info of object
	 * 
	 * @param object
	 *            object details which is to be updated
	 * @return true if successfully updated else false
	 */
	boolean updateInfo(Object object);

	/**
	 * method to insert object in quantity
	 * 
	 * @param object
	 * @return true if successfully inserted else false
	 */
	boolean create(Object object);

}

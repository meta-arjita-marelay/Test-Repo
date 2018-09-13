package com.metacube.training.dao;

import java.util.List;

@SuppressWarnings("hiding")
public interface DAOInterface<Object> {
	/**
	 * method to get all info of tables by id
	 * 
	 * @param id
	 *            of attribute whose details is to be selected
	 * @return object of pojo class whose details is selected
	 */
	Object getInfoById(int id);

	/**
	 * get all info from tables
	 * 
	 * @return list of object of pojos
	 */
	List<Object> getAllInfo();

	/**
	 * method to delete details of attributes through id
	 * 
	 * @param id
	 *            object id which is to be deleted
	 * @return true if successfully deleted else false
	 */
	boolean deleteInfo(int id);

	/**
	 * method to update info objects
	 * 
	 * @param object
	 *            details which is to be updated
	 * @return true if successfully updated else false
	 */
	boolean updateInfo(Object object);

	/**
	 * methos to insert or add object in tables
	 * 
	 * @param object
	 *            object which is to be added
	 * @returnc true if successfully added else false
	 */
	boolean create(Object object);

}

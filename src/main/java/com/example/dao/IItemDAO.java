package com.example.dao;

import com.example.data.IItem;

public interface IItemDAO {
	
	/**
	 * Method to save data to DB
	 * @param item
	 */
	void saveItem(IItem item);

}

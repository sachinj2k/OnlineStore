package com.example.dao;

import org.springframework.stereotype.Repository;

import com.example.data.IItem;

@Repository
public class ItemDAO implements IItemDAO{

	@Override
	public void saveItem(IItem item) {
		
		System.out.println(item);
	}
	
	

}

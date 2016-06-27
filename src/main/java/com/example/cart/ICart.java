package com.example.cart;

import java.math.BigDecimal;

import com.example.data.IItem;

public interface ICart {
	
	/*
	 *Add item to cart 
	 */
	void addItemToCart(IItem item);
	/**
	 * get total cost
	 * @return
	 */
	BigDecimal getTotalCost();
	/**
	 * Get total sales tax
	 * @return
	 */
	BigDecimal getSalesTax();
	/**
	 * print itemized bill
	 */
	void printItemizedBill();
}

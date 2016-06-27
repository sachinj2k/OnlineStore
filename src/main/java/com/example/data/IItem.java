package com.example.data;

import java.math.BigDecimal;

public interface IItem {
	
	String getName();
	ItemsCategoryEnum getItemCategory();
	void SetItemCategory(ItemsCategoryEnum categoryEnum);
	BigDecimal getItemPrice();
	void setItemPrice(BigDecimal price);
	BigDecimal getItemPriceWithTax();
	BigDecimal getItemSalesTax();
	void setName(String name);

}

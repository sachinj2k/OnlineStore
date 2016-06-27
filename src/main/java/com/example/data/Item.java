package com.example.data;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.example.salesTax.ITaxCalculator;

@Named
@Scope("prototype")
public class Item implements IItem {
	
	private String name;
	private BigDecimal price;
	private ItemsCategoryEnum itemCategory;
	private ITaxCalculator calculator;
	
	@Inject
	public void setCalculator(ITaxCalculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}


	public ItemsCategoryEnum getItemCategory() {
		return itemCategory;
	}

	public BigDecimal getItemPrice() {
		return this.price;
	}

	public void setItemPrice(BigDecimal price) {
		this.price = price;

	}

	public BigDecimal getItemPriceWithTax() {
		return getItemSalesTax().add(getItemPrice()) ;
	}

	public BigDecimal getItemSalesTax() {
		return calculator.calculateSalesTax(this);
	}

	@Override
	public String toString() {
		return this.getName() + this.getItemSalesTax();
	}

	@Override
	public void SetItemCategory(ItemsCategoryEnum categoryEnum) {
        this.itemCategory = categoryEnum;		
	}
}

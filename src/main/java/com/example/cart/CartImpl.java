package com.example.cart;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Named;

import com.example.data.IItem;

@Named
public class CartImpl implements ICart{
	
	private List<IItem> itemsList;
	private BigDecimal totalCost = new BigDecimal(0);
	private BigDecimal salesTax = new BigDecimal(0);
	private static final Format FORMATTER = new DecimalFormat("0.00");
	
	public CartImpl(){
		
	}
	public CartImpl(List<IItem> itemsList) {
		this.itemsList = itemsList;
	}
	
	public List<IItem> getItemsList() {
		return Collections.unmodifiableList(itemsList);
	}

	@Override
	public void addItemToCart(IItem item) {
		if(itemsList==null)
		{
			itemsList = new ArrayList<>();
		}
			itemsList.add(item);
	}

	@Override
	public BigDecimal getTotalCost() {
		return new BigDecimal(FORMATTER.format(totalCost));
	}

	@Override
	public BigDecimal getSalesTax() {
		return new BigDecimal(FORMATTER.format(salesTax));
	}

	@Override
	public void printItemizedBill() {
		StringBuilder buffer = new StringBuilder();
		for (IItem item : itemsList) {
			buffer.append("\n").append(item.toString());
			totalCost = totalCost.add(item.getItemPriceWithTax());
			salesTax = salesTax.add(item.getItemSalesTax());
		}
		buffer.append("\nSales Tax:" + FORMATTER.format(salesTax));
		buffer.append("\nTotal :" + FORMATTER.format(totalCost));
		System.out.println(buffer.toString());
	}
	
	@Override
	public String toString(){
		StringBuilder buffer = new StringBuilder();
		for (IItem item : itemsList) {
			buffer.append("\n").append(item.toString());
		}
		return buffer.toString();
	}
}

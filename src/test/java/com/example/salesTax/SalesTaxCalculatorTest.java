package com.example.salesTax;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.example.data.IItem;
import com.example.data.Item;
import com.example.data.ItemsCategoryEnum;

import junit.framework.Assert;

public class SalesTaxCalculatorTest {
	
	IItem item;
	SalesTaxCalculator calculator;
	@Before
	public void setup()
	{
		item = new Item();
		item.setName("test");
		item.setItemPrice(new BigDecimal(10.10));
		item.SetItemCategory(ItemsCategoryEnum.A);
		calculator = new SalesTaxCalculator();
	}
	
	@Test
	public void getItemTaxTypeTest()
	{
		ItemTaxEnum value = calculator.getItemTaxType(item);
		System.out.println(value);
		Assert.assertEquals(ItemTaxEnum.A, value);
	}
	
	@Test
	public void calculateSalesTaxTest()
	{
		System.out.println(new BigDecimal(10/100d));
		BigDecimal value = calculator.calculateSalesTax(item);
		System.out.println(value);
		Assert.assertEquals(new BigDecimal(1.01).setScale(2, BigDecimal.ROUND_HALF_UP), value);
	}

}

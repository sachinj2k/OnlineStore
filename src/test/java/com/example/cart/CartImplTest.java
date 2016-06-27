package com.example.cart;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.example.data.Item;
import com.example.data.ItemsCategoryEnum;
import com.example.salesTax.ITaxCalculator;

import junit.framework.Assert;

public class CartImplTest {
	
	private CartImpl cartImpl;
	private Item item;
	private ITaxCalculator calculator = Mockito.mock(ITaxCalculator.class);
	
	@Before
	public void setUp()
	{
		cartImpl = new CartImpl();
		item = new Item();
		item.setItemPrice(new BigDecimal(10.17));
		item.setName("test");
		item.setCalculator(calculator);
		item.SetItemCategory(ItemsCategoryEnum.B);
	}
	
	@Test
	public void addItemToCartTest()
	{
		cartImpl.addItemToCart(item);
		Assert.assertEquals(1, cartImpl.getItemsList().size());
	}
	
	@Test
	public void printItemizedBillTest()
	{
		cartImpl.addItemToCart(item);
		Mockito.when(calculator.calculateSalesTax(item)).thenReturn(new BigDecimal(2.21));
		cartImpl.printItemizedBill();
		
		Assert.assertEquals(cartImpl.getTotalCost(), new BigDecimal("12.38"));
		
	}
	

}

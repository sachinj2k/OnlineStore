package com.example.data;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.example.salesTax.ITaxCalculator;

import junit.framework.Assert;

public class ItemTest {
	
	ITaxCalculator calculator = Mockito.mock(ITaxCalculator.class);
	
	@Before
	public void setUp()
	{
		
	}
	
	@Test
	public void getItemPriceWithTaxTest()
   {
	 Item item = new Item();
	 item.setPrice(new BigDecimal(10.10));
	 item.setCalculator(calculator);
	 Mockito.when(calculator.calculateSalesTax(item)).thenReturn(new BigDecimal(1.05));
	 Assert.assertEquals(new BigDecimal(11.15), item.getItemPriceWithTax());
   }
}

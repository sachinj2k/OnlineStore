package com.example.util;

import java.math.BigDecimal;

import org.junit.Test;

import junit.framework.Assert;

public class AppUtilTest {
	
	@Test
	public void roundOffTest()
	{
		BigDecimal number = AppUtils.roundOff(new BigDecimal(11.167));
		System.out.println(number);
		Assert.assertEquals(new BigDecimal(11.17), number);
	}

}

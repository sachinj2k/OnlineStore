package com.example.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class AppUtils {
	
	public static final Float ROUND_OFF = 0.05f;
	public static BigDecimal roundOff(BigDecimal tax)
	{
		DecimalFormat df = new DecimalFormat("#.00");
		return new BigDecimal(df.format(tax));
		//return (float) df.format(tax);
		//return (float) Math.ceil((tax*100)/100);
	}

}

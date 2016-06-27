package com.example.salesTax;

import java.math.BigDecimal;

public enum ItemTaxEnum {
	
	A(new BigDecimal(10/100d).setScale(2, BigDecimal.ROUND_HALF_UP)),
	B(new BigDecimal(20/100d).setScale(2, BigDecimal.ROUND_HALF_UP)),
	C(new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));
	
    private BigDecimal applicableTax;
	
	ItemTaxEnum(BigDecimal tax)
	{
		this.applicableTax = tax;
		
	}
	
	public BigDecimal getApplicableTax() {
		return applicableTax;
	}
	
}

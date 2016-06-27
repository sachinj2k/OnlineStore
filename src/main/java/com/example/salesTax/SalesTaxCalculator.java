package com.example.salesTax;

import java.math.BigDecimal;

import javax.inject.Named;

import com.example.data.IItem;
import com.example.util.AppUtils;

@Named
public class SalesTaxCalculator implements ITaxCalculator{

	@Override
	public BigDecimal calculateSalesTax(IItem item) {
		
		return AppUtils.roundOff((getItemTaxType(item).getApplicableTax().multiply(item.getItemPrice())));
	}
  
	ItemTaxEnum getItemTaxType(IItem item)
	{
		switch (item.getItemCategory())
		{
		case A :
			return ItemTaxEnum.A;
		case B:
			return ItemTaxEnum.B;
		case C:
			return ItemTaxEnum.C;
		default:
			return null;
		}
	}
}

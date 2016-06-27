package com.example.salesTax;

import java.math.BigDecimal;

import com.example.data.IItem;

public interface ITaxCalculator {

	BigDecimal calculateSalesTax(IItem item);
}

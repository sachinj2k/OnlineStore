 package com.example.cart;
 
 import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.IItemDAO;
import com.example.data.IItem;
import com.example.data.ItemsCategoryEnum;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext(new String[] {"/spring/Spring-Config.xml"});
		
       	
       ICart cart = (ICart)context.getBean("cartImpl");
       IItemDAO itemDAO = (IItemDAO) context.getBean("itemDAO");
       for(int i=0;i<4;i++)
       {
    	   IItem item = readInputData(context);
           cart.addItemToCart(item);
           itemDAO.saveItem(item);
       }
       System.out.println(cart.getTotalCost());
       cart.printItemizedBill();

	}
	
	/**
	 * 
	 * @param context
	 * @return
	 */
	private static IItem readInputData(ApplicationContext context)
	{
		IItem item = (IItem)context.getBean("item");
		item.setName("book");
		item.setItemPrice(new BigDecimal(10.10));
		ItemsCategoryEnum value = ItemsCategoryEnum.valueOf("A");
		item.SetItemCategory(value);
		return item;
	}

}

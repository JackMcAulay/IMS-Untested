package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ItemTest {
	private Item testItem = new Item(1l,"Pepsi",1.99,100L);
	private Item testItem2 = new Item(1l,"Pepsi",1.99,100L);
	private Item testItem3 = new Item(2l,"Pepsi",1.99,100L);
	private Item nullItem1 = new Item(null,null,null,null);
	private Item nullItem2 = new Item(1l,null,null,null);
	private Item nullItem3 = new Item(1l,"Pepsi",null,null);
	private Item nullItem4 = new Item(1l,"piers",1.99,null);
	private Customer testCustomer = new Customer(1l,"jack","mcaulay");
	
	@Test
	public void testSetters() {
		testItem.setId(2l);
		testItem.setName("Coke");
		testItem.setPrice(2.10);
		testItem.setQuantity(110L);
		assertFalse(testItem.equals(testItem2));
	}
	
	@Test
	public void testGetters() {
		long id = 1l, quantity = 100L;
		String name = "Pepsi";
		double price = 1.99;
		assertTrue(testItem.getId().equals(id));
		assertTrue(testItem.getName().equals(name));
		assertTrue(testItem.getPrice().equals(price));
		assertTrue(testItem.getQuantity().equals(quantity));
	}
	
	@Test
	public void testEquals() {
		assertFalse(nullItem1.equals(testItem));
		assertFalse(nullItem2.equals(testItem));
		assertFalse(nullItem3.equals(testItem));
		assertFalse(nullItem4.equals(testItem));
		assertFalse(testItem.equals(nullItem1));
		assertFalse(testItem.equals(nullItem2));
		assertFalse(testItem.equals(nullItem3));
		assertFalse(testItem.equals(nullItem4));
		assertTrue(testItem.equals(testItem));
		assertFalse(testItem.equals(null));
		assertFalse(testItem.equals(testCustomer));
		assertFalse(testItem.equals(testItem3));
	}
}

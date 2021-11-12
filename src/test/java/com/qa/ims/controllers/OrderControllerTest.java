package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;
	
	@Mock
	private CustomerDAO customerDAO;
	
	@Mock
	private ItemDAO itemDAO;

	@InjectMocks
	private OrderController controller;
	
	@Test
	public void testCreate() {
		final long ID = 1L;
		final Customer TEST_CUSTOMER = new Customer(ID, "jack", "mcaulay");
		final Item TEST_ITEM = new Item(ID, "Pepsi", 1.50, 90L);
		List<Item> items = new ArrayList<>();
		items.add(TEST_ITEM);
		final Order created = new Order(ID, TEST_CUSTOMER, items);
		
		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(utils.getLong()).thenReturn(ID);
		dao.createLine(ID, ID);
		Mockito.when(utils.getString()).thenReturn("no");
		Mockito.when(dao.readLatest()).thenReturn(created);

		assertEquals(created, controller.create());
	}
}

package com.uciext.ws.hw4.backend;

import java.util.Collection;

import com.uciext.ws.hw4.backend.model.CatalogDAO;
import com.uciext.ws.hw4.backend.model.OrderConfirmDAO;
import com.uciext.ws.hw4.backend.model.OrderDAO;

public interface InventoryManager {

	public CatalogDAO getCatalog();
	
	public OrderConfirmDAO processOrder(OrderDAO order) throws Exception;
}
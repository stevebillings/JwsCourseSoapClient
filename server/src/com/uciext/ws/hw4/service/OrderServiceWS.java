package com.uciext.ws.hw4.service;

import java.util.Collection;

import javax.xml.bind.JAXBElement;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;

import com.uciext.ws.hw4.service.model.catalog.Catalog;
import com.uciext.ws.hw4.service.model.order.Order;
import com.uciext.ws.hw4.service.model.orderconfirm.OrderConfirm;

@WebService(targetNamespace = "http://inventory.service.hw4.ws.uciext.com")
public interface OrderServiceWS {

	@WebMethod
	public String hello();
		
	@WebMethod(operationName="catalog")
	public Catalog getCatalog();
		
	public OrderConfirm submitOrder(
			@WebParam(name="order", targetNamespace="http://inventory.service.hw4.ws.uciext.com") Order order) 
		throws Exception;
}

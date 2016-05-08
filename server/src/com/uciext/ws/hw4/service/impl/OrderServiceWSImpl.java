package com.uciext.ws.hw4.service.impl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.uciext.ws.hw4.backend.InventoryManager;
import com.uciext.ws.hw4.backend.impl.InventoryManagerImpl;
import com.uciext.ws.hw4.backend.model.CatalogDAO;
import com.uciext.ws.hw4.backend.model.OrderDAO;
import com.uciext.ws.hw4.backend.model.OrderConfirmDAO;
import com.uciext.ws.hw4.backend.model.ProductDAO;
import com.uciext.ws.hw4.backend.model.ProductOrderDAO;

import com.uciext.ws.hw4.service.OrderServiceWS;
import com.uciext.ws.hw4.service.model.catalog.Catalog;
import com.uciext.ws.hw4.service.model.catalog.Product;
import com.uciext.ws.hw4.service.model.order.Order;
import com.uciext.ws.hw4.service.model.order.ProductOrder;
import com.uciext.ws.hw4.service.model.orderconfirm.OrderConfirm;
import com.uciext.ws.hw4.service.model.orderconfirm.ProductConfirm;
import com.uciext.ws.hw4.util.Util;

@WebService(
   portName = "OrderPort",
   serviceName = "OrderService",
   targetNamespace = "http://inventory.service.hw4.ws.uciext.com",
   endpointInterface = "com.uciext.ws.hw4.service.OrderServiceWS")
public class OrderServiceWSImpl implements OrderServiceWS {
	
	private InventoryManager inventoryManager = new InventoryManagerImpl();

	private DateFormat df = new SimpleDateFormat("MM-dd-yyyy");

  // Hello operation to test the SOAP web service
	@Override
	public String hello() {		
		Util.log("SOAP /ws/ordering/hello request");
	  
		return "Hello from Order Service WS [" + (new java.util.Date() + "]");
	}


	// Get catalog
	@Override
	public Catalog getCatalog() {		
		Util.log("SOAP /ws/ordering/catalog request");

		// Get data
		CatalogDAO catalogDAO = inventoryManager.getCatalog();

		// Create a response
		Catalog response = new Catalog();
		response.setLastModifiedDate(df.format(catalogDAO.getLastModifiedDate()));
		response.setDescription(catalogDAO.getDescription());

		List<Product> productList = response.getProduct();
		for (ProductDAO productDAO : catalogDAO.getProductList()) {
			Product product = new Product();
			product.setSku(productDAO.getSku());
			product.setName(productDAO.getProductName());
			product.setPrice(productDAO.getPrice());
			product.setQuantity(productDAO.getQuantity());
			
			productList.add(product);
		}
		
		Util.log("SOAP /ws/ordering/catalog response");
		return response;
	}

	// Submit order
	@Override
	public OrderConfirm submitOrder(Order order) throws Exception {		

		Util.log("SOAP /ws/ordering/submitOrder request APP/XML");

		// Process order
		OrderConfirm response = processOrder(order);

		Util.log("SOAP /ws/ordering/order response APP/XML");
		return response;
	}

	// PRIVATE

	private OrderConfirm processOrder(Order order) throws Exception {
		
		// Map the request object to the backend model
		OrderDAO orderDAO = new OrderDAO();

		orderDAO.setVendorName(order.getVendorName());		
		orderDAO.setVendorCode(order.getVendorCode());		
		orderDAO.setOrderNumber(order.getOrderNumber());		
	
		Util.log("Received productOrders=" + order.getProductOrder().size());	
    List<ProductOrderDAO> productOrderList = new ArrayList<ProductOrderDAO>();
		for (ProductOrder productOrder : order.getProductOrder()) {
			ProductOrderDAO productOrderDAO = new ProductOrderDAO();
			productOrderDAO.setOrderQuantity(productOrder.getOrderQuantity());
			ProductDAO productDAO = new ProductDAO();
			productDAO.setSku(productOrder.getProductSku());
			productDAO.setProductName(productOrder.getProductName());
			productOrderDAO.setProduct(productDAO);
			Util.log(productOrderDAO.toString());
						
			productOrderList.add(productOrderDAO);
		}
		orderDAO.setProductOrderList(productOrderList);
		
		// Process order
		OrderConfirmDAO orderConfirmDAO = inventoryManager.processOrder(orderDAO);
		
		// Map the order confirmation from backend model to the service
		OrderConfirm orderConfirm = new OrderConfirm();
		orderConfirm.setVendorCode(orderConfirmDAO.getVendorCode());		
		orderConfirm.setOrderNumber(orderConfirmDAO.getOrderNumber());		
		orderConfirm.setConfirmNumber(String.valueOf(orderConfirmDAO.getOrderConfirmId()));		
		orderConfirm.setTotalOrderPrice(orderConfirmDAO.getTotalOrderPrice());		
		
    List<ProductConfirm> productConfirmList = new ArrayList<ProductConfirm>();
		for (ProductOrderDAO productOrderDAO : orderConfirmDAO.getProductOrderList()) {
			ProductConfirm productConfirm = new ProductConfirm();
			productConfirm.setProductSku(productOrderDAO.getProduct().getSku());
			productConfirm.setOrderQuantity(productOrderDAO.getOrderQuantity());
			productConfirm.setPrice(productOrderDAO.getProduct().getPrice());
			
			orderConfirm.getProductConfirm().add(productConfirm);
		}
		return orderConfirm;
	}
}

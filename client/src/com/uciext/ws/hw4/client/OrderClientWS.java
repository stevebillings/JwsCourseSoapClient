package com.uciext.ws.hw4.client;

import javax.xml.ws.WebServiceRef;

import com.uciext.ws.hw4.service.inventory.CatalogResponse;
import com.uciext.ws.hw4.service.inventory.Order;
import com.uciext.ws.hw4.service.inventory.OrderService;
import com.uciext.ws.hw4.service.inventory.OrderServiceWS;
import com.uciext.ws.hw4.service.inventory.Product;
import com.uciext.ws.hw4.service.inventory.ProductConfirm;
import com.uciext.ws.hw4.service.inventory.ProductOrder;
import com.uciext.ws.hw4.service.inventory.SubmitOrderResponse;

public class OrderClientWS {
	@WebServiceRef(wsdlLocation = "http://localhost:8080/inventoryWS/ws/OrderServiceHw4?wsdl")
	private static OrderService service;

	public static void main(String[] argv) {

		if (argv.length < 1) {
			System.out.println("ERROR: Missing argument");
			printCommandUsage();
			System.exit(1);
		}
		String operation = argv[0];

		try {
			service = new OrderService();
			OrderServiceWS port = service.getOrderPort();

			if ("Hello".equals(operation)) {
				String response = port.hello();
				System.out.println(response);
			} else if ("Get_Catalog".equalsIgnoreCase(operation)) {
				CatalogResponse catalogResponse = port.catalog(null);
				System.out.println(toString(catalogResponse));
			} else if ("Submit_Order".equalsIgnoreCase(operation)) {
				Order order = new Order();
				order.setOrderNumber("1");
				order.setVendorCode("333");
				order.setVendorName("Vendor333");

				ProductOrder productOrder = new ProductOrder();
				productOrder.setProductName("Kindle Fire");
				productOrder.setProductSku("111003392854");
				productOrder.setOrderQuantity(2.0);
				order.getProductOrder().add(productOrder);

				productOrder = new ProductOrder();
				productOrder.setProductName("Kindle Paperwhite");
				productOrder.setProductSku("111003392994");
				productOrder.setOrderQuantity(3.0);
				order.getProductOrder().add(productOrder);

				SubmitOrderResponse.Return orderReturn = port.submitOrder(order);
				System.out.println(toString(orderReturn));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String toString(SubmitOrderResponse.Return orderReturn) {
		StringBuilder sb = new StringBuilder();
		sb.append("Order #:");
		sb.append(orderReturn.getOrderNumber());
		sb.append('\n');
		sb.append("Confirm #: ");
		sb.append(orderReturn.getConfirmNumber());
		sb.append('\n');
		sb.append("Total order price: ");
		sb.append(orderReturn.getTotalOrderPrice());
		sb.append('\n');
		sb.append("Vendor code: ");
		sb.append(orderReturn.getVendorCode());
		sb.append('\n');
		for (ProductConfirm productConfirm : orderReturn.getProductConfirm()) {
			sb.append('\n');
			sb.append("SKU: ");
			sb.append(productConfirm.getProductSku());
			sb.append('\n');
			sb.append("Quantity: ");
			sb.append(productConfirm.getOrderQuantity());
			sb.append('\n');
			sb.append("Price: ");
			sb.append(productConfirm.getPrice());
			sb.append('\n');

		}
		return sb.toString();
	}

	private static String toString(CatalogResponse catalog) {
		StringBuilder sb = new StringBuilder();
		sb.append("Catalog description: ");
		sb.append(catalog.getReturn().getDescription());
		sb.append('\n');

		sb.append("Last modified: ");
		sb.append(catalog.getReturn().getLastModifiedDate());
		sb.append('\n');

		for (Product product : catalog.getReturn().getProduct()) {
			sb.append('\n');
			sb.append("\tProduct name: ");
			sb.append("\t" + product.getName());
			sb.append('\n');

			sb.append("\tProduct sku: ");
			sb.append("\t" + product.getSku());
			sb.append('\n');

			sb.append("\tProduct price: ");
			sb.append("\t" + product.getPrice());
			sb.append('\n');

			sb.append("\tProduct quantity: ");
			sb.append("\t" + product.getQuantity());
			sb.append('\n');
		}

		return sb.toString();
	}

	private static void printCommandUsage() {
		System.err.println("Usage for get hello message: java OrderClientWS Hello");
		System.err.println("Usage for get catalog: java OrderClientWS Get_Catalog");
		System.err.println("Usage for submit order: java OrderClientWS Submit_Order");
		System.err.println("Usage for run sequence: java OrderClientWS Run_Sequence");
	}
}

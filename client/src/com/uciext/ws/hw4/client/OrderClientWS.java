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

	private static int orderNumber = 1;

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
				Order order = createOrderFireAndPaperWhite(2, 2);
				SubmitOrderResponse.Return orderReturn = port.submitOrder(order);
				System.out.println(toString(orderReturn));
			} else if ("Run_Sequence".equalsIgnoreCase(operation)) {
				System.out.println(toString(port.catalog(null)));
				System.out.println(toString(port.submitOrder(createOrderFireAndPaperWhite(5.0, 4.0))));
				System.out.println(toString(port.submitOrder(createOrderFireAndPaperWhite(5.0, 7.0))));
				System.out.println(toString(port.submitOrder(createOrderFireAndPaperWhite(5.0, 4.0))));
				System.out.println(toString(port.submitOrder(createOrderFireAndPaperWhite(5.0, 4.0))));
				System.out.println(toString(port.catalog(null)));
			} else {
				System.out.println("ERROR: Invalid argument: " + operation);
				printCommandUsage();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Order createOrderFireAndPaperWhite(double fireQuantity, double paperWhiteQuantity) {
		System.out.println(
				"\nOrdering " + fireQuantity + " Kindle Fire(s) and " + paperWhiteQuantity + " Kindle PaperWhite(s)");

		Order order = new Order();
		order.setOrderNumber(String.valueOf(orderNumber++));
		order.setVendorCode("333");
		order.setVendorName("Vendor333");

		ProductOrder fireOrder = new ProductOrder();
		fireOrder.setProductName("Kindle Fire");
		fireOrder.setProductSku("111003392854");
		fireOrder.setOrderQuantity(fireQuantity);
		order.getProductOrder().add(fireOrder);

		ProductOrder paperWhiteOrder = new ProductOrder();
		paperWhiteOrder.setProductName("Kindle Paperwhite");
		paperWhiteOrder.setProductSku("111003392994");
		paperWhiteOrder.setOrderQuantity(paperWhiteQuantity);
		order.getProductOrder().add(paperWhiteOrder);
		return order;
	}

	private static String toString(SubmitOrderResponse.Return orderReturn) {
		StringBuilder sb = new StringBuilder();
		sb.append("\nORDER CONFIRMATION:\nOrder #:");
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
		sb.append("\nCATALOG:\nCatalog description: ");
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

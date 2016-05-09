package com.uciext.ws.hw4.client;

import javax.xml.ws.WebServiceRef;

import com.uciext.ws.hw4.service.inventory.CatalogResponse;
import com.uciext.ws.hw4.service.inventory.OrderService;
import com.uciext.ws.hw4.service.inventory.OrderServiceWS;
import com.uciext.ws.hw4.service.inventory.Product;

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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		System.err.println("Usage for InventoryClient: java InventoryClient Hello");
		System.err.println("Usage for Get Students Count: java StudentClientWS Get_Students_Count");
		// System.err.println("Usage for Get Student: java StudentClientWS
		// Get_Student");
		// System.err.println("Usage for Update Student with XML: java
		// StudentClientWS Update_Student [middleName]");
		// System.err.println("Usage for Get Students: java StudentClientWS
		// Get_Students");
	}
}

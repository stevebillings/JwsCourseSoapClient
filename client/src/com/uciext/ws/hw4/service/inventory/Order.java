
package com.uciext.ws.hw4.service.inventory;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vendorCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vendorName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="orderNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://inventory.service.hw4.ws.uciext.com}productOrder" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "vendorCode", "vendorName", "orderNumber", "productOrder" })
@XmlRootElement(name = "order")
public class Order {

	@XmlElement(required = true)
	protected String vendorCode;
	@XmlElement(required = true)
	protected String vendorName;
	@XmlElement(required = true)
	protected String orderNumber;
	@XmlElement(required = true)
	protected List<ProductOrder> productOrder;

	/**
	 * Gets the value of the vendorCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVendorCode() {
		return vendorCode;
	}

	/**
	 * Sets the value of the vendorCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVendorCode(String value) {
		this.vendorCode = value;
	}

	/**
	 * Gets the value of the vendorName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * Sets the value of the vendorName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVendorName(String value) {
		this.vendorName = value;
	}

	/**
	 * Gets the value of the orderNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * Sets the value of the orderNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderNumber(String value) {
		this.orderNumber = value;
	}

	/**
	 * Gets the value of the productOrder property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the productOrder property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getProductOrder().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ProductOrder }
	 * 
	 * 
	 */
	public List<ProductOrder> getProductOrder() {
		if (productOrder == null) {
			productOrder = new ArrayList<ProductOrder>();
		}
		return this.productOrder;
	}

}

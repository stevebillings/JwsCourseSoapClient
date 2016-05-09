
package com.uciext.ws.hw4.service.inventory;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for catalogResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="catalogResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="lastModifiedDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element ref="{http://inventory.service.hw4.ws.uciext.com}product" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "catalogResponse", propOrder = { "_return" })
public class CatalogResponse {

	@XmlElement(name = "return")
	protected CatalogResponse.Return _return;

	/**
	 * Gets the value of the return property.
	 * 
	 * @return possible object is {@link CatalogResponse.Return }
	 * 
	 */
	public CatalogResponse.Return getReturn() {
		return _return;
	}

	/**
	 * Sets the value of the return property.
	 * 
	 * @param value
	 *            allowed object is {@link CatalogResponse.Return }
	 * 
	 */
	public void setReturn(CatalogResponse.Return value) {
		this._return = value;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="lastModifiedDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element ref="{http://inventory.service.hw4.ws.uciext.com}product" maxOccurs="unbounded"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "lastModifiedDate", "description", "product" })
	public static class Return {

		@XmlElement(required = true)
		protected String lastModifiedDate;
		@XmlElement(required = true)
		protected String description;
		@XmlElement(required = true)
		protected List<Product> product;

		/**
		 * Gets the value of the lastModifiedDate property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getLastModifiedDate() {
			return lastModifiedDate;
		}

		/**
		 * Sets the value of the lastModifiedDate property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setLastModifiedDate(String value) {
			this.lastModifiedDate = value;
		}

		/**
		 * Gets the value of the description property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * Sets the value of the description property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setDescription(String value) {
			this.description = value;
		}

		/**
		 * Gets the value of the product property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list, not a
		 * snapshot. Therefore any modification you make to the returned list
		 * will be present inside the JAXB object. This is why there is not a
		 * <CODE>set</CODE> method for the product property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getProduct().add(newItem);
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link Product }
		 * 
		 * 
		 */
		public List<Product> getProduct() {
			if (product == null) {
				product = new ArrayList<Product>();
			}
			return this.product;
		}

	}

}

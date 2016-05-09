
package com.uciext.ws.hw4.service.inventory;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for submitOrderResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="submitOrderResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="vendorCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="orderNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="confirmNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element ref="{http://inventory.service.hw4.ws.uciext.com}productConfirm" maxOccurs="unbounded"/>
 *                   &lt;element name="totalOrderPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
@XmlType(name = "submitOrderResponse", propOrder = {
    "_return"
})
public class SubmitOrderResponse {

    @XmlElement(name = "return")
    protected SubmitOrderResponse.Return _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link SubmitOrderResponse.Return }
     *     
     */
    public SubmitOrderResponse.Return getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubmitOrderResponse.Return }
     *     
     */
    public void setReturn(SubmitOrderResponse.Return value) {
        this._return = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="vendorCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="orderNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="confirmNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element ref="{http://inventory.service.hw4.ws.uciext.com}productConfirm" maxOccurs="unbounded"/>
     *         &lt;element name="totalOrderPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "vendorCode",
        "orderNumber",
        "confirmNumber",
        "productConfirm",
        "totalOrderPrice"
    })
    public static class Return {

        @XmlElement(required = true)
        protected String vendorCode;
        @XmlElement(required = true)
        protected String orderNumber;
        @XmlElement(required = true)
        protected String confirmNumber;
        @XmlElement(namespace = "http://inventory.service.hw4.ws.uciext.com", required = true)
        protected List<ProductConfirm> productConfirm;
        protected double totalOrderPrice;

        /**
         * Gets the value of the vendorCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVendorCode() {
            return vendorCode;
        }

        /**
         * Sets the value of the vendorCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVendorCode(String value) {
            this.vendorCode = value;
        }

        /**
         * Gets the value of the orderNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrderNumber() {
            return orderNumber;
        }

        /**
         * Sets the value of the orderNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrderNumber(String value) {
            this.orderNumber = value;
        }

        /**
         * Gets the value of the confirmNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getConfirmNumber() {
            return confirmNumber;
        }

        /**
         * Sets the value of the confirmNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setConfirmNumber(String value) {
            this.confirmNumber = value;
        }

        /**
         * Gets the value of the productConfirm property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the productConfirm property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProductConfirm().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ProductConfirm }
         * 
         * 
         */
        public List<ProductConfirm> getProductConfirm() {
            if (productConfirm == null) {
                productConfirm = new ArrayList<ProductConfirm>();
            }
            return this.productConfirm;
        }

        /**
         * Gets the value of the totalOrderPrice property.
         * 
         */
        public double getTotalOrderPrice() {
            return totalOrderPrice;
        }

        /**
         * Sets the value of the totalOrderPrice property.
         * 
         */
        public void setTotalOrderPrice(double value) {
            this.totalOrderPrice = value;
        }

    }

}

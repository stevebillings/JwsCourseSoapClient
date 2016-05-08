
package com.uciext.ws.hw4.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "submitOrder", namespace = "http://inventory.service.hw4.ws.uciext.com")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "submitOrder", namespace = "http://inventory.service.hw4.ws.uciext.com")
public class SubmitOrder {

    @XmlElement(name = "order", namespace = "http://inventory.service.hw4.ws.uciext.com")
    private com.uciext.ws.hw4.service.model.order.Order order;

    /**
     * 
     * @return
     *     returns Order
     */
    public com.uciext.ws.hw4.service.model.order.Order getOrder() {
        return this.order;
    }

    /**
     * 
     * @param order
     *     the value for the order property
     */
    public void setOrder(com.uciext.ws.hw4.service.model.order.Order order) {
        this.order = order;
    }

}

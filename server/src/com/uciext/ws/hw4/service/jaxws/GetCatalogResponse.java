
package com.uciext.ws.hw4.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "catalogResponse", namespace = "http://inventory.service.hw4.ws.uciext.com")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "catalogResponse", namespace = "http://inventory.service.hw4.ws.uciext.com")
public class GetCatalogResponse {

    @XmlElement(name = "return", namespace = "")
    private com.uciext.ws.hw4.service.model.catalog.Catalog _return;

    /**
     * 
     * @return
     *     returns Catalog
     */
    public com.uciext.ws.hw4.service.model.catalog.Catalog getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.uciext.ws.hw4.service.model.catalog.Catalog _return) {
        this._return = _return;
    }

}

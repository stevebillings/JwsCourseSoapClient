
package com.uciext.ws.hw4.service.inventory;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.uciext.ws.hw4.service.inventory package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Catalog_QNAME = new QName("http://inventory.service.hw4.ws.uciext.com", "catalog");
    private final static QName _CatalogResponse_QNAME = new QName("http://inventory.service.hw4.ws.uciext.com", "catalogResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://inventory.service.hw4.ws.uciext.com", "helloResponse");
    private final static QName _Hello_QNAME = new QName("http://inventory.service.hw4.ws.uciext.com", "hello");
    private final static QName _SubmitOrder_QNAME = new QName("http://inventory.service.hw4.ws.uciext.com", "submitOrder");
    private final static QName _SubmitOrderResponse_QNAME = new QName("http://inventory.service.hw4.ws.uciext.com", "submitOrderResponse");
    private final static QName _Exception_QNAME = new QName("http://inventory.service.hw4.ws.uciext.com", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.uciext.ws.hw4.service.inventory
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CatalogResponse }
     * 
     */
    public CatalogResponse createCatalogResponse() {
        return new CatalogResponse();
    }

    /**
     * Create an instance of {@link SubmitOrderResponse }
     * 
     */
    public SubmitOrderResponse createSubmitOrderResponse() {
        return new SubmitOrderResponse();
    }

    /**
     * Create an instance of {@link SubmitOrder }
     * 
     */
    public SubmitOrder createSubmitOrder() {
        return new SubmitOrder();
    }

    /**
     * Create an instance of {@link ProductOrder }
     * 
     */
    public ProductOrder createProductOrder() {
        return new ProductOrder();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link OrderConfirm }
     * 
     */
    public OrderConfirm createOrderConfirm() {
        return new OrderConfirm();
    }

    /**
     * Create an instance of {@link ProductConfirm }
     * 
     */
    public ProductConfirm createProductConfirm() {
        return new ProductConfirm();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Catalog }
     * 
     */
    public Catalog createCatalog() {
        return new Catalog();
    }

    /**
     * Create an instance of {@link CatalogResponse.Return }
     * 
     */
    public CatalogResponse.Return createCatalogResponseReturn() {
        return new CatalogResponse.Return();
    }

    /**
     * Create an instance of {@link SubmitOrderResponse.Return }
     * 
     */
    public SubmitOrderResponse.Return createSubmitOrderResponseReturn() {
        return new SubmitOrderResponse.Return();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inventory.service.hw4.ws.uciext.com", name = "catalog")
    public JAXBElement<Object> createCatalog(Object value) {
        return new JAXBElement<Object>(_Catalog_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inventory.service.hw4.ws.uciext.com", name = "catalogResponse")
    public JAXBElement<CatalogResponse> createCatalogResponse(CatalogResponse value) {
        return new JAXBElement<CatalogResponse>(_CatalogResponse_QNAME, CatalogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inventory.service.hw4.ws.uciext.com", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inventory.service.hw4.ws.uciext.com", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inventory.service.hw4.ws.uciext.com", name = "submitOrder")
    public JAXBElement<SubmitOrder> createSubmitOrder(SubmitOrder value) {
        return new JAXBElement<SubmitOrder>(_SubmitOrder_QNAME, SubmitOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inventory.service.hw4.ws.uciext.com", name = "submitOrderResponse")
    public JAXBElement<SubmitOrderResponse> createSubmitOrderResponse(SubmitOrderResponse value) {
        return new JAXBElement<SubmitOrderResponse>(_SubmitOrderResponse_QNAME, SubmitOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inventory.service.hw4.ws.uciext.com", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}

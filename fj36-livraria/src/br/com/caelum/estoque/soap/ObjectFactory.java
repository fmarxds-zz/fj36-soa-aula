
package br.com.caelum.estoque.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.caelum.estoque.soap package. 
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

    private final static QName _TokenUsuario_QNAME = new QName("http://caelum.com.br/estoquews/v1", "tokenUsuario");
    private final static QName _QuantidadeEmEstoquePeloCodigo_QNAME = new QName("http://caelum.com.br/estoquews/v1", "QuantidadeEmEstoquePeloCodigo");
    private final static QName _QuantidadeEmEstoquePeloCodigoResponse_QNAME = new QName("http://caelum.com.br/estoquews/v1", "QuantidadeEmEstoquePeloCodigoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.caelum.estoque.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QuantidadeEmEstoquePeloCodigoResponse }
     * 
     */
    public QuantidadeEmEstoquePeloCodigoResponse createQuantidadeEmEstoquePeloCodigoResponse() {
        return new QuantidadeEmEstoquePeloCodigoResponse();
    }

    /**
     * Create an instance of {@link QuantidadeEmEstoquePeloCodigo }
     * 
     */
    public QuantidadeEmEstoquePeloCodigo createQuantidadeEmEstoquePeloCodigo() {
        return new QuantidadeEmEstoquePeloCodigo();
    }

    /**
     * Create an instance of {@link ItemEstoque }
     * 
     */
    public ItemEstoque createItemEstoque() {
        return new ItemEstoque();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/estoquews/v1", name = "tokenUsuario")
    public JAXBElement<String> createTokenUsuario(String value) {
        return new JAXBElement<String>(_TokenUsuario_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuantidadeEmEstoquePeloCodigo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/estoquews/v1", name = "QuantidadeEmEstoquePeloCodigo")
    public JAXBElement<QuantidadeEmEstoquePeloCodigo> createQuantidadeEmEstoquePeloCodigo(QuantidadeEmEstoquePeloCodigo value) {
        return new JAXBElement<QuantidadeEmEstoquePeloCodigo>(_QuantidadeEmEstoquePeloCodigo_QNAME, QuantidadeEmEstoquePeloCodigo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuantidadeEmEstoquePeloCodigoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/estoquews/v1", name = "QuantidadeEmEstoquePeloCodigoResponse")
    public JAXBElement<QuantidadeEmEstoquePeloCodigoResponse> createQuantidadeEmEstoquePeloCodigoResponse(QuantidadeEmEstoquePeloCodigoResponse value) {
        return new JAXBElement<QuantidadeEmEstoquePeloCodigoResponse>(_QuantidadeEmEstoquePeloCodigoResponse_QNAME, QuantidadeEmEstoquePeloCodigoResponse.class, null, value);
    }

}

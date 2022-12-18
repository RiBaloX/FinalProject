
package services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the services package. 
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

    private final static QName _FindCaseByWeeknumResponse_QNAME = new QName("http://services/", "Find_case_by_weeknumResponse");
    private final static QName _FindCaseByWeeknum_QNAME = new QName("http://services/", "Find_case_by_weeknum");
    private final static QName _Covid19Statistics_QNAME = new QName("http://services/", "covid19Statistics");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindCaseByWeeknum }
     * 
     */
    public FindCaseByWeeknum createFindCaseByWeeknum() {
        return new FindCaseByWeeknum();
    }

    /**
     * Create an instance of {@link Covid19Statistics }
     * 
     */
    public Covid19Statistics createCovid19Statistics() {
        return new Covid19Statistics();
    }

    /**
     * Create an instance of {@link FindCaseByWeeknumResponse }
     * 
     */
    public FindCaseByWeeknumResponse createFindCaseByWeeknumResponse() {
        return new FindCaseByWeeknumResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCaseByWeeknumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "Find_case_by_weeknumResponse")
    public JAXBElement<FindCaseByWeeknumResponse> createFindCaseByWeeknumResponse(FindCaseByWeeknumResponse value) {
        return new JAXBElement<FindCaseByWeeknumResponse>(_FindCaseByWeeknumResponse_QNAME, FindCaseByWeeknumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCaseByWeeknum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "Find_case_by_weeknum")
    public JAXBElement<FindCaseByWeeknum> createFindCaseByWeeknum(FindCaseByWeeknum value) {
        return new JAXBElement<FindCaseByWeeknum>(_FindCaseByWeeknum_QNAME, FindCaseByWeeknum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Covid19Statistics }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "covid19Statistics")
    public JAXBElement<Covid19Statistics> createCovid19Statistics(Covid19Statistics value) {
        return new JAXBElement<Covid19Statistics>(_Covid19Statistics_QNAME, Covid19Statistics.class, null, value);
    }

}


package com.edw.wsdl.employee;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.edw.wsdl.employee package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.edw.wsdl.employee
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link EmployeeResponse }
     * 
     */
    public EmployeeResponse createEmployeeResponse() {
        return new EmployeeResponse();
    }

    /**
     * Create an instance of {@link EmployeesResponse }
     * 
     */
    public EmployeesResponse createEmployeesResponse() {
        return new EmployeesResponse();
    }

    /**
     * Create an instance of {@link EmployeeByIdRequest }
     * 
     */
    public EmployeeByIdRequest createEmployeeByIdRequest() {
        return new EmployeeByIdRequest();
    }

    /**
     * Create an instance of {@link EmployeeByNameRequest }
     * 
     */
    public EmployeeByNameRequest createEmployeeByNameRequest() {
        return new EmployeeByNameRequest();
    }

}

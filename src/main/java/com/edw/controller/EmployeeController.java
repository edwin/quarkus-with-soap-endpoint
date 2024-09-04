package com.edw.controller;

import com.edw.model.EmployeeModel;
import com.edw.service.EmployeeService;
import com.edw.wsdl.employee.*;
import jakarta.inject.Inject;
import jakarta.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.DatatypeFactory;
import java.util.GregorianCalendar;

/**
 * <pre>
 *  com.edw.controller.EmployeeController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 28 Aug 2024 8:39
 */
@WebService(serviceName = "Employee")
public class EmployeeController implements EmployeeServicePortType {

    @Inject
    EmployeeService employeeService;

    private GregorianCalendar gregorianCalendar = new GregorianCalendar();

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public EmployeesResponse getEmployeesByName(EmployeeByNameRequest parameters) {
        EmployeesResponse employeesResponse = new EmployeesResponse();

        // map database result to response
        for(EmployeeModel employeeModel : employeeService.findByName(parameters.getFirstname(), parameters.getLastname())) {
            Employee employee = new Employee();
            employee.setId(employeeModel.getId());
            employee.setFirstname(employeeModel.getFirstname());
            employee.setLastname(employeeModel.getLastname());
            employee.setGender(employeeModel.getGender());

            try {
                gregorianCalendar.setTime(employeeModel.getBirthdate());
                employee.setBirthdate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));
            } catch (Exception ex) {
                logger.error(ex.getMessage(), ex);
            }

            employeesResponse.getEmployee().add(employee);
        }

        return employeesResponse;
    }

    @Override
    public EmployeeResponse getEmployeeById(EmployeeByIdRequest parameters) {
        return null;
    }
}

package com.edw.controller;

import com.edw.wsdl.employee.*;
import jakarta.jws.WebService;

/**
 * <pre>
 *  com.edw.controller.EmployeeController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 28 Aug 2024 8:39
 */
@WebService(serviceName = "EmployeeService")
public class EmployeeController implements EmployeeServicePortType {

    @Override
    public EmployeesResponse getEmployeesByName(EmployeeByNameRequest parameters) {
        return null;
    }

    @Override
    public EmployeeResponse getEmployeeById(EmployeeByIdRequest parameters) {
        return null;
    }
}

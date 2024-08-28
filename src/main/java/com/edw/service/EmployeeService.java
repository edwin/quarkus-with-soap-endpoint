package com.edw.service;

import com.edw.model.EmployeeModel;
import com.edw.repository.EmployeeRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

/**
 * <pre>
 *  com.edw.service.EmployeeService
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 28 Aug 2024 9:04
 */
@ApplicationScoped
public class EmployeeService {

    @Inject
    EmployeeRepository employeeRepository;

    public List<EmployeeModel> findFiveLatest() {
        return employeeRepository.findFiveLatest();
    }

    public List<EmployeeModel> findByName(String firstname, String lastname) {
        return employeeRepository
                .find("select em  from EmployeeModel em where firstname like ?1 " +
                        " OR lastname like ?2 ",
                        Sort.descending("id"),
                        firstname,
                        lastname)
                .stream().toList();
    }

}

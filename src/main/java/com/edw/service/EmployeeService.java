package com.edw.service;

import com.edw.interceptor.AuditTrail;
import com.edw.model.EmployeeModel;
import com.edw.repository.EmployeeRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

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
@AuditTrail
public class EmployeeService {

    @Inject
    EmployeeRepository employeeRepository;

    @Inject
    EntityManager em;

    public List<EmployeeModel> findFiveLatest() {
        return employeeRepository.findFiveLatest();
    }

    public List<Object[]> doCustomQuery() {
        return em.createNativeQuery("select distinct(gender), count(gender) " +
                        " from T_EMPLOYEE WHERE gender != :gender " +
                        " group by gender order by count(gender) desc")
                .setParameter("gender", "X")
                .getResultList();
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

    public EmployeeModel findById(Long id) {
        return employeeRepository.findById(id);
    }

}

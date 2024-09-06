package com.edw.service;

import com.edw.model.EmployeeModel;
import com.edw.repository.EmployeeRepository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 *  com.edw.service.EmployeeServiceTest
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 04 Sep 2024 13:54
 */
@QuarkusTest
public class EmployeeServiceTest {

    @Inject
    EmployeeRepository employeeRepository;

    @Inject
    EmployeeService employeeService;

    @BeforeEach
    public void reset() {
        employeeRepository.deleteAll();

        employeeRepository.persist(EmployeeModel.builder()
                .firstname("test03")
                .lastname("test04")
                .gender("F")
                .birthdate(new Date())
                .build());
    }

    @Test
    public void test_doCustomQuery() {
        List<Object[]> objects = employeeService.doCustomQuery();

        for (Object[] object : objects) {
            Character gender = (Character) object[0];
            Assertions.assertEquals('F', gender);

            Long count = (Long) object[1];
            Assertions.assertEquals(count, 1);
        }

        Assertions.assertTrue(!objects.isEmpty());
    }

}

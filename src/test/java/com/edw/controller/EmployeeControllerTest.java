package com.edw.controller;

import com.edw.model.EmployeeModel;
import com.edw.repository.EmployeeRepository;
import io.quarkus.test.junit.QuarkusTest;

import io.restassured.response.Response;
import jakarta.inject.Inject;
import org.junit.jupiter.api.*;

import java.util.Date;

import static io.restassured.RestAssured.given;

/**
 * <pre>
 *  com.edw.controller.EmployeeControllerTest
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 28 Aug 2024 12:31
 */
@QuarkusTest
public class EmployeeControllerTest {

    @Inject
    EmployeeRepository employeeRepository;

    @Test
    public void test_getWSDL() {
        given()
            .when()
                .get("/api/Employee?wsdl")
            .then()
                .statusCode(200)
            .log().all();
    }

    @Test
    public void test_getEmployeesByName() {

        employeeRepository.persist(EmployeeModel.builder()
                                        .firstname("test01")
                                        .lastname("test02")
                                        .gender("M")
                                        .birthdate(new Date())
                                        .build());

        Response response = given().
                                request().body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:emp=\"http://localhost/employee\">\n" +
                                        "   <soapenv:Header/>\n" +
                                        "   <soapenv:Body>\n" +
                                        "      <emp:EmployeeByNameRequest firstname=\"test01\" lastname=\"test\"/>\n" +
                                        "   </soapenv:Body>\n" +
                                        "</soapenv:Envelope>")
                                .headers("SOAPAction", "http://localhost/employee/GetEmployeesByName", "Content-Type", "text/xml")
                            .when()
                                .post("/api/Employee")
                            .then()
                                .statusCode(200)
                            .log().all().extract().response();
        Assertions.assertTrue(response.asString().contains("firstname=\"test01\""));
        Assertions.assertTrue(response.asString().contains("lastname=\"test02\""));
        Assertions.assertTrue(response.asString().contains("gender=\"M\""));
    }
}
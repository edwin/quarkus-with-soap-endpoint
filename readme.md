# Skeleton Project for Quarkus, Panache Queries, and WSDL

## Generate Java Classes from WSDL
```
$ mvn generate-sources
```

## WSDL Location
```
http://localhost:8080/api/Employee?wsdl
```

## Sample Data
```sql
create or replace table test_db.t_employee
(
    id        bigint auto_increment
        primary key,
    gender    varchar(1)   null,
    birthdate datetime(6)  null,
    firstname varchar(100) null,
    lastname  varchar(100) null
);

INSERT INTO test_db.t_employee (gender, birthdate, firstname, lastname) VALUES ('M', '2024-08-28 10:00:30.000000', 'random', 'name');
INSERT INTO test_db.t_employee (gender, birthdate, firstname, lastname) VALUES ('F', '2024-08-28 10:00:30.000000', 'some', 'random');
```

## getEmployeesByName API

### Sample Request
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:emp="http://localhost/employee">
   <soapenv:Header/>
   <soapenv:Body>
      <emp:EmployeeByNameRequest firstname="random" lastname="random"/>
   </soapenv:Body>
</soapenv:Envelope>
```

### Sample Response
```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <EmployeesResponse xmlns="http://localhost/employee">
         <employee id="2" firstname="some" lastname="random" birthdate="2024-08-28+07:00" gender="F"/>
         <employee id="1" firstname="random" lastname="name" birthdate="2024-08-28+07:00" gender="M"/>
      </EmployeesResponse>
   </soap:Body>
</soap:Envelope>
```

## getEmployeeById API

### Sample Request
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:emp="http://localhost/employee">
   <soapenv:Header/>
   <soapenv:Body>
      <emp:EmployeeByIdRequest id="1"/>
   </soapenv:Body>
</soapenv:Envelope>
```

### Sample Response
```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <EmployeeResponse xmlns="http://localhost/employee">
         <employee id="1" firstname="random" lastname="name" birthdate="2024-08-28+07:00" gender="M"/>
      </EmployeeResponse>
   </soap:Body>
</soap:Envelope>
```
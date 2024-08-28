package com.edw.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <pre>
 *  com.edw.model.EmployeeModel
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 28 Aug 2024 8:50
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="T_EMPLOYEE")
public class EmployeeModel extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String firstname;

    @Column(length = 100)
    private String lastname;

    private Date birthdate;

    @Column(length = 1)
    private String gender;
}

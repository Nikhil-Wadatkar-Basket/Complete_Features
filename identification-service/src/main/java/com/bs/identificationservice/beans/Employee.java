package com.bs.identificationservice.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "employee_details_tab")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "emp_id")
    private Integer emp_id;
    @Column
    private Integer department_id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String job_id;
    @Column
    private String phone;
    @Column
    private Integer salary;
    @Column
    private Date birthdate;
    @Column
    private Date hire_date;

    //    @OneToMany(targetEntity = IdentityDetails.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @OneToMany(targetEntity = IdentityDetails.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "emp_id_col", referencedColumnName = "emp_id")
    private Set<IdentityDetails> identityDetailsList = new LinkedHashSet<>();
}
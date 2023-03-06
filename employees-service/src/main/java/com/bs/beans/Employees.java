package com.bs.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Employees {
	@Id
	private Integer employeeId;
	private Integer departmentId;
	private Integer jobId;
	private Integer managerId;
	private Integer salary;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
}

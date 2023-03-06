package com.bs.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Dependents {
	@Id
	private Integer dependentId;
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String relationship;
}

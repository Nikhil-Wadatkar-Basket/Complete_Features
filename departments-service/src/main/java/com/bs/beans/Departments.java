package com.bs.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Departments {

	@Id
	private Integer departmentId;
	private Integer locationId;
	private String departmentName;
}

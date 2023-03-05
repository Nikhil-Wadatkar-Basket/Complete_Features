package com.bs.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	@Id
	private Integer id;
	@Column
	private Integer monthlyBudget;
	@Column
	private String name;

	@Column
	private Integer lastEmployeeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMonthlyBudget() {
		return monthlyBudget;
	}

	public void setMonthlyBudget(Integer monthlyBudget) {
		this.monthlyBudget = monthlyBudget;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLastEmployeeId() {
		return lastEmployeeId;
	}

	public void setLastEmployeeId(Integer lastEmployeeId) {
		this.lastEmployeeId = lastEmployeeId;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", monthlyBudget=" + monthlyBudget + ", name=" + name + ", lastEmployeeId="
				+ lastEmployeeId + "]";
	}

	public Department(Integer id, Integer monthlyBudget, String name, Integer lastEmployeeId) {
		super();
		this.id = id;
		this.monthlyBudget = monthlyBudget;
		this.name = name;
		this.lastEmployeeId = lastEmployeeId;
	}

}

package com.bs.employee.beans;

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
public class Employee {
	@Id
	private Integer id;
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
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public Employee(Integer id, Integer department_id, String name, String email, String job_id, String phone,
			Integer salary, Date birthdate, Date hire_date) {
		super();
		this.id = id;
		this.department_id = department_id;
		this.name = name;
		this.email = email;
		this.job_id = job_id;
		this.phone = phone;
		this.salary = salary;
		this.birthdate = birthdate;
		this.hire_date = hire_date;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", department_id=" + department_id + ", name=" + name + ", email=" + email
				+ ", job_id=" + job_id + ", phone=" + phone + ", salary=" + salary + ", birthdate=" + birthdate
				+ ", hire_date=" + hire_date + "]";
	}

}

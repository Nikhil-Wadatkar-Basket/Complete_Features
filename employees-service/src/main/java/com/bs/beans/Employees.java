package com.bs.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author nikhi
 *
 */
@Entity
@Table
//@Data
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
	private String gender;
	private String departmentName;
	private Date hireDate;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Employees(Integer employeeId, Integer departmentId, Integer jobId, Integer managerId, Integer salary,
			String firstName, String lastName, String email, String phoneNumber, String gender, String departmentName,
			Date hireDate) {
		super();
		this.employeeId = employeeId;
		this.departmentId = departmentId;
		this.jobId = jobId;
		this.managerId = managerId;
		this.salary = salary;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.departmentName = departmentName;
		this.hireDate = hireDate;
	}

	public Employees() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", departmentId=" + departmentId + ", jobId=" + jobId
				+ ", managerId=" + managerId + ", salary=" + salary + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", gender=" + gender
				+ ", departmentName=" + departmentName + ", hireDate=" + hireDate + "]";
	}

}

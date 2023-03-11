package com.bs.beans;

public class Departments {
	public Departments() {
		// TODO Auto-generated constructor stub
	}

	private Integer departmentId;
	private Integer locationId;
	private String departmentName;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Departments(Integer departmentId, Integer locationId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.locationId = locationId;
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Departments [departmentId=" + departmentId + ", locationId=" + locationId + ", departmentName="
				+ departmentName + "]";
	}

}

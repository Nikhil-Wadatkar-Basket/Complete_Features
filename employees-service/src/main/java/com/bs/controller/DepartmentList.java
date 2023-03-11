package com.bs.controller;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bs.beans.Departments;

@Component
public class DepartmentList {
	private Departments[] departments;

	public DepartmentList() {
		// TODO Auto-generated constructor stub
	}

	public Departments[] getDepartments() {
		return departments;
	}

	public void setDepartments(Departments[] departments) {
		this.departments = departments;
	}

	public DepartmentList(Departments[] departments) {
		super();
		this.departments = departments;
	}

}

package com.bs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bs.beans.Departments;
import com.bs.repo.DepartmentsRepo;
import com.bs.service.DepartmentsService;

@RestController
public class DepartmentsController {
	@Autowired
	private DepartmentsService regionService;
	@Autowired
	private DepartmentsRepo departmentsRepo;

	@GetMapping("/getAll")
	public List<Departments> getAllDepartments() throws InterruptedException {
		System.out.println("Calling department getAll service");
		return regionService.getAllDepartments();
	}

	@PostMapping("/createDepartments")
	public ResponseEntity<Departments> createDepartments(@RequestBody Departments region) {
		return new ResponseEntity<Departments>(regionService.createDepartment(region), HttpStatus.OK);
	}

	@PostMapping("/saveAllDepartments")
	public int saveAllDepartments(@RequestBody List<Departments> depts) {
		return departmentsRepo.saveAll(depts).size();

	}

	@PostMapping("/updateDepartments")
	public ResponseEntity<Departments> updateDepartments(@RequestBody Departments region) {
		return new ResponseEntity<Departments>(regionService.updateDepartment(region), HttpStatus.OK);
	}

	@GetMapping("/getByID/{id}")
	public ResponseEntity<Departments> getByID(@PathVariable("id") Integer id) {
		return new ResponseEntity<Departments>(regionService.getByID(id), HttpStatus.OK);
	}

	@GetMapping("/deleteByID/{id}")
	public ResponseEntity<String> deleteByID(@PathVariable("id") Integer id) {
		return new ResponseEntity<String>(regionService.deleteDepartmentByID(id), HttpStatus.OK);
	}

}

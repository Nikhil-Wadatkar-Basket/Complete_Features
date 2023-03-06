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

import com.bs.beans.Employees;
import com.bs.service.EmployeesService;

@RestController
public class EmployeesController {
	@Autowired
	private EmployeesService regionService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Employees>> getAllEmployees() throws InterruptedException {
		return new ResponseEntity<List<Employees>>(regionService.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/getByManagerId/{id}")
	public ResponseEntity<List<Employees>> getByManagerId(@PathVariable("id") Integer id) throws InterruptedException {
		return new ResponseEntity<List<Employees>>(regionService.getByManagerId(id), HttpStatus.OK);
	}

	@GetMapping("/getByJobId/{id}")
	public ResponseEntity<List<Employees>> getByJobId(@PathVariable("id") Integer id) {
		return new ResponseEntity<List<Employees>>(regionService.getByJobId(id), HttpStatus.OK);
	}
	
	
	@PostMapping("/createEmployees")
	public ResponseEntity<Employees> createEmployees(@RequestBody Employees region) {
		return new ResponseEntity<Employees>(regionService.createEmployee(region), HttpStatus.OK);
	}

	@PostMapping("/updateEmployees")
	public ResponseEntity<Employees> updateEmployees(@RequestBody Employees region) {
		return new ResponseEntity<Employees>(regionService.updateEmployee(region), HttpStatus.OK);
	}

	@GetMapping("/getByID/{id}")
	public ResponseEntity<Employees> getByID(@PathVariable("id") Integer id) {
		return new ResponseEntity<Employees>(regionService.getByID(id), HttpStatus.OK);
	}

	@GetMapping("/deleteByID/{id}")
	public ResponseEntity<String> deleteByID(@PathVariable("id") Integer id) {
		return new ResponseEntity<String>(regionService.deleteEmployeeByID(id), HttpStatus.OK);
	}

}

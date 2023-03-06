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

import com.bs.beans.Dependents;
import com.bs.service.DependentsService;

@RestController
public class DependentsController {
	@Autowired
	private DependentsService DependentsService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Dependents>> getAllDependents() throws InterruptedException {
		return new ResponseEntity<List<Dependents>>(DependentsService.getAllDependents(), HttpStatus.OK);
	}

	@PostMapping("/createDependents")
	public ResponseEntity<Dependents> createDependents(@RequestBody Dependents region) {
		return new ResponseEntity<Dependents>(DependentsService.createDependent(region), HttpStatus.OK);
	}

	@PostMapping("/updateDependents")
	public ResponseEntity<Dependents> updateDependents(@RequestBody Dependents region) {
		return new ResponseEntity<Dependents>(DependentsService.updateDependent(region), HttpStatus.OK);
	}

	@GetMapping("/getByID/{id}")
	public ResponseEntity<Dependents> getByID(@PathVariable("id") Integer id) {
		return new ResponseEntity<Dependents>(DependentsService.getByID(id), HttpStatus.OK);
	}

	@GetMapping("/deleteByID/{id}")
	public ResponseEntity<String> deleteByID(@PathVariable("id") Integer id) {
		return new ResponseEntity<String>(DependentsService.deleteDependentByID(id), HttpStatus.OK);
	}

}

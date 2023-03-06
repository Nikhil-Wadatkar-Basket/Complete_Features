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

import com.bs.beans.Jobs;
import com.bs.service.JobsService;

@RestController
public class JobsController {
	@Autowired
	private JobsService jobService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Jobs>> getAllJobss() throws InterruptedException {
		return new ResponseEntity<List<Jobs>>(jobService.getAllJobs(), HttpStatus.OK);
	}

	@PostMapping("/createJobs")
	public ResponseEntity<Jobs> createJobs(@RequestBody Jobs countries) {
		return new ResponseEntity<Jobs>(jobService.createJobs(countries), HttpStatus.OK);
	}

	@PostMapping("/updateJobs")
	public ResponseEntity<Jobs> updateJobs(@RequestBody Jobs countries) {
		return new ResponseEntity<Jobs>(jobService.updateJobs(countries), HttpStatus.OK);
	}

	@GetMapping("/getByID/{id}")
	public ResponseEntity<Jobs> getByID(@PathVariable("id") Integer id) {
		return new ResponseEntity<Jobs>(jobService.getByID(id), HttpStatus.OK);
	}

	@GetMapping("/deleteByID/{id}")
	public ResponseEntity<String> deleteByID(@PathVariable("id") String id) {
		return new ResponseEntity<String>(jobService.deleteJobsByID(id), HttpStatus.OK);
	}

}

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

import com.bs.beans.Region;
import com.bs.service.RegionService;

@RestController
public class RegionController {
	@Autowired
	private RegionService regionService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Region>> getAllRegions() throws InterruptedException {
		return new ResponseEntity<List<Region>>(regionService.getAllRegions(), HttpStatus.OK);
	}

	@PostMapping("/createRegion")
	public ResponseEntity<Region> createRegion(@RequestBody Region region) {
		return new ResponseEntity<Region>(regionService.createRegion(region), HttpStatus.OK);
	}

	@PostMapping("/updateRegion")
	public ResponseEntity<Region> updateRegion(@RequestBody Region region) {
		return new ResponseEntity<Region>(regionService.updateRegion(region), HttpStatus.OK);
	}

	@GetMapping("/getByID/{id}")
	public ResponseEntity<Region> getByID(@PathVariable("id") Integer id) {
		return new ResponseEntity<Region>(regionService.getByID(id), HttpStatus.OK);
	}

	@GetMapping("/deleteByID/{id}")
	public ResponseEntity<String> deleteByID(@PathVariable("id") Integer id) {
		return new ResponseEntity<String>(regionService.deleteRegionByID(id), HttpStatus.OK);
	}

}

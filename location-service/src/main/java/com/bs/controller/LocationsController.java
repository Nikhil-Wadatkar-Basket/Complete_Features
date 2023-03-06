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

import com.bs.beans.Locations;
import com.bs.service.LocationsService;

@RestController
public class LocationsController {
	@Autowired
	private LocationsService countriesService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Locations>> getAllLocationss() throws InterruptedException {
		return new ResponseEntity<List<Locations>>(countriesService.getAllLocationss(), HttpStatus.OK);
	}

	@PostMapping("/createLocations")
	public ResponseEntity<Locations> createLocations(@RequestBody Locations countries) {
		return new ResponseEntity<Locations>(countriesService.createLocations(countries), HttpStatus.OK);
	}

	@PostMapping("/updateLocations")
	public ResponseEntity<Locations> updateLocations(@RequestBody Locations countries) {
		return new ResponseEntity<Locations>(countriesService.updateLocations(countries), HttpStatus.OK);
	}

	@GetMapping("/getByID/{id}")
	public ResponseEntity<Locations> getByID(@PathVariable("id") Integer id) {
		return new ResponseEntity<Locations>(countriesService.getByID(id), HttpStatus.OK);
	}

	@GetMapping("/deleteByID/{id}")
	public ResponseEntity<String> deleteByID(@PathVariable("id") Integer id) {
		return new ResponseEntity<String>(countriesService.deleteLocationsByID(id), HttpStatus.OK);
	}

	@GetMapping("/getByCountryByUS")
	public ResponseEntity<List<Locations>> getByCountryID()  {
		return new ResponseEntity<List<Locations>>(countriesService.getByCountryID(), HttpStatus.OK);
	}
	
}
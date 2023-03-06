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

import com.bs.beans.Countries;
import com.bs.service.CountriesService;

@RestController
public class CountriesController {
	@Autowired
	private CountriesService countriesService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Countries>> getAllCountriess() throws InterruptedException {
		return new ResponseEntity<List<Countries>>(countriesService.getAllCountriess(), HttpStatus.OK);
	}

	@PostMapping("/createCountries")
	public ResponseEntity<Countries> createCountries(@RequestBody Countries countries) {
		return new ResponseEntity<Countries>(countriesService.createCountries(countries), HttpStatus.OK);
	}

	@PostMapping("/updateCountries")
	public ResponseEntity<Countries> updateCountries(@RequestBody Countries countries) {
		return new ResponseEntity<Countries>(countriesService.updateCountries(countries), HttpStatus.OK);
	}

	@GetMapping("/getByID/{id}")
	public ResponseEntity<Countries> getByID(@PathVariable("id") Integer id) {
		return new ResponseEntity<Countries>(countriesService.getByID(id), HttpStatus.OK);
	}

	@GetMapping("/deleteByID/{id}")
	public ResponseEntity<String> deleteByID(@PathVariable("id") Integer id) {
		return new ResponseEntity<String>(countriesService.deleteCountriesByID(id), HttpStatus.OK);
	}

}

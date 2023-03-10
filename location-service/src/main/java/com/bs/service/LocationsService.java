package com.bs.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.Locations;
import com.bs.constants.LocationConstants;
import com.bs.repo.LocationsRepo;

@Service
public class LocationsService {
	@Autowired
	private LocationsRepo countryRepo;

	public List<Locations> getAllLocationss() {
		List<Locations> allcountries = countryRepo.findAll();
		allcountries = null;
		return allcountries;
	}

	public Locations createLocations(Locations countries) {
		return countryRepo.save(countries);
	}

	public Locations updateLocations(Locations countries) {
		Locations updatedLocations = null;
		Locations Saved = null;
		Optional<Locations> findById = countryRepo.findById(countries.getLocationId());
		if (findById.isPresent()) {
			updatedLocations = new Locations();
			Saved = countryRepo.save(updatedLocations);
		}
		return Saved;
	}

	public Locations getByID(Integer id) {
		return countryRepo.getLocationsByLocationId(id);
	}

	public String deleteLocationsByID(Integer id) {
		return countryRepo.deleteLocationsByLocationId(id);
	}

	public List<Locations> getByCountryID() {

		return countryRepo.findAll().stream().filter(cc -> cc.getCountryId().equals(LocationConstants.US))
				.collect(Collectors.toList());
	}

}

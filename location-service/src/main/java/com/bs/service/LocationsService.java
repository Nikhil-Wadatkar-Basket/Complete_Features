package com.bs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.Locations;
import com.bs.repo.LocationsRepo;

@Service
public class LocationsService {
	@Autowired
	private LocationsRepo countryRepo;

	public List<Locations> getAllLocationss() {
		List<Locations> allcountries = countryRepo.findAll();
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
//			updatedLocations.setLocationName(findById.get().getLocationName());
//			updatedLocations.setRegionId(findById.get().getRegionId());
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

}

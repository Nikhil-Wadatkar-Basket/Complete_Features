package com.bs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.Countries;
import com.bs.repo.CountriesRepo;

@Service
public class CountriesService {
	@Autowired
	private CountriesRepo countryRepo;

	public List<Countries> getAllCountriess() {
		List<Countries> allcountries = countryRepo.findAll();
		return allcountries;
	}

	public Countries createCountries(Countries countries) {
		return countryRepo.save(countries);
	}

	public Countries updateCountries(Countries countries) {
		Countries updatedCountries = null;
		Countries Saved = null;
		Optional<Countries> findById = countryRepo.findByCountryId(countries.getCountryId());
		if (findById.isPresent()) {
			updatedCountries = new Countries();
			updatedCountries.setCountryName(findById.get().getCountryName());
			updatedCountries.setRegionId(findById.get().getRegionId());
			Saved = countryRepo.save(updatedCountries);
		}
		return Saved;
	}

	public Countries getByID(Integer id) {
		return countryRepo.getCountriesByCountryId(id);
	}

	public String deleteCountriesByID(Integer id) {
		return countryRepo.deleteCountriesByCountryId(id);
	}

}

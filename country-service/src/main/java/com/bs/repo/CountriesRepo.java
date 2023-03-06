package com.bs.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.bs.beans.Countries;

@Repository
public interface CountriesRepo extends JpaRepository<Countries, Integer> {

//	@Query(nativeQuery = true, name = "select * from countries where countries_Id=:1")
	public Countries getCountriesByCountryId(Integer id);

	@Modifying
//	@Query(nativeQuery = true, name = "delete from countries where countries_Id=:1")
	public String deleteCountriesByCountryId(Integer id);

	public Optional<Countries> findByCountryId(String countryId);

}

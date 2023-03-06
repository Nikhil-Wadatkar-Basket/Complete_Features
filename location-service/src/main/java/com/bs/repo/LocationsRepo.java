package com.bs.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.bs.beans.Locations;

@Repository
public interface LocationsRepo extends JpaRepository<Locations, Integer> {

//	@Query(nativeQuery = true, name = "select * from countries where countries_Id=:1")
	public Locations getLocationsByLocationId(Integer id);

	@Modifying
//	@Query(nativeQuery = true, name = "delete from countries where countries_Id=:1")
	public String deleteLocationsByLocationId(Integer id);

	public Optional<Locations> findByLocationId(String countryId);

}

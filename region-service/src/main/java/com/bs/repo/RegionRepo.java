package com.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bs.beans.Region;

@Repository
public interface RegionRepo extends JpaRepository<Region, Integer> {

//	@Query(nativeQuery = true, name = "select * from region where region_Id=:1")
	public Region getByRegionId(Integer id);

	@Modifying
//	@Query(nativeQuery = true, name = "delete from region where region_Id=:1")
	public String deleteRegionByRegionId(Integer id);

}

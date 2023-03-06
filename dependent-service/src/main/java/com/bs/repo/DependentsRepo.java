package com.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.bs.beans.Dependents;

@Repository
public interface DependentsRepo extends JpaRepository<Dependents, Integer> {

//	@Query(nativeQuery = true, name = "select * from region where region_Id=:1")
	public Dependents getByDependentId(Integer id);

	@Modifying
//	@Query(nativeQuery = true, name = "delete from region where region_Id=:1")
	public String deleteDependentsByDependentId(Integer id);

}

package com.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.bs.beans.Departments;

@Repository
public interface DepartmentsRepo extends JpaRepository<Departments, Integer> {

//	@Query(nativeQuery = true, name = "select * from region where region_Id=:1")
	public Departments getByDepartmentId(Integer id);

	@Modifying
//	@Query(nativeQuery = true, name = "delete from region where region_Id=:1")
	public String deleteDepartmentsByDepartmentId(Integer id);

}

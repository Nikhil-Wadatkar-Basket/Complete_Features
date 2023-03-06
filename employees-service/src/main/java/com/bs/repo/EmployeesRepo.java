package com.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.bs.beans.Employees;

@Repository
public interface EmployeesRepo extends JpaRepository<Employees, Integer> {

//	@Query(nativeQuery = true, name = "select * from region where region_Id=:1")
	public Employees getByEmployeeId(Integer id);

	@Modifying
//	@Query(nativeQuery = true, name = "delete from region where region_Id=:1")
	public String deleteEmployeesByEmployeeId(Integer id);
	
	//add all custom methods here using custom query

}

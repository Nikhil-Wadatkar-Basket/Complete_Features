package com.bs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.Employees;
import com.bs.repo.EmployeesRepo;

@Service
public class EmployeesService {
	@Autowired
	private EmployeesRepo regionRepo;

	public List<Employees> getAllEmployees() {
		return regionRepo.findAll();
	}

	public Employees createEmployee(Employees region) {
		return regionRepo.save(region);
	}

	public Employees updateEmployee(Employees dept) {
		Employees updatedEmployee = null;
		Employees Saved = null;
		Optional<Employees> findById = regionRepo.findById(dept.getEmployeeId());
		if (findById.isPresent()) {
			updatedEmployee = new Employees();
//			updatedEmployee.setEmployeeName(findById.get().getEmployeeId());
			Saved = regionRepo.save(updatedEmployee);
		}
		return Saved;
	}

	public Employees getByID(Integer id) {
		return regionRepo.getByEmployeeId(id);
	}

	public String deleteEmployeeByID(Integer id) {
		return regionRepo.deleteEmployeesByEmployeeId(id);
	}

}

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
	private EmployeesRepo employeeRepo;

	public List<Employees> getAllEmployees() {
		return employeeRepo.findAll();
	}

	public Employees createEmployee(Employees region) {
		region.setLastName(null);
		return employeeRepo.save(region);
	}

	public Employees updateEmployee(Employees dept) {
		Employees updatedEmployee = null;
		Employees saved = null;
		Optional<Employees> findById = employeeRepo.findById(dept.getEmployeeId());
		if (findById.isPresent()) {
			updatedEmployee = new Employees();
//			updatedEmployee.setEmployeeName(findById.get().getEmployeeId());
			saved = employeeRepo.save(updatedEmployee);
		}
		return saved;
	}

	public Employees getByID(Integer id) {
		if (id > 0) {
			throw new NullPointerException("");
		}
		return employeeRepo.getByEmployeeId(id);
	}

	public String deleteEmployeeByID(Integer id) {
		return employeeRepo.deleteEmployeesByEmployeeId(id);
	}

	public Integer saveAllEmployees(List<Employees> employees) {
		return employeeRepo.saveAll(employees).size();

	}

}

package com.bs.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bs.beans.Employees;
import com.bs.repo.EmployeesRepo;

@Service
public class EmployeesService {
	@Autowired
	private EmployeesRepo employeeRepo;

	public List<Employees> getAllEmployees() {
		return employeeRepo.findAll();
	}

	public List<Employees> getByManagerId(Integer id) {

		List<Employees> findAll = regionRepo.findAll();
		List<Employees> filteredList = new LinkedList<Employees>();
		
		
		for (Employees emp : findAll) {
			if (emp.getManagerId() == id)
				filteredList.add(emp);
		}
		return filteredList;
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

	public List<Employees> getByJobId(Integer id) {
		return regionRepo.findAll().stream().filter(emp -> emp.getJobId() == id).collect(Collectors.toList());
		
		

	}

}

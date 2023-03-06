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
	private EmployeesRepo regionRepo;

	public List<Employees> getAllEmployees() {
		return regionRepo.findAll();
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

	public List<Employees> getByJobId(Integer id) {
		return regionRepo.findAll().stream().filter(emp -> emp.getJobId() == id).collect(Collectors.toList());
		
		

	}

}

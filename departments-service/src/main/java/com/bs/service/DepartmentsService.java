package com.bs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.Departments;
import com.bs.exceptions.DepartmentNotFoundException;
import com.bs.exceptions.EmptyDepartmentListException;
import com.bs.repo.DepartmentsRepo;

@Service
public class DepartmentsService {
	@Autowired
	private DepartmentsRepo deptRepo;

	public List<Departments> getAllDepartments() {

		List<Departments> allDepartments = deptRepo.findAll();
		if (allDepartments.size() == 0)
			throw new EmptyDepartmentListException("There are not departments");
		return allDepartments;
	}

	public Departments createDepartment(Departments region) {
		return deptRepo.save(region);
	}

	public Departments updateDepartment(Departments dept) {
		Departments updatedDepartment = null;
		Departments Saved = null;
		Optional<Departments> findById = deptRepo.findById(dept.getDepartmentId());
		if (findById.isPresent()) {
			updatedDepartment = new Departments();
			updatedDepartment.setDepartmentName(findById.get().getDepartmentName());
			Saved = deptRepo.save(updatedDepartment);
		}
		return Saved;
	}

	public Departments getByID(Integer id) {
		Departments byDepartmentId = deptRepo.getByDepartmentId(id);
		if (null == byDepartmentId)
			throw new DepartmentNotFoundException("Department Not Found");
		return byDepartmentId;
	}

	public String deleteDepartmentByID(Integer id) {
		return deptRepo.deleteDepartmentsByDepartmentId(id);
	}

}

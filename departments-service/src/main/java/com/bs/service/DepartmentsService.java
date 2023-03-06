package com.bs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.Departments;
import com.bs.repo.DepartmentsRepo;

@Service
public class DepartmentsService {
	@Autowired
	private DepartmentsRepo regionRepo;

	public List<Departments> getAllDepartments() {
		return regionRepo.findAll();
	}

	public Departments createDepartment(Departments region) {
		return regionRepo.save(region);
	}

	public Departments updateDepartment(Departments dept) {
		Departments updatedDepartment = null;
		Departments Saved = null;
		Optional<Departments> findById = regionRepo.findById(dept.getDepartmentId());
		if (findById.isPresent()) {
			updatedDepartment = new Departments();
			updatedDepartment.setDepartmentName(findById.get().getDepartmentName());
			Saved = regionRepo.save(updatedDepartment);
		}
		return Saved;
	}

	public Departments getByID(Integer id) {
		return regionRepo.getByDepartmentId(id);
	}

	public String deleteDepartmentByID(Integer id) {
		return regionRepo.deleteDepartmentsByDepartmentId(id);
	}

}

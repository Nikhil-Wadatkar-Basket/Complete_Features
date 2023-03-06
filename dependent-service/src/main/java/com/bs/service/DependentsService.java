package com.bs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.Dependents;
import com.bs.repo.DependentsRepo;

@Service
public class DependentsService {
	@Autowired
	private DependentsRepo regionRepo;

	public List<Dependents> getAllDependents() {
		return regionRepo.findAll();
	}

	public Dependents createDependent(Dependents region) {
		return regionRepo.save(region);
	}

	public Dependents updateDependent(Dependents dept) {
		Dependents updatedDependent = null;
		Dependents Saved = null;
		Optional<Dependents> findById = regionRepo.findById(dept.getDependentId());
		if (findById.isPresent()) {
			updatedDependent = new Dependents();
			Saved = regionRepo.save(updatedDependent);
		}
		return Saved;
	}

	public Dependents getByID(Integer id) {
		return regionRepo.getByDependentId(id);
	}

	public String deleteDependentByID(Integer id) {
		return regionRepo.deleteDependentsByDependentId(id);
	}

}

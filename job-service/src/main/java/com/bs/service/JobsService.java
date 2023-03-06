package com.bs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.Jobs;
import com.bs.repo.JobsRepo;

@Service
public class JobsService {
	@Autowired
	private JobsRepo countryRepo;

	public List<Jobs> getAllJobs() {
		List<Jobs> allcountries = countryRepo.findAll();
		return allcountries;
	}

	public Jobs createJobs(Jobs countries) {
		return countryRepo.save(countries);
	}

	public Jobs updateJobs(Jobs job) {
		Jobs updatedJobs = null;
		Jobs Saved = null;
		Optional<Jobs> findById = countryRepo.findById(job.getJobId());
		if (findById.isPresent()) {
			updatedJobs = new Jobs();
//			updatedJobs.setJobName(findById.get().getJobName());
//			updatedJobs.setRegionId(findById.get().getRegionId());
			Saved = countryRepo.save(updatedJobs);
		}
		return Saved;
	}

	public Jobs getByID(Integer id) {
		return countryRepo.getJobsByJobId(id);
	}

	public String deleteJobsByID(String id) {
		return countryRepo.deleteJobsByJobId(id);
	}

}

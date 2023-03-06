package com.bs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.beans.Region;
import com.bs.repo.RegionRepo;

@Service
public class RegionService {
	@Autowired
	private RegionRepo regionRepo;

	public List<Region> getAllRegions() {
		return regionRepo.findAll();
	}

	public Region createRegion(Region region) {
		return regionRepo.save(region);
	}

	public Region updateRegion(Region region) {
		Region updatedRegion = null;
		Region Saved = null;
		Optional<Region> findById = regionRepo.findById(region.getRegionId());
		if (findById.isPresent()) {
			updatedRegion = new Region();
			updatedRegion.setRegionName(findById.get().getRegionName());
			Saved = regionRepo.save(updatedRegion);
		}
		return Saved;
	}

	public Region getByID(Integer id) {
		return regionRepo.getByRegionId(id);
	}

	public String deleteRegionByID(Integer id) {
		return regionRepo.deleteRegionByRegionId(id);
	}

}

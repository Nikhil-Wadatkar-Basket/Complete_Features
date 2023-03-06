package com.bs.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.bs.beans.Jobs;

@Repository
public interface JobsRepo extends JpaRepository<Jobs, String> {

//	@Query(nativeQuery = true, name = "select * from countries where countries_Id=:1")
	public Jobs getJobsByJobId(Integer id);

	@Modifying
//	@Query(nativeQuery = true, name = "delete from countries where countries_Id=:1")
	public String deleteJobsByJobId(String id);

	public Optional<Jobs> findByJobId(String jobId);

}

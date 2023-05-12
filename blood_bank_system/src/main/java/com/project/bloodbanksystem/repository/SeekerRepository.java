package com.project.bloodbanksystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.bloodbanksystem.model.Seeker;

@Repository
public interface SeekerRepository extends JpaRepository<Seeker, Long> {
	
	
	
	@Query(value = "SELECT * FROM seeker WHERE seeker_first_name = ?1", nativeQuery = true)
	public List<Seeker> serchUserByName(String seeker_name);
	
	// Example of Native Query - SQL
	@Query(value = "SELECT * FROM seeker, state WHERE state_id = seeker_state", nativeQuery = true)
	public List<Seeker> serchUserByState(String seeker_state);
	

}

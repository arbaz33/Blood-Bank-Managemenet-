package com.project.bloodbanksystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.bloodbanksystem.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
	
	
	
	@Query(value = "SELECT * FROM hospital WHERE hospital_name = ?1", nativeQuery = true)
	public List<Hospital> serchUserByName(String hospital_name);
	
	// Example of Native Query - SQL
	@Query(value = "SELECT * FROM hospital, state WHERE state_id = hospital_state", nativeQuery = true)
	public List<Hospital> serchUserByState(String hospital_state);
	

}

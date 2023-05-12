package com.project.bloodbanksystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.bloodbanksystem.model.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
	
	
	
	@Query(value = "SELECT * FROM donor WHERE donor_first_name = ?1", nativeQuery = true)
	public List<Donor> serchUserByName(String donor_name);
	
	// Example of Native Query - SQL
	@Query(value = "SELECT * FROM donor, state WHERE state_id = donor_state", nativeQuery = true)
	public List<Donor> serchUserByState(String donor_state);
	

}

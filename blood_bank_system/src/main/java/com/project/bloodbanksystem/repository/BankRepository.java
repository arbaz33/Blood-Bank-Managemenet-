package com.project.bloodbanksystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.bloodbanksystem.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
	
	
	
	@Query(value = "SELECT * FROM bank WHERE bank_first_name = ?1", nativeQuery = true)
	public List<Bank> serchUserByName(String bank_name);
	
	// Example of Native Query - SQL
	@Query(value = "SELECT * FROM bank, state WHERE state_id = bank_state", nativeQuery = true)
	public List<Bank> serchUserByState(String bank_state);
	

}

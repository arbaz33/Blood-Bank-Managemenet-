package com.project.bloodbanksystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bloodbanksystem.exception.ResourceNotFoundException;
import com.project.bloodbanksystem.model.Bank;
import com.project.bloodbanksystem.repository.BankRepository;
import com.project.bloodbanksystem.services.FileUploadService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class BankController {

	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	public FileUploadService fileService;
	
	@PersistenceContext
    private EntityManager entityManager;

	/**
	 * Function for getting all banks list
	 * @return
	 */
	@GetMapping("/bank")
	public List<Bank> getAllBanks() {
		return bankRepository.findAll();
	}

	/**
	 * Function for searching bank name
	 * @param bankName
	 * @return
	 */
	@GetMapping("/bank/search/{name}")
	public List<Bank> getBankByName(@PathVariable(value = "name") String bankName) {
			return bankRepository.serchUserByName(bankName);
	}
	
	/** 
	 * Function for searching by state
	 * @param bankState
	 * @return
	 */
	@GetMapping("/bank/search-state/{state}")
	public List<Bank> serchUserByState(@PathVariable(value = "state") String bankState) {
			return bankRepository.serchUserByState(bankState);
	}
	
	/**
	 * Function for getting single bank details
	 * @param bankId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/bank/{id}")
	public ResponseEntity<Bank> getBankById(@PathVariable(value = "id") Long bankId)
			throws ResourceNotFoundException {
		Bank bank = bankRepository.findById(bankId)
				.orElseThrow(() -> new ResourceNotFoundException("Bank not found for this id :: " + bankId));
		return ResponseEntity.ok().body(bank);
	}

	/**
	 * Function for creating bank
	 * @param bank
	 * @return
	 */
	@PostMapping("/bank")
	public Bank createBank(@Valid @RequestBody Bank bank) {
		System.out.print("I am here");
		System.out.print(bank);
		return bankRepository.save(bank);
	}
	
	/**
	 * Function for editing and updating bank
	 * @param bankId
	 * @param bankDetails
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/bank/{id}")
	public ResponseEntity<Bank> updateBank(@PathVariable(value = "id") Long bankId,
			@Valid @RequestBody Bank bankDetails) throws ResourceNotFoundException {
		final Bank updatedBank = bankRepository.save(bankDetails);
		return ResponseEntity.ok(updatedBank);
	}

	/**
	 * Function for deleting bank
	 * @param bankId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/bank/{id}")
	public Map<String, Boolean> deleteBank(@PathVariable(value = "id") Long bankId)
			throws ResourceNotFoundException {
		Bank bank = bankRepository.findById(bankId)
				.orElseThrow(() -> new ResourceNotFoundException("Bank not found for this id :: " + bankId));

		bankRepository.delete(bank);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

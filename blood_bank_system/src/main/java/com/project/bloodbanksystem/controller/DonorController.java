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
import com.project.bloodbanksystem.model.Donor;
import com.project.bloodbanksystem.repository.DonorRepository;
import com.project.bloodbanksystem.services.FileUploadService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class DonorController {

	@Autowired
	private DonorRepository donorRepository;
	
	@Autowired
	public FileUploadService fileService;
	
	@PersistenceContext
    private EntityManager entityManager;

	/**
	 * Function for getting all donors list
	 * @return
	 */
	@GetMapping("/donor")
	public List<Donor> getAllDonors() {
		return donorRepository.findAll();
	}

	/**
	 * Function for searching donor name
	 * @param donorName
	 * @return
	 */
	@GetMapping("/donor/search/{name}")
	public List<Donor> getDonorByName(@PathVariable(value = "name") String donorName) {
			return donorRepository.serchUserByName(donorName);
	}
	
	/** 
	 * Function for searching by state
	 * @param donorState
	 * @return
	 */
	@GetMapping("/donor/search-state/{state}")
	public List<Donor> serchUserByState(@PathVariable(value = "state") String donorState) {
			return donorRepository.serchUserByState(donorState);
	}
	
	/**
	 * Function for getting single donor details
	 * @param donorId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/donor/{id}")
	public ResponseEntity<Donor> getDonorById(@PathVariable(value = "id") Long donorId)
			throws ResourceNotFoundException {
		Donor donor = donorRepository.findById(donorId)
				.orElseThrow(() -> new ResourceNotFoundException("Donor not found for this id :: " + donorId));
		return ResponseEntity.ok().body(donor);
	}

	/**
	 * Function for creating donor
	 * @param donor
	 * @return
	 */
	@PostMapping("/donor")
	public Donor createDonor(@Valid @RequestBody Donor donor) {
		System.out.print("I am here");
		System.out.print(donor);
		return donorRepository.save(donor);
	}
	
	/**
	 * Function for editing and updating donor
	 * @param donorId
	 * @param donorDetails
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/donor/{id}")
	public ResponseEntity<Donor> updateDonor(@PathVariable(value = "id") Long donorId,
			@Valid @RequestBody Donor donorDetails) throws ResourceNotFoundException {
		final Donor updatedDonor = donorRepository.save(donorDetails);
		return ResponseEntity.ok(updatedDonor);
	}

	/**
	 * Function for deleting donor
	 * @param donorId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/donor/{id}")
	public Map<String, Boolean> deleteDonor(@PathVariable(value = "id") Long donorId)
			throws ResourceNotFoundException {
		Donor donor = donorRepository.findById(donorId)
				.orElseThrow(() -> new ResourceNotFoundException("Donor not found for this id :: " + donorId));

		donorRepository.delete(donor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

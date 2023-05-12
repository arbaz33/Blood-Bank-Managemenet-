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
import com.project.bloodbanksystem.model.Hospital;
import com.project.bloodbanksystem.repository.HospitalRepository;
import com.project.bloodbanksystem.services.FileUploadService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class HospitalController {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	public FileUploadService fileService;
	
	@PersistenceContext
    private EntityManager entityManager;

	/**
	 * Function for getting all hospitals list
	 * @return
	 */
	@GetMapping("/hospital")
	public List<Hospital> getAllHospitals() {
		return hospitalRepository.findAll();
	}

	/**
	 * Function for searching hospital name
	 * @param hospitalName
	 * @return
	 */
	@GetMapping("/hospital/search/{name}")
	public List<Hospital> getHospitalByName(@PathVariable(value = "name") String hospitalName) {
			return hospitalRepository.serchUserByName(hospitalName);
	}
	
	/** 
	 * Function for searching by state
	 * @param hospitalState
	 * @return
	 */
	@GetMapping("/hospital/search-state/{state}")
	public List<Hospital> serchUserByState(@PathVariable(value = "state") String hospitalState) {
			return hospitalRepository.serchUserByState(hospitalState);
	}
	
	/**
	 * Function for getting single hospital details
	 * @param hospitalId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/hospital/{id}")
	public ResponseEntity<Hospital> getHospitalById(@PathVariable(value = "id") Long hospitalId)
			throws ResourceNotFoundException {
		Hospital hospital = hospitalRepository.findById(hospitalId)
				.orElseThrow(() -> new ResourceNotFoundException("Hospital not found for this id :: " + hospitalId));
		return ResponseEntity.ok().body(hospital);
	}

	/**
	 * Function for creating hospital
	 * @param hospital
	 * @return
	 */
	@PostMapping("/hospital")
	public Hospital createHospital(@Valid @RequestBody Hospital hospital) {
		System.out.print("I am here");
		System.out.print(hospital);
		return hospitalRepository.save(hospital);
	}
	
	/**
	 * Function for editing and updating hospital
	 * @param hospitalId
	 * @param hospitalDetails
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/hospital/{id}")
	public ResponseEntity<Hospital> updateHospital(@PathVariable(value = "id") Long hospitalId,
			@Valid @RequestBody Hospital hospitalDetails) throws ResourceNotFoundException {
		final Hospital updatedHospital = hospitalRepository.save(hospitalDetails);
		return ResponseEntity.ok(updatedHospital);
	}

	/**
	 * Function for deleting hospital
	 * @param hospitalId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/hospital/{id}")
	public Map<String, Boolean> deleteHospital(@PathVariable(value = "id") Long hospitalId)
			throws ResourceNotFoundException {
		Hospital hospital = hospitalRepository.findById(hospitalId)
				.orElseThrow(() -> new ResourceNotFoundException("Hospital not found for this id :: " + hospitalId));

		hospitalRepository.delete(hospital);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

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
import com.project.bloodbanksystem.model.Seeker;
import com.project.bloodbanksystem.repository.SeekerRepository;
import com.project.bloodbanksystem.services.FileUploadService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class SeekerController {

	@Autowired
	private SeekerRepository seekerRepository;
	
	@Autowired
	public FileUploadService fileService;
	
	@PersistenceContext
    private EntityManager entityManager;

	/**
	 * Function for getting all seekers list
	 * @return
	 */
	@GetMapping("/seeker")
	public List<Seeker> getAllSeekers() {
		return seekerRepository.findAll();
	}

	/**
	 * Function for searching seeker name
	 * @param seekerName
	 * @return
	 */
	@GetMapping("/seeker/search/{name}")
	public List<Seeker> getSeekerByName(@PathVariable(value = "name") String seekerName) {
			return seekerRepository.serchUserByName(seekerName);
	}
	
	/** 
	 * Function for searching by state
	 * @param seekerState
	 * @return
	 */
	@GetMapping("/seeker/search-state/{state}")
	public List<Seeker> serchUserByState(@PathVariable(value = "state") String seekerState) {
			return seekerRepository.serchUserByState(seekerState);
	}
	
	/**
	 * Function for getting single seeker details
	 * @param seekerId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/seeker/{id}")
	public ResponseEntity<Seeker> getSeekerById(@PathVariable(value = "id") Long seekerId)
			throws ResourceNotFoundException {
		Seeker seeker = seekerRepository.findById(seekerId)
				.orElseThrow(() -> new ResourceNotFoundException("Seeker not found for this id :: " + seekerId));
		return ResponseEntity.ok().body(seeker);
	}

	/**
	 * Function for creating seeker
	 * @param seeker
	 * @return
	 */
	@PostMapping("/seeker")
	public Seeker createSeeker(@Valid @RequestBody Seeker seeker) {
		System.out.print("I am here");
		System.out.print(seeker);
		return seekerRepository.save(seeker);
	}
	
	/**
	 * Function for editing and updating seeker
	 * @param seekerId
	 * @param seekerDetails
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/seeker/{id}")
	public ResponseEntity<Seeker> updateSeeker(@PathVariable(value = "id") Long seekerId,
			@Valid @RequestBody Seeker seekerDetails) throws ResourceNotFoundException {
		final Seeker updatedSeeker = seekerRepository.save(seekerDetails);
		return ResponseEntity.ok(updatedSeeker);
	}

	/**
	 * Function for deleting seeker
	 * @param seekerId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/seeker/{id}")
	public Map<String, Boolean> deleteSeeker(@PathVariable(value = "id") Long seekerId)
			throws ResourceNotFoundException {
		Seeker seeker = seekerRepository.findById(seekerId)
				.orElseThrow(() -> new ResourceNotFoundException("Seeker not found for this id :: " + seekerId));

		seekerRepository.delete(seeker);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

package com.project.bloodbanksystem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
import com.project.bloodbanksystem.model.Bgroup;
import com.project.bloodbanksystem.model.Blood;
import com.project.bloodbanksystem.repository.BloodRepository;
import com.project.bloodbanksystem.services.FileUploadService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class BloodController {

	@Autowired
	private BloodRepository bloodRepository;
	
	@Autowired
	public FileUploadService fileService;
	
	@PersistenceContext
    private EntityManager entityManager;

	/**
	 * Function for getting all bloods list
	 * @return
	 */
	@GetMapping("/blood")
	public List<Blood> getAllBloods() {
		return bloodRepository.findAll();
	}

	/**
	 * Function for getting single blood details
	 * @param bloodId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/blood/{id}")
	public ResponseEntity<Blood> getBloodById(@PathVariable(value = "id") Long bloodId)
			throws ResourceNotFoundException {
		Blood blood = bloodRepository.findById(bloodId)
				.orElseThrow(() -> new ResourceNotFoundException("Blood not found for this id :: " + bloodId));
		return ResponseEntity.ok().body(blood);
	}

	/**
	 * Function for creating blood
	 * @param blood
	 * @return
	 */
	@PostMapping("/blood")
	public Blood createBlood(@Valid @RequestBody Blood blood) {
		System.out.print("I am here");
		System.out.print(blood);
		return bloodRepository.save(blood);
	}
	
	/**
	 * Function for editing and updating blood
	 * @param bloodId
	 * @param bloodDetails
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/blood/{id}")
	public ResponseEntity<Blood> updateBlood(@PathVariable(value = "id") Long bloodId,
			@Valid @RequestBody Blood bloodDetails) throws ResourceNotFoundException {
		final Blood updatedBlood = bloodRepository.save(bloodDetails);
		return ResponseEntity.ok(updatedBlood);
	}

	/**
	 * Function for deleting blood
	 * @param bloodId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/blood/{id}")
	public Map<String, Boolean> deleteBlood(@PathVariable(value = "id") Long bloodId)
			throws ResourceNotFoundException {
		Blood blood = bloodRepository.findById(bloodId)
				.orElseThrow(() -> new ResourceNotFoundException("Blood not found for this id :: " + bloodId));

		bloodRepository.delete(blood);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	/**
	 * Getting the list of all bloods
	 * @return
	 */
	
	@GetMapping("/blood/blood-report")
	public ArrayList getAllBloodReport(){
		
		 String SQL = "SELECT blood, bank, group from blood blood, bank bank,bgroup group  WHERE blood_bgroup_id = bgroup_id AND blood_bank_id = bank_id";
		 Query q = entityManager.createQuery(SQL);
		 List<Object[]> job = q.getResultList();
		 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		 for ( Object[] row : job ) {
			  Blood blood_details = (Blood)row[ 0 ];
			  Bank bank_details = (Bank)row[ 1 ];
			  Bgroup group_details = (Bgroup)row[ 2 ];
				 
			
				HashMap<String, String> results = new HashMap();
				   
				results.put("blood_id",String.valueOf(blood_details.getBlood_id()));
				results.put("blood_bank_id",blood_details.getBlood_bank_id());
				results.put("blood_bgroup_id",blood_details.getBlood_bgroup_id());
				results.put("bgroup_image",group_details.getBgroup_image());
				results.put("blood_quantity",blood_details.getBlood_quantity());
				results.put("blood_description",blood_details.getBlood_description());
				results.put("bank_name",bank_details.getBank_name());
				results.put("bank_city",bank_details.getBank_city());
				results.put("bank_state",bank_details.getBank_state());
				results.put("bank_address",bank_details.getBank_address());
				results.put("bank_contact",bank_details.getBank_contact());
				results.put("bank_email",bank_details.getBank_email());
				results.put("bgroup_name",group_details.getBgroup_name());
								
				resultArray.add(results);
			 
		 }	 
	
	    return resultArray;
	}
	
	/**
	 * Getting the list of all bloods
	 * @return
	 */
	
	@GetMapping("/blood/blood-detaills/{id}")
	public ArrayList getBloodDetails(@PathVariable(value = "id") String blood_id){
		
		 String SQL = "SELECT blood, bank, group from blood blood, bank bank,bgroup group  WHERE blood_bgroup_id = bgroup_id AND blood_bank_id = bank_id AND blood_id = :blood_id";
		 Query q = entityManager.createQuery(SQL);
		 q.setParameter("blood_id", blood_id);
		 List<Object[]> job = q.getResultList();
		 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		 for ( Object[] row : job ) {
			  Blood blood_details = (Blood)row[ 0 ];
			  Bank bank_details = (Bank)row[ 1 ];
			  Bgroup group_details = (Bgroup)row[ 2 ];
				 
			
				HashMap<String, String> results = new HashMap();
				   
				results.put("blood_id",String.valueOf(blood_details.getBlood_id()));
				results.put("blood_bank_id",blood_details.getBlood_bank_id());
				results.put("blood_bgroup_id",blood_details.getBlood_bgroup_id());
				results.put("bgroup_image",group_details.getBgroup_image());
				results.put("blood_quantity",blood_details.getBlood_quantity());
				results.put("blood_description",blood_details.getBlood_description());
				results.put("bank_name",bank_details.getBank_name());
				results.put("bank_city",bank_details.getBank_city());
				results.put("bank_state",bank_details.getBank_state());
				results.put("bank_address",bank_details.getBank_address());
				results.put("bank_contact",bank_details.getBank_contact());
				results.put("bank_email",bank_details.getBank_email());
				results.put("bgroup_name",group_details.getBgroup_name());
								
				resultArray.add(results);
			 
		 }	 
	
	    return resultArray;
	}
}

package net.javaguides.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Patient;

import net.javaguides.springboot.repository.PatientRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class PatientController {
	
	
	@Autowired
	private PatientRepository patientRepository;
	
	//Get all patients
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}
	
	//Create new patient
	@PostMapping("/patients")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}
	
	//Get patient by id
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> gePatientById(@PathVariable Long id) {
		
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id : " + id));
		return ResponseEntity.ok(patient);
	}
	
	//update patient
	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long id,@RequestBody Patient patientDetails){
		
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id : " + id));
		patient.setName(patientDetails.getName());
		patient.setNIC(patientDetails.getNIC());
		patient.setAddress(patientDetails.getAddress());
		patient.setPhone(patientDetails.getPhone());
		patient.setEmail(patientDetails.getEmail());
		patient.setGender(patientDetails.getGender());
		patient.setDOB(patientDetails.getDOB());
		patient.setServeType(patientDetails.getServeType());
		patient.setDate(patientDetails.getDate());
		patient.setPayment(patientDetails.getPayment());

		Patient updatedPatient = patientRepository.save(patient);
		return ResponseEntity.ok(updatedPatient);
	}
	
	//Delete patient
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id){
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id : " + id));
		
		patientRepository.delete(patient);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	
	
}

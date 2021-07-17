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
import net.javaguides.springboot.model.Doctor;
import net.javaguides.springboot.repository.DoctorRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class DoctorController {

	@Autowired
	private DoctorRepository doctorRepository;
	
	/*@PostMapping(value="/create")
	public Map<String, Object> create(@RequestBody Doctor data){
		HashMap<String, Object>response = new HashMap<String, Object>();
		try {
			
			Optional<Doctor> validNic = doctorRepository.findByNic(data,getNic());
			
			if(validNic.ispresent()) {
				response.put("message", "The Nic"+data.getNic()+"is already registered");
				response.put("success", true);
				return response;
				
			}
			else {
			doctorRepository.save(data);
			response.put("message", "successful save");
			response.put("success", true);
			return response;
			}
			
		}catch(Exception e) {
			//TODO:handle exception
			response.put("message", e.getMessage());
			response.put("success", false);
			return response;
		}
		
	}*/
	


	// get all doctors
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctors(){
		return doctorRepository.findAll();
	}		
	
	// create doctor rest api
	@PostMapping("/doctors")
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	// get doctor by id rest api
	@GetMapping("/doctors/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
		Doctor doctor = doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id :" + id));
		return ResponseEntity.ok(doctor);
	}
	
	// update doctor rest api
	
	@PutMapping("/doctors/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails){
		Doctor doctor = doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id :" + id));
		
		doctor.setFullName(doctorDetails.getFullName());
		doctor.setNic(doctorDetails.getNic());
		doctor.setSpecialization(doctorDetails.getSpecialization());
		doctor.setDepartment(doctorDetails.getDepartment());
		doctor.setContactnumber(doctorDetails.getContactnumber());
		doctor.setAddress(doctorDetails.getAddress());
		doctor.setEmail(doctorDetails.getEmail());
		doctor.setRegistrationdate(doctorDetails.getRegistrationdate());
		
		Doctor updatedDoctor = doctorRepository.save(doctor);
		return ResponseEntity.ok(updatedDoctor);
	}
	
	// delete doctor rest api
	@DeleteMapping("/doctors/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDoctor(@PathVariable Long id){
		Doctor doctor = doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id :" + id));
		
		doctorRepository.delete(doctor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}

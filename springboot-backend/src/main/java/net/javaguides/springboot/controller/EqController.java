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
import net.javaguides.springboot.model.EqModel;
import net.javaguides.springboot.repository.EqRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EqController {

	@Autowired
	private EqRepo equipmentRepository;
	
	//get all equipment
	
		@GetMapping("/eq")
		 public List<EqModel> getAllEquipment(){
			return equipmentRepository.findAll();
		}
		
		//create equipment rest api
		@PostMapping("/eq")
		public EqModel createEquipment(@RequestBody EqModel equipment) {
			return equipmentRepository.save(equipment);
		}
			
		//get equipment by id rest api
		
	     @GetMapping("/eq/{equipmentId}")
		public ResponseEntity<EqModel> getEquipmentById(@PathVariable  int equipmentId) {
	    	 
	    	EqModel equipment  = equipmentRepository.findById(equipmentId)
	    			 .orElseThrow(()-> new ResourceNotFoundException("Lab details does not exist with id:" + equipmentId));
	    	 
			return ResponseEntity.ok(equipment);
		}
		
		
	     
	     //update equipmentDetails rest api
	     @PutMapping("/eq/{equipmentId}")
	     public ResponseEntity<EqModel> updateEquipment(@PathVariable  int equipmentId,@RequestBody EqModel equipmentDetails){
	    	 
	    	 
	    	 EqModel equipment  = equipmentRepository.findById(equipmentId)
	    			 .orElseThrow(()-> new ResourceNotFoundException("Equipment details does not exist with id:" +equipmentId));
	    	 
	    	  
	    	 equipment.setEquipmentId(equipmentDetails.getEquipmentId());
	    	 equipment.setEquipmentName(equipmentDetails.getEquipmentName());
	    	 equipment.setCount(equipmentDetails.getCount()); 
	    	 
	    	 EqModel updateEquipment =equipmentRepository.save(equipment);
	    	 return ResponseEntity.ok(updateEquipment);    	 
	    	 
	     }
	     
	     
	     //delete equipDetails rest api
	     @DeleteMapping("/eq/{equipmentId}")
	     public ResponseEntity<Map<String,Boolean>> deleteEquipment(@PathVariable int equipmentId){
	    	 
	    	 EqModel equipment  =  equipmentRepository.findById(equipmentId)
	    			 .orElseThrow(()-> new ResourceNotFoundException("Equipment details does not exist with id:" + equipmentId));
	    	 
	    	 equipmentRepository.delete(equipment);
	    	 Map<String, Boolean>response = new HashMap<>();
	    	 response.put("deleted" , Boolean.TRUE);
	    	 
	    	 return ResponseEntity.ok(response);
	    	 
	    	 
	     }
	     
	     

}

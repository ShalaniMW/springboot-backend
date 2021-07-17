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
import net.javaguides.springboot.model.Equipment;
import net.javaguides.springboot.repository.EquipmentRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EquipmentController {
 
	@Autowired
	public EquipmentRepository equipmentRepository;
	
	//get all equipments
	@GetMapping("/equipment")
	public List<Equipment> getAllEquipments(){
		return equipmentRepository.findAll();
	}
	
	//create equipment rest api
	@PostMapping("/equipment")
	public Equipment createEquipment(@RequestBody Equipment equipment) {
		return equipmentRepository.save(equipment);
	}
		
//get equipment by id rest api
	
     @GetMapping("/equipment/{eqId}")
	public ResponseEntity<Equipment> getEquipmentById(@PathVariable  long eqId) {
    	 
    	Equipment equipment  = equipmentRepository.findById(eqId)
    			 .orElseThrow(()-> new ResourceNotFoundException("OPD details does not exist with id:" + eqId));
    	 
		return ResponseEntity.ok(equipment);
	}
     
 	
     //update equipment rest api
     @PutMapping("/equipment/{eqId}")
     public ResponseEntity<Equipment> updateLab(@PathVariable  long eqId,@RequestBody Equipment equipmentDetails){
    	 
    	 
    	Equipment equipment  = equipmentRepository.findById(eqId)
    			 .orElseThrow(()-> new ResourceNotFoundException("OPD details does not exist with id:" + eqId));
    	
    	 equipment.setEqName(equipmentDetails.getEqName());
    	 equipment.setEQuantity(equipmentDetails.getEQuantity());
    	 equipment.setEUprice(equipmentDetails.getEUprice());
    	 equipment.setEStorage(equipmentDetails.getEStorage());
    	 equipment.setETrade(equipmentDetails.getETrade());
    	 equipment.setE_IS_Date(equipmentDetails.getE_IS_Date());
    	 equipment.setE_Ex_Date(equipmentDetails.getE_Ex_Date());
    	 
    	 Equipment updateEquipment = equipmentRepository.save(equipment);
    	 return ResponseEntity.ok(updateEquipment);    	 
    	 
     }
     
     //delete labDetails rest api
     @DeleteMapping("/equipment/{eqId}")
     public ResponseEntity<Map<String,Boolean>> deleteLab(@PathVariable long eqId){
    	 
    	 Equipment equipment  = equipmentRepository.findById(eqId)
    			 .orElseThrow(()-> new ResourceNotFoundException("OPD details does not exist with id:" + eqId));
    	 
    	 equipmentRepository.delete(equipment);
    	 Map<String, Boolean>response = new HashMap<>();
    	 response.put("deleted" , Boolean.TRUE);
    	 
    	 return ResponseEntity.ok(response);
    	 
     }
     
}

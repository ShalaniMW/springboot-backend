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
import net.javaguides.springboot.model.DrugModel;
import net.javaguides.springboot.repository.DrugRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class DrugController {
	
	@Autowired
	private DrugRepo drugRepo;
	
	//Get All Drugs
	@GetMapping("/drug")
	public List<DrugModel> getAllDrugs(){
		
		return drugRepo.findAll();
	}
	
	//Create Drug Rest Api
	@PostMapping("/drug")
	public DrugModel createDrug(@RequestBody DrugModel drug) {
			
		return drugRepo.save(drug);
	}
	
	//Get Drug by Id Rest Api
	@GetMapping("/drug/{drugId}")
	public ResponseEntity<DrugModel> getDrugById(@PathVariable Long drugId) {
			
		DrugModel drug = drugRepo.findById(drugId).orElseThrow(() -> new ResourceNotFoundException("404 Error: Drug not found by this id: " + drugId));
		return ResponseEntity.ok(drug);
	}
	
	//Update Drug Rest Api
	@PutMapping("/drug/{drugId}")
	public ResponseEntity<DrugModel> updateDrugById(@PathVariable Long drugId, @RequestBody DrugModel drugDet){
		
		DrugModel drug = drugRepo.findById(drugId).orElseThrow(() -> new ResourceNotFoundException("404 Error: Drug not found by this id: " + drugId));
		
		drug.setBufferStock(drugDet.getBufferStock());
		drug.setExpDate(drugDet.getExpDate());
		drug.setGenericName(drugDet.getGenericName());
		drug.setManuDate(drugDet.getManuDate());
		drug.setStorageLocation(drugDet.getStorageLocation());
		drug.setTradeName(drugDet.getTradeName());
		drug.setUnitPrice(drugDet.getUnitPrice());
		drug.setQuantity(drugDet.getQuantity());
		drug.setDepartment(drugDet.getDepartment());
		drug.setSupplierId(drugDet.getSupplierId());
		
		DrugModel updatedDrug = drugRepo.save(drug);
		return ResponseEntity.ok(updatedDrug);
		
	}
	
	//Delete Drug Rest Api
	@DeleteMapping("/drug/{drugId}")
	public ResponseEntity<Map<String, Boolean>> deleteDrug(@PathVariable Long drugId){
		
		DrugModel drug = drugRepo.findById(drugId).orElseThrow(() -> new ResourceNotFoundException("404 Error: Drug not found by this id: " + drugId));
		
		drugRepo.delete(drug);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
}
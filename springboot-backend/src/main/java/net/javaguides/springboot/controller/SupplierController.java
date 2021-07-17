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
import net.javaguides.springboot.model.Supplier;
import net.javaguides.springboot.repository.SupplierRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")


public class SupplierController {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	//Get all suppliers
	@GetMapping("/suppliers")
	public List<Supplier> getAllSuppliers(){
		return supplierRepository.findAll();
	}
	
	//Create new supplier
	@PostMapping("/suppliers")
	public Supplier createSupplier(@RequestBody Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	//Get supplier by id
	@GetMapping("/suppliers/{id}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
		
		Supplier supplier = supplierRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Supplier not exist with id : " + id));
		return ResponseEntity.ok(supplier);
	}
	
	//update supplier
	@PutMapping("/suppliers/{id}")
	public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id,@RequestBody Supplier supplierDetails){
		
		Supplier supplier = supplierRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Supplier not exist with id : " + id));
		supplier.setsName(supplierDetails.getsName());
		supplier.setsAddress(supplierDetails.getsAddress());
		supplier.setsNumber(supplierDetails.getsNumber());
		supplier.setDrugType(supplierDetails.getDrugType());
		

		Supplier updatedSupplier = supplierRepository.save(supplier);
		return ResponseEntity.ok(updatedSupplier);
	}
	
	//Delete supplier
	@DeleteMapping("/suppliers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSupplier(@PathVariable Long id){
		Supplier supplier = supplierRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Supplier not exist with id : " + id));
		
		supplierRepository.delete(supplier);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}

}

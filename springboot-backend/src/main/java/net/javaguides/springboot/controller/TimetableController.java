package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Timetable;
import net.javaguides.springboot.repository.TimetableRepository;

@CrossOrigin( origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TimetableController {

	@Autowired
	private TimetableRepository timetableRepository;
	
	
	//get the timetable
	@GetMapping("/timetable")
	public List<Timetable> getTimetable(){
		return timetableRepository.findAll();
	}
	
	//get timetable by ID
	@GetMapping("/timetable/{shiftID}")
	public ResponseEntity<Timetable> getTimetableByID(@PathVariable Long shiftID){
		Timetable timetable = timetableRepository.findById(shiftID).orElseThrow(() -> new ResourceNotFoundException("Timetable not exist without ID:" + shiftID));
		return ResponseEntity.ok(timetable);
	}
	
	//update timetable shifts
	@PutMapping("/timetable/{shiftID}")
	public ResponseEntity<Timetable> updateTimetable(@PathVariable Long shiftID,@RequestBody Timetable shiftDetails){
		Timetable timetable = timetableRepository.findById(shiftID).orElseThrow(() -> new ResourceNotFoundException("Timetable not exist without ID:" + shiftID));
		
		timetable.setMonday(shiftDetails.getMonday());
		timetable.setTuesday(shiftDetails.getTuesday());
		timetable.setWednesday(shiftDetails.getWednesday());
		timetable.setThursday(shiftDetails.getThursday());
		timetable.setFriday(shiftDetails.getFriday());
		timetable.setSaturday(shiftDetails.getSaturday());
		timetable.setSunday(shiftDetails.getSunday());
		
		Timetable updateTimetable = timetableRepository.save(timetable);
		return ResponseEntity.ok(updateTimetable);
	}
}

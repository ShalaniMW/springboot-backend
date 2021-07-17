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
import net.javaguides.springboot.model.Notification;
import net.javaguides.springboot.repository.NotificationRepository;

@CrossOrigin( origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class NotificationController {

	@Autowired
	private NotificationRepository notificationRepository;
	
	//get all notifications
	@GetMapping("/notification")
	public List<Notification> getAllNotifications(){
		return notificationRepository.findAll();
	}
	
	//create notification
	@PostMapping("/notification")
	public Notification createNotifications(@RequestBody Notification notification) {
		return notificationRepository.save(notification);	
	}
	
	//get notification by ID
	@GetMapping("/notification/{id}")
	public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
		Notification notification = notificationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notification not exist with ID:" + id));
		return ResponseEntity.ok(notification);
	}
	
	//update notification
	@PutMapping("/notification/{id}")
	public ResponseEntity<Notification> updateNotifications(@PathVariable Long id,@RequestBody Notification notificationDetails){
		Notification notification = notificationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notification is not exist without id  :" + id));
		
		notification.setNotify_name(notificationDetails.getNotify_name());
		notification.setNotify_body(notificationDetails.getNotify_body());
		notification.setNotify_date(notificationDetails.getNotify_date());
		
		Notification updateNotification = notificationRepository.save(notification);
		return ResponseEntity.ok(updateNotification);
		
	}
	
	
	//delete notifications
	@DeleteMapping("/notification/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteNotifications(@PathVariable Long id){
		Notification notification = notificationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notification is not exist without id  :" + id));
		
		notificationRepository.delete(notification);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	
	}
	
	
}

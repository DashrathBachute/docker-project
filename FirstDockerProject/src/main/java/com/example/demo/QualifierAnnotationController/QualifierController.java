package com.example.demo.QualifierAnnotationController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.QualifierAnnotation.NotificationService;

@RestController
@RequestMapping("/api")
public class QualifierController {

	
	
	private final NotificationService notificationService;
	//this is setter injection
//	@Autowired
//	@Qualifier("emailService")
//	private NotificationService notificationService;
	
	//COntructur injection 
	@Autowired
	public QualifierController(@Qualifier("emailService") NotificationService notificationService ) {
		this.notificationService= notificationService;
	}
	
	
	@GetMapping("/get")
	public String sendNotification() {
		return notificationService.sendNotification();
	}
	
}

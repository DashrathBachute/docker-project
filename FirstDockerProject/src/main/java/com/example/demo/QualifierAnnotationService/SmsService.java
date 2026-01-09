package com.example.demo.QualifierAnnotationService;

import org.springframework.stereotype.Service;

import com.example.demo.QualifierAnnotation.NotificationService;

@Service
public class SmsService implements NotificationService{

	@Override
	public String sendNotification() {
		return "Send Notification";
	}

}

package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.Mockitto.User;
import com.example.demo.Mockitto.UserRepository;
import com.example.demo.Mockitto.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	 @Mock
	 private UserRepository userRepository;
	 
	 @InjectMocks
	 private UserService userService;
	 
	 
	 @Test
	 public void saveUserTest() {
		 
		 User user = new User(1L, "Dashrath");
		 
		 when(userRepository.save(user)).thenReturn(user);
		 
		 User savedUser = userService.saveUser(user);
		 
		 assertNotNull(savedUser);
		 assertEquals("Dashrath", savedUser.getName());
		 
		 
		 
	 }
	

}

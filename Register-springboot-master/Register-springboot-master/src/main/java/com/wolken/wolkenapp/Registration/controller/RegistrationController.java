package com.wolken.wolkenapp.Registration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenapp.Registration.Entity.RegistrationEntity;
import com.wolken.wolkenapp.Registration.Service.RegistartionService;

@RestController
@Transactional
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/")
public class RegistrationController {
	@Autowired
	RegistartionService service;
	
	Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	@GetMapping("/index")
	public String index() {
		return "Hello";
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> addUserDetails(@RequestBody RegistrationEntity entity) {
		logger.info("Entered the controller");
		String message = service.validateAndAdd(entity);
		if (message.equals("data saved successfully")) {
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/getbyemail")
	public ResponseEntity<RegistrationEntity> getByEmail(String email) {
		logger.info("Entered the controller");
		RegistrationEntity regentity = service.validateAndGetByEmail(email);
		if (regentity != null) 
			return new ResponseEntity<RegistrationEntity>(regentity, HttpStatus.OK);
		return new ResponseEntity<RegistrationEntity>(regentity, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/updatebyemail")
	public ResponseEntity<String> updateByEmail(@RequestBody RegistrationEntity entity) {
		logger.info("Entered the controller");
		String message = service.validateAndUpdateByEmail(entity);
		if (message.equals("updated successfully"))
			return new ResponseEntity<String>(message, HttpStatus.OK);
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/deletebyemail")
	public ResponseEntity<String> deleteByEmail(String email) {
		logger.info("Entered the controller");
		String message = service.validateAndDeleteByEmail(email);
		if (message.equals("Deleted successfully"))
			return new ResponseEntity<String>(message, HttpStatus.OK);
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}

}

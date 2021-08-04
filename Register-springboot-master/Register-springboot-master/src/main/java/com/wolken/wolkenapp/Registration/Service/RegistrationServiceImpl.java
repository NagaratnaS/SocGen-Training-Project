package com.wolken.wolkenapp.Registration.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wolken.wolkenapp.Registration.Entity.RegistrationEntity;
import com.wolken.wolkenapp.Registration.Repository.RegistrartionRepository;

@Service
public class RegistrationServiceImpl implements RegistartionService{
	
	@Autowired
	RegistrartionRepository repo;
	@Autowired
	RegistrationEntity regentity;
	
	Logger log = LoggerFactory.getLogger(RegistrationServiceImpl.class);

	@Override
	public String validateAndAdd(RegistrationEntity entity) {
		// TODO Auto-generated method stub
		log.info("Entered validate and add");
		if(!entity.getFname().equals(null) && !entity.getGender().equals(null) && !entity.getEmail().equals(null) && !entity.getDateOfBirth().equals(null) && entity.getContactNo() > 0) {
			repo.save(entity);
			return "data saved successfully";
		} 
		log.error("Data not saved");
		return "data not saved,error";
	}

	@Override
	public RegistrationEntity validateAndGetByEmail(String email) {
		// TODO Auto-generated method stub
		log.info("Entered validateAndGertByEmail method");
		if(!email.equals(null)) {
			regentity = repo.findByEmail(email);
			if (regentity != null)
			 return regentity;
			log.error("Email not found");
			
		}
		log.info("Email id sent is null");
		return null;
	}

	@Override
	public String validateAndUpdateByEmail(RegistrationEntity entity) {
		// TODO Auto-generated method stub
		log.info("entered validateAndUpdateByEmail method");
		if(!entity.getFname().equals(null) && !entity.getGender().equals(null) && !entity.getEmail().equals(null) && !entity.getDateOfBirth().equals(null) && entity.getContactNo() > 0) {
			regentity = repo.findByEmail(entity.getEmail());
			log.info("All the entered data are valid");
			if(regentity != null) {
				log.info("data with given email found.. updating it");
				regentity.setFname(entity.getFname());
				regentity.setGender(entity.getGender());
				regentity.setDateOfBirth(entity.getDateOfBirth());
				regentity.setContactNo(entity.getContactNo());
				repo.save(regentity);
				return "updated successfully";
			}
			log.info("email not found");
		}
		log.info("Invalid user input");
		return "not updated some error";
	}

	@Override
	public String validateAndDeleteByEmail(String email) {
		// TODO Auto-generated method stub
		log.info("entered validateAndDeleteByEmail method");
		if(!email.equals(null)) {
			log.info("email is not null accessing db");
			int noOfRowsDeleted = repo.deleteByEmail(email);
			if (noOfRowsDeleted > 0) {
				log.info("Deleted successfully");
				return "Deleted successfully";
			}
				
			log.info("email not found!");
			
		}
		log.info("invalid user input");
		return "not deleted, error";
	}

}

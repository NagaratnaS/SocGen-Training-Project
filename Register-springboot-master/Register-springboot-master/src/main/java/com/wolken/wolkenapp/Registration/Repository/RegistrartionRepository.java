package com.wolken.wolkenapp.Registration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.wolkenapp.Registration.Entity.RegistrationEntity;

public interface RegistrartionRepository extends JpaRepository< RegistrationEntity, Integer>{
	
	public RegistrationEntity findByEmail(String email);
	public int deleteByEmail(String email);
	
}


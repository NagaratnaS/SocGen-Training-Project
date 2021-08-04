package com.wolken.wolkenapp.Registration.Service;

import com.wolken.wolkenapp.Registration.Entity.RegistrationEntity;

public interface RegistartionService {
	public String validateAndAdd(RegistrationEntity entity);
	public RegistrationEntity validateAndGetByEmail(String email);
	public String validateAndUpdateByEmail(RegistrationEntity entity);
	public String validateAndDeleteByEmail(String email);

}

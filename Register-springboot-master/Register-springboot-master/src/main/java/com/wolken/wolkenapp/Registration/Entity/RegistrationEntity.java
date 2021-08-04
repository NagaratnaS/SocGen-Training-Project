package com.wolken.wolkenapp.Registration.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Component
@Table(name = "regspring")
public class RegistrationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "personID")
	private int personID;
	@Column(name = "fname")
	private String fname;
	@Column(name = "email")
	private String email;
	@Column(name = "dateOfBirth")
	private String dateOfBirth;
	@Column(name = "contactNo")
	private int contactNo;
	@Column(name = "gender")
	private String gender;
	@Column(name = "password")
	private String password;
	@Transient
	private String confirmPassword;

}

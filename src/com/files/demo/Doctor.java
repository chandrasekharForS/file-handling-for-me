package com.files.demo;

import java.io.Serializable;

public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String doctorId;
	private String name;
	private String specialization;
	private String phoneNumber;
	private String email;
	private boolean isAvailable;
	
	public Doctor(String doctorId, String name, String specialization, String phoneNumber, String email) {
		this.doctorId = doctorId;
		this.name = name;
		this.specialization = specialization;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.isAvailable = true;
	}
	
	public String getDoctorId() {
		return doctorId;
	}
	
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSpecialization() {
		return specialization;
	}
	
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", specialization=" + specialization 
			+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", isAvailable=" + isAvailable + "]";
	}
}

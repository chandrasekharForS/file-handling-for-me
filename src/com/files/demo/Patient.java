package com.files.demo;

import java.io.Serializable;

public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String patientId;
	private String name;
	private int age;
	private String gender;
	private String phoneNumber;
	private String address;
	private String medicalHistory;
	
	public Patient(String patientId, String name, int age, String gender, String phoneNumber, String address) {
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.medicalHistory = "";
	}
	
	public String getPatientId() {
		return patientId;
	}
	
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getMedicalHistory() {
		return medicalHistory;
	}
	
	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	
	public void addToMedicalHistory(String record) {
		if (this.medicalHistory.isEmpty()) {
			this.medicalHistory = record;
		} else {
			this.medicalHistory += "; " + record;
		}
	}
	
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", age=" + age 
			+ ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", address=" + address 
			+ ", medicalHistory=" + medicalHistory + "]";
	}
}

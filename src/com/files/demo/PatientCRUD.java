package com.files.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PatientCRUD {
	private static final String FILE_NAME = "patients.ser";
	
	// Load patients from file
	public static List<Patient> loadPatients() {
		List<Patient> patients = new ArrayList<>();
		File file = new File(FILE_NAME);
		
		if (file.exists()) {
			try (FileInputStream fis = new FileInputStream(file);
				 ObjectInputStream ois = new ObjectInputStream(fis)) {
				patients = (List<Patient>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return patients;
	}
	
	// Save patients to file
	public static void savePatients(List<Patient> patients) {
		try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(patients);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Add a new patient
	public static void addPatient(Patient patient) {
		List<Patient> patients = loadPatients();
		
		// Check if patient already exists
		for (Patient p : patients) {
			if (p.getPatientId().equals(patient.getPatientId())) {
				System.out.println("Patient with ID " + patient.getPatientId() + " already exists!");
				return;
			}
		}
		
		patients.add(patient);
		savePatients(patients);
		System.out.println("Patient added successfully: " + patient.getName());
	}
	
	// Get patient by ID
	public static Patient getPatientById(String patientId) {
		List<Patient> patients = loadPatients();
		for (Patient patient : patients) {
			if (patient.getPatientId().equals(patientId)) {
				return patient;
			}
		}
		return null;
	}
	
	// Read all patients
	public static void readAllPatients() {
		List<Patient> patients = loadPatients();
		if (patients.isEmpty()) {
			System.out.println("No patients found.");
			return;
		}
		for (Patient patient : patients) {
			System.out.println(patient);
		}
	}
	
	// Update patient details
	public static void updatePatient(String patientId, Patient updatedPatient) {
		List<Patient> patients = loadPatients();
		for (int i = 0; i < patients.size(); i++) {
			if (patients.get(i).getPatientId().equals(patientId)) {
				patients.set(i, updatedPatient);
				savePatients(patients);
				System.out.println("Patient updated successfully: " + updatedPatient.getName());
				return;
			}
		}
		System.out.println("Patient not found with ID: " + patientId);
	}
	
	// Delete patient by ID
	public static void deletePatient(String patientId) {
		List<Patient> patients = loadPatients();
		boolean removed = patients.removeIf(patient -> patient.getPatientId().equals(patientId));
		if (removed) {
			savePatients(patients);
			System.out.println("Patient deleted successfully with ID: " + patientId);
		} else {
			System.out.println("Patient not found with ID: " + patientId);
		}
	}
}

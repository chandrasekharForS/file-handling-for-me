package com.files.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DoctorCRUD {
	private static final String FILE_NAME = "doctors.ser";
	
	// Load doctors from file
	public static List<Doctor> loadDoctors() {
		List<Doctor> doctors = new ArrayList<>();
		File file = new File(FILE_NAME);
		
		if (file.exists()) {
			try (FileInputStream fis = new FileInputStream(file);
				 ObjectInputStream ois = new ObjectInputStream(fis)) {
				doctors = (List<Doctor>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return doctors;
	}
	
	// Save doctors to file
	public static void saveDoctors(List<Doctor> doctors) {
		try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(doctors);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Add a new doctor
	public static void addDoctor(Doctor doctor) {
		List<Doctor> doctors = loadDoctors();
		
		// Check if doctor already exists
		for (Doctor d : doctors) {
			if (d.getDoctorId().equals(doctor.getDoctorId())) {
				System.out.println("Doctor with ID " + doctor.getDoctorId() + " already exists!");
				return;
			}
		}
		
		doctors.add(doctor);
		saveDoctors(doctors);
		System.out.println("Doctor added successfully: " + doctor.getName());
	}
	
	// Get doctor by ID
	public static Doctor getDoctorById(String doctorId) {
		List<Doctor> doctors = loadDoctors();
		for (Doctor doctor : doctors) {
			if (doctor.getDoctorId().equals(doctorId)) {
				return doctor;
			}
		}
		return null;
	}
	
	// Read all doctors
	public static void readAllDoctors() {
		List<Doctor> doctors = loadDoctors();
		if (doctors.isEmpty()) {
			System.out.println("No doctors found.");
			return;
		}
		for (Doctor doctor : doctors) {
			System.out.println(doctor);
		}
	}
	
	// Read doctors by specialization
	public static void readDoctorsBySpecialization(String specialization) {
		List<Doctor> doctors = loadDoctors();
		boolean found = false;
		for (Doctor doctor : doctors) {
			if (doctor.getSpecialization().equalsIgnoreCase(specialization)) {
				System.out.println(doctor);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No doctors found with specialization: " + specialization);
		}
	}
	
	// Update doctor details
	public static void updateDoctor(String doctorId, Doctor updatedDoctor) {
		List<Doctor> doctors = loadDoctors();
		for (int i = 0; i < doctors.size(); i++) {
			if (doctors.get(i).getDoctorId().equals(doctorId)) {
				doctors.set(i, updatedDoctor);
				saveDoctors(doctors);
				System.out.println("Doctor updated successfully: " + updatedDoctor.getName());
				return;
			}
		}
		System.out.println("Doctor not found with ID: " + doctorId);
	}
	
	// Delete doctor by ID
	public static void deleteDoctor(String doctorId) {
		List<Doctor> doctors = loadDoctors();
		boolean removed = doctors.removeIf(doctor -> doctor.getDoctorId().equals(doctorId));
		if (removed) {
			saveDoctors(doctors);
			System.out.println("Doctor deleted successfully with ID: " + doctorId);
		} else {
			System.out.println("Doctor not found with ID: " + doctorId);
		}
	}
}

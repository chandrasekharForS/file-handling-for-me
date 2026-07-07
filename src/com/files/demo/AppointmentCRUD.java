package com.files.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AppointmentCRUD {
	private static final String FILE_NAME = "appointments.ser";
	
	// Load appointments from file
	public static List<Appointment> loadAppointments() {
		List<Appointment> appointments = new ArrayList<>();
		File file = new File(FILE_NAME);
		
		if (file.exists()) {
			try (FileInputStream fis = new FileInputStream(file);
				 ObjectInputStream ois = new ObjectInputStream(fis)) {
				appointments = (List<Appointment>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return appointments;
	}
	
	// Save appointments to file
	public static void saveAppointments(List<Appointment> appointments) {
		try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(appointments);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Book new appointment
	public static void bookAppointment(Appointment appointment) {
		List<Appointment> appointments = loadAppointments();
		
		// Check if appointment already exists
		for (Appointment a : appointments) {
			if (a.getAppointmentId().equals(appointment.getAppointmentId())) {
				System.out.println("Appointment with ID " + appointment.getAppointmentId() + " already exists!");
				return;
			}
		}
		
		appointments.add(appointment);
		saveAppointments(appointments);
		System.out.println("Appointment booked successfully!");
	}
	
	// Get appointment by ID
	public static Appointment getAppointmentById(String appointmentId) {
		List<Appointment> appointments = loadAppointments();
		for (Appointment appointment : appointments) {
			if (appointment.getAppointmentId().equals(appointmentId)) {
				return appointment;
			}
		}
		return null;
	}
	
	// Get appointments by patient ID
	public static void readAppointmentsByPatient(String patientId) {
		List<Appointment> appointments = loadAppointments();
		boolean found = false;
		for (Appointment appointment : appointments) {
			if (appointment.getPatientId().equals(patientId)) {
				System.out.println(appointment);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No appointments found for patient ID: " + patientId);
		}
	}
	
	// Get appointments by doctor ID
	public static void readAppointmentsByDoctor(String doctorId) {
		List<Appointment> appointments = loadAppointments();
		boolean found = false;
		for (Appointment appointment : appointments) {
			if (appointment.getDoctorId().equals(doctorId)) {
				System.out.println(appointment);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No appointments found for doctor ID: " + doctorId);
		}
	}
	
	// Read all appointments
	public static void readAllAppointments() {
		List<Appointment> appointments = loadAppointments();
		if (appointments.isEmpty()) {
			System.out.println("No appointments found.");
			return;
		}
		for (Appointment appointment : appointments) {
			System.out.println(appointment);
		}
	}
	
	// Update appointment
	public static void updateAppointment(String appointmentId, Appointment updatedAppointment) {
		List<Appointment> appointments = loadAppointments();
		for (int i = 0; i < appointments.size(); i++) {
			if (appointments.get(i).getAppointmentId().equals(appointmentId)) {
				appointments.set(i, updatedAppointment);
				saveAppointments(appointments);
				System.out.println("Appointment updated successfully!");
				return;
			}
		}
		System.out.println("Appointment not found with ID: " + appointmentId);
	}
	
	// Cancel appointment
	public static void cancelAppointment(String appointmentId) {
		List<Appointment> appointments = loadAppointments();
		for (Appointment appointment : appointments) {
			if (appointment.getAppointmentId().equals(appointmentId)) {
				appointment.setStatus("Cancelled");
				saveAppointments(appointments);
				System.out.println("Appointment cancelled successfully!");
				return;
			}
		}
		System.out.println("Appointment not found with ID: " + appointmentId);
	}
	
	// Delete appointment
	public static void deleteAppointment(String appointmentId) {
		List<Appointment> appointments = loadAppointments();
		boolean removed = appointments.removeIf(appointment -> appointment.getAppointmentId().equals(appointmentId));
		if (removed) {
			saveAppointments(appointments);
			System.out.println("Appointment deleted successfully!");
		} else {
			System.out.println("Appointment not found with ID: " + appointmentId);
		}
	}
}

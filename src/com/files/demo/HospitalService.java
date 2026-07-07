package com.files.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HospitalService {
	private static int patientCounter = 1000;
	private static int doctorCounter = 2000;
	private static int appointmentCounter = 3000;
	private static int billCounter = 4000;
	
	// Generate unique IDs
	public static synchronized String generatePatientId() {
		return "P" + (++patientCounter);
	}
	
	public static synchronized String generateDoctorId() {
		return "D" + (++doctorCounter);
	}
	
	public static synchronized String generateAppointmentId() {
		return "APT" + (++appointmentCounter);
	}
	
	public static synchronized String generateBillId() {
		return "B" + (++billCounter);
	}
	
	// Register a new patient
	public static void registerPatient(Scanner sc) {
		System.out.println("\n--- Patient Registration ---");
		System.out.print("Enter Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Age: ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("Enter Gender: ");
		String gender = sc.nextLine();
		System.out.print("Enter Phone Number: ");
		String phone = sc.nextLine();
		System.out.print("Enter Address: ");
		String address = sc.nextLine();
		
		String patientId = generatePatientId();
		Patient patient = new Patient(patientId, name, age, gender, phone, address);
		PatientCRUD.addPatient(patient);
	}
	
	// Register a new doctor
	public static void registerDoctor(Scanner sc) {
		System.out.println("\n--- Doctor Registration ---");
		System.out.print("Enter Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Specialization: ");
		String specialization = sc.nextLine();
		System.out.print("Enter Phone Number: ");
		String phone = sc.nextLine();
		System.out.print("Enter Email: ");
		String email = sc.nextLine();
		
		String doctorId = generateDoctorId();
		Doctor doctor = new Doctor(doctorId, name, specialization, phone, email);
		DoctorCRUD.addDoctor(doctor);
	}
	
	// Book appointment
	public static void bookAppointment(Scanner sc) {
		System.out.println("\n--- Book Appointment ---");
		System.out.print("Enter Patient ID: ");
		String patientId = sc.nextLine();
		Patient patient = PatientCRUD.getPatientById(patientId);
		if (patient == null) {
			System.out.println("Patient not found!");
			return;
		}
		
		System.out.print("Enter Doctor ID: ");
		String doctorId = sc.nextLine();
		Doctor doctor = DoctorCRUD.getDoctorById(doctorId);
		if (doctor == null) {
			System.out.println("Doctor not found!");
			return;
		}
		
		if (!doctor.isAvailable()) {
			System.out.println("Doctor is not available!");
			return;
		}
		
		System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
		String date = sc.nextLine();
		System.out.print("Enter Appointment Time (HH:MM): ");
		String time = sc.nextLine();
		System.out.print("Enter Reason for Visit: ");
		String reason = sc.nextLine();
		
		String appointmentId = generateAppointmentId();
		Appointment appointment = new Appointment(appointmentId, patientId, doctorId, date, time, reason);
		AppointmentCRUD.bookAppointment(appointment);
		
		// Add to patient's medical history
		patient.addToMedicalHistory("Appointment on " + date + " with Dr. " + doctor.getName());
		PatientCRUD.updatePatient(patientId, patient);
	}
	
	// Generate bill for appointment
	public static void generateBillForAppointment(Scanner sc) {
		System.out.println("\n--- Generate Bill ---");
		System.out.print("Enter Appointment ID: ");
		String appointmentId = sc.nextLine();
		Appointment appointment = AppointmentCRUD.getAppointmentById(appointmentId);
		if (appointment == null) {
			System.out.println("Appointment not found!");
			return;
		}
		
		System.out.print("Enter Consultation Fee: ");
		double consultation = Double.parseDouble(sc.nextLine());
		System.out.print("Enter Medication Fee: ");
		double medication = Double.parseDouble(sc.nextLine());
		System.out.print("Enter Tests Fee: ");
		double tests = Double.parseDouble(sc.nextLine());
		
		String billId = generateBillId();
		Bill bill = new Bill(billId, appointment.getPatientId(), appointmentId, consultation, medication, tests, getTodayDate());
		BillCRUD.generateBill(bill);
	}
	
	// View patient details
	public static void viewPatientDetails(Scanner sc) {
		System.out.println("\n--- View Patient Details ---");
		System.out.print("Enter Patient ID: ");
		String patientId = sc.nextLine();
		Patient patient = PatientCRUD.getPatientById(patientId);
		if (patient != null) {
			System.out.println(patient);
		} else {
			System.out.println("Patient not found!");
		}
	}
	
	// View doctor details
	public static void viewDoctorDetails(Scanner sc) {
		System.out.println("\n--- View Doctor Details ---");
		System.out.print("Enter Doctor ID: ");
		String doctorId = sc.nextLine();
		Doctor doctor = DoctorCRUD.getDoctorById(doctorId);
		if (doctor != null) {
			System.out.println(doctor);
		} else {
			System.out.println("Doctor not found!");
		}
	}
	
	// Search doctors by specialization
	public static void searchDoctorsBySpecialization(Scanner sc) {
		System.out.println("\n--- Search Doctors by Specialization ---");
		System.out.print("Enter Specialization: ");
		String specialization = sc.nextLine();
		DoctorCRUD.readDoctorsBySpecialization(specialization);
	}
	
	// View appointments by patient
	public static void viewPatientAppointments(Scanner sc) {
		System.out.println("\n--- View Patient Appointments ---");
		System.out.print("Enter Patient ID: ");
		String patientId = sc.nextLine();
		AppointmentCRUD.readAppointmentsByPatient(patientId);
	}
	
	// View bills by patient
	public static void viewPatientBills(Scanner sc) {
		System.out.println("\n--- View Patient Bills ---");
		System.out.print("Enter Patient ID: ");
		String patientId = sc.nextLine();
		BillCRUD.readBillsByPatient(patientId);
	}
	
	// Mark bill as paid
	public static void markBillPaid(Scanner sc) {
		System.out.println("\n--- Mark Bill as Paid ---");
		System.out.print("Enter Bill ID: ");
		String billId = sc.nextLine();
		BillCRUD.markBillAsPaid(billId);
	}
	
	// Get today's date
	private static String getTodayDate() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return today.format(formatter);
	}
}

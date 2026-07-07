package com.files.demo;

import java.util.Scanner;

public class HospitalApp {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		
		while (running) {
			displayMainMenu();
			int choice = getIntInput(sc);
			
			switch (choice) {
				case 1:
					patientMenu(sc);
					break;
				case 2:
					doctorMenu(sc);
					break;
				case 3:
					appointmentMenu(sc);
					break;
				case 4:
					billingMenu(sc);
					break;
				case 5:
					running = false;
					System.out.println("\nThank you for using Hospital Management System!");
					break;
				default:
					System.out.println("Invalid choice! Please try again.");
			}
		}
		
		sc.close();
	}
	
	private static void displayMainMenu() {
		System.out.println("\n========================================");
		System.out.println("   HOSPITAL MANAGEMENT SYSTEM");
		System.out.println("========================================");
		System.out.println("1. Patient Management");
		System.out.println("2. Doctor Management");
		System.out.println("3. Appointment Management");
		System.out.println("4. Billing & Payment");
		System.out.println("5. Exit");
		System.out.print("Enter your choice: ");
	}
	
	private static void patientMenu(Scanner sc) {
		boolean inPatientMenu = true;
		
		while (inPatientMenu) {
			System.out.println("\n--- PATIENT MANAGEMENT ---");
			System.out.println("1. Register New Patient");
			System.out.println("2. View Patient Details");
			System.out.println("3. View All Patients");
			System.out.println("4. View Medical History");
			System.out.println("5. Back to Main Menu");
			System.out.print("Enter your choice: ");
			
			int choice = getIntInput(sc);
			
			switch (choice) {
				case 1:
					HospitalService.registerPatient(sc);
					break;
				case 2:
					HospitalService.viewPatientDetails(sc);
					break;
				case 3:
					System.out.println("\n--- All Patients ---");
					PatientCRUD.readAllPatients();
					break;
				case 4:
					HospitalService.viewPatientDetails(sc);
					break;
				case 5:
					inPatientMenu = false;
					break;
				default:
					System.out.println("Invalid choice! Please try again.");
			}
		}
	}
	
	private static void doctorMenu(Scanner sc) {
		boolean inDoctorMenu = true;
		
		while (inDoctorMenu) {
			System.out.println("\n--- DOCTOR MANAGEMENT ---");
			System.out.println("1. Register New Doctor");
			System.out.println("2. View Doctor Details");
			System.out.println("3. View All Doctors");
			System.out.println("4. Search Doctors by Specialization");
			System.out.println("5. Back to Main Menu");
			System.out.print("Enter your choice: ");
			
			int choice = getIntInput(sc);
			
			switch (choice) {
				case 1:
					HospitalService.registerDoctor(sc);
					break;
				case 2:
					HospitalService.viewDoctorDetails(sc);
					break;
				case 3:
					System.out.println("\n--- All Doctors ---");
					DoctorCRUD.readAllDoctors();
					break;
				case 4:
					HospitalService.searchDoctorsBySpecialization(sc);
					break;
				case 5:
					inDoctorMenu = false;
					break;
				default:
					System.out.println("Invalid choice! Please try again.");
			}
		}
	}
	
	private static void appointmentMenu(Scanner sc) {
		boolean inAppointmentMenu = true;
		
		while (inAppointmentMenu) {
			System.out.println("\n--- APPOINTMENT MANAGEMENT ---");
			System.out.println("1. Book Appointment");
			System.out.println("2. View Patient Appointments");
			System.out.println("3. View Doctor Appointments");
			System.out.println("4. View All Appointments");
			System.out.println("5. Cancel Appointment");
			System.out.println("6. Back to Main Menu");
			System.out.print("Enter your choice: ");
			
			int choice = getIntInput(sc);
			
			switch (choice) {
				case 1:
					HospitalService.bookAppointment(sc);
					break;
				case 2:
					HospitalService.viewPatientAppointments(sc);
					break;
				case 3:
					System.out.println("\n--- Doctor Appointments ---");
					System.out.print("Enter Doctor ID: ");
					String doctorId = sc.nextLine();
					AppointmentCRUD.readAppointmentsByDoctor(doctorId);
					break;
				case 4:
					System.out.println("\n--- All Appointments ---");
					AppointmentCRUD.readAllAppointments();
					break;
				case 5:
					System.out.println("\n--- Cancel Appointment ---");
					System.out.print("Enter Appointment ID: ");
					String appointmentId = sc.nextLine();
					AppointmentCRUD.cancelAppointment(appointmentId);
					break;
				case 6:
					inAppointmentMenu = false;
					break;
				default:
					System.out.println("Invalid choice! Please try again.");
			}
		}
	}
	
	private static void billingMenu(Scanner sc) {
		boolean inBillingMenu = true;
		
		while (inBillingMenu) {
			System.out.println("\n--- BILLING & PAYMENT ---");
			System.out.println("1. Generate Bill for Appointment");
			System.out.println("2. View Patient Bills");
			System.out.println("3. View All Bills");
			System.out.println("4. Mark Bill as Paid");
			System.out.println("5. Back to Main Menu");
			System.out.print("Enter your choice: ");
			
			int choice = getIntInput(sc);
			
			switch (choice) {
				case 1:
					HospitalService.generateBillForAppointment(sc);
					break;
				case 2:
					HospitalService.viewPatientBills(sc);
					break;
				case 3:
					System.out.println("\n--- All Bills ---");
					BillCRUD.readAllBills();
					break;
				case 4:
					HospitalService.markBillPaid(sc);
					break;
				case 5:
					inBillingMenu = false;
					break;
				default:
					System.out.println("Invalid choice! Please try again.");
			}
		}
	}
	
	private static int getIntInput(Scanner sc) {
		try {
			return Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input! Please enter a number.");
			return -1;
		}
	}
}

package com.files.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BillCRUD {
	private static final String FILE_NAME = "bills.ser";
	
	// Load bills from file
	public static List<Bill> loadBills() {
		List<Bill> bills = new ArrayList<>();
		File file = new File(FILE_NAME);
		
		if (file.exists()) {
			try (FileInputStream fis = new FileInputStream(file);
				 ObjectInputStream ois = new ObjectInputStream(fis)) {
				bills = (List<Bill>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return bills;
	}
	
	// Save bills to file
	public static void saveBills(List<Bill> bills) {
		try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(bills);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Generate new bill
	public static void generateBill(Bill bill) {
		List<Bill> bills = loadBills();
		
		// Check if bill already exists
		for (Bill b : bills) {
			if (b.getBillId().equals(bill.getBillId())) {
				System.out.println("Bill with ID " + bill.getBillId() + " already exists!");
				return;
			}
		}
		
		bills.add(bill);
		saveBills(bills);
		System.out.println("Bill generated successfully! Total Amount: " + bill.getTotalAmount());
	}
	
	// Get bill by ID
	public static Bill getBillById(String billId) {
		List<Bill> bills = loadBills();
		for (Bill bill : bills) {
			if (bill.getBillId().equals(billId)) {
				return bill;
			}
		}
		return null;
	}
	
	// Get bills by patient ID
	public static void readBillsByPatient(String patientId) {
		List<Bill> bills = loadBills();
		boolean found = false;
		double totalAmount = 0;
		for (Bill bill : bills) {
			if (bill.getPatientId().equals(patientId)) {
				System.out.println(bill);
				totalAmount += bill.getTotalAmount();
				found = true;
			}
		}
		if (found) {
			System.out.println("Total Outstanding: " + totalAmount);
		} else {
			System.out.println("No bills found for patient ID: " + patientId);
		}
	}
	
	// Read all bills
	public static void readAllBills() {
		List<Bill> bills = loadBills();
		if (bills.isEmpty()) {
			System.out.println("No bills found.");
			return;
		}
		for (Bill bill : bills) {
			System.out.println(bill);
		}
	}
	
	// Update bill
	public static void updateBill(String billId, Bill updatedBill) {
		List<Bill> bills = loadBills();
		for (int i = 0; i < bills.size(); i++) {
			if (bills.get(i).getBillId().equals(billId)) {
				bills.set(i, updatedBill);
				saveBills(bills);
				System.out.println("Bill updated successfully!");
				return;
			}
		}
		System.out.println("Bill not found with ID: " + billId);
	}
	
	// Mark bill as paid
	public static void markBillAsPaid(String billId) {
		List<Bill> bills = loadBills();
		for (Bill bill : bills) {
			if (bill.getBillId().equals(billId)) {
				bill.setPaymentStatus("Paid");
				saveBills(bills);
				System.out.println("Bill marked as paid!");
				return;
			}
		}
		System.out.println("Bill not found with ID: " + billId);
	}
	
	// Delete bill
	public static void deleteBill(String billId) {
		List<Bill> bills = loadBills();
		boolean removed = bills.removeIf(bill -> bill.getBillId().equals(billId));
		if (removed) {
			saveBills(bills);
			System.out.println("Bill deleted successfully!");
		} else {
			System.out.println("Bill not found with ID: " + billId);
		}
	}
}

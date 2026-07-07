package com.files.demo;

import java.io.Serializable;

public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String billId;
	private String patientId;
	private String appointmentId;
	private double consultationFee;
	private double medicationFee;
	private double testsFee;
	private double totalAmount;
	private String billDate;
	private String paymentStatus; // Paid, Pending, Partial
	
	public Bill(String billId, String patientId, String appointmentId, 
			   double consultationFee, double medicationFee, double testsFee, String billDate) {
		this.billId = billId;
		this.patientId = patientId;
		this.appointmentId = appointmentId;
		this.consultationFee = consultationFee;
		this.medicationFee = medicationFee;
		this.testsFee = testsFee;
		this.billDate = billDate;
		this.totalAmount = consultationFee + medicationFee + testsFee;
		this.paymentStatus = "Pending";
	}
	
	public String getBillId() {
		return billId;
	}
	
	public void setBillId(String billId) {
		this.billId = billId;
	}
	
	public String getPatientId() {
		return patientId;
	}
	
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	public double getConsultationFee() {
		return consultationFee;
	}
	
	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
		calculateTotal();
	}
	
	public double getMedicationFee() {
		return medicationFee;
	}
	
	public void setMedicationFee(double medicationFee) {
		this.medicationFee = medicationFee;
		calculateTotal();
	}
	
	public double getTestsFee() {
		return testsFee;
	}
	
	public void setTestsFee(double testsFee) {
		this.testsFee = testsFee;
		calculateTotal();
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	
	public String getBillDate() {
		return billDate;
	}
	
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	
	public String getPaymentStatus() {
		return paymentStatus;
	}
	
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	private void calculateTotal() {
		this.totalAmount = consultationFee + medicationFee + testsFee;
	}
	
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", patientId=" + patientId + ", appointmentId=" + appointmentId 
			+ ", consultationFee=" + consultationFee + ", medicationFee=" + medicationFee 
			+ ", testsFee=" + testsFee + ", totalAmount=" + totalAmount + ", billDate=" + billDate 
			+ ", paymentStatus=" + paymentStatus + "]";
	}
}

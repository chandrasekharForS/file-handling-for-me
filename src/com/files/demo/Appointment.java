package com.files.demo;

import java.io.Serializable;

public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String appointmentId;
	private String patientId;
	private String doctorId;
	private String appointmentDate;
	private String appointmentTime;
	private String reason;
	private String status; // Scheduled, Completed, Cancelled
	
	public Appointment(String appointmentId, String patientId, String doctorId, 
					   String appointmentDate, String appointmentTime, String reason) {
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.reason = reason;
		this.status = "Scheduled";
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	public String getPatientId() {
		return patientId;
	}
	
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	public String getDoctorId() {
		return doctorId;
	}
	
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	
	public String getAppointmentDate() {
		return appointmentDate;
	}
	
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	public String getAppointmentTime() {
		return appointmentTime;
	}
	
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", patientId=" + patientId 
			+ ", doctorId=" + doctorId + ", appointmentDate=" + appointmentDate 
			+ ", appointmentTime=" + appointmentTime + ", reason=" + reason + ", status=" + status + "]";
	}
}

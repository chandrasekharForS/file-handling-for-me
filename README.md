# Hospital Management System (Mini ERP)

## Overview
A comprehensive Hospital Management System built in Java that manages patients, doctors, appointments, and billing using file-based serialization for data persistence.

## Core Features

### 1. **Patient Management**
   - Register new patients
   - View patient details
   - Maintain medical history
   - Search patients by ID

### 2. **Doctor Management**
   - Register doctors with specialization
   - Track doctor availability
   - Search doctors by specialization
   - View doctor information

### 3. **Appointment Management**
   - Book appointments between patients and doctors
   - Track appointment status (Scheduled, Completed, Cancelled)
   - View appointments by patient or doctor
   - Cancel appointments
   - Automatic patient medical history updates

### 4. **Billing System**
   - Generate bills for appointments
   - Track payment status (Paid, Pending, Partial)
   - Calculate total charges (consultation + medication + tests)
   - View outstanding bills
   - Mark bills as paid

## Classes

### Model Classes
- **Patient.java** - Patient information model
- **Doctor.java** - Doctor information model
- **Appointment.java** - Appointment details model
- **Bill.java** - Billing information model

### CRUD Operations
- **PatientCRUD.java** - Patient data operations
- **DoctorCRUD.java** - Doctor data operations
- **AppointmentCRUD.java** - Appointment data operations
- **BillCRUD.java** - Bill data operations

### Business Logic
- **HospitalService.java** - Business operations and service methods
- **HospitalApp.java** - Main application with interactive menu system

## File Storage
Data is persisted using Java serialization to the following files:
- `patients.ser` - Patient records
- `doctors.ser` - Doctor records
- `appointments.ser` - Appointment records
- `bills.ser` - Billing records

## How to Run

1. **Compile the project:**
   ```bash
   javac -d bin src/com/files/demo/*.java
   ```

2. **Run the application:**
   ```bash
   java -cp bin com.files.demo.HospitalApp
   ```

## Main Menu
```
========================================
   HOSPITAL MANAGEMENT SYSTEM
========================================
1. Patient Management
2. Doctor Management
3. Appointment Management
4. Billing & Payment
5. Exit
```

## Features by Menu

### Patient Management
- Register new patients
- View patient details
- View all patients
- View medical history

### Doctor Management
- Register new doctors
- View doctor details
- View all doctors
- Search by specialization

### Appointment Management
- Book appointments
- View patient appointments
- View doctor appointments
- View all appointments
- Cancel appointments

### Billing & Payment
- Generate bills for appointments
- View patient bills
- View all bills
- Mark bills as paid

## Sample Data Entry

### Register a Patient
```
Name: John Doe
Age: 35
Gender: Male
Phone: 9876543210
Address: 123 Main Street
```

### Register a Doctor
```
Name: Dr. Smith
Specialization: Cardiology
Phone: 9123456789
Email: smith@hospital.com
```

### Book Appointment
```
Patient ID: P1001
Doctor ID: D2001
Date: 2024-12-25
Time: 14:30
Reason: Regular Checkup
```

### Generate Bill
```
Appointment ID: APT3001
Consultation Fee: 500
Medication Fee: 200
Tests Fee: 300
Total: 1000
```

## ID Generation
- **Patients:** P1001, P1002, ... (starting from P1000)
- **Doctors:** D2001, D2002, ... (starting from D2000)
- **Appointments:** APT3001, APT3002, ... (starting from APT3000)
- **Bills:** B4001, B4002, ... (starting from B4000)

## Data Persistence
All data is automatically saved to serialized files after each operation. Data is loaded from files when the application starts, ensuring continuity between sessions.

## Error Handling
- Patient/Doctor/Appointment existence checks
- Invalid input validation
- File I/O error handling
- Null pointer checks

## Future Enhancements
- Database integration (MySQL/PostgreSQL)
- GUI using Swing/JavaFX
- User authentication
- Report generation
- Email notifications
- SMS alerts
- Staff management
- Inventory management

## Author
Created as a Mini ERP System for Hospital Management using File Handling in Java.

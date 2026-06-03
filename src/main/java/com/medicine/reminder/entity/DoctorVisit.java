package com.medicine.reminder.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "doctor_visits")
public class DoctorVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String hospitalName;
    private String doctorName;
    private String doctorQualification;
    private String doctorSpecialist;

    private String patientCategory; 
    private String checkupReason;
    private LocalDate visitDate;
    private String prescriptionFile;

    @Column(length = 1000)
    private String doctorPrescription;

    private String prescriptionFileName;
    private String prescriptionFilePath;
}
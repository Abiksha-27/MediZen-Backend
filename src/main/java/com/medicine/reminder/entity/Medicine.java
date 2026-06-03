package com.medicine.reminder.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean reminderEnabled = true;
    private Long userId;
    private String medicineName;
    private String dosage;
    private LocalTime medicineTime;
    private LocalDate startDate;
    private LocalDate endDate;


}

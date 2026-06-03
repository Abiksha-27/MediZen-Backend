package com.medicine.reminder.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "medicine_status")
public class MedicineStatus {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long medicineName;
	    private Long medicineId;
	    private Long userId;
	    private LocalDate date;
	    private String status;
	    private String medicinePeriod;
	    private String foodTiming;
	    

}

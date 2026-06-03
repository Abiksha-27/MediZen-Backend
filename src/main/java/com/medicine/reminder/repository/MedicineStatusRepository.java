package com.medicine.reminder.repository;
import com.medicine.reminder.entity.MedicineStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicineStatusRepository extends JpaRepository<MedicineStatus, Long> {
    List<MedicineStatus> findByUserId(Long userId); 

}

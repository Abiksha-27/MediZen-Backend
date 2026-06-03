package com.medicine.reminder.repository;
import com.medicine.reminder.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findByUserId(Long userId);
    boolean existsByUserIdAndMedicineNameAndMedicineTime(
            Long userId,
            String medicineName,
            java.time.LocalTime medicineTime
    );

}

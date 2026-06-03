package com.medicine.reminder.repository;

import com.medicine.reminder.entity.DoctorVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DoctorVisitRepository extends JpaRepository<DoctorVisit, Long> {

    List<DoctorVisit> findByUserId(Long userId);
}
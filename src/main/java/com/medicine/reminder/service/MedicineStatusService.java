package com.medicine.reminder.service;

import com.medicine.reminder.entity.MedicineStatus;
import com.medicine.reminder.repository.MedicineStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineStatusService {

    @Autowired
    private MedicineStatusRepository statusRepository;

    public MedicineStatus markStatus(MedicineStatus status) {
        return statusRepository.save(status);
    }

    public List<MedicineStatus> getHistoryByUser(Long userId) {
        return statusRepository.findByUserId(userId);
    }
}
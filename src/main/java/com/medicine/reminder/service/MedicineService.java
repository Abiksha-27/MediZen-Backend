package com.medicine.reminder.service;
import com.medicine.reminder.entity.Medicine;
import com.medicine.reminder.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    public Medicine addMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public List<Medicine> getMedicinesByUser(Long userId) {
        return medicineRepository.findByUserId(userId);
    }

    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }
    public Medicine updateMedicine(Long id, Medicine newMedicine) {
        Medicine oldMedicine = medicineRepository.findById(id).orElse(null);

        if (oldMedicine == null) {
            return null;
        }

        oldMedicine.setMedicineName(newMedicine.getMedicineName());
        oldMedicine.setDosage(newMedicine.getDosage());
        oldMedicine.setMedicineTime(newMedicine.getMedicineTime());
        oldMedicine.setStartDate(newMedicine.getStartDate());
        oldMedicine.setEndDate(newMedicine.getEndDate());

        return medicineRepository.save(oldMedicine);
    }
    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id).orElse(null);
    }

    public Medicine saveMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }
    public Medicine turnOffReminder(Long id) {
        Medicine medicine = medicineRepository.findById(id).orElseThrow();
        medicine.setReminderEnabled(false);
        return medicineRepository.save(medicine);
    }
    
    

}

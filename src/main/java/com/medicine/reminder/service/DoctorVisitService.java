package com.medicine.reminder.service;

import com.medicine.reminder.entity.DoctorVisit;
import com.medicine.reminder.repository.DoctorVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Service
public class DoctorVisitService {

    @Autowired
    private DoctorVisitRepository doctorVisitRepository;

    private final String uploadDir = "uploads/";

    public DoctorVisit saveVisit(
            Long userId,
            String hospitalName,
            String doctorName,
            String doctorQualification,
            String doctorSpecialist,
            String patientCategory,
            String checkupReason,
            String visitDate,
            String doctorPrescription,
            MultipartFile file
    ) throws Exception {

        Files.createDirectories(Paths.get(uploadDir));

        String fileName = null;
        String filePath = null;

        if (file != null && !file.isEmpty()) {
            fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path path = Paths.get(uploadDir + fileName);
            Files.write(path, file.getBytes());
            filePath = path.toString();
        }

        DoctorVisit visit = new DoctorVisit();
        visit.setUserId(userId);
        visit.setHospitalName(hospitalName);
        visit.setDoctorName(doctorName);
        visit.setDoctorQualification(doctorQualification);
        visit.setDoctorSpecialist(doctorSpecialist);
        visit.setPatientCategory(patientCategory);
        visit.setCheckupReason(checkupReason);
        visit.setVisitDate(LocalDate.parse(visitDate));
        visit.setDoctorPrescription(doctorPrescription);
        visit.setPrescriptionFileName(fileName);
        visit.setPrescriptionFilePath(filePath);

        return doctorVisitRepository.save(visit);
    }

    public List<DoctorVisit> getVisitsByUser(Long userId) {
        return doctorVisitRepository.findByUserId(userId);
    }

    public List<DoctorVisit> getAllVisits() {
        return doctorVisitRepository.findAll();
    }
}
package com.medicine.reminder.controller;

import com.medicine.reminder.entity.DoctorVisit;
import com.medicine.reminder.repository.DoctorVisitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.*;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@RestController
@RequestMapping("/api/doctor-visits")
@CrossOrigin("*")
public class DoctorVisitController {

    @Autowired
    private DoctorVisitRepository repository;

    private final String uploadDir = "uploads/";

    @PostMapping("/add")
    public DoctorVisit addVisit(
            @RequestParam Long userId,
            @RequestParam String hospitalName,
            @RequestParam String doctorName,
            @RequestParam String doctorQualification,
            @RequestParam String doctorSpecialist,
            @RequestParam String patientCategory,
            @RequestParam String checkupReason,
            @RequestParam String visitDate,
            @RequestParam String doctorPrescription,
            @RequestParam(required = false) MultipartFile file
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

        return repository.save(visit);
    }
    @GetMapping("/user/{userId}")
    public List<DoctorVisit> getVisitsByUser(@PathVariable Long userId) {
        return repository.findByUserId(userId);
    }
    @GetMapping("/file/{fileName}")
    public ResponseEntity<org.springframework.core.io.Resource> viewFile(
            @PathVariable String fileName) throws Exception {

        Path path = Paths.get("uploads").resolve(fileName);
        org.springframework.core.io.Resource resource =
                new org.springframework.core.io.UrlResource(path.toUri());

        String contentType = Files.probeContentType(path);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(resource);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteDoctorVisit(@PathVariable Long id) {
        repository.deleteById(id);
        return "Doctor visit deleted successfully";
    }
}
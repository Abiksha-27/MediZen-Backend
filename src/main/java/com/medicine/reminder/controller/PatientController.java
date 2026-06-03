package com.medicine.reminder.controller;

import com.medicine.reminder.entity.Patient;
import com.medicine.reminder.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin("*")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient) {

        return patientRepository.save(patient);
    }
}
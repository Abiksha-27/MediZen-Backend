package com.medicine.reminder.controller;

import com.medicine.reminder.entity.MedicineStatus;
import com.medicine.reminder.service.MedicineStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
@CrossOrigin("*")
public class MedicineStatusController {

    @Autowired
    private MedicineStatusService statusService;

    @PostMapping("/mark")
    public MedicineStatus markStatus(@RequestBody MedicineStatus status) {
        return statusService.markStatus(status);
    }

    @GetMapping("/history/{userId}")
    public List<MedicineStatus> getHistory(@PathVariable Long userId) {
        return statusService.getHistoryByUser(userId);
    }
}
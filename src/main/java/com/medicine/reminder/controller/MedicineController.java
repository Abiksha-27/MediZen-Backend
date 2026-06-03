package com.medicine.reminder.controller;
import com.medicine.reminder.entity.Medicine;
import com.medicine.reminder.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
@CrossOrigin("*")
public class MedicineController {
	 @Autowired
	    private MedicineService medicineService;

	 @PostMapping("/add")
	 public Object addMedicine(@RequestBody Medicine medicine) {
	     return medicineService.addMedicine(medicine);
	 }
	    @GetMapping("/user/{userId}")
	    public List<Medicine> getMedicinesByUser(@PathVariable Long userId) {
	        return medicineService.getMedicinesByUser(userId);
	    }

	    @DeleteMapping("/delete/{id}")
	    public String deleteMedicine(@PathVariable Long id) {
	        medicineService.deleteMedicine(id);
	        return "Medicine deleted successfully";
	    }
	    @PutMapping("/update/{id}")
	    public Medicine updateMedicine(@PathVariable Long id, @RequestBody Medicine medicine) {
	        return medicineService.updateMedicine(id, medicine);
	    }
	    @PutMapping("/reminder-off/{id}")
	    public Medicine turnOffReminder(@PathVariable Long id) {
	        return medicineService.turnOffReminder(id);
	    }
	    

}

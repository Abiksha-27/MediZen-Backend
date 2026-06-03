package com.medicine.reminder.controller;

import com.medicine.reminder.entity.EmergencyContact;
import com.medicine.reminder.repository.EmergencyContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emergency")
@CrossOrigin("*")
public class EmergencyContactController {

    @Autowired
    private EmergencyContactRepository repository;

    @PostMapping("/add")
    public EmergencyContact addContact(@RequestBody EmergencyContact contact) {
        return repository.save(contact);
    }

    @GetMapping("/user/{userId}")
    public List<EmergencyContact> getContacts(@PathVariable Long userId) {
        return repository.findByUserId(userId);
    }
    @PutMapping("/update/{id}")
    public EmergencyContact updateContact(
            @PathVariable Long id,
            @RequestBody EmergencyContact updatedContact) {

        EmergencyContact contact =
                repository.findById(id).orElseThrow();

        contact.setContactName(updatedContact.getContactName());
        contact.setRelation(updatedContact.getRelation());
        contact.setPhoneNumber(updatedContact.getPhoneNumber());

        return repository.save(contact);
    }
}
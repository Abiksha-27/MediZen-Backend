package com.medicine.reminder.service;

import com.medicine.reminder.entity.EmergencyContact;
import com.medicine.reminder.repository.EmergencyContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmergencyContactService {

    @Autowired
    private EmergencyContactRepository repository;

    public EmergencyContact addContact(EmergencyContact contact) {
        return repository.save(contact);
    }

    public List<EmergencyContact> getContacts(Long userId) {
        return repository.findByUserId(userId);
    }
}
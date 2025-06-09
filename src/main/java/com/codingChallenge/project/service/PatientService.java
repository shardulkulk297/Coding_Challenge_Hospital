package com.codingChallenge.project.service;

import com.codingChallenge.project.model.Patient;
import com.codingChallenge.project.model.User;
import com.codingChallenge.project.model.enums.Role;
import com.codingChallenge.project.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final UserService userService;
    private final PatientRepository patientRepository;

    public PatientService(UserService userService, PatientRepository patientRepository) {
        this.userService = userService;
        this.patientRepository = patientRepository;
    }
    public Patient addPatient(Patient patient) {
        User user = patient.getUser();
        user.setRole(Role.PATIENT);
        user = userService.signUp(user);
        patient.setUser(user);
        return patientRepository.save(patient);
    }

    public Patient getByUsername(String username) {
        return patientRepository.getByUsername(username);
    }
}

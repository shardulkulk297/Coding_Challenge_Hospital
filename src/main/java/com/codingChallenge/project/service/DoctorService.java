package com.codingChallenge.project.service;

import com.codingChallenge.project.model.Doctor;
import com.codingChallenge.project.model.User;
import com.codingChallenge.project.model.enums.Role;
import com.codingChallenge.project.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private final UserService userService;
    private final DoctorRepository doctorRepository;

    public DoctorService(UserService userService, DoctorRepository doctorRepository) {
        this.userService = userService;
        this.doctorRepository = doctorRepository;
    }

    public Doctor addDoctor(Doctor doctor) {
        User user = doctor.getUser();
        user.setRole(Role.DOCTOR);
        user = userService.signUp(user);
        doctor.setUser(user);
        return doctorRepository.save(doctor);
    }
}

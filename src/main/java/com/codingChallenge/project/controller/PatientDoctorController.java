package com.codingChallenge.project.controller;

import com.codingChallenge.project.model.PatientDoctor;
import com.codingChallenge.project.service.PatientDoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientDoctorController {

    private final PatientDoctorService patientDoctorService;

    public PatientDoctorController(PatientDoctorService patientDoctorService) {
        this.patientDoctorService = patientDoctorService;
    }

    @PostMapping("/api/patient/doctor/appointment/add")
    public ResponseEntity<?> createAppointment(@RequestParam int patientId, @RequestParam int doctorId, @RequestBody PatientDoctor patientDoctor){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientDoctorService.createAppointment(patientId, doctorId, patientDoctor));
    }

}

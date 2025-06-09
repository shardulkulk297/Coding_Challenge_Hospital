package com.codingChallenge.project.service;

import com.codingChallenge.project.exception.ResourceNotFoundException;
import com.codingChallenge.project.model.Doctor;
import com.codingChallenge.project.model.Patient;
import com.codingChallenge.project.model.PatientDoctor;
import com.codingChallenge.project.repository.DoctorRepository;
import com.codingChallenge.project.repository.PatientDoctorRepository;
import com.codingChallenge.project.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientDoctorService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final PatientDoctorRepository patientDoctorRepository;

    public PatientDoctorService(PatientRepository patientRepository, DoctorRepository doctorRepository, PatientDoctorRepository patientDoctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.patientDoctorRepository = patientDoctorRepository;
    }

    public PatientDoctor createAppointment(int patientId, int doctorId, PatientDoctor patientDoctor) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new ResourceNotFoundException("Patient Not found"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()->new ResourceNotFoundException("Doctor not Found"));
        patientDoctor.setPatient(patient);
        patientDoctor.setDoctor(doctor);
        return patientDoctorRepository.save(patientDoctor);
    }
}

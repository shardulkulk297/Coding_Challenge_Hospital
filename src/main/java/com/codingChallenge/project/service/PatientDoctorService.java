package com.codingChallenge.project.service;

import com.codingChallenge.project.dto.PatientDto;
import com.codingChallenge.project.exception.ResourceNotFoundException;
import com.codingChallenge.project.model.Doctor;
import com.codingChallenge.project.model.MedicalHistory;
import com.codingChallenge.project.model.Patient;
import com.codingChallenge.project.model.PatientDoctor;
import com.codingChallenge.project.repository.DoctorRepository;
import com.codingChallenge.project.repository.PatientDoctorRepository;
import com.codingChallenge.project.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientDoctorService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final PatientDoctorRepository patientDoctorRepository;
    private final MedicalHistoryService medicalHistoryService;
    private final PatientDto patientDto;

    public PatientDoctorService(PatientRepository patientRepository, DoctorRepository doctorRepository, PatientDoctorRepository patientDoctorRepository, MedicalHistoryService medicalHistoryService, PatientDto patientDto) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.patientDoctorRepository = patientDoctorRepository;
        this.medicalHistoryService = medicalHistoryService;
        this.patientDto = patientDto;
    }

    public PatientDoctor createAppointment(int patientId, int doctorId, PatientDoctor patientDoctor) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new ResourceNotFoundException("Patient Not found"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()->new ResourceNotFoundException("Doctor not Found"));
        patientDoctor.setPatient(patient);
        patientDoctor.setDoctor(doctor);
        return patientDoctorRepository.save(patientDoctor);
    }

    public List<Patient> getPatientsByDoctor(int doctorId) {
        List<Patient> patients = patientDoctorRepository.getPatientsByDoctor(doctorId);
        return patients;
    }
}

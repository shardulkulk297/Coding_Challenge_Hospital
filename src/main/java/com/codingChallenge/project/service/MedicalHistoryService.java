package com.codingChallenge.project.service;

import com.codingChallenge.project.model.MedicalHistory;
import com.codingChallenge.project.model.Patient;
import com.codingChallenge.project.repository.MedicalHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicalHistoryService {

    private final PatientService patientService;
    private final MedicalHistoryRepository medicalHistoryRepository;

    public MedicalHistoryService(PatientService patientService, MedicalHistoryRepository medicalHistoryRepository) {
        this.patientService = patientService;
        this.medicalHistoryRepository = medicalHistoryRepository;
    }

    /*
    I have written a separate logic in patient service for adding patient so if patient exists already then:
    1. Fetch Id from username
    2. Set id to patient
    3. Set patient to medical history
    If not:
    1. Add patient using service
    2. Set that patient to medicalHistory
     */

    public MedicalHistory addPatientWithMedicalRecords(MedicalHistory medicalHistory) {
        Patient patient = medicalHistory.getPatient();
        Patient patientToCheck = patientService.getByUsername(patient.getUser().getUsername());
        if(patientToCheck!=null){
            patient.setId(patientToCheck.getId());
            medicalHistory.setPatient(patient);
        }
        else{
            patient = patientService.addPatient(patient);
            medicalHistory.setPatient(patient);
        }
        return medicalHistoryRepository.save(medicalHistory);
    }
}

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

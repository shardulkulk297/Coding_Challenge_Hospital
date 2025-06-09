package com.codingChallenge.project.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "patient_doctor")
public class PatientDoctor {
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    @Column(nullable = false, name = "date_of_appointment")
    private LocalDate dateOfAppointment;
    private LocalDate lastDateOfVisit;
    private String consultationReason;
    private String treatment_plan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(LocalDate dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public LocalDate getLastDateOfVisit() {
        return lastDateOfVisit;
    }

    public void setLastDateOfVisit(LocalDate lastDateOfVisit) {
        this.lastDateOfVisit = lastDateOfVisit;
    }

    public String getConsultationReason() {
        return consultationReason;
    }

    public void setConsultationReason(String consultationReason) {
        this.consultationReason = consultationReason;
    }

    public String getTreatment_plan() {
        return treatment_plan;
    }

    public void setTreatment_plan(String treatment_plan) {
        this.treatment_plan = treatment_plan;
    }
}

package com.codingChallenge.project.repository;

import com.codingChallenge.project.model.PatientDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDoctorRepository extends JpaRepository<PatientDoctor, Integer> {
}

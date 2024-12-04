package com.project.healthcare.Supporter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.healthcare.Supporter.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
  List<Patient> findByDoctorId(Long doctorId);
}

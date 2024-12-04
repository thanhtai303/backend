package com.project.healthcare.Supporter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.healthcare.Supporter.model.Patient;
import com.project.healthcare.Supporter.repository.DoctorRepository;
import com.project.healthcare.Supporter.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class DoctorService {
  private final DoctorRepository doctorRepository;
  private final PatientRepository patientRepository;

  @Autowired
  public DoctorService(DoctorRepository doctorRepository,
      PatientRepository patientRepository) {
    this.doctorRepository = doctorRepository;
    this.patientRepository = patientRepository;
  }

  public List<Patient> getPatientsList(Long doctorId) {
    return patientRepository.findByDoctorId(doctorId);
  }

  public void monitorPatientHealthStatus(Long patientId) {
    // Implementation for monitoring patient health
  }
}

package com.project.healthcare.Supporter.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.healthcare.Supporter.dtos.ConsultationDTO;
import com.project.healthcare.Supporter.exception_handler.ResourceNotFoundException;
import com.project.healthcare.Supporter.model.Consultation;
import com.project.healthcare.Supporter.model.Doctor;
import com.project.healthcare.Supporter.model.Patient;
import com.project.healthcare.Supporter.repository.ConsultationRepository;
import com.project.healthcare.Supporter.repository.DoctorRepository;
import com.project.healthcare.Supporter.repository.PatientRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsultationService {
  private final ConsultationRepository consultationRepository;
  private final DoctorRepository doctorRepository;
  private final PatientRepository patientRepository;

  @Autowired
  public ConsultationService(
      ConsultationRepository consultationRepository,
      DoctorRepository doctorRepository,
      PatientRepository patientRepository) {
    this.consultationRepository = consultationRepository;
    this.doctorRepository = doctorRepository;
    this.patientRepository = patientRepository;
  }

  @Transactional
  public ConsultationDTO createConsultation(Long patientId, Long doctorId) {
    Patient patient = patientRepository.findById(patientId)
        .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

    Doctor doctor = doctorRepository.findById(doctorId)
        .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));

    Consultation consultation = new Consultation();
    consultation.setPatient(patient);
    consultation.setDoctor(doctor);
    consultation.setStatus("PENDING");
    consultation.setCreatedAt(LocalDateTime.now());

    consultation = consultationRepository.save(consultation);
    return convertToDTO(consultation);
  }

  public List<ConsultationDTO> getPatientConsultations(Long patientId) {
    return consultationRepository.findByPatientIdOrderByCreatedAtDesc(patientId)
        .stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  private ConsultationDTO convertToDTO(Consultation consultation) {
    return new ConsultationDTO(
        consultation.getId(),
        consultation.getPatient().getId(),
        consultation.getDoctor().getId(),
        consultation.getStatus(),
        consultation.getCreatedAt());
  }
}

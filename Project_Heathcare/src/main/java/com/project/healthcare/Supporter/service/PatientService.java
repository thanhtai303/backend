package com.project.healthcare.Supporter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.healthcare.Supporter.director.PatientDirector;
import com.project.healthcare.Supporter.director.SensorDataDirector;
import com.project.healthcare.Supporter.dtos.PatientDTO;
import com.project.healthcare.Supporter.dtos.SensorDataDTO;
import com.project.healthcare.Supporter.model.Patient;
import com.project.healthcare.Supporter.model.SensorData;
import com.project.healthcare.Supporter.repository.PatientRepository;
import com.project.healthcare.Supporter.repository.SensorDataRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class PatientService {
  private final PatientRepository patientRepository;
  private final PatientDirector patientDirector;
  private final SensorDataDirector sensorDataDirector;
  private final SensorDataRepository sensorDataRepository;

  @Autowired
  public PatientService(PatientRepository patientRepository,
      PatientDirector patientDirector,
      SensorDataDirector sensorDataDirector,
      SensorDataRepository sensorDataRepository) {
    this.patientRepository = patientRepository;
    this.patientDirector = patientDirector;
    this.sensorDataDirector = sensorDataDirector;
    this.sensorDataRepository = sensorDataRepository;
  }

  public Patient createPatient(PatientDTO patientDTO) {
    Patient patient = patientDirector.constructPatient(
        patientDTO.getName(),
        patientDTO.getEmail(),
        patientDTO.getPassword(),
        patientDTO.getDob());
    return patientRepository.save(patient);
  }

  public SensorData addSensorData(Long patientId, SensorDataDTO sensorDataDTO) {
    Patient patient = patientRepository.findById(patientId)
        .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

    SensorData sensorData = sensorDataDirector.constructSensorData(
        sensorDataDTO.getTemperature(),
        sensorDataDTO.getBloodPressure(),
        sensorDataDTO.getHeartRate(),
        patient);
    return sensorDataRepository.save(sensorData);
  }

  public List<SensorData> getPatientHealthHistory(Long patientId) {
    return sensorDataRepository.findByPatientIdOrderByTimestampDesc(patientId);
  }
}

//

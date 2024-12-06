package com.project.healthcare.Supporter.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.healthcare.Supporter.dtos.HealthStatusDTO;
import com.project.healthcare.Supporter.dtos.SensorDataDTO;
import com.project.healthcare.Supporter.model.SensorData;
import com.project.healthcare.Supporter.repository.PatientRepository;
import com.project.healthcare.Supporter.repository.SensorDataRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HealthService {
  private final SensorDataRepository sensorDataRepository;

  @Autowired
  public HealthService(SensorDataRepository sensorDataRepository,
      PatientRepository patientRepository) {
    this.sensorDataRepository = sensorDataRepository;
  }

  public HealthStatusDTO getHealthStatus(Long patientId) {
    List<SensorData> sensorData = sensorDataRepository
        .findByPatientIdOrderByTimestampDesc(patientId);

    if (sensorData.isEmpty()) {
      return new HealthStatusDTO(null, "No data available", Collections.emptyList());
    }

    SensorData latest = sensorData.get(0);
    return analyzeHealthStatus(latest);
  }

  private HealthStatusDTO analyzeHealthStatus(SensorData data) {
    List<String> recommendations = new ArrayList<>();
    String status = "Normal";

    if (data.getTemperature() > 38.0) {
      status = "Warning";
      recommendations.add("High temperature detected. Please consult a doctor.");
    }

    if (data.getHeartRate() > 100 || data.getHeartRate() < 60) {
      status = "Warning";
      recommendations.add("Abnormal heart rate. Please monitor closely.");
    }

    return new HealthStatusDTO(
        convertToDTO(data),
        status,
        recommendations);
  }

  private SensorDataDTO convertToDTO(SensorData data) {
    return new SensorDataDTO(
        data.getPatient().getId(),
        data.getTemperature(),
        data.getBloodPressure(),
        data.getHeartRate(),
        data.getTimestamp());
  }
}

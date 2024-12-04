package com.project.healthcare.Supporter.director;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.healthcare.Supporter.builder.SensorDataBuilder;
import com.project.healthcare.Supporter.model.Patient;
import com.project.healthcare.Supporter.model.SensorData;

@Component
public class SensorDataDirector {
  private final SensorDataBuilder builder;

  @Autowired
  public SensorDataDirector(SensorDataBuilder builder) {
    this.builder = builder;
  }

  public SensorData constructSensorData(Double temperature, Double bloodPressure,
      Integer heartRate, Patient patient) {
    return builder
        .setTemperature(temperature)
        .setBloodPressure(bloodPressure)
        .setHeartRate(heartRate)
        .setTimestamp(LocalDateTime.now())
        .setPatient(patient)
        .build();
  }
}

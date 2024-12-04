package com.project.healthcare.Supporter.builder;

import java.time.LocalDateTime;

import com.project.healthcare.Supporter.model.Patient;
import com.project.healthcare.Supporter.model.SensorData;

public interface SensorDataBuilder {
  SensorDataBuilder setTemperature(Double temperature);

  SensorDataBuilder setBloodPressure(Double bloodPressure);

  SensorDataBuilder setHeartRate(Integer heartRate);

  SensorDataBuilder setTimestamp(LocalDateTime timestamp);

  SensorDataBuilder setPatient(Patient patient);

  SensorData build();
}

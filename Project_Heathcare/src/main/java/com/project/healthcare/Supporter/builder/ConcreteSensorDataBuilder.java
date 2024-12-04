package com.project.healthcare.Supporter.builder;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.project.healthcare.Supporter.model.Patient;
import com.project.healthcare.Supporter.model.SensorData;

@Component
public class ConcreteSensorDataBuilder implements SensorDataBuilder {
  private SensorData sensorData;

  public ConcreteSensorDataBuilder() {
    this.sensorData = new SensorData();
  }

  @Override
  public SensorDataBuilder setTemperature(Double temperature) {
    sensorData.setTemperature(temperature);
    return this;
  }

  @Override
  public SensorDataBuilder setBloodPressure(Double bloodPressure) {
    sensorData.setBloodPressure(bloodPressure);
    return this;
  }

  @Override
  public SensorDataBuilder setHeartRate(Integer heartRate) {
    sensorData.setHeartRate(heartRate);
    return this;
  }

  @Override
  public SensorDataBuilder setTimestamp(LocalDateTime timestamp) {
    sensorData.setTimestamp(timestamp);
    return this;
  }

  @Override
  public SensorDataBuilder setPatient(Patient patient) {
    sensorData.setPatient(patient);
    return this;
  }

  @Override
  public SensorData build() {
    SensorData built = this.sensorData;
    this.sensorData = new SensorData();
    return built;
  }
}

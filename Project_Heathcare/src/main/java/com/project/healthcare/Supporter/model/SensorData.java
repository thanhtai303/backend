package com.project.healthcare.Supporter.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sensor_data")
@Data
@NoArgsConstructor
public class SensorData {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Double temperature;
  private Double bloodPressure;
  private Integer heartRate;
  private LocalDateTime timestamp;

  @ManyToOne
  @JoinColumn(name = "patient_id")
  private Patient patient;
}

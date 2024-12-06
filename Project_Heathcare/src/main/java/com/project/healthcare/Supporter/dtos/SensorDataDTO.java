package com.project.healthcare.Supporter.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorDataDTO {
  private Long patientId;
  private Double temperature;
  private String bloodPressure;
  private Integer heartRate;
  private LocalDateTime timestamp;
}

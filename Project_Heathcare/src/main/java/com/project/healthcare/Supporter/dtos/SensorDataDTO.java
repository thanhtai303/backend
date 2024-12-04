package com.project.healthcare.Supporter.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorDataDTO {
  private Double temperature;
  private Double bloodPressure;
  private Integer heartRate;
}

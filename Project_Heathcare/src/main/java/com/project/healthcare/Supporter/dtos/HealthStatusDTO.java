package com.project.healthcare.Supporter.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthStatusDTO {
  private SensorDataDTO latestSensorData;
  private String status;
  private List<String> recommendations;
}
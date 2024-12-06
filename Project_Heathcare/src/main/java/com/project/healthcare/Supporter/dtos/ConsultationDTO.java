package com.project.healthcare.Supporter.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationDTO {
  private Long id;
  private Long patientId;
  private Long doctorId;
  private String status;
  private LocalDateTime createdAt;
}

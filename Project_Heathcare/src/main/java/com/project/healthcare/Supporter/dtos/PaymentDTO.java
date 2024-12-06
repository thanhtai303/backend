package com.project.healthcare.Supporter.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
  private Long id;
  private Long consultationId;
  private BigDecimal amount;
  private String status;
  private LocalDateTime createdAt;
}

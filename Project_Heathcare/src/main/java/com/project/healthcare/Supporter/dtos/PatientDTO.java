package com.project.healthcare.Supporter.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
  private String name;
  private String email;
  private String password;
  private LocalDate dob;
}

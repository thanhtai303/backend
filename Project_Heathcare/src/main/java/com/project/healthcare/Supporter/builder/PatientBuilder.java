package com.project.healthcare.Supporter.builder;

import java.time.LocalDate;

import com.project.healthcare.Supporter.model.Patient;

public interface PatientBuilder {
  PatientBuilder setName(String name);

  PatientBuilder setEmail(String email);

  PatientBuilder setPassword(String password);

  PatientBuilder setDob(LocalDate dob);

  Patient build();
}

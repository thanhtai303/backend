package com.project.healthcare.Supporter.builder;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.project.healthcare.Supporter.model.Patient;

@Component
public class ConcretePatientBuilder implements PatientBuilder {
  private Patient patient;

  public ConcretePatientBuilder() {
    this.patient = new Patient();
  }

  @Override
  public PatientBuilder setName(String name) {
    patient.setName(name);
    return this;
  }

  @Override
  public PatientBuilder setEmail(String email) {
    patient.setEmail(email);
    return this;
  }

  @Override
  public PatientBuilder setPassword(String password) {
    patient.setPassword(password);
    return this;
  }

  @Override
  public PatientBuilder setDob(LocalDate dob) {
    patient.setDob(dob);
    return this;
  }

  @Override
  public Patient build() {
    Patient builtPatient = this.patient;
    this.patient = new Patient();
    return builtPatient;
  }
}

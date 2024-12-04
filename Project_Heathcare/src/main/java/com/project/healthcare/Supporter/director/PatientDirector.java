package com.project.healthcare.Supporter.director;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.healthcare.Supporter.builder.PatientBuilder;
import com.project.healthcare.Supporter.model.Patient;

@Component
public class PatientDirector {
  private final PatientBuilder builder;

  @Autowired
  public PatientDirector(PatientBuilder builder) {
    this.builder = builder;
  }

  public Patient constructPatient(String name, String email, String password, LocalDate dob) {
    return builder
        .setName(name)
        .setEmail(email)
        .setPassword(password)
        .setDob(dob)
        .build();
  }
}

//

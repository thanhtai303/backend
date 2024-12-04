package com.project.healthcare.Supporter.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "doctors")
@Data
@EqualsAndHashCode(callSuper = true)
public class Doctor extends User {
  @OneToMany(mappedBy = "doctor")
  private List<Patient> patients;
  private String listOfPatients;
}

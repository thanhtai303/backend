package com.project.healthcare.Supporter.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "patients")
@Data
@EqualsAndHashCode(callSuper = true)
public class Patient extends User {
  private LocalDate dob;

  @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
  private List<SensorData> sensorData;

  @ManyToOne
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;
}
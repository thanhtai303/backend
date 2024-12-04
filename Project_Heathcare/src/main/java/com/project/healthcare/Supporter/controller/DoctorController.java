package com.project.healthcare.Supporter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.healthcare.Supporter.model.Patient;
import com.project.healthcare.Supporter.service.DoctorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/doctors")
@Tag(name = "Doctor Management", description = "APIs for doctor management")
public class DoctorController {
  private final DoctorService doctorService;

  @Autowired
  public DoctorController(DoctorService doctorService) {
    this.doctorService = doctorService;
  }

  @GetMapping("/{doctorId}/patients")
  @Operation(summary = "Get patients list", description = "Retrieves list of doctor's patients")
  public ResponseEntity<List<Patient>> getPatientsList(@PathVariable Long doctorId) {
    List<Patient> patients = doctorService.getPatientsList(doctorId);
    return ResponseEntity.ok(patients);
  }
}

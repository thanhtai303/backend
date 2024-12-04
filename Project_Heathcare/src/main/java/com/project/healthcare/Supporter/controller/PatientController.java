package com.project.healthcare.Supporter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.healthcare.Supporter.dtos.PatientDTO;
import com.project.healthcare.Supporter.dtos.SensorDataDTO;
import com.project.healthcare.Supporter.model.Patient;
import com.project.healthcare.Supporter.model.SensorData;
import com.project.healthcare.Supporter.service.PatientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/patients")
@Tag(name = "Patient Management", description = "APIs for patient management")
public class PatientController {
  private final PatientService patientService;

  @Autowired
  public PatientController(PatientService patientService) {
    this.patientService = patientService;
  }

  @PostMapping
  @Operation(summary = "Create new patient", description = "Creates a new patient account")
  public ResponseEntity<Patient> createPatient(@RequestBody PatientDTO patientDTO) {
    Patient patient = patientService.createPatient(patientDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(patient);
  }

  @PostMapping("/{patientId}/sensor-data")
  @Operation(summary = "Add sensor data", description = "Adds new sensor data for a patient")
  public ResponseEntity<SensorData> addSensorData(
      @PathVariable Long patientId,
      @RequestBody SensorDataDTO sensorDataDTO) {
    SensorData sensorData = patientService.addSensorData(patientId, sensorDataDTO);
    return ResponseEntity.ok(sensorData);
  }

  @GetMapping("/{patientId}/health-history")
  @Operation(summary = "Get health history", description = "Retrieves patient's health history")
  public ResponseEntity<List<SensorData>> getHealthHistory(@PathVariable Long patientId) {
    List<SensorData> history = patientService.getPatientHealthHistory(patientId);
    return ResponseEntity.ok(history);
  }
}

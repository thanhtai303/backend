package com.project.healthcare.Supporter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.healthcare.Supporter.dtos.ConsultationDTO;
import com.project.healthcare.Supporter.service.ConsultationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/consultations")
@Tag(name = "Consultation Management")
public class ConsultationController {
  private final ConsultationService consultationService;

  @Autowired
  public ConsultationController(ConsultationService consultationService) {
    this.consultationService = consultationService;
  }

  @PostMapping
  @Operation(summary = "Create New Consultation")
  public ResponseEntity<ConsultationDTO> createConsultation(
      @RequestParam Long patientId,
      @RequestParam Long doctorId) {
    return ResponseEntity.ok(consultationService.createConsultation(patientId, doctorId));
  }

  @GetMapping("/patient/{patientId}")
  @Operation(summary = "Get Patient's Consultations")
  public ResponseEntity<List<ConsultationDTO>> getPatientConsultations(
      @PathVariable Long patientId) {
    return ResponseEntity.ok(consultationService.getPatientConsultations(patientId));
  }
}

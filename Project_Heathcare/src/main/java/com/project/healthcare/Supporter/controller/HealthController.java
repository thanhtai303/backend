package com.project.healthcare.Supporter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.healthcare.Supporter.dtos.HealthStatusDTO;
import com.project.healthcare.Supporter.service.HealthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/health")
@Tag(name = "Health Monitoring")
public class HealthController {
  private final HealthService healthService;

  @Autowired
  public HealthController(HealthService healthService) {
    this.healthService = healthService;
  }

  @GetMapping("/status/{patientId}")
  @Operation(summary = "Get Patient Health Status")
  public ResponseEntity<HealthStatusDTO> getHealthStatus(
      @PathVariable Long patientId) {
    return ResponseEntity.ok(healthService.getHealthStatus(patientId));
  }
}

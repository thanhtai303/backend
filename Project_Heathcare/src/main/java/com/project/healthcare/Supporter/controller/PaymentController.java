package com.project.healthcare.Supporter.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.healthcare.Supporter.dtos.PaymentDTO;
import com.project.healthcare.Supporter.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/payments")
@Tag(name = "Payment Management")
public class PaymentController {
  private final PaymentService paymentService;

  @Autowired
  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @PostMapping
  @Operation(summary = "Create New Payment")
  public ResponseEntity<PaymentDTO> createPayment(
      @RequestParam Long consultationId,
      @RequestParam BigDecimal amount) {
    return ResponseEntity.ok(paymentService.createPayment(consultationId, amount));
  }
}

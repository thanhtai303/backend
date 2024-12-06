package com.project.healthcare.Supporter.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.healthcare.Supporter.dtos.PaymentDTO;
import com.project.healthcare.Supporter.exception_handler.ResourceNotFoundException;
import com.project.healthcare.Supporter.model.Consultation;
import com.project.healthcare.Supporter.model.Payment;
import com.project.healthcare.Supporter.repository.ConsultationRepository;
import com.project.healthcare.Supporter.repository.PaymentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {
  private final PaymentRepository paymentRepository;
  private final ConsultationRepository consultationRepository;

  @Autowired
  public PaymentService(
      PaymentRepository paymentRepository,
      ConsultationRepository consultationRepository) {
    this.paymentRepository = paymentRepository;
    this.consultationRepository = consultationRepository;
  }

  @Transactional
  public PaymentDTO createPayment(Long consultationId, BigDecimal amount) {
    Consultation consultation = consultationRepository.findById(consultationId)
        .orElseThrow(() -> new ResourceNotFoundException("Consultation not found"));

    Payment payment = new Payment();
    payment.setConsultation(consultation);
    payment.setAmount(amount);
    payment.setStatus("PENDING");
    payment.setCreatedAt(LocalDateTime.now());

    payment = paymentRepository.save(payment);
    return convertToDTO(payment);
  }

  private PaymentDTO convertToDTO(Payment payment) {
    return new PaymentDTO(
        payment.getId(),
        payment.getConsultation().getId(),
        payment.getAmount(),
        payment.getStatus(),
        payment.getCreatedAt());
  }
}

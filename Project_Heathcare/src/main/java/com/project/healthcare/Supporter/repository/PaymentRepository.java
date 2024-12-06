package com.project.healthcare.Supporter.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.healthcare.Supporter.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
  List<Payment> findByConsultationId(Long consultationId);

  List<Payment> findByStatus(String status);

  @Query("SELECT p FROM Payment p WHERE p.consultation.patient.id = :patientId")
  List<Payment> findByPatientId(@Param("patientId") Long patientId);

  @Query("SELECT SUM(p.amount) FROM Payment p WHERE p.status = 'COMPLETED' " +
      "AND p.createdAt BETWEEN :startDate AND :endDate")
  BigDecimal calculateTotalPayments(@Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate);
}
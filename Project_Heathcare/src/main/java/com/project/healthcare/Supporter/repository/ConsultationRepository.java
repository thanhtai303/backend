package com.project.healthcare.Supporter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.healthcare.Supporter.model.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
  List<Consultation> findByPatientIdOrderByCreatedAtDesc(Long patientId);

  List<Consultation> findByDoctorIdOrderByCreatedAtDesc(Long doctorId);

  List<Consultation> findByStatus(String status);

  @Query("SELECT c FROM Consultation c WHERE c.patient.id = :patientId AND c.status = :status")
  List<Consultation> findByPatientIdAndStatus(@Param("patientId") Long patientId,
      @Param("status") String status);
}

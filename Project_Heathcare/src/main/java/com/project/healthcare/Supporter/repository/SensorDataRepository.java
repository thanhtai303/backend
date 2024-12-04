package com.project.healthcare.Supporter.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.healthcare.Supporter.model.SensorData;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
  List<SensorData> findByPatientIdOrderByTimestampDesc(Long patientId);

  List<SensorData> findByPatientIdAndTimestampBetween(
      Long patientId, LocalDateTime start, LocalDateTime end);
}

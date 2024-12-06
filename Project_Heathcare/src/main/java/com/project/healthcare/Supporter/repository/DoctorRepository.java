package com.project.healthcare.Supporter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.healthcare.Supporter.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
  Optional<Doctor> findByUserId(Long userId);

  List<Doctor> findAllByOrderByCreatedAtDesc();
}

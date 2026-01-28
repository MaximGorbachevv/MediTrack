package com.poject2.meditrack.repository;

import com.poject2.meditrack.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {
}

package com.poject2.meditrack.repository;

import com.poject2.meditrack.dto.DoctorSummary;
import com.poject2.meditrack.model.Appointment;
import com.poject2.meditrack.model.Doctor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, String> {
    @EntityGraph(attributePaths = "appointments")
    List<Doctor>findAll();

    @Query("SELECT new com.poject2.meditrack.dto.DoctorSummary(d.id,d.fullname, COUNT(a))"+"FROM Doctor d LEFT JOIN d.appointments a GROUP BY d.id, d.fullname")
    List<DoctorSummary>findDoctorSummaries();
}

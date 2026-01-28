package com.poject2.meditrack.repository;

import com.poject2.meditrack.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, String> {
}

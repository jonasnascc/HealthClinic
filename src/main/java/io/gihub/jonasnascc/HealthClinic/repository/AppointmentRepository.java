package io.gihub.jonasnascc.HealthClinic.repository;

import io.gihub.jonasnascc.HealthClinic.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

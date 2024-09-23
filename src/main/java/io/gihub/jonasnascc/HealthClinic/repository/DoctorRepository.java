package io.gihub.jonasnascc.HealthClinic.repository;

import io.gihub.jonasnascc.HealthClinic.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, String> {
    Optional<Doctor> findByCrm(String crm);
}
